package com.bytedance.android.shopping.api.mall.common.tools;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridLynxPreDecodeConfigDTO;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ecom.service_annotation.ReturnSubService;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements IHybridHostService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f170438b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IHybridHostService f170439a;

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.p IHybridHostRouterService() {
        return this.f170439a.IHybridHostRouterService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final Map<String, Long> addABSearchTimeMills(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        return this.f170439a.addABSearchTimeMills(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final Object addLiveFloatManagerListener(yj.y r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        return this.f170439a.addLiveFloatManagerListener(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void attachDropFrameMonitorTo(String r100, RecyclerView r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        this.f170439a.attachDropFrameMonitorTo(r100, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean enableJsbAsync() {
        return this.f170439a.enableJsbAsync();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void ensureNotReachHere(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f170439a.ensureNotReachHere(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean forbidMallLoadInAbSchema() {
        return this.f170439a.forbidMallLoadInAbSchema();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final t07.a geIlynxKitService() {
        return this.f170439a.geIlynxKitService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final Observable<Boolean> getAppBackgroundStateObservable() {
        return this.f170439a.getAppBackgroundStateObservable();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.x getECPluginService() {
        return this.f170439a.getECPluginService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final yj.g getHostAB() {
        return this.f170439a.getHostAB();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final <T> T getHostABValue(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        return (T) this.f170439a.getHostABValue(r100, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final yj.f getHybridECSdkService() {
        return this.f170439a.getHybridECSdkService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final yj.t getHybridLynxHostService() {
        return this.f170439a.getHybridLynxHostService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final yj.c getIECVideoPreloadManager() {
        this.f170439a.getIECVideoPreloadManager();
        return null;
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.h getIHybridHostALogService() {
        return this.f170439a.getIHybridHostALogService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.i getIHybridHostAppInfo() {
        return this.f170439a.getIHybridHostAppInfo();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.j getIHybridHostECSchemaMonitorService() {
        this.f170439a.getIHybridHostECSchemaMonitorService();
        return null;
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.k getIHybridHostEventService() {
        return this.f170439a.getIHybridHostEventService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.l getIHybridHostFrescoService() {
        return this.f170439a.getIHybridHostFrescoService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.m getIHybridHostKVService() {
        this.f170439a.getIHybridHostKVService();
        return null;
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.n getIHybridHostNetService() {
        return this.f170439a.getIHybridHostNetService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.r getIHybridHostUIService() {
        return this.f170439a.getIHybridHostUIService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.s getIHybridHostUserService() {
        return this.f170439a.getIHybridHostUserService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.u getIHybridPluginService() {
        return this.f170439a.getIHybridPluginService();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final Integer getLocationPermissionParam() {
        return this.f170439a.getLocationPermissionParam();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final View getLoginGuideView(Context r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "clickListener");
        return this.f170439a.getLoginGuideView(r100, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final Map<Integer, ECHybridLynxPreDecodeConfigDTO> getLynxCardPreDecodeData() {
        return this.f170439a.getLynxCardPreDecodeData();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.w getMallOptService() {
        this.f170439a.getMallOptService();
        return null;
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    @ReturnSubService
    public final yj.v getMallScrollService() {
        this.f170439a.getMallScrollService();
        return null;
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final Boolean getRecommendStatus() {
        return this.f170439a.getRecommendStatus();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final yj.q getServiceProvider() {
        return this.f170439a.getServiceProvider();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean getStorageTheme(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        return this.f170439a.getStorageTheme(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final yj.e gylLoadMoreContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f170439a.gylLoadMoreContainer(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void installDesktopApp(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "sceneName");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "guideStyleType");
        Intrinsics.checkNotNullParameter(r103, "needLoading");
        this.f170439a.installDesktopApp(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean isFoldDevice() {
        return this.f170439a.isFoldDevice();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean isInMallTab(Activity r100) {
        return this.f170439a.isInMallTab(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean isInnerPushShowing() {
        return this.f170439a.isInnerPushShowing();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean isLargeDevice() {
        return this.f170439a.isLargeDevice();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean isMallTopTabSupported() {
        return this.f170439a.isMallTopTabSupported();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean isPadDevice() {
        return this.f170439a.isPadDevice();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean isSearchNewAbSchema(String r100) {
        return this.f170439a.isSearchNewAbSchema(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean isShowingFloatLive() {
        return this.f170439a.isShowingFloatLive();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean liveSdkInitFinished() {
        return this.f170439a.liveSdkInitFinished();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean needCheckLoginState() {
        return this.f170439a.needCheckLoginState();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void notifyPreloadDeepFeedSlc() {
        this.f170439a.notifyPreloadDeepFeedSlc();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void preloadFloatLive(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f170439a.preloadFloatLive(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void recordPerformanceTimestamp(String r100) {
        this.f170439a.recordPerformanceTimestamp(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void refreshTabTheme(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        this.f170439a.refreshTabTheme(r100, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void removeLiveFloatManagerListener(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f170439a.removeLiveFloatManagerListener(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void reportThreadPoolInfo(JSONObject r100) {
        this.f170439a.reportThreadPoolInfo(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final boolean resumeMallAfterFinish() {
        return this.f170439a.resumeMallAfterFinish();
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void showOrHideFloatLive(boolean r110, Fragment r111, FrameLayout r112, String r113, long r114, boolean r115, HashMap<String, String> r210, RelativeLayout.LayoutParams r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r111, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r112, "rootView");
        this.f170439a.showOrHideFloatLive(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void toggleLiveAudio(boolean r100) {
        this.f170439a.toggleLiveAudio(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void ttWebWarmUpAsync(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f170439a.ttWebWarmUpAsync(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void updateBadgeStyle(boolean r100) {
        this.f170439a.updateBadgeStyle(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.hostapi.IHybridHostService
    public final void updateThemeStorage(Context r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageName");
        this.f170439a.updateThemeStorage(r100, r101, r102);
    }

    static {
        f170438b = new h();
    }

    public h() {
        IHybridHostService r100 = com.bytedance.android.ec.hybrid.a.h();
        Intrinsics.checkNotNull(r100);
        this.f170439a = r100;
    }
}
