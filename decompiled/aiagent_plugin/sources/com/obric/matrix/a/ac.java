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

/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ac extends Message<ac, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ac> f33276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("bizExampleRequest")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleRequest#ADAPTER", tag = 100000)
    public final com.obric.matrix.a.a f33277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("sendWsMessageRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageRequest#ADAPTER", tag = 101001)
    public final ah f33278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("subscribeWsMsgRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgRequest#ADAPTER", tag = 101002)
    public final as f33279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("subscribeWsStatusRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusRequest#ADAPTER", tag = 101003)
    public final au f33280e;

    @SerializedName("subscribeWsMsgByProviderRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderRequest#ADAPTER", tag = 101004)
    public final aq f;

    @SerializedName("subscribeWsMsgByCallBackRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackRequest#ADAPTER", tag = 101005)
    public final ao g;

    @SerializedName("subscribeWsMsgByBroadCastRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastRequest#ADAPTER", tag = 101006)
    public final am h;

    @SerializedName("getLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationRequest#ADAPTER", tag = 102001)
    public final k i;

    @SerializedName("refreshLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationRequest#ADAPTER", tag = 102002)
    public final z j;

    @SerializedName("decodeLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationRequest#ADAPTER", tag = 102003)
    public final d k;

    @SerializedName("getIntersectFencesRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesRequest#ADAPTER", tag = 102004)
    public final i l;

    @SerializedName("startPicoLinksRequest")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest#ADAPTER", tag = 111001)
    public final aj m;

    @SerializedName("picoLinksCallback")
    @WireField(adapter = "com.obric.matrix.proto.PicoLinksCallback#ADAPTER", tag = 111002)
    public final w n;

    @SerializedName("onePartyCommonNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkRequest#ADAPTER", tag = 112001)
    public final u o;

    @SerializedName("sendApplogEventRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventRequest#ADAPTER", tag = 112002)
    public final af p;

    @SerializedName("genericNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkRequest#ADAPTER", tag = 112003)
    public final g q;

    @SerializedName("getTTNetParametersRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersRequest#ADAPTER", tag = 112004)
    public final m r;

    /* JADX INFO: compiled from: RequestBody.java */
    public static final class a extends Message.Builder<ac, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.obric.matrix.a.a f33281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ah f33282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public as f33283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public au f33284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public aq f33285e;
        public ao f;
        public am g;
        public k h;
        public z i;
        public d j;
        public i k;
        public aj l;
        public w m;
        public u n;
        public af o;
        public g p;
        public m q;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
        }

        public a a(com.obric.matrix.a.a r1) {
            this.f33281a = r1;
            return this;
        }

        public a a(ah r1) {
            this.f33282b = r1;
            return this;
        }

        public a a(as r1) {
            this.f33283c = r1;
            return this;
        }

        public a a(au r1) {
            this.f33284d = r1;
            return this;
        }

        public a a(aq r1) {
            this.f33285e = r1;
            return this;
        }

        public a a(ao r1) {
            this.f = r1;
            return this;
        }

        public a a(am r1) {
            this.g = r1;
            return this;
        }

        public a a(k r1) {
            this.h = r1;
            return this;
        }

        public a a(z r1) {
            this.i = r1;
            return this;
        }

        public a a(d r1) {
            this.j = r1;
            return this;
        }

        public a a(i r1) {
            this.k = r1;
            return this;
        }

        public a a(aj r1) {
            this.l = r1;
            return this;
        }

        public a a(w r1) {
            this.m = r1;
            return this;
        }

        public a a(u r1) {
            this.n = r1;
            return this;
        }

        public a a(af r1) {
            this.o = r1;
            return this;
        }

        public a a(g r1) {
            this.p = r1;
            return this;
        }

        public a a(m r1) {
            this.q = r1;
            return this;
        }

        public ac a() {
            return new ac(this.f33281a, this.f33282b, this.f33283c, this.f33284d, this.f33285e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: RequestBody.java */
    private static final class b extends ProtoAdapter<ac> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ac decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ac r4) {
            a(r3, (ac) ZeusTransformUtils.preCheckCast(r4, ac.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ac r3) {
            return a((ac) ZeusTransformUtils.preCheckCast(r3, ac.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ac redact(ac r3) {
            return b((ac) ZeusTransformUtils.preCheckCast(r3, ac.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ac.class);
        }

        public int a(ac r4) {
            return ((((((((((((((((com.obric.matrix.a.a.f33255a.encodedSizeWithTag(100000, r4.f33277b) + ah.f33314a.encodedSizeWithTag(101001, r4.f33278c)) + as.f33390a.encodedSizeWithTag(101002, r4.f33279d)) + au.f33402a.encodedSizeWithTag(101003, r4.f33280e)) + aq.f33375a.encodedSizeWithTag(101004, r4.f)) + ao.f33362a.encodedSizeWithTag(101005, r4.g)) + am.f33349a.encodedSizeWithTag(101006, r4.h)) + k.f33506a.encodedSizeWithTag(102001, r4.i)) + z.f33594a.encodedSizeWithTag(102002, r4.j)) + d.f33446a.encodedSizeWithTag(102003, r4.k)) + i.f33488a.encodedSizeWithTag(102004, r4.l)) + aj.f33321a.encodedSizeWithTag(111001, r4.m)) + w.f33577a.encodedSizeWithTag(111002, r4.n)) + u.f33553a.encodedSizeWithTag(112001, r4.o)) + af.f33307a.encodedSizeWithTag(112002, r4.p)) + g.f33468a.encodedSizeWithTag(112003, r4.q)) + m.f33512a.encodedSizeWithTag(112004, r4.r)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, ac r4) {
            com.obric.matrix.a.a.f33255a.encodeWithTag(r3, 100000, r4.f33277b);
            ah.f33314a.encodeWithTag(r3, 101001, r4.f33278c);
            as.f33390a.encodeWithTag(r3, 101002, r4.f33279d);
            au.f33402a.encodeWithTag(r3, 101003, r4.f33280e);
            aq.f33375a.encodeWithTag(r3, 101004, r4.f);
            ao.f33362a.encodeWithTag(r3, 101005, r4.g);
            am.f33349a.encodeWithTag(r3, 101006, r4.h);
            k.f33506a.encodeWithTag(r3, 102001, r4.i);
            z.f33594a.encodeWithTag(r3, 102002, r4.j);
            d.f33446a.encodeWithTag(r3, 102003, r4.k);
            i.f33488a.encodeWithTag(r3, 102004, r4.l);
            aj.f33321a.encodeWithTag(r3, 111001, r4.m);
            w.f33577a.encodeWithTag(r3, 111002, r4.n);
            u.f33553a.encodeWithTag(r3, 112001, r4.o);
            af.f33307a.encodeWithTag(r3, 112002, r4.p);
            g.f33468a.encodeWithTag(r3, 112003, r4.q);
            m.f33512a.encodeWithTag(r3, 112004, r4.r);
            r3.writeBytes(r4.unknownFields());
        }

        public ac a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L29;
            if (r2 != 100000) goto L7;
            r5.a((com.obric.matrix.a.a) ZeusTransformUtils.preCheckCast(com.obric.matrix.a.a.f33255a.decode(r6), com.obric.matrix.a.a.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            switch(r2) {
                case 101001: goto L27;
                case 101002: goto L26;
                case 101003: goto L25;
                case 101004: goto L24;
                case 101005: goto L23;
                case 101006: goto L22;
                default: goto L8;
            };
        L22:
            r5.a((am) ZeusTransformUtils.preCheckCast(am.f33349a.decode(r6), am.class, "com.obric.aiagent.plugin"));
            goto L3
        L23:
            r5.a((ao) ZeusTransformUtils.preCheckCast(ao.f33362a.decode(r6), ao.class, "com.obric.aiagent.plugin"));
            goto L3
        L24:
            r5.a((aq) ZeusTransformUtils.preCheckCast(aq.f33375a.decode(r6), aq.class, "com.obric.aiagent.plugin"));
            goto L3
        L25:
            r5.a((au) ZeusTransformUtils.preCheckCast(au.f33402a.decode(r6), au.class, "com.obric.aiagent.plugin"));
            goto L3
        L26:
            r5.a((as) ZeusTransformUtils.preCheckCast(as.f33390a.decode(r6), as.class, "com.obric.aiagent.plugin"));
            goto L3
        L27:
            r5.a((ah) ZeusTransformUtils.preCheckCast(ah.f33314a.decode(r6), ah.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            switch(r2) {
                case 102001: goto L21;
                case 102002: goto L20;
                case 102003: goto L19;
                case 102004: goto L18;
                default: goto L9;
            };
        L18:
            r5.a((i) ZeusTransformUtils.preCheckCast(i.f33488a.decode(r6), i.class, "com.obric.aiagent.plugin"));
            goto L3
        L19:
            r5.a((d) ZeusTransformUtils.preCheckCast(d.f33446a.decode(r6), d.class, "com.obric.aiagent.plugin"));
            goto L3
        L20:
            r5.a((z) ZeusTransformUtils.preCheckCast(z.f33594a.decode(r6), z.class, "com.obric.aiagent.plugin"));
            goto L3
        L21:
            r5.a((k) ZeusTransformUtils.preCheckCast(k.f33506a.decode(r6), k.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            switch(r2) {
                case 111001: goto L17;
                case 111002: goto L16;
                default: goto L10;
            };
        L16:
            r5.a((w) ZeusTransformUtils.preCheckCast(w.f33577a.decode(r6), w.class, "com.obric.aiagent.plugin"));
            goto L3
        L17:
            r5.a((aj) ZeusTransformUtils.preCheckCast(aj.f33321a.decode(r6), aj.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            switch(r2) {
                case 112001: goto L15;
                case 112002: goto L14;
                case 112003: goto L13;
                case 112004: goto L12;
                default: goto L11;
            };
        L12:
            r5.a((m) ZeusTransformUtils.preCheckCast(m.f33512a.decode(r6), m.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            r5.a((g) ZeusTransformUtils.preCheckCast(g.f33468a.decode(r6), g.class, "com.obric.aiagent.plugin"));
            goto L3
        L14:
            r5.a((af) ZeusTransformUtils.preCheckCast(af.f33307a.decode(r6), af.class, "com.obric.aiagent.plugin"));
            goto L3
        L15:
            r5.a((u) ZeusTransformUtils.preCheckCast(u.f33553a.decode(r6), u.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L29:
            r6.endMessage(r0);
            return r5.a();
        }

        public ac b(ac r3) {
            a r2 = r3.a();
            if (r2.f33281a == null) goto L6;
            r2.f33281a = (com.obric.matrix.a.a) ZeusTransformUtils.preCheckCast(com.obric.matrix.a.a.f33255a.redact(r2.f33281a), com.obric.matrix.a.a.class, "com.obric.aiagent.plugin");
        L6:
            if (r2.f33282b == null) goto L9;
            r2.f33282b = (ah) ZeusTransformUtils.preCheckCast(ah.f33314a.redact(r2.f33282b), ah.class, "com.obric.aiagent.plugin");
        L9:
            if (r2.f33283c == null) goto L12;
            r2.f33283c = (as) ZeusTransformUtils.preCheckCast(as.f33390a.redact(r2.f33283c), as.class, "com.obric.aiagent.plugin");
        L12:
            if (r2.f33284d == null) goto L15;
            r2.f33284d = (au) ZeusTransformUtils.preCheckCast(au.f33402a.redact(r2.f33284d), au.class, "com.obric.aiagent.plugin");
        L15:
            if (r2.f33285e == null) goto L18;
            r2.f33285e = (aq) ZeusTransformUtils.preCheckCast(aq.f33375a.redact(r2.f33285e), aq.class, "com.obric.aiagent.plugin");
        L18:
            if (r2.f == null) goto L21;
            r2.f = (ao) ZeusTransformUtils.preCheckCast(ao.f33362a.redact(r2.f), ao.class, "com.obric.aiagent.plugin");
        L21:
            if (r2.g == null) goto L24;
            r2.g = (am) ZeusTransformUtils.preCheckCast(am.f33349a.redact(r2.g), am.class, "com.obric.aiagent.plugin");
        L24:
            if (r2.h == null) goto L27;
            r2.h = (k) ZeusTransformUtils.preCheckCast(k.f33506a.redact(r2.h), k.class, "com.obric.aiagent.plugin");
        L27:
            if (r2.i == null) goto L30;
            r2.i = (z) ZeusTransformUtils.preCheckCast(z.f33594a.redact(r2.i), z.class, "com.obric.aiagent.plugin");
        L30:
            if (r2.j == null) goto L33;
            r2.j = (d) ZeusTransformUtils.preCheckCast(d.f33446a.redact(r2.j), d.class, "com.obric.aiagent.plugin");
        L33:
            if (r2.k == null) goto L36;
            r2.k = (i) ZeusTransformUtils.preCheckCast(i.f33488a.redact(r2.k), i.class, "com.obric.aiagent.plugin");
        L36:
            if (r2.l == null) goto L39;
            r2.l = (aj) ZeusTransformUtils.preCheckCast(aj.f33321a.redact(r2.l), aj.class, "com.obric.aiagent.plugin");
        L39:
            if (r2.m == null) goto L42;
            r2.m = (w) ZeusTransformUtils.preCheckCast(w.f33577a.redact(r2.m), w.class, "com.obric.aiagent.plugin");
        L42:
            if (r2.n == null) goto L45;
            r2.n = (u) ZeusTransformUtils.preCheckCast(u.f33553a.redact(r2.n), u.class, "com.obric.aiagent.plugin");
        L45:
            if (r2.o == null) goto L48;
            r2.o = (af) ZeusTransformUtils.preCheckCast(af.f33307a.redact(r2.o), af.class, "com.obric.aiagent.plugin");
        L48:
            if (r2.p == null) goto L51;
            r2.p = (g) ZeusTransformUtils.preCheckCast(g.f33468a.redact(r2.p), g.class, "com.obric.aiagent.plugin");
        L51:
            if (r2.q == null) goto L53;
            r2.q = (m) ZeusTransformUtils.preCheckCast(m.f33512a.redact(r2.q), m.class, "com.obric.aiagent.plugin");
        L53:
            r2.clearUnknownFields();
            return r2.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33276a = new b();
    }

    public ac(com.obric.matrix.a.a r4, ah r5, as r6, au r7, aq r8, ao r9, am r10, k r11, z r12, d r13, i r14, aj r15, w r16, u r17, af r18, g r19, m r20, e.h r21) {
        super(f33276a, r21);
        this.f33277b = r4;
        this.f33278c = r5;
        this.f33279d = r6;
        this.f33280e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
    }

    public a a() {
        a r0 = new a();
        r0.f33281a = this.f33277b;
        r0.f33282b = this.f33278c;
        r0.f33283c = this.f33279d;
        r0.f33284d = this.f33280e;
        r0.f33285e = this.f;
        r0.f = this.g;
        r0.g = this.h;
        r0.h = this.i;
        r0.i = this.j;
        r0.j = this.k;
        r0.k = this.l;
        r0.l = this.m;
        r0.m = this.n;
        r0.n = this.o;
        r0.o = this.p;
        r0.p = this.q;
        r0.q = this.r;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ac.class) == true) goto L8;
        return false;
    L8:
        ac r6 = (ac) ZeusTransformUtils.preCheckCast(r5, ac.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L46;
        if (Internal.equals(this.f33277b, r6.f33277b) == false) goto L46;
        if (Internal.equals(this.f33278c, r6.f33278c) == false) goto L46;
        if (Internal.equals(this.f33279d, r6.f33279d) == false) goto L46;
        if (Internal.equals(this.f33280e, r6.f33280e) == false) goto L46;
        if (Internal.equals(this.f, r6.f) == false) goto L46;
        if (Internal.equals(this.g, r6.g) == false) goto L46;
        if (Internal.equals(this.h, r6.h) == false) goto L46;
        if (Internal.equals(this.i, r6.i) == false) goto L46;
        if (Internal.equals(this.j, r6.j) == false) goto L46;
        if (Internal.equals(this.k, r6.k) == false) goto L46;
        if (Internal.equals(this.l, r6.l) == false) goto L46;
        if (Internal.equals(this.m, r6.m) == false) goto L46;
        if (Internal.equals(this.n, r6.n) == false) goto L46;
        if (Internal.equals(this.o, r6.o) == false) goto L46;
        if (Internal.equals(this.p, r6.p) == false) goto L46;
        if (Internal.equals(this.q, r6.q) == false) goto L46;
        if (Internal.equals(this.r, r6.r) == false) goto L46;
        return true;
    L46:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L73;
        int r1 = unknownFields().hashCode() * 37;
        com.obric.matrix.a.a r2 = this.f33277b;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        ah r6 = this.f33278c;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        as r9 = this.f33279d;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        au r12 = this.f33280e;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        aq r15 = this.f;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        ao r18 = this.g;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        am r21 = this.h;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        k r24 = this.i;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        z r27 = this.j;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        d r30 = this.k;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        i r33 = this.l;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        aj r36 = this.m;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        w r39 = this.n;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        u r42 = this.o;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        af r45 = this.p;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        g r48 = this.q;
        if (r48 == null) goto L67;
        int r49 = r48.hashCode();
    L68:
        int r50 = (r47 + r49) * 37;
        m r51 = this.r;
        if (r51 == null) goto L71;
        r3 = r51.hashCode();
    L71:
        int r52 = r50 + r3;
        this.hashCode = r52;
        return r52;
    L67:
        r49 = 0;
        goto L68
    L63:
        r46 = 0;
        goto L64
    L59:
        r43 = 0;
        goto L60
    L55:
        r40 = 0;
        goto L56
    L51:
        r37 = 0;
        goto L52
    L47:
        r34 = 0;
        goto L48
    L43:
        r31 = 0;
        goto L44
    L39:
        r28 = 0;
        goto L40
    L35:
        r25 = 0;
        goto L36
    L31:
        r22 = 0;
        goto L32
    L27:
        r19 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
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
    L73:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33277b == null) goto L6;
        r0.append(", bizExampleRequest=").append(this.f33277b);
    L6:
        if (this.f33278c == null) goto L9;
        r0.append(", sendWsMessageRequest=").append(this.f33278c);
    L9:
        if (this.f33279d == null) goto L12;
        r0.append(", subscribeWsMsgRequest=").append(this.f33279d);
    L12:
        if (this.f33280e == null) goto L15;
        r0.append(", subscribeWsStatusRequest=").append(this.f33280e);
    L15:
        if (this.f == null) goto L18;
        r0.append(", subscribeWsMsgByProviderRequest=").append(this.f);
    L18:
        if (this.g == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackRequest=").append(this.g);
    L21:
        if (this.h == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastRequest=").append(this.h);
    L24:
        if (this.i == null) goto L27;
        r0.append(", getLocationRequest=").append(this.i);
    L27:
        if (this.j == null) goto L30;
        r0.append(", refreshLocationRequest=").append(this.j);
    L30:
        if (this.k == null) goto L33;
        r0.append(", decodeLocationRequest=").append(this.k);
    L33:
        if (this.l == null) goto L36;
        r0.append(", getIntersectFencesRequest=").append(this.l);
    L36:
        if (this.m == null) goto L39;
        r0.append(", startPicoLinksRequest=").append(this.m);
    L39:
        if (this.n == null) goto L42;
        r0.append(", picoLinksCallback=").append(this.n);
    L42:
        if (this.o == null) goto L45;
        r0.append(", onePartyCommonNetworkRequest=").append(this.o);
    L45:
        if (this.p == null) goto L48;
        r0.append(", sendApplogEventRequest=").append(this.p);
    L48:
        if (this.q == null) goto L51;
        r0.append(", genericNetworkRequest=").append(this.q);
    L51:
        if (this.r == null) goto L54;
        r0.append(", getTTNetParametersRequest=").append(this.r);
    L54:
        return r0.replace(0, 2, "RequestBody{").append('}').toString();
    }
}
