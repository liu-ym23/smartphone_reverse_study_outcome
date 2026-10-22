package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class v extends DynamicFactor<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f123184b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "room_id";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Long b() {
        IRoom r100 = com.bytedance.android.live.core.utils.a0.o(this.f123184b);
        if (r100 == null) goto L5;
        long r101 = r100.getRoomId();
    L7:
        return Long.valueOf(r101);
    L5:
        r101 = 0;
        goto L7
    }

    public v(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123184b = r100;
    }
}
