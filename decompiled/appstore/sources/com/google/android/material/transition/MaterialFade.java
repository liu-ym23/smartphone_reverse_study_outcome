package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.s;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialFade extends MaterialVisibility<FadeProvider> {
    private static final float DEFAULT_FADE_END_THRESHOLD_ENTER = 0.3f;
    private static final float DEFAULT_START_SCALE = 0.8f;

    @AttrRes
    private static final int DEFAULT_THEMED_EASING_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_INCOMING_DURATION_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_OUTGOING_DURATION_ATTR = 0;

    static {
        DEFAULT_THEMED_INCOMING_DURATION_ATTR = R.attr.motionDurationShort2;
        DEFAULT_THEMED_OUTGOING_DURATION_ATTR = R.attr.motionDurationShort1;
        DEFAULT_THEMED_EASING_ATTR = R.attr.motionEasingLinear;
    }

    public MaterialFade() {
        super(createPrimaryAnimatorProvider(), createSecondaryAnimatorProvider());
    }

    private static FadeProvider createPrimaryAnimatorProvider() {
        FadeProvider r10 = new FadeProvider();
        r10.setIncomingEndThreshold(0.3f);
        return r10;
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        ScaleProvider r10 = new ScaleProvider();
        r10.setScaleOnDisappear(false);
        r10.setIncomingStartScale(DEFAULT_START_SCALE);
        return r10;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r10) {
        super.addAdditionalAnimatorProvider(r10);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @NonNull
    public TimeInterpolator getDefaultEasingInterpolator(boolean r10) {
        return AnimationUtils.LINEAR_INTERPOLATOR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @AttrRes
    public int getDurationThemeAttrResId(boolean r10) {
        if (r10 == false) goto L5;
        return DEFAULT_THEMED_INCOMING_DURATION_ATTR;
    L5:
        return DEFAULT_THEMED_OUTGOING_DURATION_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @AttrRes
    public int getEasingThemeAttrResId(boolean r10) {
        return DEFAULT_THEMED_EASING_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup r10, View r11, s r12, s r13) {
        return super.onAppear(r10, r11, r12, r13);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup r10, View r11, s r12, s r13) {
        return super.onDisappear(r10, r11, r12, r13);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r10) {
        return super.removeAdditionalAnimatorProvider(r10);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider r10) {
        super.setSecondaryAnimatorProvider(r10);
    }
}
