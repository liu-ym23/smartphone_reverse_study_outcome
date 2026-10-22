package com.bytedance.android.gamecp.business.gamedetail.component.minigameplay;

import com.bytedance.android.gamecp.business.datacontext.GameCpDataContext;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.live.datacontext.DataContext;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends TrackRegisterStrategy {
    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 5;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getClickTempExtraAttrs() {
        DataContext r100 = com.bytedance.live.datacontext.d.d(GameCpDataContext.class);
        if ((r100 instanceof GameCpDataContext) == true) goto L6;
        r100 = null;
    L6:
        return MapsKt.mapOf(TuplesKt.to("game_status", com.bytedance.android.gamecp.business.datacontext.a.a((GameCpDataContext) r100)));
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final yu.a getGPTrackShowConfig() {
        return new yu.a(true, 2);
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getShowExtraAttrs() {
        DataContext r100 = com.bytedance.live.datacontext.d.d(GameCpDataContext.class);
        if ((r100 instanceof GameCpDataContext) == true) goto L6;
        r100 = null;
    L6:
        return MapsKt.mapOf(TuplesKt.to("game_status", com.bytedance.android.gamecp.business.datacontext.a.a((GameCpDataContext) r100)));
    }

    public f() {
    }
}
