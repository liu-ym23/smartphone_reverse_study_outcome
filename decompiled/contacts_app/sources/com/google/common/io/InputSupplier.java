package com.google.common.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface InputSupplier<T> {
    T getInput() throws IOException;
}
