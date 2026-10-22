package com.stepos.core.ability.converter;

import ai.onnxruntime.a;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import com.stepos.core.ability.speech.TtsCloudConfig;
import gc.o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrAudioFileDecoder {
    private static final int FMT_BITS_PER_SAMPLE_OFFSET = 14;
    private static final int FMT_CHUNK_MIN_SIZE = 16;
    public static final AsrAudioFileDecoder INSTANCE = new AsrAudioFileDecoder();
    private static final int PCM16_BYTES_PER_SAMPLE = 2;
    private static final int TARGET_SAMPLE_RATE = 16000;
    private static final long WAV_HEADER_SCAN_LIMIT = 4096;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AudioProbe {
        public static final Companion Companion = new Companion(null);
        private static final AudioProbe UNKNOWN = new AudioProbe(0, 0, 0, 0, 15, null);
        private final int bitsPerSample;
        private final int channelCount;
        private final long durationMs;
        private final int sampleRate;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            public final AudioProbe getUNKNOWN() {
                return AudioProbe.UNKNOWN;
            }

            private Companion() {
            }
        }

        public AudioProbe() {
            this(0L, 0, 0, 0, 15, null);
        }

        public static /* synthetic */ AudioProbe copy$default(AudioProbe audioProbe, long j10, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                j10 = audioProbe.durationMs;
            }
            long j11 = j10;
            if ((i13 & 2) != 0) {
                i10 = audioProbe.sampleRate;
            }
            int i14 = i10;
            if ((i13 & 4) != 0) {
                i11 = audioProbe.channelCount;
            }
            int i15 = i11;
            if ((i13 & 8) != 0) {
                i12 = audioProbe.bitsPerSample;
            }
            return audioProbe.copy(j11, i14, i15, i12);
        }

        public final long component1() {
            return this.durationMs;
        }

        public final int component2() {
            return this.sampleRate;
        }

        public final int component3() {
            return this.channelCount;
        }

        public final int component4() {
            return this.bitsPerSample;
        }

        public final AudioProbe copy(long j10, int i10, int i11, int i12) {
            return new AudioProbe(j10, i10, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioProbe)) {
                return false;
            }
            AudioProbe audioProbe = (AudioProbe) obj;
            return this.durationMs == audioProbe.durationMs && this.sampleRate == audioProbe.sampleRate && this.channelCount == audioProbe.channelCount && this.bitsPerSample == audioProbe.bitsPerSample;
        }

        public final int getBitsPerSample() {
            return this.bitsPerSample;
        }

        public final int getChannelCount() {
            return this.channelCount;
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public int hashCode() {
            return Integer.hashCode(this.bitsPerSample) + a.d(this.channelCount, a.d(this.sampleRate, Long.hashCode(this.durationMs) * 31, 31), 31);
        }

        public String toString() {
            long j10 = this.durationMs;
            int i10 = this.sampleRate;
            int i11 = this.channelCount;
            int i12 = this.bitsPerSample;
            StringBuilder sbR = a.r(j10, "AudioProbe(durationMs=", ", sampleRate=", i10);
            sbR.append(", channelCount=");
            sbR.append(i11);
            sbR.append(", bitsPerSample=");
            sbR.append(i12);
            sbR.append(")");
            return sbR.toString();
        }

        public AudioProbe(long j10, int i10, int i11, int i12) {
            this.durationMs = j10;
            this.sampleRate = i10;
            this.channelCount = i11;
            this.bitsPerSample = i12;
        }

        public /* synthetic */ AudioProbe(long j10, int i10, int i11, int i12, int i13, e eVar) {
            this((i13 & 1) != 0 ? 0L : j10, (i13 & 2) != 0 ? 0 : i10, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class MonoResampler16k {
        private boolean hasLast;
        private int lastSample;
        private long outIndex;
        private final double ratio;
        private long srcIndex;

        public MonoResampler16k(int i10) {
            this.ratio = i10 / 16000;
        }

        public final short[] feed(short[] mono) {
            long j10;
            g.f(mono, "mono");
            if (mono.length == 0) {
                return new short[0];
            }
            short[] sArrCopyOf = new short[((int) (mono.length / this.ratio)) + 2];
            int i10 = 0;
            for (short s8 : mono) {
                long j11 = 1;
                if (this.hasLast) {
                    long j12 = this.srcIndex - 1;
                    while (true) {
                        j10 = j11;
                        double d8 = this.outIndex * this.ratio;
                        long j13 = (long) d8;
                        if (j13 != j12) {
                            break;
                        }
                        long j14 = j12;
                        int i11 = (int) (((s8 - r8) * (d8 - j13)) + this.lastSample);
                        if (i10 >= sArrCopyOf.length) {
                            sArrCopyOf = Arrays.copyOf(sArrCopyOf, (sArrCopyOf.length * 2) + 1);
                            g.e(sArrCopyOf, "copyOf(...)");
                        }
                        sArrCopyOf[i10] = (short) i11;
                        this.outIndex += j10;
                        i10++;
                        j11 = j10;
                        j12 = j14;
                    }
                } else {
                    j10 = 1;
                }
                this.lastSample = s8;
                this.srcIndex += j10;
                this.hasLast = true;
            }
            if (i10 == sArrCopyOf.length) {
                return sArrCopyOf;
            }
            short[] sArrCopyOf2 = Arrays.copyOf(sArrCopyOf, i10);
            g.e(sArrCopyOf2, "copyOf(...)");
            return sArrCopyOf2;
        }
    }

    private AsrAudioFileDecoder() {
    }

    private final String ascii(byte[] bArr, int i10) {
        return new String(bArr, i10, 4, gc.a.f9109e);
    }

    private final short[] downmixShorts(short[] sArr, int i10) {
        if (i10 <= 1) {
            return sArr;
        }
        int length = sArr.length / i10;
        short[] sArr2 = new short[length];
        for (int i11 = 0; i11 < length; i11++) {
            long j10 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                j10 += sArr[(i11 * i10) + i12];
            }
            sArr2[i11] = (short) (j10 / i10);
        }
        return sArr2;
    }

    private final int le16(byte[] bArr, int i10) {
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8);
    }

    private final long le32(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    private final int optInt(MediaFormat mediaFormat, String str) {
        Object objA;
        if (!mediaFormat.containsKey(str)) {
            return 0;
        }
        try {
            objA = Integer.valueOf(mediaFormat.getInteger(str));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0;
        }
        return ((Number) objA).intValue();
    }

    private final long optLong(MediaFormat mediaFormat, String str) {
        Object objA;
        if (!mediaFormat.containsKey(str)) {
            return 0L;
        }
        try {
            objA = Long.valueOf(mediaFormat.getLong(str));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0L;
        }
        return ((Number) objA).longValue();
    }

    private final short[] pcmBytesToShorts(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            sArr[i10] = (short) ((bArr[i11 + 1] << 8) | (bArr[i11] & 255));
        }
        return sArr;
    }

    public static /* synthetic */ AudioProbe probeAudioInfo$default(AsrAudioFileDecoder asrAudioFileDecoder, String str, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = true;
        }
        return asrAudioFileDecoder.probeAudioInfo(str, z);
    }

    public final short[] decodeFromPfd(ParcelFileDescriptor pfd) throws MediaCodec.CryptoException, IOException {
        MediaFormat trackFormat;
        MonoResampler16k monoResampler16k;
        int length;
        long j10;
        MonoResampler16k monoResampler16k2;
        boolean z;
        short[] sArrFeed;
        g.f(pfd, "pfd");
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(pfd.getFileDescriptor());
        int trackCount = mediaExtractor.getTrackCount();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= trackCount) {
                i11 = -1;
                trackFormat = null;
                break;
            }
            trackFormat = mediaExtractor.getTrackFormat(i11);
            g.e(trackFormat, "getTrackFormat(...)");
            String string = trackFormat.getString("mime");
            if (string != null && o.k0(string, "audio/", false)) {
                break;
            }
            i11++;
        }
        if (trackFormat == null) {
            pfd.close();
            throw new IllegalArgumentException("No audio track found in file descriptor");
        }
        mediaExtractor.selectTrack(i11);
        String string2 = trackFormat.getString("mime");
        g.c(string2);
        int integer = trackFormat.getInteger("sample-rate");
        int integer2 = trackFormat.getInteger("channel-count");
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(string2);
        g.e(mediaCodecCreateDecoderByType, "createDecoderByType(...)");
        mediaCodecCreateDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
        mediaCodecCreateDecoderByType.start();
        ArrayList arrayList = new ArrayList();
        MonoResampler16k monoResampler16k3 = integer != 16000 ? new MonoResampler16k(integer) : null;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        boolean z3 = false;
        int i12 = 0;
        boolean z10 = false;
        while (!z3) {
            if (z10) {
                monoResampler16k = monoResampler16k3;
                length = i12;
                j10 = 10000;
            } else {
                int i13 = i12;
                int iDequeueInputBuffer = mediaCodecCreateDecoderByType.dequeueInputBuffer(TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS);
                if (iDequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = mediaCodecCreateDecoderByType.getInputBuffer(iDequeueInputBuffer);
                    g.c(inputBuffer);
                    int sampleData = mediaExtractor.readSampleData(inputBuffer, i10);
                    if (sampleData < 0) {
                        monoResampler16k = monoResampler16k3;
                        j10 = 10000;
                        length = i13;
                        mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                        z10 = true;
                    } else {
                        monoResampler16k = monoResampler16k3;
                        j10 = 10000;
                        length = i13;
                        mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, mediaExtractor.getSampleTime(), 0);
                        mediaExtractor.advance();
                    }
                } else {
                    monoResampler16k = monoResampler16k3;
                    j10 = 10000;
                    length = i13;
                }
            }
            int iDequeueOutputBuffer = mediaCodecCreateDecoderByType.dequeueOutputBuffer(bufferInfo, j10);
            if (iDequeueOutputBuffer >= 0) {
                ByteBuffer outputBuffer = mediaCodecCreateDecoderByType.getOutputBuffer(iDequeueOutputBuffer);
                g.c(outputBuffer);
                int i14 = bufferInfo.size;
                if (i14 > 0) {
                    byte[] bArr = new byte[i14];
                    outputBuffer.get(bArr);
                    short[] sArrPcmBytesToShorts = pcmBytesToShorts(bArr);
                    z = true;
                    if (integer2 != 1) {
                        sArrPcmBytesToShorts = downmixShorts(sArrPcmBytesToShorts, integer2);
                    }
                    monoResampler16k2 = monoResampler16k;
                    if (monoResampler16k != null && (sArrFeed = monoResampler16k2.feed(sArrPcmBytesToShorts)) != null) {
                        sArrPcmBytesToShorts = sArrFeed;
                    }
                    if (sArrPcmBytesToShorts.length != 0) {
                        arrayList.add(sArrPcmBytesToShorts);
                        length += sArrPcmBytesToShorts.length;
                    }
                } else {
                    monoResampler16k2 = monoResampler16k;
                    z = true;
                }
                mediaCodecCreateDecoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                if ((bufferInfo.flags & 4) != 0) {
                    z3 = z;
                }
                monoResampler16k3 = monoResampler16k2;
                i12 = length;
                i10 = 0;
            } else {
                i12 = length;
                monoResampler16k3 = monoResampler16k;
                i10 = 0;
            }
        }
        mediaCodecCreateDecoderByType.stop();
        mediaCodecCreateDecoderByType.release();
        mediaExtractor.release();
        pfd.close();
        short[] sArr = new short[i12];
        Iterator it = arrayList.iterator();
        g.e(it, "iterator(...)");
        int length2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            g.e(next, "next(...)");
            short[] sArr2 = (short[]) next;
            System.arraycopy(sArr2, 0, sArr, length2, sArr2.length);
            length2 += sArr2.length;
        }
        return sArr;
    }

    public final long pcmDurationMs(long j10, int i10) {
        if (j10 <= 0 || i10 <= 0) {
            return 0L;
        }
        return (j10 * 1000) / i10;
    }

    public final long pcmSampleCount(long j10) {
        return j10 / 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r0 = r8.equals("audio/raw");
        r8 = new com.stepos.core.ability.converter.AsrAudioFileDecoder.AudioProbe(optLong(r7, "durationUs") / 1000, optInt(r7, "sample-rate"), optInt(r7, "channel-count"), 0, 8, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.ability.converter.AsrAudioFileDecoder.AudioProbe probeAudioInfo(java.lang.String r17, boolean r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "localPath"
            kotlin.jvm.internal.g.f(r2, r0)
            android.media.MediaExtractor r3 = new android.media.MediaExtractor
            r3.<init>()
            r0 = 0
            r3.setDataSource(r2)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            com.stepos.core.ability.converter.AsrAudioFileDecoder$AudioProbe$Companion r4 = com.stepos.core.ability.converter.AsrAudioFileDecoder.AudioProbe.Companion     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            com.stepos.core.ability.converter.AsrAudioFileDecoder$AudioProbe r4 = r4.getUNKNOWN()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r5 = r3.getTrackCount()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r6 = r0
        L1d:
            if (r6 >= r5) goto L68
            android.media.MediaFormat r7 = r3.getTrackFormat(r6)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r8 = "getTrackFormat(...)"
            kotlin.jvm.internal.g.e(r7, r8)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r8 = "mime"
            java.lang.String r8 = r7.getString(r8)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            if (r8 != 0) goto L31
            goto L65
        L31:
            java.lang.String r9 = "audio/"
            boolean r9 = gc.o.k0(r8, r9, r0)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            if (r9 == 0) goto L65
            java.lang.String r4 = "audio/raw"
            boolean r0 = r8.equals(r4)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            com.stepos.core.ability.converter.AsrAudioFileDecoder$AudioProbe r8 = new com.stepos.core.ability.converter.AsrAudioFileDecoder$AudioProbe     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r4 = "durationUs"
            long r4 = r1.optLong(r7, r4)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r9 = 1000(0x3e8, double:4.94E-321)
            long r9 = r4 / r9
            java.lang.String r4 = "sample-rate"
            int r11 = r1.optInt(r7, r4)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r4 = "channel-count"
            int r12 = r1.optInt(r7, r4)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r14 = 8
            r15 = 0
            r13 = 0
            r8.<init>(r9, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
        L5e:
            r4 = r0
            goto L6a
        L60:
            r0 = move-exception
            r1 = r0
            goto L99
        L63:
            r4 = r0
            goto L76
        L65:
            int r6 = r6 + 1
            goto L1d
        L68:
            r8 = r4
            goto L5e
        L6a:
            r3.release()     // Catch: java.lang.Throwable -> L70
            lb.n r0 = lb.n.f10413a     // Catch: java.lang.Throwable -> L70
            goto L74
        L70:
            r0 = move-exception
        L71:
            kotlin.c.a(r0)
        L74:
            r5 = r8
            goto L84
        L76:
            com.stepos.core.ability.converter.AsrAudioFileDecoder$AudioProbe$Companion r0 = com.stepos.core.ability.converter.AsrAudioFileDecoder.AudioProbe.Companion     // Catch: java.lang.Throwable -> L60
            com.stepos.core.ability.converter.AsrAudioFileDecoder$AudioProbe r8 = r0.getUNKNOWN()     // Catch: java.lang.Throwable -> L60
            r3.release()     // Catch: java.lang.Throwable -> L82
            lb.n r0 = lb.n.f10413a     // Catch: java.lang.Throwable -> L82
            goto L74
        L82:
            r0 = move-exception
            goto L71
        L84:
            if (r18 == 0) goto L98
            if (r4 != 0) goto L89
            goto L98
        L89:
            int r10 = r16.probeWavBitsPerSample$ability_release(r17)
            r11 = 7
            r12 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            com.stepos.core.ability.converter.AsrAudioFileDecoder$AudioProbe r0 = com.stepos.core.ability.converter.AsrAudioFileDecoder.AudioProbe.copy$default(r5, r6, r8, r9, r10, r11, r12)
            return r0
        L98:
            return r5
        L99:
            r3.release()     // Catch: java.lang.Throwable -> L9f
            lb.n r0 = lb.n.f10413a     // Catch: java.lang.Throwable -> L9f
            goto La3
        L9f:
            r0 = move-exception
            kotlin.c.a(r0)
        La3:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.converter.AsrAudioFileDecoder.probeAudioInfo(java.lang.String, boolean):com.stepos.core.ability.converter.AsrAudioFileDecoder$AudioProbe");
    }

    public final long probeDurationMs(String localPath) {
        g.f(localPath, "localPath");
        return probeAudioInfo(localPath, false).getDurationMs();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        r2 = new byte[16];
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
    
        if (r1.read(r2) == 16) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        r14 = le16(r2, 14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int probeWavBitsPerSample$ability_release(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = "localPath"
            kotlin.jvm.internal.g.f(r15, r0)
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = "r"
            r1.<init>(r15, r2)     // Catch: java.lang.Throwable -> L94
            r15 = 12
            byte[] r2 = new byte[r15]     // Catch: java.lang.Throwable -> L83
            int r3 = r1.read(r2)     // Catch: java.lang.Throwable -> L83
            if (r3 == r15) goto L1a
        L17:
            r14 = r0
            goto L8c
        L1a:
            java.lang.String r3 = r14.ascii(r2, r0)     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "RIFF"
            boolean r3 = kotlin.jvm.internal.g.b(r3, r4)     // Catch: java.lang.Throwable -> L83
            if (r3 == 0) goto L17
            r3 = 8
            java.lang.String r2 = r14.ascii(r2, r3)     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "WAVE"
            boolean r2 = kotlin.jvm.internal.g.b(r2, r4)     // Catch: java.lang.Throwable -> L83
            if (r2 != 0) goto L35
            goto L17
        L35:
            long r4 = r1.length()     // Catch: java.lang.Throwable -> L83
            r6 = 4096(0x1000, double:2.0237E-320)
            long r4 = java.lang.Math.min(r4, r6)     // Catch: java.lang.Throwable -> L83
            byte[] r2 = new byte[r3]     // Catch: java.lang.Throwable -> L83
            long r6 = (long) r15     // Catch: java.lang.Throwable -> L83
        L42:
            long r8 = (long) r3     // Catch: java.lang.Throwable -> L83
            long r10 = r6 + r8
            int r15 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r15 > 0) goto L17
            r1.seek(r6)     // Catch: java.lang.Throwable -> L83
            int r15 = r1.read(r2)     // Catch: java.lang.Throwable -> L83
            if (r15 == r3) goto L53
            goto L17
        L53:
            r15 = 4
            long r10 = r14.le32(r2, r15)     // Catch: java.lang.Throwable -> L83
            r12 = 0
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5f
            goto L17
        L5f:
            java.lang.String r15 = r14.ascii(r2, r0)     // Catch: java.lang.Throwable -> L83
            java.lang.String r12 = "fmt "
            boolean r15 = kotlin.jvm.internal.g.b(r15, r12)     // Catch: java.lang.Throwable -> L83
            if (r15 == 0) goto L85
            r12 = 16
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 < 0) goto L85
            r15 = 16
            byte[] r2 = new byte[r15]     // Catch: java.lang.Throwable -> L83
            int r3 = r1.read(r2)     // Catch: java.lang.Throwable -> L83
            if (r3 == r15) goto L7c
            goto L17
        L7c:
            r15 = 14
            int r14 = r14.le16(r2, r15)     // Catch: java.lang.Throwable -> L83
            goto L8c
        L83:
            r14 = move-exception
            goto L96
        L85:
            long r8 = r8 + r10
            r12 = 1
            long r10 = r10 & r12
            long r8 = r8 + r10
            long r6 = r6 + r8
            goto L42
        L8c:
            r1.close()     // Catch: java.lang.Throwable -> L94
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch: java.lang.Throwable -> L94
            goto La0
        L94:
            r14 = move-exception
            goto L9c
        L96:
            throw r14     // Catch: java.lang.Throwable -> L97
        L97:
            r15 = move-exception
            mb.y.q(r1, r14)     // Catch: java.lang.Throwable -> L94
            throw r15     // Catch: java.lang.Throwable -> L94
        L9c:
            kotlin.Result$Failure r14 = kotlin.c.a(r14)
        La0:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r0)
            boolean r0 = r14 instanceof kotlin.Result.Failure
            if (r0 == 0) goto La9
            r14 = r15
        La9:
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.converter.AsrAudioFileDecoder.probeWavBitsPerSample$ability_release(java.lang.String):int");
    }
}
