package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements IGameCPFmpMonitorService {
    public c() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void markActionEnd(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "action");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.d r103 = r102.getGameCPFmpMonitorService();
        if (r103 == null) goto L9;
        r103.markActionEnd(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void startComponentFmp(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.d r103 = r102.getGameCPFmpMonitorService();
        if (r103 == null) goto L9;
        r103.startComponentFmp(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void startFmpTrack(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackEvent");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.d r103 = r102.getGameCPFmpMonitorService();
        if (r103 == null) goto L9;
        r103.startFmpTrack(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void stopFmpTrack(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.d r103 = r102.getGameCPFmpMonitorService();
        if (r103 == null) goto L9;
        r103.stopFmpTrack(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void addTrackExtra(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "field");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.d r104 = r103.getGameCPFmpMonitorService();
        if (r104 == null) goto L9;
        r104.addTrackExtra(r100, r101, r102);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void addTrackField(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "field");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.d r104 = r103.getGameCPFmpMonitorService();
        if (r104 == null) goto L9;
        r104.addTrackField(r100, r101, r102);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void endComponentFmp(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.d r104 = r103.getGameCPFmpMonitorService();
        if (r104 == null) goto L9;
        r104.endComponentFmp(r100, r101, r102);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void markEventActionEnd(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "action");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.d r104 = r103.getGameCPFmpMonitorService();
        if (r104 == null) goto L9;
        r104.markEventActionEnd(r100, r101, r102);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void addEventExtra(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "field");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.d r105 = r104.getGameCPFmpMonitorService();
        if (r105 == null) goto L9;
        r105.addEventExtra(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void addEventField(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "field");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.d r105 = r104.getGameCPFmpMonitorService();
        if (r105 == null) goto L9;
        r105.addEventField(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void markActionStart(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "durationKey");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.d r105 = r104.getGameCPFmpMonitorService();
        if (r105 == null) goto L9;
        r105.markActionStart(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService
    public final void markEventActionStart(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r103, "durationKey");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.d r105 = r104.getGameCPFmpMonitorService();
        if (r105 == null) goto L9;
        r105.markEventActionStart(r100, r101, r102, r103);
        return;
    L9:
        return;
    }
}
