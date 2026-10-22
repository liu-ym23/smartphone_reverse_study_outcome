package io.modelcontextprotocol.json.schema;

import java.util.function.UnaryOperator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements UnaryOperator {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Exception f6239a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return JsonSchemaInternal.lambda$addException$3(this.f6239a, (IllegalStateException) obj);
    }
}
