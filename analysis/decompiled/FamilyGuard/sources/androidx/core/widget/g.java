package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class g {

    static class a {
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void c(PopupWindow popupWindow, boolean z5) {
            popupWindow.setOverlapAnchor(z5);
        }

        static void d(PopupWindow popupWindow, int i5) {
            popupWindow.setWindowLayoutType(i5);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z5) {
        a.c(popupWindow, z5);
    }

    public static void b(PopupWindow popupWindow, int i5) {
        a.d(popupWindow, i5);
    }

    public static void c(PopupWindow popupWindow, View view, int i5, int i6, int i7) {
        popupWindow.showAsDropDown(view, i5, i6, i7);
    }
}
