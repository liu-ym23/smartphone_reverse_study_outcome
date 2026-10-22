package com.bytedance.android.livesdk.player.api;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.SurfaceHolder;
import com.bytedance.android.livesdk.player.model.j;
import com.bytedance.android.livesdkapi.model.AdaptiveGradingRequest;
import com.bytedance.android.livesdkapi.model.AesBoostConfig;
import com.bytedance.android.livesdkapi.model.AudioChannelExpandParams;
import com.bytedance.android.livesdkapi.model.AudioStereoParams;
import com.bytedance.android.livesdkapi.model.AudioTTAPParams;
import com.bytedance.android.livesdkapi.model.DisplayMode;
import com.bytedance.android.livesdkapi.model.ExecuteCommandConfig;
import com.bytedance.android.livesdkapi.model.LiveStreamType;
import com.bytedance.android.livesdkapi.model.PlayerSpeedRangeParams;
import com.bytedance.android.livesdkapi.model.RenderAreaInfo;
import com.bytedance.android.livesdkapi.model.StreamSrConfig;
import com.bytedance.android.livesdkapi.model.SuperResolutionConfig;
import com.bytedance.android.livesdkapi.model.SvcParams;
import com.bytedance.android.livesdkapi.model.VideoEffectSixDofLiteModeParams;
import com.bytedance.android.livesdkapi.model.VolumeGainParams;
import com.bytedance.android.livesdkapi.player.ISetSurfaceInterceptor;
import com.bytedance.android.livesdkapi.player.preload.PreloadParamBundle;
import com.bytedance.android.livesdkapi.roomplayer.ComposerResult;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.texturerender.VideoSurface;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import oo2.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public interface ITTLivePlayer {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/player/api/ITTLivePlayer$Headers;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Headers {
        public static final a Companion = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f155153a = null;

            public a() {
            }

            static {
                f155153a = new a();
            }
        }

        static {
            Companion = a.f155153a;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/player/api/ITTLivePlayer$ImageLayout;", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public @interface ImageLayout {
    }

    void A0(SvcParams r100);

    void B0(boolean r100);

    void C0(boolean r100);

    void D0(int r100);

    void E0(int r100);

    void F0();

    void G0();

    void H0();

    void I0(Function1<? super ITTLivePlayer, Boolean> r100);

    ISetSurfaceInterceptor J0();

    Boolean K0();

    void L0();

    void M();

    void M0(AdaptiveGradingRequest r100);

    void N(SurfaceHolder r100, boolean r101);

    void N0();

    void O(int r100);

    void O0(int r100);

    RenderAreaInfo P(int r100);

    void P0(boolean r100);

    void Q();

    void Q0(JSONObject r100);

    void R();

    void R0();

    void S(int r100, int r101, String r102);

    void S0(boolean r100);

    void T(AesBoostConfig r100);

    void U(SurfaceControl r100, boolean r101);

    void V();

    void W(StreamSrConfig.SrScale r100);

    void X(SuperResolutionConfig r100);

    void Y(Surface r100, boolean r101);

    void Z(int r100);

    void a0();

    void appendComposerNodes(String[] r100, String[] r101, ComposerResult r102);

    void b0(boolean r100);

    void c0(String r100);

    void cropSurfaceOrSurfaceHolder(float r100, float r101, float r102, float r103, int r104);

    void d0(boolean r100, StreamSrConfig.SrScale r101, int r102, String r103);

    void e0(float r100);

    void enableRTMPauseUseStop(boolean r100);

    void executeCommand(ExecuteCommandConfig r100);

    void f0(String r100, Map<String, String> r101, LiveStreamType r102);

    void forceDrawOnceWhenSwitchSurface(boolean r100);

    void g0(b.a r100, boolean r101);

    void getActualPlayerSurface();

    Bitmap getBitmap();

    void getComposerNodePaths();

    String getCurrentResolution();

    Surface getCurrentSurface();

    JSONObject getFirstFrameBlockInfo();

    JSONObject getLivePlayerInfo(String r100, JSONObject r101);

    String getLivePlayerState();

    Map<String, String> getLiveStreamBaseInfo();

    JSONObject getLiveStreamInfoForSlardarReport();

    String getPlayerState();

    float getPlayerVolume();

    JSONObject getStaticLog();

    String getStreamFormat();

    SurfaceControl getSurfaceControl();

    Point getVideoSize();

    int getVoiceDB();

    float getVolume();

    void gyroEnable(boolean r100);

    void h0(j r100);

    void i0();

    void isEffectInited();

    boolean isOSPlayer();

    boolean isPlaying();

    void isPrePrepare();

    Boolean isPreloading();

    boolean isSharpenUsed();

    boolean isSrUsed();

    void isSupportResolutionSwitch(String r100);

    boolean isTextureRender();

    void j0(VideoEffectSixDofLiteModeParams r100);

    void k0();

    void l0(float r100);

    void m0(PlayerSpeedRangeParams r100);

    boolean n0();

    void o0(Object r100);

    void onTouchEvent(MotionEvent r100);

    void p0(String r100, String r101, String r102);

    void pause();

    void prePlaySwitchRes();

    void prePrepare(String r100, String r101);

    void preload(String r100, PreloadParamBundle r101);

    void prepareAsync();

    void q0();

    void r0(boolean r100);

    void release();

    void releaseAsync();

    void releaseEffect();

    void removeComposerNodes(String[] r100, ComposerResult r101);

    void removeExtraSurface(Surface r100, int r101);

    void resetLastSwitchResolutionOperation();

    void resetSurface(Object r100);

    VideoLiveManager s0();

    void saveBytebuffer(Bundle r100, VideoSurface.SaveFrameCallback r101);

    void saveFrame(Function1<? super Bitmap, Unit> r100);

    void seekBy(int r100);

    void sendMessage(int r100, int r101, int r102, String r103);

    void setAudioChannelExpand(AudioChannelExpandParams r100);

    void setAudioStereo(AudioStereoParams r100);

    void setAudioTTAP(AudioTTAPParams r100);

    void setAutoResolutionState(int r100);

    void setComposerNodes(String[] r100, String[] r101, ComposerResult r102);

    void setDropFrame(int r100, int r101, int r102);

    void setEnable(boolean r100, int r101);

    void setEnableSr(boolean r100);

    void setExtraSurface(Surface r100, int r101);

    void setImageLayout(@ImageLayout int r100);

    void setIsPrePlay(boolean r100);

    void setLiveRoomState(boolean r100);

    void setMute(boolean r100);

    void setPlayerVolume(float r100);

    void setPreplayShow(int r100);

    void setPreviewFlag(boolean r100);

    void setProcessAudioAddr(long r100);

    void setProjectKey(String r100);

    void setPullControlMessageInfo(String r100, Function1<? super Boolean, Unit> r101);

    void setRenderCacheStringValue(String r100, String r101);

    void setSetSurfaceInterceptor(ISetSurfaceInterceptor r100);

    void setVolumeGain(VolumeGainParams r100);

    void setVrDirectMode(int r100);

    void setupWithConfig(VideoEffectInitConfig r100);

    void smoothSwitchResolution(String r100, int r101);

    void start();

    void startMuteIssueMonitoring(int r100);

    void stop();

    void stopMuteIssueMonitoring();

    void switchResolution(String r100);

    void switchToCellularNetwork(int r100, String r101);

    void switchToDefaultNetwork(int r100, String r101);

    void t0(boolean r100);

    void toggleVr(boolean r100);

    void u0(String r100, String r101);

    void unbindAudioProcessor();

    void updateDisplayMode(DisplayMode r100);

    void updatePicoInfo(JSONObject r100);

    void updateVideoStreamTransmissionStateIfPossible(boolean r100);

    void v0(int r100, int r101);

    void w0();

    void x0(boolean r100);

    boolean y0(String r100, String r101);

    void z0();
}
