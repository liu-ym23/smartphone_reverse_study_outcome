package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OCompoundTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OCompoundTitleBar extends OTitleBar {
    private int mEnd0Color;
    private int mEnd1Color;
    private ImageView mEndButton0;
    private ImageView mEndButton1;
    private View mLine;
    public FrameLayout mRightAction;
    private int mStart0Color;
    private int mStart1Color;
    private ImageView mStartButton0;
    private ImageView mStartButton1;

    public OCompoundTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCompoundTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OCompoundTitleBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OCompoundTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        init(r6);
        if (r7 == null) goto L6;
        initAttrs(r7);
        return;
    }

    public final FrameLayout getMRightAction() {
        FrameLayout r0 = this.mRightAction;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mRightAction");
        return null;
    }

    public final void setMRightAction(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.mRightAction = r2;
    }

    public final ImageView getStartButton0() {
        return this.mStartButton0;
    }

    public final ImageView getStartButton1() {
        return this.mStartButton1;
    }

    public final ImageView getEndButton0() {
        return this.mEndButton0;
    }

    public final ImageView getEndButton1() {
        return this.mEndButton1;
    }

    public final View getDivider() {
        return this.mLine;
    }

    private final void init(Context r5) {
        OTitleBar.inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_compound_title_bar, "layout", "o_view_compound_title_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        this.mStartButton0 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_start_0, DbHelper.COL_ID, "iv_start_0")), ImageView.class, "com.obric.aiagent.plugin");
        this.mStartButton1 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_start_1, DbHelper.COL_ID, "iv_start_1")), ImageView.class, "com.obric.aiagent.plugin");
        this.mEndButton0 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_end_0, DbHelper.COL_ID, "iv_end_0")), ImageView.class, "com.obric.aiagent.plugin");
        this.mEndButton1 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_end_1, DbHelper.COL_ID, "iv_end_1")), ImageView.class, "com.obric.aiagent.plugin");
        this.mTitleView = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE)), TextView.class, "com.obric.aiagent.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_right_container, DbHelper.COL_ID, "fl_right_container"));
        o.c(r6, "findViewById(R.id.fl_right_container)");
        setMRightAction((FrameLayout) ZeusTransformUtils.preCheckCast(r6, FrameLayout.class, "com.obric.aiagent.plugin"));
        this.mLine = findViewById(ZeusTransformUtils.mapRes(R.id.line, DbHelper.COL_ID, "line"));
    }

    private final void initAttrs(AttributeSet r9) {
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.OCompoundTitleBar, 0, 0);
        setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r10.getString(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_centerText, "styleable", "OCompoundTitleBar_oui_centerText")), CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L6
        setTitleColor(r10.getColor(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_centerTextColor, "styleable", "OCompoundTitleBar_oui_centerTextColor"), androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"))));     // Catch: Throwable -> L6
        setTitleSizePixel(r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_centerTextSize, "styleable", "OCompoundTitleBar_oui_centerTextSize"), g.a(17)));     // Catch: Throwable -> L6
        int r0 = r10.getColor(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_dividerColor, "styleable", "OCompoundTitleBar_oui_dividerColor"), androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_4, "color", "oui_basic_text_4")));     // Catch: Throwable -> L6
        showDividerLine(r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_dividerVisible, "styleable", "OCompoundTitleBar_oui_dividerVisible"), false));     // Catch: Throwable -> L6
        setDividerLineBackground(r0);     // Catch: Throwable -> L6
        r10.recycle();
        return;
    L6:
        th = move-exception;
        r10.recycle();
        throw th;
    }

    public final int getMStart0Color() {
        return this.mStart0Color;
    }

    public final void setMStart0Color(int r1) {
        this.mStart0Color = r1;
    }

    public final int getMStart1Color() {
        return this.mStart1Color;
    }

    public final void setMStart1Color(int r1) {
        this.mStart1Color = r1;
    }

    public final int getMEnd0Color() {
        return this.mEnd0Color;
    }

    public final void setMEnd0Color(int r1) {
        this.mEnd0Color = r1;
    }

    public final int getMEnd1Color() {
        return this.mEnd1Color;
    }

    public final void setMEnd1Color(int r1) {
        this.mEnd1Color = r1;
    }

    public final void setTint(int r2, int r3, int r4, int r5) {
        this.mStart0Color = r2;
        this.mStart1Color = r3;
        this.mEnd0Color = r4;
        this.mEnd1Color = r5;
        ImageView r0 = this.mStartButton0;
        if (r0 == null) goto L6;
        r0.setColorFilter(r2);
    L6:
        ImageView r6 = this.mStartButton1;
        if (r6 == null) goto L10;
        r6.setColorFilter(r3);
    L10:
        ImageView r7 = this.mEndButton0;
        if (r7 == null) goto L14;
        r7.setColorFilter(r4);
    L14:
        ImageView r1 = this.mEndButton1;
        if (r1 == null) goto L19;
        r1.setColorFilter(r5);
        return;
    }

    public final void setDrawables(int r5, int r6, int r7, int r8) {
        Drawable r0 = null;
        if (r5 == 0) goto L5;
        Drawable r9 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    L6:
        if (r6 == 0) goto L8;
        Drawable r10 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
    L9:
        if (r7 == 0) goto L11;
        Drawable r11 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7);
    L12:
        if (r8 == 0) goto L14;
        r0 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8);
    L14:
        setDrawables(r9, r10, r11, r0);
        return;
    L11:
        r11 = null;
        goto L12
    L8:
        r10 = null;
        goto L9
    L5:
        r9 = null;
        goto L6
    }

    public final void setDrawables(Drawable r5, Drawable r6, Drawable r7, Drawable r8) {
        if (r5 != null) goto L12;
        ImageView r3 = this.mStartButton0;
        if (r3 == null) goto L8;
        r3.setVisibility(4);
    L8:
        ImageView r4 = this.mStartButton0;
        if (r4 == null) goto L16;
        r4.setOnClickListener(null);
    L16:
        ImageView r9 = this.mStartButton0;
        if (r9 == null) goto L20;
        r9.setImageDrawable(r5);
    L20:
        if (r6 != null) goto L29;
        ImageView r10 = this.mStartButton1;
        if (r10 == null) goto L25;
        r10.setVisibility(4);
    L25:
        ImageView r11 = this.mStartButton1;
        if (r11 == null) goto L33;
        r11.setOnClickListener(null);
    L33:
        ImageView r12 = this.mStartButton1;
        if (r12 == null) goto L37;
        r12.setImageDrawable(r6);
    L37:
        if (r7 != null) goto L46;
        ImageView r13 = this.mEndButton0;
        if (r13 == null) goto L42;
        r13.setVisibility(4);
    L42:
        ImageView r14 = this.mEndButton0;
        if (r14 == null) goto L50;
        r14.setOnClickListener(null);
    L50:
        ImageView r15 = this.mEndButton0;
        if (r15 == null) goto L54;
        r15.setImageDrawable(r7);
    L54:
        if (r8 != null) goto L63;
        ImageView r16 = this.mEndButton1;
        if (r16 == null) goto L59;
        r16.setVisibility(4);
    L59:
        ImageView r17 = this.mEndButton1;
        if (r17 == null) goto L67;
        r17.setOnClickListener(null);
    L67:
        ImageView r18 = this.mEndButton1;
        if (r18 == null) goto L72;
        r18.setImageDrawable(r8);
        return;
    L72:
        return;
    L63:
        ImageView r19 = this.mEndButton1;
        if (r19 == null) goto L67;
        r19.setVisibility(0);
        goto L67
    L46:
        ImageView r20 = this.mEndButton0;
        if (r20 == null) goto L50;
        r20.setVisibility(0);
        goto L50
    L29:
        ImageView r21 = this.mStartButton1;
        if (r21 == null) goto L33;
        r21.setVisibility(0);
        goto L33
    L12:
        ImageView r22 = this.mStartButton0;
        if (r22 == null) goto L16;
        r22.setVisibility(0);
        goto L16
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void showDividerLine(boolean r1) {
        View r0 = this.mLine;
        if (r0 == null) goto L10;
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        View r0 = this.mLine;
        if (r0 == null) goto L7;
        r0.setBackgroundColor(r1);
        return;
    }
}
