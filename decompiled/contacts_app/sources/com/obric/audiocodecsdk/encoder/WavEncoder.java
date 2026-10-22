package com.obric.audiocodecsdk.encoder;

import com.bytedance.apm.constant.PerfConsts;
import com.google.common.base.Ascii;
import com.obric.audiocodecsdk.log.XLog;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WavEncoder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/audiocodecsdk/encoder/WavEncoder;", "Lcom/obric/audiocodecsdk/encoder/AudioEncoder;", "sampleRate", "", "channel", "bitrate", "bufferSize", "outputFilePath", "", "(IIIILjava/lang/String;)V", "TAG", "getBitrate", "()I", "getChannel", "outFile", "Ljava/io/RandomAccessFile;", "getSampleRate", "encode", "", "buffer", "", PerfConsts.PERF_DISK_FILE_SIZE, "start", "stop", "writeWavHeader", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WavEncoder extends AudioEncoder {
    private final String TAG;
    private final int bitrate;
    private final int bufferSize;
    private final int channel;
    private RandomAccessFile outFile;
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

    public WavEncoder(int r2, int r3, int r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "outputFilePath");
        this.sampleRate = r2;
        this.channel = r3;
        this.bitrate = r4;
        this.bufferSize = r5;
        this.outputFilePath = r6;
        this.TAG = "WavEncoder";
    }

    @Override // com.obric.audiocodecsdk.encoder.AudioEncoder
    public void start() {
        XLog.INSTANCE.d(this.TAG, "start");
        this.outFile = new RandomAccessFile(this.outputFilePath, "rw");
        setTotalBytes(0);
        writeWavHeader();
    }

    @Override // com.obric.audiocodecsdk.encoder.AudioEncoder
    public void encode(byte[] r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "buffer");
        RandomAccessFile r0 = this.outFile;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("outFile");
        r0 = null;
    L5:
        r0.write(r3, 0, r4);
        setTotalBytes(getTotalBytes() + ((long) r4));
    }

    @Override // com.obric.audiocodecsdk.encoder.AudioEncoder
    public void stop() {
        XLog.INSTANCE.d(this.TAG, "stop");
        RandomAccessFile r0 = this.outFile;
        RandomAccessFile r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("outFile");
        r0 = null;
    L5:
        r0.seek(0);
        writeWavHeader();
        RandomAccessFile r5 = this.outFile;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("outFile");
    L9:
        r1.close();
        return;
    L8:
        r1 = r5;
        goto L9
    }

    private final void writeWavHeader() {
        long r1 = getTotalBytes() + ((long) 36);
        int r4 = this.sampleRate;
        int r5 = this.channel;
        int r6 = ((r4 * r5) * 16) / 8;
        byte[] r10 = {82, 73, 70, 70, (byte) (r1 & 255), (byte) ((r1 >> 8) & 255), (byte) ((r1 >> 16) & 255), (byte) ((r1 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, Ascii.DLE, 0, 0, 0, 1, 0, (byte) r5, 0, (byte) (r4 & 255), (byte) ((r4 >> 8) & 255), (byte) ((r4 >> 16) & 255), (byte) ((r4 >> 24) & 255), (byte) (r6 & 255), (byte) ((r6 >> 8) & 255), (byte) ((r6 >> 16) & 255), (byte) ((r6 >> 24) & 255), (byte) ((r5 * 16) / 8), 0, (byte) 16, 0, 100, 97, 116, 97, (byte) (getTotalBytes() & 255), (byte) ((getTotalBytes() >> 8) & 255), (byte) ((getTotalBytes() >> 16) & 255), (byte) ((getTotalBytes() >> 24) & 255)};
        RandomAccessFile r0 = this.outFile;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("outFile");
        r0 = null;
    L5:
        r0.write(r10, 0, 44);
    }
}
