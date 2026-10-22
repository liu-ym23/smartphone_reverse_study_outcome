package com.bytedance.rpc.transport;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface TransportInput {
    long contentLength() throws IOException;

    String contentType();

    InputStream in() throws IOException;
}
