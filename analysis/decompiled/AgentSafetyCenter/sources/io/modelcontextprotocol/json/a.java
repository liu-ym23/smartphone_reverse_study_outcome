package io.modelcontextprotocol.json;

import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ AtomicReference f6232a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return McpJsonInternal.lambda$createDefaultMapper$0(this.f6232a, (ServiceLoader.Provider) obj);
    }
}
