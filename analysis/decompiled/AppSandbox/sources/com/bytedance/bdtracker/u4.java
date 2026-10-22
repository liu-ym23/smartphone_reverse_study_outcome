package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class u4 extends t4 {
    public u4(String str, Context context, String str2) {
        super(str, context, str2);
        Context context2 = this.c;
        StringBuilder sbA = a.a("security_store_");
        sbA.append(this.b);
        SharedPreferences sharedPreferencesA = q4.a(context2, sbA.toString(), 0);
        if (sharedPreferencesA.contains("sks_kv") || !sharedPreferencesA.contains("sks_hash")) {
            return;
        }
        v4.a(this.a.get(), this.b);
    }

    @Override // com.bytedance.bdtracker.t4
    public String a() {
        return "";
    }

    @Override // com.bytedance.bdtracker.t4
    public void a(String str) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkHasKVStoreSwitch failed, preferences == null, key: {}", this.b, str);
            return;
        }
        String strA = a.a("sks", str);
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
        sharedPreferences.edit().putBoolean(a() + str, z).apply();
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public boolean getBoolean(String str, boolean z) {
        boolean z2;
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getBoolean failed, preferences == null, key: {}", this.b, str);
            return z;
        }
        SharedPreferences sharedPreferences2 = this.a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.b, str);
        } else {
            String strA = a.a("sks", str);
            if (sharedPreferences2.contains(strA)) {
                String string = sharedPreferences2.getString(strA, null);
                if (TextUtils.isEmpty(string)) {
                    z2 = z;
                    sharedPreferences2.edit().remove(strA).apply();
                    a(str);
                    a(str, z2);
                    LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.b, str);
                } else {
                    try {
                        z2 = Boolean.parseBoolean(w4.a(string, w4.a(this.c, this.b), this.b));
                    } catch (Throwable th) {
                        LoggerImpl.global().error("[{}][KVStore]DefaultKVStore Boolean.parseBoolean failed, key: {}, ", th, this.b, str);
                    }
                    sharedPreferences2.edit().remove(strA).apply();
                    a(str);
                    a(str, z2);
                    LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.b, str);
                }
            }
        }
        return sharedPreferences.getBoolean(a() + str, z);
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public int getInt(String str, int i) {
        int i2;
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getInt failed, preferences == null, key: {}", this.b, str);
            return i;
        }
        SharedPreferences sharedPreferences2 = this.a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.b, str);
        } else {
            String strA = a.a("sks", str);
            if (sharedPreferences2.contains(strA)) {
                String string = sharedPreferences2.getString(strA, null);
                if (TextUtils.isEmpty(string)) {
                    i2 = i;
                    sharedPreferences2.edit().remove(strA).apply();
                    a(str);
                    a(str, i2);
                    LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.b, str);
                } else {
                    try {
                        i2 = Integer.parseInt(w4.a(string, w4.a(this.c, this.b), this.b));
                    } catch (Throwable th) {
                        LoggerImpl.global().error("[{}][KVStore]DefaultKVStore Integer.parseInt failed, key: {}, ", th, this.b, str);
                    }
                    sharedPreferences2.edit().remove(strA).apply();
                    a(str);
                    a(str, i2);
                    LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.b, str);
                }
            }
        }
        return sharedPreferences.getInt(a() + str, i);
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public long getLong(String str, long j) {
        long j2;
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getLong failed, preferences == null, key: {}", this.b, str);
            return j;
        }
        SharedPreferences sharedPreferences2 = this.a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.b, str);
        } else {
            String strA = a.a("sks", str);
            if (sharedPreferences2.contains(strA)) {
                String string = sharedPreferences2.getString(strA, null);
                if (TextUtils.isEmpty(string)) {
                    j2 = j;
                    sharedPreferences2.edit().remove(strA).apply();
                    a(str);
                    a(str, j2);
                    LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.b, str);
                } else {
                    try {
                        j2 = Long.parseLong(w4.a(string, w4.a(this.c, this.b), this.b));
                    } catch (Throwable th) {
                        LoggerImpl.global().error("[{}][KVStore]DefaultKVStore Long.parseLong failed, key: {}, ", th, this.b, str);
                    }
                    sharedPreferences2.edit().remove(strA).apply();
                    a(str);
                    a(str, j2);
                    LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.b, str);
                }
            }
        }
        return sharedPreferences.getLong(a() + str, j);
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
            String strA = a.a("sks", str);
            if (sharedPreferences2.contains(strA)) {
                String string = sharedPreferences2.getString(strA, null);
                String strA2 = TextUtils.isEmpty(string) ? str2 : w4.a(string, w4.a(this.c, this.b), this.b);
                sharedPreferences2.edit().remove(strA).apply();
                a(str);
                a(str, strA2);
                LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.b, str);
            }
        }
        return sharedPreferences.getString(a() + str, str2);
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
            String strA = a.a("sks", str);
            if (sharedPreferences2.contains(strA)) {
                String string = sharedPreferences2.getString(strA, null);
                Set<String> setB = TextUtils.isEmpty(string) ? set : w4.b(w4.a(string, w4.a(this.c, this.b), this.b), this.b);
                sharedPreferences2.edit().remove(strA).apply();
                a(str);
                if (setB == null) {
                    setB = new HashSet<>();
                }
                a(str, setB);
                LoggerImpl.global().debug("[{}][KVStore]DefaultKVStore replace raw key: {}", this.b, str);
            }
        }
        return sharedPreferences.getStringSet(a() + str, set);
    }

    @Override // com.bytedance.bdtracker.t4
    public void a(String str, int i) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]putIntInner failed, preferences == null, key: {}", this.b, str);
            return;
        }
        sharedPreferences.edit().putInt(a() + str, i).apply();
    }

    @Override // com.bytedance.bdtracker.t4
    public void a(String str, long j) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]putLongInner failed, preferences == null, key: {}", this.b, str);
            return;
        }
        sharedPreferences.edit().putLong(a() + str, j).apply();
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
        sharedPreferences.edit().putString(a() + str, str2).apply();
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
        sharedPreferences.edit().putStringSet(a() + str, set).apply();
    }
}
