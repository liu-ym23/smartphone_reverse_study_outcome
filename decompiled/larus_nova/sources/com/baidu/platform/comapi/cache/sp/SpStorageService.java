package com.baidu.platform.comapi.cache.sp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mapapi.JNIInitializer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
final class SpStorageService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f32885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SpStorageConfig f32886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f32887c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SharedPreferences f32888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SharedPreferences.Editor f32889b;

        public a(SharedPreferences r100) {
            this.f32888a = r100;
        }

        public static /* synthetic */ SharedPreferences.Editor a(a r100) {
            return r100.f32889b;
        }

        public static /* synthetic */ SharedPreferences b(a r100) {
            return r100.f32888a;
        }

        public static /* synthetic */ SharedPreferences.Editor a(a r100, SharedPreferences.Editor r101) {
            r100.f32889b = r101;
            return r101;
        }
    }

    static {
        f32885a = new HashMap();
    }

    private void a() {
        SpStorageConfig r100 = this.f32886b;
        monitor-enter(r100);
        a r101 = this.f32887c;     // Catch: Throwable -> L11
        if (a.a(r101) == null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        a.a(r101, a.b(r101).edit());     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private SpStorageService(SpStorageConfig r100) {
        if (JNIInitializer.getCachedContext() != null) goto L5;
        return;
    L5:
        this.f32886b = r100;
        String r101 = r100.getStorageName();
        if (r100.isCacheModel() == true) goto L9;
        this.f32887c = new a(JNIInitializer.getCachedContext().getSharedPreferences(r101, 0));
        return;
    L9:
        Map<String, a> r102 = f32885a;
        a r103 = r102.get(r101);
        if (r103 == null) goto L13;
        this.f32887c = r103;
        return;
    L13:
        a r104 = new a(JNIInitializer.getCachedContext().getSharedPreferences(r101, 0));
        this.f32887c = r104;
        r102.put(r101, r104);
    }

    public void a(String r100) {
        SpStorageConfig r101 = this.f32886b;
        monitor-enter(r101);
        a();     // Catch: Throwable -> L7
        a.a(this.f32887c).remove(r100).apply();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static SpStorageService a(SpStorageConfig r100) {
        if (TextUtils.isEmpty(r100.getStorageName()) == true) goto L7;
        return new SpStorageService(r100);
    L7:
        throw new IllegalArgumentException();
    }

    public float a(String r100, float r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        float r103 = a.b(this.f32887c).getFloat(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(String r100, float r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        a();     // Catch: Throwable -> L7
        a.a(this.f32887c).putFloat(r100, r101).apply();     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int a(String r100, int r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        int r103 = a.b(this.f32887c).getInt(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(String r100, int r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        a();     // Catch: Throwable -> L7
        a.a(this.f32887c).putInt(r100, r101).apply();     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public long a(String r100, long r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        long r103 = a.b(this.f32887c).getLong(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(String r100, long r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        a();     // Catch: Throwable -> L7
        a.a(this.f32887c).putLong(r100, r101).apply();     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String a(String r100, String r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        String r103 = a.b(this.f32887c).getString(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(String r100, String r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        a();     // Catch: Throwable -> L7
        a.a(this.f32887c).putString(r100, r101).apply();     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean a(String r100, boolean r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        boolean r103 = a.b(this.f32887c).getBoolean(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(String r100, boolean r101) {
        SpStorageConfig r102 = this.f32886b;
        monitor-enter(r102);
        a();     // Catch: Throwable -> L7
        a.a(this.f32887c).putBoolean(r100, r101).apply();     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
