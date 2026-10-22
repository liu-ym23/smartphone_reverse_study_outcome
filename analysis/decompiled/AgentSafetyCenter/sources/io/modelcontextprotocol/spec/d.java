package io.modelcontextprotocol.spec;

import java.util.function.Consumer;
import reactor.core.publisher.MonoSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6353c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f6354f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ MonoSink f6355g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ McpSession f6356h;

    public /* synthetic */ d(int i) {
        this.f6353c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6353c) {
            case 0:
                ((McpClientSession) this.f6356h).lambda$sendRequest$9(this.f6354f, this.f6355g, (Throwable) obj);
                break;
            default:
                ((McpServerSession) this.f6356h).lambda$sendRequest$1(this.f6354f, this.f6355g, (Throwable) obj);
                break;
        }
    }
}
