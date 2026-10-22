package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OBaseTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: OButtonFloating.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OButtonFloating extends OShadowFrame {
    public OBaseTextView textView;

    public OButtonFloating(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OButtonFloating(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OButtonFloating(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public /* synthetic */ OButtonFloating(Context r2, AttributeSet r3, int r4, int r5, int r6, h r7) {
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

    public OButtonFloating(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r5, r6);
    }

    public final OBaseTextView getTextView() {
        OBaseTextView r0 = this.textView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("textView");
        return null;
    }

    public final void setTextView(OBaseTextView r2) {
        o.e(r2, "<set-?>");
        this.textView = r2;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void initContent(Context r11, FrameLayout r12, AttributeSet r13, TypedArray r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r15, "context");
        o.e(r12, "contentView");
        if (r14 != null) goto L5;
        return;
    L5:
        CharSequence r17 = r14.getText(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetText, "styleable", "OShadowFrame_oui_widgetText"));
        int r8 = r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetTextStyle, "styleable", "OShadowFrame_oui_widgetTextStyle"), ZeusTransformUtils.mapRes(R.style.Button_2_Medium, "style", "Button_2_Medium"));
        int r0 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetTextColor, "styleable", "OShadowFrame_oui_widgetTextColor"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"), null));
        OBaseTextView r9 = new OBaseTextView(r15, null, 0, 6, null);
        r9.setTextAppearance(r8);
        r9.setTextColor(r0);
        r9.setText(r17);
        r9.setSingleLine();
        r9.setIncludeFontPadding(false);
        r9.setGravity(17);
        setTextView(r9);
        View r1 = (View) ZeusTransformUtils.preCheckCast(getTextView(), View.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        x r18 = x.f38692a;
        r12.addView(r1, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        if (getMaterialApplied() == false) goto L9;
        initMaterials(r15, r14);
        return;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void applyDynamicTheme(int r1) {
        super.applyDynamicTheme(r1);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void updateUIOnEnableChanged(boolean r1) {
        super.updateUIOnEnableChanged(r1);
        if (r1 == false) goto L5;
        getTextView().setAlpha(1.0f);
        return;
    L5:
        getTextView().setAlpha(0.3f);
    }

    public final TextView getTitleView() {
        return (TextView) ZeusTransformUtils.preCheckCast(getTextView(), TextView.class, "com.obric.aiagent.plugin");
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "text");
        getTextView().setText(r4);
    }

    public final void setTitle(int r1) {
        getTextView().setText(r1);
    }
}
