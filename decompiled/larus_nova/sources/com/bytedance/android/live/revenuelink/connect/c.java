package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class c implements i {
    public c() {
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void Z2(fy.d r100) {
        Intrinsics.checkNotNullParameter(r100, "finishParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void h3(fy.f r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "joinChannelParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void i3(fy.d r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "finishParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void k3(fy.h r100, ExtraResponse<n0, Extra> r101) {
        Intrinsics.checkNotNullParameter(r100, "leaveParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void m2(fy.h r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "leaveParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void m3(fy.f r100, ExtraResponse<com.bytedance.android.livesdk.link.model.bridge.f, Extra> r101) {
        Intrinsics.checkNotNullParameter(r100, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r101, "response");
    }
}
