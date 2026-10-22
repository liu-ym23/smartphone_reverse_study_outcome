package com.baidu.platform.comapi.c;

import com.baidu.platform.comapi.logstatistics.LogStatistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f32876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f32877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LogStatistics f32878c;

    private void b() {
        f32876a = null;
        f32876a = new JSONObject();
    }

    public static a a() {
        if (f32877b != null) goto L6;
        f32877b = new a();
    L6:
        if (f32876a != null) goto L9;
        f32876a = new JSONObject();
    L9:
        return f32877b;
    }

    public a() {
        this.f32878c = null;
    }

    public synchronized boolean a(String r100) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f32878c != null) goto L7;
        this.f32878c = LogStatistics.getInstance();     // Catch: Throwable -> L19
    L7:
        if (this.f32878c == null) goto L16;
        JSONObject r101 = f32876a;     // Catch: Throwable -> L19
        if (r101 != null) goto L11;
    L13:
        boolean r102 = this.f32878c.a(1100, 1, r100, null);     // Catch: Throwable -> L19
    L14:
        b();     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return r102;
    L11:
        if (r101.length() <= 0) goto L13;
        r102 = this.f32878c.a(1100, 1, r100, f32876a.toString());     // Catch: Throwable -> L19
        goto L14
    L16:
        r102 = false;
        goto L17
    }
}
