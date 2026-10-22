package k;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f9773f;

    /* renamed from: a, reason: collision with root package name */
    public int f9774a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f9775b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f9776c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f9777d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f9778e;

    public c() {
        super(null);
    }

    public final void a(Configuration configuration) {
        if (this.f9778e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f9777d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f9777d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f9775b == null) {
            this.f9775b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f9775b.setTo(theme);
            }
        }
        this.f9775b.applyStyle(this.f9774a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f9778e
            if (r0 != 0) goto L32
            android.content.res.Configuration r0 = r3.f9777d
            if (r0 == 0) goto L2c
            android.content.res.Configuration r1 = k.c.f9773f
            if (r1 != 0) goto L16
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            k.c.f9773f = r1
        L16:
            android.content.res.Configuration r1 = k.c.f9773f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1f
            goto L2c
        L1f:
            android.content.res.Configuration r0 = r3.f9777d
            android.content.Context r0 = r3.createConfigurationContext(r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f9778e = r0
            goto L32
        L2c:
            android.content.res.Resources r0 = super.getResources()
            r3.f9778e = r0
        L32:
            android.content.res.Resources r3 = r3.f9778e
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k.c.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f9776c == null) {
            this.f9776c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f9776c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f9775b;
        if (theme != null) {
            return theme;
        }
        if (this.f9774a == 0) {
            this.f9774a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.f9775b;
    }

    public final int getThemeResId() {
        return this.f9774a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i10) {
        if (this.f9774a != i10) {
            this.f9774a = i10;
            b();
        }
    }

    public c(Context context, int i10) {
        super(context);
        this.f9774a = i10;
    }
}
