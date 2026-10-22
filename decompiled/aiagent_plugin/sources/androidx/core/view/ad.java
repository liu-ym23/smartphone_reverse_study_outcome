package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewParentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class ad {
    private static final String TAG = "ViewParentCompat";

    /* JADX INFO: compiled from: ViewParentCompat.java */
    static class a {
        static boolean a(ViewParent r2, View r3, View r4, int r5) {
            return ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin")).onStartNestedScroll(r3, r4, r5);
        }

        static void b(ViewParent r2, View r3, View r4, int r5) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin")).onNestedScrollAccepted(r3, r4, r5);
        }

        static void a(ViewParent r2, View r3) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin")).onStopNestedScroll(r3);
        }

        static void a(ViewParent r6, View r7, int r8, int r9, int r10, int r11) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r6, ViewParent.class, "com.obric.aiagent.plugin")).onNestedScroll(r7, r8, r9, r10, r11);
        }

        static void a(ViewParent r2, View r3, int r4, int r5, int[] r6) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin")).onNestedPreScroll(r3, r4, r5, r6);
        }

        static boolean a(ViewParent r2, View r3, float r4, float r5, boolean r6) {
            return ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin")).onNestedFling(r3, r4, r5, r6);
        }

        static boolean a(ViewParent r2, View r3, float r4, float r5) {
            return ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin")).onNestedPreFling(r3, r4, r5);
        }
    }

    public static boolean a(ViewParent r2, View r3, View r4, int r5, int r6) {
        ViewParent r7 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, q.class) == true) goto L5;
        if (r6 == 0) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT < 21) goto L14;
        return a.a(r7, r3, r4, r5);
    L11:
        e = move-exception;
        a(TAG, "ViewParent " + r7 + " does not implement interface method onStartNestedScroll", e);
        return false;
    L14:
        if (ZeusTransformUtils.instanceOf(r7, p.class) == true) goto L16;
        return false;
    L16:
        return ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.aiagent.plugin")).onStartNestedScroll(r3, r4, r5);
    L5:
        return ((q) ZeusTransformUtils.preCheckCast(r7, q.class, "com.obric.aiagent.plugin")).onStartNestedScroll(r3, r4, r5, r6);
    }

    public static void b(ViewParent r2, View r3, View r4, int r5, int r6) {
        ViewParent r7 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, q.class) == false) goto L5;
        ((q) ZeusTransformUtils.preCheckCast(r7, q.class, "com.obric.aiagent.plugin")).onNestedScrollAccepted(r3, r4, r5, r6);
        return;
    L5:
        if (r6 == 0) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        a.b(r7, r3, r4, r5);     // Catch: AbstractMethodError -> L10
        return;
    L10:
        e = move-exception;
        a(TAG, "ViewParent " + r7 + " does not implement interface method onNestedScrollAccepted", e);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, p.class) == false) goto L21;
        ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.aiagent.plugin")).onNestedScrollAccepted(r3, r4, r5);
        return;
    }

    public static void a(ViewParent r2, View r3, int r4) {
        ViewParent r5 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, q.class) == false) goto L5;
        ((q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.aiagent.plugin")).onStopNestedScroll(r3, r4);
        return;
    L5:
        if (r4 == 0) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        a.a(r5, r3);     // Catch: AbstractMethodError -> L10
        return;
    L10:
        e = move-exception;
        a(TAG, "ViewParent " + r5 + " does not implement interface method onStopNestedScroll", e);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r5, p.class) == false) goto L21;
        ((p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin")).onStopNestedScroll(r3);
        return;
    }

    public static void a(ViewParent r8, View r9, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        ViewParent r16 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r8, ViewParent.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, r.class) == false) goto L5;
        ((r) ZeusTransformUtils.preCheckCast(r16, r.class, "com.obric.aiagent.plugin")).onNestedScroll(r9, r10, r11, r12, r13, r14, r15);
        return;
    L5:
        r15[0] = r15[0] + r12;
        r15[1] = r15[1] + r13;
        if (ZeusTransformUtils.instanceOf(r16, q.class) == false) goto L8;
        ((q) ZeusTransformUtils.preCheckCast(r16, q.class, "com.obric.aiagent.plugin")).onNestedScroll(r9, r10, r11, r12, r13, r14);
        return;
    L8:
        if (r14 == 0) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 21) goto L17;
        a.a(r16, r9, r10, r11, r12, r13);     // Catch: AbstractMethodError -> L14
        return;
    L14:
        e = move-exception;
        a(TAG, "ViewParent " + r16 + " does not implement interface method onNestedScroll", e);
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r16, p.class) == false) goto L26;
        ((p) ZeusTransformUtils.preCheckCast(r16, p.class, "com.obric.aiagent.plugin")).onNestedScroll(r9, r10, r11, r12, r13);
        return;
    }

    public static void a(ViewParent r6, View r7, int r8, int r9, int[] r10, int r11) {
        ViewParent r12 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r6, ViewParent.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, q.class) == false) goto L5;
        ((q) ZeusTransformUtils.preCheckCast(r12, q.class, "com.obric.aiagent.plugin")).onNestedPreScroll(r7, r8, r9, r10, r11);
        return;
    L5:
        if (r11 == 0) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        a.a(r12, r7, r8, r9, r10);     // Catch: AbstractMethodError -> L10
        return;
    L10:
        e = move-exception;
        a(TAG, "ViewParent " + r12 + " does not implement interface method onNestedPreScroll", e);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r12, p.class) == false) goto L21;
        ((p) ZeusTransformUtils.preCheckCast(r12, p.class, "com.obric.aiagent.plugin")).onNestedPreScroll(r7, r8, r9, r10);
        return;
    }

    public static boolean a(ViewParent r3, View r4, float r5, float r6, boolean r7) {
        ViewParent r8 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r3, ViewParent.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L9;
        return a.a(r8, r4, r5, r6, r7);
    L6:
        e = move-exception;
        a(TAG, "ViewParent " + r8 + " does not implement interface method onNestedFling", e);
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r8, p.class) == true) goto L11;
        return false;
    L11:
        return ((p) ZeusTransformUtils.preCheckCast(r8, p.class, "com.obric.aiagent.plugin")).onNestedFling(r4, r5, r6, r7);
    }

    public static boolean a(ViewParent r3, View r4, float r5, float r6) {
        ViewParent r7 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r3, ViewParent.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L9;
        return a.a(r7, r4, r5, r6);
    L6:
        e = move-exception;
        a(TAG, "ViewParent " + r7 + " does not implement interface method onNestedPreFling", e);
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r7, p.class) == true) goto L11;
        return false;
    L11:
        return ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.aiagent.plugin")).onNestedPreFling(r4, r5, r6);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
