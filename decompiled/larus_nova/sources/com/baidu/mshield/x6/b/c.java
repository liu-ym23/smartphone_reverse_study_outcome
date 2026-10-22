package com.baidu.mshield.x6.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.x6.f.f;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f32575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f32576b;

    public String a() {
        return this.f32575a.getString("wmcudd", "");
    }

    public String b() {
        return this.f32575a.getString("xytk", "");
    }

    public String c() {
        return this.f32575a.getString("xytk2", "");
    }

    public String d() {
        return this.f32575a.getString("xytkrt2", "");
    }

    public String e() {
        return this.f32575a.getString("xytk_m", "");
    }

    public String f() {
        return this.f32575a.getString("xytkrt", "");
    }

    public c(Context r100) {
        SharedPreferences r101 = F.getInstance().getPlatformSharedSharedPreferences(r100);     // Catch: Throwable -> L5
        this.f32575a = r101;     // Catch: Throwable -> L5
        this.f32576b = r101.edit();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.b(th);
    }

    public void a(String r100) {
        this.f32576b.putString("xytk", r100);
        this.f32576b.commit();
    }

    public void b(String r100) {
        this.f32576b.putString("xytk2", r100);
        this.f32576b.commit();
    }

    public void c(String r100) {
        this.f32576b.putString("xytkrt2", r100);
        this.f32576b.commit();
    }

    public void d(String r100) {
        this.f32576b.putString("xytkrt", r100);
        this.f32576b.commit();
    }
}
