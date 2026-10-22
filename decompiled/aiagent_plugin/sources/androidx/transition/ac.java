package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewGroupUtilsApi14.java */
/* JADX INFO: loaded from: classes.dex */
class ac {
    private static final String TAG = "ViewGroupUtilsApi14";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LayoutTransition f2785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f2786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f2788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f2789e;

    static void a(ViewGroup r7, boolean r8) {
        boolean r2 = false;
        if (f2785a != null) goto L6;
        LayoutTransition r0 = new ViewGroupUtilsApi14$1();
        f2785a = r0;
        r0.setAnimator(2, null);
        f2785a.setAnimator(0, null);
        f2785a.setAnimator(1, null);
        f2785a.setAnimator(3, null);
        f2785a.setAnimator(4, null);
    L6:
        if (r8 == false) goto L16;
        LayoutTransition r9 = r7.getLayoutTransition();
        if (r9 != null) goto L10;
    L15:
        r7.setLayoutTransition(f2785a);
        return;
    L10:
        if (r9.isRunning() == false) goto L13;
        a(r9);
    L13:
        if (r9 == f2785a) goto L15;
        r7.setTag(ZeusTransformUtils.mapRes(R.id.transition_layout_save, DbHelper.COL_ID, "transition_layout_save"), r9);
        goto L15
    L16:
        r7.setLayoutTransition(null);
        if (f2787c == false) goto L38;
    L22:
        Field r10 = f2786b;
        if (r10 != null) goto L40;
    L31:
        if (r2 == false) goto L33;
        r7.requestLayout();
    L33:
        LayoutTransition r11 = (LayoutTransition) ZeusTransformUtils.preCheckCast(r7.getTag(ZeusTransformUtils.mapRes(R.id.transition_layout_save, DbHelper.COL_ID, "transition_layout_save")), LayoutTransition.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L45;
        r7.setTag(ZeusTransformUtils.mapRes(R.id.transition_layout_save, DbHelper.COL_ID, "transition_layout_save"), null);
        r7.setLayoutTransition(r11);
        return;
    L45:
        return;
    L40:
        boolean r12 = r10.getBoolean(r7);     // Catch: IllegalAccessException -> L37
        if (r12 == true) goto L42;
    L29:
        r2 = r12;
        goto L31
    L42:
        f2786b.setBoolean(r7, false);     // Catch: IllegalAccessException -> L28
    L28:
        r2 = r12;
    L30:
        a(TAG, "Failed to get mLayoutSuppressed field by reflection");
        goto L31
    L38:
        Field r13 = ViewGroup.class.getDeclaredField("mLayoutSuppressed");     // Catch: NoSuchFieldException -> L20
        f2786b = r13;     // Catch: NoSuchFieldException -> L20
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L20
    L21:
        f2787c = true;
    L20:
        a(TAG, "Failed to access mLayoutSuppressed field by reflection");
        goto L21
    }

    private static void a(LayoutTransition r7) {
        if (f2789e == false) goto L16;
    L9:
        Method r0 = f2788d;
        if (r0 == null) goto L20;
        r0.invoke(r7, new Object[0]);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14
    L22:
        return;
    L14:
        a(TAG, "Failed to access cancel method by reflection");
        return;
    L13:
        a(TAG, "Failed to invoke cancel method by reflection");
        return;
    L20:
        return;
    L16:
        Method r4 = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);     // Catch: NoSuchMethodException -> L7
        f2788d = r4;     // Catch: NoSuchMethodException -> L7
        r4.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L8:
        f2789e = true;
    L7:
        a(TAG, "Failed to access cancel method by reflection");
        goto L8
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
