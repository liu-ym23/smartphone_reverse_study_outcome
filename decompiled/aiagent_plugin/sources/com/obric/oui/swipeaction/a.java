package com.obric.oui.swipeaction;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.obric.oui.button.OIconButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: OSwipeQuickDeleteHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements OSwipeLayout.e, OSwipeLayout.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0994a f36276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OSwipeLayout f36277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ViewGroup f36278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f36279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f36280e;
    private final List<View> f;
    private final Map<View, Integer> g;
    private View h;
    private Integer i;
    private Integer j;
    private Integer k;
    private int l;
    private boolean m;
    private final ArgbEvaluator n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private AnimatorSet t;

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OSwipeQuickDeleteHelper.kt */
    public static final class C0994a {
        public /* synthetic */ C0994a(h r1) {
            this();
        }

        private C0994a() {
        }
    }

    /* JADX INFO: compiled from: OSwipeQuickDeleteHelper.kt */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: OSwipeQuickDeleteHelper.kt */
    public interface c {
        void a(boolean r1);
    }

    static {
        f36276a = new C0994a(null);
    }

    public static /* synthetic */ void lambda$ePb_A3UBBO5vMCu7gXtzItG8BCI(a r0, ValueAnimator r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$t5LLy2CbAsZEb6iFKorlihU5eI0(a r0, ValueAnimator r1) {
        a(r0, r1);
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.i
    public void a(OSwipeLayout r1) {
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.i
    public void c(OSwipeLayout r1) {
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.i
    public void b(OSwipeLayout r1) {
        c();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.i
    public void d(OSwipeLayout r1) {
        c();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.i
    public void a(OSwipeLayout r3, int r4, int r5) {
        o.e(r3, "layout");
        if (r3.mOverrideDragDistance <= 0) goto L5;
        int r6 = r3.mOverrideDragDistance;
    L6:
        float r7 = r6;
        float r0 = 0.0f;
        if (r7 != 0.0f) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        float r8 = Math.abs(r4);
        float r2 = r8 / r7;
        this.o = r8;
        this.p = r7;
        if (r2 < r3.mQuickDeleteThreshold) goto L15;
        r0 = 1.0f;
    L15:
        a(r0);
        a(r8, r7, r2);
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r6 = r3.getDragDistance();
        goto L6
    }

    private final void a(float r12) {
        if (this.q != r12) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.q = r12;
        AnimatorSet r1 = this.t;
        if (r1 == null) goto L12;
        r1.cancel();
    L12:
        this.t = new AnimatorSet();
        float r2 = 1.0f;
        if (r12 != 1.0f) goto L15;
        boolean r13 = true;
    L16:
        float[] r4 = new float[2];
        r4[0] = this.r;
        if (r13 == false) goto L19;
        float r6 = 1.0f;
    L20:
        r4[1] = r6;
        ValueAnimator r5 = ValueAnimator.ofFloat(r4);
        r5.setDuration(300);
        r5.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r5.addUpdateListener(new $$Lambda$a$t5LLy2CbAsZEb6iFKorlihU5eI0(this));
        float[] r8 = new float[2];
        r8[0] = this.s;
        if (r13 == true) goto L24;
        r2 = 0.0f;
    L24:
        r8[1] = r2;
        ValueAnimator r14 = ValueAnimator.ofFloat(r8);
        r14.setDuration(300);
        r14.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r14.addUpdateListener(new $$Lambda$a$ePb_A3UBBO5vMCu7gXtzItG8BCI(this));
        AnimatorSet r3 = this.t;
        if (r3 == null) goto L28;
        r3.playTogether(new Animator[]{(Animator) ZeusTransformUtils.preCheckCast(r5, Animator.class, "com.obric.aiagent.plugin"), (Animator) ZeusTransformUtils.preCheckCast(r14, Animator.class, "com.obric.aiagent.plugin")});
    L28:
        AnimatorSet r11 = this.t;
        if (r11 == null) goto L33;
        r11.start();
        return;
    L33:
        return;
    L19:
        r6 = 0.0f;
        goto L20
    L15:
        r13 = false;
        goto L16
    L5:
        r0 = false;
        goto L6
    }

    private static final void a(a r2, ValueAnimator r3) {
        o.e(r2, "this$0");
        o.e(r3, "it");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.r = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.b();
    }

    private static final void b(a r2, ValueAnimator r3) {
        o.e(r2, "this$0");
        o.e(r3, "it");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.s = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.b();
    }

    private final void b() {
        float r0 = this.p;
        if (r0 <= 0.0f) goto L6;
        float r1 = this.o;
        a(r1, r0, r1 / r0);
        return;
    }

    private final void a(float r10, float r11, float r12) {
        ViewGroup.MarginLayoutParams r1 = null;
        int r3 = 0;
        if (r12 > 1.0f) goto L43;
        float r13 = this.l - r10;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r15 = 0;
    L6:
        if (r14.hasNext() == false) goto L21;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r14.next(), View.class, "com.obric.aiagent.plugin");
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r5), Integer.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        int r7 = r5.getWidth();
    L12:
        if (r5.getLayoutParams().width == r7) goto L14;
        r5.getLayoutParams().width = r7;
        r5.requestLayout();
    L14:
        r15 = r15 + r7;
        float r8 = r15 - r13;
        float r9 = 0.0f;
        if (r7 <= 0) goto L18;
        r9 = n.a(r8 / r7, 0.0f, 1.0f);
    L20:
        r5.setAlpha(r9);
        r5.setScaleX(r9);
        r5.setScaleY(r9);
        goto L6
    L18:
        if (r8 < 0.0f) goto L20;
        r9 = 1.0f;
        goto L20
    L10:
        r7 = r6.intValue();
        goto L12
    L21:
        View r16 = this.h;
        if (r16 == null) goto L36;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r17, ViewGroup.MarginLayoutParams.class) == false) goto L27;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r17, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L27:
        if (r1 == null) goto L36;
        if (this.i == null) goto L36;
        int r18 = r1.getMarginStart();
        Integer r19 = this.i;
        if (r19 != null) goto L34;
    L35:
        Integer r110 = this.i;
        o.a(r110);
        r1.setMarginStart(r110.intValue());
        r16.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        goto L36
    L34:
        if (r18 != r19.intValue()) goto L35;
    L36:
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(p.e(this.f, 1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L38:
        if (r111.hasNext() == false) goto L42;
        View r112 = (View) ZeusTransformUtils.preCheckCast(r111.next(), View.class, "com.obric.aiagent.plugin");
        if (r112.getVisibility() == 0) goto L38;
        r112.setVisibility(0);
        goto L38
    L42:
        this.f36278c.requestLayout();
        return;
    L43:
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L45:
        if (r113.hasNext() == false) goto L52;
        View r20 = (View) ZeusTransformUtils.preCheckCast(r113.next(), View.class, "com.obric.aiagent.plugin");
        if (r20.getAlpha() != 1.0f) goto L49;
        boolean r21 = true;
    L50:
        if (r21 == true) goto L45;
        r20.setAlpha(1.0f);
        r20.setScaleX(1.0f);
        r20.setScaleY(1.0f);
        goto L45
    L49:
        r21 = false;
        goto L50
    L52:
        float r114 = n.b(r10 - r11, r11 * (this.f36277b.mQuickDeleteMax - 1.0f));
        View r115 = this.h;
        if (r115 != null) goto L55;
        return;
    L55:
        float r22 = 1.0f - this.r;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(p.e(this.f, 1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L57:
        if (r2.hasNext() == false) goto L65;
        View r23 = (View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.aiagent.plugin");
        r23.setAlpha(r22);
        r23.setScaleX(r22);
        r23.setScaleY(r22);
        Integer r24 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r23), Integer.class, "com.obric.aiagent.plugin");
        if (r24 != null) goto L61;
        int r25 = r23.getWidth();
    L62:
        int r26 = (int) (r25 * r22);
        if (r23.getLayoutParams().width == r26) goto L57;
        r23.getLayoutParams().width = r26;
        r23.requestLayout();
        goto L57
    L61:
        r25 = r24.intValue();
        goto L62
    L65:
        float r4 = this.s;
        ViewGroup.LayoutParams r27 = r115.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r27, ViewGroup.MarginLayoutParams.class) == false) goto L68;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r27, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L68:
        if (r1 == null) goto L76;
        Integer r28 = this.i;
        if (r28 == null) goto L73;
        r3 = r28.intValue();
    L73:
        int r0 = (int) (r3 * (1.0f - r4));
        if (r1.getMarginStart() == r0) goto L76;
        r1.setMarginStart(r0);
        r115.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L76:
        Integer r29 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r115), Integer.class, "com.obric.aiagent.plugin");
        if (r29 != null) goto L79;
        int r30 = r115.getWidth();
    L80:
        int r116 = (int) (r30 + r114);
        int r117 = (int) (r116 + ((((int) (r10 - (this.f36278c.getPaddingLeft() + this.f36278c.getPaddingRight()))) - r116) * r4));
        if (r115.getLayoutParams().width == r117) goto L84;
        r115.getLayoutParams().width = r117;
        r115.requestLayout();
    L84:
        if (ZeusTransformUtils.instanceOf(r115, ImageView.class) == false) goto L98;
        if (this.j == null) goto L98;
        Integer r118 = this.k;
        if (r118 == null) goto L93;
        ArgbEvaluator r31 = this.n;
        o.a(r118);
        Integer r32 = this.j;
        o.a(r32);
        Object r119 = r31.evaluate(r4, r118, r32);
        Objects.requireNonNull(r119, "null cannot be cast to non-null type kotlin.Int");
        int r120 = ((Integer) ZeusTransformUtils.preCheckCast(r119, Integer.class, "com.obric.aiagent.plugin")).intValue();
        if (((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.aiagent.plugin")).getBackgroundTintList() == null) goto L92;
        ((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.aiagent.plugin")).setBackgroundTintList(ColorStateList.valueOf(r120));
        goto L93
    L92:
        r115.setBackgroundColor(r120);
    L93:
        ArgbEvaluator r121 = this.n;
        Integer r33 = this.j;
        o.a(r33);
        Object r34 = r121.evaluate(r4, r33, -1);
        Objects.requireNonNull(r34, "null cannot be cast to non-null type kotlin.Int");
        int r35 = ((Integer) ZeusTransformUtils.preCheckCast(r34, Integer.class, "com.obric.aiagent.plugin")).intValue();
        if (((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.aiagent.plugin")).getImageTintList() == null) goto L96;
        ((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.aiagent.plugin")).setImageTintList(ColorStateList.valueOf(r35));
        goto L98
    L96:
        ((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.aiagent.plugin")).setColorFilter(r35);
    L98:
        if (ZeusTransformUtils.instanceOf(r115, OIconButton.class) == false) goto L121;
        ((OIconButton) ZeusTransformUtils.preCheckCast(r115, OIconButton.class, "com.obric.aiagent.plugin")).setAlignmentProgress(r4);
        return;
    L121:
        return;
    L79:
        r30 = r29.intValue();
        goto L80
    }

    private final void c() {
        this.r = 0.0f;
        this.s = 0.0f;
        this.q = 0.0f;
        AnimatorSet r1 = this.t;
        if (r1 == null) goto L6;
        r1.cancel();
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(p.e(this.f, 1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.aiagent.plugin");
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r3), Integer.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L12;
        int r5 = r3.getWidth();
    L14:
        if (r3.getLayoutParams().width == r5) goto L16;
        r3.getLayoutParams().width = r5;
    L16:
        r3.setAlpha(1.0f);
        r3.setScaleX(1.0f);
        r3.setScaleY(1.0f);
        if (r3.getVisibility() == 0) goto L8;
        r3.setVisibility(0);
        goto L8
    L12:
        r5 = r4.intValue();
        goto L14
    L19:
        View r6 = this.h;
        if (r6 == null) goto L59;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r6), Integer.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L25;
        int r8 = r6.getWidth();
    L27:
        if (r6.getLayoutParams().width == r8) goto L30;
        r6.getLayoutParams().width = r8;
    L30:
        if (ZeusTransformUtils.instanceOf(r6, OIconButton.class) == false) goto L32;
        ((OIconButton) ZeusTransformUtils.preCheckCast(r6, OIconButton.class, "com.obric.aiagent.plugin")).setAlignmentProgress(0.0f);
    L32:
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L35;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L36:
        if (r9 == null) goto L46;
        if (this.i == null) goto L46;
        int r10 = r9.getMarginStart();
        Integer r11 = this.i;
        if (r11 != null) goto L43;
    L44:
        Integer r12 = this.i;
        o.a(r12);
        r9.setMarginStart(r12.intValue());
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        goto L46
    L43:
        if (r10 != r11.intValue()) goto L44;
    L46:
        if (ZeusTransformUtils.instanceOf(r6, ImageView.class) == false) goto L59;
        if (this.j == null) goto L54;
        if (((ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.aiagent.plugin")).getImageTintList() == null) goto L52;
        ImageView r13 = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.aiagent.plugin");
        Integer r14 = this.j;
        o.a(r14);
        r13.setImageTintList(ColorStateList.valueOf(r14.intValue()));
        goto L54
    L52:
        ImageView r15 = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.aiagent.plugin");
        Integer r16 = this.j;
        o.a(r16);
        r15.setColorFilter(r16.intValue());
    L54:
        if (this.k == null) goto L59;
        if (((ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.aiagent.plugin")).getBackgroundTintList() == null) goto L58;
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.aiagent.plugin");
        Integer r18 = this.k;
        o.a(r18);
        r17.setBackgroundTintList(ColorStateList.valueOf(r18.intValue()));
        goto L59
    L58:
        Integer r19 = this.k;
        o.a(r19);
        r6.setBackgroundColor(r19.intValue());
        goto L59
    L35:
        r9 = null;
        goto L36
    L25:
        r8 = r7.intValue();
    L59:
        this.f36278c.requestLayout();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.i
    public void a(OSwipeLayout r4, float r5, float r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        float r7 = ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        if (this.m == false) goto L7;
        return;
    L7:
        View r0 = this.h;
        boolean r1 = false;
        if (r0 == null) goto L17;
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r0), Integer.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L13;
        View r9 = this.h;
        o.a(r9);
        int r10 = r9.getWidth();
    L15:
        if (Math.abs(this.o) < (this.l - r10)) goto L17;
        r1 = true;
        goto L17
    L13:
        r10 = r8.intValue();
    L17:
        if (r1 == false) goto L19;
        r4.setDragDistance((int) (this.l / r7));
        r4.open();
        return;
    L19:
        r4.close();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.e
    public void a(boolean r2) {
        if (this.m != r2) goto L5;
        return;
    L5:
        this.m = r2;
        c r0 = this.f36280e;
        if (r0 == null) goto L10;
        r0.a(r2);
    L10:
        if (this.m == false) goto L13;
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36277b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 3);
        return;
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.e
    public void a() {
        b r0 = this.f36279d;
        if (r0 == null) goto L7;
        r0.a();
        return;
    }
}
