package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d0 implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6257c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpStatelessAsyncServer f6258f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f6259g;

    public /* synthetic */ d0(int i) {
        this.f6257c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f6257c) {
            case 0:
                return this.f6258f.lambda$findResourceTemplateSpecification$23(this.f6259g, (McpStatelessServerFeatures.AsyncResourceTemplateSpecification) obj);
            default:
                return this.f6258f.lambda$findResourceSpecification$22(this.f6259g, (McpStatelessServerFeatures.AsyncResourceSpecification) obj);
        }
    }
}
