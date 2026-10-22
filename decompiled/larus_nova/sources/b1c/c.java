package b1c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crypto.utils.CryptoConst;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.z0;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements b1c.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z0<b, String> f16968c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m4c.a.C6771a f16969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f16970b;

    public static class a implements z0.a<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f16972b;

        public a() {
            this.f16971a = String.valueOf(true);
            this.f16972b = String.valueOf(false);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m4c.a.C6771a f16974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16975c;

        public final int hashCode() {
            if (this.f16975c != (-1)) goto L6;
            this.f16975c = Objects.hash(new Object[]{this.f16973a, this.f16974b});
        L6:
            return this.f16975c;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (b.class != r100.getClass()) goto L17;
            b r101 = (b) r100;
            if (Objects.equals(this.f16973a, r101.f16973a) == true) goto L13;
        L15:
            return false;
        L13:
            if (Objects.equals(this.f16974b, r101.f16974b) == false) goto L15;
            return true;
        }

        public b(String r100, m4c.a.C6771a r101) {
            this.f16975c = -1;
            this.f16973a = r100;
            this.f16974b = r101;
        }
    }

    static {
        f16968c = new z0(new a());
    }

    public static String b(String r100) throws UnsupportedEncodingException, GeneralSecurityException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        v8b.a.a().getClass();
        return c(r100, m4c.b.a.f511910a.b());
    L8:
        e = move-exception;
        Log.e("SecurePolicy", "decrypt string fail:".concat(r100), e, true);
        return null;
    }

    public static String e(String r100) throws UnsupportedEncodingException, GeneralSecurityException {
        v8b.a.a().getClass();
        m4c.a.C6771a r101 = m4c.b.a.f511910a.b();     // Catch: GeneralSecurityException -> L5
    L8:
        return f(r100, r101);
    L5:
        e = move-exception;
        Log.e("SecurePolicy", "get aes key failed", e, true);
        r101 = null;
        goto L8
    }

    public static String g(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r100;
    L10:
        MessageDigest r101 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L7
        byte[] r102 = r100.getBytes(StandardCharsets.UTF_8);     // Catch: NoSuchAlgorithmException -> L7
        r101.update(r102, 0, r102.length);     // Catch: NoSuchAlgorithmException -> L7
        return Base64.encodeToString(r101.digest(), 2);
    L7:
        e = move-exception;
        Log.w("SecurePolicy", "Problem generating hash", e);
        return null;
    }

    public final String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return r100;
    L16:
        return c(r100, this.f16969a);
    L10:
        e = move-exception;
        Log.e("SecurePolicy", "decrypt error, $value", e, true);
        return null;
    L8:
        e = move-exception;
        Log.e("SecurePolicy", "decrypt error, $value", e, true);
        return null;
    L12:
        e = move-exception;
        Log.e("SecurePolicy", "decrypt error, $value", e, true);
        return null;
    }

    public final String d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return r100;
    L13:
        return f(r100, this.f16969a);
    L7:
        e = move-exception;
        Log.w("SecurePolicy", LBSLightLocationTraceLogger.ENCRYPT, e);
        return null;
    L9:
        e = move-exception;
        Log.w("SecurePolicy", LBSLightLocationTraceLogger.ENCRYPT, e);
        return null;
    }

    public static String c(String r100, m4c.a.C6771a r110) throws UnsupportedEncodingException, GeneralSecurityException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        z0<b, String> r101 = f16968c;
        if (r100 != null) goto L8;
        r101.getClass();
        b r102 = null;
    L9:
        b r103 = r102;
        if (r103 != null) goto L12;
    L15:
        String[] r104 = r100.split(":");
        if (r104.length == 3) goto L23;
        if (r104.length == 2) goto L23;
        throw new IllegalArgumentException("Cannot parse: ".concat(r100));
    L23:
        if (r104.length != 3) goto L25;
        String r105 = r104[0];
        String r106 = r104[2];
    L26:
        int r107 = m4c.a.f511904a;
        Charset r108 = StandardCharsets.UTF_8;
        Cipher r109 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r109.init(2, r110.f511905a, new IvParameterSpec(Base64.decode(r105, 2)));     // Catch: NullPointerException -> L30
        String r111 = new String(r109.doFinal(Base64.decode(r106, 2)), r108);
        r101.a(new b(r111, r110), r100);
        return r111;
    L30:
        e = move-exception;
        throw new GeneralSecurityException("init cipher npe", e);
    L25:
        r105 = r104[0];
        r106 = r104[1];
        goto L26
    L12:
        if (Objects.equals(r103.f16974b, r110) == false) goto L15;
        return r103.f16973a;
    L8:
        r102 = r101.f444795b.get(r100);
        goto L9
    }

    public static String f(String r100, m4c.a.C6771a r101) throws UnsupportedEncodingException, GeneralSecurityException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        b r102 = new b(r100, r101);
        z0<b, String> r103 = f16968c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        String r104 = r103.f444796c.get(r102);
        if (r104 == null) goto L8;
        return r104;
    L8:
        int r105 = m4c.a.f511904a;
        byte[] r106 = r100.getBytes(StandardCharsets.UTF_8);
        byte[] r107 = new byte[16];
        SecureRandom.getInstance("SHA1PRNG").nextBytes(r107);
        Cipher r108 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r108.init(1, r101.f511905a, new IvParameterSpec(r107));
        byte[] r109 = r108.getIV();
        byte[] r110 = r108.doFinal(r106);
        String r111 = Base64.encodeToString(r109, 2);
        String r112 = Base64.encodeToString(r110, 2);
        String r113 = r111.concat(":").concat(r112);
        r103.a(r102, r113);
        return r113;
    }

    public c(Context r100, m4c.a.C6771a r101, String r102) {
        if (this.f16970b == null) goto L5;
    L9:
        if (r101 == null) goto L28;
        this.f16969a = r101;
        return;
    L28:
        String r103 = g(r100.getPackageName());     // Catch: GeneralSecurityException -> L25
        if (TextUtils.isEmpty(r103) == false) goto L14;
        r103 = "RTNCQTAxN0Q4N0Y0N0Y4QjA2RTFGMzNGQzhGMjJFNUI=";
    L14:
        String r104 = this.f16970b.getString(r103, null);     // Catch: GeneralSecurityException -> L25
        if (r104 != null) goto L19;
        int r105 = m4c.a.f511904a;     // Catch: GeneralSecurityException -> L25
        KeyGenerator r106 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: GeneralSecurityException -> L25
        r106.init(128);     // Catch: GeneralSecurityException -> L25
        SecretKey r107 = r106.generateKey();     // Catch: GeneralSecurityException -> L25
        byte[] r108 = new byte[32];     // Catch: GeneralSecurityException -> L25
        SecureRandom.getInstance("SHA1PRNG").nextBytes(r108);     // Catch: GeneralSecurityException -> L25
        m4c.a.C6771a r109 = new m4c.a.C6771a(r107, new SecretKeySpec(r108, "HmacSHA256"));     // Catch: GeneralSecurityException -> L25
        this.f16969a = r109;     // Catch: GeneralSecurityException -> L25
        if (this.f16970b.edit().putString(r103, r109.toString()).commit() == true) goto L21;
        Log.w("SecurePolicy", "Key not committed to prefs");     // Catch: GeneralSecurityException -> L25
    L21:
        if (this.f16969a == null) goto L24;
        return;
    L24:
        throw new GeneralSecurityException("Problem generating Key");     // Catch: GeneralSecurityException -> L25
    L19:
        this.f16969a = m4c.a.a(r104);     // Catch: GeneralSecurityException -> L25
    L25:
        e = move-exception;
        Log.e("SecurePolicy", "Error init:" + e.getMessage(), e);
        throw new IllegalStateException(e);
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
        SharedPreferences r110 = PreferenceManager.getDefaultSharedPreferences(r100);
    L8:
        this.f16970b = r110;
        goto L9
    L7:
        r110 = r100.getSharedPreferences(r102, 0);
        goto L8
    }
}
