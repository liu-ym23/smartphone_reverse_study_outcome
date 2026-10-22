package com.stepos.mcp.sdk.java.transport;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return AndroidClientTransport.lambda$static$0(runnable);
    }
}
