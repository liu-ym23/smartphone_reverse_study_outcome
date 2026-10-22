package V;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class b extends h {

    /* renamed from: a, reason: collision with root package name */
    public final Map f1915a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f1916b;

    public b(Map preferencesMap, boolean z4) {
        Intrinsics.checkNotNullParameter(preferencesMap, "preferencesMap");
        this.f1915a = preferencesMap;
        this.f1916b = new AtomicBoolean(z4);
    }

    @Override // V.h
    public final Map a() {
        Map mapUnmodifiableMap = Collections.unmodifiableMap(this.f1915a);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
        return mapUnmodifiableMap;
    }

    @Override // V.h
    public final Object b(f key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f1915a.get(key);
    }

    public final void c() {
        if (!(!this.f1916b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public final void d(f key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        c();
        Map map = this.f1915a;
        if (obj == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            c();
            map.remove(key);
        } else {
            if (!(obj instanceof Set)) {
                map.put(key, obj);
                return;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(CollectionsKt.toSet((Iterable) obj));
            Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(value.toSet())");
            map.put(key, setUnmodifiableSet);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return Intrinsics.areEqual(this.f1915a, ((b) obj).f1915a);
    }

    public final int hashCode() {
        return this.f1915a.hashCode();
    }

    public final String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(this.f1915a.entrySet(), ",\n", "{\n", "\n}", 0, null, a.f1914a, 24, null);
    }

    public /* synthetic */ b(boolean z4) {
        this(new LinkedHashMap(), z4);
    }
}
