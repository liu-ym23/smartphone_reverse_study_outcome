package stepos.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.Window;

/* loaded from: classes4.dex */
public interface H {
    void a(Menu menu, Va.A a3);

    void b();

    void c(Menu menu, Va.A a3);

    boolean canShowOverflowMenu();

    void d();

    void dismissPopups();

    boolean hideOverflowMenu();

    void initFeature(int i);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void setBackTopBackground(Drawable drawable);

    void setBackTopClickCallback(View.OnClickListener onClickListener);

    void setBackTopEnable(boolean z10);

    void setMenuPrepared();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}
