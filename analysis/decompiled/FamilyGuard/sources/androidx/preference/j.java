package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Context f11109a;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f11111c;

    /* renamed from: d, reason: collision with root package name */
    private SharedPreferences.Editor f11112d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11113e;

    /* renamed from: f, reason: collision with root package name */
    private String f11114f;

    /* renamed from: g, reason: collision with root package name */
    private int f11115g;

    /* renamed from: i, reason: collision with root package name */
    private PreferenceScreen f11117i;

    /* renamed from: j, reason: collision with root package name */
    private c f11118j;

    /* renamed from: k, reason: collision with root package name */
    private a f11119k;

    /* renamed from: l, reason: collision with root package name */
    private b f11120l;

    /* renamed from: b, reason: collision with root package name */
    private long f11110b = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f11116h = 0;

    public interface a {
        void g(Preference preference);
    }

    public interface b {
        void h(PreferenceScreen preferenceScreen);
    }

    public interface c {
        boolean j(Preference preference);
    }

    public static abstract class d {
    }

    public j(Context context) {
        this.f11109a = context;
        s(d(context));
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences(d(context), c());
    }

    private static int c() {
        return 0;
    }

    private static String d(Context context) {
        return context.getPackageName() + "_preferences";
    }

    private void n(boolean z5) {
        SharedPreferences.Editor editor;
        if (!z5 && (editor = this.f11112d) != null) {
            editor.apply();
        }
        this.f11113e = z5;
    }

    public <T extends Preference> T a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f11117i;
        if (preferenceScreen == null) {
            return null;
        }
        return (T) preferenceScreen.T0(charSequence);
    }

    SharedPreferences.Editor e() {
        if (!this.f11113e) {
            return l().edit();
        }
        if (this.f11112d == null) {
            this.f11112d = l().edit();
        }
        return this.f11112d;
    }

    long f() {
        long j5;
        synchronized (this) {
            j5 = this.f11110b;
            this.f11110b = 1 + j5;
        }
        return j5;
    }

    public b g() {
        return this.f11120l;
    }

    public c h() {
        return this.f11118j;
    }

    public d i() {
        return null;
    }

    public e j() {
        return null;
    }

    public PreferenceScreen k() {
        return this.f11117i;
    }

    public SharedPreferences l() {
        j();
        if (this.f11111c == null) {
            this.f11111c = (this.f11116h != 1 ? this.f11109a : androidx.core.content.a.b(this.f11109a)).getSharedPreferences(this.f11114f, this.f11115g);
        }
        return this.f11111c;
    }

    public PreferenceScreen m(Context context, int i5, PreferenceScreen preferenceScreen) {
        n(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new i(context, this).d(i5, preferenceScreen);
        preferenceScreen2.U(this);
        n(false);
        return preferenceScreen2;
    }

    public void o(a aVar) {
        this.f11119k = aVar;
    }

    public void p(b bVar) {
        this.f11120l = bVar;
    }

    public void q(c cVar) {
        this.f11118j = cVar;
    }

    public boolean r(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f11117i;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.Z();
        }
        this.f11117i = preferenceScreen;
        return true;
    }

    public void s(String str) {
        this.f11114f = str;
        this.f11111c = null;
    }

    boolean t() {
        return !this.f11113e;
    }

    public void u(Preference preference) {
        a aVar = this.f11119k;
        if (aVar != null) {
            aVar.g(preference);
        }
    }
}
