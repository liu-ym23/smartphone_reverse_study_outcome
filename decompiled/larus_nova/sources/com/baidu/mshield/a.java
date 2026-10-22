package com.baidu.mshield;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f32358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f32359b;

    public boolean a() {
        if (this.f32358a.getInt("cloud_sw", 0) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public int b() {
        return this.f32358a.getInt("wm_in_ma_cco", 3);
    }

    public a(Context r100) {
        SharedPreferences r101 = com.baidu.mshield.sharedpreferences.a.a(r100).c("msgzpfc");     // Catch: Throwable -> L5
        this.f32358a = r101;     // Catch: Throwable -> L5
        this.f32359b = r101.edit();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.baidu.mshield.b.c.a.c(th.getMessage());
    }

    public int a(String r100) {
        return this.f32358a.getInt("wm_in_cco" + r100, 0);
    }

    public void a(String r100, int r101) {
        this.f32359b.putInt("wm_in_cco" + r100, r101);
        this.f32359b.commit();
    }
}
