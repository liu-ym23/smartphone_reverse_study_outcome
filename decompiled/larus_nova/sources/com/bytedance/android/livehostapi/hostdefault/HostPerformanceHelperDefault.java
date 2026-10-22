package com.bytedance.android.livehostapi.hostdefault;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.livehostapi.platform.IHostPerformanceHelper;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HostPerformanceHelperDefault implements IHostPerformanceHelper {
    public HostPerformanceHelperDefault() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void closeAnimDelay() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void closePeriodAnimDelay(long r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void doSetExtraGraphicBuffer(Context r100, int r101) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void dropFrameByKita(int r100, Activity r101) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void onEnterFullScreenClean() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void onEnterPlay() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void onEnterRoom(Map<String, Object> r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void onExitPlay() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void onLeaveFullScreenClean() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void onLeaveRoom() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void onLiveCommonPerformanceDataUpdate() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void onLiveDegrade(int r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void onLiveFpsPerformanceDataUpdate() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void openAnimDelay() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void releaseVideoPlayer() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public void setProperty(String r100, Map<String, Object> r101) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceHelper
    public Boolean onLevelChange(String r100, int r101) {
        return Boolean.FALSE;
    }
}
