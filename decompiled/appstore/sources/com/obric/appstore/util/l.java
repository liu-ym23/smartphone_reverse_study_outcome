package com.obric.appstore.util;

import android.app.Activity;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f11084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f11085b = null;

    static {
        f11084a = new l();
        f11085b = new String[]{"mCalledExitCoordinator", "mReturnExitCoordinator", "mExitTransitionCoordinators"};
    }

    public l() {
    }

    public final void a(Object r10) {
        Field r11 = g(r10.getClass(), "mExitCallbacks");
        if (r11 != null) goto L17;
        return;
    L17:
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L8
        r11.setAccessible(true);     // Catch: Throwable -> L8
        Object r13 = r11.get(r10);     // Catch: Throwable -> L8
        if (r13 == null) goto L10;
        kotlin.jvm.internal.q.d(r13);     // Catch: Throwable -> L8
        c(r13, "mActivity");     // Catch: Throwable -> L8
    L10:
        r11.set(r10, null);     // Catch: Throwable -> L8
        Object r14 = Result.m35constructorimpl(Integer.valueOf(com.bytedanceos.common.toolbox.i.a("LeakFixUtils", "Cleared mExitCallbacks in ExitTransitionCoordinator")));     // Catch: Throwable -> L8
    L13:
        Throwable r15 = Result.m38exceptionOrNullimpl(r14);
        if (r15 == null) goto L19;
        com.bytedanceos.common.toolbox.i.k("LeakFixUtils", "Failed to clear mExitCallbacks: " + f11084a.j(r15));
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.a r16 = Result.Companion;
        r14 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L13
    }

    public final void b(Object r10) {
        a(r10);
        c(r10, "mResultReceiver");
    }

    public final void c(Object r10, String r11) {
        Field r12 = g(r10.getClass(), r11);
        if (r12 != null) goto L14;
        com.bytedanceos.common.toolbox.i.k("LeakFixUtils", r11 + " field not found in " + r10.getClass().getName());
        return;
    L14:
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L8
        r12.setAccessible(true);     // Catch: Throwable -> L8
        r12.set(r10, null);     // Catch: Throwable -> L8
        Object r14 = Result.m35constructorimpl(Integer.valueOf(com.bytedanceos.common.toolbox.i.a("LeakFixUtils", "Cleared " + r11 + " in " + r10.getClass().getSimpleName())));     // Catch: Throwable -> L8
    L10:
        Throwable r15 = Result.m38exceptionOrNullimpl(r14);
        if (r15 == null) goto L16;
        com.bytedanceos.common.toolbox.i.k("LeakFixUtils", "Failed to clear " + r11 + " in " + r10.getClass().getName() + ": " + f11084a.j(r15));
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.a r16 = Result.Companion;
        r14 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L10
    }

    public final void d(Activity r10, Set r11) {
        Field r12 = g(Activity.class, "mActivityTransitionState");
        if (r12 != null) goto L35;
        return;
    L35:
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L7
        r12.setAccessible(true);     // Catch: Throwable -> L7
        Object r14 = Result.m35constructorimpl(r12.get(r10));     // Catch: Throwable -> L7
    L9:
        Throwable r15 = Result.m38exceptionOrNullimpl(r14);
        if (r15 != null) goto L31;
        if (r14 != null) goto L13;
        return;
    L13:
        String[] r16 = f11085b;
        int r17 = r16.length;
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L30;
        String r19 = r16[r18];
        l r20 = f11084a;
        Field r21 = r20.g(r14.getClass(), r19);
        if (r21 == null) goto L29;
        Result.a r22 = Result.Companion;     // Catch: Throwable -> L24
        r21.setAccessible(true);     // Catch: Throwable -> L24
        Object r23 = r21.get(r14);     // Catch: Throwable -> L24
        if (r23 == null) goto L22;
        kotlin.jvm.internal.q.d(r23);     // Catch: Throwable -> L24
        r20.e(r23, r11);     // Catch: Throwable -> L24
        r21.set(r14, null);     // Catch: Throwable -> L24
        com.bytedanceos.common.toolbox.i.a("LeakFixUtils", "Cleared ActivityTransitionState." + r19);     // Catch: Throwable -> L24
    L22:
        Object r24 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L24
    L26:
        Throwable r25 = Result.m38exceptionOrNullimpl(r24);
        if (r25 == null) goto L29;
        com.bytedanceos.common.toolbox.i.k("LeakFixUtils", "Failed to clear ActivityTransitionState." + r19 + ": " + f11084a.j(r25));
    L24:
        th = move-exception;
        Result.a r26 = Result.Companion;
        r24 = Result.m35constructorimpl(kotlin.c.a(th));
    L29:
        r18 = r18 + 1;
        goto L14
    L30:
        return;
    L31:
        com.bytedanceos.common.toolbox.i.k("LeakFixUtils", "Failed to get mActivityTransitionState: " + f11084a.j(r15));
        return;
    L7:
        th = move-exception;
        Result.a r27 = Result.Companion;
        r14 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L9
    }

    public final void e(Object r10, Set r11) {
        if (i(r10) == false) goto L6;
        r11.add(r10);
        return;
    L6:
        if ((r10 instanceof WeakReference) == false) goto L13;
        Object r12 = ((WeakReference) r10).get();
        if (r12 != null) goto L10;
        return;
    L10:
        if (f11084a.i(r12) == false) goto L37;
        r11.add(r12);
        return;
    L37:
        return;
    L13:
        if ((r10 instanceof SparseArray) == false) goto L39;
        SparseArray r13 = (SparseArray) r10;
        int r14 = r13.size();
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L40;
        Object r16 = r13.valueAt(r15);
        if ((r16 instanceof WeakReference) == false) goto L23;
        Object r17 = ((WeakReference) r16).get();
        if (r17 == null) goto L27;
        if (f11084a.i(r17) == false) goto L27;
        r11.add(r17);
    L27:
        r15 = r15 + 1;
        goto L15
    L23:
        if (r16 == null) goto L27;
        if (i(r16) == false) goto L27;
        r11.add(r16);
        goto L27
    L40:
        return;
    }

    public final void f(Activity r10, Set r11) {
        Field r12 = g(Activity.class, "mExitTransitionCoordinator");
        if (r12 != null) goto L20;
        return;
    L20:
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L10
        r12.setAccessible(true);     // Catch: Throwable -> L10
        Object r14 = r12.get(r10);     // Catch: Throwable -> L10
        Unit r15 = null;
        if (r14 == null) goto L13;
        kotlin.jvm.internal.q.d(r14);     // Catch: Throwable -> L10
        if (i(r14) == false) goto L12;
        r11.add(r14);     // Catch: Throwable -> L10
        r12.set(r10, null);     // Catch: Throwable -> L10
        com.bytedanceos.common.toolbox.i.a("LeakFixUtils", "Cleared legacy mExitTransitionCoordinator in Activity");     // Catch: Throwable -> L10
    L12:
        r15 = Unit.f21064a;     // Catch: Throwable -> L10
    L13:
        Object r16 = Result.m35constructorimpl(r15);     // Catch: Throwable -> L10
    L16:
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);
        if (r17 == null) goto L22;
        com.bytedanceos.common.toolbox.i.k("LeakFixUtils", "Failed to clear legacy mExitTransitionCoordinator: " + f11084a.j(r17));
        return;
    L22:
        return;
    L10:
        th = move-exception;
        Result.a r18 = Result.Companion;
        r16 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L16
    }

    public final Field g(Class r10, String r11) {
    L2:
        if (r10 == null) goto L6;
        return r10.getDeclaredField(r11);
    L5:
        r10 = r10.getSuperclass();
        goto L2
    L6:
        return null;
    }

    public final void h(Activity r10) {
        kotlin.jvm.internal.q.g(r10, "activity");
        LinkedHashSet r11 = new LinkedHashSet();
        f(r10, r11);
        d(r10, r11);
        if (r11.isEmpty() == false) goto L6;
        com.bytedanceos.common.toolbox.i.a("LeakFixUtils", "No ExitTransitionCoordinator found");
        return;
    L6:
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        f11084a.b(r12.next());
        goto L8
    L10:
        com.bytedanceos.common.toolbox.i.a("LeakFixUtils", "Cleared " + r11.size() + " ExitTransitionCoordinator references");
    }

    public final boolean i(Object r10) {
        return kotlin.jvm.internal.q.b(r10.getClass().getName(), "android.app.ExitTransitionCoordinator");
    }

    public final String j(Throwable r10) {
        return r10.getClass().getSimpleName() + ": " + r10.getMessage();
    }
}
