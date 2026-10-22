package i;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f32990f;

    /* renamed from: a, reason: collision with root package name */
    public int f32991a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f32992b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f32993c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f32994d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f32995e;

    public d() {
        super(null);
    }

    public static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f32990f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f32990f = configuration2;
        }
        return configuration.equals(f32990f);
    }

    public void a(Configuration configuration) {
        if (this.f32995e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f32994d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f32994d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f32995e == null) {
            Configuration configuration = this.f32994d;
            if (configuration == null || e(configuration)) {
                this.f32995e = super.getResources();
            } else {
                this.f32995e = createConfigurationContext(this.f32994d).getResources();
            }
        }
        return this.f32995e;
    }

    public int c() {
        return this.f32991a;
    }

    public final void d() {
        boolean z10 = this.f32992b == null;
        if (z10) {
            this.f32992b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f32992b.setTo(theme);
            }
        }
        f(this.f32992b, this.f32991a, z10);
    }

    public void f(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
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
        if (this.f32993c == null) {
            this.f32993c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f32993c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f32992b;
        if (theme != null) {
            return theme;
        }
        if (this.f32991a == 0) {
            this.f32991a = R$style.Theme_AppCompat_Light;
        }
        d();
        return this.f32992b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f32991a != i10) {
            this.f32991a = i10;
            d();
        }
    }

    public d(Context context, int i10) {
        super(context);
        this.f32991a = i10;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f32992b = theme;
    }
}
