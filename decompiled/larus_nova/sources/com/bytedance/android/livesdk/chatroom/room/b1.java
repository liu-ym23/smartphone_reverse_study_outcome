package com.bytedance.android.livesdk.chatroom.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.config.nr;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f110774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f110775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f110776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f110777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f110778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vs.f f110779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f110780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f110781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f110782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f110783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f110784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f110785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f110786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f110787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a1 f110788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f110789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DataCenter f110790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f110791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f110792s;

    public final void b() {
        if (this.f110778e == false) goto L5;
        return;
    L5:
        this.f110787n = true;
        if (this.f110785l != (-1)) goto L8;
        return;
    L8:
        if (this.f110782i == true) goto L13;
        this.f110786m = SystemClock.elapsedRealtime();
        this.f110774a.removeCallbacksAndMessages(null);
        this.f110781h = true;
        return;
    }

    public final void c() {
        if (this.f110785l != (-1)) goto L5;
        return;
    L5:
        if (this.f110789p == false) goto L7;
        return;
    L7:
        if (this.f110791r == false) goto L10;
        return;
    L10:
        if (this.f110787n == false) goto L15;
        if (this.f110786m <= 0) goto L15;
        d(true);
    L15:
        if (this.f110792s == false) goto L18;
        return;
    L18:
        if (nr.f120854a.getValue().booleanValue() == true) goto L20;
    L24:
        long r100 = (SystemClock.elapsedRealtime() - this.f110785l) - this.f110784k;
        this.f110784k = 0;
        this.f110779f.c("live_duration", MapsKt.mapOf(TuplesKt.to("duration", String.valueOf(r100))), new Object[0]);
        this.f110789p = true;
        return;
    L20:
        if (this.f110775b == true) goto L22;
        return;
    L22:
        if (this.f110776c == true) goto L24;
    }

    public final void d(boolean r100) {
        if (this.f110778e == false) goto L5;
        return;
    L5:
        this.f110787n = false;
        if (this.f110786m != (-1)) goto L8;
        return;
    L8:
        if (this.f110782i == false) goto L11;
        return;
    L11:
        if (this.f110792s == false) goto L19;
        if (r100 == true) goto L19;
        this.f110784k = 0;
        VSDataContext r101 = VSDataContext.a.c(VSDataContext.Companion, this.f110790q);
        if (r101 == null) goto L32;
        com.bytedance.live.datacontext.m<Long> r102 = r101.getTotalStopTime();
        if (r102 == null) goto L32;
        r102.setValue(Long.valueOf(this.f110784k));
    L32:
        this.f110786m = -1;
        ILivePlayerClient r103 = LivePlatformPlayerManager.f();
        if (r103 == null) goto L35;
        r103.setLiveRoomState(true);
    L35:
        this.f110774a.post(this.f110788o);
        return;
    L19:
        VSDataContext r104 = VSDataContext.a.c(VSDataContext.Companion, this.f110790q);
        if (r104 == null) goto L26;
        com.bytedance.live.datacontext.m<Long> r105 = r104.getTotalStopTime();
        if (r105 == null) goto L26;
        Long r106 = r105.getValue();
        if (r106 == null) goto L26;
        long r107 = r106.longValue();
    L27:
        this.f110784k = (r107 + SystemClock.elapsedRealtime()) - this.f110786m;
        VSDataContext r108 = VSDataContext.a.b(this.f110790q);
        if (r108 == null) goto L32;
        com.bytedance.live.datacontext.m<Long> r109 = r108.getTotalStopTime();
        if (r109 == null) goto L32;
        r109.setValue(Long.valueOf(this.f110784k));
    L26:
        r107 = this.f110784k;
        goto L27
    }

    public b1(DataCenter r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f110790q = r100;
        this.f110791r = false;
        this.f110792s = r101;
        this.f110774a = new Handler(Looper.getMainLooper());
        this.f110779f = com.bytedance.android.livesdk.vs.f.a(r100);
        this.f110783j = true;
        this.f110785l = -1;
        this.f110786m = -1;
        this.f110788o = new a1(this);
    }

    public final void a(boolean r100, boolean r101) {
        if (this.f110775b == true) goto L5;
    L7:
        if (r100 == false) goto L9;
        this.f110775b = r100;
    L9:
        if (r101 == false) goto L12;
        this.f110776c = r101;
    L12:
        if (this.f110775b == true) goto L14;
        return;
    L14:
        if (this.f110776c == true) goto L16;
        return;
    L16:
        if (this.f110777d == true) goto L48;
        this.f110777d = true;
        String r102 = null;
        if (this.f110791r == false) goto L28;
        VSDataContext r103 = VSDataContext.a.c(VSDataContext.Companion, this.f110790q);
        com.bytedance.android.livesdk.vs.f r104 = this.f110779f;
        if (r103 == null) goto L27;
        com.bytedance.live.datacontext.m<Integer> r105 = r103.getSeekType();
        if (r105 == null) goto L27;
        Integer r106 = r105.getValue();
        if (r106 == null) goto L27;
        r102 = String.valueOf(r106.intValue());
    L27:
        r104.c("video_play", MapsKt.mapOf(TuplesKt.to("seek_type", r102)), new Object[0]);
        return;
    L28:
        HashMap r107 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(VrBgLogData.KEY_VR_TYPE, VrUtils.n()), TuplesKt.to("is_vr_machine", VrUtils.o(this.f110790q))});
        this.f110779f.c("live_play", r107, new Object[0]);
        if (this.f110792s == true) goto L44;
        nm1.m r108 = pm1.f.l();
        if (r108 == null) goto L33;
        r108.x(this.f110790q, r107);
    L33:
        com.bytedance.android.livesdk.vs.f.a(this.f110790q).c("live_machine_play", r107, new Object[]{am2.u.class});
        RoomContext r109 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r109 == null) goto L45;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> r110 = r109.getLoggerHelper();
        if (r110 == null) goto L46;
        com.bytedance.android.livesdk.chatroom.l r111 = r110.getValue();
        if (r111 == null) goto L47;
        r111.a("livesdk_live_content_play", null);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L48:
        return;
    L5:
        if (this.f110776c == false) goto L7;
    }
}
