package com.android.contacts.widget;

import android.database.CharArrayBuffer;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.android.contacts.format.FormatUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TextHighlightingAnimation implements Runnable, TextWithHighlightingFactory {
    private static final long FRAME_RATE = 50;
    private static final int MAX_ALPHA = 255;
    private static final int MIN_ALPHA = 50;
    private static final DimmingSpan[] sEmptySpans = null;
    private AccelerateInterpolator ACCELERATE_INTERPOLATOR;
    private DecelerateInterpolator DECELERATE_INTERPOLATOR;
    private boolean mAnimating;
    private boolean mDimming;
    private DimmingSpan mDimmingSpan;
    private final int mDuration;
    private Handler mHandler;
    private long mTargetTime;

    /* JADX INFO: renamed from: com.android.contacts.widget.TextHighlightingAnimation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DimmingSpan extends CharacterStyle {
        private int mAlpha;

        private DimmingSpan() {
        }

        /* synthetic */ DimmingSpan(AnonymousClass1 r1) {
            this();
        }

        public void setAlpha(int r1) {
            this.mAlpha = r1;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r6) {
            int[] r0 = r6.drawableState;
            if (r0 == null) goto L14;
            int r1 = r0.length;
            int r2 = 0;
        L5:
            if (r2 >= r1) goto L14;
            int r3 = r0[r2];
            if (r3 == 16842908) goto L13;
            if (r3 == 16842913) goto L20;
            if (r3 == 16842919) goto L21;
            r2 = r2 + 1;
            goto L5
        L21:
            return;
        L20:
            return;
        L13:
            return;
        L14:
            int r4 = r6.getColor();
            r6.setColor(Color.argb(this.mAlpha, Color.red(r4), Color.green(r4), Color.blue(r4)));
        }
    }

    public class TextWithHighlightingImpl implements TextWithHighlighting {
        private boolean mDimmingEnabled;
        private int mDimmingSpanEnd;
        private int mDimmingSpanStart;
        private final DimmingSpan[] mSpans;
        private String mString;
        private CharArrayBuffer mText;
        final /* synthetic */ TextHighlightingAnimation this$0;

        @Override // android.text.Spanned
        public int getSpanFlags(Object r1) {
            return 0;
        }

        @Override // android.text.Spanned
        public int nextSpanTransition(int r1, int r2, Class r3) {
            return 0;
        }

        public TextWithHighlightingImpl(TextHighlightingAnimation r3) {
            this.this$0 = r3;
            this.mSpans = new DimmingSpan[]{TextHighlightingAnimation.access$000(r3)};
        }

        @Override // com.android.contacts.widget.TextWithHighlighting
        public void setText(CharArrayBuffer r5, CharArrayBuffer r6) {
            this.mText = r5;
            this.mString = new String(this.mText.data, 0, this.mText.sizeCopied);
            int r7 = FormatUtils.overlapPoint(r5, r6);
            if (r7 != 0) goto L5;
        L8:
            this.mDimmingEnabled = false;
            return;
        L5:
            if (r7 == (-1)) goto L8;
            this.mDimmingEnabled = true;
            this.mDimmingSpanStart = 0;
            this.mDimmingSpanEnd = r7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.Spanned
        public <T> T[] getSpans(int r1, int r2, Class<T> r3) {
            if (this.mDimmingEnabled == false) goto L7;
            return (T[]) this.mSpans;
        L7:
            return (T[]) TextHighlightingAnimation.access$100();
        }

        @Override // android.text.Spanned
        public int getSpanStart(Object r1) {
            return this.mDimmingSpanStart;
        }

        @Override // android.text.Spanned
        public int getSpanEnd(Object r1) {
            return this.mDimmingSpanEnd;
        }

        @Override // java.lang.CharSequence
        public char charAt(int r1) {
            return this.mText.data[r1];
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.mText.sizeCopied;
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r2, int r3) {
            return new String(this.mText.data, r2, r3);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            return this.mString;
        }
    }

    protected abstract void invalidate();

    protected void onAnimationEnded() {
    }

    protected void onAnimationStarted() {
    }

    static /* synthetic */ DimmingSpan access$000(TextHighlightingAnimation r0) {
        return r0.mDimmingSpan;
    }

    static /* synthetic */ DimmingSpan[] access$100() {
        return sEmptySpans;
    }

    @Override // com.android.contacts.widget.TextWithHighlightingFactory
    public /* bridge */ /* synthetic */ TextWithHighlighting createTextWithHighlighting() {
        return createTextWithHighlighting();
    }

    static {
        sEmptySpans = new DimmingSpan[0];
    }

    public TextHighlightingAnimation(int r2) {
        this.ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();
        this.DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
        this.mDuration = r2;
        this.mHandler = new Handler();
        DimmingSpan r3 = new DimmingSpan(null);
        this.mDimmingSpan = r3;
        r3.setAlpha(255);
    }

    @Override // com.android.contacts.widget.TextWithHighlightingFactory
    public TextWithHighlightingImpl createTextWithHighlighting() {
        return new TextWithHighlightingImpl(this);
    }

    public void startHighlighting() {
        startAnimation(true);
    }

    public void stopHighlighting() {
        startAnimation(false);
    }

    private void startAnimation(boolean r7) {
        if (this.mDimming == r7) goto L9;
        this.mDimming = r7;
        long r0 = System.currentTimeMillis();
        if (this.mAnimating == true) goto L7;
        this.mAnimating = true;
        this.mTargetTime = r0 + ((long) this.mDuration);
        onAnimationStarted();
        this.mHandler.post(this);
        return;
    L7:
        this.mTargetTime = (((long) this.mDuration) + r0) - (this.mTargetTime - r0);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        long r2 = this.mTargetTime - System.currentTimeMillis();
        if (r2 >= 0) goto L10;
        DimmingSpan r0 = this.mDimmingSpan;
        if (this.mDimming == false) goto L7;
        int r1 = 50;
    L8:
        r0.setAlpha(r1);
        this.mAnimating = false;
        onAnimationEnded();
        return;
    L7:
        r1 = 255;
        goto L8
    L10:
        float r3 = r2 / this.mDuration;
        if (this.mDimming == false) goto L13;
        this.mDimmingSpan.setAlpha((int) ((this.DECELERATE_INTERPOLATOR.getInterpolation(r3) * 205.0f) + 50.0f));
    L14:
        invalidate();
        this.mHandler.postDelayed(this, 50);
        return;
    L13:
        this.mDimmingSpan.setAlpha((int) (((1.0f - this.ACCELERATE_INTERPOLATOR.getInterpolation(r3)) * 205.0f) + 50.0f));
        goto L14
    }
}
