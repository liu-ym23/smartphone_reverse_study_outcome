package com.obric.oui.tips;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: OTips.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OTips extends ConstraintLayout {
    private final f leftIcon$delegate;
    private ColorStateList leftIconTint;
    private final f rightIcon$delegate;
    private ColorStateList rightIconTint;
    private String spanText;
    private final f tipsTv$delegate;

    /* JADX INFO: compiled from: OTips.kt */
    static final class a extends p implements d.h.a.a<ImageView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTips f36491a;

        a(OTips r1) {
            this.f36491a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ImageView invoke() {
            return a();
        }

        public final ImageView a() {
            return (ImageView) ZeusTransformUtils.preCheckCast(this.f36491a.findViewById(ZeusTransformUtils.mapRes(R.id.iv_left, DbHelper.COL_ID, "iv_left")), ImageView.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: OTips.kt */
    static final class b extends p implements d.h.a.a<ImageView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTips f36492a;

        b(OTips r1) {
            this.f36492a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ImageView invoke() {
            return a();
        }

        public final ImageView a() {
            return (ImageView) ZeusTransformUtils.preCheckCast(this.f36492a.findViewById(ZeusTransformUtils.mapRes(R.id.iv_right, DbHelper.COL_ID, "iv_right")), ImageView.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: OTips.kt */
    static final class c extends p implements d.h.a.a<TextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTips f36493a;

        c(OTips r1) {
            this.f36493a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ TextView invoke() {
            return a();
        }

        public final TextView a() {
            return (TextView) ZeusTransformUtils.preCheckCast(this.f36493a.findViewById(ZeusTransformUtils.mapRes(R.id.tv_left, DbHelper.COL_ID, "tv_left")), TextView.class, "com.obric.aiagent.plugin");
        }
    }

    public OTips(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OTips(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$BKb7Nspkn2g4NdQvH83T5cMI0Og(d.h.a.a r0, View r1) {
        m1203setLeftIconOnClickListener$lambda3(r0, r1);
    }

    public static /* synthetic */ void lambda$kLWT0nrKIeSSzyt2Xlx2R6OVQG8(d.h.a.a r0, View r1) {
        m1204setRightIconOnClickListener$lambda2(r0, r1);
    }

    public /* synthetic */ OTips(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OTips(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        this.leftIcon$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new a(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.tipsTv$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.rightIcon$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.o_tips, "layout", "o_tips"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (r10 == null) goto L47;
        TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.OTips);
        o.c(r11, "context.obtainStyledAttr…attrs, R.styleable.OTips)");
        Drawable r12 = r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_leftIcon, "styleable", "OTips_oui_leftIcon"));
        if (r12 == null) goto L8;
        setLeftIc(r12);
    L8:
        Drawable r13 = r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_RightIcon, "styleable", "OTips_oui_RightIcon"));
        if (r13 == null) goto L12;
        setRightIc(r13);
    L12:
        ColorStateList r14 = r11.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_leftIcon_tint, "styleable", "OTips_oui_leftIcon_tint"));
        if (r14 == null) goto L22;
        this.leftIconTint = r14;
        ImageView r0 = getLeftIcon();
        if (r0 == null) goto L22;
        Drawable r1 = r0.getDrawable();
        if (r1 == null) goto L22;
        r1.setTintList(r14);
    L22:
        ColorStateList r15 = r11.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_rightIcon_tint, "styleable", "OTips_oui_rightIcon_tint"));
        if (r15 == null) goto L32;
        this.rightIconTint = r15;
        ImageView r2 = getRightIcon();
        if (r2 == null) goto L32;
        Drawable r3 = r2.getDrawable();
        if (r3 == null) goto L32;
        r3.setTintList(r15);
    L32:
        Integer r16 = Integer.valueOf(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_tipsTextColor, "styleable", "OTips_oui_tipsTextColor"), -1));
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin")).intValue() == (-1)) goto L35;
        boolean r4 = true;
    L36:
        if (r4 == true) goto L39;
        r16 = null;
    L39:
        if (r16 == null) goto L45;
        int r17 = ((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin")).intValue();
        TextView r5 = getTipsTv();
        if (r5 == null) goto L45;
        r5.setTextColor(r17);
    L45:
        setTipsText(r11.getString(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_tipsText, "styleable", "OTips_oui_tipsText")));
        setTipsLine(r11.getInteger(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_tipsLine, "styleable", "OTips_oui_tipsLine"), 1));
        setTextRolling(r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_textRolling, "styleable", "OTips_oui_textRolling"), false));
        this.spanText = r11.getString(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_spanText, "styleable", "OTips_oui_spanText"));
        r11.recycle();
        return;
    L35:
        r4 = false;
        goto L36
    }

    public final ImageView getLeftIcon() {
        return (ImageView) ZeusTransformUtils.preCheckCast(this.leftIcon$delegate.b(), ImageView.class, "com.obric.aiagent.plugin");
    }

    private final Drawable getLeftIc() {
        return getLeftIcon().getDrawable();
    }

    private final void setLeftIc(Drawable r3) {
        getLeftIcon().setImageDrawable(r3);
        ImageView r4 = getLeftIcon();
        o.c(r4, "leftIcon");
        k.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        invalidate();
    }

    public final TextView getTipsTv() {
        return (TextView) ZeusTransformUtils.preCheckCast(this.tipsTv$delegate.b(), TextView.class, "com.obric.aiagent.plugin");
    }

    public final String getTipsText() {
        CharSequence r0 = getTipsTv().getText();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    public final void setTipsText(String r4) {
        getTipsTv().setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        invalidate();
    }

    public final int getTipsLine() {
        return getTipsTv().getMaxLines();
    }

    public final void setTipsLine(int r3) {
        getTipsTv().setMaxLines(r3);
        TextView r0 = getTipsTv();
        boolean r1 = true;
        if (r3 == 1) goto L6;
        r1 = false;
    L6:
        r0.setSingleLine(r1);
        invalidate();
    }

    public final ImageView getRightIcon() {
        return (ImageView) ZeusTransformUtils.preCheckCast(this.rightIcon$delegate.b(), ImageView.class, "com.obric.aiagent.plugin");
    }

    private final Drawable getRightIc() {
        return getRightIcon().getDrawable();
    }

    private final void setRightIc(Drawable r3) {
        getRightIcon().setImageDrawable(r3);
        ImageView r4 = getRightIcon();
        o.c(r4, "rightIcon");
        k.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        invalidate();
    }

    public final boolean getTextRolling() {
        if (getTipsTv().isSelected() == true) goto L5;
    L7:
        return false;
    L5:
        if (getTipsLine() != 1) goto L7;
        return true;
    }

    public final void setTextRolling(boolean r4) {
        getTipsTv().setSelected(r4);
        if (r4 == false) goto L5;
        getTipsTv().setMovementMethod(null);
        String r5 = getTipsText();
        getTipsTv().setText(null);
        getTipsTv().setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        setTipsLine(1);
        getTipsTv().setMarqueeRepeatLimit(-1);
        getTipsTv().setEllipsize(TextUtils.TruncateAt.MARQUEE);
    L6:
        invalidate();
        return;
    L5:
        getTipsTv().setEllipsize(TextUtils.TruncateAt.END);
        goto L6
    }

    public static /* synthetic */ void setRightIconRes$default(OTips r0, int r1, ColorStateList r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setRightIconRes(r1, r2);
    }

    public final void setRightIconRes(int r2, ColorStateList r3) {
        ImageView r0 = getRightIcon();
        if (r0 == null) goto L19;
        r0.setImageResource(r2);
        if (r3 == null) goto L12;
        Drawable r1 = r0.getDrawable();
        if (r1 == null) goto L17;
        r1.setTintList(r3);
    L17:
        k.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        r0.invalidate();
        return;
    L12:
        if (this.rightIconTint == null) goto L17;
        Drawable r4 = r0.getDrawable();
        if (r4 == null) goto L17;
        r4.setTintList(this.rightIconTint);
        goto L17
    }

    public static /* synthetic */ void setLeftIconRes$default(OTips r0, int r1, ColorStateList r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setLeftIconRes(r1, r2);
    }

    public final void setLeftIconRes(int r2, ColorStateList r3) {
        ImageView r0 = getLeftIcon();
        if (r0 == null) goto L19;
        r0.setImageResource(r2);
        if (r3 == null) goto L12;
        Drawable r1 = r0.getDrawable();
        if (r1 == null) goto L17;
        r1.setTintList(r3);
    L17:
        k.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        r0.invalidate();
        return;
    L12:
        if (this.leftIconTint == null) goto L17;
        Drawable r4 = r0.getDrawable();
        if (r4 == null) goto L17;
        r4.setTintList(this.leftIconTint);
        goto L17
    }

    /* JADX INFO: renamed from: setRightIconOnClickListener$lambda-2, reason: not valid java name */
    private static final void m1204setRightIconOnClickListener$lambda2(d.h.a.a r1, View r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "$clickAction");
        r3.invoke();
    }

    public final void setRightIconOnClickListener(d.h.a.a<x> r3) {
        final d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "clickAction");
        ImageView r2 = getRightIcon();
        if (r2 == null) goto L7;
        r2.setOnClickListener(new $$Lambda$OTips$kLWT0nrKIeSSzyt2Xlx2R6OVQG8(r4));
        return;
    }

    /* JADX INFO: renamed from: setLeftIconOnClickListener$lambda-3, reason: not valid java name */
    private static final void m1203setLeftIconOnClickListener$lambda3(d.h.a.a r1, View r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "$clickAction");
        r3.invoke();
    }

    public final void setLeftIconOnClickListener(d.h.a.a<x> r3) {
        final d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "clickAction");
        ImageView r2 = getLeftIcon();
        if (r2 == null) goto L7;
        r2.setOnClickListener(new $$Lambda$OTips$BKb7Nspkn2g4NdQvH83T5cMI0Og(r4));
        return;
    }
}
