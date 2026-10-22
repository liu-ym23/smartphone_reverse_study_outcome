package com.bytedance.android.ec.hybrid.hostapi;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridLynxPreDecodeConfigDTO;
import com.bytedance.android.ecom.service_annotation.ReturnSubService;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import t07.a;
import yj.c;
import yj.e;
import yj.f;
import yj.g;
import yj.h;
import yj.i;
import yj.j;
import yj.k;
import yj.l;
import yj.m;
import yj.n;
import yj.p;
import yj.q;
import yj.r;
import yj.s;
import yj.t;
import yj.u;
import yj.v;
import yj.w;
import yj.x;
import yj.y;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H'J\b\u0010\u0005\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\u0006H'J\n\u0010\t\u001a\u0004\u0018\u00010\bH'J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH'J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0017J\b\u0010\u0011\u001a\u00020\u0010H'J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H'J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0017J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0017J\b\u0010\u0019\u001a\u00020\u0018H'J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0017J\b\u0010\u001d\u001a\u00020\u001cH'J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H&J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J+\u0010(\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010$*\u00020\u00012\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0004\b(\u0010)J\b\u0010+\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020,H&J\u0016\u00101\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0017J\u0010\u00107\u001a\u0002062\u0006\u00105\u001a\u000204H&Jz\u0010G\u001a\u0002062\u0006\u00108\u001a\u00020*2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010%2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020*2(\b\u0002\u0010C\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010Aj\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u0001`B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\u0006\u0010F\u001a\u00020*H&J\u0018\u0010K\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`J2\u0006\u0010I\u001a\u00020HH&J\u0014\u0010L\u001a\u0002062\n\u0010I\u001a\u00060\u0001j\u0002`JH&J\b\u0010M\u001a\u00020*H&J\u0010\u0010O\u001a\u0002062\u0006\u0010N\u001a\u00020*H&J\b\u0010P\u001a\u00020*H\u0016J\b\u0010Q\u001a\u00020*H\u0016J \u0010W\u001a\u0004\u0018\u00010V2\u0006\u0010S\u001a\u00020R2\f\u0010U\u001a\b\u0012\u0004\u0012\u0002060TH\u0016J\b\u0010X\u001a\u00020*H\u0016J\u0011\u0010Y\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\bY\u0010ZJ\u0010\u0010\\\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010[H\u0016J\u0010\u0010]\u001a\u0002062\u0006\u0010S\u001a\u00020RH&J0\u0010b\u001a\u0002062\b\b\u0002\u0010^\u001a\u00020%2\b\b\u0002\u0010_\u001a\u00020%2\b\b\u0002\u0010`\u001a\u00020%2\b\b\u0002\u0010a\u001a\u00020%H\u0016J\n\u0010d\u001a\u0004\u0018\u00010cH\u0016J\u0018\u0010h\u001a\u0002062\u0006\u0010e\u001a\u00020%2\u0006\u0010g\u001a\u00020fH&J\b\u0010i\u001a\u00020*H\u0016J\b\u0010j\u001a\u00020*H\u0016J\u0012\u0010l\u001a\u00020*2\b\u0010k\u001a\u0004\u0018\u00010%H\u0016J\b\u0010m\u001a\u00020*H\u0016J\u0012\u0010n\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\b\u0010o\u001a\u00020*H\u0016J\u001e\u0010q\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020>\u0018\u00010.2\u0006\u0010p\u001a\u00020%H\u0016J\b\u0010r\u001a\u00020*H\u0016J\u0012\u0010s\u001a\u0002062\b\u0010&\u001a\u0004\u0018\u00010%H&J\u0012\u0010v\u001a\u0002062\b\u0010u\u001a\u0004\u0018\u00010tH&J\u0011\u0010w\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\bw\u0010xJ\u0012\u0010{\u001a\u0004\u0018\u00010z2\u0006\u0010y\u001a\u00020RH\u0016J\u0018\u0010~\u001a\u0002062\u0006\u0010|\u001a\u00020%2\u0006\u0010}\u001a\u00020*H\u0016J \u0010\u007f\u001a\u0002062\u0006\u0010S\u001a\u00020R2\u0006\u0010|\u001a\u00020%2\u0006\u0010}\u001a\u00020*H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020*2\u0006\u0010|\u001a\u00020%H\u0016J\u0012\u0010\u0082\u0001\u001a\u0002062\u0007\u0010\u0081\u0001\u001a\u00020%H\u0016J\t\u0010\u0083\u0001\u001a\u00020*H\u0016J\u0011\u0010\u0084\u0001\u001a\u0002062\u0006\u0010}\u001a\u00020*H\u0016J\t\u0010\u0085\u0001\u001a\u000206H\u0016¨\u0006\u0086\u0001"}, d2 = {"Lcom/bytedance/android/ec/hybrid/hostapi/IHybridHostService;", "", "Lyj/i;", "getIHybridHostAppInfo", "Lyj/n;", "getIHybridHostNetService", "Lyj/p;", "IHybridHostRouterService", "Lyj/u;", "getIHybridPluginService", "Lyj/x;", "getECPluginService", "Lyj/q;", "getServiceProvider", "Lyj/l;", "getIHybridHostFrescoService", "Lyj/r;", "getIHybridHostUIService", "Lyj/h;", "getIHybridHostALogService", "Lyj/w;", "getMallOptService", "Lyj/v;", "getMallScrollService", "Lyj/s;", "getIHybridHostUserService", "Lyj/m;", "getIHybridHostKVService", "Lyj/k;", "getIHybridHostEventService", "Lyj/t;", "getHybridLynxHostService", "Lt07/a;", "geIlynxKitService", "Lyj/g;", "getHostAB", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "defaultValue", "getHostABValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "", "liveSdkInitFinished", "Lyj/f;", "getHybridECSdkService", "", "", "Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridLynxPreDecodeConfigDTO;", "getLynxCardPreDecodeData", "Lyj/j;", "getIHybridHostECSchemaMonitorService", "Landroid/app/Activity;", "activity", "", "preloadFloatLive", "show", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "Landroid/widget/FrameLayout;", "rootView", "requestPage", "", "enterRoomId", "muteStatus", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "ecomParams", "Landroid/widget/RelativeLayout$LayoutParams;", "layoutParams", "enableChangePosition", "showOrHideFloatLive", "Lyj/y;", "listener", "Lcom/bytedance/android/ec/hybrid/hostapi/LiveFloatManagerListenerHolder;", "addLiveFloatManagerListener", "removeLiveFloatManagerListener", "isShowingFloatLive", "open", "toggleLiveAudio", "isMallTopTabSupported", "needCheckLoginState", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/Function0;", "clickListener", "Landroid/view/View;", "getLoginGuideView", "enableJsbAsync", "getLocationPermissionParam", "()Ljava/lang/Integer;", "Lio/reactivex/Observable;", "getAppBackgroundStateObservable", "ttWebWarmUpAsync", "sceneName", "enterFrom", "guideStyleType", "needLoading", "installDesktopApp", "Lyj/c;", "getIECVideoPreloadManager", "scene", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "attachDropFrameMonitorTo", "isPadDevice", "isFoldDevice", "url", "isSearchNewAbSchema", "forbidMallLoadInAbSchema", "isInMallTab", "resumeMallAfterFinish", "stage", "addABSearchTimeMills", "isInnerPushShowing", "recordPerformanceTimestamp", "Lorg/json/JSONObject;", "metric", "reportThreadPoolInfo", "getRecommendStatus", "()Ljava/lang/Boolean;", "ctx", "Lyj/e;", "gylLoadMoreContainer", "pageName", "isDark", "refreshTabTheme", "updateThemeStorage", "getStorageTheme", "msg", "ensureNotReachHere", "isLargeDevice", "updateBadgeStyle", "notifyPreloadDeepFeedSlc", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHybridHostService {
    @ReturnSubService
    p IHybridHostRouterService();

    Map<String, Long> addABSearchTimeMills(String r100);

    Object addLiveFloatManagerListener(y r100);

    void attachDropFrameMonitorTo(String r100, RecyclerView r101);

    boolean enableJsbAsync();

    void ensureNotReachHere(String r100);

    boolean forbidMallLoadInAbSchema();

    a geIlynxKitService();

    Observable<Boolean> getAppBackgroundStateObservable();

    @ReturnSubService
    x getECPluginService();

    g getHostAB();

    <T> T getHostABValue(String r100, T r101);

    f getHybridECSdkService();

    t getHybridLynxHostService();

    c getIECVideoPreloadManager();

    @ReturnSubService
    h getIHybridHostALogService();

    @ReturnSubService
    i getIHybridHostAppInfo();

    @ReturnSubService
    j getIHybridHostECSchemaMonitorService();

    @ReturnSubService
    k getIHybridHostEventService();

    @ReturnSubService
    l getIHybridHostFrescoService();

    @ReturnSubService
    m getIHybridHostKVService();

    @ReturnSubService
    n getIHybridHostNetService();

    @ReturnSubService
    r getIHybridHostUIService();

    @ReturnSubService
    s getIHybridHostUserService();

    @ReturnSubService
    u getIHybridPluginService();

    Integer getLocationPermissionParam();

    View getLoginGuideView(Context r100, Function0<Unit> r101);

    Map<Integer, ECHybridLynxPreDecodeConfigDTO> getLynxCardPreDecodeData();

    @ReturnSubService
    w getMallOptService();

    @ReturnSubService
    v getMallScrollService();

    Boolean getRecommendStatus();

    q getServiceProvider();

    boolean getStorageTheme(String r100);

    e gylLoadMoreContainer(Context r100);

    void installDesktopApp(String r100, String r101, String r102, String r103);

    boolean isFoldDevice();

    boolean isInMallTab(Activity r100);

    boolean isInnerPushShowing();

    boolean isLargeDevice();

    boolean isMallTopTabSupported();

    boolean isPadDevice();

    boolean isSearchNewAbSchema(String r100);

    boolean isShowingFloatLive();

    boolean liveSdkInitFinished();

    boolean needCheckLoginState();

    void notifyPreloadDeepFeedSlc();

    void preloadFloatLive(Activity r100);

    void recordPerformanceTimestamp(String r100);

    void refreshTabTheme(String r100, boolean r101);

    void removeLiveFloatManagerListener(Object r100);

    void reportThreadPoolInfo(JSONObject r100);

    boolean resumeMallAfterFinish();

    void showOrHideFloatLive(boolean r100, Fragment r101, FrameLayout r102, String r103, long r104, boolean r105, HashMap<String, String> r106, RelativeLayout.LayoutParams r107, boolean r110);

    void toggleLiveAudio(boolean r100);

    void ttWebWarmUpAsync(Context r100);

    void updateBadgeStyle(boolean r100);

    void updateThemeStorage(Context r100, String r101, boolean r102);
}
