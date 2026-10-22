package com.bytedance.retrofit2.client;

import g6.b;
import g6.c;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface SsCall {
    void cancel();

    c execute() throws IOException;

    b getRequest();

    boolean setThrottleNetSpeed(long r10);
}
