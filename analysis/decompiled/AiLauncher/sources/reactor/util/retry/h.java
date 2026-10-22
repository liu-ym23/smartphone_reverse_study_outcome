package reactor.util.retry;

import java.util.function.Predicate;

/* loaded from: classes5.dex */
public final /* synthetic */ class h implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Predicate f39865a;

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f39865a.test((Throwable) obj);
    }
}
