package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes3.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = null;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS = null;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public Callback() {
        }

        /* JADX INFO: renamed from: onDismissed, reason: avoid collision after fix types in other method */
        public void onDismissed2(Snackbar r10, int r11) {
        }

        /* JADX INFO: renamed from: onShown, reason: avoid collision after fix types in other method */
        public void onShown2(Snackbar r10) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public /* bridge */ /* synthetic */ void onDismissed(Snackbar r10, int r11) {
            onDismissed2(r10, r11);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public /* bridge */ /* synthetic */ void onShown(Snackbar r10) {
            onShown2(r10);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context r10) {
            super(r10);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            int r12 = getChildCount();
            int r13 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L8;
            View r15 = getChildAt(r14);
            if (r15.getLayoutParams().width != (-1)) goto L7;
            r15.measure(View.MeasureSpec.makeMeasureSpec(r13, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r15.getMeasuredHeight(), Ints.MAX_POWER_OF_TWO));
        L7:
            r14 = r14 + 1;
            goto L3
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable r10) {
            super.setBackground(r10);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable r10) {
            super.setBackgroundDrawable(r10);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList r10) {
            super.setBackgroundTintList(r10);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
            super.setBackgroundTintMode(r10);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener r10) {
            super.setOnClickListener(r10);
        }

        public SnackbarLayout(Context r10, AttributeSet r11) {
            super(r10, r11);
        }
    }

    static {
        int r10 = R.attr.snackbarButtonStyle;
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{r10};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{r10, R.attr.snackbarTextViewStyle};
    }

    private Snackbar(@NonNull Context r10, @NonNull ViewGroup r11, @NonNull View r12, @NonNull ContentViewCallback r13) {
        super(r10, r11, r12, r13);
        this.accessibilityManager = (AccessibilityManager) r11.getContext().getSystemService("accessibility");
    }

    @Nullable
    private static ViewGroup findSuitableParent(View r10) {
        ViewGroup r11 = null;
    L4:
        if ((r10 instanceof CoordinatorLayout) == true) goto L6;
        if ((r10 instanceof FrameLayout) == true) goto L10;
    L14:
        if (r10 == null) goto L19;
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == false) goto L18;
        r10 = (View) r12;
        goto L19
    L18:
        r10 = null;
    L19:
        if (r10 != null) goto L4;
        return r11;
    L10:
        if (r10.getId() == 16908290) goto L12;
        r11 = (ViewGroup) r10;
        goto L14
    L12:
        return (ViewGroup) r10;
    L6:
        return (ViewGroup) r10;
    }

    @Deprecated
    public static boolean hasSnackbarButtonStyleAttr(@NonNull Context r10) {
        TypedArray r11 = r10.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int r12 = r11.getResourceId(0, -1);
        r11.recycle();
        if (r12 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean hasSnackbarContentStyleAttrs(@NonNull Context r10) {
        TypedArray r11 = r10.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int r12 = r11.getResourceId(0, -1);
        int r13 = r11.getResourceId(1, -1);
        r11.recycle();
        if (r12 == (-1)) goto L7;
        if (r13 != (-1)) goto L6;
        return false;
    L6:
        return true;
    L7:
        return false;
    }

    @NonNull
    public static Snackbar make(@NonNull View r10, @NonNull CharSequence r11, int r12) {
        return makeInternal(null, r10, r11, r12);
    }

    @NonNull
    private static Snackbar makeInternal(@Nullable Context r10, @NonNull View r11, @NonNull CharSequence r12, int r13) {
        ViewGroup r14 = findSuitableParent(r11);
        if (r14 == null) goto L13;
        if (r10 != null) goto L6;
        r10 = r14.getContext();
    L6:
        LayoutInflater r15 = LayoutInflater.from(r10);
        if (hasSnackbarContentStyleAttrs(r10) == false) goto L9;
        int r16 = R.layout.mtrl_layout_snackbar_include;
    L10:
        SnackbarContentLayout r17 = (SnackbarContentLayout) r15.inflate(r16, r14, false);
        Snackbar r18 = new Snackbar(r10, r14, r17, r17);
        r18.setText(r12);
        r18.setDuration(r13);
        return r18;
    L9:
        r16 = R.layout.design_layout_snackbar_include;
        goto L10
    L13:
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int r10 = super.getDuration();
        if (r10 != (-2)) goto L6;
        return -2;
    L6:
        if (this.hasAction == false) goto L8;
        int r11 = 4;
    L10:
        return this.accessibilityManager.getRecommendedTimeoutMillis(r10, r11 | 3);
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    @NonNull
    public Snackbar setAction(@StringRes int r10, View.OnClickListener r11) {
        return setAction(getContext().getText(r10), r11);
    }

    @NonNull
    public Snackbar setActionTextColor(ColorStateList r10) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(r10);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTint(@ColorInt int r10) {
        return setBackgroundTintList(ColorStateList.valueOf(r10));
    }

    @NonNull
    public Snackbar setBackgroundTintList(@Nullable ColorStateList r10) {
        this.view.setBackgroundTintList(r10);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        this.view.setBackgroundTintMode(r10);
        return this;
    }

    @NonNull
    @Deprecated
    public Snackbar setCallback(@Nullable Callback r10) {
        BaseTransientBottomBar.BaseCallback<Snackbar> r11 = this.callback;
        if (r11 == null) goto L5;
        removeCallback(r11);
    L5:
        if (r10 == null) goto L7;
        addCallback(r10);
    L7:
        this.callback = r10;
        return this;
    }

    @NonNull
    public Snackbar setMaxInlineActionWidth(@Dimension int r10) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).setMaxInlineActionWidth(r10);
        return this;
    }

    @NonNull
    public Snackbar setText(@NonNull CharSequence r10) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setText(r10);
        return this;
    }

    @NonNull
    public Snackbar setTextColor(ColorStateList r10) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(r10);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    @NonNull
    public static Snackbar make(@NonNull Context r10, @NonNull View r11, @NonNull CharSequence r12, int r13) {
        return makeInternal(r10, r11, r12, r13);
    }

    @NonNull
    public Snackbar setAction(@Nullable CharSequence r10, @Nullable final View.OnClickListener r11) {
        Button r12 = ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(r10) == true) goto L7;
        if (r11 == null) goto L7;
        this.hasAction = true;
        r12.setVisibility(0);
        r12.setText(r10);
        r12.setOnClickListener(new AnonymousClass1(this, r11));
    L8:
        return this;
    L7:
        r12.setVisibility(8);
        r12.setOnClickListener(null);
        this.hasAction = false;
        goto L8
    }

    @NonNull
    public static Snackbar make(@NonNull View r10, @StringRes int r11, int r12) {
        return make(r10, r10.getResources().getText(r11), r12);
    }

    @NonNull
    public Snackbar setActionTextColor(@ColorInt int r10) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(r10);
        return this;
    }

    @NonNull
    public Snackbar setText(@StringRes int r10) {
        return setText(getContext().getText(r10));
    }

    @NonNull
    public Snackbar setTextColor(@ColorInt int r10) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(r10);
        return this;
    }
}
