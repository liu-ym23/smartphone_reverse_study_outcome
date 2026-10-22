package reactor.core.publisher;

import java.util.function.Supplier;
import reactor.core.CoreSubscriber;

/* loaded from: classes5.dex */
public final /* synthetic */ class J0 implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoreSubscriber f39628a;

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f39628a.currentContext();
    }
}
