package com.google.zxing;

import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MultiFormatWriter implements Writer {

    /* JADX INFO: renamed from: com.google.zxing.MultiFormatWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$BarcodeFormat = null;

        static {
            int[] r0 = new int[BarcodeFormat.values().length];
            $SwitchMap$com$google$zxing$BarcodeFormat = r0;
            r0[BarcodeFormat.EAN_8.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.UPC_E.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.EAN_13.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.UPC_A.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.QR_CODE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.CODE_39.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.CODE_93.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.CODE_128.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.ITF.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.PDF_417.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.CODABAR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.AZTEC.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    public MultiFormatWriter() {
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) throws WriterException {
        return encode(r7, r8, r9, r10, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10, Map<EncodeHintType, ?> r11) throws WriterException {
        switch(AnonymousClass1.$SwitchMap$com$google$zxing$BarcodeFormat[r8.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            default: goto L5;
        };
    L6:
        Writer r6 = new AztecWriter();
    L20:
        return r6.encode(r7, r8, r9, r10, r11);
    L7:
        r6 = new DataMatrixWriter();
        goto L20
    L8:
        r6 = new CodaBarWriter();
        goto L20
    L9:
        r6 = new PDF417Writer();
        goto L20
    L10:
        r6 = new ITFWriter();
        goto L20
    L11:
        r6 = new Code128Writer();
        goto L20
    L12:
        r6 = new Code93Writer();
        goto L20
    L13:
        r6 = new Code39Writer();
        goto L20
    L14:
        r6 = new QRCodeWriter();
        goto L20
    L15:
        r6 = new UPCAWriter();
        goto L20
    L16:
        r6 = new EAN13Writer();
        goto L20
    L17:
        r6 = new UPCEWriter();
        goto L20
    L18:
        r6 = new EAN8Writer();
        goto L20
    L5:
        throw new IllegalArgumentException("No encoder available for format " + r8);
    }
}
