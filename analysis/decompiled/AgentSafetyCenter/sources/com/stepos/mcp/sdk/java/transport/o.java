package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2761c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ServerTransportProvider.ServerSessionTransport f2762f;

    public /* synthetic */ o(int i) {
        this.f2761c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f2761c;
        ServerTransportProvider.ServerSessionTransport serverSessionTransport = this.f2762f;
        switch (i) {
            case 0:
                serverSessionTransport.lambda$startOutboundProcessing$4((qd.e) obj);
                break;
            default:
                serverSessionTransport.lambda$startOutboundProcessing$7((Throwable) obj);
                break;
        }
    }
}
