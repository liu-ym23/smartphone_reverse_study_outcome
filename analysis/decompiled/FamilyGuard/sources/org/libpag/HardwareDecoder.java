package org.libpag;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class HardwareDecoder {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f19124a = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    private MediaCodec f19126c;

    /* renamed from: b, reason: collision with root package name */
    private VideoSurface f19125b = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f19127d = true;

    /* renamed from: e, reason: collision with root package name */
    private MediaCodec.BufferInfo f19128e = new MediaCodec.BufferInfo();

    /* renamed from: f, reason: collision with root package name */
    private int f19129f = -1;

    /* renamed from: g, reason: collision with root package name */
    private boolean f19130g = false;

    HardwareDecoder() {
    }

    private static HardwareDecoder Create(MediaFormat mediaFormat) {
        VideoSurface videoSurfaceA;
        AtomicInteger atomicInteger = f19124a;
        if (atomicInteger.get() >= 10 || (videoSurfaceA = VideoSurface.a(mediaFormat.getInteger("width"), mediaFormat.getInteger("height"))) == null) {
            return null;
        }
        atomicInteger.getAndIncrement();
        HandlerThread handlerThread = new HandlerThread("libpag_GPUDecoder_init_decoder");
        try {
            handlerThread.start();
            MediaCodec[] mediaCodecArr = {null};
            boolean zA = new t(handlerThread.getLooper()).a(new a(mediaFormat, videoSurfaceA, mediaCodecArr), 2000L);
            handlerThread.quitSafely();
            if (!zA) {
                return null;
            }
            HardwareDecoder hardwareDecoder = new HardwareDecoder();
            hardwareDecoder.f19125b = videoSurfaceA;
            hardwareDecoder.f19126c = mediaCodecArr[0];
            return hardwareDecoder;
        } catch (Error | Exception e6) {
            e6.printStackTrace();
            f19124a.getAndDecrement();
            return null;
        }
    }

    private int dequeueInputBuffer() {
        try {
            return this.f19126c.dequeueInputBuffer(1000L);
        } catch (Error | Exception e6) {
            e6.printStackTrace();
            return -1;
        }
    }

    private int dequeueOutputBuffer() {
        try {
            return this.f19126c.dequeueOutputBuffer(this.f19128e, 1000L);
        } catch (Exception e6) {
            e6.printStackTrace();
            return -1;
        }
    }

    private ByteBuffer getInputBuffer(int i5) {
        try {
            return this.f19126c.getInputBuffer(i5);
        } catch (Error | Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private VideoSurface getVideoSurface() {
        return this.f19125b;
    }

    private int onDecodeFrame() {
        releaseOutputBuffer();
        try {
            int iDequeueOutputBuffer = dequeueOutputBuffer();
            if ((this.f19128e.flags & 4) == 0) {
                if (iDequeueOutputBuffer >= 0) {
                    this.f19129f = iDequeueOutputBuffer;
                }
                return this.f19129f != -1 ? 0 : -1;
            }
            if (iDequeueOutputBuffer < 0) {
                return -3;
            }
            this.f19129f = iDequeueOutputBuffer;
            return -3;
        } catch (Exception e6) {
            e6.printStackTrace();
            return -2;
        }
    }

    private int onEndOfStream() {
        int iDequeueInputBuffer = dequeueInputBuffer();
        if (iDequeueInputBuffer >= 0) {
            return queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
        }
        return -1;
    }

    private void onFlush() {
        if (this.f19127d) {
            return;
        }
        try {
            this.f19126c.flush();
            this.f19128e = new MediaCodec.BufferInfo();
            this.f19129f = -1;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void onRelease() {
        if (this.f19130g) {
            return;
        }
        this.f19130g = true;
        releaseOutputBuffer();
        releaseDecoder();
    }

    private boolean onRenderFrame() {
        int i5 = this.f19129f;
        if (i5 != -1) {
            int iReleaseOutputBuffer = releaseOutputBuffer(i5, true);
            this.f19129f = -1;
            if (iReleaseOutputBuffer == 0) {
                return true;
            }
        }
        return false;
    }

    private int onSendBytes(ByteBuffer byteBuffer, long j5) {
        int iDequeueInputBuffer = dequeueInputBuffer();
        if (iDequeueInputBuffer < 0) {
            return -1;
        }
        ByteBuffer inputBuffer = getInputBuffer(iDequeueInputBuffer);
        if (inputBuffer == null) {
            return -2;
        }
        inputBuffer.clear();
        byteBuffer.position(0);
        inputBuffer.put(byteBuffer);
        return queueInputBuffer(iDequeueInputBuffer, 0, byteBuffer.limit(), j5, 0);
    }

    private long presentationTime() {
        return this.f19128e.presentationTimeUs;
    }

    private int queueInputBuffer(int i5, int i6, int i7, long j5, int i8) throws MediaCodec.CryptoException {
        try {
            this.f19126c.queueInputBuffer(i5, i6, i7, j5, i8);
            this.f19127d = false;
            return 0;
        } catch (Error | Exception e6) {
            e6.printStackTrace();
            return -2;
        }
    }

    private void releaseAsync(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f19124a.getAndIncrement();
        HandlerThread handlerThread = new HandlerThread("libpag_GPUDecoder_release_decoder");
        try {
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(new d(this, runnable, handlerThread));
        } catch (Error | Exception e6) {
            e6.printStackTrace();
            runnable.run();
        }
    }

    private void releaseDecoder() {
        if (this.f19126c == null) {
            return;
        }
        releaseAsync(new b(this));
    }

    private void releaseOutputBuffer() {
        int i5 = this.f19129f;
        if (i5 != -1) {
            releaseOutputBuffer(i5, false);
            this.f19129f = -1;
        }
    }

    private int releaseOutputBuffer(int i5, boolean z5) {
        try {
            this.f19126c.releaseOutputBuffer(i5, z5);
            return 0;
        } catch (Error | Exception e6) {
            e6.printStackTrace();
            return -2;
        }
    }
}
