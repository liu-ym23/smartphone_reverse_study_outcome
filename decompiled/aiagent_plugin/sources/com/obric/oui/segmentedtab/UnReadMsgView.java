package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.Objects;

/* JADX INFO: compiled from: UnReadMsgView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnReadMsgView extends AppCompatTextView {
    private int backgroundColor;
    private int cornerRadius;
    private final GradientDrawable gdBackground;
    private boolean isRadiusHalfHeight;
    private boolean isWidthHeightEqual;
    private int strokeColor;
    private int strokeWidth;

    public UnReadMsgView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public UnReadMsgView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ UnReadMsgView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public UnReadMsgView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.gdBackground = new GradientDrawable();
        obtainAttributes(r6, r7);
    }

    private final void obtainAttributes(Context r4, AttributeSet r5) {
        TypedArray r6 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.MsgView);
        o.c(r6, "context.obtainStyledAttr…trs, R.styleable.MsgView)");
        this.backgroundColor = r6.getColor(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_backgroundColor, "styleable", "MsgView_mv_backgroundColor"), 0);
        this.cornerRadius = r6.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_cornerRadius, "styleable", "MsgView_mv_cornerRadius"), 0);
        this.strokeWidth = r6.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_strokeWidth, "styleable", "MsgView_mv_strokeWidth"), 0);
        this.strokeColor = r6.getColor(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_strokeColor, "styleable", "MsgView_mv_strokeColor"), 0);
        this.isRadiusHalfHeight = r6.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_isRadiusHalfHeight, "styleable", "MsgView_mv_isRadiusHalfHeight"), false);
        this.isWidthHeightEqual = r6.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_isWidthHeightEqual, "styleable", "MsgView_mv_isWidthHeightEqual"), false);
        r6.recycle();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r2, int r3) {
        if (isWidthHeightEqual() == true) goto L5;
    L10:
        super.onMeasure(r2, r3);
        return;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        int r4 = View.MeasureSpec.makeMeasureSpec(n.c(getWidth(), getHeight()), 1073741824);
        super.onMeasure(r4, r4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (isRadiusHalfHeight() == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        setBgSelector();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.backgroundColor = r1;
        setBgSelector();
    }

    private final void setCornerRadius(int r1) {
        this.cornerRadius = dp2px(r1);
        setBgSelector();
    }

    private final void setStrokeWidth(int r1) {
        this.strokeWidth = dp2px(r1);
        setBgSelector();
    }

    public final void setStrokeColor(int r1) {
        this.strokeColor = r1;
        setBgSelector();
    }

    public final void setIsRadiusHalfHeight(boolean r1) {
        this.isRadiusHalfHeight = r1;
        setBgSelector();
    }

    public final void setIsWidthHeightEqual(boolean r1) {
        this.isWidthHeightEqual = r1;
        setBgSelector();
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    public final int getStrokeWidth() {
        return this.strokeWidth;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    private final boolean isRadiusHalfHeight() {
        return this.isRadiusHalfHeight;
    }

    private final boolean isWidthHeightEqual() {
        return this.isWidthHeightEqual;
    }

    private final int dp2px(float r3) {
        return (int) ((r3 * ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final int sp2px(float r3) {
        return (int) ((r3 * ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void setDrawable(GradientDrawable r1, int r2, int r3) {
        r1.setColor(r2);
        r1.setCornerRadius(this.cornerRadius);
        r1.setStroke(this.strokeWidth, r3);
    }

    private final void setBgSelector() {
        StateListDrawable r0 = new StateListDrawable();
        setDrawable(this.gdBackground, this.backgroundColor, this.strokeColor);
        r0.addState(new int[]{-16842919}, (Drawable) ZeusTransformUtils.preCheckCast(this.gdBackground, Drawable.class, "com.obric.aiagent.plugin"));
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.aiagent.plugin"));
    }

    public final void show(int r9) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        DisplayMetrics r2 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics();
        o.c(r2, "resources.displayMetrics");
        setVisibility(0);
        if (r9 > 0) goto L5;
        setStrokeWidth(0);
        setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        float r10 = 5;
        r1.width = (int) (r2.density * r10);
        r1.height = (int) (r10 * r2.density);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        float r4 = 18;
        r1.height = (int) (r2.density * r4);
        boolean r6 = true;
        if (1 > r9) goto L9;
        if (r9 >= 10) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
        r1.width = (int) (r4 * r2.density);
        setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r9), CharSequence.class, "com.obric.aiagent.plugin"));
    L21:
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        if (10 <= r9) goto L14;
    L16:
        r6 = false;
    L18:
        if (r6 == false) goto L20;
        r1.width = -2;
        float r5 = 6;
        setPadding((int) (r2.density * r5), 0, (int) (r5 * r2.density), 0);
        setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r9), CharSequence.class, "com.obric.aiagent.plugin"));
        goto L21
    L20:
        r1.width = -2;
        float r11 = 6;
        setPadding((int) (r2.density * r11), 0, (int) (r11 * r2.density), 0);
        setText((CharSequence) ZeusTransformUtils.preCheckCast("99+", CharSequence.class, "com.obric.aiagent.plugin"));
        goto L21
    L14:
        if (r9 >= 100) goto L16;
    L9:
        r7 = false;
        goto L10
    }
}
