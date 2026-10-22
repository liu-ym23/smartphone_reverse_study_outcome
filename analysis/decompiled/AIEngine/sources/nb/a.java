package nb;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.g;
import mb.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends h<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return ((kotlin.collections.builders.a) this).f10051a.g((Map.Entry) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        MapBuilder<K, V> mapBuilder = ((kotlin.collections.builders.a) this).f10051a;
        mapBuilder.getClass();
        mapBuilder.c();
        int i10 = mapBuilder.i(entry.getKey());
        if (i10 >= 0) {
            V[] vArr = mapBuilder.f10028b;
            g.c(vArr);
            if (g.b(vArr[i10], entry.getValue())) {
                mapBuilder.m(i10);
                return true;
            }
        }
        return false;
    }
}
