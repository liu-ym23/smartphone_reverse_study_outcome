package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {
    private boolean drawBottomInsetForeground;
    private boolean drawTopInsetForeground;

    @Nullable
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect;

    public ScrimInsetsFrameLayout(@NonNull Context r10) {
        this(r10, null);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        int r11 = getWidth();
        int r12 = getHeight();
        if (this.insets != null) goto L5;
        return;
    L5:
        if (this.insetForeground == null) goto L15;
        int r13 = r10.save();
        r10.translate(getScrollX(), getScrollY());
        if (this.drawTopInsetForeground == false) goto L10;
        this.tempRect.set(0, 0, r11, this.insets.top);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r10);
    L10:
        if (this.drawBottomInsetForeground == false) goto L12;
        this.tempRect.set(0, r12 - this.insets.bottom, r11, r12);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r10);
    L12:
        Rect r14 = this.tempRect;
        Rect r15 = this.insets;
        r14.set(0, r15.top, r15.left, r12 - r15.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r10);
        Rect r16 = this.tempRect;
        Rect r17 = this.insets;
        r16.set(r11 - r17.right, r17.top, r11, r12 - r17.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r10);
        r10.restoreToCount(r13);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r10 = this.insetForeground;
        if (r10 == null) goto L6;
        r10.setCallback(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable r10 = this.insetForeground;
        if (r10 == null) goto L6;
        r10.setCallback(null);
        return;
    }

    public void onInsetsChanged(WindowInsetsCompat r10) {
    }

    public void setDrawBottomInsetForeground(boolean r10) {
        this.drawBottomInsetForeground = r10;
    }

    public void setDrawTopInsetForeground(boolean r10) {
        this.drawTopInsetForeground = r10;
    }

    public void setScrimInsetForeground(@Nullable Drawable r10) {
        this.insetForeground = r10;
    }

    public ScrimInsetsFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.tempRect = new Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.ScrimInsetsFrameLayout, r12, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.insetForeground = r13.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        r13.recycle();
        setWillNotDraw(true);
        ViewCompat.C0(this, new AnonymousClass1(this));
    }
}
