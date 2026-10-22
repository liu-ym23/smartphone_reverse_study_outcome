package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.s;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {

    @AttrRes
    private static final int DEFAULT_THEMED_DURATION_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_EASING_ATTR = 0;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    private final int axis;
    private final boolean forward;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Axis {
    }

    static {
        DEFAULT_THEMED_DURATION_ATTR = R.attr.motionDurationLong1;
        DEFAULT_THEMED_EASING_ATTR = R.attr.motionEasingStandard;
    }

    public MaterialSharedAxis(int r10, boolean r11) {
        super(createPrimaryAnimatorProvider(r10, r11), createSecondaryAnimatorProvider());
        this.axis = r10;
        this.forward = r11;
    }

    private static VisibilityAnimatorProvider createPrimaryAnimatorProvider(int r10, boolean r11) {
        if (r10 == 0) goto L18;
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L10;
        return new ScaleProvider(r11);
    L10:
        throw new IllegalArgumentException("Invalid axis: " + r10);
    L12:
        if (r11 == false) goto L14;
        int r12 = 80;
    L16:
        return new SlideDistanceProvider(r12);
    L14:
        r12 = 48;
        goto L16
    L18:
        if (r11 == false) goto L20;
        int r13 = 8388613;
    L22:
        return new SlideDistanceProvider(r13);
    L20:
        r13 = 8388611;
        goto L22
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        return new FadeThroughProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r10) {
        super.addAdditionalAnimatorProvider(r10);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public int getAxis() {
        return this.axis;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @AttrRes
    public int getDurationThemeAttrResId(boolean r10) {
        return DEFAULT_THEMED_DURATION_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @AttrRes
    public int getEasingThemeAttrResId(boolean r10) {
        return DEFAULT_THEMED_EASING_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.forward;
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
