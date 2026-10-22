package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
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
public class OButtonTitleBar extends OTitleBar implements View.OnClickListener {
    private static final float DEFAULT_END_BUTTON_SIZE = 17.0f;
    public static final int END_BUTTON_TYPE_ACTION = 1;
    public static final int END_BUTTON_TYPE_NORMAL = 0;
    private int endButtonType;
    private TextView mEndBtn;
    private Drawable mEndButtonBackgroundDrawable;
    private View mLine;
    private int mLineColor;
    private com.obric.oui.titlebar.a.a mOnTitleBarClickListener;
    private ImageView mStartBtn;

    public OButtonTitleBar(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public OButtonTitleBar(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public OButtonTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.endButtonType = 0;
        init(r6);
        if (r7 == null) goto L6;
        initAttrs(r6, r7);
        return;
    }

    private void initAttrs(Context r12, AttributeSet r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        TypedArray r15 = r14.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.OButtonTitleBar);
        String r0 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_centerText, "styleable", "OButtonTitleBar_oui_centerText"));
        float r2 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_centerTextSize, "styleable", "OButtonTitleBar_oui_centerTextSize"), g.a(17));
        int r3 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_centerTextColor, "styleable", "OButtonTitleBar_oui_centerTextColor"), androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, "color", "TextPrimary")));
        this.mTitleView.setText(r0);
        int r4 = 0;
        this.mTitleView.setTextSize(0, r2);
        this.mTitleView.setTextColor(r3);
        String r1 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonText, "styleable", "OButtonTitleBar_oui_rightButtonText"));
        int r5 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonType, "styleable", "OButtonTitleBar_oui_rightButtonType"), 1);
        float r7 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonTextSize, "styleable", "OButtonTitleBar_oui_rightButtonTextSize"), g.a(DEFAULT_END_BUTTON_SIZE));
        int r8 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonTextColor, "styleable", "OButtonTitleBar_oui_rightButtonTextColor"), 0);
        this.mEndButtonBackgroundDrawable = r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonTextBackground, "styleable", "OButtonTitleBar_oui_rightButtonTextBackground"));
        int r9 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonVisible, "styleable", "OButtonTitleBar_oui_rightButtonVisible"), 0);
        this.mEndBtn.setText(r1);
        this.endButtonType = r5;
        if (r5 != 1) goto L5;
        this.mEndBtn.setTypeface(Typeface.defaultFromStyle(1));
        this.mEndBtn.setTextColor(androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.Primary, "color", "Primary")));
    L6:
        this.mEndBtn.setTextSize(0, r7);
        if (r8 == 0) goto L9;
        this.mEndBtn.setTextColor(r8);
    L9:
        Drawable r6 = this.mEndButtonBackgroundDrawable;
        if (r6 == null) goto L12;
        this.mEndBtn.setBackground(r6);
    L12:
        this.mEndBtn.setVisibility(r9);
        boolean r10 = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_dividerVisible, "styleable", "OButtonTitleBar_oui_dividerVisible"), false);
        View r11 = this.mLine;
        if (r10 == true) goto L16;
        r4 = 4;
    L16:
        r11.setVisibility(r4);
        int r16 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_dividerColor, "styleable", "OButtonTitleBar_oui_dividerColor"), androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.LinePrimary, "color", "LinePrimary")));
        this.mLineColor = r16;
        this.mLine.setBackgroundColor(r16);
        r15.recycle();
        return;
    L5:
        this.mEndBtn.setTypeface(Typeface.defaultFromStyle(0));
        this.mEndBtn.setTextColor(androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, "color", "TextPrimary")));
        goto L6
    }

    private void init(Context r5) {
        inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_button_title_bar, "layout", "o_view_button_title_bar"), this);
        this.mStartBtn = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.back_btn, DbHelper.COL_ID, "back_btn")), ImageView.class, "com.obric.aiagent.plugin");
        this.mTitleView = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE)), TextView.class, "com.obric.aiagent.plugin");
        this.mEndBtn = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.right_btn, DbHelper.COL_ID, "right_btn")), TextView.class, "com.obric.aiagent.plugin");
        this.mLine = findViewById(ZeusTransformUtils.mapRes(R.id.line, DbHelper.COL_ID, "line"));
        this.mStartBtn.setOnClickListener(this);
        this.mEndBtn.setOnClickListener(this);
        ClickEffectTouchListener r6 = new ClickEffectTouchListener(0.5f, 1.0f);
        this.mStartBtn.setOnTouchListener(r6);
        this.mEndBtn.setOnTouchListener(r6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (this.mOnTitleBarClickListener != null) goto L5;
        return;
    L5:
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.back_btn, DbHelper.COL_ID, "back_btn")) goto L8;
        this.mOnTitleBarClickListener.a(r5);
        return;
    L8:
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.right_btn, DbHelper.COL_ID, "right_btn")) goto L13;
        this.mOnTitleBarClickListener.b(r5);
        return;
    }

    public void setOnTitleBarClickListener(com.obric.oui.titlebar.a.a r3) {
        this.mOnTitleBarClickListener = (com.obric.oui.titlebar.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.titlebar.a.a.class, "com.obric.aiagent.plugin");
    }

    public TextView getEndBtn() {
        return this.mEndBtn;
    }

    public ImageView getStartBtn() {
        return this.mStartBtn;
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

    public int getEndButtonType() {
        return this.endButtonType;
    }
}
