package io.modelcontextprotocol.json.schema;

import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ AtomicReference f6236a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return JsonSchemaInternal.lambda$createDefaultValidator$0(this.f6236a, (ServiceLoader.Provider) obj);
    }
}
