package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed;
    private int mSide;

    public SidePropagation() {
        this.mPropagationSpeed = 3.0f;
        this.mSide = 80;
    }

    public void setSide(int r1) {
        this.mSide = r1;
    }

    public void setPropagationSpeed(float r2) {
        if (r2 == 0.0f) goto L7;
        this.mPropagationSpeed = r2;
        return;
    L7:
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup r17, Transition r18, TransitionValues r19, TransitionValues r20) {
        TransitionValues r0 = r19;
        if (r0 != null) goto L6;
        if (r20 != null) goto L6;
        return 0;
    L6:
        Rect r1 = r18.getEpicenter();
        if (r20 != null) goto L9;
    L12:
        int r13 = -1;
    L13:
        int r3 = getViewX(r0);
        int r4 = getViewY(r0);
        int[] r5 = new int[2];
        r17.getLocationOnScreen(r5);
        int r6 = r5[0] + Math.round(r17.getTranslationX());
        int r7 = r5[1] + Math.round(r17.getTranslationY());
        int r8 = r6 + r17.getWidth();
        int r9 = r7 + r17.getHeight();
        if (r1 == null) goto L16;
        int r10 = r1.centerX();
        int r15 = r1.centerY();
    L17:
        float r2 = distance(r17, r3, r4, r10, r15, r6, r7, r8, r9) / getMaxDistance(r17);
        long r11 = r18.getDuration();
        if (r11 >= 0) goto L21;
        r11 = 300;
    L21:
        return Math.round(((r11 * ((long) r13)) / this.mPropagationSpeed) * r2);
    L16:
        r10 = (r6 + r8) / 2;
        r15 = (r7 + r9) / 2;
        goto L17
    L9:
        if (getViewVisibility(r0) == 0) goto L12;
        r0 = r20;
        r13 = 1;
        goto L13
    }

    private int distance(View r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        int r5 = this.mSide;
        boolean r4 = true;
        if (r5 != 8388611) goto L12;
        if (ViewCompat.getLayoutDirection(r6) == 1) goto L8;
        r4 = false;
    L8:
        if (r4 == false) goto L10;
    L9:
        r5 = 5;
    L19:
        if (r5 == 3) goto L30;
        if (r5 == 5) goto L33;
        if (r5 == 48) goto L32;
        if (r5 == 80) goto L31;
        return 0;
    L31:
        return (r8 - r12) + Math.abs(r9 - r7);
    L32:
        return (r14 - r8) + Math.abs(r9 - r7);
    L33:
        return (r7 - r11) + Math.abs(r10 - r8);
    L30:
        return (r13 - r7) + Math.abs(r10 - r8);
    L10:
        r5 = 3;
        goto L19
    L12:
        if (r5 != 8388613) goto L19;
        if (ViewCompat.getLayoutDirection(r6) == 1) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L9;
        goto L9
    }

    private int getMaxDistance(ViewGroup r2) {
        int r1 = this.mSide;
        if (r1 == 3) goto L13;
        if (r1 == 5) goto L13;
        if (r1 == 8388611) goto L13;
        if (r1 == 8388613) goto L13;
        return r2.getHeight();
    L13:
        return r2.getWidth();
    }
}
