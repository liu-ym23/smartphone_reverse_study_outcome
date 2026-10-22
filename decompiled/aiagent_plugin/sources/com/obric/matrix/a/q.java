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

/* JADX INFO: compiled from: MonitorInfo.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q extends Message<q, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<q> f33531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Long f33532b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Long f33533c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Long f33534d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Long f33535e = null;
    public static final Long f = null;

    @SerializedName("thirdStartTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long g;

    @SerializedName("thirdJavaJniCallTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long h;

    @SerializedName("matrixBindRevTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long i;

    @SerializedName("matrixBindProcessEndTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long j;

    @SerializedName("thirdJavaRevResResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long k;

    /* JADX INFO: compiled from: MonitorInfo.java */
    public static final class a extends Message.Builder<q, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f33536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f33537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f33538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f33539d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f33540e;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33536a = 0L;
            this.f33537b = 0L;
            this.f33538c = 0L;
            this.f33539d = 0L;
            this.f33540e = 0L;
        }

        public a a(Long r1) {
            this.f33536a = r1;
            return this;
        }

        public a b(Long r1) {
            this.f33537b = r1;
            return this;
        }

        public a c(Long r1) {
            this.f33538c = r1;
            return this;
        }

        public a d(Long r1) {
            this.f33539d = r1;
            return this;
        }

        public a e(Long r1) {
            this.f33540e = r1;
            return this;
        }

        public q a() {
            return new q(this.f33536a, this.f33537b, this.f33538c, this.f33539d, this.f33540e, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: MonitorInfo.java */
    private static final class b extends ProtoAdapter<q> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ q decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, q r4) {
            a(r3, (q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(q r3) {
            return a((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ q redact(q r3) {
            return b((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, q.class);
        }

        public int a(q r4) {
            return ((((ProtoAdapter.INT64.encodedSizeWithTag(1, r4.g) + ProtoAdapter.INT64.encodedSizeWithTag(2, r4.h)) + ProtoAdapter.INT64.encodedSizeWithTag(3, r4.i)) + ProtoAdapter.INT64.encodedSizeWithTag(4, r4.j)) + ProtoAdapter.INT64.encodedSizeWithTag(5, r4.k)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, q r4) {
            ProtoAdapter.INT64.encodeWithTag(r3, 1, r4.g);
            ProtoAdapter.INT64.encodeWithTag(r3, 2, r4.h);
            ProtoAdapter.INT64.encodeWithTag(r3, 3, r4.i);
            ProtoAdapter.INT64.encodeWithTag(r3, 4, r4.j);
            ProtoAdapter.INT64.encodeWithTag(r3, 5, r4.k);
            r3.writeBytes(r4.unknownFields());
        }

        public q a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L21;
            if (r2 != 1) goto L8;
            r5.a((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT64.decode(r6), Long.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.b((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT64.decode(r6), Long.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.c((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT64.decode(r6), Long.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            if (r2 != 4) goto L14;
            r5.d((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT64.decode(r6), Long.class, "com.obric.aiagent.plugin"));
            goto L3
        L14:
            if (r2 != 5) goto L15;
            r5.e((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT64.decode(r6), Long.class, "com.obric.aiagent.plugin"));
            goto L3
        L15:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L21:
            r6.endMessage(r0);
            return r5.a();
        }

        public q b(q r1) {
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
        f33531a = new b();
        f33532b = 0L;
        f33533c = 0L;
        f33534d = 0L;
        f33535e = 0L;
        f = 0L;
    }

    public q(Long r2, Long r3, Long r4, Long r5, Long r6, e.h r7) {
        super(f33531a, r7);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
    }

    public a a() {
        a r0 = new a();
        r0.f33536a = this.g;
        r0.f33537b = this.h;
        r0.f33538c = this.i;
        r0.f33539d = this.j;
        r0.f33540e = this.k;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L8;
        return false;
    L8:
        q r6 = (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L22;
        if (Internal.equals(this.g, r6.g) == false) goto L22;
        if (Internal.equals(this.h, r6.h) == false) goto L22;
        if (Internal.equals(this.i, r6.i) == false) goto L22;
        if (Internal.equals(this.j, r6.j) == false) goto L22;
        if (Internal.equals(this.k, r6.k) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.g;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.h;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.i;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.j;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Long r15 = this.k;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = r14 + r3;
        this.hashCode = r16;
        return r16;
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L25:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.g == null) goto L6;
        r0.append(", thirdStartTime=").append(this.g);
    L6:
        if (this.h == null) goto L9;
        r0.append(", thirdJavaJniCallTime=").append(this.h);
    L9:
        if (this.i == null) goto L12;
        r0.append(", matrixBindRevTime=").append(this.i);
    L12:
        if (this.j == null) goto L15;
        r0.append(", matrixBindProcessEndTime=").append(this.j);
    L15:
        if (this.k == null) goto L18;
        r0.append(", thirdJavaRevResResult=").append(this.k);
    L18:
        return r0.replace(0, 2, "MonitorInfo{").append('}').toString();
    }
}
