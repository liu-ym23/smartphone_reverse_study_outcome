package com.bytedance.android.service.manager.push;

import android.content.Context;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureServiceImplOfMock;
import com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceServiceImplOfMock;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderServiceImplOfMock;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitorImplOfMock;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorServiceImplOfMock;
import com.bytedance.android.service.manager.push.notification.INotificationMonitorService;
import com.bytedance.android.service.manager.push.notification.INotificationMonitorServiceImplOfMock;
import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class PushExternalServiceImplOfMock implements PushExternalService {
    public PushExternalServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean allowStartNonMainProcess() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public String checkAndGetValidChannelId(Context r100, String r101) {
        return "";
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void createDefaultChannel(Context r100) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean curIsWorkerProcess(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public String getCurBusinessSysAlertTypeForCustomDialog(Context r100) {
        return "";
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public ProcessEnum getWorkerProcess(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean isAppNotifyOpen() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean isNewUserLaunch() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean isSupportSystemPushPermissionDialog(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void onContentProviderLaunch(String r100, String r101) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void onNotificationDelete(long r100, JSONObject r101) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void registerSettingsUpdateListener(ISettingsUpdateListener r100) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void requestNotificationPermissionBySysDialog(String r100, RequestResultCallback r101) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void requestSettings(List<String> r100, boolean r101) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void requestSettingsSynchronous(List<String> r100, boolean r101) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void showPush(JSONObject r100, int r101, String r102) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void showPush(JSONObject r100, int r101, String r102, boolean r103) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void triggerSignalReport(String r100) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void tryUpdateNoticeState(Context r100) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void tryUpdateSender() {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void unRegisterSettingsUpdateListener(ISettingsUpdateListener r100) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IClientFeatureService getClientFeatureService() {
        return new IClientFeatureServiceImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IClientIntelligenceService getClientIntelligenceService() {
        return new IClientIntelligenceServiceImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IMultiProcessMonitor getIMultiProcessMonitor() {
        return new IMultiProcessMonitorImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IMultiProcessEventSenderService getMultiProcessEventSenderService() {
        return new IMultiProcessEventSenderServiceImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public INotificationMonitorService getNotificationMonitorService() {
        return new INotificationMonitorServiceImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IPushSdkMonitorService getPushSdkMonitorService() {
        return new IPushSdkMonitorServiceImplOfMock();
    }
}
