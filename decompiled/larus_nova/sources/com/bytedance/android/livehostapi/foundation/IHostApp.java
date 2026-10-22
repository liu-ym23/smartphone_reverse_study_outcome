package com.bytedance.android.livehostapi.foundation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.depend.feed.IHostAvatarBorderController;
import com.bytedance.android.livehostapi.business.depend.feed.IHostLiveCircleView;
import com.bytedance.android.livehostapi.business.depend.gamecenter.IHostGameCenterService;
import com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTagParams;
import com.bytedance.android.livehostapi.business.depend.openplatform.IHostOpenPlatformGameService;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livehostapi.foundation.depend.ILocalDoActionRequestCallback;
import com.bytedance.android.livehostapi.foundation.depend.IWebViewContainer;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import com.bytedance.android.livehostapi.foundation.depend.OnSwitchAccountListener;
import com.bytedance.android.livehostapi.foundation.depend.SwitchAccountSource;
import io.reactivex.Observable;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostApp extends IMiddlewareHostApp, IHostAppForSaas {
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
    public static final int LIVE_BROADCAST_BROWSE_ACTIVITY_CLASS = 36;
    public static final int LIVE_BROADCAST_GAME_QR_CODE_ACTIVITY_CLASS = 33;
    public static final int LIVE_BROADCAST_MIRROR_ACTIVITY_CLASS = 23;
    public static final int LIVE_BROADCAST_MULTI_PROCESS_MIDDLE_ACTIVITY_CLASS = 38;
    public static final int LIVE_BROADCAST_SELF_ID_CARD_ACTIVITY_CLASS = 41;
    public static final int LIVE_BROADCAST_SELF_RECORD_AUDIO_VIDEO_ACTIVITY_CLASS = 39;
    public static final int LIVE_FAST_OPEN_LIVE_ACTIVITY_CLASS = 24;
    public static final int LIVE_PLAYER_ACTIVITY_CLASS = 25;
    public static final int LIVE_PRO_MAIN_ACTIVITY_CLASS = 40;
    public static final int LIVE_SUB_BROADCAST_ACTIVITY_CLASS = 37;
    public static final int START_LIVE_ACTIVITY_CLASS = 7;
    public static final int VERIFY_ACTIVITY_CLASS = 8;
    public static final int XG_LIVE_FEED_CLASS = 34;
    public static final int XT_MEDIA_BROADCAST_ACTIVITY_CLASS = 20;
    public static final int XT_MEDIA_BROADCAST_BEFORE_ACTIVITY_CLASS = 22;
    public static final int XT_MEDIA_BROADCAST_CONFIG_ACTIVITY_CLASS = 19;

    public @interface ActivityType {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    IHostAvatarBorderController avatarBorderController();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void centerIconToast(Context r100, Map<String, Object> r101);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void centerToast(Context r100, String r101, int r102);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void centerToast(Context r100, String r101, int r102, boolean r103);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void checkAndShowGuide(FragmentActivity r100, String r101, String r102);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void checkBindHelpShow(FragmentActivity r100, String r101);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    IWebViewContainer createHostWebViewHolder(Activity r100);

    void doActionWithToken(String r100, String r101, String r102, JSONObject r103, ILocalDoActionRequestCallback r104);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void enterRecorderActivity(Activity r100);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    List<Activity> getAllActivity();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    List<Class> getAllLiveActivity();

    List<Class> getAllWatchLiveActivity();

    List<Class> getAllWatchLiveActivity(boolean r100);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    String getAudioAccessibilityServiceName();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    String getBgBroadcastServiceName();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Activity getCurrentActivity();

    IHostGameCenterService getGameCenterService();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Class getHostActivity(int r100);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Typeface getHostTypeface(int r100);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Class getLiveActivityClass();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Activity getMainActivity();

    IHostOpenPlatformGameService getOpenPlatformGameService();

    Activity getPreviousActivity();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Observable<String> getRecommendHashTag(LiveHashTagParams r100);

    String getRecordServiceName();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    int getRenderThreadId();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    String getSessionId();

    String getTimingCloseActivityName();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Activity getTopActivity();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Uri getUriForFile(Context r100, File r101);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Boolean isHostPlaying();

    Boolean isHostUnMutePlaying();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void killChildProcess(Context r100);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    IHostLiveCircleView liveCircleView(Context r100);

    void makeShowCustomToast(String r100, int r101, boolean r102);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void openWallet(Activity r100);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void registerLiveLifeCycleListener(IHostAppMonitorListener r100);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    Dialog selectHashTag(Context r100, LiveHashTagParams r101, ILiveHashTagCallback r102);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void sendHostLogEvent(String r100, Bundle r101);

    void setStartLivePageSize2Camera(int r100);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    boolean shouldUseScopedStorage();

    void showSwitchAccount(Activity r100, SwitchAccountSource r101, List<String> r102, OnSwitchAccountListener r103);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void startBindMobileFullFragment(Activity r100, String r101, String r102, OnBindPhoneListener r103);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void startBindPhoneDialogFragment(Activity r100, String r101, String r102, OnBindPhoneListener r103);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void startBindSafeMobileFullFragment(Activity r100, String r101, String r102, Bundle r103, OnBindPhoneListener r104);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    boolean startVideoRecordActivity(Activity r100, String r101);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void systemToast(Context r100, String r101, int r102);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void transCloudControlCommand(JSONObject r100);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    void updateStreamStall(float r100);
}
