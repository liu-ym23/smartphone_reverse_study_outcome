package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @ReplaceWith(expression = "listView.canScrollList(direction)")
    public static boolean canScrollList(ListView r100, int r101) {
        return r100.canScrollList(r101);
    }

    @ReplaceWith(expression = "listView.scrollListBy(y)")
    public static void scrollListBy(ListView r100, int r101) {
        r100.scrollListBy(r101);
    }
}
