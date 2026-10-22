package io.modelcontextprotocol.client.transport;

import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6177c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ StdioClientTransport f6178f;

    public /* synthetic */ g0(int i) {
        this.f6177c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f6177c;
        StdioClientTransport stdioClientTransport = this.f6178f;
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
