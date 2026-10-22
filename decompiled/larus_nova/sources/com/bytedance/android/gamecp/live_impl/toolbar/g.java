package com.bytedance.android.gamecp.live_impl.toolbar;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.bytedance.android.gamecp.common.setting.config.m1;
import com.bytedance.android.gamecp.common.utils.GameMountMonitor;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.e1;
import com.bytedance.android.gamecp.common.utils.t;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.host_api.model.introducecard.u;
import com.bytedance.android.gamecp.host_api.model.intruducecard2.IntroduceMsgType;
import com.bytedance.android.gamecp.host_api.model.toolbar.LiveToolbarData;
import com.bytedance.android.gamecp.host_api.model.toolbar.ToolbarComponentData;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.android.gamecp.live_impl.RoomContext;
import com.bytedance.android.gamecp.live_impl.card.GamePromoteServiceApi;
import com.bytedance.android.gamecp.live_impl.toolbar.api.ToolbarApi;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.g2;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class g extends FrameLayout implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Room f57980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f57981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f57982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f57983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f57984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f57985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f57986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.gamecp.host_api.model.introducecard.l f57987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f57988i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f57989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f57990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f57991l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public xr.p f57992m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public xr.c f57993n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f57994o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f57995p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f57996q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ILiveRoomControllerProvider.ProviderSource f57997r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f57998s;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f57999a = null;

        static {
            f57999a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.gamecp.base.network.response.h r101 = (com.bytedance.android.gamecp.base.network.response.h) r100;
            Logger.e("introduce-card", "成功更新直播间状态");
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f58000a = null;

        static {
            f58000a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (r101 == null) goto L6;
            String r102 = r101.getMessage();
            if (r102 == null) goto L6;
        L7:
            Logger.e("introduce-card", r102, r101);
            return;
        L6:
            r102 = "直播间状态设置出错";
            goto L7
        }
    }

    @Override // com.bytedance.android.gamecp.live_impl.toolbar.o
    public final void onHide() {
    }

    @Override // com.bytedance.android.gamecp.live_impl.toolbar.o
    public final void onShow(ToolbarMatchInterface r100) {
    }

    public final void a() {
        Boolean r100 = this.f57983d;
        Long r101 = null;
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L8;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, null, null, 7);
        if (r102 == null) goto L28;
        r102.setDelayedClickAnchorIcon(true);
        return;
    L28:
        return;
    L8:
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L30;
        Context r103 = getContext();
        if (r103 != null) goto L12;
        return;
    L12:
        if ((r103 instanceof FragmentActivity) == true) goto L15;
        r103 = null;
    L15:
        if (r103 != null) goto L18;
        return;
    L18:
        if (this.f57990k == true) goto L33;
        this.f57990k = true;
        long r104 = System.currentTimeMillis();
        ToolbarApi r105 = (ToolbarApi) bs.e.a().b(ToolbarApi.class);
        Room r106 = this.f57980a;
        if (r106 == null) goto L23;
        r101 = Long.valueOf(r106.getId());
    L23:
        Disposable r107 = r105.getTransferPageSchema(String.valueOf(r101)).subscribe(new e(this, r104), new f(this));
        CompositeDisposable r108 = this.f57984e;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L26:
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r107, r108);
        return;
    L33:
        return;
    }

    @Override // com.bytedance.android.gamecp.live_impl.toolbar.o
    public final void onLoad() {
        Logger.d("game-promote", "Anchor Behavior onLoad, fold=" + this.f57983d + ", this=" + this);
        xr.f r100 = (xr.f) s.a(xr.f.class);
        if (r100 == null) goto L5;
        xr.p r101 = r100.getTrackService();
    L6:
        this.f57992m = r101;
        View r102 = this.f57981b;
        if (r102 == null) goto L9;
        View r103 = r102.getRootView();
    L10:
        this.f57982c = r103;
        this.f57980a = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        this.f57984e = new CompositeDisposable();
        if (Intrinsics.areEqual(this.f57983d, Boolean.FALSE) == false) goto L14;
        g();
    L14:
        if (this.f57989j == true) goto L25;
        this.f57989j = true;
        Logger.d("game-promote", "Anchor Behavior logShow, fold=" + this.f57983d + ", this=" + this);
        b("livesdk_game_promote_anchor_promote_icon_show");
        LiveTracingMonitor.EventModule r104 = t.f57302a;
        JSONObject r105 = new JSONObject();
        r105.put("live_type", com.bytedance.android.gamecp.host_api.a.b().getLiveService().getEventLiveType());
        bw.i r106 = com.bytedance.android.gamecp.host_api.a.b().getLiveService();
        if (r106 == null) goto L19;
        Object r107 = r106.dataCenterOperate(false, "data_live_anchor_game_promote_status", null, "-1");
    L20:
        r105.put("anchor_status", r107);
        if (Intrinsics.areEqual(this.f57983d, Boolean.TRUE) == false) goto L23;
        String r108 = "more";
    L24:
        r105.put("enter_from", r108);
        Unit r109 = Unit.INSTANCE;
        t.c(500, null, r105);
        goto L25
    L23:
        r108 = "live";
        goto L24
    L19:
        r107 = null;
    L25:
        Room r110 = this.f57980a;
        if (r110 == null) goto L55;
        LiveToolbarData r111 = r110.getToolbarData();
        if (r111 == null) goto L55;
        List<ToolbarComponentData> r112 = r111.getToolbarDataList();
        if (r112 == null) goto L55;
        Iterator<T> r113 = r112.iterator();
    L33:
        if (r113.hasNext() == false) goto L40;
        Object r114 = r113.next();
        if (((ToolbarComponentData) r114).getId() != 5) goto L37;
        boolean r115 = true;
    L38:
        if (r115 == false) goto L33;
    L41:
        ToolbarComponentData r116 = (ToolbarComponentData) r114;
        if (r116 == null) goto L55;
        JsonElement r117 = GsonHelper.a.f57436d.parse(r116.getExtraData());     // Catch: Throwable -> L53
        if (r117 == null) goto L46;
        JsonObject r118 = r117.getAsJsonObject();     // Catch: Throwable -> L53
    L47:
        Gson r119 = GsonHelper.get();     // Catch: Throwable -> L53
        if (r118 == null) goto L50;
        JsonElement r120 = r118.get("game_info");     // Catch: Throwable -> L53
    L51:
        ArrayList<com.bytedance.android.gamecp.host_api.model.j> r121 = (ArrayList) GsonHelper.get().fromJson(r119.toJson(r120), new com.bytedance.android.gamecp.live_impl.toolbar.a().getType());     // Catch: Throwable -> L53
    L56:
        com.bytedance.android.gamecp.live_impl.utils.k r122 = com.bytedance.android.gamecp.live_impl.utils.k.f58089a;
        Room r123 = this.f57980a;
        r122.getClass();
        com.bytedance.android.gamecp.live_impl.utils.k.c(r121, r123, null, false, true);
        if (r121 == null) goto L59;
        boolean r124 = true;
    L60:
        if (r124 == true) goto L64;
        r121 = null;
    L64:
        if (r121 == null) goto L78;
        RoomContext r125 = RoomContext.a.c(RoomContext.Companion, null, null, null, 7);
        if (r125 == null) goto L78;
        com.bytedance.live.datacontext.m<ArrayList<com.bytedance.android.gamecp.host_api.model.j>> r126 = r125.getSimplePromoteList();
        if (r126 == null) goto L78;
        if (r126.getValue().size() != 0) goto L72;
        boolean r127 = true;
    L73:
        if (r127 == true) goto L76;
        r126 = null;
    L76:
        if (r126 == null) goto L78;
        r126.setValue(r121);
        goto L78
    L72:
        r127 = false;
    L78:
        xr.f r128 = (xr.f) s.a(xr.f.class);
        if (r128 == null) goto L83;
        xr.p r129 = r128.getTrackService();
        if (r129 == null) goto L83;
        xr.c r130 = xr.p.a.a(r129);
    L84:
        this.f57993n = r130;
        if (r130 == null) goto L87;
        ((com.bytedance.android.gamecp.common.track.monitor.a) r130).attachViewAppearObserver(this.f57981b, new AnchorToolbarView$initTrack$1(this));
    L87:
        this.f57988i = true;
        Disposable r131 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().K(new d()).subscribe();
        CompositeDisposable r132 = this.f57984e;
        if (r132 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L90:
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r131, r132);
        RoomContext.a r133 = RoomContext.Companion;
        RoomContext r134 = RoomContext.a.c(r133, null, null, null, 7);
        if (r134 != null) goto L93;
        return;
    L93:
        if (r134.getDelayedClickAnchorIcon() != true) goto L107;
        RoomContext r135 = RoomContext.a.c(r133, null, null, null, 7);
        if (r135 == null) goto L97;
        r135.setDelayedClickAnchorIcon(false);
    L97:
        a();
        return;
    L107:
        return;
    L83:
        r130 = null;
        goto L84
    L59:
        r124 = false;
        goto L60
    L50:
        r120 = null;
        goto L51
    L46:
        r118 = null;
    L53:
        th = move-exception;
        yr.b.d("Error parsing json", null, th);
        goto L55
    L37:
        r115 = false;
        goto L38
    L40:
        r114 = null;
    L55:
        r121 = null;
        goto L56
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.gamecp.live_impl.toolbar.o
    public final void onUnload() {
        Logger.d("game-promote", "Anchor Behavior onUnload, fold=" + this.f57983d + ", this=" + this);
        if (this.f57988i == true) goto L6;
        return;
    L6:
        if (this.f57985f == true) goto L8;
    L23:
        this.f57980a = null;
        CompositeDisposable r100 = this.f57984e;
        if (r100 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L26:
        r100.dispose();
        this.f57988i = false;
        xr.c r101 = this.f57993n;
        if (r101 == null) goto L29;
        r101.detachViewAppearObserver();
    L29:
        this.f57993n = null;
        View r102 = this.f57982c;
        if (r102 == null) goto L35;
        int r103 = com.bytedance.android.gamecp.live_impl.utils.e.f58085a;
        xr.p r104 = this.f57992m;
        Intrinsics.checkNotNullParameter(r102, "rootView");
        if (r104 == null) goto L36;
        r104.unRegisterPageParamNode(null, r102);
        return;
    L36:
        return;
    L35:
        return;
    L8:
        if (this.f57986g <= 0) goto L23;
        long r105 = (System.currentTimeMillis() - this.f57986g) / ((long) 1000);
        Pair[] r106 = new Pair[3];
        com.bytedance.android.gamecp.host_api.model.introducecard.l r107 = this.f57987h;
        if (r107 == null) goto L12;
        String r108 = r107.gameName;
    L13:
        r106[0] = TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, String.valueOf(r108));
        com.bytedance.android.gamecp.host_api.model.introducecard.l r109 = this.f57987h;
        if (r109 == null) goto L16;
        String r110 = r109.gameId;
    L17:
        r106[1] = TuplesKt.to("game_id", String.valueOf(r110));
        r106[2] = TuplesKt.to("duration", String.valueOf(r105));
        Map<String, String> r111 = MapsKt.mutableMapOf(r106);
        Map<? extends String, ? extends String> r112 = com.bytedance.android.gamecp.common.track.b.b(LogFilterName.PAGE_SOURCE_LOG);
        Map<? extends String, ? extends String> r113 = com.bytedance.android.gamecp.common.track.b.b(LogFilterName.ROOM);
        if (r112 == null) goto L20;
        r111.putAll(r112);
    L20:
        if (r113 == null) goto L22;
        r111.putAll(r113);
    L22:
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("livesdk_game_promote_anchor_ad_passive_duration", r111);
        goto L23
    L16:
        r110 = null;
        goto L17
    L12:
        r108 = null;
        goto L13
    }

    public final void g() {
        GamePromoteServiceApi r100 = (GamePromoteServiceApi) bs.e.a().b(GamePromoteServiceApi.class);
        Room r101 = this.f57980a;
        if (r101 == null) goto L5;
        Long r102 = r101.getRoomId();
    L6:
        Disposable r103 = r100.setRoomStatus(String.valueOf(r102), "1").subscribe(a.f57999a, b.f58000a);
        CompositeDisposable r104 = this.f57984e;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L9:
        r104.add(r103);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final String getRoomId() {
        return this.f57998s;
    }

    public final ILiveRoomControllerProvider.ProviderSource getSource() {
        return this.f57997r;
    }

    public final String getUniqueKey() {
        return this.f57996q;
    }

    public final void b(String r100) {
        Pair[] r101 = new Pair[1];
        if (Intrinsics.areEqual(this.f57983d, Boolean.TRUE) == false) goto L5;
        String r102 = "more";
    L6:
        r101[0] = TuplesKt.to("enter_from", r102);
        Map<String, String> r103 = MapsKt.mutableMapOf(r101);
        Map<? extends String, ? extends String> r104 = com.bytedance.android.gamecp.common.track.b.b(LogFilterName.PAGE_SOURCE_LOG);
        Map<? extends String, ? extends String> r105 = com.bytedance.android.gamecp.common.track.b.b(LogFilterName.ROOM);
        if (r104 == null) goto L9;
        r103.putAll(r104);
    L9:
        if (r105 == null) goto L11;
        r103.putAll(r105);
    L11:
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3(r100, r103);
        return;
    L5:
        r102 = "live";
        goto L6
    }

    @Override // com.bytedance.android.gamecp.live_impl.toolbar.o
    public final void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        Logger.d("game-promote", "Anchor Behavior logClick, fold=" + this.f57983d + ", this=" + this);
        b("livesdk_game_promote_anchor_promote_icon_click");
        LiveTracingMonitor.EventModule r100 = t.f57302a;
        JSONObject r101 = new JSONObject();
        r101.put("live_type", com.bytedance.android.gamecp.host_api.a.b().getLiveService().getEventLiveType());
        r101.put("anchor_status", com.bytedance.android.gamecp.host_api.a.b().getLiveService().dataCenterOperate(false, "data_live_anchor_game_promote_status", null, "-1"));
        String r102 = "more";
        if (Intrinsics.areEqual(this.f57983d, Boolean.TRUE) == false) goto L5;
        String r103 = "more";
    L6:
        r101.put("enter_from", r103);
        Unit r104 = Unit.INSTANCE;
        t.c(501, null, r101);
        LinkedHashMap r105 = new LinkedHashMap();
        String r106 = this.f57996q;
        if (this.f57997r != ILiveRoomControllerProvider.ProviderSource.PREVIEW) goto L9;
        boolean r107 = true;
    L10:
        com.bytedance.android.gamecp.live_impl.utils.l.a(r105, r106, r107);
        xr.f r108 = (xr.f) s.a(xr.f.class);
        if (r108 == null) goto L19;
        xr.p r109 = r108.getTrackService();
        if (r109 == null) goto L19;
        Pair[] r111 = new Pair[3];
        Pair[] r112 = new Pair[1];
        if (Intrinsics.areEqual(this.f57983d, Boolean.FALSE) == false) goto L17;
        Object r113 = "live_detail";
    L18:
        r112[0] = TuplesKt.to("current_page", r113);
        r111[0] = TuplesKt.to("location", e1.a(MapsKt.mutableMapOf(r112)));
        r111[1] = TuplesKt.to("module_name", "promote_icon");
        r111[2] = TuplesKt.to(SlcElement.KEY_ATTR, e1.a(r105));
        r109.sendLog(r110, "dygame_module_click", MapsKt.mutableMapOf(r111));
        goto L19
    L17:
        r113 = "more";
    L19:
        Pair[] r114 = new Pair[2];
        r114[0] = TuplesKt.to(SlcElement.KEY_ATTR, e1.a(r105));
        Boolean r115 = this.f57983d;
        Boolean r116 = Boolean.FALSE;
        if (Intrinsics.areEqual(r115, r116) == false) goto L22;
        r102 = "live_detail";
    L22:
        r114[1] = TuplesKt.to("current_page", r102);
        d(this, null, null, MapsKt.mapOf(r114), 14);
        if (Intrinsics.areEqual(this.f57983d, r116) == false) goto L33;
        int r117 = com.bytedance.android.gamecp.common.utils.n.f57245a;
        if (com.bytedance.android.gamecp.common.utils.n.b(r110.getId()) == true) goto L31;
        Disposable r118 = ((GamePromoteServiceApi) bs.e.a().b(GamePromoteServiceApi.class)).uploadAnchorClickEvent(this.f57991l).subscribe(h.f58001a, i.f58002a);
        CompositeDisposable r119 = this.f57984e;
        if (r119 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L30:
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r118, r119);
    L31:
        a();
        return;
    L33:
        return;
    L9:
        r107 = false;
        goto L10
    L5:
        r103 = "live";
        goto L6
    }

    @Override // com.bytedance.android.gamecp.live_impl.toolbar.o
    public final void onMessage(tlc.d r110) {
        if (this.f57988i == true) goto L5;
        return;
    L5:
        if (r110 == null) goto L110;
        int r100 = r110.getIntType();
        String r101 = null;
        if (r100 == 6001) goto L68;
        if (r100 == 6004) goto L12;
        return;
    L12:
        if ((r110 instanceof com.bytedance.android.gamecp.live_impl.message.a) == true) goto L14;
        tlc.d r102 = null;
    L15:
        com.bytedance.android.gamecp.live_impl.message.a r103 = (com.bytedance.android.gamecp.live_impl.message.a) r102;
        if (r103 == null) goto L113;
        com.bytedance.android.gamecp.host_api.model.introducecard.k r104 = r103.mGameIntroduceShowMessage;
        if (r104 == null) goto L114;
        Integer r105 = r104.msgType;
        int r106 = IntroduceMsgType.REMIND_INTRODUCE.getType();
        if (r105 != null) goto L23;
        return;
    L23:
        if (r105.intValue() != r106) goto L115;
        String r111 = ((com.bytedance.android.gamecp.live_impl.message.a) r110).mGameIntroduceShowMessage.updatedIntroduce;
        if (r111 != null) goto L27;
        return;
    L27:
        if (UtilsKt.c(r111) == true) goto L30;
        r111 = null;
    L30:
        if (r111 == null) goto L117;
        u r112 = (u) GsonHelper.get().fromJson(r111, u.class);     // Catch: Exception -> L66
        if (r112 == null) goto L34;
        r101 = r112.gameId;     // Catch: Exception -> L66
    L34:
        if (r101 != null) goto L36;
    L39:
        boolean r107 = true;
    L40:
        if (r107 == true) goto L118;
        bw.i r108 = com.bytedance.android.gamecp.host_api.a.b().getLiveService();     // Catch: Exception -> L66
        if (r112 == null) goto L48;
        String r109 = r112.content;     // Catch: Exception -> L66
        if (r109 == null) goto L48;
        String r113 = r109;
    L49:
        if (r112 == null) goto L56;
        GameImageBundler r114 = r112.gameIcon;     // Catch: Exception -> L66
        if (r114 == null) goto L56;
        String r115 = r114.getThumbHeifImageUrl();     // Catch: Exception -> L66
        if (r115 == null) goto L56;
        String r116 = r115;
    L58:
        if (r112 == null) goto L63;
        String r117 = r112.gameId;     // Catch: Exception -> L66
        if (r117 == null) goto L63;
        String r118 = r117;
    L64:
        r108.showAnchorFloatBallGamePromoteNotice(1, "", r113, r116, "", 0, r118);     // Catch: Exception -> L66
        return;
    L63:
        r118 = "";
    L56:
        r116 = "";
    L48:
        r113 = "";
        goto L49
    L118:
        return;
    L36:
        if (r101.length() == 0) goto L39;
        r107 = false;
    L66:
        LocalTestManager.a(new Class[]{uv.a.class});
        return;
    L117:
        return;
    L115:
        return;
    L114:
        return;
    L113:
        return;
    L14:
        r102 = r110;
        goto L15
    L68:
        if (r110.getIntType() == 6001) goto L70;
    L72:
        boolean r119 = false;
    L73:
        if (r119 == true) goto L76;
        r110 = null;
    L76:
        if (r110 == null) goto L109;
        com.bytedance.android.gamecp.live_impl.message.c r120 = (com.bytedance.android.gamecp.live_impl.message.c) r110;
        if ((r120.E() instanceof com.bytedance.android.gamecp.host_api.model.introducecard.l) == true) goto L81;
        r120 = null;
    L81:
        if (r120 == null) goto L83;
        com.bytedance.android.gamecp.host_api.model.introducecard.l r121 = r120.E();
    L84:
        if (r121 == null) goto L107;
        int r122 = r121.type;
        if (r122 != 2) goto L88;
        LiveTracingMonitor.EventModule r123 = t.f57302a;
        JSONObject r124 = new JSONObject();
        r124.put("live_type", com.bytedance.android.gamecp.host_api.a.b().getLiveService().getEventLiveType());
        r124.put("anchor_status", com.bytedance.android.gamecp.host_api.a.b().getLiveService().dataCenterOperate(false, "data_live_anchor_game_promote_status", null, "-1"));
        Unit r125 = Unit.INSTANCE;
        t.c(504, null, r124);
        return;
    L88:
        if (r122 != 3) goto L90;
        Logger.d("game-promote", "OPEN_INTRODUCE_CARD, info=" + r121.gameName);
        this.f57985f = true;
        this.f57986g = System.currentTimeMillis();
        this.f57987h = r121;
        Logger.d("game-promote", "在前端点击讲解，showTime=" + this.f57986g + ", info=" + r121.gameName);
        return;
    L90:
        if (r122 != 4) goto L92;
        Logger.d("game-promote", "CLOSE_INTRODUCE_CARD, info=" + r121.gameName);
        if (cs.a.a() == false) goto L103;
        LocalTestManager.a(new Class[]{uv.a.class});
    L103:
        this.f57985f = false;
        this.f57986g = -1;
        this.f57987h = null;
        return;
    L92:
        if (r122 != 6) goto L94;
        Logger.d("game-promote", "GAME_OFFLINE, info=" + r121.gameName);
        if (cs.a.a() == false) goto L99;
        LocalTestManager.a(new Class[]{uv.a.class});
    L99:
        this.f57985f = false;
        this.f57986g = -1;
        this.f57987h = null;
        return;
    L94:
        if (cs.a.a() == false) goto L120;
        LocalTestManager.a(new Class[]{uv.a.class});
        return;
    L120:
        return;
    L107:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.host_api.model.introducecard.GamePromoteInfo");
    L83:
        r121 = null;
        goto L84
    L109:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.live_impl.message.GamePromoteMessage");
    L70:
        if ((r110 instanceof com.bytedance.android.gamecp.live_impl.message.c) == false) goto L72;
        r119 = true;
        goto L73
    }

    public static void e(String r100, int r101) {
        LiveTracingMonitor.EventModule r102 = t.f57302a;
        JSONObject r103 = new JSONObject();
        r103.put("live_type", com.bytedance.android.gamecp.host_api.a.b().getLiveService().getEventLiveType());
        r103.put("anchor_status", com.bytedance.android.gamecp.host_api.a.b().getLiveService().dataCenterOperate(false, "data_live_anchor_game_promote_status", null, "-1"));
        r103.put("source", r100);
        r103.put("success", r101);
        Unit r104 = Unit.INSTANCE;
        t.c(502, null, r103);
    }

    public static void f(String r100, Map r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        LiveTracingMonitor.EventModule r103 = GameMountMonitor.f57159a;     // Catch: Throwable -> L11
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L11
        r104.put("scene", "live");     // Catch: Throwable -> L11
        r104.put("enter_from", "live");     // Catch: Throwable -> L11
        r104.put("status", "fail");     // Catch: Throwable -> L11
        r104.put("reason", r100);     // Catch: Throwable -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        Iterator r107 = r101.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r107.hasNext() == false) goto L9;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: Throwable -> L11
        r106.put((String) r108.getKey(), r108.getValue());     // Catch: Throwable -> L11
    L9:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L11
        GameMountMonitor.a(r104, r106);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public g(Context r100, String r101, ILiveRoomControllerProvider.ProviderSource r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "roomId");
        super(r100, null, 0);
        this.f57996q = r101;
        this.f57997r = r102;
        this.f57998s = r103;
        this.f57983d = Boolean.FALSE;
        this.f57986g = -1;
        this.f57991l = 1;
        this.f57995p = -1;
    }

    public static void d(g r100, Map r101, Map r102, Map r103, int r104) {
        Unit r105 = null;
        if ((r104 & 4) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = null;
    L11:
        r100.getClass();
        JSONObject r106 = new JSONObject();
        JSONObject r107 = new JSONObject();
        JSONObject r108 = new JSONObject();
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L31
        if (r101 == null) goto L18;
        Iterator r110 = r101.entrySet().iterator();     // Catch: Throwable -> L31
    L16:
        if (r110.hasNext() == false) goto L18;
        Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Throwable -> L31
        r106.put((String) r111.getKey(), r111.getValue());     // Catch: Throwable -> L31
    L18:
        if (r102 == null) goto L23;
        Iterator r112 = r102.entrySet().iterator();     // Catch: Throwable -> L31
    L21:
        if (r112.hasNext() == false) goto L23;
        Map.Entry r113 = (Map.Entry) r112.next();     // Catch: Throwable -> L31
        r107.put((String) r113.getKey(), ((Number) r113.getValue()).longValue());     // Catch: Throwable -> L31
    L23:
        if (r103 == null) goto L29;
        Iterator r114 = r103.entrySet().iterator();     // Catch: Throwable -> L31
    L26:
        if (r114.hasNext() == false) goto L28;
        Map.Entry r115 = (Map.Entry) r114.next();     // Catch: Throwable -> L31
        r108.put((String) r115.getKey(), r115.getValue());     // Catch: Throwable -> L31
        goto L26
    L28:
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L31
    L33:
        com.bytedance.android.gamecp.host_api.a.b().getLiveService().getGameTraceMonitor();
        return;
    L31:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(g r110, boolean r111, com.bytedance.android.gamecp.base.network.response.i r112, Long r113, String r114, int r115) {
        if ((r115 & 2) == 0) goto L6;
        r112 = null;
    L6:
        if ((r115 & 4) == 0) goto L9;
        r113 = null;
    L9:
        if ((r115 & 8) == 0) goto L12;
        r114 = "";
    L12:
        if ((r115 & 16) == 0) goto L14;
        boolean r116 = true;
    L15:
        r110.getClass();
        if (r111 == true) goto L18;
        yr.b.b(6, "game-promote", "getTransferPageSchema error: " + r114);
        String r117 = GameMountMonitor.ErrorReason.REQUEST_FAILED.getMsg();
        f(r117, MapsKt.mapOf(TuplesKt.to("error_msg", r114)));
        d(r110, null, null, MapsKt.mapOf(TuplesKt.to("reason", r117)), 14);
        return;
    L18:
        if (r113 == null) goto L20;
        Map r118 = MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - r113.longValue())));
    L21:
        d(r110, null, r118, null, 20);
        if (r112 == null) goto L26;
        qw.a r119 = (qw.a) r112.data;
        if (r119 == null) goto L26;
        String r120 = r119.transferPageSchema;
    L27:
        if (r120 != null) goto L29;
    L32:
        boolean r121 = true;
    L34:
        if (r121 == false) goto L36;
        yr.b.b(6, "game-promote", "主播获取跳转中转页的url为空");
        String r122 = GameMountMonitor.ErrorReason.URL_IS_NULL_OR_EMPTY.getMsg();
        f(r122, null);
        d(r110, null, null, MapsKt.mapOf(TuplesKt.to("reason", r122)), 12);
        return;
    L36:
        m1 r123 = g2.f561314a.getValue();
        if (r112 == null) goto L41;
        qw.a r124 = (qw.a) r112.data;
        if (r124 == null) goto L41;
        Integer r125 = Integer.valueOf(r124.containerType);
    L42:
        String r126 = String.valueOf(r125);
        Map<String, Map<String, String>> r100 = r123.a();
        if (r100 == null) goto L45;
        Map<String, String> r101 = r100.get(r126);
    L47:
        if (r101 != null) goto L59;
        yr.b.b(6, "game-promote", "containerType不符合预期，为".concat(r126));
        String r127 = GameMountMonitor.ErrorReason.CONTAINER_TYPE_ERROR.getMsg();
        Pair[] r128 = new Pair[4];
        if (r112 == null) goto L53;
        qw.a r102 = (qw.a) r112.data;
        if (r102 == null) goto L53;
        Integer r103 = Integer.valueOf(r102.containerType);
    L54:
        r128[0] = TuplesKt.to(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, String.valueOf(r103));
        r128[1] = TuplesKt.to("config", String.valueOf(r123.a()));
        if (r112 == null) goto L57;
        String r129 = r112.logId;
    L58:
        r128[2] = TuplesKt.to("log_id", r129);
        r128[3] = TuplesKt.to("reason", r127);
        Map r130 = MapsKt.mapOf(r128);
        f(r127, r130);
        d(r110, null, null, r130, 12);
        return;
    L57:
        r129 = null;
    L53:
        r103 = null;
        goto L54
    L59:
        if (r116 == false) goto L76;
        if (r112 == null) goto L64;
        qw.a r131 = (qw.a) r112.data;
        if (r131 == null) goto L64;
        Integer r132 = Integer.valueOf(r131.containerType);
    L65:
        String r133 = String.valueOf(r132);
        if (r112 == null) goto L70;
        qw.a r134 = (qw.a) r112.data;
        if (r134 == null) goto L70;
        String r135 = r134.transferPageSchema;
    L71:
        d(r110, MapsKt.mapOf(new Pair[]{TuplesKt.to(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r133), TuplesKt.to("url", UriProtector.parse(String.valueOf(r135)).getPath()), TuplesKt.to("using_cache", String.valueOf(false))}), null, null, 24);
        return;
    L70:
        r135 = null;
    L64:
        r132 = null;
        goto L65
    L76:
        return;
    L45:
        r101 = null;
    L41:
        r125 = null;
        goto L42
    L29:
        if (r120.length() == 0) goto L32;
        r121 = false;
    L26:
        r120 = null;
        goto L27
    L20:
        r118 = null;
        goto L21
    L14:
        r116 = false;
        goto L15
    }
}
