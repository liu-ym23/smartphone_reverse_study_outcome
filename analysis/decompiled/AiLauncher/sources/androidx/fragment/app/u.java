package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final w<?> f14141a;

    public u(w<?> wVar) {
        this.f14141a = wVar;
    }

    public static u b(w<?> wVar) {
        return new u((w) B0.h.g(wVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        FragmentManager fragmentManagerG = this.f14141a.getFragmentManager();
        w<?> wVar = this.f14141a;
        fragmentManagerG.o(wVar, wVar, fragment);
    }

    public void c() {
        this.f14141a.getFragmentManager().A();
    }

    public boolean d(MenuItem menuItem) {
        return this.f14141a.getFragmentManager().D(menuItem);
    }

    public void e() {
        this.f14141a.getFragmentManager().E();
    }

    public void f() {
        this.f14141a.getFragmentManager().G();
    }

    public void g() {
        this.f14141a.getFragmentManager().P();
    }

    public void h() {
        this.f14141a.getFragmentManager().T();
    }

    public void i() {
        this.f14141a.getFragmentManager().U();
    }

    public void j() {
        this.f14141a.getFragmentManager().W();
    }

    public boolean k() {
        return this.f14141a.getFragmentManager().d0(true);
    }

    public FragmentManager l() {
        return this.f14141a.getFragmentManager();
    }

    public void m() {
        this.f14141a.getFragmentManager().Z0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f14141a.getFragmentManager().B0().onCreateView(view, str, context, attributeSet);
    }
}
