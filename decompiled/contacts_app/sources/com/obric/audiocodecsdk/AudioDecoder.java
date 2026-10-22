package com.obric.audiocodecsdk;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.audiocodecsdk.log.XLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AudioDecoder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'J\b\u0010)\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\u000bH\u0002J\u0006\u0010+\u001a\u00020\u001eJ\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u0006R\u000e\u0010\t\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u0011\u0010$\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b%\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/audiocodecsdk/AudioDecoder;", "", "filePtah", "", "(Ljava/lang/String;)V", "startTime", "", "endTime", "(Ljava/lang/String;JJ)V", "TAG", "bitRate", "", "getBitRate", "()I", "channel", "getChannel", "codec", "Landroid/media/MediaCodec;", "currentTime", "getCurrentTime", "()J", "setCurrentTime", "(J)V", "duration", "getDuration", "extractor", "Landroid/media/MediaExtractor;", "format", "Landroid/media/MediaFormat;", "isReadFinish", "", "()Z", "setReadFinish", "(Z)V", "maxInputSize", "getMaxInputSize", "sampleRate", "getSampleRate", "decode", "", "", "getBitRateInner", "getMaxInputSizeInner", "init", "isWavFile", Params.FILE_PATH, "release", "", "seekMs", "position", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AudioDecoder {
    private final String TAG;
    private MediaCodec codec;
    private long currentTime;
    private final long endTime;
    private MediaExtractor extractor;
    private final String filePtah;
    private MediaFormat format;
    private boolean isReadFinish;
    private final long startTime;

    public AudioDecoder(String r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "filePtah");
        this.filePtah = r2;
        this.startTime = r3;
        this.endTime = r5;
        this.TAG = "AudioDecoder";
    }

    public final boolean isReadFinish() {
        return this.isReadFinish;
    }

    public final void setReadFinish(boolean r1) {
        this.isReadFinish = r1;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final void setCurrentTime(long r1) {
        this.currentTime = r1;
    }

    public final int getSampleRate() {
        MediaFormat r1 = this.format;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getInteger("sample-rate");
    }

    public final int getChannel() {
        MediaFormat r1 = this.format;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getInteger("channel-count");
    }

    public final long getDuration() {
        MediaFormat r4 = this.format;
        if (r4 == null) goto L5;
        long r0 = r4.getLong("durationUs");
    L7:
        return r0 / ((long) 1000);
    L5:
        r0 = 0;
        goto L7
    }

    public final int getBitRate() {
        return getBitRateInner();
    }

    public final int getMaxInputSize() {
        return getMaxInputSizeInner();
    }

    public AudioDecoder(String r8) {
        Intrinsics.checkNotNullParameter(r8, "filePtah");
        this(r8, 0, 0);
    }

    public final boolean init() {
        XLog.INSTANCE.d(this.TAG, "init");
        if (new File(this.filePtah).exists() == true) goto L54;
        XLog.INSTANCE.e(this.TAG, "file " + this.filePtah + " not exist");
        return false;
    L54:
        MediaExtractor r1 = new MediaExtractor();     // Catch: IOException -> L49
        this.extractor = r1;     // Catch: IOException -> L49
        r1.setDataSource(this.filePtah);     // Catch: IOException -> L49
        this.isReadFinish = false;
        this.currentTime = 0;
        MediaExtractor r2 = this.extractor;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r2 = null;
    L10:
        int r3 = r2.getTrackCount();
        int r7 = 0;
    L12:
        if (r7 >= r3) goto L25;
        MediaExtractor r12 = this.extractor;
        if (r12 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r12 = null;
    L16:
        MediaFormat r13 = r12.getTrackFormat(r7);
        Intrinsics.checkNotNullExpressionValue(r13, "extractor.getTrackFormat(i)");
        String r14 = r13.getString("mime");
        if (r14 != null) goto L19;
    L21:
        boolean r15 = false;
    L22:
        if (r15 == true) goto L23;
        r7 = r7 + 1;
        goto L12
    L23:
        this.format = r13;
    L26:
        if (r7 != (-1)) goto L28;
        return false;
    L28:
        MediaExtractor r4 = this.extractor;
        if (r4 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r4 = null;
    L31:
        r4.selectTrack(r7);
        if (this.startTime <= 0) goto L37;
        MediaExtractor r5 = this.extractor;
        if (r5 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r5 = null;
    L36:
        r5.seekTo(this.startTime * ((long) 1000), 2);
    L37:
        MediaFormat r6 = this.format;
        if (r6 == null) goto L46;
        String r8 = r6.getString("mime");
        if (r8 == null) goto L46;
        MediaCodec r9 = MediaCodec.createDecoderByType(r8);     // Catch: IOException -> L43
        r9.configure(this.format, null, null, 0);     // Catch: IOException -> L43
        r9.start();     // Catch: IOException -> L43
        this.codec = r9;     // Catch: IOException -> L43
    L43:
        e = move-exception;
        XLog.INSTANCE.e(this.TAG, "init exception", e);
    L46:
        if (this.codec != null) goto L48;
        return false;
    L48:
        return true;
    L19:
        if (StringsKt.startsWith$default(r14, "audio/", false, 2, null) != true) goto L21;
        r15 = true;
        goto L22
    L25:
        r7 = -1;
    L49:
        e = move-exception;
        XLog.INSTANCE.e(this.TAG, "init exception", e);
        return false;
    }

    public final List<byte[]> decode() {
        MediaCodec r1 = this.codec;
        if (r1 == null) goto L5;
        int r6 = r1.dequeueInputBuffer(10000);
    L7:
        if (r6 >= 0) goto L10;
        XLog.INSTANCE.e(this.TAG, "decode inputBufferIndex < 0");
        return null;
    L10:
        MediaCodec r5 = this.codec;
        if (r5 == null) goto L13;
        ByteBuffer r7 = r5.getInputBuffer(r6);
    L14:
        if (r7 != null) goto L17;
        XLog.INSTANCE.e(this.TAG, "decode inputBuffer == null");
        return null;
    L17:
        MediaExtractor r8 = this.extractor;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r8 = null;
    L20:
        int r9 = r8.readSampleData(r7, 0);
        if (r9 >= 0) goto L26;
        XLog.INSTANCE.d(this.TAG, "decode read finish");
        MediaCodec r10 = this.codec;
        if (r10 == null) goto L25;
        r10.queueInputBuffer(r6, 0, 0, 0, 4);
    L25:
        this.isReadFinish = true;
    L37:
        if (this.endTime <= 0) goto L44;
        MediaExtractor r11 = this.extractor;
        if (r11 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r11 = null;
    L42:
        if (r11.getSampleTime() <= (this.endTime * ((long) 1000))) goto L44;
        this.isReadFinish = true;
    L44:
        ArrayList r4 = new ArrayList();
        MediaCodec.BufferInfo r12 = new MediaCodec.BufferInfo();
        MediaCodec r13 = this.codec;
        if (r13 == null) goto L47;
        int r2 = r13.dequeueOutputBuffer(r12, 10000);
    L48:
        if (r2 < 0) goto L62;
        MediaCodec r3 = this.codec;
        if (r3 == null) goto L52;
        ByteBuffer r14 = r3.getOutputBuffer(r2);
    L53:
        if (r14 == null) goto L54;
        this.currentTime = r12.presentationTimeUs / ((long) 1000);
        byte[] r15 = new byte[r12.size];
        r14.get(r15);
        r14.clear();
        r4.add(r15);
        MediaCodec r16 = this.codec;
        if (r16 == null) goto L59;
        r16.releaseOutputBuffer(r2, false);
    L59:
        MediaCodec r17 = this.codec;
        if (r17 == null) goto L47;
        r2 = r17.dequeueOutputBuffer(r12, 0);
        goto L48
    L47:
        r2 = -1;
        goto L48
    L54:
        XLog.INSTANCE.e(this.TAG, "decode outputBuffer == null");
        return null;
    L52:
        r14 = null;
        goto L53
    L62:
        return r4;
    L63:
        r2 = -1;
        goto L48
    L26:
        MediaCodec r18 = this.codec;
        if (r18 == null) goto L32;
        MediaExtractor r19 = this.extractor;
        if (r19 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r19 = null;
    L31:
        r18.queueInputBuffer(r6, 0, r9, r19.getSampleTime(), 0);
    L32:
        MediaExtractor r20 = this.extractor;
        if (r20 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r20 = null;
    L35:
        r20.advance();
        goto L37
    L13:
        r7 = null;
        goto L14
    L5:
        r6 = -1;
        goto L7
    }

    public final void seekMs(long r4) {
        this.currentTime = r4;
        this.isReadFinish = false;
        MediaExtractor r0 = this.extractor;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");
        r0 = null;
    L5:
        r0.seekTo(r4 * ((long) 1000), 2);
        MediaCodec r3 = this.codec;
        if (r3 == null) goto L9;
        r3.flush();
        return;
    }

    private final int getBitRateInner() {
        int r1 = 0;
        if (isWavFile(this.filePtah) == false) goto L9;
        MediaFormat r0 = this.format;
        if (r0 == null) goto L8;
        r1 = r0.getInteger("bits-per-sample");
    L8:
        return (getSampleRate() * getChannel()) * r1;
    L9:
        MediaFormat r2 = this.format;
        if (r2 != null) goto L12;
        return 0;
    L12:
        return r2.getInteger("bitrate");
    }

    private final int getMaxInputSizeInner() {
        MediaFormat r0 = this.format;
        if (r0 == null) goto L7;
        boolean r3 = true;
        if (r0.containsKey("max-input-size") != true) goto L7;
    L8:
        if (r3 == false) goto L13;
        MediaFormat r4 = this.format;
        if (r4 != null) goto L12;
        return 0;
    L12:
        return r4.getInteger("max-input-size");
    L13:
        return 0;
    L7:
        r3 = false;
        goto L8
    }

    public final void release() {
        MediaCodec r0 = this.codec;     // Catch: IllegalStateException -> L13
        if (r0 == null) goto L5;
        r0.stop();     // Catch: IllegalStateException -> L13
    L5:
        MediaCodec r1 = this.codec;     // Catch: IllegalStateException -> L13
        if (r1 == null) goto L8;
        r1.release();     // Catch: IllegalStateException -> L13
    L8:
        MediaExtractor r2 = this.extractor;     // Catch: IllegalStateException -> L13
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("extractor");     // Catch: IllegalStateException -> L13
        r2 = null;
    L11:
        r2.release();     // Catch: IllegalStateException -> L13
        this.codec = null;     // Catch: IllegalStateException -> L13
        return;
    L13:
        e = move-exception;
        XLog.INSTANCE.e(this.TAG, "release exception", e);
    }

    private final boolean isWavFile(String r7) {
        File r6 = new File(r7);
        boolean r0 = false;
        if (r6.exists() == true) goto L5;
    L44:
        return false;
    L5:
        if (r6.isDirectory() == true) goto L44;
        FileInputStream r8 = new FileInputStream(r6);
        byte[] r2 = new byte[12];     // Catch: Throwable -> L39
        if (r8.read(r2, 0, 12) >= 12) goto L14;
        CloseableKt.closeFinally(r8, null);
        return false;
    L14:
        if (r2[0] == 82) goto L16;
    L22:
        boolean r9 = false;
    L24:
        if (r2[8] == 87) goto L26;
    L33:
        boolean r1 = false;
    L34:
        if (r9 == false) goto L37;
        if (r1 == false) goto L37;
        r0 = true;
    L37:
        CloseableKt.closeFinally(r8, null);
        return r0;
    L26:
        if (r2[9] != 65) goto L33;
        if (r2[10] != 86) goto L33;
        if (r2[11] != 69) goto L33;
        r1 = true;
        goto L34
    L16:
        if (r2[1] != 73) goto L22;
        if (r2[2] != 70) goto L22;
        if (r2[3] != 70) goto L22;
        r9 = true;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    }
}
