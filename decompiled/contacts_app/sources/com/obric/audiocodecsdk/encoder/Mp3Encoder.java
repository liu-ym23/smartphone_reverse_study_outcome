package com.obric.audiocodecsdk.encoder;

import com.bytedance.apm.constant.PerfConsts;
import com.obric.audiocodecsdk.log.XLog;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Mp3Encoder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/audiocodecsdk/encoder/Mp3Encoder;", "Lcom/obric/audiocodecsdk/encoder/AudioEncoder;", "sampleRate", "", "channel", "bitrate", "bufferSize", "outputFilePath", "", "(IIIILjava/lang/String;)V", "TAG", "getBitrate", "()I", "getChannel", "fileOutputStream", "Ljava/io/FileOutputStream;", "lameHandler", "", "mp3Buffer", "", "getSampleRate", "byteArrayToShortArray", "", "byteArray", "sizeInBytes", "encode", "", "buffer", PerfConsts.PERF_DISK_FILE_SIZE, "start", "stop", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Mp3Encoder extends AudioEncoder {
    private final String TAG;
    private final int bitrate;
    private final int bufferSize;
    private final int channel;
    private FileOutputStream fileOutputStream;
    private long lameHandler;
    private byte[] mp3Buffer;
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

    public Mp3Encoder(int r2, int r3, int r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "outputFilePath");
        this.sampleRate = r2;
        this.channel = r3;
        this.bitrate = r4;
        this.bufferSize = r5;
        this.outputFilePath = r6;
        this.TAG = "Mp3Encoder";
    }

    @Override // com.obric.audiocodecsdk.encoder.AudioEncoder
    public void start() {
        XLog.INSTANCE.d(this.TAG, "start");
        this.mp3Buffer = new byte[(int) (((double) 7200) + (((double) (this.bufferSize * 2)) * 1.25d))];
        this.fileOutputStream = new FileOutputStream(this.outputFilePath);
        setTotalBytes(0);
        int r0 = this.sampleRate;
        this.lameHandler = LameInterf.init(r0, this.channel, r0, this.bitrate, 5);
    }

    @Override // com.obric.audiocodecsdk.encoder.AudioEncoder
    public void encode(byte[] r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "buffer");
        if (r10 != 0) goto L6;
        XLog.INSTANCE.w(this.TAG, "encode size is 0");
        return;
    L6:
        short[] r3 = byteArrayToShortArray(r9, r10);
        long r0 = this.lameHandler;
        int r4 = r3.length;
        byte[] r11 = this.mp3Buffer;
        byte[] r7 = null;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mp3Buffer");
        byte[] r5 = null;
    L10:
        int r12 = LameInterf.encode(r0, r3, r3, r4, r5);
        if (r12 > 0) goto L26;
        XLog.INSTANCE.e(this.TAG, "encode get encodedSize " + r12);
        return;
    L26:
        FileOutputStream r1 = this.fileOutputStream;     // Catch: IOException -> L21
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("fileOutputStream");     // Catch: IOException -> L21
        r1 = null;
    L15:
        byte[] r2 = this.mp3Buffer;     // Catch: IOException -> L21
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mp3Buffer");     // Catch: IOException -> L21
    L19:
        r1.write(r7, 0, r12);     // Catch: IOException -> L21
    L23:
        setTotalBytes(getTotalBytes() + ((long) r10));
        return;
    L18:
        r7 = r2;
    L21:
        e = move-exception;
        XLog.INSTANCE.e(this.TAG, "encode", e);
        goto L23
    L9:
        r5 = r11;
        goto L10
    }

    @Override // com.obric.audiocodecsdk.encoder.AudioEncoder
    public void stop() {
        XLog.INSTANCE.d(this.TAG, "stop");
        long r0 = this.lameHandler;
        byte[] r2 = this.mp3Buffer;
        FileOutputStream r4 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mp3Buffer");
        r2 = null;
    L5:
        int r1 = LameInterf.flush(r0, r2);
        XLog.INSTANCE.d(this.TAG, "flush size " + r1);
        if (r1 <= 0) goto L29;
        FileOutputStream r3 = this.fileOutputStream;     // Catch: IOException -> L15
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("fileOutputStream");     // Catch: IOException -> L15
        r3 = null;
    L10:
        byte[] r5 = this.mp3Buffer;     // Catch: IOException -> L15
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mp3Buffer");     // Catch: IOException -> L15
        r5 = null;
    L13:
        r3.write(r5, 0, r1);     // Catch: IOException -> L15
    L15:
        e = move-exception;
        XLog.INSTANCE.e(this.TAG, "stop write file", e);
    L29:
        FileOutputStream r6 = this.fileOutputStream;     // Catch: IOException -> L23
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("fileOutputStream");     // Catch: IOException -> L23
    L21:
        r4.close();     // Catch: IOException -> L23
    L25:
        LameInterf.close(this.lameHandler);
        return;
    L20:
        r4 = r6;
    L23:
        e = move-exception;
        XLog.INSTANCE.e(this.TAG, "stop close file", e);
        goto L25
    }

    private final short[] byteArrayToShortArray(byte[] r4, int r5) {
        int r6 = r5 / 2;
        short[] r3 = new short[r6];
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        int r1 = r0 * 2;
        int r2 = r4[r1 + 1] << 8;
        r3[r0] = (short) ((r4[r1] & 255) | r2);
        r0 = r0 + 1;
        goto L3
    L5:
        return r3;
    }
}
