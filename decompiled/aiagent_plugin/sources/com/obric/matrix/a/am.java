package com.obric.matrix.a;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SubscribeWsMsgByBroadCastRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class am extends Message<am, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<am> f33349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f33350b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Integer f33351c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer f33352d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_SERVICE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f33353e;

    @SerializedName("method")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer f;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String g;

    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer h;

    /* JADX INFO: compiled from: SubscribeWsMsgByBroadCastRequest.java */
    public static final class a extends Message.Builder<am, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f33354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f33355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f33356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f33357d;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33354a = 0;
            this.f33355b = 0;
            this.f33356c = "";
            this.f33357d = 0;
        }

        public a a(Integer r1) {
            this.f33354a = r1;
            return this;
        }

        public a b(Integer r1) {
            this.f33355b = r1;
            return this;
        }

        public a a(String r1) {
            this.f33356c = r1;
            return this;
        }

        public a c(Integer r1) {
            this.f33357d = r1;
            return this;
        }

        public am a() {
            return new am(this.f33354a, this.f33355b, this.f33356c, this.f33357d, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SubscribeWsMsgByBroadCastRequest.java */
    private static final class b extends ProtoAdapter<am> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ am decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, am r4) {
            a(r3, (am) ZeusTransformUtils.preCheckCast(r4, am.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(am r3) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ am redact(am r3) {
            return b((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, am.class);
        }

        public int a(am r4) {
            return (((ProtoAdapter.INT32.encodedSizeWithTag(1, r4.f33353e) + ProtoAdapter.INT32.encodedSizeWithTag(2, r4.f)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.g)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r4.h)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, am r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.f33353e);
            ProtoAdapter.INT32.encodeWithTag(r3, 2, r4.f);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.g);
            ProtoAdapter.INT32.encodeWithTag(r3, 4, r4.h);
            r3.writeBytes(r4.unknownFields());
        }

        public am a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.c((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.a();
        }

        public am b(am r1) {
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
        f33349a = new b();
        f33350b = 0;
        f33351c = 0;
        f33352d = 0;
    }

    public am(Integer r2, Integer r3, String r4, Integer r5, e.h r6) {
        super(f33349a, r6);
        this.f33353e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
    }

    public a a() {
        a r0 = new a();
        r0.f33354a = this.f33353e;
        r0.f33355b = this.f;
        r0.f33356c = this.g;
        r0.f33357d = this.h;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, am.class) == true) goto L8;
        return false;
    L8:
        am r6 = (am) ZeusTransformUtils.preCheckCast(r5, am.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f33353e, r6.f33353e) == false) goto L20;
        if (Internal.equals(this.f, r6.f) == false) goto L20;
        if (Internal.equals(this.g, r6.g) == false) goto L20;
        if (Internal.equals(this.h, r6.h) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f33353e;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.g;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.h;
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
        if (this.f33353e == null) goto L6;
        r0.append(", service=").append(this.f33353e);
    L6:
        if (this.f == null) goto L9;
        r0.append(", method=").append(this.f);
    L9:
        if (this.g == null) goto L12;
        r0.append(", packageName=").append(this.g);
    L12:
        if (this.h == null) goto L15;
        r0.append(", opt=").append(this.h);
    L15:
        return r0.replace(0, 2, "SubscribeWsMsgByBroadCastRequest{").append('}').toString();
    }
}
