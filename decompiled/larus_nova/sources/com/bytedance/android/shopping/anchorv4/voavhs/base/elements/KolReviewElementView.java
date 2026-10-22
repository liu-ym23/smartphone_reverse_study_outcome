package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/KolReviewElementView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KolReviewElementView extends FrameLayout implements ActionHubAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b f167841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KolReviewElement f167842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f167843c;

    public KolReviewElementView(Context r100) {
        this(r100, null, 0, 14);
    }

    public KolReviewElementView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public KolReviewElementView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        KolReviewElement r100 = this.f167842b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAction();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f167843c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f167841a.e(r100);
        super.draw(r100);
        this.f167841a.d(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f167843c = r100;
    }

    public static void b(int r100, SimpleDraweeView r101) {
        if (r100 != 0) goto L5;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        r102.gravity = 17;
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
        return;
    L5:
        if (r100 != 1) goto L11;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.leftMargin = com.bytedance.android.shopping.extensions.b.b(10);
        r104.topMargin = com.bytedance.android.shopping.extensions.b.b(10);
        Unit r105 = Unit.INSTANCE;
        r101.setLayoutParams(r104);
        return;
    }

    public final void a(KolReviewElement r210, ViewGroup.LayoutParams r211) {
        int r100 = 8;
        if (r210 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        this.f167842b = r210;
        removeAllViews();
        long r101 = r210.getLayoutStyle();
        if (r101 != KolReviewStyle.STYLE_SPLIT.getType()) goto L16;
        ShoppingAsyncInflater.a r102 = ShoppingAsyncInflater.f45268e;
        Context r103 = getContext();
        r102.getClass();
        View r104 = ShoppingAsyncInflater.a.a(r103).aU(R.layout.ec_commerce_anchor_v4_kol_review_split, this, true);
        MediaBoxElementView r105 = (MediaBoxElementView) r104.findViewById(R.id.anchor_v4_kol_review_media);
        SimpleDraweeView r106 = (SimpleDraweeView) r104.findViewById(R.id.anchor_v4_kol_type_icon);
        TextWithOneIconElementView r110 = (TextWithOneIconElementView) r104.findViewById(R.id.anchor_v4_kol_follow_status);
        TextWithOneIconElementView r107 = (TextWithOneIconElementView) r104.findViewById(R.id.anchor_v4_kol_like_count);
        TextWithOneIconElementView r111 = (TextWithOneIconElementView) r104.findViewById(R.id.anchor_v4_kol_info);
        View r108 = r104.findViewById(R.id.anchor_v4_kol_review_bottom_mask);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-2, -2);
        if (r211 == null) goto L11;
        int r109 = r211.width;
        r112 = new FrameLayout.LayoutParams(r109, r109);
    L11:
        MediaBoxElementView.c(r105, r210.getImage(), r112, false, 4);
        ImageExtensionsKt.d(r106, r210.getTypeIcon(), null);
        TextWithOneIconElementView.b(r110, r210.getFollowText(), null, false, null, 14);
        TextWithOneIconElementView.b(r107, r210.getLikeCount(), null, false, null, 14);
        TextWithOneIconElementView.b(r111, r210.getKolInfo(), null, false, null, 14);
        b(r210.getTypeIconStyle(), r106);
        if (r210.getHasMask() == false) goto L14;
        r100 = 0;
    L14:
        r108.setVisibility(r100);
    L22:
        Action r113 = r210.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r113);
        return;
    L16:
        if (r101 != KolReviewStyle.STYLE_WHOLE.getType()) goto L21;
        ShoppingAsyncInflater.a r114 = ShoppingAsyncInflater.f45268e;
        Context r115 = getContext();
        r114.getClass();
        View r116 = ShoppingAsyncInflater.a.a(r115).aU(R.layout.ec_commerce_anchor_v4_kol_review_whole, this, true);
        MediaBoxElementView r117 = (MediaBoxElementView) r116.findViewById(R.id.anchor_v4_kol_review_media);
        SimpleDraweeView r118 = (SimpleDraweeView) r116.findViewById(R.id.anchor_v4_kol_type_icon);
        TextElementView r119 = (TextElementView) r116.findViewById(R.id.anchor_v4_kol_content);
        LinearLayout r120 = (LinearLayout) r116.findViewById(R.id.ec_commerce_ll_kol_view_whole);
        TextWithOneIconElementView r121 = (TextWithOneIconElementView) r116.findViewById(R.id.anchor_v4_kol_like_count);
        TextWithOneIconElementView r122 = (TextWithOneIconElementView) r116.findViewById(R.id.anchor_v4_kol_user);
        TextWithOneIconElementView r123 = (TextWithOneIconElementView) r116.findViewById(R.id.anchor_v4_kol_follow_status);
        View r124 = r116.findViewById(R.id.anchor_v4_kol_review_bottom_mask);
        MediaBoxElementView.c(r117, r210.getImage(), null, false, 6);
        ImageExtensionsKt.d(r118, r210.getTypeIcon(), null);
        r119.x(r210.getReviewContent());
        TextWithOneIconElementView.b(r121, r210.getLikeCount(), null, false, null, 14);
        TextWithOneIconElementView.b(r122, r210.getKolInfo(), null, false, null, 14);
        TextWithOneIconElementView.b(r123, r210.getFollowText(), null, false, null, 14);
        b(r210.getTypeIconStyle(), r118);
        if (r210.getHasMask() == false) goto L20;
        r100 = 0;
    L20:
        r124.setVisibility(r100);
        r120.setBackground(com.bytedance.commerce.base.drawable.a.a(KolReviewElementView$renderAsWholeMode$2.INSTANCE));
        goto L22
    L21:
        setVisibility(8);
        goto L22
    }

    public KolReviewElementView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f167843c = null;
        this.f167841a = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f167841a.c(r100, r101);
    }
}
