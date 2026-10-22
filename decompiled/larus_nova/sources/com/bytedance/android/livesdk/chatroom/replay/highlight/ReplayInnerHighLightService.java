package com.bytedance.android.livesdk.chatroom.replay.highlight;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.replay.highlight.widget.ReplayHighLightWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSSeekBarMarkRepelStack;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.e;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mq1.j;
import mq1.t;
import mq1.v;
import nic.l;
import nic.p;
import oic.f;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayInnerHighLightService implements j, o {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f108746n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f108747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f108748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f108749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f108750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f108751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<EpisodeHighLight> f108752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Pair<Integer, Integer>> f108753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f108754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f108755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.base.b f108756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.base.c f108757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final fq1.a f108758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final t f108759m;

    public static final class a {
    }

    public static final class b extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f108760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<Long, Unit> f108761b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(DataCenter r100, Function1<? super Long, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "dataCenter");
            this.f108761b = r101;
        }

        @Override // nic.l.a, nic.h
        public final void B(p r100, tic.a r101) {
            if (this.f108760a == true) goto L11;
            Function1<Long, Unit> r102 = this.f108761b;
            if (r102 == null) goto L12;
            if (r100 == null) goto L8;
            Long r103 = Long.valueOf(((f) r100).getDuration());
        L9:
            Unit r104 = r102.invoke(r103);
            return;
        L8:
            r103 = null;
            goto L9
        L12:
            return;
        }

        @Override // nic.l.a, nic.h
        public final void q(f r100, tic.a r101, int r102, int r103) {
            if (this.f108760a == true) goto L10;
            Function1<Long, Unit> r104 = this.f108761b;
            if (r104 == null) goto L11;
            if (r100 == null) goto L8;
            r103 = r100.getDuration();
        L8:
            Unit r105 = r104.invoke(Long.valueOf(r103));
            return;
        L11:
            return;
        }
    }

    public static final class c implements jm1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayInnerHighLightService f108762a;

        @Override // jm1.c
        public final void C5() {
        }

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
        public final void l3() {
        }

        @Override // jm1.c
        public final void onRenderStart() {
        }

        @Override // jm1.c
        public final void v2(EpisodeHighLight r100) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
        }

        @Override // jm1.c
        public final void z() {
        }

        public c(ReplayInnerHighLightService r100) {
            this.f108762a = r100;
        }

        @Override // jm1.c
        public final void Pc(float r100, boolean r101, long r102) {
            if (r101 == false) goto L5;
            this.f108762a.c();
            return;
        }
    }

    static {
    }

    public final void c() {
        ReplayHighLightWidget r100 = (ReplayHighLightWidget) this.f108751e.getValue();
        View r101 = r100.contentView;
        if (r101 == null) goto L5;
        r101.setOnClickListener(null);
    L5:
        View r102 = r100.contentView;
        if (r102 == null) goto L8;
        UtilityKotlinExtentionsKt.i(r102);
    L8:
        this.f108754h = null;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        IReplayInnerProgressService r100 = (IReplayInnerProgressService) this.f108749c.getValue();
        Disposable r101 = null;
        if (r100 == null) goto L5;
        final PlayerProgressServiceContext r102 = r100.provideContext(this.f108747a);
    L6:
        final VideoContext r103 = VideoContext.n0(this.f108748b);
        Episode r104 = this.f108758l.f478400a;
        if (r104 != null) goto L9;
    L36:
        ALogger.e("ReplayInnerHighLightService", "onCreate:null vsDataContext");
        v r105 = this.f108759m.provideVSPlayerViewControlService(this.f108747a);
        if (r105 == null) goto L45;
        VSPlayerViewControlContext r106 = r105.provideContext();
        if (r106 == null) goto L45;
        m<Boolean> r107 = r106.getPlayerViewVisible();
        if (r107 == null) goto L45;
        Observable<Boolean> r108 = r107.a();
        if (r108 == null) goto L45;
        r101 = r108.subscribe(new com.bytedance.android.livesdk.chatroom.replay.highlight.a(this));
    L45:
        this.f108754h = r101;
        return;
    L9:
        if (r104.highlights == null) goto L47;
        ((ArrayList) this.f108752f).clear();
        ((ArrayList) this.f108752f).addAll(r104.highlights);
        if (r102 == null) goto L16;
        VSSeekBarMarkRepelStack r109 = r102.getProgressMarkStack();
        if (r109 == null) goto L16;
        Pair<String, List<e>> r110 = r109.a();
    L18:
        if (r110 != null) goto L20;
    L23:
        boolean r111 = true;
    L25:
        if ((true ^ ((ArrayList) this.f108752f).isEmpty()) == false) goto L28;
        if (r111 == false) goto L28;
        b r112 = new b(this.f108747a, new ReplayInnerHighLightService$initHighLightList$$inlined$let$lambda$1(this, r102, r103));
        this.f108750d = r112;
        r103.D0(r112);
    L33:
        IReplayInnerProgressService r113 = (IReplayInnerProgressService) this.f108749c.getValue();
        if (r113 == null) goto L36;
        r113.addProgressChangeListener(this.f108755i);
    L28:
        StringBuilder r114 = new StringBuilder("onCreate:fail to add HighLight size=[");
        r114.append(((ArrayList) this.f108752f).size());
        r114.append("], stackState = ");
        r114.append(r111);
        r114.append(",stackFirst = ");
        if (r110 == null) goto L31;
        String r115 = r110.getFirst();
    L32:
        r114.append(r115);
        ALogger.e("ReplayInnerHighLightService", r114.toString());
        goto L33
    L31:
        r115 = null;
        goto L32
    L20:
        if (Intrinsics.areEqual(r110.getFirst(), "VS_HIGH_LIGHT") == true) goto L23;
        r111 = false;
    L16:
        r110 = null;
        goto L18
    L47:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        VideoContext.n0(this.f108748b).K0(this.f108750d);
        IReplayInnerProgressService r100 = (IReplayInnerProgressService) this.f108749c.getValue();
        if (r100 == null) goto L5;
        r100.removeProgressChangeListener(this.f108755i);
    L5:
        Disposable r101 = this.f108754h;
        if (r101 != null) goto L8;
    L9:
        Disposable r102 = this.f108754h;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        this.f108754h = null;
        return;
    L8:
        if (r101.isDisposed() == true) goto L12;
        goto L9
    }

    @Override // mq1.j
    public final void a(Function0<Pair<Integer, Integer>> r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.f108753g = r100;
    }

    public ReplayInnerHighLightService(com.bytedance.android.livesdk.chatroom.vs_base.base.b r100, com.bytedance.android.livesdk.chatroom.vs_base.base.c r101, fq1.a r102, t r103) {
        Intrinsics.checkNotNullParameter(r100, "replayFragmentScope");
        Intrinsics.checkNotNullParameter(r101, "replayInteractionFragmentScope");
        Intrinsics.checkNotNullParameter(r102, "episodeHelper");
        Intrinsics.checkNotNullParameter(r103, "playerService");
        this.f108756j = r100;
        this.f108757k = r101;
        this.f108758l = r102;
        this.f108759m = r103;
        this.f108747a = r101.getDataCenter();
        this.f108748b = r100.b();
        this.f108749c = LazyKt.lazy(new ReplayInnerHighLightService$progressService$2(this));
        this.f108751e = LazyKt.lazy(ReplayInnerHighLightService$widget$2.INSTANCE);
        this.f108752f = new ArrayList();
        this.f108755i = new c(this);
    }
}
