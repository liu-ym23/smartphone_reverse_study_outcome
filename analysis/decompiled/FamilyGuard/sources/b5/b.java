package b5;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private Object f11834a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f11835b;

    /* renamed from: c, reason: collision with root package name */
    private a f11836c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11837d = true;

    public interface a {
        boolean a();
    }

    /* renamed from: b5.b$b, reason: collision with other inner class name */
    public interface InterfaceC0154b {
        boolean a(b bVar, MenuItem menuItem);

        boolean b(b bVar, Menu menu);

        void c(b bVar);

        boolean d(b bVar, Menu menu);
    }

    public abstract void a();

    public a b() {
        return this.f11836c;
    }

    public abstract View e();

    public abstract Menu f();

    public abstract MenuInflater g();

    public abstract CharSequence h();

    public Object i() {
        return this.f11834a;
    }

    public abstract CharSequence j();

    public boolean k() {
        return this.f11835b;
    }

    public abstract void l();

    public boolean m() {
        return this.f11837d;
    }

    public abstract boolean n();

    public void o(a aVar) {
        this.f11836c = aVar;
    }

    public abstract void p(View view);

    public abstract void q(int i5);

    public abstract void r(CharSequence charSequence);

    public void s(Object obj) {
        this.f11834a = obj;
    }

    public abstract void t(int i5);

    public abstract void u(CharSequence charSequence);

    public void v(boolean z5) {
        this.f11835b = z5;
    }
}
