package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements IGameCPCloudGameService {
    public a() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final void closeAllGame() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L8;
        xr.g r101 = r100.getCloudGameService();
        if (r101 == null) goto L9;
        r101.closeAllGame();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final boolean isPluginReady() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L9;
        xr.g r101 = r100.getCloudGameService();
        if (r101 == null) goto L9;
        if (r101.isPluginReady() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final String getRtcLibraConfig(String r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L7;
        xr.g r102 = r101.getCloudGameService();
        if (r102 == null) goto L7;
        return r102.b1();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final void closeGame(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "from");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.g r104 = r103.getCloudGameService();
        if (r104 == null) goto L9;
        r104.N();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final <T> T getTrackParams(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "gameId");
        Intrinsics.checkNotNullParameter(r102, "key");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L7;
        xr.g r104 = r103.getCloudGameService();
        if (r104 == null) goto L7;
        return (T) r104.g0();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final void initMonitor(long r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "gameId");
        Intrinsics.checkNotNullParameter(r102, "map");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.g r104 = r103.getCloudGameService();
        if (r104 == null) goto L9;
        r104.G0();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final void monitorEvent(long r100, String r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "gameId");
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "extra");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.g r105 = r104.getCloudGameService();
        if (r105 == null) goto L9;
        r105.z();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final <T> void setTrackValue(long r100, String r101, String r102, T r103) {
        Intrinsics.checkNotNullParameter(r101, "gameId");
        Intrinsics.checkNotNullParameter(r102, "key");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.g r105 = r104.getCloudGameService();
        if (r105 == null) goto L9;
        r105.h1();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final void trackEvent(long r100, String r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "gameId");
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "extra");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.g r105 = r104.getCloudGameService();
        if (r105 == null) goto L9;
        r105.T0();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService
    public final Map<String, Object> createStartParams(String r100, String r101, String r102, String r103, List<? extends Pair<String, ? extends Object>> r104, Map<String, String> r105, int r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "gameName");
        Intrinsics.checkNotNullParameter(r101, "gameIcon");
        Intrinsics.checkNotNullParameter(r102, "gameId");
        Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.Notification.CHANNEL_ID);
        xr.f r108 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r108 == null) goto L7;
        xr.g r109 = r108.getCloudGameService();
        if (r109 == null) goto L7;
        return r109.I0();
    L7:
        return null;
    }
}
