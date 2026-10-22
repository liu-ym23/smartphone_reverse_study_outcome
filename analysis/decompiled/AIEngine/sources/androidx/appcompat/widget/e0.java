package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface e0 {
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

    v0.h0 i(int i10, long j10);

    void j();

    void k(boolean z);

    void l();

    void m(Menu menu, j.a aVar);

    void n();

    void o(int i10);

    int p();

    void q();

    void r(int i10);

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
