package com.baidu.mshield.x6.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.x6.f.f;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f32551a;

    public a(Context r100) {
        SharedPreferences r101 = r100.getSharedPreferences("msgzpfc", 4);     // Catch: Throwable -> L5
        this.f32551a = r101;     // Catch: Throwable -> L5
        r101.edit();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.b(th);
    }

    public String a(String r100) {
        return this.f32551a.getString(r100, "");
    }
}
