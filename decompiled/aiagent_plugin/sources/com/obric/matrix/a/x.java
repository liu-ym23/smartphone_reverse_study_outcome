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

/* JADX INFO: compiled from: Point.java */
/* JADX INFO: loaded from: classes4.dex */
public final class x extends Message<x, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<x> f33584a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Double f33585b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Double f33586c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double f33587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double f33588e;

    /* JADX INFO: compiled from: Point.java */
    public static final class a extends Message.Builder<x, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f33589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f33590b;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            Double r0 = Double.valueOf(0.0d);
            this.f33589a = r0;
            this.f33590b = r0;
        }

        public a a(Double r1) {
            this.f33589a = r1;
            return this;
        }

        public a b(Double r1) {
            this.f33590b = r1;
            return this;
        }

        public x a() {
            return new x(this.f33589a, this.f33590b, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: Point.java */
    private static final class b extends ProtoAdapter<x> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ x decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, x r4) {
            a(r3, (x) ZeusTransformUtils.preCheckCast(r4, x.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(x r3) {
            return a((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ x redact(x r3) {
            return b((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, x.class);
        }

        public int a(x r4) {
            return (ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r4.f33587d) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.f33588e)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, x r4) {
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 1, r4.f33587d);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.f33588e);
            r3.writeBytes(r4.unknownFields());
        }

        public x a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.b((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public x b(x r1) {
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
        f33584a = new b();
        Double r0 = Double.valueOf(0.0d);
        f33585b = r0;
        f33586c = r0;
    }

    public x(Double r2, Double r3, e.h r4) {
        super(f33584a, r4);
        this.f33587d = r2;
        this.f33588e = r3;
    }

    public a a() {
        a r0 = new a();
        r0.f33589a = this.f33587d;
        r0.f33590b = this.f33588e;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, x.class) == true) goto L8;
        return false;
    L8:
        x r6 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f33587d, r6.f33587d) == false) goto L16;
        if (Internal.equals(this.f33588e, r6.f33588e) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Double r2 = this.f33587d;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.f33588e;
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
        if (this.f33587d == null) goto L6;
        r0.append(", longitude=").append(this.f33587d);
    L6:
        if (this.f33588e == null) goto L9;
        r0.append(", latitude=").append(this.f33588e);
    L9:
        return r0.replace(0, 2, "Point{").append('}').toString();
    }
}
