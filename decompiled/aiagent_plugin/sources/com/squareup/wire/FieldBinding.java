package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final String adapterString;
    private final Field builderField;
    private final Method builderMethod;
    private ProtoAdapter<?> keyAdapter;
    private final String keyAdapterString;
    public final WireField.Label label;
    private final Field messageField;
    public final String name;
    public final boolean redacted;
    private ProtoAdapter<?> singleAdapter;
    public final int tag;

    private static Field getBuilderField(Class<?> r3, String r4) {
        return r3.getField(r4);
    L5:
        throw new AssertionError("No builder field " + r3.getName() + "." + r4);
    }

    private static Method getBuilderMethod(Class<?> r3, String r4, Class<?> r5) {
        return r3.getMethod(r4, new Class[]{r5});
    L6:
        throw new AssertionError("No builder method " + r3.getName() + "." + r4 + "(" + r5.getName() + ")");
    }

    FieldBinding(WireField r3, Field r4, Class<B> r5) {
        WireField r6 = (WireField) ZeusTransformUtils.wrapperContextForParams(r3, WireField.class, "com.obric.aiagent.plugin");
        this.label = r6.label();
        String r0 = r4.getName();
        this.name = r0;
        this.tag = r6.tag();
        this.keyAdapterString = r6.keyAdapter();
        this.adapterString = r6.adapter();
        this.redacted = r6.redacted();
        this.messageField = r4;
        this.builderField = getBuilderField(r5, r0);
        this.builderMethod = getBuilderMethod(r5, r0, r4.getType());
    }

    boolean isMap() {
        return !this.keyAdapterString.isEmpty();
    }

    ProtoAdapter<?> singleAdapter() {
        ProtoAdapter<?> r0 = this.singleAdapter;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ProtoAdapter<?> r1 = ProtoAdapter.get(this.adapterString);
        this.singleAdapter = r1;
        return r1;
    }

    ProtoAdapter<?> keyAdapter() {
        ProtoAdapter<?> r0 = this.keyAdapter;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ProtoAdapter<?> r1 = ProtoAdapter.get(this.keyAdapterString);
        this.keyAdapter = r1;
        return r1;
    }

    ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> r0 = this.adapter;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (isMap() == false) goto L9;
        ProtoAdapter<Object> r1 = ProtoAdapter.newMapAdapter(keyAdapter(), singleAdapter());
        this.adapter = r1;
        return r1;
    L9:
        ProtoAdapter<?> r2 = singleAdapter().withLabel(this.label);
        this.adapter = r2;
        return r2;
    }

    void value(B r3, Object r4) {
        if (this.label.isRepeated() == false) goto L6;
        ((List) ZeusTransformUtils.preCheckCast(getFromBuilder(r3), List.class, "com.obric.aiagent.plugin")).add(r4);
        return;
    L6:
        if (this.keyAdapterString.isEmpty() == true) goto L8;
        ((Map) ZeusTransformUtils.preCheckCast(getFromBuilder(r3), Map.class, "com.obric.aiagent.plugin")).putAll((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        set(r3, r4);
    }

    void set(B r3, Object r4) {
    L7:
        e = move-exception;
        throw new AssertionError(e);
    L3:
        if (this.label.isOneOf() == false) goto L5;
        this.builderMethod.invoke(r3, new Object[]{r4});     // Catch: Throwable -> L7
        return;
    L5:
        this.builderField.set(r3, r4);     // Catch: Throwable -> L7
    }

    Object get(M r1) {
        return this.messageField.get(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    Object getFromBuilder(B r1) {
        return this.builderField.get(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}
