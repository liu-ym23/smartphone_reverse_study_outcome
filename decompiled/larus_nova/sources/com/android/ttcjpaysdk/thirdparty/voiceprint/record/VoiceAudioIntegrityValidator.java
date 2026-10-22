package com.android.ttcjpaysdk.thirdparty.voiceprint.record;

import com.alipay.sdk.m.l.c;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.obric.miniapp.alarm.AccountType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator;", "", "()V", "EXPECTED_BITS_PER_SAMPLE", "", "EXPECTED_CHANNELS", "EXPECTED_SAMPLE_RATE", "MAX_DURATION_MS", "", "MIN_DURATION_MS", "TAG", "", "matchesAscii", "", HTTP.CONTENT_RANGE_BYTES, "", "offset", "ascii", "readIntLe", "readShortLe", "", c.f25505j, "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator$Result;", "audio", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceSealedAudio;", "Reasons", "Result", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoiceAudioIntegrityValidator {
    private static final int EXPECTED_BITS_PER_SAMPLE = 16;
    private static final int EXPECTED_CHANNELS = 1;
    private static final int EXPECTED_SAMPLE_RATE = 44100;
    public static final VoiceAudioIntegrityValidator INSTANCE = null;
    private static final long MAX_DURATION_MS = 12000;
    private static final long MIN_DURATION_MS = 800;
    private static final String TAG = "VoiceAudioIntegrityValidator";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator$Reasons;", "", "()V", AccountType.ALL, "", "", "getALL", "()Ljava/util/Set;", "BAD_BITS", "BAD_CHANNELS", "BAD_RIFF_HEADER", "BAD_SAMPLE_RATE", "DATA_SIZE_MISMATCH", "DURATION_TOO_LONG", "DURATION_TOO_SHORT", "NOT_PCM", "PCM_COUNT_MISMATCH", "SIGNAL_BAD_ZCR", "SIGNAL_CLIPPED", "SIGNAL_SILENT", "SIZE_TOO_SMALL", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Reasons {
        private static final Set<String> ALL = null;
        public static final String BAD_BITS = "bad_bits";
        public static final String BAD_CHANNELS = "bad_channels";
        public static final String BAD_RIFF_HEADER = "bad_riff_header";
        public static final String BAD_SAMPLE_RATE = "bad_sample_rate";
        public static final String DATA_SIZE_MISMATCH = "data_size_mismatch";
        public static final String DURATION_TOO_LONG = "duration_too_long";
        public static final String DURATION_TOO_SHORT = "duration_too_short";
        public static final Reasons INSTANCE = null;
        public static final String NOT_PCM = "not_pcm";
        public static final String PCM_COUNT_MISMATCH = "pcm_count_mismatch";
        public static final String SIGNAL_BAD_ZCR = "signal_bad_zcr";
        public static final String SIGNAL_CLIPPED = "signal_clipped";
        public static final String SIGNAL_SILENT = "signal_silent";
        public static final String SIZE_TOO_SMALL = "size_too_small";

        private Reasons() {
        }

        static {
            INSTANCE = new Reasons();
            ALL = SetsKt.setOf(new String[]{SIZE_TOO_SMALL, BAD_RIFF_HEADER, NOT_PCM, BAD_CHANNELS, BAD_SAMPLE_RATE, BAD_BITS, DATA_SIZE_MISMATCH, PCM_COUNT_MISMATCH, DURATION_TOO_SHORT, DURATION_TOO_LONG, SIGNAL_SILENT, SIGNAL_CLIPPED, SIGNAL_BAD_ZCR});
        }

        public final Set<String> getALL() {
            return ALL;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator$Result;", "", "()V", "Failed", "Ok", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator$Result$Failed;", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator$Result$Ok;", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator$Result$Failed;", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator$Result;", "reason", "", "detail", "(Ljava/lang/String;Ljava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "getReason", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Failed extends Result {
            private final String detail;
            private final String reason;

            public static /* synthetic */ Failed copy$default(Failed r100, String r101, String r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.reason;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.detail;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.reason;
            }

            public final String component2() {
                return this.detail;
            }

            public final Failed copy(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                Intrinsics.checkNotNullParameter(r101, "detail");
                return new Failed(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof Failed) == true) goto L8;
                return false;
            L8:
                Failed r101 = (Failed) r100;
                if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.detail, r101.detail) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.reason.hashCode() * 31) + this.detail.hashCode();
            }

            public String toString() {
                return "Failed(reason=" + this.reason + ", detail=" + this.detail + ')';
            }

            public final String getDetail() {
                return this.detail;
            }

            public final String getReason() {
                return this.reason;
            }

            public Failed(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                Intrinsics.checkNotNullParameter(r101, "detail");
                super(null);
                this.reason = r100;
                this.detail = r101;
            }

            public /* synthetic */ Failed(String r100, String r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 2) == 0) goto L5;
                r101 = "";
            L5:
                this(r100, r101);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator$Result$Ok;", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceAudioIntegrityValidator$Result;", "()V", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Ok extends Result {
            public static final Ok INSTANCE = null;

            static {
                INSTANCE = new Ok();
            }

            private Ok() {
                super(null);
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        INSTANCE = new VoiceAudioIntegrityValidator();
    }

    private VoiceAudioIntegrityValidator() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Result validate(VoiceSealedAudio r110) {
        Intrinsics.checkNotNullParameter(r110, "audio");
        byte[] r100 = r110.getBytes();
        if (r100.length > 44) goto L7;
        return new Result.Failed(Reasons.SIZE_TOO_SMALL, "size=" + r100.length);
    L7:
        if (matchesAscii(r100, 0, "RIFF") == false) goto L63;
        if (matchesAscii(r100, 8, "WAVE") == false) goto L63;
        if (matchesAscii(r100, 12, "fmt ") == false) goto L63;
        if (matchesAscii(r100, 36, "data") == false) goto L63;
        int r101 = readShortLe(r100, 20) & 65535;
        int r102 = readShortLe(r100, 22) & 65535;
        int r103 = readIntLe(r100, 24);
        int r104 = 65535 & readShortLe(r100, 34);
        int r105 = readIntLe(r100, 40);
        if (r101 != 1) goto L18;
        if (r102 == 1) goto L23;
        return new Result.Failed(Reasons.BAD_CHANNELS, "channels=" + r102);
    L23:
        if (r103 == EXPECTED_SAMPLE_RATE) goto L27;
        return new Result.Failed(Reasons.BAD_SAMPLE_RATE, "sampleRate=" + r103);
    L27:
        if (r104 != 16) goto L29;
        long r106 = r100.length - 44;
        if (r105 == r106) goto L35;
        return new Result.Failed(Reasons.DATA_SIZE_MISMATCH, "header=" + r105 + ", actual=" + r106);
    L35:
        if (r110.getPcmByteCount() > 0) goto L37;
    L40:
        long r107 = r110.getDurationMs();
        if (r107 >= 800) goto L45;
        return new Result.Failed(Reasons.DURATION_TOO_SHORT, "ms=" + r107);
    L45:
        if (r107 > MAX_DURATION_MS) goto L47;
        VoicePcmStats r111 = VoicePcmStats.Companion.computeFromWav(r100);
        if (r111.isLikelySilent() == false) goto L53;
        return new Result.Failed(Reasons.SIGNAL_SILENT, "rms=" + r111.getRms());
    L53:
        if (r111.isAbnormalClipping() == false) goto L57;
        return new Result.Failed(Reasons.SIGNAL_CLIPPED, "ratio=" + r111.getClipRatio());
    L57:
        if (r111.isImplausibleZcr() == true) goto L59;
        CJLogger.d(TAG, "validate ok: size=" + r100.length + ", sr=" + r103 + ", ch=" + r102 + ", bits=" + r104 + ", dur=" + r107 + " ms");
        return Result.Ok.INSTANCE;
    L59:
        return new Result.Failed(Reasons.SIGNAL_BAD_ZCR, "zcr=" + r111.getZeroCrossingRate());
    L47:
        return new Result.Failed(Reasons.DURATION_TOO_LONG, "ms=" + r107);
    L37:
        if (r110.getPcmByteCount() == r106) goto L40;
        return new Result.Failed(Reasons.PCM_COUNT_MISMATCH, "tracked=" + r110.getPcmByteCount() + ", actual=" + r106);
    L29:
        return new Result.Failed(Reasons.BAD_BITS, "bits=" + r104);
    L18:
        return new Result.Failed(Reasons.NOT_PCM, "audioFormat=" + r101);
    L63:
        return new Result.Failed(Reasons.BAD_RIFF_HEADER, null, 2, 0 == true ? 1 : 0);
    }

    private final int readIntLe(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        int r103 = r100[r101 + 1] & UByte.MAX_VALUE;
        int r104 = r100[r101 + 2] & UByte.MAX_VALUE;
        return ((((r100[r101 + 3] & UByte.MAX_VALUE) << 24) | (r104 << 16)) | (r103 << 8)) | r102;
    }

    private final short readShortLe(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        return (short) (((r100[r101 + 1] & UByte.MAX_VALUE) << 8) | r102);
    }

    private final boolean matchesAscii(byte[] r100, int r101, String r102) {
        if ((r102.length() + r101) <= r100.length) goto L5;
        return false;
    L5:
        int r103 = r102.length();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        if ((r100[r101 + r104] & UByte.MAX_VALUE) != (r102.charAt(r104) & 255)) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }
}
