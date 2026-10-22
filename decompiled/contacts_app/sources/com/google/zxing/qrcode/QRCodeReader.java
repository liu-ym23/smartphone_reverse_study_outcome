package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class QRCodeReader implements Reader {
    private static final ResultPoint[] NO_POINTS = null;
    private final Decoder decoder;

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    public QRCodeReader() {
        this.decoder = new Decoder();
    }

    static {
        NO_POINTS = new ResultPoint[0];
    }

    protected final Decoder getDecoder() {
        return this.decoder;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r2) throws NotFoundException, ChecksumException, FormatException {
        return decode(r2, null);
    }

    @Override // com.google.zxing.Reader
    public final Result decode(BinaryBitmap r4, Map<DecodeHintType, ?> r5) throws NotFoundException, ChecksumException, FormatException {
        if (r5 != null) goto L4;
    L6:
        DetectorResult r6 = new Detector(r4.getBlackMatrix()).detect(r5);
        DecoderResult r3 = this.decoder.decode(r6.getBits(), r5);
        ResultPoint[] r7 = r6.getPoints();
    L8:
        if ((r3.getOther() instanceof QRCodeDecoderMetaData) == false) goto L10;
        ((QRCodeDecoderMetaData) r3.getOther()).applyMirroredCorrection(r7);
    L10:
        Result r8 = new Result(r3.getText(), r3.getRawBytes(), r7, BarcodeFormat.QR_CODE);
        List<byte[]> r9 = r3.getByteSegments();
        if (r9 == null) goto L13;
        r8.putMetadata(ResultMetadataType.BYTE_SEGMENTS, r9);
    L13:
        String r10 = r3.getECLevel();
        if (r10 == null) goto L17;
        r8.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, r10);
    L17:
        if (r3.hasStructuredAppend() == false) goto L19;
        r8.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(r3.getStructuredAppendSequenceNumber()));
        r8.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(r3.getStructuredAppendParity()));
    L19:
        return r8;
    L4:
        if (r5.containsKey(DecodeHintType.PURE_BARCODE) == false) goto L6;
        BitMatrix r11 = extractPureBits(r4.getBlackMatrix());
        r3 = this.decoder.decode(r11, r5);
        r7 = NO_POINTS;
        goto L8
    }

    private static BitMatrix extractPureBits(BitMatrix r11) throws NotFoundException {
        int[] r0 = r11.getTopLeftOnBit();
        int[] r1 = r11.getBottomRightOnBit();
        if (r0 == null) goto L48;
        if (r1 == null) goto L48;
        float r2 = moduleSize(r0, r11);
        int r4 = r0[1];
        int r5 = r1[1];
        int r3 = r0[0];
        int r6 = r1[0];
        if (r3 >= r6) goto L46;
        if (r4 >= r5) goto L46;
        int r7 = r5 - r4;
        if (r7 == (r6 - r3)) goto L15;
        r6 = r3 + r7;
        if (r6 < r11.getWidth()) goto L15;
        throw NotFoundException.getNotFoundInstance();
    L15:
        int r8 = Math.round(((r6 - r3) + 1) / r2);
        int r9 = Math.round((r7 + 1) / r2);
        if (r8 <= 0) goto L44;
        if (r9 <= 0) goto L44;
        if (r9 != r8) goto L42;
        int r10 = (int) (r2 / 2.0f);
        int r12 = r4 + r10;
        int r13 = r3 + r10;
        int r14 = (((int) ((r8 - 1) * r2)) + r13) - r6;
        if (r14 <= 0) goto L25;
        if (r14 > r10) goto L24;
        r13 = r13 - r14;
        goto L25
    L24:
        throw NotFoundException.getNotFoundInstance();
    L25:
        int r15 = (((int) ((r9 - 1) * r2)) + r12) - r5;
        if (r15 <= 0) goto L31;
        if (r15 > r10) goto L30;
        r12 = r12 - r15;
        goto L31
    L30:
        throw NotFoundException.getNotFoundInstance();
    L31:
        BitMatrix r16 = new BitMatrix(r8, r9);
        int r17 = 0;
    L32:
        if (r17 >= r9) goto L40;
        int r18 = ((int) (r17 * r2)) + r12;
        int r19 = 0;
    L34:
        if (r19 >= r8) goto L39;
        if (r11.get(((int) (r19 * r2)) + r13, r18) == false) goto L38;
        r16.set(r19, r17);
    L38:
        r19 = r19 + 1;
        goto L34
    L39:
        r17 = r17 + 1;
        goto L32
    L40:
        return r16;
    L42:
        throw NotFoundException.getNotFoundInstance();
    L44:
        throw NotFoundException.getNotFoundInstance();
    L46:
        throw NotFoundException.getNotFoundInstance();
    L48:
        throw NotFoundException.getNotFoundInstance();
    }

    private static float moduleSize(int[] r8, BitMatrix r9) throws NotFoundException {
        int r0 = r9.getHeight();
        int r1 = r9.getWidth();
        int r3 = r8[0];
        boolean r4 = true;
        int r5 = r8[1];
        int r6 = 0;
    L3:
        if (r3 >= r1) goto L11;
        if (r5 >= r0) goto L11;
        if (r4 == r9.get(r3, r5)) goto L10;
        r6 = r6 + 1;
        if (r6 == 5) goto L11;
        r4 = !r4;
    L10:
        r3 = r3 + 1;
        r5 = r5 + 1;
    L11:
        if (r3 == r1) goto L16;
        if (r5 == r0) goto L16;
        return (r3 - r8[0]) / 7.0f;
    L16:
        throw NotFoundException.getNotFoundInstance();
    }
}
