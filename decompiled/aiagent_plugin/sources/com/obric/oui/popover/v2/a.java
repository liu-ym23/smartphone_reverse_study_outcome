package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.x;

/* JADX INFO: compiled from: OPopoverAnimationHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36043a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f36044b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.oui.animation.engine.c<View> f36045c = null;

    /* JADX INFO: renamed from: com.obric.oui.popover.v2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OPopoverAnimationHelper.kt */
    public static final class C0976a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f36046a;

        public C0976a(float r1) {
            this.f36046a = r1;
        }

        public final float a() {
            return this.f36046a;
        }

        public final void a(float r1) {
            this.f36046a = r1;
        }
    }

    /* JADX INFO: compiled from: OPopoverAnimationHelper.kt */
    public static final class b extends com.obric.oui.animation.engine.c<View> {
        b() {
            super("v");
        }

        @Override // com.obric.oui.animation.engine.c
        public /* synthetic */ float a(View r3) {
            return a2((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.oui.animation.engine.c
        public /* synthetic */ void a(View r3, float r4) {
            a2((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), r4);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public float a2(View r4) {
            if (r4 == null) goto L20;
            Object r5 = r4.getTag(a.f36043a.a());
            if (r5 == null) goto L21;
            com.obric.oui.d.c r0 = com.obric.oui.d.c.f35012a;
            Float r1 = null;
            if (ZeusTransformUtils.instanceOf(r5, C0976a.class) == true) goto L12;
            r5 = null;
        L12:
            C0976a r6 = (C0976a) ZeusTransformUtils.preCheckCast(r5, C0976a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            r1 = Float.valueOf(r6.a());
        L16:
            if (r1 != null) goto L19;
            return 0.0f;
        L19:
            return r1.floatValue();
        L21:
            return 0.0f;
        L20:
            return 0.0f;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(View r2, float r3) {
            if (r2 == null) goto L16;
            Object r1 = r2.getTag(a.f36043a.a());
            if (r1 == null) goto L17;
            com.obric.oui.d.c r4 = com.obric.oui.d.c.f35012a;
            if (ZeusTransformUtils.instanceOf(r1, C0976a.class) == true) goto L11;
            r1 = null;
        L11:
            C0976a r5 = (C0976a) ZeusTransformUtils.preCheckCast(r1, C0976a.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L18;
            r5.a(r3);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public static /* synthetic */ void lambda$e_cH2ijyH3DcOxMKK8AzZIDj1Ko(ViewGroup r0, float r1, float r2, float r3, float r4, View r5, float r6, float r7, com.obric.oui.animation.engine.b r8, float r9, float r10) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void lambda$kOE4TBVf3wrI1zFdsfRqAOqhoXc(ViewGroup r0, float r1, float r2, float r3, float r4, float r5, float r6, com.obric.oui.animation.engine.b r7, float r8, float r9) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private a() {
    }

    static {
        f36043a = new a();
        f36044b = ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, DbHelper.COL_ID, "o_popover_anim_p");
        f36045c = (com.obric.oui.animation.engine.c) ZeusTransformUtils.preCheckCast(new b(), com.obric.oui.animation.engine.c.class, "com.obric.aiagent.plugin");
    }

    public final int a() {
        return f36044b;
    }

    /* JADX WARN: Type inference failed for: r14v4, types: [T, com.obric.oui.animation.a.b] */
    public final AnimatorSet a(final ViewGroup r21, boolean r22, int r23, float r24, float r25, final boolean r26, Animator r27, d.h.a.a<x> r28, d.h.a.a<x> r29) {
        final d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r28, d.h.a.a.class, "com.obric.aiagent.plugin");
        final d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r29, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r21, "view");
        r21.setPivotX(r24);
        r21.setPivotY(r25);
        r21.setVisibility(0);
        AnimatorSet r12 = new AnimatorSet();
        final z.f r13 = new z.f();
        if (r27 == null) goto L5;
        r12.play(r27);
    L52:
        r12.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new OPopoverAnimationHelper$startVisibilityAnimation$2(r26, r21, r13, r10, r11), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r12.start();
        return r12;
    L5:
        PathInterpolator r1 = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
        final float r3 = 0.0f;
        if (r26 == false) goto L8;
        float r4 = 0.0f;
    L9:
        if (r26 == false) goto L11;
        float r5 = 1.0f;
    L12:
        int r14 = 1;
        if (r21.getAlpha() != 0.0f) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
    L23:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r21, "alpha", new float[]{r4, r5});
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r1, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r2.setDuration(100);
        r12.play((Animator) ZeusTransformUtils.preCheckCast(r2, Animator.class, "com.obric.aiagent.plugin"));
        if (r26 == false) goto L26;
        final float r6 = 0.2f;
    L27:
        if (r26 == false) goto L29;
        final float r8 = 1.0f;
    L31:
        if (r23 != 48) goto L35;
        r14 = -1;
    L35:
        if (r26 == false) goto L37;
        float r9 = -g.b((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.aiagent.plugin"), 10);
    L38:
        float r15 = r14;
        final float r16 = r9 * r15;
        if (r26 == false) goto L41;
        float r0 = 0.0f;
    L42:
        final float r17 = r0 * r15;
        if (r26 == false) goto L45;
        final float r18 = 0.0f;
    L46:
        if (r26 == false) goto L49;
        r3 = 10000.0f;
    L49:
        if (com.obric.oui.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.aiagent.plugin")).a() == true) goto L51;
        r21.setScaleX(r6);
        r21.setScaleY(r6);
        r21.setTranslationY(r16);
        r21.setTag(f36044b, new C0976a(r18));
    L51:
        ?? r19 = com.obric.oui.animation.a.b.a(com.obric.oui.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.aiagent.plugin")).a(0.85f).b(632.0f), f36045c, r3, null, 4, null);
        r19.a(new $$Lambda$a$kOE4TBVf3wrI1zFdsfRqAOqhoXc(r21, r18, r3, r6, r8, r16, r17));
        r13.f38504a = r19;
        goto L52
    L45:
        r18 = 10000.0f;
        goto L46
    L41:
        r0 = -g.b((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.aiagent.plugin"), 10);
        goto L42
    L37:
        r9 = 0.0f;
        goto L38
    L29:
        r8 = 0.2f;
        goto L31
    L26:
        r6 = 1.0f;
        goto L27
    L18:
        if (r21.getAlpha() != 1.0f) goto L20;
        boolean r20 = true;
    L21:
        if (r20 == true) goto L23;
        r4 = r21.getAlpha();
        goto L23
    L20:
        r20 = false;
        goto L21
    L15:
        r7 = false;
        goto L16
    L11:
        r5 = 0.0f;
        goto L12
    L8:
        r4 = 1.0f;
        goto L9
    }

    private static final void a(ViewGroup r1, float r2, float r3, float r4, float r5, float r6, float r7, com.obric.oui.animation.engine.b r8, float r9, float r10) {
        o.e(r1, "$view");
        com.obric.oui.d.c r11 = com.obric.oui.d.c.f35012a;
        Object r12 = r1.getTag(f36044b);
        if (r12 != null) goto L6;
    L4:
        r12 = null;
    L8:
        if (((C0976a) ZeusTransformUtils.preCheckCast(r12, C0976a.class, "com.obric.aiagent.plugin")) == null) goto L11;
        float r13 = com.obric.oui.d.b.a(r9, r2, r3);
        float r14 = r4 + ((r5 - r4) * r13);
        r1.setScaleX(r14);
        r1.setScaleY(r14);
        r1.setTranslationY(r6 + ((r7 - r6) * r13));
        return;
    L11:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r12, C0976a.class) == false) goto L4;
        goto L4
    }

    public final void a(com.obric.oui.popover.v2.b<?> r17, boolean r18, final float r19, final float r20) {
        com.obric.oui.popover.v2.b r0 = (com.obric.oui.popover.v2.b) ZeusTransformUtils.wrapperContextForParams(r17, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin");
        o.e(r0, "popover");
        final ViewGroup r4 = r0.getPopoverWindowFrame();
        final View r9 = r0.getPopoverBubbleLayout().getChildAt(0);
        if (r18 == false) goto L5;
        float r1 = 0.8f;
    L7:
        if (r18 == false) goto L9;
        final float r5 = 0.0f;
    L10:
        if (r18 == false) goto L12;
        final float r6 = 10000.0f;
    L13:
        final float r7 = r4.getScaleX();
        final float r2 = r9.getAlpha();
        com.obric.oui.animation.a.b r3 = com.obric.oui.animation.a.b.a(com.obric.oui.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin")).a(r1).b(439.0f), f36045c, r6, null, 4, null);
        r3.a(new $$Lambda$a$e_cH2ijyH3DcOxMKK8AzZIDj1Ko(r4, r5, r6, r7, r20, r9, r2, r19));
        r3.b();
        return;
    L12:
        r6 = 0.0f;
        goto L13
    L9:
        r5 = 10000.0f;
        goto L10
    L5:
        r1 = 1.0f;
        goto L7
    }

    private static final void a(ViewGroup r1, float r2, float r3, float r4, float r5, View r6, float r7, float r8, com.obric.oui.animation.engine.b r9, float r10, float r11) {
        o.e(r1, "$view");
        com.obric.oui.d.c r12 = com.obric.oui.d.c.f35012a;
        Object r13 = r1.getTag(f36044b);
        if (r13 != null) goto L6;
    L4:
        r13 = null;
    L8:
        if (((C0976a) ZeusTransformUtils.preCheckCast(r13, C0976a.class, "com.obric.aiagent.plugin")) == null) goto L11;
        float r14 = com.obric.oui.d.b.a(r10, r2, r3);
        float r15 = r4 + ((r5 - r4) * r14);
        r1.setScaleX(r15);
        r1.setScaleY(r15);
        r6.setAlpha(r7 + ((r8 - r7) * r14));
        return;
    L11:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r13, C0976a.class) == false) goto L4;
        goto L4
    }
}
