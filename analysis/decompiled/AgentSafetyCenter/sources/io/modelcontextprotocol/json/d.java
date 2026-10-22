package io.modelcontextprotocol.json;

import java.util.function.UnaryOperator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements UnaryOperator {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Exception f6235a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return McpJsonInternal.lambda$addException$3(this.f6235a, (IllegalStateException) obj);
    }
}
