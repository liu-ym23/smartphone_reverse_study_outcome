package com.bytedance.android.livesdkapi.multicamera;

import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J1\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0010H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0010H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0010H&J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\u0003H&¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/multicamera/IMultiCameraLiveRtcManager;", "", "deleteAllDevice", "", "getCameraViewByRtcId", "Landroid/view/View;", "rtcUid", "", "getCurrentViewId", "getLocalRtcUid", "getMainDeviceViewId", "", "()Ljava/lang/Long;", "insertCameraView", "view", "isEngineOn", "", "isLocalDevice", "isShowingView", "joinRtcRoom", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "rtcExtraInfo", "viewId", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "localAudioMuteStatus", "muteLocalAudio", "muted", "muteLocalVideo", "setCurrentViewId", "setRtcListener", "listener", "Lcom/bytedance/android/livesdkapi/multicamera/IRtcMessageListener;", "stopAndRelease", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMultiCameraLiveRtcManager {
    void deleteAllDevice();

    View getCameraViewByRtcId(String r100);

    String getCurrentViewId();

    String getLocalRtcUid();

    Long getMainDeviceViewId();

    void insertCameraView(String r100, View r101);

    boolean isEngineOn();

    boolean isLocalDevice(String r100);

    boolean isShowingView(String r100);

    void joinRtcRoom(DataCenter r100, String r101, String r102, Long r103);

    boolean localAudioMuteStatus();

    void muteLocalAudio(boolean r100);

    void muteLocalVideo(boolean r100);

    void setCurrentViewId(String r100);

    void setRtcListener(IRtcMessageListener r100);

    void stopAndRelease();
}
