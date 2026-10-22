package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewPropertyAnimatorCompat;
import stepos.support.v7.app.C1973w;

/* loaded from: classes4.dex */
public interface I {
    void a(Menu menu, Va.A a3);

    boolean b();

    void c(boolean z10);

    boolean canShowOverflowMenu();

    void collapseActionView();

    void d(boolean z10);

    void dismissPopupMenus();

    boolean e();

    void f(ViewGroup viewGroup);

    void g(Menu menu, Va.A a3);

    Context getContext();

    int getDisplayOptions();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    void h(ViewGroup viewGroup);

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    void i();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    boolean j();

    void k(C1973w c1973w);

    boolean l();

    void m(boolean z10);

    void setCollapsible(boolean z10);

    void setDisplayOptions(int i);

    void setHomeButtonEnabled(boolean z10);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setLogo(int i);

    void setMenuPrepared();

    void setNavigationContentDescription(int i);

    void setNavigationIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j5);

    boolean showOverflowMenu();
}
