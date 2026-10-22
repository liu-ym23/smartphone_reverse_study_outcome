package io.modelcontextprotocol.spec;

import java.util.function.Consumer;
import reactor.util.function.Tuple2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6345c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ DefaultMcpTransportStream f6346f;

    public /* synthetic */ a(int i) {
        this.f6345c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f6345c;
        DefaultMcpTransportStream defaultMcpTransportStream = this.f6346f;
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
