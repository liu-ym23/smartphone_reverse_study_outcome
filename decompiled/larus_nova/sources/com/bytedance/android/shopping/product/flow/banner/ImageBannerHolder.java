package com.bytedance.android.shopping.product.flow.banner;

import android.view.View;
import com.bytedance.android.shopping.widget.RemoteRoundImageView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/ImageBannerHolder;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageBannerHolder extends BannerHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f182341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f182342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RemoteRoundImageView f182343c;

    public ImageBannerHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f182341a = (ECDraweeView) r100.findViewById(R.id.image);
        this.f182342b = r100.findViewById(R.id.fl_image_container);
        this.f182343c = (RemoteRoundImageView) r100.findViewById(R.id.atmosphere_image);
    }
}
