package kotlinx.coroutines;

import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AwaitKt {
    public static final <T> Object awaitAll(Collection<? extends Deferred<? extends T>> collection, b<? super List<? extends T>> bVar) {
        return collection.isEmpty() ? EmptyList.f10001a : new AwaitAll((Deferred[]) collection.toArray(new Deferred[0])).await(bVar);
    }
}
