package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6281c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpAsyncServer f6282f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f6283g;

    public /* synthetic */ n(int i) {
        this.f6281c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f6281c) {
            case 0:
                return this.f6282f.lambda$findResourceTemplateSpecification$31(this.f6283g, (McpServerFeatures.AsyncResourceTemplateSpecification) obj);
            default:
                return this.f6282f.lambda$findResourceSpecification$30(this.f6283g, (McpServerFeatures.AsyncResourceSpecification) obj);
        }
    }
}
