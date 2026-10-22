package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StateListAnimator {
    private final Animator.AnimatorListener animationListener;

    @Nullable
    private Tuple lastMatch;

    @Nullable
    ValueAnimator runningAnimator;
    private final ArrayList<Tuple> tuples;

    public static class Tuple {
        final ValueAnimator animator;
        final int[] specs;

        public Tuple(int[] r10, ValueAnimator r11) {
            this.specs = r10;
            this.animator = r11;
        }
    }

    public StateListAnimator() {
        this.tuples = new ArrayList();
        this.lastMatch = null;
        this.runningAnimator = null;
        this.animationListener = new AnonymousClass1(this);
    }

    private void cancel() {
        ValueAnimator r10 = this.runningAnimator;
        if (r10 == null) goto L6;
        r10.cancel();
        this.runningAnimator = null;
        return;
    }

    private void start(@NonNull Tuple r10) {
        ValueAnimator r11 = r10.animator;
        this.runningAnimator = r11;
        r11.start();
    }

    public void addState(int[] r10, ValueAnimator r11) {
        Tuple r12 = new Tuple(r10, r11);
        r11.addListener(this.animationListener);
        this.tuples.add(r12);
    }

    public void jumpToCurrentState() {
        ValueAnimator r10 = this.runningAnimator;
        if (r10 == null) goto L6;
        r10.end();
        this.runningAnimator = null;
        return;
    }

    public void setState(int[] r10) {
        int r11 = this.tuples.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        Tuple r13 = this.tuples.get(r12);
        if (StateSet.stateSetMatches(r13.specs, r10) == true) goto L9;
        r12 = r12 + 1;
    L9:
        Tuple r14 = this.lastMatch;
        if (r13 != r14) goto L12;
        return;
    L12:
        if (r14 == null) goto L14;
        cancel();
    L14:
        this.lastMatch = r13;
        if (r13 == null) goto L20;
        start(r13);
        return;
    L20:
        return;
    L8:
        r13 = null;
        goto L9
    }
}
