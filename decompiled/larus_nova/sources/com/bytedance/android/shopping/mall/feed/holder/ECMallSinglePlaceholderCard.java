package com.bytedance.android.shopping.mall.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/holder/ECMallSinglePlaceholderCard;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallSinglePlaceholderCard extends BaseViewHolder {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f177061p = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SimpleDraweeView f177062o;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final boolean C3() {
        return false;
    }

    public ECMallSinglePlaceholderCard(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        SimpleDraweeView r101 = new SimpleDraweeView(r100.getContext());
        r101.setScaleType(ImageView.ScaleType.FIT_XY);
        Unit r102 = Unit.INSTANCE;
        this.f177062o = r101;
        ((ViewGroup) r100).addView(r101, new ViewGroup.LayoutParams(-1, -2));
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r100, String r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        super.b4(r100, r101, r102);
        if ((r100 instanceof ECMallPlaceholderCardVO) == true) goto L5;
        return;
    L5:
        ECMallPlaceholderCardVO r103 = (ECMallPlaceholderCardVO) r100;
        if (r103.getBackgroundUrl() == null) goto L8;
    L10:
        ECMallDeliveryReduceConfig r104 = r103.getReduceConfig();
        if (r104 == null) goto L13;
        Double r105 = Double.valueOf(r104.getCardRadius());
    L14:
        if (r105 == null) goto L16;
        float r106 = b0.c(r105);
        this.f177062o.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r106, r106, 0.0f, 0.0f));
    L17:
        String r107 = r103.getBackgroundUrl();
        if (r107 != null) goto L20;
    L23:
        boolean r108 = true;
    L24:
        if (r108 == true) goto L29;
        Float r109 = r103.getBackgroundUrlRatio();
        if (r109 == null) goto L28;
        this.f177062o.setAspectRatio(r109.floatValue());
    L28:
        this.f177062o.setImageURI(r103.getBackgroundUrl());
        return;
    L29:
        Float r110 = r103.getBackgroundResIdRatio();
        if (r110 == null) goto L32;
        this.f177062o.setAspectRatio(r110.floatValue());
    L32:
        SimpleDraweeView r111 = this.f177062o;
        Integer r112 = r103.getBackgroundResId();
        if (r112 == null) goto L35;
        int r113 = r112.intValue();
    L36:
        r111.setImageResource(r113);
        return;
    L35:
        r113 = -1;
        goto L36
    L20:
        if (r107.length() == 0) goto L23;
        r108 = false;
        goto L24
    L16:
        this.f177062o.getHierarchy().setRoundingParams(null);
        goto L17
    L13:
        r105 = null;
        goto L14
    L8:
        if (r103.getBackgroundResId() != null) goto L10;
    }
}
