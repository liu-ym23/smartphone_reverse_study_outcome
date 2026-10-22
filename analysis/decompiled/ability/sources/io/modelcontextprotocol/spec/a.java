package io.modelcontextprotocol.spec;

import java.util.function.Consumer;
import reactor.util.function.Tuple2;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4739a;
    public final /* synthetic */ DefaultMcpTransportStream b;

    public /* synthetic */ a(DefaultMcpTransportStream defaultMcpTransportStream, int i) {
        this.f4739a = i;
        this.b = defaultMcpTransportStream;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f4739a;
        DefaultMcpTransportStream defaultMcpTransportStream = this.b;
        switch (i) {
            case 0:
                defaultMcpTransportStream.lambda$consumeSseStream$0((String) obj);
                break;
            default:
                defaultMcpTransportStream.lambda$consumeSseStream$1((Tuple2) obj);
                break;
        }
    }
}
