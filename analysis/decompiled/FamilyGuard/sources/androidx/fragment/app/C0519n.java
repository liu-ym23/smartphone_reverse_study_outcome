package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0519n {

    /* renamed from: a, reason: collision with root package name */
    private final p<?> f10706a;

    private C0519n(p<?> pVar) {
        this.f10706a = pVar;
    }

    public static C0519n b(p<?> pVar) {
        return new C0519n((p) D.h.f(pVar, "callbacks == null"));
    }

    public void a(ComponentCallbacksC0511f componentCallbacksC0511f) {
        p<?> pVar = this.f10706a;
        pVar.f10712e.k(pVar, pVar, componentCallbacksC0511f);
    }

    public void c() {
        this.f10706a.f10712e.v();
    }

    public boolean d(MenuItem menuItem) {
        return this.f10706a.f10712e.y(menuItem);
    }

    public void e() {
        this.f10706a.f10712e.z();
    }

    public void f() {
        this.f10706a.f10712e.B();
    }

    public void g() {
        this.f10706a.f10712e.K();
    }

    public void h() {
        this.f10706a.f10712e.O();
    }

    public void i() {
        this.f10706a.f10712e.P();
    }

    public void j() {
        this.f10706a.f10712e.R();
    }

    public boolean k() {
        return this.f10706a.f10712e.Y(true);
    }

    public x l() {
        return this.f10706a.f10712e;
    }

    public void m() {
        this.f10706a.f10712e.R0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f10706a.f10712e.t0().onCreateView(view, str, context, attributeSet);
    }
}
