package io.modelcontextprotocol.spec;

import java.util.function.Consumer;
import reactor.core.publisher.MonoSink;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ McpClientSession f6349c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f6350f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f6351g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6352h;
    public /* synthetic */ ContextView i;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f6349c.lambda$sendRequest$10(this.f6350f, this.f6351g, this.f6352h, this.i, (MonoSink) obj);
    }
}
