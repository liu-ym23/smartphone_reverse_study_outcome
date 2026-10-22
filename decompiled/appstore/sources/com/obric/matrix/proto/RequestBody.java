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
public final class RequestBody extends Message<RequestBody, a> {
    public static final ProtoAdapter<RequestBody> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("bizExampleRequest")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleRequest#ADAPTER", tag = 100000)
    public final BizExampleRequest bizExampleRequest;

    @SerializedName("decodeLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationRequest#ADAPTER", tag = 102003)
    public final DecodeLocationRequest decodeLocationRequest;

    @SerializedName("genericNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkRequest#ADAPTER", tag = 112003)
    public final GenericNetworkRequest genericNetworkRequest;

    @SerializedName("getIntersectFencesRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesRequest#ADAPTER", tag = 102004)
    public final GetIntersectFencesRequest getIntersectFencesRequest;

    @SerializedName("getLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationRequest#ADAPTER", tag = 102001)
    public final GetLocationRequest getLocationRequest;

    @SerializedName("getTTNetParametersRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersRequest#ADAPTER", tag = 112004)
    public final GetTTNetParametersRequest getTTNetParametersRequest;

    @SerializedName("onePartyCommonNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkRequest#ADAPTER", tag = 112001)
    public final OnePartyCommonNetworkRequest onePartyCommonNetworkRequest;

    @SerializedName("picoLinksCallback")
    @WireField(adapter = "com.obric.matrix.proto.PicoLinksCallback#ADAPTER", tag = 111002)
    public final PicoLinksCallback picoLinksCallback;

    @SerializedName("refreshLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationRequest#ADAPTER", tag = 102002)
    public final RefreshLocationRequest refreshLocationRequest;

    @SerializedName("sendApplogEventRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventRequest#ADAPTER", tag = 112002)
    public final SendApplogEventRequest sendApplogEventRequest;

    @SerializedName("sendWsMessageRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageRequest#ADAPTER", tag = 101001)
    public final SendWsMessageRequest sendWsMessageRequest;

    @SerializedName("startPicoLinksRequest")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest#ADAPTER", tag = 111001)
    public final StartPicoLinksRequest startPicoLinksRequest;

    @SerializedName("subscribeWsMsgByBroadCastRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastRequest#ADAPTER", tag = 101006)
    public final SubscribeWsMsgByBroadCastRequest subscribeWsMsgByBroadCastRequest;

    @SerializedName("subscribeWsMsgByCallBackRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackRequest#ADAPTER", tag = 101005)
    public final SubscribeWsMsgByCallBackRequest subscribeWsMsgByCallBackRequest;

    @SerializedName("subscribeWsMsgByProviderRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderRequest#ADAPTER", tag = 101004)
    public final SubscribeWsMsgByProviderRequest subscribeWsMsgByProviderRequest;

    @SerializedName("subscribeWsMsgRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgRequest#ADAPTER", tag = 101002)
    public final SubscribeWsMsgRequest subscribeWsMsgRequest;

    @SerializedName("subscribeWsStatusRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusRequest#ADAPTER", tag = 101003)
    public final SubscribeWsStatusRequest subscribeWsStatusRequest;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BizExampleRequest f12081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SendWsMessageRequest f12082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SubscribeWsMsgRequest f12083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public SubscribeWsStatusRequest f12084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public SubscribeWsMsgByProviderRequest f12085e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SubscribeWsMsgByCallBackRequest f12086f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SubscribeWsMsgByBroadCastRequest f12087g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public GetLocationRequest f12088h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RefreshLocationRequest f12089i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public DecodeLocationRequest f12090j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public GetIntersectFencesRequest f12091k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public StartPicoLinksRequest f12092l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public PicoLinksCallback f12093m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public OnePartyCommonNetworkRequest f12094n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public SendApplogEventRequest f12095o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public GenericNetworkRequest f12096p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public GetTTNetParametersRequest f12097q;

        public a() {
        }

        public a a(BizExampleRequest r10) {
            this.f12081a = r10;
            return this;
        }

        public RequestBody b() {
            return new RequestBody(this.f12081a, this.f12082b, this.f12083c, this.f12084d, this.f12085e, this.f12086f, this.f12087g, this.f12088h, this.f12089i, this.f12090j, this.f12091k, this.f12092l, this.f12093m, this.f12094n, this.f12095o, this.f12096p, this.f12097q, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(DecodeLocationRequest r10) {
            this.f12090j = r10;
            return this;
        }

        public a d(GenericNetworkRequest r10) {
            this.f12096p = r10;
            return this;
        }

        public a e(GetIntersectFencesRequest r10) {
            this.f12091k = r10;
            return this;
        }

        public a f(GetLocationRequest r10) {
            this.f12088h = r10;
            return this;
        }

        public a g(GetTTNetParametersRequest r10) {
            this.f12097q = r10;
            return this;
        }

        public a h(OnePartyCommonNetworkRequest r10) {
            this.f12094n = r10;
            return this;
        }

        public a i(PicoLinksCallback r10) {
            this.f12093m = r10;
            return this;
        }

        public a j(RefreshLocationRequest r10) {
            this.f12089i = r10;
            return this;
        }

        public a k(SendApplogEventRequest r10) {
            this.f12095o = r10;
            return this;
        }

        public a l(SendWsMessageRequest r10) {
            this.f12082b = r10;
            return this;
        }

        public a m(StartPicoLinksRequest r10) {
            this.f12092l = r10;
            return this;
        }

        public a n(SubscribeWsMsgByBroadCastRequest r10) {
            this.f12087g = r10;
            return this;
        }

        public a o(SubscribeWsMsgByCallBackRequest r10) {
            this.f12086f = r10;
            return this;
        }

        public a p(SubscribeWsMsgByProviderRequest r10) {
            this.f12085e = r10;
            return this;
        }

        public a q(SubscribeWsMsgRequest r10) {
            this.f12083c = r10;
            return this;
        }

        public a r(SubscribeWsStatusRequest r10) {
            this.f12084d = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, RequestBody.class);
        }

        public RequestBody a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L29;
            if (r13 != 100000) goto L7;
            r11.a(BizExampleRequest.ADAPTER.decode(r10));
            goto L3
        L7:
            switch(r13) {
                case 101001: goto L27;
                case 101002: goto L26;
                case 101003: goto L25;
                case 101004: goto L24;
                case 101005: goto L23;
                case 101006: goto L22;
                default: goto L8;
            };
        L22:
            r11.n(SubscribeWsMsgByBroadCastRequest.ADAPTER.decode(r10));
            goto L3
        L23:
            r11.o(SubscribeWsMsgByCallBackRequest.ADAPTER.decode(r10));
            goto L3
        L24:
            r11.p(SubscribeWsMsgByProviderRequest.ADAPTER.decode(r10));
            goto L3
        L25:
            r11.r(SubscribeWsStatusRequest.ADAPTER.decode(r10));
            goto L3
        L26:
            r11.q(SubscribeWsMsgRequest.ADAPTER.decode(r10));
            goto L3
        L27:
            r11.l(SendWsMessageRequest.ADAPTER.decode(r10));
            goto L3
        L8:
            switch(r13) {
                case 102001: goto L21;
                case 102002: goto L20;
                case 102003: goto L19;
                case 102004: goto L18;
                default: goto L9;
            };
        L18:
            r11.e(GetIntersectFencesRequest.ADAPTER.decode(r10));
            goto L3
        L19:
            r11.c(DecodeLocationRequest.ADAPTER.decode(r10));
            goto L3
        L20:
            r11.j(RefreshLocationRequest.ADAPTER.decode(r10));
            goto L3
        L21:
            r11.f(GetLocationRequest.ADAPTER.decode(r10));
            goto L3
        L9:
            switch(r13) {
                case 111001: goto L17;
                case 111002: goto L16;
                default: goto L10;
            };
        L16:
            r11.i(PicoLinksCallback.ADAPTER.decode(r10));
            goto L3
        L17:
            r11.m(StartPicoLinksRequest.ADAPTER.decode(r10));
            goto L3
        L10:
            switch(r13) {
                case 112001: goto L15;
                case 112002: goto L14;
                case 112003: goto L13;
                case 112004: goto L12;
                default: goto L11;
            };
        L12:
            r11.g(GetTTNetParametersRequest.ADAPTER.decode(r10));
            goto L3
        L13:
            r11.d(GenericNetworkRequest.ADAPTER.decode(r10));
            goto L3
        L14:
            r11.k(SendApplogEventRequest.ADAPTER.decode(r10));
            goto L3
        L15:
            r11.h(OnePartyCommonNetworkRequest.ADAPTER.decode(r10));
            goto L3
        L11:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L29:
            r10.endMessage(r12);
            return r11.b();
        }

        public void b(ProtoWriter r10, RequestBody r11) {
            BizExampleRequest.ADAPTER.encodeWithTag(r10, 100000, r11.bizExampleRequest);
            SendWsMessageRequest.ADAPTER.encodeWithTag(r10, 101001, r11.sendWsMessageRequest);
            SubscribeWsMsgRequest.ADAPTER.encodeWithTag(r10, 101002, r11.subscribeWsMsgRequest);
            SubscribeWsStatusRequest.ADAPTER.encodeWithTag(r10, 101003, r11.subscribeWsStatusRequest);
            SubscribeWsMsgByProviderRequest.ADAPTER.encodeWithTag(r10, 101004, r11.subscribeWsMsgByProviderRequest);
            SubscribeWsMsgByCallBackRequest.ADAPTER.encodeWithTag(r10, 101005, r11.subscribeWsMsgByCallBackRequest);
            SubscribeWsMsgByBroadCastRequest.ADAPTER.encodeWithTag(r10, 101006, r11.subscribeWsMsgByBroadCastRequest);
            GetLocationRequest.ADAPTER.encodeWithTag(r10, 102001, r11.getLocationRequest);
            RefreshLocationRequest.ADAPTER.encodeWithTag(r10, 102002, r11.refreshLocationRequest);
            DecodeLocationRequest.ADAPTER.encodeWithTag(r10, 102003, r11.decodeLocationRequest);
            GetIntersectFencesRequest.ADAPTER.encodeWithTag(r10, 102004, r11.getIntersectFencesRequest);
            StartPicoLinksRequest.ADAPTER.encodeWithTag(r10, 111001, r11.startPicoLinksRequest);
            PicoLinksCallback.ADAPTER.encodeWithTag(r10, 111002, r11.picoLinksCallback);
            OnePartyCommonNetworkRequest.ADAPTER.encodeWithTag(r10, 112001, r11.onePartyCommonNetworkRequest);
            SendApplogEventRequest.ADAPTER.encodeWithTag(r10, 112002, r11.sendApplogEventRequest);
            GenericNetworkRequest.ADAPTER.encodeWithTag(r10, 112003, r11.genericNetworkRequest);
            GetTTNetParametersRequest.ADAPTER.encodeWithTag(r10, 112004, r11.getTTNetParametersRequest);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(RequestBody r10) {
            return ((((((((((((((((BizExampleRequest.ADAPTER.encodedSizeWithTag(100000, r10.bizExampleRequest) + SendWsMessageRequest.ADAPTER.encodedSizeWithTag(101001, r10.sendWsMessageRequest)) + SubscribeWsMsgRequest.ADAPTER.encodedSizeWithTag(101002, r10.subscribeWsMsgRequest)) + SubscribeWsStatusRequest.ADAPTER.encodedSizeWithTag(101003, r10.subscribeWsStatusRequest)) + SubscribeWsMsgByProviderRequest.ADAPTER.encodedSizeWithTag(101004, r10.subscribeWsMsgByProviderRequest)) + SubscribeWsMsgByCallBackRequest.ADAPTER.encodedSizeWithTag(101005, r10.subscribeWsMsgByCallBackRequest)) + SubscribeWsMsgByBroadCastRequest.ADAPTER.encodedSizeWithTag(101006, r10.subscribeWsMsgByBroadCastRequest)) + GetLocationRequest.ADAPTER.encodedSizeWithTag(102001, r10.getLocationRequest)) + RefreshLocationRequest.ADAPTER.encodedSizeWithTag(102002, r10.refreshLocationRequest)) + DecodeLocationRequest.ADAPTER.encodedSizeWithTag(102003, r10.decodeLocationRequest)) + GetIntersectFencesRequest.ADAPTER.encodedSizeWithTag(102004, r10.getIntersectFencesRequest)) + StartPicoLinksRequest.ADAPTER.encodedSizeWithTag(111001, r10.startPicoLinksRequest)) + PicoLinksCallback.ADAPTER.encodedSizeWithTag(111002, r10.picoLinksCallback)) + OnePartyCommonNetworkRequest.ADAPTER.encodedSizeWithTag(112001, r10.onePartyCommonNetworkRequest)) + SendApplogEventRequest.ADAPTER.encodedSizeWithTag(112002, r10.sendApplogEventRequest)) + GenericNetworkRequest.ADAPTER.encodedSizeWithTag(112003, r10.genericNetworkRequest)) + GetTTNetParametersRequest.ADAPTER.encodedSizeWithTag(112004, r10.getTTNetParametersRequest)) + r10.unknownFields().size();
        }

        public RequestBody d(RequestBody r10) {
            a r11 = r10.newBuilder();
            BizExampleRequest r12 = r11.f12081a;
            if (r12 == null) goto L5;
            r11.f12081a = BizExampleRequest.ADAPTER.redact(r12);
        L5:
            SendWsMessageRequest r13 = r11.f12082b;
            if (r13 == null) goto L8;
            r11.f12082b = SendWsMessageRequest.ADAPTER.redact(r13);
        L8:
            SubscribeWsMsgRequest r14 = r11.f12083c;
            if (r14 == null) goto L11;
            r11.f12083c = SubscribeWsMsgRequest.ADAPTER.redact(r14);
        L11:
            SubscribeWsStatusRequest r15 = r11.f12084d;
            if (r15 == null) goto L14;
            r11.f12084d = SubscribeWsStatusRequest.ADAPTER.redact(r15);
        L14:
            SubscribeWsMsgByProviderRequest r16 = r11.f12085e;
            if (r16 == null) goto L17;
            r11.f12085e = SubscribeWsMsgByProviderRequest.ADAPTER.redact(r16);
        L17:
            SubscribeWsMsgByCallBackRequest r17 = r11.f12086f;
            if (r17 == null) goto L20;
            r11.f12086f = SubscribeWsMsgByCallBackRequest.ADAPTER.redact(r17);
        L20:
            SubscribeWsMsgByBroadCastRequest r18 = r11.f12087g;
            if (r18 == null) goto L23;
            r11.f12087g = SubscribeWsMsgByBroadCastRequest.ADAPTER.redact(r18);
        L23:
            GetLocationRequest r19 = r11.f12088h;
            if (r19 == null) goto L26;
            r11.f12088h = GetLocationRequest.ADAPTER.redact(r19);
        L26:
            RefreshLocationRequest r20 = r11.f12089i;
            if (r20 == null) goto L29;
            r11.f12089i = RefreshLocationRequest.ADAPTER.redact(r20);
        L29:
            DecodeLocationRequest r21 = r11.f12090j;
            if (r21 == null) goto L32;
            r11.f12090j = DecodeLocationRequest.ADAPTER.redact(r21);
        L32:
            GetIntersectFencesRequest r22 = r11.f12091k;
            if (r22 == null) goto L35;
            r11.f12091k = GetIntersectFencesRequest.ADAPTER.redact(r22);
        L35:
            StartPicoLinksRequest r23 = r11.f12092l;
            if (r23 == null) goto L38;
            r11.f12092l = StartPicoLinksRequest.ADAPTER.redact(r23);
        L38:
            PicoLinksCallback r24 = r11.f12093m;
            if (r24 == null) goto L41;
            r11.f12093m = PicoLinksCallback.ADAPTER.redact(r24);
        L41:
            OnePartyCommonNetworkRequest r25 = r11.f12094n;
            if (r25 == null) goto L44;
            r11.f12094n = OnePartyCommonNetworkRequest.ADAPTER.redact(r25);
        L44:
            SendApplogEventRequest r26 = r11.f12095o;
            if (r26 == null) goto L47;
            r11.f12095o = SendApplogEventRequest.ADAPTER.redact(r26);
        L47:
            GenericNetworkRequest r27 = r11.f12096p;
            if (r27 == null) goto L50;
            r11.f12096p = GenericNetworkRequest.ADAPTER.redact(r27);
        L50:
            GetTTNetParametersRequest r28 = r11.f12097q;
            if (r28 == null) goto L53;
            r11.f12097q = GetTTNetParametersRequest.ADAPTER.redact(r28);
        L53:
            r11.clearUnknownFields();
            return r11.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (RequestBody) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((RequestBody) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((RequestBody) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public RequestBody(BizExampleRequest r20, SendWsMessageRequest r21, SubscribeWsMsgRequest r22, SubscribeWsStatusRequest r23, SubscribeWsMsgByProviderRequest r24, SubscribeWsMsgByCallBackRequest r25, SubscribeWsMsgByBroadCastRequest r26, GetLocationRequest r27, RefreshLocationRequest r28, DecodeLocationRequest r29, GetIntersectFencesRequest r30, StartPicoLinksRequest r31, PicoLinksCallback r32, OnePartyCommonNetworkRequest r33, SendApplogEventRequest r34, GenericNetworkRequest r35, GetTTNetParametersRequest r36) {
        this(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof RequestBody) == true) goto L8;
        return false;
    L8:
        RequestBody r11 = (RequestBody) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L46;
        if (Internal.equals(this.bizExampleRequest, r11.bizExampleRequest) == false) goto L46;
        if (Internal.equals(this.sendWsMessageRequest, r11.sendWsMessageRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgRequest, r11.subscribeWsMsgRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsStatusRequest, r11.subscribeWsStatusRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByProviderRequest, r11.subscribeWsMsgByProviderRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByCallBackRequest, r11.subscribeWsMsgByCallBackRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByBroadCastRequest, r11.subscribeWsMsgByBroadCastRequest) == false) goto L46;
        if (Internal.equals(this.getLocationRequest, r11.getLocationRequest) == false) goto L46;
        if (Internal.equals(this.refreshLocationRequest, r11.refreshLocationRequest) == false) goto L46;
        if (Internal.equals(this.decodeLocationRequest, r11.decodeLocationRequest) == false) goto L46;
        if (Internal.equals(this.getIntersectFencesRequest, r11.getIntersectFencesRequest) == false) goto L46;
        if (Internal.equals(this.startPicoLinksRequest, r11.startPicoLinksRequest) == false) goto L46;
        if (Internal.equals(this.picoLinksCallback, r11.picoLinksCallback) == false) goto L46;
        if (Internal.equals(this.onePartyCommonNetworkRequest, r11.onePartyCommonNetworkRequest) == false) goto L46;
        if (Internal.equals(this.sendApplogEventRequest, r11.sendApplogEventRequest) == false) goto L46;
        if (Internal.equals(this.genericNetworkRequest, r11.genericNetworkRequest) == false) goto L46;
        if (Internal.equals(this.getTTNetParametersRequest, r11.getTTNetParametersRequest) == false) goto L46;
        return true;
    L46:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L73;
        int r11 = unknownFields().hashCode() * 37;
        BizExampleRequest r12 = this.bizExampleRequest;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        SendWsMessageRequest r16 = this.sendWsMessageRequest;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        SubscribeWsMsgRequest r19 = this.subscribeWsMsgRequest;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        SubscribeWsStatusRequest r22 = this.subscribeWsStatusRequest;
        if (r22 == null) goto L19;
        int r23 = r22.hashCode();
    L20:
        int r24 = (r21 + r23) * 37;
        SubscribeWsMsgByProviderRequest r25 = this.subscribeWsMsgByProviderRequest;
        if (r25 == null) goto L23;
        int r26 = r25.hashCode();
    L24:
        int r27 = (r24 + r26) * 37;
        SubscribeWsMsgByCallBackRequest r28 = this.subscribeWsMsgByCallBackRequest;
        if (r28 == null) goto L27;
        int r29 = r28.hashCode();
    L28:
        int r30 = (r27 + r29) * 37;
        SubscribeWsMsgByBroadCastRequest r31 = this.subscribeWsMsgByBroadCastRequest;
        if (r31 == null) goto L31;
        int r32 = r31.hashCode();
    L32:
        int r33 = (r30 + r32) * 37;
        GetLocationRequest r34 = this.getLocationRequest;
        if (r34 == null) goto L35;
        int r35 = r34.hashCode();
    L36:
        int r36 = (r33 + r35) * 37;
        RefreshLocationRequest r37 = this.refreshLocationRequest;
        if (r37 == null) goto L39;
        int r38 = r37.hashCode();
    L40:
        int r39 = (r36 + r38) * 37;
        DecodeLocationRequest r40 = this.decodeLocationRequest;
        if (r40 == null) goto L43;
        int r41 = r40.hashCode();
    L44:
        int r42 = (r39 + r41) * 37;
        GetIntersectFencesRequest r43 = this.getIntersectFencesRequest;
        if (r43 == null) goto L47;
        int r44 = r43.hashCode();
    L48:
        int r45 = (r42 + r44) * 37;
        StartPicoLinksRequest r46 = this.startPicoLinksRequest;
        if (r46 == null) goto L51;
        int r47 = r46.hashCode();
    L52:
        int r48 = (r45 + r47) * 37;
        PicoLinksCallback r49 = this.picoLinksCallback;
        if (r49 == null) goto L55;
        int r50 = r49.hashCode();
    L56:
        int r51 = (r48 + r50) * 37;
        OnePartyCommonNetworkRequest r52 = this.onePartyCommonNetworkRequest;
        if (r52 == null) goto L59;
        int r53 = r52.hashCode();
    L60:
        int r54 = (r51 + r53) * 37;
        SendApplogEventRequest r55 = this.sendApplogEventRequest;
        if (r55 == null) goto L63;
        int r56 = r55.hashCode();
    L64:
        int r57 = (r54 + r56) * 37;
        GenericNetworkRequest r58 = this.genericNetworkRequest;
        if (r58 == null) goto L67;
        int r59 = r58.hashCode();
    L68:
        int r60 = (r57 + r59) * 37;
        GetTTNetParametersRequest r61 = this.getTTNetParametersRequest;
        if (r61 == null) goto L71;
        r13 = r61.hashCode();
    L71:
        int r62 = r60 + r13;
        this.hashCode = r62;
        return r62;
    L67:
        r59 = 0;
        goto L68
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
    L73:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.bizExampleRequest == null) goto L6;
        r10.append(", bizExampleRequest=");
        r10.append(this.bizExampleRequest);
    L6:
        if (this.sendWsMessageRequest == null) goto L9;
        r10.append(", sendWsMessageRequest=");
        r10.append(this.sendWsMessageRequest);
    L9:
        if (this.subscribeWsMsgRequest == null) goto L12;
        r10.append(", subscribeWsMsgRequest=");
        r10.append(this.subscribeWsMsgRequest);
    L12:
        if (this.subscribeWsStatusRequest == null) goto L15;
        r10.append(", subscribeWsStatusRequest=");
        r10.append(this.subscribeWsStatusRequest);
    L15:
        if (this.subscribeWsMsgByProviderRequest == null) goto L18;
        r10.append(", subscribeWsMsgByProviderRequest=");
        r10.append(this.subscribeWsMsgByProviderRequest);
    L18:
        if (this.subscribeWsMsgByCallBackRequest == null) goto L21;
        r10.append(", subscribeWsMsgByCallBackRequest=");
        r10.append(this.subscribeWsMsgByCallBackRequest);
    L21:
        if (this.subscribeWsMsgByBroadCastRequest == null) goto L24;
        r10.append(", subscribeWsMsgByBroadCastRequest=");
        r10.append(this.subscribeWsMsgByBroadCastRequest);
    L24:
        if (this.getLocationRequest == null) goto L27;
        r10.append(", getLocationRequest=");
        r10.append(this.getLocationRequest);
    L27:
        if (this.refreshLocationRequest == null) goto L30;
        r10.append(", refreshLocationRequest=");
        r10.append(this.refreshLocationRequest);
    L30:
        if (this.decodeLocationRequest == null) goto L33;
        r10.append(", decodeLocationRequest=");
        r10.append(this.decodeLocationRequest);
    L33:
        if (this.getIntersectFencesRequest == null) goto L36;
        r10.append(", getIntersectFencesRequest=");
        r10.append(this.getIntersectFencesRequest);
    L36:
        if (this.startPicoLinksRequest == null) goto L39;
        r10.append(", startPicoLinksRequest=");
        r10.append(this.startPicoLinksRequest);
    L39:
        if (this.picoLinksCallback == null) goto L42;
        r10.append(", picoLinksCallback=");
        r10.append(this.picoLinksCallback);
    L42:
        if (this.onePartyCommonNetworkRequest == null) goto L45;
        r10.append(", onePartyCommonNetworkRequest=");
        r10.append(this.onePartyCommonNetworkRequest);
    L45:
        if (this.sendApplogEventRequest == null) goto L48;
        r10.append(", sendApplogEventRequest=");
        r10.append(this.sendApplogEventRequest);
    L48:
        if (this.genericNetworkRequest == null) goto L51;
        r10.append(", genericNetworkRequest=");
        r10.append(this.genericNetworkRequest);
    L51:
        if (this.getTTNetParametersRequest == null) goto L53;
        r10.append(", getTTNetParametersRequest=");
        r10.append(this.getTTNetParametersRequest);
    L53:
        StringBuilder r11 = r10.replace(0, 2, "RequestBody{");
        r11.append('}');
        return r11.toString();
    }

    public RequestBody(BizExampleRequest r10, SendWsMessageRequest r11, SubscribeWsMsgRequest r12, SubscribeWsStatusRequest r13, SubscribeWsMsgByProviderRequest r14, SubscribeWsMsgByCallBackRequest r15, SubscribeWsMsgByBroadCastRequest r16, GetLocationRequest r17, RefreshLocationRequest r18, DecodeLocationRequest r19, GetIntersectFencesRequest r110, StartPicoLinksRequest r111, PicoLinksCallback r112, OnePartyCommonNetworkRequest r113, SendApplogEventRequest r114, GenericNetworkRequest r115, GetTTNetParametersRequest r20, ByteString r21) {
        super(ADAPTER, r21);
        this.bizExampleRequest = r10;
        this.sendWsMessageRequest = r11;
        this.subscribeWsMsgRequest = r12;
        this.subscribeWsStatusRequest = r13;
        this.subscribeWsMsgByProviderRequest = r14;
        this.subscribeWsMsgByCallBackRequest = r15;
        this.subscribeWsMsgByBroadCastRequest = r16;
        this.getLocationRequest = r17;
        this.refreshLocationRequest = r18;
        this.decodeLocationRequest = r19;
        this.getIntersectFencesRequest = r110;
        this.startPicoLinksRequest = r111;
        this.picoLinksCallback = r112;
        this.onePartyCommonNetworkRequest = r113;
        this.sendApplogEventRequest = r114;
        this.genericNetworkRequest = r115;
        this.getTTNetParametersRequest = r20;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12081a = this.bizExampleRequest;
        r10.f12082b = this.sendWsMessageRequest;
        r10.f12083c = this.subscribeWsMsgRequest;
        r10.f12084d = this.subscribeWsStatusRequest;
        r10.f12085e = this.subscribeWsMsgByProviderRequest;
        r10.f12086f = this.subscribeWsMsgByCallBackRequest;
        r10.f12087g = this.subscribeWsMsgByBroadCastRequest;
        r10.f12088h = this.getLocationRequest;
        r10.f12089i = this.refreshLocationRequest;
        r10.f12090j = this.decodeLocationRequest;
        r10.f12091k = this.getIntersectFencesRequest;
        r10.f12092l = this.startPicoLinksRequest;
        r10.f12093m = this.picoLinksCallback;
        r10.f12094n = this.onePartyCommonNetworkRequest;
        r10.f12095o = this.sendApplogEventRequest;
        r10.f12096p = this.genericNetworkRequest;
        r10.f12097q = this.getTTNetParametersRequest;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
