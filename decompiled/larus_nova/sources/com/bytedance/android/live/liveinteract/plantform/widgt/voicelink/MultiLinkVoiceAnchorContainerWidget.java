package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.component.data.ComponentGlobalDataContext;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.nova.R;
import hh1.w0;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nz.f0;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceAnchorContainerWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lkn0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVoiceAnchorContainerWidget extends PlatformMultiLinkWidget implements kn0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f77757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f77758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f77759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f77760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Widget f77762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Widget f77763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Widget f77764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.livesdk.message.linker.h f77765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f77766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FragmentManager f77767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f77768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w0 f77769m;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_voice_scene_container;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return 0;
    }

    @Override // kn0.a
    public final void i2(String r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        Lazy r100 = MultiComponentManager.f72503e;
        MultiComponentManager.a.a().a(this, this.context, this.dataCenter);
        ((cg6.a) getScopeServiceInMultiLinkRoom(cg6.a.class)).init(this.context);
        enableSubWidgetManager();
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r101 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r102 = r101.getValue();
        if (r102 == null) goto L7;
        this.f77757a.add(r102.a().subscribe(new e(this)));
    L7:
        RxUtilKt.c(xs2.b.a().b(pe0.a.class).subscribe(new d(this)), this.f77757a);
        this.f77758b = (IRoom) this.dataCenter.get("data_room");
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        ComponentGlobalDataContext.Companion.getClass();
        ComponentGlobalDataContext r100 = ComponentGlobalDataContext.a.a();
        if (r100 == null) goto L7;
        DataCenter r101 = r100.getDataCenter();
        if (r101 == null) goto L7;
        r101.put("cmd_link_switch_video_resolution_for_short_video", new com.bytedance.android.live.liveinteract.model.e());
    L7:
        cg6.a r102 = (cg6.a) getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r102 == null) goto L20;
        hg6.g r103 = r102.getRtcManager();
        if (r103 == null) goto L14;
        fg6.b r104 = r103.F();
        if (r104 == null) goto L14;
        r104.a();
    L14:
        hg6.g r105 = r102.getRtcManager();
        if (r105 == null) goto L17;
        r105.onDestroy();
    L17:
        vb6.g r106 = r102.O5();
        if (r106 == null) goto L20;
        r106.h(null);
    L20:
        hd0.c.f().k(0);
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r107 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r107 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r108 = r107.getValue();
        if (r108 == null) goto L25;
        r108.reset();
    L25:
        this.f77757a.dispose();
        if (this.f77768l.t0() == true) goto L28;
    L39:
        com.bytedance.android.live.liveinteract.plantform.utils.i.b();
        Lazy r109 = MultiComponentManager.f72503e;
        MultiComponentManager.a.a().b(this.context);
        cg6.a r110 = (cg6.a) getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r110 == null) goto L43;
        r110.release();
        return;
    L43:
        return;
    L28:
        if (this.f77768l == null) goto L36;
        cg6.a r111 = (cg6.a) getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r111 == null) goto L36;
        jg6.a r112 = r111.e5();
        if (r112 == null) goto L36;
        kg6.e r113 = r112.b();
        if (r113 == null) goto L36;
        r113.z(new kg6.d(true, true, LiveCommonConstants.REASON_ON_DEDTROY, 8));
    L36:
        String r114 = je0.d.b0();
        w0 r115 = this.f77769m;
        if (r115 == null) goto L39;
        r115.f9(r114, false);
        goto L39
    }

    @Override // kn0.a
    public final void E1(ILinkerClientUIInfoChangeContent r100) {
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r101 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r101 == null) goto L6;
        r101.onClientUIInfoChangeMessage(r100);
        return;
    }

    @Override // kn0.a
    public final void d1(z0 r100) {
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r101 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        com.bytedance.android.live.liveinteract.multianchor.model.b r102 = null;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        com.bytedance.android.live.liveinteract.multianchor.model.b r103 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r100.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
    L7:
        r101.onSwitchSceneMessage(r103);
        goto L8
    L6:
        r103 = null;
    L8:
        IKtvService r104 = (IKtvService) jc1.k.n(IKtvService.class);
        if (r100 == null) goto L11;
        r102 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r100.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
    L11:
        r104.onSwitchSceneMessage(r102);
    }

    public static long wq(int r100, int r101) {
        if (r100 != 0) goto L4;
        f0.c r102 = f0.c.f521316b;
        return 7;
    L4:
        if (r100 != 5) goto L6;
    L14:
        int r103 = f0.f.f521319b;
        return 4;
    L6:
        if (r100 == 9) goto L11;
        if (r100 == 16) goto L14;
        return 0;
    L11:
        if (r101 != 61) goto L13;
        int r104 = f0.g.f521320b;
        return 2;
    L13:
        int r105 = f0.b.f521315b;
        return 1;
    }

    @Override // kn0.a
    public final void continueAnchorLinkMic(int r100, com.bytedance.android.livesdk.message.linker.h r101) {
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L5;
    L7:
        com.bytedance.android.live.liveinteract.voicechat.d r102 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r102 == null) goto L10;
        r102.continueAnchorLinkMic(r100, r101);
    L10:
        this.f77765i = null;
        return;
    L5:
        if (((IKtvService) jc1.k.n(IKtvService.class)).continueAnchorLinkMic(r100, r101) == true) goto L7;
        this.f77765i = r101;
    }

    public MultiLinkVoiceAnchorContainerWidget(FragmentManager r100, com.bytedance.android.live.pushstream.d r101, w0 r102) {
        Intrinsics.checkNotNullParameter(r101, "liveStream");
        this.f77767k = r100;
        this.f77768l = r101;
        this.f77769m = r102;
        this.f77757a = new CompositeDisposable();
    }

    @Override // kn0.a
    public final void vh(int r210, int r211, int r212, String r213) {
        if (this.f77766j == false) goto L5;
        return;
    L5:
        this.f77766j = true;
        u r100 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f77758b == null) goto L27;
        long r110 = System.currentTimeMillis();
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r101 = r100.s();
        if (r101 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r102 = r101.getValue();
        if (r102 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r103 = r102.t();
        if (r103 == null) goto L17;
        int r104 = r103.f114793b;
    L18:
        tf0.m r105 = b0.b();
        if ((r105 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) == true) goto L21;
        r105 = null;
    L21:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u r106 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) r105;
        if (r106 == null) goto L24;
        r106.f76110a = false;
        r106.f76111b = r110;
    L24:
        LinkApi r111 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r107 = this.f77758b;
        Intrinsics.checkNotNull(r107);
        long r112 = r107.getId();
        IRoom r108 = this.f77758b;
        Intrinsics.checkNotNull(r108);
        Disposable r109 = r111.switchScene(r112, r108.getId(), r210, r211, r212, r213).subscribeOn(Schedulers.io()).flatMap(f.f77825a).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r106, r212, r210, r211, r213, r110, r104), new h(this, r210, r211, r213, r110));
        this.f77757a.add(r109);
        return;
    L17:
        r104 = 0;
        goto L18
    }
}
