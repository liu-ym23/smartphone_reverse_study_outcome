package com.stepos.mcp.sdk.java.transport;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return AndroidClientTransport.lambda$static$0(runnable);
    }
}
