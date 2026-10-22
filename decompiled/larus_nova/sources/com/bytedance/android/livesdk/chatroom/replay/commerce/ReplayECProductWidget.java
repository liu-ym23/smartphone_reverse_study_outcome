package com.bytedance.android.livesdk.chatroom.replay.commerce;

import am2.b0;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.f;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.android.livesdkapi.livereplay.IECLiveReplayParams;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.scope.m;
import com.bytedance.live.datacontext.k;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mq1.u;
import mq1.v;
import org.json.JSONObject;
import pm1.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/commerce/ReplayECProductWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdkapi/livereplay/IECLiveReplayParams;", "Ljm1/c;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayECProductWidget extends LiveRecyclableWidget implements IECLiveReplayParams, jm1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IExternalWidget f108274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function2<Long, Boolean, Unit>> f108275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f108276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f108277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PlayerProgressServiceContext f108278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.vsplayer.model.c f108279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f108280g;

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

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_ec_product_layout;
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
    public final void z() {
    }

    @Override // com.bytedance.android.livesdkapi.livereplay.IECLiveReplayParams
    public final JSONObject getEcomLiveParams() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.e r100 = f.f117931a;
        String r101 = null;
        if (r100 == null) goto L5;
        e r102 = (e) m.f163449e.d(r100, e.class);
    L6:
        if (r102 == null) goto L11;
        Bundle r103 = r102.f108285a.getArguments();
        if (r103 == null) goto L11;
        r101 = r103.getString(VSConstants.ENTER_ECOM_LIVE_PARAMS, "");
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        return new JSONObject();
    L15:
        return new JSONObject(r101);
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        IExternalWidget r100 = this.f108274a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        r100.onUnload();
    L7:
        v r101 = s.e().provideVSPlayerViewControlService(this.dataCenter);
        if (r101 == null) goto L10;
        r101.c(PlayerViewControl.KEY.ECProduct);
    L10:
        IReplayInnerProgressService r102 = s.e().provideVSProgressService(this.dataCenter);
        if (r102 == null) goto L13;
        r102.removeProgressChangeListener(this);
    L13:
        ((ArrayList) this.f108275b).clear();
        this.f108277d.clear();
    }

    @Override // com.bytedance.android.livesdkapi.livereplay.IECLiveReplayParams
    public final Map<String, String> reportParams() {
        o r100 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.dataCenter).c(b0.class);
        if (r100 == null) goto L5;
        Map<String, String> r101 = r100.getMap();
    L6:
        LinkedHashMap r102 = new LinkedHashMap();
        if (r101 == null) goto L11;
        String r103 = r101.get("enter_from_merge");
        if (r103 == null) goto L11;
        r102.put("enter_from_merge", r103);
    L11:
        if (r101 == null) goto L15;
        String r104 = r101.get("enter_method");
        if (r104 == null) goto L15;
        r102.put("enter_method", r104);
    L15:
        r102.put("action_type", "click");
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    public ReplayECProductWidget() {
        this.f108275b = new ArrayList();
        this.f108277d = new CompositeDisposable();
        this.f108280g = true;
    }

    @Override // com.bytedance.android.livesdkapi.livereplay.IECLiveReplayParams
    public final long getReplayProgress() {
        IReplayInnerProgressService r100 = s.e().provideVSProgressService(this.dataCenter);
        if (r100 == null) goto L11;
        PlayerProgressServiceContext r101 = r100.provideContext(this.dataCenter);
        if (r101 == null) goto L11;
        com.bytedance.live.datacontext.m<Long> r102 = r101.getTotalTime();
        if (r102 == null) goto L11;
        Long r103 = r102.getValue();
        if (r103 == null) goto L11;
        return r103.longValue();
    L11:
        return 0;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        IExternalWidget r100 = this.f108274a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        r100.onShow();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.livereplay.IECLiveReplayParams
    public final void addReplayProgressListener(Function2<? super Long, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f108275b).add(r100);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        IReplayInnerProgressService r101 = s.e().provideVSProgressService(this.dataCenter);
        if (r101 == null) goto L5;
        PlayerProgressServiceContext r102 = r101.provideContext(this.dataCenter);
    L6:
        this.f108278e = r102;
        this.f108276c = (FrameLayout) this.containerView.findViewById(R.id.ec_widget_container);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        fq1.a r111 = fq1.b.a();
        View r100 = null;
        if (r111 == null) goto L5;
        Episode r112 = r111.f478400a;
    L6:
        yr1.c r101 = (yr1.c) h.f529822d.c(yr1.c.class);
        if (r101 == null) goto L35;
        Context r102 = this.context;
        if (r112 == null) goto L12;
        String r103 = String.valueOf(r112.roomId);
        if (r103 == null) goto L12;
    L13:
        if (r112 == null) goto L18;
        IBaseUser r104 = r112.author();
        if (r104 == null) goto L18;
        String r105 = r104.getIdString();
        if (r105 == null) goto L18;
    L19:
        if (r112 == null) goto L24;
        IBaseUser r106 = r112.author();
        if (r106 == null) goto L24;
        Intrinsics.checkNotNullParameter(r106, "$this$secUidExt");
        String r107 = r106.getCastSecUid();
        if (r107 == null) goto L24;
    L25:
        if (r112 == null) goto L28;
        String r108 = String.valueOf(r112.getId());
        if (r108 == null) goto L28;
    L29:
        if (r112 == null) goto L33;
        EpisodeExtraBasicInfo r113 = r112.episodeExtraBasicInfo;
        if (r113 == null) goto L33;
        long r109 = r113.getRoomStartTime();
    L34:
        IExternalWidget r114 = r101.a(r102, r103, r105, r107, r108, r109, this);
    L36:
        this.f108274a = r114;
        if (r114 != null) goto L39;
        return;
    L39:
        IReplayInnerProgressService r115 = s.e().provideVSProgressService(this.dataCenter);
        if (r115 == null) goto L42;
        r115.addProgressChangeListener(this);
    L42:
        FrameLayout r116 = this.f108276c;
        boolean r117 = false;
        if (r116 != null) goto L45;
    L56:
        u r118 = s.e().provideVSPlayerTipService(this.dataCenter);
        if (r118 == null) goto L59;
        PlayerTipsContext r119 = r118.provideVSPlayTipsContext();
    L60:
        if (r119 == null) goto L66;
        k<com.bytedance.android.livesdk.chatroom.progress.context.a> r120 = r119.getMShowPlayerTipEvent();
        if (r120 == null) goto L66;
        PublishSubject r121 = r120.onEvent();
        if (r121 == null) goto L66;
        r121.subscribe(new b(this));
    L66:
        if (r119 == null) goto L72;
        k<String> r122 = r119.getMHidePlayerTipEvent();
        if (r122 == null) goto L72;
        PublishSubject r123 = r122.onEvent();
        if (r123 == null) goto L72;
        r123.subscribe(new c(this));
    L72:
        if (r119 == null) goto L80;
        com.bytedance.live.datacontext.m<Boolean> r124 = r119.isTipsShowing();
        if (r124 == null) goto L80;
        Observable<Boolean> r125 = r124.a();
        if (r125 == null) goto L80;
        Disposable r126 = r125.subscribe(new d(this));
        if (r126 == null) goto L80;
        RxUtilKt.c(r126, this.f108277d);
    L80:
        if (r119 == null) goto L82;
        r117 = r119.getPlayerTipShowing();
    L82:
        wq(r117);
        IExternalWidget r127 = this.f108274a;
        if (r127 == null) goto L85;
        r127.onLoad();
    L85:
        IExternalWidget r128 = this.f108274a;
        if (r128 == null) goto L88;
        r100 = r128.getView();
    L88:
        FrameLayout r129 = this.f108276c;
        if (r129 == null) goto L91;
        r129.removeAllViews();
    L91:
        FrameLayout r130 = this.f108276c;
        if (r130 == null) goto L95;
        r130.addView(r100);
        return;
    L95:
        return;
    L59:
        r119 = null;
        goto L60
    L45:
        if (this.f108279f == null) goto L47;
        boolean r131 = true;
    L48:
        if (r131 == true) goto L50;
        this.f108279f = new com.bytedance.android.livesdk.chatroom.vsplayer.model.c(PlayerViewControl.KEY.ECProduct, new a(this), r116, PlayerViewControl.Type.BOTTOM, PlayerViewControl.Style.ATTACH, 0.0f, true, false, false);
    L50:
        v r132 = s.e().provideVSPlayerViewControlService(this.dataCenter);
        if (r132 == null) goto L56;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r133 = this.f108279f;
        if (r133 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException(MapController.ITEM_LAYER_TAG);
    L55:
        r132.e(r133);
        goto L56
    L47:
        r131 = false;
    L33:
        r109 = 0;
    L28:
        r108 = "";
    L24:
        r107 = "";
    L18:
        r105 = "";
    L12:
        r103 = "";
        goto L13
    L35:
        r114 = null;
        goto L36
    L5:
        r112 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.livereplay.IECLiveReplayParams
    public final void removeReplayProgressListener(Function2<? super Long, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f108275b).remove(r100);
    }

    @Override // com.bytedance.android.livesdkapi.livereplay.IECLiveReplayParams
    public final void seekReplayProgress(long r110) {
        PlayerProgressServiceContext r100 = this.f108278e;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<Long> r101 = r100.getCurrentTime();
        if (r101 == null) goto L9;
        Long r102 = r101.getValue();
        if (r102 == null) goto L9;
        long r103 = r102.longValue();
    L10:
        com.bytedance.android.livesdk.chatroom.vs_base.log.d r104 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.dataCenter);
        Pair[] r105 = new Pair[7];
        PlayerProgressServiceContext r106 = this.f108278e;
        if (r106 == null) goto L13;
        Boolean r107 = r106.isPlaying();
    L15:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L17;
        String r108 = "0";
    L18:
        r105[0] = TuplesKt.to("vs_is_pause", r108);
        r105[1] = TuplesKt.to("vs_slide_duration", String.valueOf(Math.abs(r110 - r103)));
        if (r110 <= r103) goto L21;
        String r109 = "forward";
    L22:
        r105[2] = TuplesKt.to("vs_slide_direction", r109);
        r105[3] = TuplesKt.to("duration", "0");
        r105[4] = TuplesKt.to("vs_start_watch_record", String.valueOf(r103));
        r105[5] = TuplesKt.to("vs_exit_watch_record", String.valueOf(r110));
        r105[6] = TuplesKt.to("seek_type", "click_ec_card");
        r104.d("progress_bar_slide", MapsKt.mapOf(r105), new Object[0]);
        IReplayInnerProgressService r111 = s.e().provideVSProgressService(this.dataCenter);
        if (r111 == null) goto L26;
        r111.seekTo(r110);
        return;
    L26:
        return;
    L21:
        r109 = "back";
        goto L22
    L17:
        r108 = "1";
        goto L18
    L13:
        r107 = null;
    L9:
        r103 = 0;
        goto L10
    }

    @Override // jm1.c
    public final void v2(EpisodeHighLight r100) {
        Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
        Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
    }

    public final void wq(boolean r100) {
        FrameLayout r101 = this.f108276c;
        if (r101 == null) goto L10;
        int r102 = r101.getPaddingLeft();
        int r103 = r101.getPaddingTop();
        int r104 = r101.getPaddingRight();
        if (r100 == false) goto L7;
        int r105 = s1.f(32.0f);
    L8:
        r101.setPadding(r102, r103, r104, r105);
        return;
    L7:
        r105 = 0;
        goto L8
    }

    @Override // jm1.c
    public final void Pc(float r100, boolean r101, long r102) {
        Iterator r103 = ((ArrayList) this.f108275b).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((Function2) r103.next()).invoke(Long.valueOf((long) (r102 * (r100 / 100.0f))), Boolean.valueOf(r101));
        goto L4
    L6:
        this.f108280g = !r101;
    }
}
