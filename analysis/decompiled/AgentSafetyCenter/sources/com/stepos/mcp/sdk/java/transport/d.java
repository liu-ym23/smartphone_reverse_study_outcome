package com.stepos.mcp.sdk.java.transport;

import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2738c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f2739f;

    public /* synthetic */ d(int i) {
        this.f2738c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f2738c;
        Object obj2 = this.f2739f;
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
