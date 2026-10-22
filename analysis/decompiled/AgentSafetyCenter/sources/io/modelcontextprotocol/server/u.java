package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import java.util.List;
import java.util.function.BiConsumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ BiConsumer f6323c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpAsyncServerExchange f6324f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ List f6325g;

    @Override // java.lang.Runnable
    public final void run() {
        McpServerFeatures.Async.lambda$fromSync$4(this.f6323c, this.f6324f, this.f6325g);
    }
}
