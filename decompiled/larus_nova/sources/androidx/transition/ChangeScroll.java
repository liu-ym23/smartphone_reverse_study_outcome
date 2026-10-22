package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
public class ChangeScroll extends Transition {
    private static final String[] PROPERTIES = null;
    private static final String PROPNAME_SCROLL_X = "android:changeScroll:x";
    private static final String PROPNAME_SCROLL_Y = "android:changeScroll:y";

    static {
        PROPERTIES = new String[]{PROPNAME_SCROLL_X, PROPNAME_SCROLL_Y};
    }

    public ChangeScroll() {
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return PROPERTIES;
    }

    private void captureValues(TransitionValues r100) {
        r100.values.put(PROPNAME_SCROLL_X, Integer.valueOf(r100.view.getScrollX()));
        r100.values.put(PROPNAME_SCROLL_Y, Integer.valueOf(r100.view.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        captureValues(r100);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        captureValues(r100);
    }

    public ChangeScroll(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r100, TransitionValues r101, TransitionValues r110) {
        ObjectAnimator r102 = null;
        if (r101 == null) goto L14;
        if (r110 == null) goto L15;
        View r103 = r110.view;
        int r104 = ((Integer) r101.values.get(PROPNAME_SCROLL_X)).intValue();
        int r105 = ((Integer) r110.values.get(PROPNAME_SCROLL_X)).intValue();
        int r106 = ((Integer) r101.values.get(PROPNAME_SCROLL_Y)).intValue();
        int r111 = ((Integer) r110.values.get(PROPNAME_SCROLL_Y)).intValue();
        if (r104 == r105) goto L9;
        r103.setScrollX(r104);
        ObjectAnimator r107 = ObjectAnimator.ofInt(r103, "scrollX", new int[]{r104, r105});
    L10:
        if (r106 == r111) goto L13;
        r103.setScrollY(r106);
        r102 = ObjectAnimator.ofInt(r103, "scrollY", new int[]{r106, r111});
    L13:
        return TransitionUtils.mergeAnimators(r107, r102);
    L9:
        r107 = null;
        goto L10
    L15:
        return null;
    L14:
        return null;
    }
}
