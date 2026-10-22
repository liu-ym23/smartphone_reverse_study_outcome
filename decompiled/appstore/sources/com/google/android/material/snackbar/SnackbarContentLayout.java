package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private int maxInlineActionWidth;
    private int maxWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context r10) {
        this(r10, null);
    }

    private static void updateTopBottomPadding(@NonNull View r10, int r11, int r12) {
        if (ViewCompat.V(r10) == false) goto L5;
        ViewCompat.D0(r10, ViewCompat.F(r10), r11, ViewCompat.E(r10), r12);
        return;
    L5:
        r10.setPadding(r10.getPaddingLeft(), r11, r10.getPaddingRight(), r12);
    }

    private boolean updateViewsWithinLayout(int r10, int r11, int r12) {
        if (r10 == getOrientation()) goto L5;
        setOrientation(r10);
        boolean r13 = true;
    L7:
        if (this.messageView.getPaddingTop() == r11) goto L9;
    L12:
        updateTopBottomPadding(this.messageView, r11, r12);
        return true;
    L9:
        if (this.messageView.getPaddingBottom() != r12) goto L12;
        return r13;
    L5:
        r13 = false;
        goto L7
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int r10, int r11) {
        this.messageView.setAlpha(0.0f);
        long r12 = r11;
        long r13 = r10;
        this.messageView.animate().alpha(1.0f).setDuration(r12).setStartDelay(r13).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(0.0f);
        this.actionView.animate().alpha(1.0f).setDuration(r12).setStartDelay(r13).start();
        return;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int r10, int r11) {
        this.messageView.setAlpha(1.0f);
        long r12 = r11;
        long r13 = r10;
        this.messageView.animate().alpha(0.0f).setDuration(r12).setStartDelay(r13).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(1.0f);
        this.actionView.animate().alpha(0.0f).setDuration(r12).setStartDelay(r13).start();
        return;
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (this.maxWidth <= 0) goto L7;
        int r12 = getMeasuredWidth();
        int r13 = this.maxWidth;
        if (r12 <= r13) goto L7;
        r10 = View.MeasureSpec.makeMeasureSpec(r13, Ints.MAX_POWER_OF_TWO);
        super.onMeasure(r10, r11);
    L7:
        int r14 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int r15 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        if (this.messageView.getLayout().getLineCount() <= 1) goto L10;
        boolean r16 = true;
    L11:
        if (r16 == true) goto L13;
    L19:
        if (r16 == true) goto L23;
        r14 = r15;
    L23:
        if (updateViewsWithinLayout(0, r14, r14) == false) goto L27;
    L24:
        super.onMeasure(r10, r11);
        return;
    L27:
        return;
    L13:
        if (this.maxInlineActionWidth <= 0) goto L19;
        if (this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) goto L19;
        if (updateViewsWithinLayout(1, r14, r14 - r15) == true) goto L24;
        return;
    L10:
        r16 = false;
        goto L11
    }

    public void setMaxInlineActionWidth(int r10) {
        this.maxInlineActionWidth = r10;
    }

    public void updateActionTextColorAlphaIfNeeded(float r10) {
        if (r10 == 1.0f) goto L6;
        int r11 = this.actionView.getCurrentTextColor();
        int r12 = MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), r11, r10);
        this.actionView.setTextColor(r12);
        return;
    }

    public SnackbarContentLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.SnackbarLayout);
        this.maxWidth = r12.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.maxInlineActionWidth = r12.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        r12.recycle();
    }
}
