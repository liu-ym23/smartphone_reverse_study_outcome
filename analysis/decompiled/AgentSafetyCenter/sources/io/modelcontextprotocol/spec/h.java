package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import io.modelcontextprotocol.util.KeepAliveScheduler;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6366c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6367f;

    public /* synthetic */ h(int i) {
        this.f6366c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f6366c;
        Object obj2 = this.f6367f;
        switch (i) {
            case 0:
                return ((McpStreamableServerSession.McpStreamableServerSessionStream) obj2).equals((McpStreamableServerSession.McpStreamableServerSessionStream) obj);
            case 1:
                return ((KeepAliveScheduler) obj2).lambda$start$5((Throwable) obj);
            default:
                return ((Predicate) obj2).test((Throwable) obj);
        }
    }
}
