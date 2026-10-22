package com.obric.oui.segmentedtab;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OTouchAnimView.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OTouchAnimView extends RelativeLayout {
    private static final float ALPHA_ON_PRESS = 0.5f;
    public static final a Companion = null;
    public static final String PRESS_ANIM_SCENE_PRESS = "press_anim";
    public static final String PRESS_ANIM_SCENE_RELEASE = "release_anim";
    private static final String TAG = "TouchAnimView";
    private float animValue;
    private ValueAnimator pressAnimator;
    private ValueAnimator releaseAnimator;

    /* JADX INFO: compiled from: OTouchAnimView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        public final float a(float r2) {
            return 1 - (r2 * OTouchAnimView.ALPHA_ON_PRESS);
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OTouchAnimView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OTouchAnimView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$PNiUo8-07B5qQtvN6pvYCoSdr6E, reason: not valid java name */
    public static /* synthetic */ void m1161lambda$PNiUo807B5qQtvN6pvYCoSdr6E(OTouchAnimView r0, ValueAnimator r1) {
        m1163startPressAnim$lambda1$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$k8QmJAWrZCKikXEQ-xzP8XjuMLU, reason: not valid java name */
    public static /* synthetic */ void m1162lambda$k8QmJAWrZCKikXEQxzP8XjuMLU(OTouchAnimView r0, ValueAnimator r1) {
        m1164startReleaseAnim$lambda4$lambda3(r0, r1);
    }

    public abstract boolean canPerFormAnim();

    public abstract void onTouchAnimUpdate(float r1, String r2);

    public /* synthetic */ OTouchAnimView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OTouchAnimView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        o.e(r3, "event");
        int r0 = r3.getAction();
        if (r0 != 0) goto L5;
        startPressAnim();
    L12:
        return super.dispatchTouchEvent(r3);
    L5:
        if (r0 != 1) goto L7;
    L9:
        startReleaseAnim();
        goto L12
    L7:
        if (r0 == 3) goto L9;
        goto L9
    }

    private final void startPressAnim() {
        if (canPerFormAnim() == true) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.releaseAnimator;
        if (r0 == null) goto L9;
        r0.removeAllUpdateListeners();
    L9:
        ValueAnimator r1 = this.releaseAnimator;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        ValueAnimator r2 = this.pressAnimator;
        if (r2 == null) goto L17;
        r2.cancel();
    L17:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.animValue, 1.0f});
        r3.setDuration(50);
        r3.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r3.addUpdateListener(new $$Lambda$OTouchAnimView$PNiUo807B5qQtvN6pvYCoSdr6E(this));
        r3.start();
        this.pressAnimator = r3;
    }

    /* JADX INFO: renamed from: startPressAnim$lambda-1$lambda-0, reason: not valid java name */
    private static final void m1163startPressAnim$lambda1$lambda0(OTouchAnimView r2, ValueAnimator r3) {
        o.e(r2, "this$0");
        o.e(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.animValue = r5;
        r2.onTouchAnimUpdate(r5, PRESS_ANIM_SCENE_PRESS);
    }

    private final void startReleaseAnim() {
        if (canPerFormAnim() == true) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.pressAnimator;
        if (r0 == null) goto L9;
        r0.removeAllUpdateListeners();
    L9:
        ValueAnimator r1 = this.pressAnimator;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        ValueAnimator r2 = this.releaseAnimator;
        if (r2 == null) goto L17;
        r2.cancel();
    L17:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.animValue, 0.0f});
        r3.setDuration(200);
        r3.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r3.addUpdateListener(new $$Lambda$OTouchAnimView$k8QmJAWrZCKikXEQxzP8XjuMLU(this));
        r3.start();
        this.releaseAnimator = r3;
    }

    /* JADX INFO: renamed from: startReleaseAnim$lambda-4$lambda-3, reason: not valid java name */
    private static final void m1164startReleaseAnim$lambda4$lambda3(OTouchAnimView r2, ValueAnimator r3) {
        o.e(r2, "this$0");
        o.e(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.animValue = r5;
        r2.onTouchAnimUpdate(r5, PRESS_ANIM_SCENE_RELEASE);
    }

    public final boolean isAnimRunning() {
        ValueAnimator r0 = this.pressAnimator;
        if (r0 != null) goto L6;
    L4:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L17;
        ValueAnimator r3 = this.releaseAnimator;
        if (r3 != null) goto L13;
    L11:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L17;
        return false;
    L13:
        if (r3.isRunning() != true) goto L11;
        r4 = true;
    L17:
        return true;
    L6:
        if (r0.isRunning() != true) goto L4;
        r1 = true;
        goto L8
    }

    public final void cancelAnim() {
        ValueAnimator r0 = this.pressAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        ValueAnimator r1 = this.releaseAnimator;
        if (r1 == null) goto L11;
        r1.cancel();
        return;
    }
}
