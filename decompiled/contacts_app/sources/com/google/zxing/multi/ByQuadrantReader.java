package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ByQuadrantReader implements Reader {
    private final Reader delegate;

    public ByQuadrantReader(Reader r1) {
        this.delegate = r1;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r2) throws NotFoundException, ChecksumException, FormatException {
        return decode(r2, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r6, Map<DecodeHintType, ?> r7) throws NotFoundException, ChecksumException, FormatException {
        int r0 = r6.getWidth();
        int r1 = r0 / 2;
        int r2 = r6.getHeight() / 2;
        return this.delegate.decode(r6.crop(0, 0, r1, r2), r7);
    L5:
        Result r3 = this.delegate.decode(r6.crop(r1, 0, r1, r2), r7);     // Catch: NotFoundException -> L7
        makeAbsolute(r3.getResultPoints(), r1, 0);     // Catch: NotFoundException -> L7
        return r3;
    L7:
        Result r4 = this.delegate.decode(r6.crop(0, r2, r1, r2), r7);     // Catch: NotFoundException -> L9
        makeAbsolute(r4.getResultPoints(), 0, r2);     // Catch: NotFoundException -> L9
        return r4;
    L9:
        Result r5 = this.delegate.decode(r6.crop(r1, r2, r1, r2), r7);     // Catch: NotFoundException -> L11
        makeAbsolute(r5.getResultPoints(), r1, r2);     // Catch: NotFoundException -> L11
        return r5;
    L11:
        int r8 = r1 / 2;
        int r9 = r2 / 2;
        BinaryBitmap r10 = r6.crop(r8, r9, r1, r2);
        Result r11 = this.delegate.decode(r10, r7);
        makeAbsolute(r11.getResultPoints(), r8, r9);
        return r11;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        this.delegate.reset();
    }

    private static void makeAbsolute(ResultPoint[] r5, int r6, int r7) {
        if (r5 == null) goto L7;
        int r0 = 0;
    L5:
        if (r0 >= r5.length) goto L9;
        ResultPoint r1 = r5[r0];
        r5[r0] = new ResultPoint(r1.getX() + r6, r1.getY() + r7);
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }
}
