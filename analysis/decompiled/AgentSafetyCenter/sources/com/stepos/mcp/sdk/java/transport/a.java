package com.stepos.mcp.sdk.java.transport;

import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2733c;

    public /* synthetic */ a(int i) {
        this.f2733c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        switch (this.f2733c) {
            case 0:
                AIDLServerTransportProvider.lambda$notifyClients$0(th);
                break;
            default:
                ServerTransportProvider.lambda$notifyClients$0(th);
                break;
        }
    }
}
