package org.libpag;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import org.libpag.t;

/* loaded from: classes.dex */
class a implements t.b {

    /* renamed from: a, reason: collision with root package name */
    private MediaCodec f19220a;

    /* renamed from: b, reason: collision with root package name */
    private long f19221b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MediaFormat f19222c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ VideoSurface f19223d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ MediaCodec[] f19224e;

    a(MediaFormat mediaFormat, VideoSurface videoSurface, MediaCodec[] mediaCodecArr) {
        this.f19222c = mediaFormat;
        this.f19223d = videoSurface;
        this.f19224e = mediaCodecArr;
    }

    @Override // org.libpag.t.b
    public void a(boolean z5) {
        if (z5 && this.f19220a != null) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.f19221b;
            try {
                this.f19220a.stop();
            } catch (Exception unused) {
            }
            try {
                this.f19220a.release();
            } catch (Exception unused2) {
            }
            this.f19220a = null;
            this.f19223d.a();
            new RuntimeException("init decoder timeout. cost: " + jUptimeMillis + "ms").printStackTrace();
        }
        if (!z5) {
            this.f19224e[0] = this.f19220a;
        }
        HardwareDecoder.f19124a.getAndDecrement();
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        this.f19221b = SystemClock.uptimeMillis();
        try {
            MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(this.f19222c.getString("mime"));
            this.f19220a = mediaCodecCreateDecoderByType;
            mediaCodecCreateDecoderByType.configure(this.f19222c, this.f19223d.getInputSurface(), (MediaCrypto) null, 0);
            this.f19220a.start();
        } catch (Exception unused) {
            Log.e("HardwareDecoder", "create and config hardware decoder have exception");
            MediaCodec mediaCodec = this.f19220a;
            if (mediaCodec != null) {
                mediaCodec.release();
                this.f19220a = null;
                this.f19223d.a();
            }
        }
    }
}
