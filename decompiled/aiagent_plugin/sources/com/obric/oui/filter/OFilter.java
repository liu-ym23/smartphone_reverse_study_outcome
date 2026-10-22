package com.obric.oui.filter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.l;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OFilter.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OFilter extends DrawableCenterButton {
    public static final a Companion = null;
    public static final int FILTER_STYLE_HIGHLIGHT = 1;
    public static final int FILTER_STYLE_NORMAL = 0;
    public static final int NORMAL_PADDING_HORIZONTAL = 12;
    public static final int NORMAL_PADDING_VERTICAL = 5;
    public static final int WITH_ICON_PADDING_HORIZONTAL = 16;
    public static final int WITH_ICON_PADDING_VERTICAL = 7;
    private final Paint bgPaint;
    private final RectF bgRect;
    private Drawable drawable;
    private float highlightCornerRadiusPx;
    private boolean isAlwaysLight;
    private float normalCornerRadiusPx;
    private int normalPaddingHorizontal;
    private int normalPaddingVertical;
    private b onFilterSelectChangeListener;
    private final float paintStrokeWidth;
    private boolean showIcon;
    private final Paint strokePaint;
    private final RectF strokeRect;
    private int style;
    private int tintAndTextColor;
    private int withIconPaddingHorizontal;
    private int withIconPaddingVertical;

    /* JADX INFO: compiled from: OFilter.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OFilter.kt */
    public interface b {
        void a(OFilter r1, boolean r2);
    }

    static {
        Companion = new a(null);
    }

    public OFilter(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, false, 14, null);
    }

    public OFilter(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, false, 12, null);
    }

    public OFilter(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, false, 8, null);
    }

    public /* synthetic */ OFilter(Context r2, AttributeSet r3, int r4, boolean r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r8, r9, r4, r5);
    }

    public OFilter(Context r7, AttributeSet r8, int r9, boolean r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        super(r11, r12, r9);
        this.normalPaddingHorizontal = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        this.normalPaddingVertical = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 5);
        this.withIconPaddingHorizontal = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
        this.withIconPaddingVertical = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 7);
        float r1 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0.5d);
        this.paintStrokeWidth = r1;
        Paint r3 = new Paint(1);
        r3.setStyle(Paint.Style.FILL);
        this.bgPaint = r3;
        Paint r4 = new Paint(1);
        r4.setStyle(Paint.Style.STROKE);
        r4.setStrokeWidth(r1);
        this.strokePaint = r4;
        this.bgRect = new RectF();
        this.strokeRect = new RectF();
        refreshDimensionCache();
        TypedArray r13 = r11.getTheme().obtainStyledAttributes(r12, R.styleable.OFilter, r9, 0);
        this.style = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OFilter_oui_filterStyle, "styleable", "OFilter_oui_filterStyle"), 0);     // Catch: Throwable -> L6
        this.showIcon = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFilter_showIcon, "styleable", "OFilter_showIcon"), false);     // Catch: Throwable -> L6
        this.isAlwaysLight = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFilter_oui_isAlwaysLight, "styleable", "OFilter_oui_isAlwaysLight"), r10);     // Catch: Throwable -> L6
        r13.recycle();
        setSingleLine();
        setTextSize(0, ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_filter_text_size, "dimen", "oui_filter_text_size")));
        setCompoundDrawablePadding(ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_filter_drawable_padding, "dimen", "oui_filter_drawable_padding")));
        setGravity(17);
        refreshStyle();
        return;
    L6:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
        invalidate();
    }

    private final void refreshDimensionCache() {
        this.normalCornerRadiusPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
        this.highlightCornerRadiusPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    }

    public final void changeIconVisibility(boolean r4) {
        this.showIcon = r4;
        if (r4 == false) goto L5;
        setStyle$default(this, 1, false, 2, null);
        return;
    L5:
        internalSetDrawable();
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        refreshStyle();
        b r0 = this.onFilterSelectChangeListener;
        if (r0 == null) goto L7;
        r0.a(this, r2);
        return;
    }

    public static /* synthetic */ void setStyle$default(OFilter r0, int r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.setStyle(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStyle");
    }

    public final void setStyle(int r1, boolean r2) {
        this.style = r1;
        this.isAlwaysLight = r2;
        refreshStyle();
    }

    public final int getStyle() {
        return this.style;
    }

    public final void refreshStyle() {
        if (isEnabled() == true) goto L6;
        return;
    L6:
        if (this.style != 1) goto L8;
        setMinHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 36));
    L10:
        if (isSelected() == false) goto L19;
        if (this.isAlwaysLight == false) goto L15;
        int r0 = ZeusTransformUtils.mapRes(R.color.primary, "color", "primary");
        int r3 = ZeusTransformUtils.mapRes(R.color.BGBrand, "color", "BGBrand");
        this.tintAndTextColor = ZeusTransformUtils.mapRes(R.color.primary, "color", "primary");
        setTypeface(null, 1);
    L25:
        this.bgPaint.setColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3));
        this.strokePaint.setColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0));
        setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.tintAndTextColor));
        internalSetDrawable();
        return;
    L15:
        if (this.style != 1) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.color.primary, "color", "primary");
        this.tintAndTextColor = ZeusTransformUtils.mapRes(R.color.primary, "color", "primary");
        r3 = ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent");
        setTypeface(null, 1);
        goto L25
    L17:
        r0 = ZeusTransformUtils.mapRes(R.color.BGInput, "color", "BGInput");
        this.tintAndTextColor = ZeusTransformUtils.mapRes(R.color.TextPrimary, "color", "TextPrimary");
        r3 = ZeusTransformUtils.mapRes(R.color.BGInput, "color", "BGInput");
        setTypeface(null, 1);
        goto L25
    L19:
        if (this.isAlwaysLight == false) goto L22;
        r0 = ZeusTransformUtils.mapRes(R.color.LineReverse2, "color", "LineReverse2");
        this.tintAndTextColor = ZeusTransformUtils.mapRes(R.color.TextReverse, "color", "TextReverse");
        r3 = ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent");
        setTypeface(null, 0);
        goto L25
    L22:
        if (this.style != 1) goto L24;
        r0 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_2, "color", "oui_basic_text_2");
        this.tintAndTextColor = ZeusTransformUtils.mapRes(R.color.oui_basic_text_2, "color", "oui_basic_text_2");
        r3 = ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent");
        setTypeface(null, 0);
        goto L25
    L24:
        r0 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_2, "color", "oui_basic_text_2");
        this.tintAndTextColor = ZeusTransformUtils.mapRes(R.color.oui_basic_text_2, "color", "oui_basic_text_2");
        r3 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_4, "color", "oui_basic_text_4");
        setTypeface(null, 0);
        goto L25
    L8:
        setMinHeight(-1);
        goto L10
    }

    private final void internalSetDrawable() {
        if (this.showIcon == true) goto L5;
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        int r0 = this.normalPaddingHorizontal;
        int r1 = this.normalPaddingVertical;
        setPadding(r0, r1, r0, r1);
        setGravity(17);
        return;
    L5:
        if (this.drawable != null) goto L11;
        Drawable r2 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_arrow_forward_filter, "drawable", "o_arrow_forward_filter"));
        if (r2 != null) goto L9;
        Drawable r3 = null;
    L10:
        this.drawable = r3;
        goto L11
    L9:
        r3 = r2.mutate();
    L11:
        Drawable r4 = this.drawable;
        o.a(r4);
        Drawable r5 = androidx.core.graphics.drawable.a.g(r4);
        androidx.core.graphics.drawable.a.a(r5, PorterDuff.Mode.SRC_IN);
        androidx.core.graphics.drawable.a.a(r5, androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.tintAndTextColor));
        r5.setBounds(0, 0, r5.getIntrinsicWidth(), r5.getIntrinsicHeight());
        setGravity(8388629);
        setCompoundDrawablesWithIntrinsicBounds(null, null, r5, null);
        int r6 = this.withIconPaddingHorizontal;
        int r7 = this.withIconPaddingVertical;
        setPadding(r6, r7, r6, r7);
    }

    public final void setWithIconPadding(int r1, int r2) {
        this.withIconPaddingHorizontal = r1;
        this.withIconPaddingVertical = r2;
    }

    public final void setNormalPadding(int r1, int r2) {
        this.normalPaddingHorizontal = r1;
        this.normalPaddingVertical = r2;
    }

    public final void setAlwaysLight(boolean r1) {
        this.isAlwaysLight = r1;
        refreshStyle();
    }

    public final boolean getIsAlwaysLight() {
        return this.isAlwaysLight;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        setAlpha(1.0f);
        refreshStyle();
        return;
    L5:
        setAlpha(0.5f);
    }

    public final void setSelectChangeListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.onFilterSelectChangeListener = r4;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.filter.DrawableCenterButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r2) {
        o.e(r2, "canvas");
        drawCustomBackground(r2);
        super.onDraw(r2);
    }

    private final void drawCustomBackground(Canvas r6) {
        r6.save();
        r6.translate(getScrollX() * 1.0f, getScrollY() * 1.0f);
        if (this.style != 0) goto L5;
        float r0 = this.normalCornerRadiusPx;
    L6:
        this.bgRect.set(0.0f, 0.0f, getWidth(), getHeight());
        l.a(r6, this.bgRect, r0, this.bgPaint);
        if (this.style != 1) goto L9;
        float r1 = this.paintStrokeWidth * 0.5f;
        this.strokeRect.set(r1, r1, getWidth() - r1, getHeight() - r1);
        l.a(r6, this.strokeRect, r0, this.strokePaint);
    L9:
        r6.restore();
        return;
    L5:
        r0 = this.highlightCornerRadiusPx;
        goto L6
    }
}
