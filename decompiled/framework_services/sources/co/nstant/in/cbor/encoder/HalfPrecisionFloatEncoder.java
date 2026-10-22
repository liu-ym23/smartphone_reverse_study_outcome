package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.HalfPrecisionFloat;
import com.android.server.location.gnss.hal.GnssNative;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class HalfPrecisionFloatEncoder extends AbstractEncoder<HalfPrecisionFloat> {
    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(HalfPrecisionFloat r1) throws CborException {
        encode2(r1);
    }

    public HalfPrecisionFloatEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(HalfPrecisionFloat dataItem) throws CborException {
        write(249);
        int bits = fromFloat(dataItem.getValue());
        write((bits >> 8) & 255);
        write((bits >> 0) & 255);
    }

    public static int fromFloat(float fval) {
        int fbits = Float.floatToIntBits(fval);
        int sign = (fbits >>> 16) & 32768;
        int val = (fbits + 4096) & Integer.MAX_VALUE;
        if (val < 1199570944) goto L15;
        if ((Integer.MAX_VALUE & fbits) < 1199570944) goto L13;
        if (val >= 2139095040) goto L11;
        return sign | 31744;
    L11:
        return (sign | 31744) | ((8388607 & fbits) >>> 13);
    L13:
        return sign | 31743;
    L15:
        if (val < 947912704) goto L19;
        return ((val - 939524096) >>> 13) | sign;
    L19:
        if (val >= 855638016) goto L21;
        return sign;
    L21:
        int val2 = (Integer.MAX_VALUE & fbits) >>> 23;
        return ((((fbits & 8388607) | 8388608) + (8388608 >>> (val2 + GnssNative.GeofenceCallbacks.GEOFENCE_STATUS_ERROR_ID_UNKNOWN))) >>> (126 - val2)) | sign;
    }
}
