package com.stepos.mcp.sdk.java.transport;

import java.util.function.Consumer;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3832a;

    public /* synthetic */ a(int i) {
        this.f3832a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        switch (this.f3832a) {
            case 0:
                AIDLServerTransportProvider.lambda$notifyClients$0(th);
                break;
            default:
                ServerTransportProvider.lambda$notifyClients$0(th);
                break;
        }
    }
}
