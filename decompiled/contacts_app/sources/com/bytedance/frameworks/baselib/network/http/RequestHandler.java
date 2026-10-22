package com.bytedance.frameworks.baselib.network.http;

import java.net.URI;

/* JADX INFO: loaded from: classes2.dex */
public interface RequestHandler {
    void abort();

    URI getURI();
}
