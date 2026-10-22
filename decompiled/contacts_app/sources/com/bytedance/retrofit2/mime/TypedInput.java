package com.bytedance.retrofit2.mime;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface TypedInput {
    InputStream in() throws IOException;

    long length() throws IOException;

    String mimeType();
}
