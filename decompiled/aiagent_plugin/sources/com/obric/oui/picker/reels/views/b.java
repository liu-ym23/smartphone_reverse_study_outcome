package com.obric.oui.picker.reels.views;

import android.widget.OverScroller;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ScrollerExt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "ScrollerExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f35960a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f35961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f35962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f35963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f35964e;

    static {
        f35960a = new b();
    }

    private b() {
    }

    public final void a(OverScroller r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        o.e(r12, "<this>");
        r12.fling(0, r14, 0, a(r12, r15, r14, r13), 0, 0, r16, r17, 0, r18);
    }

    private final int a(OverScroller r18, int r19, int r20, int r21) {
        if (f35964e == true) goto L6;
        com.obric.oui.d.a.b.e(TAG, o.a("calculateSnapVelocity, reflect failed, use original velocityY: ", Integer.valueOf(r19)));
        return r19;
    L6:
        if (r19 == 0) goto L49;
        float r1 = r20;
        float r3 = r21;
        float r4 = b(r18, r19) + r1;
        double r5 = r4 / r3;
        float r7 = ((float) Math.floor(r5)) * r3;
        float r6 = ((float) Math.ceil(r5)) * r3;
        if (Math.abs(r4 - r7) < Math.abs(r6 - r4)) goto L11;
        r7 = r6;
    L11:
        if (r19 <= 0) goto L13;
        byte r8 = 1;
    L14:
        int r9 = 0;
        if (r19 <= 0) goto L17;
        int r10 = 40000;
        int r11 = 0;
    L18:
        float r12 = Float.MAX_VALUE;
        int r13 = 20;
        int r14 = r19;
    L19:
        if (r9 >= r13) goto L54;
        int r15 = r9 + 1;
        int r16 = (r11 + r10) / 2;
        float r17 = b(r18, r16) + r1;
        float r110 = r17 - r7;
        if (Math.abs(r110) >= r12) goto L24;
        r12 = Math.abs(r110);
        r14 = r16;
    L24:
        com.obric.oui.d.a.b.a(TAG, "calculateSnapVelocity, iteration: " + r9 + ", mid: " + r16 + ", low: " + r11 + ", high: " + r10 + ", diff: " + r110 + ", dist: " + r17 + ", targetDistance: " + r7 + ", bestDiff: " + r12 + ", bestVelocity: " + r14 + ", velocityY: " + r19 + ", currentOffset: " + r1);
        if (r8 <= 0) goto L33;
        if (r110 < 0.0f) goto L37;
        if (Math.abs(r110) > 0.3f) goto L37;
        return r14;
    L37:
        if (r8 <= 0) goto L42;
        if (r110 > 0.0f) goto L44;
    L43:
        r11 = r16 + 1;
    L45:
        if (r11 > r10) goto L57;
        r9 = r15;
        r13 = 20;
        goto L19
    L57:
        return r14;
    L44:
        r10 = r16 - 1;
        goto L45
    L42:
        if (r110 >= 0.0f) goto L44;
    L33:
        if (r110 > 0.0f) goto L37;
        if (Math.abs(r110) > 0.3f) goto L37;
        return r14;
    L54:
        return r14;
    L17:
        r11 = -40000;
        r10 = 0;
        goto L18
    L13:
        r8 = -1;
        goto L14
    L49:
        return r19;
    }

    private final int b(OverScroller r1, int r2) {
        double r0 = a(r1, r2);
        if (r2 != 0) goto L5;
        Object r3 = 0;
    L9:
        return ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
    L5:
        if (r2 <= 0) goto L7;
        r3 = Double.valueOf(r0);
        goto L9
    L7:
        r3 = Double.valueOf(-r0);
        goto L9
    }

    public final void a() {
    L14:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "init reflect error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        f35964e = false;
        return;
    L4:
        if (f35961b != null) goto L7;
        f35961b = ZeusTransformUtils.forName("android.widget.OverScroller", "com.obric.aiagent.plugin");     // Catch: Exception -> L14
    L7:
        if (f35962c != null) goto L12;
        Class<?> r1 = f35961b;     // Catch: Exception -> L14
        o.a(r1);     // Catch: Exception -> L14
        Method r2 = r1.getDeclaredMethod("getSplineFlingDistance", new Class[]{Integer.TYPE});     // Catch: Exception -> L14
        f35962c = r2;     // Catch: Exception -> L14
        if (r2 == null) goto L12;
        r2.setAccessible(true);     // Catch: Exception -> L14
    L12:
        f35964e = true;     // Catch: Exception -> L14
    }

    private final void a(OverScroller r4) {
    L13:
        e = move-exception;
        com.obric.oui.d.a.b.a(TAG, "disableDynamicScroll, failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L3:
        if (f35963d != null) goto L8;
        Method r3 = OverScroller.class.getDeclaredMethod("disableDynamicScroll", new Class[0]);     // Catch: Exception -> L13
        f35963d = r3;     // Catch: Exception -> L13
        if (r3 == null) goto L8;
        r3.setAccessible(true);     // Catch: Exception -> L13
    L8:
        Method r5 = f35963d;     // Catch: Exception -> L13
        if (r5 == null) goto L18;
        r5.invoke(r4, new Object[0]);     // Catch: Exception -> L13
        return;
    }

    public static final double a(OverScroller r5, int r6) {
        o.e(r5, "overScroller");
        f35960a.a(r5);     // Catch: Exception -> L11
        Method r2 = f35962c;     // Catch: Exception -> L11
        if (r2 != null) goto L6;
        Object r7 = null;
    L7:
        if (r7 == null) goto L10;
        return ((Double) ZeusTransformUtils.preCheckCast(r7, Double.class, "com.obric.aiagent.plugin")).doubleValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");     // Catch: Exception -> L11
    L6:
        r7 = r2.invoke(r5, new Object[]{Integer.valueOf(r6)});     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "reflectGetSplineFlingDistance, velocity: " + r6 + ", error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        f35964e = false;
        return 0.0d;
    }
}
