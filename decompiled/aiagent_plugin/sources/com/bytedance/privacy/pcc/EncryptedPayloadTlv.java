package com.bytedance.privacy.pcc;

import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EncryptedPayloadTlv {
    private static final Gson GSON = null;
    private static final int TAG_BIZ_ACCESS_TOKEN = 5;
    private static final int TAG_BIZ_APP_ID = 1;
    private static final int TAG_BIZ_ATTRIBUTE = 259;
    private static final int TAG_BIZ_SERVICE_ID = 2;
    private static final int TAG_BIZ_SESSION_KEY_ID = 4;
    private static final int TAG_BIZ_TYPE = 3;
    private static final int TAG_CIM_CONTENT_TYPE = 769;
    private static final int TAG_CIM_ENC_ALG = 770;
    private static final int TAG_CONTENT_INFO_META = 768;
    private static final int TAG_ENV_DH_PK = 4;
    private static final int TAG_ENV_ENC_SESSION_KEY = 6;
    private static final int TAG_ENV_KEY_ENC_ALG = 3;
    private static final int TAG_ENV_KEY_IDENTIFY = 1;
    private static final int TAG_ENV_KEY_VERSION = 2;
    private static final int TAG_ENV_LIST = 516;
    private static final int TAG_ENV_LIST_SIZE = 515;
    private static final int TAG_ENV_SALT = 5;
    private static final int TAG_ENV_TYPE = 514;
    private static final int TAG_ENV_VERSION = 513;
    private static final int TAG_KEY_ENVELOPE = 512;
    private static final int TAG_META_CONTENT_TYPE = 258;
    private static final int TAG_META_INFO = 256;
    private static final int TAG_META_VERSION = 257;
    private static final int TAG_OKA_CHUNK_SIZE = 2;
    private static final int TAG_OKA_NONCE = 1;
    private static final int TAG_OTHER_KEY_ATTR = 771;
    private static final int TAG_SIGN_ALG = 1025;
    private static final int TAG_SIGN_CONTENT_INFO = 1024;
    private static final int TAG_SIGN_CONTENT_SIG = 1026;

    @SerializedName("content_info_meta")
    public ContentInfoMeta contentInfoMeta;

    @SerializedName("key_envelope")
    public KeyEnvelopePayload keyEnvelopePayload;

    @SerializedName("meta_info")
    public MetaInfo metaInfo;

    @SerializedName("sign_content_info")
    public SignContentInfo signContentInfo;

    /* JADX INFO: renamed from: com.bytedance.privacy.pcc.EncryptedPayloadTlv$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class BizAttribute {

        @SerializedName("access_token")
        public byte[] accessToken;

        @SerializedName("app_id")
        public String appId;

        @SerializedName("biz_type")
        public int bizType;

        @SerializedName("app_svc_id")
        public String serviceId;

        @SerializedName("session_key_id")
        public byte[] sessionKeyId;

        public BizAttribute() {
        }
    }

    private static final class ByteArrayBase64Adapter implements JsonDeserializer<byte[]>, JsonSerializer<byte[]> {
        private ByteArrayBase64Adapter() {
        }

        /* synthetic */ ByteArrayBase64Adapter(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.gson.JsonDeserializer
        public /* synthetic */ byte[] deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
            return deserialize2(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.gson.JsonSerializer
        public /* synthetic */ JsonElement serialize(byte[] r3, Type r4, JsonSerializationContext r5) {
            Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
            JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.aiagent.plugin");
            return serialize2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"), r6, r7);
        }

        /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
        public JsonElement serialize2(byte[] r2, Type r3, JsonSerializationContext r4) {
            Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
            JsonSerializationContext r5 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonSerializationContext.class, "com.obric.aiagent.plugin");
            return new JsonPrimitive(Base64.encodeToString(r2, 2));
        }

        @Override // com.google.gson.JsonDeserializer
        /* JADX INFO: renamed from: deserialize, reason: avoid collision after fix types in other method */
        public byte[] deserialize2(JsonElement r2, Type r3, JsonDeserializationContext r4) {
            Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
            JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.aiagent.plugin");
            return Base64.decode(r2.getAsString(), 0);
        }
    }

    public static class ContentInfoMeta {

        @SerializedName("content_encryption_algorithm")
        public int contentEncryptionAlgorithm;

        @SerializedName(MonitorConstants.EXTRA_CONTENT_TYPE)
        public int contentType;

        @SerializedName("other_key_attribute")
        public OtherKeyAttribute otherKeyAttribute;

        public ContentInfoMeta() {
        }
    }

    public static class KeyEnvelope {

        @SerializedName("dh_pk")
        public byte[] dhPK;

        @SerializedName("encrypted_session_key")
        public byte[] encryptedSessionKey;

        @SerializedName("index")
        public int index;

        @SerializedName("key_encryption_algorithm")
        public int keyEncryptionAlgorithm;

        @SerializedName("key_identify")
        public byte[] keyIdentify;

        @SerializedName("key_version")
        public int keyVersion;

        @SerializedName("salt")
        public byte[] salt;

        public KeyEnvelope() {
        }
    }

    public static class KeyEnvelopePayload {

        @SerializedName("envelope_type")
        public int envelopeType;

        @SerializedName("key_envelope_list")
        public List<KeyEnvelope> keyEnvelopeList;

        @SerializedName("key_envelope_list_size")
        public int keyEnvelopeListSize;

        @SerializedName("version")
        public int version;

        public KeyEnvelopePayload() {
        }
    }

    public static class MetaInfo {

        @SerializedName("biz_attribute")
        public BizAttribute bizAttribute;

        @SerializedName(MonitorConstants.EXTRA_CONTENT_TYPE)
        public int contentType;

        @SerializedName("version")
        public int version;

        public MetaInfo() {
        }
    }

    public static class OtherKeyAttribute {

        @SerializedName("chunk_size")
        public int chunkSize;

        @SerializedName("nonce")
        public byte[] nonce;

        public OtherKeyAttribute() {
        }
    }

    public static class SignContentInfo {

        @SerializedName("content_signature")
        public byte[] contentSignature;

        @SerializedName("signature_algorithm")
        public int signatureAlgorithm;

        public SignContentInfo() {
        }
    }

    private static final class TlvReader {
        private final byte[] data;
        private int pos;

        TlvReader(byte[] r1) {
            this.data = r1;
            this.pos = 0;
        }

        boolean hasMore() {
            if (this.pos >= this.data.length) goto L5;
            return true;
        L5:
            return false;
        }

        int position() {
            return this.pos;
        }

        int readTag() {
            int r0 = this.pos;
            int r1 = r0 + 2;
            byte[] r2 = this.data;
            if (r1 > r2.length) goto L7;
            int r3 = ((r2[r0] & 255) << 8) | (r2[r0 + 1] & 255);
            this.pos = r0 + 2;
            return r3;
        L7:
            throw new Exception("TLV underflow reading tag at offset " + this.pos);
        }

        int readLength() {
            int r0 = this.pos;
            int r1 = r0 + 4;
            byte[] r2 = this.data;
            if (r1 > r2.length) goto L11;
            int r3 = ((((r2[r0] & 255) << 24) | ((r2[r0 + 1] & 255) << 16)) | ((r2[r0 + 2] & 255) << 8)) | (r2[r0 + 3] & 255);
            if (r3 < 0) goto L9;
            this.pos = r0 + 4;
            return r3;
        L9:
            throw new Exception("TLV length overflow at offset " + this.pos);
        L11:
            throw new Exception("TLV underflow reading length at offset " + this.pos);
        }

        byte[] readValue(int r5) {
            int r0 = this.pos;
            int r1 = r0 + r5;
            byte[] r2 = this.data;
            if (r1 > r2.length) goto L7;
            byte[] r3 = new byte[r5];
            System.arraycopy(r2, r0, r3, 0, r5);
            this.pos += r5;
            return r3;
        L7:
            throw new Exception("TLV underflow reading value: need " + r5 + " bytes at offset " + this.pos + " but only " + (this.data.length - this.pos) + " remain");
        }
    }

    private static final class TlvWriter {
        private final ByteArrayOutputStream buf;

        private TlvWriter() {
            this.buf = new ByteArrayOutputStream();
        }

        /* synthetic */ TlvWriter(AnonymousClass1 r1) {
            this();
        }

        private void writeTag(int r3) {
            this.buf.write((r3 >> 8) & 255);
            this.buf.write(r3 & 255);
        }

        private void writeLength(int r3) {
            this.buf.write((r3 >> 24) & 255);
            this.buf.write((r3 >> 16) & 255);
            this.buf.write((r3 >> 8) & 255);
            this.buf.write(r3 & 255);
        }

        void writeBytes(int r2, byte[] r3) {
            writeTag(r2);
            writeLength(r3.length);
            this.buf.write(r3, 0, r3.length);
        }

        void writeContainer(int r2, byte[] r3) {
            writeTag(r2);
            writeLength(r3.length);
            this.buf.write(r3, 0, r3.length);
        }

        void writeUint16(int r2, int r3) {
            writeTag(r2);
            writeLength(2);
            this.buf.write((r3 >> 8) & 255);
            this.buf.write(r3 & 255);
        }

        void writeUint32(int r2, int r3) {
            writeTag(r2);
            writeLength(4);
            this.buf.write((r3 >> 24) & 255);
            this.buf.write((r3 >> 16) & 255);
            this.buf.write((r3 >> 8) & 255);
            this.buf.write(r3 & 255);
        }

        byte[] toBytes() {
            return this.buf.toByteArray();
        }
    }

    public EncryptedPayloadTlv() {
    }

    static {
        GSON = new GsonBuilder().registerTypeHierarchyAdapter(byte[].class, new ByteArrayBase64Adapter(null)).setPrettyPrinting().create();
    }

    public String toJsonString() {
        return GSON.toJson(this);
    }

    public static EncryptedPayloadTlv fromJsonString(String r2) {
        return (EncryptedPayloadTlv) ZeusTransformUtils.preCheckCast(GSON.fromJson(r2, EncryptedPayloadTlv.class), EncryptedPayloadTlv.class, "com.obric.aiagent.plugin");
    }

    public byte[] encode() {
        TlvWriter r0 = new TlvWriter(null);
        MetaInfo r1 = this.metaInfo;
        if (r1 == null) goto L5;
        r0.writeContainer(256, encodeMetaInfo(r1));
    L5:
        KeyEnvelopePayload r2 = this.keyEnvelopePayload;
        if (r2 == null) goto L8;
        r0.writeContainer(512, encodeKeyEnvelopePayload(r2));
    L8:
        ContentInfoMeta r3 = this.contentInfoMeta;
        if (r3 == null) goto L11;
        r0.writeContainer(TAG_CONTENT_INFO_META, encodeContentInfoMeta(r3));
    L11:
        SignContentInfo r4 = this.signContentInfo;
        if (r4 == null) goto L15;
        r0.writeContainer(1024, encodeSignContentInfo(r4));
    L15:
        return r0.toBytes();
    }

    public byte[] encodeSignedPortion() {
        TlvWriter r0 = new TlvWriter(null);
        MetaInfo r1 = this.metaInfo;
        if (r1 == null) goto L5;
        r0.writeContainer(256, encodeMetaInfo(r1));
    L5:
        KeyEnvelopePayload r2 = this.keyEnvelopePayload;
        if (r2 == null) goto L8;
        r0.writeContainer(512, encodeKeyEnvelopePayload(r2));
    L8:
        ContentInfoMeta r3 = this.contentInfoMeta;
        if (r3 == null) goto L12;
        r0.writeContainer(TAG_CONTENT_INFO_META, encodeContentInfoMeta(r3));
    L12:
        return r0.toBytes();
    }

    private static byte[] encodeMetaInfo(MetaInfo r3) {
        TlvWriter r0 = new TlvWriter(null);
        r0.writeUint16(TAG_META_VERSION, r3.version);
        r0.writeUint16(TAG_META_CONTENT_TYPE, r3.contentType);
        if (r3.bizAttribute == null) goto L6;
        r0.writeContainer(TAG_BIZ_ATTRIBUTE, encodeBizAttribute(r3.bizAttribute));
    L6:
        return r0.toBytes();
    }

    private static byte[] encodeBizAttribute(BizAttribute r4) {
        TlvWriter r0 = new TlvWriter(null);
        if (r4.appId == null) goto L6;
        r0.writeBytes(1, r4.appId.getBytes(StandardCharsets.UTF_8));
    L6:
        if (r4.serviceId == null) goto L8;
        r0.writeBytes(2, r4.serviceId.getBytes(StandardCharsets.UTF_8));
    L8:
        r0.writeUint16(3, r4.bizType);
        if (r4.sessionKeyId == null) goto L12;
        r0.writeBytes(4, r4.sessionKeyId);
    L12:
        if (r4.accessToken == null) goto L15;
        r0.writeBytes(5, r4.accessToken);
    L15:
        return r0.toBytes();
    }

    private static byte[] encodeKeyEnvelopePayload(KeyEnvelopePayload r5) {
        AnonymousClass1 r1 = null;
        TlvWriter r0 = new TlvWriter(r1);
        r0.writeUint16(TAG_ENV_VERSION, r5.version);
        r0.writeUint16(TAG_ENV_TYPE, r5.envelopeType);
        r0.writeUint32(TAG_ENV_LIST_SIZE, r5.keyEnvelopeListSize);
        if (r5.keyEnvelopeList == null) goto L12;
        if (r5.keyEnvelopeList.isEmpty() == true) goto L12;
        TlvWriter r2 = new TlvWriter(r1);
        Iterator<KeyEnvelope> r6 = r5.keyEnvelopeList.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        KeyEnvelope r3 = (KeyEnvelope) ZeusTransformUtils.preCheckCast(r6.next(), KeyEnvelope.class, "com.obric.aiagent.plugin");
        r2.writeContainer(r3.index, encodeKeyEnvelope(r3));
        goto L8
    L10:
        r0.writeContainer(TAG_ENV_LIST, r2.toBytes());
    L12:
        return r0.toBytes();
    }

    private static byte[] encodeKeyEnvelope(KeyEnvelope r3) {
        TlvWriter r0 = new TlvWriter(null);
        if (r3.keyIdentify == null) goto L5;
        r0.writeBytes(1, r3.keyIdentify);
    L5:
        r0.writeUint32(2, r3.keyVersion);
        r0.writeUint16(3, r3.keyEncryptionAlgorithm);
        if (r3.dhPK == null) goto L9;
        r0.writeBytes(4, r3.dhPK);
    L9:
        if (r3.salt == null) goto L12;
        r0.writeBytes(5, r3.salt);
    L12:
        if (r3.encryptedSessionKey == null) goto L15;
        r0.writeBytes(6, r3.encryptedSessionKey);
    L15:
        return r0.toBytes();
    }

    private static byte[] encodeContentInfoMeta(ContentInfoMeta r3) {
        TlvWriter r0 = new TlvWriter(null);
        r0.writeUint16(TAG_CIM_CONTENT_TYPE, r3.contentType);
        r0.writeUint16(TAG_CIM_ENC_ALG, r3.contentEncryptionAlgorithm);
        if (r3.otherKeyAttribute == null) goto L6;
        r0.writeContainer(TAG_OTHER_KEY_ATTR, encodeOtherKeyAttribute(r3.otherKeyAttribute));
    L6:
        return r0.toBytes();
    }

    private static byte[] encodeOtherKeyAttribute(OtherKeyAttribute r3) {
        TlvWriter r0 = new TlvWriter(null);
        if (r3.nonce == null) goto L6;
        r0.writeBytes(1, r3.nonce);
    L6:
        if (r3.chunkSize <= 0) goto L9;
        r0.writeUint32(2, r3.chunkSize);
    L9:
        return r0.toBytes();
    }

    private static byte[] encodeSignContentInfo(SignContentInfo r3) {
        TlvWriter r0 = new TlvWriter(null);
        r0.writeUint16(1025, r3.signatureAlgorithm);
        if (r3.contentSignature == null) goto L6;
        r0.writeBytes(1026, r3.contentSignature);
    L6:
        return r0.toBytes();
    }

    public static EncryptedPayloadTlv decode(byte[] r4) {
        EncryptedPayloadTlv r0 = new EncryptedPayloadTlv();
        TlvReader r1 = new TlvReader(r4);
    L4:
        if (r1.hasMore() == false) goto L18;
        int r5 = r1.readTag();
        byte[] r2 = r1.readValue(r1.readLength());
        r1.position();
        if (r5 != 256) goto L8;
        r0.metaInfo = decodeMetaInfo(r2);
        goto L4
    L8:
        if (r5 != 512) goto L10;
        r0.keyEnvelopePayload = decodeKeyEnvelopePayload(r2);
        goto L4
    L10:
        if (r5 != TAG_CONTENT_INFO_META) goto L12;
        r0.contentInfoMeta = decodeContentInfoMeta(r2);
        goto L4
    L12:
        if (r5 != 1024) goto L4;
        r0.signContentInfo = decodeSignContentInfo(r2);
        goto L4
    L18:
        return r0;
    }

    private static MetaInfo decodeMetaInfo(byte[] r3) {
        MetaInfo r0 = new MetaInfo();
        TlvReader r1 = new TlvReader(r3);
    L4:
        if (r1.hasMore() == false) goto L11;
        int r4 = r1.readTag();
        byte[] r2 = r1.readValue(r1.readLength());
        switch(r4) {
            case 257: goto L10;
            case 258: goto L9;
            case 259: goto L8;
            default: goto L4;
        };
    L8:
        r0.bizAttribute = decodeBizAttribute(r2);
        goto L4
    L9:
        r0.contentType = readUint16(r2);
        goto L4
    L10:
        r0.version = readUint16(r2);
        goto L4
    L11:
        return r0;
    }

    private static BizAttribute decodeBizAttribute(byte[] r4) {
        BizAttribute r0 = new BizAttribute();
        TlvReader r1 = new TlvReader(r4);
    L4:
        if (r1.hasMore() == false) goto L21;
        int r5 = r1.readTag();
        byte[] r2 = r1.readValue(r1.readLength());
        if (r5 != 1) goto L8;
        r0.appId = new String(r2, StandardCharsets.UTF_8);
        goto L4
    L8:
        if (r5 != 2) goto L10;
        r0.serviceId = new String(r2, StandardCharsets.UTF_8);
        goto L4
    L10:
        if (r5 != 3) goto L12;
        r0.bizType = readUint16(r2);
        goto L4
    L12:
        if (r5 != 4) goto L14;
        r0.sessionKeyId = r2;
        goto L4
    L14:
        if (r5 != 5) goto L4;
        r0.accessToken = r2;
        goto L4
    L21:
        return r0;
    }

    private static KeyEnvelopePayload decodeKeyEnvelopePayload(byte[] r3) {
        KeyEnvelopePayload r0 = new KeyEnvelopePayload();
        r0.keyEnvelopeList = new ArrayList();
        TlvReader r1 = new TlvReader(r3);
    L4:
        if (r1.hasMore() == false) goto L12;
        int r4 = r1.readTag();
        byte[] r2 = r1.readValue(r1.readLength());
        switch(r4) {
            case 513: goto L11;
            case 514: goto L10;
            case 515: goto L9;
            case 516: goto L8;
            default: goto L4;
        };
    L8:
        decodeKeyEnvelopeList(r2, r0.keyEnvelopeList);
        goto L4
    L9:
        r0.keyEnvelopeListSize = readUint32(r2);
        goto L4
    L10:
        r0.envelopeType = readUint16(r2);
        goto L4
    L11:
        r0.version = readUint16(r2);
        goto L4
    L12:
        return r0;
    }

    private static void decodeKeyEnvelopeList(byte[] r2, List<KeyEnvelope> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        TlvReader r0 = new TlvReader(r2);
    L4:
        if (r0.hasMore() == false) goto L6;
        int r5 = r0.readTag();
        KeyEnvelope r1 = decodeKeyEnvelope(r0.readValue(r0.readLength()));
        r1.index = r5;
        r4.add(r1);
        goto L4
    }

    private static KeyEnvelope decodeKeyEnvelope(byte[] r3) {
        KeyEnvelope r0 = new KeyEnvelope();
        TlvReader r1 = new TlvReader(r3);
    L4:
        if (r1.hasMore() == false) goto L14;
        int r4 = r1.readTag();
        byte[] r2 = r1.readValue(r1.readLength());
        switch(r4) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L4;
        };
    L8:
        r0.encryptedSessionKey = r2;
        goto L4
    L9:
        r0.salt = r2;
        goto L4
    L10:
        r0.dhPK = r2;
        goto L4
    L11:
        r0.keyEncryptionAlgorithm = readUint16(r2);
        goto L4
    L12:
        r0.keyVersion = readUint32(r2);
        goto L4
    L13:
        r0.keyIdentify = r2;
        goto L4
    L14:
        return r0;
    }

    private static ContentInfoMeta decodeContentInfoMeta(byte[] r3) {
        ContentInfoMeta r0 = new ContentInfoMeta();
        TlvReader r1 = new TlvReader(r3);
    L4:
        if (r1.hasMore() == false) goto L11;
        int r4 = r1.readTag();
        byte[] r2 = r1.readValue(r1.readLength());
        switch(r4) {
            case 769: goto L10;
            case 770: goto L9;
            case 771: goto L8;
            default: goto L4;
        };
    L8:
        r0.otherKeyAttribute = decodeOtherKeyAttribute(r2);
        goto L4
    L9:
        r0.contentEncryptionAlgorithm = readUint16(r2);
        goto L4
    L10:
        r0.contentType = readUint16(r2);
        goto L4
    L11:
        return r0;
    }

    private static OtherKeyAttribute decodeOtherKeyAttribute(byte[] r4) {
        OtherKeyAttribute r0 = new OtherKeyAttribute();
        TlvReader r1 = new TlvReader(r4);
    L4:
        if (r1.hasMore() == false) goto L12;
        int r5 = r1.readTag();
        byte[] r2 = r1.readValue(r1.readLength());
        if (r5 != 1) goto L8;
        r0.nonce = r2;
        goto L4
    L8:
        if (r5 != 2) goto L4;
        r0.chunkSize = readUint32(r2);
        goto L4
    L12:
        return r0;
    }

    private static SignContentInfo decodeSignContentInfo(byte[] r4) {
        SignContentInfo r0 = new SignContentInfo();
        TlvReader r1 = new TlvReader(r4);
    L4:
        if (r1.hasMore() == false) goto L12;
        int r5 = r1.readTag();
        byte[] r2 = r1.readValue(r1.readLength());
        if (r5 != 1025) goto L8;
        r0.signatureAlgorithm = readUint16(r2);
        goto L4
    L8:
        if (r5 != 1026) goto L4;
        r0.contentSignature = r2;
        goto L4
    L12:
        return r0;
    }

    private static int readUint16(byte[] r2) {
        int r0 = (r2[0] & 255) << 8;
        return (r2[1] & 255) | r0;
    }

    private static int readUint32(byte[] r2) {
        int r0 = (((r2[0] & 255) << 24) | ((r2[1] & 255) << 16)) | ((r2[2] & 255) << 8);
        return (r2[3] & 255) | r0;
    }
}
