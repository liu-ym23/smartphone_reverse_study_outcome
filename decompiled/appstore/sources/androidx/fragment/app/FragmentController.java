package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class FragmentController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentHostCallback f3180a;

    public FragmentController(FragmentHostCallback r10) {
        this.f3180a = r10;
    }

    public static FragmentController b(FragmentHostCallback r10) {
        return new FragmentController((FragmentHostCallback) androidx.core.util.e.h(r10, "callbacks == null"));
    }

    public void a(Fragment r10) {
        FragmentHostCallback r11 = this.f3180a;
        r11.f3185e.m(r11, r11, r10);
    }

    public void c() {
        this.f3180a.f3185e.x();
    }

    public boolean d(MenuItem r10) {
        return this.f3180a.f3185e.A(r10);
    }

    public void e() {
        this.f3180a.f3185e.B();
    }

    public void f() {
        this.f3180a.f3185e.D();
    }

    public void g() {
        this.f3180a.f3185e.M();
    }

    public void h() {
        this.f3180a.f3185e.Q();
    }

    public void i() {
        this.f3180a.f3185e.R();
    }

    public void j() {
        this.f3180a.f3185e.T();
    }

    public boolean k() {
        return this.f3180a.f3185e.a0(true);
    }

    public FragmentManager l() {
        return this.f3180a.f3185e;
    }

    public void m() {
        this.f3180a.f3185e.c1();
    }

    public View n(View r10, String r11, Context r12, AttributeSet r13) {
        return this.f3180a.f3185e.z0().onCreateView(r10, r11, r12, r13);
    }
}
