package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ae;

/* JADX INFO: compiled from: DecorToolbar.java */
/* JADX INFO: loaded from: classes.dex */
public interface p {
    ViewGroup a();

    ae a(int r1, long r2);

    void a(int r1);

    void a(Drawable r1);

    void a(SparseArray<Parcelable> r1);

    void a(Menu r1, androidx.appcompat.view.menu.d.a r2);

    void a(Window.Callback r1);

    void a(androidx.appcompat.view.menu.d.a r1, MenuBuilder.a r2);

    void a(ScrollingTabContainerView r1);

    void a(CharSequence r1);

    void a(boolean r1);

    void b(int r1);

    void b(SparseArray<Parcelable> r1);

    void b(boolean r1);

    boolean b();

    void c();

    void c(int r1);

    CharSequence d();

    void d(int r1);

    void e();

    void e(int r1);

    void f();

    boolean g();

    Context getContext();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    boolean l();

    boolean m();

    void n();

    void o();

    int p();

    int q();

    Menu r();
}
