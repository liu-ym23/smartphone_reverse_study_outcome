package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes17.dex */
public class ChangeClipBounds extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = null;

    static {
        sTransitionProperties = new String[]{PROPNAME_CLIP};
    }

    public ChangeClipBounds() {
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues r100) {
        View r101 = r100.view;
        if (r101.getVisibility() != 8) goto L5;
        return;
    L5:
        Rect r102 = ViewCompat.getClipBounds(r101);
        r100.values.put(PROPNAME_CLIP, r102);
        if (r102 != null) goto L9;
        Rect r103 = new Rect(0, 0, r101.getWidth(), r101.getHeight());
        r100.values.put(PROPNAME_BOUNDS, r103);
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        captureValues(r100);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        captureValues(r100);
    }

    public ChangeClipBounds(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r100, TransitionValues r101, TransitionValues r110) {
        ObjectAnimator r102 = null;
        if (r101 == null) goto L28;
        if (r110 == null) goto L28;
        if (r101.values.containsKey(PROPNAME_CLIP) == false) goto L28;
        if (r110.values.containsKey(PROPNAME_CLIP) == false) goto L28;
        Rect r103 = (Rect) r101.values.get(PROPNAME_CLIP);
        Rect r104 = (Rect) r110.values.get(PROPNAME_CLIP);
        if (r104 != null) goto L13;
        boolean r105 = true;
    L14:
        if (r103 != null) goto L18;
        if (r104 != null) goto L18;
        return null;
    L18:
        if (r103 != null) goto L20;
        r103 = (Rect) r101.values.get(PROPNAME_BOUNDS);
    L23:
        if (r103.equals(r104) == false) goto L25;
        return null;
    L25:
        ViewCompat.setClipBounds(r110.view, r103);
        RectEvaluator r106 = new RectEvaluator(new Rect());
        r102 = ObjectAnimator.ofObject(r110.view, ViewUtils.CLIP_BOUNDS, r106, new Rect[]{r103, r104});
        if (r105 == false) goto L28;
        final View r107 = r110.view;
        r102.addListener(new AnonymousClass1(this, r107));
        goto L28
    L20:
        if (r104 != null) goto L23;
        r104 = (Rect) r110.values.get(PROPNAME_BOUNDS);
        goto L23
    L13:
        r105 = false;
    L28:
        return r102;
    }
}
