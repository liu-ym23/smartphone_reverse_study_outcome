package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: ActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f302b;

    /* JADX INFO: compiled from: ActionMode.java */
    public interface a {
        void a(b r1);

        boolean a(b r1, Menu r2);

        boolean a(b r1, MenuItem r2);

        boolean b(b r1, Menu r2);
    }

    public abstract MenuInflater a();

    public abstract void a(int r1);

    public abstract void a(View r1);

    public abstract void a(CharSequence r1);

    public abstract Menu b();

    public abstract void b(int r1);

    public abstract void b(CharSequence r1);

    public abstract void c();

    public abstract void d();

    public abstract CharSequence f();

    public abstract CharSequence g();

    public boolean h() {
        return false;
    }

    public abstract View i();

    public b() {
    }

    public void a(Object r1) {
        this.f301a = r1;
    }

    public Object j() {
        return this.f301a;
    }

    public void a(boolean r1) {
        this.f302b = r1;
    }

    public boolean k() {
        return this.f302b;
    }
}
