package com.baidu.mshield;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f8259a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f8260b;

    public a(Context context) {
        try {
            SharedPreferences sharedPreferencesC = com.baidu.mshield.sharedpreferences.a.a(context).c("msgzpfc");
            this.f8259a = sharedPreferencesC;
            this.f8260b = sharedPreferencesC.edit();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.c(th.getMessage());
        }
    }

    public boolean a() {
        return this.f8259a.getInt("cloud_sw", 0) == 1;
    }

    public int b() {
        return this.f8259a.getInt("wm_in_ma_cco", 3);
    }

    public void a(String str, int i4) {
        this.f8260b.putInt("wm_in_cco" + str, i4);
        this.f8260b.commit();
    }

    public int a(String str) {
        return this.f8259a.getInt("wm_in_cco" + str, 0);
    }
}
