package ai.onnxruntime.platform;

import com.stepos.core.ability.speech.AsrCloudWsSession;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Fp16Conversions {
    private static final Logger logger = Logger.getLogger(Fp16Conversions.class.getName());

    public static float bf16ToFloat(short s8) {
        return Float.intBitsToFloat(s8 << 16);
    }

    public static FloatBuffer convertBf16BufferToFloatBuffer(ShortBuffer shortBuffer) {
        int iPosition = shortBuffer.position();
        int iRemaining = shortBuffer.remaining();
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(iRemaining * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i10 = 0; i10 < iRemaining; i10++) {
            floatBufferAsFloatBuffer.put(i10, bf16ToFloat(shortBuffer.get(i10 + iPosition)));
        }
        return floatBufferAsFloatBuffer;
    }

    public static ShortBuffer convertFloatBufferToBf16Buffer(FloatBuffer floatBuffer) {
        int iPosition = floatBuffer.position();
        int iRemaining = floatBuffer.remaining();
        ShortBuffer shortBufferAsShortBuffer = ByteBuffer.allocateDirect(iRemaining * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        for (int i10 = 0; i10 < iRemaining; i10++) {
            shortBufferAsShortBuffer.put(i10, floatToBf16(floatBuffer.get(i10 + iPosition)));
        }
        return shortBufferAsShortBuffer;
    }

    public static ShortBuffer convertFloatBufferToFp16Buffer(FloatBuffer floatBuffer) {
        int iPosition = floatBuffer.position();
        int iRemaining = floatBuffer.remaining();
        ShortBuffer shortBufferAsShortBuffer = ByteBuffer.allocateDirect(iRemaining * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        for (int i10 = 0; i10 < iRemaining; i10++) {
            shortBufferAsShortBuffer.put(i10, floatToFp16(floatBuffer.get(i10 + iPosition)));
        }
        return shortBufferAsShortBuffer;
    }

    public static FloatBuffer convertFp16BufferToFloatBuffer(ShortBuffer shortBuffer) {
        int iPosition = shortBuffer.position();
        int iRemaining = shortBuffer.remaining();
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(iRemaining * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i10 = 0; i10 < iRemaining; i10++) {
            floatBufferAsFloatBuffer.put(i10, fp16ToFloat(shortBuffer.get(i10 + iPosition)));
        }
        return floatBufferAsFloatBuffer;
    }

    public static short floatToBf16(float f8) {
        int iFloatToIntBits = Float.floatToIntBits(f8);
        return (short) (((((iFloatToIntBits >> 16) & 1) + AsrCloudWsSession.PCM_FULL_SCALE) + iFloatToIntBits) >> 16);
    }

    public static short floatToFp16(float f8) {
        return mlasFloatToFp16(f8);
    }

    public static float fp16ToFloat(short s8) {
        return mlasFp16ToFloat(s8);
    }

    public static short mlasFloatToFp16(float f8) {
        short sFloatToIntBits;
        int iFloatToIntBits = Float.floatToIntBits(f8);
        int iFloatToIntBits2 = Float.floatToIntBits(Float.POSITIVE_INFINITY);
        int i10 = Integer.MIN_VALUE & iFloatToIntBits;
        int i11 = iFloatToIntBits ^ i10;
        if (i11 >= 1199570944) {
            sFloatToIntBits = i11 > iFloatToIntBits2 ? (short) 32256 : (short) 31744;
        } else {
            sFloatToIntBits = (short) (i11 < 947912704 ? Float.floatToIntBits(Float.intBitsToFloat(1056964608) + Float.intBitsToFloat(i11)) - 1056964608 : ((i11 - 939520001) + ((i11 >> 13) & 1)) >> 13);
        }
        return (short) (sFloatToIntBits | ((short) (i10 >> 16)));
    }

    public static float mlasFp16ToFloat(short s8) {
        int i10 = (s8 & Short.MAX_VALUE) << 13;
        int i11 = i10 & 260046848;
        int iFloatToIntBits = 939524096 + i10;
        if (i11 == 260046848) {
            iFloatToIntBits = i10 + 1879048192;
        } else if (i11 == 0) {
            iFloatToIntBits = Float.floatToIntBits(Float.intBitsToFloat(i10 + 947912704) - Float.intBitsToFloat(947912704));
        }
        return Float.intBitsToFloat(((s8 & Short.MIN_VALUE) << 16) | iFloatToIntBits);
    }
}
