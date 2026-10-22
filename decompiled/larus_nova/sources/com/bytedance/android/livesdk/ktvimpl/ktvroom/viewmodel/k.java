package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.model.api.q0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.f9;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.PlayFlag;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdk.utils.d5;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class k extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f145503y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvimpl.base.sei.f f145504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f145505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f145506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f145507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final KtvContext f145508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f145509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f145510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<MusicPanel> f145511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f145512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f145513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f145514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.midi.b f145515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f145516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f145517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f145518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f145519p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f145520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f145521r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f145522s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f145523t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final oe2.b f145524u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final sb0.b f145525v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> f145526w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Function2<Integer, Long, Unit> f145527x;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f145528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145529b;

        public b(k r100, int r101) {
            this.f145528a = r100;
            this.f145529b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ChorusContext.a r102 = ChorusContext.Companion;
            KtvMusic r103 = null;
            if (r102.c() == false) goto L12;
            ChorusContext r104 = r102.getContext();
            if (r104 == null) goto L11;
            com.bytedance.live.datacontext.n<List<MusicPanel>> r105 = r104.getChorusSelectedSongList();
            if (r105 == null) goto L11;
            List<MusicPanel> r106 = r105.getValue();
            if (r106 == null) goto L11;
            MusicPanel r107 = (MusicPanel) CollectionsKt.firstOrNull(r106);
        L14:
            if (((Boolean) KtvSettingHelper.f70653q0.getValue()).booleanValue() == false) goto L19;
            int r108 = this.f145529b;
            if (r107 == null) goto L18;
            r103 = r107.f153577a;
        L18:
            JSONObject r109 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.c(r108, r103, this.f145528a.f145516m);
        L24:
            if (this.f145529b != 0) goto L34;
            KtvRoomContext.Companion.getClass();
            KtvRoomContext r110 = KtvRoomContext.a.a();
            if (r110 == null) goto L34;
            com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r111 = r110.getPreviewViewModel();
            if (r111 == null) goto L34;
            KtvPreviewSongsViewModel r112 = r111.getValue();
            if (r112 == null) goto L34;
            if (r112.isShowPreviewCard() != true) goto L34;
            r109.put("play_flag", PlayFlag.PREVIEW_SONG.ordinal());
        L34:
            this.f145528a.p(r109);
            return;
        L19:
            int r113 = this.f145529b;
            MusicPanel r114 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.f145528a.f145508e);
            if (r114 == null) goto L22;
            r103 = r114.f153577a;
        L22:
            r109 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.c(r113, r103, this.f145528a.f145516m);
        L11:
            r107 = null;
            goto L14
        L12:
            r107 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.f145528a.f145508e);
            goto L14
        }
    }

    public static final class c implements com.bytedance.android.livesdk.ktvimpl.base.sei.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f145530a;

        public c(k r100) {
            this.f145530a = r100;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
        public final boolean accept(com.bytedance.android.livesdk.ktvimpl.base.sei.w r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r101 = r100.f143344b;
            if ((r101 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == true) goto L5;
        L9:
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r102 = r100.f143344b;
            if ((r102 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.g) == false) goto L12;
            this.f145530a.f145525v.b().a();
            ((com.bytedance.android.livesdk.ktvimpl.base.sei.g) r102).getClass();
            return true;
        L12:
            return false;
        L5:
            if ((!Intrinsics.areEqual(r101.a(), this.f145530a.f145525v.f())) == false) goto L8;
            com.bytedance.android.livesdk.ktvimpl.base.sei.i r103 = (com.bytedance.android.livesdk.ktvimpl.base.sei.i) r100.f143344b;
            this.f145530a.f145525v.b().a();
            r103.getClass();
            return true;
        L8:
            if (this.f145530a.f145508e.getKtvAllState().getValue().intValue() != 8) goto L9;
            return true;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
        public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r110) {
            Intrinsics.checkNotNullParameter(r110, "result");
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r100 = r110.f143344b;
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r101 = null;
            if ((r100 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == true) goto L5;
            r100 = null;
        L5:
            com.bytedance.android.livesdk.ktvimpl.base.sei.i r102 = (com.bytedance.android.livesdk.ktvimpl.base.sei.i) r100;
            if (r102 == null) goto L24;
            k r103 = this.f145530a;
            JSONObject r104 = new JSONObject(r110.f143343a);
            r103.getClass();
            Intrinsics.checkNotNullParameter(r102, "seiModel");
            Intrinsics.checkNotNullParameter(r104, "sourceSei");
            if (r102.c() != (-1)) goto L20;
            MidiContext.a r105 = MidiContext.Companion;
            r105.getClass();
            if (MidiContext.a.e(null) == false) goto L20;
            com.bytedance.android.live.ktv.common.midi.b r106 = r103.f145515l;
            float r107 = r102.g();
            int r108 = r102.f();
            MidiContext r109 = r105.getContext();
            if (r109 == null) goto L18;
            com.bytedance.live.datacontext.j<g0> r111 = r109.getMidiConfig();
            if (r111 == null) goto L18;
            g0 r112 = r111.getValue();
            if (r112 == null) goto L18;
            Map<String, q0> r113 = r112.b();
        L19:
            int r114 = r106.b(r107, r108, r113);
        L21:
            JSONObject r115 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.a(r102.j(), r102.i(), r102.g(), r102.f(), r102.e(), r102.b(), r114, r102.h(), 1);
            com.bytedance.android.livesdk.ktvimpl.base.sei.f r116 = r103.f145504a;
            if (r116 == null) goto L24;
            r116.a("ktv_midi_sei", r115);
        L18:
            r113 = null;
        L20:
            r114 = r102.c();
        L24:
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r117 = r110.f143344b;
            if ((r117 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.g) == false) goto L28;
            r101 = r117;
        L28:
            com.bytedance.android.livesdk.ktvimpl.base.sei.g r118 = (com.bytedance.android.livesdk.ktvimpl.base.sei.g) r101;
            if (r118 == null) goto L34;
            k r119 = this.f145530a;
            JSONObject r120 = new JSONObject(r110.f143343a);
            r119.getClass();
            Intrinsics.checkNotNullParameter(r118, "midiSeiModel");
            Intrinsics.checkNotNullParameter(r120, "sourceSei");
            Intrinsics.checkNotNullParameter(r118, "midiSeiModel");
            Intrinsics.checkNotNullParameter(r120, "sourceSei");
            com.bytedance.android.livesdk.ktvimpl.base.sei.f r121 = r119.f145504a;
            if (r121 == null) goto L35;
            r121.a("ktv_score_sei", r120);
            return;
        L35:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f145531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f145532b;

        public d(k r100, long r101) {
            this.f145531a = r100;
            this.f145532b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.live.network.response.e r100 = (com.bytedance.android.live.network.response.e) r110;
            mb0.c.a.b(pd2.d.f528658n, LinkMonitorData.ApiGetSingingHotResult, System.currentTimeMillis() - this.f145532b, r100.logId);
            com.bytedance.android.live.ktv.common.model.api.e r101 = (com.bytedance.android.live.ktv.common.model.api.e) r100.data;
            com.bytedance.android.livesdk.ktvimpl.base.sei.n r111 = new com.bytedance.android.livesdk.ktvimpl.base.sei.n(r101.b(), r101.c(), r101.d(), r101.g(), r101.e(), r101.f(), r101.a(), this.f145531a.f145512i / ((long) 1000));
            KtvContext.Companion.getClass();
            KtvContext r102 = KtvContext.a.g();
            if (r102 == null) goto L5;
            r102.updateSingEndedFeedback(r111);
        L5:
            RxUtilKt.h(Observable.create(new p(this, r101)).subscribeOn(Schedulers.computation())).subscribe(new q(this), new r(this));
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f145533a;

        public e(k r100, long r101) {
            this.f145533a = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            String r102 = "getKtvSingingHotResult exception: " + r101.getStackTrace();
            ALogger.i(bb0.b.b(), r102 + ", invoke class :" + k.class.getSimpleName());
            mb0.c.a.a(pd2.d.f528658n, LinkMonitorData.ApiGetSingingHotResult, System.currentTimeMillis() - this.f145533a, r101);
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void f(com.bytedance.android.livesdk.ktvimpl.base.sei.k r100) {
        Intrinsics.checkNotNullParameter(r100, "seiModel");
    }

    static {
        f145503y = ((long) ((Number) vm2.h.f556127f4.getValue(null, vm2.h.f556082a[264(0x108, float:3.7E-43)])).intValue()) * 1000;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void i() {
        ALogger.i(bb0.b.b(), "KtvRoomAnchorController reset, invoke class :".concat(k.class.getSimpleName()));
        this.f145519p = true;
        this.f145505b.dispose();
        this.f145506c.dispose();
        this.f145521r.dispose();
        this.f145509f = -1;
        this.f145514k = true;
        this.f145508e.getSeiProcessor().getValue().g(this.f145523t);
        ((ArrayList) this.f145511h).clear();
        this.f145507d.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void c(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "valid");
        KtvRoomLyricsStateMachineConfig.d r100 = (KtvRoomLyricsStateMachineConfig.d) r110.f66101c;
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L6;
        k(r110);
        return;
    L6:
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L9;
        k(r110);
        return;
    L9:
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L45;
        KtvRoomLyricsStateMachineConfig.d.f r101 = (KtvRoomLyricsStateMachineConfig.d.f) r100;
        KtvRoomLyricsStateMachineConfig.c r102 = r101.f145412d;
        float r103 = r102.f145403a;
        long r104 = r102.f145404b.f153577a.getMDuration() * 1000;
        if (r103 <= 0) goto L20;
        if (r104 <= 0) goto L20;
        if (this.f145520q == true) goto L20;
        if (r103 < f145503y) goto L20;
        this.f145520q = true;
        MusicPanel r105 = r101.f145409b;
        long r111 = r105.f153577a.getMId();
        String r106 = r105.f153577a.getOrderUserIdString();
        long r107 = System.currentTimeMillis();
        this.f145521r = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).addSongStatusForRebroadcast(this.f145517n, d5.c(r106), r106, r111, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(r107), new o(r107));
    L20:
        if ((r110.f66099a instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L22;
        this.f145512i = System.currentTimeMillis();
        this.f145513j = false;
    L22:
        KtvMusic r112 = r101.f145409b.f153577a;
        String r108 = this.f145510g;
        Lazy r109 = KtvUtilsKt.f70681a;
        Intrinsics.checkNotNullParameter(r112, "$this$isSelf");
        OrderInfo r113 = r112.getOrderInfo();
        if (r113 == null) goto L27;
        InteractiveSongUserInfo r114 = r113.getTopUser();
        if (r114 == null) goto L27;
        String r115 = r114.getIdString();
    L28:
        if (r108 != null) goto L36;
        IMiddlewareUserService r116 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r116 == null) goto L34;
        com.bytedance.android.livesdk.user.e r117 = r116.user();
        if (r117 == null) goto L34;
        r108 = r117.n();
    L34:
        r108 = null;
    L36:
        if (Intrinsics.areEqual(r115, r108) == false) goto L38;
    L39:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r118 = r101.f145411c;
        if (r118 == null) goto L47;
        q(r118, r101.f145409b);
        return;
    L47:
        return;
    L38:
        if (ChorusContext.Companion.c() == true) goto L39;
        return;
    L27:
        r115 = null;
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void h(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "valid");
        KtvRoomLyricsStateMachineConfig.b r101 = (KtvRoomLyricsStateMachineConfig.b) r100.f66102d;
        if ((r101 instanceof KtvRoomLyricsStateMachineConfig.b.a) == false) goto L6;
        i();
        return;
    L6:
        if ((r101 instanceof KtvRoomLyricsStateMachineConfig.b.C2265b) == false) goto L37;
        this.f145514k = false;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isKtvMode() == false) goto L10;
        OrderedSongDataContext r102 = KtvModeOrderedSongDataContext.Companion.getContext();
    L11:
        if (r102 == null) goto L15;
        Disposable r103 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b.a.a(r102, false, new l(this), 3);
        if (r103 == null) goto L15;
        RxUtilKt.c(r103, this.f145507d);
    L15:
        ChorusContext.a r104 = ChorusContext.Companion;
        ChorusContext r105 = r104.getContext();
        if (r105 == null) goto L24;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r106 = r105.getChorusSelectedSongList();
        if (r106 == null) goto L24;
        Observable<sh6.b<List<MusicPanel>>> r107 = r106.a();
        if (r107 == null) goto L24;
        Disposable r108 = r107.subscribe(new m(this));
        if (r108 == null) goto L24;
        RxUtilKt.c(r108, this.f145507d);
    L24:
        List<MusicPanel> r109 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(this.f145508e);
        if (r109 == null) goto L29;
        List<MusicPanel> r110 = CollectionsKt.toMutableList(r109);
        if (r110 == null) goto L29;
        m(r110);
    L29:
        ChorusContext r111 = r104.getContext();
        if (r111 == null) goto L41;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r112 = r111.getChorusSelectedSongList();
        if (r112 == null) goto L42;
        List<MusicPanel> r113 = r112.getValue();
        if (r113 == null) goto L43;
        l(r113);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L10:
        r102 = KtvComponentOrderedSongDataContext.Companion.getContext();
        goto L11
    L37:
        if ((r101 instanceof KtvRoomLyricsStateMachineConfig.b.e) == false) goto L45;
        j(2);
        return;
    }

    public final void j(int r100) {
        if (this.f145505b.isDisposed() == true) goto L7;
        if (this.f145509f != r100) goto L7;
        return;
    L7:
        if (this.f145514k == false) goto L10;
        return;
    L10:
        if (this.f145518o == true) goto L12;
    L14:
        MusicPanel r101 = this.f145526w.b().b();
        ChorusContext.a r102 = ChorusContext.Companion;
        String r103 = null;
        if (r102.c() == false) goto L24;
        ChorusContext r104 = r102.getContext();
        if (r104 == null) goto L23;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r105 = r104.getChorusSelectedSongList();
        if (r105 == null) goto L23;
        List<MusicPanel> r106 = r105.getValue();
        if (r106 == null) goto L23;
        MusicPanel r107 = (MusicPanel) CollectionsKt.firstOrNull(r106);
    L25:
        ALogger.i("logKtvMainPath", ("anchor beginPing：" + r100) + ", invoke class :" + k.class.getSimpleName());
        if (this.f145509f == r100) goto L28;
    L63:
        this.f145505b.dispose();
        this.f145509f = r100;
        int r108 = com.bytedance.android.livesdk.ktvimpl.base.c.f142400a;
        this.f145505b = du2.a.b(0, ((Number) vm2.h.Y2.getValue(null, vm2.h.f556082a[205(0xcd, float:2.87E-43)])).longValue() * ((long) 1000.0f), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r100));
        String r109 = "beginPing:state:" + r100;
        if (r107 == null) goto L76;
        JSONObject r110 = new JSONObject();
        r110.put("extra", r109);
        r110.put("fullTrackLocalPath", r107.f153590n);
        r110.put("accompanimentTrackLocalPath", r107.f153591o);
        r110.put("lrcLocalPath", r107.f153588l);
        r110.put("midiLocalPath", r107.f153593q);
        r110.put("state", r107.f153578b);
        r110.put(NativeDownloadModel.JsonKey.ID, r107.f153577a.getMId());
        r110.put("mTitle", r107.f153577a.getMTitle());
        OrderInfo r111 = r107.f153577a.getOrderInfo();
        if (r111 == null) goto L71;
        Intrinsics.checkNotNullParameter(r111, "$this$topUserFlex");
        b8 r112 = r111.getTopUser();
        if (r112 == null) goto L71;
        r103 = r112.getNickNameFlex();
    L71:
        r110.put("to_nickName", r103);
        r110.put("source", r107.f153582f);
        ALogger.i(bb0.b.b(), r110.toString());
        return;
    L76:
        return;
    L28:
        if (r100 != 1) goto L63;
        if (r101 == null) goto L33;
        KtvMusic r113 = r101.f153577a;
        if (r113 == null) goto L33;
        Long r114 = Long.valueOf(r113.getMId());
    L34:
        if (r107 == null) goto L38;
        KtvMusic r115 = r107.f153577a;
        if (r115 == null) goto L38;
        Long r116 = Long.valueOf(r115.getMId());
    L40:
        if ((!Intrinsics.areEqual(r114, r116)) == true) goto L63;
        if (r101 == null) goto L49;
        KtvMusic r117 = r101.f153577a;
        if (r117 == null) goto L49;
        OrderInfo r118 = r117.getOrderInfo();
        if (r118 == null) goto L49;
        InteractiveSongUserInfo r119 = r118.getTopUser();
        if (r119 == null) goto L49;
        String r120 = r119.getIdString();
    L50:
        if (r107 == null) goto L58;
        KtvMusic r121 = r107.f153577a;
        if (r121 == null) goto L58;
        OrderInfo r122 = r121.getOrderInfo();
        if (r122 == null) goto L58;
        InteractiveSongUserInfo r123 = r122.getTopUser();
        if (r123 == null) goto L58;
        String r124 = r123.getIdString();
    L60:
        if ((true ^ Intrinsics.areEqual(r120, r124)) == true) goto L63;
        if (r101 != null) goto L74;
        if (r107 == null) goto L63;
        return;
    L74:
        return;
    L58:
        r124 = null;
    L49:
        r120 = null;
    L38:
        r116 = null;
    L33:
        r114 = null;
    L23:
        r107 = null;
        goto L25
    L24:
        r107 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.f145508e);
        goto L25
    L12:
        if (this.f145519p == false) goto L14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r100) {
        STATE r101 = r100.f66099a;
        if ((r101 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L8;
        if (r101 == 0) goto L7;
        MusicPanel r102 = ((KtvRoomLyricsStateMachineConfig.d.f) r101).f145409b;
        Intrinsics.checkNotNullParameter(r102, "panel");
        o(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    }

    public final void l(List<MusicPanel> r100) {
        ChorusContext.a r101 = ChorusContext.Companion;
        if (r101.c() == true) goto L6;
        return;
    L6:
        if (r101.d() == true) goto L11;
        ((ArrayList) this.f145511h).clear();
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L62;
        KtvContext.a.g().updateCurrentUserIsSinger(false);
        return;
    L62:
        return;
    L11:
        if (r100 == null) goto L63;
        boolean r102 = n(CollectionsKt.toMutableList(r100));
        com.bytedance.android.livesdk.ktvimpl.chorus.a.a("KtvRoomAnchorController", "isDiffFirst:" + r102);
        Float r103 = null;
        if (r102 == true) goto L16;
        r100 = null;
    L16:
        if (r100 == null) goto L64;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r100.iterator();
    L19:
        if (r105.hasNext() == false) goto L23;
        Object r106 = r105.next();
        if ((true ^ ((MusicPanel) r106).f153581e) == false) goto L19;
        r104.add(r106);
        goto L19
    L23:
        StringBuilder r107 = new StringBuilder("KtvRoomAnchorController-newList:");
        r107.append(r104.size());
        r107.append(".currentSelectedList:");
        List<MusicPanel> r108 = this.f145511h;
        if (r108 == null) goto L26;
        Integer r109 = Integer.valueOf(((ArrayList) r108).size());
    L27:
        r107.append(r109.intValue());
        com.bytedance.android.livesdk.ktvimpl.chorus.a.a("KtvRoomAnchorController", r107.toString());
        MusicPanel r110 = (MusicPanel) CollectionsKt.firstOrNull(this.f145511h);
        ((ArrayList) this.f145511h).clear();
        ((ArrayList) this.f145511h).addAll(r104);
        if (r104.size() > 0) goto L38;
        j(0);
        MusicPanel r111 = this.f145526w.b().b();
        if (r111 == null) goto L34;
        KtvMusic r112 = r111.f153577a;
        if (r112 == null) goto L34;
        long r113 = r112.getMId();
    L35:
        this.f145526w.d(KtvRoomLyricsStateMachineConfig.a.h.f145394c, null);
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L44;
        this.f145527x.invoke(2, Long.valueOf(r113));
        KtvContext.a.g().updateCurrentUserIsSinger(false);
    L44:
        KtvContext.Companion.getClass();
        KtvContext r114 = KtvContext.a.g();
        if (r114 == null) goto L51;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r115 = r114.getKtvCoreController();
        if (r115 == null) goto L51;
        com.bytedance.android.livesdk.ktvimpl.base.i r116 = r115.getValue();
        if (r116 == null) goto L51;
        r103 = Float.valueOf(r116.c());
    L51:
        if (r103 != null) goto L53;
        return;
    L53:
        if ((!Intrinsics.areEqual(r103, 0.0f)) == false) goto L66;
        if (r110 == null) goto L67;
        pd2.d r117 = pd2.d.f528658n;
        float r118 = r103.floatValue();
        r117.getClass();
        pd2.d.A(r110, r118);
        return;
    L67:
        return;
    L66:
        return;
    L34:
        r113 = 0;
        goto L35
    L38:
        MusicPanel r119 = (MusicPanel) CollectionsKt.getOrNull(r104, 0);
        if (r119 == null) goto L44;
        this.f145527x.invoke(1, Long.valueOf(r119.f153577a.getMId()));
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L43;
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r120 = this.f145526w;
        KtvRoomLyricsStateMachineConfig.a.i r121 = new KtvRoomLyricsStateMachineConfig.a.i(r119);
        StateMachine.a r122 = StateMachine.f66079c;
        r120.d(r121, null);
        goto L44
    L43:
        KtvContext.a.g().updateCurrentUserIsSinger(true);
        goto L44
    L26:
        r109 = null;
        goto L27
    L64:
        return;
    }

    public final void m(List<MusicPanel> r210) {
        if (ChorusContext.Companion.c() == false) goto L5;
        return;
    L5:
        boolean r100 = n(r210);
        String r101 = bb0.b.b();
        ALogger.i(r101, ("isDiffFirst:" + r100) + ", invoke class :" + Boolean.class.getSimpleName());
        Float r102 = null;
        if (r100 == false) goto L8;
        List<MusicPanel> r103 = r210;
    L9:
        if (r103 == null) goto L86;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        Object r106 = r105.next();
        if ((true ^ ((MusicPanel) r106).f153581e) == false) goto L12;
        r104.add(r106);
        goto L12
    L16:
        StringBuilder r107 = new StringBuilder("KtvRoomAnchorController-newList:");
        r107.append(r104.size());
        r107.append(".currentSelectedList:");
        List<MusicPanel> r108 = this.f145511h;
        if (r108 == null) goto L19;
        Integer r109 = Integer.valueOf(((ArrayList) r108).size());
    L20:
        r107.append(r109.intValue());
        String r110 = r107.toString();
        ALogger.i(bb0.b.b(), r110 + ", invoke class :" + k.class.getSimpleName());
        MusicPanel r111 = (MusicPanel) CollectionsKt.firstOrNull(this.f145511h);
        boolean r112 = false;
        if (((Boolean) KtvSettingHelper.S.getValue()).booleanValue() == false) goto L23;
        j(0);
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r113 = this.f145526w;
        KtvRoomLyricsStateMachineConfig.a.h r114 = KtvRoomLyricsStateMachineConfig.a.h.f145394c;
        StateMachine.a r115 = StateMachine.f66079c;
        r113.d(r114, null);
    L23:
        ((ArrayList) this.f145511h).clear();
        ((ArrayList) this.f145511h).addAll(r104);
        if (r104.size() > 0) goto L34;
        j(0);
        MusicPanel r116 = this.f145526w.b().b();
        if (r116 == null) goto L30;
        KtvMusic r117 = r116.f153577a;
        if (r117 == null) goto L30;
        long r118 = r117.getMId();
    L31:
        this.f145526w.d(KtvRoomLyricsStateMachineConfig.a.h.f145394c, null);
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L68;
        this.f145527x.invoke(2, Long.valueOf(r118));
        KtvContext.a.g().updateCurrentUserIsSinger(false);
    L68:
        KtvContext.Companion.getClass();
        KtvContext r119 = KtvContext.a.g();
        if (r119 == null) goto L75;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r120 = r119.getKtvCoreController();
        if (r120 == null) goto L75;
        com.bytedance.android.livesdk.ktvimpl.base.i r121 = r120.getValue();
        if (r121 == null) goto L75;
        r102 = Float.valueOf(r121.c());
    L75:
        if (r102 != null) goto L77;
        return;
    L77:
        if ((!Intrinsics.areEqual(r102, 0.0f)) == false) goto L88;
        if (r111 == null) goto L89;
        pd2.d r122 = pd2.d.f528658n;
        float r123 = r102.floatValue();
        r122.getClass();
        pd2.d.A(r111, r123);
        return;
    L89:
        return;
    L88:
        return;
    L30:
        r118 = 0;
        goto L31
    L34:
        int r124 = mb0.f.f512760a;
        MusicPanel r125 = (MusicPanel) CollectionsKt.getOrNull(r104, 0);
        if (r125 == null) goto L37;
        Long r126 = Long.valueOf(r125.c());
    L38:
        JSONObject r127 = new JSONObject();
        if (r126 == null) goto L41;
        r126.longValue();
        r127.put("songId", r126.longValue());
    L41:
        int r128 = rd0.a.f537202a;
        MultiTraceData$TraceBusiness r129 = MultiTraceData$TraceBusiness.KTV;
        MultiTraceData$TraceEvent r130 = MultiTraceData$TraceEvent.MusicPlayFlow;
        rd0.a.b(r129, r130, "anchorSendWaitingStateSei", 0, null, r127, 88);
        j(1);
        MusicPanel r131 = (MusicPanel) CollectionsKt.getOrNull(r104, 0);
        if (r131 == null) goto L68;
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a.d(r131.f153577a) == false) goto L58;
        this.f145527x.invoke(1, Long.valueOf(r131.f153577a.getMId()));
        pd2.d r132 = pd2.d.f528658n;
        pd2.d.M(r132, r131, "be_singer");
        pd2.d.M(r132, r131, "singer_comfirm");
        Long r133 = Long.valueOf(r131.c());
        String r134 = r131.e();
        KtvContext.Companion.getClass();
        boolean r135 = KtvContext.a.g().isCurrentUserIsSinger();
        JSONObject r136 = new JSONObject();
        if (r133 == null) goto L48;
        r133.longValue();
        r136.put("songId", r133.longValue());
    L48:
        if (r134 != null) goto L50;
    L51:
        r112 = true;
    L52:
        if (r112 == true) goto L54;
        r136.put("musicName", r134);
    L54:
        r136.put("isSinger", r135);
        rd0.a.b(r129, r130, "anchorBeSinger", 0, null, r136, 88);
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L57;
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r137 = this.f145526w;
        KtvRoomLyricsStateMachineConfig.a.i r138 = new KtvRoomLyricsStateMachineConfig.a.i(r131);
        StateMachine.a r139 = StateMachine.f66079c;
        r137.d(r138, null);
        goto L68
    L57:
        KtvContext.a.g().updateCurrentUserIsSinger(true);
        Unit r140 = Unit.INSTANCE;
        goto L68
    L50:
        if (r134.length() != 0) goto L52;
    L58:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L67;
        KtvContext.a.g().updateCurrentUserIsSinger(false);
        Function2<Integer, Long, Unit> r141 = this.f145527x;
        MusicPanel r142 = this.f145526w.b().b();
        if (r142 == null) goto L65;
        KtvMusic r143 = r142.f153577a;
        if (r143 == null) goto L65;
        long r144 = r143.getMId();
    L66:
        r141.invoke(2, Long.valueOf(r144));
    L65:
        r144 = 0;
        goto L66
    L67:
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r145 = this.f145526w;
        KtvRoomLyricsStateMachineConfig.a.c r146 = new KtvRoomLyricsStateMachineConfig.a.c(r131);
        StateMachine.a r147 = StateMachine.f66079c;
        r145.d(r146, null);
        goto L68
    L37:
        r126 = null;
        goto L38
    L19:
        r109 = null;
        goto L20
    L86:
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final boolean n(List<MusicPanel> r100) {
        MusicPanel r101 = (MusicPanel) CollectionsKt.firstOrNull(this.f145511h);
        Boolean r102 = null;
        if (r101 == null) goto L7;
        KtvMusic r103 = r101.f153577a;
        if (r103 == null) goto L7;
        Long r104 = Long.valueOf(r103.getMId());
    L8:
        MusicPanel r105 = (MusicPanel) CollectionsKt.getOrNull(r100, 0);
        if (r105 == null) goto L13;
        KtvMusic r106 = r105.f153577a;
        if (r106 == null) goto L13;
        Long r107 = Long.valueOf(r106.getMId());
    L15:
        if (Intrinsics.areEqual(r104, r107) == false) goto L47;
        MusicPanel r108 = (MusicPanel) CollectionsKt.firstOrNull(this.f145511h);
        if (r108 == null) goto L25;
        KtvMusic r109 = r108.f153577a;
        if (r109 == null) goto L25;
        OrderInfo r110 = r109.getOrderInfo();
        if (r110 == null) goto L25;
        InteractiveSongUserInfo r111 = r110.getTopUser();
        if (r111 == null) goto L25;
        String r112 = r111.getIdString();
    L26:
        MusicPanel r113 = (MusicPanel) CollectionsKt.firstOrNull(r100);
        if (r113 == null) goto L35;
        KtvMusic r114 = r113.f153577a;
        if (r114 == null) goto L35;
        OrderInfo r115 = r114.getOrderInfo();
        if (r115 == null) goto L35;
        InteractiveSongUserInfo r116 = r115.getTopUser();
        if (r116 == null) goto L35;
        String r117 = r116.getIdString();
    L37:
        if (Intrinsics.areEqual(r112, r117) == false) goto L47;
        MusicPanel r118 = (MusicPanel) CollectionsKt.firstOrNull(this.f145511h);
        if (r118 == null) goto L41;
        Boolean r119 = Boolean.valueOf(r118.f153581e);
    L42:
        MusicPanel r120 = (MusicPanel) CollectionsKt.firstOrNull(r100);
        if (r120 == null) goto L46;
        r102 = Boolean.valueOf(r120.f153581e);
    L46:
        if (Intrinsics.areEqual(r119, r102) == false) goto L47;
        return false;
    L41:
        r119 = null;
    L35:
        r117 = null;
    L25:
        r112 = null;
    L47:
        return true;
    L13:
        r107 = null;
    L7:
        r104 = null;
        goto L8
    }

    public final void o(MusicPanel r110) {
        if (this.f145513j == false) goto L5;
        return;
    L5:
        if (((f9) KtvSettingHelper.f70647o0.getValue()).a() == false) goto L10;
        this.f145513j = true;
        String r100 = r110.f153577a.getOrderUserIdString();
        long r111 = r110.f153577a.getMId();
        long r101 = System.currentTimeMillis();
        this.f145506c = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getKtvSingingHotResult(this.f145517n, d5.c(r100), r100, this.f145512i / ((long) 1000), r111).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r101), new e(this, r101));
        return;
    }

    public final void p(JSONObject r100) {
        if (this.f145522s == true) goto L5;
    L7:
        ChorusContext.a r101 = ChorusContext.Companion;
        if (r101.c() == false) goto L13;
        if (r101.d() == true) goto L13;
        return;
    L13:
        if (r100.has("anchor_id") == true) goto L15;
        r100.put("anchor_id", com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(this.f145516m));
    L15:
        r100.put("scene", this.f145524u.k());
        r100.put("mode", this.f145524u.b());
        r100.put("is_in_chorus", r101.c());
        if (r100.has("sender_user_id") == true) goto L18;
        r100.put("sender_user_id", com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(this.f145516m));
    L18:
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.i r102 = KtvContext.a.g().getKtvCoreController().getValue();
        if (r102 == null) goto L37;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L37;
        if (r102.f142521f == null) goto L37;
        Long r103 = r102.f();
        if (r103 == null) goto L27;
        Object r104 = Float.valueOf(r103.longValue() / 1000.0f);
    L28:
        r100.put("duration", r104);
        Long r105 = r102.h();
        if (r105 == null) goto L31;
        Object r106 = Float.valueOf(r105.longValue() / 1000.0f);
    L32:
        r100.put("start", r106);
        Long r107 = r102.e();
        if (r107 == null) goto L35;
        Object r108 = Float.valueOf(r107.longValue() / 1000.0f);
    L36:
        r100.put("playTime", r108);
        r100.put("song_type", 1);
        goto L37
    L35:
        r108 = 0;
        goto L36
    L31:
        r106 = 0;
        goto L32
    L27:
        r104 = 0;
    L37:
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r109 = this.f145504a;
        if (r109 == null) goto L41;
        r109.a("ktv_sei", r100);
        return;
    L41:
        return;
    L5:
        if (KtvUtilsKt.v() == false) goto L7;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void g(com.bytedance.android.livesdk.ktvimpl.base.sei.k r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "seiModel");
        Intrinsics.checkNotNullParameter(r101, "sourceSei");
        int r102 = r100.d();
        if (r102 != 0) goto L5;
    L13:
        ChorusContext.a r103 = ChorusContext.Companion;
        if (r103.c() == false) goto L19;
        if (r103.d() == true) goto L19;
        return;
    L19:
        if (r103.c() == false) goto L28;
        ChorusContext r104 = r103.getContext();
        if (r104 == null) goto L27;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r105 = r104.getChorusSelectedSongList();
        if (r105 == null) goto L27;
        List<MusicPanel> r106 = r105.getValue();
        if (r106 == null) goto L27;
        MusicPanel r107 = (MusicPanel) CollectionsKt.firstOrNull(r106);
    L29:
        if (r107 == null) goto L35;
        KtvMusic r108 = r107.f153577a;
        if (r108 == null) goto L35;
        if (KtvUtilsKt.s(r108, r100.j(), r100.A()) != true) goto L35;
        j(2);
    L35:
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L39;
        p(r101);
    L39:
        if (r100.d() != 0) goto L42;
        q(r100, this.f145526w.b().b());
        return;
    L42:
        return;
    L27:
        r107 = null;
        goto L29
    L28:
        KtvContext.Companion.getClass();
        r107 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        goto L29
    L5:
        if (r102 == 3) goto L13;
        if (r102 == 4) goto L13;
        if (r102 == 5) goto L13;
        if (r102 == 6) goto L13;
    }

    public final void q(com.bytedance.android.livesdk.ktvimpl.base.sei.k r100, MusicPanel r101) {
        Intrinsics.checkNotNullParameter(r100, "seiModel");
        if ((r100.h() - (r100.y() - r100.B())) > 5) goto L7;
        if (r101 == null) goto L8;
        o(r101);
        return;
    L8:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(oe2.b r100, sb0.b r101, StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r102, Function2<? super Integer, ? super Long, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "ktvRoomProvider");
        Intrinsics.checkNotNullParameter(r101, "dataEntity");
        Intrinsics.checkNotNullParameter(r102, "stateMachine");
        Intrinsics.checkNotNullParameter(r103, "singerUpdateAction");
        this.f145524u = r100;
        this.f145525v = r101;
        this.f145526w = r102;
        this.f145527x = r103;
        this.f145505b = Disposables.disposed();
        this.f145506c = Disposables.disposed();
        this.f145507d = new CompositeDisposable();
        KtvContext.Companion.getClass();
        KtvContext r104 = KtvContext.a.g();
        this.f145508e = r104;
        this.f145509f = -1;
        this.f145510g = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n().toString();
        this.f145511h = new ArrayList();
        this.f145515l = new com.bytedance.android.live.ktv.common.midi.b();
        this.f145516m = r101.b().a();
        this.f145517n = r101.b().getRoomId();
        ReadOnlyProperty r105 = vm2.h.f556111d4;
        KProperty<?>[] r106 = vm2.h.f556082a;
        this.f145518o = ((Boolean) r105.getValue(null, r106[262(0x106, float:3.67E-43)])).booleanValue();
        this.f145521r = Disposables.disposed();
        this.f145522s = ((Boolean) vm2.h.f556119e4.getValue(null, r106[263(0x107, float:3.69E-43)])).booleanValue();
        c r107 = new c(this);
        this.f145523t = r107;
        j(0);
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a(r104.getSeiProcessor().getValue(), r107);
    }
}
