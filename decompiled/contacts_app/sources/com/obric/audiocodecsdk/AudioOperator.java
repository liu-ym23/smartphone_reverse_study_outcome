package com.obric.audiocodecsdk;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.audiocodecsdk.encoder.AudioEncoder;
import com.obric.audiocodecsdk.encoder.EncoderFactory;
import com.obric.audiocodecsdk.encoder.EncoderType;
import com.obric.audiocodecsdk.log.XLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AudioOperator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J$\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0019\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/audiocodecsdk/AudioOperator;", "", "()V", "TAG", "", "clipDecodedDataCallback", "Lcom/obric/audiocodecsdk/AudioOperator$DecodedDataCallback;", "mergeDecodedDataCallback", "clip", "", "inputFilepath", "outputFilepath", "startTime", "", "endTime", "getEncoderType", "Lcom/obric/audiocodecsdk/encoder/EncoderType;", Params.FILE_PATH, "merge", "inputFiles", "", "outType", "setClipDecodedDataCallback", "", "callback", "setMergeDecodedDataCallback", "DecodedDataCallback", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AudioOperator {
    private final String TAG;
    private DecodedDataCallback clipDecodedDataCallback;
    private DecodedDataCallback mergeDecodedDataCallback;

    /* JADX INFO: compiled from: AudioOperator.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/audiocodecsdk/AudioOperator$DecodedDataCallback;", "", "onDecodedData", "", "data", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DecodedDataCallback {
        void onDecodedData(byte[] r1, int r2);
    }

    public AudioOperator() {
        this.TAG = "AudioOperator";
    }

    public final boolean clip(String r8, String r9, long r10, long r12) {
        Intrinsics.checkNotNullParameter(r8, "inputFilepath");
        Intrinsics.checkNotNullParameter(r9, "outputFilepath");
        AudioDecoder r0 = new AudioDecoder(r8, r10, r12);
        if (r0.init() == true) goto L6;
        XLog.INSTANCE.e(this.TAG, "init decoder failed");
        return false;
    L6:
        AudioEncoder r11 = EncoderFactory.createEncoder(getEncoderType(r8), r0.getSampleRate(), r0.getChannel(), r0.getBitRate(), r0.getMaxInputSize(), r9);
        if (r11 != null) goto L10;
        XLog.INSTANCE.e(this.TAG, "encoder == null");
        return false;
    L10:
        r11.start();
    L12:
        if (r0.isReadFinish() == true) goto L23;
        List<byte[]> r13 = r0.decode();
        if (r13 == null) goto L15;
        Iterator<byte[]> r14 = r13.iterator();
    L18:
        if (r14.hasNext() == false) goto L12;
        byte[] r15 = r14.next();
        DecodedDataCallback r16 = this.clipDecodedDataCallback;
        if (r16 == null) goto L22;
        r16.onDecodedData(r15, r15.length);
    L22:
        r11.encode(r15, r15.length);
        goto L18
    L15:
        XLog.INSTANCE.e(this.TAG, "parseEncodedFile decodedBuffers is null");
    L23:
        r11.stop();
        r0.release();
        return true;
    }

    public final boolean merge(List<String> r9, String r10, EncoderType r11) {
        Intrinsics.checkNotNullParameter(r9, "inputFiles");
        Intrinsics.checkNotNullParameter(r10, "outputFilepath");
        Intrinsics.checkNotNullParameter(r11, "outType");
        ArrayList r0 = new ArrayList();
        Iterator<T> r12 = r9.iterator();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r12.hasNext() == false) goto L10;
        AudioDecoder r7 = new AudioDecoder((String) r12.next());
        if (r7.init() == false) goto L7;
        r3 = Math.max(r3, r7.getSampleRate());
        r4 = Math.max(r4, r7.getChannel());
        r5 = Math.max(r5, r7.getBitRate());
        r6 = Math.max(r6, r7.getMaxInputSize());
        r0.add(r7);
        goto L4
    L7:
        XLog.INSTANCE.e(this.TAG, "init decoder failed");
        return false;
    L10:
        AudioEncoder r13 = EncoderFactory.createEncoder(r11, r3, r4, r5, r6, r10);
        if (r13 != null) goto L14;
        XLog.INSTANCE.e(this.TAG, "create encoder failed");
        return false;
    L14:
        r13.start();
        Iterator r14 = r0.iterator();
    L16:
        if (r14.hasNext() == false) goto L30;
        AudioDecoder r15 = (AudioDecoder) r14.next();
    L19:
        if (r15.isReadFinish() == true) goto L29;
        List<byte[]> r1 = r15.decode();
        if (r1 == null) goto L19;
        Iterator<T> r2 = r1.iterator();
    L24:
        if (r2.hasNext() == false) goto L19;
        byte[] r8 = (byte[]) r2.next();
        DecodedDataCallback r16 = this.mergeDecodedDataCallback;
        if (r16 == null) goto L28;
        r16.onDecodedData(r8, r8.length);
    L28:
        r13.encode(r8, r8.length);
        goto L24
    L29:
        r15.release();
        goto L16
    L30:
        r13.stop();
        return true;
    }

    public final void setClipDecodedDataCallback(DecodedDataCallback r1) {
        this.clipDecodedDataCallback = r1;
    }

    public final void setMergeDecodedDataCallback(DecodedDataCallback r1) {
        this.mergeDecodedDataCallback = r1;
    }

    private final EncoderType getEncoderType(String r7) {
        MediaExtractor r6 = new MediaExtractor();
        r6.setDataSource(r7);     // Catch: Throwable -> L35 Exception -> L37
        int r8 = r6.getTrackCount();     // Catch: Throwable -> L35 Exception -> L37
        int r1 = 0;
    L4:
        if (r1 >= r8) goto L33;
        MediaFormat r2 = r6.getTrackFormat(r1);     // Catch: Throwable -> L35 Exception -> L37
        Intrinsics.checkNotNullExpressionValue(r2, "extractor.getTrackFormat(i)");     // Catch: Throwable -> L35 Exception -> L37
        String r3 = r2.getString("mime");     // Catch: Throwable -> L35 Exception -> L37
        if (r3 == null) goto L10;
        boolean r4 = true;
        if (StringsKt.startsWith$default(r3, "audio/", false, 2, null) != true) goto L10;
    L11:
        if (r4 == true) goto L12;
        r1 = r1 + 1;
        goto L4
    L12:
        int r9 = r3.hashCode();     // Catch: Throwable -> L35 Exception -> L37
        if (r9 == (-53558318)) goto L27;
        if (r9 == 187094639) goto L23;
        if (r9 == 1504831518) goto L20;
    L28:
        EncoderType r10 = EncoderType.UNKNOWN;     // Catch: Throwable -> L35 Exception -> L37
    L30:
        r6.release();
        return r10;
    L20:
        if (r3.equals("audio/mpeg") == false) goto L28;
        r10 = EncoderType.MP3;     // Catch: Throwable -> L35 Exception -> L37
        goto L30
    L23:
        if (r3.equals("audio/raw") == false) goto L28;
        r10 = EncoderType.WAV;     // Catch: Throwable -> L35 Exception -> L37
        goto L30
    L27:
        if (r3.equals("audio/mp4a-latm") == false) goto L28;
        r10 = EncoderType.AAC;     // Catch: Throwable -> L35 Exception -> L37
    L10:
        r4 = false;
        goto L11
    L33:
        EncoderType r11 = EncoderType.UNKNOWN;     // Catch: Throwable -> L35 Exception -> L37
    L39:
        r6.release();
        return r11;
    L35:
        th = move-exception;
        r6.release();
        throw th;
    L37:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L35
        r11 = EncoderType.UNKNOWN;     // Catch: Throwable -> L35
        goto L39
    }
}
