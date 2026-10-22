package androidx.appcompat.widget;

import android.view.Menu;
import android.view.Window;

/* JADX INFO: compiled from: DecorContentParent.java */
/* JADX INFO: loaded from: classes.dex */
public interface o {
    boolean canShowOverflowMenu();

    void dismissPopups();

    boolean hideOverflowMenu();

    void initFeature(int r1);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void setMenu(Menu r1, androidx.appcompat.view.menu.d.a r2);

    void setMenuPrepared();

    void setWindowCallback(Window.Callback r1);

    void setWindowTitle(CharSequence r1);

    boolean showOverflowMenu();
}
