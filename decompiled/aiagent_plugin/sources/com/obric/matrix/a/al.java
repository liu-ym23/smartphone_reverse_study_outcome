package com.obric.matrix.a;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: StringArray.java */
/* JADX INFO: loaded from: classes4.dex */
public final class al extends Message<al, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<al> f33346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> f33347b;

    /* JADX INFO: compiled from: StringArray.java */
    public static final class a extends Message.Builder<al, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f33348a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33348a = Internal.newMutableList();
        }

        public al a() {
            return new al(this.f33348a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: StringArray.java */
    private static final class b extends ProtoAdapter<al> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ al decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, al r4) {
            a(r3, (al) ZeusTransformUtils.preCheckCast(r4, al.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(al r3) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ al redact(al r3) {
            return b((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, al.class);
        }

        public int a(al r3) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r3.f33347b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, al r4) {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r3, 1, r4.f33347b);
            r3.writeBytes(r4.unknownFields());
        }

        public al a(ProtoReader r7) {
            a r6 = new a();
            long r0 = r7.beginMessage();
        L3:
            int r2 = r7.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r6.f33348a.add((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r7), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r7.peekFieldEncoding();
            r6.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r0);
            return r6.a();
        }

        public al b(al r1) {
            a r0 = r1.a();
            r0.clearUnknownFields();
            return r0.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33346a = new b();
    }

    public al(List<String> r3, e.h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        super(f33346a, r4);
        this.f33347b = Internal.immutableCopyOf("_value", r5);
    }

    public a a() {
        a r0 = new a();
        r0.f33348a = Internal.copyOf("_value", this.f33347b);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, al.class) == true) goto L8;
        return false;
    L8:
        al r6 = (al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f33347b.equals(r6.f33347b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f33347b.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<String> r1 = this.f33347b;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", _value=").append(this.f33347b);
    L8:
        return r0.replace(0, 2, "StringArray{").append('}').toString();
    }
}
