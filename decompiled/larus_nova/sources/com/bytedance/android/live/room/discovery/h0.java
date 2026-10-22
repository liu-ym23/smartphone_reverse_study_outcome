package com.bytedance.android.live.room.discovery;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import zg1.h1;

/* JADX INFO: loaded from: classes47.dex */
public final class h0 implements IMiddlewareHostBusiness.HotSpotCallback {
    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.HotSpotCallback
    public final void onDismiss() {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.HotSpotCallback
    public final void onShow() {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.HotSpotCallback
    public final void onJumpToHotSpotDetail() {
        xs2.b.a().post(new h1(39));
    }

    public h0() {
    }
}
