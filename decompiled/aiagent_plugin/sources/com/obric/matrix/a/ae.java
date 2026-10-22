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

/* JADX INFO: compiled from: ResponseBody.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ae extends Message<ae, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ae> f33297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("bizExampleResponse")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleResponse#ADAPTER", tag = 100000)
    public final com.obric.matrix.a.b f33298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("sendWsMessageResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageResponse#ADAPTER", tag = 101001)
    public final ai f33299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("subscribeWsMsgResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgResponse#ADAPTER", tag = 101002)
    public final at f33300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("subscribeWsStatusResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusResponse#ADAPTER", tag = 101003)
    public final av f33301e;

    @SerializedName("subscribeWsMsgByProviderResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderResponse#ADAPTER", tag = 101004)
    public final ar f;

    @SerializedName("subscribeWsMsgByCallBackResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackResponse#ADAPTER", tag = 101005)
    public final ap g;

    @SerializedName("subscribeWsMsgByBroadCastResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastResponse#ADAPTER", tag = 101006)
    public final an h;

    @SerializedName("getLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationResponse#ADAPTER", tag = 102001)
    public final l i;

    @SerializedName("refreshLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationResponse#ADAPTER", tag = 102002)
    public final aa j;

    @SerializedName("decodeLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationResponse#ADAPTER", tag = 102003)
    public final e k;

    @SerializedName("getIntersectFencesResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesResponse#ADAPTER", tag = 102004)
    public final j l;

    @SerializedName("startPicoLinksResponse")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse#ADAPTER", tag = 111001)
    public final ak m;

    @SerializedName("onePartyCommonNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkResponse#ADAPTER", tag = 112001)
    public final v n;

    @SerializedName("sendApplogEventResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventResponse#ADAPTER", tag = 112002)
    public final ag o;

    @SerializedName("genericNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkResponse#ADAPTER", tag = 112003)
    public final h p;

    @SerializedName("getTTNetParametersResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersResponse#ADAPTER", tag = 112004)
    public final n q;

    /* JADX INFO: compiled from: ResponseBody.java */
    public static final class a extends Message.Builder<ae, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.obric.matrix.a.b f33302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ai f33303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public at f33304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public av f33305d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ar f33306e;
        public ap f;
        public an g;
        public l h;
        public aa i;
        public e j;
        public j k;
        public ak l;
        public v m;
        public ag n;
        public h o;
        public n p;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
        }

        public a a(com.obric.matrix.a.b r1) {
            this.f33302a = r1;
            return this;
        }

        public a a(ai r1) {
            this.f33303b = r1;
            return this;
        }

        public a a(at r1) {
            this.f33304c = r1;
            return this;
        }

        public a a(av r1) {
            this.f33305d = r1;
            return this;
        }

        public a a(ar r1) {
            this.f33306e = r1;
            return this;
        }

        public a a(ap r1) {
            this.f = r1;
            return this;
        }

        public a a(an r1) {
            this.g = r1;
            return this;
        }

        public a a(l r1) {
            this.h = r1;
            return this;
        }

        public a a(aa r1) {
            this.i = r1;
            return this;
        }

        public a a(e r1) {
            this.j = r1;
            return this;
        }

        public a a(j r1) {
            this.k = r1;
            return this;
        }

        public a a(ak r1) {
            this.l = r1;
            return this;
        }

        public a a(v r1) {
            this.m = r1;
            return this;
        }

        public a a(ag r1) {
            this.n = r1;
            return this;
        }

        public a a(h r1) {
            this.o = r1;
            return this;
        }

        public a a(n r1) {
            this.p = r1;
            return this;
        }

        public ae a() {
            return new ae(this.f33302a, this.f33303b, this.f33304c, this.f33305d, this.f33306e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: ResponseBody.java */
    private static final class b extends ProtoAdapter<ae> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ae decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ae r4) {
            a(r3, (ae) ZeusTransformUtils.preCheckCast(r4, ae.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ae r3) {
            return a((ae) ZeusTransformUtils.preCheckCast(r3, ae.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ae redact(ae r3) {
            return b((ae) ZeusTransformUtils.preCheckCast(r3, ae.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ae.class);
        }

        public int a(ae r4) {
            return (((((((((((((((com.obric.matrix.a.b.f33437a.encodedSizeWithTag(100000, r4.f33298b) + ai.f33317a.encodedSizeWithTag(101001, r4.f33299c)) + at.f33399a.encodedSizeWithTag(101002, r4.f33300d)) + av.f33408a.encodedSizeWithTag(101003, r4.f33301e)) + ar.f33384a.encodedSizeWithTag(101004, r4.f)) + ap.f33371a.encodedSizeWithTag(101005, r4.g)) + an.f33358a.encodedSizeWithTag(101006, r4.h)) + l.f33509a.encodedSizeWithTag(102001, r4.i)) + aa.f33258a.encodedSizeWithTag(102002, r4.j)) + e.f33454a.encodedSizeWithTag(102003, r4.k)) + j.f33499a.encodedSizeWithTag(102004, r4.l)) + ak.f33334a.encodedSizeWithTag(111001, r4.m)) + v.f33567a.encodedSizeWithTag(112001, r4.n)) + ag.f33313a.encodedSizeWithTag(112002, r4.o)) + h.f33480a.encodedSizeWithTag(112003, r4.p)) + n.f33513a.encodedSizeWithTag(112004, r4.q)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, ae r4) {
            com.obric.matrix.a.b.f33437a.encodeWithTag(r3, 100000, r4.f33298b);
            ai.f33317a.encodeWithTag(r3, 101001, r4.f33299c);
            at.f33399a.encodeWithTag(r3, 101002, r4.f33300d);
            av.f33408a.encodeWithTag(r3, 101003, r4.f33301e);
            ar.f33384a.encodeWithTag(r3, 101004, r4.f);
            ap.f33371a.encodeWithTag(r3, 101005, r4.g);
            an.f33358a.encodeWithTag(r3, 101006, r4.h);
            l.f33509a.encodeWithTag(r3, 102001, r4.i);
            aa.f33258a.encodeWithTag(r3, 102002, r4.j);
            e.f33454a.encodeWithTag(r3, 102003, r4.k);
            j.f33499a.encodeWithTag(r3, 102004, r4.l);
            ak.f33334a.encodeWithTag(r3, 111001, r4.m);
            v.f33567a.encodeWithTag(r3, 112001, r4.n);
            ag.f33313a.encodeWithTag(r3, 112002, r4.o);
            h.f33480a.encodeWithTag(r3, 112003, r4.p);
            n.f33513a.encodeWithTag(r3, 112004, r4.q);
            r3.writeBytes(r4.unknownFields());
        }

        public ae a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L29;
            if (r2 != 100000) goto L8;
            r5.a((com.obric.matrix.a.b) ZeusTransformUtils.preCheckCast(com.obric.matrix.a.b.f33437a.decode(r6), com.obric.matrix.a.b.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 111001) goto L9;
            r5.a((ak) ZeusTransformUtils.preCheckCast(ak.f33334a.decode(r6), ak.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            switch(r2) {
                case 101001: goto L26;
                case 101002: goto L25;
                case 101003: goto L24;
                case 101004: goto L23;
                case 101005: goto L22;
                case 101006: goto L21;
                default: goto L10;
            };
        L21:
            r5.a((an) ZeusTransformUtils.preCheckCast(an.f33358a.decode(r6), an.class, "com.obric.aiagent.plugin"));
            goto L3
        L22:
            r5.a((ap) ZeusTransformUtils.preCheckCast(ap.f33371a.decode(r6), ap.class, "com.obric.aiagent.plugin"));
            goto L3
        L23:
            r5.a((ar) ZeusTransformUtils.preCheckCast(ar.f33384a.decode(r6), ar.class, "com.obric.aiagent.plugin"));
            goto L3
        L24:
            r5.a((av) ZeusTransformUtils.preCheckCast(av.f33408a.decode(r6), av.class, "com.obric.aiagent.plugin"));
            goto L3
        L25:
            r5.a((at) ZeusTransformUtils.preCheckCast(at.f33399a.decode(r6), at.class, "com.obric.aiagent.plugin"));
            goto L3
        L26:
            r5.a((ai) ZeusTransformUtils.preCheckCast(ai.f33317a.decode(r6), ai.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            switch(r2) {
                case 102001: goto L20;
                case 102002: goto L19;
                case 102003: goto L18;
                case 102004: goto L17;
                default: goto L11;
            };
        L17:
            r5.a((j) ZeusTransformUtils.preCheckCast(j.f33499a.decode(r6), j.class, "com.obric.aiagent.plugin"));
            goto L3
        L18:
            r5.a((e) ZeusTransformUtils.preCheckCast(e.f33454a.decode(r6), e.class, "com.obric.aiagent.plugin"));
            goto L3
        L19:
            r5.a((aa) ZeusTransformUtils.preCheckCast(aa.f33258a.decode(r6), aa.class, "com.obric.aiagent.plugin"));
            goto L3
        L20:
            r5.a((l) ZeusTransformUtils.preCheckCast(l.f33509a.decode(r6), l.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            switch(r2) {
                case 112001: goto L16;
                case 112002: goto L15;
                case 112003: goto L14;
                case 112004: goto L13;
                default: goto L12;
            };
        L13:
            r5.a((n) ZeusTransformUtils.preCheckCast(n.f33513a.decode(r6), n.class, "com.obric.aiagent.plugin"));
            goto L3
        L14:
            r5.a((h) ZeusTransformUtils.preCheckCast(h.f33480a.decode(r6), h.class, "com.obric.aiagent.plugin"));
            goto L3
        L15:
            r5.a((ag) ZeusTransformUtils.preCheckCast(ag.f33313a.decode(r6), ag.class, "com.obric.aiagent.plugin"));
            goto L3
        L16:
            r5.a((v) ZeusTransformUtils.preCheckCast(v.f33567a.decode(r6), v.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L29:
            r6.endMessage(r0);
            return r5.a();
        }

        public ae b(ae r3) {
            a r2 = r3.a();
            if (r2.f33302a == null) goto L6;
            r2.f33302a = (com.obric.matrix.a.b) ZeusTransformUtils.preCheckCast(com.obric.matrix.a.b.f33437a.redact(r2.f33302a), com.obric.matrix.a.b.class, "com.obric.aiagent.plugin");
        L6:
            if (r2.f33303b == null) goto L9;
            r2.f33303b = (ai) ZeusTransformUtils.preCheckCast(ai.f33317a.redact(r2.f33303b), ai.class, "com.obric.aiagent.plugin");
        L9:
            if (r2.f33304c == null) goto L12;
            r2.f33304c = (at) ZeusTransformUtils.preCheckCast(at.f33399a.redact(r2.f33304c), at.class, "com.obric.aiagent.plugin");
        L12:
            if (r2.f33305d == null) goto L15;
            r2.f33305d = (av) ZeusTransformUtils.preCheckCast(av.f33408a.redact(r2.f33305d), av.class, "com.obric.aiagent.plugin");
        L15:
            if (r2.f33306e == null) goto L18;
            r2.f33306e = (ar) ZeusTransformUtils.preCheckCast(ar.f33384a.redact(r2.f33306e), ar.class, "com.obric.aiagent.plugin");
        L18:
            if (r2.f == null) goto L21;
            r2.f = (ap) ZeusTransformUtils.preCheckCast(ap.f33371a.redact(r2.f), ap.class, "com.obric.aiagent.plugin");
        L21:
            if (r2.g == null) goto L24;
            r2.g = (an) ZeusTransformUtils.preCheckCast(an.f33358a.redact(r2.g), an.class, "com.obric.aiagent.plugin");
        L24:
            if (r2.h == null) goto L27;
            r2.h = (l) ZeusTransformUtils.preCheckCast(l.f33509a.redact(r2.h), l.class, "com.obric.aiagent.plugin");
        L27:
            if (r2.i == null) goto L30;
            r2.i = (aa) ZeusTransformUtils.preCheckCast(aa.f33258a.redact(r2.i), aa.class, "com.obric.aiagent.plugin");
        L30:
            if (r2.j == null) goto L33;
            r2.j = (e) ZeusTransformUtils.preCheckCast(e.f33454a.redact(r2.j), e.class, "com.obric.aiagent.plugin");
        L33:
            if (r2.k == null) goto L36;
            r2.k = (j) ZeusTransformUtils.preCheckCast(j.f33499a.redact(r2.k), j.class, "com.obric.aiagent.plugin");
        L36:
            if (r2.l == null) goto L39;
            r2.l = (ak) ZeusTransformUtils.preCheckCast(ak.f33334a.redact(r2.l), ak.class, "com.obric.aiagent.plugin");
        L39:
            if (r2.m == null) goto L42;
            r2.m = (v) ZeusTransformUtils.preCheckCast(v.f33567a.redact(r2.m), v.class, "com.obric.aiagent.plugin");
        L42:
            if (r2.n == null) goto L45;
            r2.n = (ag) ZeusTransformUtils.preCheckCast(ag.f33313a.redact(r2.n), ag.class, "com.obric.aiagent.plugin");
        L45:
            if (r2.o == null) goto L48;
            r2.o = (h) ZeusTransformUtils.preCheckCast(h.f33480a.redact(r2.o), h.class, "com.obric.aiagent.plugin");
        L48:
            if (r2.p == null) goto L50;
            r2.p = (n) ZeusTransformUtils.preCheckCast(n.f33513a.redact(r2.p), n.class, "com.obric.aiagent.plugin");
        L50:
            r2.clearUnknownFields();
            return r2.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33297a = new b();
    }

    public ae(com.obric.matrix.a.b r4, ai r5, at r6, av r7, ar r8, ap r9, an r10, l r11, aa r12, e r13, j r14, ak r15, v r16, ag r17, h r18, n r19, e.h r20) {
        super(f33297a, r20);
        this.f33298b = r4;
        this.f33299c = r5;
        this.f33300d = r6;
        this.f33301e = r7;
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
    }

    public a a() {
        a r0 = new a();
        r0.f33302a = this.f33298b;
        r0.f33303b = this.f33299c;
        r0.f33304c = this.f33300d;
        r0.f33305d = this.f33301e;
        r0.f33306e = this.f;
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
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ae.class) == true) goto L8;
        return false;
    L8:
        ae r6 = (ae) ZeusTransformUtils.preCheckCast(r5, ae.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L44;
        if (Internal.equals(this.f33298b, r6.f33298b) == false) goto L44;
        if (Internal.equals(this.f33299c, r6.f33299c) == false) goto L44;
        if (Internal.equals(this.f33300d, r6.f33300d) == false) goto L44;
        if (Internal.equals(this.f33301e, r6.f33301e) == false) goto L44;
        if (Internal.equals(this.f, r6.f) == false) goto L44;
        if (Internal.equals(this.g, r6.g) == false) goto L44;
        if (Internal.equals(this.h, r6.h) == false) goto L44;
        if (Internal.equals(this.i, r6.i) == false) goto L44;
        if (Internal.equals(this.j, r6.j) == false) goto L44;
        if (Internal.equals(this.k, r6.k) == false) goto L44;
        if (Internal.equals(this.l, r6.l) == false) goto L44;
        if (Internal.equals(this.m, r6.m) == false) goto L44;
        if (Internal.equals(this.n, r6.n) == false) goto L44;
        if (Internal.equals(this.o, r6.o) == false) goto L44;
        if (Internal.equals(this.p, r6.p) == false) goto L44;
        if (Internal.equals(this.q, r6.q) == false) goto L44;
        return true;
    L44:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L69;
        int r1 = unknownFields().hashCode() * 37;
        com.obric.matrix.a.b r2 = this.f33298b;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        ai r6 = this.f33299c;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        at r9 = this.f33300d;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        av r12 = this.f33301e;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        ar r15 = this.f;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        ap r18 = this.g;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        an r21 = this.h;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        l r24 = this.i;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        aa r27 = this.j;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        e r30 = this.k;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        j r33 = this.l;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        ak r36 = this.m;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        v r39 = this.n;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        ag r42 = this.o;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        h r45 = this.p;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        n r48 = this.q;
        if (r48 == null) goto L67;
        r3 = r48.hashCode();
    L67:
        int r49 = r47 + r3;
        this.hashCode = r49;
        return r49;
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
    L69:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33298b == null) goto L6;
        r0.append(", bizExampleResponse=").append(this.f33298b);
    L6:
        if (this.f33299c == null) goto L9;
        r0.append(", sendWsMessageResponse=").append(this.f33299c);
    L9:
        if (this.f33300d == null) goto L12;
        r0.append(", subscribeWsMsgResponse=").append(this.f33300d);
    L12:
        if (this.f33301e == null) goto L15;
        r0.append(", subscribeWsStatusResponse=").append(this.f33301e);
    L15:
        if (this.f == null) goto L18;
        r0.append(", subscribeWsMsgByProviderResponse=").append(this.f);
    L18:
        if (this.g == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackResponse=").append(this.g);
    L21:
        if (this.h == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastResponse=").append(this.h);
    L24:
        if (this.i == null) goto L27;
        r0.append(", getLocationResponse=").append(this.i);
    L27:
        if (this.j == null) goto L30;
        r0.append(", refreshLocationResponse=").append(this.j);
    L30:
        if (this.k == null) goto L33;
        r0.append(", decodeLocationResponse=").append(this.k);
    L33:
        if (this.l == null) goto L36;
        r0.append(", getIntersectFencesResponse=").append(this.l);
    L36:
        if (this.m == null) goto L39;
        r0.append(", startPicoLinksResponse=").append(this.m);
    L39:
        if (this.n == null) goto L42;
        r0.append(", onePartyCommonNetworkResponse=").append(this.n);
    L42:
        if (this.o == null) goto L45;
        r0.append(", sendApplogEventResponse=").append(this.o);
    L45:
        if (this.p == null) goto L48;
        r0.append(", genericNetworkResponse=").append(this.p);
    L48:
        if (this.q == null) goto L51;
        r0.append(", getTTNetParametersResponse=").append(this.q);
    L51:
        return r0.replace(0, 2, "ResponseBody{").append('}').toString();
    }
}
