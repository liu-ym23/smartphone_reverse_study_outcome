package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class ResponseBody extends Message<ResponseBody, a> {
    public static final ProtoAdapter<ResponseBody> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("bizExampleResponse")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleResponse#ADAPTER", tag = 100000)
    public final BizExampleResponse bizExampleResponse;

    @SerializedName("decodeLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationResponse#ADAPTER", tag = 102003)
    public final DecodeLocationResponse decodeLocationResponse;

    @SerializedName("genericNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkResponse#ADAPTER", tag = 112003)
    public final GenericNetworkResponse genericNetworkResponse;

    @SerializedName("getIntersectFencesResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesResponse#ADAPTER", tag = 102004)
    public final GetIntersectFencesResponse getIntersectFencesResponse;

    @SerializedName("getLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationResponse#ADAPTER", tag = 102001)
    public final GetLocationResponse getLocationResponse;

    @SerializedName("getTTNetParametersResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersResponse#ADAPTER", tag = 112004)
    public final GetTTNetParametersResponse getTTNetParametersResponse;

    @SerializedName("onePartyCommonNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkResponse#ADAPTER", tag = 112001)
    public final OnePartyCommonNetworkResponse onePartyCommonNetworkResponse;

    @SerializedName("refreshLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationResponse#ADAPTER", tag = 102002)
    public final RefreshLocationResponse refreshLocationResponse;

    @SerializedName("sendApplogEventResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventResponse#ADAPTER", tag = 112002)
    public final SendApplogEventResponse sendApplogEventResponse;

    @SerializedName("sendWsMessageResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageResponse#ADAPTER", tag = 101001)
    public final SendWsMessageResponse sendWsMessageResponse;

    @SerializedName("startPicoLinksResponse")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse#ADAPTER", tag = 111001)
    public final StartPicoLinksResponse startPicoLinksResponse;

    @SerializedName("subscribeWsMsgByBroadCastResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastResponse#ADAPTER", tag = 101006)
    public final SubscribeWsMsgByBroadCastResponse subscribeWsMsgByBroadCastResponse;

    @SerializedName("subscribeWsMsgByCallBackResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackResponse#ADAPTER", tag = 101005)
    public final SubscribeWsMsgByCallBackResponse subscribeWsMsgByCallBackResponse;

    @SerializedName("subscribeWsMsgByProviderResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderResponse#ADAPTER", tag = 101004)
    public final SubscribeWsMsgByProviderResponse subscribeWsMsgByProviderResponse;

    @SerializedName("subscribeWsMsgResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgResponse#ADAPTER", tag = 101002)
    public final SubscribeWsMsgResponse subscribeWsMsgResponse;

    @SerializedName("subscribeWsStatusResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusResponse#ADAPTER", tag = 101003)
    public final SubscribeWsStatusResponse subscribeWsStatusResponse;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BizExampleResponse f12108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SendWsMessageResponse f12109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SubscribeWsMsgResponse f12110c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public SubscribeWsStatusResponse f12111d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public SubscribeWsMsgByProviderResponse f12112e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SubscribeWsMsgByCallBackResponse f12113f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SubscribeWsMsgByBroadCastResponse f12114g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public GetLocationResponse f12115h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RefreshLocationResponse f12116i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public DecodeLocationResponse f12117j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public GetIntersectFencesResponse f12118k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public StartPicoLinksResponse f12119l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public OnePartyCommonNetworkResponse f12120m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public SendApplogEventResponse f12121n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public GenericNetworkResponse f12122o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public GetTTNetParametersResponse f12123p;

        public a() {
        }

        public a a(BizExampleResponse r10) {
            this.f12108a = r10;
            return this;
        }

        public ResponseBody b() {
            return new ResponseBody(this.f12108a, this.f12109b, this.f12110c, this.f12111d, this.f12112e, this.f12113f, this.f12114g, this.f12115h, this.f12116i, this.f12117j, this.f12118k, this.f12119l, this.f12120m, this.f12121n, this.f12122o, this.f12123p, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(DecodeLocationResponse r10) {
            this.f12117j = r10;
            return this;
        }

        public a d(GenericNetworkResponse r10) {
            this.f12122o = r10;
            return this;
        }

        public a e(GetIntersectFencesResponse r10) {
            this.f12118k = r10;
            return this;
        }

        public a f(GetLocationResponse r10) {
            this.f12115h = r10;
            return this;
        }

        public a g(GetTTNetParametersResponse r10) {
            this.f12123p = r10;
            return this;
        }

        public a h(OnePartyCommonNetworkResponse r10) {
            this.f12120m = r10;
            return this;
        }

        public a i(RefreshLocationResponse r10) {
            this.f12116i = r10;
            return this;
        }

        public a j(SendApplogEventResponse r10) {
            this.f12121n = r10;
            return this;
        }

        public a k(SendWsMessageResponse r10) {
            this.f12109b = r10;
            return this;
        }

        public a l(StartPicoLinksResponse r10) {
            this.f12119l = r10;
            return this;
        }

        public a m(SubscribeWsMsgByBroadCastResponse r10) {
            this.f12114g = r10;
            return this;
        }

        public a n(SubscribeWsMsgByCallBackResponse r10) {
            this.f12113f = r10;
            return this;
        }

        public a o(SubscribeWsMsgByProviderResponse r10) {
            this.f12112e = r10;
            return this;
        }

        public a p(SubscribeWsMsgResponse r10) {
            this.f12110c = r10;
            return this;
        }

        public a q(SubscribeWsStatusResponse r10) {
            this.f12111d = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseBody.class);
        }

        public ResponseBody a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L29;
            if (r13 != 100000) goto L8;
            r11.a(BizExampleResponse.ADAPTER.decode(r10));
            goto L3
        L8:
            if (r13 != 111001) goto L9;
            r11.l(StartPicoLinksResponse.ADAPTER.decode(r10));
            goto L3
        L9:
            switch(r13) {
                case 101001: goto L26;
                case 101002: goto L25;
                case 101003: goto L24;
                case 101004: goto L23;
                case 101005: goto L22;
                case 101006: goto L21;
                default: goto L10;
            };
        L21:
            r11.m(SubscribeWsMsgByBroadCastResponse.ADAPTER.decode(r10));
            goto L3
        L22:
            r11.n(SubscribeWsMsgByCallBackResponse.ADAPTER.decode(r10));
            goto L3
        L23:
            r11.o(SubscribeWsMsgByProviderResponse.ADAPTER.decode(r10));
            goto L3
        L24:
            r11.q(SubscribeWsStatusResponse.ADAPTER.decode(r10));
            goto L3
        L25:
            r11.p(SubscribeWsMsgResponse.ADAPTER.decode(r10));
            goto L3
        L26:
            r11.k(SendWsMessageResponse.ADAPTER.decode(r10));
            goto L3
        L10:
            switch(r13) {
                case 102001: goto L20;
                case 102002: goto L19;
                case 102003: goto L18;
                case 102004: goto L17;
                default: goto L11;
            };
        L17:
            r11.e(GetIntersectFencesResponse.ADAPTER.decode(r10));
            goto L3
        L18:
            r11.c(DecodeLocationResponse.ADAPTER.decode(r10));
            goto L3
        L19:
            r11.i(RefreshLocationResponse.ADAPTER.decode(r10));
            goto L3
        L20:
            r11.f(GetLocationResponse.ADAPTER.decode(r10));
            goto L3
        L11:
            switch(r13) {
                case 112001: goto L16;
                case 112002: goto L15;
                case 112003: goto L14;
                case 112004: goto L13;
                default: goto L12;
            };
        L13:
            r11.g(GetTTNetParametersResponse.ADAPTER.decode(r10));
            goto L3
        L14:
            r11.d(GenericNetworkResponse.ADAPTER.decode(r10));
            goto L3
        L15:
            r11.j(SendApplogEventResponse.ADAPTER.decode(r10));
            goto L3
        L16:
            r11.h(OnePartyCommonNetworkResponse.ADAPTER.decode(r10));
            goto L3
        L12:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L29:
            r10.endMessage(r12);
            return r11.b();
        }

        public void b(ProtoWriter r10, ResponseBody r11) {
            BizExampleResponse.ADAPTER.encodeWithTag(r10, 100000, r11.bizExampleResponse);
            SendWsMessageResponse.ADAPTER.encodeWithTag(r10, 101001, r11.sendWsMessageResponse);
            SubscribeWsMsgResponse.ADAPTER.encodeWithTag(r10, 101002, r11.subscribeWsMsgResponse);
            SubscribeWsStatusResponse.ADAPTER.encodeWithTag(r10, 101003, r11.subscribeWsStatusResponse);
            SubscribeWsMsgByProviderResponse.ADAPTER.encodeWithTag(r10, 101004, r11.subscribeWsMsgByProviderResponse);
            SubscribeWsMsgByCallBackResponse.ADAPTER.encodeWithTag(r10, 101005, r11.subscribeWsMsgByCallBackResponse);
            SubscribeWsMsgByBroadCastResponse.ADAPTER.encodeWithTag(r10, 101006, r11.subscribeWsMsgByBroadCastResponse);
            GetLocationResponse.ADAPTER.encodeWithTag(r10, 102001, r11.getLocationResponse);
            RefreshLocationResponse.ADAPTER.encodeWithTag(r10, 102002, r11.refreshLocationResponse);
            DecodeLocationResponse.ADAPTER.encodeWithTag(r10, 102003, r11.decodeLocationResponse);
            GetIntersectFencesResponse.ADAPTER.encodeWithTag(r10, 102004, r11.getIntersectFencesResponse);
            StartPicoLinksResponse.ADAPTER.encodeWithTag(r10, 111001, r11.startPicoLinksResponse);
            OnePartyCommonNetworkResponse.ADAPTER.encodeWithTag(r10, 112001, r11.onePartyCommonNetworkResponse);
            SendApplogEventResponse.ADAPTER.encodeWithTag(r10, 112002, r11.sendApplogEventResponse);
            GenericNetworkResponse.ADAPTER.encodeWithTag(r10, 112003, r11.genericNetworkResponse);
            GetTTNetParametersResponse.ADAPTER.encodeWithTag(r10, 112004, r11.getTTNetParametersResponse);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(ResponseBody r10) {
            return (((((((((((((((BizExampleResponse.ADAPTER.encodedSizeWithTag(100000, r10.bizExampleResponse) + SendWsMessageResponse.ADAPTER.encodedSizeWithTag(101001, r10.sendWsMessageResponse)) + SubscribeWsMsgResponse.ADAPTER.encodedSizeWithTag(101002, r10.subscribeWsMsgResponse)) + SubscribeWsStatusResponse.ADAPTER.encodedSizeWithTag(101003, r10.subscribeWsStatusResponse)) + SubscribeWsMsgByProviderResponse.ADAPTER.encodedSizeWithTag(101004, r10.subscribeWsMsgByProviderResponse)) + SubscribeWsMsgByCallBackResponse.ADAPTER.encodedSizeWithTag(101005, r10.subscribeWsMsgByCallBackResponse)) + SubscribeWsMsgByBroadCastResponse.ADAPTER.encodedSizeWithTag(101006, r10.subscribeWsMsgByBroadCastResponse)) + GetLocationResponse.ADAPTER.encodedSizeWithTag(102001, r10.getLocationResponse)) + RefreshLocationResponse.ADAPTER.encodedSizeWithTag(102002, r10.refreshLocationResponse)) + DecodeLocationResponse.ADAPTER.encodedSizeWithTag(102003, r10.decodeLocationResponse)) + GetIntersectFencesResponse.ADAPTER.encodedSizeWithTag(102004, r10.getIntersectFencesResponse)) + StartPicoLinksResponse.ADAPTER.encodedSizeWithTag(111001, r10.startPicoLinksResponse)) + OnePartyCommonNetworkResponse.ADAPTER.encodedSizeWithTag(112001, r10.onePartyCommonNetworkResponse)) + SendApplogEventResponse.ADAPTER.encodedSizeWithTag(112002, r10.sendApplogEventResponse)) + GenericNetworkResponse.ADAPTER.encodedSizeWithTag(112003, r10.genericNetworkResponse)) + GetTTNetParametersResponse.ADAPTER.encodedSizeWithTag(112004, r10.getTTNetParametersResponse)) + r10.unknownFields().size();
        }

        public ResponseBody d(ResponseBody r10) {
            a r11 = r10.newBuilder();
            BizExampleResponse r12 = r11.f12108a;
            if (r12 == null) goto L5;
            r11.f12108a = BizExampleResponse.ADAPTER.redact(r12);
        L5:
            SendWsMessageResponse r13 = r11.f12109b;
            if (r13 == null) goto L8;
            r11.f12109b = SendWsMessageResponse.ADAPTER.redact(r13);
        L8:
            SubscribeWsMsgResponse r14 = r11.f12110c;
            if (r14 == null) goto L11;
            r11.f12110c = SubscribeWsMsgResponse.ADAPTER.redact(r14);
        L11:
            SubscribeWsStatusResponse r15 = r11.f12111d;
            if (r15 == null) goto L14;
            r11.f12111d = SubscribeWsStatusResponse.ADAPTER.redact(r15);
        L14:
            SubscribeWsMsgByProviderResponse r16 = r11.f12112e;
            if (r16 == null) goto L17;
            r11.f12112e = SubscribeWsMsgByProviderResponse.ADAPTER.redact(r16);
        L17:
            SubscribeWsMsgByCallBackResponse r17 = r11.f12113f;
            if (r17 == null) goto L20;
            r11.f12113f = SubscribeWsMsgByCallBackResponse.ADAPTER.redact(r17);
        L20:
            SubscribeWsMsgByBroadCastResponse r18 = r11.f12114g;
            if (r18 == null) goto L23;
            r11.f12114g = SubscribeWsMsgByBroadCastResponse.ADAPTER.redact(r18);
        L23:
            GetLocationResponse r19 = r11.f12115h;
            if (r19 == null) goto L26;
            r11.f12115h = GetLocationResponse.ADAPTER.redact(r19);
        L26:
            RefreshLocationResponse r20 = r11.f12116i;
            if (r20 == null) goto L29;
            r11.f12116i = RefreshLocationResponse.ADAPTER.redact(r20);
        L29:
            DecodeLocationResponse r21 = r11.f12117j;
            if (r21 == null) goto L32;
            r11.f12117j = DecodeLocationResponse.ADAPTER.redact(r21);
        L32:
            GetIntersectFencesResponse r22 = r11.f12118k;
            if (r22 == null) goto L35;
            r11.f12118k = GetIntersectFencesResponse.ADAPTER.redact(r22);
        L35:
            StartPicoLinksResponse r23 = r11.f12119l;
            if (r23 == null) goto L38;
            r11.f12119l = StartPicoLinksResponse.ADAPTER.redact(r23);
        L38:
            OnePartyCommonNetworkResponse r24 = r11.f12120m;
            if (r24 == null) goto L41;
            r11.f12120m = OnePartyCommonNetworkResponse.ADAPTER.redact(r24);
        L41:
            SendApplogEventResponse r25 = r11.f12121n;
            if (r25 == null) goto L44;
            r11.f12121n = SendApplogEventResponse.ADAPTER.redact(r25);
        L44:
            GenericNetworkResponse r26 = r11.f12122o;
            if (r26 == null) goto L47;
            r11.f12122o = GenericNetworkResponse.ADAPTER.redact(r26);
        L47:
            GetTTNetParametersResponse r27 = r11.f12123p;
            if (r27 == null) goto L50;
            r11.f12123p = GetTTNetParametersResponse.ADAPTER.redact(r27);
        L50:
            r11.clearUnknownFields();
            return r11.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (ResponseBody) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((ResponseBody) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((ResponseBody) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public ResponseBody(BizExampleResponse r19, SendWsMessageResponse r20, SubscribeWsMsgResponse r21, SubscribeWsStatusResponse r22, SubscribeWsMsgByProviderResponse r23, SubscribeWsMsgByCallBackResponse r24, SubscribeWsMsgByBroadCastResponse r25, GetLocationResponse r26, RefreshLocationResponse r27, DecodeLocationResponse r28, GetIntersectFencesResponse r29, StartPicoLinksResponse r30, OnePartyCommonNetworkResponse r31, SendApplogEventResponse r32, GenericNetworkResponse r33, GetTTNetParametersResponse r34) {
        this(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ResponseBody) == true) goto L8;
        return false;
    L8:
        ResponseBody r11 = (ResponseBody) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L44;
        if (Internal.equals(this.bizExampleResponse, r11.bizExampleResponse) == false) goto L44;
        if (Internal.equals(this.sendWsMessageResponse, r11.sendWsMessageResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgResponse, r11.subscribeWsMsgResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsStatusResponse, r11.subscribeWsStatusResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByProviderResponse, r11.subscribeWsMsgByProviderResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByCallBackResponse, r11.subscribeWsMsgByCallBackResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByBroadCastResponse, r11.subscribeWsMsgByBroadCastResponse) == false) goto L44;
        if (Internal.equals(this.getLocationResponse, r11.getLocationResponse) == false) goto L44;
        if (Internal.equals(this.refreshLocationResponse, r11.refreshLocationResponse) == false) goto L44;
        if (Internal.equals(this.decodeLocationResponse, r11.decodeLocationResponse) == false) goto L44;
        if (Internal.equals(this.getIntersectFencesResponse, r11.getIntersectFencesResponse) == false) goto L44;
        if (Internal.equals(this.startPicoLinksResponse, r11.startPicoLinksResponse) == false) goto L44;
        if (Internal.equals(this.onePartyCommonNetworkResponse, r11.onePartyCommonNetworkResponse) == false) goto L44;
        if (Internal.equals(this.sendApplogEventResponse, r11.sendApplogEventResponse) == false) goto L44;
        if (Internal.equals(this.genericNetworkResponse, r11.genericNetworkResponse) == false) goto L44;
        if (Internal.equals(this.getTTNetParametersResponse, r11.getTTNetParametersResponse) == false) goto L44;
        return true;
    L44:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L69;
        int r11 = unknownFields().hashCode() * 37;
        BizExampleResponse r12 = this.bizExampleResponse;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        SendWsMessageResponse r16 = this.sendWsMessageResponse;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        SubscribeWsMsgResponse r19 = this.subscribeWsMsgResponse;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        SubscribeWsStatusResponse r22 = this.subscribeWsStatusResponse;
        if (r22 == null) goto L19;
        int r23 = r22.hashCode();
    L20:
        int r24 = (r21 + r23) * 37;
        SubscribeWsMsgByProviderResponse r25 = this.subscribeWsMsgByProviderResponse;
        if (r25 == null) goto L23;
        int r26 = r25.hashCode();
    L24:
        int r27 = (r24 + r26) * 37;
        SubscribeWsMsgByCallBackResponse r28 = this.subscribeWsMsgByCallBackResponse;
        if (r28 == null) goto L27;
        int r29 = r28.hashCode();
    L28:
        int r30 = (r27 + r29) * 37;
        SubscribeWsMsgByBroadCastResponse r31 = this.subscribeWsMsgByBroadCastResponse;
        if (r31 == null) goto L31;
        int r32 = r31.hashCode();
    L32:
        int r33 = (r30 + r32) * 37;
        GetLocationResponse r34 = this.getLocationResponse;
        if (r34 == null) goto L35;
        int r35 = r34.hashCode();
    L36:
        int r36 = (r33 + r35) * 37;
        RefreshLocationResponse r37 = this.refreshLocationResponse;
        if (r37 == null) goto L39;
        int r38 = r37.hashCode();
    L40:
        int r39 = (r36 + r38) * 37;
        DecodeLocationResponse r40 = this.decodeLocationResponse;
        if (r40 == null) goto L43;
        int r41 = r40.hashCode();
    L44:
        int r42 = (r39 + r41) * 37;
        GetIntersectFencesResponse r43 = this.getIntersectFencesResponse;
        if (r43 == null) goto L47;
        int r44 = r43.hashCode();
    L48:
        int r45 = (r42 + r44) * 37;
        StartPicoLinksResponse r46 = this.startPicoLinksResponse;
        if (r46 == null) goto L51;
        int r47 = r46.hashCode();
    L52:
        int r48 = (r45 + r47) * 37;
        OnePartyCommonNetworkResponse r49 = this.onePartyCommonNetworkResponse;
        if (r49 == null) goto L55;
        int r50 = r49.hashCode();
    L56:
        int r51 = (r48 + r50) * 37;
        SendApplogEventResponse r52 = this.sendApplogEventResponse;
        if (r52 == null) goto L59;
        int r53 = r52.hashCode();
    L60:
        int r54 = (r51 + r53) * 37;
        GenericNetworkResponse r55 = this.genericNetworkResponse;
        if (r55 == null) goto L63;
        int r56 = r55.hashCode();
    L64:
        int r57 = (r54 + r56) * 37;
        GetTTNetParametersResponse r58 = this.getTTNetParametersResponse;
        if (r58 == null) goto L67;
        r13 = r58.hashCode();
    L67:
        int r59 = r57 + r13;
        this.hashCode = r59;
        return r59;
    L63:
        r56 = 0;
        goto L64
    L59:
        r53 = 0;
        goto L60
    L55:
        r50 = 0;
        goto L56
    L51:
        r47 = 0;
        goto L52
    L47:
        r44 = 0;
        goto L48
    L43:
        r41 = 0;
        goto L44
    L39:
        r38 = 0;
        goto L40
    L35:
        r35 = 0;
        goto L36
    L31:
        r32 = 0;
        goto L32
    L27:
        r29 = 0;
        goto L28
    L23:
        r26 = 0;
        goto L24
    L19:
        r23 = 0;
        goto L20
    L15:
        r20 = 0;
        goto L16
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L69:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.bizExampleResponse == null) goto L6;
        r10.append(", bizExampleResponse=");
        r10.append(this.bizExampleResponse);
    L6:
        if (this.sendWsMessageResponse == null) goto L9;
        r10.append(", sendWsMessageResponse=");
        r10.append(this.sendWsMessageResponse);
    L9:
        if (this.subscribeWsMsgResponse == null) goto L12;
        r10.append(", subscribeWsMsgResponse=");
        r10.append(this.subscribeWsMsgResponse);
    L12:
        if (this.subscribeWsStatusResponse == null) goto L15;
        r10.append(", subscribeWsStatusResponse=");
        r10.append(this.subscribeWsStatusResponse);
    L15:
        if (this.subscribeWsMsgByProviderResponse == null) goto L18;
        r10.append(", subscribeWsMsgByProviderResponse=");
        r10.append(this.subscribeWsMsgByProviderResponse);
    L18:
        if (this.subscribeWsMsgByCallBackResponse == null) goto L21;
        r10.append(", subscribeWsMsgByCallBackResponse=");
        r10.append(this.subscribeWsMsgByCallBackResponse);
    L21:
        if (this.subscribeWsMsgByBroadCastResponse == null) goto L24;
        r10.append(", subscribeWsMsgByBroadCastResponse=");
        r10.append(this.subscribeWsMsgByBroadCastResponse);
    L24:
        if (this.getLocationResponse == null) goto L27;
        r10.append(", getLocationResponse=");
        r10.append(this.getLocationResponse);
    L27:
        if (this.refreshLocationResponse == null) goto L30;
        r10.append(", refreshLocationResponse=");
        r10.append(this.refreshLocationResponse);
    L30:
        if (this.decodeLocationResponse == null) goto L33;
        r10.append(", decodeLocationResponse=");
        r10.append(this.decodeLocationResponse);
    L33:
        if (this.getIntersectFencesResponse == null) goto L36;
        r10.append(", getIntersectFencesResponse=");
        r10.append(this.getIntersectFencesResponse);
    L36:
        if (this.startPicoLinksResponse == null) goto L39;
        r10.append(", startPicoLinksResponse=");
        r10.append(this.startPicoLinksResponse);
    L39:
        if (this.onePartyCommonNetworkResponse == null) goto L42;
        r10.append(", onePartyCommonNetworkResponse=");
        r10.append(this.onePartyCommonNetworkResponse);
    L42:
        if (this.sendApplogEventResponse == null) goto L45;
        r10.append(", sendApplogEventResponse=");
        r10.append(this.sendApplogEventResponse);
    L45:
        if (this.genericNetworkResponse == null) goto L48;
        r10.append(", genericNetworkResponse=");
        r10.append(this.genericNetworkResponse);
    L48:
        if (this.getTTNetParametersResponse == null) goto L50;
        r10.append(", getTTNetParametersResponse=");
        r10.append(this.getTTNetParametersResponse);
    L50:
        StringBuilder r11 = r10.replace(0, 2, "ResponseBody{");
        r11.append('}');
        return r11.toString();
    }

    public ResponseBody(BizExampleResponse r10, SendWsMessageResponse r11, SubscribeWsMsgResponse r12, SubscribeWsStatusResponse r13, SubscribeWsMsgByProviderResponse r14, SubscribeWsMsgByCallBackResponse r15, SubscribeWsMsgByBroadCastResponse r16, GetLocationResponse r17, RefreshLocationResponse r18, DecodeLocationResponse r19, GetIntersectFencesResponse r110, StartPicoLinksResponse r111, OnePartyCommonNetworkResponse r112, SendApplogEventResponse r113, GenericNetworkResponse r114, GetTTNetParametersResponse r115, ByteString r20) {
        super(ADAPTER, r20);
        this.bizExampleResponse = r10;
        this.sendWsMessageResponse = r11;
        this.subscribeWsMsgResponse = r12;
        this.subscribeWsStatusResponse = r13;
        this.subscribeWsMsgByProviderResponse = r14;
        this.subscribeWsMsgByCallBackResponse = r15;
        this.subscribeWsMsgByBroadCastResponse = r16;
        this.getLocationResponse = r17;
        this.refreshLocationResponse = r18;
        this.decodeLocationResponse = r19;
        this.getIntersectFencesResponse = r110;
        this.startPicoLinksResponse = r111;
        this.onePartyCommonNetworkResponse = r112;
        this.sendApplogEventResponse = r113;
        this.genericNetworkResponse = r114;
        this.getTTNetParametersResponse = r115;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12108a = this.bizExampleResponse;
        r10.f12109b = this.sendWsMessageResponse;
        r10.f12110c = this.subscribeWsMsgResponse;
        r10.f12111d = this.subscribeWsStatusResponse;
        r10.f12112e = this.subscribeWsMsgByProviderResponse;
        r10.f12113f = this.subscribeWsMsgByCallBackResponse;
        r10.f12114g = this.subscribeWsMsgByBroadCastResponse;
        r10.f12115h = this.getLocationResponse;
        r10.f12116i = this.refreshLocationResponse;
        r10.f12117j = this.decodeLocationResponse;
        r10.f12118k = this.getIntersectFencesResponse;
        r10.f12119l = this.startPicoLinksResponse;
        r10.f12120m = this.onePartyCommonNetworkResponse;
        r10.f12121n = this.sendApplogEventResponse;
        r10.f12122o = this.genericNetworkResponse;
        r10.f12123p = this.getTTNetParametersResponse;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
