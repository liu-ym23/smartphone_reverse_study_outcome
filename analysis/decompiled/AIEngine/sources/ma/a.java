package ma;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import ta.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f10533a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f10534b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: ma.a$a, reason: collision with other inner class name */
    public static class C0109a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10535a = new a();
    }

    public static byte[] b(Context context, String str, int i10) {
        c.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.simple_crypto_AES");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.simple_crypto_AES", 0);
        c.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.simple_crypto_AES structure complete");
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            byte[] bArrDecode = Base64.decode(string, 2);
            if (bArrDecode.length == i10) {
                return bArrDecode;
            }
        }
        byte[] bArr = new byte[i10];
        new SecureRandom().nextBytes(bArr);
        sharedPreferences.edit().putString(str, Base64.encodeToString(bArr, 2)).commit();
        return bArr;
    }

    public final SecretKeySpec a() {
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec("262t1#x23&^ya1bk".toCharArray(), this.f10533a, 100, 256)).getEncoded(), "AES");
        } catch (Exception e10) {
            throw new RuntimeException("Deal with exceptions properly!", e10);
        }
    }
}
