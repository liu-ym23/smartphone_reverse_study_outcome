package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface MultipleBarcodeReader {
    Result[] decodeMultiple(BinaryBitmap r1) throws NotFoundException;

    Result[] decodeMultiple(BinaryBitmap r1, Map<DecodeHintType, ?> r2) throws NotFoundException;
}
