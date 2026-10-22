package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.RSS14Reader;
import com.google.zxing.oned.rss.expanded.RSSExpandedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class MultiFormatOneDReader extends OneDReader {
    private final OneDReader[] readers;

    public MultiFormatOneDReader(Map<DecodeHintType, ?> r5) {
        if (r5 != null) goto L5;
        Collection r0 = null;
    L6:
        if (r5 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        ArrayList r2 = new ArrayList();
        if (r0 == null) goto L44;
        if (r0.contains(BarcodeFormat.EAN_13) == false) goto L16;
    L21:
        r2.add(new MultiFormatUPCEANReader(r5));
    L23:
        if (r0.contains(BarcodeFormat.CODE_39) == false) goto L26;
        r2.add(new Code39Reader(r1));
    L26:
        if (r0.contains(BarcodeFormat.CODE_93) == false) goto L29;
        r2.add(new Code93Reader());
    L29:
        if (r0.contains(BarcodeFormat.CODE_128) == false) goto L32;
        r2.add(new Code128Reader());
    L32:
        if (r0.contains(BarcodeFormat.ITF) == false) goto L35;
        r2.add(new ITFReader());
    L35:
        if (r0.contains(BarcodeFormat.CODABAR) == false) goto L38;
        r2.add(new CodaBarReader());
    L38:
        if (r0.contains(BarcodeFormat.RSS_14) == false) goto L41;
        r2.add(new RSS14Reader());
    L41:
        if (r0.contains(BarcodeFormat.RSS_EXPANDED) == false) goto L44;
        r2.add(new RSSExpandedReader());
        goto L44
    L16:
        if (r0.contains(BarcodeFormat.UPC_A) == true) goto L21;
        if (r0.contains(BarcodeFormat.EAN_8) == true) goto L21;
        if (r0.contains(BarcodeFormat.UPC_E) == false) goto L23;
    L44:
        if (r2.isEmpty() == false) goto L46;
        r2.add(new MultiFormatUPCEANReader(r5));
        r2.add(new Code39Reader());
        r2.add(new CodaBarReader());
        r2.add(new Code93Reader());
        r2.add(new Code128Reader());
        r2.add(new ITFReader());
        r2.add(new RSS14Reader());
        r2.add(new RSSExpandedReader());
    L46:
        this.readers = (OneDReader[]) r2.toArray(new OneDReader[r2.size()]);
        return;
    L8:
        if (r5.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) goto L10;
        r1 = true;
        goto L11
    L5:
        r0 = (Collection) r5.get(DecodeHintType.POSSIBLE_FORMATS);
        goto L6
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r4, BitArray r5, Map<DecodeHintType, ?> r6) throws NotFoundException {
        OneDReader[] r3 = this.readers;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        return r3[r1].decodeRow(r4, r5, r6);
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        OneDReader[] r3 = this.readers;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].reset();
        r1 = r1 + 1;
        goto L3
    }
}
