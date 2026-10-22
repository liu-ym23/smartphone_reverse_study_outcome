package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.common.widget.ClickEffectTouchListener;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ONormalTitleBar extends OTitleBar implements View.OnClickListener {
    private ImageView mEndBtn;
    private View mLine;
    private com.obric.oui.titlebar.a.a mOnTitleBarClickListener;
    private ImageView mStartBtn;
    private TextView mStartText;

    public ONormalTitleBar(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public ONormalTitleBar(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public ONormalTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        init(r6);
        if (r7 == null) goto L6;
        initAttrs(r6, r7);
        return;
    }

    private void initAttrs(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        TypedArray r11 = r10.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.ONormalTitleBar);
        String r0 = r11.getString(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_centerText, "styleable", "ONormalTitleBar_oui_centerText"));
        float r2 = r11.getDimension(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_centerTextSize, "styleable", "ONormalTitleBar_oui_centerTextSize"), g.a(17));
        int r3 = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_centerTextColor, "styleable", "ONormalTitleBar_oui_centerTextColor"), androidx.core.content.a.c(r10, ZeusTransformUtils.mapRes(R.color.TextPrimary, "color", "TextPrimary")));
        this.mTitleView.setText(r0);
        int r4 = 0;
        this.mTitleView.setTextSize(0, r2);
        this.mTitleView.setTextColor(r3);
        Drawable r1 = r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_rightDrawable, "styleable", "ONormalTitleBar_oui_rightDrawable"));
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_rightDrawableTint, "styleable", "ONormalTitleBar_oui_rightDrawableTint")) == false) goto L6;
        if (r1 == null) goto L6;
        int r5 = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_rightDrawableTint, "styleable", "ONormalTitleBar_oui_rightDrawableTint"), 0);
        r1 = r1.mutate();
        androidx.core.graphics.drawable.a.a(r1, r5);
    L6:
        if (r1 == null) goto L8;
        this.mEndBtn.setImageDrawable(r1);
    L8:
        boolean r6 = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_dividerVisible, "styleable", "ONormalTitleBar_oui_dividerVisible"), true);
        View r7 = this.mLine;
        if (r6 == true) goto L12;
        r4 = 8;
    L12:
        r7.setVisibility(r4);
        this.mLine.setBackgroundColor(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_dividerColor, "styleable", "ONormalTitleBar_oui_dividerColor"), androidx.core.content.a.c(r10, ZeusTransformUtils.mapRes(R.color.LinePrimary, "color", "LinePrimary"))));
        r11.recycle();
    }

    private void init(Context r5) {
        inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_normal_title_bar, "layout", "o_view_normal_title_bar"), this);
        this.mStartBtn = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.back_btn, DbHelper.COL_ID, "back_btn")), ImageView.class, "com.obric.aiagent.plugin");
        this.mTitleView = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE)), TextView.class, "com.obric.aiagent.plugin");
        this.mEndBtn = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.right_btn, DbHelper.COL_ID, "right_btn")), ImageView.class, "com.obric.aiagent.plugin");
        this.mLine = findViewById(ZeusTransformUtils.mapRes(R.id.line, DbHelper.COL_ID, "line"));
        this.mStartText = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.text_left, DbHelper.COL_ID, "text_left")), TextView.class, "com.obric.aiagent.plugin");
        this.mStartBtn.setOnClickListener(this);
        this.mEndBtn.setOnClickListener(this);
        this.mStartText.setOnClickListener(this);
        ClickEffectTouchListener r6 = new ClickEffectTouchListener(0.5f, 1.0f);
        this.mStartBtn.setOnTouchListener(r6);
        this.mEndBtn.setOnTouchListener(r6);
        this.mStartText.setOnTouchListener(r6);
    }

    public void setStartBtnIcon(int r1) {
        this.mStartBtn.setImageResource(r1);
    }

    public void setEndBtnIcon(int r1) {
        this.mEndBtn.setImageResource(r1);
    }

    public void setOnTitleBarClickListener(com.obric.oui.titlebar.a.a r3) {
        this.mOnTitleBarClickListener = (com.obric.oui.titlebar.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.titlebar.a.a.class, "com.obric.aiagent.plugin");
    }

    public void setStartText(String r3) {
        this.mStartBtn.setVisibility(8);
        this.mStartText.setVisibility(0);
        this.mStartText.setText(r3);
    }

    public void setStartTextSize(float r2) {
        this.mStartText.setTextSize(0, r2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (this.mOnTitleBarClickListener != null) goto L5;
        return;
    L5:
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.back_btn, DbHelper.COL_ID, "back_btn")) goto L7;
    L12:
        this.mOnTitleBarClickListener.a(r5);
        return;
    L7:
        if (r5.getId() == ZeusTransformUtils.mapRes(R.id.text_left, DbHelper.COL_ID, "text_left")) goto L12;
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.right_btn, DbHelper.COL_ID, "right_btn")) goto L15;
        this.mOnTitleBarClickListener.b(r5);
        return;
    }

    public ImageView getStartBtn() {
        return this.mStartBtn;
    }

    public ImageView getEndBtn() {
        return this.mEndBtn;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void showDividerLine(boolean r1) {
        View r0 = this.mLine;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        this.mLine.setBackgroundColor(r1);
    }

    public void setDividerHeight(int r2) {
        ViewGroup.LayoutParams r0 = this.mLine.getLayoutParams();
        r0.height = r2;
        this.mLine.setLayoutParams(r0);
    }

    public void setCenterText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mTitleView.setText(r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        k.a(getStartBtn(), g.a(44), g.a(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        k.a(getEndBtn(), g.a(44), g.a(44), false);
        return;
    }
}
