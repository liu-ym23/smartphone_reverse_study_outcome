package com.obric.autoaction.presentation.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.b.h;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.oui.common.util.k;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: PlayerBubble.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PlayerBubble extends RelativeLayout {
    public static final c Companion = null;
    private static final String TAG = "Bubble";
    private h binding;
    private final float defaultX;
    private final float hideX;
    private final float hideY;
    private boolean isHideAnimating;
    private boolean isShowAnimating;
    private a mExpansionStatus;
    private Animator mOngoingExpansionAnimator;
    private boolean mSnappedToRight;
    private b mStaticStatus;
    private int mTvExpandedWidth;
    private float showX;
    private float showY;

    /* JADX INFO: compiled from: PlayerBubble.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25113a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f25114b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f25115c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f25116d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f25117e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f25113a, f25114b, f25115c, f25116d};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f25113a = new a("Collapsed", 0);
            f25114b = new a("Collapsing", 1);
            f25115c = new a("Expanding", 2);
            f25116d = new a("Expanded", 3);
            a[] r0 = a();
            f25117e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f25117e.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: PlayerBubble.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f25118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Integer f25119b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f25118a == r6.f25118a) goto L12;
            return false;
        L12:
            if (o.a(this.f25119b, r6.f25119b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.f25118a) * 31;
            Integer r1 = this.f25119b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "BubbleStatus(iconRes=" + this.f25118a + ", bgRes=" + this.f25119b + ')';
        }

        public b(int r1, Integer r2) {
            this.f25118a = r1;
            this.f25119b = r2;
        }

        public final int a() {
            return this.f25118a;
        }

        public /* synthetic */ b(int r1, Integer r2, int r3, d.h.b.h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = -1;
        L5:
            this(r1, r2);
        }
    }

    /* JADX INFO: compiled from: PlayerBubble.kt */
    public static final class c {
        public /* synthetic */ c(d.h.b.h r1) {
            this();
        }

        private c() {
        }
    }

    static {
        Companion = new c(null);
    }

    public PlayerBubble(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public PlayerBubble(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ x lambda$MoIxddVOtmc7PhTMnvSi71HLhTY(PlayerBubble r0, View r1, boolean r2, Throwable r3) {
        return hideBubble$lambda$10$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$YedcckIBMhIxD6g3GyuLKZrIp5c(PlayerBubble r0, View r1, boolean r2, Throwable r3) {
        return showBubble$lambda$12$lambda$11(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$efWHszXZ-1a0NKnBDgr9huUTnfs, reason: not valid java name */
    public static /* synthetic */ void m638lambda$efWHszXZ1a0NKnBDgr9huUTnfs(PlayerBubble r0, PlayerBubble r1, float r2, int r3, ValueAnimator r4) {
        collapseBubble$lambda$6$lambda$5(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$lsqA9H_JEO4A-xkVYrwJLj8if18, reason: not valid java name */
    public static /* synthetic */ void m639lambda$lsqA9H_JEO4AxkVYrwJLj8if18(PlayerBubble r0, PlayerBubble r1, float r2, int r3, ValueAnimator r4) {
        expandBubble$lambda$2$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$n3i2I5qCP4n0aMEzWb_KwQfepIo(PlayerBubble r0, boolean r1) {
        return configureSnapping$lambda$0(r0, r1);
    }

    public /* synthetic */ PlayerBubble(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ void access$setMExpansionStatus$p(PlayerBubble r0, a r1) {
        r0.mExpansionStatus = r1;
    }

    public PlayerBubble(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r6);
        this.mTvExpandedWidth = ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_bubble_expanded_width, "dimen", "auto_ai_bubble_expanded_width"));
        h r9 = h.a(LayoutInflater.from(r7), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        o.c(r9, "inflate(...)");
        this.binding = r9;
        this.mSnappedToRight = true;
        this.mExpansionStatus = a.f25113a;
        this.hideX = TypedValue.applyDimension(1, 145, Resources.getSystem().getDisplayMetrics());
        this.hideY = TypedValue.applyDimension(1, 654, Resources.getSystem().getDisplayMetrics());
        float r10 = 300;
        this.showX = TypedValue.applyDimension(1, r10, Resources.getSystem().getDisplayMetrics());
        this.showY = TypedValue.applyDimension(1, 400, Resources.getSystem().getDisplayMetrics());
        this.defaultX = TypedValue.applyDimension(1, r10, Resources.getSystem().getDisplayMetrics());
    }

    public final void setStaticStatus(b r2) {
        o.e(r2, "status");
        this.mStaticStatus = r2;
        this.binding.f24618c.setImageResource(r2.a());
    }

    public final boolean isSnappedToRight() {
        return this.mSnappedToRight;
    }

    public final void configureSnapping() {
        com.obric.autoaction.e.a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), new $$Lambda$PlayerBubble$n3i2I5qCP4n0aMEzWb_KwQfepIo(this));
    }

    private static final x configureSnapping$lambda$0(PlayerBubble r0, boolean r1) {
        r0.mSnappedToRight = r1;
        return x.f38692a;
    }

    public final boolean isInExpansionStatus() {
        if (this.mExpansionStatus != a.f25115c) goto L5;
    L8:
        return true;
    L5:
        if (this.mExpansionStatus == a.f25116d) goto L8;
        return false;
    }

    public final boolean isInCollapsingStatus() {
        if (this.mExpansionStatus != a.f25113a) goto L5;
    L8:
        return true;
    L5:
        if (this.mExpansionStatus == a.f25114b) goto L8;
        return false;
    }

    public final void cancelOngoingAnimator() {
        Animator r0 = this.mOngoingExpansionAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.mOngoingExpansionAnimator = null;
    }

    public final void expandBubble(CharSequence r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r14, "expandedText");
        final OTextView r0 = this.binding.f24617b;
        o.c(r0, "floatingIconExpandedText");
        r0.setText(r14);
        if (isInExpansionStatus() == false) goto L5;
        return;
    L5:
        this.mExpansionStatus = a.f25115c;
        cancelOngoingAnimator();
        r0.measure(0, 0);
        int r2 = this.mTvExpandedWidth;
        if (r2 > 0) goto L9;
        r2 = r0.getMeasuredWidth();
    L9:
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        o.a(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        int r5 = ((((this.binding.f24618c.getWidth() + r2) + r4.leftMargin) + r4.rightMargin) + this.binding.f24616a.getPaddingLeft()) + this.binding.f24616a.getPaddingRight();
        final int r6 = getWidth();
        final float r7 = getX();
        ValueAnimator r8 = ValueAnimator.ofInt(new int[]{r6, r5});
        r8.setDuration(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.player_bubble_expansion_duration_ms, WsChannelMultiProcessSharedProvider.INT_TYPE, "player_bubble_expansion_duration_ms")));
        r8.addUpdateListener(new $$Lambda$PlayerBubble$lsqA9H_JEO4AxkVYrwJLj8if18(this, this, r7, r6));
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{r0.getAlpha(), 1.0f});
        r15.setDuration(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.player_bubble_expansion_alpha_duration_ms, WsChannelMultiProcessSharedProvider.INT_TYPE, "player_bubble_expansion_alpha_duration_ms")));
        AnimatorSet r9 = new AnimatorSet();
        r9.play((Animator) ZeusTransformUtils.preCheckCast(r8, Animator.class, "com.obric.aiagent.plugin")).before((Animator) ZeusTransformUtils.preCheckCast(r15, Animator.class, "com.obric.aiagent.plugin"));
        r9.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new PlayerBubble$expandBubble$1$1(r0, this), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r9.start();
        this.mOngoingExpansionAnimator = (Animator) ZeusTransformUtils.preCheckCast(r9, Animator.class, "com.obric.aiagent.plugin");
    }

    private static final void expandBubble$lambda$2$lambda$1(PlayerBubble r5, PlayerBubble r6, float r7, int r8, ValueAnimator r9) {
        o.e(r9, "it");
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        Object r1 = r9.getAnimatedValue();
        o.a(r1, "null cannot be cast to non-null type kotlin.Int");
        r0.width = ((Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r5.setLayoutParams(r0);
        if (r6.mSnappedToRight == true) goto L5;
        r5.setX(r7);
        return;
    L5:
        Object r10 = r9.getAnimatedValue();
        o.a(r10, "null cannot be cast to non-null type kotlin.Int");
        r5.setX(r7 - (((Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.aiagent.plugin")).intValue() - r8));
    }

    public final void collapseBubble() {
        if (isInCollapsingStatus() == false) goto L6;
        Loog.INSTANCE.w(TAG, "cannot re-collapsed an already collapsed / collapsing bubble.");
        return;
    L6:
        this.mExpansionStatus = a.f25114b;
        cancelOngoingAnimator();
        final OTextView r0 = this.binding.f24617b;
        o.c(r0, "floatingIconExpandedText");
        final int r1 = getWidth();
        final float r2 = getX();
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{r1, (this.binding.f24618c.getWidth() + this.binding.f24616a.getPaddingLeft()) + this.binding.f24616a.getPaddingRight()});
        r4.setDuration(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.player_bubble_expansion_duration_ms, WsChannelMultiProcessSharedProvider.INT_TYPE, "player_bubble_expansion_duration_ms")));
        r4.addUpdateListener(new $$Lambda$PlayerBubble$efWHszXZ1a0NKnBDgr9huUTnfs(this, this, r2, r1));
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{r0.getAlpha(), 0.0f});
        r3.setDuration(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.player_bubble_expansion_alpha_duration_ms, WsChannelMultiProcessSharedProvider.INT_TYPE, "player_bubble_expansion_alpha_duration_ms")));
        AnimatorSet r5 = new AnimatorSet();
        r5.play((Animator) ZeusTransformUtils.preCheckCast(r3, Animator.class, "com.obric.aiagent.plugin")).before((Animator) ZeusTransformUtils.preCheckCast(r4, Animator.class, "com.obric.aiagent.plugin"));
        r5.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new PlayerBubble$collapseBubble$1$1(r0, this), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r5.start();
        this.mOngoingExpansionAnimator = (Animator) ZeusTransformUtils.preCheckCast(r5, Animator.class, "com.obric.aiagent.plugin");
    }

    private static final void collapseBubble$lambda$6$lambda$5(PlayerBubble r5, PlayerBubble r6, float r7, int r8, ValueAnimator r9) {
        o.e(r9, "it");
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        Object r1 = r9.getAnimatedValue();
        o.a(r1, "null cannot be cast to non-null type kotlin.Int");
        r0.width = ((Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r5.setLayoutParams(r0);
        if (r6.mSnappedToRight == true) goto L5;
        r5.setX(r7);
        return;
    L5:
        Object r10 = r9.getAnimatedValue();
        o.a(r10, "null cannot be cast to non-null type kotlin.Int");
        r5.setX(r7 - (((Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.aiagent.plugin")).intValue() - r8));
    }

    public final void hideBubble() {
        setClickable(false);
        final View r2 = this.binding.a();
        o.a(r2);
        if (k.e(r2) == false) goto L5;
        return;
    L5:
        if (r2.getAlpha() != 0.0f) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        if (this.isHideAnimating == false) goto L12;
        return;
    L12:
        if (this.isShowAnimating == false) goto L14;
    L31:
        this.isHideAnimating = true;
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a(r2, 0.0f, 1, null), this.hideX, this.hideY, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.f32430c, e.c.g, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.c.f32439b, e.b.f32433a, e.d.f32443a), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).a(new $$Lambda$PlayerBubble$MoIxddVOtmc7PhTMnvSi71HLhTY(this, r2)).b(), null, null, 3, null);
        return;
    L14:
        if (r2.getX() != 0.0f) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
    L23:
        ViewParent r5 = r2.getParent();
        o.a(r5, "null cannot be cast to non-null type android.view.View");
        if ((r2.getX() + (r2.getWidth() / 2)) <= (((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin")).getWidth() / 2)) goto L26;
        boolean r6 = true;
    L27:
        if (r6 == false) goto L29;
        float r7 = this.defaultX;
    L30:
        this.showX = r7;
        this.showY = r2.getY();
        goto L31
    L29:
        r7 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_bubble_margin_to_screen_end, "dimen", "auto_ai_bubble_margin_to_screen_end"));
        goto L30
    L26:
        r6 = false;
        goto L27
    L19:
        if (r2.getY() != 0.0f) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == true) goto L31;
    L21:
        r8 = false;
        goto L22
    L16:
        r4 = false;
        goto L17
    L7:
        r3 = false;
        goto L8
    }

    private static final x hideBubble$lambda$10$lambda$9(PlayerBubble r0, View r1, boolean r2, Throwable r3) {
        r0.isHideAnimating = false;
        r1.setClickable(false);
        if (r3 == null) goto L6;
        ILogDepend.Companion.e(TAG, "hideBubble: 动画异常", r3);
    L6:
        return x.f38692a;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    public final void showBubble() {
        setClickable(true);
        final View r2 = this.binding.a();
        o.a(r2);
        if (k.e(r2) == true) goto L10;
        if (r2.getAlpha() != 1.0f) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        return;
    L7:
        r3 = false;
    L10:
        if (this.isShowAnimating == true) goto L14;
        this.isShowAnimating = true;
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a(r2, 0.0f, 1, null), this.showX, this.showY, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.f32430c, e.c.g, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null), 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.c.f32439b, e.b.f32433a, e.d.f32443a), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).a(new $$Lambda$PlayerBubble$YedcckIBMhIxD6g3GyuLKZrIp5c(this, r2)).b(), null, null, 3, null);
        return;
    }

    private static final x showBubble$lambda$12$lambda$11(PlayerBubble r0, View r1, boolean r2, Throwable r3) {
        r0.isShowAnimating = false;
        r1.setClickable(true);
        if (r3 == null) goto L6;
        ILogDepend.Companion.e(TAG, "showBubble: 动画异常", r3);
    L6:
        return x.f38692a;
    }
}
