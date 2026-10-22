package io.modelcontextprotocol.client.transport;

import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class F implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4653a;

    public /* synthetic */ F(int i) {
        this.f4653a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4653a) {
            case 0:
                StdioClientTransport.lambda$closeGracefully$14((Process) obj);
                break;
            default:
                StdioClientTransport.lambda$new$0((String) obj);
                break;
        }
    }
}
