package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessContext;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateSubtitleType;
import com.bytedance.android.livesdk.chatroom.model.interact.k2;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import hh1.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m implements jk0.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f80567j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jk0.b f80568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.voicechat.radio.a f80569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioSubtitleBusinessWidget f80570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f80571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f80572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k2 f80573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f80574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WidgetManager f80575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j1 f80576i;

    public static final class a {
    }

    static {
    }

    @Override // jk0.d
    public final void a() {
        int r100 = e.f80544a;
        if (e.c(gh0.a.d()) == false) goto L6;
        ALogger.e("RadioStageContainerWidget", "[RadioSubtitleComponent] onSubtitleStateChangeStop ab-off return");
        return;
    L6:
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] onSubtitleStateStop");
        jk0.b r101 = this.f80568a;
        if (r101 == null) goto L10;
        r101.onStop();
        return;
    }

    @Override // jk0.d
    public final void b() {
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] onSubtitleStateStart");
        int r100 = e.f80544a;
        if (e.c(gh0.a.d()) == false) goto L6;
        ALogger.e("RadioStageContainerWidget", "[RadioSubtitleComponent] onSubtitleStateChangeStart ab-off return");
        return;
    L6:
        jk0.b r101 = this.f80568a;
        if (r101 == null) goto L10;
        r101.onStart();
        return;
    }

    @Override // jk0.d
    public final void c() {
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] onAnchorSetSubtitleStartBefore");
        j(this);
    }

    @Override // jk0.d
    public final void e() {
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] onAnchorSetSubtitleSttopAfter");
        int r100 = e.f80544a;
        if (e.c(gh0.a.d()) == false) goto L6;
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent] onAnchorSetSubtitleStopAfter 实验命中off 不操作rtc");
        return;
    L6:
        l();
        jk0.b r101 = this.f80568a;
        if (r101 == null) goto L10;
        r101.onStop();
        return;
    }

    public final void k() {
        RadioSubtitleBusinessWidget r100 = this.f80570c;
        if (r100 == null) goto L8;
        WidgetManager r101 = this.f80575h;
        if (r101 == null) goto L7;
        r101.unload(r100);
    L7:
        this.f80570c = null;
    L8:
        l();
    }

    @Override // jk0.d
    public final void d() {
        if (gh0.a.d() == true) goto L12;
        int r100 = e.f80544a;
        if (e.c(gh0.a.d()) == false) goto L8;
        ALogger.e("RadioStageContainerWidget", "[RadioSubtitleComponent] onMessageSubtitleStart ab-off return");
        return;
    L8:
        jk0.b r101 = this.f80568a;
        if (r101 == null) goto L13;
        r101.onStart();
        return;
    L13:
        return;
    }

    @Override // jk0.d
    public final void f() {
        if (gh0.a.d() == true) goto L12;
        int r100 = e.f80544a;
        if (e.c(gh0.a.d()) == false) goto L8;
        ALogger.e("RadioStageContainerWidget", "[RadioSubtitleComponent] onMessageSubtitleStop ab-off return");
        return;
    L8:
        jk0.b r101 = this.f80568a;
        if (r101 == null) goto L13;
        r101.onStop();
        return;
    L13:
        return;
    }

    public final void l() {
        if (gh0.a.d() == false) goto L26;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r100 = this.f80569b;
        if (r100 == null) goto L24;
        vb6.g r101 = r100.f80473b;
        if (r101 == null) goto L15;
        yb6.e r102 = r101.j();
        if (r102 == null) goto L15;
        ei6.a r103 = r102.Z0();
        if (r103 == null) goto L15;
        zi6.d r104 = r103.c();
        if (r104 == null) goto L15;
        r104.b();
    L15:
        vb6.g r105 = r100.f80473b;
        if (r105 == null) goto L20;
        yb6.e r106 = r105.j();
        if (r106 == null) goto L20;
        r106.n();
    L20:
        vb6.g r107 = r100.f80473b;
        if (r107 == null) goto L23;
        r107.h(null);
    L23:
        r100.f80473b = null;
    L24:
        this.f80569b = null;
        return;
    }

    @Override // jk0.d
    public final com.bytedance.android.live.liveinteract.voicechat.radio.a g() {
        return this.f80569b;
    }

    public static final void h(m r100) {
        if (r100.f80573f == null) goto L5;
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent] requestInitRtcInfo pre has: " + r100.f80573f);
        k2 r101 = r100.f80573f;
        Intrinsics.checkNotNull(r101);
        r100.i(r101);
        return;
    L5:
        LinkApis r102 = (LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class);
        IRoom r103 = je0.d.e(null);
        if (r103 == null) goto L8;
        long r104 = r103.getId();
    L9:
        r102.preInitRtc(r104).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(r100), new p(r100));
        return;
    L8:
        r104 = 0;
        goto L9
    }

    public static void j(m r100) {
        r100.getClass();
        RadioSubtitleComponent$startSubTitleWithDependence$1 r101 = new RadioSubtitleComponent$startSubTitleWithDependence$1(r100, null);
        r100.f80571d = 0;
        int r102 = e.f80544a;
        if (e.c(gh0.a.d()) == false) goto L5;
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent] 实验命中off 不打开字幕");
        return;
    L5:
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] loadSubtitleBusinessWidget:" + r100.f80570c);
        if (r100.f80570c != null) goto L9;
        RadioSubtitleBusinessWidget r103 = new RadioSubtitleBusinessWidget();
        r100.f80570c = r103;
        Intrinsics.checkNotNullParameter(r100, "callback");
        r103.f80471z = r100;
        r100.f80575h.load(r100.f80570c);
    L9:
        if (gh0.a.d() == false) goto L20;
        int r104 = b6.f65253p0.getValue().getStatus();
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] startSubTitleWithDependence subtitleSettingStatus:" + r104);
        if (r104 != IAudioSubtitleContent.SwitchStatus.SWITCH_UNKNOWN.getValue()) goto L16;
        IAudioSubtitleContent r105 = (IAudioSubtitleContent) vh7.f.c(IAudioSubtitleContent.class);
        r105.setStatus(IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue());
        nj0.b r106 = LinkmicSubtitleBusinessContext.Companion.b();
        if (r106 == null) goto L21;
        r106.N5(r105, UpdateSubtitleType.UNKNOWN, new q(r105, r101));
        return;
    L21:
        return;
    L16:
        if (r104 != IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue()) goto L23;
        r101.invoke2();
        return;
    L23:
        return;
    }

    public final void i(k2 r110) {
        boolean r100 = true;
        if (this.f80569b != null) goto L32;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r101 = new com.bytedance.android.live.liveinteract.voicechat.radio.a(this.f80574g, r110, this.f80576i);
        this.f80569b = r101;
        ALogger.i("RadioStageContainerWidget", "[RadioLinkRTCManager]initRTC: " + r101.f80479h);
        vb6.g r111 = r101.f80473b;
        if (r111 == null) goto L7;
        r111.attach();
    L7:
        com.bytedance.live.datacontext.m<IRoom> r112 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r112 == null) goto L15;
        IRoom r113 = r112.getValue();
        if (r113 == null) goto L15;
        vb6.g r102 = r101.f80473b;
        if (r102 == null) goto L14;
        r102.b(r113.getId(), r113.getOwnerUserIdString(), new b(r101));
    L14:
        tc0.c.h().f545348e = r113.getOwnerUserIdString();
    L15:
        tc0.c r114 = tc0.c.h();
        String r103 = r101.f80479h.b();
        if (r103 != null) goto L18;
        r103 = "";
    L18:
        r114.f545349f = r103;
        tc0.c.h().f545354k = r101.f80479h.a();
        m00.e r115 = ((IMiddlewareBroadcastService) jc1.k.n(IMiddlewareBroadcastService.class)).createLinkInRoomView(r101.f80472a, r101.f80478g, 0);
        Intrinsics.checkNotNull(r115);
        r101.f80474c = r115;
        vb6.g r116 = r101.f80473b;
        if (r116 == null) goto L29;
        yb6.e r117 = r116.j();
        if (r117 == null) goto L29;
        m00.e r104 = r101.f80474c;
        if (r104 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorVideoClient");
    L25:
        if (r104 == null) goto L28;
        r117.s0(gc6.b.c((v0) r104, null), m.class.getSimpleName().concat(" create set"));
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.interact.LiveVideoClientFactory");
    L29:
        vb6.g r118 = r101.f80473b;
        if (r118 == null) goto L32;
        r118.b1(r101.f80477f, true);
    L32:
        RadioSubtitleBusinessWidget r119 = this.f80570c;
        if (r119 == null) goto L35;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r105 = this.f80569b;
        Intrinsics.checkNotNull(r105);
        com.bytedance.android.live.pushstream.d r106 = r105.f80472a;
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNullParameter(r106, "liveStream");
        r119.f80603d = r106;
    L35:
        RadioSubtitleBusinessWidget r120 = this.f80570c;
        if (r120 == null) goto L38;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r107 = this.f80569b;
        Intrinsics.checkNotNull(r107);
        vb6.g r108 = r107.f80473b;
        Intrinsics.checkNotNull(r108);
        yb6.e r109 = r108.j();
        Intrinsics.checkNotNullParameter(r109, "mediaManager");
        r120.f80602c = r109;
    L38:
        RadioSubtitleBusinessWidget r121 = this.f80570c;
        if (r121 == null) goto L41;
        r121.xq();
    L41:
        com.bytedance.android.live.liveinteract.voicechat.radio.a r122 = this.f80569b;
        if (r122 == null) goto L55;
        vb6.g r123 = r122.f80473b;
        if (r123 == null) goto L52;
        yb6.e r124 = r123.j();
        if (r124 == null) goto L52;
        yb6.n r125 = r124.K();
        if (r125 == null) goto L52;
        if (r125.f567105e != true) goto L52;
        boolean r126 = true;
    L53:
        if (r126 != true) goto L55;
    L56:
        if (r100 == true) goto L63;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r127 = this.f80569b;
        if (r127 == null) goto L64;
        int r128 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        ALogger.i("RadioStageContainerWidget", "startRTC--currentScene:" + r128);
        vb6.g r129 = r127.f80473b;
        if (r129 == null) goto L65;
        r129.c1(r128);
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L52:
        r126 = false;
    L55:
        r100 = false;
        goto L56
    }

    public m(Context r100, WidgetManager r101, j1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "subWidgetManager");
        Intrinsics.checkNotNullParameter(r102, "scopeProvider");
        this.f80574g = r100;
        this.f80575h = r101;
        this.f80576i = r102;
    }
}
