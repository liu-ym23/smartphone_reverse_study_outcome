package com.bytedance.android.livehostapi.foundation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.depend.feed.IHostAvatarBorderController;
import com.bytedance.android.livehostapi.business.depend.feed.IHostLiveCircleView;
import com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTagParams;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livehostapi.foundation.depend.ITTNetNQEConfigHelper;
import com.bytedance.android.livehostapi.foundation.depend.IToolsPluginInstallCallback;
import com.bytedance.android.livehostapi.foundation.depend.IWebViewContainer;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import io.reactivex.Observable;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IMiddlewareHostApp extends IService, IBaseHostApp {
    public static final int BROADCAST_PREVIEW_CLASS = 18;
    public static final int BROADCAST_RES_DOWNLOAD_ACTIVITY_CLASS = 17;
    public static final int BROADCAST_SIGNING_CLASS = 9;
    public static final int GAME_PROMOTE_DETAIL_HOST = 35;
    public static final int GIFT_AD_ACTIVITY_CLASS = 1;
    public static final String HOST_EVENT_FLOW_FREE_CLICK = "host_event_flow_free_click";
    public static final String HOST_EVENT_FLOW_FREE_POPUPS = "host_event_flow_free_popups";
    public static final int LIVE_BG_BROADCAST_ACTIVITY_CLASS = 6;
    public static final int LIVE_BILLING_ACTIVITY_CLASS = 21;
    public static final int LIVE_BROADCAST_ACTIVITY_CLASS = 5;
    public static final int LIVE_BROADCAST_BEFORE_ACTIVITY_CLASS = 16;
    public static final int LIVE_BROADCAST_GAME_QR_CODE_ACTIVITY_CLASS = 33;
    public static final int LIVE_BROADCAST_MIRROR_ACTIVITY_CLASS = 23;
    public static final int LIVE_BROADCAST_MULTI_PROCESS_MIDDLE_ACTIVITY_CLASS = 38;
    public static final int LIVE_BROADCAST_SELF_RECORD_AUDIO_VIDEO_ACTIVITY_CLASS = 39;
    public static final int LIVE_FAST_OPEN_LIVE_ACTIVITY_CLASS = 24;
    public static final int LIVE_PLAYER_ACTIVITY_CLASS = 25;
    public static final int LIVE_SUB_BROADCAST_ACTIVITY_CLASS = 37;
    public static final int START_LIVE_ACTIVITY_CLASS = 7;
    public static final int VERIFY_ACTIVITY_CLASS = 8;
    public static final int XG_LIVE_FEED_CLASS = 34;
    public static final int XT_MEDIA_BROADCAST_ACTIVITY_CLASS = 20;
    public static final int XT_MEDIA_BROADCAST_BEFORE_ACTIVITY_CLASS = 22;
    public static final int XT_MEDIA_BROADCAST_CONFIG_ACTIVITY_CLASS = 19;

    public @interface ActivityType {
    }

    IHostAvatarBorderController avatarBorderController();

    void centerIconToast(Context r100, Map<String, Object> r101);

    void centerToast(Context r100, String r101, int r102);

    void centerToast(Context r100, String r101, int r102, boolean r103);

    void checkAndShowGuide(FragmentActivity r100, String r101, String r102);

    void checkBindHelpShow(FragmentActivity r100, String r101);

    IWebViewContainer createHostWebViewHolder(Activity r100);

    void enterRecorderActivity(Activity r100);

    List<Activity> getAllActivity();

    List<Class> getAllLiveActivity();

    long getAppStorageByMB();

    String getAudioAccessibilityServiceName();

    String getBgBroadcastServiceName();

    Activity getCurrentActivity();

    Long getDelayTimeDirect(String r100);

    Class getHostActivity(int r100);

    Typeface getHostTypeface(int r100);

    Class getLiveActivityClass();

    Activity getMainActivity();

    Map<String, String> getNQEParams();

    Observable<String> getRecommendHashTag(LiveHashTagParams r100);

    int getRenderThreadId();

    String getSessionId();

    ITTNetNQEConfigHelper getTTNetNQEConfigHelper();

    Activity getTopActivity();

    long getTotalStorageByMB();

    Uri getUriForFile(Context r100, File r101);

    void installToolsPlugin(Context r100, IToolsPluginInstallCallback r101);

    Boolean isAvatarAnimRunning();

    Boolean isHostPlaying();

    boolean isToolsPluginReady();

    void killChildProcess(Context r100);

    IHostLiveCircleView liveCircleView(Context r100);

    void openWallet(Activity r100);

    void registerLiveLifeCycleListener(IHostAppMonitorListener r100);

    String replaceBrand(int r100);

    String replaceBrand(int r100, HashMap<String, String> r101);

    String replaceBrand(String r100);

    String replaceBrand(String r100, HashMap<String, String> r101);

    Dialog selectHashTag(Context r100, LiveHashTagParams r101, ILiveHashTagCallback r102);

    void sendHostLogEvent(String r100, Bundle r101);

    boolean shouldUseScopedStorage();

    void startBindMobileFullFragment(Activity r100, String r101, String r102, OnBindPhoneListener r103);

    void startBindPhoneDialogFragment(Activity r100, String r101, String r102, OnBindPhoneListener r103);

    void startBindSafeMobileFullFragment(Activity r100, String r101, String r102, Bundle r103, OnBindPhoneListener r104);

    boolean startVideoRecordActivity(Activity r100, String r101);

    void systemToast(Context r100, String r101, int r102);

    void transCloudControlCommand(JSONObject r100);

    void updateStreamStall(float r100);
}
