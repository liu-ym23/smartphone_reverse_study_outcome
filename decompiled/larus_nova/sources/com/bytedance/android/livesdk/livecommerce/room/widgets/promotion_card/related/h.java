package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends BaseRequestListener {
    public h() {
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
        super.onRequestSuccess(r100, r101, r102);
        OptCardUtil.b("image", "activity prefetch success");
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
        super.onRequestStart(r100, r101, r102, r103);
        OptCardUtil.b("image", "activity prefetch start");
    }
}
