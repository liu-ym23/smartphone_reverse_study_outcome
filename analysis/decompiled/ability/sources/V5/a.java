package V5;

import W5.c;
import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f1385a;

    public a(Context context, String str) {
        c.d("SharedPreferencesHelper", "init SharedPreferences, name: " + str);
        this.f1385a = context.getSharedPreferences(str, 0);
        c.a("SharedPreferencesHelper", str + " structure complete");
    }

    public final void a(String str, String str2) {
        this.f1385a.edit().putString(str, str2).commit();
    }
}
