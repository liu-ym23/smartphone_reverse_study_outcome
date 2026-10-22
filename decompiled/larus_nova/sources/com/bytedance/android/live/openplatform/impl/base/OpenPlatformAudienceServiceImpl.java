package com.bytedance.android.live.openplatform.impl.base;

import android.content.Context;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.ImageLoader;
import com.bytedance.android.live.openplatform.impl.base.utils.v;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.LittleGameConfig;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.openplatform.LiveOpenApiCallback;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import j70.h;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import jc1.k;
import ko0.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import po0.e;
import w20.lc;
import yo0.d;
import zo0.f;
import zo0.g;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 P2\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\bN\u0010OJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0018\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\nH\u0016J\u0018\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\b\u00101\u001a\u000200H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u001e\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000207\u0018\u0001062\u0006\u00105\u001a\u000204H\u0016J\u001a\u0010;\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010:H\u0016J\u0016\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000106H\u0016J\u001a\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0016R.\u0010A\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR.\u0010H\u001a\u0004\u0018\u00010G2\b\u0010@\u001a\u0004\u0018\u00010G8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006R"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/OpenPlatformAudienceServiceImpl;", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAudienceService;", "Lko0/c;", "getMiniAppLiveCastEntranceInfo", "", "appId", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "callback", "", "invokeLiveOpenApi", "Lj70/h;", "Lh70/b;", "getAudienceMiniAppWidgetDescriptor", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniAppSource;", "source", "openMountedMiniApp", "location", "openSnowFlake", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;", "button", "onSnowFlakeShow", "", "isFromMsg", "onSnowFlakeHide", "reportMpLiveLinkShow", "reportMpLiveLinkClick", "isMiniAppExplainCardShowing", "hideMiniAppExplainCard", "showMiniAppExplainCard", "sei", "onSei", "isGuest", "reportAudienceLiveProjectionWatch", "", "duration", "reportAudienceLiveProjectionWatchDuration", "recordSnowFlakeShown", "showType", "reportExplainCardShown", "deleteMiniAppMountInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "preloadMiniAppContext", "reportSnowFlakeAnimShow", "Lmo0/a;", "getOpenPlatformImageLoader", "Lis2/b;", "getShelfInfoBackendHandler", "", "cardType", "", "", "getMiniAppCommonCardExtraParams", "schema", "Lw20/lc$a;", "openLiveMicroApp", "getCommonEventParams", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/a0;", "createToolbarComponentConfig", "Lto0/a;", "<set-?>", "miniAppAudienceService", "Lto0/a;", "getMiniAppAudienceService", "()Lto0/a;", "setMiniAppAudienceService", "(Lto0/a;)V", "Lyo0/b;", "openApiService", "Lyo0/b;", "getOpenApiService", "()Lyo0/b;", "setOpenApiService", "(Lyo0/b;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenPlatformAudienceServiceImpl implements IOpenPlatformAudienceService {
    public static final a Companion = null;
    private static final e diComponent = null;
    private to0.a miniAppAudienceService;
    private yo0.b openApiService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements yo0.a.InterfaceC8363a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveOpenApiCallback f84008a;

        public b(LiveOpenApiCallback r100) {
            this.f84008a = r100;
        }

        @Override // yo0.a.InterfaceC8363a
        public final void a(d r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f84008a.onError(r100.f568625b, r100.a());
        }

        @Override // yo0.a.InterfaceC8363a
        public final void b(d r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f84008a.onSuccess(r100.a());
        }
    }

    static {
        Companion = new a();
        diComponent = po0.a.a();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void deleteMiniAppMountInfo() {
        MiniAppDataContext.Companion.getClass();
        if (MiniAppDataContext.a.b() != null) goto L5;
        return;
    L5:
        to0.a r100 = this.miniAppAudienceService;
        if (r100 == null) goto L13;
        OpenPlatformContext r101 = r100.a();
        if (r101 == null) goto L14;
        AudienceShelfInfoService r102 = (AudienceShelfInfoService) r101.getService(AudienceShelfInfoService.class);
        if (r102 == null) goto L15;
        r102.j();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public h<? extends h70.b> getAudienceMiniAppWidgetDescriptor() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAudienceMiniAppWidgetDescriptor();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public Map<String, String> getCommonEventParams() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCommonEventParams();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public c getMiniAppLiveCastEntranceInfo() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMiniAppLiveCastEntranceInfo();
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public is2.b getShelfInfoBackendHandler() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getShelfInfoBackendHandler();
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void hideMiniAppExplainCard() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 == null) goto L6;
        r100.hideMiniAppExplainCard();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public boolean isMiniAppExplainCardShowing() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isMiniAppExplainCardShowing();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void openSnowFlake() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 == null) goto L6;
        r100.openSnowFlake();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void recordSnowFlakeShown() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 == null) goto L9;
        OpenPlatformContext r101 = r100.a();
        if (r101 == null) goto L9;
        OpenPlatformPerformanceReportService r102 = (OpenPlatformPerformanceReportService) r101.getService(OpenPlatformPerformanceReportService.class);
        if (r102 == null) goto L9;
        r102.k(false);
    L9:
        to0.a r103 = this.miniAppAudienceService;
        if (r103 == null) goto L16;
        OpenPlatformContext r104 = r103.a();
        if (r104 == null) goto L16;
        if (r104.isInLive() != true) goto L16;
        int r105 = 4;
    L17:
        int r106 = no0.a.f519883a;
        no0.a.c(r105, 1, 2);
        return;
    L16:
        r105 = 3;
        goto L17
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportMpLiveLinkClick() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 == null) goto L6;
        r100.reportMpLiveLinkClick();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportMpLiveLinkShow() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 == null) goto L6;
        r100.reportMpLiveLinkShow();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportSnowFlakeAnimShow() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 == null) goto L6;
        r100.reportSnowFlakeAnimShow();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void showMiniAppExplainCard() {
        to0.a r100 = this.miniAppAudienceService;
        if (r100 == null) goto L6;
        r100.showMiniAppExplainCard();
        return;
    }

    public OpenPlatformAudienceServiceImpl() {
        po0.a.b r100 = (po0.a.b) diComponent;
        setMiniAppAudienceService(r100.f530023d.get());
        setOpenApiService(r100.f530022c.get());
        k.l(IOpenPlatformAudienceService.class, this);
        v.a();
    }

    public static final /* synthetic */ e access$getDiComponent$cp() {
        return diComponent;
    }

    public final to0.a getMiniAppAudienceService() {
        return this.miniAppAudienceService;
    }

    public final yo0.b getOpenApiService() {
        return this.openApiService;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public mo0.a getOpenPlatformImageLoader() {
        return ImageLoader.f84018a;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public Map<String, Object> getMiniAppCommonCardExtraParams(int r100) {
        to0.a r101 = this.miniAppAudienceService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.c();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void onSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        to0.a r101 = this.miniAppAudienceService;
        if (r101 == null) goto L6;
        r101.onSei(r100);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void onSnowFlakeHide(boolean r100) {
        to0.a r101 = this.miniAppAudienceService;
        if (r101 == null) goto L6;
        r101.f();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void onSnowFlakeShow(s r100) {
        to0.a r101 = this.miniAppAudienceService;
        if (r101 == null) goto L6;
        r101.onSnowFlakeShow(r100);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void openMountedMiniApp(MountedMiniAppSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        to0.a r101 = this.miniAppAudienceService;
        if (r101 == null) goto L6;
        r101.openMountedMiniApp(r100);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void reportAudienceLiveProjectionWatch(boolean r100) {
        to0.a r101 = this.miniAppAudienceService;
        if (r101 == null) goto L6;
        r101.reportAudienceLiveProjectionWatch(r100);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportExplainCardShown(String r210) {
        Intrinsics.checkNotNullParameter(r210, "showType");
        to0.a r100 = this.miniAppAudienceService;
        if (r100 == null) goto L26;
        OpenPlatformContext r101 = r100.a();
        if (r101 == null) goto L27;
        OpenPlatformPerformanceReportService r102 = (OpenPlatformPerformanceReportService) r101.getService(OpenPlatformPerformanceReportService.class);
        if (r102 == null) goto L28;
        Intrinsics.checkNotNullParameter(r210, "showType");
        HashMap<String, f> r103 = g.f573094a;
        PerformanceScene r104 = PerformanceScene.EXPLAIN_CARD;
        zo0.h.b(r104).b();
        boolean r105 = zo0.h.b(r104).c("is_from_enter");
        PerformanceScene r106 = PerformanceScene.MINI_APP_CONTEXT;
        long r107 = zo0.h.b(r106).g("audience_enter_room_duration");
        if (r105 == false) goto L11;
        long r108 = zo0.h.b(r104).f();
        long r110 = zo0.h.b(r106).h();
    L12:
        long r109 = r108 - r110;
        if (r105 == false) goto L15;
        long r111 = r107 + r109;
    L16:
        long r112 = zo0.h.b(r106).d("context_initialized", "start");
        long r113 = zo0.h.b(r104).d("audience_widget_loaded", "start");
        long r114 = zo0.h.b(r104).d("card_show_finish", "card_show_start");
        long r115 = zo0.h.b(r104).d("toolbar_anim_finish", "toolbar_anim_start");
        long r211 = zo0.h.b(r104).d(VideoEventOneOutSync.END_TYPE_FINISH, "card_anim_start");
        Pair[] r116 = new Pair[9];
        if (r105 == false) goto L19;
        String r117 = "enter";
    L20:
        r116[0] = TuplesKt.to("toolbar_im_source", r117);
        if (r105 == false) goto L23;
        String r118 = String.valueOf(r107);
    L24:
        r116[1] = TuplesKt.to("enter_room_duration", r118);
        r116[2] = TuplesKt.to("duration", String.valueOf(r109));
        r116[3] = TuplesKt.to("total_duration", String.valueOf(r111));
        r116[4] = TuplesKt.to("context_init_duration", String.valueOf(r112));
        r116[5] = TuplesKt.to("ui_init_duration", String.valueOf(r113));
        r116[6] = TuplesKt.to("draw_duration", String.valueOf(r114));
        r116[7] = TuplesKt.to("toolbar_anim_duration", String.valueOf(r115));
        r116[8] = TuplesKt.to("card_anim_duration", String.valueOf(r211));
        Map r119 = MapsKt.mutableMapOf(r116);
        r119.putAll(OpenPlatformPerformanceReportService.g(r105));
        OpenPlatformPerformanceReportService.h(r104, r119, MapsKt.emptyMap());
        com.bytedance.android.livesdk.log.g r120 = u.l();
        Map r121 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(BdpAppEventConstant.PARAMS_FOR_SPECIAL, BdpAppEventConstant.MICRO_APP), TuplesKt.to("room_id", String.valueOf(r102.getOpenPlatformContext().getRoomId())), TuplesKt.to("show_type", r210)});
        r121.putAll(r119);
        Unit r122 = Unit.INSTANCE;
        r120.e("mp_entrance_explain_card_fp_cost", r121, new Object[0]);
        return;
    L23:
        r118 = "0";
        goto L24
    L19:
        r117 = "msg";
        goto L20
    L15:
        r111 = r109;
        goto L16
    L11:
        r108 = zo0.h.b(r104).f();
        r110 = zo0.h.b(PerformanceScene.SHELF_REQUEST).h();
        goto L12
    L28:
        return;
    L27:
        return;
    }

    @Inject
    public final void setMiniAppAudienceService(to0.a r100) {
        this.miniAppAudienceService = r100;
    }

    @Inject
    public final void setOpenApiService(yo0.b r100) {
        this.openApiService = r100;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void openMountedMiniApp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "location");
        to0.a r101 = this.miniAppAudienceService;
        if (r101 == null) goto L6;
        r101.openMountedMiniApp(r100);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public a0 createToolbarComponentConfig(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new LittleGameConfig(r101, r100);
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void openLiveMicroApp(String r100, lc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        to0.a r102 = this.miniAppAudienceService;
        if (r102 == null) goto L6;
        r102.openLiveMicroApp(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void preloadMiniAppContext(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        to0.a r102 = this.miniAppAudienceService;
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void reportAudienceLiveProjectionWatchDuration(long r100, boolean r101) {
        to0.a r102 = this.miniAppAudienceService;
        if (r102 == null) goto L6;
        r102.reportAudienceLiveProjectionWatchDuration(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void invokeLiveOpenApi(String r100, JSONObject r101, LiveOpenApiCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        yo0.b r103 = this.openApiService;
        if (r103 == null) goto L6;
        r103.c(r100, r101, new b(r102));
        return;
    }
}
