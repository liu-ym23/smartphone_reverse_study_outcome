package A3;

import H3.e;
import H3.g;
import H3.i;
import H3.j;
import H3.k;
import H3.n;
import H3.r;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.oned.Code128Writer;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b implements c {

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1125a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f1125a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1125a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1125a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1125a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1125a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1125a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1125a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1125a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1125a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1125a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1125a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1125a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1125a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // A3.c
    public D3.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        c jVar;
        switch (a.f1125a[barcodeFormat.ordinal()]) {
            case 1:
                jVar = new j();
                break;
            case 2:
                jVar = new r();
                break;
            case 3:
                jVar = new i();
                break;
            case 4:
                jVar = new n();
                break;
            case 5:
                jVar = new K3.a();
                break;
            case 6:
                jVar = new e();
                break;
            case 7:
                jVar = new g();
                break;
            case 8:
                jVar = new Code128Writer();
                break;
            case 9:
                jVar = new k();
                break;
            case 10:
                jVar = new I3.a();
                break;
            case 11:
                jVar = new H3.b();
                break;
            case 12:
                jVar = new F3.a();
                break;
            case 13:
                jVar = new B3.a();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return jVar.a(str, barcodeFormat, i10, i11, map);
    }
}
