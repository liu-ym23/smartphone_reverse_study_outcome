package com.bytedance.android.livesdk.player.newstrategy;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f155942a = null;

    static {
        f155942a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        IFeatureService r102 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r102 == null) goto L11;
        z90.a r103 = r102.getFeatureManager();
        if (r103 == null) goto L12;
        if (r101 == null) goto L8;
        Long r104 = Long.valueOf(r101.longValue() + 1);
    L9:
        r103.i("player_stall_duration", r104, FeatureType.MONITOR);
        return;
    L8:
        r104 = null;
        goto L9
    L12:
        return;
    }
}
