package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.widget.LiveUserPredictStrategy;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d0 extends DynamicFactor<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f123152b;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "inner_feed_stay_duration_p50";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        LiveUserPredictStrategy r100 = LiveUserPredictStrategy.f161121c;
        DataCenter r101 = this.f123152b;
        IRoom r102 = com.bytedance.android.live.core.utils.a0.f66111a;
        Intrinsics.checkNotNullParameter(r101, "$this$safeFeedRoom");
        IRoom r103 = (IRoom) r101.get("data_feed_room", null);
        r100.getClass();
        return Integer.valueOf(LiveUserPredictStrategy.a(r103).f162211a);
    }

    public d0(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123152b = r100;
    }
}
