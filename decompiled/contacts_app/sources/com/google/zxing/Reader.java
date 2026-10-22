package com.google.zxing;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface Reader {
    Result decode(BinaryBitmap r1) throws NotFoundException, ChecksumException, FormatException;

    Result decode(BinaryBitmap r1, Map<DecodeHintType, ?> r2) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
