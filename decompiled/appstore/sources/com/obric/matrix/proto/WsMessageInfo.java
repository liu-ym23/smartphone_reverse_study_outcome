package com.obric.matrix.proto;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class WsMessageInfo extends Message<WsMessageInfo, a> {
    public static final ProtoAdapter<WsMessageInfo> ADAPTER = null;
    public static final Integer DEFAULT_CHANNELID = null;
    public static final Integer DEFAULT_CMD = null;
    public static final Long DEFAULT_LOGID = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOADENCODING = "";
    public static final String DEFAULT_PAYLOADTYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("channelId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    public final Integer channelId;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer cmd;

    @SerializedName("headers")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final Map<String, String> headers;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long logId;

    @SerializedName("method")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer method;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

    @SerializedName("payloadEncoding")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payloadEncoding;

    @SerializedName("payloadType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payloadType;

    @SerializedName("seqId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long seqId;

    @SerializedName("service")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer service;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f12187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f12188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f12189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f12190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12191e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f12192f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ByteString f12193g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f12194h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f12195i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Map f12196j;

        public a() {
            this.f12187a = 0L;
            this.f12188b = 0L;
            this.f12189c = 0;
            this.f12190d = 0;
            this.f12191e = "";
            this.f12192f = "";
            this.f12193g = ByteString.EMPTY;
            this.f12194h = 0;
            this.f12195i = 0;
            this.f12196j = Internal.newMutableMap();
        }

        public WsMessageInfo a() {
            return new WsMessageInfo(this.f12187a, this.f12188b, this.f12189c, this.f12190d, this.f12191e, this.f12192f, this.f12193g, this.f12194h, this.f12195i, this.f12196j, super.buildUnknownFields());
        }

        public a b(Integer r10) {
            this.f12195i = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r10) {
            this.f12194h = r10;
            return this;
        }

        public a d(Long r10) {
            this.f12188b = r10;
            return this;
        }

        public a e(Integer r10) {
            this.f12190d = r10;
            return this;
        }

        public a f(ByteString r10) {
            this.f12193g = r10;
            return this;
        }

        public a g(String r10) {
            this.f12192f = r10;
            return this;
        }

        public a h(String r10) {
            this.f12191e = r10;
            return this;
        }

        public a i(Long r10) {
            this.f12187a = r10;
            return this;
        }

        public a j(Integer r10) {
            this.f12189c = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter f12197a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, WsMessageInfo.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f12197a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public WsMessageInfo a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L17;
            switch(r13) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L6;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r11.f12196j.putAll((Map) this.f12197a.decode(r10));
            goto L3
        L8:
            r11.b(ProtoAdapter.INT32.decode(r10));
            goto L3
        L9:
            r11.c(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            r11.f(ProtoAdapter.BYTES.decode(r10));
            goto L3
        L11:
            r11.g(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            r11.h(ProtoAdapter.STRING.decode(r10));
            goto L3
        L13:
            r11.e(ProtoAdapter.INT32.decode(r10));
            goto L3
        L14:
            r11.j(ProtoAdapter.INT32.decode(r10));
            goto L3
        L15:
            r11.d(ProtoAdapter.INT64.decode(r10));
            goto L3
        L16:
            r11.i(ProtoAdapter.INT64.decode(r10));
            goto L3
        L6:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L17:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, WsMessageInfo r11) {
            ProtoAdapter<Long> r12 = ProtoAdapter.INT64;
            r12.encodeWithTag(r10, 1, r11.seqId);
            r12.encodeWithTag(r10, 2, r11.logId);
            ProtoAdapter<Integer> r13 = ProtoAdapter.INT32;
            r13.encodeWithTag(r10, 3, r11.service);
            r13.encodeWithTag(r10, 4, r11.method);
            ProtoAdapter<String> r14 = ProtoAdapter.STRING;
            r14.encodeWithTag(r10, 6, r11.payloadType);
            r14.encodeWithTag(r10, 7, r11.payloadEncoding);
            ProtoAdapter.BYTES.encodeWithTag(r10, 8, r11.payload);
            r13.encodeWithTag(r10, 9, r11.cmd);
            r13.encodeWithTag(r10, 10, r11.channelId);
            this.f12197a.encodeWithTag(r10, 11, r11.headers);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(WsMessageInfo r10) {
            ProtoAdapter<Long> r11 = ProtoAdapter.INT64;
            int r12 = r11.encodedSizeWithTag(1, r10.seqId) + r11.encodedSizeWithTag(2, r10.logId);
            ProtoAdapter<Integer> r13 = ProtoAdapter.INT32;
            int r14 = (r12 + r13.encodedSizeWithTag(3, r10.service)) + r13.encodedSizeWithTag(4, r10.method);
            ProtoAdapter<String> r15 = ProtoAdapter.STRING;
            return ((((((r14 + r15.encodedSizeWithTag(6, r10.payloadType)) + r15.encodedSizeWithTag(7, r10.payloadEncoding)) + ProtoAdapter.BYTES.encodedSizeWithTag(8, r10.payload)) + r13.encodedSizeWithTag(9, r10.cmd)) + r13.encodedSizeWithTag(10, r10.channelId)) + this.f12197a.encodedSizeWithTag(11, r10.headers)) + r10.unknownFields().size();
        }

        public WsMessageInfo d(WsMessageInfo r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (WsMessageInfo) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((WsMessageInfo) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((WsMessageInfo) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_CMD = 0;
        DEFAULT_CHANNELID = 0;
    }

    public WsMessageInfo(Long r13, Long r14, Integer r15, Integer r16, String r17, String r18, ByteString r19, Integer r20, Integer r21, Map<String, String> r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof WsMessageInfo) == true) goto L8;
        return false;
    L8:
        WsMessageInfo r11 = (WsMessageInfo) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L32;
        if (Internal.equals(this.seqId, r11.seqId) == false) goto L32;
        if (Internal.equals(this.logId, r11.logId) == false) goto L32;
        if (Internal.equals(this.service, r11.service) == false) goto L32;
        if (Internal.equals(this.method, r11.method) == false) goto L32;
        if (Internal.equals(this.payloadType, r11.payloadType) == false) goto L32;
        if (Internal.equals(this.payloadEncoding, r11.payloadEncoding) == false) goto L32;
        if (Internal.equals(this.payload, r11.payload) == false) goto L32;
        if (Internal.equals(this.cmd, r11.cmd) == false) goto L32;
        if (Internal.equals(this.channelId, r11.channelId) == false) goto L32;
        if (this.headers.equals(r11.headers) == false) goto L32;
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L41;
        int r11 = unknownFields().hashCode() * 37;
        Long r12 = this.seqId;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Long r16 = this.logId;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        Integer r19 = this.service;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        Integer r22 = this.method;
        if (r22 == null) goto L19;
        int r23 = r22.hashCode();
    L20:
        int r24 = (r21 + r23) * 37;
        String r25 = this.payloadType;
        if (r25 == null) goto L23;
        int r26 = r25.hashCode();
    L24:
        int r27 = (r24 + r26) * 37;
        String r28 = this.payloadEncoding;
        if (r28 == null) goto L27;
        int r29 = r28.hashCode();
    L28:
        int r30 = (r27 + r29) * 37;
        ByteString r31 = this.payload;
        if (r31 == null) goto L31;
        int r32 = r31.hashCode();
    L32:
        int r33 = (r30 + r32) * 37;
        Integer r34 = this.cmd;
        if (r34 == null) goto L35;
        int r35 = r34.hashCode();
    L36:
        int r36 = (r33 + r35) * 37;
        Integer r37 = this.channelId;
        if (r37 == null) goto L39;
        r13 = r37.hashCode();
    L39:
        int r38 = ((r36 + r13) * 37) + this.headers.hashCode();
        this.hashCode = r38;
        return r38;
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
    L41:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.seqId == null) goto L6;
        r10.append(", seqId=");
        r10.append(this.seqId);
    L6:
        if (this.logId == null) goto L9;
        r10.append(", logId=");
        r10.append(this.logId);
    L9:
        if (this.service == null) goto L12;
        r10.append(", service=");
        r10.append(this.service);
    L12:
        if (this.method == null) goto L15;
        r10.append(", method=");
        r10.append(this.method);
    L15:
        if (this.payloadType == null) goto L18;
        r10.append(", payloadType=");
        r10.append(this.payloadType);
    L18:
        if (this.payloadEncoding == null) goto L21;
        r10.append(", payloadEncoding=");
        r10.append(this.payloadEncoding);
    L21:
        if (this.payload == null) goto L24;
        r10.append(", payload=");
        r10.append(this.payload);
    L24:
        if (this.cmd == null) goto L27;
        r10.append(", cmd=");
        r10.append(this.cmd);
    L27:
        if (this.channelId == null) goto L29;
        r10.append(", channelId=");
        r10.append(this.channelId);
    L29:
        Map<String, String> r11 = this.headers;
        if (r11 != null) goto L32;
    L34:
        StringBuilder r12 = r10.replace(0, 2, "WsMessageInfo{");
        r12.append('}');
        return r12.toString();
    L32:
        if (r11.isEmpty() == true) goto L34;
        r10.append(", headers=");
        r10.append(this.headers);
        goto L34
    }

    public WsMessageInfo(Long r10, Long r11, Integer r12, Integer r13, String r14, String r15, ByteString r16, Integer r17, Integer r18, Map<String, String> r19, ByteString r110) {
        super(ADAPTER, r110);
        this.seqId = r10;
        this.logId = r11;
        this.service = r12;
        this.method = r13;
        this.payloadType = r14;
        this.payloadEncoding = r15;
        this.payload = r16;
        this.cmd = r17;
        this.channelId = r18;
        this.headers = Internal.immutableCopyOf("headers", r19);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12187a = this.seqId;
        r10.f12188b = this.logId;
        r10.f12189c = this.service;
        r10.f12190d = this.method;
        r10.f12191e = this.payloadType;
        r10.f12192f = this.payloadEncoding;
        r10.f12193g = this.payload;
        r10.f12194h = this.cmd;
        r10.f12195i = this.channelId;
        r10.f12196j = Internal.copyOf("headers", this.headers);
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
