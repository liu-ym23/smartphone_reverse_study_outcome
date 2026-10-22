package com.stepos.aiengine.util;

import La.C0953c;
import W4.a;
import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010 \u001a\u00020$2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010%R\u0014\u0010&\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/stepos/aiengine/util/AudioUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "fromUri", "(Landroid/content/Context;Landroid/net/Uri;)[B", "wavBytes", "wavTo16kMonoPcm", "([B)[B", "pcmBytes", "", "srcSampleRate", "resampleTo16k", "([BI)[B", "channels", "downmixToMono", SingleFileBundle.KEY_BYTES, "Lcom/stepos/aiengine/util/AudioUtils$WavInfo;", "parseWav$aiengine_api_release", "([B)Lcom/stepos/aiengine/util/AudioUtils$WavInfo;", "parseWav", "", Const.INTENT_KEY_APIKEY, "([B)[S", "shorts", Const.INTENT_KEY_UMID, "([S)[B", Const.INTENT_KEY_PKGNAME, a.ENABLE_OFF, "c", "([BI)I", "", "([BI)S", "ASR_SAMPLE_RATE", "I", "WavInfo", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AudioUtils {
    public static final int ASR_SAMPLE_RATE = 16000;
    public static final AudioUtils INSTANCE = new AudioUtils();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\r¨\u0006$"}, d2 = {"Lcom/stepos/aiengine/util/AudioUtils$WavInfo;", "", "", "pcmBytes", "", "sampleRate", "channels", "bitsPerSample", "<init>", "([BIII)V", "component1", "()[B", "component2", "()I", "component3", "component4", ChatTracker.CLICK_COPY, "([BIII)Lcom/stepos/aiengine/util/AudioUtils$WavInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "[B", "getPcmBytes", Const.INTENT_KEY_PKGNAME, "I", "getSampleRate", "c", "getChannels", Const.INTENT_KEY_UMID, "getBitsPerSample", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class WavInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final byte[] pcmBytes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int sampleRate;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int channels;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final int bitsPerSample;

        public WavInfo(byte[] pcmBytes, int i10, int i11, int i12) {
            p.i(pcmBytes, "pcmBytes");
            this.pcmBytes = pcmBytes;
            this.sampleRate = i10;
            this.channels = i11;
            this.bitsPerSample = i12;
        }

        public static /* synthetic */ WavInfo copy$default(WavInfo wavInfo, byte[] bArr, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                bArr = wavInfo.pcmBytes;
            }
            if ((i13 & 2) != 0) {
                i10 = wavInfo.sampleRate;
            }
            if ((i13 & 4) != 0) {
                i11 = wavInfo.channels;
            }
            if ((i13 & 8) != 0) {
                i12 = wavInfo.bitsPerSample;
            }
            return wavInfo.copy(bArr, i10, i11, i12);
        }

        /* renamed from: component1, reason: from getter */
        public final byte[] getPcmBytes() {
            return this.pcmBytes;
        }

        /* renamed from: component2, reason: from getter */
        public final int getSampleRate() {
            return this.sampleRate;
        }

        /* renamed from: component3, reason: from getter */
        public final int getChannels() {
            return this.channels;
        }

        /* renamed from: component4, reason: from getter */
        public final int getBitsPerSample() {
            return this.bitsPerSample;
        }

        public final WavInfo copy(byte[] pcmBytes, int sampleRate, int channels, int bitsPerSample) {
            p.i(pcmBytes, "pcmBytes");
            return new WavInfo(pcmBytes, sampleRate, channels, bitsPerSample);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WavInfo)) {
                return false;
            }
            WavInfo wavInfo = (WavInfo) other;
            return p.d(this.pcmBytes, wavInfo.pcmBytes) && this.sampleRate == wavInfo.sampleRate && this.channels == wavInfo.channels && this.bitsPerSample == wavInfo.bitsPerSample;
        }

        public final int getBitsPerSample() {
            return this.bitsPerSample;
        }

        public final int getChannels() {
            return this.channels;
        }

        public final byte[] getPcmBytes() {
            return this.pcmBytes;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public int hashCode() {
            return (((((Arrays.hashCode(this.pcmBytes) * 31) + Integer.hashCode(this.sampleRate)) * 31) + Integer.hashCode(this.channels)) * 31) + Integer.hashCode(this.bitsPerSample);
        }

        public String toString() {
            return "WavInfo(pcmBytes=" + Arrays.toString(this.pcmBytes) + ", sampleRate=" + this.sampleRate + ", channels=" + this.channels + ", bitsPerSample=" + this.bitsPerSample + ")";
        }
    }

    public final short[] a(byte[] bytes) {
        int length = bytes.length / 2;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            sArr[i10] = (short) ((bytes[i11 + 1] << 8) | (bytes[i11] & 255));
        }
        return sArr;
    }

    public final short b(byte[] b10, int off) {
        return (short) ((b10[off] & 255) | ((b10[off + 1] & 255) << 8));
    }

    public final int c(byte[] b10, int off) {
        return (b10[off] & 255) | ((b10[off + 1] & 255) << 8) | ((b10[off + 2] & 255) << 16) | ((b10[off + 3] & 255) << 24);
    }

    public final byte[] d(short[] shorts) {
        byte[] bArr = new byte[shorts.length * 2];
        int length = shorts.length;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            short s10 = shorts[i10];
            bArr[i11] = (byte) (s10 & 255);
            bArr[i11 + 1] = (byte) ((s10 >>> 8) & 255);
        }
        return bArr;
    }

    public final byte[] downmixToMono(byte[] pcmBytes, int channels) {
        p.i(pcmBytes, "pcmBytes");
        if (channels == 1) {
            return pcmBytes;
        }
        int length = a(pcmBytes).length / channels;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < channels; i11++) {
                j10 += r10[(i10 * channels) + i11];
            }
            sArr[i10] = (short) (j10 / channels);
        }
        return d(sArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] fromUri(android.content.Context r20, android.net.Uri r21) throws android.media.MediaCodec.CryptoException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.util.AudioUtils.fromUri(android.content.Context, android.net.Uri):byte[]");
    }

    public final WavInfo parseWav$aiengine_api_release(byte[] bytes) {
        p.i(bytes, "bytes");
        int i10 = 12;
        if (bytes.length < 12) {
            return new WavInfo(bytes, 16000, 1, 16);
        }
        byte[] bArrO = C1168p.o(bytes, 0, 4);
        Charset charset = C0953c.US_ASCII;
        String str = new String(bArrO, charset);
        String str2 = new String(C1168p.o(bytes, 8, 12), charset);
        if (!p.d(str, "RIFF") || !p.d(str2, "WAVE")) {
            return new WavInfo(bytes, 16000, 1, 16);
        }
        byte[] bArrO2 = null;
        int iB = 16;
        int iB2 = 1;
        int i11 = 16000;
        while (true) {
            int i12 = i10 + 8;
            if (i12 > bytes.length) {
                break;
            }
            int i13 = i10 + 4;
            String str3 = new String(C1168p.o(bytes, i10, i13), C0953c.US_ASCII);
            int iC = c(bytes, i13);
            if (p.d(str3, "fmt ")) {
                iB2 = b(bytes, i10 + 10) & 65535;
                int iC2 = c(bytes, i10 + 12);
                iB = 65535 & b(bytes, i10 + 22);
                i11 = iC2;
            } else if (p.d(str3, "data")) {
                bArrO2 = C1168p.o(bytes, i12, C5685n.j(iC, (bytes.length - i10) - 8) + i12);
            }
            if (iC <= 0) {
                break;
            }
            i10 += iC + 8;
        }
        return bArrO2 != null ? new WavInfo(bArrO2, i11, iB2, iB) : new WavInfo(bytes, 16000, 1, 16);
    }

    public final byte[] resampleTo16k(byte[] pcmBytes, int srcSampleRate) {
        p.i(pcmBytes, "pcmBytes");
        if (srcSampleRate == 16000) {
            return pcmBytes;
        }
        short[] sArrA = a(pcmBytes);
        double d10 = srcSampleRate / 16000;
        int length = (int) (sArrA.length / d10);
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            double d11 = i10 * d10;
            int iN = C5685n.n((int) d11, 0, sArrA.length - 1);
            int iN2 = C5685n.n(iN + 1, 0, sArrA.length - 1);
            double d12 = d11 - iN;
            short s10 = sArrA[iN];
            sArr[i10] = (short) (s10 + ((sArrA[iN2] - s10) * d12));
        }
        return d(sArr);
    }

    public final byte[] wavTo16kMonoPcm(byte[] wavBytes) {
        p.i(wavBytes, "wavBytes");
        WavInfo wav$aiengine_api_release = parseWav$aiengine_api_release(wavBytes);
        byte[] pcmBytes = wav$aiengine_api_release.getChannels() == 1 ? wav$aiengine_api_release.getPcmBytes() : downmixToMono(wav$aiengine_api_release.getPcmBytes(), wav$aiengine_api_release.getChannels());
        return wav$aiengine_api_release.getSampleRate() == 16000 ? pcmBytes : resampleTo16k(pcmBytes, wav$aiengine_api_release.getSampleRate());
    }
}
