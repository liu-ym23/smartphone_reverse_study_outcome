package com.android.ttcjpaysdk.thirdparty.voiceprint.record;

import androidx.camera.video.AudioStats;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoicePcmStats;", "", "sampleCount", "", "rms", "", "clipRatio", "zeroCrossingRate", "(JDDD)V", "getClipRatio", "()D", "getRms", "getSampleCount", "()J", "getZeroCrossingRate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "isAbnormalClipping", "isImplausibleZcr", "isLikelySilent", "toString", "", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePcmStats {
    private static final double CLIP_RATIO_THRESHOLD = 0.05d;
    public static final Companion Companion = null;
    private static final double MAX_ZCR_FOR_VOICE = 0.5d;
    private static final long MIN_SAMPLES_FOR_ZCR = 4096;
    private static final double MIN_ZCR_FOR_VOICE = 0.001d;
    private static final double SILENT_RMS_THRESHOLD = 30.0d;
    private static final String TAG = "VoicePcmStats";
    private final double clipRatio;
    private final double rms;
    private final long sampleCount;
    private final double zeroCrossingRate;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoicePcmStats$Companion;", "", "()V", "CLIP_RATIO_THRESHOLD", "", "MAX_ZCR_FOR_VOICE", "MIN_SAMPLES_FOR_ZCR", "", "MIN_ZCR_FOR_VOICE", "SILENT_RMS_THRESHOLD", "TAG", "", "computeFromOutput", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoicePcmStats;", "buffer", "Ljava/io/ByteArrayOutputStream;", "computeFromPcm16Le", "pcmBytes", "", "offset", "", "length", "computeFromWav", "wavBytes", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final VoicePcmStats computeFromOutput(ByteArrayOutputStream r100) {
            Intrinsics.checkNotNullParameter(r100, "buffer");
            return computeFromWav(r100.toByteArray());
        }

        public final VoicePcmStats computeFromWav(byte[] r110) {
            Intrinsics.checkNotNullParameter(r110, "wavBytes");
            if (r110.length <= 44) goto L5;
            return computeFromPcm16Le(r110, 44, r110.length - 44);
        L8:
            th = move-exception;
            CJLogger.c(VoicePcmStats.TAG, "computeFromWav fail", th);
            return new VoicePcmStats(0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        L5:
            return new VoicePcmStats(0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        }

        public final VoicePcmStats computeFromPcm16Le(byte[] r210, int r211, int r212) {
            byte[] r100 = r210;
            Intrinsics.checkNotNullParameter(r100, "pcmBytes");
            short r101 = 0;
            if (r100.length != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L40;
            if (r212 < 2) goto L40;
            if (r211 < 0) goto L40;
            if ((r211 + r212) > r100.length) goto L40;
            int r103 = r211 + (r212 & (-2));
            int r104 = r211;
            long r105 = 0;
            long r106 = 0;
            double r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
            long r111 = 0;
        L14:
            int r107 = r104 + 1;
            if (r107 >= r103) goto L27;
            short r108 = (short) (((r100[r107] & UByte.MAX_VALUE) << 8) | (r100[r104] & UByte.MAX_VALUE));
            double r109 = r108;
            r110 = r110 + (r109 * r109);
            if (Math.abs(r108) < 32760) goto L20;
            r111 = r111 + 1;
        L20:
            if (r106 <= 0) goto L24;
            long r112 = r101;
            int r113 = r103;
            if ((r112 * ((long) r108)) >= 0) goto L25;
            r105 = r105 + 1;
        L25:
            r106 = r106 + 1;
            r104 = r104 + 2;
            r100 = r210;
            r103 = r113;
            r101 = r108;
            goto L14
        L24:
            r113 = r103;
            goto L25
        L27:
            if (r106 <= 0) goto L29;
            double r114 = Math.sqrt(r110 / r106);
        L30:
            if (r106 <= 0) goto L32;
            double r115 = r111 / r106;
        L34:
            if (r106 <= 1) goto L36;
            double r116 = r105 / (r106 - 1);
        L38:
            return new VoicePcmStats(r106, r114, r115, r116);
        L36:
            r116 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L38
        L32:
            r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L34
        L29:
            r114 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L40:
            return new VoicePcmStats(0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        L5:
            r102 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ VoicePcmStats copy$default(VoicePcmStats r100, long r110, double r111, double r112, double r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r101 = r100.sampleCount;
    L7:
        if ((r114 & 2) == 0) goto L9;
        double r102 = r100.rms;
    L11:
        if ((r114 & 4) == 0) goto L13;
        double r103 = r100.clipRatio;
    L15:
        if ((r114 & 8) == 0) goto L17;
        double r104 = r100.zeroCrossingRate;
    L19:
        return r100.copy(r101, r102, r103, r104);
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final long component1() {
        return this.sampleCount;
    }

    public final double component2() {
        return this.rms;
    }

    public final double component3() {
        return this.clipRatio;
    }

    public final double component4() {
        return this.zeroCrossingRate;
    }

    public final VoicePcmStats copy(long r110, double r111, double r112, double r113) {
        return new VoicePcmStats(r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoicePcmStats) == true) goto L8;
        return false;
    L8:
        VoicePcmStats r101 = (VoicePcmStats) r100;
        if (this.sampleCount == r101.sampleCount) goto L12;
        return false;
    L12:
        if (Double.compare(this.rms, r101.rms) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.clipRatio, r101.clipRatio) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.zeroCrossingRate, r101.zeroCrossingRate) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.sampleCount;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.rms);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.clipRatio);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.zeroCrossingRate);
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public String toString() {
        return "VoicePcmStats(sampleCount=" + this.sampleCount + ", rms=" + this.rms + ", clipRatio=" + this.clipRatio + ", zeroCrossingRate=" + this.zeroCrossingRate + ')';
    }

    public final boolean isAbnormalClipping() {
        if (this.clipRatio <= CLIP_RATIO_THRESHOLD) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isImplausibleZcr() {
        if (this.sampleCount <= 4096) goto L9;
        double r100 = this.zeroCrossingRate;
        if (r100 >= MIN_ZCR_FOR_VOICE) goto L7;
    L8:
        return true;
    L7:
        if (r100 > 0.5d) goto L8;
    L9:
        return false;
    }

    public final boolean isLikelySilent() {
        if (this.sampleCount > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.rms >= SILENT_RMS_THRESHOLD) goto L7;
        return true;
    }

    public final double getClipRatio() {
        return this.clipRatio;
    }

    public final double getRms() {
        return this.rms;
    }

    public final long getSampleCount() {
        return this.sampleCount;
    }

    public final double getZeroCrossingRate() {
        return this.zeroCrossingRate;
    }

    public VoicePcmStats(long r100, double r101, double r102, double r103) {
        this.sampleCount = r100;
        this.rms = r101;
        this.clipRatio = r102;
        this.zeroCrossingRate = r103;
    }
}
