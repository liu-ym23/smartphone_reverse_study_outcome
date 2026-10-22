package com.baidu.mshield.x6.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.x6.f.f;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f8452a;

    public a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("msgzpfc", 4);
            this.f8452a = sharedPreferences;
            sharedPreferences.edit();
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public String a(String str) {
        return this.f8452a.getString(str, "");
    }
}
