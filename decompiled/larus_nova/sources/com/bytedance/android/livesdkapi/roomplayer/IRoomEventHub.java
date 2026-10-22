package com.bytedance.android.livesdkapi.roomplayer;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.bytedance.android.livesdkapi.model.WtnPlayEvent;
import com.bytedance.android.livesdkapi.view.IRenderView;
import java.nio.ByteBuffer;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0007R\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\"0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0007R\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0007R\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0007R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0007R\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0007R\u0018\u00101\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0007R\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0007R&\u00105\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t060\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0007R\u0018\u00108\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0007R\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0007R\u0018\u0010=\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0007R\u0018\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u0007R\u0018\u0010A\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0007R\u0018\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u0007R\u0018\u0010E\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0007R\u0018\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0007R\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0007R\u0018\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0007R\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u0007R\u0018\u0010O\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0007R\u0018\u0010Q\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\u0007R\u0018\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u0007R\u0018\u0010U\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0018\u0010Z\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0007R\u0018\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\u0007R\u0018\u0010_\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b`\u0010\u0007R\u0018\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\u0007R\u0018\u0010c\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bd\u0010\u0007R\u0018\u0010e\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010\u0007R\u0018\u0010g\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u0007R\u0018\u0010i\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u0007R\u0018\u0010k\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u0007R\u0018\u0010m\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bn\u0010\u0007R\u0018\u0010o\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\u0007R\u0018\u0010q\u001a\b\u0012\u0004\u0012\u00020r0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bs\u0010\u0007R\u0018\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bu\u0010\u0007R\u0018\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bw\u0010\u0007R$\u0010x\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005060\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\by\u0010\u0007R\u0018\u0010z\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b{\u0010\u0007R\u0018\u0010|\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b}\u0010\u0007R\u001b\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u007f0\u0004X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0007¨\u0006\u0081\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerVRController$VREvent;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerException$Observers;", "abrSwitch", "Landroidx/lifecycle/MutableLiveData;", "", "getAbrSwitch", "()Landroidx/lifecycle/MutableLiveData;", "afterCdnDisasterToleranceStreamDataString", "", "getAfterCdnDisasterToleranceStreamDataString", "allSurfaceReadyFirstFrameRender", "", "getAllSurfaceReadyFirstFrameRender", "audioRenderStall", "getAudioRenderStall", "audioRenderStallNew", "", "getAudioRenderStallNew", "backgroundHandlerRunning", "getBackgroundHandlerRunning", "backgroundStopIn4G", "getBackgroundStopIn4G", "binarySeiUpdate", "Ljava/nio/ByteBuffer;", "getBinarySeiUpdate", "bindRenderView", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "getBindRenderView", "clientMobileTrafficUsedExceed", "getClientMobileTrafficUsedExceed", "setClientMobileTrafficUsedExceed", "(Landroidx/lifecycle/MutableLiveData;)V", "disableResolutionList", "", "getDisableResolutionList", "extraSurfaceReadyFirstFrameRender", "getExtraSurfaceReadyFirstFrameRender", "firstFrame", "getFirstFrame", "isSeiCropping", "jsonObjectSeiUpdate", "Lcom/bytedance/android/livesdkapi/roomplayer/SeiToJsonObject;", "getJsonObjectSeiUpdate", "lastKeyFrameSei", "getLastKeyFrameSei", "layoutEvent", "Lcom/bytedance/android/livesdkapi/model/LayoutEvent;", "getLayoutEvent", "liveEnd", "getLiveEnd", "mainSurfaceReadyFirstFrameRender", "getMainSurfaceReadyFirstFrameRender", "onNetworkQualityChanged", "Lkotlin/Pair;", "getOnNetworkQualityChanged", "playComplete", "getPlayComplete", "playMonitorLog", "Lorg/json/JSONObject;", "getPlayMonitorLog", "playPrepared", "getPlayPrepared", "playResume", "getPlayResume", "playerBlur", "getPlayerBlur", "playerMediaError", "getPlayerMediaError", "playerMute", "getPlayerMute", "playing", "getPlaying", "playingHandlerRunning", "getPlayingHandlerRunning", "ptsUpdate", "getPtsUpdate", "released", "getReleased", BasicTestActionHandler.TEST_ACTION_RESET, "getReset", "resetSurface", "getResetSurface", "resolutionDegrade", "getResolutionDegrade", "resolutionRemoved", "getResolutionRemoved", "()Z", "setResolutionRemoved", "(Z)V", "roomFinish", "getRoomFinish", "sceneChange", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "getSceneChange", "seiUpdate", "getSeiUpdate", "smoothSwitchResolutionError", "getSmoothSwitchResolutionError", "stallEnd", "getStallEnd", "stallStart", "getStallStart", "startPullStream", "getStartPullStream", "stopped", "getStopped", "surfaceControlChange", "getSurfaceControlChange", "surfaceReady", "getSurfaceReady", "surfaceReadyFirstFrameRender", "getSurfaceReadyFirstFrameRender", "switchResolutionResult", "Lcom/bytedance/android/livesdkapi/roomplayer/SwitchResolutionResult;", "getSwitchResolutionResult", "videoRenderStall", "getVideoRenderStall", "videoRenderStallNew", "getVideoRenderStallNew", "videoSizeChanged", "getVideoSizeChanged", "vrEffectEvent", "getVrEffectEvent", "vrStreamEnable", "getVrStreamEnable", "wtnPlayEvent", "Lcom/bytedance/android/livesdkapi/model/WtnPlayEvent;", "getWtnPlayEvent", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomEventHub extends ILivePlayerVRController.VREvent, ILivePlayerException.Observers {
    MutableLiveData<Integer> getAbrSwitch();

    MutableLiveData<String> getAfterCdnDisasterToleranceStreamDataString();

    MutableLiveData<Boolean> getAllSurfaceReadyFirstFrameRender();

    MutableLiveData<Integer> getAudioRenderStall();

    MutableLiveData<Long> getAudioRenderStallNew();

    MutableLiveData<Boolean> getBackgroundHandlerRunning();

    MutableLiveData<Boolean> getBackgroundStopIn4G();

    MutableLiveData<ByteBuffer> getBinarySeiUpdate();

    MutableLiveData<IRenderView> getBindRenderView();

    MutableLiveData<Boolean> getClientMobileTrafficUsedExceed();

    MutableLiveData<Set<String>> getDisableResolutionList();

    MutableLiveData<Boolean> getExtraSurfaceReadyFirstFrameRender();

    MutableLiveData<Boolean> getFirstFrame();

    MutableLiveData<SeiToJsonObject> getJsonObjectSeiUpdate();

    MutableLiveData<String> getLastKeyFrameSei();

    MutableLiveData<LayoutEvent> getLayoutEvent();

    MutableLiveData<Boolean> getLiveEnd();

    MutableLiveData<Boolean> getMainSurfaceReadyFirstFrameRender();

    MutableLiveData<Pair<Integer, String>> getOnNetworkQualityChanged();

    MutableLiveData<Boolean> getPlayComplete();

    MutableLiveData<JSONObject> getPlayMonitorLog();

    MutableLiveData<Boolean> getPlayPrepared();

    MutableLiveData<Boolean> getPlayResume();

    MutableLiveData<Boolean> getPlayerBlur();

    MutableLiveData<String> getPlayerMediaError();

    MutableLiveData<Boolean> getPlayerMute();

    MutableLiveData<Boolean> getPlaying();

    MutableLiveData<Boolean> getPlayingHandlerRunning();

    MutableLiveData<Long> getPtsUpdate();

    MutableLiveData<Boolean> getReleased();

    MutableLiveData<Boolean> getReset();

    MutableLiveData<Boolean> getResetSurface();

    MutableLiveData<String> getResolutionDegrade();

    boolean getResolutionRemoved();

    MutableLiveData<Boolean> getRoomFinish();

    MutableLiveData<ILivePlayerScene> getSceneChange();

    MutableLiveData<String> getSeiUpdate();

    MutableLiveData<Integer> getSmoothSwitchResolutionError();

    MutableLiveData<Boolean> getStallEnd();

    MutableLiveData<Boolean> getStallStart();

    MutableLiveData<Boolean> getStartPullStream();

    MutableLiveData<Boolean> getStopped();

    MutableLiveData<Boolean> getSurfaceControlChange();

    MutableLiveData<Boolean> getSurfaceReady();

    MutableLiveData<Boolean> getSurfaceReadyFirstFrameRender();

    MutableLiveData<SwitchResolutionResult> getSwitchResolutionResult();

    MutableLiveData<Integer> getVideoRenderStall();

    MutableLiveData<Long> getVideoRenderStallNew();

    MutableLiveData<Pair<Integer, Integer>> getVideoSizeChanged();

    MutableLiveData<String> getVrEffectEvent();

    MutableLiveData<Boolean> getVrStreamEnable();

    MutableLiveData<WtnPlayEvent> getWtnPlayEvent();

    MutableLiveData<Boolean> isSeiCropping();

    void setClientMobileTrafficUsedExceed(MutableLiveData<Boolean> r100);

    void setResolutionRemoved(boolean r100);
}
