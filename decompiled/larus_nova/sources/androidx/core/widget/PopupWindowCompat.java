package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.ReplaceWith;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static boolean getOverlapAnchor(PopupWindow r100) {
            return r100.getOverlapAnchor();
        }

        public static int getWindowLayoutType(PopupWindow r100) {
            return r100.getWindowLayoutType();
        }

        public static void setOverlapAnchor(PopupWindow r100, boolean r101) {
            r100.setOverlapAnchor(r101);
        }

        public static void setWindowLayoutType(PopupWindow r100, int r101) {
            r100.setWindowLayoutType(r101);
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(PopupWindow r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getOverlapAnchor(r100);
    L7:
        if (sOverlapAnchorFieldAttempted == false) goto L19;
    L11:
        Field r101 = sOverlapAnchorField;
        if (r101 != null) goto L21;
        return false;
    L21:
        return ((Boolean) r101.get(r100)).booleanValue();
    L23:
        return false;
    L19:
        Field r102 = PopupWindow.class.getDeclaredField("mOverlapAnchor");     // Catch: NoSuchFieldException -> L17
        sOverlapAnchorField = r102;     // Catch: NoSuchFieldException -> L17
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        sOverlapAnchorFieldAttempted = true;
        goto L11
    }

    public static int getWindowLayoutType(PopupWindow r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getWindowLayoutType(r100);
    L7:
        if (sGetWindowLayoutTypeMethodAttempted == false) goto L18;
    L11:
        Method r101 = sGetWindowLayoutTypeMethod;
        if (r101 != null) goto L20;
    L15:
        return 0;
    L20:
        return ((Integer) r101.invoke(r100, new Object[0])).intValue();
    L18:
        Method r102 = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);     // Catch: Exception -> L16
        sGetWindowLayoutTypeMethod = r102;     // Catch: Exception -> L16
        r102.setAccessible(true);     // Catch: Exception -> L16
    L10:
        sGetWindowLayoutTypeMethodAttempted = true;
        goto L11
    }

    public static void setOverlapAnchor(PopupWindow r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setOverlapAnchor(r100, r101);
        return;
    L6:
        if (sOverlapAnchorFieldAttempted == false) goto L16;
    L10:
        Field r102 = sOverlapAnchorField;
        if (r102 == null) goto L21;
        r102.set(r100, Boolean.valueOf(r101));     // Catch: IllegalAccessException -> L14
        return;
    L22:
        return;
    L21:
        return;
    L16:
        Field r103 = PopupWindow.class.getDeclaredField("mOverlapAnchor");     // Catch: NoSuchFieldException -> L15
        sOverlapAnchorField = r103;     // Catch: NoSuchFieldException -> L15
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L15
    L9:
        sOverlapAnchorFieldAttempted = true;
        goto L10
    }

    public static void setWindowLayoutType(PopupWindow r100, int r101) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setWindowLayoutType(r100, r101);
        return;
    L6:
        if (sSetWindowLayoutTypeMethodAttempted == false) goto L17;
    L9:
        Method r102 = sSetWindowLayoutTypeMethod;
        if (r102 == null) goto L20;
        r102.invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L13
        return;
    L21:
        return;
    L20:
        return;
    L17:
        Method r103 = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});     // Catch: Exception -> L14
        sSetWindowLayoutTypeMethod = r103;     // Catch: Exception -> L14
        r103.setAccessible(true);     // Catch: Exception -> L14
    L8:
        sSetWindowLayoutTypeMethodAttempted = true;
        goto L9
    }

    public static void INVOKEVIRTUAL_androidx_core_widget_PopupWindowCompat_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(PopupWindow r100, View r101, int r102, int r103, int r104) {
        OverlaySource r105 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r100, r101, r105) == false) goto L5;
        return;
    L5:
        r100.showAsDropDown(r101, r102, r103, r104);
        PopupWindowLancet.trackAfterShow(r100, r105, r101);
    }

    @ReplaceWith(expression = "popup.showAsDropDown(anchor, xoff, yoff, gravity)")
    public static void showAsDropDown(PopupWindow r100, View r101, int r102, int r103, int r104) {
        INVOKEVIRTUAL_androidx_core_widget_PopupWindowCompat_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(r100, r101, r102, r103, r104);
    }
}
