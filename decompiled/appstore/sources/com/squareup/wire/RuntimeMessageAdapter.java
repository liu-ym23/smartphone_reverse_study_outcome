package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {
    private static final String REDACTED = "██";
    private final Class<B> builderType;
    private final Map<Integer, FieldBinding<M, B>> fieldBindings;
    private final Class<M> messageType;

    public RuntimeMessageAdapter(Class<M> r10, Class<B> r11, Map<Integer, FieldBinding<M, B>> r12) {
        super(FieldEncoding.LENGTH_DELIMITED, r10);
        this.messageType = r10;
        this.builderType = r11;
        this.fieldBindings = r12;
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> r10) {
        Class r11 = getBuilderType(r10);
        LinkedHashMap r12 = new LinkedHashMap();
        Field[] r13 = r10.getDeclaredFields();
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L9;
        Field r16 = r13[r15];
        WireField r17 = (WireField) r16.getAnnotation(WireField.class);
        if (r17 == null) goto L7;
        r12.put(Integer.valueOf(r17.tag()), new FieldBinding(r17, r16, r11));
    L7:
        r15 = r15 + 1;
        goto L3
    L9:
        return new RuntimeMessageAdapter(r10, r11, Collections.unmodifiableMap(r12));
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> r10) {
        return (Class<B>) Class.forName(r10.getName() + "$Builder");
    L5:
        throw new IllegalArgumentException("No builder class found for message type " + r10.getName());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) throws IOException {
        return decode(r10);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) throws IOException {
        encode(r10, (Message) r11);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
        return encodedSize((Message) r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof RuntimeMessageAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeMessageAdapter) r10).messageType != this.messageType) goto L7;
        return true;
    }

    public Map<Integer, FieldBinding<M, B>> fieldBindings() {
        return this.fieldBindings;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    public B newBuilder() {
        return this.builderType.newInstance();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object r10) {
        return redact((Message) r10);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ String toString(Object r10) {
        return toString((Message) r10);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M decode(ProtoReader r10) throws IOException {
        Message.Builder r11 = newBuilder();
        long r12 = r10.beginMessage();
    L3:
        int r13 = r10.nextTag();
        if (r13 == (-1)) goto L17;
        FieldBinding<M, B> r14 = this.fieldBindings.get(Integer.valueOf(r13));
        if (r14 == null) goto L14;
        if (r14.isMap() == false) goto L12;
        ProtoAdapter<?> r15 = r14.adapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
    L13:
        r14.value(r11, r15.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        goto L3
    L12:
        r15 = r14.singleAdapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
    L10:
        e = move-exception;
        r11.addUnknownField(r13, FieldEncoding.VARINT, Long.valueOf(e.value));
        goto L3
    L14:
        FieldEncoding r16 = r10.peekFieldEncoding();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        r11.addUnknownField(r13, r16, r16.rawProtoAdapter().decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        goto L3
    L17:
        r10.endMessage(r12);
        return (M) r11.build();
    }

    public void encode(ProtoWriter r10, M r11) throws IOException {
        Iterator<FieldBinding<M, B>> r12 = this.fieldBindings.values().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        FieldBinding<M, B> r13 = r12.next();
        Object r14 = r13.get(r11);
        if (r14 == null) goto L4;
        r13.adapter().encodeWithTag(r10, r13.tag, r14);
        goto L4
    L9:
        r10.writeBytes(r11.unknownFields());
    }

    public int encodedSize(M r10) {
        int r11 = r10.cachedSerializedSize;
        if (r11 == 0) goto L5;
        return r11;
    L5:
        Iterator<FieldBinding<M, B>> r12 = this.fieldBindings.values().iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L12;
        FieldBinding<M, B> r14 = r12.next();
        Object r15 = r14.get(r10);
        if (r15 == null) goto L7;
        r13 = r13 + r14.adapter().encodedSizeWithTag(r14.tag, r15);
        goto L7
    L12:
        int r16 = r13 + r10.unknownFields().size();
        r10.cachedSerializedSize = r16;
        return r16;
    }

    public M redact(M r10) {
        Message.Builder<M, B> r11 = r10.newBuilder();
        Iterator<FieldBinding<M, B>> r12 = this.fieldBindings.values().iterator();
    L4:
        if (r12.hasNext() == false) goto L25;
        FieldBinding<M, B> r13 = r12.next();
        if (r13.redacted == true) goto L8;
    L12:
        boolean r14 = Message.class.isAssignableFrom(r13.singleAdapter().javaType);
        if (r13.redacted == true) goto L22;
        if (r14 == false) goto L18;
        if (r13.label.isRepeated() == false) goto L22;
    L18:
        if (r14 == false) goto L4;
        if (r13.label.isRepeated() == false) goto L4;
        Internal.redactElements((List) r13.getFromBuilder(r11), r13.singleAdapter());
    L22:
        Object r15 = r13.getFromBuilder(r11);
        if (r15 == null) goto L4;
        r13.set(r11, r13.adapter().redact(r15));
        goto L4
    L8:
        if (r13.label != WireField.Label.REQUIRED) goto L12;
        throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", new Object[]{r13.name, this.javaType.getName()}));
    L25:
        r11.clearUnknownFields();
        return (M) r11.build();
    }

    public String toString(M r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator<FieldBinding<M, B>> r12 = this.fieldBindings.values().iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        FieldBinding<M, B> r13 = r12.next();
        Object r14 = r13.get(r10);
        if (r14 == null) goto L4;
        r11.append(", ");
        r11.append(r13.name);
        r11.append('=');
        if (r13.redacted == false) goto L10;
        r14 = REDACTED;
    L10:
        r11.append(r14);
        goto L4
    L11:
        r11.replace(0, 2, this.messageType.getSimpleName() + '{');
        r11.append('}');
        return r11.toString();
    }
}
