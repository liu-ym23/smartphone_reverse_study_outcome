package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    private static Configuration f7709f;

    /* renamed from: a, reason: collision with root package name */
    private int f7710a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f7711b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f7712c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f7713d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f7714e;

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f7714e == null) {
            Configuration configuration = this.f7713d;
            if (configuration == null || e(configuration)) {
                this.f7714e = super.getResources();
            } else {
                this.f7714e = createConfigurationContext(this.f7713d).getResources();
            }
        }
        return this.f7714e;
    }

    private void d() {
        boolean z5 = this.f7711b == null;
        if (z5) {
            this.f7711b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f7711b.setTo(theme);
            }
        }
        f(this.f7711b, this.f7710a, z5);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f7709f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f7709f = configuration2;
        }
        return configuration.equals(f7709f);
    }

    public void a(Configuration configuration) {
        if (this.f7714e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f7713d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f7713d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f7710a;
    }

    protected void f(Resources.Theme theme, int i5, boolean z5) {
        theme.applyStyle(i5, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f7712c == null) {
            this.f7712c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f7712c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f7711b;
        if (theme != null) {
            return theme;
        }
        if (this.f7710a == 0) {
            this.f7710a = g.i.f16980e;
        }
        d();
        return this.f7711b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i5) {
        if (this.f7710a != i5) {
            this.f7710a = i5;
            d();
        }
    }

    public d(Context context, int i5) {
        super(context);
        this.f7710a = i5;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f7711b = theme;
    }
}
