package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private Object f7707a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7708b;

    public interface a {
        void a(b bVar);

        boolean b(b bVar, Menu menu);

        boolean c(b bVar, Menu menu);

        boolean d(b bVar, MenuItem menuItem);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f7707a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f7708b;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i5);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f7707a = obj;
    }

    public abstract void q(int i5);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z5) {
        this.f7708b = z5;
    }
}
