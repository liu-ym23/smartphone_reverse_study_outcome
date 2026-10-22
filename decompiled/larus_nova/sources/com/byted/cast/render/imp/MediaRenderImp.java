package com.byted.cast.render.imp;

import android.content.Context;
import android.os.Build;
import android.view.Surface;
import com.byted.cast.common.CastLogger;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.mediacommon.AudioProfile;
import com.byted.cast.mediacommon.MediaMonitor;
import com.byted.cast.mediacommon.render.IAudioFrameListener;
import com.byted.cast.mediacommon.render.ILatencyListener;
import com.byted.cast.mediacommon.render.IVideoFrameListener;
import com.byted.cast.mediacommon.render.MediaRenderState;
import com.byted.cast.mediacommon.render.parameters.AudioParameter;
import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.byted.cast.mediacommon.render.parameters.MediaParameter;
import com.byted.cast.mediacommon.render.parameters.VideoParameter;
import com.byted.cast.render.datasource.UrlDataSource;
import com.byted.cast.render.decoder.IMediaDecoder;
import com.byted.cast.render.decoder.MediaCodecDecoder;
import com.byted.cast.render.decoder.NativeVideoDecoder;
import com.byted.cast.render.jitterbuffer.AudioJitterBuffer;
import com.byted.cast.render.jitterbuffer.VideoJitterBuffer;
import com.byted.cast.render.parser.AVParser;
import com.byted.cast.render.render.audio.AudioTrackRender;
import com.byted.cast.render.render.audio.IAudioRender;
import com.byted.cast.render.render.video.IVideoRender;
import com.byted.cast.render.render.video.NativeRender;
import com.byted.cast.render.utils.Dump;
import com.byted.cast.render.utils.LatencyControl;
import com.byted.cast.render.utils.Logger;
import com.byted.cast.render.utils.Utils;
import com.bytedance.librarian.a;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.ttvecamera.TECameraUtils;
import java.io.File;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class MediaRenderImp {
    private static int instances;
    private final int MaxDumpFrames;
    private String TAG;
    private final HashMap<Integer, IMediaDecoder> audioDecoders;
    private File audioEnableFile;
    private IAudioFrameListener audioFrameListener;
    private AudioJitterBuffer audioJitterBuffer;
    private int audioJitterBufferDelayMs;
    private AudioJitterBuffer.JITTER_MODE audioJitterBufferMode;
    private final LatencyControl audioLatencyControl;
    private final HashMap<Integer, AudioParameter> audioParameters;
    private IAudioRender audioRender;
    AVParser avParser;
    private int bitRate;
    private int bitWidth;
    private int channels;
    private CodecId codecId;
    private int curDumpFrames;
    private final String deviceName;
    private final Dump dumpAudio;
    private File dumpEnableFile;
    private final Dump dumpFrame;
    private final Dump dumpPacket;
    private final Dump dumpPcm;
    private File ffmpegEnableFile;
    private int frameSize;
    private float gain;
    private int height;
    private boolean isOpenDumpAudio;
    private boolean isOpenDumpFrame;
    private boolean isOpenJitterBuffer;
    private boolean isPlayAudio;
    private boolean isUseVideoNativeDecoder;
    private boolean isUseVideoRender;
    private CastLogger mCastLogger;
    private Context mContext;
    private int renderColorFormat;
    private String renderDumpPath;
    private File renderEnableFile;
    private int sampleRate;
    private int sliceHeight;
    private int stride;
    private Surface surface;
    private UrlDataSource urlDataSource;
    private final String userId;
    private int vaildAudioFramesIndex;
    private int vaildVideoFramesIndex;
    private IMediaDecoder videoDecoder;
    private IVideoFrameListener videoFrameListener;
    private VideoJitterBuffer videoJitterBuffer;
    private int videoJitterBufferDelayMs;
    private VideoJitterBuffer.JITTER_MODE videoJitterBufferMode;
    private final LatencyControl videoLatencyControl;
    private VideoParameter videoParameter;
    private IVideoRender videoRender;
    private int width;

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    private void initAudioJitterBuffer() {
        AudioJitterBuffer r100 = new AudioJitterBuffer();
        this.audioJitterBuffer = r100;
        r100.setJitterCallback(new AnonymousClass2(this)).setAudioFormat(this.sampleRate, this.channels, this.bitWidth / 8);
        this.audioJitterBuffer.setJitterMode(this.audioJitterBufferMode);
        this.audioJitterBuffer.setJitterPrefetchSize((((((this.audioJitterBufferDelayMs * this.channels) * (this.bitWidth / 8)) * this.sampleRate) / 1000) / this.frameSize) + 1);
        this.audioJitterBuffer.setVideoJitterBuffer(this.videoJitterBuffer);
        VideoJitterBuffer r101 = this.videoJitterBuffer;
        if (r101 == null) goto L6;
        r101.setAudioJitterBuffer(this.audioJitterBuffer);
        return;
    }

    private void initVideoDecoder() {
        VideoParameter r100 = this.videoParameter;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.isUseVideoNativeDecoder == false) goto L8;
        this.videoDecoder = new NativeVideoDecoder(this.userId, r100.codecId);
    L10:
        if (this.isUseVideoRender == false) goto L12;
    L14:
        this.videoDecoder.setMediaDecoderListener(new AnonymousClass3(this));
        return;
    L12:
        if (this.isUseVideoNativeDecoder == true) goto L14;
        ((MediaCodecDecoder) this.videoDecoder).setSurface(this.surface);
        goto L14
    L8:
        MediaCodecDecoder r101 = new MediaCodecDecoder(this.userId, r100.codecId).setVideoJitterBuffer(this.videoJitterBuffer);
        VideoParameter r102 = this.videoParameter;
        this.videoDecoder = r101.config_video_parameters(r102.width, r102.height, r102.fps);
        goto L10
    }

    private void initVideoJitterBuffer() {
        Logger.d(this.TAG, "initVideoJitterBuffer audioJitterBuffer = " + this.audioJitterBuffer);
        Logger.d(this.TAG, "initVideoJitterBuffer videoJitterBufferMode = " + this.videoJitterBufferMode);
        VideoJitterBuffer r100 = new VideoJitterBuffer();
        this.videoJitterBuffer = r100;
        r100.setAudioJitterBuffer(this.audioJitterBuffer);
        this.videoJitterBuffer.setJitterMode(this.videoJitterBufferMode);
        this.videoJitterBuffer.setJitterCallback(new AnonymousClass1(this));
        this.videoJitterBuffer.setJitterDelay(this.videoJitterBufferDelayMs);
        AudioJitterBuffer r101 = this.audioJitterBuffer;
        if (r101 == null) goto L6;
        r101.setVideoJitterBuffer(this.videoJitterBuffer);
        return;
    }

    private void startAudioRender() {
        AudioTrackRender r100 = new AudioTrackRender(this.userId);
        this.audioRender = r100;
        r100.config_audio_parameters(this.sampleRate, this.channels, this.bitWidth);
        this.audioRender.start();
    }

    private void startVideoRender() {
        NativeRender r100 = new NativeRender(this.userId, this.deviceName, Build.VERSION.SDK_INT);
        this.videoRender = r100;
        r100.config_video_parameters(this.width, this.height, this.stride, this.sliceHeight, this.renderColorFormat);
        this.videoRender.setSurface(this.surface);
        String r101 = this.renderDumpPath;
        if (r101 == null) goto L5;
        this.videoRender.setDumpPath(r101);
        this.videoRender.isOpenDump(this.isOpenDumpFrame);
    L5:
        this.videoRender.start();
    }

    public void stopUrl() {
        UrlDataSource r100 = this.urlDataSource;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        this.urlDataSource = null;
    }

    public MediaRenderImp(String r100) {
        this.TAG = "MediaRenderImp";
        this.avParser = null;
        this.audioDecoders = new HashMap();
        this.audioJitterBuffer = null;
        this.videoJitterBuffer = null;
        this.audioRender = null;
        this.videoRender = null;
        this.isUseVideoRender = false;
        this.isUseVideoNativeDecoder = false;
        this.surface = null;
        this.channels = 2;
        this.sampleRate = 48000;
        this.bitWidth = 16;
        this.bitRate = 64;
        this.frameSize = 4096;
        this.codecId = CodecId.AACLC;
        this.width = TECameraUtils.CAPTURE_NORMAL;
        this.height = 1080;
        this.stride = TECameraUtils.CAPTURE_NORMAL;
        this.sliceHeight = 1080;
        this.renderColorFormat = 19;
        this.audioParameters = new HashMap();
        this.videoFrameListener = null;
        this.audioFrameListener = null;
        this.vaildVideoFramesIndex = 0;
        this.vaildAudioFramesIndex = 0;
        this.isPlayAudio = true;
        this.gain = 1.0f;
        this.isOpenJitterBuffer = true;
        this.videoJitterBufferDelayMs = 100;
        this.audioJitterBufferDelayMs = 150;
        this.videoJitterBufferMode = VideoJitterBuffer.JITTER_MODE.QUALITY_STATIC_MODE;
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.QUALITY_STATIC_MODE;
        this.dumpPacket = new Dump();
        this.dumpFrame = new Dump();
        this.dumpAudio = new Dump();
        this.dumpPcm = new Dump();
        this.dumpEnableFile = null;
        this.ffmpegEnableFile = null;
        this.renderEnableFile = null;
        this.audioEnableFile = null;
        this.isOpenDumpFrame = false;
        this.isOpenDumpAudio = false;
        this.MaxDumpFrames = 50;
        this.curDumpFrames = 0;
        this.mContext = null;
        this.mCastLogger = null;
        this.urlDataSource = null;
        this.userId = r100;
        this.TAG += HTTP.URL_DEFAULT + r100;
        this.videoLatencyControl = new LatencyControl(r100, "video");
        this.audioLatencyControl = new LatencyControl(r100, "audio");
        String r101 = Utils.getProperty("ro.product.name", "");
        this.deviceName = r101;
        if (instances > 0) goto L5;
    L22:
        Logger.i(this.TAG, "Create MediaRenderImp success, userId: " + r100);
        return;
    L5:
        if (r101.equals("VIDAA_TV") == false) goto L7;
    L16:
        this.isUseVideoRender = true;
    L18:
        if (r101.equals("dredd") == false) goto L20;
    L21:
        this.isUseVideoNativeDecoder = true;
        goto L22
    L20:
        if (r101.equals("HiTV-M1") == false) goto L22;
    L7:
        if (r101.equals("KKHi3751V563") == true) goto L16;
        if (r101.equals("aosp_arbutus") == true) goto L16;
        if (r101.equals("xmen") == true) goto L16;
        if (r101.equals("aosp_pitaya") == true) goto L16;
        if (r101.equals("PD2183") == false) goto L18;
        goto L16
    }

    @JvmStatic
    public static void INVOKESTATIC_com_byted_cast_render_imp_MediaRenderImp_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static /* synthetic */ IMediaDecoder access$000(MediaRenderImp r100) {
        return r100.videoDecoder;
    }

    public static /* synthetic */ LatencyControl access$100(MediaRenderImp r100) {
        return r100.videoLatencyControl;
    }

    public static /* synthetic */ boolean access$1000(MediaRenderImp r100) {
        return r100.isUseVideoNativeDecoder;
    }

    public static /* synthetic */ IVideoRender access$1100(MediaRenderImp r100) {
        return r100.videoRender;
    }

    public static /* synthetic */ int access$1200(MediaRenderImp r100) {
        return r100.width;
    }

    public static /* synthetic */ int access$1300(MediaRenderImp r100) {
        return r100.height;
    }

    public static /* synthetic */ int access$1400(MediaRenderImp r100) {
        return r100.stride;
    }

    public static /* synthetic */ String access$1600(MediaRenderImp r100) {
        return r100.userId;
    }

    public static /* synthetic */ String access$1800(MediaRenderImp r100) {
        return r100.deviceName;
    }

    public static /* synthetic */ IVideoFrameListener access$1900(MediaRenderImp r100) {
        return r100.videoFrameListener;
    }

    public static /* synthetic */ IAudioRender access$200(MediaRenderImp r100) {
        return r100.audioRender;
    }

    public static /* synthetic */ void access$2000(MediaRenderImp r100) {
        r100.startVideoRender();
    }

    public static /* synthetic */ boolean access$2100(MediaRenderImp r100) {
        return r100.isOpenDumpAudio;
    }

    public static /* synthetic */ Dump access$2200(MediaRenderImp r100) {
        return r100.dumpPcm;
    }

    public static /* synthetic */ AudioJitterBuffer access$2300(MediaRenderImp r100) {
        return r100.audioJitterBuffer;
    }

    public static /* synthetic */ IAudioFrameListener access$2400(MediaRenderImp r100) {
        return r100.audioFrameListener;
    }

    public static /* synthetic */ int access$2500(MediaRenderImp r100) {
        return r100.sampleRate;
    }

    public static /* synthetic */ int access$2600(MediaRenderImp r100) {
        return r100.channels;
    }

    public static /* synthetic */ int access$2700(MediaRenderImp r100) {
        return r100.bitWidth;
    }

    public static /* synthetic */ int access$2800(MediaRenderImp r100) {
        return r100.bitRate;
    }

    public static /* synthetic */ void access$300(MediaRenderImp r100) {
        r100.startAudioRender();
    }

    public static /* synthetic */ LatencyControl access$400(MediaRenderImp r100) {
        return r100.audioLatencyControl;
    }

    public static /* synthetic */ boolean access$500(MediaRenderImp r100) {
        return r100.isOpenDumpFrame;
    }

    public static /* synthetic */ Dump access$600(MediaRenderImp r100) {
        return r100.dumpFrame;
    }

    public static /* synthetic */ int access$700(MediaRenderImp r100) {
        return r100.curDumpFrames;
    }

    public static /* synthetic */ int access$708(MediaRenderImp r100) {
        int r101 = r100.curDumpFrames;
        r100.curDumpFrames = r101 + 1;
        return r101;
    }

    public static /* synthetic */ String access$800(MediaRenderImp r100) {
        return r100.TAG;
    }

    public static /* synthetic */ boolean access$900(MediaRenderImp r100) {
        return r100.isUseVideoRender;
    }

    private IMediaDecoder createAudioDecoder(final int r100) {
        if (this.audioParameters.containsKey(Integer.valueOf(r100)) == true) goto L5;
        return null;
    L5:
        AudioParameter r101 = this.audioParameters.get(Integer.valueOf(r100));
        if (r101 != null) goto L8;
        return null;
    L8:
        MediaCodecDecoder r102 = new MediaCodecDecoder(this.userId + ":" + r100, r101.codecId).config_audio_parameters(r101.sampleRate, r101.channels, r101.bitWidth, r101.frameSize);
        r102.setMediaDecoderListener(new AnonymousClass4(this, r100));
        return r102;
    }

    public MediaRenderState getAudioState(int r100) {
        if (this.audioDecoders.containsKey(Integer.valueOf(r100)) == true) goto L7;
        return MediaRenderState.STATE_UNINITIALIZED;
    L7:
        return this.audioDecoders.get(Integer.valueOf(r100)).getState();
    }

    public Object getParameter(MediaParameter r100) {
        if (r100 != MediaParameter.Audio_Render_BitWidth) goto L7;
        return Integer.valueOf(this.bitWidth);
    L7:
        if (r100 != MediaParameter.Audio_Render_SampleRate) goto L11;
        return Integer.valueOf(this.sampleRate);
    L11:
        if (r100 != MediaParameter.Audio_Render_Channel) goto L15;
        return Integer.valueOf(this.channels);
    L15:
        if (r100 != MediaParameter.Audio_Render_SessionId) goto L21;
        IAudioRender r101 = this.audioRender;
        if (r101 != null) goto L19;
        return null;
    L19:
        return ((AudioTrackRender) r101).getParameter(r100);
    L21:
        if (r100 != MediaParameter.Audio_IsAutoPlay) goto L25;
        return Boolean.valueOf(this.isPlayAudio);
    L25:
        if (r100 != MediaParameter.Video_Decoder_IsSetSurface) goto L33;
        if (this.surface == null) goto L29;
        boolean r102 = true;
    L31:
        return Boolean.valueOf(r102);
    L29:
        r102 = false;
        goto L31
    L33:
        if (r100 != MediaParameter.Audio_Render_volume) goto L37;
        return Float.valueOf(this.gain);
    L37:
        if (r100 != MediaParameter.Audio_Render_max_vol) goto L43;
        IAudioRender r103 = this.audioRender;
        if (r103 != null) goto L41;
        return null;
    L41:
        return Float.valueOf(r103.getMaxVol());
    L43:
        if (r100 != MediaParameter.Audio_Render_min_vol) goto L49;
        IAudioRender r104 = this.audioRender;
        if (r104 != null) goto L47;
        return null;
    L47:
        return Float.valueOf(r104.getMinVol());
    L49:
        if (r100 == MediaParameter.Render_IsUseSoftDecoder) goto L51;
        Logger.e(this.TAG, "setParameter key not found! key: " + r100);
        return null;
    L51:
        return Boolean.valueOf(this.isUseVideoNativeDecoder);
    }

    public MediaRenderState getVideoState(int r100) {
        IMediaDecoder r101 = this.videoDecoder;
        if (r101 != null) goto L7;
        return MediaRenderState.STATE_UNINITIALIZED;
    L7:
        return r101.getState();
    }

    public void sendAVStream(byte[] r100) {
        AVParser r101 = this.avParser;
        if (r101 == null) goto L6;
        r101.sendStream(r100);
        return;
    }

    public void setAudioFrameListener(IAudioFrameListener r100) {
        this.audioFrameListener = r100;
    }

    public void setVideoFrameListener(IVideoFrameListener r100) {
        this.videoFrameListener = r100;
    }

    public boolean startAudioPlayer(int r100) {
        if (this.audioDecoders.containsKey(Integer.valueOf(r100)) == true) goto L11;
        IMediaDecoder r101 = createAudioDecoder(r100);
        if (this.audioDecoders.isEmpty() == true) goto L7;
    L10:
        this.audioDecoders.put(Integer.valueOf(r100), r101);
    L12:
        if (r101 == null) goto L14;
        r101.start();
    L14:
        AudioJitterBuffer r102 = this.audioJitterBuffer;
        if (r102 == null) goto L23;
        r102.start();
    L23:
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L19
        r103.put("userId", this.userId);     // Catch: JSONException -> L19
        r103.put("result", "succ");     // Catch: JSONException -> L19
        MediaMonitor.onSinkMonitor("MediaRender_StartAudioPlayer", r103.toString());     // Catch: JSONException -> L19
    L21:
        Logger.i(this.TAG, "audioPlayer start success");
        return true;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L7:
        if (this.isOpenJitterBuffer == false) goto L9;
        initAudioJitterBuffer();
    L9:
        startAudioRender();
        goto L10
    L11:
        r101 = this.audioDecoders.get(Integer.valueOf(r100));
        goto L12
    }

    public boolean startVideoPlayer(int r100) {
        if (this.isOpenJitterBuffer == true) goto L5;
    L7:
        initVideoDecoder();
        VideoJitterBuffer r101 = this.videoJitterBuffer;
        if (r101 == null) goto L10;
        r101.start();
    L10:
        IMediaDecoder r102 = this.videoDecoder;
        if (r102 == null) goto L13;
        r102.start();
    L13:
        instances++;
        Logger.i(this.TAG, "videoPlayer start success");
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L16
        r103.put("userId", this.userId);     // Catch: JSONException -> L16
        r103.put("result", "succ");     // Catch: JSONException -> L16
        MediaMonitor.onSinkMonitor("MediaRender_StartVideoPlayer", r103.toString());     // Catch: JSONException -> L16
    L18:
        return true;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L5:
        if (this.videoJitterBuffer != null) goto L7;
        initVideoJitterBuffer();
        goto L7
    }

    public boolean stopAudioPlayer(int r100) {
        Logger.i(this.TAG, "AudioPlayer stop");
        if (this.audioDecoders.containsKey(Integer.valueOf(r100)) == true) goto L11;
        Logger.e(this.TAG, "AudioPlayer is not exist, id: " + r100);
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L7
        r101.put("userId", this.userId);     // Catch: JSONException -> L7
        r101.put("result", "failed");     // Catch: JSONException -> L7
        MediaMonitor.onSinkMonitor("MediaRender_StopAudioPlayer", r101.toString());     // Catch: JSONException -> L7
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    L11:
        IMediaDecoder r102 = this.audioDecoders.get(Integer.valueOf(r100));
        if (r102 == null) goto L14;
        r102.stop();
    L14:
        this.audioDecoders.remove(Integer.valueOf(r100));
        this.audioParameters.remove(Integer.valueOf(r100));
        if (this.audioDecoders.isEmpty() == false) goto L30;
        AudioJitterBuffer r103 = this.audioJitterBuffer;
        if (r103 == null) goto L19;
        r103.stop();
        this.audioJitterBuffer = null;
    L19:
        IAudioRender r104 = this.audioRender;
        if (r104 == null) goto L30;
        r104.stop();
        this.audioRender = null;
    L30:
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L24
        r105.put("userId", this.userId);     // Catch: JSONException -> L24
        r105.put("result", "succ");     // Catch: JSONException -> L24
        MediaMonitor.onSinkMonitor("MediaRender_StopAudioPlayer", r105.toString());     // Catch: JSONException -> L24
    L26:
        Logger.i(this.TAG, "AudioPlayer stop success");
        return true;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public boolean stopVideoPlayer(int r100) {
        Logger.i(this.TAG, "VideoPlayer stop");
        IVideoRender r101 = this.videoRender;
        if (r101 == null) goto L5;
        r101.stop();
        this.videoRender = null;
    L5:
        IMediaDecoder r102 = this.videoDecoder;
        if (r102 == null) goto L8;
        r102.stop();
    L8:
        VideoJitterBuffer r103 = this.videoJitterBuffer;
        if (r103 == null) goto L11;
        r103.stop();
    L11:
        this.avParser = null;
        this.videoDecoder = null;
        this.videoJitterBuffer = null;
        this.videoParameter = null;
        instances--;
        Logger.i(this.TAG, "VideoPlayer stop success");
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L14
        r104.put("userId", this.userId);     // Catch: JSONException -> L14
        r104.put("result", "succ");     // Catch: JSONException -> L14
        MediaMonitor.onSinkMonitor("MediaRender_StopVideoPlayer", r104.toString());     // Catch: JSONException -> L14
    L16:
        return true;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static /* synthetic */ IVideoRender access$1102(MediaRenderImp r100, IVideoRender r101) {
        r100.videoRender = r101;
        return r101;
    }

    public static /* synthetic */ int access$1202(MediaRenderImp r100, int r101) {
        r100.width = r101;
        return r101;
    }

    public static /* synthetic */ int access$1302(MediaRenderImp r100, int r101) {
        r100.height = r101;
        return r101;
    }

    public static /* synthetic */ int access$1402(MediaRenderImp r100, int r101) {
        r100.stride = r101;
        return r101;
    }

    public static /* synthetic */ int access$1502(MediaRenderImp r100, int r101) {
        r100.sliceHeight = r101;
        return r101;
    }

    public static /* synthetic */ int access$1702(MediaRenderImp r100, int r101) {
        r100.renderColorFormat = r101;
        return r101;
    }

    private void addADTStoPacket(byte[] r100, int r101) {
        int r102 = AudioProfile.getSFI(48000);
        r100[0] = -1;
        r100[1] = -7;
        r100[2] = (byte) ((64 + (r102 << 2)) + 0);
        r100[3] = (byte) (128 + (r101 >> 11));
        r100[4] = (byte) ((r101 & 2047) >> 3);
        r100[5] = (byte) (((r101 & 7) << 5) + 31);
        r100[6] = -4;
    }

    public void setAudioParameter(int r100, AudioParameter r101) {
        if (this.audioParameters.containsKey(Integer.valueOf(r100)) == false) goto L5;
        this.audioParameters.remove(Integer.valueOf(r100));
    L5:
        this.audioParameters.put(Integer.valueOf(r100), r101);
        int r102 = r101.frameSize;
        if (r102 != 0) goto L8;
        r102 = 4096;
    L8:
        this.frameSize = r102;
        this.sampleRate = r101.sampleRate;
        this.channels = r101.channels;
        this.bitWidth = r101.bitWidth;
        this.codecId = r101.codecId;
        Logger.i(this.TAG, "Audio player sampleRate: " + this.sampleRate + ",channels: " + this.channels + ", bitWidth: " + this.bitWidth + ", codecId=" + this.codecId);
    }

    public void setParameter(MediaParameter r110, Object r111) {
        if (r110 != MediaParameter.Audio_Render_routingChangedListener) goto L8;
        IAudioRender r100 = this.audioRender;
        if (r100 == null) goto L100;
        r100.setParameter(r110, r111);
        return;
    L100:
        return;
    L8:
        if (r110 != MediaParameter.Audio_Render_volume) goto L13;
        float r112 = ((Float) r111).floatValue();
        this.gain = r112;
        IAudioRender r113 = this.audioRender;
        if (r113 == null) goto L102;
        r113.setVolume(r112);
        return;
    L102:
        return;
    L13:
        if (r110 != MediaParameter.Audio_IsAutoPlay) goto L16;
        this.isPlayAudio = ((Boolean) r111).booleanValue();
        return;
    L16:
        if (r110 != MediaParameter.Audio_Render_BitWidth) goto L19;
        this.bitWidth = ((Integer) r111).intValue();
        return;
    L19:
        if (r110 != MediaParameter.Audio_Render_SampleRate) goto L22;
        this.sampleRate = ((Integer) r111).intValue();
        return;
    L22:
        if (r110 != MediaParameter.Audio_Render_Channel) goto L25;
        this.channels = ((Integer) r111).intValue();
        return;
    L25:
        if (r110 != MediaParameter.Audio_Render_FrameSize) goto L28;
        this.frameSize = ((Integer) r111).intValue();
        return;
    L28:
        if (r110 != MediaParameter.Audio_Render_BitRate) goto L31;
        this.bitRate = ((Integer) r111).intValue();
        return;
    L31:
        if (r110 != MediaParameter.Video_JitterBuffer_Delay) goto L34;
        this.videoJitterBufferDelayMs = ((Integer) r111).intValue();
        return;
    L34:
        if (r110 != MediaParameter.Audio_JitterBuffer_Delay) goto L37;
        this.audioJitterBufferDelayMs = ((Integer) r111).intValue();
        return;
    L37:
        if (r110 != MediaParameter.Video_JitterBuffer_Mode) goto L47;
        String r114 = this.TAG;
        StringBuilder r101 = new StringBuilder("Video_JitterBuffer_Mode ");
        Integer r115 = (Integer) r111;
        r101.append(r115);
        Logger.d(r114, r101.toString());
        int r116 = r115.intValue();
        if (r116 == 0) goto L45;
        if (r116 == 1) goto L44;
        if (r116 == 2) goto L43;
        Logger.e(this.TAG, "UnSupported videoJitterBuffer Mode");
        return;
    L43:
        this.videoJitterBufferMode = VideoJitterBuffer.JITTER_MODE.QUALITY_STATIC_MODE;
        return;
    L44:
        this.videoJitterBufferMode = VideoJitterBuffer.JITTER_MODE.QUALITY_DYNAMIC_MODE;
        return;
    L45:
        this.videoJitterBufferMode = VideoJitterBuffer.JITTER_MODE.LOW_LATENCY_MODE;
        return;
    L47:
        if (r110 != MediaParameter.Audio_JitterBuffer_Mode) goto L60;
        String r117 = this.TAG;
        StringBuilder r102 = new StringBuilder("Audio_JitterBuffer_Mode ");
        Integer r118 = (Integer) r111;
        r102.append(r118);
        Logger.d(r117, r102.toString());
        int r119 = r118.intValue();
        if (r119 == 0) goto L58;
        if (r119 == 1) goto L57;
        if (r119 != 2) goto L53;
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.QUALITY_STATIC_MODE;
        return;
    L53:
        if (r119 == 3) goto L55;
        Logger.e(this.TAG, "UnSupported audioJitterBuffer Mode");
        return;
    L55:
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.BYPASS_QUEUE_MODE;
        return;
    L57:
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.QUALITY_DYNAMIC_MODE;
        return;
    L58:
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.LOW_LATENCY_MODE;
        return;
    L60:
        if (r110 != MediaParameter.Render_IsOpenJitterBuffer) goto L63;
        this.isOpenJitterBuffer = ((Boolean) r111).booleanValue();
        return;
    L63:
        if (r110 != MediaParameter.Render_videoLatencyListener) goto L66;
        this.videoLatencyControl.setLatencyListener((ILatencyListener) r111);
        return;
    L66:
        if (r110 != MediaParameter.Render_audioLatencyListener) goto L69;
        this.audioLatencyControl.setLatencyListener((ILatencyListener) r111);
        return;
    L69:
        if (r110 != MediaParameter.Render_dumpFilePath) goto L79;
        String r120 = (String) r111;
        this.dumpPacket.setFilePath(r120, this.userId + ".h264");
        this.dumpFrame.setFilePath(r120, this.userId + ".yuv");
        this.dumpAudio.setFilePath(r120, this.userId + ".aac");
        this.dumpPcm.setFilePath(r120, this.userId + Global.SUFFIX_PCM_FILE);
        this.renderDumpPath = r120;
        StringBuilder r121 = new StringBuilder();
        r121.append(this.renderDumpPath);
        String r103 = File.separator;
        r121.append(r103);
        r121.append("dump_enable");
        this.dumpEnableFile = new PolarisFileWrapper(r121.toString());
        this.ffmpegEnableFile = new PolarisFileWrapper(this.renderDumpPath + r103 + "ffmpeg_enable");
        this.audioEnableFile = new PolarisFileWrapper(this.renderDumpPath + r103 + "audio_dump");
        if (this.ffmpegEnableFile.exists() == false) goto L73;
        this.isUseVideoNativeDecoder = true;
    L73:
        PolarisFileWrapper r122 = new PolarisFileWrapper(this.renderDumpPath + r103 + "nativeRender_enable");
        this.renderEnableFile = r122;
        if (r122.exists() == true) goto L76;
        return;
    L76:
        if (instances <= 0) goto L125;
        this.isUseVideoRender = true;
        return;
    L125:
        return;
    L79:
        if (r110 != MediaParameter.Render_context) goto L96;
        if ((r111 instanceof Context) == false) goto L93;
        Logger.i(this.TAG, "Render_context: Context");
        Context r123 = (Context) r111;
        this.mContext = r123;
        if (this.dumpEnableFile != null) goto L127;
        String r124 = r123.getExternalFilesDir(null).getPath();
        Logger.i(this.TAG, "W dumpPath:" + r124);
        this.dumpPacket.setFilePath(r124, this.userId + "_" + System.currentTimeMillis() + ".h264");
        this.dumpFrame.setFilePath(r124, this.userId + "_" + System.currentTimeMillis() + ".yuv");
        Dump r125 = this.dumpAudio;
        StringBuilder r104 = new StringBuilder();
        r104.append(this.userId);
        r104.append(".aac");
        r125.setFilePath(r124, r104.toString());
        this.dumpPcm.setFilePath(r124, this.userId + Global.SUFFIX_PCM_FILE);
        this.renderDumpPath = r124;
        StringBuilder r126 = new StringBuilder();
        r126.append(this.renderDumpPath);
        String r105 = File.separator;
        r126.append(r105);
        r126.append("dump_enable");
        this.dumpEnableFile = new PolarisFileWrapper(r126.toString());
        this.ffmpegEnableFile = new PolarisFileWrapper(this.renderDumpPath + r105 + "ffmpeg_enable");
        this.audioEnableFile = new PolarisFileWrapper(this.renderDumpPath + r105 + "audio_dump");
        if (this.ffmpegEnableFile.exists() == false) goto L87;
        this.isUseVideoNativeDecoder = true;
    L87:
        PolarisFileWrapper r127 = new PolarisFileWrapper(this.renderDumpPath + r105 + "nativeRender_enable");
        this.renderEnableFile = r127;
        if (r127.exists() == true) goto L90;
        return;
    L90:
        if (instances <= 0) goto L129;
        this.isUseVideoRender = true;
        return;
    L129:
        return;
    L127:
        return;
    L93:
        if ((r111 instanceof CastLogger) == false) goto L131;
        Logger.i(this.TAG, "Render_context: CastLogger");
        CastLogger r128 = (CastLogger) r111;
        this.mCastLogger = r128;
        r128.d(this.TAG, "CastLogger Ready!");
        Logger.setCastLogger(this.mCastLogger);
        return;
    L131:
        return;
    L96:
        if (r110 != MediaParameter.Render_IsUseSoftDecoder) goto L98;
        this.isUseVideoNativeDecoder = ((Boolean) r111).booleanValue();
        return;
    L98:
        Logger.e(this.TAG, "setParameter key not found! key: " + r110);
    }

    public void setSurface(int r100, Surface r101) {
        this.surface = r101;
    }

    public void setVideoParameter(int r100, VideoParameter r101) {
        this.videoParameter = r101;
    }

    public void startUrl(final int r100, String r101) {
        INVOKESTATIC_com_byted_cast_render_imp_MediaRenderImp_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("MediaRenderJni");     // Catch: Exception -> L4
    L7:
        if (r101.isEmpty() == true) goto L14;
        UrlDataSource r102 = new UrlDataSource();
        this.urlDataSource = r102;
        r102.setDataListener(new AnonymousClass5(this, r100));
        this.urlDataSource.setUrl(r101);
        UrlDataSource r103 = this.urlDataSource;
        if (r103 == null) goto L15;
        r103.start();
        return;
    L15:
        return;
    L14:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static /* synthetic */ void access$2900(MediaRenderImp r100, byte[] r101, int r102) {
        r100.addADTStoPacket(r101, r102);
    }

    public void sendAudioPacket(int r110, byte[] r111, long r112) {
        int r100 = r110 / 10;
        int r113 = r110 % 10;
        String r101 = "";
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r103 >= 4) goto L6;
        r101 = r101 + String.format("%02x ", new Object[]{Byte.valueOf(r111[r103])});
        r103 = r103 + 1;
        goto L4
    L6:
        Logger.d(this.TAG, "sendAudioPacket type=" + r100 + ", playerId=" + r113 + "aPacket" + r101);
        int r104 = this.vaildAudioFramesIndex + 1;
        this.vaildAudioFramesIndex = r104;
        this.audioLatencyControl.sendDataIn(r113, (long) r104, r112);
        File r105 = this.audioEnableFile;
        if (r105 != null) goto L9;
    L11:
        this.isOpenDumpAudio = r102;
        if (r102 == false) goto L21;
        if (r100 == 0) goto L15;
    L17:
        if (r100 != 1) goto L21;
        if (this.dumpPcm.isReady() == false) goto L21;
        this.dumpPcm.writeData(r111);
        goto L21
    L15:
        if (this.dumpAudio.isReady() == false) goto L17;
        this.dumpAudio.writeData(r111);
    L21:
        IMediaDecoder r106 = this.audioDecoders.get(Integer.valueOf(r113));
        if (r106 == null) goto L37;
        this.audioLatencyControl.decodeIn(r113, r112);
        if (r100 != 0) goto L26;
        r106.sendPacket(r111, r112);
        return;
    L26:
        this.audioLatencyControl.decoded(r113, r112);
        AudioJitterBuffer r107 = this.audioJitterBuffer;
        if (r107 == null) goto L29;
        r107.append(r111, r112);
    L32:
        IAudioFrameListener r108 = this.audioFrameListener;
        if (r108 == null) goto L39;
        r108.onAudioOutput(this.userId, r113, r111, this.sampleRate, this.channels, this.bitWidth, this.bitRate, r112);
        return;
    L39:
        return;
    L29:
        IAudioRender r109 = this.audioRender;
        if (r109 == null) goto L32;
        r109.render(r111, r111.length);
        this.audioLatencyControl.rendered(r113, r112);
        goto L32
    L37:
        return;
    L9:
        if (r105.exists() == false) goto L11;
        r102 = true;
        goto L11
    }

    public void sendVideoPacket(int r100, byte[] r110, long r111) {
        int r101 = this.vaildVideoFramesIndex + 1;
        this.vaildVideoFramesIndex = r101;
        this.videoLatencyControl.sendDataIn(r100, r101, r111);
        File r102 = this.dumpEnableFile;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.isOpenDumpFrame = r103;
        if (this.dumpPacket.isReady() == false) goto L11;
        Logger.i(this.TAG, "sendVideoPacket DUMP H26X");
        this.dumpPacket.writeData(r110);
    L12:
        IVideoRender r104 = this.videoRender;
        if (r104 == null) goto L15;
        r104.isOpenDump(this.isOpenDumpFrame);
    L15:
        VideoJitterBuffer r105 = this.videoJitterBuffer;
        if (r105 == null) goto L26;
        if (this.videoParameter.codecId != CodecId.H264) goto L20;
        int r106 = r110[4] & 31;
    L22:
        if (r106 != 7) goto L24;
        r111 = 0;
    L24:
        r105.append(r110, r111 * 1000);
        return;
    L20:
        r106 = (r110[4] >> 1) & 63;
        goto L22
    L26:
        if (this.videoDecoder == null) goto L28;
        this.videoLatencyControl.decodeIn(r100, r111);
        this.videoDecoder.sendPacket(r110, r111);
        return;
    L28:
        Logger.e(this.TAG, "videoJitterBuffer and videoDecoder is null");
        return;
    L11:
        Logger.i(this.TAG, "sendVideoPacket NO DUMP");
        goto L12
    L5:
        if (r102.exists() == false) goto L7;
        r103 = true;
        goto L8
    }
}
