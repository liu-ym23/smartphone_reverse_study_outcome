package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Consumer;
import reactor.core.Exceptions;
import reactor.core.publisher.MonoSink;
import reactor.util.retry.Retry;
import reactor.util.retry.RetrySpec;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4740a;

    public /* synthetic */ b(int i) {
        this.f4740a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4740a) {
            case 0:
                McpClientSession.lambda$sendRequest$8((Void) obj);
                break;
            case 1:
                McpServerSession.lambda$sendRequest$0((Void) obj);
                break;
            case 2:
                McpServerSession.lambda$handle$5((Throwable) obj);
                break;
            case 3:
                McpStreamableServerSession.McpStreamableServerSessionStream.lambda$sendRequest$1((Void) obj);
                break;
            case 4:
                McpStreamableServerSession.McpStreamableServerSessionStream.lambda$closeGracefully$5((MonoSink) obj);
                break;
            case 5:
                McpStreamableServerSession.McpStreamableServerSessionStream.lambda$close$7((MonoSink) obj);
                break;
            case 6:
                Exceptions.lambda$static$0((AutoCloseable) obj);
                break;
            case 7:
                RetrySpec.lambda$static$0((Retry.RetrySignal) obj);
                break;
            default:
                ((u3.i) obj).h();
                break;
        }
    }
}
