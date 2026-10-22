package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ArrayMapOwner.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {

    /* JADX INFO: compiled from: ArrayMapOwner.kt */
    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {
        private final int id;
        private final KClass<? extends K> key;

        public AbstractArrayMapAccessor(KClass<? extends K> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.key = r2;
            this.id = r3;
        }

        protected final T extractValue(AbstractArrayMapOwner<K, V> r2) {
            Intrinsics.checkNotNullParameter(r2, "thisRef");
            return r2.getArrayMap().get(this.id);
        }
    }

    protected abstract ArrayMap<V> getArrayMap();

    protected abstract TypeRegistry<K, V> getTypeRegistry();

    protected abstract void registerComponent(KClass<? extends K> r1, V r2);

    public AbstractArrayMapOwner() {
    }

    @Override // java.lang.Iterable
    public final Iterator<V> iterator() {
        return getArrayMap().iterator();
    }

    public final boolean isEmpty() {
        if (getArrayMap().getSize() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
