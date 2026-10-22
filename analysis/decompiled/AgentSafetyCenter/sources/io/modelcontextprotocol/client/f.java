package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6117a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ LifecycleInitializer f6118b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f6119c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f6120d;

    public /* synthetic */ f(int i) {
        this.f6117a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6117a) {
            case 0:
                return this.f6118b.lambda$withInitialization$2((LifecycleInitializer.DefaultInitialization) this.f6120d, this.f6119c, (Throwable) obj);
            default:
                return this.f6118b.lambda$withInitialization$3(this.f6119c, (Function) this.f6120d, (ContextView) obj);
        }
    }
}
