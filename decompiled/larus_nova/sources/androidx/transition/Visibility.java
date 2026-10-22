package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = null;
    private int mMode;

    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {
        boolean mCanceled;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r100) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r100) {
        }

        private void hideViewWhenNotCanceled() {
            if (this.mCanceled == true) goto L7;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            ViewGroup r100 = this.mParent;
            if (r100 == null) goto L7;
            r100.invalidate();
        L7:
            suppressLayout(false);
        }

        private void suppressLayout(boolean r100) {
            if (this.mSuppressLayout == true) goto L5;
            return;
        L5:
            if (this.mLayoutSuppressed == r100) goto L11;
            ViewGroup r101 = this.mParent;
            if (r101 == null) goto L12;
            this.mLayoutSuppressed = r100;
            ViewGroupUtils.suppressLayout(r101, r100);
            return;
        L12:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            hideViewWhenNotCanceled();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator r100) {
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator r100) {
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, 0);
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r100) {
            hideViewWhenNotCanceled();
            r100.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r100) {
            suppressLayout(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r100) {
            suppressLayout(true);
        }

        public DisappearListener(View r100, int r101, boolean r102) {
            this.mCanceled = false;
            this.mView = r100;
            this.mFinalVisibility = r101;
            this.mParent = (ViewGroup) r100.getParent();
            this.mSuppressLayout = r102;
            suppressLayout(true);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static class VisibilityInfo {
        ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;

        public VisibilityInfo() {
        }
    }

    public Animator onAppear(ViewGroup r100, View r101, TransitionValues r102, TransitionValues r103) {
        return null;
    }

    public Animator onDisappear(ViewGroup r100, View r101, TransitionValues r102, TransitionValues r103) {
        return null;
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_VISIBILITY, PROPNAME_PARENT};
    }

    public Visibility() {
        this.mMode = 3;
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues r100) {
        int r101 = r100.view.getVisibility();
        r100.values.put(PROPNAME_VISIBILITY, Integer.valueOf(r101));
        r100.values.put(PROPNAME_PARENT, r100.view.getParent());
        int[] r102 = new int[2];
        r100.view.getLocationOnScreen(r102);
        r100.values.put(PROPNAME_SCREEN_LOCATION, r102);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        captureValues(r100);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        captureValues(r100);
    }

    public boolean isVisible(TransitionValues r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = ((Integer) r100.values.get(PROPNAME_VISIBILITY)).intValue();
        View r102 = (View) r100.values.get(PROPNAME_PARENT);
        if (r101 != 0) goto L10;
        if (r102 == null) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public void setMode(int r100) {
        if ((r100 & (-4)) != 0) goto L7;
        this.mMode = r100;
        return;
    L7:
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public Visibility(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mMode = 3;
        TypedArray r102 = r100.obtainStyledAttributes(r101, Styleable.VISIBILITY_TRANSITION);
        int r103 = TypedArrayUtils.getNamedInt(r102, (XmlResourceParser) r101, "transitionVisibilityMode", 0, 0);
        r102.recycle();
        if (r103 == 0) goto L6;
        setMode(r103);
        return;
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues r100, TransitionValues r101) {
        VisibilityInfo r102 = new VisibilityInfo();
        r102.mVisibilityChange = false;
        r102.mFadeIn = false;
        if (r100 != null) goto L5;
    L7:
        r102.mStartVisibility = -1;
        r102.mStartParent = null;
    L8:
        if (r101 != null) goto L10;
    L12:
        r102.mEndVisibility = -1;
        r102.mEndParent = null;
    L14:
        if (r100 == null) goto L32;
        if (r101 == null) goto L32;
        int r103 = r102.mStartVisibility;
        int r104 = r102.mEndVisibility;
        if (r103 == r104) goto L19;
    L21:
        if (r103 == r104) goto L27;
        if (r103 != 0) goto L24;
        r102.mFadeIn = false;
        r102.mVisibilityChange = true;
    L40:
        return r102;
    L24:
        if (r104 != 0) goto L40;
        r102.mFadeIn = true;
        r102.mVisibilityChange = true;
        goto L40
    L27:
        if (r102.mEndParent != null) goto L30;
        r102.mFadeIn = false;
        r102.mVisibilityChange = true;
        goto L40
    L30:
        if (r102.mStartParent != null) goto L40;
        r102.mFadeIn = true;
        r102.mVisibilityChange = true;
        goto L40
    L19:
        if (r102.mStartParent != r102.mEndParent) goto L21;
        return r102;
    L32:
        if (r100 == null) goto L34;
    L36:
        if (r101 != null) goto L40;
        if (r102.mStartVisibility != 0) goto L40;
        r102.mFadeIn = false;
        r102.mVisibilityChange = true;
        goto L40
    L34:
        if (r102.mEndVisibility != 0) goto L36;
        r102.mFadeIn = true;
        r102.mVisibilityChange = true;
        goto L40
    L10:
        if (r101.values.containsKey(PROPNAME_VISIBILITY) == false) goto L12;
        r102.mEndVisibility = ((Integer) r101.values.get(PROPNAME_VISIBILITY)).intValue();
        r102.mEndParent = (ViewGroup) r101.values.get(PROPNAME_PARENT);
        goto L14
    L5:
        if (r100.values.containsKey(PROPNAME_VISIBILITY) == false) goto L7;
        r102.mStartVisibility = ((Integer) r100.values.get(PROPNAME_VISIBILITY)).intValue();
        r102.mStartParent = (ViewGroup) r100.values.get(PROPNAME_PARENT);
        goto L8
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues r100, TransitionValues r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        if (r101.values.containsKey(PROPNAME_VISIBILITY) == r100.values.containsKey(PROPNAME_VISIBILITY)) goto L11;
        return false;
    L11:
        VisibilityInfo r102 = getVisibilityChangeInfo(r100, r101);
        if (r102.mVisibilityChange == true) goto L14;
        return false;
    L14:
        if (r102.mStartVisibility != 0) goto L16;
    L17:
        return true;
    L16:
        if (r102.mEndVisibility == 0) goto L17;
        return false;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r100, TransitionValues r110, TransitionValues r111) {
        VisibilityInfo r101 = getVisibilityChangeInfo(r110, r111);
        if (r101.mVisibilityChange == true) goto L5;
        return null;
    L5:
        if (r101.mStartParent != null) goto L9;
        if (r101.mEndParent != null) goto L9;
        return null;
    L9:
        if (r101.mFadeIn == false) goto L13;
        return onAppear(r100, r110, r101.mStartVisibility, r111, r101.mEndVisibility);
    L13:
        return onDisappear(r100, r110, r101.mStartVisibility, r111, r101.mEndVisibility);
    }

    public Animator onAppear(ViewGroup r100, TransitionValues r101, int r102, TransitionValues r103, int r104) {
        if ((this.mMode & 1) != 1) goto L12;
        if (r103 == null) goto L12;
        if (r101 != null) goto L11;
        View r105 = (View) r103.view.getParent();
        if (getVisibilityChangeInfo(getMatchedTransitionValues(r105, false), getTransitionValues(r105, false)).mVisibilityChange == false) goto L11;
        return null;
    L11:
        return onAppear(r100, r103.view, r101, r103);
    L12:
        return null;
    }

    public Animator onDisappear(ViewGroup r100, TransitionValues r101, int r102, TransitionValues r110, int r111) {
        if ((this.mMode & 2) == 2) goto L5;
        return null;
    L5:
        if (r101 == null) goto L7;
        final View r103 = r101.view;
    L8:
        if (r110 == null) goto L10;
        View r104 = r110.view;
    L12:
        if (r104 != null) goto L14;
    L25:
        if (r104 == null) goto L28;
        r103 = r104;
    L27:
        r104 = null;
    L49:
        if (r103 == null) goto L56;
        if (r101 == null) goto L56;
        int[] r112 = (int[]) r101.values.get(PROPNAME_SCREEN_LOCATION);
        int r105 = r112[0];
        int r113 = r112[1];
        int[] r106 = new int[2];
        r100.getLocationOnScreen(r106);
        r103.offsetLeftAndRight((r105 - r106[0]) - r103.getLeft());
        r103.offsetTopAndBottom((r113 - r106[1]) - r103.getTop());
        final ViewGroupOverlayImpl r114 = ViewGroupUtils.getOverlay(r100);
        r114.add(r103);
        Animator r107 = onDisappear(r100, r103, r101, r110);
        if (r107 != null) goto L54;
        r114.remove(r103);
    L55:
        return r107;
    L54:
        r107.addListener(new AnonymousClass1(this, r114, r103));
    L56:
        if (r104 == null) goto L62;
        int r108 = r104.getVisibility();
        ViewUtils.setTransitionVisibility(r104, 0);
        Animator r109 = onDisappear(r100, r104, r101, r110);
        if (r109 == null) goto L60;
        DisappearListener r115 = new DisappearListener(r104, r111, true);
        r109.addListener(r115);
        AnimatorUtils.addPauseListener(r109, r115);
        addListener(r115);
    L61:
        return r109;
    L60:
        ViewUtils.setTransitionVisibility(r104, r108);
        goto L61
    L62:
        return null;
    L28:
        if (r103 != null) goto L30;
    L47:
        r103 = null;
        r104 = null;
        goto L49
    L30:
        if (r103.getParent() == null) goto L27;
        if ((r103.getParent() instanceof View) == false) goto L47;
        View r116 = (View) r103.getParent();
        if (getVisibilityChangeInfo(getTransitionValues(r116, true), getMatchedTransitionValues(r116, true)).mVisibilityChange == true) goto L38;
        r103 = TransitionUtils.copyViewImage(r100, r103, r116);
        goto L27
    L38:
        if (r116.getParent() != null) goto L46;
        int r117 = r116.getId();
        if (r117 == (-1)) goto L46;
        if (r100.findViewById(r117) == null) goto L46;
        if (this.mCanRemoveViews == true) goto L27;
    L46:
        r103 = null;
        goto L27
    L14:
        if (r104.getParent() == null) goto L25;
        if (r111 == 4) goto L20;
        if (r103 == r104) goto L20;
        if (this.mCanRemoveViews == true) goto L27;
        r103 = TransitionUtils.copyViewImage(r100, r103, (View) r103.getParent());
    L20:
        r103 = null;
        goto L49
    L10:
        r104 = null;
        goto L12
    L7:
        r103 = null;
        goto L8
    }
}
