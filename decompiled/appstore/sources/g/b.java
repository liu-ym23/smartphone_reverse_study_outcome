package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.annotation.DoNotInline;
import androidx.appcompat.R$style;

/* JADX INFO: loaded from: classes.dex */
public class b extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f19729f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f19731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f19732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f19733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f19734e;

    public static class a {
        @DoNotInline
        public static Context a(b r10, Configuration r11) {
            return r10.createConfigurationContext(r11);
        }
    }

    public b(Context r10, int r11) {
        super(r10);
        this.f19730a = r11;
    }

    public static boolean d(Configuration r10) {
        if (r10 != null) goto L6;
        return true;
    L6:
        if (f19729f != null) goto L9;
        Configuration r11 = new Configuration();
        r11.fontScale = 0.0f;
        f19729f = r11;
    L9:
        return r10.equals(f19729f);
    }

    public void a(Configuration r10) {
        if (this.f19734e != null) goto L11;
        if (this.f19733d != null) goto L9;
        this.f19733d = new Configuration(r10);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r10) {
        super.attachBaseContext(r10);
    }

    public final Resources b() {
        if (this.f19734e != null) goto L12;
        Configuration r10 = this.f19733d;
        if (r10 != null) goto L7;
    L10:
        this.f19734e = super.getResources();
        goto L12
    L7:
        if (d(r10) == true) goto L10;
        this.f19734e = a.a(this, this.f19733d).getResources();
    L12:
        return this.f19734e;
    }

    public final void c() {
        if (this.f19731b != null) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        this.f19731b = getResources().newTheme();
        Resources.Theme r11 = getBaseContext().getTheme();
        if (r11 == null) goto L10;
        this.f19731b.setTo(r11);
    L10:
        e(this.f19731b, this.f19730a, r10);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public void e(Resources.Theme r10, int r11, boolean r12) {
        r10.applyStyle(r11, true);
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
    public Object getSystemService(String r10) {
        if ("layout_inflater".equals(r10) == false) goto L10;
        if (this.f19732c != null) goto L8;
        this.f19732c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L8:
        return this.f19732c;
    L10:
        return getBaseContext().getSystemService(r10);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r10 = this.f19731b;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.f19730a != 0) goto L8;
        this.f19730a = R$style.Theme_AppCompat_Light;
    L8:
        c();
        return this.f19731b;
    }

    public int getThemeResId() {
        return this.f19730a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r10) {
        if (this.f19730a == r10) goto L6;
        this.f19730a = r10;
        c();
        return;
    }

    public b(Context r10, Resources.Theme r11) {
        super(r10);
        this.f19731b = r11;
    }
}
