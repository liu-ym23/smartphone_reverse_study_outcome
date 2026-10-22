package com.bytedance.android.livesdkapi.roomplayer;

import android.content.Context;
import android.view.SurfaceControl;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.player.api.ILivePlayerControl;
import com.bytedance.android.live.player.api.ILivePlayerRender;
import com.bytedance.android.live.player.api.ILivePlayerStatus;
import com.bytedance.android.livesdkapi.model.AudioChannelExpandParams;
import com.bytedance.android.livesdkapi.model.AudioStereoParams;
import com.bytedance.android.livesdkapi.model.AudioTTAPParams;
import com.bytedance.android.livesdkapi.model.DisplayMode;
import com.bytedance.android.livesdkapi.model.DropFrameConfig;
import com.bytedance.android.livesdkapi.model.VolumeBalanceParams;
import com.bytedance.android.livesdkapi.model.VolumeGainParams;
import com.bytedance.android.livesdkapi.player.ILivePlayerEventController;
import com.bytedance.android.livesdkapi.player.preload.PreloadParamBundle;
import com.bytedance.android.livesdkapi.view.IExtraRenderView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.android.lark.utils.statistics.PerfLog;
import is0.b;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002¢\u0001J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J4\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0012j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`\u0013H&J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0010H&J\b\u0010\u0018\u001a\u00020\u0010H&J\b\u0010\u0019\u001a\u00020\u0010H&J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001f\u001a\u00020\u001eH&J\b\u0010!\u001a\u00020 H&J\b\u0010\"\u001a\u00020\u001cH&J\b\u0010#\u001a\u00020\fH'J\b\u0010$\u001a\u00020\fH'J\b\u0010%\u001a\u00020\fH'J\b\u0010&\u001a\u00020\u001cH&J\u0014\u0010(\u001a\u00020\u001c2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001aH'J\u0012\u0010)\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001aH'J\b\u0010*\u001a\u00020\fH'J\b\u0010+\u001a\u00020\fH'J\u0012\u0010.\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010,H&J\u001a\u00103\u001a\u00020\f2\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u000101H&J\b\u00104\u001a\u00020\fH&J\b\u00105\u001a\u00020\u001cH&J\u0018\u00109\u001a\u00020\f2\u0006\u00106\u001a\u00020\u00102\u0006\u00108\u001a\u000207H&J\u0011\u0010:\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b:\u0010;J\u0010\u0010>\u001a\u00020\f2\u0006\u0010=\u001a\u00020<H&J\u0010\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u00020?H&J\u0010\u0010B\u001a\u00020\f2\u0006\u0010@\u001a\u00020?H&J \u0010G\u001a\u00020\f\"\b\b\u0000\u0010D*\u00020C2\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000EH&J\b\u0010I\u001a\u00020HH&J\b\u0010K\u001a\u00020JH&J\b\u0010M\u001a\u00020LH&J\u001b\u0010I\u001a\u00020H2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010NH&¢\u0006\u0004\bI\u0010PJ\u0016\u0010R\u001a\u0010\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020N\u0018\u00010QH&J\u0010\u0010T\u001a\u00020\f2\u0006\u0010S\u001a\u00020\u001cH&J\u0010\u0010V\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u001cH&J\u0012\u0010Y\u001a\u00020\f2\b\u0010X\u001a\u0004\u0018\u00010WH&J\u0012\u0010Z\u001a\u00020\f2\b\u0010X\u001a\u0004\u0018\u00010WH&J\b\u0010[\u001a\u00020\fH&J0\u0010b\u001a\u00020\f2\u0006\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020\\2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020\\2\u0006\u0010a\u001a\u00020NH&J\b\u0010c\u001a\u00020NH&J\u0010\u0010e\u001a\u00020\f2\u0006\u0010d\u001a\u00020NH&J \u0010h\u001a\u00020\f2\u0006\u0010S\u001a\u00020N2\u0006\u0010f\u001a\u00020N2\u0006\u0010g\u001a\u00020NH&J\b\u0010j\u001a\u00020iH&J\u001a\u0010l\u001a\u0004\u0018\u00010k2\u0006\u0010_\u001a\u00020N2\u0006\u0010`\u001a\u00020NH&J\u0012\u0010n\u001a\u00020\f2\b\u0010m\u001a\u0004\u0018\u00010kH&J\n\u0010o\u001a\u0004\u0018\u00010kH&J\u0010\u0010r\u001a\u00020\f2\u0006\u0010q\u001a\u00020pH&J\u0010\u0010u\u001a\u00020\f2\u0006\u0010t\u001a\u00020sH&J\u0010\u0010w\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020vH&J\u0010\u0010y\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020xH&J\u0010\u0010{\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020zH&J\u0010\u0010}\u001a\u00020\f2\u0006\u0010|\u001a\u00020NH&J\u0012\u0010\u007f\u001a\u0004\u0018\u00010~2\u0006\u0010'\u001a\u00020\u001aH&J\u0011\u0010\u0080\u0001\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u001aH&J\u0014\u0010\u0082\u0001\u001a\u0004\u0018\u00010C2\u0007\u0010\u0081\u0001\u001a\u00020NH&J\u0015\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00100QH\u0016J*\u0010\u0087\u0001\u001a\u00020\f2\u001f\u0010\u0086\u0001\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00100Q0\u0084\u0001j\u0003`\u0085\u0001H&J\t\u0010\u0088\u0001\u001a\u00020\fH&J\u0013\u0010\u008b\u0001\u001a\u00020\f2\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001H&J\u0013\u0010\u008c\u0001\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010WH\u0016J\u000b\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J\u001d\u0010\u0090\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010\u008e\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020WH&R\u0018\u0010\u0094\u0001\u001a\u00030\u0091\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0095\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0019\u0010\u009b\u0001\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009e\u0001\u001a\u0004\u0018\u00010~8&X¦\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0017\u0010¡\u0001\u001a\u00020N8&X¦\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001¨\u0006£\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "Lcom/bytedance/android/live/player/api/ILivePlayerRender;", "Lcom/bytedance/android/live/player/api/ILivePlayerStatus;", "Lcom/bytedance/android/live/player/api/ILivePlayerControl;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerVRController;", "Lcom/bytedance/android/livesdkapi/player/ILivePlayerEventController;", "Lcom/bytedance/android/livesdkapi/roomplayer/IAudioControl;", "Lcom/bytedance/android/livesdkapi/roomplayer/IVideoEffectControl;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerNetworkAwareController;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerMonitor;", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "View", "", "changeRenderView", "Lcom/bytedance/android/livesdkapi/roomplayer/IPlayerLogger;", "logger", "", "targetEvent", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "injectAppLoggerParams", "bizDomain", "updateBizDomain", "getPlayerStreamId", "getPlayerStreamData", "Landroid/content/Context;", "activity", "", "preCreateSurface", "Lcom/bytedance/android/livesdkapi/roomplayer/IPlayerBusinessManager;", "businessManager", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerSharedDataManager;", "sharedDataManager", "hasRealPlayer", "markStart", "resetMark", "clearObservers", "enableEventHubLeakFix", PerfLog.PARAM_KEY_CONTEXT_ID, "stop", "stopAndRelease", "onForeground", "onBackground", "Lcom/bytedance/android/livesdkapi/roomplayer/IFrameCallback;", "frameCallback", "setFrameCallback", "Lcom/bytedance/android/livesdkapi/roomplayer/WtnPlayRequest;", "wtnPlayRequest", "Lcom/bytedance/android/livesdkapi/roomplayer/WtnPlayCallback;", "callback", "switchToWtnPlay", "closeWtnPlay", "isRtsStream", "streamInfoJson", "Lcom/bytedance/android/livesdkapi/player/preload/PreloadParamBundle;", "preloadParam", "preload", "isPreloading", "()Ljava/lang/Boolean;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "scene", "setUseScene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient$ISharePlayerController;", "intercept", "addSharePlayerController", "removeSharePlayerController", "", ExifInterface.GPS_DIRECTION_TRUE, "Lis0/b;", "feature", "registerPlayerFeature", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController;", "extraRenderController", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerMultiRenderController;", "multiRenderController", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerGameExtraRenderController;", "gameExtraRenderController", "", "controllerType", "(Ljava/lang/Integer;)Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController;", "Lkotlin/Pair;", "getVideoSizeOnCreateRenderView", "enable", "setEnableSr", "ignore", "ignoreLossAudioFocus", "Lorg/json/JSONObject;", "picoInfo", "updateVRBgImage", "updatePicoInfo", "resetSmoothDoubleRenderSurface", "", "x", "y", "width", "height", "type", "cropSurfaceOrSurfaceHolder", "getAutoResolutionState", "state", "setAutoResolutionState", "dropInterval", "minFrameRate", "setDropFrame", "Lcom/bytedance/android/livesdkapi/model/DropFrameConfig;", "getDropFrameConfig", "Landroid/view/SurfaceControl;", "useSurfaceControl", "surfaceControl", "setSurfaceControl", "getSurfaceControl", "Lcom/bytedance/android/livesdkapi/model/VolumeBalanceParams;", "volumeBalanceParams", "setVolumeBalanceParams", "Lcom/bytedance/android/livesdkapi/model/AudioStereoParams;", "audioStereoParams", "setAudioStereo", "Lcom/bytedance/android/livesdkapi/model/VolumeGainParams;", "setVolumeGain", "Lcom/bytedance/android/livesdkapi/model/AudioChannelExpandParams;", "setAudioChannelExpand", "Lcom/bytedance/android/livesdkapi/model/AudioTTAPParams;", "setAudioTTAP", "show", "setPreplayShow", "Lcom/bytedance/android/livesdkapi/view/IExtraRenderView;", "createExtraRenderView", "setApplicationContext", "Key", "getObjectOption", "onMixedAudioDetected", "Lkotlin/Function0;", "Lcom/bytedance/android/livesdkapi/roomplayer/OnMixedAudioHandler;", "handler", "addMixedAudioHandler", "onRoomBackgroundV2", "Lcom/bytedance/android/livesdkapi/model/DisplayMode;", "displayMode", "updateDisplayMode", "processClientAIParams", "getRoomIdString", "eventKey", "info", "getLivePlayerInfo", "Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;", "getEventHub", "()Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;", "eventHub", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getRenderView", "()Lcom/bytedance/android/livesdkapi/view/IRenderView;", "renderView", "getExtraRenderView", "()Lcom/bytedance/android/livesdkapi/view/IExtraRenderView;", "extraRenderView", "getPlayerBlurInitResult", "()I", "playerBlurInitResult", "ISharePlayerController", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerClient extends ILivePlayerRender, ILivePlayerStatus, ILivePlayerControl, ILivePlayerVRController, ILivePlayerEventController, IAudioControl, IVideoEffectControl, ILivePlayerNetworkAwareController, ILivePlayerMonitor {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static String getRoomIdString(ILivePlayerClient r100) {
            return null;
        }

        public static void processClientAIParams(ILivePlayerClient r100, JSONObject r101) {
        }

        public static Pair<Boolean, String> onMixedAudioDetected(ILivePlayerClient r100) {
            return new Pair(Boolean.FALSE, "");
        }

        public static /* synthetic */ ILivePlayerExtraRenderController extraRenderController$default(ILivePlayerClient r100, Integer r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = 0;
        L7:
            return r100.extraRenderController(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: extraRenderController");
        }

        public static /* synthetic */ boolean stop$default(ILivePlayerClient r100, Context r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.stop(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stop");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient$ISharePlayerController;", "", "cancelDelayStopOrRelease", "", "directRunStopOrRelease", "interceptStopOrRelease", "", "isRelease", "isInDelayStopOrRelease", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ISharePlayerController {
        void cancelDelayStopOrRelease();

        void directRunStopOrRelease();

        boolean interceptStopOrRelease(boolean r100);

        boolean isInDelayStopOrRelease();
    }

    void addMixedAudioHandler(Function0<Pair<Boolean, String>> r100);

    void addSharePlayerController(ISharePlayerController r100);

    IPlayerBusinessManager businessManager();

    void changeRenderView(IRenderView r100);

    @Deprecated(message = "To Refactor")
    void clearObservers();

    void closeWtnPlay();

    IExtraRenderView createExtraRenderView(Context r100);

    void cropSurfaceOrSurfaceHolder(float r100, float r101, float r102, float r103, int r104);

    boolean enableEventHubLeakFix();

    ILivePlayerExtraRenderController extraRenderController();

    ILivePlayerExtraRenderController extraRenderController(Integer r100);

    ILivePlayerGameExtraRenderController gameExtraRenderController();

    int getAutoResolutionState();

    DropFrameConfig getDropFrameConfig();

    IRoomEventHub getEventHub();

    IExtraRenderView getExtraRenderView();

    LifecycleOwner getLifecycleOwner();

    JSONObject getLivePlayerInfo(String r100, JSONObject r101);

    Object getObjectOption(int r100);

    int getPlayerBlurInitResult();

    String getPlayerStreamData();

    String getPlayerStreamId();

    IRenderView getRenderView();

    String getRoomIdString();

    SurfaceControl getSurfaceControl();

    Pair<Integer, Integer> getVideoSizeOnCreateRenderView();

    boolean hasRealPlayer();

    void ignoreLossAudioFocus(boolean r100);

    void injectAppLoggerParams(String r100, HashMap<String, String> r101);

    Boolean isPreloading();

    boolean isRtsStream();

    IPlayerLogger logger();

    @Deprecated(message = "To Move")
    void markStart();

    ILivePlayerMultiRenderController multiRenderController();

    @Deprecated(message = "To Delete")
    void onBackground();

    @Deprecated(message = "To Delete")
    void onForeground();

    Pair<Boolean, String> onMixedAudioDetected();

    void onRoomBackgroundV2();

    boolean preCreateSurface(Context r100);

    void preload(String r100, PreloadParamBundle r101);

    void processClientAIParams(JSONObject r100);

    <T> void registerPlayerFeature(b<T> r100);

    void removeSharePlayerController(ISharePlayerController r100);

    @Deprecated(message = "To Move")
    void resetMark();

    void resetSmoothDoubleRenderSurface();

    void setApplicationContext(Context r100);

    void setAudioChannelExpand(AudioChannelExpandParams r100);

    void setAudioStereo(AudioStereoParams r100);

    void setAudioTTAP(AudioTTAPParams r100);

    void setAutoResolutionState(int r100);

    void setDropFrame(int r100, int r101, int r102);

    void setEnableSr(boolean r100);

    void setFrameCallback(IFrameCallback r100);

    void setPreplayShow(int r100);

    void setSurfaceControl(SurfaceControl r100);

    void setUseScene(ILivePlayerScene r100);

    void setVolumeBalanceParams(VolumeBalanceParams r100);

    void setVolumeGain(VolumeGainParams r100);

    ILivePlayerSharedDataManager sharedDataManager();

    @Deprecated(message = "use stop()")
    boolean stop(Context r100);

    @Deprecated(message = "use release()")
    boolean stopAndRelease(Context r100);

    void switchToWtnPlay(WtnPlayRequest r100, WtnPlayCallback r101);

    void updateBizDomain(String r100);

    void updateDisplayMode(DisplayMode r100);

    void updatePicoInfo(JSONObject r100);

    void updateVRBgImage(JSONObject r100);

    SurfaceControl useSurfaceControl(int r100, int r101);
}
