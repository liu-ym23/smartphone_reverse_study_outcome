package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes17.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed;
    private int mSide;

    public SidePropagation() {
        this.mPropagationSpeed = 3.0f;
        this.mSide = 80;
    }

    private int getMaxDistance(ViewGroup r100) {
        int r101 = this.mSide;
        if (r101 == 3) goto L13;
        if (r101 == 5) goto L13;
        if (r101 == 8388611) goto L13;
        if (r101 == 8388613) goto L13;
        return r100.getHeight();
    L13:
        return r100.getWidth();
    }

    public void setPropagationSpeed(float r100) {
        if (r100 == 0.0f) goto L7;
        this.mPropagationSpeed = r100;
        return;
    L7:
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public void setSide(int r100) {
        this.mSide = r100;
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup r110, Transition r111, TransitionValues r112, TransitionValues r210) {
        TransitionValues r100 = r112;
        if (r100 != null) goto L6;
        if (r210 != null) goto L6;
        return 0;
    L6:
        Rect r101 = r111.getEpicenter();
        if (r210 != null) goto L9;
    L12:
        int r113 = -1;
    L13:
        int r102 = getViewX(r100);
        int r103 = getViewY(r100);
        int[] r104 = new int[2];
        r110.getLocationOnScreen(r104);
        int r105 = r104[0] + Math.round(r110.getTranslationX());
        int r106 = r104[1] + Math.round(r110.getTranslationY());
        int r107 = r105 + r110.getWidth();
        int r108 = r106 + r110.getHeight();
        if (r101 == null) goto L16;
        int r109 = r101.centerX();
        int r114 = r101.centerY();
    L17:
        float r115 = distance(r110, r102, r103, r109, r114, r105, r106, r107, r108) / getMaxDistance(r110);
        long r116 = r111.getDuration();
        if (r116 >= 0) goto L21;
        r116 = 300;
    L21:
        return Math.round(((r116 * ((long) r113)) / this.mPropagationSpeed) * r115);
    L16:
        r109 = (r105 + r107) / 2;
        r114 = (r106 + r108) / 2;
        goto L17
    L9:
        if (getViewVisibility(r100) == 0) goto L12;
        r100 = r210;
        r113 = 1;
        goto L13
    }

    private int distance(View r100, int r101, int r102, int r110, int r111, int r112, int r113, int r114, int r115) {
        int r103 = this.mSide;
        boolean r104 = true;
        if (r103 != 8388611) goto L12;
        if (ViewCompat.getLayoutDirection(r100) == 1) goto L8;
        r104 = false;
    L8:
        if (r104 == false) goto L10;
    L9:
        r103 = 5;
    L19:
        if (r103 == 3) goto L30;
        if (r103 == 5) goto L33;
        if (r103 == 48) goto L32;
        if (r103 == 80) goto L31;
        return 0;
    L31:
        return (r102 - r113) + Math.abs(r110 - r101);
    L32:
        return (r115 - r102) + Math.abs(r110 - r101);
    L33:
        return (r101 - r112) + Math.abs(r111 - r102);
    L30:
        return (r114 - r101) + Math.abs(r111 - r102);
    L10:
        r103 = 3;
        goto L19
    L12:
        if (r103 != 8388613) goto L19;
        if (ViewCompat.getLayoutDirection(r100) == 1) goto L17;
        r104 = false;
    L17:
        if (r104 == false) goto L9;
        goto L9
    }
}
