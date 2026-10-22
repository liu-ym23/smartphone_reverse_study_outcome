package cn.bingoogolapple.qrcode.zxing;

import android.content.Context;
import android.util.AttributeSet;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import com.google.zxing.a;

/* JADX INFO: loaded from: classes28.dex */
public class ZXingView extends QRCodeView {
    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    public final void b() {
        a r100 = new a();
        BarcodeType r101 = this.f24316d;
        if (r101 != BarcodeType.ONE_DIMENSION) goto L6;
        r100.a(g0.a.f479450b);
        return;
    L6:
        if (r101 != BarcodeType.TWO_DIMENSION) goto L9;
        r100.a(g0.a.f479451c);
        return;
    L9:
        if (r101 != BarcodeType.ONLY_QR_CODE) goto L12;
        r100.a(g0.a.f479452d);
        return;
    L12:
        if (r101 != BarcodeType.ONLY_CODE_128) goto L15;
        r100.a(g0.a.f479453e);
        return;
    L15:
        if (r101 != BarcodeType.ONLY_EAN_13) goto L18;
        r100.a(g0.a.f479454f);
        return;
    L18:
        if (r101 != BarcodeType.HIGH_FREQUENCY) goto L21;
        r100.a(g0.a.f479455g);
        return;
    L21:
        if (r101 != BarcodeType.CUSTOM) goto L23;
        r100.a(null);
        return;
    L23:
        r100.a(g0.a.f479449a);
    }

    public ZXingView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ZXingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
