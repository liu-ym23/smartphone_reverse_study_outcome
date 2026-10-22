package com.bytedance.android.ec.adapter.impl.adapters.reverse.player;

import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECPlayerView$getPlayerClient$1 extends MutablePropertyReference0Impl {
    public ECPlayerView$getPlayerClient$1(d r100) {
        super(r100, d.class, "liveClient", "getLiveClient()Lcom/bytedance/android/ec/adapter/api/player/IECLivePlayerClient;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        IECLivePlayerClient r100 = ((d) this.receiver).f42758a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveClient");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        IECLivePlayerClient r101 = (IECLivePlayerClient) r100;
        ((d) this.receiver).f42758a = r101;
    }
}
