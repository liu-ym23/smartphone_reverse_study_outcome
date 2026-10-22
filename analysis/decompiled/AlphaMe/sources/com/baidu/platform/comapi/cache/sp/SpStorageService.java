package com.baidu.platform.comapi.cache.sp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mapapi.JNIInitializer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class SpStorageService {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f8743a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private SpStorageConfig f8744b;

    /* renamed from: c, reason: collision with root package name */
    private a f8745c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final SharedPreferences f8746a;

        /* renamed from: b, reason: collision with root package name */
        private SharedPreferences.Editor f8747b;

        public a(SharedPreferences sharedPreferences) {
            this.f8746a = sharedPreferences;
        }
    }

    private SpStorageService(SpStorageConfig spStorageConfig) {
        if (JNIInitializer.getCachedContext() == null) {
            return;
        }
        this.f8744b = spStorageConfig;
        String storageName = spStorageConfig.getStorageName();
        if (!spStorageConfig.isCacheModel()) {
            this.f8745c = new a(JNIInitializer.getCachedContext().getSharedPreferences(storageName, 0));
            return;
        }
        Map<String, a> map = f8743a;
        a aVar = map.get(storageName);
        if (aVar != null) {
            this.f8745c = aVar;
            return;
        }
        a aVar2 = new a(JNIInitializer.getCachedContext().getSharedPreferences(storageName, 0));
        this.f8745c = aVar2;
        map.put(storageName, aVar2);
    }

    public static SpStorageService a(SpStorageConfig spStorageConfig) {
        if (TextUtils.isEmpty(spStorageConfig.getStorageName())) {
            throw new IllegalArgumentException();
        }
        return new SpStorageService(spStorageConfig);
    }

    public void b(String str, int i4) {
        synchronized (this.f8744b) {
            a();
            this.f8745c.f8747b.putInt(str, i4).apply();
        }
    }

    public int a(String str, int i4) {
        int i5;
        synchronized (this.f8744b) {
            i5 = this.f8745c.f8746a.getInt(str, i4);
        }
        return i5;
    }

    public void b(String str, float f4) {
        synchronized (this.f8744b) {
            a();
            this.f8745c.f8747b.putFloat(str, f4).apply();
        }
    }

    public float a(String str, float f4) {
        float f5;
        synchronized (this.f8744b) {
            f5 = this.f8745c.f8746a.getFloat(str, f4);
        }
        return f5;
    }

    public void b(String str, long j4) {
        synchronized (this.f8744b) {
            a();
            this.f8745c.f8747b.putLong(str, j4).apply();
        }
    }

    public long a(String str, long j4) {
        long j5;
        synchronized (this.f8744b) {
            j5 = this.f8745c.f8746a.getLong(str, j4);
        }
        return j5;
    }

    public void b(String str, boolean z4) {
        synchronized (this.f8744b) {
            a();
            this.f8745c.f8747b.putBoolean(str, z4).apply();
        }
    }

    public boolean a(String str, boolean z4) {
        boolean z5;
        synchronized (this.f8744b) {
            z5 = this.f8745c.f8746a.getBoolean(str, z4);
        }
        return z5;
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this.f8744b) {
            string = this.f8745c.f8746a.getString(str, str2);
        }
        return string;
    }

    public void b(String str, String str2) {
        synchronized (this.f8744b) {
            a();
            this.f8745c.f8747b.putString(str, str2).apply();
        }
    }

    public void a(String str) {
        synchronized (this.f8744b) {
            a();
            this.f8745c.f8747b.remove(str).apply();
        }
    }

    private void a() {
        synchronized (this.f8744b) {
            try {
                a aVar = this.f8745c;
                if (aVar.f8747b != null) {
                    return;
                }
                aVar.f8747b = aVar.f8746a.edit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
