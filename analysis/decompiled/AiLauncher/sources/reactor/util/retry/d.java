package reactor.util.retry;

import java.util.function.Supplier;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes5.dex */
public final /* synthetic */ class d implements Supplier {
    @Override // java.util.function.Supplier
    public final Object get() {
        return Schedulers.parallel();
    }
}
