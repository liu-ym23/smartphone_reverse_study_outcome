package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$styleable;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.tangram.style.BannerStyle;
import com.bytedanceos.common.utils.e;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.util.ImageUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BaseBannerView extends RelativeLayout {
    private static final int SHADOW_DELTA = 0;
    private static final int SHADOW_HEIGHT_LARGE_DELTA = 0;
    private static final int SHADOW_WIDTH_LARGE_DELTA = 0;
    public static final int STYLE_TYPE_DOUBLE_COLUMN = 5;
    public static final int STYLE_TYPE_IDLE = -1;
    public static final int STYLE_TYPE_LARGE = 1;
    public static final int STYLE_TYPE_ONE_PLUS_FOUR_CARD = 3;
    public static final int STYLE_TYPE_ONE_PLUS_FOUR_CARD_SMALL = 4;
    public static final int STYLE_TYPE_SMALL = 0;
    public static final int STYLE_TYPE_SMALL_SINGLE = 2;
    protected CardView mCardView;
    protected NetworkImageView mImageView;
    private BannerStyle mStyle;
    private int mStyleType;

    static {
        SHADOW_DELTA = Style.dp2px(4.0d);
        SHADOW_WIDTH_LARGE_DELTA = Style.dp2px(8.0d);
        SHADOW_HEIGHT_LARGE_DELTA = Style.dp2px(14.0d);
    }

    public BaseBannerView(Context r10) {
        this(r10, null);
    }

    private void addDivideLine() {
    }

    private void init(AttributeSet r10) {
        CardView r11 = new CardView(getContext());
        this.mCardView = r11;
        r11.setCardBackgroundColor(getContext().getColor(R$color.Transparent));
        RelativeLayout.LayoutParams r12 = new RelativeLayout.LayoutParams(-2, -2);
        this.mCardView.setCardElevation(0.0f);
        this.mCardView.setContentPadding(0, 0, 0, 0);
        this.mCardView.setUseCompatPadding(false);
        addView(this.mCardView, r12);
        intImageView();
        TypedArray r13 = getContext().obtainStyledAttributes(r10, R$styleable.BaseBannerView);
        this.mStyleType = r13.getInt(R$styleable.BaseBannerView_style_type, -1);
        r13.recycle();
        ImageUtils.setImageSetter(BaseApplication.c().f());
    }

    private void intImageView() {
        this.mImageView = new NetworkImageView(getContext());
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, -1);
        r10.gravity = 16;
        this.mCardView.addView(this.mImageView, r10);
        this.mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mImageView.setDefaultImageResId(R$drawable.oui_default_banner);
    }

    private boolean isValidStyleType() {
        if (this.mStyleType <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void removeDivideLine() {
    }

    private void setStyle(BannerStyle r10) {
        this.mStyle = r10;
        updateCardLayout();
        updateSelfLayout();
        updateLine();
    }

    private void updateCardLayout() {
        RelativeLayout.LayoutParams r10 = (RelativeLayout.LayoutParams) this.mCardView.getLayoutParams();
        int r11 = r10.width;
        BannerStyle r12 = this.mStyle;
        int r13 = r12.f9924c;
        if (r11 == r13) goto L5;
        r10.width = r13;
    L5:
        int r14 = r10.height;
        int r15 = r12.f9925d;
        if (r14 == r15) goto L8;
        r10.height = r15;
    L8:
        int r16 = r10.topMargin;
        int[] r17 = r12.f9927f;
        int r18 = r17[0];
        if (r16 == r18) goto L11;
        r10.topMargin = r18;
    L11:
        int r19 = r10.bottomMargin;
        int r20 = r17[2];
        if (r19 == r20) goto L14;
        r10.bottomMargin = r20;
    L14:
        int r21 = r10.leftMargin;
        int r22 = r17[3];
        if (r21 == r22) goto L17;
        r10.leftMargin = r22;
    L17:
        int r23 = r10.rightMargin;
        int r24 = r17[1];
        if (r23 == r24) goto L20;
        r10.rightMargin = r24;
    L20:
        this.mCardView.setLayoutParams(r10);
        this.mCardView.setRadius(this.mStyle.f9931j);
        if (this.mImageView != null) goto L24;
        intImageView();
        return;
    }

    private void updateLine() {
        if (this.mStyle.f9928g == false) goto L5;
        addDivideLine();
        return;
    L5:
        removeDivideLine();
    }

    private void updateSelfLayout() {
        if (getLayoutParams() == null) goto L13;
        int r10 = getLayoutParams().width;
        int r11 = this.mStyle.f9922a;
        if (r10 == r11) goto L8;
        if (r11 <= 0) goto L8;
        ViewGroup.LayoutParams r12 = getLayoutParams();
        r12.width = this.mStyle.f9922a;
    L8:
        int r13 = getLayoutParams().height;
        int r14 = this.mStyle.f9923b;
        if (r13 == r14) goto L14;
        if (r14 <= 0) goto L15;
        ViewGroup.LayoutParams r15 = getLayoutParams();
        r15.height = this.mStyle.f9923b;
        return;
    L15:
        return;
    L14:
        return;
    }

    public void bindData(Topic r10) {
        if (this.mStyle.f9930i == false) goto L5;
        this.mImageView.e(r10.getImageResUrl(), this.mStyle.f9931j);
    L6:
        this.mImageView.setContentDescription(r10.getTitle());
        this.mImageView.setTag(r10);
        return;
    L5:
        this.mImageView.setImageUrl(r10.getImageResUrl());
        goto L6
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isValidStyleType() == false) goto L6;
        setStyleType(this.mStyleType);
        return;
    }

    public void setStyleType(int r10) {
        this.mStyleType = r10;
        setStyle(e.a(r10));
    }

    public BaseBannerView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public BaseBannerView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mStyleType = -1;
        init(r11);
    }
}
