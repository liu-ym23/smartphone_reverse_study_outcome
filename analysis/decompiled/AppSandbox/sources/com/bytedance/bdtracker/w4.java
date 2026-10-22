package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.applog.log.LoggerImpl;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class w4 extends t4 {
    public static final String[] e = new String[0];
    public static boolean f = false;
    public final String[] d;

    public w4(String str, Context context, String str2) throws NoSuchAlgorithmException {
        super(str, context, str2);
        SharedPreferences sharedPreferencesA = q4.a(context, "security_store_" + str, 0);
        if (sharedPreferencesA.contains("sks_kv")) {
            this.d = sharedPreferencesA.getString("sks_kv", "").split("/");
        } else {
            String[] strArrA = g5.a();
            this.d = strArrA;
            sharedPreferencesA.edit().putString("sks_kv", strArrA[0] + "/" + strArrA[1]).apply();
        }
        a(sharedPreferencesA, this.d);
    }

    public w4(String str, Context context, String str2, String str3) throws NoSuchAlgorithmException {
        super(str, context, str2);
        String[] strArr = {str3, new String(new byte[16])};
        this.d = strArr;
        LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore create use custom key", str);
        SharedPreferences sharedPreferencesA = q4.a(context, "security_store_" + str, 0);
        if (sharedPreferencesA.contains("sks_kv")) {
            sharedPreferencesA.edit().remove("sks_kv").apply();
        }
        a(sharedPreferencesA, strArr);
    }

    public static String a(String str, String[] strArr, String str2) {
        if (strArr != null && strArr.length >= 2) {
            String str3 = strArr[0];
            String str4 = strArr[1];
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                cipher.init(2, new SecretKeySpec(str3.getBytes(), "AES"), new IvParameterSpec(str4.getBytes()));
                return new String(cipher.doFinal(Base64.decode(str, 0)));
            } catch (Throwable th) {
                LoggerImpl.global().error("[{}][KVStore]decrypt aes failed", th, str2);
            }
        }
        return str;
    }

    public static String[] a(Context context, String str) {
        String string;
        SharedPreferences sharedPreferencesA = q4.a(context, "security_store_" + str, 0);
        if (sharedPreferencesA.contains("sks_kv") && (string = sharedPreferencesA.getString("sks_kv", null)) != null) {
            return string.split("/");
        }
        return e;
    }

    public static String b(String str, String[] strArr, String str2) {
        if (strArr != null && strArr.length >= 2) {
            String str3 = strArr[0];
            String str4 = strArr[1];
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                cipher.init(1, new SecretKeySpec(str3.getBytes(), "AES"), new IvParameterSpec(str4.getBytes()));
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Throwable th) {
                LoggerImpl.global().error("[{}][KVStore]encrypt aes failed", th, str2);
            }
        }
        return str;
    }

    public static HashSet<String> b(String str, String str2) {
        HashSet<String> hashSet = new HashSet<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            HashSet<String> hashSet2 = new HashSet<>();
            for (int i = 0; i < length; i++) {
                try {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        hashSet2.add(string);
                    }
                } catch (Throwable th) {
                    th = th;
                    hashSet = hashSet2;
                    LoggerImpl.global().error("[{}][KVStore]convertToSet failed", th, str2);
                    return hashSet;
                }
            }
            return hashSet2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.bdtracker.t4
    public String a() {
        return "sks";
    }

    public final void a(SharedPreferences sharedPreferences, String[] strArr) throws NoSuchAlgorithmException {
        if (sharedPreferences.contains("sks_hash")) {
            String string = sharedPreferences.getString("sks_hash", "");
            String strA = f5.a(strArr[0]);
            if (f || !Objects.equals(string, strA)) {
                if (!Objects.equals(string, strA)) {
                    f = true;
                }
                v4.a(this.a.get(), this.b);
            }
        }
        sharedPreferences.edit().putString("sks_hash", f5.a(strArr[0])).apply();
    }

    @Override // com.bytedance.bdtracker.t4
    public void a(String str) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkHasKVStoreSwitch failed, preferences == null, key: {}", this.b, str);
            return;
        }
        String strA = a.a("", str);
        if (sharedPreferences.contains(strA)) {
            sharedPreferences.edit().remove(strA).apply();
            LoggerImpl.global().debug("[{}][KVStore]BaseKVStore remove raw key: {}", this.b, strA);
        }
    }

    @Override // com.bytedance.bdtracker.t4
    public void a(String str, boolean z) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]putBooleanInner failed, preferences == null, key: {}", this.b, str);
            return;
        }
        sharedPreferences.edit().putString(a() + str, b(String.valueOf(z), this.d, this.b)).apply();
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getBoolean failed, preferences == null, key: {}", this.b, str);
            return z;
        }
        SharedPreferences sharedPreferences2 = this.a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.b, str);
        } else {
            String strA = a.a("", str);
            if (sharedPreferences2.contains(strA)) {
                boolean z2 = sharedPreferences2.getBoolean(strA, z);
                sharedPreferences2.edit().remove(strA).apply();
                a(str);
                a(str, z2);
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.b, str);
            }
        }
        String string = sharedPreferences.getString(a() + str, null);
        if (TextUtils.isEmpty(string)) {
            return z;
        }
        try {
            return Boolean.parseBoolean(a(string, this.d, this.b));
        } catch (Throwable th) {
            LoggerImpl.global().error("[{}][KVStore]SecurityKVStore Boolean.parseBoolean failed, key: {}, ", th, this.b, str);
            this.remove(str);
            return z;
        }
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public int getInt(String str, int i) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getInt failed, preferences == null, key: {}", this.b, str);
            return i;
        }
        SharedPreferences sharedPreferences2 = this.a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.b, str);
        } else {
            String strA = a.a("", str);
            if (sharedPreferences2.contains(strA)) {
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.b, str);
                int i2 = sharedPreferences2.getInt(strA, i);
                sharedPreferences2.edit().remove(strA).apply();
                a(str);
                a(str, i2);
            }
        }
        String string = sharedPreferences.getString(a() + str, null);
        if (TextUtils.isEmpty(string)) {
            return i;
        }
        try {
            return Integer.parseInt(a(string, this.d, this.b));
        } catch (Throwable th) {
            LoggerImpl.global().error("[{}][KVStore]SecurityKVStore Integer.parseInt failed, key: {}, ", th, this.b, str);
            this.remove(str);
            return i;
        }
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getLong failed, preferences == null, key: {}", this.b, str);
            return j;
        }
        SharedPreferences sharedPreferences2 = this.a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.b, str);
        } else {
            String strA = a.a("", str);
            if (sharedPreferences2.contains(strA)) {
                long j2 = sharedPreferences2.getLong(strA, j);
                sharedPreferences2.edit().remove(strA).apply();
                a(str);
                a(str, j2);
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.b, str);
            }
        }
        String string = sharedPreferences.getString(a() + str, null);
        if (TextUtils.isEmpty(string)) {
            return j;
        }
        try {
            return Long.parseLong(a(string, this.d, this.b));
        } catch (Throwable th) {
            LoggerImpl.global().error("[{}][KVStore]SecurityKVStore Long.parseLong failed, key: {}, ", th, this.b, str);
            this.remove(str);
            return j;
        }
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getString failed, preferences == null, key: {}", this.b, str);
            return str2;
        }
        SharedPreferences sharedPreferences2 = this.a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.b, str);
        } else {
            String strA = a.a("", str);
            if (sharedPreferences2.contains(strA)) {
                String string = sharedPreferences2.getString(strA, str2);
                sharedPreferences2.edit().remove(strA).apply();
                a(str);
                a(str, string);
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.b, str);
            }
        }
        String string2 = sharedPreferences.getString(a() + str, null);
        return TextUtils.isEmpty(string2) ? str2 : a(string2, this.d, this.b);
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getStringSet failed, preferences == null, key: {}", this.b, str);
            return set;
        }
        SharedPreferences sharedPreferences2 = this.a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.b, str);
        } else {
            String strA = a.a("", str);
            if (sharedPreferences2.contains(strA)) {
                Set<String> stringSet = sharedPreferences2.getStringSet(strA, set);
                sharedPreferences2.edit().remove(strA).apply();
                a(str);
                if (stringSet == null) {
                    stringSet = new HashSet<>();
                }
                a(str, stringSet);
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.b, str);
            }
        }
        if (TextUtils.isEmpty(sharedPreferences.getString(a() + str, null))) {
            return set;
        }
        return b(a(sharedPreferences.getString(a() + str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), this.d, this.b), this.b);
    }

    @Override // com.bytedance.bdtracker.t4
    public void a(String str, int i) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]putIntInner failed, preferences == null, key: {}", this.b, str);
            return;
        }
        sharedPreferences.edit().putString(a() + str, b(String.valueOf(i), this.d, this.b)).apply();
    }

    @Override // com.bytedance.bdtracker.t4
    public void a(String str, long j) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]putLongInner failed, preferences == null, key: {}", this.b, str);
            return;
        }
        sharedPreferences.edit().putString(a() + str, b(String.valueOf(j), this.d, this.b)).apply();
    }

    @Override // com.bytedance.bdtracker.t4
    public void a(String str, String str2) {
        if (str2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]putStringInner is null, remove key: {}", this.b, str);
            remove(str);
            return;
        }
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]putStringInner failed, preferences == null, key: {}", this.b, str);
            return;
        }
        sharedPreferences.edit().putString(a() + str, b(str2, this.d, this.b)).apply();
    }

    @Override // com.bytedance.bdtracker.t4
    public void a(String str, Set<String> set) {
        if (set == null) {
            LoggerImpl.global().warn("[{}][KVStore]putStringSetInner is null, remove key: {}", this.b, str);
            remove(str);
            return;
        }
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]putStringSetInner failed, preferences == null, key: {}", this.b, str);
            return;
        }
        sharedPreferences.edit().putString(a() + str, b(set.toString(), this.d, this.b)).apply();
    }
}
