package com.bytedance.apm.internal;

import android.content.SharedPreferences;
import com.bytedance.apm.constant.SlardarConfigConsts;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f6503a;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.internal.b$b, reason: collision with other inner class name */
    public static class C0073b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6504a = null;

        static {
            f6504a = new b(null);
        }

        public static /* synthetic */ b a() {
            return f6504a;
        }
    }

    public /* synthetic */ b(a r10) {
        this();
    }

    public static b a() {
        return C0073b.a();
    }

    public int b(String r10) {
        return this.f6503a.getInt(r10, -1);
    }

    public long c(String r10) {
        return this.f6503a.getLong(r10, 0);
    }

    public String d(String r10) {
        return this.f6503a.getString(r10, null);
    }

    public void e(String r10, int r11) {
        this.f6503a.edit().putInt(r10, r11).apply();
    }

    public void f(String r10, long r11) {
        this.f6503a.edit().putLong(r10, r11).apply();
    }

    public void g(String r10, String r11) {
        this.f6503a.edit().putString(r10, r11).apply();
    }

    public b() {
        this.f6503a = j1.b.g(c.g(), SlardarConfigConsts.MONITOR_CONFIG);
    }
}
