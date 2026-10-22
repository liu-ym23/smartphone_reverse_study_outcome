package q6;

import La.C0953c;
import La.H;
import android.content.Context;
import android.provider.Settings;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lq6/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)[B", "", "androidId", "pepper", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)[B", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)Ljava/lang/String;", "ikm", "salt", "info", "", "length", "c", "([B[B[BI)[B", "TAG", "Ljava/lang/String;", "KEY_LENGTH", "I", "INFO", "cached", "[B", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: q6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5156a {
    private static final String INFO = "task_info.db";
    public static final C5156a INSTANCE = new C5156a();
    private static final int KEY_LENGTH = 32;
    private static final String TAG = "DeviceDerivedKey";
    private static volatile byte[] cached;

    public final byte[] a(String androidId, String pepper) {
        p.i(pepper, "pepper");
        if (androidId == null || H.x0(androidId) || H.x0(pepper)) {
            return null;
        }
        Charset charset = C0953c.UTF_8;
        byte[] bytes = androidId.getBytes(charset);
        p.h(bytes, "getBytes(...)");
        byte[] bytes2 = pepper.getBytes(charset);
        p.h(bytes2, "getBytes(...)");
        byte[] bytes3 = INFO.getBytes(C0953c.US_ASCII);
        p.h(bytes3, "getBytes(...)");
        return c(bytes, bytes2, bytes3, 32);
    }

    public final byte[] b(Context context) {
        byte[] bArrCopyOf;
        p.i(context, "context");
        byte[] bArr = cached;
        if (bArr != null) {
            byte[] bArrCopyOf2 = Arrays.copyOf(bArr, bArr.length);
            p.h(bArrCopyOf2, "copyOf(...)");
            return bArrCopyOf2;
        }
        synchronized (this) {
            byte[] bArr2 = cached;
            if (bArr2 != null) {
                byte[] bArrCopyOf3 = Arrays.copyOf(bArr2, bArr2.length);
                p.h(bArrCopyOf3, "copyOf(...)");
                return bArrCopyOf3;
            }
            C5156a c5156a = INSTANCE;
            String strD = c5156a.d(context);
            byte[] bArrA = c5156a.a(strD, "stepos-taskinfo-kdf-salt-v1-9f2b7c4e8a1d6035b9e0c7a2f4d81e60");
            if (bArrA == null) {
                bArrCopyOf = null;
                C4148a.u(TAG, "cannot derive task-store key this round (androidIdBlank=" + (strD == null || H.x0(strD)) + ")", false, 4, null);
            } else {
                cached = bArrA;
                bArrCopyOf = Arrays.copyOf(bArrA, bArrA.length);
                p.h(bArrCopyOf, "copyOf(...)");
            }
            return bArrCopyOf;
        }
    }

    public final byte[] c(byte[] ikm, byte[] salt, byte[] info, int length) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(salt, "HmacSHA256"));
        mac.init(new SecretKeySpec(mac.doFinal(ikm), "HmacSHA256"));
        byte[] bArr = new byte[length];
        byte[] bArrDoFinal = new byte[0];
        int i10 = 0;
        int i11 = 1;
        while (i10 < length) {
            mac.update(bArrDoFinal);
            mac.update(info);
            mac.update((byte) i11);
            bArrDoFinal = mac.doFinal();
            p.h(bArrDoFinal, "doFinal(...)");
            int iMin = Math.min(bArrDoFinal.length, length - i10);
            System.arraycopy(bArrDoFinal, 0, bArr, i10, iMin);
            i10 += iMin;
            i11++;
        }
        return bArr;
    }

    public final String d(Context context) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Settings.Secure.getString(context.getContentResolver(), "android_id"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (String) objB;
    }
}
