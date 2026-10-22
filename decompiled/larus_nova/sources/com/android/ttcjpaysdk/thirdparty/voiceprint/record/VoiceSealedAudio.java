package com.android.ttcjpaysdk.thirdparty.voiceprint.record;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000eR\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000e¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceSealedAudio;", "", HTTP.CONTENT_RANGE_BYTES, "", "sampleRate", "", "channels", "bitsPerSample", "pcmByteCount", "", "isFromMemory", "", "([BIIIJZ)V", "getBitsPerSample", "()I", "getBytes", "()[B", "getChannels", "digest", "", "getDigest", "()Ljava/lang/String;", "durationMs", "getDurationMs", "()J", "()Z", "getPcmByteCount", "getSampleRate", "sealedBytes", "sizeBytes", "getSizeBytes", "equals", "other", "hashCode", "toString", "zeroize", "", "zeroize$bdpay_voiceprint_release", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoiceSealedAudio {
    public static final Companion Companion = null;
    private static final int DIGEST_LOG_PREFIX_LEN = 8;
    private static final String TAG = "VoiceSealedAudio";
    private final int bitsPerSample;
    private final int channels;
    private final String digest;
    private final boolean isFromMemory;
    private final long pcmByteCount;
    private final int sampleRate;
    private final byte[] sealedBytes;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceSealedAudio$Companion;", "", "()V", "DIGEST_LOG_PREFIX_LEN", "", "TAG", "", "sha256Hex", HTTP.CONTENT_RANGE_BYTES, "", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final String sha256Hex(byte[] r110) {
            MessageDigest r100 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L4
            r100.update(r110);     // Catch: Throwable -> L4
            return ArraysKt.joinToString$default(r100.digest(), "", null, null, 0, null, VoiceSealedAudio$Companion$sha256Hex$1.INSTANCE, 30, null);
        L4:
            th = move-exception;
            CJLogger.c(VoiceSealedAudio.TAG, "sha256 fail", th);
            return "";
        }

        public static final /* synthetic */ String access$sha256Hex(Companion r100, byte[] r101) {
            return r100.sha256Hex(r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final byte[] getBytes() {
        monitor-enter(this);
        byte[] r100 = this.sealedBytes;     // Catch: Throwable -> L6
        byte[] r101 = Arrays.copyOf(r100, r100.length);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final void zeroize$bdpay_voiceprint_release() {
        monitor-enter(this);     // Catch: Throwable -> L9
        ArraysKt.fill$default(this.sealedBytes, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L6
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        CJLogger.b(TAG, "zeroize fail:" + th.getMessage());
    }

    public final long getDurationMs() {
        int r100 = this.sampleRate;
        if (r100 <= 0) goto L14;
        int r101 = this.channels;
        if (r101 <= 0) goto L14;
        int r102 = this.bitsPerSample;
        if (r102 <= 0) goto L14;
        long r103 = (((long) r100) * ((long) r101)) * ((long) (r102 / 8));
        if (r103 > 0) goto L13;
        return 0;
    L13:
        return (this.pcmByteCount * 1000) / r103;
    L14:
        return 0;
    }

    public final int getSizeBytes() {
        return this.sealedBytes.length;
    }

    public int hashCode() {
        int r100 = this.digest.hashCode() * 31;
        long r101 = this.pcmByteCount;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "VoiceSealedAudio(sizeBytes=" + getSizeBytes() + ", sampleRate=" + this.sampleRate + ", channels=" + this.channels + ", bitsPerSample=" + this.bitsPerSample + ", pcmByteCount=" + this.pcmByteCount + ", isFromMemory=" + this.isFromMemory + ", digestPrefix=" + StringsKt.take(this.digest, 8) + ')';
    }

    public final int getBitsPerSample() {
        return this.bitsPerSample;
    }

    public final int getChannels() {
        return this.channels;
    }

    public final String getDigest() {
        return this.digest;
    }

    public final long getPcmByteCount() {
        return this.pcmByteCount;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final boolean isFromMemory() {
        return this.isFromMemory;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoiceSealedAudio) == true) goto L8;
        return false;
    L8:
        VoiceSealedAudio r101 = (VoiceSealedAudio) r100;
        if (Intrinsics.areEqual(this.digest, r101.digest) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.pcmByteCount != r101.pcmByteCount) goto L13;
        return true;
    }

    public VoiceSealedAudio(byte[] r100, int r101, int r102, int r103, long r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        this.sampleRate = r101;
        this.channels = r102;
        this.bitsPerSample = r103;
        this.pcmByteCount = r104;
        this.isFromMemory = r105;
        byte[] r106 = Arrays.copyOf(r100, r100.length);
        this.sealedBytes = r106;
        this.digest = Companion.access$sha256Hex(Companion, r106);
    }
}
