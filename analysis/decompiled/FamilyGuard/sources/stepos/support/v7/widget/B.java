package stepos.support.v7.widget;

import android.view.View;
import androidx.core.view.H;

/* loaded from: classes.dex */
class B {

    /* renamed from: a, reason: collision with root package name */
    private final View f21556a;

    /* renamed from: b, reason: collision with root package name */
    private int f21557b;

    /* renamed from: c, reason: collision with root package name */
    private int f21558c;

    /* renamed from: d, reason: collision with root package name */
    private int f21559d;

    /* renamed from: e, reason: collision with root package name */
    private int f21560e;

    public B(View view) {
        this.f21556a = view;
    }

    void a() {
        View view = this.f21556a;
        H.V(view, this.f21559d - (view.getTop() - this.f21557b));
        View view2 = this.f21556a;
        H.U(view2, this.f21560e - (view2.getLeft() - this.f21558c));
    }

    public int b() {
        return this.f21557b;
    }

    public void c() {
        this.f21557b = this.f21556a.getTop();
        this.f21558c = this.f21556a.getLeft();
    }

    public boolean d(int i5) {
        if (this.f21559d == i5) {
            return false;
        }
        this.f21559d = i5;
        a();
        return true;
    }
}
