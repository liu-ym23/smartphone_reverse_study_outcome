package org.libpag;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.libpag.d;

/* loaded from: classes5.dex */
class HardwareDecoder {

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f37841f = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    private MediaCodec f37843b;

    /* renamed from: a, reason: collision with root package name */
    private VideoSurface f37842a = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f37844c = true;

    /* renamed from: d, reason: collision with root package name */
    private MediaCodec.BufferInfo f37845d = new MediaCodec.BufferInfo();

    /* renamed from: e, reason: collision with root package name */
    private int f37846e = -1;

    public class a implements d.b {

        /* renamed from: a, reason: collision with root package name */
        private MediaCodec f37847a;

        /* renamed from: b, reason: collision with root package name */
        private long f37848b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MediaFormat f37849c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoSurface f37850d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MediaCodec[] f37851e;

        public a(MediaFormat mediaFormat, VideoSurface videoSurface, MediaCodec[] mediaCodecArr) {
            this.f37849c = mediaFormat;
            this.f37850d = videoSurface;
            this.f37851e = mediaCodecArr;
        }

        @Override // org.libpag.d.b
        public void a(boolean z10) {
            if (z10 && this.f37847a != null) {
                long jUptimeMillis = SystemClock.uptimeMillis() - this.f37848b;
                try {
                    this.f37847a.stop();
                } catch (Exception unused) {
                }
                try {
                    this.f37847a.release();
                } catch (Exception unused2) {
                }
                this.f37847a = null;
                this.f37850d.a();
                new RuntimeException("init decoder timeout. cost: " + jUptimeMillis + Const.SP_KEY_GSM_UPLOAD_MXSIZE).printStackTrace();
            }
            if (!z10) {
                this.f37851e[0] = this.f37847a;
            }
            HardwareDecoder.f37841f.getAndDecrement();
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            this.f37848b = SystemClock.uptimeMillis();
            try {
                MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(this.f37849c.getString("mime"));
                this.f37847a = mediaCodecCreateDecoderByType;
                mediaCodecCreateDecoderByType.configure(this.f37849c, this.f37850d.getInputSurface(), (MediaCrypto) null, 0);
                this.f37847a.start();
            } catch (Exception unused) {
                Log.e("HardwareDecoder", "create and config hardware decoder have exception");
                MediaCodec mediaCodec = this.f37847a;
                if (mediaCodec != null) {
                    mediaCodec.release();
                    this.f37847a = null;
                    this.f37850d.a();
                }
            }
        }
    }

    private static HardwareDecoder Create(MediaFormat mediaFormat) {
        VideoSurface videoSurfaceA;
        AtomicInteger atomicInteger = f37841f;
        if (atomicInteger.get() >= 10 || (videoSurfaceA = VideoSurface.a(mediaFormat.getInteger("width"), mediaFormat.getInteger("height"))) == null) {
            return null;
        }
        atomicInteger.getAndIncrement();
        HandlerThread handlerThread = new HandlerThread("libpag_GPUDecoder_init_decoder");
        try {
            handlerThread.start();
            MediaCodec[] mediaCodecArr = {null};
            boolean zA = new d(handlerThread.getLooper()).a(new a(mediaFormat, videoSurfaceA, mediaCodecArr), 2000L);
            handlerThread.quitSafely();
            if (!zA) {
                return null;
            }
            HardwareDecoder hardwareDecoder = new HardwareDecoder();
            hardwareDecoder.f37842a = videoSurfaceA;
            hardwareDecoder.f37843b = mediaCodecArr[0];
            return hardwareDecoder;
        } catch (Error | Exception e10) {
            e10.printStackTrace();
            f37841f.getAndDecrement();
            return null;
        }
    }

    private int dequeueInputBuffer() {
        try {
            return this.f37843b.dequeueInputBuffer(1000L);
        } catch (Error | Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    private int dequeueOutputBuffer() {
        try {
            return this.f37843b.dequeueOutputBuffer(this.f37845d, 1000L);
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    private ByteBuffer getInputBuffer(int i10) {
        try {
            return this.f37843b.getInputBuffer(i10);
        } catch (Error | Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private VideoSurface getVideoSurface() {
        return this.f37842a;
    }

    private int onDecodeFrame() {
        releaseOutputBuffer();
        try {
            int iDequeueOutputBuffer = dequeueOutputBuffer();
            if ((this.f37845d.flags & 4) == 0) {
                if (iDequeueOutputBuffer >= 0) {
                    this.f37846e = iDequeueOutputBuffer;
                }
                return this.f37846e != -1 ? 0 : -1;
            }
            if (iDequeueOutputBuffer < 0) {
                return -3;
            }
            this.f37846e = iDequeueOutputBuffer;
            return -3;
        } catch (Exception e10) {
            e10.printStackTrace();
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
        if (this.f37844c) {
            return;
        }
        try {
            this.f37843b.flush();
            this.f37845d = new MediaCodec.BufferInfo();
            this.f37846e = -1;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void onRelease() {
        if (this.f37843b == null) {
            return;
        }
        releaseOutputBuffer();
        try {
            this.f37843b.stop();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            this.f37843b.release();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f37843b = null;
        this.f37842a.a();
    }

    private boolean onRenderFrame() {
        int i10 = this.f37846e;
        if (i10 != -1) {
            int iReleaseOutputBuffer = releaseOutputBuffer(i10, true);
            this.f37846e = -1;
            if (iReleaseOutputBuffer == 0) {
                return true;
            }
        }
        return false;
    }

    private int onSendBytes(ByteBuffer byteBuffer, long j10) {
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
        return queueInputBuffer(iDequeueInputBuffer, 0, byteBuffer.limit(), j10, 0);
    }

    private long presentationTime() {
        return this.f37845d.presentationTimeUs;
    }

    private int queueInputBuffer(int i10, int i11, int i12, long j10, int i13) throws MediaCodec.CryptoException {
        try {
            this.f37843b.queueInputBuffer(i10, i11, i12, j10, i13);
            this.f37844c = false;
            return 0;
        } catch (Error | Exception e10) {
            e10.printStackTrace();
            return -2;
        }
    }

    private void releaseOutputBuffer() {
        int i10 = this.f37846e;
        if (i10 != -1) {
            releaseOutputBuffer(i10, false);
            this.f37846e = -1;
        }
    }

    private int releaseOutputBuffer(int i10, boolean z10) {
        try {
            this.f37843b.releaseOutputBuffer(i10, z10);
            return 0;
        } catch (Error | Exception e10) {
            e10.printStackTrace();
            return -2;
        }
    }
}
