package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class WsMessageInfo extends Message<WsMessageInfo, Builder> {
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

    @SerializedName(EventConstants.EVENT_KEY_CMD)
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

    @SerializedName("payload")
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

    public static final class Builder extends Message.Builder<WsMessageInfo, Builder> {
        public Integer channelId;
        public Integer cmd;
        public Map<String, String> headers;
        public Long logId;
        public Integer method;
        public ByteString payload;
        public String payloadEncoding;
        public String payloadType;
        public Long seqId;
        public Integer service;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.seqId = 0L;
            this.logId = 0L;
            this.service = 0;
            this.method = 0;
            this.payloadType = "";
            this.payloadEncoding = "";
            this.payload = ByteString.EMPTY;
            this.cmd = 0;
            this.channelId = 0;
            this.headers = Internal.newMutableMap();
        }

        public Builder seqId(Long r1) {
            this.seqId = r1;
            return this;
        }

        public Builder logId(Long r1) {
            this.logId = r1;
            return this;
        }

        public Builder service(Integer r1) {
            this.service = r1;
            return this;
        }

        public Builder method(Integer r1) {
            this.method = r1;
            return this;
        }

        public Builder payloadType(String r1) {
            this.payloadType = r1;
            return this;
        }

        public Builder payloadEncoding(String r1) {
            this.payloadEncoding = r1;
            return this;
        }

        public Builder payload(ByteString r1) {
            this.payload = r1;
            return this;
        }

        public Builder cmd(Integer r1) {
            this.cmd = r1;
            return this;
        }

        public Builder channelId(Integer r1) {
            this.channelId = r1;
            return this;
        }

        public Builder headers(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.headers = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public WsMessageInfo build() {
            return new WsMessageInfo(this.seqId, this.logId, this.service, this.method, this.payloadType, this.payloadEncoding, this.payload, this.cmd, this.channelId, this.headers, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_WsMessageInfo extends ProtoAdapter<WsMessageInfo> {
        private final ProtoAdapter<Map<String, String>> headers;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WsMessageInfo decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, WsMessageInfo r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WsMessageInfo r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WsMessageInfo redact(WsMessageInfo r1) {
            return redact2(r1);
        }

        public ProtoAdapter_WsMessageInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, WsMessageInfo.class);
            this.headers = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WsMessageInfo r5) {
            return (((((((((ProtoAdapter.INT64.encodedSizeWithTag(1, r5.seqId) + ProtoAdapter.INT64.encodedSizeWithTag(2, r5.logId)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r5.service)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.method)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r5.payloadType)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r5.payloadEncoding)) + ProtoAdapter.BYTES.encodedSizeWithTag(8, r5.payload)) + ProtoAdapter.INT32.encodedSizeWithTag(9, r5.cmd)) + ProtoAdapter.INT32.encodedSizeWithTag(10, r5.channelId)) + this.headers.encodedSizeWithTag(11, r5.headers)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, WsMessageInfo r5) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.seqId);
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r5.logId);
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r5.service);
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r5.method);
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r5.payloadType);
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r5.payloadEncoding);
            ProtoAdapter.BYTES.encodeWithTag(r4, 8, r5.payload);
            ProtoAdapter.INT32.encodeWithTag(r4, 9, r5.cmd);
            ProtoAdapter.INT32.encodeWithTag(r4, 10, r5.channelId);
            this.headers.encodeWithTag(r4, 11, r5.headers);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WsMessageInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
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
            r0.headers.putAll(this.headers.decode(r7));
            goto L3
        L8:
            r0.channelId(ProtoAdapter.INT32.decode(r7));
            goto L3
        L9:
            r0.cmd(ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            r0.payload(ProtoAdapter.BYTES.decode(r7));
            goto L3
        L11:
            r0.payloadEncoding(ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.payloadType(ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.method(ProtoAdapter.INT32.decode(r7));
            goto L3
        L14:
            r0.service(ProtoAdapter.INT32.decode(r7));
            goto L3
        L15:
            r0.logId(ProtoAdapter.INT64.decode(r7));
            goto L3
        L16:
            r0.seqId(ProtoAdapter.INT64.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L17:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public WsMessageInfo redact2(WsMessageInfo r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_WsMessageInfo();
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

    public WsMessageInfo(Long r2, Long r3, Integer r4, Integer r5, String r6, String r7, ByteString r8, Integer r9, Integer r10, Map<String, String> r11, ByteString r12) {
        super(ADAPTER, r12);
        this.seqId = r2;
        this.logId = r3;
        this.service = r4;
        this.method = r5;
        this.payloadType = r6;
        this.payloadEncoding = r7;
        this.payload = r8;
        this.cmd = r9;
        this.channelId = r10;
        this.headers = Internal.immutableCopyOf("headers", r11);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.seqId = this.seqId;
        r0.logId = this.logId;
        r0.service = this.service;
        r0.method = this.method;
        r0.payloadType = this.payloadType;
        r0.payloadEncoding = this.payloadEncoding;
        r0.payload = this.payload;
        r0.cmd = this.cmd;
        r0.channelId = this.channelId;
        r0.headers = Internal.copyOf("headers", this.headers);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof WsMessageInfo) == true) goto L8;
        return false;
    L8:
        WsMessageInfo r6 = (WsMessageInfo) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L32;
        if (Internal.equals(this.seqId, r6.seqId) == false) goto L32;
        if (Internal.equals(this.logId, r6.logId) == false) goto L32;
        if (Internal.equals(this.service, r6.service) == false) goto L32;
        if (Internal.equals(this.method, r6.method) == false) goto L32;
        if (Internal.equals(this.payloadType, r6.payloadType) == false) goto L32;
        if (Internal.equals(this.payloadEncoding, r6.payloadEncoding) == false) goto L32;
        if (Internal.equals(this.payload, r6.payload) == false) goto L32;
        if (Internal.equals(this.cmd, r6.cmd) == false) goto L32;
        if (Internal.equals(this.channelId, r6.channelId) == false) goto L32;
        if (this.headers.equals(r6.headers) == false) goto L32;
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L41;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.seqId;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.logId;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.service;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.method;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.payloadType;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.payloadEncoding;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        ByteString r21 = this.payload;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        Integer r24 = this.cmd;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        Integer r27 = this.channelId;
        if (r27 == null) goto L39;
        r3 = r27.hashCode();
    L39:
        int r28 = ((r26 + r3) * 37) + this.headers.hashCode();
        this.hashCode = r28;
        return r28;
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
    L41:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.seqId == null) goto L6;
        r0.append(", seqId=").append(this.seqId);
    L6:
        if (this.logId == null) goto L9;
        r0.append(", logId=").append(this.logId);
    L9:
        if (this.service == null) goto L12;
        r0.append(", service=").append(this.service);
    L12:
        if (this.method == null) goto L15;
        r0.append(", method=").append(this.method);
    L15:
        if (this.payloadType == null) goto L18;
        r0.append(", payloadType=").append(this.payloadType);
    L18:
        if (this.payloadEncoding == null) goto L21;
        r0.append(", payloadEncoding=").append(this.payloadEncoding);
    L21:
        if (this.payload == null) goto L24;
        r0.append(", payload=").append(this.payload);
    L24:
        if (this.cmd == null) goto L27;
        r0.append(", cmd=").append(this.cmd);
    L27:
        if (this.channelId == null) goto L29;
        r0.append(", channelId=").append(this.channelId);
    L29:
        Map<String, String> r1 = this.headers;
        if (r1 == null) goto L35;
        if (r1.isEmpty() == true) goto L35;
        r0.append(", headers=").append(this.headers);
    L35:
        return r0.replace(0, 2, "WsMessageInfo{").append('}').toString();
    }
}
