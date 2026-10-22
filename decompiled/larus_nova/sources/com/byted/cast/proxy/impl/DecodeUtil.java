package com.byted.cast.proxy.impl;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.byted.cast.proxy.CastProxyMonitor;
import com.byted.cast.proxy.ErrorCode;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public class DecodeUtil {
    private static final String DECODE_HANDLER_THREAD = "DecodeThread";
    private static final long RECORD_RESIZE_FPS_INTERVAL = 1000;
    private static final Handler castProxyHandler = null;
    private static final HandlerThread decodeHandlerThread = null;
    private static boolean isNeedRemoveSps;
    private static long lastResizeFpsRecordTime;
    private static MediaCodec mediaCodec;
    private static int resizeFps;
    private static final List<Integer> resizeFpsList = null;

    public DecodeUtil() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native byte[] decode(String r100, byte[] r101, boolean r102);

    public static native byte[] decodeV2(String r100, String r101, byte[] r102, boolean r103);

    public static native void ffmpegDecode(String r100, String r101, boolean r102, boolean r103, boolean r104, int r105, boolean r106, boolean r107);

    public static native int[] getDiscardEvent();

    public static void jniCallback() {
    }

    public static void releaseMediaCodec() {
        MediaCodec r100 = mediaCodec;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        r100.stop();     // Catch: Throwable -> L7
        mediaCodec.release();     // Catch: Throwable -> L7
        mediaCodec = null;     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        mediaCodec = null;
        CastProxyMonitor.getInstance().notifyMediaCodecEncodeError(ErrorCode.ERROR_CODE_MEDIACODEC_RELEASE_ERROR, "releaseMediaCodec error:" + th);
    }

    public static native void startDiscardFrame();

    public static native void stopDiscardFrame();

    public static native void stopFfmpegDecode();

    static {
        resizeFpsList = new ArrayList(30);
        INVOKESTATIC_com_byted_cast_proxy_impl_DecodeUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("castproxy");     // Catch: Throwable -> L5
    L7:
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(DECODE_HANDLER_THREAD);
        decodeHandlerThread = r100;
        ThreadMethodProxy.start(r100);
        castProxyHandler = new Handler(r100.getLooper());
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    @JvmStatic
    public static void INVOKESTATIC_com_byted_cast_proxy_impl_DecodeUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void notifyEvent(String r100) {
        Utils.getInstance().notifyJniEvent(r100);
    }

    public static void setNeedRemoveSps(boolean r100) {
        isNeedRemoveSps = r100;
    }

    public static void notifyError(int r100, String r101) {
        Utils.getInstance().notifyJniError(r100, r101);
    }

    public static int writePacket(byte[] r100, int r101) {
        if (isNeedRemoveSps == false) goto L5;
        byte[] r102 = FLVConverter.removeVideoTags(r100);
        Utils.getInstance().produce(r102);
    L6:
        return r101;
    L5:
        Utils.getInstance().produce(r100);
        goto L6
    }

    public static int initMediaCodec(int r110, int r111, int r112) {
        int r100 = Build.VERSION.SDK_INT;
        releaseMediaCodec();     // Catch: Throwable -> L21
        mediaCodec = MediaCodec.createEncoderByType(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE);     // Catch: Throwable -> L21
        MediaFormat r101 = MediaFormat.createVideoFormat(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE, r110, r111);     // Catch: Throwable -> L21
        if (r111 < 1080) goto L6;
        int r102 = 4000000;
    L7:
        if (r112 > 0) goto L10;
        r112 = 30;
    L15:
        r101.setInteger("bitrate", r102);     // Catch: Throwable -> L21
        r101.setInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, r112);     // Catch: Throwable -> L21
        if (r100 < 24) goto L18;
        r101.setInteger("color-standard", 1);     // Catch: Throwable -> L21
        r101.setInteger("color-transfer", 3);     // Catch: Throwable -> L21
        r101.setInteger("color-range", 2);     // Catch: Throwable -> L21
    L18:
        r101.setInteger("color-format", 2135033992);     // Catch: Throwable -> L21
        r101.setInteger("i-frame-interval", 2);     // Catch: Throwable -> L21
        mediaCodec.configure(r101, null, null, 1);     // Catch: Throwable -> L21
        mediaCodec.start();     // Catch: Throwable -> L21
        CastProxyMonitor.getInstance().notifyInitMediaCodecEvent(r110, r111, r112, true, "");     // Catch: Throwable -> L21
        return 0;
    L10:
        if (r112 > 22) goto L13;
        r112 = 22;
        goto L15
    L13:
        if (r112 < 60) goto L15;
        r112 = 60;
        goto L15
    L6:
        r102 = 2000000;
    L21:
        th = move-exception;
        mediaCodec = null;
        CastProxyMonitor r103 = CastProxyMonitor.getInstance();
        r103.notifyInitMediaCodecEvent(r110, r111, r112, false, String.valueOf(th));
        return -1;
    }

    public static void writeYUVData(byte[] r210, long r211, long r212, int r213) {
        if (mediaCodec == null) goto L36;
        resizeFps++;
        long r100 = System.currentTimeMillis();
        if ((r100 - lastResizeFpsRecordTime) < 1000) goto L38;
        List<Integer> r101 = resizeFpsList;
        r101.add(Integer.valueOf(resizeFps));
        resizeFps = 0;
        lastResizeFpsRecordTime = r100;
        if (r101.size() < 30) goto L38;
        ArrayList<Integer> r102 = new ArrayList(r101.size());
        r102.addAll(r101);
        r101.clear();
        CastProxyMonitor.getInstance().notifyResizeFpsEvent(r102);
    L38:
        int r110 = mediaCodec.dequeueInputBuffer(-1);     // Catch: Throwable -> L33
        if (r110 < 0) goto L31;
        ByteBuffer r103 = mediaCodec.getInputBuffer(r110);     // Catch: Throwable -> L33
        if (r103 == null) goto L29;
        r103.put(r210, 0, r210.length);     // Catch: Throwable -> L33
        mediaCodec.queueInputBuffer(r110, 0, r210.length, r211 * 1000, 0);     // Catch: Throwable -> L33
        MediaCodec.BufferInfo r104 = new MediaCodec.BufferInfo();     // Catch: Throwable -> L33
        int r105 = mediaCodec.dequeueOutputBuffer(r104, -1);     // Catch: Throwable -> L33
        if (r105 < 0) goto L28;
        ByteBuffer r106 = mediaCodec.getOutputBuffer(r105);     // Catch: Throwable -> L33
        if (r106 == null) goto L26;
        byte[] r111 = new byte[r104.size];     // Catch: Throwable -> L33
        r106.get(r111);     // Catch: Throwable -> L33
        int r107 = r104.flags;     // Catch: Throwable -> L33
        if ((r107 & 1) == 0) goto L20;
        boolean r108 = true;
    L22:
        if ((r107 & 2) == 0) goto L24;
        boolean r214 = true;
    L25:
        Utils.getInstance().produce(H264ToFLVUtil.h264ToFLV(r111, r211, r212, FLVConverter.isSpsOrPps(r111), r214));     // Catch: Throwable -> L33
    L27:
        mediaCodec.releaseOutputBuffer(r105, false);     // Catch: Throwable -> L33
        return;
    L24:
        r214 = r108;
        goto L25
    L20:
        r108 = false;
        goto L22
    L26:
        CastProxyMonitor.getInstance().notifyMediaCodecEncodeError(ErrorCode.ERROR_CODE_MEDIACODEC_OUTPUT_BUFFER_NULL, "outputBuffer is null.");     // Catch: Throwable -> L33
        goto L27
    L28:
        CastProxyMonitor.getInstance().notifyMediaCodecEncodeError(ErrorCode.ERROR_CODE_MEDIACODEC_OUTPUT_INDEX_INVALID, "outputBufferIndex is " + r105);     // Catch: Throwable -> L33
        return;
    L29:
        CastProxyMonitor.getInstance().notifyMediaCodecEncodeError(ErrorCode.ERROR_CODE_MEDIACODEC_INPUT_BUFFER_NULL, "inputBuffer is null.");     // Catch: Throwable -> L33
        return;
    L31:
        CastProxyMonitor.getInstance().notifyMediaCodecEncodeError(ErrorCode.ERROR_CODE_MEDIACODEC_INPUT_INDEX_INVALID, "inputBufferIndex is " + r110);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        CastProxyMonitor.getInstance().notifyMediaCodecEncodeError(ErrorCode.ERROR_CODE_MEDIACODEC_ENCODE_EXCEPTION, "mediaCodec encode Exception: " + th);
        return;
    L36:
        CastProxyMonitor.getInstance().notifyMediaCodecEncodeError(ErrorCode.ERROR_CODE_MEDIACODEC_NOT_SUPPORT, "mediaCodec is null or not support.");
    }
}
