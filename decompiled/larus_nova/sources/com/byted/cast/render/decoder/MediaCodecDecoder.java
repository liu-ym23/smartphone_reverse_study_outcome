package com.byted.cast.render.decoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.byted.cast.mediacommon.MediaMonitor;
import com.byted.cast.mediacommon.render.MediaRenderState;
import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.byted.cast.mediacommon.render.parameters.MediaRenderErrorCode;
import com.byted.cast.render.jitterbuffer.VideoJitterBuffer;
import com.byted.cast.render.parser.SPS;
import com.byted.cast.render.parser.golomb;
import com.byted.cast.render.utils.Logger;
import com.byted.cast.render.utils.Utils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class MediaCodecDecoder implements IMediaDecoder {
    private static int instanceNum;
    private String TAG;
    private int audioProfile;
    private int channels;
    private final CodecId codecId;
    private long decodeFrames;
    private final Object decodeLock;
    private long decodeLogTime;
    private DecodeThread decodeThread;
    private final Map<Long, Long> decodeTimeMaps;
    private String decoderName;
    private int decodingFrames;
    private int fps;
    private int height;
    private boolean inputWait;
    private int isADTS;
    private boolean isInit;
    private boolean isNeedCodec;
    private boolean isNeedResetDeocder;
    private boolean isSendIdr;
    private boolean isVideo;
    private long lastRecvTime;
    private IMediaDecoderListener listener;
    private SortedSet<Long> mPtsSet;
    private MediaCodec mediaCodec;
    private String mime;
    private boolean outputWait;
    private final ConcurrentSkipListMap<Long, byte[]> packets;
    private long recvFrames;
    private long recvLogTime;
    private final Object renderLock;
    private RenderThread renderThread;
    private int samplePerFrame;
    private int sampleRate;
    private long sendFirstIFrameTime;
    MediaRenderState state;
    private long sumDecodeTimes;
    private long sumRecvTimes;
    private Surface surface;
    private final String userId;
    VideoJitterBuffer videoJitterBuffer;
    private int width;

    /* JADX INFO: renamed from: com.byted.cast.render.decoder.MediaCodecDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class DecodeThread extends PthreadThreadV2 {
        private int errorNumbers;
        private boolean isRunning;
        final /* synthetic */ MediaCodecDecoder this$0;
        private int waitTimes;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_byted_cast_render_decoder_MediaCodecDecoder$DecodeThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public synchronized void stopThread() {
            monitor-enter(this);
            this.isRunning = false;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void com_byted_cast_render_decoder_MediaCodecDecoder$DecodeThread__run$___twin___() {
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "DecodeThread start");
        L4:
            if (this.isRunning == false) goto L45;
        L43:
            e = move-exception;
            e.printStackTrace();
            MediaCodecDecoder.access$1000(this.this$0).OnError(MediaRenderErrorCode.MEDIARENDER_DECODE_ERROR, "processThread error");
            goto L45
        L6:
            if (MediaCodecDecoder.access$300(this.this$0).isEmpty() == true) goto L7;
            if (MediaCodecDecoder.access$600(this.this$0) == false) goto L4;
            if (MediaCodecDecoder.access$700(this.this$0) == null) goto L4;
            this.waitTimes = 0;     // Catch: Exception -> L43
            int r100 = MediaCodecDecoder.access$700(this.this$0).dequeueInputBuffer(100000);     // Catch: Exception -> L43
            if (r100 >= 0) goto L25;
            int r101 = this.errorNumbers + 1;     // Catch: Exception -> L43
            this.errorNumbers = r101;     // Catch: Exception -> L43
            if (r101 <= 100) goto L4;
            Logger.w(MediaCodecDecoder.access$200(this.this$0), "cannot send pkt to mediacodec");     // Catch: Exception -> L43
            this.errorNumbers = 0;     // Catch: Exception -> L43
            goto L4
        L25:
            ByteBuffer r102 = MediaCodecDecoder.access$700(this.this$0).getInputBuffer(r100);     // Catch: Exception -> L43
            Object r103 = MediaCodecDecoder.access$400(this.this$0);     // Catch: Exception -> L43
            monitor-enter(r103);     // Catch: Exception -> L43
            long r104 = ((Long) MediaCodecDecoder.access$300(this.this$0).firstKey()).longValue();     // Catch: Throwable -> L36
            Map.Entry r105 = MediaCodecDecoder.access$300(this.this$0).pollFirstEntry();     // Catch: Throwable -> L36
            Objects.requireNonNull(r105);     // Catch: Throwable -> L36
            byte[] r106 = (byte[]) r105.getValue();     // Catch: Throwable -> L36
            MediaCodecDecoder.access$800(this.this$0).put(Long.valueOf(r104), Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L36
            int r107 = r106.length;     // Catch: Throwable -> L36
            if (r102 == null) goto L32;
            r107 = Math.min(r107, r102.capacity());     // Catch: Throwable -> L36
            if (r107 <= 0) goto L32;
            r102.put(r106, 0, r107);     // Catch: Throwable -> L36
        L32:
            MediaCodec r108 = MediaCodecDecoder.access$700(this.this$0);     // Catch: Throwable -> L36
            r108.queueInputBuffer(r100, 0, r107, r104, 0);     // Catch: Throwable -> L36
            monitor-exit(r103);     // Catch: Throwable -> L36
            MediaCodecDecoder.access$908(this.this$0);     // Catch: Exception -> L43
            this.errorNumbers = 0;     // Catch: Exception -> L43
            goto L4
        L36:
            th = move-exception;
            throw th;     // Catch: Exception -> L43
        L7:
            Object r109 = MediaCodecDecoder.access$400(this.this$0);     // Catch: Exception -> L43
            monitor-enter(r109);     // Catch: Exception -> L43
            MediaCodecDecoder.access$502(this.this$0, true);     // Catch: Throwable -> L15
            MediaCodecDecoder.access$400(this.this$0).wait(500);     // Catch: Throwable -> L15
            int r110 = this.waitTimes + 1;     // Catch: Throwable -> L15
            this.waitTimes = r110;     // Catch: Throwable -> L15
            if (r110 <= 10) goto L12;
            Logger.w(MediaCodecDecoder.access$200(this.this$0), "long time no input data");     // Catch: Throwable -> L15
            this.waitTimes = 0;     // Catch: Throwable -> L15
        L12:
            MediaCodecDecoder.access$502(this.this$0, false);     // Catch: Throwable -> L15
            monitor-exit(r109);     // Catch: Throwable -> L15
            goto L4
        L15:
            th = move-exception;
            throw th;     // Catch: Exception -> L43
        L45:
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "DecoderThread stop");
        }

        private DecodeThread(MediaCodecDecoder r100) {
            this.this$0 = r100;
            super("MediaCodecDecoder$DecodeThread");
            this.isRunning = true;
            this.errorNumbers = 0;
            this.waitTimes = 0;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_byted_cast_render_decoder_MediaCodecDecoder$DecodeThread_com_larus_apm_impl_protector_RunnableLancet_run(DecodeThread r100) {
            r100.com_byted_cast_render_decoder_MediaCodecDecoder$DecodeThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ DecodeThread(MediaCodecDecoder r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public class RenderThread extends PthreadThreadV2 {
        private int errorNumber;
        private boolean isFirstFrame;
        private boolean isRunning;
        final /* synthetic */ MediaCodecDecoder this$0;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_byted_cast_render_decoder_MediaCodecDecoder$RenderThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public synchronized void stopThread() {
            monitor-enter(this);
            this.isRunning = false;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void com_byted_cast_render_decoder_MediaCodecDecoder$RenderThread__run$___twin___() {
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "RenderThread start");
            MediaCodec.BufferInfo r100 = new MediaCodec.BufferInfo();
        L4:
            if (this.isRunning == false) goto L104;
        L102:
            e = move-exception;
            e.printStackTrace();
            MediaCodecDecoder.access$1000(this.this$0).OnError(MediaRenderErrorCode.MEDIARENDER_DECODE_ERROR, "renderThread error");
            goto L104
        L6:
            if (MediaCodecDecoder.access$600(this.this$0) == false) goto L7;
            if (MediaCodecDecoder.access$700(this.this$0) == null) goto L17;
            int r101 = MediaCodecDecoder.access$700(this.this$0).dequeueOutputBuffer(r100, 1000000 / MediaCodecDecoder.access$1300(this.this$0));     // Catch: Exception -> L102
            Logger.v(MediaCodecDecoder.access$200(this.this$0), "dequeueOutputBuffer outputBufferId=" + r101 + ", info.presentationTimeUs=" + r100.presentationTimeUs);     // Catch: Exception -> L102
            if (r101 >= 0) goto L20;
            if (r101 == (-2)) goto L56;
            if (r101 != (-1)) goto L4;
            int r102 = this.errorNumber + 1;     // Catch: Exception -> L102
            this.errorNumber = r102;     // Catch: Exception -> L102
            if (r102 <= 200) goto L4;
            Logger.w(MediaCodecDecoder.access$200(this.this$0), MediaCodecDecoder.access$2200(this.this$0) + ": always no outFrame");     // Catch: Exception -> L102
            this.errorNumber = 0;     // Catch: Exception -> L102
            goto L4
        L56:
            MediaFormat r103 = MediaCodecDecoder.access$700(this.this$0).getOutputFormat();     // Catch: Exception -> L102
            if (r103.containsKey("width") == false) goto L90;
            if (r103.containsKey("height") == false) goto L90;
            int r104 = MediaCodecDecoder.access$2000(this.this$0);     // Catch: Exception -> L102
            int r105 = MediaCodecDecoder.access$2100(this.this$0);     // Catch: Exception -> L102
            if (Build.VERSION.SDK_INT >= 23) goto L63;
        L67:
            int r106 = r104;
            int r110 = r105;
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "mediacodec videoSizeChanged format: width: " + r103.getInteger("width") + ", height: " + r103.getInteger("height") + ", colorFormat: 0x" + Integer.toHexString(r103.getInteger("color-format")) + ", stride: " + r106 + ", sliceHeight: " + r110);     // Catch: Exception -> L102
            if (r103.containsKey("color-format") == false) goto L70;
            int r107 = r103.getInteger("color-format");     // Catch: Exception -> L102
        L72:
            if (r107 != 2135033992) goto L74;
        L87:
            int r111 = 1;
        L88:
            MediaCodecDecoder.access$1000(this.this$0).OnVideoSizeChanged(MediaCodecDecoder.access$2000(this.this$0), MediaCodecDecoder.access$2100(this.this$0), r106, r110, r111);     // Catch: Exception -> L102
            goto L90
        L74:
            if (r107 == 17) goto L87;
            if (r107 == 18) goto L87;
            if (r107 == 19) goto L87;
            if (r107 == 20) goto L87;
            if (r107 == 21) goto L87;
            if (r107 == 39) goto L87;
            r111 = 2;
            goto L88
        L70:
            r107 = 2;
            goto L72
        L63:
            if (r103.containsKey("stride") == false) goto L67;
            if (r103.containsKey("slice-height") == false) goto L67;
            r104 = r103.getInteger("stride");     // Catch: Exception -> L102
            r105 = r103.getInteger("slice-height");     // Catch: Exception -> L102
        L90:
            if (r103.containsKey(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT) == false) goto L4;
            if (r103.containsKey(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE) == false) goto L4;
            if (r103.containsKey("bit-width") == false) goto L4;
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "mediacodec audioSizeChanged sampleRate: " + r103.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE) + ", channels: " + r103.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT) + ", bitwidth: " + r103.getInteger("bit-width"));     // Catch: Exception -> L102
            goto L4
        L20:
            ByteBuffer r108 = MediaCodecDecoder.access$700(this.this$0).getOutputBuffer(r101);     // Catch: Exception -> L102
            long r109 = System.currentTimeMillis();     // Catch: Exception -> L102
            if (this.isFirstFrame == false) goto L24;
            long r112 = r109 - MediaCodecDecoder.access$1400(this.this$0);     // Catch: Exception -> L102
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "firstFrameDecodeTime: " + r112 + ", mediacodec frameQueue size: " + MediaCodecDecoder.access$900(this.this$0));     // Catch: Exception -> L102
            JSONObject r113 = new JSONObject();     // Catch: Exception -> L102
            r113.put("userId", MediaCodecDecoder.access$1500(this.this$0));     // Catch: Exception -> L102
            r113.put("firstFrameDecodeTime", r112);     // Catch: Exception -> L102
            MediaMonitor.onSinkMonitor("MediaRender_FirstDecodedFrame", r113.toString());     // Catch: Exception -> L102
            this.isFirstFrame = false;     // Catch: Exception -> L102
        L24:
            if (MediaCodecDecoder.access$1600(this.this$0) != null) goto L29;
            if (r108 == null) goto L29;
            int r114 = r100.size;     // Catch: Exception -> L102
            if (r114 <= 0) goto L29;
            byte[] r115 = new byte[r114];     // Catch: Exception -> L102
            r108.get(r115, 0, r114);     // Catch: Exception -> L102
            r108.clear();     // Catch: Exception -> L102
            MediaCodecDecoder.access$1000(this.this$0).OnAVFrameAvailable(r115, r100.presentationTimeUs);     // Catch: Exception -> L102
        L30:
            VideoJitterBuffer r116 = this.this$0.videoJitterBuffer;     // Catch: Exception -> L102
            if (r116 != null) goto L33;
        L35:
            long r117 = 0;
        L36:
            MediaCodecDecoder.access$910(this.this$0);     // Catch: Exception -> L102
            Long r118 = (Long) MediaCodecDecoder.access$800(this.this$0).get(Long.valueOf(r100.presentationTimeUs));     // Catch: Exception -> L102
            if (r118 == null) goto L45;
            long r119 = r109 - r118.longValue();     // Catch: Exception -> L102
            MediaCodecDecoder.access$1708(this.this$0);     // Catch: Exception -> L102
            MediaCodecDecoder r120 = this.this$0;     // Catch: Exception -> L102
            MediaCodecDecoder.access$1802(r120, r119 + MediaCodecDecoder.access$1800(r120));     // Catch: Exception -> L102
            if ((MediaCodecDecoder.access$1800(this.this$0) / MediaCodecDecoder.access$1700(this.this$0)) > 200) goto L41;
        L43:
            MediaCodecDecoder.access$800(this.this$0).remove(Long.valueOf(r100.presentationTimeUs));     // Catch: Exception -> L102
            goto L45
        L41:
            if ((r109 - MediaCodecDecoder.access$1900(this.this$0)) <= 5000) goto L43;
            long r121 = MediaCodecDecoder.access$1800(this.this$0) / MediaCodecDecoder.access$1700(this.this$0);     // Catch: Exception -> L102
            Logger.w(MediaCodecDecoder.access$200(this.this$0), "decode too slow, 5s average decodeTime is " + r121 + "ms, decode frames is " + MediaCodecDecoder.access$1700(this.this$0) + ", mediacodec save frames: " + MediaCodecDecoder.access$900(this.this$0) + ", wait decode packet is " + MediaCodecDecoder.access$300(this.this$0).size());     // Catch: Exception -> L102
            JSONObject r122 = new JSONObject();     // Catch: Exception -> L102
            r122.put("userId", MediaCodecDecoder.access$1500(this.this$0));     // Catch: Exception -> L102
            r122.put("averDecodeTime", r121);     // Catch: Exception -> L102
            r122.put("decodeFrames", MediaCodecDecoder.access$1700(this.this$0));     // Catch: Exception -> L102
            r122.put("mediacodecSaveFrames", MediaCodecDecoder.access$900(this.this$0));     // Catch: Exception -> L102
            r122.put("waitDecodePackets", MediaCodecDecoder.access$300(this.this$0).size());     // Catch: Exception -> L102
            MediaMonitor.onSinkMonitor("MediaRender_DecodeTime", r122.toString());     // Catch: Exception -> L102
            MediaCodecDecoder.access$1902(this.this$0, r109);     // Catch: Exception -> L102
            MediaCodecDecoder.access$1702(this.this$0, 0);     // Catch: Exception -> L102
            MediaCodecDecoder.access$1802(this.this$0, 0);     // Catch: Exception -> L102
        L45:
            if (MediaCodecDecoder.access$1600(this.this$0) != null) goto L47;
        L49:
            this.errorNumber = 0;     // Catch: Exception -> L102
            if (MediaCodecDecoder.access$700(this.this$0) == null) goto L4;
            MediaCodecDecoder.access$700(this.this$0).releaseOutputBuffer(r101, r117);     // Catch: Exception -> L102
            if (MediaCodecDecoder.access$1000(this.this$0) == null) goto L4;
            MediaCodecDecoder.access$1000(this.this$0).OnAVFrameRendered(null, r100.presentationTimeUs);     // Catch: Exception -> L102
            goto L4
        L47:
            if (MediaCodecDecoder.access$1600(this.this$0).isValid() == true) goto L49;
            Logger.e(MediaCodecDecoder.access$200(this.this$0), "surface is inValid!!!");     // Catch: Exception -> L102
            MediaCodecDecoder.access$1000(this.this$0).OnError(MediaRenderErrorCode.MEDIARENDER_SURFACE_ERROR, "renderThread surface is inValid");     // Catch: Exception -> L102
            goto L49
        L33:
            if (this.isRunning == false) goto L35;
            r117 = r116.doRender(r100.presentationTimeUs * 1000);     // Catch: Exception -> L102
        L29:
            MediaCodecDecoder.access$1000(this.this$0).OnAVFrameAvailable(null, r100.presentationTimeUs);     // Catch: Exception -> L102
            goto L30
        L17:
            Logger.e(MediaCodecDecoder.access$200(this.this$0), "dequeueOutputBuffer failed, mediacodec is null");     // Catch: Exception -> L102
            MediaCodecDecoder.access$1000(this.this$0).OnError(MediaRenderErrorCode.MEDIARENDER_DECODE_ERROR, "mediacodec is null");     // Catch: Exception -> L102
            goto L104
        L7:
            Object r123 = MediaCodecDecoder.access$1100(this.this$0);     // Catch: Exception -> L102
            monitor-enter(r123);     // Catch: Exception -> L102
            MediaCodecDecoder.access$1202(this.this$0, true);     // Catch: Throwable -> L12
            MediaCodecDecoder.access$1100(this.this$0).wait();     // Catch: Throwable -> L12
            MediaCodecDecoder.access$1202(this.this$0, false);     // Catch: Throwable -> L12
            monitor-exit(r123);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Exception -> L102
        L104:
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "RenderThread stop");
        }

        private RenderThread(MediaCodecDecoder r100) {
            this.this$0 = r100;
            super("MediaCodecDecoder$RenderThread");
            this.isRunning = true;
            this.isFirstFrame = true;
            this.errorNumber = 0;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_byted_cast_render_decoder_MediaCodecDecoder$RenderThread_com_larus_apm_impl_protector_RunnableLancet_run(RenderThread r100) {
            r100.com_byted_cast_render_decoder_MediaCodecDecoder$RenderThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ RenderThread(MediaCodecDecoder r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    private void resetDecoder() {
        this.isInit = false;
        Object r100 = this.decodeLock;
        monitor-enter(r100);
        this.packets.clear();     // Catch: Throwable -> L19
        this.mPtsSet.clear();     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (this.mediaCodec != null) goto L9;
        return;
    L9:
        if (this.inputWait == false) goto L14;
        if (this.outputWait == false) goto L14;
        this.mediaCodec.reset();     // Catch: Exception -> L16
        return;
    L14:
        Thread.sleep(2);     // Catch: Exception -> L16
    L19:
        th = move-exception;
        throw th;
    }

    private boolean deInit() {
        MediaCodec r100 = this.mediaCodec;     // Catch: Exception -> L7
        if (r100 == null) goto L32;
        r100.flush();     // Catch: Exception -> L7
    L32:
        MediaCodec r101 = this.mediaCodec;     // Catch: Throwable -> L18 Exception -> L20
        if (r101 == null) goto L13;
        r101.stop();     // Catch: Throwable -> L18 Exception -> L20
    L13:
        MediaCodec r102 = this.mediaCodec;
        if (r102 == null) goto L16;
        r102.release();
    L16:
        this.mediaCodec = null;
        this.isInit = false;
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        instanceNum--;
        Logger.i(this.TAG, "deInit: success");
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        Logger.e(this.TAG, "deInit, stop Error");     // Catch: Throwable -> L18
        MediaCodec r103 = this.mediaCodec;
        if (r103 == null) goto L25;
        r103.release();
    L25:
        this.mediaCodec = null;
        this.isInit = false;
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        instanceNum--;
        Logger.i(this.TAG, "deInit: success");
        return false;
    L18:
        th = move-exception;
        MediaCodec r104 = this.mediaCodec;
        if (r104 == null) goto L30;
        r104.release();
    L30:
        this.mediaCodec = null;
        this.isInit = false;
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        instanceNum--;
        Logger.i(this.TAG, "deInit: success");
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();
        Logger.e(this.TAG, "deInit, flush Error");
        goto L32
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean start() {
        Logger.i(this.TAG, "start mime: " + this.mime);
        if (this.isNeedCodec == true) goto L5;
        return true;
    L5:
        MediaRenderState r100 = this.state;
        MediaRenderState r101 = MediaRenderState.STATE_EXECUTING;
        if (r100 != r101) goto L9;
        Logger.e(this.TAG, "start failed, reason: isStarted");
        return true;
    L9:
        AnonymousClass1 r102 = null;
        if (this.renderThread != null) goto L13;
        RenderThread r103 = new RenderThread(this, r102);
        this.renderThread = r103;
        ThreadMethodProxy.setPriority(r103, 10);
        ThreadMethodProxy.start(this.renderThread);
    L13:
        if (this.decodeThread != null) goto L15;
        DecodeThread r104 = new DecodeThread(this, r102);
        this.decodeThread = r104;
        ThreadMethodProxy.start(r104);
    L15:
        this.state = r101;
        if (this.isInit == false) goto L18;
        return true;
    L18:
        if (this.isVideo == false) goto L27;
        if (initDecoder(false) == false) goto L22;
        Logger.d(this.TAG, "hw video decoder init success, resolution: " + this.width + "x" + this.height);
        return true;
    L22:
        Logger.e(this.TAG, "hw video decoder init failure, resolution: " + this.width + "x" + this.height);
        if (initDecoder(true) == false) goto L25;
        Logger.d(this.TAG, "sw video decoder init success, resolution: " + this.width + "x" + this.height);
        return true;
    L25:
        Logger.e(this.TAG, "sw video decoder init failure, resolution: " + this.width + "x" + this.height);
        this.listener.OnError(MediaRenderErrorCode.MEDIARENDER_INIT_ERROR, "init failed");
    L30:
        return false;
    L27:
        if (initDecoder(false) == false) goto L29;
        Logger.i(this.TAG, "hw audio decoder init success");
        return true;
    L29:
        Logger.i(this.TAG, "hw audio decoder init failure");
        goto L30
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean stop() {
        Logger.i(this.TAG, "stop, mime: " + this.mime);
        if (this.isNeedCodec == true) goto L6;
        return true;
    L6:
        if (this.state == MediaRenderState.STATE_EXECUTING) goto L45;
        return true;
    L45:
        DecodeThread r100 = this.decodeThread;     // Catch: InterruptedException -> L30
        if (r100 == null) goto L19;
        r100.stopThread();     // Catch: InterruptedException -> L30
        Object r101 = this.decodeLock;     // Catch: InterruptedException -> L30
        monitor-enter(r101);     // Catch: InterruptedException -> L30
        this.decodeLock.notify();     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        ThreadMethodProxy.join(this.decodeThread, 100);     // Catch: InterruptedException -> L30
        this.decodeThread = null;     // Catch: InterruptedException -> L30
        goto L19
    L16:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L30
    L19:
        RenderThread r102 = this.renderThread;     // Catch: InterruptedException -> L30
        if (r102 == null) goto L32;
        r102.stopThread();     // Catch: InterruptedException -> L30
        Object r103 = this.decodeLock;     // Catch: InterruptedException -> L30
        monitor-enter(r103);     // Catch: InterruptedException -> L30
        this.decodeLock.notify();     // Catch: Throwable -> L27
        monitor-exit(r103);     // Catch: Throwable -> L27
        ThreadMethodProxy.join(this.renderThread, 100);     // Catch: InterruptedException -> L30
        this.renderThread = null;     // Catch: InterruptedException -> L30
        goto L32
    L27:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L30
    L32:
        this.isSendIdr = false;
        Object r104 = this.decodeLock;
        monitor-enter(r104);
        this.packets.clear();     // Catch: Throwable -> L38
        this.mPtsSet.clear();     // Catch: Throwable -> L38
        monitor-exit(r104);     // Catch: Throwable -> L38
        return deInit();
    L38:
        th = move-exception;
        throw th;
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public MediaRenderState getState() {
        return this.state;
    }

    public static /* synthetic */ IMediaDecoderListener access$1000(MediaCodecDecoder r100) {
        return r100.listener;
    }

    public static /* synthetic */ Object access$1100(MediaCodecDecoder r100) {
        return r100.renderLock;
    }

    public static /* synthetic */ int access$1300(MediaCodecDecoder r100) {
        return r100.fps;
    }

    public static /* synthetic */ long access$1400(MediaCodecDecoder r100) {
        return r100.sendFirstIFrameTime;
    }

    public static /* synthetic */ String access$1500(MediaCodecDecoder r100) {
        return r100.userId;
    }

    public static /* synthetic */ Surface access$1600(MediaCodecDecoder r100) {
        return r100.surface;
    }

    public static /* synthetic */ long access$1700(MediaCodecDecoder r100) {
        return r100.decodeFrames;
    }

    public static /* synthetic */ long access$1708(MediaCodecDecoder r100) {
        long r101 = r100.decodeFrames;
        r100.decodeFrames = 1 + r101;
        return r101;
    }

    public static /* synthetic */ long access$1800(MediaCodecDecoder r100) {
        return r100.sumDecodeTimes;
    }

    public static /* synthetic */ long access$1900(MediaCodecDecoder r100) {
        return r100.decodeLogTime;
    }

    public static /* synthetic */ String access$200(MediaCodecDecoder r100) {
        return r100.TAG;
    }

    public static /* synthetic */ int access$2000(MediaCodecDecoder r100) {
        return r100.width;
    }

    public static /* synthetic */ int access$2100(MediaCodecDecoder r100) {
        return r100.height;
    }

    public static /* synthetic */ String access$2200(MediaCodecDecoder r100) {
        return r100.mime;
    }

    public static /* synthetic */ ConcurrentSkipListMap access$300(MediaCodecDecoder r100) {
        return r100.packets;
    }

    public static /* synthetic */ Object access$400(MediaCodecDecoder r100) {
        return r100.decodeLock;
    }

    public static /* synthetic */ boolean access$600(MediaCodecDecoder r100) {
        return r100.isInit;
    }

    public static /* synthetic */ MediaCodec access$700(MediaCodecDecoder r100) {
        return r100.mediaCodec;
    }

    public static /* synthetic */ Map access$800(MediaCodecDecoder r100) {
        return r100.decodeTimeMaps;
    }

    public static /* synthetic */ int access$900(MediaCodecDecoder r100) {
        return r100.decodingFrames;
    }

    public static /* synthetic */ int access$908(MediaCodecDecoder r100) {
        int r101 = r100.decodingFrames;
        r100.decodingFrames = r101 + 1;
        return r101;
    }

    public static /* synthetic */ int access$910(MediaCodecDecoder r100) {
        int r101 = r100.decodingFrames;
        r100.decodingFrames = r101 - 1;
        return r101;
    }

    private boolean checkInputData(byte[] r100) {
        if (this.isVideo == false) goto L63;
        CodecId r101 = this.codecId;
        CodecId r102 = CodecId.H264;
        if (r101 != r102) goto L7;
        int r103 = r100[4] & 31;
    L8:
        if (r103 != 1) goto L14;
        if (this.isSendIdr == true) goto L14;
        Logger.w(this.TAG, "no idr, ignore this P frame");
        return false;
    L14:
        if (r103 != 5) goto L17;
        if (r101 != r102) goto L17;
    L20:
        Logger.i(this.TAG, "Feed I frame");
    L22:
        if (r103 != 7) goto L26;
        if (this.codecId != r102) goto L26;
    L29:
        Logger.i(this.TAG, "Feed SPS frame");
        SPS r104 = new golomb().Parse(r100, this.codecId);
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L32
        r105.put("userId", this.userId);     // Catch: JSONException -> L32
        r105.put("width", r104.width);     // Catch: JSONException -> L32
        r105.put("height", r104.height);     // Catch: JSONException -> L32
        MediaMonitor.onSinkMonitor("MediaRender_FeedSPSFrame", r105.toString());     // Catch: JSONException -> L32
    L34:
        int r106 = r104.width;
        int r107 = this.width;
        if (r106 == r107) goto L37;
    L38:
        if (r106 != 0) goto L40;
    L41:
        r104.width = r107;
        r104.height = this.height;
    L42:
        Logger.i(this.TAG, "videoSizeChanged from " + this.width + "x" + this.height + " to " + r104.width + "x" + r104.height);
        if (this.isNeedResetDeocder == false) goto L45;
        resetDecoder();
    L45:
        config_video_parameters(r104.width, r104.height, this.fps);
    L47:
        if (this.isInit == true) goto L57;
        if (initDecoder(false) == false) goto L52;
        Logger.i(this.TAG, "hw video decoder init success, resolution: " + this.width + "x" + this.height);
        goto L57
    L52:
        if (initDecoder(true) == false) goto L54;
        Logger.e(this.TAG, "sw video decoder init success, resolution: " + this.width + "x" + this.height);
        goto L57
    L54:
        this.listener.OnError(MediaRenderErrorCode.MEDIARENDER_INIT_ERROR, "init failed");
        return false;
    L57:
        if (this.packets.size() <= 30) goto L60;
        this.packets.clear();
    L60:
        if (this.isSendIdr == true) goto L69;
        this.sendFirstIFrameTime = System.currentTimeMillis();
        this.isSendIdr = true;
    L69:
        return true;
    L40:
        if (r104.height != 0) goto L42;
    L37:
        if (r104.height == this.height) goto L47;
    L32:
        e = move-exception;
        e.printStackTrace();
    L26:
        if (r103 != 32) goto L69;
        if (this.codecId != CodecId.H265) goto L69;
    L17:
        if (r103 != 19) goto L22;
        if (r101 != CodecId.H265) goto L22;
    L7:
        r103 = (r100[4] >> 1) & 63;
        goto L8
    L63:
        if (this.packets.size() <= 30) goto L66;
        this.packets.clear();
    L66:
        if (this.isInit == true) goto L69;
        return initDecoder(false);
    }

    private void configAudioFormat(MediaFormat r100) {
        r100.setInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT, this.channels);
        r100.setInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE, this.sampleRate);
        r100.setInteger("is-adts", this.isADTS);
        r100.setInteger("aac-profile", this.audioProfile);
        int r101 = 4;
        byte[] r102 = new byte[4];
        CodecId r103 = this.codecId;
        if (r103 != CodecId.AACELD) goto L6;
        r102[0] = -8;
        r102[1] = -24;
        r102[2] = 80;
        r102[3] = 0;
    L8:
        r100.setByteBuffer("csd-0", ByteBuffer.wrap(r102, 0, r101));
        return;
    L6:
        if (r103 != CodecId.AACLC) goto L8;
        r102[0] = 17;
        r102[1] = -112;
        r101 = 2;
        goto L8
    }

    private void configVideoFormat(MediaFormat r100) {
        r100.setInteger("width", this.width);
        r100.setInteger("height", this.height);
        Logger.i(this.TAG, "config video width = " + this.width + ", height = " + this.height);
        r100.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
        r100.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
        r100.setInteger("vendor.low-latency.enable", 1);
        r100.setInteger("vdec-lowlatency", 1);
        r100.setInteger("need_hwcomposer", 0);
    }

    private synchronized boolean initDecoder(boolean r100) {
        monitor-enter(this);
        Logger.i(this.TAG, "init: mime: " + this.mime);     // Catch: Throwable -> L55
        if (this.mime != null) goto L10;
        Logger.e(this.TAG, "no mime");     // Catch: Throwable -> L55
        monitor-exit(this);
        return false;
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L63;
        MediaCodecInfo.CodecCapabilities r101 = new MediaCodecInfo.CodecCapabilities();     // Catch: Throwable -> L55
        if (instanceNum < r101.getMaxSupportedInstances()) goto L63;
        Logger.e(this.TAG, " max support instances is " + r101.getMaxSupportedInstances());     // Catch: Throwable -> L55
    L63:
    L51:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L55
        Logger.e(this.TAG, "mediacodec configure failed");     // Catch: Throwable -> L55
        return false;
    L15:
        if ((r100 & this.isVideo) == false) goto L17;
        this.mediaCodec = MediaCodec.createByCodecName("OMX.google.h264.decoder");     // Catch: Exception -> L51 Throwable -> L55
    L18:
        MediaFormat r102 = new MediaFormat();     // Catch: Exception -> L51 Throwable -> L55
        r102.setString("mime", this.mime);     // Catch: Exception -> L51 Throwable -> L55
        if (this.mime.contains("video") == false) goto L22;
        configVideoFormat(r102);     // Catch: Exception -> L51 Throwable -> L55
    L24:
        Surface r103 = this.surface;     // Catch: Exception -> L51 Throwable -> L55
        if (r103 == null) goto L30;
        if (r103.isValid() == true) goto L30;
        Logger.e(this.TAG, "surface is unValid!");     // Catch: Exception -> L51 Throwable -> L55
        this.listener.OnError(MediaRenderErrorCode.MEDIARENDER_SURFACE_ERROR, "surface is unValid");     // Catch: Exception -> L51 Throwable -> L55
        this.surface = null;     // Catch: Exception -> L51 Throwable -> L55
    L30:
        if (CheckFormat(this.mime, r102) == false) goto L48;
        this.mediaCodec.configure(r102, this.surface, null, 0);     // Catch: Exception -> L51 Throwable -> L55
        this.mediaCodec.start();     // Catch: Exception -> L51 Throwable -> L55
        Object r104 = this.renderLock;     // Catch: Throwable -> L55
        monitor-enter(r104);     // Catch: Throwable -> L55
        this.isInit = true;     // Catch: Throwable -> L45
        this.renderLock.notifyAll();     // Catch: Throwable -> L45
        monitor-exit(r104);     // Catch: Throwable -> L45
        instanceNum++;     // Catch: Throwable -> L55
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L40 Throwable -> L55
        r105.put("userId", this.userId);     // Catch: JSONException -> L40 Throwable -> L55
        r105.put("decoderName", this.decoderName);     // Catch: JSONException -> L40 Throwable -> L55
        MediaMonitor.onSinkMonitor("MediaRender_InitDecoder", r105.toString());     // Catch: JSONException -> L40 Throwable -> L55
    L42:
        Logger.i(this.TAG, "init: success!");     // Catch: Throwable -> L55
        monitor-exit(this);
        return true;
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L55
        goto L42
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L48:
        Logger.e(this.TAG, "unsupported format, config failed");     // Catch: Exception -> L51 Throwable -> L55
        monitor-exit(this);
        return false;
    L22:
        if (this.mime.contains("audio") == false) goto L24;
        configAudioFormat(r102);     // Catch: Exception -> L51 Throwable -> L55
        goto L24
    L17:
        this.mediaCodec = MediaCodec.createDecoderByType(this.mime);     // Catch: Exception -> L51 Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public void setMediaDecoderListener(IMediaDecoderListener r100) {
        this.listener = r100;
    }

    public MediaCodecDecoder setSurface(Surface r100) {
        if (r100 != null) goto L4;
    L6:
        Logger.e(this.TAG, "[setSurface]: surface is unValid");
        String r101 = "failed";
    L12:
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L9
        r102.put("userId", this.userId);     // Catch: JSONException -> L9
        r102.put("result", r101);     // Catch: JSONException -> L9
        MediaMonitor.onSinkMonitor("MediaRender_SetSurface", r102.toString());     // Catch: JSONException -> L9
    L11:
        return this;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L4:
        if (r100.isValid() == false) goto L6;
        this.surface = r100;
        r101 = "succ";
        goto L12
    }

    public MediaCodecDecoder setVideoJitterBuffer(VideoJitterBuffer r100) {
        this.videoJitterBuffer = r100;
        return this;
    }

    public MediaCodecDecoder(String r100, CodecId r110) {
        this.TAG = "MediaCodecDecoder";
        this.mediaCodec = null;
        this.surface = null;
        this.width = TECameraUtils.CAPTURE_NORMAL;
        this.height = 1080;
        this.fps = 30;
        this.channels = 2;
        this.sampleRate = 48000;
        this.samplePerFrame = 1024;
        this.audioProfile = 39;
        this.isADTS = 0;
        this.isNeedCodec = true;
        this.renderThread = null;
        this.decodeThread = null;
        this.isInit = false;
        this.isVideo = true;
        this.renderLock = new Object();
        this.decodeLock = new Object();
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        this.packets = new ConcurrentSkipListMap();
        this.mPtsSet = new ConcurrentSkipListSet();
        this.inputWait = false;
        this.outputWait = false;
        this.isSendIdr = false;
        this.isNeedResetDeocder = false;
        this.lastRecvTime = 0;
        this.decodeTimeMaps = new HashMap();
        this.decodingFrames = 0;
        this.decodeLogTime = 0;
        this.sumDecodeTimes = 0;
        this.decodeFrames = 0;
        this.recvLogTime = 0;
        this.sumRecvTimes = 0;
        this.recvFrames = 0;
        this.sendFirstIFrameTime = 0;
        this.userId = r100;
        this.codecId = r110;
        String r101 = "_" + r100;
        if (r110 != CodecId.H264) goto L6;
        this.mime = KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE;
        r101 = r101 + "/video";
        this.isNeedCodec = true;
        this.isVideo = true;
    L17:
        this.TAG += r101;
        if (Utils.getProperty("ro.product.name", "").equals("CHM-TL00") == false) goto L23;
        Logger.i(this.TAG, "device need reset decoder");
        this.isNeedResetDeocder = true;
        return;
    L23:
        return;
    L6:
        if (r110 != CodecId.H265) goto L9;
        this.mime = "video/hevc";
        r101 = r101 + "/video";
        this.isNeedCodec = true;
        this.isVideo = true;
        goto L17
    L9:
        if (r110 != CodecId.AACLC) goto L12;
        this.mime = "audio/mp4a-latm";
        this.audioProfile = 2;
        this.isADTS = 1;
        r101 = r101 + "/audio";
        this.isNeedCodec = true;
        this.isVideo = false;
        goto L17
    L12:
        if (r110 != CodecId.AACELD) goto L15;
        this.mime = "audio/mp4a-latm";
        this.audioProfile = 39;
        r101 = r101 + "/audio";
        this.isNeedCodec = true;
        this.isVideo = false;
        goto L17
    L15:
        if (r110 != CodecId.PCM) goto L21;
        this.mime = "";
        this.isNeedCodec = false;
        this.isVideo = false;
        goto L17
    L21:
        Logger.i(this.TAG, "unsupported CodecId");
    }

    public static /* synthetic */ boolean access$1202(MediaCodecDecoder r100, boolean r101) {
        r100.outputWait = r101;
        return r101;
    }

    public static /* synthetic */ long access$1702(MediaCodecDecoder r100, long r101) {
        r100.decodeFrames = r101;
        return r101;
    }

    public static /* synthetic */ long access$1802(MediaCodecDecoder r100, long r101) {
        r100.sumDecodeTimes = r101;
        return r101;
    }

    public static /* synthetic */ long access$1902(MediaCodecDecoder r100, long r101) {
        r100.decodeLogTime = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(MediaCodecDecoder r100, boolean r101) {
        r100.inputWait = r101;
        return r101;
    }

    public boolean CheckFormat(String r110, MediaFormat r111) {
        MediaCodecInfo[] r100 = new MediaCodecList(0).getCodecInfos();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L24;
        MediaCodecInfo r103 = r100[r102];
        if (r103.isEncoder() == true) goto L23;
        if (Arrays.binarySearch(r103.getSupportedTypes(), r110) < 0) goto L23;
        MediaCodecInfo.CodecCapabilities r104 = r103.getCapabilitiesForType(r110);
        if (r104.isFormatSupported(r111) == true) goto L12;
        if (r110.contains("video") == false) goto L22;
        Logger.w(this.TAG, "Codec: " + r103.getName() + " ,video resolution is not support, setWidth: " + r111.getInteger("width") + " ,setHeight: " + r111.getInteger("height") + " -> maxWidth: " + r104.getVideoCapabilities().getSupportedWidths().getUpper() + " ,maxHeight: " + r104.getVideoCapabilities().getSupportedHeights().getUpper() + " ,minWidth: " + r104.getVideoCapabilities().getSupportedWidths().getLower() + " ,minHeight: " + r104.getVideoCapabilities().getSupportedHeights().getLower());
        goto L23
    L22:
        Logger.w(this.TAG, "audio format is not support, sampleRate: " + r111.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE) + " ,channel: " + r111.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT) + " ,supported sampleRate: " + r104.getAudioCapabilities().getSupportedSampleRates().toString() + " ,channel: " + r104.getAudioCapabilities().getMaxInputChannelCount());
        goto L23
    L12:
        Logger.i(this.TAG, "find Codec: " + r103.getName());
        if (this.isVideo == false) goto L17;
        MediaCodecInfo.VideoCapabilities r112 = r104.getVideoCapabilities();
        if (r112 == null) goto L17;
        Logger.i(this.TAG, "Codec: " + r103.getName() + " ,video resolution format -> maxWidth: " + r112.getSupportedWidths().getUpper() + " ,maxHeight: " + r112.getSupportedHeights().getUpper() + " ,minWidth: " + r112.getSupportedWidths().getLower() + " ,minHeight: " + r112.getSupportedHeights().getLower());
    L17:
        this.decoderName = r103.getName();
        return true;
    L23:
        r102 = r102 + 1;
        goto L3
    L24:
        return false;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean sendPacket(byte[] r110, long r210) {
        long r100 = r210;
        if (this.isNeedCodec == true) goto L7;
        this.listener.OnAVFrameAvailable(r110, r100);
        return true;
    L7:
        if (checkInputData(r110) == true) goto L9;
        return false;
    L9:
        Object r101 = this.decodeLock;
        monitor-enter(r101);
    L66:
        th = move-exception;
        throw th;
    L12:
        if (this.isVideo == true) goto L25;
        if (this.mPtsSet.contains(Long.valueOf(r210)) == true) goto L21;
        Logger.v(this.TAG, "addFrame...New...frame.length=" + r110.length + " timestamp=" + r100);     // Catch: Throwable -> L66
        this.mPtsSet.add(Long.valueOf(r210));     // Catch: Throwable -> L66
        if (this.mPtsSet.size() <= 20) goto L27;
        int r102 = 0;
    L19:
        if (r102 >= 10) goto L27;
        SortedSet<Long> r103 = this.mPtsSet;     // Catch: Throwable -> L66
        r103.remove(r103.first());     // Catch: Throwable -> L66
        r102 = r102 + 1;     // Catch: Throwable -> L66
    L27:
        monitor-exit(r101);     // Catch: Throwable -> L66
        if (this.isInit == true) goto L32;
        Logger.w(this.TAG, "decoder is not init");
        return false;
    L32:
        long r104 = System.currentTimeMillis();
        long r105 = this.lastRecvTime;
        long r111 = r104 - r105;
        if (r105 == 0) goto L35;
        this.sumRecvTimes += r111;
        this.recvFrames++;
    L35:
        long r106 = this.recvFrames;
        if (r106 <= 0) goto L38;
        long r112 = this.sumRecvTimes / r106;
    L40:
        if (r112 <= 150) goto L50;
        if ((r104 - this.recvLogTime) <= 2000) goto L50;
        Logger.w(this.TAG, "recvData delay too big, 2s average time is " + r112 + "ms");
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L46
        r107.put("userId", this.userId);     // Catch: JSONException -> L46
        r107.put("log", "averRecvTime: " + r112);     // Catch: JSONException -> L46
        MediaMonitor.onSinkMonitor("MediaRender_RecvTime", r107.toString());     // Catch: JSONException -> L46
    L48:
        this.recvLogTime = r104;
        this.sumRecvTimes = 0;
        this.recvFrames = 0;
    L58:
        this.lastRecvTime = r104;
        Object r108 = this.decodeLock;
        monitor-enter(r108);
        this.packets.put(Long.valueOf(r100), r110);     // Catch: Throwable -> L63
        this.decodeLock.notify();     // Catch: Throwable -> L63
        monitor-exit(r108);     // Catch: Throwable -> L63
        return true;
    L63:
        th = move-exception;
        throw th;
    L46:
        e = move-exception;
        e.printStackTrace();
    L50:
        if (r111 <= 1000) goto L58;
        if (r111 >= 100000) goto L58;
        Logger.w(this.TAG, "recvData delay too big, recvtime is " + r111 + "ms");
        JSONObject r109 = new JSONObject();     // Catch: JSONException -> L56
        r109.put("userId", this.userId);     // Catch: JSONException -> L56
        r109.put("log", "recvTime: " + r111);     // Catch: JSONException -> L56
        MediaMonitor.onSinkMonitor("MediaRender_RecvTime", r109.toString());     // Catch: JSONException -> L56
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L58
    L38:
        r112 = 0;
        goto L40
    L21:
        Logger.v(this.TAG, "addFrame...Skip...frame.length=" + r110.length + " timestamp=" + r100);     // Catch: Throwable -> L66
        monitor-exit(r101);     // Catch: Throwable -> L66
        return true;
    L25:
        if (this.packets.containsKey(Long.valueOf(r210)) == false) goto L27;
        r100 = r100 + 1;     // Catch: Throwable -> L66
        goto L27
    }

    public MediaCodecDecoder config_video_parameters(int r100, int r101, int r102) {
        Logger.i(this.TAG, "[config_video_parameters]: width = " + r100 + ", height = " + r101 + ", fps = " + r102);
        this.width = r100;
        this.height = r101;
        if (r102 != 0) goto L5;
        r102 = 30;
    L5:
        this.fps = r102;
        return this;
    }

    public MediaCodecDecoder config_audio_parameters(int r100, int r101, int r102, int r103) {
        this.sampleRate = r100;
        this.channels = r101;
        this.samplePerFrame = (r103 / r101) / (r102 / 8);
        Logger.i(this.TAG, "[config_audio_parameters]: sampleRate = " + r100 + ", channels = " + r101 + ", bitwidth = " + r102 + ", frameSize = " + r103 + ", samplePerFrame = " + this.samplePerFrame);
        return this;
    }
}
