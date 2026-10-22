package androidx.appcompat.widget;

import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public abstract class PopupMenu {

    public interface OnDismissListener {
        void onDismiss(PopupMenu r10);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r10);
    }
}
