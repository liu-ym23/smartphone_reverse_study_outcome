package com.bytedanceos.ui.transition;

import android.transition.SidePropagation;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends SidePropagation {
    public a() {
    }

    @Override // android.transition.SidePropagation, android.transition.TransitionPropagation
    public long getStartDelay(ViewGroup r10, Transition r11, TransitionValues r12, TransitionValues r13) {
        return 0;
    }
}
