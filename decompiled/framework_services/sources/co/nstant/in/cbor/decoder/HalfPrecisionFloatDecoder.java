package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.HalfPrecisionFloat;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class HalfPrecisionFloatDecoder extends AbstractDecoder<HalfPrecisionFloat> {
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ HalfPrecisionFloat decode(int r1) throws CborException {
        return decode(r1);
    }

    public HalfPrecisionFloatDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public HalfPrecisionFloat decode(int initialByte) throws CborException {
        int bits = (nextSymbol() << 8) | nextSymbol();
        return new HalfPrecisionFloat(toFloat(bits));
    }

    private static float toFloat(int bits) {
        int s = (32768 & bits) >> 15;
        int e = (bits & 31744) >> 10;
        int f = bits & 1023;
        int r5 = 1;
        if (e != 0) goto L9;
        if (s == 0) goto L7;
        r5 = -1;
    L7:
        return (float) ((((double) r5) * Math.pow(2.0d, -14.0d)) * (((double) f) / Math.pow(2.0d, 10.0d)));
    L9:
        if (e != 31) goto L16;
        if (f == 0) goto L12;
        return Float.NaN;
    L12:
        if (s == 0) goto L15;
        r5 = -1;
    L15:
        return r5 * Float.POSITIVE_INFINITY;
    L16:
        if (s == 0) goto L19;
        r5 = -1;
    L19:
        return (float) ((((double) r5) * Math.pow(2.0d, e - 15)) * ((((double) f) / Math.pow(2.0d, 10.0d)) + 1.0d));
    }
}
