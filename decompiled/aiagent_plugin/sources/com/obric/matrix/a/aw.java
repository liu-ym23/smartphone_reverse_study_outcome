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

/* JADX INFO: compiled from: TargetDataset.java */
/* JADX INFO: loaded from: classes4.dex */
public final class aw extends Message<aw, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<aw> f33417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("name")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f33418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f33419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("appkey")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f33420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("properties")
    @WireField(adapter = "com.obric.matrix.proto.NullableMap#ADAPTER", tag = 4)
    public final t f33421e;

    /* JADX INFO: compiled from: TargetDataset.java */
    public static final class a extends Message.Builder<aw, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f33424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public t f33425d;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33422a = "";
            this.f33423b = "";
            this.f33424c = "";
        }

        public a a(String r1) {
            this.f33422a = r1;
            return this;
        }

        public a b(String r1) {
            this.f33423b = r1;
            return this;
        }

        public a c(String r1) {
            this.f33424c = r1;
            return this;
        }

        public a a(t r1) {
            this.f33425d = r1;
            return this;
        }

        public aw a() {
            return new aw(this.f33422a, this.f33423b, this.f33424c, this.f33425d, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: TargetDataset.java */
    private static final class b extends ProtoAdapter<aw> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ aw decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, aw r4) {
            a(r3, (aw) ZeusTransformUtils.preCheckCast(r4, aw.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(aw r3) {
            return a((aw) ZeusTransformUtils.preCheckCast(r3, aw.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ aw redact(aw r3) {
            return b((aw) ZeusTransformUtils.preCheckCast(r3, aw.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, aw.class);
        }

        public int a(aw r4) {
            return (((ProtoAdapter.STRING.encodedSizeWithTag(1, r4.f33418b) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.f33419c)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.f33420d)) + t.f33549a.encodedSizeWithTag(4, r4.f33421e)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, aw r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.f33418b);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.f33419c);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.f33420d);
            t.f33549a.encodeWithTag(r3, 4, r4.f33421e);
            r3.writeBytes(r4.unknownFields());
        }

        public aw a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.c((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.a((t) ZeusTransformUtils.preCheckCast(t.f33549a.decode(r6), t.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.a();
        }

        public aw b(aw r3) {
            a r2 = r3.a();
            if (r2.f33425d == null) goto L5;
            r2.f33425d = (t) ZeusTransformUtils.preCheckCast(t.f33549a.redact(r2.f33425d), t.class, "com.obric.aiagent.plugin");
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
        f33417a = new b();
    }

    public aw(String r2, String r3, String r4, t r5, e.h r6) {
        super(f33417a, r6);
        this.f33418b = r2;
        this.f33419c = r3;
        this.f33420d = r4;
        this.f33421e = r5;
    }

    public a a() {
        a r0 = new a();
        r0.f33422a = this.f33418b;
        r0.f33423b = this.f33419c;
        r0.f33424c = this.f33420d;
        r0.f33425d = this.f33421e;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aw.class) == true) goto L8;
        return false;
    L8:
        aw r6 = (aw) ZeusTransformUtils.preCheckCast(r5, aw.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f33418b, r6.f33418b) == false) goto L20;
        if (Internal.equals(this.f33419c, r6.f33419c) == false) goto L20;
        if (Internal.equals(this.f33420d, r6.f33420d) == false) goto L20;
        if (Internal.equals(this.f33421e, r6.f33421e) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f33418b;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f33419c;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f33420d;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        t r12 = this.f33421e;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33418b == null) goto L6;
        r0.append(", name=").append(this.f33418b);
    L6:
        if (this.f33419c == null) goto L9;
        r0.append(", appid=").append(this.f33419c);
    L9:
        if (this.f33420d == null) goto L12;
        r0.append(", appkey=").append(this.f33420d);
    L12:
        if (this.f33421e == null) goto L15;
        r0.append(", properties=").append(this.f33421e);
    L15:
        return r0.replace(0, 2, "TargetDataset{").append('}').toString();
    }
}
