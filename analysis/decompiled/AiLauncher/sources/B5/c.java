package B5;

import La.C0953c;
import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ailauncher.common.R$raw;
import h8.C4148a;
import h8.i;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import l9.C4877a;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001b¨\u0006*"}, d2 = {"LB5/c;", "Lh8/i;", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "", "priority", "", "tag", "maskedMsg", "", "tr", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "ctx", "Ljava/security/PublicKey;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)Ljava/security/PublicKey;", "p", "", "f", "(I)C", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "io", "Ljava/util/concurrent/ExecutorService;", "Ljava/text/SimpleDateFormat;", "tsFmt", "Ljava/text/SimpleDateFormat;", "Ljava/security/SecureRandom;", "rng", "Ljava/security/SecureRandom;", "Ljavax/crypto/SecretKey;", "aesKey", "Ljavax/crypto/SecretKey;", "wrappedKeyB64", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c implements i {
    private static final String TAG = "SENC";
    private static volatile SecretKey aesKey;
    private static volatile String wrappedKeyB64;
    public static final c INSTANCE = new c();
    private static final ExecutorService io = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: B5.a
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return c.e(runnable);
        }
    });
    private static final SimpleDateFormat tsFmt = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    private static final SecureRandom rng = new SecureRandom();

    public static final Thread e(Runnable runnable) {
        Thread thread = new Thread(runnable, "sensitive-log-enc");
        thread.setDaemon(true);
        return thread;
    }

    public static final void h(String str, String str2, int i10, String str3, String str4, String str5, SecretKey secretKey) {
        c cVar = INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(' ');
            sb2.append(cVar.f(i10));
            sb2.append(JsonPointer.SEPARATOR);
            sb2.append(str3);
            sb2.append(": ");
            sb2.append(str4);
            if (str5 != null) {
                sb2.append('\n');
                sb2.append(str5);
            }
            byte[] bytes = sb2.toString().getBytes(C0953c.UTF_8);
            p.h(bytes, "getBytes(...)");
            byte[] bArr = new byte[12];
            rng.nextBytes(bArr);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKey, new GCMParameterSpec(128, bArr));
            byte[] bArrDoFinal = cipher.doFinal(bytes);
            byte[] bArr2 = new byte[bArrDoFinal.length + 12];
            System.arraycopy(bArr, 0, bArr2, 0, 12);
            System.arraycopy(bArrDoFinal, 0, bArr2, 12, bArrDoFinal.length);
            Result.b(Integer.valueOf(C4148a.a(TAG, str + "." + Base64.encodeToString(bArr2, 2))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    @Override // h8.i
    public void a(final int priority, final String tag, final String maskedMsg, Throwable tr) {
        final String str;
        p.i(tag, "tag");
        p.i(maskedMsg, "maskedMsg");
        final SecretKey secretKey = aesKey;
        if (secretKey == null || (str = wrappedKeyB64) == null) {
            return;
        }
        final String str2 = tsFmt.format(new Date());
        final String stackTraceString = tr != null ? Log.getStackTraceString(tr) : null;
        io.execute(new Runnable() { // from class: B5.b
            @Override // java.lang.Runnable
            public final void run() {
                c.h(str, str2, priority, tag, maskedMsg, stackTraceString, secretKey);
            }
        });
    }

    public final void d(Context context) {
        Object objB;
        Object objB2;
        p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        PublicKey publicKeyG = g(applicationContext);
        if (publicKeyG == null) {
            C4148a.k(TAG, "public key res/raw/sensitive_log_pubkey load failed -> encrypted sink NOT installed", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            objB = Result.b(keyGenerator.generateKey());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        SecretKey secretKey = (SecretKey) objB;
        if (secretKey == null) {
            return;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
            cipher.init(1, publicKeyG, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
            objB2 = Result.b(cipher.doFinal(secretKey.getEncoded()));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        byte[] bArr = (byte[]) objB2;
        if (bArr == null) {
            return;
        }
        aesKey = secretKey;
        wrappedKeyB64 = Base64.encodeToString(bArr, 2);
        C4148a.n(this);
        C4148a.k(TAG, "encrypted sensitive-log sink installed (ciphertext -> logcat)", false, 4, null);
    }

    public final char f(int p10) {
        if (p10 == 2) {
            return 'V';
        }
        if (p10 == 3) {
            return 'D';
        }
        if (p10 == 4) {
            return 'I';
        }
        if (p10 != 5) {
            return p10 != 6 ? '?' : 'E';
        }
        return 'W';
    }

    public final PublicKey g(Context ctx) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream inputStreamOpenRawResource = ctx.getResources().openRawResource(R$raw.sensitive_log_pubkey);
            try {
                p.f(inputStreamOpenRawResource);
                byte[] bArrC = C4877a.c(inputStreamOpenRawResource);
                l9.b.a(inputStreamOpenRawResource, null);
                objB = Result.b(KeyFactory.getInstance(Encrypt.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(bArrC)));
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (PublicKey) (Result.g(objB) ? null : objB);
    }
}
