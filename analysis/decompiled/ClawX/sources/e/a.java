package e;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.stepos.stepclaw.R;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public int f2250a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f2251b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f2252c;
    public Resources d;

    public final void a() {
        if (this.f2251b == null) {
            this.f2251b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2251b.setTo(theme);
            }
        }
        this.f2251b.applyStyle(this.f2250a, true);
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
        if (this.d == null) {
            this.d = super.getResources();
        }
        return this.d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2252c == null) {
            this.f2252c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2252c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f2251b;
        if (theme != null) {
            return theme;
        }
        if (this.f2250a == 0) {
            this.f2250a = R.style.Theme_AppCompat_Light;
        }
        a();
        return this.f2251b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i8) {
        if (this.f2250a != i8) {
            this.f2250a = i8;
            a();
        }
    }
}
