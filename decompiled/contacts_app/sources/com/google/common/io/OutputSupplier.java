package com.google.common.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface OutputSupplier<T> {
    T getOutput() throws IOException;
}
