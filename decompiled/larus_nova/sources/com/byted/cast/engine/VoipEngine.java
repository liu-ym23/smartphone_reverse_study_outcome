package com.byted.cast.engine;

import android.content.Context;
import android.util.Pair;
import android.view.Surface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.mediacommon.MediaSetting;
import com.byted.cast.sdk.RTCAudioProfile;
import com.byted.cast.sdk.RTCEngine;
import com.byted.cast.sdk.RTCMediaKind;
import com.byted.cast.sdk.RTCScreenProfile;
import com.byted.cast.sdk.RTCSetting;
import com.byted.cast.sdk.RTCVideoProfile;
import com.byted.cast.sdk.render.video.IVideoFrameListener;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.librarian.a;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.heytap.mcssdk.constant.b;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class VoipEngine implements IVideoFrameListener {
    private static final String DefaultContextId = "bytelink_sink";
    public static final int MIRROR_ERROR_LOAD_LIBRARY_FAILED = 211006;
    private static final String TAG = "VoipEngine";
    private static boolean bLibraryLoaded;
    private static final RTCEngine.ConnectState[] mConnectStates = null;
    private static ILibraryLoader sLibraryLoader;
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;
    private OnVoipEngineListener mOnVoipEngineListener;
    private HashMap<Pair<String, RTCMediaKind>, Integer> mPublished;
    private List<VoipVideoRender> mVideoRenders;
    private long mVoipContext;
    private List<OnVoipStreamEventListener> mVoipStreamEventListeners;

    public static class DeviceParams {

        /* JADX INFO: renamed from: app, reason: collision with root package name */
        public String f33723app;
        public String appPackage;
        public String appVersion;
        public String cpuType;
        public String deviceId;
        public String deviceModel;
        public int fps;
        public int height;

        /* JADX INFO: renamed from: os, reason: collision with root package name */
        public String f33724os;
        public String osVersion;
        public String sdkVersion;
        public String timeZone;
        public int width;

        public DeviceParams() {
        }

        public String toString() {
            return "DeviceParams{deviceId='" + this.deviceId + "', sdkVersion='" + this.sdkVersion + "', app='" + this.f33723app + "', appVersion='" + this.appVersion + "', appPackage='" + this.appPackage + "', os='" + this.f33724os + "', osVersion='" + this.osVersion + "', deviceModel='" + this.deviceModel + "', cpuType='" + this.cpuType + "', timeZone='" + this.timeZone + "', width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + '}';
        }
    }

    public interface OnVoipEngineListener {

        /* JADX INFO: renamed from: com.byted.cast.engine.VoipEngine$OnVoipEngineListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCastPortSet(OnVoipEngineListener r100, int r101, int r102, int r103, int r104) {
            }

            public static void $default$onCastPortUnSet(OnVoipEngineListener r100, int r101, int r102, int r103, int r104) {
            }

            public static void $default$onServerStart(OnVoipEngineListener r100, int r101) {
            }

            public static void $default$onServerStop(OnVoipEngineListener r100, int r101) {
            }
        }

        void onAudioFrame(String r100, RTCSetting.ACODEC_ID r101, byte[] r102, long r103);

        void onAudioPcm(String r100, byte[] r101, long r102);

        void onAudioSetVolume(String r100, float r101, float r102);

        void onCancelRequest(String r100);

        void onCancelSuccess();

        void onCastControl(int r100, int r101);

        void onCastPause(RTCMediaKind r100);

        void onCastPortSet(int r100, int r101, int r102, int r103);

        void onCastPortUnSet(int r100, int r101, int r102, int r103);

        boolean onCastRequest(String r100, String r101);

        void onCastResume(RTCMediaKind r100);

        void onCastSuccess();

        void onConnect(String r100, String r101);

        void onConnectStateChanged(RTCEngine.ConnectState r100);

        void onConnectSuccess(int r100, int r101, int r102);

        void onDisconnect(RTCEngine.ExitReason r100, String r101);

        void onDisconnect(String r100, RTCEngine.ExitReason r101, String r102);

        void onError(int r100, String r101);

        void onIdrRequest(RTCMediaKind r100);

        void onLogMonitor(String r100, String[][] r101);

        void onMonitorEvent(String r100, String r101);

        void onNotifyLatency(String r100, Long r101, HashMap<String, Long> r102);

        void onRecvMetaData(String r100);

        void onRecvMetaData(String r100, String r101);

        void onServerStart(int r100);

        void onServerStop(int r100);

        void onSetbitrateRequest(RTCMediaKind r100, int r101);

        void onSinkLatencyStat(String r100, String r101);

        void onSinkStuckStat(String r100, String r101);

        void onStat(String r100);

        void onStuckStat(String r100);

        void onUpdateRtt(int r100);

        void onVideoFrame(String r100, RTCMediaKind r101, int r102, int r103, int r104, boolean r105);

        void onVideoFrame(String r100, RTCSetting.VCODEC_ID r101, byte[] r102, long r103);

        void onVideoSizeChanged(String r100, int r101, int r102);
    }

    public interface OnVoipStreamEventListener {
        void onStreamPublished(String r100, RTCMediaKind r101, int r102);

        void onStreamSubscribed(String r100, RTCMediaKind r101);

        void onStreamUnpublished(String r100, RTCMediaKind r101);

        void onStreamUnsubscribed(String r100, RTCMediaKind r101);
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private native long create(String r100, String r101);

    private native void decodeInput(long r100, String r101, long r102);

    private native void decodeOutput(long r100, String r101, long r102);

    private static native void deinit(String r100);

    private native void destroy(String r100, long r101);

    private static native void dumpMediaData(long r100, int r101, int r102);

    private native int getAudioData(long r100, byte[] r101, int r102, int r103);

    private native String getStatistics(long r100);

    private static native void init(String r100, String r101);

    private native void inputAudioData(long r100, byte[] r101, int r102, int r103, long r104);

    private native void inputSEIData(long r100, String r101, long r102);

    private native void inputScreenData(long r100, byte[] r101, int r102, int r103, int r104, int r105, long r106, int r110, int r111);

    private native void inputVideoData(long r100, byte[] r101, int r102, int r103, int r104, int r105, boolean r106);

    private native void kickOutSource(long r100, String r101);

    private static native void nativeSetFileLogEnabled(String r100, boolean r101);

    private static native void nativeSetLogLevel(String r100, int r101);

    private native void notifyDeviceEvent(long r100, int r101, Object r102, Object r103, Object r104);

    private native void renderFrame(long r100, String r101, long r102);

    private native void sendMetaDataTo(long r100, String r101, String r102);

    private native void setAudioDropPolicyByMs(long r100, int r101, int r102);

    private native void setAudioMaxDelayByMs(long r100, int r101);

    private native void setAudioVolume(long r100, float r101, float r102);

    private native void setPinCode(long r100, String r101);

    private native void setRandomPortEnabled(long r100, boolean r101);

    private static int transLogLevelToNative(int r100) {
        if (r100 != 2) goto L5;
        return 4;
    L5:
        if (r100 != 3) goto L7;
        return 3;
    L7:
        if (r100 != 5) goto L9;
        return 1;
    L9:
        if (r100 != 6) goto L11;
        return 0;
    L11:
        if (r100 == 7) goto L13;
        return 2;
    L13:
        return -1;
    }

    public native void addVideoRender(long r100, long r101);

    public native void castCancel(long r100);

    public native void castRequest(long r100);

    public native void connect(long r100, String r101, int r102, String r103, String r104);

    public native void disconnect(long r100);

    public native void removeVideoRender(long r100, long r101);

    public native void sendMetaData(long r100, String r101);

    public native void setCastToken(long r100, String r101);

    public native void setMediaProfile(long r100, int r101, String r102);

    public native void setTransType(long r100, int r101, int r102);

    public native void setVideoSurface(long r100, String r101, Surface r102);

    static {
        mConnectStates = new RTCEngine.ConnectState[]{RTCEngine.ConnectState.CLOSE, RTCEngine.ConnectState.CONNECTING, RTCEngine.ConnectState.CONNECTED, RTCEngine.ConnectState.CONNECT_FAILED, RTCEngine.ConnectState.DISCONNECTED, RTCEngine.ConnectState.RECONNECTING, RTCEngine.ConnectState.RECONNECTED, RTCEngine.ConnectState.RECONNECT_FAILED, RTCEngine.ConnectState.ERROR};
    }

    private void onCancelSuccess() {
        this.mLogger.i(TAG, "onCancelSuccess");
        OnVoipEngineListener r100 = this.mOnVoipEngineListener;
        if (r100 == null) goto L6;
        r100.onCancelSuccess();
        return;
    }

    private void onCastSuccess() {
        this.mLogger.i(TAG, "onCastSuccess ");
        OnVoipEngineListener r100 = this.mOnVoipEngineListener;
        if (r100 == null) goto L6;
        r100.onCastSuccess();
        return;
    }

    public void castCancel() {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "castCancel voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "CastCancel");
        castCancel(this.mVoipContext);
    }

    public void castRequest() {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "castRequest voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "CastRequest");
        castRequest(this.mVoipContext);
    }

    public void destroy() {
        this.mLogger.i(TAG, MapMonitorConst.EVENT_DESTROY);
        if (bLibraryLoaded == true) goto L6;
        this.mLogger.e(TAG, "destroy: library not loaded");
        this.mVoipContext = -1;
    L12:
        this.mVideoRenders.clear();
        this.mVoipStreamEventListeners.clear();
        return;
    L6:
        if (this.mVoipContext == (-1)) goto L12;
        ContextManager.CastContext r100 = this.mCastContext;
        if (r100 == null) goto L10;
        String r101 = r100.getContextId();
    L11:
        this.mLogger.i(TAG, "real destroy");
        destroy(r101, this.mVoipContext);
        this.mVoipContext = -1;
        goto L12
    L10:
        r101 = DefaultContextId;
        goto L11
    }

    public void disconnect() {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "disconnect voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "disconnect");
        disconnect(this.mVoipContext);
    }

    public String getStatistics() {
        long r100 = this.mVoipContext;
        if (r100 != (-1)) goto L7;
        this.mLogger.w(TAG, "voip engine not inited!");
        return "";
    L7:
        return getStatistics(r100);
    }

    public VoipEngine(ContextManager.CastContext r100) {
        this.mVoipContext = -1;
        this.mVoipStreamEventListeners = new ArrayList();
        this.mVideoRenders = new ArrayList();
        this.mPublished = new HashMap();
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_byted_cast_engine_VoipEngine_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_engine_VoipEngine_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private String createAudioProfile(RTCAudioProfile r100) {
        JSONObject r101 = new JSONObject();
        r101.put("Capturesamplerate", r100.getRecordSampleRate());     // Catch: JSONException -> L6
        r101.put("Playbacksamplerate", r100.getPlaySampleRate());     // Catch: JSONException -> L6
        r101.put("bitrate", r100.getBitrate());     // Catch: JSONException -> L6
        r101.put("maxBitrate", r100.getMaxBitrate());     // Catch: JSONException -> L6
        r101.put("echoDetectionEnable", r100.isEchoDetectionEnabled());     // Catch: JSONException -> L6
        r101.put("aec", r100.getAECType().ordinal());     // Catch: JSONException -> L6
        r101.put("anc", r100.getANCType().ordinal());     // Catch: JSONException -> L6
        r101.put("agc", r100.getAGCType().ordinal());     // Catch: JSONException -> L6
        return r101.toString();
    L6:
        e = move-exception;
        this.mLogger.e(TAG, e.getMessage());
        return null;
    }

    private static JSONObject createDeviceParams(DeviceParams r100) {
        JSONObject r101 = new JSONObject();
        r101.put("deviceId", r100.deviceId);     // Catch: JSONException -> L5
        r101.put(b.C, r100.sdkVersion);     // Catch: JSONException -> L5
        r101.put("app", r100.f33723app);     // Catch: JSONException -> L5
        r101.put("appVersion", r100.appVersion);     // Catch: JSONException -> L5
        r101.put(b.f276355e, r100.appPackage);     // Catch: JSONException -> L5
        r101.put("os", r100.f33724os);     // Catch: JSONException -> L5
        r101.put("osVersion", r100.osVersion);     // Catch: JSONException -> L5
        r101.put("deviceModel", r100.deviceModel);     // Catch: JSONException -> L5
        r101.put("cpuType", r100.cpuType);     // Catch: JSONException -> L5
        r101.put(TimeZoneItemV2.TIME_ZONE, r100.timeZone);     // Catch: JSONException -> L5
        r101.put("width", r100.width);     // Catch: JSONException -> L5
        r101.put("height", r100.height);     // Catch: JSONException -> L5
        r101.put("fps", r100.fps);     // Catch: JSONException -> L5
        return r101;
    L5:
        e = move-exception;
        e.getMessage();
        return null;
    }

    private static String createEngineProfile(RTCSetting r100) {
        JSONObject r101 = new JSONObject();
        r101.put("decodeType", r100.getDecodeType().ordinal());     // Catch: JSONException -> L6
        r101.put("streamType", r100.getStreamType().ordinal());     // Catch: JSONException -> L6
        r101.put("avsyncType", r100.getAVSyncType().ordinal());     // Catch: JSONException -> L6
        r101.put("audioTransType", r100.getAudioTransType().ordinal());     // Catch: JSONException -> L6
        r101.put("videoTransType", r100.getVideoTransType().ordinal());     // Catch: JSONException -> L6
        r101.put("bEnableAudioCallback", r100.isbEnableAudioCallback());     // Catch: JSONException -> L6
        r101.put("bEnableAudioMixer", r100.isbEnableAudioMixer());     // Catch: JSONException -> L6
        r101.put("latencyMs", r100.getLatencyMs());     // Catch: JSONException -> L6
        r101.put("bDecodedByUser", r100.isDecodedByUser());     // Catch: JSONException -> L6
        r101.put("bEnableVideoNativeDecode", r100.isEnableVideoNativeDecode());     // Catch: JSONException -> L6
        return r101.toString();
    L6:
        e = move-exception;
        e.getMessage();
        return null;
    }

    private String createScreenProfile(RTCScreenProfile r100) {
        JSONObject r101 = new JSONObject();
        r101.put("codecId", r100.getCodecId().ordinal());     // Catch: JSONException -> L10
        r101.put("bitrate", r100.getBitrate());     // Catch: JSONException -> L10
        r101.put("maxBitrate", r100.getMaxBitrate());     // Catch: JSONException -> L10
        if (r100.getBitrateMode() != null) goto L6;
        int r102 = 0;
    L7:
        r101.put("bitrateMode", r102);     // Catch: JSONException -> L10
        r101.put("width", r100.getWidth());     // Catch: JSONException -> L10
        r101.put("height", r100.getHeight());     // Catch: JSONException -> L10
        r101.put("fps", r100.getFps());     // Catch: JSONException -> L10
        r101.put("scc", r100.getSccType().ordinal());     // Catch: JSONException -> L10
        r101.put("fixedResolution", r100.isFixedResolution());     // Catch: JSONException -> L10
        return r101.toString();
    L6:
        r102 = r100.getBitrateMode().ordinal();     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        this.mLogger.e(TAG, e.getMessage());
        return null;
    }

    private String createVideoProfile(RTCVideoProfile r100) {
        JSONObject r101 = new JSONObject();
        r101.put("codecId", r100.getCodecId().ordinal());     // Catch: JSONException -> L6
        r101.put("bitrate", r100.getBitrate());     // Catch: JSONException -> L6
        r101.put("maxBitrate", r100.getMaxBitrate());     // Catch: JSONException -> L6
        r101.put("bitrateMode", r100.getBitrateMode().ordinal());     // Catch: JSONException -> L6
        r101.put("ltr", r100.isLtrEnabled());     // Catch: JSONException -> L6
        r101.put(GXTemplateKey.GAIAX_LAYERS, r100.getLayers());     // Catch: JSONException -> L6
        r101.put("fixedResolution", r100.isFixedResolution());     // Catch: JSONException -> L6
        return r101.toString();
    L6:
        e = move-exception;
        this.mLogger.e(TAG, e.getMessage());
        return null;
    }

    public static synchronized void deinitialize(ContextManager.CastContext r100) {
        monitor-enter(VoipEngine.class);
        ContextManager.getLogger(r100).i(TAG, "deinitialize");     // Catch: Throwable -> L15
        if (bLibraryLoaded == true) goto L9;
        ContextManager.getLogger(r100).i(TAG, "deinitialize: library not loaded");     // Catch: Throwable -> L15
        monitor-exit(VoipEngine.class);
        return;
    L9:
        if (r100 == null) goto L11;
        String r101 = r100.getContextId();     // Catch: Throwable -> L15
    L12:
        deinit(r101);     // Catch: Throwable -> L15
        monitor-exit(VoipEngine.class);
        return;
    L11:
        r101 = DefaultContextId;
    L15:
        th = move-exception;
        throw th;
    }

    private static boolean loadLibrary(ContextManager.CastContext r100) {
        if (bLibraryLoaded == false) goto L7;
        ContextManager.getLogger(r100).i(TAG, "loadLibrary: Already loaded");
        return true;
    L7:
        if (loadLibrary("bat") == true) goto L11;
        ContextManager.getLogger(r100).i(TAG, "loadLibrary: bat failed");
        return false;
    L11:
        if (loadLibrary("voip") == true) goto L15;
        ContextManager.getLogger(r100).i(TAG, "loadLibrary: voip failed");
        return false;
    L15:
        if (loadLibrary("bytelink") == true) goto L18;
        ContextManager.getLogger(r100).i(TAG, "loadLibrary: bytelink failed");
        return false;
    L18:
        ContextManager.getLogger(r100).i(TAG, "loadLibrary: success");
        bLibraryLoaded = true;
        return true;
    }

    private void onCancelRequest(String r100) {
        this.mLogger.i(TAG, "onCancelRequest: " + r100);
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onCancelRequest(r100);
        return;
    }

    private void onCastPause(int r100) {
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onCastPause(RTCMediaKind.valueOf(r100));
        return;
    }

    private void onCastResume(int r100) {
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onCastResume(RTCMediaKind.valueOf(r100));
        return;
    }

    private void onConnectStateChanged(int r100) {
        this.mLogger.i(TAG, "onConnectStateChanged: " + r100);
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L9;
        if (r100 < 0) goto L10;
        RTCEngine.ConnectState[] r102 = mConnectStates;
        if (r100 >= r102.length) goto L11;
        r101.onConnectStateChanged(r102[r100]);
        return;
    L11:
        return;
    L10:
        return;
    }

    private void onIdrRequest(int r100) {
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onIdrRequest(RTCMediaKind.valueOf(r100));
        return;
    }

    private void onRecvMetaData(String r100) {
        this.mLogger.d(TAG, "onRecvMetaData: " + r100);
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onRecvMetaData(r100);
        return;
    }

    private void onServerStart(int r100) {
        Objects.toString(this.mOnVoipEngineListener);
        this.mLogger.i(TAG, "onServerStart: " + r100);
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onServerStart(r100);
        return;
    }

    private void onServerStop(int r100) {
        Objects.toString(this.mOnVoipEngineListener);
        this.mLogger.i(TAG, "onServerStop: " + r100);
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onServerStop(r100);
        return;
    }

    private void onStat(String r100) {
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onStat(r100);
        return;
    }

    private void onStuckStat(String r100) {
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onStuckStat(r100);
        return;
    }

    private void onUpdateRtt(int r100) {
        OnVoipEngineListener r101 = this.mOnVoipEngineListener;
        if (r101 == null) goto L6;
        r101.onUpdateRtt(r100);
        return;
    }

    public void addOnVoipStreamEventListener(OnVoipStreamEventListener r100) {
        this.mVoipStreamEventListeners.add(r100);
        Iterator<Map.Entry<Pair<String, RTCMediaKind>, Integer>> r101 = this.mPublished.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<Pair<String, RTCMediaKind>, Integer> r102 = r101.next();
        r100.onStreamPublished((String) r102.getKey().first, (RTCMediaKind) r102.getKey().second, r102.getValue().intValue());
        goto L4
    }

    public void addVideoRender(VoipVideoRender r100) {
        long r101 = this.mVoipContext;
        if (r101 != (-1)) goto L6;
        this.mVideoRenders.add(r100);
        return;
    L6:
        addVideoRender(r101, r100.getRenderContext());
    }

    public boolean create(RTCSetting r100) {
        if (bLibraryLoaded == true) goto L7;
        this.mLogger.e(TAG, "create: library not loaded");
        this.mVoipContext = -1;
        return false;
    L7:
        if (this.mVoipContext == (-1)) goto L10;
        this.mLogger.w(TAG, "already created");
        return false;
    L10:
        String r101 = createEngineProfile(r100);
        this.mLogger.i(TAG, "create: " + r101);
        ContextManager.CastContext r102 = this.mCastContext;
        if (r102 == null) goto L13;
        String r103 = r102.getContextId();
    L14:
        this.mVoipContext = create(r103, r101);
        Iterator<VoipVideoRender> r104 = this.mVideoRenders.iterator();
    L16:
        if (r104.hasNext() == false) goto L18;
        addVideoRender(this.mVoipContext, r104.next().getRenderContext());
        goto L16
    L18:
        return true;
    L13:
        r103 = DefaultContextId;
        goto L14
    }

    public void kickOutSource(String r100) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "kickOutSource voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "KickOutSource: " + r100);
        kickOutSource(this.mVoipContext, r100);
    }

    public void removeOnVoipStreamEventListener(OnVoipStreamEventListener r100) {
        this.mVoipStreamEventListeners.remove(r100);
    }

    public void removeVideoRender(VoipVideoRender r100) {
        long r101 = this.mVoipContext;
        if (r101 != (-1)) goto L6;
        this.mVideoRenders.remove(r100);
        return;
    L6:
        removeVideoRender(r101, r100.getRenderContext());
    }

    public void sendMetaData(String r100) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "sendMetaData voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "sendMetaData");
        sendMetaData(this.mVoipContext, r100);
    }

    public void setAudioMaxDelayByMs(int r100) {
        long r101 = this.mVoipContext;
        if (r101 != (-1)) goto L5;
        return;
    L5:
        setAudioMaxDelayByMs(r101, r100);
    }

    public void setAudioProfile(RTCAudioProfile r100) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "setAudioProfile, voip engine not inited !");
        return;
    L6:
        String r101 = createAudioProfile(r100);
        this.mLogger.i(TAG, "setAudioProfile: " + r101);
        setMediaProfile(this.mVoipContext, RTCMediaKind.AUDIO.value(), r101);
    }

    public void setCastToken(String r100) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "setCastToken voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "setCastToken");
        setCastToken(this.mVoipContext, r100);
    }

    public void setOnVoipEngineListener(OnVoipEngineListener r100) {
        this.mOnVoipEngineListener = r100;
    }

    public void setPinCode(String r100) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "setPinCode voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "SetPinCode: " + r100);
        setPinCode(this.mVoipContext, r100);
    }

    public void setRandomPortEnabled(boolean r100) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "setRandomPortEnabled voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "setRandomPortEnabled:" + r100);
        setRandomPortEnabled(this.mVoipContext, r100);
    }

    public void setScreenProfile(RTCScreenProfile r100) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "setScreenProfile voip engine not inited !");
        return;
    L6:
        String r101 = createScreenProfile(r100);
        this.mLogger.i(TAG, "setScreenProfile: " + r101);
        setMediaProfile(this.mVoipContext, RTCMediaKind.SCREEN.value(), r101);
    }

    public void setVideoProfile(RTCVideoProfile r100) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "setVideoProfile voip engine not inited !");
        return;
    L6:
        String r101 = createVideoProfile(r100);
        this.mLogger.i(TAG, "setVideoProfile: " + r101);
        setMediaProfile(this.mVoipContext, RTCMediaKind.VIDEO.value(), r101);
    }

    private static boolean loadLibrary(String r100) {
        ILibraryLoader r101 = sLibraryLoader;
        if (r101 != null) goto L16;
        INVOKESTATIC_com_byted_cast_engine_VoipEngine_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        th.printStackTrace();
    L12:
        return false;
    L16:
        return r101.loadLibrary(r100);
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    private static String getSysProp(String r100, String r101) {
        Object r102 = INVOKESTATIC_com_byted_cast_engine_VoipEngine_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r100, r101});     // Catch: Throwable -> L7
        if (r102 == null) goto L10;
        return r102.toString();
    L10:
        return r101;
    L11:
        return r101;
    }

    private void onCastControl(int r100, int r101) {
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onCastControl(r100, r101);
        return;
    }

    private boolean onCastRequest(String r100, String r101) {
        this.mLogger.i(TAG, "onCastRequest: " + r100 + " token " + r101);
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 != null) goto L5;
        return true;
    L5:
        return r102.onCastRequest(r100, r101);
    }

    private void onConnect(String r100, String r101) {
        this.mLogger.i(TAG, "onConnect: " + r100);
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onConnect(r100, r101);
        return;
    }

    private void onDisconnect(int r100, String r101) {
        this.mLogger.i(TAG, "onDisconnect: " + r101);
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onDisconnect(RTCEngine.valueOf(r100), r101);
        return;
    }

    private void onError(int r100, String r101) {
        this.mLogger.i(TAG, "onError: " + r100 + ", " + r101);
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onError(r100, r101);
        return;
    }

    private void onLogMonitor(String r100, String[][] r101) {
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onLogMonitor(r100, r101);
        return;
    }

    private void onMonitorEvent(String r100, String r101) {
        this.mLogger.i(TAG, "onMonitorEvent, eventType:" + r100 + ", eventContent:" + r101);
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onMonitorEvent(r100, r101);
        return;
    }

    private void onRecvMetaData(String r100, String r101) {
        this.mLogger.d(TAG, "onRecvMetaData: " + r101 + " from:" + r100);
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onRecvMetaData(r100, r101);
        return;
    }

    private void onSetbitrateRequest(int r100, int r101) {
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onSetbitrateRequest(RTCMediaKind.valueOf(r100), r101);
        return;
    }

    private void onSinkLatencyStat(String r100, String r101) {
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onSinkLatencyStat(r100, r101);
        return;
    }

    private void onSinkStuckStat(String r100, String r101) {
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onSinkStuckStat(r100, r101);
        return;
    }

    public static void setFileLogEnabled(ContextManager.CastContext r100, boolean r101) {
        ContextManager.getLogger(r100).i(TAG, "setFileLogEnabled:" + r101);
        if (loadLibrary(r100) == true) goto L6;
        ContextManager.getLogger(r100).w(TAG, "setFileLogEnabled, loadLibrary failed!");
        return;
    L6:
        if (r100 == null) goto L8;
        String r102 = r100.getContextId();
    L9:
        nativeSetFileLogEnabled(r102, r101);
        return;
    L8:
        r102 = DefaultContextId;
        goto L9
    }

    public static void setLibraryLoader(ContextManager.CastContext r100, ILibraryLoader r101) {
        ContextManager.getLogger(r100).i(TAG, "setLibraryLoader:" + r101);
        sLibraryLoader = r101;
        loadLibrary(r100);
    }

    public static boolean setLogLevel(ContextManager.CastContext r100, int r101) {
        ContextManager.getLogger(r100).i(TAG, "setLogLevel: " + r101);
        if (loadLibrary(r100) == true) goto L6;
        ContextManager.getLogger(r100).w(TAG, "setLogLevel, loadLibrary failed!");
        return false;
    L6:
        if (r100 == null) goto L8;
        String r102 = r100.getContextId();
    L9:
        nativeSetLogLevel(r102, transLogLevelToNative(r101));
        return true;
    L8:
        r102 = DefaultContextId;
        goto L9
    }

    public static void setLogger(ContextManager.CastContext r100, ILogger r101) {
        ContextManager.getLogger(r100).setLogger(r101);
        ContextManager.getLogger(r100).i(TAG, "setLogger:" + r101);
    }

    public void dumpMediaData(int r100, int r101) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.w(TAG, "voip engine not inited!");
        return;
    L6:
        this.mLogger.i(TAG, "dumpMediaData: " + r101 + "s");
        dumpMediaData(this.mVoipContext, r100, r101);
    }

    public void inputSEI(String r110, long r111) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "inputSEI voip engine not inited !");
        return;
    L6:
        if (r110 != null) goto L8;
        return;
    L8:
        if (r110.isEmpty() == true) goto L13;
        this.mLogger.i(TAG, "inputSEI: seiLen=" + r110.length() + " ts=" + r111);
        inputSEIData(this.mVoipContext, r110, r111);
        return;
    }

    @Override // com.byted.cast.sdk.render.video.IVideoFrameListener
    public void onDecodeIn(String r100, long r101) {
        long r102 = this.mVoipContext;
        if (r102 != (-1)) goto L6;
        this.mLogger.v(TAG, "onDecodeIn voip engine not inited !");
        return;
    L6:
        decodeInput(r102, r100, r101);
    }

    @Override // com.byted.cast.sdk.render.video.IVideoFrameListener
    public void onDecoded(String r100, long r101) {
        long r102 = this.mVoipContext;
        if (r102 != (-1)) goto L6;
        this.mLogger.v(TAG, "onDecoded voip engine not inited !");
        return;
    L6:
        decodeOutput(r102, r100, r101);
    }

    @Override // com.byted.cast.sdk.render.video.IVideoFrameListener
    public void onRendered(String r100, long r101) {
        long r102 = this.mVoipContext;
        if (r102 != (-1)) goto L6;
        this.mLogger.v(TAG, "onRendered voip engine not inited !");
        return;
    L6:
        renderFrame(r102, r100, r101);
    }

    public void sendMetaData(String r100, String r101) {
        long r102 = this.mVoipContext;
        if (r102 != (-1)) goto L6;
        this.mLogger.v(TAG, "sendMetaData voip engine not inited !");
        return;
    L6:
        sendMetaDataTo(r102, r100, r101);
    }

    public void setAudioDropPolicyByMs(int r100, int r101) {
        long r102 = this.mVoipContext;
        if (r102 != (-1)) goto L5;
        return;
    L5:
        setAudioDropPolicyByMs(r102, r100, r101);
    }

    public void setAudioVolume(float r100, float r101) {
        long r102 = this.mVoipContext;
        if (r102 != (-1)) goto L6;
        this.mLogger.v(TAG, "setAudioVolume voip engine not inited !");
        return;
    L6:
        setAudioVolume(r102, r100, r101);
    }

    public void setTransType(RTCSetting.TRANS_TYPE r100, RTCSetting.TRANS_TYPE r101) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "setTransType voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "setTransType audio: " + r100.toString() + " video: " + r101.toString());
        setTransType(this.mVoipContext, r100.ordinal(), r101.ordinal());
    }

    public void setVideoSurface(String r100, Surface r101) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "setVideoSurface voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "setVideoSurface: " + r101);
        setVideoSurface(this.mVoipContext, r100, r101);
    }

    private void onAudioPcm(String r100, byte[] r101, long r102) {
        OnVoipEngineListener r103 = this.mOnVoipEngineListener;
        if (r103 == null) goto L6;
        r103.onAudioPcm(r100, r101, r102);
        return;
    }

    private void onAudioSetVolume(String r100, float r101, float r102) {
        this.mLogger.i(TAG, "onAudioSetVolume: ratio=" + r101 + " volume=" + r102);
        OnVoipEngineListener r103 = this.mOnVoipEngineListener;
        if (r103 == null) goto L6;
        r103.onAudioSetVolume(r100, r101, r102);
        return;
    }

    private void onConnectSuccess(int r100, int r101, int r102) {
        this.mLogger.i(TAG, "onConnectSuccess ");
        OnVoipEngineListener r103 = this.mOnVoipEngineListener;
        if (r103 == null) goto L6;
        r103.onConnectSuccess(r100, r101, r102);
        return;
    }

    private void onDisconnect(String r100, int r101, String r102) {
        this.mLogger.i(TAG, "onDisconnect: " + r100 + " " + r102);
        OnVoipEngineListener r103 = this.mOnVoipEngineListener;
        if (r103 == null) goto L6;
        r103.onDisconnect(r100, RTCEngine.valueOf(r101), r102);
        return;
    }

    private void onNotifyLatency(String r100, long r101, HashMap<String, Long> r102) {
        OnVoipEngineListener r103 = this.mOnVoipEngineListener;
        if (r103 == null) goto L6;
        r103.onNotifyLatency(r100, Long.valueOf(r101), r102);
        return;
    }

    private void onVideoSizeChanged(String r100, int r101, int r102) {
        OnVoipEngineListener r103 = this.mOnVoipEngineListener;
        if (r103 == null) goto L6;
        r103.onVideoSizeChanged(r100, r101, r102);
        return;
    }

    public int readRemoteAudioFrame(byte[] r100, int r101, int r102) {
        long r103 = this.mVoipContext;
        if (r103 != (-1)) goto L7;
        this.mLogger.v(TAG, "readRemoteAudioFrame voip engine not inited !");
        return -1;
    L7:
        return getAudioData(r103, r100, r101, r102);
    }

    private void onAudioFrame(String r100, int r101, byte[] r102, long r110) {
        OnVoipEngineListener r103 = this.mOnVoipEngineListener;
        if (r103 == null) goto L6;
        r103.onAudioFrame(r100, RTCSetting.valueOfAudio(r101), r102, r110);
        return;
    }

    private void onCastPortSet(int r100, int r101, int r102, int r103) {
        Objects.toString(this.mOnVoipEngineListener);
        this.mLogger.i(TAG, "onCastPortSet: video_chan " + r100 + " video_port " + r101 + " audio_chan " + r102 + " audio_port " + r103);
        OnVoipEngineListener r104 = this.mOnVoipEngineListener;
        if (r104 == null) goto L6;
        r104.onCastPortSet(r100, r101, r102, r103);
        return;
    }

    private void onCastPortUnSet(int r100, int r101, int r102, int r103) {
        Objects.toString(this.mOnVoipEngineListener);
        this.mLogger.i(TAG, "onCastPortUnSet: video_chan " + r100 + " video_port " + r101 + " audio_chan " + r102 + " audio_port " + r103);
        OnVoipEngineListener r104 = this.mOnVoipEngineListener;
        if (r104 == null) goto L6;
        r104.onCastPortUnSet(r100, r101, r102, r103);
        return;
    }

    private void onVideoFrame(String r100, int r101, byte[] r102, long r110) {
        OnVoipEngineListener r103 = this.mOnVoipEngineListener;
        if (r103 == null) goto L6;
        r103.onVideoFrame(r100, RTCSetting.valueOfVideo(r101), r102, r110);
        return;
    }

    public void connect(String r100, int r101, String r110, String r111) {
        if (this.mVoipContext != (-1)) goto L6;
        this.mLogger.v(TAG, "connect voip engine not inited !");
        return;
    L6:
        this.mLogger.i(TAG, "connect: " + r100 + " : " + r101);
        connect(this.mVoipContext, r100, r101, r110, r111);
    }

    public void inputAudioFrame(byte[] r100, int r110, MediaSetting.ACODEC_ID r111, long r112) {
        long r101 = this.mVoipContext;
        if (r101 != (-1)) goto L6;
        this.mLogger.v(TAG, "inputAudioFrame voip engine not inited !");
        return;
    L6:
        inputAudioData(r101, r100, r110, r111.ordinal(), r112);
    }

    public void notifyDeviceEvent(int r110, Object r111, Object r112, Object r113) {
        if (this.mVoipContext != (-1)) goto L5;
        return;
    L5:
        this.mLogger.v(TAG, "notifyDeviceEvent: " + r110);
        notifyDeviceEvent(this.mVoipContext, r110, r111, r112, r113);
    }

    private void onVideoEvent(String r100, int r101, int r110, int r111, int r112, boolean r113) {
        OnVoipEngineListener r102 = this.mOnVoipEngineListener;
        if (r102 == null) goto L6;
        r102.onVideoFrame(r100, RTCMediaKind.valueOf(r101), r110, r111, r112, r113);
        return;
    }

    public void inputVideoFrame(byte[] r110, int r111, int r112, MediaSetting.VideoFormat r113, int r114, boolean r115) {
        long r100 = this.mVoipContext;
        if (r100 != (-1)) goto L6;
        this.mLogger.v(TAG, "inputVideoFrame voip engine not inited !");
        return;
    L6:
        inputVideoData(r100, r110, r111, r112, r113.ordinal(), r114, r115);
    }

    public static void initialize(Context r100, ContextManager.CastContext r101, RTCEngine.RuntimeEnv r110, DeviceParams r111, String r112, int r113, boolean r114) {
        initialize(r100, r101, r110, r111, r112, "", r113, r114);
    }

    private static String createSystemProfile(RTCEngine.RuntimeEnv r100, DeviceParams r110, String r111, String r112, String r113, int r114, boolean r115, boolean r116) {
        return createSystemProfile(r100, r110, r111, r112, r113, r114, r115, r116, false);
    }

    public static synchronized void initialize(Context r110, ContextManager.CastContext r111, RTCEngine.RuntimeEnv r112, DeviceParams r113, String r114, String r115, int r116, boolean r117) {
        monitor-enter(VoipEngine.class);
        initialize(r110, r111, r112, r113, r114, r115, r116, r117, true);     // Catch: Throwable -> L8
        monitor-exit(VoipEngine.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void inputScreenFrame(byte[] r110, int r111, int r112, int r113, MediaSetting.VideoFormat r114, long r210, int r211, int r212) {
        if (this.mVoipContext != (-1)) goto L7;
        this.mLogger.v(TAG, "inputScreenFrame voip engine not inited !");
        return;
    L7:
        if (r212 != 1) goto L10;
        this.mLogger.i(TAG, "inputScreenFrame: " + r111 + " " + r112 + "x" + r113 + ", format = " + r114 + ", rotation = " + r211 + ", timestamp:" + r210);
    L10:
        inputScreenData(this.mVoipContext, r110, r111, r112, r113, r114.ordinal(), r210, r211, r212);
    }

    private static String createSystemProfile(RTCEngine.RuntimeEnv r100, DeviceParams r101, String r102, String r103, String r104, int r105, boolean r110, boolean r111, boolean r112) {
        JSONObject r106 = new JSONObject();
        r106.put("env", r100.ordinal());     // Catch: JSONException -> L10
        r106.put("device", createDeviceParams(r101));     // Catch: JSONException -> L10
        r106.put("documentPath", r102);     // Catch: JSONException -> L10
        r106.put("mediaServerAddr", "");     // Catch: JSONException -> L10
        r106.put("castSourceOnly", r110);     // Catch: JSONException -> L10
        r106.put("name", r103);     // Catch: JSONException -> L10
        r106.put("localPort", r105);     // Catch: JSONException -> L10
        r106.put("localIP", r104);     // Catch: JSONException -> L10
        r106.put("useUdpPath", r111);     // Catch: JSONException -> L10
        r106.put("useMoq", false);     // Catch: JSONException -> L10
        r106.put("omniAppId", "");     // Catch: JSONException -> L10
        r106.put("omniBusinessId", "");     // Catch: JSONException -> L10
        StringBuilder r107 = new StringBuilder("uid_");     // Catch: JSONException -> L10
        if (r101 == null) goto L6;
        String r108 = r101.deviceId;     // Catch: JSONException -> L10
    L7:
        r107.append(r108);     // Catch: JSONException -> L10
        r106.put("omniUid", getSysProp("debug.bytecast.omniUid", r107.toString()));     // Catch: JSONException -> L10
        r106.put("omniRoomId", getSysProp("debug.bytecast.omniRoomId", "bytecast_moq_room"));     // Catch: JSONException -> L10
        r106.put("omniParameters", "");     // Catch: JSONException -> L10
        r106.put("randomPortEnabled", r112);     // Catch: JSONException -> L10
        return r106.toString();
    L6:
        r108 = "unknown";
    L10:
        e = move-exception;
        e.getMessage();
        return null;
    }

    public static synchronized void initialize(Context r110, ContextManager.CastContext r111, RTCEngine.RuntimeEnv r112, DeviceParams r113, String r114, String r115, int r116, boolean r117, boolean r210) {
        monitor-enter(VoipEngine.class);
        initialize(r110, r111, r112, r113, r114, r115, r116, r117, r210, false);     // Catch: Throwable -> L8
        monitor-exit(VoipEngine.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void initialize(Context r110, ContextManager.CastContext r111, RTCEngine.RuntimeEnv r112, DeviceParams r113, String r114, String r115, int r116, boolean r210, boolean r211, boolean r212) {
        monitor-enter(VoipEngine.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (loadLibrary(r111) == true) goto L8;
        monitor-exit(VoipEngine.class);
        return;
    L8:
        String r100 = createSystemProfile(r112, r113, r110.getExternalFilesDir(null) + "/bytelink/", r114, r115, r116, r210, r211, r212);     // Catch: Throwable -> L15
        ContextManager.getLogger(r111).i(TAG, "initialize: profile = " + r100);     // Catch: Throwable -> L15
        if (r111 == null) goto L11;
        String r101 = r111.getContextId();     // Catch: Throwable -> L15
    L12:
        init(r101, r100);     // Catch: Throwable -> L15
        monitor-exit(VoipEngine.class);
        return;
    L11:
        r101 = DefaultContextId;
        goto L12
    }
}
