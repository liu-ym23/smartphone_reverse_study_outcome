package com.bytedance.android.live.openplatform.impl.minigameanchor;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alipay.sdk.m.p.e;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.jsb.MiniGameCommonJsbContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.launch.AnchorLaunchMgContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.h;
import com.bytedance.android.live.openplatform.impl.minigameanchor.panel.MiniGameFeaturePanelContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.panel.MiniGameFeaturePanelDialog;
import com.bytedance.android.live.openplatform.impl.minigameanchor.preview.PreviewMiniGameContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.preview.PreviewMiniGameDialogFragment;
import com.bytedance.android.live.openplatform.impl.minigameanchor.widget.PreviewMiniGameWidgetDelegate;
import com.bytedance.android.livesdk.config.r50;
import com.bytedance.android.livesdk.config.x80;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import cr0.b;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniGameAnchorServiceImpl implements vo0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PreviewMiniGameWidgetDelegate f85091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OpenPlatformContext f85092b;

    public static final class a {
    }

    static {
    }

    public MiniGameAnchorServiceImpl() {
    }

    @Override // vo0.a
    public final boolean c() {
        OpenPlatformContext r100 = this.f85092b;
        if (r100 == null) goto L7;
        LiveMgMountContextService r101 = (LiveMgMountContextService) r100.getService(LiveMgMountContextService.class);
        if (r101 == null) goto L7;
        return r101.f85205c;
    L7:
        return false;
    }

    @Override // vo0.a
    public final dr0.a getAnchorMiniGameWidgetDescriptor() {
        return new dr0.a();
    }

    @Override // vo0.a
    public final Map<String, String> getMiniGameAppCommonLogMap() {
        OpenPlatformContext r100 = this.f85092b;
        if (r100 == null) goto L8;
        AnchorMiniGameAppLogContextService r101 = (AnchorMiniGameAppLogContextService) r100.getService(AnchorMiniGameAppLogContextService.class);
        if (r101 == null) goto L8;
        Map<String, String> r102 = r101.getPreviewMgCommonLogMap();
        if (r102 == null) goto L8;
        return r102;
    L8:
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put(BdpAppEventConstant.PARAMS_FOR_SPECIAL, BdpAppEventConstant.MICRO_GAME);
        return r103;
    }

    @Override // vo0.a
    public final void unmount() {
        OpenPlatformContext r100 = this.f85092b;
        if (r100 == null) goto L8;
        LiveMgMountContextService r101 = (LiveMgMountContextService) r100.getService(LiveMgMountContextService.class);
        if (r101 == null) goto L9;
        r101.n(AnonymousClass1.INSTANCE);
        return;
    L9:
        return;
    }

    @Override // xo0.a
    public final OpenPlatformContext a() {
        return this.f85092b;
    }

    @Override // xo0.a
    public final void b(OpenPlatformContext r100) {
        this.f85092b = r100;
    }

    @Override // vo0.a
    public final void d(String r100) {
        OpenPlatformContext r101 = this.f85092b;
        if (r101 == null) goto L8;
        AnchorLaunchMgContextService r102 = (AnchorLaunchMgContextService) r101.getService(AnchorLaunchMgContextService.class);
        if (r102 == null) goto L9;
        r102.j(r100, null);
        return;
    L9:
        return;
    }

    @Override // vo0.a
    public final void previewItemClick(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PreviewMiniGameWidgetDelegate r101 = this.f85091a;
        if (r101 == null) goto L23;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (x80.f121583a.getValue().booleanValue() == false) goto L12;
        ((PreviewMiniGameContextService) r101.f85280a.getService(PreviewMiniGameContextService.class)).getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = r50.f121104a.getValue().a();
        if (r102 != null) goto L9;
        r102 = "sslocal://webcast_webview?type=fullscreen&url=https%3A%2F%2Fwww.xingtu.cn%2Fmobile%2Fstar-vue3%2Fsup%2Fgame%2Flive-landing%3Futm_source3Dlive_entrance&hide_nav_bar=1&height_percent=100&mix_container_type=annie&hide_status_bar=1&should_full_screen=1&host=aweme&engine_type=new&status_bar_color=black&status_font_mode=dark";
    L9:
        ILiveActionHandler r103 = (ILiveActionHandler) k.f(ILiveActionHandler.class);
        if (r103 == null) goto L23;
        r103.handle(r100, r102);
        goto L23
    L12:
        ((PreviewMiniGameContextService) r101.f85280a.getService(PreviewMiniGameContextService.class)).getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r104 = AnchorMiniGameDataContext.a.a();
        if (r104 == null) goto L23;
        n<OpenPlatformMgInfoModel> r105 = r104.getOpenPlatformMg();
        if (r105 == null) goto L23;
        OpenPlatformMgInfoModel r106 = r105.getValue();
        if (r106 == null) goto L23;
        PreviewMiniGameDialogFragment r107 = new PreviewMiniGameDialogFragment();
        r107.f85275f = r106;
        FragmentManager r108 = ((FragmentActivity) r100).getSupportFragmentManager();
        LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r107, "PreviewMiniGameDialogFragment", r109);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r108, r107, r109) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L22:
        r107.showNow(r108, "PreviewMiniGameDialogFragment");
    L23:
        OpenPlatformContext r110 = this.f85092b;
        if (r110 == null) goto L32;
        AnchorMiniGameAppLogContextService r111 = (AnchorMiniGameAppLogContextService) r110.getService(AnchorMiniGameAppLogContextService.class);
        if (r111 == null) goto L33;
        AnchorMiniGameAppLogContextService.reportPreviewMgAppLog$default(r111, "livesdk_takepage_micro_game_click", null, 2, null);
        return;
    L33:
        return;
    }

    @Override // vo0.a
    public final void setMountStatus(boolean r100) {
        OpenPlatformContext r101 = this.f85092b;
        if (r101 == null) goto L8;
        LiveMgMountContextService r102 = (LiveMgMountContextService) r101.getService(LiveMgMountContextService.class);
        if (r102 == null) goto L9;
        r102.j(r100);
        return;
    L9:
        return;
    }

    @Override // vo0.a
    public final void mount(Context r110, u r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        OpenPlatformContext r100 = this.f85092b;
        if (r100 == null) goto L31;
        LiveMgMountContextService r101 = (LiveMgMountContextService) r100.getService(LiveMgMountContextService.class);
        if (r101 == null) goto L32;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        r r102 = r111.c();
        if (r102 == null) goto L33;
        c0 r103 = r102.x();
        if (r103 == null) goto L34;
        r103.f59335a = r111.f59372d;
        r103.f59336b = r111.f59373e;
        if (r101.f85205c == true) goto L13;
    L23:
        r101.f85208f = r103;
        ((AnchorMiniGameAppLogContextService) r101.getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class)).setMicroGameInfo(r101.f85208f);
        String r112 = r103.schema;
        if (r112 == null) goto L27;
        m.f(Observable.create(new h(r112)).subscribeOn(Schedulers.io()), null);
    L27:
        if (r103.f59336b == true) goto L29;
        LiveMgMountContextService.k(r101, r101.getOpenPlatformContext().getContext(), r103, null, null, 28);
        return;
    L29:
        r101.g(r110, r103);
        return;
    L13:
        if (Intrinsics.areEqual(r103.gameId, r101.f85204b) == false) goto L23;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r104 = AnchorMiniGameDataContext.a.a();
        if (r104 == null) goto L20;
        com.bytedance.live.datacontext.m<String> r105 = r104.getOpenFeatureBinderId();
        if (r105 == null) goto L20;
        r105.setValue(r101.f85204b);
    L20:
        if (r111.f59373e == false) goto L22;
        r101.l();
        return;
    L22:
        ((MiniGameCommonJsbContextService) r101.getOpenPlatformContext().getService(MiniGameCommonJsbContextService.class)).j(r110, null);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    }

    @Override // vo0.a
    public final void openBottomFeaturePanel(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OpenPlatformContext r102 = this.f85092b;
        if (r102 == null) goto L18;
        MiniGameFeaturePanelContextService r103 = (MiniGameFeaturePanelContextService) r102.getService(MiniGameFeaturePanelContextService.class);
        if (r103 == null) goto L18;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        DataCenter r104 = r103.getOpenPlatformContext().getDataCenter();
        if (r104 == null) goto L9;
        LiveMode r105 = (LiveMode) r104.get("data_live_mode", LiveMode.VIDEO);
    L11:
        if (r105 != LiveMode.VIDEO) goto L13;
        ((MiniGameCommonJsbContextService) r103.getOpenPlatformContext().getService(MiniGameCommonJsbContextService.class)).j(r100, r101);
        goto L18
    L13:
        MiniGameFeaturePanelDialog r106 = new MiniGameFeaturePanelDialog();
        FragmentManager r107 = ((FragmentActivity) r100).getSupportFragmentManager();
        LandscapeRestrictionOperation r108 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r106, "MiniGameFeaturePanelDialog", r108);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r107, r106, r108) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L17:
        r106.showNow(r107, "MiniGameFeaturePanelDialog");
        goto L18
    L9:
        r105 = null;
    L18:
        OpenPlatformContext r109 = this.f85092b;
        if (r109 == null) goto L27;
        AnchorMiniGameAppLogContextService r110 = (AnchorMiniGameAppLogContextService) r109.getService(AnchorMiniGameAppLogContextService.class);
        if (r110 == null) goto L28;
        HashMap<String, String> r111 = new HashMap();
        r111.put("click_type", "icon");
        Unit r112 = Unit.INSTANCE;
        r110.reportLiveRoomMgAppLog("livesdk_anchor_micro_game_click", r111);
        return;
    L28:
        return;
    }

    @Override // vo0.a
    public final void previewSwitchTask(String r100, String r101) {
        OpenPlatformContext r102 = this.f85092b;
        if (r102 == null) goto L8;
        PreviewMiniGameContextService r103 = (PreviewMiniGameContextService) r102.getService(PreviewMiniGameContextService.class);
        if (r103 == null) goto L9;
        Lazy r104 = LiveOpenPlatformMgClient.f84036c;
        r103.autoDispose(((MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class)).previewSwitchTask(r100, r101).compose(RxUtil.rxSchedulerHelper()).subscribe(cr0.a.f465030a, b.f465031a));
        return;
    L9:
        return;
    }

    @Override // vo0.a
    public final void reportMiniGameAppLog(String r100, HashMap<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        OpenPlatformContext r102 = this.f85092b;
        if (r102 != null) goto L5;
    L11:
        OpenPlatformContext r103 = this.f85092b;
        if (r103 == null) goto L20;
        AnchorMiniGameAppLogContextService r104 = (AnchorMiniGameAppLogContextService) r103.getService(AnchorMiniGameAppLogContextService.class);
        if (r104 == null) goto L21;
        r104.reportLiveRoomMgAppLog(r100, r101);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (r102.isInLive() == true) goto L11;
        OpenPlatformContext r105 = this.f85092b;
        if (r105 == null) goto L17;
        AnchorMiniGameAppLogContextService r106 = (AnchorMiniGameAppLogContextService) r105.getService(AnchorMiniGameAppLogContextService.class);
        if (r106 == null) goto L18;
        r106.reportPreviewMgAppLog(r100, r101);
        return;
    L18:
        return;
    }

    @Override // vo0.a
    public final PreviewMiniGameWidgetDelegate getPreviewMiniGameWidgetLifecycleObserver(Context r100, ViewGroup r101, PreviewSourceParam r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PreviewMiniGameWidgetDelegate r103 = new PreviewMiniGameWidgetDelegate(r100, r101, r102);
        this.f85091a = r103;
        return r103;
    }

    @Override // vo0.a
    public final void handleCommonJSBInvoke(String r100, JsonObject r101, Function1<? super JsonObject, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "param");
        OpenPlatformContext r103 = this.f85092b;
        if (r103 == null) goto L8;
        MiniGameCommonJsbContextService r104 = (MiniGameCommonJsbContextService) r103.getService(MiniGameCommonJsbContextService.class);
        if (r104 == null) goto L9;
        r104.i(r100, r101, r102);
        return;
    L9:
        return;
    }
}
