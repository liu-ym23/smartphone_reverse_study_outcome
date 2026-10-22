package q6;

import Z8.r;
import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Base64;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.mmkv.MMKV;
import h8.C4148a;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o6.C5009a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0014\u0010\fJ\r\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0013J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001d\u0010\fJ\u0017\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010(\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010#R\u0014\u0010)\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010*\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010#R\u0014\u0010,\u001a\u00020+8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020+8\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00100¨\u00066"}, d2 = {"Lq6/c;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;)V", Const.INTENT_KEY_UMID, "", "f", "()[B", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/tencent/mmkv/MMKV;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/tencent/mmkv/MMKV;", "", "m", "()Z", "k", "n", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/String;", "l", c.SCHEME_LEGACY, Const.INTENT_KEY_APIKEY, "([B)[B", Const.INTENT_KEY_PKGNAME, "c", "(Landroid/content/Context;)Ljava/lang/String;", "e", "(Landroid/content/Context;)[B", "TAG", "Ljava/lang/String;", "SECURE_MMKV_ID", "KEY_DATABASE_PASSPHRASE", "KEY_DATABASE_PASSPHRASE_WRAPPED", "KEY_PASSPHRASE_SCHEME", "KEY_KEYSTORE_FAILURES", "SCHEME_LEGACY", "SCHEME_KEYSTORE_V1", "", "DATABASE_KEY_LENGTH", "I", "MAX_KEYSTORE_FAILURES", "isInitialized", "Z", "secureMMKV", "Lcom/tencent/mmkv/MMKV;", "databasePassphrase", "[B", "passphraseResetInThisProcess", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private static final int DATABASE_KEY_LENGTH = 32;
    public static final c INSTANCE = new c();
    private static final String KEY_DATABASE_PASSPHRASE = "db_passphrase";
    private static final String KEY_DATABASE_PASSPHRASE_WRAPPED = "db_passphrase_wrapped";
    private static final String KEY_KEYSTORE_FAILURES = "db_passphrase_unwrap_failures";
    private static final String KEY_PASSPHRASE_SCHEME = "db_passphrase_scheme";
    private static final int MAX_KEYSTORE_FAILURES = 3;
    private static final String SCHEME_KEYSTORE_V1 = "keystore_v1";
    private static final String SCHEME_LEGACY = "legacy";
    private static final String SECURE_MMKV_ID = "secure_key_storage";
    private static final String TAG = "SecureKeyManager";
    private static volatile byte[] databasePassphrase;
    private static volatile boolean isInitialized;
    private static volatile boolean passphraseResetInThisProcess;
    private static MMKV secureMMKV;

    public final byte[] a(byte[] legacy) {
        byte[] bArrF = b.INSTANCE.f(legacy);
        if (bArrF == null) {
            MMKV mmkv = secureMMKV;
            if (mmkv == null) {
                p.A("secureMMKV");
                mmkv = null;
            }
            mmkv.r(KEY_PASSPHRASE_SCHEME, SCHEME_LEGACY);
            C4148a.u(TAG, "keystore unavailable on this device, staying on legacy passphrase scheme", false, 4, null);
            return legacy;
        }
        MMKV mmkv2 = secureMMKV;
        if (mmkv2 == null) {
            p.A("secureMMKV");
            mmkv2 = null;
        }
        mmkv2.u(KEY_DATABASE_PASSPHRASE_WRAPPED, bArrF);
        MMKV mmkv3 = secureMMKV;
        if (mmkv3 == null) {
            p.A("secureMMKV");
            mmkv3 = null;
        }
        mmkv3.r(KEY_PASSPHRASE_SCHEME, SCHEME_KEYSTORE_V1);
        MMKV mmkv4 = secureMMKV;
        if (mmkv4 == null) {
            p.A("secureMMKV");
            mmkv4 = null;
        }
        mmkv4.D(KEY_DATABASE_PASSPHRASE);
        C4148a.k(TAG, "passphrase migrated to keystore scheme (value unchanged)", false, 4, null);
        return legacy;
    }

    public final byte[] b() {
        boolean zU;
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        byte[] bArrF = b.INSTANCE.f(bArr);
        if (bArrF != null) {
            MMKV mmkv = secureMMKV;
            if (mmkv == null) {
                p.A("secureMMKV");
                mmkv = null;
            }
            zU = mmkv.u(KEY_DATABASE_PASSPHRASE_WRAPPED, bArrF);
            MMKV mmkv2 = secureMMKV;
            if (mmkv2 == null) {
                p.A("secureMMKV");
                mmkv2 = null;
            }
            mmkv2.r(KEY_PASSPHRASE_SCHEME, SCHEME_KEYSTORE_V1);
        } else {
            MMKV mmkv3 = secureMMKV;
            if (mmkv3 == null) {
                p.A("secureMMKV");
                mmkv3 = null;
            }
            zU = mmkv3.u(KEY_DATABASE_PASSPHRASE, bArr);
            MMKV mmkv4 = secureMMKV;
            if (mmkv4 == null) {
                p.A("secureMMKV");
                mmkv4 = null;
            }
            mmkv4.r(KEY_PASSPHRASE_SCHEME, SCHEME_LEGACY);
        }
        if (!zU) {
            C4148a.h(TAG, "failed to persist new database passphrase, refusing to use it", false, 4, null);
            return null;
        }
        C4148a.k(TAG, "new database passphrase created, scheme=" + j(), false, 4, null);
        return bArr;
    }

    public final String c(Context context) {
        String strEncodeToString = Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(e(context)), 2);
        p.h(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public final synchronized void d(Context context) {
        p.i(context, "context");
        if (isInitialized) {
            return;
        }
        C5009a.INSTANCE.e(context);
        MMKV mmkvB = MMKV.B(SECURE_MMKV_ID, 1, c(context));
        p.h(mmkvB, "mmkvWithID(...)");
        secureMMKV = mmkvB;
        databasePassphrase = l();
        isInitialized = true;
    }

    public final byte[] e(Context context) {
        Signature signature;
        byte[] byteArray;
        try {
            SigningInfo signingInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo;
            Signature[] apkContentsSigners = signingInfo != null ? signingInfo.getApkContentsSigners() : null;
            if (apkContentsSigners == null || (signature = (Signature) r.Z(apkContentsSigners)) == null || (byteArray = signature.toByteArray()) == null) {
                throw new IllegalStateException("No signature found");
            }
            return byteArray;
        } catch (Exception e10) {
            throw new IllegalStateException("Failed to get app signature", e10);
        }
    }

    public final byte[] f() {
        if (!isInitialized) {
            throw new IllegalStateException("SecureKeyManager not initialized. Call ensureInit() first.");
        }
        byte[] bArr = databasePassphrase;
        if (bArr == null) {
            throw new IllegalStateException("Database passphrase unavailable (keystore key lost).");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        p.h(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public final byte[] g() {
        byte[] bArr;
        if (!isInitialized || (bArr = databasePassphrase) == null) {
            return null;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        p.h(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public final MMKV h() {
        if (!isInitialized) {
            throw new IllegalStateException("SecureKeyManager not initialized. Call ensureInit() first.");
        }
        MMKV mmkv = secureMMKV;
        if (mmkv != null) {
            return mmkv;
        }
        p.A("secureMMKV");
        return null;
    }

    public final void i(Context context) {
        p.i(context, "context");
        d(context);
    }

    public final String j() {
        if (!isInitialized) {
            return "uninitialized";
        }
        MMKV mmkv = secureMMKV;
        if (mmkv == null) {
            p.A("secureMMKV");
            mmkv = null;
        }
        String strH = mmkv.h(KEY_PASSPHRASE_SCHEME, SCHEME_LEGACY);
        return strH == null ? SCHEME_LEGACY : strH;
    }

    public final synchronized byte[] k() {
        if (!isInitialized) {
            return null;
        }
        byte[] bArr = databasePassphrase;
        if (bArr != null) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            p.h(bArrCopyOf, "copyOf(...)");
            return bArrCopyOf;
        }
        C4148a.h(TAG, "keystore key permanently lost after 3 cold starts, regenerating passphrase — data encrypted with the old key is unrecoverable", false, 4, null);
        MMKV mmkv = secureMMKV;
        if (mmkv == null) {
            p.A("secureMMKV");
            mmkv = null;
        }
        mmkv.removeValuesForKeys(new String[]{KEY_DATABASE_PASSPHRASE_WRAPPED, KEY_DATABASE_PASSPHRASE, KEY_KEYSTORE_FAILURES});
        byte[] bArrB = b();
        if (bArrB == null) {
            return null;
        }
        databasePassphrase = bArrB;
        passphraseResetInThisProcess = true;
        byte[] bArrCopyOf2 = Arrays.copyOf(bArrB, bArrB.length);
        p.h(bArrCopyOf2, "copyOf(...)");
        return bArrCopyOf2;
    }

    public final byte[] l() {
        MMKV mmkv = secureMMKV;
        MMKV mmkv2 = null;
        if (mmkv == null) {
            p.A("secureMMKV");
            mmkv = null;
        }
        byte[] bArrD = mmkv.d(KEY_DATABASE_PASSPHRASE);
        if (bArrD == null || bArrD.length != 32) {
            bArrD = null;
        }
        MMKV mmkv3 = secureMMKV;
        if (mmkv3 == null) {
            p.A("secureMMKV");
            mmkv3 = null;
        }
        byte[] bArrD2 = mmkv3.d(KEY_DATABASE_PASSPHRASE_WRAPPED);
        if (bArrD2 == null) {
            return bArrD != null ? a(bArrD) : b();
        }
        byte[] bArrE = b.INSTANCE.e(bArrD2);
        if (bArrE == null || bArrE.length != 32) {
            bArrE = null;
        }
        if (bArrE != null) {
            MMKV mmkv4 = secureMMKV;
            if (mmkv4 == null) {
                p.A("secureMMKV");
            } else {
                mmkv2 = mmkv4;
            }
            mmkv2.D(KEY_KEYSTORE_FAILURES);
            return bArrE;
        }
        MMKV mmkv5 = secureMMKV;
        if (mmkv5 == null) {
            p.A("secureMMKV");
            mmkv5 = null;
        }
        int iF = mmkv5.f(KEY_KEYSTORE_FAILURES, 0) + 1;
        MMKV mmkv6 = secureMMKV;
        if (mmkv6 == null) {
            p.A("secureMMKV");
            mmkv6 = null;
        }
        mmkv6.p(KEY_KEYSTORE_FAILURES, iF);
        if (bArrD != null) {
            C4148a.u(TAG, "wrapped passphrase unreadable, recovering from legacy copy", false, 4, null);
            return a(bArrD);
        }
        C4148a.h(TAG, "database passphrase unavailable, consecutiveFailures=" + iF, false, 4, null);
        return null;
    }

    public final boolean m() {
        if (isInitialized && databasePassphrase == null) {
            MMKV mmkv = secureMMKV;
            if (mmkv == null) {
                p.A("secureMMKV");
                mmkv = null;
            }
            if (mmkv.f(KEY_KEYSTORE_FAILURES, 0) >= 3) {
                return true;
            }
        }
        return false;
    }

    public final boolean n() {
        return passphraseResetInThisProcess;
    }
}
