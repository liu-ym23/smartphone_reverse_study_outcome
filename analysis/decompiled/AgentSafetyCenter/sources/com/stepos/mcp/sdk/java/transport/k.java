package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2752c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ServerTransportProvider.ServerSessionTransport f2753f;

    public /* synthetic */ k(int i) {
        this.f2752c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f2752c;
        ServerTransportProvider.ServerSessionTransport serverSessionTransport = this.f2753f;
        switch (i) {
            case 0:
                serverSessionTransport.lambda$closeGracefully$1();
                break;
            case 1:
                serverSessionTransport.lambda$handleIncomingMessages$3();
                break;
            default:
                serverSessionTransport.lambda$startOutboundProcessing$6();
                break;
        }
    }
}
