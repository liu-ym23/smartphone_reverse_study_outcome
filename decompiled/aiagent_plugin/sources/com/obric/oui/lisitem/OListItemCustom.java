package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OListItemCustom.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OListItemCustom extends OListItemGeneral {
    public OUIFrameLayout contentImgBackground;
    public FrameLayout mTitleInfo;
    public ImageView trailingImageView;
    public OTextView trailingText;
    private String trailingTextString;

    public /* synthetic */ OListItemCustom(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OListItemCustom(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8);
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.title_info, DbHelper.COL_ID, "title_info"));
        o.c(r0, "findViewById(R.id.title_info)");
        setMTitleInfo((FrameLayout) ZeusTransformUtils.preCheckCast(r0, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_content_img_background, DbHelper.COL_ID, "iv_content_img_background"));
        o.c(r1, "findViewById(R.id.iv_content_img_background)");
        setContentImgBackground((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r1, OUIFrameLayout.class, "com.obric.aiagent.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.trailingText, DbHelper.COL_ID, "trailingText"));
        o.c(r2, "findViewById(R.id.trailingText)");
        setTrailingText((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin"));
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.trailingImage, DbHelper.COL_ID, "trailingImage"));
        o.c(r3, "findViewById(R.id.trailingImage)");
        setTrailingImageView((ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.aiagent.plugin"));
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.OListItemGeneral);
        setTrailingTextString(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_trailing_text, "styleable", "OListItemGeneral_oui_list_item_trailing_text")));
        r9.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r0 = this.mTitleInfo;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mTitleInfo");
        return null;
    }

    public final void setMTitleInfo(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.mTitleInfo = r2;
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r0 = this.contentImgBackground;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("contentImgBackground");
        return null;
    }

    public final void setContentImgBackground(OUIFrameLayout r2) {
        o.e(r2, "<set-?>");
        this.contentImgBackground = r2;
    }

    public final OTextView getTrailingText() {
        OTextView r0 = this.trailingText;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("trailingText");
        return null;
    }

    public final void setTrailingText(OTextView r2) {
        o.e(r2, "<set-?>");
        this.trailingText = r2;
    }

    public final ImageView getTrailingImageView() {
        ImageView r0 = this.trailingImageView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("trailingImageView");
        return null;
    }

    public final void setTrailingImageView(ImageView r2) {
        o.e(r2, "<set-?>");
        this.trailingImageView = r2;
    }

    public final String getTrailingTextString() {
        return this.trailingTextString;
    }

    public final void setTrailingTextString(String r1) {
        this.trailingTextString = r1;
        updateState();
        String r2 = this.trailingTextString;
        if (r2 == null) goto L7;
        setTrailingText(r2);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void inflateContent() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_custom_trailing, "layout", "o_listitem_custom_trailing"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public final void setTrailingText(String r3) {
        o.e(r3, "text");
        getTrailingText().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final void setImageView(Drawable r1) {
        getTrailingImageView().setImageDrawable(r1);
    }

    public final void setListItemSettingsEnabled(boolean r2) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r2);
        if (r2 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return d.i.a.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_large, "dimen", "oui_listitem_content_width_large")));
    }
}
