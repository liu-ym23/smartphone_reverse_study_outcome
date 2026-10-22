package S2;

import T2.d;
import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f1791a;

    public a(Context context, String str) {
        d.d("SharedPreferencesHelper", "init SharedPreferences, name: " + str);
        this.f1791a = context.getSharedPreferences(str, 0);
        d.a("SharedPreferencesHelper", str + " structure complete");
    }

    public final void a(String str, String str2) {
        this.f1791a.edit().putString(str, str2).commit();
    }
}
