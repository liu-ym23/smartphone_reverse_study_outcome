package com.bytedance.android.livesdkapi.roomplayer;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.room.e;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.player.ILivePlayerFeatureManager;
import com.bytedance.android.livesdkapi.player.ITTVideoEnginePlayListener;
import com.bytedance.android.livesdkapi.player.preload.ILivePlayerPreloadService;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.xlive.IXLivePlayer;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import gl0.d;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0014\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0011H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H&J\b\u0010\u0017\u001a\u00020\u0004H&J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0004H&J\b\u0010\u001e\u001a\u00020\u001dH&J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001f0\u0010H&J\u0012\u0010#\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020!H'J\u0012\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020!H&J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\"\u001a\u00020!H&J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020!H&J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000bH&J\u0018\u0010-\u001a\u00020,2\u0006\u0010\u0013\u001a\u00020)2\u0006\u0010+\u001a\u00020*H'J\n\u0010.\u001a\u0004\u0018\u00010\u0002H&J#\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010/2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000000H&¢\u0006\u0004\b2\u00103J\n\u00105\u001a\u0004\u0018\u000104H&J\u0010\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206H&J\u0010\u00109\u001a\u00020\u00062\u0006\u00107\u001a\u000206H&J\u001a\u0010;\u001a\u00020:2\u0006\u0010\u0013\u001a\u00020)2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0010\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u00020<H&J\b\u0010A\u001a\u00020@H&J\b\u0010C\u001a\u00020BH&J\b\u0010E\u001a\u00020DH&J\b\u0010G\u001a\u00020FH&J\b\u0010H\u001a\u00020\u0019H&J\u0010\u0010K\u001a\u00020\u00062\u0006\u0010J\u001a\u00020IH&¨\u0006L"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerService;", "", "Lcom/bytedance/android/livesdkapi/host/ILivePlayerHostService;", "livePlayerHostService", "", "enableCover", "", "inject", "isInit", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;", "config", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "createClient", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "scene", "isPlaying", "", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerReadOnlyContext;", "stopAllWithShownClientContext", PerfLog.PARAM_KEY_CONTEXT_ID, "playClientByClientContext", "isIntercept", "setInterceptStream", "getInterceptStream", "client", "", "trigger", "checkAudioMixedEvent", "playerStabilityOptEnable", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerVqosLogger;", "vqosLogger", "Ljava/lang/ref/WeakReference;", "allPlayerClients", "", LocationMonitorConst.IDENTIFIER, "getClientWithIdentifier", "getClientWithIdentifierIgnoreCreateScene", "getPreviewClientListWithIdentifier", "newIdentifier", "updatePlayerIdentifier", "destroyClient", "Landroid/content/Context;", "Lcom/bytedance/android/livesdkapi/view/IRenderView$RenderViewType;", "renderViewType", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "createRenderView", "hostService", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "type", "getConfig", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/bytedance/android/live/room/e;", "dnsOptimizer", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerEventObserver;", "observer", "registerPlayerEventObserver", "removePlayerEventObserver", "Lgl0/d;", "getLiveStatusErrorView", "Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;", "playerView", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerStatusController;", "getPlayerLiveStatusController", "Lcom/bytedance/android/livesdkapi/player/ILivePlayerFeatureManager;", "featureManager", "Lcom/bytedance/android/livesdkapi/xlive/IXLivePlayer;", "xlive", "Lcom/bytedance/android/livesdkapi/player/ITTVideoEnginePlayListener;", "ttVideoEnginePlayListener", "Lcom/bytedance/android/livesdkapi/player/preload/ILivePlayerPreloadService;", "getPreloadService", "getCacheClientSize", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerFeature;", "playerFeature", "registerLivePlayerFeature", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ boolean isPlaying$default(ILivePlayerService r100, ILivePlayerScene r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.isPlaying(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isPlaying");
        }
    }

    List<WeakReference<ILivePlayerClient>> allPlayerClients();

    void checkAudioMixedEvent(ILivePlayerClient r100, int r101);

    ILivePlayerClient createClient(LivePlayerConfig r100);

    @Deprecated(message = "兼容历史业务逻辑, 不推荐直接使用, RenderView的创建应该由LivePlayerView来管理")
    IRenderView createRenderView(Context r100, IRenderView.RenderViewType r101);

    void destroyClient(ILivePlayerClient r100);

    e dnsOptimizer();

    ILivePlayerFeatureManager featureManager();

    int getCacheClientSize();

    @Deprecated(message = "")
    ILivePlayerClient getClientWithIdentifier(String r100);

    ILivePlayerClient getClientWithIdentifierIgnoreCreateScene(String r100);

    <T> T getConfig(Class<T> r100);

    boolean getInterceptStream();

    d getLiveStatusErrorView(Context r100, ILivePlayerScene r101);

    ILivePlayerStatusController getPlayerLiveStatusController(AbsLivePlayerView r100);

    ILivePlayerPreloadService getPreloadService();

    List<ILivePlayerClient> getPreviewClientListWithIdentifier(String r100);

    ILivePlayerHostService hostService();

    void inject(ILivePlayerHostService r100, boolean r101);

    boolean isInit();

    boolean isPlaying(ILivePlayerScene r100);

    void playClientByClientContext(LivePlayerReadOnlyContext r100);

    boolean playerStabilityOptEnable();

    void registerLivePlayerFeature(ILivePlayerFeature r100);

    void registerPlayerEventObserver(ILivePlayerEventObserver r100);

    void removePlayerEventObserver(ILivePlayerEventObserver r100);

    void setInterceptStream(boolean r100);

    List<LivePlayerReadOnlyContext> stopAllWithShownClientContext();

    ITTVideoEnginePlayListener ttVideoEnginePlayListener();

    boolean updatePlayerIdentifier(ILivePlayerClient r100, String r101);

    ILivePlayerVqosLogger vqosLogger();

    IXLivePlayer xlive();
}
