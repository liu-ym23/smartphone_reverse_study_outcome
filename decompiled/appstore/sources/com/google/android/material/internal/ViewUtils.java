package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ViewUtils {

    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View r10, WindowInsetsCompat r11, RelativePadding r12);
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int r10, int r11, int r12, int r13) {
            this.start = r10;
            this.top = r11;
            this.end = r12;
            this.bottom = r13;
        }

        public void applyToView(View r10) {
            ViewCompat.D0(r10, this.start, this.top, this.end, this.bottom);
        }

        public RelativePadding(@NonNull RelativePadding r10) {
            this.start = r10.start;
            this.top = r10.top;
            this.end = r10.end;
            this.bottom = r10.bottom;
        }
    }

    private ViewUtils() {
    }

    public static void addOnGlobalLayoutListener(@Nullable View r10, @NonNull ViewTreeObserver.OnGlobalLayoutListener r11) {
        if (r10 == null) goto L5;
        r10.getViewTreeObserver().addOnGlobalLayoutListener(r11);
        return;
    }

    public static void doOnApplyWindowInsets(@NonNull View r10, @Nullable AttributeSet r11, int r12, int r13) {
        doOnApplyWindowInsets(r10, r11, r12, r13, null);
    }

    public static float dpToPx(@NonNull Context r10, @Dimension(unit = 0) int r11) {
        return TypedValue.applyDimension(1, r11, r10.getResources().getDisplayMetrics());
    }

    @Nullable
    public static ViewGroup getContentView(@Nullable View r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        View r11 = r10.getRootView();
        ViewGroup r12 = (ViewGroup) r11.findViewById(R.id.content);
        if (r12 == null) goto L8;
        return r12;
    L8:
        if (r11 != r10) goto L10;
    L13:
        return null;
    L10:
        if ((r11 instanceof ViewGroup) == false) goto L13;
        return (ViewGroup) r11;
    }

    @Nullable
    public static ViewOverlayImpl getContentViewOverlay(@NonNull View r10) {
        return getOverlay(getContentView(r10));
    }

    @Nullable
    public static ViewOverlayImpl getOverlay(@Nullable View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new ViewOverlayApi18(r10);
    }

    public static float getParentAbsoluteElevation(@NonNull View r10) {
        ViewParent r11 = r10.getParent();
        float r12 = 0.0f;
    L4:
        if ((r11 instanceof View) == false) goto L6;
        r12 = r12 + ViewCompat.v((View) r11);
        r11 = r11.getParent();
        goto L4
    L6:
        return r12;
    }

    public static boolean isLayoutRtl(View r10) {
        if (ViewCompat.A(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static PorterDuff.Mode parseTintMode(int r10, PorterDuff.Mode r11) {
        if (r10 == 3) goto L21;
        if (r10 == 5) goto L19;
        if (r10 == 9) goto L17;
        switch(r10) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r11;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void removeOnGlobalLayoutListener(@Nullable View r10, @NonNull ViewTreeObserver.OnGlobalLayoutListener r11) {
        if (r10 == null) goto L5;
        removeOnGlobalLayoutListener(r10.getViewTreeObserver(), r11);
        return;
    }

    public static void requestApplyInsetsWhenAttached(@NonNull View r10) {
        if (ViewCompat.S(r10) == false) goto L5;
        ViewCompat.m0(r10);
        return;
    L5:
        r10.addOnAttachStateChangeListener(new AnonymousClass4());
    }

    public static void requestFocusAndShowKeyboard(@NonNull final View r10) {
        r10.requestFocus();
        r10.post(new AnonymousClass1(r10));
    }

    public static void doOnApplyWindowInsets(@NonNull View r10, @Nullable AttributeSet r11, int r12, int r13, @Nullable final OnApplyWindowInsetsListener r14) {
        TypedArray r15 = r10.getContext().obtainStyledAttributes(r11, com.google.android.material.R.styleable.Insets, r12, r13);
        final boolean r16 = r15.getBoolean(com.google.android.material.R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        final boolean r17 = r15.getBoolean(com.google.android.material.R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        final boolean r18 = r15.getBoolean(com.google.android.material.R.styleable.Insets_paddingRightSystemWindowInsets, false);
        r15.recycle();
        doOnApplyWindowInsets(r10, new AnonymousClass2(r16, r17, r18, r14));
    }

    public static void removeOnGlobalLayoutListener(@NonNull ViewTreeObserver r10, @NonNull ViewTreeObserver.OnGlobalLayoutListener r11) {
        r10.removeOnGlobalLayoutListener(r11);
    }

    public static void doOnApplyWindowInsets(@NonNull View r10, @NonNull final OnApplyWindowInsetsListener r11) {
        final RelativePadding r12 = new RelativePadding(ViewCompat.F(r10), r10.getPaddingTop(), ViewCompat.E(r10), r10.getPaddingBottom());
        ViewCompat.C0(r10, new AnonymousClass3(r11, r12));
        requestApplyInsetsWhenAttached(r10);
    }
}
