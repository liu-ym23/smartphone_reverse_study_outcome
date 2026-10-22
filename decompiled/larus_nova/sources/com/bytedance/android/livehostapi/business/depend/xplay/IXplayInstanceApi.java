package com.bytedance.android.livehostapi.business.depend.xplay;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\tH&J\u001a\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u0014\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020\u000eH&J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0018H&J\b\u0010'\u001a\u00020\u000eH&J\b\u0010(\u001a\u00020\u000eH&J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0018H&J\b\u0010*\u001a\u00020\u000eH&J\u001c\u0010+\u001a\u00020\u000e2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020.0-H&J\u001e\u0010/\u001a\u00020\u000e2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010.0-H&J\b\u00100\u001a\u00020\u000eH&J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0018H&J0\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u0002042\u0006\u00108\u001a\u000204H&J2\u00109\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;H&J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020?H&J*\u0010@\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;2\b\b\u0002\u0010\u0019\u001a\u00020\tH&J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\tH&J\u0010\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020EH&J\b\u0010F\u001a\u00020\u000eH&J\b\u0010G\u001a\u00020\u000eH&J\b\u0010H\u001a\u00020\u000eH&J\u0010\u0010I\u001a\u0002042\u0006\u0010J\u001a\u000204H&J\b\u0010K\u001a\u00020\u000eH&J\u0010\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\tH&J\u0010\u0010N\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\tH&J\u0010\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006QÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayInstanceApi;", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayMessageInterface;", "gameGuideView", "Landroid/view/View;", "getGameGuideView", "()Landroid/view/View;", "gameView", "getGameView", "isGuidePlaying", "", "()Z", "isInitialized", "isPlaying", "addCallback", "", "callback", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayInstanceCallback;", "attachContext", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "disableGestureRecognizer", "disable", "enableAudio", "playerName", "", "enable", "getAllCloudPlayerRtcInfo", "", "Lcom/bytedance/android/livehostapi/business/depend/xplay/CloudPlayerRtcInfo;", "getCloudGameState", "Lcom/bytedance/android/livehostapi/business/depend/xplay/CloudGameState;", "getTargetPlayerRtcInfo", "getTargetView", "name", "initGame", "startParams", "Lcom/bytedance/android/livehostapi/business/depend/xplay/XplayStartParams;", "pauseGame", "pauseTarget", "playGame", "playGuideGame", "playTarget", "preloadScene", "publishVideoStreamAndSetConfig", "configMap", "", "", "pushExternalVideoFrame", "resumeGame", "resumeTarget", "sendStreamingParameter", "width", "", "height", "frameRate", "maxKbps", "minKbps", "setTargetPlayerVideoExternalConfig", "sharpness", "", "contrast", "brightness", "setVideoCaptureListener", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayCGVideoCaptureListener;", "setVideoExternalConfig", "showKeyboard", "autoDismiss", "startMixStream", "configObject", "Lorg/json/JSONObject;", "stopGame", "stopGuideGame", "stopMixStream", "switchRemoteSimulcastStreamType", "videoSimulcastListIndex", "unPublishVideoStream", "updateEnableAudioFrame", "enableAudioFrame", "updateEnableVideoFrame", "updateRenderToView", "isRenderToView", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IXplayInstanceApi extends IXplayMessageInterface {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.xplay.IXplayInstanceApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void setVideoExternalConfig$default(IXplayInstanceApi r100, float r101, float r102, float r103, boolean r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = true;
        L6:
            r100.setVideoExternalConfig(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setVideoExternalConfig");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void setVideoExternalConfig$default(IXplayInstanceApi r100, float r101, float r102, float r103, boolean r104, int r105, Object r106) {
            CC.setVideoExternalConfig$default(r100, r101, r102, r103, r104, r105, r106);
        }
    }

    void addCallback(IXplayInstanceCallback r100);

    void attachContext(Context r100);

    void disableGestureRecognizer(boolean r100);

    void enableAudio(String r100, boolean r101);

    List<CloudPlayerRtcInfo> getAllCloudPlayerRtcInfo();

    CloudGameState getCloudGameState();

    View getGameGuideView();

    View getGameView();

    CloudPlayerRtcInfo getTargetPlayerRtcInfo(String r100);

    View getTargetView(String r100);

    void initGame(XplayStartParams r100);

    boolean isGuidePlaying();

    boolean isInitialized();

    boolean isPlaying();

    void pauseGame();

    void pauseTarget(String r100);

    void playGame();

    void playGuideGame();

    void playTarget(String r100);

    void preloadScene();

    void publishVideoStreamAndSetConfig(Map<String, ? extends Object> r100);

    void pushExternalVideoFrame(Map<String, ? extends Object> r100);

    void resumeGame();

    void resumeTarget(String r100);

    void sendStreamingParameter(int r100, int r101, int r102, int r103, int r104);

    void setTargetPlayerVideoExternalConfig(String r100, boolean r101, float r102, float r103, float r104);

    void setVideoCaptureListener(IXplayCGVideoCaptureListener r100);

    void setVideoExternalConfig(float r100, float r101, float r102, boolean r103);

    void showKeyboard(boolean r100);

    void startMixStream(JSONObject r100);

    void stopGame();

    void stopGuideGame();

    void stopMixStream();

    int switchRemoteSimulcastStreamType(int r100);

    void unPublishVideoStream();

    void updateEnableAudioFrame(boolean r100);

    void updateEnableVideoFrame(boolean r100);

    void updateRenderToView(boolean r100);
}
