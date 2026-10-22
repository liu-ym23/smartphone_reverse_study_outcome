package q6;

import Y8.t;
import Z8.C1168p;
import android.security.keystore.KeyGenParameterSpec;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b¨\u0006\u001e"}, d2 = {"Lq6/b;", "", "<init>", "()V", "", "plain", "f", "([B)[B", "blob", "e", "Ljavax/crypto/SecretKey;", Const.INTENT_KEY_UMID, "()Ljavax/crypto/SecretKey;", "c", Const.INTENT_KEY_APIKEY, "", "strongBox", Const.INTENT_KEY_PKGNAME, "(Z)Ljavax/crypto/SecretKey;", "", "TAG", "Ljava/lang/String;", "PROVIDER", "KEY_ALIAS", "TRANSFORMATION", "", "KEY_SIZE_BITS", "I", "IV_LENGTH", "GCM_TAG_LENGTH_BITS", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    private static final int GCM_TAG_LENGTH_BITS = 128;
    public static final b INSTANCE = new b();
    private static final int IV_LENGTH = 12;
    private static final String KEY_ALIAS = "ailauncher_db_kek_v1";
    private static final int KEY_SIZE_BITS = 256;
    private static final String PROVIDER = "AndroidKeyStore";
    private static final String TAG = "KeystoreKeyWrapper";
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";

    public final SecretKey a() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(b(true));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "StrongBox KEK unavailable, retry without it: " + thE, false, 4, null);
        }
        if (Result.e(objB) != null) {
            try {
                KeyStore keyStore = KeyStore.getInstance(PROVIDER);
                keyStore.load(null);
                keyStore.deleteEntry(KEY_ALIAS);
                Result.b(t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
            objB = INSTANCE.b(false);
        }
        return (SecretKey) objB;
    }

    public final SecretKey b(boolean strongBox) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenParameterSpec.Builder userAuthenticationRequired = new KeyGenParameterSpec.Builder(KEY_ALIAS, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).setRandomizedEncryptionRequired(true).setUserAuthenticationRequired(false);
        if (strongBox) {
            userAuthenticationRequired.setIsStrongBoxBacked(true);
        }
        KeyGenParameterSpec keyGenParameterSpecBuild = userAuthenticationRequired.build();
        p.h(keyGenParameterSpecBuild, "build(...)");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", PROVIDER);
        keyGenerator.init(keyGenParameterSpecBuild);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        C4148a.k(TAG, "KEK generated, strongBox=" + strongBox, false, 4, null);
        p.f(secretKeyGenerateKey);
        return secretKeyGenerateKey;
    }

    public final SecretKey c() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        SecretKey secretKeyD = d();
        return secretKeyD == null ? a() : secretKeyD;
    }

    public final SecretKey d() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance(PROVIDER);
        keyStore.load(null);
        if (!keyStore.containsAlias(KEY_ALIAS)) {
            return null;
        }
        Key key = keyStore.getKey(KEY_ALIAS, null);
        if (key instanceof SecretKey) {
            return (SecretKey) key;
        }
        return null;
    }

    public final byte[] e(byte[] blob) {
        Object objB;
        p.i(blob, "blob");
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (blob.length <= 12) {
            throw new IllegalArgumentException(("wrapped blob too short: " + blob.length).toString());
        }
        SecretKey secretKeyD = d();
        if (secretKeyD == null) {
            throw new IllegalStateException("KEK alias absent while wrapped blob exists");
        }
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKeyD, new GCMParameterSpec(128, blob, 0, 12));
        objB = Result.b(cipher.doFinal(blob, 12, blob.length - 12));
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "unwrap failed (KEK lost or blob corrupted)", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (byte[]) objB;
    }

    public final byte[] f(byte[] plain) {
        Object objB;
        Cipher cipher;
        byte[] iv;
        p.i(plain, "plain");
        try {
            Result.Companion companion = Result.INSTANCE;
            cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, c());
            iv = cipher.getIV();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (iv.length != 12) {
            throw new IllegalArgumentException(("unexpected GCM iv size=" + iv.length).toString());
        }
        byte[] bArrDoFinal = cipher.doFinal(plain);
        p.f(iv);
        p.f(bArrDoFinal);
        objB = Result.b(C1168p.E(iv, bArrDoFinal));
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "wrap failed, fallback to legacy scheme", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (byte[]) objB;
    }
}
