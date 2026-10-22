package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* loaded from: classes2.dex */
public final /* synthetic */ class f implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4635a = 0;
    public final /* synthetic */ LifecycleInitializer b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f(LifecycleInitializer lifecycleInitializer, LifecycleInitializer.DefaultInitialization defaultInitialization, String str) {
        this.b = lifecycleInitializer;
        this.d = defaultInitialization;
        this.c = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4635a) {
            case 0:
                return this.b.lambda$withInitialization$2((LifecycleInitializer.DefaultInitialization) this.d, this.c, (Throwable) obj);
            default:
                return this.b.lambda$withInitialization$3(this.c, (Function) this.d, (ContextView) obj);
        }
    }

    public /* synthetic */ f(LifecycleInitializer lifecycleInitializer, String str, Function function) {
        this.b = lifecycleInitializer;
        this.c = str;
        this.d = function;
    }
}
