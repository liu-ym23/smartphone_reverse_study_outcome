package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.j;

/* loaded from: classes.dex */
public interface H {
    boolean a();

    void b();

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    void g(Menu menu, j.a aVar);

    Context getContext();

    CharSequence getTitle();

    void h();

    boolean i();

    void j(int i5);

    void k(int i5);

    int l();

    androidx.core.view.S m(int i5, long j5);

    void n(int i5);

    void o(boolean z5);

    int p();

    void q();

    void s();

    void setIcon(int i5);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(boolean z5);

    void u(T t5);
}
