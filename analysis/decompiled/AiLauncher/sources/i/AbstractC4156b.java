package i;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: i.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4156b {

    /* renamed from: a, reason: collision with root package name */
    public Object f32988a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f32989b;

    /* renamed from: i.b$a */
    public interface a {
        boolean a(AbstractC4156b abstractC4156b, MenuItem menuItem);

        void b(AbstractC4156b abstractC4156b);

        boolean c(AbstractC4156b abstractC4156b, Menu menu);

        boolean d(AbstractC4156b abstractC4156b, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f32988a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f32989b;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i10);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f32988a = obj;
    }

    public abstract void q(int i10);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z10) {
        this.f32989b = z10;
    }
}
