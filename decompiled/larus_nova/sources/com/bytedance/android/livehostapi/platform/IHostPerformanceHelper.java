package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostPerformanceHelper extends IService {
    void closeAnimDelay();

    void closePeriodAnimDelay(long r100);

    void doSetExtraGraphicBuffer(Context r100, int r101);

    void dropFrameByKita(int r100, Activity r101);

    Map<String, String> getHostSettings();

    void onEnterFullScreenClean();

    void onEnterPlay();

    void onEnterRoom(Map<String, Object> r100);

    void onExitPlay();

    void onLeaveFullScreenClean();

    void onLeaveRoom();

    Boolean onLevelChange(String r100, int r101);

    void onLiveCommonPerformanceDataUpdate();

    void onLiveDegrade(int r100);

    void onLiveFpsPerformanceDataUpdate();

    void openAnimDelay();

    void releaseVideoPlayer();

    void setProperty(String r100, Map<String, Object> r101);
}
