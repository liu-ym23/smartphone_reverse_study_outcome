package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
public final class r implements IConfig.e {
    public r() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IConfig.e
    public final int getHeight() {
        Pair<Integer, Integer> r100 = com.bytedance.android.live.revlink.impl.utils.u.f();
        if (r100 == null) goto L7;
        Integer r101 = r100.getSecond();
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    @Override // xh6.c
    public final Object getReal() {
        Pair<Integer, Integer> r100 = com.bytedance.android.live.revlink.impl.utils.u.f();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IConfig.e
    public final int getWidth() {
        Pair<Integer, Integer> r100 = com.bytedance.android.live.revlink.impl.utils.u.f();
        if (r100 == null) goto L7;
        Integer r101 = r100.getFirst();
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }
}
