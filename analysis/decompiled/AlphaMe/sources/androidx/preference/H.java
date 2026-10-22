package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4022a;

    /* renamed from: b, reason: collision with root package name */
    public long f4023b = 0;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f4024c = null;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f4025d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4026e;

    /* renamed from: f, reason: collision with root package name */
    public final String f4027f;

    /* renamed from: g, reason: collision with root package name */
    public PreferenceScreen f4028g;

    /* renamed from: h, reason: collision with root package name */
    public G f4029h;

    /* renamed from: i, reason: collision with root package name */
    public E f4030i;

    /* renamed from: j, reason: collision with root package name */
    public F f4031j;

    public H(Context context) {
        this.f4022a = context;
        this.f4027f = context.getPackageName() + "_preferences";
    }

    public final SharedPreferences.Editor a() {
        if (!this.f4026e) {
            return b().edit();
        }
        if (this.f4025d == null) {
            this.f4025d = b().edit();
        }
        return this.f4025d;
    }

    public final SharedPreferences b() {
        if (this.f4024c == null) {
            this.f4024c = this.f4022a.getSharedPreferences(this.f4027f, 0);
        }
        return this.f4024c;
    }

    public final PreferenceScreen c(Context context, int i4, PreferenceScreen preferenceScreen) throws Resources.NotFoundException {
        this.f4026e = true;
        D d4 = new D(context, this);
        XmlResourceParser xml = context.getResources().getXml(i4);
        try {
            PreferenceGroup preferenceGroupC = d4.c(xml, preferenceScreen);
            xml.close();
            PreferenceScreen preferenceScreen2 = (PreferenceScreen) preferenceGroupC;
            preferenceScreen2.k(this);
            SharedPreferences.Editor editor = this.f4025d;
            if (editor != null) {
                editor.apply();
            }
            this.f4026e = false;
            return preferenceScreen2;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
