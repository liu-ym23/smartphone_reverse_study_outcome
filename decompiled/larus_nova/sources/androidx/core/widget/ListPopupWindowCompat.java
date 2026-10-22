package androidx.core.widget;

import android.view.View;
import android.widget.ListPopupWindow;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class ListPopupWindowCompat {
    private ListPopupWindowCompat() {
    }

    public static View.OnTouchListener createDragToOpenListener(Object r100, View r101) {
        return createDragToOpenListener((ListPopupWindow) r100, r101);
    }

    @ReplaceWith(expression = "listPopupWindow.createDragToOpenListener(src)")
    public static View.OnTouchListener createDragToOpenListener(ListPopupWindow r100, View r101) {
        return r100.createDragToOpenListener(r101);
    }
}
