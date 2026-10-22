package com.byted.cast.sdk.render.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.sdk.IRTCEngineEventListener;
import com.byted.cast.sdk.RTCSetting;
import com.byted.cast.sdk.utils.Utils;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;

/* JADX INFO: loaded from: classes43.dex */
public class VideoPlayer implements VideoJitterBufferCallback {
    private static final String TAG = "VideoPlayer";
    private boolean bInited;
    private ContextManager.CastContext mCastContext;
    private RTCSetting.VCODEC_ID mCodecId;
    private long mFrameIndexIn;
    private FrameMap mFrameMap;
    private golomb mGolomb;
    private int mHeight;
    private IRTCEngineEventListener mListener;
    private CastLogger mLogger;
    private MediaCodec mMediaCodec;
    private String mUserId;
    private IVideoFrameListener mVideoFrameListener;
    private boolean mWaitNextIDR;
    private int mWidth;

    public void startPlay() {
        this.mLogger.i(TAG, "startPlay...");
    }

    public void stopPlay() {
        this.mLogger.i(TAG, "stopPlay...");
        VideoJitterBuffer.getInstance().stop();
        MediaCodec r100 = this.mMediaCodec;
        if (r100 == null) goto L5;
        r100.release();
        this.mMediaCodec = null;
    L5:
        this.bInited = false;
    }

    public boolean isInit() {
        return this.bInited;
    }

    @Override // com.byted.cast.sdk.render.video.VideoJitterBufferCallback
    public void onOutputFrame(long r100) {
        this.mLogger.i(TAG, "onOutputFrame, pts:" + r100);
        if (this.mVideoFrameListener == null) goto L10;
        long r101 = this.mFrameMap.findOnly(r100);
        if (r101 >= 0) goto L8;
        this.mLogger.e(TAG, "onOutputFrame, Ignore output buffer because unknown frameIndex. pts=" + r100);
        return;
    L8:
        this.mVideoFrameListener.onDecoded(this.mUserId, r101);
        return;
    }

    @Override // com.byted.cast.sdk.render.video.VideoJitterBufferCallback
    public void onRenderFrame(long r100) {
        this.mLogger.i(TAG, "onRenderFrame, pts:" + r100);
        if (this.mVideoFrameListener == null) goto L10;
        long r101 = this.mFrameMap.find(r100);
        if (r101 >= 0) goto L8;
        this.mLogger.e(TAG, "onRenderFrame, Ignore output buffer because unknown frameIndex. pts=" + r100);
        return;
    L8:
        this.mVideoFrameListener.onRendered(this.mUserId, r101);
        return;
    }

    public void setVideoFrameListener(IVideoFrameListener r100) {
        this.mVideoFrameListener = r100;
    }

    private void pushInputBuffer(long r100, long r101) {
        IVideoFrameListener r102 = this.mVideoFrameListener;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 <= 0) goto L9;
        r102.onDecodeIn(this.mUserId, r101);
        this.mFrameMap.put(r100, r101);
        return;
    }

    @Override // com.byted.cast.sdk.render.video.VideoJitterBufferCallback
    public void onVideoSize(int r100, int r101) {
        this.mLogger.i(TAG, "onVideoSize, w=" + r100 + " h=" + r101);
    }

    public void queueBuffer(byte[] r110, long r111) {
        SPS r100 = this.mGolomb.Parse(r110, this.mCodecId);
        if (r100.bVaild == false) goto L10;
        int r101 = this.mWidth;
        int r102 = r100.width;
        if (r101 == r102) goto L7;
    L8:
        this.mWidth = r102;
        int r103 = r100.height;
        this.mHeight = r103;
        this.mListener.OnVideoSizeChanged(this.mUserId, r102, r103, 0);
        goto L10
    L7:
        if (this.mHeight != r100.height) goto L8;
    L10:
        if (this.mMediaCodec != null) goto L13;
        this.mLogger.e(TAG, "dequeueInputBuffer, but mMediaCodec is null");
        return;
    L13:
        this.mLogger.v(TAG, "VideoJitterBuffer queueBuffer...dataLen=" + r110.length + " pts=" + r111 + " sps.bVaild=" + r100.bVaild);
        long r112 = r111 * 1000;
        VideoJitterBuffer.getInstance().append(r110, r112, r100.bVaild);
        if (this.mVideoFrameListener == null) goto L29;
        NAL r104 = new NAL(r110, r110.length, this.mCodecId);
        NAL.detectNALType(r104);
        int r113 = r104.type;
        if (r113 != 7) goto L19;
        this.mWaitNextIDR = false;
        this.mLogger.i(TAG, "Feed codec config. Size=" + r104.length + ", last FrameIndex=" + this.mFrameIndexIn);
        pushInputBuffer(0, this.mFrameIndexIn);
        return;
    L19:
        if (r113 != 6) goto L22;
        this.mLogger.i(TAG, "Feed SEI data. Size=" + r104.length + ", last FrameIndex=" + this.mFrameIndexIn);
        pushInputBuffer(0, this.mFrameIndexIn);
        return;
    L22:
        if (r113 != 5) goto L25;
        this.mFrameIndexIn++;
        this.mLogger.i(TAG, "Feed IDR-Frame. Size=" + r104.length + ", PresentationTimeUs=" + r112 + ", frameIndex=" + this.mFrameIndexIn);
        pushInputBuffer(r112, this.mFrameIndexIn);
        return;
    L25:
        if (this.mWaitNextIDR == false) goto L27;
        this.mLogger.i(TAG, "Ignoring P-Frame, last frameIndex=" + this.mFrameIndexIn);
        return;
    L27:
        this.mFrameIndexIn++;
        this.mLogger.i(TAG, "Feed P-Frame. Size=" + r104.length + ", PresentationTimeUs=" + r112 + ", frameIndex=" + this.mFrameIndexIn);
        pushInputBuffer(r112, this.mFrameIndexIn);
        return;
    }

    public VideoPlayer(String r100, ContextManager.CastContext r101, IRTCEngineEventListener r102) {
        this.mMediaCodec = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.bInited = false;
        this.mFrameIndexIn = 0;
        this.mWaitNextIDR = false;
        this.mCastContext = r101;
        CastLogger r103 = ContextManager.getLogger(r101);
        this.mLogger = r103;
        r103.i(TAG, "VideoPlayer ctor:" + r100);
        this.mUserId = r100;
        this.mListener = r102;
        this.mFrameMap = new FrameMap();
        this.mGolomb = new golomb(this.mCastContext);
    }

    public void init(Surface r100, RTCSetting.VCODEC_ID r101, byte[] r102) {
        this.mLogger.i(TAG, "init...");
        SPS r103 = this.mGolomb.Parse(r102, r101);
        if (r103.bVaild == false) goto L9;
        int r104 = this.mWidth;
        int r105 = r103.width;
        if (r104 == r105) goto L7;
    L8:
        this.mWidth = r105;
        int r106 = r103.height;
        this.mHeight = r106;
        this.mListener.OnVideoSizeChanged(this.mUserId, r105, r106, 0);
        goto L9
    L7:
        if (this.mHeight != r103.height) goto L8;
    L9:
        this.mCodecId = r101;
        if (r101 != RTCSetting.VCODEC_ID.H264) goto L12;
        String r107 = KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE;
    L13:
        this.mLogger.i(TAG, "init  width=" + this.mWidth + " height=" + this.mHeight + " codec is " + r107);
        MediaFormat r108 = MediaFormat.createVideoFormat(r107, this.mWidth, this.mHeight);
        if (Utils.getProperty("ro.product.name", "", this.mCastContext).equalsIgnoreCase("darwin") == false) goto L23;
        r108.setFloat("operating-rate", 480.0f);
        r108.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
        r108.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
        this.mLogger.i(TAG, "mMediaCodec.configure, enable darwin lowlatency");
    L23:
        MediaCodec r109 = MediaCodec.createDecoderByType(r107);     // Catch: Exception -> L20
        this.mMediaCodec = r109;     // Catch: Exception -> L20
        r109.configure(r108, r100, null, 0);     // Catch: Exception -> L20
        this.mMediaCodec.start();     // Catch: Exception -> L20
        VideoJitterBuffer.getInstance().setMediaCodec(this.mMediaCodec, new MediaCodec.BufferInfo()).setJitterCallback(this);
        VideoJitterBuffer.getInstance().start();
        this.bInited = true;
        this.mLogger.i(TAG, "init bInited:" + this.bInited);
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        this.mMediaCodec = null;
        this.mLogger.e(TAG, "mMediaCodec.configure error" + e.toString());
        return;
    L12:
        r107 = "video/hevc";
        goto L13
    }
}
