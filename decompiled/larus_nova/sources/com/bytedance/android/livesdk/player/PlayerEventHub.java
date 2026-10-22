package com.bytedance.android.livesdk.player;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.player.event.PlayerNextLiveData;
import com.bytedance.android.livesdk.player.event.WeakMutableLiveData;
import com.bytedance.android.livesdk.player.log.PlayerSeiNextLiveData;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.bytedance.android.livesdkapi.model.PlayerLeakOptimizeConfig;
import com.bytedance.android.livesdkapi.model.WtnPlayEvent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSpmLogger;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.SeiToJsonObject;
import com.bytedance.android.livesdkapi.roomplayer.SwitchResolutionResult;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class PlayerEventHub implements IRoomEventHub {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final Lazy f155048g0 = null;
    public final MutableLiveData<Boolean> A;
    public final MutableLiveData<Integer> B;
    public final MutableLiveData<Long> C;
    public final MutableLiveData<Integer> D;
    public final MutableLiveData<Long> E;
    public final MutableLiveData<JSONObject> F;
    public final PlayerNextLiveData<SwitchResolutionResult> G;
    public final PlayerNextLiveData<Integer> H;
    public final PlayerNextLiveData<Integer> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final PlayerNextLiveData<String> f155049J;
    public final PlayerNextLiveData<Boolean> K;
    public final PlayerNextLiveData<Boolean> L;
    public final PlayerLoggerNextLiveData<Boolean> M;
    public final PlayerEventHub$sceneChange$1 N;
    public final PlayerLoggerNextLiveData<Boolean> O;
    public final MutableLiveData<IRenderView> P;
    public final PlayerNextLiveData<Boolean> Q;
    public final MutableLiveData<Boolean> R;
    public MutableLiveData<Boolean> S;
    public final MutableLiveData<String> T;
    public final MutableLiveData<Boolean> U;
    public final MutableLiveData<LayoutEvent> V;
    public final PlayerNextLiveData<Boolean> W;
    public final PlayerNextLiveData X;
    public final PlayerNextLiveData Y;
    public final MutableLiveData<Boolean> Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILivePlayerSpmLogger f155050a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final MutableLiveData<Pair<Integer, String>> f155051a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlayerNextLiveData<Boolean> f155052b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final MutableLiveData<Set<String>> f155053b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PlayerLoggerNextLiveData<Boolean> f155054c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public volatile boolean f155055c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PlayerLoggerNextLiveData<Pair<Integer, Integer>> f155056d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final MutableLiveData<Boolean> f155057d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PlayerNextLiveData<String> f155058e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final PlayerNextLiveData<Map<String, String>> f155059e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PlayerNextLiveData<String> f155060f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final MutableLiveData<WtnPlayEvent> f155061f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PlayerNextLiveData<Long> f155062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PlayerNextLiveData<SeiToJsonObject> f155063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PlayerNextLiveData<ByteBuffer> f155064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PlayerNextLiveData<String> f155065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PlayerLoggerNextLiveData<Boolean> f155066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PlayerLoggerNextLiveData<Boolean> f155067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PlayerLoggerNextLiveData<Boolean> f155068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PlayerLoggerNextLiveData<Boolean> f155069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PlayerLoggerNextLiveData<Boolean> f155070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PlayerLoggerMutableLiveData<Boolean> f155071p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PlayerLoggerMutableLiveData<Boolean> f155072q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PlayerLoggerNextLiveData<Boolean> f155073r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PlayerNextLiveData<Boolean> f155074s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final PlayerNextLiveData<Boolean> f155075t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PlayerNextLiveData<Boolean> f155076u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PlayerNextLiveData<Boolean> f155077v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PlayerNextLiveData<String> f155078w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final PlayerNextLiveData<Boolean> f155079x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final PlayerLoggerMutableLiveData<Boolean> f155080y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final MutableLiveData<Boolean> f155081z;

    public static final class a {
    }

    static {
        f155048g0 = LazyKt.lazy(PlayerEventHub$Companion$seiCostTracer$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getAbrSwitch() {
        return this.I;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<String> getAfterCdnDisasterToleranceStreamDataString() {
        return this.T;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getAllSurfaceReadyFirstFrameRender() {
        return this.f155076u;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Integer> getAudioRenderStall() {
        return this.D;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Long> getAudioRenderStallNew() {
        return this.E;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getBackgroundHandlerRunning() {
        return this.L;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Boolean> getBackgroundStopIn4G() {
        return this.R;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getBinarySeiUpdate() {
        return this.f155064i;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<IRenderView> getBindRenderView() {
        return this.P;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Boolean> getClientMobileTrafficUsedExceed() {
        return this.S;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Set<String>> getDisableResolutionList() {
        return this.f155053b0;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getExtraSurfaceReadyFirstFrameRender() {
        return this.f155075t;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getFirstFrame() {
        return this.f155054c;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getJsonObjectSeiUpdate() {
        return this.f155063h;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getLastKeyFrameSei() {
        return this.f155060f;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<LayoutEvent> getLayoutEvent() {
        return this.V;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getLiveEnd() {
        return this.f155080y;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getMainSurfaceReadyFirstFrameRender() {
        return this.f155074s;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Pair<Integer, String>> getOnNetworkQualityChanged() {
        return this.f155051a0;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getPlayComplete() {
        return this.f155069n;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<JSONObject> getPlayMonitorLog() {
        return this.F;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getPlayPrepared() {
        return this.f155052b;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getPlayResume() {
        return this.f155070o;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getPlayerBlur() {
        return this.f155072q;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getPlayerMediaError() {
        return this.f155065j;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getPlayerMute() {
        return this.f155071p;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getPlaying() {
        return this.f155066k;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getPlayingHandlerRunning() {
        return this.K;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getPtsUpdate() {
        return this.f155062g;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getReleased() {
        return this.f155068m;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getReset() {
        return this.M;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Boolean> getResetSurface() {
        return this.U;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getResolutionDegrade() {
        return this.f155049J;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final boolean getResolutionRemoved() {
        return this.f155055c0;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Boolean> getRoomFinish() {
        return this.Z;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<ILivePlayerScene> getSceneChange() {
        return this.N;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getSeiUpdate() {
        return this.f155058e;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getSmoothSwitchResolutionError() {
        return this.H;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Boolean> getStallEnd() {
        return this.A;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Boolean> getStallStart() {
        return this.f155081z;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getStartPullStream() {
        return this.O;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getStopped() {
        return this.f155067l;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Boolean> getSurfaceControlChange() {
        return this.f155057d0;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getSurfaceReady() {
        return this.Q;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getSurfaceReadyFirstFrameRender() {
        return this.f155073r;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getSwitchResolutionResult() {
        return this.G;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Integer> getVideoRenderStall() {
        return this.B;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<Long> getVideoRenderStallNew() {
        return this.C;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getVideoSizeChanged() {
        return this.f155056d;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController.VREvent
    public final MutableLiveData<VrBgLogData> getVrBgLogUpdateOrSend() {
        return this.Y;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getVrEffectEvent() {
        return this.f155078w;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController.VREvent
    public final MutableLiveData getVrLive() {
        return this.W;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData getVrStreamEnable() {
        return this.f155077v;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController.VREvent
    public final MutableLiveData<List<Float>> getVrViewAngleChange() {
        return this.X;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData<WtnPlayEvent> getWtnPlayEvent() {
        return this.f155061f0;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final MutableLiveData isSeiCropping() {
        return this.f155079x;
    }

    /* JADX WARN: Type inference failed for: r1v43, types: [com.bytedance.android.livesdk.player.PlayerEventHub$sceneChange$1] */
    public PlayerEventHub(final LivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        ILivePlayerSpmLogger r101 = r100.getSpmLogger();
        this.f155050a = r101;
        PlayerNextLiveData<Boolean> r102 = new PlayerNextLiveData();
        Boolean r103 = Boolean.FALSE;
        r102.setValue(r103);
        Unit r104 = Unit.INSTANCE;
        this.f155052b = r102;
        PlayerLoggerNextLiveData<Boolean> r105 = new PlayerLoggerNextLiveData(r101, "firstFrame");
        r105.setValue(r103);
        this.f155054c = r105;
        this.f155056d = new PlayerLoggerNextLiveData(r101, "videoSizeChanged");
        if (((Boolean) f155048g0.getValue()).booleanValue() == false) goto L5;
        PlayerNextLiveData<String> r106 = new PlayerSeiNextLiveData(r100.getCostTracer());
    L6:
        this.f155058e = r106;
        this.f155060f = new PlayerNextLiveData();
        PlayerNextLiveData<Long> r107 = new PlayerNextLiveData();
        r107.setValue(0L);
        this.f155062g = r107;
        PlayerNextLiveData<SeiToJsonObject> r108 = new PlayerNextLiveData();
        new SeiToJsonObject(null, null);
        this.f155063h = r108;
        this.f155064i = new PlayerNextLiveData();
        this.f155065j = new PlayerNextLiveData();
        PlayerLoggerNextLiveData<Boolean> r109 = new PlayerLoggerNextLiveData(r101, "playing");
        r109.setValue(r103);
        this.f155066k = r109;
        Lazy r110 = PlayerLoggerNextLiveData.f155087h;
        PlayerLoggerNextLiveData<Boolean> r111 = new PlayerLoggerNextLiveData(r101, "stopped", ((Boolean) r110.getValue()).booleanValue());
        r111.setValue(r103);
        this.f155067l = r111;
        PlayerLoggerNextLiveData<Boolean> r112 = new PlayerLoggerNextLiveData(r101, "released", ((Boolean) r110.getValue()).booleanValue());
        r112.setValue(r103);
        this.f155068m = r112;
        PlayerLoggerNextLiveData<Boolean> r113 = new PlayerLoggerNextLiveData(r101, "playComplete");
        r113.setValue(r103);
        this.f155069n = r113;
        PlayerLoggerNextLiveData<Boolean> r114 = new PlayerLoggerNextLiveData(r101, "playResume");
        r114.setValue(r103);
        this.f155070o = r114;
        PlayerLoggerMutableLiveData<Boolean> r115 = new PlayerLoggerMutableLiveData(r101, "playerMute");
        r115.setValue(r103);
        this.f155071p = r115;
        PlayerLoggerMutableLiveData<Boolean> r116 = new PlayerLoggerMutableLiveData(r101, "playerBlur");
        r116.setValue(r103);
        this.f155072q = r116;
        PlayerLoggerNextLiveData<Boolean> r117 = new PlayerLoggerNextLiveData(r101, "surfaceReadyFirstFrameRender");
        r117.setValue(r103);
        this.f155073r = r117;
        PlayerNextLiveData<Boolean> r118 = new PlayerNextLiveData();
        r118.setValue(r103);
        this.f155074s = r118;
        PlayerNextLiveData<Boolean> r119 = new PlayerNextLiveData();
        r119.setValue(r103);
        this.f155075t = r119;
        PlayerNextLiveData<Boolean> r120 = new PlayerNextLiveData();
        r120.setValue(r103);
        this.f155076u = r120;
        this.f155077v = new PlayerNextLiveData();
        this.f155078w = new PlayerNextLiveData();
        PlayerNextLiveData<Boolean> r121 = new PlayerNextLiveData();
        r121.setValue(r103);
        this.f155079x = r121;
        PlayerLoggerMutableLiveData<Boolean> r122 = new PlayerLoggerMutableLiveData(r101, "liveEnd");
        r122.setValue(r103);
        this.f155080y = r122;
        this.f155081z = new MutableLiveData();
        this.A = new MutableLiveData();
        this.B = new MutableLiveData();
        this.C = new MutableLiveData();
        this.D = new MutableLiveData();
        this.E = new MutableLiveData();
        this.F = new MutableLiveData();
        PlayerNextLiveData<SwitchResolutionResult> r123 = new PlayerNextLiveData();
        r123.setValue(new SwitchResolutionResult(true));
        this.G = r123;
        PlayerNextLiveData<Integer> r124 = new PlayerNextLiveData();
        r124.setValue(-1);
        this.H = r124;
        PlayerNextLiveData<Integer> r125 = new PlayerNextLiveData();
        r125.setValue(-1);
        this.I = r125;
        this.f155049J = new PlayerNextLiveData();
        PlayerNextLiveData<Boolean> r126 = new PlayerNextLiveData();
        r126.setValue(r103);
        this.K = r126;
        PlayerNextLiveData<Boolean> r127 = new PlayerNextLiveData();
        r127.setValue(r103);
        this.L = r127;
        PlayerLoggerNextLiveData<Boolean> r128 = new PlayerLoggerNextLiveData(r101, BasicTestActionHandler.TEST_ACTION_RESET);
        r128.setValue(r103);
        this.M = r128;
        this.N = new PlayerEventHub$sceneChange$1(r100);
        PlayerLoggerNextLiveData<Boolean> r129 = new PlayerLoggerNextLiveData(r101, "startPullStream");
        r129.setValue(r103);
        this.O = r129;
        if (((PlayerLeakOptimizeConfig) LivePlayerService.INSTANCE.getConfig(PlayerLeakOptimizeConfig.class)).getViewWeakRef() == false) goto L9;
        MutableLiveData<IRenderView> r130 = new WeakMutableLiveData(true);
    L10:
        this.P = r130;
        this.Q = new PlayerNextLiveData();
        this.R = new MutableLiveData();
        MutableLiveData<Boolean> r131 = new MutableLiveData();
        r131.setValue(r103);
        this.S = r131;
        MutableLiveData<String> r132 = new MutableLiveData();
        r132.setValue("");
        this.T = r132;
        this.U = new MutableLiveData(r103);
        this.V = new MutableLiveData();
        PlayerNextLiveData<Boolean> r133 = new PlayerNextLiveData();
        r133.setValue(r103);
        this.W = r133;
        this.X = new PlayerNextLiveData();
        this.Y = new PlayerNextLiveData();
        this.Z = new MutableLiveData();
        this.f155051a0 = new MutableLiveData();
        this.f155053b0 = new MutableLiveData();
        MutableLiveData<Boolean> r134 = new MutableLiveData();
        r134.setValue(r103);
        this.f155057d0 = r134;
        PlayerNextLiveData<Map<String, String>> r135 = new PlayerNextLiveData();
        r135.setValue(null);
        this.f155059e0 = r135;
        this.f155061f0 = new MutableLiveData();
        return;
    L9:
        r130 = new PlayerNextLiveData();
        goto L10
    L5:
        r106 = new PlayerNextLiveData();
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final void setClientMobileTrafficUsedExceed(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.S = r100;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub
    public final void setResolutionRemoved(boolean r100) {
        this.f155055c0 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerException.Observers
    public final void observeException(LifecycleOwner r100, Observer<Map<String, String>> r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f155059e0.observe(r100, r101, false);
    }
}
