package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: androidx.core.view.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0457b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9800a;

    /* renamed from: b, reason: collision with root package name */
    private a f9801b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0123b f9802c;

    /* renamed from: androidx.core.view.b$a */
    public interface a {
    }

    /* renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0123b {
        void onActionProviderVisibilityChanged(boolean z5);
    }

    public AbstractC0457b(Context context) {
        this.f9800a = context;
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
        this.f9802c = null;
        this.f9801b = null;
    }

    public void i(a aVar) {
        this.f9801b = aVar;
    }

    public void j(InterfaceC0123b interfaceC0123b) {
        if (this.f9802c != null && interfaceC0123b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f9802c = interfaceC0123b;
    }
}
