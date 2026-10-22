package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveDanmakuCountLevel extends DynamicFactor<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f123089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f123090c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_danmaku_count_level";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        com.bytedance.android.livesdk.interactivity.api.h r100 = com.bytedance.android.livesdk.interactivity.api.i.b(this.f123090c, 1);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r101 = r100.getBarrageContext();
        if (r101 == null) goto L9;
        r101.c(new LiveDanmakuCountLevel$onBind$1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r100 = this.f123089b;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public LiveDanmakuCountLevel(DataCenter r100) {
        this.f123090c = r100;
    }
}
