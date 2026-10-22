package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2409a;

    /* renamed from: b, reason: collision with root package name */
    public long f2410b = 0;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f2411c = null;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f2412d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2413e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2414f;

    /* renamed from: g, reason: collision with root package name */
    public PreferenceScreen f2415g;
    public PreferenceFragmentCompat h;

    /* renamed from: i, reason: collision with root package name */
    public PreferenceFragmentCompat f2416i;

    /* renamed from: j, reason: collision with root package name */
    public PreferenceFragmentCompat f2417j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void onDisplayPreferenceDialog(Preference preference);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        void onNavigateToScreen(PreferenceScreen preferenceScreen);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c {
        boolean onPreferenceTreeClick(Preference preference);
    }

    public f(Context context) {
        this.f2409a = context;
        this.f2414f = context.getPackageName() + "_preferences";
    }

    public final SharedPreferences.Editor a() {
        if (!this.f2413e) {
            return b().edit();
        }
        if (this.f2412d == null) {
            this.f2412d = b().edit();
        }
        return this.f2412d;
    }

    public final SharedPreferences b() {
        if (this.f2411c == null) {
            this.f2411c = this.f2409a.getSharedPreferences(this.f2414f, 0);
        }
        return this.f2411c;
    }

    public final PreferenceScreen c(Context context, int i10, PreferenceScreen preferenceScreen) {
        this.f2413e = true;
        e eVar = new e(context, this);
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            PreferenceGroup preferenceGroupC = eVar.c(xml, preferenceScreen);
            xml.close();
            PreferenceScreen preferenceScreen2 = (PreferenceScreen) preferenceGroupC;
            preferenceScreen2.m(this);
            SharedPreferences.Editor editor = this.f2412d;
            if (editor != null) {
                editor.apply();
            }
            this.f2413e = false;
            return preferenceScreen2;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
