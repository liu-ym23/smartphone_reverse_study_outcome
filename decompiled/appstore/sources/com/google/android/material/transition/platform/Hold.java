package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public final class Hold extends Visibility {
    public Hold() {
    }

    @Override // android.transition.Visibility
    @NonNull
    public Animator onAppear(@NonNull ViewGroup r10, @NonNull View r11, @Nullable TransitionValues r12, @Nullable TransitionValues r13) {
        return ValueAnimator.ofFloat(new float[]{0.0f});
    }

    @Override // android.transition.Visibility
    @NonNull
    public Animator onDisappear(@NonNull ViewGroup r10, @NonNull View r11, @Nullable TransitionValues r12, @Nullable TransitionValues r13) {
        return ValueAnimator.ofFloat(new float[]{0.0f});
    }
}
