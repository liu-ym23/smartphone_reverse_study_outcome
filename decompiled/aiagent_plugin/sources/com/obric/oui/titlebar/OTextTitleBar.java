package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.common.widget.ClickEffectTouchListener;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class OTextTitleBar extends OTitleBar implements View.OnClickListener {
    public static final int END_BUTTON_TYPE_ACTION = 1;
    public static final int END_BUTTON_TYPE_NORMAL = 0;
    private int endButtonType;
    private ImageView mBackBtn;
    private TextView mEndText;
    private View mLine;
    private com.obric.oui.titlebar.a.a mOnTitleBarClickListener;
    private TextView mStartText;
    private boolean mUseBackIcon;
    private boolean mUseCloseIcon;

    public OTextTitleBar(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public OTextTitleBar(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public OTextTitleBar(Context r3, AttributeSet r4, int r5) {
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
        TypedArray r15 = r14.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.OTextTitleBar);
        String r0 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_centerText, "styleable", "OTextTitleBar_oui_centerText"));
        float r2 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_centerTextSize, "styleable", "OTextTitleBar_oui_centerTextSize"), g.a(17));
        int r3 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_centerTextColor, "styleable", "OTextTitleBar_oui_centerTextColor"), androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, "color", "TextPrimary")));
        this.mTitleView.setText(r0);
        this.mTitleView.setTextSize(0, r2);
        this.mTitleView.setTextColor(r3);
        this.mUseBackIcon = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_useBackIcon, "styleable", "OTextTitleBar_oui_useBackIcon"), false);
        boolean r1 = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_useCloseIcon, "styleable", "OTextTitleBar_oui_useCloseIcon"), false);
        this.mUseCloseIcon = r1;
        if (this.mUseBackIcon == false) goto L5;
        this.mBackBtn.setVisibility(0);
        this.mStartText.setVisibility(8);
        this.mBackBtn.setContentDescription(r14.getString(ZeusTransformUtils.mapRes(R.string.oui_iv_back_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_iv_back_desc")));
    L8:
        int r4 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightButtonType, "styleable", "OTextTitleBar_oui_rightButtonType"), 1);
        this.endButtonType = r4;
        if (r4 != 1) goto L11;
        this.mEndText.setTextColor(androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.Primary, "color", "Primary")));
    L12:
        String r5 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightButtonText, "styleable", "OTextTitleBar_oui_rightButtonText"));
        float r6 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightTextSize, "styleable", "OTextTitleBar_oui_rightTextSize"), g.a(15));
        int r7 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightTextColor, "styleable", "OTextTitleBar_oui_rightTextColor"), androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, "color", "TextPrimary")));
        int r8 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightTextVisible, "styleable", "OTextTitleBar_oui_rightTextVisible"), 0);
        this.mEndText.setText(r5);
        this.mEndText.setTextSize(0, r6);
        if (r15.hasValue(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightTextColor, "styleable", "OTextTitleBar_oui_rightTextColor")) == false) goto L15;
        this.mEndText.setTextColor(r7);
    L15:
        this.mEndText.setVisibility(r8);
        this.mLine.setVisibility(r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_dividerVisible, "styleable", "OTextTitleBar_oui_dividerVisible"), 0));
        this.mLine.setBackgroundColor(r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_dividerColor, "styleable", "OTextTitleBar_oui_dividerColor"), androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.LinePrimary, "color", "LinePrimary"))));
        r15.recycle();
        return;
    L11:
        this.mEndText.setTextColor(androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, "color", "TextPrimary")));
        goto L12
    L5:
        if (r1 == false) goto L7;
        this.mBackBtn.setVisibility(0);
        this.mBackBtn.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_ic_titlebar_close, "drawable", "o_ic_titlebar_close"));
        this.mStartText.setVisibility(8);
        this.mBackBtn.setContentDescription(r14.getString(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_iv_close_desc")));
        goto L8
    L7:
        String r9 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_leftButtonText, "styleable", "OTextTitleBar_oui_leftButtonText"));
        float r10 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_leftTextSize, "styleable", "OTextTitleBar_oui_leftTextSize"), g.a(15));
        int r11 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_leftTextColor, "styleable", "OTextTitleBar_oui_leftTextColor"), androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, "color", "TextPrimary")));
        this.mBackBtn.setVisibility(8);
        this.mStartText.setVisibility(0);
        this.mStartText.setText(r9);
        this.mStartText.setTextSize(0, r10);
        this.mStartText.setTextColor(r11);
        goto L8
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r0 = g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        int r1 = ((r0 / 2) - Math.max(this.mStartText.getMeasuredWidth(), this.mEndText.getMeasuredWidth())) * 2;
        this.mTitleView.setMaxWidth(Math.max(r1, g.a(112)));
    }

    private void init(Context r5) {
        inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_text_title_bar, "layout", "o_view_text_title_bar"), this);
        this.mStartText = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.text_left, DbHelper.COL_ID, "text_left")), TextView.class, "com.obric.aiagent.plugin");
        this.mTitleView = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE)), TextView.class, "com.obric.aiagent.plugin");
        this.mEndText = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.text_right, DbHelper.COL_ID, "text_right")), TextView.class, "com.obric.aiagent.plugin");
        this.mBackBtn = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.back_btn, DbHelper.COL_ID, "back_btn")), ImageView.class, "com.obric.aiagent.plugin");
        this.mLine = findViewById(ZeusTransformUtils.mapRes(R.id.line, DbHelper.COL_ID, "line"));
        this.mBackBtn.setOnClickListener(this);
        this.mStartText.setOnClickListener(this);
        this.mEndText.setOnClickListener(this);
        ClickEffectTouchListener r6 = new ClickEffectTouchListener(0.5f, 1.0f);
        this.mBackBtn.setOnTouchListener(r6);
        this.mStartText.setOnTouchListener(r6);
        this.mEndText.setOnTouchListener(r6);
    }

    public void setStartText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mStartText.setText(r4);
    }

    public void setStartText(int r1) {
        this.mStartText.setText(r1);
    }

    public void setStartTextColor(int r1) {
        this.mStartText.setTextColor(r1);
    }

    public void setStartTextSize(float r1) {
        this.mStartText.setTextSize(r1);
    }

    public void setEndText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mEndText.setText(r4);
    }

    public void setEndText(int r1) {
        this.mEndText.setText(r1);
    }

    public void setEndTextColor(int r1) {
        this.mEndText.setTextColor(r1);
    }

    public void setEndTextSize(float r1) {
        this.mEndText.setTextSize(r1);
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
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.text_right, DbHelper.COL_ID, "text_right")) goto L15;
        this.mOnTitleBarClickListener.b(r5);
        return;
    }

    public void setOnTitleBarClickListener(com.obric.oui.titlebar.a.a r3) {
        this.mOnTitleBarClickListener = (com.obric.oui.titlebar.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.titlebar.a.a.class, "com.obric.aiagent.plugin");
    }

    public TextView getStartText() {
        return this.mStartText;
    }

    public TextView getEndText() {
        return this.mEndText;
    }

    public ImageView getBackBtn() {
        return this.mBackBtn;
    }

    public boolean isUseBackIcon() {
        return this.mUseBackIcon;
    }

    public boolean isUseCloseIcon() {
        return this.mUseCloseIcon;
    }

    public void setUseBackIcon(boolean r6) {
        if (this.mUseBackIcon == r6) goto L13;
        this.mUseBackIcon = r6;
        ImageView r0 = this.mBackBtn;
        int r1 = 0;
        if (r6 == false) goto L7;
        int r7 = 0;
    L8:
        r0.setVisibility(r7);
        this.mBackBtn.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_ic_titlebar_back, "drawable", "o_ic_titlebar_back"));
        TextView r8 = this.mStartText;
        if (this.mUseBackIcon == false) goto L11;
        r1 = 8;
    L11:
        r8.setVisibility(r1);
        this.mBackBtn.setContentDescription(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oui_iv_back_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_iv_back_desc")));
        return;
    L7:
        r7 = 8;
        goto L8
    }

    public void setUseCloseIcon(boolean r6) {
        if (this.mUseCloseIcon == r6) goto L13;
        this.mUseCloseIcon = r6;
        ImageView r0 = this.mBackBtn;
        int r1 = 0;
        if (r6 == false) goto L7;
        int r7 = 0;
    L8:
        r0.setVisibility(r7);
        this.mBackBtn.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_ic_titlebar_close, "drawable", "o_ic_titlebar_close"));
        TextView r8 = this.mStartText;
        if (this.mUseCloseIcon == false) goto L11;
        r1 = 8;
    L11:
        r8.setVisibility(r1);
        this.mBackBtn.setContentDescription(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_iv_close_desc")));
        return;
    L7:
        r7 = 8;
        goto L8
    }

    public void showLine(boolean r1) {
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

    public void setLineBackground(int r1) {
        this.mLine.setBackgroundColor(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextView r0 = this.mStartText;
        if (r0 == null) goto L5;
        k.a(r0, g.a(44), g.a(44), false);
    L5:
        TextView r5 = this.mEndText;
        if (r5 == null) goto L9;
        k.a(r5, g.a(44), g.a(44), false);
        return;
    }

    public int getEndButtonType() {
        return this.endButtonType;
    }
}
