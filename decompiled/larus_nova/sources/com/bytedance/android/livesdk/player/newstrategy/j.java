package com.bytedance.android.livesdk.player.newstrategy;

import am2.x;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Long> f155943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Disposable f155944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Disposable f155945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f155946d;

    static {
        f155943a = new ArrayList();
    }

    public static void a(boolean r100) {
        if (f155946d == 0) goto L29;
        long r101 = System.currentTimeMillis() - f155946d;
        f155946d = 0;
        HashMap r102 = new HashMap();
        r102.put("stallDuration", String.valueOf(r101));
        r102.put("isRelease", String.valueOf(r100));
        IFeatureService r103 = (IFeatureService) jc1.k.f(IFeatureService.class);
        Integer r104 = null;
        if (r103 == null) goto L9;
        z90.a r105 = r103.getFeatureManager();
        if (r105 == null) goto L9;
        Integer r106 = (Integer) r105.getFeature("stall_counter_300s", 0);
    L10:
        r102.put("stall_counter_300s", String.valueOf(r106));
        IFeatureService r107 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r107 == null) goto L15;
        z90.a r108 = r107.getFeatureManager();
        if (r108 == null) goto L15;
        Integer r109 = (Integer) r108.getFeature("stall_counter_60s", 0);
    L16:
        r102.put("stall_counter_60s", String.valueOf(r109));
        IFeatureService r110 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r110 == null) goto L21;
        z90.a r111 = r110.getFeatureManager();
        if (r111 == null) goto L21;
        Integer r112 = (Integer) r111.getFeature("stall_counter_30s", 0);
    L22:
        r102.put("stall_counter_30s", String.valueOf(r112));
        IFeatureService r113 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r113 == null) goto L27;
        z90.a r114 = r113.getFeatureManager();
        if (r114 == null) goto L27;
        r104 = (Integer) r114.getFeature("stall_counter_15s", 0);
    L27:
        r102.put("stall_counter_15s", String.valueOf(r104));
        u.l().f("livesdk_live_player_stall", r102, new Object[]{Room.class, x.class});
        return;
    L21:
        r112 = null;
    L15:
        r109 = null;
    L9:
        r106 = null;
        goto L10
    }
}
