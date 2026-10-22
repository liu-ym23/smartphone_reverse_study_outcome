package com.google.crypto.tink;

import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import m7.g;
import m7.j;
import m7.k;
import o7.n;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class JsonKeysetReader implements KeysetReader {
    private static final long MAX_KEY_ID = 4294967295L;
    private static final long MIN_KEY_ID = -2147483648L;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final InputStream inputStream;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private EncryptedKeyset encryptedKeysetFromJson(j jVar) {
        validateEncryptedKeyset(jVar);
        byte[] bArrUrlSafeDecode = this.urlSafeBase64 ? Base64.urlSafeDecode(jVar.n("encryptedKeyset").i()) : Base64.decode(jVar.n("encryptedKeyset").i());
        return jVar.f8266c.containsKey("keysetInfo") ? EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrUrlSafeDecode)).setKeysetInfo(keysetInfoFromJson((j) jVar.f8266c.get("keysetInfo"))).build() : EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrUrlSafeDecode)).build();
    }

    private static int getKeyId(g gVar) throws IOException {
        try {
            long parsedNumberAsLongOrThrow = JsonParser.getParsedNumberAsLongOrThrow(gVar);
            if (parsedNumberAsLongOrThrow <= MAX_KEY_ID && parsedNumberAsLongOrThrow >= MIN_KEY_ID) {
                return (int) gVar.g();
            }
            f.l("invalid key id");
            return 0;
        } catch (NumberFormatException e10) {
            throw new IOException(e10);
        }
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String str) {
        str.getClass();
        switch (str) {
            case "REMOTE":
                return KeyData.KeyMaterialType.REMOTE;
            case "SYMMETRIC":
                return KeyData.KeyMaterialType.SYMMETRIC;
            case "ASYMMETRIC_PRIVATE":
                return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
            case "ASYMMETRIC_PUBLIC":
                return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
            default:
                throw new k("unknown key material type: ".concat(str));
        }
    }

    private static OutputPrefixType getOutputPrefixType(String str) {
        str.getClass();
        switch (str) {
            case "LEGACY":
                return OutputPrefixType.LEGACY;
            case "RAW":
                return OutputPrefixType.RAW;
            case "TINK":
                return OutputPrefixType.TINK;
            case "CRUNCHY":
                return OutputPrefixType.CRUNCHY;
            default:
                throw new k("unknown output prefix type: ".concat(str));
        }
    }

    private static KeyStatusType getStatus(String str) {
        str.getClass();
        switch (str) {
            case "ENABLED":
                return KeyStatusType.ENABLED;
            case "DESTROYED":
                return KeyStatusType.DESTROYED;
            case "DISABLED":
                return KeyStatusType.DISABLED;
            default:
                throw new k("unknown status: ".concat(str));
        }
    }

    private KeyData keyDataFromJson(j jVar) {
        validateKeyData(jVar);
        return KeyData.newBuilder().setTypeUrl(jVar.n("typeUrl").i()).setValue(ByteString.copyFrom(this.urlSafeBase64 ? Base64.urlSafeDecode(jVar.n("value").i()) : Base64.decode(jVar.n("value").i()))).setKeyMaterialType(getKeyMaterialType(jVar.n("keyMaterialType").i())).build();
    }

    private Keyset.Key keyFromJson(j jVar) {
        validateKey(jVar);
        return Keyset.Key.newBuilder().setStatus(getStatus(jVar.n("status").i())).setKeyId(getKeyId(jVar.n("keyId"))).setOutputPrefixType(getOutputPrefixType(jVar.n("outputPrefixType").i())).setKeyData(keyDataFromJson((j) jVar.f8266c.get("keyData"))).build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(j jVar) {
        return KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(jVar.n("status").i())).setKeyId(getKeyId(jVar.n("keyId"))).setOutputPrefixType(getOutputPrefixType(jVar.n("outputPrefixType").i())).setTypeUrl(jVar.n("typeUrl").i()).build();
    }

    private Keyset keysetFromJson(j jVar) {
        validateKeyset(jVar);
        Keyset.Builder builderNewBuilder = Keyset.newBuilder();
        if (jVar.f8266c.containsKey("primaryKeyId")) {
            builderNewBuilder.setPrimaryKeyId(getKeyId(jVar.n("primaryKeyId")));
        }
        m7.f fVar = (m7.f) jVar.f8266c.get("key");
        for (int i = 0; i < fVar.f8264c.size(); i++) {
            builderNewBuilder.addKey(keyFromJson(fVar.l(i).e()));
        }
        return builderNewBuilder.build();
    }

    private static KeysetInfo keysetInfoFromJson(j jVar) {
        KeysetInfo.Builder builderNewBuilder = KeysetInfo.newBuilder();
        n nVar = jVar.f8266c;
        n nVar2 = jVar.f8266c;
        if (nVar.containsKey("primaryKeyId")) {
            builderNewBuilder.setPrimaryKeyId(getKeyId(jVar.n("primaryKeyId")));
        }
        if (nVar2.containsKey("keyInfo")) {
            m7.f fVar = (m7.f) nVar2.get("keyInfo");
            for (int i = 0; i < fVar.f8264c.size(); i++) {
                builderNewBuilder.addKeyInfo(keyInfoFromJson(fVar.l(i).e()));
            }
        }
        return builderNewBuilder.build();
    }

    private static void validateEncryptedKeyset(j jVar) {
        if (!jVar.f8266c.containsKey("encryptedKeyset")) {
            throw new k("invalid encrypted keyset");
        }
    }

    private static void validateKey(j jVar) {
        n nVar = jVar.f8266c;
        n nVar2 = jVar.f8266c;
        if (!nVar.containsKey("keyData") || !nVar2.containsKey("status") || !nVar2.containsKey("keyId") || !nVar2.containsKey("outputPrefixType")) {
            throw new k("invalid key");
        }
    }

    private static void validateKeyData(j jVar) {
        n nVar = jVar.f8266c;
        n nVar2 = jVar.f8266c;
        if (!nVar.containsKey("typeUrl") || !nVar2.containsKey("value") || !nVar2.containsKey("keyMaterialType")) {
            throw new k("invalid keyData");
        }
    }

    private static void validateKeyset(j jVar) {
        if (!jVar.f8266c.containsKey("key") || ((m7.f) jVar.f8266c.get("key")).f8264c.size() == 0) {
            throw new k("invalid keyset");
        }
    }

    public static JsonKeysetReader withBytes(byte[] bArr) {
        return new JsonKeysetReader(new ByteArrayInputStream(bArr));
    }

    @Deprecated
    public static JsonKeysetReader withFile(File file) {
        return withInputStream(new FileInputStream(file));
    }

    public static JsonKeysetReader withInputStream(InputStream inputStream) {
        return new JsonKeysetReader(inputStream);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object obj) {
        return withString(obj.toString());
    }

    @Deprecated
    public static JsonKeysetReader withPath(String str) {
        return withInputStream(new FileInputStream(new File(str)));
    }

    public static JsonKeysetReader withString(String str) {
        return new JsonKeysetReader(new ByteArrayInputStream(str.getBytes(UTF_8)));
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        try {
            try {
                return keysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).e());
            } catch (IllegalStateException | k e10) {
                throw new IOException(e10);
            }
        } finally {
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            try {
                return encryptedKeysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).e());
            } catch (IllegalStateException | k e10) {
                throw new IOException(e10);
            }
        } finally {
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    @Deprecated
    public static JsonKeysetReader withPath(Path path) {
        return withInputStream(new FileInputStream(path.toFile()));
    }
}
