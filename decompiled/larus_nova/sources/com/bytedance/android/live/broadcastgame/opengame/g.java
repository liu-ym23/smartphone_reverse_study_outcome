package com.bytedance.android.live.broadcastgame.opengame;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class g extends com.bytedance.android.livesdk.log.filter.a<com.bytedance.android.live.broadcastgame.api.c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.c f60121c;

    public g() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        com.bytedance.android.live.broadcastgame.api.c r101 = this.f60121c;
        if (r101 == null) goto L10;
        if (r100 == null) goto L6;
        String r102 = r100.put(EventConstants.ExtraJson.GAME_NAME, String.valueOf(r101.f59283a));
    L6:
        if (r100 == null) goto L8;
        String r103 = r100.put("game_id", String.valueOf(r101.f59284b));
    L8:
        if (r100 == null) goto L10;
        String r104 = r100.put(BdpAppEventConstant.PARAMS_GAME_CATEGORY, String.valueOf(r101.f59285c));
    L10:
        super.a(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        this.f60121c = (com.bytedance.android.live.broadcastgame.api.c) r100;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        com.bytedance.android.live.broadcastgame.api.c r102 = (com.bytedance.android.live.broadcastgame.api.c) r101;
        if (r102 == null) goto L6;
        if (r100 == null) goto L6;
        String r103 = (String) r100.put("game_name,", String.valueOf(r102.f59283a));
    L6:
        super.u(r100, r102);
    }
}
