package b8;

import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Consumer;
import reactor.core.Exceptions;
import reactor.core.publisher.MonoSink;
import reactor.util.retry.Retry;
import reactor.util.retry.RetrySpec;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1964c;

    public /* synthetic */ h(int i) {
        this.f1964c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f1964c) {
            case 0:
                ((w7.l) obj).h();
                break;
            case 1:
                McpClientSession.lambda$sendRequest$8((Void) obj);
                break;
            case 2:
                McpServerSession.lambda$sendRequest$0((Void) obj);
                break;
            case 3:
                McpServerSession.lambda$handle$5((Throwable) obj);
                break;
            case 4:
                McpStreamableServerSession.McpStreamableServerSessionStream.lambda$sendRequest$1((Void) obj);
                break;
            case 5:
                McpStreamableServerSession.McpStreamableServerSessionStream.lambda$closeGracefully$5((MonoSink) obj);
                break;
            case 6:
                McpStreamableServerSession.McpStreamableServerSessionStream.lambda$close$7((MonoSink) obj);
                break;
            case 7:
                Exceptions.lambda$static$0((AutoCloseable) obj);
                break;
            default:
                RetrySpec.lambda$static$0((Retry.RetrySignal) obj);
                break;
        }
    }
}
