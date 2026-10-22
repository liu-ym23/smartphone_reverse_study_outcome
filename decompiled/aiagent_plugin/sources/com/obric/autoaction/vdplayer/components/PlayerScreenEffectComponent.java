package com.obric.autoaction.vdplayer.components;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Display;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import androidx.lifecycle.p;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.autoaction.vdplayer.d.g;
import com.obric.autoaction.view.AiStrokeView;
import com.obric.autogui.common.api.platform.AOPlatform;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;

/* JADX INFO: compiled from: PlayerScreenEffectComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PlayerScreenEffectComponent extends BaseVDPlayerSlotComponent<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25295a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AiStrokeView f25296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ValueAnimator f25297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f25298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ValueAnimator f25299e;
    private float f;

    /* JADX INFO: compiled from: PlayerScreenEffectComponent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PlayerScreenEffectComponent.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25301a = null;

        static {
            int[] r0 = new int[g.values().length];
            r0[g.f25484a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[g.f25486c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[g.f25488e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[g.f25487d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[g.f25485b.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f25301a = r0;
        }
    }

    static {
        f25295a = new a(null);
    }

    public static /* synthetic */ WindowInsets lambda$WCHJNPzqiR8EgOVvge8T23nUTi8(PlayerScreenEffectComponent r0, View r1, WindowInsets r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$bRvri7_LJr86hadhbom8M36wlzM(AiStrokeView r0, PlayerScreenEffectComponent r1, float r2, ValueAnimator r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$wkqc4rYA-CvNkkICzygTuh2uLlY, reason: not valid java name */
    public static /* synthetic */ void m658lambda$wkqc4rYACvNkkICzygTuh2uLlY(PlayerScreenEffectComponent r0, View r1, ValueAnimator r2) {
        a(r0, r1, r2);
    }

    public PlayerScreenEffectComponent() {
        super((d.h.a.b) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25300a, d.h.a.b.class, "com.obric.aiagent.plugin"));
        this.f = 4.0f;
    }

    public static final /* synthetic */ void a(PlayerScreenEffectComponent r0, float r1) {
        r0.f = r1;
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r8, com.obric.autoaction.a.c r9) {
        o.e(r8, "container");
        o.e(r9, "componentHost");
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "getContext(...)");
        AiStrokeView r10 = new AiStrokeView(r2, null, 0, 6, null);
        this.f25296b = r10;
        r10.setBackgroundColor(0);
        return (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent, com.obric.autoaction.a.h
    public void a(View r2, com.obric.autoaction.a.c r3) {
        o.e(r2, "boundView");
        o.e(r3, "componentHost");
        super.a(r2, r3);
        d();
        c.a((AiStrokeView) ZeusTransformUtils.preCheckCast(r2, AiStrokeView.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.lifecycle.d
    public void b(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.b(r4);
        AiStrokeView r2 = this.f25296b;
        if (r2 == null) goto L6;
        r2.play();
        return;
    }

    public void a(g r9) {
        o.e(r9, "state");
        AiStrokeView r0 = this.f25296b;
        if (r0 != null) goto L5;
        return;
    L5:
        int r10 = b.f25301a[r9.ordinal()];
        if (r10 == 1) goto L27;
        int r5 = 503316480;
        if (r10 != 2) goto L10;
        a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 503316480);
        a(4.0f);
        r0.setAutoFreeze(false);
        r0.play();
        k.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        if (r10 != 3) goto L12;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L25;
        r5 = r11.getColor(ZeusTransformUtils.mapRes(R.color.oui_scrim_sheet, "color", "oui_scrim_sheet"));
    L25:
        a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), r5);
        a(0.0f);
        r0.stop();
        return;
    L12:
        if (r10 != 4) goto L14;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L21;
        r5 = r12.getColor(ZeusTransformUtils.mapRes(R.color.oui_scrim_sheet, "color", "oui_scrim_sheet"));
    L21:
        a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), r5);
        a(0.0f);
        r0.stop();
        return;
    L14:
        if (r10 != 5) goto L17;
        a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 0);
        a(0.0f);
        r0.setAutoFreeze(false);
        r0.play();
        k.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        return;
    L17:
        throw new d.k();
    L27:
        a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 1711276032);
        a(4.0f);
        r0.setAutoFreeze(true);
        r0.play();
        k.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
    }

    private final void a(final View r4, int r5) {
        Integer r0 = this.f25298d;
        if (r0 != null) goto L6;
    L8:
        this.f25298d = Integer.valueOf(r5);
        Drawable r1 = r4.getBackground();
        if (ZeusTransformUtils.instanceOf(r1, ColorDrawable.class) == false) goto L11;
        ColorDrawable r2 = (ColorDrawable) ZeusTransformUtils.preCheckCast(r1, ColorDrawable.class, "com.obric.aiagent.plugin");
    L13:
        if (r2 == null) goto L15;
        int r3 = r2.getColor();
    L16:
        ValueAnimator r6 = this.f25297c;
        if (r6 == null) goto L19;
        r6.cancel();
    L19:
        ValueAnimator r7 = ValueAnimator.ofArgb(new int[]{r3, r5});
        r7.setDuration(300);
        r7.addUpdateListener(new $$Lambda$PlayerScreenEffectComponent$wkqc4rYACvNkkICzygTuh2uLlY(this, r4));
        r7.start();
        this.f25297c = r7;
        return;
    L15:
        r3 = 0;
        goto L16
    L11:
        r2 = null;
        goto L13
    L6:
        if (r5 != r0.intValue()) goto L8;
    }

    private static final void a(PlayerScreenEffectComponent r1, View r2, ValueAnimator r3) {
        o.e(r3, "animator");
        if (r1.f25296b != null) goto L6;
        r3.cancel();
        return;
    L6:
        Object r4 = r3.getAnimatedValue();
        o.a(r4, "null cannot be cast to non-null type kotlin.Int");
        r2.setBackgroundColor(((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue());
    }

    private final void d() {
        AiStrokeView r0 = this.f25296b;
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = this.f;
        Resources r2 = Resources.getSystem();
        o.c(r2, "Resources.getSystem()");
        r0.setStrokeWidthPx(d.i.a.a(TypedValue.applyDimension(1, r1, r2.getDisplayMetrics())));
        if (AOPlatform.INSTANCE.isInitialized() == false) goto L8;
        String r3 = AOPlatform.INSTANCE.getPlatform().getInformation().getProject();
    L10:
        switch(r3.hashCode()) {
            case -2002884275: goto L28;
            case -1048984789: goto L24;
            case -807117175: goto L20;
            case 3440915: goto L16;
            case 1328894480: goto L13;
            default: goto L31;
        };
    L31:
        m r4 = null;
    L32:
        r0.setColorRepeatCount(2);
        r0.setSpeedMultiplier(1.0f);
        r0.setCornerSmoothness(0.5f);
        if (r4 == null) goto L35;
        a(r0, ((Number) ZeusTransformUtils.preCheckCast(r4.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r4.b(), Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L35:
        Resources r5 = Resources.getSystem();
        o.c(r5, "Resources.getSystem()");
        int r6 = d.i.a.a(TypedValue.applyDimension(1, 44.0f, r5.getDisplayMetrics()));
        Resources r7 = Resources.getSystem();
        o.c(r7, "Resources.getSystem()");
        a(r0, r6, d.i.a.a(TypedValue.applyDimension(1, 42.0f, r7.getDisplayMetrics())));
        a(r0);
        return;
    L13:
        if (r3.equals(IFeatureServiceKt.PRODUCT_NERIDA_LITE) == false) goto L31;
    L26:
        Resources r8 = Resources.getSystem();
        o.c(r8, "Resources.getSystem()");
        Integer r9 = Integer.valueOf(d.i.a.a(TypedValue.applyDimension(1, 47.0f, r8.getDisplayMetrics())));
        Resources r10 = Resources.getSystem();
        o.c(r10, "Resources.getSystem()");
        r4 = new m(r9, Integer.valueOf(d.i.a.a(TypedValue.applyDimension(1, 47.0f, r10.getDisplayMetrics()))));
        goto L32
    L16:
        if (r3.equals(IFeatureServiceKt.PRODUCT_PIKE) == false) goto L31;
        Resources r11 = Resources.getSystem();
        o.c(r11, "Resources.getSystem()");
        Integer r12 = Integer.valueOf(d.i.a.a(TypedValue.applyDimension(1, 33.0f, r11.getDisplayMetrics())));
        Resources r13 = Resources.getSystem();
        o.c(r13, "Resources.getSystem()");
        r4 = new m(r12, Integer.valueOf(d.i.a.a(TypedValue.applyDimension(1, 33.0f, r13.getDisplayMetrics()))));
        goto L32
    L20:
        if (r3.equals("pacific") == false) goto L31;
        Resources r14 = Resources.getSystem();
        o.c(r14, "Resources.getSystem()");
        Integer r15 = Integer.valueOf(d.i.a.a(TypedValue.applyDimension(1, 44.0f, r14.getDisplayMetrics())));
        Resources r16 = Resources.getSystem();
        o.c(r16, "Resources.getSystem()");
        r4 = new m(r15, Integer.valueOf(d.i.a.a(TypedValue.applyDimension(1, 42.0f, r16.getDisplayMetrics()))));
        goto L32
    L24:
        if (r3.equals(IFeatureServiceKt.PRODUCT_NERIDA) == true) goto L26;
    L28:
        if (r3.equals(IFeatureServiceKt.PRODUCT_GENESIS_R) == false) goto L31;
        Resources r17 = Resources.getSystem();
        o.c(r17, "Resources.getSystem()");
        Integer r18 = Integer.valueOf(d.i.a.a(TypedValue.applyDimension(1, 57.0f, r17.getDisplayMetrics())));
        Resources r19 = Resources.getSystem();
        o.c(r19, "Resources.getSystem()");
        r4 = new m(r18, Integer.valueOf(d.i.a.a(TypedValue.applyDimension(1, 57.0f, r19.getDisplayMetrics()))));
        goto L32
    L8:
        r3 = "pacific";
        goto L10
    }

    private final void a(AiStrokeView r1, int r2, int r3) {
        r1.setCornerRadiusTopLeft(r2);
        r1.setCornerRadiusTopRight(r2);
        r1.setCornerRadiusBottomLeft(r3);
        r1.setCornerRadiusBottomRight(r3);
    }

    private final void a(AiStrokeView r5) {
        m<Integer, Integer> r0 = a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        if (r0 == null) goto L6;
        a(r5, ((Number) ZeusTransformUtils.preCheckCast(r0.c(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.d(), Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L6:
        r5.setOnApplyWindowInsetsListener(new $$Lambda$PlayerScreenEffectComponent$WCHJNPzqiR8EgOVvge8T23nUTi8(this));
        r5.requestApplyInsets();
    }

    private static final WindowInsets a(PlayerScreenEffectComponent r4, View r5, WindowInsets r6) {
        o.e(r5, "v");
        o.e(r6, "insets");
        m<Integer, Integer> r0 = r4.a(r6);
        if (r0 == null) goto L10;
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r0.d(), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (ZeusTransformUtils.instanceOf(r5, AiStrokeView.class) == false) goto L7;
        AiStrokeView r7 = (AiStrokeView) ZeusTransformUtils.preCheckCast(r5, AiStrokeView.class, "com.obric.aiagent.plugin");
    L8:
        if (r7 == null) goto L10;
        r4.a(r7, r1, r2);
        goto L10
    L7:
        r7 = null;
    L10:
        return r6;
    }

    private final m<Integer, Integer> a(View r3) {
        Display r2 = r3.getDisplay();
        if (r2 != null) goto L7;
        r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getDisplay();
        if (r2 != null) goto L7;
        return null;
    L7:
        RoundedCorner r4 = r2.getRoundedCorner(0);
        if (r4 == null) goto L17;
        int r5 = r4.getRadius();
        RoundedCorner r6 = r2.getRoundedCorner(3);
        if (r6 == null) goto L17;
        int r7 = r6.getRadius();
        if (r5 <= 0) goto L17;
        if (r7 <= 0) goto L17;
        return s.a(Integer.valueOf(r5), Integer.valueOf(r7));
    L17:
        return null;
    }

    private final m<Integer, Integer> a(WindowInsets r3) {
        RoundedCorner r2 = r3.getRoundedCorner(0);
        if (r2 == null) goto L12;
        int r4 = r2.getRadius();
        RoundedCorner r5 = r3.getRoundedCorner(3);
        if (r5 == null) goto L12;
        int r6 = r5.getRadius();
        if (r4 <= 0) goto L12;
        if (r6 <= 0) goto L12;
        return s.a(Integer.valueOf(r4), Integer.valueOf(r6));
    L12:
        return null;
    }

    private final void a(final float r9) {
        final AiStrokeView r0 = this.f25296b;
        if (r0 != null) goto L5;
        return;
    L5:
        final float r1 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density;
        Resources r3 = Resources.getSystem();
        o.c(r3, "Resources.getSystem()");
        int r4 = d.i.a.a(TypedValue.applyDimension(1, r9, r3.getDisplayMetrics()));
        int r5 = r0.getStrokeWidthPx();
        if (r5 != r4) goto L9;
        this.f = r9;
        return;
    L9:
        ValueAnimator r6 = this.f25299e;
        if (r6 == null) goto L12;
        r6.cancel();
    L12:
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r5, r4});
        r7.setDuration(200);
        r7.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r7.addUpdateListener(new $$Lambda$PlayerScreenEffectComponent$bRvri7_LJr86hadhbom8M36wlzM(r0, this, r1));
        r7.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new PlayerScreenEffectComponent$animateStrokeWidthTo$1$2(this, r9), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r7.start();
        this.f25299e = r7;
    }

    private static final void a(AiStrokeView r2, PlayerScreenEffectComponent r3, float r4, ValueAnimator r5) {
        o.e(r5, "animator");
        Object r6 = r5.getAnimatedValue();
        o.a(r6, "null cannot be cast to non-null type kotlin.Int");
        int r7 = ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.setStrokeWidthPx(r7);
        r3.f = r7 / r4;
    }

    @Override // androidx.lifecycle.d
    public void d(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.d(r4);
        AiStrokeView r2 = this.f25296b;
        if (r2 == null) goto L6;
        r2.stop();
        return;
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        ValueAnimator r5 = this.f25297c;
        if (r5 == null) goto L5;
        r5.cancel();
    L5:
        this.f25297c = null;
        this.f25296b = null;
        this.f25298d = null;
        c.a(null);
    }
}
