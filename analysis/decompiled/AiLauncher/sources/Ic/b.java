package Ic;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public Object f3431a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3432b;

    /* renamed from: c, reason: collision with root package name */
    public a f3433c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3434d = true;

    public interface a {
        boolean onBackPressed();
    }

    /* renamed from: Ic.b$b, reason: collision with other inner class name */
    public interface InterfaceC0060b {
        void a(b bVar);

        boolean b(b bVar, Menu menu);

        boolean c(b bVar, MenuItem menuItem);

        boolean d(b bVar, Menu menu);
    }

    public abstract void c();

    public a d() {
        return this.f3433c;
    }

    public abstract View e();

    public abstract Menu f();

    public abstract MenuInflater g();

    public abstract CharSequence h();

    public Object i() {
        return this.f3431a;
    }

    public abstract CharSequence j();

    public boolean k() {
        return this.f3432b;
    }

    public abstract void l();

    public boolean m() {
        return this.f3434d;
    }

    public abstract boolean n();

    public void o(a aVar) {
        this.f3433c = aVar;
    }

    public abstract void p(View view);

    public abstract void q(int i10);

    public abstract void r(CharSequence charSequence);

    public void s(Object obj) {
        this.f3431a = obj;
    }

    public abstract void t(int i10);

    public abstract void u(CharSequence charSequence);

    public void v(boolean z10) {
        this.f3432b = z10;
    }
}
