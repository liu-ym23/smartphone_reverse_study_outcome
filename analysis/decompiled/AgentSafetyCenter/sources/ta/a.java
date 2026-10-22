package ta;

import android.content.Context;
import android.content.SharedPreferences;
import ua.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f13291a;

    public a(Context context, String str) {
        c.d("SharedPreferencesHelper", "init SharedPreferences, name: ".concat(str));
        this.f13291a = context.getSharedPreferences(str, 0);
        c.a("SharedPreferencesHelper", str.concat(" structure complete"));
    }

    public final void a(String str, String str2) {
        this.f13291a.edit().putString(str, str2).commit();
    }
}
