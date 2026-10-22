package com.obric.autoaction.e;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.OvershootInterpolator;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: FloatingDragAnimation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    /* JADX INFO: renamed from: lambda$pmq4GhvKOVffdF-2vSb-2SeabeM, reason: not valid java name */
    public static /* synthetic */ boolean m578lambda$pmq4GhvKOVffdF2vSb2SeabeM(z.c r0, z.c r1, z.c r2, z.c r3, z.a r4, int r5, View r6, Context r7, d.h.a.b r8, View r9, MotionEvent r10) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static final void a(final View r12, d.h.a.b<? super Boolean, x> r13) {
        final d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r12, "view");
        o.e(r11, "onSnapped");
        final Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        final int r8 = ViewConfiguration.get(r10).getScaledTouchSlop();
        final z.a r7 = new z.a();
        final z.c r5 = new z.c();
        final z.c r6 = new z.c();
        final z.c r3 = new z.c();
        final z.c r4 = new z.c();
        r12.setOnTouchListener(new $$Lambda$a$pmq4GhvKOVffdF2vSb2SeabeM(r3, r4, r5, r6, r7, r8, r12, r10, r11));
    }

    private static final boolean a(z.c r4, z.c r5, z.c r6, z.c r7, z.a r8, int r9, View r10, Context r11, d.h.a.b r12, View r13, MotionEvent r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        ViewParent r0 = r13.getParent();
        o.a(r0, "null cannot be cast to non-null type android.view.View");
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        int r2 = r14.getAction();
        if (r2 == 0) goto L27;
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L9;
        return false;
    L9:
        if (r8.f38499a == true) goto L16;
        float r17 = r9;
        if (Math.abs(r14.getRawX() - r6.f38501a) <= r17) goto L13;
    L14:
        r8.f38499a = true;
        goto L16
    L13:
        if (Math.abs(r14.getRawY() - r7.f38501a) > r17) goto L14;
    L16:
        if (r8.f38499a == true) goto L18;
        return true;
    L18:
        float r18 = r14.getRawX() + r4.f38501a;
        float r19 = r14.getRawY() + r5.f38501a;
        float r20 = n.a(r18, 0.0f, r1.getWidth() - r13.getWidth());
        r13.animate().x(r20).y(n.a(r19, 0.0f, r1.getHeight() - r13.getHeight())).setDuration(0).start();
    L29:
        return true;
    L20:
        if (r8.f38499a == false) goto L22;
        o.a(r15);
        o.a(r13);
        a(r15, r13, r13.getX(), r1.getWidth(), r16);
        goto L29
    L22:
        if (r10.isClickable() == false) goto L24;
        r13.performClick();
        goto L29
    L24:
        return false;
    L27:
        r4.f38501a = r13.getX() - r14.getRawX();
        r5.f38501a = r13.getY() - r14.getRawY();
        r6.f38501a = r14.getRawX();
        r7.f38501a = r14.getRawY();
        r8.f38499a = false;
        return false;
    }

    private static final void a(Context r3, View r4, float r5, int r6, d.h.a.b<? super Boolean, x> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        float r2 = r6 / 2;
        if (((r4.getWidth() / 2) + r5) <= r2) goto L5;
        boolean r0 = true;
    L6:
        r9.invoke(Boolean.valueOf(r0));
        if ((r5 + (r4.getWidth() / 2)) <= r2) goto L9;
        float r10 = (r6 - r4.getWidth()) - ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_bubble_margin_to_screen_end, "dimen", "auto_ai_bubble_margin_to_screen_end"));
    L10:
        r4.animate().x(r10).setDuration(300).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new OvershootInterpolator(2.0f), TimeInterpolator.class, "com.obric.aiagent.plugin")).start();
        return;
    L9:
        r10 = ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_bubble_margin_to_screen_end, "dimen", "auto_ai_bubble_margin_to_screen_end"));
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static final void a(View r5, boolean r6) {
        o.e(r5, "view");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        ViewParent r2 = r5.getParent();
        o.a(r2, "null cannot be cast to non-null type android.view.ViewGroup");
        int r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin")).getWidth();
        if (r6 == false) goto L5;
        int r4 = (r3 - r5.getWidth()) - ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_bubble_margin_to_screen_end, "dimen", "auto_ai_bubble_margin_to_screen_end"));
    L6:
        r5.setX(r4);
        return;
    L5:
        r4 = ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_bubble_margin_to_screen_end, "dimen", "auto_ai_bubble_margin_to_screen_end"));
        goto L6
    }
}
