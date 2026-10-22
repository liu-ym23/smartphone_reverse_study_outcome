package io.modelcontextprotocol.client.transport;

import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class G implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4654a;
    public final /* synthetic */ StdioClientTransport b;

    public /* synthetic */ G(StdioClientTransport stdioClientTransport, int i) {
        this.f4654a = i;
        this.b = stdioClientTransport;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f4654a;
        StdioClientTransport stdioClientTransport = this.b;
        switch (i) {
            case 0:
                stdioClientTransport.lambda$handleIncomingErrors$5((String) obj);
                break;
            default:
                stdioClientTransport.lambda$handleOutbound$10((Throwable) obj);
                break;
        }
    }
}
