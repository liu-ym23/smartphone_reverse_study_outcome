package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14410a;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f14412c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f14413d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14414e;

    /* renamed from: f, reason: collision with root package name */
    public String f14415f;

    /* renamed from: g, reason: collision with root package name */
    public int f14416g;

    /* renamed from: i, reason: collision with root package name */
    public PreferenceScreen f14418i;

    /* renamed from: j, reason: collision with root package name */
    public c f14419j;

    /* renamed from: k, reason: collision with root package name */
    public a f14420k;

    /* renamed from: l, reason: collision with root package name */
    public b f14421l;

    /* renamed from: b, reason: collision with root package name */
    public long f14411b = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f14417h = 0;

    public interface a {
        void onDisplayPreferenceDialog(Preference preference);
    }

    public interface b {
        void onNavigateToScreen(PreferenceScreen preferenceScreen);
    }

    public interface c {
        boolean onPreferenceTreeClick(Preference preference);
    }

    public static abstract class d {
    }

    public j(Context context) {
        this.f14410a = context;
        q(b(context));
    }

    public static String b(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public <T extends Preference> T a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f14418i;
        if (preferenceScreen == null) {
            return null;
        }
        return (T) preferenceScreen.findPreference(charSequence);
    }

    public SharedPreferences.Editor c() {
        if (!this.f14414e) {
            return j().edit();
        }
        if (this.f14413d == null) {
            this.f14413d = j().edit();
        }
        return this.f14413d;
    }

    public long d() {
        long j10;
        synchronized (this) {
            j10 = this.f14411b;
            this.f14411b = 1 + j10;
        }
        return j10;
    }

    public b e() {
        return this.f14421l;
    }

    public c f() {
        return this.f14419j;
    }

    public d g() {
        return null;
    }

    public e h() {
        return null;
    }

    public PreferenceScreen i() {
        return this.f14418i;
    }

    public SharedPreferences j() {
        h();
        if (this.f14412c == null) {
            this.f14412c = (this.f14417h != 1 ? this.f14410a : androidx.core.content.a.b(this.f14410a)).getSharedPreferences(this.f14415f, this.f14416g);
        }
        return this.f14412c;
    }

    public PreferenceScreen k(Context context, int i10, PreferenceScreen preferenceScreen) {
        l(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new i(context, this).d(i10, preferenceScreen);
        preferenceScreen2.onAttachedToHierarchy(this);
        l(false);
        return preferenceScreen2;
    }

    public final void l(boolean z10) {
        SharedPreferences.Editor editor;
        if (!z10 && (editor = this.f14413d) != null) {
            editor.apply();
        }
        this.f14414e = z10;
    }

    public void m(a aVar) {
        this.f14420k = aVar;
    }

    public void n(b bVar) {
        this.f14421l = bVar;
    }

    public void o(c cVar) {
        this.f14419j = cVar;
    }

    public boolean p(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f14418i;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.onDetached();
        }
        this.f14418i = preferenceScreen;
        return true;
    }

    public void q(String str) {
        this.f14415f = str;
        this.f14412c = null;
    }

    public boolean r() {
        return !this.f14414e;
    }

    public void s(Preference preference) {
        a aVar = this.f14420k;
        if (aVar != null) {
            aVar.onDisplayPreferenceDialog(preference);
        }
    }
}
