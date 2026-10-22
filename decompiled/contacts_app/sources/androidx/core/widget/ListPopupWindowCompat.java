package androidx.core.widget;

import android.view.View;
import android.widget.ListPopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class ListPopupWindowCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static View.OnTouchListener createDragToOpenListener(ListPopupWindow r0, View r1) {
            return r0.createDragToOpenListener(r1);
        }
    }

    private ListPopupWindowCompat() {
    }

    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(Object r0, View r1) {
        return createDragToOpenListener((ListPopupWindow) r0, r1);
    }

    public static View.OnTouchListener createDragToOpenListener(ListPopupWindow r0, View r1) {
        return Api19Impl.createDragToOpenListener(r0, r1);
    }
}
