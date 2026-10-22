package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TransitionUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RectF f13776a = null;

    /* JADX INFO: compiled from: TransitionUtils.java */
    interface a {
        void a(Canvas r1);
    }

    /* JADX INFO: compiled from: TransitionUtils.java */
    interface b {
        com.google.android.material.shape.c a(com.google.android.material.shape.c r1, com.google.android.material.shape.c r2);
    }

    static float a(float r0, float r1, float r2) {
        return r0 + (r2 * (r1 - r0));
    }

    static <T> T a(T r0, T r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1;
    }

    static boolean a(Transition r2, Context r3, int r4, TimeInterpolator r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        TimeInterpolator r7 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r5, TimeInterpolator.class, "com.obric.aiagent.plugin");
        if (r4 != 0) goto L5;
        return false;
    L5:
        if (r2.getInterpolator() != null) goto L10;
        r2.setInterpolator(com.google.android.material.f.a.a(r6, r4, r7));
        return true;
    L10:
        return false;
    }

    static boolean a(Transition r4, Context r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r6 != 0) goto L5;
        return false;
    L5:
        if (r4.getDuration() != (-1)) goto L12;
        int r8 = com.google.android.material.f.a.a(r7, r6, -1);
        if (r8 == (-1)) goto L13;
        r4.setDuration(r8);
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    static boolean b(Transition r2, Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == 0) goto L8;
        PathMotion r6 = a(r5, r4);
        if (r6 == null) goto L10;
        r2.setPathMotion(r6);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    static PathMotion a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        TypedValue r0 = new TypedValue();
        if (r5.getTheme().resolveAttribute(r4, r0, true) == true) goto L5;
        return null;
    L5:
        if (r0.type != 16) goto L15;
        int r6 = r0.data;
        if (r6 != 0) goto L9;
        return null;
    L9:
        if (r6 != 1) goto L13;
        return new MaterialArcMotion();
    L13:
        throw new IllegalArgumentException("Invalid motion path type: " + r6);
    L15:
        if (r0.type != 3) goto L19;
        return new PatternPathMotion(androidx.core.graphics.i.a(String.valueOf(r0.string)));
    L19:
        throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
    }

    static com.google.android.material.shape.m a(com.google.android.material.shape.m r1, final RectF r2) {
        return r1.a(new AnonymousClass1(r2));
    }

    static com.google.android.material.shape.m a(com.google.android.material.shape.m r2, com.google.android.material.shape.m r3, RectF r4, b r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        if (b(r2, r4) == false) goto L5;
        com.google.android.material.shape.m r7 = r2;
    L7:
        return r7.n().b(r6.a(r2.f(), r3.f())).c(r6.a(r2.g(), r3.g())).e(r6.a(r2.i(), r3.i())).d(r6.a(r2.h(), r3.h())).a();
    L5:
        r7 = r3;
        goto L7
    }

    private static boolean b(com.google.android.material.shape.m r2, RectF r3) {
        if (r2.f().a(r3) == 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (r2.g().a(r3) != 0.0f) goto L12;
        if (r2.h().a(r3) != 0.0f) goto L12;
        if (r2.i().a(r3) != 0.0f) goto L12;
        return false;
    }

    static float a(float r6, float r7, float r8, float r9, float r10) {
        return a(r6, r7, r8, r9, r10, false);
    }

    static float a(float r0, float r1, float r2, float r3, float r4, boolean r5) {
        if (r5 == false) goto L10;
        if (r4 < 0.0f) goto L8;
        if (r4 <= 1.0f) goto L10;
    L8:
        return a(r0, r1, r4);
    L10:
        if (r4 >= r2) goto L13;
        return r0;
    L13:
        if (r4 <= r3) goto L16;
        return r1;
    L16:
        return a(r0, r1, (r4 - r2) / (r3 - r2));
    }

    static int a(int r1, int r2, float r3, float r4, float r5) {
        if (r5 >= r3) goto L6;
        return r1;
    L6:
        if (r5 <= r4) goto L9;
        return r2;
    L9:
        return (int) a(r1, r2, (r5 - r3) / (r4 - r3));
    }

    static com.google.android.material.shape.m a(com.google.android.material.shape.m r7, com.google.android.material.shape.m r8, final RectF r9, final RectF r10, final float r11, final float r12, final float r13) {
        if (r13 >= r11) goto L6;
        return r7;
    L6:
        if (r13 <= r12) goto L9;
        return r8;
    L9:
        return a(r7, r8, r9, new AnonymousClass2(r9, r10, r11, r12, r13));
    }

    static Shader a(int r9) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, r9, r9, Shader.TileMode.CLAMP);
    }

    static View a(View r1, int r2) {
        View r0 = r1.findViewById(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return b(r1, r2);
    }

    static View b(View r3, int r4) {
        String r1 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getResourceName(r4);
    L3:
        if (r3 == null) goto L11;
        if (r3.getId() == r4) goto L6;
        ViewParent r5 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r5, View.class) == false) goto L11;
        r3 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
        goto L3
    L6:
        return r3;
    L11:
        throw new IllegalArgumentException(r1 + " is not a valid ancestor");
    }

    static RectF a(View r4) {
        return new RectF(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
    }

    static Rect b(View r4) {
        return new Rect(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
    }

    static RectF c(View r4) {
        int[] r0 = new int[2];
        r4.getLocationOnScreen(r0);
        int r1 = r0[0];
        int r2 = r0[1];
        return new RectF(r1, r2, r4.getWidth() + r1, r4.getHeight() + r2);
    }

    static float a(RectF r1) {
        return r1.width() * r1.height();
    }

    static {
        f13776a = new RectF();
    }

    private static int a(Canvas r7, Rect r8, int r9) {
        RectF r0 = f13776a;
        r0.set(r8);
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return r7.saveLayerAlpha(r0, r9);
    L7:
        return r7.saveLayerAlpha(r0.left, r0.top, r0.right, r0.bottom, r9, 31);
    }

    static void a(Canvas r2, Rect r3, float r4, float r5, float r6, int r7, a r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.aiagent.plugin");
        if (r7 > 0) goto L5;
        return;
    L5:
        int r0 = r2.save();
        r2.translate(r4, r5);
        r2.scale(r6, r6);
        if (r7 >= 255) goto L8;
        a(r2, r3, r7);
    L8:
        r9.a(r2);
        r2.restoreToCount(r0);
    }
}
