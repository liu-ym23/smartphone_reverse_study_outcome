package com.bytedance.android.livehostapi.foundation.depend;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public interface LiveCall<T> {
    void cancel() throws IOException;

    T execute() throws IOException;
}
