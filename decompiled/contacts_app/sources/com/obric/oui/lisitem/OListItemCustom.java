package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.common.oui.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OListItemCustom.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,J\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/J\u000e\u0010\u001d\u001a\u00020)2\u0006\u00100\u001a\u00020 R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 @FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00061"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCustom;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentImgBackground", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "mTitleInfo", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "trailingImageView", "Landroid/widget/ImageView;", "getTrailingImageView", "()Landroid/widget/ImageView;", "setTrailingImageView", "(Landroid/widget/ImageView;)V", "trailingText", "Lcom/obric/oui/text/OTextView;", "getTrailingText", "()Lcom/obric/oui/text/OTextView;", "setTrailingText", "(Lcom/obric/oui/text/OTextView;)V", "value", "", "trailingTextString", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "getContentDefaultOneChildWidth", "", "inflateContent", "", "setImageView", "drawable", "Landroid/graphics/drawable/Drawable;", "setListItemSettingsEnabled", "enabled", "", "text", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCustom extends OListItemGeneral {
    public OUIFrameLayout contentImgBackground;
    public FrameLayout mTitleInfo;
    public ImageView trailingImageView;
    public OTextView trailingText;
    private String trailingTextString;

    public /* synthetic */ OListItemCustom(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OListItemCustom(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        View r0 = findViewById(R.id.title_info);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.title_info)");
        setMTitleInfo((FrameLayout) r0);
        View r1 = findViewById(R.id.iv_content_img_background);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.iv_content_img_background)");
        setContentImgBackground((OUIFrameLayout) r1);
        View r2 = findViewById(R.id.trailingText);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.trailingText)");
        setTrailingText((OTextView) r2);
        View r5 = findViewById(R.id.trailingImage);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.trailingImage)");
        setTrailingImageView((ImageView) r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.OListItemGeneral);
        setTrailingTextString(r6.getString(R.styleable.OListItemGeneral_oui_list_item_trailing_text));
        r6.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r0 = this.mTitleInfo;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
        return null;
    }

    public final void setMTitleInfo(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mTitleInfo = r2;
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r0 = this.contentImgBackground;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
        return null;
    }

    public final void setContentImgBackground(OUIFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentImgBackground = r2;
    }

    public final OTextView getTrailingText() {
        OTextView r0 = this.trailingText;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingText");
        return null;
    }

    public final void setTrailingText(OTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.trailingText = r2;
    }

    public final ImageView getTrailingImageView() {
        ImageView r0 = this.trailingImageView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingImageView");
        return null;
    }

    public final void setTrailingImageView(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
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
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_custom_trailing, this);
    }

    public final void setTrailingText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        getTrailingText().setText(r2);
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
        return MathKt.roundToInt(getResources().getDimension(R.dimen.oui_listitem_content_width_large));
    }
}
