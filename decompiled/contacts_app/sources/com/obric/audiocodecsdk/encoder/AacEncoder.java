package com.obric.audiocodecsdk.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.audiocodecsdk.log.XLog;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AacEncoder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/audiocodecsdk/encoder/AacEncoder;", "Lcom/obric/audiocodecsdk/encoder/AudioEncoder;", "sampleRate", "", "channel", "bitrate", "bufferSize", "outputFilePath", "", "(IIIILjava/lang/String;)V", "TAG", "audioTrackIndex", "getBitrate", "()I", "bytesPerSecond", "getChannel", "mediaCodec", "Landroid/media/MediaCodec;", "mediaMuxer", "Landroid/media/MediaMuxer;", "muxerStarted", "", "getSampleRate", "encode", "", "buffer", "", PerfConsts.PERF_DISK_FILE_SIZE, "start", "stop", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AacEncoder extends AudioEncoder {
    private final String TAG;
    private int audioTrackIndex;
    private final int bitrate;
    private final int bufferSize;
    private int bytesPerSecond;
    private final int channel;
    private MediaCodec mediaCodec;
    private MediaMuxer mediaMuxer;
    private boolean muxerStarted;
    private final String outputFilePath;
    private final int sampleRate;

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getChannel() {
        return this.channel;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public AacEncoder(int r2, int r3, int r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "outputFilePath");
        this.sampleRate = r2;
        this.channel = r3;
        this.bitrate = r4;
        this.bufferSize = r5;
        this.outputFilePath = r6;
        this.TAG = "AacEncoder";
        this.audioTrackIndex = -1;
        this.bytesPerSecond = (r2 * r3) * 2;
    }

    @Override // com.obric.audiocodecsdk.encoder.AudioEncoder
    public void start() {
        this.mediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
        MediaFormat r0 = MediaFormat.createAudioFormat("audio/mp4a-latm", this.sampleRate, this.channel);
        r0.setInteger("bitrate", this.bitrate);
        r0.setInteger("aac-profile", 2);
        r0.setInteger("max-input-size", this.bufferSize);
        Intrinsics.checkNotNullExpressionValue(r0, "createAudioFormat(MediaF…ZE, bufferSize)\n        }");
        MediaCodec r1 = this.mediaCodec;
        if (r1 == null) goto L5;
        r1.configure(r0, null, null, 1);
    L5:
        MediaCodec r2 = this.mediaCodec;
        if (r2 == null) goto L8;
        r2.start();
    L8:
        this.mediaMuxer = new MediaMuxer(this.outputFilePath, 0);
        setTotalBytes(0);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00db -> B:46:0x00dc). Please report as a decompilation issue!!! */
    @Override // com.obric.audiocodecsdk.encoder.AudioEncoder
    public void encode(byte[] r22, int r23) {
        Intrinsics.checkNotNullParameter(r22, "buffer");
        int r3 = r22.length;
        int r0 = 0;
        int r5 = 0;
    L3:
        if (r0 >= r3) goto L87;
        MediaCodec r6 = this.mediaCodec;
        if (r6 == null) goto L7;
        int r11 = r6.dequeueInputBuffer(10000);
    L9:
        if (r11 < 0) goto L10;
        MediaCodec r7 = this.mediaCodec;
        if (r7 == null) goto L16;
        ByteBuffer r8 = r7.getInputBuffer(r11);
    L17:
        if (r8 == null) goto L19;
        r8.clear();
    L19:
        if (r8 == null) goto L21;
        int r12 = r8.capacity();
    L22:
        int r14 = Math.min((r12 * 9) / 10, r3 - r0);
        if (r8 == null) goto L25;
        r8.put(r22, r0, r14);
    L25:
        int r9 = r0 + r14;
        MediaCodec.BufferInfo r15 = new MediaCodec.BufferInfo();
        int r20 = r9;
        long r4 = ((getTotalBytes() * 1000) / ((long) this.bytesPerSecond)) * 1000;     // Catch: Exception -> L39
        XLog.INSTANCE.d(this.TAG, "encode totalBytes " + getTotalBytes() + " bytesPerSecond " + this.bytesPerSecond + " pts " + r4);     // Catch: Exception -> L39
        MediaCodec r10 = this.mediaCodec;     // Catch: Exception -> L39
        if (r10 == null) goto L34;
        int r13 = r14;
        MediaCodec.BufferInfo r16 = r15;
        r10.queueInputBuffer(r11, 0, r14, r4, 0);     // Catch: Exception -> L32
    L35:
        MediaCodec r1 = this.mediaCodec;     // Catch: Exception -> L32
        if (r1 == null) goto L45;
        int r2 = r1.dequeueOutputBuffer(r16, 10000);     // Catch: Exception -> L32
    L46:
        if (r2 < 0) goto L69;
        MediaCodec r17 = this.mediaCodec;
        if (r17 == null) goto L50;
        ByteBuffer r18 = r17.getOutputBuffer(r2);
    L51:
        if (r18 == null) goto L53;
        r18.position(r16.offset);
    L53:
        if (r18 == null) goto L56;
        r18.limit(r16.offset + r16.size);
    L56:
        if (this.audioTrackIndex != (-1)) goto L63;
        MediaCodec r19 = this.mediaCodec;
        if (r19 == null) goto L60;
        MediaFormat r21 = r19.getOutputFormat();
    L61:
        MediaMuxer r110 = this.mediaMuxer;
        Intrinsics.checkNotNull(r110);
        Intrinsics.checkNotNull(r21);
        this.audioTrackIndex = r110.addTrack(r21);
        MediaMuxer r24 = this.mediaMuxer;
        Intrinsics.checkNotNull(r24);
        r24.start();
        this.muxerStarted = true;
        goto L63
    L60:
        r21 = null;
    L63:
        MediaMuxer r25 = this.mediaMuxer;
        Intrinsics.checkNotNull(r25);
        int r111 = this.audioTrackIndex;
        Intrinsics.checkNotNull(r18);
        r25.writeSampleData(r111, r18, r16);
        MediaCodec r26 = this.mediaCodec;
        if (r26 == null) goto L66;
        r26.releaseOutputBuffer(r2, false);
    L66:
        MediaCodec r27 = this.mediaCodec;
        if (r27 == null) goto L45;
        r2 = r27.dequeueOutputBuffer(r16, 10000);
        goto L46
    L50:
        r18 = null;
        goto L51
    L69:
        setTotalBytes(getTotalBytes() + ((long) r13));
        r5 = 0;
        r0 = r20;
    L45:
        r2 = -1;
    L32:
        e = e;
    L44:
        XLog.INSTANCE.e(this.TAG, "queueInputBuffer", e);
        goto L45
    L34:
        r13 = r14;
        r16 = r15;
    L39:
        e = e;
    L43:
        r13 = r14;
        r16 = r15;
    L41:
        e = e;
        r20 = r9;
        goto L43
    L21:
        r12 = 0;
        goto L22
    L16:
        r8 = null;
        goto L17
    L10:
        XLog.INSTANCE.e(this.TAG, "inputBufferIndex < 0");
        r5 = r5 + 1;
        if (r5 < 10) goto L3;
        XLog.INSTANCE.e(this.TAG, "Max retry count reached, exiting");
        return;
    L7:
        r11 = -1;
        goto L9
    }

    @Override // com.obric.audiocodecsdk.encoder.AudioEncoder
    public void stop() {
        XLog.INSTANCE.d(this.TAG, "stop");
        MediaCodec r0 = this.mediaCodec;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        MediaCodec r1 = this.mediaCodec;
        if (r1 == null) goto L9;
        r1.release();
    L9:
        if (this.muxerStarted == false) goto L14;
        MediaMuxer r2 = this.mediaMuxer;
        if (r2 == null) goto L13;
        r2.stop();
    L13:
        this.muxerStarted = false;
    L14:
        MediaMuxer r3 = this.mediaMuxer;
        if (r3 == null) goto L18;
        r3.release();
        return;
    }
}
