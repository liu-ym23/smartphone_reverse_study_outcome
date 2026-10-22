package com.bytedance.android.gamecp.business.monitor;

import android.os.SystemClock;
import com.bytedance.android.gamecp.base.cache.c;
import com.bytedance.android.gamecp.common.monitor_v1.FMPMonitorTracker;
import com.bytedance.android.gamecp.common.monitor_v1.i;
import kotlin.jvm.internal.Intrinsics;
import xr.d;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d {
    public a() {
    }

    @Override // xr.d
    public final void markActionEnd(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "action");
        FMPMonitorTracker.i(r100, r101);
    }

    @Override // xr.d
    public final void startComponentFmp(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        c<String, FMPMonitorTracker.b> r102 = FMPMonitorTracker.f56549a;
        FMPMonitorTracker.n(r100, r101, SystemClock.elapsedRealtime());
    }

    @Override // xr.d
    public final void startFmpTrack(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackEvent");
        c<String, FMPMonitorTracker.b> r102 = FMPMonitorTracker.f56549a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        FMPMonitorTracker.o(r100, r101, 0, 4);
    }

    @Override // xr.d
    public final void stopFmpTrack(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        FMPMonitorTracker r102 = FMPMonitorTracker.f56555g;
        if (r101 != null) goto L5;
        r101 = "exit_early";
    L5:
        r102.p(r100, r101);
    }

    @Override // xr.d
    public final void addTrackExtra(String r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "field");
        FMPMonitorTracker.a(FMPMonitorTracker.f56555g, r100, r101, r110, true, 16);
    }

    @Override // xr.d
    public final void addTrackField(String r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "field");
        FMPMonitorTracker.a(FMPMonitorTracker.f56555g, r100, r101, r110, false, 24);
    }

    @Override // xr.d
    public final void endComponentFmp(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        c<String, FMPMonitorTracker.b> r103 = FMPMonitorTracker.f56549a;
        Intrinsics.checkNotNullParameter(r100, "trackId");
        if (FMPMonitorTracker.d() == false) goto L7;
        FMPMonitorTracker.e().post(new i(r100, r101, r102));
        return;
    }

    @Override // xr.d
    public final void markEventActionEnd(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "action");
        FMPMonitorTracker.l(r100, r101, r102);
    }

    @Override // xr.d
    public final void addEventExtra(String r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r110, "field");
        FMPMonitorTracker.b(r100, r101, r110, r111, true, 32);
    }

    @Override // xr.d
    public final void addEventField(String r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r110, "field");
        FMPMonitorTracker.b(r100, r101, r110, r111, false, 48);
    }

    @Override // xr.d
    public final void markActionStart(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "durationKey");
        FMPMonitorTracker.k(r100, r101, r102, r103, 16);
    }

    @Override // xr.d
    public final void markEventActionStart(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r103, "durationKey");
        FMPMonitorTracker.m(r100, r101, r102, r103);
    }
}
