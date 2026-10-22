package z3;

import a7.g;
import android.content.Context;
import android.preference.PreferenceManager;
import t3.f;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f11799b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final f f11800a;

    public a(g gVar) {
        Context context = (Context) gVar.f418g;
        String str = (String) gVar.f419h;
        String str2 = (String) gVar.f420i;
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            applicationContext.getSharedPreferences(str2, 0).edit();
        }
        this.f11800a = (f) gVar.f424m;
    }
}
