package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SubUiVisibilityListener f2657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VisibilityListener f2658c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean r10);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean r10);
    }

    public ActionProvider(Context r10) {
        this.f2656a = r10;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract View c(MenuItem r10);

    public abstract boolean d();

    public abstract void e(SubMenu r10);

    public abstract boolean f();

    public void g() {
        this.f2658c = null;
        this.f2657b = null;
    }

    public void h(SubUiVisibilityListener r10) {
        this.f2657b = r10;
    }

    public abstract void i(VisibilityListener r10);

    public void j(boolean r10) {
        SubUiVisibilityListener r11 = this.f2657b;
        if (r11 == null) goto L6;
        r11.onSubUiVisibilityChanged(r10);
        return;
    }
}
