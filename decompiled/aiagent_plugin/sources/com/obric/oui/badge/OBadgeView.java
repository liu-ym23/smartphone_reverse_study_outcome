package com.obric.oui.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OBadgeView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBadgeView extends OTextView {
    public static final a Companion = null;
    private static int MAX_COUNT;
    private OBadgeDrawable badge;
    private boolean enableFontScale;
    private Integer initialBgColor;

    /* JADX INFO: compiled from: OBadgeView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public OBadgeView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBadgeView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OBadgeView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ OBadgeDrawable access$getBadge$p(OBadgeView r0) {
        return r0.badge;
    }

    public static final /* synthetic */ int access$getMAX_COUNT$cp() {
        return MAX_COUNT;
    }

    public static final /* synthetic */ void access$setMAX_COUNT$cp(int r0) {
        MAX_COUNT = r0;
    }

    public OBadgeView(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        super(r13, r14, r12, null, 8, null);
        this.enableFontScale = true;
        OBadgeDrawable r15 = OBadgeDrawable.Companion.a(r13);
        this.badge = r15;
        if (r15 != null) goto L5;
        o.c("badge");
        r15 = null;
    L5:
        r15.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.aiagent.plugin"));
        initFromAttributes(r14, r12);
        syncTextViewPropertiesToBadge();
        addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), TextWatcher.class, "com.obric.aiagent.plugin"));
    }

    static {
        Companion = new a(null);
        MAX_COUNT = 9999;
    }

    private final void initFromAttributes(AttributeSet r12, int r13) {
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        OBadgeDrawable r5 = this.badge;
        OBadgeDrawable r8 = null;
        if (r5 != null) goto L5;
        o.c("badge");
        r5 = null;
    L5:
        r5.setBadgeGravity(OBadgeDrawable.a.f34008c);
        if (r14 != null) goto L13;
        OBadgeDrawable r15 = this.badge;
        if (r15 != null) goto L10;
        o.c("badge");
    L11:
        r8.setContentDescription(getContentDescription());
        return;
    L10:
        r8 = r15;
        goto L11
    L13:
        TypedArray r16 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r14, R.styleable.OBadgeView, r13, 0);
        o.c(r16, "context.obtainStyledAttr…dgeView, defStyleAttr, 0)");
        this.enableFontScale = r16.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_oui_widgetEnableFontScale, "styleable", "OBadgeView_oui_widgetEnableFontScale"), true);     // Catch: Throwable -> L56
        OBadgeDrawable r17 = this.badge;     // Catch: Throwable -> L56
        if (r17 != null) goto L17;
        o.c("badge");     // Catch: Throwable -> L56
        r17 = null;
    L17:
        r17.setEnableFontScale(this.enableFontScale);     // Catch: Throwable -> L56
        int r18 = ZeusTransformUtils.mapRes(R.styleable.OBadgeView_o_maxNumber, "styleable", "OBadgeView_o_maxNumber");     // Catch: Throwable -> L56
        OBadgeDrawable r6 = this.badge;     // Catch: Throwable -> L56
        if (r6 != null) goto L20;
        o.c("badge");     // Catch: Throwable -> L56
        r6 = null;
    L20:
        int r19 = r16.getInt(r18, r6.getMaxNumber());     // Catch: Throwable -> L56
        OBadgeDrawable r7 = this.badge;     // Catch: Throwable -> L56
        if (r7 != null) goto L23;
        o.c("badge");     // Catch: Throwable -> L56
        r7 = null;
    L23:
        r7.setMaxNumber(r19);     // Catch: Throwable -> L56
        int r110 = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_oui_badgeview_ellipsis_color, "styleable", "OBadgeView_oui_badgeview_ellipsis_color"), 0);     // Catch: Throwable -> L56
        OBadgeDrawable r9 = this.badge;     // Catch: Throwable -> L56
        if (r9 != null) goto L26;
        o.c("badge");     // Catch: Throwable -> L56
        r9 = null;
    L26:
        r9.setEllipsisColor(Integer.valueOf(r110));     // Catch: Throwable -> L56
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_text, "styleable", "OBadgeView_android_text")) == false) goto L36;
        CharSequence r111 = r16.getText(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_text, "styleable", "OBadgeView_android_text"));     // Catch: Throwable -> L56
        OBadgeDrawable r3 = this.badge;     // Catch: Throwable -> L56
        if (r3 != null) goto L31;
        o.c("badge");     // Catch: Throwable -> L56
        r3 = null;
    L31:
        if (r111 != null) goto L33;
        String r112 = null;
    L34:
        r3.setBadgeText(r112);     // Catch: Throwable -> L56
        goto L36
    L33:
        r112 = r111.toString();     // Catch: Throwable -> L56
    L36:
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_textColor, "styleable", "OBadgeView_android_textColor")) == false) goto L42;
        int r113 = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_textColor, "styleable", "OBadgeView_android_textColor"), getCurrentTextColor());     // Catch: Throwable -> L56
        OBadgeDrawable r2 = this.badge;     // Catch: Throwable -> L56
        if (r2 != null) goto L40;
        o.c("badge");     // Catch: Throwable -> L56
        r2 = null;
    L40:
        r2.setBadgeTextColor(r113);     // Catch: Throwable -> L56
    L42:
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_textSize, "styleable", "OBadgeView_android_textSize")) == false) goto L45;
        updateBadgeTextSizeFromPx(r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_textSize, "styleable", "OBadgeView_android_textSize"), getTextSize()));     // Catch: Throwable -> L56
    L45:
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_background, "styleable", "OBadgeView_android_background")) == false) goto L50;
        int r114 = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_background, "styleable", "OBadgeView_android_background"), androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_red_6, "color", "oui_red_6")));     // Catch: Throwable -> L56
        OBadgeDrawable r0 = this.badge;     // Catch: Throwable -> L56
        if (r0 != null) goto L49;
        o.c("badge");     // Catch: Throwable -> L56
        r0 = null;
    L49:
        r0.setBackgroundColor(r114);     // Catch: Throwable -> L56
    L50:
        r16.recycle();
        OBadgeDrawable r115 = this.badge;
        if (r115 != null) goto L53;
        o.c("badge");
    L54:
        r8.setContentDescription(getContentDescription());
        return;
    L53:
        r8 = r115;
    L56:
        th = move-exception;
        r16.recycle();
        throw th;
    }

    private final void syncTextViewPropertiesToBadge() {
        OBadgeDrawable r0 = this.badge;
        OBadgeDrawable r2 = null;
        if (r0 != null) goto L5;
        o.c("badge");
        r0 = null;
    L5:
        CharSequence r3 = getText();
        if (r3 != null) goto L8;
        String r4 = null;
    L9:
        r0.setBadgeText(r4);
        OBadgeDrawable r1 = this.badge;
        if (r1 != null) goto L12;
        o.c("badge");
        r1 = null;
    L12:
        r1.setBadgeTextColor(getCurrentTextColor());
        OBadgeDrawable r5 = this.badge;
        if (r5 != null) goto L15;
        o.c("badge");
        r5 = null;
    L15:
        r5.setEnableFontScale(this.enableFontScale);
        updateBadgeTextSizeFromPx(getTextSize());
        Drawable r6 = getBackground();
        if (ZeusTransformUtils.instanceOf(r6, ColorDrawable.class) == false) goto L23;
        OBadgeDrawable r7 = this.badge;
        if (r7 != null) goto L20;
        o.c("badge");
    L21:
        r2.setBackgroundColor(((ColorDrawable) ZeusTransformUtils.preCheckCast(r6, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor());
        return;
    L20:
        r2 = r7;
        goto L21
    L23:
        if (this.initialBgColor == null) goto L31;
        OBadgeDrawable r8 = this.badge;
        if (r8 != null) goto L27;
        o.c("badge");
    L28:
        Integer r9 = this.initialBgColor;
        o.a(r9);
        r2.setBackgroundColor(r9.intValue());
        return;
    L27:
        r2 = r8;
        goto L28
    L31:
        return;
    L8:
        r4 = r3.toString();
        goto L9
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r6, int r7) {
        OBadgeDrawable r0 = this.badge;
        OBadgeDrawable r1 = null;
        if (r0 != null) goto L5;
        o.c("badge");
        r0 = null;
    L5:
        r0.updateBadgeCoordinates((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        OBadgeDrawable r2 = this.badge;
        if (r2 != null) goto L8;
        o.c("badge");
    L9:
        Rect r3 = r1.getBounds();
        o.c(r3, "badge.bounds");
        int r4 = r3.width();
        int r5 = r3.height();
        setMeasuredDimension(TextView.resolveSize(r4 + (getPaddingLeft() + getPaddingRight()), r6), TextView.resolveSize(r5 + (getPaddingTop() + getPaddingBottom()), r7));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateBadgeCoordinates();
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L6;
        updateBadgeCoordinates();
        return;
    }

    private final void updateBadgeCoordinates() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L12;
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L9;
        o.c("badge");
        r0 = null;
    L9:
        r0.updateBadgeCoordinates((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r2) {
        o.e(r2, "canvas");
        OBadgeDrawable r1 = this.badge;
        if (r1 != null) goto L5;
        o.c("badge");
        r1 = null;
    L5:
        r1.draw(r2);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r2) {
        o.e(r2, "who");
        if (super.verifyDrawable(r2) == true) goto L11;
        OBadgeDrawable r1 = this.badge;
        if (r1 != null) goto L8;
        o.c("badge");
        r1 = null;
    L8:
        if (o.a(r2, r1) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        o.e(r2, "drawable");
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L6;
        o.c("badge");
        r0 = null;
    L6:
        if (o.a(r2, r0) == false) goto L8;
        invalidate();
        return;
    L8:
        super.invalidateDrawable(r2);
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        super.setContentDescription(r4);
        OBadgeDrawable r2 = this.badge;
        if (r2 != null) goto L5;
        o.c("badge");
        r2 = null;
    L5:
        r2.setContentDescription(r4);
    }

    @Override // android.widget.TextView
    public void setTextColor(int r2) {
        if (this.badge == null) goto L9;
        super.setTextColor(r2);
        OBadgeDrawable r3 = this.badge;
        if (r3 != null) goto L7;
        o.c("badge");
        r3 = null;
    L7:
        r3.setBadgeTextColor(getCurrentTextColor());
        invalidate();
        return;
    }

    @Override // android.widget.TextView
    public void setTextSize(int r1, float r2) {
        super.setTextSize(r1, r2);
        if (this.badge == null) goto L5;
        updateBadgeTextSizeFromPx(getTextSize());
    L5:
        requestLayout();
        invalidate();
    }

    public final void setEnableFontScale(boolean r2) {
        if (this.enableFontScale != r2) goto L5;
        return;
    L5:
        this.enableFontScale = r2;
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L8;
        o.c("badge");
        r0 = null;
    L8:
        r0.setEnableFontScale(r2);
        syncTextViewPropertiesToBadge();
        requestLayout();
        invalidate();
    }

    private final void updateBadgeTextSizeFromPx(float r2) {
        float r3 = r2 / ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().scaledDensity;
        OBadgeDrawable r1 = this.badge;
        if (r1 != null) goto L5;
        o.c("badge");
        r1 = null;
    L5:
        r1.setTextSizeSp(r3);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        OBadgeDrawable r0 = this.badge;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        o.c("badge");
        r0 = null;
    L6:
        r0.setBackgroundColor(r2);
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setBackground(Drawable r4) {
        if (this.badge == null) goto L16;
        OBadgeDrawable r1 = null;
        if (ZeusTransformUtils.instanceOf(r4, ColorDrawable.class) == false) goto L7;
        ColorDrawable r5 = (ColorDrawable) ZeusTransformUtils.preCheckCast(r4, ColorDrawable.class, "com.obric.aiagent.plugin");
    L8:
        if (r5 == null) goto L17;
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L13;
        o.c("badge");
    L14:
        r1.setBackgroundColor(r5.getColor());
        invalidate();
        return;
    L13:
        r1 = r0;
        goto L14
    L17:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void setMaxNumberInCount(int r2) {
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L5;
        o.c("badge");
        r0 = null;
    L5:
        r0.setMaxNumber(r2);
        requestLayout();
        invalidate();
    }

    public final void show() {
        setVisibility(0);
    }

    public final void hide() {
        setVisibility(8);
    }
}
