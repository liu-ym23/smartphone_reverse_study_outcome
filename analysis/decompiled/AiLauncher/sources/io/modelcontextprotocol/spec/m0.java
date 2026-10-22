package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Predicate;

/* loaded from: classes4.dex */
public final /* synthetic */ class m0 implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ McpStreamableServerSession.McpStreamableServerSessionStream f34180a;

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f34180a.equals((McpStreamableServerSession.McpStreamableServerSessionStream) obj);
    }
}
