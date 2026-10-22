package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Consumer;
import reactor.core.publisher.MonoSink;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4746a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ McpLoggableSession e;

    public /* synthetic */ h(McpLoggableSession mcpLoggableSession, String str, String str2, Object obj, int i) {
        this.f4746a = i;
        this.e = mcpLoggableSession;
        this.b = str;
        this.c = str2;
        this.d = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4746a) {
            case 0:
                ((McpServerSession) this.e).lambda$sendRequest$2(this.b, this.c, this.d, (MonoSink) obj);
                break;
            default:
                ((McpStreamableServerSession.McpStreamableServerSessionStream) this.e).lambda$sendRequest$2(this.b, this.c, this.d, (MonoSink) obj);
                break;
        }
    }
}
