package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.U;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;

/* loaded from: classes5.dex */
public interface k {
    void A(ViewGroup viewGroup);

    void B(ViewGroup viewGroup);

    void C(Menu menu, g.a aVar);

    boolean D();

    boolean E();

    void F(boolean z10);

    s G();

    void H(r rVar);

    boolean a();

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    void e();

    boolean f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    void h(int i10);

    Menu i();

    int j();

    U k(int i10, long j10);

    ViewGroup l();

    void m(boolean z10);

    void n();

    void o(boolean z10);

    void p();

    void q(Menu menu, g.a aVar);

    void r(int i10);

    int s();

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t();

    void u(g.a aVar, c.a aVar2);

    boolean v();

    void w(boolean z10);

    void x(a.b bVar);

    void y(boolean z10);

    boolean z();
}
