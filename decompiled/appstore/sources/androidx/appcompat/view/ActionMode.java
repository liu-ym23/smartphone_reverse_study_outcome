package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f431b;

    public interface Callback {
        boolean onActionItemClicked(ActionMode r10, MenuItem r11);

        boolean onCreateActionMode(ActionMode r10, Menu r11);

        void onDestroyActionMode(ActionMode r10);

        boolean onPrepareActionMode(ActionMode r10, Menu r11);
    }

    public ActionMode() {
    }

    public abstract void a();

    public abstract View b();

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public Object f() {
        return this.f430a;
    }

    public abstract CharSequence g();

    public boolean h() {
        return this.f431b;
    }

    public abstract void i();

    public abstract boolean j();

    public abstract void k(View r10);

    public abstract void l(int r10);

    public abstract void m(CharSequence r10);

    public void n(Object r10) {
        this.f430a = r10;
    }

    public abstract void o(int r10);

    public abstract void p(CharSequence r10);

    public void q(boolean r10) {
        this.f431b = r10;
    }
}
