package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Consumer;
import reactor.core.publisher.MonoSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6360c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f6361f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f6362g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6363h;
    public /* synthetic */ McpLoggableSession i;

    public /* synthetic */ f(int i) {
        this.f6360c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6360c) {
            case 0:
                ((McpServerSession) this.i).lambda$sendRequest$2(this.f6361f, this.f6362g, this.f6363h, (MonoSink) obj);
                break;
            default:
                ((McpStreamableServerSession.McpStreamableServerSessionStream) this.i).lambda$sendRequest$2(this.f6361f, this.f6362g, this.f6363h, (MonoSink) obj);
                break;
        }
    }
}
