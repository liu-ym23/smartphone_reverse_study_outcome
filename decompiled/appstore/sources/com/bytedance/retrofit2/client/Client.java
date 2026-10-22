package com.bytedance.retrofit2.client;

import g6.b;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface Client {

    public interface Provider {
        Client get();
    }

    SsCall newSsCall(b r10) throws IOException;
}
