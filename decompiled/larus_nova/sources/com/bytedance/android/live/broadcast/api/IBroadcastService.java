package com.bytedance.android.live.broadcast.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.live.broadcast.api.interacttools.IInteractPluginWidget;
import com.bytedance.android.live.broadcast.api.link.BaseScreenLinkControlWidget;
import com.bytedance.android.live.broadcast.api.model.LiveToolbarMountType;
import com.bytedance.android.live.broadcast.api.model.ScheduledSettingInfo;
import com.bytedance.android.live.broadcast.api.model.s0;
import com.bytedance.android.live.browser.jsbridge.base.LiveGetReplaySettingResultModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveOpenRoomMemberLimitExemptionDialogResultModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateReplaySettingResultModel;
import com.bytedance.android.live.browser.jsbridge.base.PaidPreviewVisibilityOptionsResultModel;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.effect.api.b;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.g;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdkapi.LiveActivityProxy;
import com.bytedance.android.livesdkapi.broadcast.IBgBroadcastService;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBgBroadcastFragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBroadcastCallback;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewContainer;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IStartLiveFragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IStartLiveManager;
import com.bytedance.android.livesdkapi.depend.model.broadcast.LiveBroadcastHashTagUpdateParams;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.model.AnchorColumnPosterInfo;
import com.bytedance.android.livesdkapi.service.IBaseBroadcastService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.google.gson.JsonObject;
import hh1.v0;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import m00.e;
import m00.f;
import m00.h;
import n00.a;
import nz.c;
import nz.i;
import nz.k;
import nz.l;
import nz.m;
import nz.n;
import nz.p;
import nz.x;
import nz.y;
import org.json.JSONObject;
import w20.nb;
import w20.yc;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.BroadcastService")
@ServiceDummyLookup("com.bytedance.android.live.broadcast.api.dummy.BroadcastServiceDummy")
public interface IBroadcastService extends IBaseBroadcastService, IMiddlewareBroadcastService, IBroadcastServiceForSaas {
    public static final int COPYING = 1;
    public static final String LIVE_HEALTH_SCORE_URL = "https://webcast.huoshan.com/falcon/webcast_huoshan/page/health_score/main/index.html?showHeader=1";
    public static final int REC_COPY_DONE = 2;
    public static final String TAG_MSG_VIEW = "msg_view";
    public static final int TYPE_LINK_IN_ROOM_VIEW_AUDIO = 1;
    public static final int WIDGET_TYPE_ANCHOR_FANS_GROUP_MANAGER = 4;
    public static final int WIDGET_TYPE_BROADCAST_INFO = 0;
    public static final int WIDGET_TYPE_BROADCAST_KTV = 3;
    public static final int WIDGET_TYPE_STAR_GRAPH_WIDGET = 5;
    public static final int WIDGET_TYPE_STICKER_TIP = 1;
    public static final int WIDGET_TYPE_TASK_FINISH_ANIM = 2;
    public static final int WIDGET_TYPE_VIDEO_PLAY_CONTROL = 2333;

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    a broadcastFloatWindowManager();

    void checkAndRequestBroadcastPermission(Fragment r100, LiveMode r101, String r102, c r103, m r104);

    void checkAndRequestBroadcastPermission(FragmentActivity r100, LiveMode r101, String r102, c r103, m r104);

    Observable<g<Room>> checkGameRoomState();

    boolean closeAllInteractPlugin(boolean r100);

    void closeAndRestartBroadcast(Context r100, boolean r101);

    boolean closeInteractPluginCard(String r100, boolean r101);

    boolean closeLynxPlugin(s0 r100);

    IBgBroadcastService createBgBroadcastBinder();

    Fragment createBgBroadcastFragment(k r100, Bundle r101);

    ILiveBgBroadcastFragment createBgBrowseFragment(Bundle r100);

    ILiveBgBroadcastFragment createBgMirrorFragment(Bundle r100);

    Fragment createBroadcastStreamFragment(k r100, LiveMode r101, StreamUrlExtra r102, String r103);

    Fragment createBroadcastStreamFragment(k r100, LiveMode r101, StreamUrlExtra r102, String r103, Bundle r104);

    f createCoverController(Fragment r100, Room r101);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    m00.c createDigitAvatarPreView(Context r100);

    b createEffectGestureDetector(Context r100);

    void createInteractPluginCard(String r100, View r101);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    e createLinkInRoomView(d r100, Context r101, int r102);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    m00.d createLinkVideoView(Context r100, m00.d.a r101, String r102, boolean r103);

    Fragment createLiveBroadcastFragment(k r100, ILiveBroadcastCallback r101, Bundle r102);

    ILivePreviewContainer createPreviewContainerFragment(Bundle r100);

    c0.b createReplayVisibilityBehavior(Context r100, Episode r101);

    BaseScreenLinkControlWidget createScreenControlWidget(BaseScreenLinkControlWidget.a r100, ViewGroup r101, tlc.d r102);

    Widget createScreenLiveWidget(v0 r100);

    LiveActivityProxy createStartLiveActivityProxy(FragmentActivity r100);

    IStartLiveFragment createStartLiveFragment();

    com.bytedance.android.live.effect.api.m createStickerStatusReportUtil();

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    m00.g createVideoTalkView(Context r100, String r101, boolean r102, boolean r103, boolean r104, m00.g.a r105);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    h createVoiceRoomVideoView(Context r100, String r101);

    Fragment createXTMediaBroadcastFragment(ILiveBroadcastCallback r100, Bundle r101);

    void destroyInitStartLiveData(boolean r100);

    p digitAvatarEffectHelper();

    void downloadRequirements(List<String> r100);

    void exitStableModel(String r100);

    boolean fastStartLivePreCheck(FragmentActivity r100, LiveMode r101);

    void fastStartLivePreLoad(FragmentActivity r100, FastStartLiveConfig r101);

    IAnchorBizPanelService fetchAnchorBizPanelService();

    nz.g fetchAnchorStatusPanelService();

    Observable<g<Room>> fetchContinueRoom();

    Observable<com.bytedance.android.live.network.response.e<Room>> fetchContinueRoomWithPb();

    j70.h<? extends h70.b> getAddPictureWidgetDescriptor();

    String getAuthString(String r100);

    nz.h getBroadcastBubbleManager();

    i getBroadcastDotManager();

    String getDeviceNum(String r100);

    ArrayList<String> getDeviceNumList(String r100);

    rz.a getDotManager();

    IGameCPPreviewService getGameCPPreviewService();

    com.bytedance.ies.web.jsbridge2.f<JsonObject, LiveGetReplaySettingResultModel> getGetReplaySettingMethod();

    j70.h<? extends h70.b> getGroupLiveStreamWidgetDescriptor();

    IInteractPluginWidget getInteractPluginWidget(Fragment r100, FragmentManager r101);

    j70.h<? extends h70.b> getInteractToolInfoUploadServiceWidgetDescriptor();

    j70.h<? extends h70.b> getInteractToolPerformanceWidgetDescriptor();

    a00.a getInteractToolsMobInfo(String r100);

    LiveWidget getInteractToolsServiceWidget();

    l getInteractionScopeManager(Long r100, DataCenter r101);

    j70.h<? extends h70.b> getLiveAnchorTrialServiceWidget();

    sz.a getLiveByteCastSinkService();

    IBaseSchemaHandler getOpenLiveVisiblePageActionHandler();

    com.bytedance.ies.web.jsbridge2.f<JsonObject, LiveOpenRoomMemberLimitExemptionDialogResultModel> getOpenRoomMemberLimitExemptionDialogMethod();

    com.bytedance.ies.web.jsbridge2.f<yc, PaidPreviewVisibilityOptionsResultModel> getPaidPreviewVisibilityOptionsMethod();

    j70.h<? extends h70.b> getPicturePresentationWidgetDescriptor();

    Bitmap getPreviewBitmap();

    LiveMode getPreviewLiveMode();

    Boolean getPreviewToolbarDotInfo(String r100, int r101);

    Map<String, String> getRestartContinueLogExtra();

    Room getRestartContinueRoom();

    List<String> getRunningInteractPluginIds();

    Set<String> getRunningInteractPlugins();

    j70.h<? extends h70.b> getScreenRecordMonitorWidgetDescriptor();

    n getStableManager(DataCenter r100);

    Class<? extends Widget> getStartLiveVisibilityTransformWidgetClass();

    com.bytedance.ies.web.jsbridge2.f<nb, LiveUpdateReplaySettingResultModel> getUpdateReplaySettingMethod();

    <T> Class<T> getWidgetClass(int r100);

    IXTBroadcastService getXTBroadcastService();

    x getXTMediaBroadcastService();

    void handleAnchorPerformanceLevel(int r100);

    void handleLowMemory();

    boolean handlerRestartBroadcastActivity(Context r100, String r101);

    void hideInteractPluginCard(String r100);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    void init();

    void installPlugin(pz.a r100);

    boolean isInAudioPlayBackCapture();

    boolean isInterceptOnClickToolBar(DataCenter r100, ToolbarButton r101);

    boolean isPluginRunning(String r100);

    boolean isRequirementsDownloaded(List<String> r100);

    boolean isUserInAnchorLink(String r100);

    boolean isWiredCasting(String r100);

    AnnieXWebKit loadAnnieXWebKit(Context r100, Uri r101, String r102, MethodFinder r103, Map<String, Object> r104, Function2<String, WebView, Void> r105, Function2<String, Throwable, Void> r106);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    Observable<Integer> loadShortVideoRes();

    void markDotClicked(String r100);

    void markEnterSceneFromJsb(int r100);

    void mountToolbarComponent(int r100, LiveToolbarMountType r101);

    void onActivityResult(int r100, int r101, Intent r102, String r103);

    void openAnnouncementPushDialog(Context r100, Boolean r101);

    void openCategoryDialog(Context r100, DataCenter r101);

    void openForenoticeDialog(Context r100, boolean r101, boolean r102, ScheduledSettingInfo r103, y r104, int r105, String r106);

    void openLiveDelaySchemeActivity(Context r100, String r101, long r102);

    boolean openPluginMiniApp(String r100, String r101, String r102, Map<String, String> r103);

    void openPosterGenerateDialog(Context r100, AnchorColumnPosterInfo r101);

    void openPreviewSettingDialog(Context r100);

    void openPrivilegeDetailSettingDialog(Context r100);

    void openRoomChoosePVCountDialog(FragmentActivity r100, Room r101, LiveMode r102);

    void openRoomIntroMediaDialog(FragmentActivity r100, Room r101, LiveMode r102, Function0<Unit> r103);

    void openStableModeDialog(String r100);

    void openVideoCategoryDialog(Context r100, String r101);

    void preInitStartLiveData(Long r100, String... r101);

    void preInitStartLiveData(String... r100);

    void preInitStartLiveDataWithBundle(Bundle r100, Long r101, String... r102);

    void preInitStartLiveOnComponentCreate(Long r100, String... r101);

    Object provideToolbarBehavior(int r100, List<Object> r101);

    void putInteractToolsMobInfo(String r100, a00.a r101);

    void recordLiveStart();

    void recordPublishSuccess();

    void recyclerPreviewBitmap();

    void registerScopeService();

    void removeInteractToolsMobInfo(String r100);

    void removeToolbarComponent(int r100);

    void reply(String r100, int r101, int r102, boolean r103, long r104, long r105, int r106, String r110, String r111, pc0.b r112);

    Observable<Response<Object>> reportRoomEvent(int r100, long r101, int r102, String r103);

    void resetHeap(LiveMode r100, Context r101);

    @Override // com.bytedance.android.livesdkapi.service.IBaseBroadcastService
    void restoreVideoRecordActivity(Context r100);

    void savePerfKeva(JSONObject r100);

    void setMetadata(String r100, String r101, Map<String, String> r102);

    void setOnInvitedListener(mc0.a r100);

    boolean shouldDefaultToLive();

    void showAddAnchorShowDialog(Context r100, int r101, int r102, m00.b r103);

    void showAnchorManagerInputDialog(Context r100, int r101, String r102, m00.a r103);

    boolean showInteractPluginCard(String r100);

    void showLiveGameDiscoveryDialog(Context r100, Bundle r101);

    boolean showMultiCameraConnectionPanel(Context r100, DataCenter r101, Map<String, String> r102);

    void startBrowse(String r100);

    IStartLiveManager startLiveManager();

    boolean startLynxPlugin(s0 r100);

    void startWirelessBrowse(String r100, String r101);

    void startWirelessMirror(HashMap<String, Object> r100, String r101);

    void stopBrowse(String r100);

    void stopBrowseMirror();

    void stopCastWithDialog(Context r100, String r101);

    void stopPoll(String r100);

    void stopWirelessMirror(String r100);

    void traceLandingSwitch(String r100);

    void tryInitBrowseCastService(pz.a r100);

    void tryInitCastService(Intent r100, pz.a r101);

    void tryInitWiredCastService(Intent r100, pz.a r101);

    void tryInitWirelessCastService(pz.a r100);

    Observable<Integer> updateBroadcastRoomHashTag(LiveBroadcastHashTagUpdateParams r100);

    Observable<String> updateForenoticeInfo(ScheduledSettingInfo r100);

    void updateGameMsgViewUserCount(Long r100);

    boolean updateLynxPlugin(s0 r100);
}
