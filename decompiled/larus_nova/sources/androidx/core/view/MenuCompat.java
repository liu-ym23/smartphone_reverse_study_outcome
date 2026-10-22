package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.ReplaceWith;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes17.dex */
public final class MenuCompat {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static void setGroupDividerEnabled(Menu r100, boolean r101) {
            r100.setGroupDividerEnabled(r101);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(Menu r100, boolean r101) {
        if ((r100 instanceof SupportMenu) == false) goto L6;
        ((SupportMenu) r100).setGroupDividerEnabled(r101);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        Api28Impl.setGroupDividerEnabled(r100, r101);
        return;
    }

    @ReplaceWith(expression = "item.setShowAsAction(actionEnum)")
    public static void setShowAsAction(MenuItem r100, int r101) {
        r100.setShowAsAction(r101);
    }
}
