package com.bytedance.android.live.broadcastgame.widget;

import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcastgame.InteractGameService;
import com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget;
import com.bytedance.android.live.broadcastgame.api.e;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.n;
import com.bytedance.android.live.broadcastgame.f0;
import com.bytedance.android.live.broadcastgame.opengame.h;
import com.bytedance.android.live.broadcastgame.opengame.k;
import com.bytedance.android.live.broadcastgame.opengame.test.OpenGameTestHelper;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.GameHonorEffectWidget;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import i10.f;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/widget/AnchorGameWidget;", "Lcom/bytedance/android/live/broadcastgame/api/IAnchorGameWidget;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorGameWidget extends IAnchorGameWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f61790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f61791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f61792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f61793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InteractGameSEIWidget f61794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.openplatform.b f61795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j20.c f61796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f61797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.live.pushstream.d f61798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Room f61799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FragmentManager f61800k;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_anchor_game_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Aq() {
        Intrinsics.checkNotNullParameter(GameSeiConstants.KEY_GAME_IN_CAST, "key");
        InteractGameSEIWidget r100 = this.f61794e;
        if (r100 == null) goto L8;
        Intrinsics.checkNotNullParameter(GameSeiConstants.KEY_GAME_IN_CAST, "key");
        com.bytedance.android.live.pushstream.d r101 = r100.f61801a;
        if (r101 == null) goto L9;
        r101.c1(GameSeiConstants.KEY_GAME_IN_CAST, null, 1, true, true);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Cq() {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r100 = this.f61795f;
        if (r100 == null) goto L6;
        r100.d(null, null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Fq() {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r100 = this.f61795f;
        if (r100 == null) goto L6;
        r100.stopGameCastToAudience();
        return;
    }

    public final com.bytedance.android.live.pushstream.d Iq() {
        if (this.f61798i != null) goto L15;
        if (z.i(this.dataCenter) == false) goto L7;
        com.bytedance.android.live.pushstream.d r100 = ((IPushStreamService) jc1.k.n(IPushStreamService.class)).getRecordLiveStream(this.context);
    L13:
        this.f61798i = r100;
        goto L15
    L7:
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r101 == null) goto L12;
        j<com.bytedance.android.live.pushstream.d> r102 = r101.getLiveStream();
        if (r102 == null) goto L12;
        r100 = r102.getValue();
    L12:
        r100 = null;
    L15:
        return this.f61798i;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        WidgetManager r100 = this.subWidgetManager;
        if (r100 == null) goto L10;
        List<Widget> r101 = r100.widgets;
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r100.unload((Widget) r102.next());
    L10:
        com.bytedance.android.live.broadcastgame.api.openplatform.b r103 = this.f61795f;
        if (r103 == null) goto L13;
        r103.onDestroy();
    L13:
        h r104 = this.f61792c;
        if (r104 == null) goto L16;
        r104.release();
    L16:
        k r105 = this.f61793d;
        if (r105 == null) goto L19;
        r105.release();
    L19:
        j20.c r106 = this.f61796g;
        if (r106 == null) goto L26;
        View r107 = r106.getView();
        if (r107 == null) goto L26;
        ViewGroup r108 = this.containerView;
        if (r108 == null) goto L26;
        r108.removeView(r107);
    L26:
        this.f61796g = null;
        this.f61797h.dispose();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final String wq() {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r100 = this.f61795f;
        if (r100 == null) goto L6;
        String r101 = r100.getGameCategory();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void xq() {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r100 = this.f61795f;
        if (r100 == null) goto L6;
        r100.k();
        return;
    }

    public final void Gq() {
        enableSubWidgetManager();
        if (Iq() != null) goto L6;
        return;
    L6:
        if (isScreenPortrait() == false) goto L13;
        this.subWidgetManager.load(new InteractGameStartupWidget(this.f61795f));
        if (tb1.c.f545229a == false) goto L14;
        InteractGameSEIWidget r100 = new InteractGameSEIWidget(Iq());
        this.f61794e = r100;
        this.subWidgetManager.load(r100);
        com.bytedance.android.live.pushstream.d r101 = Iq();
        if (r101 == null) goto L15;
        WidgetManager r102 = this.subWidgetManager;
        long r103 = this.f61799j.f162599id;
        r102.load(R.id.effect_game_container, new LiveGameControlWidget(r101, this.f61800k));
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        n.f59498b.b(true);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        n.f59498b.b(false);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Eq(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.bytedance.android.live.broadcastgame.api.openplatform.b r101 = this.f61795f;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        com.bytedance.android.live.pushstream.d r101 = Iq();
        boolean r102 = false;
        XplayPerfPanelView r103 = null;
        if (r101 == null) goto L29;
        f0 r104 = this.f61791b;
        if (r104 == null) goto L7;
        com.bytedance.android.live.broadcastgame.opengame.a r105 = r104.c(r101, this.context, this.dataCenter, this.f61799j.f162599id, this.containerView);
    L8:
        this.f61795f = r105;
        String r106 = ((IHostContext) jc1.k.n(IHostContext.class)).getChannel();
        ALogger.d("AnchorGameWidget", "当前channel = [" + r106 + ']');
        if (StringsKt.contains$default(r106, "lark_inhouse", false, 2, null) == true) goto L11;
        LocalTestManager.a(new Class[]{wy.a.class});
    L19:
        if (StringsKt.contains$default(r106, "live_open_platform", false, 2, null) == false) goto L21;
    L22:
        f0 r107 = this.f61791b;
        if (r107 == null) goto L25;
        com.bytedance.android.live.broadcastgame.opengame.test.c r108 = r107.e();
    L26:
        this.f61793d = r108;
        if (r108 == null) goto L29;
        r108.a(this.containerView, this.context);
        goto L29
    L25:
        r108 = null;
        goto L26
    L21:
        if (v.a() == false) goto L29;
    L11:
        f0 r109 = this.f61791b;
        if (r109 == null) goto L14;
        OpenGameTestHelper r110 = r109.g();
    L15:
        this.f61792c = r110;
        if (r110 == null) goto L19;
        r110.a(this.containerView, this.context);
        goto L19
    L14:
        r110 = null;
        goto L15
    L7:
        r105 = null;
    L29:
        enableSubWidgetManager();
        this.subWidgetManager.load(R.id.open_platform_game_effect_container, new GameHonorEffectWidget());
        if (z.g(this.dataCenter) == false) goto L33;
        Gq();
    L39:
        if (v.a() == false) goto L62;
        f0 r111 = this.f61791b;
        if (r111 == null) goto L53;
        XplayPerfPanelView r112 = r111.d(this.containerView);
        if (r112 == null) goto L53;
        XplayExternalContext r113 = XplayExternalContext.Companion.getContext();
        if (r113 == null) goto L52;
        m<Boolean> r114 = r113.getOpenPerfDetect();
        if (r114 == null) goto L52;
        Boolean r115 = r114.getValue();
        if (r115 == null) goto L52;
        r102 = r115.booleanValue();
    L52:
        r112.setPerformancePanelVisible(r102);
        Unit r116 = Unit.INSTANCE;
        r103 = r112;
    L53:
        this.f61796g = r103;
        XplayExternalContext r117 = XplayExternalContext.Companion.getContext();
        if (r117 == null) goto L62;
        m<Boolean> r118 = r117.getOpenPerfDetect();
        if (r118 == null) goto L62;
        Observable<Boolean> r119 = r118.a();
        if (r119 == null) goto L62;
        Disposable r120 = r119.subscribe(new a(this));
        if (r120 == null) goto L62;
        RxUtilKt.c(r120, this.f61797h);
    L62:
        n.f59498b.k(this.context);
        return;
    L33:
        if (z.k(this.dataCenter) == false) goto L36;
        Gq();
        goto L39
    L36:
        if (z.i(this.dataCenter) == false) goto L39;
        enableSubWidgetManager();
        this.subWidgetManager.load(new InteractGameStartupWidget(this.f61795f));
        InteractGameSEIWidget r121 = new InteractGameSEIWidget(Iq());
        this.f61794e = r121;
        this.subWidgetManager.load(r121);
        goto L39
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void zq(boolean r100) {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r101 = this.f61795f;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void yq(boolean r100, Surface r101, int r102) {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r103 = this.f61795f;
        if (r103 == null) goto L6;
        r103.notifyStartLinkCastResult(r100, r101, r102);
        return;
    }

    public AnchorGameWidget(com.bytedance.android.live.pushstream.d r100, Room r101, Fragment r102, FragmentManager r103) {
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "fragmentManager");
        this.f61798i = r100;
        this.f61799j = r101;
        this.f61800k = r103;
        this.f61797h = new CompositeDisposable();
        InteractGameService.Companion.getClass();
        f r104 = (f) InteractGameService.access$getDiComponent$cp();
        r104.getClass();
        f r105 = r104.f487925a;
        this.f61790a = r105.f487926b.get();
        this.f61791b = r105.f487928d.get();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Bq(String r100, String r101, int r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        InteractGameSEIWidget r103 = this.f61794e;
        if (r103 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.live.pushstream.d r104 = r103.f61801a;
        if (r104 == null) goto L9;
        r104.c1(r100, r101, r102, r110, true);
        return;
    L9:
        return;
    }
}
