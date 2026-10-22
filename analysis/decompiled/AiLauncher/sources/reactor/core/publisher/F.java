package reactor.core.publisher;

import java.util.function.Supplier;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
public final /* synthetic */ class F implements Supplier {
    @Override // java.util.function.Supplier
    public final Object get() {
        return Context.empty();
    }
}
