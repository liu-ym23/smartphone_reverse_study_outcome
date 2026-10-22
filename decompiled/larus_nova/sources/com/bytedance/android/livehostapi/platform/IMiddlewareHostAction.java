package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.platform.base.IBaseHostAction;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bpea.basics.Cert;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IMiddlewareHostAction extends IService, IBaseHostAction {
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

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.IMiddlewareHostAction$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$checkoutNotification(IMiddlewareHostAction r100, Context r101, String r102, String r103, boolean r104, int r105, String r106, sy.a r107) {
        }

        public static String $default$generateSession(IMiddlewareHostAction r100, HashMap r101) {
            return null;
        }

        public static Map $default$getBizComponentFetchers(IMiddlewareHostAction r100) {
            return null;
        }

        public static Uri $default$handleLiveLynxPopupPrefetch(IMiddlewareHostAction r100, Context r101, Uri r102, String r103) {
            return null;
        }

        public static boolean $default$isGranted(IMiddlewareHostAction r100, Context r101, String... r102) {
            return false;
        }

        public static boolean $default$needDowngrade(IMiddlewareHostAction r100, String r101) {
            return false;
        }

        public static void $default$notifyECHalfPageStart(IMiddlewareHostAction r100, Uri r101, View r102, Boolean r103) {
        }

        public static void $default$pauseAllPluginDownload(IMiddlewareHostAction r100, String r101, Map r102) {
        }

        public static void $default$resumeAllPluginDownload(IMiddlewareHostAction r100, String r101, Map r102) {
        }

        public static List $default$createHostDefinedLynxBehavior(IMiddlewareHostAction r100, Context r101, Object r102) {
            return Collections.emptyList();
        }

        public static List $default$ecBehaviorAdd(IMiddlewareHostAction r100, Context r101, String r102) {
            return new LinkedList();
        }
    }

    public interface ILiveAppLogListener {
        void handleAppLogEvent(String r100, JSONObject r101);
    }

    public interface ILiveFeedFeatureProducer {
        JSONObject getDictFeature(String r100, String r101, JSONObject r102);

        Object getFeature(String r100, String r101, JSONObject r102);

        Number getNumericFeature(String r100, String r101, JSONObject r102);

        String getStringFeature(String r100, String r101, JSONObject r102);
    }

    public interface ILiveLogLogicFeatureProvider {
        void onLogEvent(JSONObject r100, long r101);
    }

    public interface ILivePortraitChangeListener {
        boolean attentionKey(String r100);

        void onPortraitChanged(String r100);
    }

    public interface ILiveSequenceItemProvider {
        Object getItemInfo(String r100, String r101, String r102, String r103);
    }

    public interface ILiveSmartClientFeatureProducer {
        JSONObject getFeature(JSONArray r100);

        List<String> producerName();
    }

    public interface IMFansGroupManagerCallback {
        void onBackPressed(Object r100);
    }

    public interface IMFansGroupManagerClickCallback {
        void onLeftTitleClick(Object r100);
    }

    public static abstract class IMPublicGroupCreatePageCallback {
        private Object eventBusSubscriber;

        public IMPublicGroupCreatePageCallback() {
        }

        public abstract void onCreateGroupFailed();

        public abstract void onCreateGroupSuccess();

        public abstract void onCreatePageClose(boolean r100);

        public Object getEventBusSubscriber() {
            return this.eventBusSubscriber;
        }

        public void setEventBusSubscriber(Object r100) {
            this.eventBusSubscriber = r100;
        }
    }

    public interface IShuffleSequenceCallback {
        Map<Object, Object> onGetFeatureSequence(String r100);
    }

    public interface LiveAudioModeChangedListener {
        void onModeChanged(int r100);
    }

    public interface LiveFeatureInterceptor {
        boolean onEnqueue(String r100, int r101, Map<String, Object> r102);

        boolean onSend(String r100, int r101, Map<String, Object> r102, String r103);
    }

    public interface LiveMatrixInviteCallback {
        void onResult(boolean r100);
    }

    public interface LivePTYFeatureProducer {
        JSONObject getDictFeature(String r100, JSONObject r101);

        String getGroupName();

        Float getNumericFeature(String r100, JSONObject r101);

        JSONArray getSeqFeature(String r100, JSONObject r101);

        String getStringFeature(String r100, JSONObject r101);
    }

    public interface PermissionRequestListener {
        void beforeRequest();

        void goToAppSetting(Continuation<Boolean> r100, String[] r101);

        void noNeedToRequest();

        void onPermissionDenied(String[] r100);

        void onPermissionGrant(String[] r100);

        boolean retry(String[] r100);
    }

    public interface SchemeCallback {
        void onCallBack(int r100, JSONObject r101);
    }

    void addAppLogLiveListener(ILiveAppLogListener r100, Set<String> r101);

    Object addAudioModeChangedListener(AudioManager r100, LiveAudioModeChangedListener r101);

    void addLiveFeatureInterceptor(LiveFeatureInterceptor r100);

    void addLivePortraitChangeListener(ILivePortraitChangeListener r100);

    void addLogLogicFeatureProvider(String r100, ILiveLogLogicFeatureProvider r101);

    void addLogLogicFeatureProviders(Map<String, ILiveLogLogicFeatureProvider> r100);

    boolean addSequenceItemProvider(String r100, ILiveSequenceItemProvider r101);

    void addShuffleSequenceProvider(IShuffleSequenceCallback r100);

    void bulletHandleSchema(Context r100, Uri r101);

    boolean canCreatePublicGroup();

    void checkForUpdate();

    void checkoutNotification(Context r100, String r101, String r102, boolean r103, int r104, String r105, sy.a<Boolean> r106);

    void clearGeckoFiles();

    void clearLiveBannerTag(String r100);

    int concatVideo(String[] r100, String r101);

    void configForeNoticeResult(boolean r100);

    void configGroupPortraits(String r100, List<String> r101);

    boolean containsPortraitKey(String r100);

    List createHostDefinedLynxBehavior(Context r100, Object r101);

    Object createRoomParamsProducer(String r100, Object r101);

    void dismissInvitePanel();

    List<Object> ecBehaviorAdd(Context r100, String r101);

    void finishLivePlayActivity();

    String generateSession(HashMap<String, String> r100);

    Map<String, Integer> getAutoEnterCountParams();

    Map<String, Object> getBizComponentFetchers();

    xu1.a getColorWeakModelEffectInfo();

    ConcurrentHashMap<String, String> getCommonClientPortraits();

    ILiveFeedFeatureProducer getFeedFeatureProducer();

    String getGeckoVersionsString();

    ConcurrentHashMap<String, String> getGroupPortraits(String r100);

    int getInstalledVersion(String r100);

    int getInstalledVersionInCurrentProcess(String r100);

    String getLiveDownloadSpeed(String r100);

    JSONObject getLiveFeaturesFromSingleFeatureCenterService();

    String getNativeItem(String r100);

    String getPortrait(String r100);

    ConcurrentHashMap<String, String> getPortraits();

    Intent getScanQRIntent(Context r100);

    ConcurrentHashMap<String, String> getServerPortraits();

    int getTabPosition(String r100);

    Object getVideoFeature(String r100);

    void gotoXtabChannel(String r100, Context r101, Map<String, String> r102);

    void handleEndRoomReasonEvent(xy.a r100);

    void handleFeedKickOut(long r100);

    Uri handleLiveLynxPopupPrefetch(Context r100, Uri r101, String r102);

    boolean handleSchema(Context r100, String r101, Bundle r102);

    void initLynxEnv();

    void initLynxHelium();

    boolean isGranted(Context r100, String... r101);

    boolean isInTimingClosed();

    Boolean isMultiTabAvailable();

    boolean isPersonalRecommendOn();

    void markLocalCommand(Context r100, String r101);

    boolean needDowngrade(String r100);

    void notifyECHalfPageStart(Uri r100, View r101, Boolean r102);

    void onVsCollectStateChange(long r100, long r101, boolean r102);

    void openFansGroupManagePage(Context r100, String r101, boolean r102, float r103, boolean r104);

    void openFeedBack(String r100, Context r101);

    void openLiveBrowser(String r100, Bundle r101, Context r102);

    void openLiveLynx(String r100, Bundle r101, Context r102);

    void pauseAllPluginDownload(String r100, Map<String, String> r101);

    void portraitCenterServiceSetup();

    boolean registerFeatureProducer(LivePTYFeatureProducer r100);

    void registerPublicGroupCreatePageCallback(IMPublicGroupCreatePageCallback r100);

    void registerSmartClientFeatureProducer(ILiveSmartClientFeatureProducer r100);

    void removeAppLogLiveListener(ILiveAppLogListener r100);

    void removeAudioModeChangedListener(AudioManager r100, Object r101);

    void removeLiveFeatureInterceptor(LiveFeatureInterceptor r100);

    void removeLivePortraitChangeListener(ILivePortraitChangeListener r100);

    void removeLogLogicFeatureProvider(String r100);

    void removeSequenceItemProvider(ILiveSequenceItemProvider r100);

    void removeShuffleSequenceProvider(IShuffleSequenceCallback r100);

    void reportLiveBanner(String r100, List<String> r101);

    void requestBlockGc(int r100);

    void requestBlockJitGc(boolean r100);

    void requestPermissions(Activity r100, PermissionRequestListener r101, Cert r102, String... r103);

    void resumeAllPluginDownload(String r100, Map<String, String> r101);

    void searchIMFriend(String r100, List<IBaseUser> r101);

    void sendLiveMatrixInvitation(String r100, String r101, String r102, LiveMatrixInviteCallback r103);

    void setJatoConfig(int r100, int r101, long r102);

    void showInvitePanel(Context r100, IRoom r101, String r102, String r103, String r104);

    void showLiveCommonInnerPush(com.bytedance.android.live.base.model.push.b r100, com.bytedance.android.live.base.model.push.a r101);

    void showStickyToast(Context r100, String r101, int r102);

    void startBlockGc(String r100);

    DialogFragment startGroupManagerFragment(String r100, String r101, IMFansGroupManagerCallback r102, IMFansGroupManagerClickCallback r103);

    void startLive(Context r100, long r101, Bundle r102);

    void startVBoost(int r100, int r101);

    void stopBlockGc(String r100);

    void switchToLiveTab(int r100, String r101);

    void unregisterFeatureProducer();

    void unregisterPublicGroupCreatePageCallback(IMPublicGroupCreatePageCallback r100);

    void updateGeckoForAll();

    void webViewDownload(Activity r100, WebView r101, String r102, String r103, String r104, String r105, long r106, boolean r107);
}
