package j;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class e extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public int f13049a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f13050b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f13051c;

    /* renamed from: d, reason: collision with root package name */
    public Resources f13052d;

    public e(Context context, int i4) {
        super(context);
        this.f13049a = i4;
    }

    public final void a() {
        if (this.f13050b == null) {
            this.f13050b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f13050b.setTo(theme);
            }
        }
        this.f13050b.applyStyle(this.f13049a, true);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        if (this.f13052d == null) {
            this.f13052d = super.getResources();
        }
        return this.f13052d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f13051c == null) {
            this.f13051c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f13051c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f13050b;
        if (theme != null) {
            return theme;
        }
        if (this.f13049a == 0) {
            this.f13049a = R.style.Theme_AppCompat_Light;
        }
        a();
        return this.f13050b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i4) {
        if (this.f13049a != i4) {
            this.f13049a = i4;
            a();
        }
    }
}
