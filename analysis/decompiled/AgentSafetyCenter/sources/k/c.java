package k;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f6799f;

    /* renamed from: a, reason: collision with root package name */
    public int f6800a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f6801b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f6802c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f6803d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f6804e;

    public c(Context context, int i) {
        super(context);
        this.f6800a = i;
    }

    public final void a(Configuration configuration) {
        if (this.f6804e != null) {
            od.f.e("getResources() or getAssets() has already been called");
        } else if (this.f6803d == null) {
            this.f6803d = new Configuration(configuration);
        } else {
            od.f.e("Override configuration has already been set");
        }
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f6801b == null) {
            this.f6801b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f6801b.setTo(theme);
            }
        }
        this.f6801b.applyStyle(this.f6800a, true);
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
            android.content.res.Resources r0 = r3.f6804e
            if (r0 != 0) goto L32
            android.content.res.Configuration r0 = r3.f6803d
            if (r0 == 0) goto L2c
            android.content.res.Configuration r1 = k.c.f6799f
            if (r1 != 0) goto L16
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            k.c.f6799f = r1
        L16:
            android.content.res.Configuration r1 = k.c.f6799f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1f
            goto L2c
        L1f:
            android.content.res.Configuration r0 = r3.f6803d
            android.content.Context r0 = r3.createConfigurationContext(r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f6804e = r0
            goto L32
        L2c:
            android.content.res.Resources r0 = super.getResources()
            r3.f6804e = r0
        L32:
            android.content.res.Resources r3 = r3.f6804e
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k.c.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f6802c == null) {
            this.f6802c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f6802c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f6801b;
        if (theme != null) {
            return theme;
        }
        if (this.f6800a == 0) {
            this.f6800a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.f6801b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (this.f6800a != i) {
            this.f6800a = i;
            b();
        }
    }
}
