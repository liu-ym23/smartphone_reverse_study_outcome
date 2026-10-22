package com.bytedance.android.livehostapi.business;

import ae1.c;
import ae1.d;
import ae1.e;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.moreliveentrance.LiveTabForceRefreshStyle;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.jsbridge.base.CheckDesktopGuideCanShowResultModel;
import com.bytedance.android.live.browser.jsbridge.base.UgRequestShowDesktopGuideResultModel;
import com.bytedance.android.livehostapi.business.depend.DialogListener;
import com.bytedance.android.livehostapi.business.depend.IGenCodeShareCallback;
import com.bytedance.android.livehostapi.business.depend.IImageTemplateApplyCallback;
import com.bytedance.android.livehostapi.business.depend.ILiveAntiAddictionListener;
import com.bytedance.android.livehostapi.business.depend.ILiveEnterFeedVoipCallback;
import com.bytedance.android.livehostapi.business.depend.ILiveRoomFragmentAdDelegate;
import com.bytedance.android.livehostapi.business.depend.IShareMsgCallback;
import com.bytedance.android.livehostapi.business.depend.ISharePanelStateListener;
import com.bytedance.android.livehostapi.business.depend.IShowDialogParam;
import com.bytedance.android.livehostapi.business.depend.IShowPoiSearchCallback;
import com.bytedance.android.livehostapi.business.depend.IUserAgreePrivacyPolicyListener;
import com.bytedance.android.livehostapi.business.depend.LiveStickerFilterListener;
import com.bytedance.android.livehostapi.business.depend.OnPixelLoopStickerPresentListener;
import com.bytedance.android.livehostapi.business.depend.OnStickerViewListener;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsService;
import com.bytedance.android.livehostapi.business.depend.floatwindow.FloatWindowContext;
import com.bytedance.android.livehostapi.business.depend.floatwindow.IFloatWindowPermissionCallback;
import com.bytedance.android.livehostapi.business.depend.follow.ILiveFeedCacheHelper;
import com.bytedance.android.livehostapi.business.depend.largefont.IHostLargeFontService;
import com.bytedance.android.livehostapi.business.depend.rerank.ILiveReRankService;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.multitask.IIndependentTaskManager;
import com.bytedance.android.livehostapi.business.smartclient.ILiveSmartClientManager;
import com.bytedance.android.livehostapi.platform.depend.im.IHostIMService;
import com.bytedance.android.livehostapi.platform.depend.im.ILiveIMCusSerMsgProxy;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.game_ws.ILiveWsClient;
import com.bytedance.android.livesdkapi.game_ws.ILiveWsListener;
import com.bytedance.android.livesdkapi.listener.ILoginOrLogoutListener;
import com.bytedance.android.livesdkapi.listener.ITeenModeStatusListener;
import com.bytedance.android.livesdkapi.model.SettingsExtraInfo;
import com.bytedance.bpea.basics.Cert;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jz.a;
import jz.b;
import jz.f;
import jz.g;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import w20.b8;
import w20.jf;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostBusiness extends IMiddlewareHostBusiness, IHostBusinessForSaas {
    public static final int LIVE_VIDEO_PLAY_USER_TYPE_ANCHOR = 1;
    public static final int LIVE_VIDEO_PLAY_USER_TYPE_GUEST = 2;
    public static final int LIVE_VIDEO_PLAY_USER_TYPE_NORMAL = 3;

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostBusiness$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$monitorPluginInvoke(IHostBusiness r100, String r101) {
        }

        public static void $default$showPaySuccessGuide(IHostBusiness r100, Activity r101, Fragment r102, boolean r103) {
        }
    }

    public interface IFeedShareServiceForLive {
        int getFeedShareIconPosition(Room r100);

        void openFeedShare(Context r100, String r101, long r102, Boolean r103, ILiveEnterFeedVoipCallback r104);
    }

    void addAnchorToPublishVideo(JsonObject r100);

    void addPanelThreeDesktop(String r100, String r101, String r102, String r103, String r104);

    @Override // com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void addStickersWithModel(AppCompatActivity r100, Sticker r101, FrameLayout r102, boolean r103, boolean r104);

    void addTopicToPublish(JsonObject r100);

    void addUgDesktopListener(String r100, String r101, Function0<Unit> r102, Function0<Unit> r103, Function0<Unit> r104);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    void applyImageTemplateToLocal(String r100, String r101, Map<String, String> r102, IImageTemplateApplyCallback r103);

    void aquireCellularUISwitch();

    void broadcastPerfDowngrade(boolean r100);

    int cachedViewCount(String r100, int r101, Context r102);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    void callRemoveRoom(String r100);

    void canShowDesktopGuide(String r100, String r101, String r102, String r103, String r104, Function2<Boolean, String, Unit> r105);

    void changeAntiAddictionStatus(Boolean r100, Boolean r101);

    void checkAndPreCreateViewAtOnce(int r100, String r101, int r102, Context r103, int r104, LayoutInflater r105);

    boolean checkIfAppWidgetInstalled(String r100);

    @Override // com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void checkImportVideo(Context r100, f r101, a r102);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    boolean checkLynxPlugin();

    Boolean checkPadSplitEnterRoomRepeat(int r100);

    Boolean checkStartInAvCallFloatWindow();

    Boolean checkWatchInAvCallFloatWindow();

    void clearPreloadViews(String r100, Context r101);

    void commitLiveLayouts(int r100, Activity r101, String r102, LifecycleOwner r103, LayoutInflater r104);

    void commitPreloadLiveLayoutsWithoutActivity(int r100, String r101, int r102, Context r103, int r104, LayoutInflater r105);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    int concatVideo(String[] r100, String r101);

    @Override // com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    ILiveWsClient connectWebsocket(Context r100, String r101, ILiveWsListener r102);

    ILiveWsClient connectWebsocket(Context r100, String r101, ILiveWsListener r102, Long r103);

    String createJumpSourceBtmToken(String r100);

    ae1.a createLiveV2UserMask(Context r100, LifecycleOwner r101, e r102, Object r103);

    byte[] decompressWithZstd(byte[] r100, byte[] r101) throws IOException;

    void ecOpenSchema(Context r100, String r101, Bundle r102);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    void enterLiveChannel(Context r100, Map<String, String> r101, String r102, Bundle r103, boolean r104, boolean r105, LiveTabForceRefreshStyle r106);

    void fetchLivePkFansGroupList();

    void finishAllActivities();

    boolean finishVideoRecordPage(Activity r100);

    void forceStopLiveMixRoom();

    IAssignUiModeDelegate getAssignUiModeDelegate(AppCompatActivity r100, int r101, int r102);

    String getBcmChainInfo();

    com.bytedance.ies.web.jsbridge2.f<b8, CheckDesktopGuideCanShowResultModel> getCanShowMethod();

    Observable<List<Sticker>> getCategoryStickerList(String r100);

    String getCurrentBcmChain();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    String getCurrentUserAddress(Object r100, String r101, int r102);

    String getDesktopParams();

    IFeedShareServiceForLive getFeedShareServiceForLive();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    void getFollowStatusFromIMDB(String r100, String r101, String r102, Function1<Pair<Integer, Integer>, Void> r103);

    IHostIMService getHostIMService();

    @Override // com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    Object getHostSettings(String r100, Object r101, SettingsExtraInfo r102);

    IIndependentTaskManager getIndependentTaskManager();

    ILiveFeedCacheHelper getLiveFeedCacheHelper();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    IHostLargeFontService getLiveLargeFontService();

    ul2.a getLiveMinimizeService();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    String getLivePoiId();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    String getLivePoiName();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView getLivePureVideoPlayerView(Context r100, int r101, int r102, long r103);

    ILiveRecommendToFriendsService getLiveRecommendToFiendsService();

    ILiveRoomFragmentAdDelegate getLiveRoomFragmentAdDelegate();

    ILiveSmartClientManager getLiveSmartClientManager();

    String getNeedPersonalRecommend();

    Room getNextFeedRoom();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    DialogFragment getPoiSearchModalDialog(Context r100, gz.a r101, IShowPoiSearchCallback r102);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    boolean getPreviewAnswerClickEnable();

    ILiveReRankService getReRankWebcastService();

    d getReminderStyle(c r100);

    com.bytedance.ies.web.jsbridge2.f<jf, UgRequestShowDesktopGuideResultModel> getRequestShowMethod();

    boolean getSceneNetPredict();

    Observable<List<String>> getStickerCategoryList();

    boolean getTabliveUnbindLiveInitOpt();

    boolean hasFloatWindowPermission();

    boolean hasLiveAppWidgetAdded(Context r100);

    boolean hasLiveHistoryPermission();

    boolean hasPadContinus();

    boolean hasPadDevice();

    boolean hasPermissionLimite();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void hideStickerView();

    boolean ignoreECWidgetFrequency();

    void initLiveModuleIfNeeded(AppCompatActivity r100, String r101);

    boolean isAppInGuestMode();

    boolean isDeepCleanDowngrade();

    boolean isDouyinPreInstall();

    boolean isEnableShowTeenageTip();

    boolean isFollowWidgetInstalledFromOtherApp(Function1<Boolean, Unit> r100);

    boolean isHitStickerRefactorExperiment();

    Boolean isHostScreenCaptureEnable();

    boolean isHotsoonR();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    boolean isLivePushOpen();

    boolean isSearchScreenshotBubbleMobOpen();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    boolean isShowStickerView();

    boolean isUserMaskV2Style(int r100);

    void loadLiveCachePool(boolean r100);

    DialogFragment loadLiveSharePanel(Context r100, ShareParams r101, Boolean r102, Boolean r103, int r104, ISharePanelStateListener r105);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    void loadLynxSoLib(View r100);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void loadTemplate(String r100, IMiddlewareHostBusiness.TemplateCallback r101);

    void markRemindEventShown(c r100, d r101);

    void monitorPluginInvoke(String r100);

    void notifyNewRoomFragment(int r100);

    Room obtainOneCachedLive();

    void onDislikeRoom(long r100);

    void onIMLiveRoomStatusChange(String r100, int r101);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    void onNetworkQualityChanged(int r100, String r101);

    void onUpdateHostIMProxy(ILiveIMCusSerMsgProxy r100);

    void openDefaultPermissionGuideDialog(Context r100, String r101);

    void openHostFansList(User r100);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void openLiveCommonVerifyActivity(Context r100, Intent r101);

    void openLiveStickerRecordPage(Context r100, Long r101, String r102, String r103);

    void openMultiSearchPage(Context r100, ez.a r101);

    void openNotifyEditPage(Activity r100, String r101, az.a r102);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    void openSoloKtvSharePanel(Activity r100, Bundle r101);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void openVideoDetailPage(String r100, String r101);

    void postDeleteReportRoomEvent(String r100);

    boolean preEnterRoomCheck(Context r100, long r101, Bundle r102);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    void preloadTemplateResource(String r100);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void publishVideo(Context r100, f r101, b r102);

    void pushAnnouncementCard(Context r100, ShareParams r101, ArrayList<GroupInfoStruct> r102, String r103);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    Disposable queryBatchAweme(List<Long> r100, IMiddlewareHostBusiness.AwemeQueryCallBack r101);

    void quickPublishVideo(Context r100, g r101, jz.c r102);

    void quickSaveVideoDraft(Context r100, g r101, b r102);

    void registerAntiAddictionObserver(LifecycleOwner r100, ILiveAntiAddictionListener r101);

    void registerBtmPage(Class<?> r100, String r101);

    void registerLoginOrLogoutListener(ILoginOrLogoutListener r100);

    void registerPushPermissionGuideTrigger(Fragment r100);

    void registerScreenCaptureCallback(LifecycleOwner r100, com.bytedance.android.livesdk.live.d r101);

    void registerTeenModeStatusListener(ITeenModeStatusListener r100);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void releaseStickerView();

    void removePrivacyAgreeListener(IUserAgreePrivacyPolicyListener r100);

    void removeStickerFilter(LiveStickerFilterListener r100);

    void reportAntiAddictionStayTime(Long r100, String r101, int r102, d r103);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void requestForShoppingAccess(Context r100, String r101);

    Observable<HashMap<String, Object>> requestMultiSearchPageData(Context r100, Map<String, String> r101);

    void requestPinWidget(Context r100, String r101);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void resetPoiMemoryPoiDetailData();

    void saveSmoothCover(long r100, List<String> r101);

    void sendBackRoomCardEvent(boolean r100, com.bytedance.android.live.base.f r101, boolean r102);

    void sendExitGuideButtonEvent(boolean r100);

    void sendExitGuideSimilarEvent(boolean r100);

    void setBcmPageParams(View r100, Map<String, String> r101);

    void setBcmParams(View r100, String r101, Long r102);

    void setOnStickerGameStateChangeListener(OnStickerGameStateChangeListener r100);

    void setPixelLoopDataAndUpdateUI(List<Pair<String, Boolean>> r100, int r101);

    void setPixelLoopLiveStickerPresenterProcessor(OnPixelLoopStickerPresentListener r100);

    void setSearchScrollPagingEnabled(Activity r100, boolean r101);

    void setStickerFilter(LiveStickerFilterListener r100);

    @Override // com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void setStickerMobHelper(ILiveStickerMobHelper r100);

    void setVideoReshootClearListener(Context r100, jz.e r101);

    void shareGenCode(Context r100, ShareParams r101, IGenCodeShareCallback r102);

    void shareInviteMsg(Context r100, ShareParams r101, List<com.bytedance.android.live.base.model.user.f> r102, IShareMsgCallback r103);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    Dialog showDialog(Context r100, CharSequence r101, CharSequence r102, CharSequence r103, DialogListener r104, CharSequence r105, DialogListener r106, IShowDialogParam r107);

    void showLiveDisLikePopView(Room r100, Context r101, String r102, String r103, String r104, Long r105, Long r106, String r107);

    boolean showLongPressPanel(Context r100, dz.b r101, Room r102);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void showManagePoiDialog(Context r100, boolean r101, long r102, DialogInterface.OnDismissListener r103);

    void showPaySuccessGuide(Activity r100, Fragment r101, boolean r102);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void showPoiInfoDialogForAudience(Context r100, String r101, String r102, String r103);

    DialogFragment showRewardDetainmentDialog(Activity r100, String r101, HashMap<String, String> r102, Runnable r103);

    @Override // com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void showStickerView(AppCompatActivity r100, FragmentManager r101, String r102, FrameLayout r103, OnStickerViewListener r104);

    @Override // com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void showToutiaoFloatWindow(FloatWindowContext r100, IFloatWindowPermissionCallback r101);

    void showUgLeaveDialog(String r100, String r101, String r102, String r103, String r104, String r105);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    DialogFragment showVsTopicDialog(Activity r100, String r101, int r102, boolean r103, int r104, IMiddlewareHostBusiness.HashTagCallback r105);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void startLightPublishActivity(Context r100, Intent r101, IMiddlewareHostBusiness.onLightLivePublishCallback r102);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    void startLivePublishActivity(Context r100, Intent r101, IMiddlewareHostBusiness.onLivePublishCallback r102);

    Pair<Disposable, Observable<Map<String, Object>>> startScanPadDevice();

    void tryAddLiveAppWidget(Context r100, boolean r101);

    void tryAddLiveAppWidget(Context r100, boolean r101, String r102);

    View tryGetLiveLayouts(int r100, Activity r101, String r102, ViewGroup r103, Boolean r104, LayoutInflater r105);

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    boolean tryOpenAdByOpenUrl(Context r100, long r101, String r102, String r103);

    void tryToLocate(Cert r100);

    void unregisterPushPermissionGuideTrigger();

    void updateAppWidget(Context r100, String r101);

    void updateLivePushOpen();

    void uploadAlogInternal(long r100, long r101, String r102);

    boolean usingVideoRecordFragment();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness, com.bytedance.android.livehostapi.business.IHostBusinessForSaas
    boolean videoIsPublishable();
}
