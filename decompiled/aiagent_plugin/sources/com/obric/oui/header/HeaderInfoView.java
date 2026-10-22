package com.obric.oui.header;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class HeaderInfoView extends LinearLayout {
    private static final int DEFAULT_BOTTOM_PADDING_DP = 24;
    private static final int DEFAULT_TOP_PADDING_DP = 96;
    private static final int[] PADDING_ATTRS = null;
    private FrameLayout customContentContainer;
    private OImageAppIcon iconView;
    private OTextView subtitleView;
    private OTextView titleView;

    static {
        PADDING_ATTRS = new int[]{R.attr.padding, R.attr.paddingTop, R.attr.paddingBottom};
    }

    public HeaderInfoView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public HeaderInfoView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public HeaderInfoView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        init(r6, r7);
    }

    private void init(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.layout.header_info_view_layout, "layout", "header_info_view_layout"), this, true, "com.obric.aiagent.plugin");
        setGravity(1);
        setOrientation(1);
        initViews();
        applyDefaultPadding(r8);
        initAttrs(r8);
    }

    private void initViews() {
        this.iconView = (OImageAppIcon) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.header_info_icon, DbHelper.COL_ID, "header_info_icon")), OImageAppIcon.class, "com.obric.aiagent.plugin");
        this.titleView = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.header_info_title, DbHelper.COL_ID, "header_info_title")), OTextView.class, "com.obric.aiagent.plugin");
        this.subtitleView = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.header_info_subtitle, DbHelper.COL_ID, "header_info_subtitle")), OTextView.class, "com.obric.aiagent.plugin");
        this.customContentContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.header_info_custom_content_container, DbHelper.COL_ID, "header_info_custom_content_container")), FrameLayout.class, "com.obric.aiagent.plugin");
    }

    private void applyDefaultPadding(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r6, PADDING_ATTRS);
        boolean r0 = r7.hasValue(0);     // Catch: Throwable -> L19
        if (r0 == false) goto L6;
    L9:
        int r1 = getPaddingTop();     // Catch: Throwable -> L19
    L10:
        if (r0 == false) goto L12;
    L15:
        int r2 = getPaddingBottom();     // Catch: Throwable -> L19
    L16:
        setPadding(getPaddingLeft(), r1, getPaddingRight(), r2);     // Catch: Throwable -> L19
        r7.recycle();
        return;
    L12:
        if (r7.hasValue(2) == true) goto L15;
        r2 = dpToPx(24);     // Catch: Throwable -> L19
        goto L16
    L6:
        if (r7.hasValue(1) == true) goto L9;
        r1 = dpToPx(DEFAULT_TOP_PADDING_DP);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    private int dpToPx(int r2) {
        return (int) TypedValue.applyDimension(1, r2, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics());
    }

    private void initAttrs(AttributeSet r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r11, com.obric.aiagent.plugin.R.styleable.HeaderInfoView, 0, 0);
    L20:
        th = move-exception;
        r12.recycle();
        throw th;
    L4:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_icon, "styleable", "HeaderInfoView_oui_headerInfo_icon")) == false) goto L7;
        setIcon(r12.getDrawable(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_icon, "styleable", "HeaderInfoView_oui_headerInfo_icon")));     // Catch: Throwable -> L20
    L7:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_title, "styleable", "HeaderInfoView_oui_headerInfo_title")) == false) goto L10;
        setTitle(r12.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_title, "styleable", "HeaderInfoView_oui_headerInfo_title")));     // Catch: Throwable -> L20
    L10:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_titleColor, "styleable", "HeaderInfoView_oui_headerInfo_titleColor")) == false) goto L13;
        setTitleColor(r12.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_titleColor, "styleable", "HeaderInfoView_oui_headerInfo_titleColor"), this.titleView.getCurrentTextColor()));     // Catch: Throwable -> L20
    L13:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_subtitle, "styleable", "HeaderInfoView_oui_headerInfo_subtitle")) == false) goto L16;
        setSubtitle(r12.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_subtitle, "styleable", "HeaderInfoView_oui_headerInfo_subtitle")));     // Catch: Throwable -> L20
    L16:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_subtitleColor, "styleable", "HeaderInfoView_oui_headerInfo_subtitleColor")) == false) goto L18;
        setSubtitleColor(r12.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.HeaderInfoView_oui_headerInfo_subtitleColor, "styleable", "HeaderInfoView_oui_headerInfo_subtitleColor"), this.subtitleView.getCurrentTextColor()));     // Catch: Throwable -> L20
    L18:
        r12.recycle();
    }

    public OImageAppIcon getIconView() {
        return this.iconView;
    }

    public void setIcon(int r2) {
        this.iconView.setImageResource(r2);
        OImageAppIcon r1 = this.iconView;
        if (r2 != 0) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setIcon(Drawable r2) {
        this.iconView.setImageDrawable(r2);
        OImageAppIcon r1 = this.iconView;
        if (r2 != null) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setImagePackageName(String r3) {
        if (r3 != null) goto L4;
    L8:
        setIcon((Drawable) ZeusTransformUtils.preCheckCast(null, Drawable.class, "com.obric.aiagent.plugin"));
        return;
    L4:
        if (r3.trim().isEmpty() == true) goto L8;
        this.iconView.setImagePackageName(r3);
        this.iconView.setVisibility(0);
    }

    public OTextView getTitleView() {
        return this.titleView;
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.titleView.setText(r4);
        OTextView r2 = this.titleView;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        int r5 = 8;
    L6:
        r2.setVisibility(r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public void setTitleColor(int r1) {
        this.titleView.setTextColor(r1);
    }

    public OTextView getSubtitleView() {
        return this.subtitleView;
    }

    public void setSubtitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.subtitleView.setText(r4);
        OTextView r2 = this.subtitleView;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        int r5 = 8;
    L6:
        r2.setVisibility(r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public void setSubtitleColor(int r1) {
        this.subtitleView.setTextColor(r1);
    }

    public FrameLayout getCustomContentContainer() {
        return this.customContentContainer;
    }

    public void addCustomContentView(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.customContentContainer.addView(r2);
        updateCustomContentContainerVisibility();
    }

    private void updateCustomContentContainerVisibility() {
        FrameLayout r1 = this.customContentContainer;
        if (r1.getChildCount() <= 0) goto L5;
        int r0 = 0;
    L6:
        r1.setVisibility(r0);
        return;
    L5:
        r0 = 8;
        goto L6
    }
}
