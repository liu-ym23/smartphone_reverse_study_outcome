package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {
    private final MemoizedFunctionToNullable<FqName, T> cache;
    private final Map<FqName, T> states;
    private final LockBasedStorageManager storageManager;

    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityAnnotationStatesImpl(Map<FqName, ? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "states");
        this.states = r2;
        LockBasedStorageManager r3 = new LockBasedStorageManager("Java nullability annotation states");
        this.storageManager = r3;
        MemoizedFunctionToNullable<FqName, T> r4 = r3.createMemoizedFunctionWithNullableValues(new NullabilityAnnotationStatesImpl$cache$1(this));
        Intrinsics.checkNotNullExpressionValue(r4, "storageManager.createMem…cificFqname(states)\n    }");
        this.cache = r4;
    }

    public final Map<FqName, T> getStates() {
        return this.states;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates
    public T get(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return this.cache.invoke(r2);
    }
}
