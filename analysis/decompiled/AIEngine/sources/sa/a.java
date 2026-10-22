package sa;

import android.content.Context;
import android.content.SharedPreferences;
import ta.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f11898a;

    public a(Context context, String str) {
        c.d("SharedPreferencesHelper", "init SharedPreferences, name: " + str);
        this.f11898a = context.getSharedPreferences(str, 0);
        c.a("SharedPreferencesHelper", str + " structure complete");
    }

    public final void a(String str, String str2) {
        this.f11898a.edit().putString(str, str2).commit();
    }
}
