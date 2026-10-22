package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3840a;
    public final /* synthetic */ ServerTransportProvider.ServerSessionTransport b;

    public /* synthetic */ j(ServerTransportProvider.ServerSessionTransport serverSessionTransport, int i) {
        this.f3840a = i;
        this.b = serverSessionTransport;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f3840a;
        ServerTransportProvider.ServerSessionTransport serverSessionTransport = this.b;
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
