package com.obric.autoaction.app.launcherpage.ui;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBarAnimationHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.obric.common.oea.foundation.animation.manager.d> f24445a;

    /* JADX INFO: renamed from: lambda$AaX8jHoSj7-uRvY7twOO2k4vYZo, reason: not valid java name */
    public static /* synthetic */ x m563lambda$AaX8jHoSj7uRvY7twOO2k4vYZo(z.d r0, ViewGroup r1, int r2, List r3, d.h.a.a r4, Throwable r5) {
        return b(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$I_5suAN2aEno8Js3l5Vw8-uk7Gs, reason: not valid java name */
    public static /* synthetic */ x m564lambda$I_5suAN2aEno8Js3l5Vw8uk7Gs(ViewGroup r0, String r1, Object r2, Object r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$QtqMjSji81Ed6y7WjVDCx5wECLw(d.h.a.b r0, boolean r1, Throwable r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$U050Kl-lxXoRJtZ4bbUyHxjsSPM, reason: not valid java name */
    public static /* synthetic */ x m565lambda$U050KllxXoRJtZ4bbUyHxjsSPM(d.h.a.b r0, boolean r1, Throwable r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$XtU_dgoZtzOlmADf0LhY-7hzV_s, reason: not valid java name */
    public static /* synthetic */ x m566lambda$XtU_dgoZtzOlmADf0LhY7hzV_s(ViewGroup r0, String r1, Object r2, Object r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$_SyvUW56r6ZCjp2M5h5uQ2BtvVo(z.d r0, ViewGroup r1, int r2, List r3, d.h.a.a r4, Throwable r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$n-XNwBrc-F3cP6NC86OT2Oc2RF4, reason: not valid java name */
    public static /* synthetic */ x m567lambda$nXNwBrcF3cP6NC86OT2Oc2RF4(d.h.a.b r0, boolean r1, Throwable r2) {
        return d(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$nXDdB9HV-BbWIEfi2bQncgBg-bE, reason: not valid java name */
    public static /* synthetic */ x m568lambda$nXDdB9HVBbWIEfi2bQncgBgbE(d.h.a.b r0, boolean r1, Throwable r2) {
        return c(r0, r1, r2);
    }

    public j() {
        this.f24445a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void a(j r1, ViewGroup r2, List r3, int r4, d.h.a.a r5, int r6, Object r7) {
        List<? extends View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = r2.getPaddingLeft();
    L6:
        if ((r6 & 8) == 0) goto L8;
        r9 = null;
    L8:
        r1.a(r2, r8, r4, r9);
    }

    public final void a(final ViewGroup r18, List<? extends View> r19, final int r20, d.h.a.a<x> r21) {
        final List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        final d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r18, "container");
        d.h.b.o.e(r9, "fadeViews");
        b();
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.aiagent.plugin"));
        int r11 = r20 + a();
        View r1 = (View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.aiagent.plugin");
        r1.setPadding(r11, r1.getPaddingTop(), r1.getPaddingRight(), r1.getPaddingBottom());
        final z.d r2 = new z.d();
        r2.f38502a = r9.size() + 1;
        final d.h.a.b r14 = new $$Lambda$j$_SyvUW56r6ZCjp2M5h5uQ2BtvVo(r2, r18, r20, r9, r6);
        com.obric.common.oea.foundation.animation.manager.d r3 = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), r11, r20, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$j$I_5suAN2aEno8Js3l5Vw8uk7Gs(r18)).a(new $$Lambda$j$U050KllxXoRJtZ4bbUyHxjsSPM(r14)).a().a();
        this.f24445a.add(r3);
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.aiagent.plugin");
        r5.setAlpha(0.0f);
        com.obric.common.oea.foundation.animation.manager.d r7 = com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a(r5, 0.0f, 1, null), com.obric.common.oea.foundation.animation.h.a.EnumC0885a.j, Float.valueOf(0.0f), 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b, com.obric.common.oea.foundation.animation.h.e.b.f32433a, com.obric.common.oea.foundation.animation.h.e.d.j), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a(new $$Lambda$j$QtqMjSji81Ed6y7WjVDCx5wECLw(r14)).b(), null, null, 3, null);
        this.f24445a.add(r7);
        goto L4
    }

    private static final x a(z.d r2, ViewGroup r3, int r4, List r5, d.h.a.a r6, Throwable r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L13;
        r2.f38502a--;
        if (r2.f38502a != 0) goto L13;
        View r10 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        r10.setPadding(r4, r10.getPaddingTop(), r10.getPaddingRight(), r10.getPaddingBottom());
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        ((View) ZeusTransformUtils.preCheckCast(r11.next(), View.class, "com.obric.aiagent.plugin")).setAlpha(1.0f);
        goto L8
    L10:
        if (r9 == null) goto L13;
        r9.invoke();
    L13:
        return x.f38692a;
    }

    private static final x a(ViewGroup r1, String r2, Object r3, Object r4) {
        d.h.b.o.e(r2, "<unused var>");
        d.h.b.o.e(r3, "value");
        d.h.b.o.e(r4, "<unused var>");
        View r5 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        r5.setPadding(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin")).intValue(), r5.getPaddingTop(), r5.getPaddingRight(), r5.getPaddingBottom());
        return x.f38692a;
    }

    private static final x a(d.h.a.b r1, boolean r2, Throwable r3) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3);
        return x.f38692a;
    }

    private static final x b(d.h.a.b r1, boolean r2, Throwable r3) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3);
        return x.f38692a;
    }

    public static /* synthetic */ void b(j r1, ViewGroup r2, List r3, int r4, d.h.a.a r5, int r6, Object r7) {
        List<? extends View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = r2.getPaddingLeft();
    L6:
        if ((r6 & 8) == 0) goto L8;
        r9 = null;
    L8:
        r1.b(r2, r8, r4, r9);
    }

    public final void b(final ViewGroup r18, List<? extends View> r19, final int r20, d.h.a.a<x> r21) {
        final List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        final d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r18, "container");
        d.h.b.o.e(r9, "fadeViews");
        if (r18.getVisibility() == 0) goto L8;
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.aiagent.plugin"));
        if (r6 == null) goto L14;
        r6.invoke();
        return;
    L14:
        return;
    L8:
        b();
        int r12 = r20 + a();
        final z.d r2 = new z.d();
        r2.f38502a = r9.size() + 1;
        final d.h.a.b r14 = new $$Lambda$j$AaX8jHoSj7uRvY7twOO2k4vYZo(r2, r18, r20, r9, r6);
        com.obric.common.oea.foundation.animation.manager.d r3 = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), r20, r12, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32439b, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$j$XtU_dgoZtzOlmADf0LhY7hzV_s(r18)).a(new $$Lambda$j$nXDdB9HVBbWIEfi2bQncgBgbE(r14)).a().a();
        this.f24445a.add(r3);
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.aiagent.plugin");
        com.obric.common.oea.foundation.animation.manager.d r7 = com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a(r5, 0.0f, 1, null), com.obric.common.oea.foundation.animation.h.a.EnumC0885a.j, Float.valueOf(r5.getAlpha()), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b, com.obric.common.oea.foundation.animation.h.e.b.f32433a, com.obric.common.oea.foundation.animation.h.e.d.k), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a(new $$Lambda$j$nXNwBrcF3cP6NC86OT2Oc2RF4(r14)).b(), null, null, 3, null);
        this.f24445a.add(r7);
        goto L10
    }

    private static final x b(z.d r2, ViewGroup r3, int r4, List r5, d.h.a.a r6, Throwable r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L13;
        r2.f38502a--;
        if (r2.f38502a != 0) goto L13;
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        View r10 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        r10.setPadding(r4, r10.getPaddingTop(), r10.getPaddingRight(), r10.getPaddingBottom());
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        ((View) ZeusTransformUtils.preCheckCast(r11.next(), View.class, "com.obric.aiagent.plugin")).setAlpha(1.0f);
        goto L8
    L10:
        if (r9 == null) goto L13;
        r9.invoke();
    L13:
        return x.f38692a;
    }

    private static final x b(ViewGroup r1, String r2, Object r3, Object r4) {
        d.h.b.o.e(r2, "<unused var>");
        d.h.b.o.e(r3, "value");
        d.h.b.o.e(r4, "<unused var>");
        View r5 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        r5.setPadding(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin")).intValue(), r5.getPaddingTop(), r5.getPaddingRight(), r5.getPaddingBottom());
        return x.f38692a;
    }

    private static final x c(d.h.a.b r1, boolean r2, Throwable r3) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3);
        return x.f38692a;
    }

    private static final x d(d.h.a.b r1, boolean r2, Throwable r3) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3);
        return x.f38692a;
    }

    private final void b() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f24445a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.obric.common.oea.foundation.animation.manager.d) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.common.oea.foundation.animation.manager.d.class, "com.obric.aiagent.plugin")).a(true);
        goto L4
    L6:
        this.f24445a.clear();
    }

    private final int a() {
        return d.i.a.a(TypedValue.applyDimension(1, 50, Resources.getSystem().getDisplayMetrics()));
    }
}
