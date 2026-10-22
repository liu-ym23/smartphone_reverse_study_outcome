package com.baidu.platform.comapi.d;

import com.baidu.platform.comapi.logstatistics.LogStatistics;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static JSONObject f8748a;

    /* renamed from: b, reason: collision with root package name */
    public static a f8749b;

    /* renamed from: c, reason: collision with root package name */
    private LogStatistics f8750c = null;

    public static a a() {
        if (f8749b == null) {
            f8749b = new a();
        }
        if (f8748a == null) {
            f8748a = new JSONObject();
        }
        return f8749b;
    }

    private void b() {
        f8748a = null;
        f8748a = new JSONObject();
    }

    public synchronized boolean a(String str) {
        boolean zA;
        try {
            if (this.f8750c == null) {
                this.f8750c = LogStatistics.getInstance();
            }
            if (this.f8750c != null) {
                JSONObject jSONObject = f8748a;
                if (jSONObject != null && jSONObject.length() > 0) {
                    zA = this.f8750c.a(1100, 1, str, f8748a.toString());
                } else {
                    zA = this.f8750c.a(1100, 1, str, (String) null);
                }
                b();
            } else {
                zA = false;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zA;
    }
}
