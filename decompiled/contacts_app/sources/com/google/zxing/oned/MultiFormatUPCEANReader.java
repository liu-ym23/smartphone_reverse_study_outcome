package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class MultiFormatUPCEANReader extends OneDReader {
    private final UPCEANReader[] readers;

    public MultiFormatUPCEANReader(Map<DecodeHintType, ?> r3) {
        if (r3 != null) goto L5;
        Collection r4 = null;
    L6:
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L21;
        if (r4.contains(BarcodeFormat.EAN_13) == false) goto L12;
        r0.add(new EAN13Reader());
    L15:
        if (r4.contains(BarcodeFormat.EAN_8) == false) goto L18;
        r0.add(new EAN8Reader());
    L18:
        if (r4.contains(BarcodeFormat.UPC_E) == false) goto L21;
        r0.add(new UPCEReader());
        goto L21
    L12:
        if (r4.contains(BarcodeFormat.UPC_A) == false) goto L15;
        r0.add(new UPCAReader());
    L21:
        if (r0.isEmpty() == false) goto L23;
        r0.add(new EAN13Reader());
        r0.add(new EAN8Reader());
        r0.add(new UPCEReader());
    L23:
        this.readers = (UPCEANReader[]) r0.toArray(new UPCEANReader[r0.size()]);
        return;
    L5:
        r4 = (Collection) r3.get(DecodeHintType.POSSIBLE_FORMATS);
        goto L6
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r6, BitArray r7, Map<DecodeHintType, ?> r8) throws NotFoundException {
        int[] r0 = UPCEANReader.findStartGuardPattern(r7);
        UPCEANReader[] r5 = this.readers;
        int r1 = r5.length;
        boolean r2 = false;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L26;
        Result r9 = r5[r3].decodeRow(r6, r7, r0, r8);     // Catch: ReaderException -> L24
        if (r9.getBarcodeFormat() == BarcodeFormat.EAN_13) goto L9;
    L11:
        boolean r10 = false;
    L12:
        if (r8 != null) goto L14;
        Collection r11 = null;
    L15:
        if (r11 != null) goto L17;
    L18:
        r2 = true;
    L19:
        if (r10 == false) goto L23;
        if (r2 == false) goto L23;
        Result r12 = new Result(r9.getText().substring(1), r9.getRawBytes(), r9.getResultPoints(), BarcodeFormat.UPC_A);
        r12.putAllMetadata(r9.getResultMetadata());
        return r12;
    L23:
        return r9;
    L17:
        if (r11.contains(BarcodeFormat.UPC_A) == false) goto L19;
    L14:
        r11 = (Collection) r8.get(DecodeHintType.POSSIBLE_FORMATS);
        goto L15
    L9:
        if (r9.getText().charAt(0) != '0') goto L11;
        r10 = true;
    L24:
        r3 = r3 + 1;
        goto L3
    L26:
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        UPCEANReader[] r3 = this.readers;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].reset();
        r1 = r1 + 1;
        goto L3
    }
}
