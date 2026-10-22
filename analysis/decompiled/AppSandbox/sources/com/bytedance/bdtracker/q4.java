package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.store.kv.IKVStore;
import java.util.Collections;

/* loaded from: classes.dex */
public class q4 extends f4 {
    public static q4 f;
    public final IKVStore c;
    public IKVStore d;
    public boolean e;

    public interface a {
        String a();
    }

    public q4(Context context, String str, boolean z) {
        this.e = false;
        this.c = v4.a(context, str);
        this.e = z;
    }

    public q4(InitConfig initConfig, Context context, String str, String str2) {
        this.e = false;
        this.c = v4.a(initConfig, context, str);
        this.d = v4.a(initConfig, context, str2);
    }

    public static SharedPreferences a(Context context, String str, int i) {
        Context contextCreateDeviceProtectedStorageContext;
        Throwable th;
        try {
            contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            try {
                if (!contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                    LoggerImpl.global().warn(Collections.singletonList("SharedPreferenceCacheHelper"), "Failed to migrate shared preferences.", new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                LoggerImpl.global().error(Collections.singletonList("SharedPreferenceCacheHelper"), "Create protected storage context failed", th, new Object[0]);
                return contextCreateDeviceProtectedStorageContext.getSharedPreferences(str, i);
            }
        } catch (Throwable th3) {
            contextCreateDeviceProtectedStorageContext = context;
            th = th3;
        }
        return contextCreateDeviceProtectedStorageContext.getSharedPreferences(str, i);
    }

    public static synchronized q4 a(Context context) {
        if (f == null) {
            f = new q4(context, "_global_cache", true);
        }
        return f;
    }

    public synchronized String a(String str, a aVar) {
        if (d(str).contains(str)) {
            return e(str);
        }
        String strA = aVar != null ? aVar.a() : null;
        h(str, strA);
        return strA;
    }

    @Override // com.bytedance.bdtracker.f4
    public void a(String str) {
        IKVStore iKVStoreD = d(str);
        if (iKVStoreD != null && iKVStoreD.contains(str)) {
            iKVStoreD.remove(str);
        }
        super.a(str);
    }

    @Override // com.bytedance.bdtracker.f4
    public void a(String str, String str2) {
        h(str, str2);
    }

    @Override // com.bytedance.bdtracker.f4
    public void a(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return;
        }
        h(str, TextUtils.join("\n", strArr));
    }

    @Override // com.bytedance.bdtracker.f4
    public String b(String str) {
        return d(str).getString(str, null);
    }

    @Override // com.bytedance.bdtracker.f4
    public String[] c(String str) {
        String string = d(str).getString(str, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string.split("\n");
    }

    public IKVStore d(String str) {
        IKVStore iKVStore;
        return (!"device_id".equals(str) || (iKVStore = this.d) == null) ? this.c : iKVStore;
    }

    public String e(String str) {
        return d(str).getString(str, null);
    }

    public void h(String str, String str2) {
        if (this.e || !TextUtils.isEmpty(str2)) {
            IKVStore iKVStoreD = d(str);
            if (this.e && str2 == null) {
                iKVStoreD.putString(str, "");
            } else {
                iKVStoreD.putString(str, str2);
            }
        }
    }
}
