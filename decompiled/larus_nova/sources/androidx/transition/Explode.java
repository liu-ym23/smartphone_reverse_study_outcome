package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
public class Explode extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final TimeInterpolator sAccelerate = null;
    private static final TimeInterpolator sDecelerate = null;
    private int[] mTempLoc;

    static {
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
    }

    public Explode() {
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    private void captureValues(TransitionValues r100) {
        View r101 = r100.view;
        r101.getLocationOnScreen(this.mTempLoc);
        int[] r102 = this.mTempLoc;
        int r103 = r102[0];
        int r104 = r102[1];
        int r105 = r101.getWidth() + r103;
        int r106 = r101.getHeight() + r104;
        r100.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(r103, r104, r105, r106));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        super.captureEndValues(r100);
        captureValues(r100);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        super.captureStartValues(r100);
        captureValues(r100);
    }

    public Explode(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float r100, float r101) {
        return (float) Math.sqrt((r100 * r100) + (r101 * r101));
    }

    private static float calculateMaxDistance(View r100, int r101, int r102) {
        return calculateDistance(Math.max(r101, r100.getWidth() - r101), Math.max(r102, r100.getHeight() - r102));
    }

    private void calculateOut(View r110, Rect r111, int[] r112) {
        r110.getLocationOnScreen(this.mTempLoc);
        int[] r100 = this.mTempLoc;
        int r101 = r100[0];
        int r102 = r100[1];
        Rect r103 = getEpicenter();
        if (r103 != null) goto L5;
        int r104 = ((r110.getWidth() / 2) + r101) + Math.round(r110.getTranslationX());
        int r105 = ((r110.getHeight() / 2) + r102) + Math.round(r110.getTranslationY());
    L6:
        float r106 = r111.centerX() - r104;
        float r107 = r111.centerY() - r105;
        if (r106 == 0.0f) goto L9;
    L11:
        float r113 = calculateDistance(r106, r107);
        float r108 = calculateMaxDistance(r110, r104 - r101, r105 - r102);
        r112[0] = Math.round((r106 / r113) * r108);
        r112[1] = Math.round(r108 * (r107 / r113));
        return;
    L9:
        if (r107 != 0.0f) goto L11;
        r106 = ((float) (Math.random() * 2.0d)) - 1.0f;
        r107 = ((float) (Math.random() * 2.0d)) - 1.0f;
        goto L11
    L5:
        int r109 = r103.centerX();
        r105 = r103.centerY();
        r104 = r109;
        goto L6
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r110, View r111, TransitionValues r112, TransitionValues r113) {
        if (r113 != null) goto L5;
        return null;
    L5:
        Rect r114 = (Rect) r113.values.get(PROPNAME_SCREEN_BOUNDS);
        float r100 = r111.getTranslationX();
        float r101 = r111.getTranslationY();
        calculateOut(r110, r114, this.mTempLoc);
        int[] r115 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(r111, r113, r114.left, r114.top, r100 + r115[0], r101 + r115[1], r100, r101, sDecelerate);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r110, View r111, TransitionValues r112, TransitionValues r113) {
        if (r112 != null) goto L5;
        return null;
    L5:
        Rect r114 = (Rect) r112.values.get(PROPNAME_SCREEN_BOUNDS);
        int r100 = r114.left;
        int r101 = r114.top;
        float r102 = r111.getTranslationX();
        float r103 = r111.getTranslationY();
        int[] r104 = (int[]) r112.view.getTag(R.id.transition_position);
        if (r104 == null) goto L8;
        int r105 = r104[0];
        float r106 = (r105 - r114.left) + r102;
        int r107 = r104[1];
        float r108 = (r107 - r114.top) + r103;
        r114.offsetTo(r105, r107);
    L9:
        calculateOut(r110, r114, this.mTempLoc);
        int[] r115 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(r111, r112, r100, r101, r102, r103, r106 + r115[0], r108 + r115[1], sAccelerate);
    L8:
        r106 = r102;
        r108 = r103;
        goto L9
    }
}
