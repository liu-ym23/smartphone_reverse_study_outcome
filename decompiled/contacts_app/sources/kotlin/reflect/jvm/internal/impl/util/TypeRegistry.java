package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ArrayMapOwner.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TypeRegistry<K, V> {
    private final AtomicInteger idCounter;
    private final ConcurrentHashMap<KClass<? extends K>, Integer> idPerType;

    public abstract <T extends K> int customComputeIfAbsent(ConcurrentHashMap<KClass<? extends K>, Integer> r1, KClass<T> r2, Function1<? super KClass<? extends K>, Integer> r3);

    public TypeRegistry() {
        this.idPerType = new ConcurrentHashMap();
        this.idCounter = new AtomicInteger(0);
    }

    public static final /* synthetic */ AtomicInteger access$getIdCounter$p(TypeRegistry r0) {
        return r0.idCounter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(KClass<KK> r2) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        return new NullableArrayMapAccessor(r2, getId(r2));
    }

    public final <T extends K> int getId(KClass<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "kClass");
        return customComputeIfAbsent(this.idPerType, r3, new AnonymousClass1(this));
    }

    protected final Collection<Integer> getIndices() {
        Collection<Integer> r1 = this.idPerType.values();
        Intrinsics.checkNotNullExpressionValue(r1, "idPerType.values");
        return r1;
    }
}
