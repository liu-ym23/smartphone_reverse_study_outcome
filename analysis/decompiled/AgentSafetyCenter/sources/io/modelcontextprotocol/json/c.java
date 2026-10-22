package io.modelcontextprotocol.json;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ AtomicReference f6234c;

    @Override // java.util.function.Supplier
    public final Object get() {
        return McpJsonInternal.lambda$createDefaultMapper$2(this.f6234c);
    }
}
