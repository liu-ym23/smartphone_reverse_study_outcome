package io.modelcontextprotocol.json;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ AtomicReference f6233a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return McpJsonInternal.lambda$createDefaultMapper$1(this.f6233a, (McpJsonMapperSupplier) obj);
    }
}
