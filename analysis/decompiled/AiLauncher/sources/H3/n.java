package H3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.util.Map;

/* loaded from: classes2.dex */
public final class n implements A3.c {

    /* renamed from: a, reason: collision with root package name */
    public final i f2986a = new i();

    @Override // A3.c
    public D3.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        if (barcodeFormat != BarcodeFormat.UPC_A) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
        }
        return this.f2986a.a('0' + str, BarcodeFormat.EAN_13, i10, i11, map);
    }
}
