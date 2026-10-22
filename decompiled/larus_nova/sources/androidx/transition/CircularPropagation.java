package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed;

    public CircularPropagation() {
        this.mPropagationSpeed = 3.0f;
    }

    public void setPropagationSpeed(float r100) {
        if (r100 == 0.0f) goto L7;
        this.mPropagationSpeed = r100;
        return;
    L7:
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    private static float distance(float r100, float r101, float r102, float r103) {
        float r104 = r102 - r100;
        float r105 = r103 - r101;
        return (float) Math.sqrt((r104 * r104) + (r105 * r105));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup r100, Transition r110, TransitionValues r111, TransitionValues r112) {
        if (r111 != null) goto L7;
        if (r112 != null) goto L7;
        return 0;
    L7:
        if (r112 != null) goto L9;
    L12:
        int r113 = -1;
    L13:
        int r101 = getViewX(r111);
        int r114 = getViewY(r111);
        Rect r102 = r110.getEpicenter();
        if (r102 == null) goto L16;
        int r103 = r102.centerX();
        int r104 = r102.centerY();
    L17:
        float r115 = distance(r101, r114, r103, r104) / distance(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
        long r105 = r110.getDuration();
        if (r105 >= 0) goto L21;
        r105 = 300;
    L21:
        return Math.round(((r105 * ((long) r113)) / this.mPropagationSpeed) * r115);
    L16:
        int[] r106 = new int[2];
        r100.getLocationOnScreen(r106);
        int r107 = Math.round((r106[0] + (r100.getWidth() / 2)) + r100.getTranslationX());
        r104 = Math.round((r106[1] + (r100.getHeight() / 2)) + r100.getTranslationY());
        r103 = r107;
        goto L17
    L9:
        if (getViewVisibility(r111) == 0) goto L12;
        r111 = r112;
        r113 = 1;
        goto L13
    }
}
