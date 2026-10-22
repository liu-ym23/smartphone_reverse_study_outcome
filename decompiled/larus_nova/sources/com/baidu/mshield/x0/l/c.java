package com.baidu.mshield.x0.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.x0.d.d;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f32545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f32546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f32547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f32548d;

    public String a() {
        return this.f32545a.getString("s_h_d_id", "");
    }

    public String b() {
        return this.f32545a.getString("rpnewuid", "");
    }

    public String c() {
        String r100 = this.f32545a.getString("rpnewuidn", "");
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return new String(com.baidu.mshield.b.f.a.a(Base64.decode(r100, 10), com.baidu.mshield.b.f.a.a(24)), "UTF-8");
    L7:
        th = move-exception;
        d.a(th);
        return "";
    }

    public String d() {
        return this.f32545a.getString("xytk", "");
    }

    public String e() {
        return this.f32545a.getString("xytk2", "");
    }

    public String f() {
        return this.f32545a.getString("sgud", "");
    }

    public c(Context r100) {
        SharedPreferences r101 = F.getInstance().getPlatformSharedSharedPreferences(r100);     // Catch: Throwable -> L5
        this.f32545a = r101;     // Catch: Throwable -> L5
        this.f32546b = r101.edit();     // Catch: Throwable -> L5
        SharedPreferences r102 = F.getInstance().getPlatformPrivateSharedPreferences(r100);     // Catch: Throwable -> L5
        this.f32547c = r102;     // Catch: Throwable -> L5
        this.f32548d = r102.edit();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.a(th);
    }

    public void a(String r100) {
        this.f32546b.putString("rpnewuid", r100);
        this.f32546b.commit();
    }

    public void b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L12;
        this.f32546b.putString("rpnewuidn", "");
        this.f32546b.commit();
        return;
    L12:
        String r101 = new String(Base64.encode(com.baidu.mshield.b.f.a.b(r100.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(24)), 10), "UTF-8");     // Catch: Throwable -> L9
        this.f32546b.putString("rpnewuidn", r101);
        this.f32546b.commit();
        return;
    L9:
        th = move-exception;
        d.a(th);
    }

    public void c(String r100) {
        this.f32548d.putString("p_s_p_c", r100);
        this.f32548d.commit();
    }

    public void d(String r100) {
        this.f32546b.putString("xytk", r100);
        this.f32546b.apply();
    }

    public void e(String r100) {
        this.f32546b.putString("xytk2", r100);
        this.f32546b.apply();
    }

    public void f(String r100) {
        this.f32546b.putString("sgud", r100);
        this.f32546b.commit();
    }
}
