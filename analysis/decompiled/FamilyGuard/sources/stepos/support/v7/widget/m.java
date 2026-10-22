package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.S;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.view.menu.h;

/* loaded from: classes.dex */
public interface m {
    int A();

    void B(boolean z5);

    void C(ViewGroup viewGroup);

    void D(a.c cVar);

    void E(Menu menu, h.a aVar);

    void F(int i5);

    Menu G();

    boolean H();

    boolean I();

    void J(int i5);

    ViewGroup K();

    void L(boolean z5);

    w M();

    int N();

    void O(View view);

    void P(v vVar);

    boolean a();

    void b();

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    void g(Drawable drawable);

    Context getContext();

    CharSequence getTitle();

    void h();

    boolean i();

    void j(int i5);

    void k(int i5);

    int l();

    S m(int i5, long j5);

    void n(int i5);

    void o(boolean z5);

    int p();

    void q();

    void r(Menu menu, h.a aVar);

    void s();

    void setIcon(int i5);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(boolean z5);

    void u(boolean z5);

    boolean v();

    View w();

    void x(h.a aVar, d.a aVar2);

    boolean y();

    void z(ViewGroup viewGroup);
}
