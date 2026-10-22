package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: androidx.core.view.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1314b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13179a;

    /* renamed from: b, reason: collision with root package name */
    public a f13180b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0160b f13181c;

    /* renamed from: androidx.core.view.b$a */
    public interface a {
    }

    /* renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0160b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public AbstractC1314b(Context context) {
        this.f13179a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f13181c = null;
        this.f13180b = null;
    }

    public void i(a aVar) {
        this.f13180b = aVar;
    }

    public void j(InterfaceC0160b interfaceC0160b) {
        if (this.f13181c != null && interfaceC0160b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f13181c = interfaceC0160b;
    }
}
