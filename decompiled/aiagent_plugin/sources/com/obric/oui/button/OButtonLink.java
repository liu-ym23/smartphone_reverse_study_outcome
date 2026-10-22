package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.e;
import com.obric.aiagent.plugin.R;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: OButtonLink.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OButtonLink extends OUILinearLayout {
    private static final float ALPHA_ON_PRESS = 0.7f;
    public static final a Companion = null;
    private static final String TAG = "OButtonLink";
    private ImageView arrowView;
    private final int pressOverlayColor;
    private OBaseTextView textView;

    /* JADX INFO: compiled from: OButtonLink.kt */
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

    public OButtonLink(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OButtonLink(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OButtonLink(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public /* synthetic */ OButtonLink(Context r2, AttributeSet r3, int r4, int r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r8, r9, r4, r5);
    }

    public OButtonLink(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        super(r13, r14, r11, null, 8, null);
        this.pressOverlayColor = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_state_overlay_pressed_on_color, "color", "oui_state_overlay_pressed_on_color"));
        initView(r13, r14);
    }

    private final void initView(Context r19, AttributeSet r20) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        TypedArray r9 = r1.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r20, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.OButtonLink);
        o.c(r9, "context.obtainStyledAttr… R.styleable.OButtonLink)");
        String r10 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_widgetText, "styleable", "OButtonLink_oui_widgetText"));
        int r11 = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_widgetTextStyle, "styleable", "OButtonLink_oui_widgetTextStyle"), ZeusTransformUtils.mapRes(R.style.Button_1_Medium, "style", "Button_1_Medium"));
        Drawable r12 = null;
        int r13 = r9.getColor(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_widgetTextColor, "styleable", "OButtonLink_oui_widgetTextColor"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_accent_7_fg, "color", "oui_accent_7_fg"), null));
        boolean r15 = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_buttonLinkShowArrow, "styleable", "OButtonLink_oui_buttonLinkShowArrow"), false);
        Drawable r16 = r9.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_buttonLinkArrowDrawable, "styleable", "OButtonLink_oui_buttonLinkArrowDrawable"));
        setOrientation(0);
        OBaseTextView r8 = new OBaseTextView(r1, null, 0, 6, null);
        r8.setSingleLine();
        r8.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r8.setTextAppearance(r11);
        r8.setTextColor(r13);
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"));
        r8.setIncludeFontPadding(false);
        r8.setGravity(17);
        this.textView = r8;
        if (r8 != null) goto L5;
        o.c("textView");
        OBaseTextView r14 = null;
    L6:
        View r3 = (View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        r4.weight = 1.0f;
        x r6 = x.f38692a;
        addView(r3, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        if (r15 == false) goto L16;
        AppCompatImageView r5 = new AppCompatImageView(r1);
        if (r16 == null) goto L15;
        Drawable r2 = r16.mutate();
        if (r2 == null) goto L15;
        r2.setTint(r13);
        r12 = r2;
    L15:
        r5.setImageDrawable(r12);
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(r5, ImageView.class, "com.obric.aiagent.plugin");
        this.arrowView = r7;
        addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L16:
        r9.recycle();
        setOverridePressColor(0);
        refreshColors(TAG);
        setChangeAlphaWhenPress(true);
        setClickable(true);
        return;
    L5:
        r14 = r8;
        goto L6
    }

    @Override // com.obric.oui.layout.OUILinearLayout, com.obric.oui.common.style.b
    public void onPressAlphaChange(int r3) {
        updateContentColorOnPress(n.a(r3 / 255.0f, 0.0f, 1.0f));
    }

    private final void updateContentColorOnPress(float r6) {
        int r0 = getAnimatedOverlayColor(r6);
        OBaseTextView r2 = null;
        if (r6 <= 0.0f) goto L5;
        PorterDuffColorFilter r7 = new PorterDuffColorFilter(r0, PorterDuff.Mode.SRC_ATOP);
    L6:
        OBaseTextView r1 = this.textView;
        if (r1 != null) goto L9;
        o.c("textView");
        r1 = null;
    L9:
        r1.getPaint().setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r7, ColorFilter.class, "com.obric.aiagent.plugin"));
        OBaseTextView r3 = this.textView;
        if (r3 != null) goto L12;
        o.c("textView");
    L13:
        r2.invalidate();
        if (r7 == null) goto L19;
        ImageView r5 = this.arrowView;
        if (r5 == null) goto L25;
        r5.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r7, ColorFilter.class, "com.obric.aiagent.plugin"));
        return;
    L25:
        return;
    L19:
        ImageView r8 = this.arrowView;
        if (r8 == null) goto L26;
        r8.clearColorFilter();
        return;
    L26:
        return;
    L12:
        r2 = r3;
        goto L13
    L5:
        r7 = (PorterDuffColorFilter) ZeusTransformUtils.preCheckCast(null, PorterDuffColorFilter.class, "com.obric.aiagent.plugin");
        goto L6
    }

    private final int getAnimatedOverlayColor(float r3) {
        return e.b(this.pressOverlayColor, n.a(d.i.a.a(r3 * Color.alpha(this.pressOverlayColor)), 0, 255));
    }
}
