package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Visibility;
import androidx.transition.s;

/* JADX INFO: loaded from: classes3.dex */
public final class Hold extends Visibility {
    public Hold() {
    }

    @Override // androidx.transition.Visibility
    @NonNull
    public Animator onAppear(@NonNull ViewGroup r10, @NonNull View r11, @Nullable s r12, @Nullable s r13) {
        return ValueAnimator.ofFloat(new float[]{0.0f});
    }

    @Override // androidx.transition.Visibility
    @NonNull
    public Animator onDisappear(@NonNull ViewGroup r10, @NonNull View r11, @Nullable s r12, @Nullable s r13) {
        return ValueAnimator.ofFloat(new float[]{0.0f});
    }
}
