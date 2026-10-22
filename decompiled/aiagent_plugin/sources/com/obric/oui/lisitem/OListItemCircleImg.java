package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OIconButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OListItemCircleImg.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OListItemCircleImg extends OListItemGeneral {
    private Drawable circleImage;
    private OIconButton contentImgCircle;
    private Drawable iconImage;
    private ImageView ivIcon;
    private final SettingsTrailingView settingsTrailingView;
    private String trailingTextString;

    public /* synthetic */ OListItemCircleImg(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OListItemCircleImg(Context r9, AttributeSet r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        super(r11, r12);
        this.settingsTrailingView = new SettingsTrailingView(r11, null, 0, 6, null);
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.contentImgCircle, DbHelper.COL_ID, "contentImgCircle"));
        o.c(r0, "findViewById(R.id.contentImgCircle)");
        this.contentImgCircle = (OIconButton) ZeusTransformUtils.preCheckCast(r0, OIconButton.class, "com.obric.aiagent.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, DbHelper.COL_ID, "iv_icon"));
        o.c(r1, "findViewById(R.id.iv_icon)");
        this.ivIcon = (ImageView) ZeusTransformUtils.preCheckCast(r1, ImageView.class, "com.obric.aiagent.plugin");
        TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.OListItemGeneral);
        setTrailingTextString(r13.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_trailing_text, "styleable", "OListItemGeneral_oui_list_item_trailing_text")));
        r13.recycle();
        if (this.circleImage == null) goto L5;
        this.contentImgCircle.setVisibility(0);
        getMContentElement().setVisibility(0);
        return;
    L5:
        this.contentImgCircle.setVisibility(8);
        getMContentElement().setVisibility(8);
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.settingsTrailingView;
    }

    public final OIconButton getContentImgCircle() {
        return this.contentImgCircle;
    }

    public final void setContentImgCircle(OIconButton r2) {
        o.e(r2, "<set-?>");
        this.contentImgCircle = r2;
    }

    public final ImageView getIvIcon() {
        return this.ivIcon;
    }

    public final void setIvIcon(ImageView r2) {
        o.e(r2, "<set-?>");
        this.ivIcon = r2;
    }

    public final String getTrailingTextString() {
        return this.trailingTextString;
    }

    public final void setTrailingTextString(String r3) {
        this.trailingTextString = r3;
        updateState();
        String r4 = this.trailingTextString;
        if (r4 == null) goto L6;
        setTrailingText(r4);
    L6:
        setTrailingView((View) ZeusTransformUtils.preCheckCast(this.settingsTrailingView, View.class, "com.obric.aiagent.plugin"));
    }

    public final Drawable getCircleImage() {
        return this.circleImage;
    }

    public final void setCircleImage(Drawable r2) {
        this.circleImage = r2;
        if (r2 == null) goto L5;
        this.contentImgCircle.setImageDrawable(r2);
        this.contentImgCircle.setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        updateState();
        return;
    L5:
        this.contentImgCircle.setVisibility(8);
        getMContentElement().setVisibility(8);
        goto L6
    }

    public final Drawable getIconImage() {
        return this.iconImage;
    }

    public final void setIconImage(Drawable r2) {
        this.iconImage = r2;
        if (r2 == null) goto L5;
        this.ivIcon.setImageDrawable(r2);
        this.ivIcon.setVisibility(0);
    L6:
        updateState();
        return;
    L5:
        this.ivIcon.setVisibility(8);
        goto L6
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void inflateContent() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_circle_img, "layout", "o_listitem_circle_img"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public final void setTrailingText(String r2) {
        o.e(r2, "text");
        this.settingsTrailingView.setTrailingText(r2);
    }

    public final void setImageView(Drawable r1) {
        this.settingsTrailingView.setTrailingImage(r1);
    }

    public final void showTrailingImageView(Drawable r3) {
        if (r3 != null) goto L4;
        this.settingsTrailingView.showTrailingImageView(false);
        return;
    L4:
        this.settingsTrailingView.showTrailingImageView(true);
        this.settingsTrailingView.setTrailingImage(r3);
    }

    public static /* synthetic */ void setTrailingTextMaxLines$default(OListItemCircleImg r0, int r1, TextUtils.TruncateAt r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = TextUtils.TruncateAt.END;
    L6:
        r0.setTrailingTextMaxLines(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTrailingTextMaxLines");
    }

    public final void setTrailingTextMaxLines(int r2, TextUtils.TruncateAt r3) {
        o.e(r3, "ellipsize");
        this.settingsTrailingView.getTextView().setMaxLines(r2);
        this.settingsTrailingView.getTextView().setEllipsize(r3);
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
