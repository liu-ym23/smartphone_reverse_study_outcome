package com.bytedance.android.live.player.api;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.model.ExecuteCommandConfig;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.roomplayer.SrControl;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\tH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\"\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\tH&J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0017H&J/\u0010 \u001a\u00020\t2%\b\u0002\u0010!\u001a\u001f\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\t\u0018\u00010\"H&J\b\u0010'\u001a\u00020\tH&J\b\u0010(\u001a\u00020\tH&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020\tH&J\b\u0010/\u001a\u00020\tH&J\u0010\u00100\u001a\u00020\t2\u0006\u00101\u001a\u000202H&J\u0018\u00100\u001a\u00020\t2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0017H&J\u0010\u00104\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0010\u00105\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0010\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u0003H&J\u0010\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0003H&J\u0012\u0010:\u001a\u00020\t2\b\b\u0002\u0010;\u001a\u00020\u0003H&J\u0010\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\fH&J\u0010\u0010>\u001a\u00020\t2\u0006\u0010=\u001a\u00020\fH&J\u0010\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u0019H&J(\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\u00172\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\"H&J\"\u0010D\u001a\u00020\t2\u0006\u00103\u001a\u00020\u00172\u0006\u0010E\u001a\u0002022\b\b\u0002\u0010F\u001a\u00020\u0003H&J\b\u0010G\u001a\u00020HH&J\b\u0010I\u001a\u00020\tH&J7\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020+2%\b\u0002\u0010!\u001a\u001f\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\t\u0018\u00010\"H&J\u0010\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0017H&J.\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00172\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010PH&J\u0010\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u0017H&J5\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u00172#\u0010S\u001a\u001f\u0012\u0013\u0012\u00110+¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\t\u0018\u00010\"H&J\b\u0010T\u001a\u00020\tH&J\b\u0010U\u001a\u00020\tH&J\u0010\u0010U\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0017H&J:\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\f2\u0006\u0010Z\u001a\u0002022\b\u0010[\u001a\u0004\u0018\u00010\u00172\u0006\u0010\\\u001a\u00020\u0003H&J\u0010\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\u0003H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006_"}, d2 = {"Lcom/bytedance/android/live/player/api/ILivePlayerControl;", "", "stopBarrier", "", "getStopBarrier", "()Z", "setStopBarrier", "(Z)V", "blur", "", "canShare", "curPlayerVolume", "", "disableShare", "disableVideoRender", "dynamicOpenTextureRender", "enableRTMPauseUseStop", "enable", "executeCommand", "executeCommandConfig", "Lcom/bytedance/android/livesdkapi/model/ExecuteCommandConfig;", "handleControlMessage", "controlMessage", "", "roomId", "", "streamId", "isMute", "isSharpenUsed", "isSrUsed", ITTVideoEngineEventSource.KEY_MUTE, "callStack", "notifyEventForSharePlayer", "eventListener", "Lkotlin/Function1;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/ParameterName;", "name", "lifecycleOwner", "pause", "prePlaySwitchRes", "prePrepare", "liveRequest", "Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "release", "releaseSync", "resetLastSwitchResolutionOperation", "resume", "seekBy", "shift", "", "resolution", "setDsharpen", "setDsr", "setEnablePtsRollback", "enabled", "setIsPrePlay", "isPrePlay", "setLiveRoomState", "isIn", "setPlayerVolume", ITTVideoEngineEventSource.KEY_VOLUME, "setPlayerVolumeWithAnim", "setProcessAudioAddr", "audioAddr", "setPullControlMessageInfo", "controlMsg", "callback", "smoothSwitchResolution", "switchReason", "fallback", "srControl", "Lcom/bytedance/android/livesdkapi/roomplayer/SrControl;", "stop", "stream", "request", "switchResolution", "resolutionKey", "reason", "extra", "", "switchStreamData", "streamData", "updateRequest", "unblur", "unmute", "unmuteWithFade", "fade", "minVolume", "maxVolume", "duration", "interpolatorName", "useCurVolume", "updateVideoStreamTransmissionStateIfPossible", "transmissionEnabled", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerControl {
    void blur();

    boolean canShare();

    float curPlayerVolume();

    void disableShare();

    void disableVideoRender(boolean r100);

    void dynamicOpenTextureRender();

    void enableRTMPauseUseStop(boolean r100);

    void executeCommand(ExecuteCommandConfig r100);

    boolean getStopBarrier();

    void handleControlMessage(String r100, long r101, long r102);

    boolean isMute();

    boolean isSharpenUsed();

    boolean isSrUsed();

    void mute();

    void mute(String r100);

    void notifyEventForSharePlayer(Function1<? super LifecycleOwner, Unit> r100);

    void pause();

    void prePlaySwitchRes();

    boolean prePrepare(LiveRequest r100);

    boolean release();

    boolean releaseSync();

    void resetLastSwitchResolutionOperation();

    void resume();

    void seekBy(int r100);

    void seekBy(int r100, String r101);

    void setDsharpen(boolean r100);

    void setDsr(boolean r100);

    void setEnablePtsRollback(boolean r100);

    void setIsPrePlay(boolean r100);

    void setLiveRoomState(boolean r100);

    void setPlayerVolume(float r100);

    void setPlayerVolumeWithAnim(float r100);

    void setProcessAudioAddr(long r100);

    void setPullControlMessageInfo(String r100, Function1<? super Boolean, Unit> r101);

    void setStopBarrier(boolean r100);

    void smoothSwitchResolution(String r100, int r101, boolean r102);

    SrControl srControl();

    void stop();

    void stream(LiveRequest r100, Function1<? super LifecycleOwner, Unit> r101);

    void switchResolution(String r100);

    void switchResolution(String r100, String r101, Map<String, String> r102);

    void switchStreamData(String r100);

    void switchStreamData(String r100, Function1<? super LiveRequest, Unit> r101);

    void unblur();

    void unmute();

    void unmute(String r100);

    void unmuteWithFade(boolean r100, float r101, float r102, int r103, String r104, boolean r105);

    void updateVideoStreamTransmissionStateIfPossible(boolean r100);
}
