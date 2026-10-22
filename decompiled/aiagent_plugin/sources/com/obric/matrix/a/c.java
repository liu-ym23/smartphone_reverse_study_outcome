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

/* JADX INFO: compiled from: Circle.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends Message<c, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<c> f33440a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Double f33441b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("center")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", tag = 1)
    public final x f33442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("radius")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double f33443d;

    /* JADX INFO: compiled from: Circle.java */
    public static final class a extends Message.Builder<c, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x f33444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f33445b;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33445b = Double.valueOf(0.0d);
        }

        public a a(x r1) {
            this.f33444a = r1;
            return this;
        }

        public a a(Double r1) {
            this.f33445b = r1;
            return this;
        }

        public c a() {
            return new c(this.f33444a, this.f33445b, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: Circle.java */
    private static final class b extends ProtoAdapter<c> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ c decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, c r4) {
            a(r3, (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(c r3) {
            return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ c redact(c r3) {
            return b((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, c.class);
        }

        public int a(c r4) {
            return (x.f33584a.encodedSizeWithTag(1, r4.f33442c) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.f33443d)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, c r4) {
            x.f33584a.encodeWithTag(r3, 1, r4.f33442c);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.f33443d);
            r3.writeBytes(r4.unknownFields());
        }

        public c a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((x) ZeusTransformUtils.preCheckCast(x.f33584a.decode(r6), x.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.a((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public c b(c r3) {
            a r2 = r3.a();
            if (r2.f33444a == null) goto L5;
            r2.f33444a = (x) ZeusTransformUtils.preCheckCast(x.f33584a.redact(r2.f33444a), x.class, "com.obric.aiagent.plugin");
        L5:
            r2.clearUnknownFields();
            return r2.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33440a = new b();
        f33441b = Double.valueOf(0.0d);
    }

    public c(x r2, Double r3, e.h r4) {
        super(f33440a, r4);
        this.f33442c = r2;
        this.f33443d = r3;
    }

    public a a() {
        a r0 = new a();
        r0.f33444a = this.f33442c;
        r0.f33445b = this.f33443d;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f33442c, r6.f33442c) == false) goto L16;
        if (Internal.equals(this.f33443d, r6.f33443d) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        x r2 = this.f33442c;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.f33443d;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        this.hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33442c == null) goto L6;
        r0.append(", center=").append(this.f33442c);
    L6:
        if (this.f33443d == null) goto L9;
        r0.append(", radius=").append(this.f33443d);
    L9:
        return r0.replace(0, 2, "Circle{").append('}').toString();
    }
}
