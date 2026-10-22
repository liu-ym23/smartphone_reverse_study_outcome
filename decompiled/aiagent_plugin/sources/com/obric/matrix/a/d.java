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

/* JADX INFO: compiled from: DecodeLocationRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends Message<d, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<d> f33446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Double f33447b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Double f33448c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f33449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double f33450e;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 3)
    public final Double f;

    /* JADX INFO: compiled from: DecodeLocationRequest.java */
    public static final class a extends Message.Builder<d, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f33452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Double f33453c;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33451a = "";
            Double r0 = Double.valueOf(0.0d);
            this.f33452b = r0;
            this.f33453c = r0;
        }

        public a a(String r1) {
            this.f33451a = r1;
            return this;
        }

        public a a(Double r1) {
            this.f33452b = r1;
            return this;
        }

        public a b(Double r1) {
            this.f33453c = r1;
            return this;
        }

        public d a() {
            return new d(this.f33451a, this.f33452b, this.f33453c, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: DecodeLocationRequest.java */
    private static final class b extends ProtoAdapter<d> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ d decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, d r4) {
            a(r3, (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(d r3) {
            return a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ d redact(d r3) {
            return b((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, d.class);
        }

        public int a(d r4) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r4.f33449d) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.f33450e)) + ProtoAdapter.DOUBLE.encodedSizeWithTag(3, r4.f)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, d r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.f33449d);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.f33450e);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 3, r4.f);
            r3.writeBytes(r4.unknownFields());
        }

        public d a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.a((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r5.b((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L15:
            r6.endMessage(r0);
            return r5.a();
        }

        public d b(d r1) {
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
        f33446a = new b();
        Double r0 = Double.valueOf(0.0d);
        f33447b = r0;
        f33448c = r0;
    }

    public d(String r2, Double r3, Double r4, e.h r5) {
        super(f33446a, r5);
        this.f33449d = r2;
        this.f33450e = r3;
        this.f = r4;
    }

    public a a() {
        a r0 = new a();
        r0.f33451a = this.f33449d;
        r0.f33452b = this.f33450e;
        r0.f33453c = this.f;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (Internal.equals(this.f33449d, r6.f33449d) == false) goto L18;
        if (Internal.equals(this.f33450e, r6.f33450e) == false) goto L18;
        if (Internal.equals(this.f, r6.f) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f33449d;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.f33450e;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Double r9 = this.f;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33449d == null) goto L6;
        r0.append(", packageName=").append(this.f33449d);
    L6:
        if (this.f33450e == null) goto L9;
        r0.append(", longitude=").append(this.f33450e);
    L9:
        if (this.f == null) goto L12;
        r0.append(", latitude=").append(this.f);
    L12:
        return r0.replace(0, 2, "DecodeLocationRequest{").append('}').toString();
    }
}
