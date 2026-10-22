package B3;

import A3.c;
import D3.b;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements c {
    public static b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Charset charset, int i12, int i13) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return c(C3.c.d(str, i12, i13, charset), i10, i11);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    public static b c(C3.a aVar, int i10, int i11) {
        b bVarA = aVar.a();
        if (bVarA == null) {
            throw new IllegalStateException();
        }
        int i12 = bVarA.i();
        int iH = bVarA.h();
        int iMax = Math.max(i10, i12);
        int iMax2 = Math.max(i11, iH);
        int iMin = Math.min(iMax / i12, iMax2 / iH);
        int i13 = (iMax - (i12 * iMin)) / 2;
        int i14 = (iMax2 - (iH * iMin)) / 2;
        b bVar = new b(iMax, iMax2);
        int i15 = 0;
        while (i15 < iH) {
            int i16 = 0;
            int i17 = i13;
            while (i16 < i12) {
                if (bVarA.g(i16, i15)) {
                    bVar.k(i17, i14, iMin, iMin);
                }
                i16++;
                i17 += iMin;
            }
            i15++;
            i14 += iMin;
        }
        return bVar;
    }

    @Override // A3.c
    public b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws NumberFormatException {
        int i12 = 0;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            charsetForName = map.containsKey(encodeHintType) ? Charset.forName(map.get(encodeHintType).toString()) : null;
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            i = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                i12 = Integer.parseInt(map.get(encodeHintType3).toString());
            }
        }
        return b(str, barcodeFormat, i10, i11, charsetForName, i, i12);
    }
}
