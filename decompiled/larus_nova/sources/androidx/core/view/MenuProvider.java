package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes17.dex */
public interface MenuProvider {

    /* JADX INFO: renamed from: androidx.core.view.MenuProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onMenuClosed(MenuProvider r100, Menu r101) {
        }

        public static void $default$onPrepareMenu(MenuProvider r100, Menu r101) {
        }
    }

    void onCreateMenu(Menu r100, MenuInflater r101);

    void onMenuClosed(Menu r100);

    boolean onMenuItemSelected(MenuItem r100);

    void onPrepareMenu(Menu r100);
}
