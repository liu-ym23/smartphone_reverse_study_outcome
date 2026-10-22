package com.byted.mgl.merge.service.api.rtc;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J&\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0014H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0014H&¨\u0006\u001a"}, d2 = {"Lcom/byted/mgl/merge/service/api/rtc/IMglRtcEngine;", "", "adjustPlaybackSignalVolume", "", ITTVideoEngineEventSource.KEY_VOLUME, "adjustRecordingSignalVolume", MapMonitorConst.EVENT_DESTROY, "enableAudioVolumeIndication", VideoThumbInfo.KEY_INTERVAL, "extraEvent", "param", "Lorg/json/JSONObject;", "joinChannel", "token", "", "roomId", "uid", "leaveChannel", "muteAllRemoteAudioStream", ITTVideoEngineEventSource.KEY_MUTE, "", "muteLocalAudioStream", "muteRemoteAudioStream", "setEnableAudio", "enable", "setEnableLocalAudio", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface IMglRtcEngine {
    int adjustPlaybackSignalVolume(int r100);

    int adjustRecordingSignalVolume(int r100);

    int destroy();

    int enableAudioVolumeIndication(int r100);

    int extraEvent(JSONObject r100);

    int joinChannel(String r100, String r101, String r102);

    int leaveChannel();

    int muteAllRemoteAudioStream(boolean r100);

    int muteLocalAudioStream(boolean r100);

    int muteRemoteAudioStream(String r100, boolean r101);

    int setEnableAudio(boolean r100);

    int setEnableLocalAudio(boolean r100);
}
