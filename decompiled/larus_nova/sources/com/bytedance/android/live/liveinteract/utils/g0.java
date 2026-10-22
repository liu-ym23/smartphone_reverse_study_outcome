package com.bytedance.android.live.liveinteract.utils;

import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f78769g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f78770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f78771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f78772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f78773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRoom f78774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> f78775f;

    public static final class a {
    }

    static {
    }

    public final void c(int r100) {
        if (this.f78772c == false) goto L5;
        return;
    L5:
        ALogger.i("LinkInfoReportHelper", "release: linkCount=" + this.f78771b);
        this.f78775f.T4(this.f78770a);
        this.f78772c = true;
        if (this.f78771b <= 0) goto L8;
        d(r100, null);
    L8:
        this.f78771b = 0;
    }

    public g0(IRoom r100, com.bytedance.android.live.liveinteract.plantform.core.y r101) {
        Intrinsics.checkNotNullParameter(r101, "userCenter");
        this.f78774e = r100;
        this.f78775f = r101;
        h0 r102 = new h0(this);
        this.f78770a = r102;
        r101.Q4(r102);
        r102.onOnlineListChanged(r101.f76316c);
    }

    public final void d(int r100, Integer r110) {
        ALogger.i("LinkInfoReportHelper", "reportSeeGuestConnectionDuration: showStartTime=" + this.f78773d);
        if (this.f78773d <= 0) goto L25;
        long r101 = SystemClock.elapsedRealtime() - this.f78773d;
        ALogger.i("LinkInfoReportHelper", "reportSeeGuestConnectionDuration: livesdk_audience_guest_connection_duration, duration=" + r101 + " ms");
        LinkedHashMap r102 = new LinkedHashMap();
        if (vm2.h.R() == false) goto L9;
        IRoom r103 = this.f78774e;
        if (r103 == null) goto L9;
        r102.put("room_id", String.valueOf(r103.getId()));
        r102.put("anchor_id", String.valueOf(this.f78774e.getAnchorId()));
        LiveMode r104 = this.f78774e.getStreamType();
        int r105 = com.bytedance.android.live.core.utils.h1.f66189a;
        r102.put("live_type", com.bytedance.android.live.core.utils.i1.a(r104));
    L9:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r106 = TalkRoomLogUtils.f77433a;
        Intrinsics.checkNotNullParameter(r102, "logMap");
        TalkRoomLogUtils.J0(r102);
        if (r100 == 0) goto L12;
        TalkRoomLogUtils.A0(r102, Integer.valueOf(r100), r110);
    L13:
        r102.put("duration", String.valueOf(r101));
        TalkRoomLogUtils.O0(r102);
        if (r110 == null) goto L17;
        r110.intValue();
        String r107 = com.bytedance.android.live.liveinteract.plantform.utils.i.a(r100, r110.intValue(), false);
        if (r107 == null) goto L17;
    L18:
        r102.put("function_type2", r107);
        if (r110 == null) goto L21;
    L23:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_guest_connection_duration", r102, new Object[]{IRoom.class, am2.x.class});
        this.f78773d = 0;
        return;
    L21:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L23;
        r102.put("function_type2", "new_audience");
    L17:
        r107 = TalkRoomLogUtils.f77440h;
        goto L18
    L12:
        TalkRoomLogUtils.B0(r102, null, r110, 2);
        goto L13
    }

    public final void e(int r100, Integer r101) {
        ALogger.i("LinkInfoReportHelper", "reportSeeGuestShow: livesdk_audience_guest_connection_show");
        this.f78773d = SystemClock.elapsedRealtime();
        LinkedHashMap r102 = new LinkedHashMap();
        if (vm2.h.R() == false) goto L7;
        IRoom r103 = this.f78774e;
        if (r103 == null) goto L7;
        r102.put("room_id", String.valueOf(r103.getId()));
        r102.put("anchor_id", String.valueOf(this.f78774e.getAnchorId()));
        LiveMode r104 = this.f78774e.getStreamType();
        int r105 = com.bytedance.android.live.core.utils.h1.f66189a;
        r102.put("live_type", com.bytedance.android.live.core.utils.i1.a(r104));
    L7:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r106 = TalkRoomLogUtils.f77433a;
        Intrinsics.checkNotNullParameter(r102, "logMap");
        TalkRoomLogUtils.J0(r102);
        if (r100 == 0) goto L10;
        TalkRoomLogUtils.B0(r102, Integer.valueOf(r100), null, 4);
    L11:
        TalkRoomLogUtils.O0(r102);
        if (r101 == null) goto L15;
        r101.intValue();
        String r107 = com.bytedance.android.live.liveinteract.plantform.utils.i.a(r100, r101.intValue(), false);
        if (r107 == null) goto L15;
    L16:
        r102.put("function_type2", r107);
        if (r101 == null) goto L19;
    L21:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_guest_connection_show", r102, new Object[]{IRoom.class, am2.x.class});
        return;
    L19:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L21;
        r102.put("function_type2", "new_audience");
    L15:
        r107 = TalkRoomLogUtils.f77440h;
        goto L16
    L10:
        TalkRoomLogUtils.B0(r102, null, null, 6);
        goto L11
    }

    public final void b(int r100, int r101, int r102) {
        if (this.f78772c == false) goto L5;
        return;
    L5:
        ALogger.i("LinkInfoReportHelper", "onPlayModeChange: currScene=" + r100 + ", fromUILayout=" + r101 + ", toUILayout=" + r102 + ", linkCount=" + this.f78771b);
        if (this.f78771b <= 0) goto L9;
        d(r100, Integer.valueOf(r101));
        e(r100, Integer.valueOf(r102));
        return;
    }

    public final void a(int r100, Integer r101, int r102, Integer r103) {
        if (this.f78772c == false) goto L5;
        return;
    L5:
        ALogger.i("LinkInfoReportHelper", "onSceneChange: from=" + r100 + ", to=" + r102 + ", linkCount=" + this.f78771b);
        if (this.f78771b <= 0) goto L9;
        d(r100, r101);
        e(r102, r103);
        return;
    }
}
