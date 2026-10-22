package com.obric.oui.toast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.color.d;
import com.obric.oui.common.util.g;
import com.obric.oui.d.a.b;
import com.obric.oui.d.i;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.c;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ToastBackgroundView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ToastBackgroundView extends FrameLayout {
    public static final a Companion = null;
    public static final float DEFAULT_CORNER_RADIUS = 24.0f;
    public static final String TAG = "ToastBackgroundView";
    private int bgColor;
    private final Paint bgPaint;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean drawSelf;
    private boolean enableMaterial;
    private final RectF rectF;
    private final Paint strokePaint;

    /* JADX INFO: compiled from: ToastBackgroundView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public ToastBackgroundView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ToastBackgroundView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public final void setupBackground(int r7) {
        setupBackground$default(this, r7, 0, null, 6, null);
    }

    public final void setupBackground(int r7, int r8) {
        setupBackground$default(this, r7, r8, null, 4, null);
    }

    public /* synthetic */ ToastBackgroundView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public ToastBackgroundView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.cornerRadius = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 24.0f);
        this.rectF = new RectF();
        boolean r8 = true;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        this.bgPaint = r9;
        Paint r10 = new Paint(1);
        r10.setStyle(Paint.Style.STROKE);
        this.strokePaint = r10;
        if (k.a(r6) == true) goto L5;
    L7:
        r8 = false;
    L8:
        this.enableMaterial = r8;
        Integer r11 = i.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        setBackgroundColor(0);
        resolveColors(r11);
        return;
    L5:
        if (l.d() == false) goto L7;
        goto L7
    }

    private final void resolveColors(Integer r7) {
        if (r7 != null) goto L5;
        int r8 = androidx.core.content.b.h.b(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_background, "color", "oui_toast_background"), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme());
        if (this.bgPaint.getColor() == r8) goto L13;
        this.bgPaint.setColor(r8);
        this.bgColor = r8;
        b.b(TAG, o.a("resolveColors: bg=", Integer.valueOf(r8)));
        return;
    L13:
        return;
    L5:
        if (this.bgPaint.getColor() == r7.intValue()) goto L12;
        this.bgPaint.setColor(r7.intValue());
        this.bgColor = r7.intValue();
        b.b(TAG, "resolveColors: bg=" + r7 + " from originBgColor");
        return;
    }

    public static /* synthetic */ void setupBackground$default(ToastBackgroundView r0, int r1, int r2, View r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 3;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.setupBackground(r1, r2, r3);
    }

    public final void setupBackground(int r12, int r13, View r14) {
        if (this.enableMaterial == false) goto L7;
        this.drawSelf = false;
        GradientDrawable r15 = new GradientDrawable();
        r15.setShape(0);
        r15.setCornerRadius(this.cornerRadius);
        r15.setColor(0);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r15, Drawable.class, "com.obric.aiagent.plugin"));
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(!isDarkTheme())), c[].class, "com.obric.aiagent.plugin"), false, r13, null, 10, null);
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r14);
        return;
    L7:
        if (r12 != (this.cornerRadius * 2)) goto L9;
        setBackground(androidx.core.content.b.h.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_toast_background_capsule_form, "drawable", "o_toast_background_capsule_form"), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme()));
        this.drawSelf = false;
    L10:
        b.b(TAG, "setupBackground: drawSelf = " + this.drawSelf + ", height = " + r12);
        invalidate();
        return;
    L9:
        this.drawSelf = true;
        goto L10
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // android.view.View
    public void onDraw(Canvas r8) {
        o.e(r8, "canvas");
        float r0 = this.cornerRadius * 1.0f;
        this.rectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.drawSelf == false) goto L5;
        r8.drawRoundRect(this.rectF, r0, r0, this.bgPaint);
    L5:
        int r1 = this.borderWidth;
        if (r1 <= 0) goto L8;
        this.strokePaint.setStrokeWidth(r1);
        this.strokePaint.setColor(this.borderColor);
        r8.drawRoundRect(this.rectF, r0, r0, this.strokePaint);
    L8:
        super.onDraw(r8);
    }

    public final boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L7:
        return d.a(r0);
    }
}
