package com.bytedance.android.livesdk.chatroom.replay.player.seekbar;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.cache.historyprogress.ProgressApi;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeVideo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.e0;
import mq1.t;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/player/seekbar/ReplayProgressSyncWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lmq1/e0;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayProgressSyncWidget extends LiveRecyclableWidget implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Episode f109645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IReplayInnerProgressService f109646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlayerProgressServiceContext f109647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f109648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f109649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f109650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f109651g;

    public static final class a {
    }

    public static final class b implements jm1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayProgressSyncWidget f109652a;

        @Override // jm1.c
        public final void P1() {
        }

        @Override // jm1.c
        public final void Xa(boolean r100) {
        }

        @Override // jm1.c
        public final void g5() {
        }

        @Override // jm1.c
        public final void k2() {
        }

        @Override // jm1.c
        public final void onRenderStart() {
        }

        @Override // jm1.c
        public final void z() {
        }

        @Override // jm1.c
        public final void C5() {
            ReplayProgressSyncWidget.xq(this.f109652a);
        }

        @Override // jm1.c
        public final void l3() {
            ReplayProgressSyncWidget.xq(this.f109652a);
        }

        public b(ReplayProgressSyncWidget r100) {
            this.f109652a = r100;
        }

        @Override // jm1.c
        public final void v2(EpisodeHighLight r100) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
        }

        @Override // jm1.c
        public final void Pc(float r100, boolean r101, long r102) {
            PlayerProgressServiceContext r103 = this.f109652a.f109647c;
            if (r103 == null) goto L9;
            com.bytedance.live.datacontext.m<Long> r104 = r103.getCurrentTime();
            if (r104 == null) goto L9;
            Long r105 = r104.getValue();
            if (r105 == null) goto L9;
            long r106 = r105.longValue();
        L10:
            long r107 = System.currentTimeMillis();
            ReplayProgressSyncWidget r108 = this.f109652a;
            if ((r107 - r108.f109649e) <= r108.f109650f) goto L14;
            r108.f109649e = System.currentTimeMillis();
            this.f109652a.wq(r106);
            return;
        L14:
            return;
        L9:
            r106 = 0;
            goto L10
        }
    }

    static {
    }

    @Override // mq1.e0
    public final void FY(tq1.g r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        int r100 = this.f109648d;
        ReplayDataContext.a r101 = ReplayDataContext.Companion;
        DataCenter r102 = this.dataCenter;
        r101.getClass();
        ReplayDataContext r103 = ReplayDataContext.a.b(r102);
        if (r103 == null) goto L36;
        com.bytedance.live.datacontext.m<Integer> r104 = r103.getOrientationAfterChanged();
        if (r104 == null) goto L36;
        if (r100 != r104.getValue().intValue()) goto L36;
        DataCenter r105 = this.dataCenter;
        r101.getClass();
        ReplayDataContext r106 = ReplayDataContext.a.b(r105);
        Integer r107 = null;
        if (r106 == null) goto L13;
        com.bytedance.live.datacontext.n<Episode> r108 = r106.getEpisode();
        if (r108 == null) goto L13;
        Episode r109 = r108.getValue();
    L14:
        if (r109 == null) goto L36;
        long r110 = r109.getId();
        int r111 = sq1.c.f542957a;
        PlayerProgressServiceContext r112 = this.f109647c;
        if (r112 == null) goto L22;
        com.bytedance.live.datacontext.m<Long> r113 = r112.getCurrentTime();
        if (r113 == null) goto L22;
        Long r114 = r113.getValue();
        if (r114 == null) goto L22;
        long r115 = r114.longValue();
    L23:
        Integer r116 = 0;
        Episode r117 = this.f109645a;
        if (r117 == null) goto L28;
        EpisodeVideo r118 = r117.video;
        if (r118 == null) goto L28;
        r107 = Integer.valueOf(r118.getVideoCode());
    L28:
        HashMap<String, String> r119 = new HashMap();
        if (r116 == null) goto L31;
        String r120 = r119.put("pno", String.valueOf(r116.intValue()));
    L31:
        if (r107 == null) goto L33;
        String r121 = r119.put("vcode", String.valueOf(r107.intValue()));
    L33:
        Observable<Response<Object>> r122 = ((ProgressApi) r.n().getService(ProgressApi.class)).leave(Long.valueOf(r110), Long.valueOf(r115 / ((long) 1000)), r119);
        if (r122 == null) goto L36;
        r122.subscribe(sq1.a.f542955a, sq1.b.f542956a);
    L22:
        r115 = 0;
    L13:
        r109 = null;
    L36:
        IReplayInnerProgressService r123 = this.f109646b;
        if (r123 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L39:
        r123.removeProgressChangeListener(this.f109651g);
    }

    public ReplayProgressSyncWidget() {
        this.f109648d = 1;
        this.f109650f = 5000;
        this.f109651g = new b(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        xq(this);
    }

    @Override // mq1.e0
    public final void qj() {
        xq(this);
    }

    public static /* synthetic */ void xq(ReplayProgressSyncWidget r100) {
        IReplayInnerProgressService r101 = r100.f109646b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L5:
        PlayerProgressServiceContext r102 = r101.provideContext(r100.dataCenter);
        if (r102 == null) goto L12;
        com.bytedance.live.datacontext.m<Long> r103 = r102.getCurrentTime();
        if (r103 == null) goto L12;
        Long r104 = r103.getValue();
        if (r104 == null) goto L12;
        long r105 = r104.longValue();
    L13:
        r100.wq(r105);
        return;
    L12:
        r105 = 0;
        goto L13
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ReplayDataContext.a r101 = ReplayDataContext.Companion;
        DataCenter r102 = this.dataCenter;
        r101.getClass();
        ReplayDataContext r103 = ReplayDataContext.a.b(r102);
        if (r103 == null) goto L7;
        com.bytedance.live.datacontext.n<Episode> r104 = r103.getEpisode();
        if (r104 == null) goto L7;
        Episode r105 = r104.getValue();
    L8:
        this.f109645a = r105;
        DataCenter r106 = this.dataCenter;
        r101.getClass();
        ReplayDataContext r107 = ReplayDataContext.a.b(r106);
        if (r107 == null) goto L15;
        com.bytedance.live.datacontext.m<Integer> r108 = r107.getOrientationAfterChanged();
        if (r108 == null) goto L15;
        Integer r109 = r108.getValue();
        if (r109 == null) goto L15;
        int r110 = r109.intValue();
    L16:
        this.f109648d = r110;
        t r111 = s.e();
        if (r111 == null) goto L26;
        IReplayInnerProgressService r112 = r111.provideVSProgressService(this.dataCenter);
        if (r112 == null) goto L27;
        this.f109646b = r112;
        this.f109647c = r112.provideContext(this.dataCenter);
        IReplayInnerProgressService r113 = this.f109646b;
        if (r113 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L24:
        r113.addProgressChangeListener(this.f109651g);
        return;
    L27:
        return;
    L26:
        return;
    L15:
        r110 = 1;
    L7:
        r105 = null;
        goto L8
    }

    public final void wq(long r100) {
        if (r100 <= 0) goto L31;
        yq1.a r101 = s.c();
        boolean r102 = true;
        if (r101 != null) goto L7;
    L8:
        ReplayDataContext.a r103 = ReplayDataContext.Companion;
        DataCenter r104 = this.dataCenter;
        r103.getClass();
        ReplayDataContext r105 = ReplayDataContext.a.b(r104);
        if (r105 == null) goto L19;
        com.bytedance.live.datacontext.j<kq1.a> r106 = r105.getPaidManager();
        if (r106 == null) goto L19;
        kq1.a r107 = r106.getValue();
        if (r107 == null) goto L19;
        kq1.d r108 = r107.d();
        if (r108 == null) goto L19;
        NextLiveData<Boolean> r109 = r108.f505581b;
        if (r109 == null) goto L19;
        Boolean r110 = r109.getValue();
    L21:
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == true) goto L24;
        r102 = false;
    L24:
        Episode r111 = this.f109645a;
        if (r111 == null) goto L32;
        long r112 = r111.getId();
        if (r102 == false) goto L29;
        r100 = 0;
    L29:
        sq1.c.b(r112, r100);
        return;
    L32:
        return;
    L19:
        r110 = null;
        goto L21
    L7:
        if (r101.s(this.dataCenter) == true) goto L24;
    }
}
