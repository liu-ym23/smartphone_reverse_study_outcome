package com.google.common.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface ByteProcessor<T> {
    T getResult();

    boolean processBytes(byte[] r1, int r2, int r3) throws IOException;
}
