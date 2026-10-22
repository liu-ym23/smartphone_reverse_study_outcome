package com.bytedance.android.livesdk.player.newstrategy;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f155941a = null;

    static {
        f155941a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        IFeatureService r102 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r102 == null) goto L7;
        z90.a r103 = r102.getFeatureManager();
        if (r103 == null) goto L7;
        r103.i("player_stall_status", Boolean.FALSE, FeatureType.MONITOR);
    L7:
        j.a(false);
        Disposable r104 = j.f155944b;
        if (r104 == null) goto L10;
        r104.dispose();
    L10:
        IFeatureService r105 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r105 == null) goto L16;
        z90.a r106 = r105.getFeatureManager();
        if (r106 == null) goto L17;
        r106.i("player_stall_duration", 0, FeatureType.MONITOR);
        return;
    L17:
        return;
    }
}
