package com.bytedance.android.livesdk.chatroom.vs_base.log;

import android.content.Context;
import android.os.SystemClock;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.player.ReplayPlayerScene;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.ReplayEventHub;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.utils.e1;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeBaseInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.m;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import fq1.s;
import fq1.t;
import java.util.Map;
import java.util.UUID;
import jc1.k;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mq1.r;
import nic.l;
import nic.p;

/* JADX INFO: loaded from: classes8.dex */
public final class ReplayDurationLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f117988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f117989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f117990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PlayerProgressServiceContext f117991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VideoContext f117992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.log.a f117993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f117994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f117995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f117996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f117997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f117998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f117999l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f118000m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f118001n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f118002o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DataCenter f118003p;

    public static final class a extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f118004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReplayDurationLogger f118005b;

        public a(ReplayDurationLogger r100) {
            this.f118005b = r100;
        }

        @Override // nic.l.a, nic.h
        public final void B(p r100, tic.a r101) {
            ReplayDurationLogger r102 = this.f118005b;
            if (r102.f117998k <= 0) goto L9;
            int r103 = e.f118011a;
            DataCenter r104 = r102.f118003p;
            String r105 = String.valueOf(System.currentTimeMillis() - this.f118005b.f117998k);
            Intrinsics.checkNotNullParameter(r105, "duration");
            if (r104 == null) goto L7;
            d.a(r104).d("switch_duration", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", r105)}), new Object[0]);
        L7:
            this.f118005b.f117998k = -1;
            return;
        }

        @Override // nic.l.a, nic.h
        public final void W(oic.f r100, tic.a r101) {
            ReplayDurationLogger r102 = this.f118005b;
            int r103 = -1;
            if (r102.f117994g != (-1)) goto L8;
            com.bytedance.android.livesdk.chatroom.vs_base.log.a r104 = r102.f117993f;
            if (r104 == null) goto L7;
            r103 = r104.O4();
        L7:
            r102.f117994g = r103;
        L8:
            ReplayDurationLogger r105 = this.f118005b;
            if (r105.f117989b != (-1)) goto L12;
            r105.f117989b = SystemClock.elapsedRealtime();
            return;
        }

        @Override // nic.l.a, nic.h
        public final void s(oic.f r100, tic.a r101) {
            this.f118005b.a("pause");
        }

        @Override // nic.l.a, nic.h
        public final void R(oic.f r100, tic.a r101, boolean r102) {
            long r103 = SystemClock.elapsedRealtime() - this.f118004a;
            if (ReplayConfigSettingKeys.LIVE_REPLAY_PERFORMANCE_TEST.getValue().booleanValue() == false) goto L7;
            DataCenter r104 = this.f118005b.f118003p;
            if (r104 == null) goto L7;
            d.a(r104).d("seek_duration", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(r103))}), new Object[0]);
        L7:
            this.f118004a = 0;
            ReplayDurationLogger r105 = this.f118005b;
            long r106 = r105.f117989b;
            if (r106 <= 0) goto L11;
            r105.f117989b = r106 + r103;
            return;
        }

        @Override // nic.l.a, nic.h
        public final void w(oic.f r100, tic.a r101, long r102) {
            this.f118004a = SystemClock.elapsedRealtime();
        }

        @Override // nic.l.a, nic.h
        public final void q(oic.f r100, tic.a r101, int r102, int r103) {
            com.bytedance.android.livesdk.chatroom.vs_base.log.a r104 = this.f118005b.f117993f;
            if (r104 == null) goto L5;
            long r105 = r104.O4();
        L6:
            ReplayDurationLogger r106 = this.f118005b;
            r106.f117990c = Math.max(r106.f117990c, r105);
            return;
        L5:
            r105 = r102;
            goto L6
        }
    }

    public final void b() {
        if (this.f117989b != (-1)) goto L5;
        this.f117989b = SystemClock.elapsedRealtime();
    L5:
        int r100 = -1;
        if (this.f117994g != (-1)) goto L12;
        com.bytedance.android.livesdk.chatroom.vs_base.log.a r101 = this.f117993f;
        if (r101 == null) goto L10;
        r100 = r101.O4();
    L10:
        this.f117994g = r100;
        return;
    }

    public final void c() {
        s r100 = t.a();
        if (r100 != null) goto L5;
    L7:
        IMiddleWareHostContext r101 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r101 == null) goto L14;
        String r102 = r101.getServerDeviceId();
        if (r102 == null) goto L14;
        if (StringsKt.isBlank(r102) == false) goto L15;
        r102 = UUID.randomUUID().toString();
    L15:
        String r103 = r102 + "_" + String.valueOf(System.currentTimeMillis());
    L16:
        this.f117988a = r103;
        return;
    L14:
        r102 = null;
        goto L15
    L5:
        if (r100.isLogin() != true) goto L7;
        r103 = t.a().getCurrentUserId().toString() + "_" + String.valueOf(System.currentTimeMillis());
        goto L16
    }

    public final void a(String r110) {
        if (this.f117989b != (-1)) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.vs_base.log.a r100 = this.f117993f;
        if (r100 == null) goto L8;
        Long r101 = Long.valueOf(r100.O4());
    L14:
        if (r101 == null) goto L16;
        long r102 = r101.longValue();
    L17:
        long r103 = SystemClock.elapsedRealtime() - this.f117989b;
        long r104 = Math.max(r102, r103);
        this.f117990c = Math.max(this.f117990c, r103);
        Pair[] r105 = new Pair[8];
        r105[0] = TuplesKt.to("duration", String.valueOf(r103));
        r105[1] = TuplesKt.to("vs_start_watch_record", String.valueOf(this.f117994g));
        r105[2] = TuplesKt.to("vs_exit_watch_record", String.valueOf(r104));
        r105[3] = TuplesKt.to("vs_max_watch_record", String.valueOf(this.f117990c));
        DataCenter r106 = this.f118003p;
        if (r106 != null) goto L20;
    L23:
        String r107 = "portrait";
    L24:
        r105[4] = TuplesKt.to("vs_screen_type", r107);
        r105[5] = TuplesKt.to("vs_enter_room_id", this.f117988a);
        r105[6] = TuplesKt.to("previous_play_speed", String.valueOf(this.f117999l));
        r105[7] = TuplesKt.to("reason", r110);
        Map<String, String> r111 = MapsKt.mutableMapOf(r105);
        fq1.a r108 = fq1.b.a();
        if (r108 == null) goto L49;
        Episode r109 = r108.f478400a;
        if (r109 == null) goto L49;
        IMainEpisode r112 = (IMainEpisode) r109.castToOrNull(IMainEpisode.class);
        if (r112 == null) goto L49;
        PrivilegeInfo r113 = r112.subscribeReplayInfo();
        if (r113 == null) goto L49;
        PrivilegeBaseInfo r114 = r113.paidLiveInfo;
        if (r114 != null) goto L35;
    L37:
        String r115 = "inactive";
    L38:
        r111.put("member_status", r115);
        fq1.a r116 = fq1.b.a();
        if (r116 == null) goto L47;
        Episode r117 = r116.f478400a;
        if (r117 == null) goto L47;
        String r118 = EpisodeExtKt.getOwnerIdString(r117);
        if (r118 == null) goto L47;
        if (r118.equals(t.a().getCurrentUserId()) != true) goto L47;
        String r119 = "1";
    L48:
        r111.put(IPerformanceManager.Params.is_anchor, r119);
    L47:
        r119 = "0";
        goto L48
    L35:
        if (r114.hasViewRight() != true) goto L37;
        r115 = "active";
    L49:
        DataCenter r120 = this.f118003p;
        if (r120 == null) goto L52;
        d.a(r120).d(HistoryTableOperate.HISTORY_PLAY_TIME, r111, new Object[0]);
    L52:
        this.f117989b = -1;
        this.f117994g = -1;
        this.f117997j = r103;
        int r121 = e1.f158934a;
        e1.b(this.f118003p, r103);
        return;
    L20:
        if (h.d(r106, true) == true) goto L23;
        r107 = "landscape";
        goto L24
    L16:
        r102 = 0;
        goto L17
    L8:
        PlayerProgressServiceContext r122 = this.f117991d;
        if (r122 == null) goto L13;
        m<Long> r123 = r122.getCurrentTime();
        if (r123 == null) goto L13;
        r101 = r123.getValue();
    L13:
        r101 = null;
        goto L14
    }

    public ReplayDurationLogger(Context r100, DataCenter r101, com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r102) {
        this.f118002o = r100;
        this.f118003p = r101;
        this.f117988a = "";
        this.f117989b = -1;
        this.f117994g = -1;
        this.f117997j = -1;
        this.f117998k = -1;
        this.f117999l = 1.0f;
        Lazy r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(ReplayDurationLogger$playerBrickService$2.INSTANCE);
        this.f118000m = r103;
        this.f118001n = new a(this);
        Boolean r104 = null;
        if (r101 == null) goto L11;
        mq1.t r105 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
        if (r105 == null) goto L9;
        IReplayInnerProgressService r106 = r105.provideVSProgressService(r101);
        if (r106 == null) goto L9;
        PlayerProgressServiceContext r107 = r106.provideContext(r101);
    L10:
        this.f117991d = r107;
    L9:
        r107 = null;
    L11:
        this.f117992e = VideoContext.n0(r100);
        if (r101 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.vs_base.log.a r108 = (com.bytedance.android.livesdk.chatroom.vs_base.log.a) r101.get("video_watch_record_logger_key", null);
    L15:
        this.f117993f = r108;
        if (r101 == null) goto L18;
        ReplayEventHub r109 = (ReplayEventHub) r101.get("zygote_event_hub", null);
    L19:
        if (r109 == null) goto L24;
        NextLiveData<Boolean> r110 = r109.f118048b;
        if (r110 == null) goto L24;
        r104 = r110.getValue();
    L24:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L26;
        b();
    L26:
        if (r102 == null) goto L33;
        LifecycleOwner r111 = r102.f118152z;
        if (r111 == null) goto L33;
        if (r109 == null) goto L33;
        NextLiveData<Boolean> r112 = r109.f118048b;
        if (r112 == null) goto L33;
        r112.observe(r111, new b(this));
    L33:
        r r113 = (r) r103.getValue();
        if (r113 == null) goto L45;
        r113.g();
        com.bytedance.android.livesdk.chatroom.replay.player.m r114 = com.bytedance.android.livesdk.chatroom.replay.player.m.f109600b;
        if (r102 == null) goto L38;
        long r115 = r102.f118149w;
    L39:
        com.bytedance.android.livesdk.chatroom.vs_base.player.c r116 = r114.a(r115);
        if (r116 != null) goto L42;
        return;
    L42:
        if (r116.getScene() != ReplayPlayerScene.PRE_PLAY) goto L47;
        r116.k(new c(this));
        return;
    L47:
        return;
    L38:
        r115 = 0;
        goto L39
    L45:
        return;
    L18:
        r109 = null;
        goto L19
    L14:
        r108 = null;
        goto L15
    }
}
