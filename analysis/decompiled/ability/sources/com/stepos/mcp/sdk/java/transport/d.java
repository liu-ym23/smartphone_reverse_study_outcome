package com.stepos.mcp.sdk.java.transport;

import java.util.function.Consumer;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3835a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(Object obj, int i) {
        this.f3835a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f3835a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((AIDLServerTransportProvider) obj2).lambda$closeGracefully$3((Void) obj);
                break;
            default:
                ((AndroidClientTransport) obj2).lambda$handleOutbound$8((Throwable) obj);
                break;
        }
    }
}
