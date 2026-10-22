package com.android.contacts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ListView;
import com.android.contacts.MultiDeleteAnimation.MultiDeleteAnimationOperator;
import com.android.contacts.PinnedHeaderList.WrapperView;
import com.android.contacts.util.CubicInterpolator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiDeleteAnimation<T extends ListView & MultiDeleteAnimationOperator> {
    private static final long MULTI_RIGHT_SLIDE_DURATION = 200;
    private HashSet<String> mDeletedHeaderSections;
    private boolean mHeaderMode;
    private boolean mResultEmpty;
    private final T mTarget;

    public interface MultiDeleteAnimationOperator {
        void startDeleteAnimations(List<Integer> r1, Animation.AnimationListener r2);
    }

    public abstract void onMultiDeleteAnimationEnd();

    public abstract void onMultiDeleteAnimationStart();

    static /* synthetic */ void access$000(MultiDeleteAnimation r0, ArrayList r1) {
        r0.onRightSlideAnimationEnd(r1);
    }

    static /* synthetic */ void access$100(MultiDeleteAnimation r0) {
        r0.end();
    }

    public MultiDeleteAnimation(T r2) {
        this.mResultEmpty = false;
        this.mTarget = r2;
    }

    public MultiDeleteAnimation(T r2, boolean r3) {
        this.mResultEmpty = false;
        this.mTarget = r2;
        this.mHeaderMode = r3;
    }

    public void start(ArrayList<Integer> r3, final ArrayList<Integer> r4) {
        ArrayList<Animator> r5 = getRightSlideAnimators(r3);
        AnimatorSet r0 = new AnimatorSet();
        r0.addListener(new AnonymousClass1(this, r4));
        r0.playTogether(r5);
        r0.setDuration(200);
        r0.setInterpolator(CubicInterpolator.OUT);
        r0.start();
    }

    public ArrayList<Animator> getRightSlideAnimators(ArrayList<Integer> r9) {
        ArrayList<Animator> r0 = new ArrayList();
        int r1 = this.mTarget.getFirstVisiblePosition();
        int r2 = this.mTarget.getLastVisiblePosition();
        Iterator<Integer> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L15;
        int r3 = r10.next().intValue();
        if (r3 < r1) goto L4;
        if (r3 > r2) goto L4;
        View r4 = this.mTarget.getChildAt(r3 - r1);
        if (r4 == null) goto L4;
        int r5 = r4.getWidth();
        if (isHeaderRetain(r4) == false) goto L14;
        r4 = ((WrapperView) r4).getItem();
    L14:
        r0.add(ObjectAnimator.ofFloat(r4, "translationX", new float[]{0.0f, r5}));
        goto L4
    L15:
        return r0;
    }

    private void onRightSlideAnimationEnd(ArrayList<Integer> r3) {
        if (this.mResultEmpty == false) goto L5;
        end();
        return;
    L5:
        this.mTarget.startDeleteAnimations(r3, new AnonymousClass2(this));
    }

    private void end() {
        int r0 = this.mTarget.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        View r2 = this.mTarget.getChildAt(r1);
        if (r2 == null) goto L10;
        if ((r2 instanceof WrapperView) == false) goto L9;
        ((WrapperView) r2).getItem().setTranslationX(0.0f);
    L9:
        r2.setTranslationX(0.0f);
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        onMultiDeleteAnimationEnd();
    }

    public MultiDeleteAnimation<T> setResultListSize(int r1) {
        if (r1 > 0) goto L4;
        boolean r2 = true;
    L5:
        this.mResultEmpty = r2;
        return this;
    L4:
        r2 = false;
        goto L5
    }

    public MultiDeleteAnimation<T> setDeletedHeaderSection(HashSet<String> r1) {
        this.mDeletedHeaderSections = r1;
        return this;
    }

    private boolean isHeaderRetain(View r2) {
        if (this.mHeaderMode == false) goto L17;
        if (r2 != null) goto L6;
        return false;
    L6:
        if ((r2 instanceof WrapperView) == false) goto L22;
        WrapperView r3 = (WrapperView) r2;
        if (r3.hasHeader() == false) goto L23;
        String r4 = (String) r3.getHeader().getTag();
        HashSet<String> r0 = this.mDeletedHeaderSections;
        if (r0 != null) goto L12;
        return true;
    L12:
        if (r0.isEmpty() == false) goto L14;
        return true;
    L14:
        if (this.mDeletedHeaderSections.contains(r4) == true) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L17:
        return false;
    }
}
