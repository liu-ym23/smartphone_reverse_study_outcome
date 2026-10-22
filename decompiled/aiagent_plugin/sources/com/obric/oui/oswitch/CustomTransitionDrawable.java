package com.obric.oui.oswitch;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CustomTransitionDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CustomTransitionDrawable extends Drawable {
    public static final a Companion = null;
    private static final int STATE_IDLE = 0;
    private static final int STATE_RUNNING = 2;
    private static final int STATE_STARTING = 1;
    private boolean crossFadeEnabled;
    private int currentAlpha;
    private int currentState;
    private int duration;
    private final Drawable endDrawable;
    private int fromAlpha;
    private Interpolator interpolator;
    private boolean isReverse;
    private final Drawable startDrawable;
    private long startTime;
    private int toAlpha;

    /* JADX INFO: compiled from: CustomTransitionDrawable.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CustomTransitionDrawable(Drawable r2, Drawable r3) {
        o.e(r2, "startDrawable");
        o.e(r3, "endDrawable");
        this.startDrawable = r2;
        this.endDrawable = r3;
        this.crossFadeEnabled = true;
        this.interpolator = (Interpolator) ZeusTransformUtils.preCheckCast(new AccelerateInterpolator(), Interpolator.class, "com.obric.aiagent.plugin");
    }

    public final void setInterpolator(Interpolator r3) {
        Interpolator r4 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r3, Interpolator.class, "com.obric.aiagent.plugin");
        o.e(r4, "interpolator");
        this.interpolator = r4;
    }

    public final void setCrossFadeEnabled(boolean r1) {
        this.crossFadeEnabled = r1;
    }

    public final boolean isCrossFadeEnabled() {
        return this.crossFadeEnabled;
    }

    public final void startTransition(int r3) {
        this.fromAlpha = 0;
        this.toAlpha = 255;
        this.currentAlpha = 0;
        this.duration = r3;
        this.isReverse = false;
        this.currentState = 1;
        invalidateSelf();
    }

    public final void reverseTransition(int r13) {
        long r0 = SystemClock.uptimeMillis();
        int r3 = 0;
        if (this.currentState != 2) goto L17;
        long r6 = this.startTime;
        long r8 = r0 - r6;
        int r2 = this.duration;
        if (r8 > r2) goto L17;
        boolean r14 = !this.isReverse;
        this.isReverse = r14;
        this.fromAlpha = this.currentAlpha;
        if (r14 == true) goto L11;
        r3 = 255;
    L11:
        this.toAlpha = r3;
        long r1 = r0 - r6;
        if (r14 == false) goto L14;
        int r15 = (int) r1;
    L15:
        this.duration = r15;
        this.currentState = 1;
        invalidateSelf();
        return;
    L14:
        r15 = r2 - ((int) r1);
    L17:
        this.fromAlpha = 255;
        this.toAlpha = 0;
        this.currentAlpha = 255;
        this.duration = r13;
        this.isReverse = true;
        this.currentState = 1;
        invalidateSelf();
    }

    public final void resetTransition() {
        this.currentAlpha = 0;
        this.currentState = 0;
        invalidateSelf();
    }

    public final void showSecondLayer() {
        this.currentAlpha = 255;
        this.currentState = 0;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r7) {
        o.e(r7, "canvas");
        int r0 = this.currentState;
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L11;
        long r1 = SystemClock.uptimeMillis() - this.startTime;
        int r3 = this.duration;
        if (r1 < r3) goto L9;
        this.currentAlpha = this.toAlpha;
        this.currentState = 0;
        goto L11
    L9:
        float r2 = this.interpolator.getInterpolation(r1 / r3);
        int r4 = this.fromAlpha;
        this.currentAlpha = r4 + ((int) ((this.toAlpha - r4) * r2));
    L11:
        int r5 = this.currentAlpha;
        if (this.currentState != 0) goto L20;
        if (r5 != 0) goto L15;
        this.startDrawable.setBounds(getBounds());
        this.startDrawable.draw(r7);
        return;
    L15:
        if (r5 == 255) goto L17;
        drawWithAlpha(r7, r5);
        return;
    L17:
        this.endDrawable.setBounds(getBounds());
        this.endDrawable.draw(r7);
        return;
    L20:
        drawWithAlpha(r7, r5);
        if (this.currentState != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.startTime = SystemClock.uptimeMillis();
        this.currentState = 2;
        goto L11
    }

    private final void drawWithAlpha(Canvas r3, int r4) {
        this.startDrawable.setBounds(getBounds());
        this.endDrawable.setBounds(getBounds());
        if (this.crossFadeEnabled == false) goto L5;
        this.startDrawable.setAlpha(255 - r4);
    L5:
        this.startDrawable.draw(r3);
        if (this.crossFadeEnabled == false) goto L8;
        this.startDrawable.setAlpha(255);
    L8:
        if (r4 <= 0) goto L11;
        this.endDrawable.setAlpha(r4);
        this.endDrawable.draw(r3);
        this.endDrawable.setAlpha(255);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.startDrawable.setAlpha(r2);
        this.endDrawable.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.startDrawable.setColorFilter(r2);
        this.endDrawable.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.startDrawable.getIntrinsicWidth(), this.endDrawable.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.startDrawable.getIntrinsicHeight(), this.endDrawable.getIntrinsicHeight());
    }
}
