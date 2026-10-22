package reactor.core.publisher;

import java.util.function.Function;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
public final /* synthetic */ class I implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5838a;
    public final /* synthetic */ Object b;

    public /* synthetic */ I(Object obj, int i) {
        this.f5838a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5838a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return ((FluxCombineLatest) obj2).lambda$subscribe$0(obj);
            case 1:
                return Flux.lambda$timeout$35((Mono) obj2, obj);
            default:
                return Operators.lambda$discardLocalAdapter$1((T) obj2, (Context) obj);
        }
    }
}
