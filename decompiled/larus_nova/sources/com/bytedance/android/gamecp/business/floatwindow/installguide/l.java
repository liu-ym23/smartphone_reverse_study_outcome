package com.bytedance.android.gamecp.business.floatwindow.installguide;

import com.bytedance.android.gamecp.business.GamePromoteTrack;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f53208a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickPosition");
        Map r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(BdpAppEventConstant.PARAMS_CLICK_POSITION, r100)});
        int r102 = GamePromoteTrack.f51759a;
        GamePromoteTrack.b(r101);
        int r103 = com.bytedance.android.gamecp.common.track.b.f56775a;
        com.bytedance.android.gamecp.common.track.b.g("livesdk_mini_game_window_setting_ignore", r101, new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG});
    }
}
