package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdkapi.GlobalRoomCache;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p implements e {
    public p() {
    }

    @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e
    public final void a(j r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "result");
        long r102 = System.currentTimeMillis();
        IRoom r103 = GlobalRoomCache.INSTANCE.getRoomById(r100.f155967c);
        ALogger.i("StartUpInterceptor", "getRoomById " + (System.currentTimeMillis() - r102));
        IFeatureService r104 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r104 != null) goto L5;
    L9:
        ALogger.i("StartUpInterceptor", "cost time:" + (System.currentTimeMillis() - r102));
        ALogger.i("StartUpInterceptor", "params: roomId:" + r100.f155967c + ",createScene:" + r100.f155965a + ",useScene:" + r100.f155966b);
        return;
    L5:
        if (r103 == null) goto L7;
        r104.unifyHandleRoom(r103);
        r104.getFeatureManager().i("no_room", Boolean.FALSE, FeatureType.MONITOR);
        ALogger.i("StartUpInterceptor", "handle success " + (System.currentTimeMillis() - r102));
    L8:
        z90.a r105 = r104.getFeatureManager();
        String r106 = r100.f155965a;
        FeatureType r107 = FeatureType.MONITOR;
        r105.i("create_scene", r106, r107);
        r104.getFeatureManager().i("use_scene", r100.f155966b, r107);
        goto L9
    L7:
        r104.getFeatureManager().i("no_room", Boolean.TRUE, FeatureType.MONITOR);
        ALogger.i("StartUpInterceptor", "no room");
        goto L8
    }
}
