package com.bytedance.android.service.manager.push;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceService;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.android.service.manager.push.notification.INotificationMonitorService;
import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface PushExternalService {
    public static final String METHOD_DELETE_PROVIDER = "delete_provider";
    public static final String METHOD_GET_TYPE = "get_type_provider";
    public static final String METHOD_INSERT_PROVIDER = "insert_provider";
    public static final String METHOD_QUERY_PROVIDER = "query_provider";
    public static final String METHOD_UPDATE_PROVIDER = "update_provider";
    public static final String SETTINGS_REQUEST_TYPE_ALLIANCE_SDK = "alliance_sdk";
    public static final String SETTINGS_REQUEST_TYPE_PUSH_SDK = "PushSDK";
    public static final String SIGNAL_SCENE_APP_LAUNCH = "app_launch";
    public static final String SIGNAL_SCENE_DEPTHS = "depths";

    boolean allowStartNonMainProcess();

    String checkAndGetValidChannelId(Context r100, String r101);

    void createDefaultChannel(Context r100);

    boolean curIsWorkerProcess(Context r100);

    IClientFeatureService getClientFeatureService();

    IClientIntelligenceService getClientIntelligenceService();

    String getCurBusinessSysAlertTypeForCustomDialog(Context r100);

    IMultiProcessMonitor getIMultiProcessMonitor();

    IMultiProcessEventSenderService getMultiProcessEventSenderService();

    INotificationMonitorService getNotificationMonitorService();

    IPushSdkMonitorService getPushSdkMonitorService();

    ProcessEnum getWorkerProcess(Context r100);

    boolean isAppNotifyOpen();

    boolean isNewUserLaunch();

    boolean isSupportSystemPushPermissionDialog(Context r100);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void onContentProviderLaunch(String r100, String r101);

    void onNotificationDelete(long r100, JSONObject r101);

    void registerSettingsUpdateListener(ISettingsUpdateListener r100);

    void requestNotificationPermissionBySysDialog(String r100, RequestResultCallback r101);

    void requestSettings(List<String> r100, boolean r101);

    void requestSettingsSynchronous(List<String> r100, boolean r101);

    void showPush(JSONObject r100, int r101, String r102);

    void showPush(JSONObject r100, int r101, String r102, boolean r103);

    void triggerSignalReport(String r100);

    void tryUpdateNoticeState(Context r100);

    void tryUpdateSender();

    void unRegisterSettingsUpdateListener(ISettingsUpdateListener r100);
}
