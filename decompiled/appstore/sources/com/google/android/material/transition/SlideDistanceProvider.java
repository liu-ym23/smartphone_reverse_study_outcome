package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;

    @Px
    private int slideDistance;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int r10) {
        this.slideDistance = -1;
        this.slideEdge = r10;
    }

    private static Animator createTranslationAppearAnimator(View r10, View r11, int r12, @Px int r13) {
        float r14 = r11.getTranslationX();
        float r15 = r11.getTranslationY();
        if (r12 == 3) goto L35;
        if (r12 == 5) goto L33;
        if (r12 == 48) goto L31;
        if (r12 == 80) goto L29;
        if (r12 == 8388611) goto L23;
        if (r12 != 8388613) goto L21;
        if (isRtl(r10) == false) goto L17;
        float r16 = r14 - r13;
    L19:
        return createTranslationXAnimator(r11, r16, r14, r14);
    L17:
        r16 = r13 + r14;
        goto L19
    L21:
        throw new IllegalArgumentException("Invalid slide direction: " + r12);
    L23:
        if (isRtl(r10) == false) goto L25;
        float r17 = r13 + r14;
    L27:
        return createTranslationXAnimator(r11, r17, r14, r14);
    L25:
        r17 = r14 - r13;
        goto L27
    L29:
        return createTranslationYAnimator(r11, r13 + r15, r15, r15);
    L31:
        return createTranslationYAnimator(r11, r15 - r13, r15, r15);
    L33:
        return createTranslationXAnimator(r11, r14 - r13, r14, r14);
    L35:
        return createTranslationXAnimator(r11, r13 + r14, r14, r14);
    }

    private static Animator createTranslationDisappearAnimator(View r10, View r11, int r12, @Px int r13) {
        float r14 = r11.getTranslationX();
        float r15 = r11.getTranslationY();
        if (r12 == 3) goto L35;
        if (r12 == 5) goto L33;
        if (r12 == 48) goto L31;
        if (r12 == 80) goto L29;
        if (r12 == 8388611) goto L23;
        if (r12 != 8388613) goto L21;
        if (isRtl(r10) == false) goto L17;
        float r16 = r13 + r14;
    L19:
        return createTranslationXAnimator(r11, r14, r16, r14);
    L17:
        r16 = r14 - r13;
        goto L19
    L21:
        throw new IllegalArgumentException("Invalid slide direction: " + r12);
    L23:
        if (isRtl(r10) == false) goto L25;
        float r17 = r14 - r13;
    L27:
        return createTranslationXAnimator(r11, r14, r17, r14);
    L25:
        r17 = r13 + r14;
        goto L27
    L29:
        return createTranslationYAnimator(r11, r15, r15 - r13, r15);
    L31:
        return createTranslationYAnimator(r11, r15, r13 + r15, r15);
    L33:
        return createTranslationXAnimator(r11, r14, r13 + r14, r14);
    L35:
        return createTranslationXAnimator(r11, r14, r14 - r13, r14);
    }

    private static Animator createTranslationXAnimator(final View r10, float r11, float r12, final float r13) {
        ObjectAnimator r14 = ObjectAnimator.ofPropertyValuesHolder(r10, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r11, r12})});
        r14.addListener(new AnonymousClass1(r10, r13));
        return r14;
    }

    private static Animator createTranslationYAnimator(final View r10, float r11, float r12, final float r13) {
        ObjectAnimator r14 = ObjectAnimator.ofPropertyValuesHolder(r10, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r11, r12})});
        r14.addListener(new AnonymousClass2(r10, r13));
        return r14;
    }

    private int getSlideDistanceOrDefault(Context r10) {
        int r11 = this.slideDistance;
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        return r10.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View r10) {
        if (ViewCompat.A(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r10, @NonNull View r11) {
        return createTranslationAppearAnimator(r10, r11, this.slideEdge, getSlideDistanceOrDefault(r11.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r10, @NonNull View r11) {
        return createTranslationDisappearAnimator(r10, r11, this.slideEdge, getSlideDistanceOrDefault(r11.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int r10) {
        if (r10 < 0) goto L6;
        this.slideDistance = r10;
        return;
    L6:
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int r10) {
        this.slideEdge = r10;
    }
}
