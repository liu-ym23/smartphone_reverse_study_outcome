package io.modelcontextprotocol.client.transport;

import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f0 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6176c;

    public /* synthetic */ f0(int i) {
        this.f6176c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6176c) {
            case 0:
                StdioClientTransport.lambda$closeGracefully$14((Process) obj);
                break;
            default:
                StdioClientTransport.lambda$new$0((String) obj);
                break;
        }
    }
}
