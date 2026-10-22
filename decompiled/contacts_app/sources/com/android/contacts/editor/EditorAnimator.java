package com.android.contacts.editor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.android.contacts.util.SchedulingUtils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EditorAnimator {
    private static EditorAnimator sInstance;
    private final int BOTTOM;
    private final int MID;
    private final int SINGLE;
    private final int TOP;
    private AnimatorRunner mRunner;

    static class AnimatorRunner extends AnimatorListenerAdapter {
        private Animator mLastAnimator;

        AnimatorRunner() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r1) {
            this.mLastAnimator = null;
        }

        public void run(List<Animator> r2) {
            run(r2, null);
        }

        public void run(List<Animator> r2, Animator.AnimatorListener r3) {
            AnimatorSet r0 = new AnimatorSet();
            r0.playTogether(r2);
            if (r3 == null) goto L5;
            r0.addListener(r3);
        L5:
            r0.addListener(this);
            this.mLastAnimator = r0;
            r0.start();
        }

        public void endOldAnimation() {
            Animator r0 = this.mLastAnimator;
            if (r0 == null) goto L6;
            r0.end();
            return;
        }
    }

    static /* synthetic */ List access$000(View r0) {
        return getViewsBelowOf(r0);
    }

    static /* synthetic */ void access$100(List r0, List r1, float r2, float r3, int r4, int r5) {
        translateViews(r0, r1, r2, r3, r4, r5);
    }

    static /* synthetic */ AnimatorRunner access$200(EditorAnimator r0) {
        return r0.mRunner;
    }

    static {
        sInstance = new EditorAnimator();
    }

    public static EditorAnimator getInstance() {
        return sInstance;
    }

    private EditorAnimator() {
        this.mRunner = new AnimatorRunner();
        this.SINGLE = 0;
        this.TOP = 1;
        this.MID = 2;
        this.BOTTOM = 3;
    }

    public void removeEditorView(View r10, final ViewGroup r11) {
        this.mRunner.endOldAnimation();
        int r0 = r10.getHeight();
        final List<View> r7 = getViewsBelowOf(r10);
        ArrayList r8 = Lists.newArrayList();
        ObjectAnimator r12 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{1.0f, 0.0f});
        r12.setDuration(200);
        r8.add(r12);
        translateViews(r8, r7, 0.0f, -r0, 100, 200);
        this.mRunner.run(r8, new AnonymousClass1(this, r7, r11));
    }

    public void expandOrganization(final View r2, final ViewGroup r3) {
        this.mRunner.endOldAnimation();
        r3.setVisibility(0);
        r3.setAlpha(0.0f);
        r3.requestFocus();
        SchedulingUtils.doAfterLayout(r2, new AnonymousClass2(this, r3, r2));
    }

    public void updateChildsBackground(ViewGroup r5) {
        this.mRunner.endOldAnimation();
        if (r5 != null) goto L5;
        return;
    L5:
        int r4 = r5.getChildCount();
        int r1 = 0;
    L6:
        if (r1 >= r4) goto L11;
        View r2 = r5.getChildAt(r1);
        if (r2.getVisibility() == 0) goto L10;
        r2.setVisibility(0);
    L10:
        r1 = r1 + 1;
        goto L6
    }

    public void showAddFieldFooter(View r1, ViewGroup r2) {
        this.mRunner.endOldAnimation();
        if (r1.getVisibility() != 0) goto L5;
        return;
    L5:
        r1.setVisibility(0);
    }

    public void hideAddFieldFooter(final View r10) {
        this.mRunner.endOldAnimation();
        if (r10.getVisibility() != 8) goto L5;
        return;
    L5:
        int r0 = r10.getHeight();
        final List<View> r7 = getViewsBelowOf(r10);
        ArrayList r8 = Lists.newArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{1.0f, 0.0f});
        r1.setDuration(200);
        r8.add(r1);
        translateViews(r8, r7, 0.0f, -r0, 100, 200);
        this.mRunner.run(r8, new AnonymousClass3(this, r7, r10));
    }

    private static void translateViews(List<Animator> r6, List<View> r7, float r8, float r9, int r10, int r11) {
        int r1 = 0;
    L4:
        if (r1 >= r7.size()) goto L6;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r7.get(r1), View.TRANSLATION_Y, new float[]{r8, r9});
        r2.setStartDelay(r10);
        r2.setDuration(r11);
        r6.add(r2);
        r1 = r1 + 1;
        goto L4
    }

    private static List<View> getViewsBelowOf(View r2) {
        ViewGroup r0 = (ViewGroup) r2.getParent();
        ArrayList r1 = Lists.newArrayList();
        if (r0 == null) goto L5;
        getViewsBelowOfRecursive(r1, r0, r0.indexOfChild(r2) + 1);
    L5:
        return r1;
    }

    private static void getViewsBelowOfRecursive(List<View> r2, ViewGroup r3, int r4) {
    L3:
        if (r4 >= r3.getChildCount()) goto L5;
        r2.add(r3.getChildAt(r4));
        r4 = r4 + 1;
        goto L3
    L5:
        ViewParent r5 = r3.getParent();
        if ((r5 instanceof LinearLayout) == false) goto L12;
        LinearLayout r6 = (LinearLayout) r5;
        if (r6.getOrientation() != 1) goto L13;
        getViewsBelowOfRecursive(r2, r6, r6.indexOfChild(r3) + 1);
        return;
    L13:
        return;
    }
}
