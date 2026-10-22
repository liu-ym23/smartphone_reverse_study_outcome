package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.push.LivePushInfo;
import com.bytedance.android.livehostapi.business.depend.ai.LiveAiPackageExtraParam;
import com.bytedance.android.livehostapi.business.depend.ai.LiveAiTaskResultCallback;
import com.bytedance.android.livehostapi.business.depend.livepreview.OpenLiveTakePageParams;
import com.bytedance.android.livehostapi.business.depend.preload.LivePushPreloadParams;
import com.bytedance.android.livesdk.chatroom.model.SimpleMediaInfo;
import com.bytedance.android.livesdk.end.EndingPageGuideCardInfo;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pushpreload.LivePushPreloadNetResult;
import com.bytedance.android.livesdkapi.feed.ILiveFeedParamService;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostAction extends IMiddlewareHostAction, IHostActionForSaas {
    public static final String BUNDLE_HIDE_MORE = "hide_more";
    public static final String BUNDLE_HIDE_NAV_BAR = "hide_nav_bar";
    public static final String BUNDLE_HIDE_STATUS_BAR = "hide_status_bar";
    public static final String BUNDLE_IS_OUT_SCENE = "is_out_scene";
    public static final String BUNDLE_IS_OUT_URL = "is_out_url";
    public static final String BUNDLE_IS_OUT_URL_TRUE = "is_from_out_scene";
    public static final String BUNDLE_ROTATE = "bundle_rotate";
    public static final String BUNDLE_SHOW_PROGRESS = "show_progress";
    public static final String BUNDLE_TITLE = "title";
    public static final String BUNDLE_URL = "url";
    public static final String ORIGIN_SCHEME = "origin_scheme";
    public static final String REGISTER_LYNX_LIFECYCLE = "ec_register_lynx_lifecycle";

    public interface BusinessInHomeSideBarCallback {
        void onResult(boolean r100);
    }

    public interface HarCallback {
        void onPredictResultChanged(boolean r100, int r101, Map<String, Float> r102);
    }

    public interface IDouyinMuteModeChangeListener {
        void onMuteModeStatusChanged(boolean r100);
    }

    public interface ILivePushPreloadTaskListener {
        void call(LivePushPreloadNetResult r100);
    }

    public interface IMConversationCallback {
        void onFailure(JSONObject r100);

        void onSuccess(JSONObject r100);
    }

    public interface IMOpenGroupChatCallback {
        void onFailure(String r100);

        void onSuccess();
    }

    public interface OHRCallback {
        void onOHRPredictChanged(Map<String, Object> r100);

        void onOHRPredictStatus(int r100);
    }

    public interface SchemeCallback extends IMiddlewareHostAction.SchemeCallback {
        @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.SchemeCallback
        void onCallBack(int r100, JSONObject r101);
    }

    void addCommonEventListener(List<String> r100);

    void addGroupMemberListForFans(String r100, String r101, Long r102, Long r103, int r104, IMConversationCallback r105);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void addLivePortraitChangeListener(IMiddlewareHostAction.ILivePortraitChangeListener r100);

    Object addMuteStatusChangeListener(IDouyinMuteModeChangeListener r100);

    boolean append(JSONObject r100);

    void beginDoFrameBoost(String r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void bulletHandleSchema(Context r100, Uri r101);

    void businessInHomeSideBar(String r100, BusinessInHomeSideBarCallback r101);

    void checkAndInitSmartOHRServiceHolder();

    Boolean checkSubSchemeSecurity(Context r100, String r101);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void checkoutNotification(Context r100, String r101, String r102, boolean r103, int r104, String r105, sy.a<Boolean> r106);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void clearGeckoFiles();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void clearLiveBannerTag(String r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    int concatVideo(String[] r100, String r101);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void configForeNoticeResult(boolean r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void configGroupPortraits(String r100, List<String> r101);

    boolean contain(String r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    boolean containsPortraitKey(String r100);

    void createGroupConversationForFans(List<Long> r100, String r101, IMConversationCallback r102);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void dismissInvitePanel();

    Observable<JSONObject> doActionWithToken(String r100, String r101, String r102, JSONObject r103);

    void endDoFrameBoost(String r100);

    void enterRoom(Context r100, Bundle r101, Room r102);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void finishLivePlayActivity();

    JSONObject getCacheWithTryLock();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    ConcurrentHashMap<String, String> getCommonClientPortraits();

    List getCommonLynxBehaviorList();

    String getCurrentXtabChannel();

    LiveEndPageData getDynamicComponent(boolean r100, EndingPageGuideCardInfo r101);

    List getECLynxBehaviorList();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    String getGeckoVersionsString();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    ConcurrentHashMap<String, String> getGroupPortraits(String r100);

    JSONObject getKVData();

    int getLastHarRangeMostStatus(int r100, boolean r101);

    List<Integer> getLastHarRangeStatus(int r100, boolean r101);

    Map<String, Float> getLastHarResult();

    int getLastHarStatus();

    ILiveFeedParamService getLiveFeedParamService();

    Long getLiveTabInstallTime();

    Long getLiveTabNearbyTime();

    long getMainFragmentCreateTimestamp();

    boolean getMuteStatus();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    String getNativeItem(String r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    String getPortrait(String r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    ConcurrentHashMap<String, String> getPortraits();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    Intent getScanQRIntent(Context r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    ConcurrentHashMap<String, String> getServerPortraits();

    Object getValueForKey(String r100);

    JSONObject getValueForKeys(List<String> r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    Object getVideoFeature(String r100);

    int getVrGyroExperimentValue();

    void gotoAwemeDetailList(String r100, Context r101);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    boolean handleSchema(Context r100, String r101, Bundle r102);

    boolean handleSchemaWithCallback(Context r100, String r101, JSONObject r102, SchemeCallback r103);

    void initJato(Context r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void initLynxEnv();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void initLynxHelium();

    void initSmartOHRServiceHolder();

    void installHook();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    boolean isGranted(Context r100, String... r101);

    boolean isHarServiceEnable();

    boolean isLightMode();

    boolean isLiveInPluginMode();

    boolean isLivePushPreloadInTask(LivePushPreloadParams r100);

    boolean isSideBarPageInMain();

    int mostUsedHand(boolean r100);

    void notifyAppEnterBackgroundFromLive(boolean r100);

    void onPitayaAppLogEvent(String r100, JSONObject r101);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void onVsCollectStateChange(long r100, long r101, boolean r102);

    void openDetailFeed(Context r100, Map<String, String> r101);

    boolean openExternalUrl(Context r100, String r101, Uri r102);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void openFeedBack(String r100, Context r101);

    void openGroupChat(Context r100, String r101, boolean r102, IMOpenGroupChatCallback r103);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void openLiveBrowser(String r100, Bundle r101, Context r102);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void openLiveLynx(String r100, Bundle r101, Context r102);

    void openLiveTakePage(Context r100, OpenLiveTakePageParams r101);

    void openMultiSelectPhotoLibraryForMultiLink(Activity r100, int r101, int r102, int r103, String r104, String r105);

    void openUserProfilePage(String r100, Map<String, String> r101);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void portraitCenterServiceSetup();

    void preloadClass(String r100);

    void putWatermarkInView(LifecycleOwner r100, View r101);

    JSONObject queryBusinessInfo(String r100);

    void redirectToKmp(Context r100, String r101);

    void registerEcAnnieLifeCallback(String r100, b7.a r101);

    void registerHarServiceObserver(HarCallback r100);

    void registerLivePushPreloadTaskListener(LivePushPreloadParams r100, ILivePushPreloadTaskListener r101);

    void registerLynxPhotoSearchResult();

    boolean registerOHRServiceObserver(OHRCallback r100);

    void removeCommonEventListener(List<String> r100);

    boolean removeKeys(List<String> r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void removeLivePortraitChangeListener(IMiddlewareHostAction.ILivePortraitChangeListener r100);

    void removeMuteStatusChangeListener(Object r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void reportLiveBanner(String r100, List<String> r101);

    void requestBlockJitCompile(boolean r100);

    boolean runPackageByBusinessName(String r100, String r101, LiveAiPackageExtraParam r102, LiveAiTaskResultCallback r103);

    List<String> scanQrCode(Bitmap r100, boolean r101, boolean r102, boolean r103);

    Single<List<SimpleMediaInfo>> selectMedia(Activity r100, String r101, int r102, int r103, int r104, String r105, int r106, ArrayList<String> r107, boolean r108);

    void setDebugWebSocketUrl(String r100);

    void setDexImageEnable(boolean r100);

    void setGlobalMuteExternal(boolean r100, boolean r101, String r102);

    boolean setKVData(JSONObject r100);

    boolean setValueForKey(String r100, Object r101);

    void showInnerPush(int r100);

    void showInnerPush(int r100, com.bytedance.android.live.base.model.push.b r101, com.bytedance.android.live.base.model.push.a r102);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void showInvitePanel(Context r100, IRoom r101, String r102, String r103, String r104);

    Boolean showLitePage(Context r100, Uri r101, b7.a r102, Bundle r103);

    void showLiveCommonInnerPush(LivePushInfo r100);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void showLiveCommonInnerPush(com.bytedance.android.live.base.model.push.b r100, com.bytedance.android.live.base.model.push.a r101);

    void showLocationPermissionDialog(Activity r100, FragmentManager r101);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void showStickyToast(Context r100, String r101, int r102);

    void startChat(Context r100, String r101, int r102, IMConversationCallback r103);

    void startDexImageCollect(String r100);

    void startDexImageCollect(String r100, long r101, boolean r102);

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void startLive(Context r100, long r101, Bundle r102);

    void startSmartOHRServiceHolder();

    void stopDexImageCollect(String r100, boolean r101);

    void stopSmartOHRServiceHolder();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void switchToLiveTab(int r100, String r101);

    boolean triggerHarPredict();

    String tryGetValuesForRequest(List<String> r100);

    void unregisterHarServiceObserver();

    void unregisterOHRServiceObserver();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void updateGeckoForAll();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction
    void webViewDownload(Activity r100, WebView r101, String r102, String r103, String r104, String r105, long r106, boolean r107);
}
