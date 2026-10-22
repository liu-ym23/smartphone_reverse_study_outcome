package com.stepos.aiengine.util;

import D7.q;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import g1.AbstractC1451a;
import j9.AbstractC1607a;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/util/AudioUtils;", "", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "fromUri", "(Landroid/content/Context;Landroid/net/Uri;)[B", "wavBytes", "wavTo16kMonoPcm", "([B)[B", "pcmBytes", "", "srcSampleRate", "resampleTo16k", "([BI)[B", "channels", "downmixToMono", SingleFileBundle.KEY_BYTES, "Lcom/stepos/aiengine/util/AudioUtils$WavInfo;", "parseWav$aiengine_api_release", "([B)Lcom/stepos/aiengine/util/AudioUtils$WavInfo;", "parseWav", "ASR_SAMPLE_RATE", "I", "WavInfo", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioUtils {
    public static final int ASR_SAMPLE_RATE = 16000;
    public static final AudioUtils INSTANCE = new AudioUtils();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\r¨\u0006$"}, d2 = {"Lcom/stepos/aiengine/util/AudioUtils$WavInfo;", "", "", "pcmBytes", "", "sampleRate", "channels", "bitsPerSample", AppAgent.CONSTRUCT, "([BIII)V", "component1", "()[B", "component2", "()I", "component3", "component4", "copy", "([BIII)Lcom/stepos/aiengine/util/AudioUtils$WavInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "[B", "getPcmBytes", "b", "I", "getSampleRate", "c", "getChannels", "d", "getBitsPerSample", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class WavInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final byte[] pcmBytes;

        /* renamed from: b, reason: from kotlin metadata */
        public final int sampleRate;

        /* renamed from: c, reason: from kotlin metadata */
        public final int channels;

        /* renamed from: d, reason: from kotlin metadata */
        public final int bitsPerSample;

        public WavInfo(byte[] pcmBytes, int i, int i6, int i10) {
            k.f(pcmBytes, "pcmBytes");
            this.pcmBytes = pcmBytes;
            this.sampleRate = i;
            this.channels = i6;
            this.bitsPerSample = i10;
        }

        public static /* synthetic */ WavInfo copy$default(WavInfo wavInfo, byte[] bArr, int i, int i6, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bArr = wavInfo.pcmBytes;
            }
            if ((i11 & 2) != 0) {
                i = wavInfo.sampleRate;
            }
            if ((i11 & 4) != 0) {
                i6 = wavInfo.channels;
            }
            if ((i11 & 8) != 0) {
                i10 = wavInfo.bitsPerSample;
            }
            return wavInfo.copy(bArr, i, i6, i10);
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
            k.f(pcmBytes, "pcmBytes");
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
            return k.b(this.pcmBytes, wavInfo.pcmBytes) && this.sampleRate == wavInfo.sampleRate && this.channels == wavInfo.channels && this.bitsPerSample == wavInfo.bitsPerSample;
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
            return Integer.hashCode(this.bitsPerSample) + a.a(this.channels, a.a(this.sampleRate, Arrays.hashCode(this.pcmBytes) * 31, 31), 31);
        }

        public String toString() {
            StringBuilder sbT = androidx.appfunctions.metadata.a.t(this.sampleRate, "WavInfo(pcmBytes=", Arrays.toString(this.pcmBytes), ", sampleRate=", ", channels=");
            sbT.append(this.channels);
            sbT.append(", bitsPerSample=");
            sbT.append(this.bitsPerSample);
            sbT.append(")");
            return sbT.toString();
        }
    }

    public static short[] a(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            int i6 = i * 2;
            sArr[i] = (short) ((bArr[i6 + 1] << 8) | (bArr[i6] & 255));
        }
        return sArr;
    }

    public static int b(int i, byte[] bArr) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static byte[] c(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            int i6 = i * 2;
            short s5 = sArr[i];
            bArr[i6] = (byte) (s5 & 255);
            bArr[i6 + 1] = (byte) ((s5 >>> 8) & 255);
        }
        return bArr;
    }

    public final byte[] downmixToMono(byte[] pcmBytes, int channels) {
        k.f(pcmBytes, "pcmBytes");
        if (channels == 1) {
            return pcmBytes;
        }
        int length = a(pcmBytes).length / channels;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            long j5 = 0;
            for (int i6 = 0; i6 < channels; i6++) {
                j5 += r8[(i * channels) + i6];
            }
            sArr[i] = (short) (j5 / channels);
        }
        return c(sArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] fromUri(android.content.Context r20, android.net.Uri r21) throws android.media.MediaCodec.CryptoException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.util.AudioUtils.fromUri(android.content.Context, android.net.Uri):byte[]");
    }

    public final WavInfo parseWav$aiengine_api_release(byte[] bytes) {
        k.f(bytes, "bytes");
        int i = 12;
        if (bytes.length < 12) {
            return new WavInfo(bytes, 16000, 1, 16);
        }
        byte[] bArrC0 = q.c0(bytes, 0, 4);
        Charset charset = AbstractC1607a.b;
        String str = new String(bArrC0, charset);
        String str2 = new String(q.c0(bytes, 8, 12), charset);
        if (!str.equals("RIFF") || !str2.equals("WAVE")) {
            return new WavInfo(bytes, 16000, 1, 16);
        }
        byte[] bArrC02 = null;
        int i6 = 16;
        int i10 = 1;
        int i11 = 16000;
        while (true) {
            int i12 = i + 8;
            if (i12 > bytes.length) {
                break;
            }
            int i13 = i + 4;
            String str3 = new String(q.c0(bytes, i, i13), AbstractC1607a.b);
            int iB = b(i13, bytes);
            if (str3.equals("fmt ")) {
                i10 = ((short) ((bytes[i + 10] & 255) | ((bytes[i + 11] & 255) << 8))) & 65535;
                int iB2 = b(i + 12, bytes);
                i6 = 65535 & ((short) ((bytes[i + 22] & 255) | ((bytes[i + 23] & 255) << 8)));
                i11 = iB2;
            } else if (str3.equals(SettingsConfig.KEY_DATA)) {
                int length = (bytes.length - i) - 8;
                if (iB <= length) {
                    length = iB;
                }
                bArrC02 = q.c0(bytes, i12, length + i12);
            }
            if (iB <= 0) {
                break;
            }
            i += iB + 8;
        }
        return bArrC02 != null ? new WavInfo(bArrC02, i11, i10, i6) : new WavInfo(bytes, 16000, 1, 16);
    }

    public final byte[] resampleTo16k(byte[] pcmBytes, int srcSampleRate) {
        k.f(pcmBytes, "pcmBytes");
        if (srcSampleRate == 16000) {
            return pcmBytes;
        }
        short[] sArrA = a(pcmBytes);
        double d = srcSampleRate / 16000;
        int length = (int) (sArrA.length / d);
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            double d6 = i * d;
            int iU = AbstractC1451a.u((int) d6, 0, sArrA.length - 1);
            int iU2 = AbstractC1451a.u(iU + 1, 0, sArrA.length - 1);
            double d10 = d6 - iU;
            short s5 = sArrA[iU];
            sArr[i] = (short) (((sArrA[iU2] - s5) * d10) + s5);
        }
        return c(sArr);
    }

    public final byte[] wavTo16kMonoPcm(byte[] wavBytes) {
        k.f(wavBytes, "wavBytes");
        WavInfo wav$aiengine_api_release = parseWav$aiengine_api_release(wavBytes);
        byte[] pcmBytes = wav$aiengine_api_release.getChannels() == 1 ? wav$aiengine_api_release.getPcmBytes() : downmixToMono(wav$aiengine_api_release.getPcmBytes(), wav$aiengine_api_release.getChannels());
        return wav$aiengine_api_release.getSampleRate() == 16000 ? pcmBytes : resampleTo16k(pcmBytes, wav$aiengine_api_release.getSampleRate());
    }
}
