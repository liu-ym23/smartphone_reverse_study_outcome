package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    private boolean drawBottomInsetForeground;
    private boolean drawTopInsetForeground;
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect;

    public void onInsetsChanged(al r1) {
    }

    public ScrimInsetsFrameLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public ScrimInsetsFrameLayout(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public ScrimInsetsFrameLayout(Context r9, AttributeSet r10, int r11) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r2, r3, r11);
        this.tempRect = new Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        TypedArray r12 = l.a(r2, r3, R.styleable.ScrimInsetsFrameLayout, r11, ZeusTransformUtils.mapRes(R.style.Widget_Design_ScrimInsetsFrameLayout, "style", "Widget_Design_ScrimInsetsFrameLayout"), new int[0]);
        this.insetForeground = r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ScrimInsetsFrameLayout_insetForeground, "styleable", "ScrimInsetsFrameLayout_insetForeground"));
        r12.recycle();
        setWillNotDraw(true);
        ViewCompat.a(this, new AnonymousClass1(this));
    }

    public void setScrimInsetForeground(Drawable r1) {
        this.insetForeground = r1;
    }

    public void setDrawTopInsetForeground(boolean r1) {
        this.drawTopInsetForeground = r1;
    }

    public void setDrawBottomInsetForeground(boolean r1) {
        this.drawBottomInsetForeground = r1;
    }

    @Override // android.view.View
    public void draw(Canvas r9) {
        super.draw(r9);
        int r0 = getWidth();
        int r1 = getHeight();
        if (this.insets != null) goto L5;
        return;
    L5:
        if (this.insetForeground == null) goto L15;
        int r2 = r9.save();
        r9.translate(getScrollX(), getScrollY());
        if (this.drawTopInsetForeground == false) goto L10;
        this.tempRect.set(0, 0, r0, this.insets.top);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
    L10:
        if (this.drawBottomInsetForeground == false) goto L12;
        this.tempRect.set(0, r1 - this.insets.bottom, r0, r1);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
    L12:
        this.tempRect.set(0, this.insets.top, this.insets.left, r1 - this.insets.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
        this.tempRect.set(r0 - this.insets.right, this.insets.top, r0, r1 - this.insets.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
        r9.restoreToCount(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r0 = this.insetForeground;
        if (r0 == null) goto L6;
        r0.setCallback(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable r1 = this.insetForeground;
        if (r1 == null) goto L6;
        r1.setCallback(null);
        return;
    }
}
