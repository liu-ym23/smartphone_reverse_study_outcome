package com.byted.mgl.merge.service.api.rtc;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H&J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H&J\u001a\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u001a\u0010\u001d\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fH&J\u001a\u0010 \u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fH&J\u001a\u0010!\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J\u001a\u0010\"\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u001fH&J\u001a\u0010$\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u0007H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0007H&¨\u0006("}, d2 = {"Lcom/byted/mgl/merge/service/api/rtc/IMglRtcEventHandler;", "", "onAudioVolumeIndication", "", "uid", "", ITTVideoEngineEventSource.KEY_VOLUME, "", "speakerNumber", "onConnectionInterrupted", "onConnectionLost", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "onExtraEvent", "param", "Lorg/json/JSONObject;", "onFirstLocalAudioFrame", "elapsed", "onFirstRemoteAudioFrame", "onJoinChannelSuccess", "onLeaveChannel", "onLogReport", FrescoMonitorConst.LOG_TYPE, "log_content", "onNetworkQuality", "txQuality", "rxQuality", "onRejoinChannelSuccess", "onStreamPublishSucceed", "onUserEnableAudio", "enabled", "", "onUserEnableLocalAudio", "onUserJoined", "onUserMuteAudio", "muted", "onUserOffline", "reason", "onWarning", "warn", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface IMglRtcEventHandler {
    void onAudioVolumeIndication(String r100, int r101, int r102);

    void onConnectionInterrupted();

    void onConnectionLost();

    void onError(int r100);

    void onExtraEvent(JSONObject r100);

    void onFirstLocalAudioFrame(int r100);

    void onFirstRemoteAudioFrame(String r100, int r101);

    void onJoinChannelSuccess(String r100, int r101);

    void onLeaveChannel();

    void onLogReport(String r100, String r101);

    void onNetworkQuality(String r100, int r101, int r102);

    void onRejoinChannelSuccess(String r100, int r101);

    void onStreamPublishSucceed();

    void onUserEnableAudio(String r100, boolean r101);

    void onUserEnableLocalAudio(String r100, boolean r101);

    void onUserJoined(String r100, int r101);

    void onUserMuteAudio(String r100, boolean r101);

    void onUserOffline(String r100, int r101);

    void onWarning(int r100);
}
