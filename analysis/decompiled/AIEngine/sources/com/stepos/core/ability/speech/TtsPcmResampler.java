package com.stepos.core.ability.speech;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsPcmResampler {
    public static final TtsPcmResampler INSTANCE = new TtsPcmResampler();
    public static final int TARGET_SAMPLE_RATE = 24000;

    private TtsPcmResampler() {
    }

    public final byte[] resampleMonoS16le(byte[] pcm16le, int i10, int i11) {
        short s8;
        kotlin.jvm.internal.g.f(pcm16le, "pcm16le");
        if (i10 <= 0 || i11 <= 0 || i10 == i11 || pcm16le.length < 4) {
            return pcm16le;
        }
        int length = pcm16le.length / 2;
        int i12 = (int) ((length * i11) / i10);
        if (i12 < 1) {
            i12 = 1;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(pcm16le);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ByteBuffer byteBufferOrder = byteBufferWrap.order(byteOrder);
        byte[] bArr = new byte[i12 * 2];
        ByteBuffer byteBufferOrder2 = ByteBuffer.wrap(bArr).order(byteOrder);
        for (int i13 = 0; i13 < i12; i13++) {
            double d8 = (i13 * i10) / i11;
            int iA0 = dc.h.a0((int) d8, 0, length - 1);
            float f8 = (float) (d8 - iA0);
            byteBufferOrder.position(iA0 * 2);
            short s9 = byteBufferOrder.getShort();
            int i14 = iA0 + 1;
            if (i14 < length) {
                byteBufferOrder.position(i14 * 2);
                s8 = byteBufferOrder.getShort();
            } else {
                s8 = s9;
            }
            byteBufferOrder2.putShort((short) dc.h.a0((int) (((s8 - s9) * f8) + s9), -32768, AsrCloudWsSession.PCM_FULL_SCALE));
        }
        return bArr;
    }

    public final byte[] upsample16kTo24kMono(byte[] pcm16le) {
        kotlin.jvm.internal.g.f(pcm16le, "pcm16le");
        return resampleMonoS16le(pcm16le, 16000, 24000);
    }
}
