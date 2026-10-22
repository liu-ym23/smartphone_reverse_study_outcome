package com.bytedance.android.service.manager.push.monitor;

import android.content.Context;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class IPushSdkMonitorServiceImplOfMock implements IPushSdkMonitorService {
    public IPushSdkMonitorServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public boolean curIsDau() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public boolean curIsTransmit() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void initOnApplication(Context r100) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onActivityDepthsDeviceStatus(JSONObject r100) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onActivityStartResult(boolean r100, int r101, String r102, String r103, String r104, long r105, String r106) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onActivityStartReturnValue(String r100, JSONObject r101, int r102) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onBadgeOperateFailed(int r100, Integer r101, String r102) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onBadgeOperateSuccess(int r100, Integer r101) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onContentRequest(String r100, int r101, int r102) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onContentShow(String r100, String r101, int r102) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onInvalidMrDepths(Context r100, List<String> r101) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onKeepAliveFrom(String r100, String r101, int r102) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onLaunchEvent(boolean r100, boolean r101, long r102, long r103, int r104, int r105, String r106) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onMessageArrive(long r100) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onMessageShow(long r100, long r101) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onProcessStartEvent(boolean r100, boolean r101, long r102, long r103, int r104, int r105, String r106, boolean r110) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onProfileIdOperateResult(int r100, int r101, int r102, long r103, String r104) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService, z67.b
    public void onRequestFailed(String r100, String r101, String r102, String r103, long r104) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService, z67.b
    public void onRequestFailed(String r100, String r101, String r102, String r103, long r104, JSONObject r105) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService, z67.b
    public void onRequestSuccess(String r100, String r101, String r102, long r103) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService, z67.b
    public void onRequestSuccess(String r100, String r101, String r102, long r103, JSONObject r104) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onTokenRetry(int r100, String r101) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onTokenRetryResult(int r100, boolean r101, String r102) {
    }

    @Override // com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService
    public void onTransmitStrategyRequest() {
    }
}
