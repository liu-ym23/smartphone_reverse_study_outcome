package io.modelcontextprotocol.client.transport;

import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpClientStreamableHttpTransport f6216c;

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f6216c.lambda$reconnect$16((Throwable) obj);
    }
}
