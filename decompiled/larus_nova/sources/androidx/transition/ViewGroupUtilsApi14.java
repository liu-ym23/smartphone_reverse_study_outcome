package androidx.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import com.larus.nova.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
class ViewGroupUtilsApi14 {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final String TAG = "ViewGroupUtilsApi14";
    private static Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static LayoutTransition sEmptyLayoutTransition;
    private static Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    private ViewGroupUtilsApi14() {
    }

    private static void cancelLayoutTransition(LayoutTransition r100) {
        if (sCancelMethodFetched == false) goto L15;
    L7:
        Method r101 = sCancelMethod;
        if (r101 == null) goto L17;
        r101.invoke(r100, new Object[0]);     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L17:
        return;
    L15:
        Method r102 = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);     // Catch: NoSuchMethodException -> L11
        sCancelMethod = r102;     // Catch: NoSuchMethodException -> L11
        r102.setAccessible(true);     // Catch: NoSuchMethodException -> L11
    L6:
        sCancelMethodFetched = true;
        goto L7
    }

    public static void suppressLayout(ViewGroup r100, boolean r101) {
        boolean r102 = false;
        if (sEmptyLayoutTransition != null) goto L6;
        LayoutTransition r103 = new AnonymousClass1();
        sEmptyLayoutTransition = r103;
        r103.setAnimator(2, null);
        sEmptyLayoutTransition.setAnimator(0, null);
        sEmptyLayoutTransition.setAnimator(1, null);
        sEmptyLayoutTransition.setAnimator(3, null);
        sEmptyLayoutTransition.setAnimator(4, null);
    L6:
        if (r101 == false) goto L16;
        LayoutTransition r104 = r100.getLayoutTransition();
        if (r104 != null) goto L10;
    L15:
        r100.setLayoutTransition(sEmptyLayoutTransition);
        return;
    L10:
        if (r104.isRunning() == false) goto L13;
        cancelLayoutTransition(r104);
    L13:
        if (r104 == sEmptyLayoutTransition) goto L15;
        r100.setTag(R.id.transition_layout_save, r104);
        goto L15
    L16:
        r100.setLayoutTransition(null);
        if (sLayoutSuppressedFieldFetched == false) goto L38;
    L20:
        Field r105 = sLayoutSuppressedField;
        if (r105 != null) goto L40;
    L29:
        if (r102 == false) goto L31;
        r100.requestLayout();
    L31:
        LayoutTransition r106 = (LayoutTransition) r100.getTag(R.id.transition_layout_save);
        if (r106 == null) goto L43;
        r100.setTag(R.id.transition_layout_save, null);
        r100.setLayoutTransition(r106);
        return;
    L43:
        return;
    L40:
        boolean r107 = r105.getBoolean(r100);     // Catch: IllegalAccessException -> L28
        if (r107 == true) goto L36;
    L27:
        r102 = r107;
        goto L29
    L36:
        sLayoutSuppressedField.setBoolean(r100, false);     // Catch: IllegalAccessException -> L26
        goto L27
    L38:
        Field r108 = ViewGroup.class.getDeclaredField("mLayoutSuppressed");     // Catch: NoSuchFieldException -> L35
        sLayoutSuppressedField = r108;     // Catch: NoSuchFieldException -> L35
        r108.setAccessible(true);     // Catch: NoSuchFieldException -> L35
    L19:
        sLayoutSuppressedFieldFetched = true;
        goto L20
    }
}
