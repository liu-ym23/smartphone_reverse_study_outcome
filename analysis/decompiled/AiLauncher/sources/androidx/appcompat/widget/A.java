package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;

/* loaded from: classes.dex */
public interface A {
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

    androidx.core.view.U k(int i10, long j10);

    ViewGroup l();

    void m(boolean z10);

    void n();

    void o(boolean z10);

    void p();

    void q(Menu menu, i.a aVar);

    void r(int i10);

    int s();

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t();

    void u(M m10);

    void v(i.a aVar, e.a aVar2);

    void w(int i10);
}
