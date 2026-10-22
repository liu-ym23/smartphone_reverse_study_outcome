package com.bytedance.android.live.openplatform.impl.base;

import android.content.Context;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.openplatform.LiveOpenApiCallback;
import com.bytedance.live.datacontext.n;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import j70.h;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import jc1.k;
import ko0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mh1.p;
import org.json.JSONObject;
import po0.e;
import w20.lc;
import yo0.d;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 n2\u00020\u0001:\u0001oB\u0007¢\u0006\u0004\bl\u0010mJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH\u0016J6\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\nH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0006H\u0016J\"\u0010-\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\"\u00100\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010\u00062\u0006\u0010/\u001a\u00020\u001fH\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J \u00106\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0016J\n\u00108\u001a\u0004\u0018\u000107H\u0016J\u0018\u0010;\u001a\u00020\n2\u0006\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\u001fH\u0016J\u0018\u0010=\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0016J\b\u0010>\u001a\u00020\nH\u0016J\b\u0010?\u001a\u00020\nH\u0016J\u001a\u0010B\u001a\u00020\n2\u0006\u0010@\u001a\u00020+2\b\u0010\t\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u00020\n2\u0006\u0010@\u001a\u00020+2\b\u0010\t\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010D\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010CH\u0016J\b\u0010E\u001a\u00020\nH\u0016J(\u0010I\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020+2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010GH\u0016J\b\u0010J\u001a\u00020\u001fH\u0016J\"\u0010O\u001a\u00020\n2\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00042\b\u0010N\u001a\u0004\u0018\u00010MH\u0016J\u0018\u0010Q\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0016J\b\u0010R\u001a\u00020\nH\u0016J\b\u0010S\u001a\u00020\nH\u0016J\b\u0010T\u001a\u00020+H\u0016J\b\u0010U\u001a\u00020\nH\u0016J\u001a\u0010W\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010VH\u0016J\u0016\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010XH\u0016J\u001e\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020[\u0018\u00010X2\u0006\u0010Z\u001a\u00020+H\u0016R0\u0010_\u001a\u0004\u0018\u00010]2\n\b\u0001\u0010^\u001a\u0004\u0018\u00010]8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR.\u0010f\u001a\u0004\u0018\u00010e2\b\u0010^\u001a\u0004\u0018\u00010e8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k¨\u0006p"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/OpenPlatformAnchorServiceImpl;", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAnchorService;", "Lko0/c;", "getMiniAppLiveCastEntranceInfo", "", "appId", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "callback", "", "invokeLiveOpenApi", "Lj70/h;", "Lh70/b;", "getAnchorMiniAppWidgetDescriptor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/view/ViewGroup;", "containerView", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam", "shootWay", "Ljo0/a;", "previewMiniAppWidget", "Landroidx/lifecycle/LifecycleObserver;", "getPreviewMiniAppWidgetLifecycleObserver", "schema", "Lko0/b;", "launchParams", "openMiniApp", "openLiveCastingMiniApp", "", "isMiniAppMounted", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "mount", "unmount", "getPreviewStarOrderId", "mountData", "openExplainCardSettingDialog", "success", "Landroid/view/Surface;", "surface", "", "fps", "notifyMiniAppStartLinkCastResult", "param", "clearSwitchingLock", "notifyMiniAppStopLinkCastResult", "openShelfManagementPage", "clickAnchorToolbarMiniApp", "mpId", "enterPosition", "exitSource", "reportExitMpBind", "Lcom/bytedance/android/live/openplatform/api/model/MemoryStatus;", "getMemoryStatus", "which", "remember", "updateMemoryStatus", "source", "reportDefaultOpenFirstExplainCardOn", "reportMpShow", "reportMpClick", "newScene", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAnchorService$a;", "pauseLinkCastWhenSceneSwitched", "Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformAnchorService$a;", "resumeLinkCastWhenSceneSwitched", "closeShelfManagementPage", "scene", "", "appIdList", "openCouponPage", "isMorePanelMiniAppRedDotShowing", "clickSource", "liveType", "Lmh1/p;", "miniAppOuterHelper", "openChoosePage", "type", "reportBubbleShow", "recordSnowFlakeShown", "recordMorePanelSnowFlakeShown", "getCoexistComponent", "clearLocalKVCache", "Lw20/lc$a;", "openLiveMicroApp", "", "getCommonEventParams", "cardType", "", "getMiniAppCommonCardExtraParams", "Lso0/a;", "<set-?>", "miniAppAnchorService", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "Lyo0/b;", "openApiService", "Lyo0/b;", "getOpenApiService", "()Lyo0/b;", "setOpenApiService", "(Lyo0/b;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenPlatformAnchorServiceImpl implements IOpenPlatformAnchorService {
    public static final a Companion = null;
    private static final e diComponent = null;
    private so0.a miniAppAnchorService;
    private yo0.b openApiService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements yo0.a.InterfaceC8363a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveOpenApiCallback f84007a;

        public b(LiveOpenApiCallback r100) {
            this.f84007a = r100;
        }

        @Override // yo0.a.InterfaceC8363a
        public final void a(d r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f84007a.onError(r100.f568625b, r100.a());
        }

        @Override // yo0.a.InterfaceC8363a
        public final void b(d r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f84007a.onSuccess(r100.a());
        }
    }

    static {
        Companion = new a();
        diComponent = po0.a.a();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void clearLocalKVCache() {
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r100 = com.bytedance.android.livesdk.sharedpref.b.M3;
        Boolean r101 = Boolean.TRUE;
        r100.getClass();
        f.d(r100, r101);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = com.bytedance.android.livesdk.sharedpref.b.L3;
        r102.getClass();
        f.d(r102, 0);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r103 = com.bytedance.android.livesdk.sharedpref.b.O3;
        r103.getClass();
        f.d(r103, r101);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = com.bytedance.android.livesdk.sharedpref.b.I3;
        r104.getClass();
        f.d(r104, r101);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r105 = com.bytedance.android.livesdk.sharedpref.b.J3;
        r105.getClass();
        f.d(r105, r101);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r106 = com.bytedance.android.livesdk.sharedpref.b.K3;
        r106.getClass();
        f.d(r106, r101);
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void clickAnchorToolbarMiniApp() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 == null) goto L6;
        r100.clickAnchorToolbarMiniApp();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void closeShelfManagementPage() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 == null) goto L6;
        r100.closeShelfManagementPage();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public h<? extends h70.b> getAnchorMiniAppWidgetDescriptor() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAnchorMiniAppWidgetDescriptor();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public int getCoexistComponent() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCoexistComponent();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public Map<String, String> getCommonEventParams() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCommonEventParams();
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public MemoryStatus getMemoryStatus() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMemoryStatus();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public c getMiniAppLiveCastEntranceInfo() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMiniAppLiveCastEntranceInfo();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public String getPreviewStarOrderId() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPreviewStarOrderId();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public boolean isMiniAppMounted() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.e();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public boolean isMorePanelMiniAppRedDotShowing() {
        if (ud0.f121363a.getValue().booleanValue() == false) goto L22;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r100 = AnchorMiniAppDataContext.a.a();
        if (r100 == null) goto L11;
        n<MiniAppEntrancePermissionResponse> r101 = r100.getEntranceInfo();
        if (r101 == null) goto L11;
        MiniAppEntrancePermissionResponse r102 = r101.getValue();
        if (r102 == null) goto L11;
        boolean r103 = r102.getPermit();
    L12:
        if (r103 == true) goto L14;
        return false;
    L14:
        if (y3.l().n(ToolbarButton.OPEN_PLATFORM_MINI_APP) == true) goto L24;
        Integer r104 = com.bytedance.android.livesdk.sharedpref.b.L3.getValue();
        if (r104 != null) goto L19;
        return false;
    L19:
        if (r104.intValue() != 0) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L11:
        r103 = false;
        goto L12
    L22:
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void openLiveCastingMiniApp() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 == null) goto L6;
        r100.openLiveCastingMiniApp();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openShelfManagementPage() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 == null) goto L6;
        r100.openShelfManagementPage();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void recordMorePanelSnowFlakeShown() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 == null) goto L9;
        OpenPlatformContext r101 = r100.a();
        if (r101 == null) goto L9;
        if (r101.isInLive() != true) goto L9;
        int r102 = 2;
    L10:
        int r103 = no0.a.f519883a;
        no0.a.c(r102, 2, 1);
        return;
    L9:
        r102 = 1;
        goto L10
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void recordSnowFlakeShown() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 == null) goto L9;
        OpenPlatformContext r101 = r100.a();
        if (r101 == null) goto L9;
        OpenPlatformPerformanceReportService r102 = (OpenPlatformPerformanceReportService) r101.getService(OpenPlatformPerformanceReportService.class);
        if (r102 == null) goto L9;
        r102.k(true);
    L9:
        so0.a r103 = this.miniAppAnchorService;
        if (r103 == null) goto L16;
        OpenPlatformContext r104 = r103.a();
        if (r104 == null) goto L16;
        if (r104.isInLive() != true) goto L16;
        int r105 = 2;
    L17:
        int r106 = no0.a.f519883a;
        no0.a.c(r105, 1, 1);
        return;
    L16:
        r105 = 1;
        goto L17
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportMpClick() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 == null) goto L6;
        r100.reportMpClick();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportMpShow() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 == null) goto L6;
        r100.reportMpShow();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void unmount() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 == null) goto L6;
        r100.unmount();
        return;
    }

    public OpenPlatformAnchorServiceImpl() {
        po0.a.b r100 = (po0.a.b) diComponent;
        setMiniAppAnchorService(r100.f530021b.get());
        setOpenApiService(r100.f530022c.get());
        k.l(IOpenPlatformAnchorService.class, this);
        v.a();
    }

    public static final /* synthetic */ e access$getDiComponent$cp() {
        return diComponent;
    }

    public final so0.a getMiniAppAnchorService() {
        return this.miniAppAnchorService;
    }

    public final yo0.b getOpenApiService() {
        return this.openApiService;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public Map<String, Object> getMiniAppCommonCardExtraParams(int r100) {
        so0.a r101 = this.miniAppAnchorService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.c();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void mount(ShelfInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "shelfInfo");
        so0.a r101 = this.miniAppAnchorService;
        if (r101 == null) goto L6;
        r101.mount(r100);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openExplainCardSettingDialog(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "mountData");
        so0.a r101 = this.miniAppAnchorService;
        if (r101 == null) goto L6;
        r101.openExplainCardSettingDialog(r100);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void resumeLinkCastWhenSceneSwitched(IMiddlewareOpenPlatformAnchorService.a r100) {
        if ((r100 instanceof IOpenPlatformAnchorService.a) == false) goto L8;
        so0.a r101 = this.miniAppAnchorService;
        if (r101 == null) goto L9;
        r101.resumeLinkCastWhenSceneSwitched((IOpenPlatformAnchorService.a) r100);
        return;
    L9:
        return;
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r100) {
        this.miniAppAnchorService = r100;
    }

    @Inject
    public final void setOpenApiService(yo0.b r100) {
        this.openApiService = r100;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void resumeLinkCastWhenSceneSwitched(IOpenPlatformAnchorService.a r100) {
        so0.a r101 = this.miniAppAnchorService;
        if (r101 == null) goto L6;
        r101.resumeLinkCastWhenSceneSwitched(r100);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void openLiveMicroApp(String r100, lc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        so0.a r102 = this.miniAppAnchorService;
        if (r102 == null) goto L6;
        r102.openLiveMicroApp(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openMiniApp(String r100, ko0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "launchParams");
        so0.a r102 = this.miniAppAnchorService;
        if (r102 == null) goto L6;
        r102.openMiniApp(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void pauseLinkCastWhenSceneSwitched(int r100, IMiddlewareOpenPlatformAnchorService.a r101) {
        if ((r101 instanceof IOpenPlatformAnchorService.a) == false) goto L8;
        so0.a r102 = this.miniAppAnchorService;
        if (r102 == null) goto L9;
        r102.pauseLinkCastWhenSceneSwitched(r100, (IOpenPlatformAnchorService.a) r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportBubbleShow(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mpId");
        Intrinsics.checkNotNullParameter(r101, "type");
        so0.a r102 = this.miniAppAnchorService;
        if (r102 == null) goto L6;
        r102.reportBubbleShow(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportDefaultOpenFirstExplainCardOn(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mpId");
        Intrinsics.checkNotNullParameter(r101, "source");
        so0.a r102 = this.miniAppAnchorService;
        if (r102 == null) goto L6;
        r102.reportDefaultOpenFirstExplainCardOn(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void updateMemoryStatus(int r100, boolean r101) {
        so0.a r102 = this.miniAppAnchorService;
        if (r102 == null) goto L6;
        r102.updateMemoryStatus(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void pauseLinkCastWhenSceneSwitched(int r100, IOpenPlatformAnchorService.a r101) {
        so0.a r102 = this.miniAppAnchorService;
        if (r102 == null) goto L6;
        r102.pauseLinkCastWhenSceneSwitched(r100, r101);
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

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void notifyMiniAppStartLinkCastResult(boolean r100, Surface r101, int r102) {
        so0.a r103 = this.miniAppAnchorService;
        if (r103 == null) goto L6;
        r103.notifyMiniAppStartLinkCastResult(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void notifyMiniAppStopLinkCastResult(boolean r100, JSONObject r101, boolean r102) {
        so0.a r103 = this.miniAppAnchorService;
        if (r103 == null) goto L6;
        r103.h(r100, r102, r101);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openChoosePage(String r100, String r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, "clickSource");
        Intrinsics.checkNotNullParameter(r101, "liveType");
        so0.a r103 = this.miniAppAnchorService;
        if (r103 == null) goto L6;
        r103.openChoosePage(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openCouponPage(Context r100, int r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        so0.a r103 = this.miniAppAnchorService;
        if (r103 == null) goto L6;
        r103.openCouponPage(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportExitMpBind(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mpId");
        Intrinsics.checkNotNullParameter(r101, "enterPosition");
        Intrinsics.checkNotNullParameter(r102, "exitSource");
        so0.a r103 = this.miniAppAnchorService;
        if (r103 == null) goto L6;
        r103.reportExitMpBind(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public LifecycleObserver getPreviewMiniAppWidgetLifecycleObserver(Context r100, ViewGroup r101, PreviewSourceParam r102, String r103, jo0.a r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "shootWay");
        Intrinsics.checkNotNullParameter(r104, "previewMiniAppWidget");
        so0.a r105 = this.miniAppAnchorService;
        if (r105 != null) goto L7;
        return null;
    L7:
        return r105.d(r100, r101, r102, r103);
    }
}
