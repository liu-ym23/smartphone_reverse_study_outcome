package stepos.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import stepos.support.v7.view.menu.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface j {
    boolean a();

    boolean b();

    boolean c();

    boolean d();

    void e();

    boolean f();

    void g(int i10);

    void m(Menu menu, g.a aVar);

    void n();

    void o();

    void q(Menu menu, g.a aVar);

    void r();

    void setBackTopBackground(Drawable drawable);

    void setBackTopClickCallback(View.OnClickListener onClickListener);

    void setBackTopEnable(boolean z);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
