package com.stepos.stepclaw.gateway;

import a6.z;
import android.content.Context;
import android.util.Base64;
import android.util.Log;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import java.io.File;
import java.security.MessageDigest;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import m5.l;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.Ed25519KeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.Ed25519KeyGenerationParameters;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.crypto.util.PrivateKeyInfoFactory;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\rJ\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\rJ\u001f\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J%\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/gateway/DeviceIdentityStore;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "input", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "base64UrlDecode", "(Ljava/lang/String;)[B", "Lcom/stepos/stepclaw/gateway/DeviceIdentity;", "load", "()Lcom/stepos/stepclaw/gateway/DeviceIdentity;", "Ljava/io/File;", "file", "readIdentity", "(Ljava/io/File;)Lcom/stepos/stepclaw/gateway/DeviceIdentity;", "identity", "Lb5/a0;", "save", "(Lcom/stepos/stepclaw/gateway/DeviceIdentity;)V", "generate", "publicKeyRawBase64", "deriveDeviceId", "(Ljava/lang/String;)Ljava/lang/String;", "data", "sha256Hex", "([B)Ljava/lang/String;", "base64UrlEncode", "loadOrCreate", "payload", "signPayload", "(Ljava/lang/String;Lcom/stepos/stepclaw/gateway/DeviceIdentity;)Ljava/lang/String;", "signatureBase64Url", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "verifySelfSignature", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/gateway/DeviceIdentity;)Z", "publicKeyBase64Url", "(Lcom/stepos/stepclaw/gateway/DeviceIdentity;)Ljava/lang/String;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "identityFile", "Ljava/io/File;", "cachedIdentity", "Lcom/stepos/stepclaw/gateway/DeviceIdentity;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceIdentityStore {
    private static final char[] HEX;
    private volatile DeviceIdentity cachedIdentity;
    private final File identityFile;
    private final Json json;

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        p.d(charArray, "toCharArray(...)");
        HEX = charArray;
    }

    public DeviceIdentityStore(Context context) {
        p.e(context, "context");
        this.json = JsonKt.Json$default(null, new z(26), 1, null);
        this.identityFile = new File(context.getFilesDir(), "openclaw/identity/device.json");
    }

    private final byte[] base64UrlDecode(String input) {
        String str;
        String strZ0 = u.Z0(u.Z0(input, '-', '+'), '_', '/');
        int length = (4 - (strZ0.length() % 4)) % 4;
        if (length < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + length + '.').toString());
        }
        if (length != 0) {
            str = "=";
            if (length != 1) {
                char cCharAt = "=".charAt(0);
                char[] cArr = new char[length];
                for (int i8 = 0; i8 < length; i8++) {
                    cArr[i8] = cCharAt;
                }
                str = new String(cArr);
            }
        } else {
            str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        byte[] bArrDecode = Base64.decode(strZ0.concat(str), 0);
        p.d(bArrDecode, "decode(...)");
        return bArrDecode;
    }

    private final String base64UrlEncode(byte[] data) {
        String strEncodeToString = Base64.encodeToString(data, 11);
        p.d(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    private final String deriveDeviceId(String publicKeyRawBase64) {
        try {
            byte[] bArrDecode = Base64.decode(publicKeyRawBase64, 0);
            p.b(bArrDecode);
            return sha256Hex(bArrDecode);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final DeviceIdentity generate() {
        Ed25519KeyPairGenerator ed25519KeyPairGenerator = new Ed25519KeyPairGenerator();
        ed25519KeyPairGenerator.init(new Ed25519KeyGenerationParameters(new SecureRandom()));
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = ed25519KeyPairGenerator.generateKeyPair();
        AsymmetricKeyParameter asymmetricKeyParameter = asymmetricCipherKeyPairGenerateKeyPair.getPublic();
        p.c(asymmetricKeyParameter, "null cannot be cast to non-null type org.bouncycastle.crypto.params.Ed25519PublicKeyParameters");
        AsymmetricKeyParameter asymmetricKeyParameter2 = asymmetricCipherKeyPairGenerateKeyPair.getPrivate();
        p.c(asymmetricKeyParameter2, "null cannot be cast to non-null type org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters");
        byte[] encoded = ((Ed25519PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        p.b(encoded);
        String strSha256Hex = sha256Hex(encoded);
        byte[] encoded2 = PrivateKeyInfoFactory.createPrivateKeyInfo((Ed25519PrivateKeyParameters) asymmetricKeyParameter2).getEncoded();
        String strEncodeToString = Base64.encodeToString(encoded, 2);
        p.d(strEncodeToString, "encodeToString(...)");
        String strEncodeToString2 = Base64.encodeToString(encoded2, 2);
        p.d(strEncodeToString2, "encodeToString(...)");
        return new DeviceIdentity(strSha256Hex, strEncodeToString, strEncodeToString2, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        return a0.f883a;
    }

    private final DeviceIdentity load() {
        return readIdentity(this.identityFile);
    }

    private final DeviceIdentity readIdentity(File file) {
        if (!file.exists()) {
            return null;
        }
        DeviceIdentity deviceIdentity = (DeviceIdentity) this.json.decodeFromString(DeviceIdentity.INSTANCE.serializer(), l.E0(file, x5.a.f6276a));
        if (!n.t1(deviceIdentity.getDeviceId()) && !n.t1(deviceIdentity.getPublicKeyRawBase64())) {
            if (!n.t1(deviceIdentity.getPrivateKeyPkcs8Base64())) {
                return deviceIdentity;
            }
        }
        return null;
    }

    private final void save(DeviceIdentity identity) {
        try {
            File parentFile = this.identityFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            l.G0(this.identityFile, this.json.encodeToString(DeviceIdentity.INSTANCE.serializer(), identity), x5.a.f6276a);
        } catch (Throwable unused) {
        }
    }

    private final String sha256Hex(byte[] data) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(data);
        char[] cArr = new char[bArrDigest.length * 2];
        int i8 = 0;
        for (byte b9 : bArrDigest) {
            int i9 = i8 + 1;
            char[] cArr2 = HEX;
            cArr[i8] = cArr2[(b9 & 255) >>> 4];
            i8 += 2;
            cArr[i9] = cArr2[b9 & 15];
        }
        return new String(cArr);
    }

    public final synchronized DeviceIdentity loadOrCreate() {
        DeviceIdentity deviceIdentity = this.cachedIdentity;
        if (deviceIdentity != null) {
            return deviceIdentity;
        }
        DeviceIdentity deviceIdentityLoad = load();
        if (deviceIdentityLoad == null) {
            DeviceIdentity deviceIdentityGenerate = generate();
            save(deviceIdentityGenerate);
            this.cachedIdentity = deviceIdentityGenerate;
            return deviceIdentityGenerate;
        }
        String strDeriveDeviceId = deriveDeviceId(deviceIdentityLoad.getPublicKeyRawBase64());
        if (strDeriveDeviceId == null || strDeriveDeviceId.equals(deviceIdentityLoad.getDeviceId())) {
            this.cachedIdentity = deviceIdentityLoad;
            return deviceIdentityLoad;
        }
        DeviceIdentity deviceIdentityCopy$default = DeviceIdentity.copy$default(deviceIdentityLoad, strDeriveDeviceId, null, null, 0L, 14, null);
        save(deviceIdentityCopy$default);
        this.cachedIdentity = deviceIdentityCopy$default;
        return deviceIdentityCopy$default;
    }

    public final String publicKeyBase64Url(DeviceIdentity identity) {
        p.e(identity, "identity");
        try {
            byte[] bArrDecode = Base64.decode(identity.getPublicKeyRawBase64(), 0);
            p.b(bArrDecode);
            return base64UrlEncode(bArrDecode);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String signPayload(String payload, DeviceIdentity identity) {
        p.e(payload, "payload");
        p.e(identity, "identity");
        try {
            Ed25519PrivateKeyParameters ed25519PrivateKeyParameters = new Ed25519PrivateKeyParameters(ASN1OctetString.getInstance(PrivateKeyInfo.getInstance(Base64.decode(identity.getPrivateKeyPkcs8Base64(), 0)).parsePrivateKey()).getOctets(), 0);
            Ed25519Signer ed25519Signer = new Ed25519Signer();
            ed25519Signer.init(true, ed25519PrivateKeyParameters);
            byte[] bytes = payload.getBytes(x5.a.f6276a);
            p.d(bytes, "getBytes(...)");
            ed25519Signer.update(bytes, 0, bytes.length);
            byte[] bArrGenerateSignature = ed25519Signer.generateSignature();
            p.d(bArrGenerateSignature, "generateSignature(...)");
            return base64UrlEncode(bArrGenerateSignature);
        } catch (Throwable th) {
            Log.e("DeviceAuth", a8.b.p("signPayload FAILED: ", th.getClass().getSimpleName(), ": ", th.getMessage()), th);
            return null;
        }
    }

    public final boolean verifySelfSignature(String payload, String signatureBase64Url, DeviceIdentity identity) {
        p.e(payload, "payload");
        p.e(signatureBase64Url, "signatureBase64Url");
        p.e(identity, "identity");
        try {
            Ed25519PublicKeyParameters ed25519PublicKeyParameters = new Ed25519PublicKeyParameters(Base64.decode(identity.getPublicKeyRawBase64(), 0), 0);
            byte[] bArrBase64UrlDecode = base64UrlDecode(signatureBase64Url);
            Ed25519Signer ed25519Signer = new Ed25519Signer();
            ed25519Signer.init(false, ed25519PublicKeyParameters);
            byte[] bytes = payload.getBytes(x5.a.f6276a);
            p.d(bytes, "getBytes(...)");
            ed25519Signer.update(bytes, 0, bytes.length);
            return ed25519Signer.verifySignature(bArrBase64UrlDecode);
        } catch (Throwable th) {
            Log.e("DeviceAuth", "self-verify exception: " + th.getMessage(), th);
            return false;
        }
    }
}
