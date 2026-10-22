package androidx.datastore.preferences.core;

import g1.a;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MutablePreferences extends g1.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1706a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f1707b;

    public MutablePreferences() {
        this(false, 3);
    }

    @Override // g1.a
    public final Map<a.C0083a<?>, Object> a() {
        Map<a.C0083a<?>, Object> mapUnmodifiableMap = Collections.unmodifiableMap(this.f1706a);
        g.e(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
        return mapUnmodifiableMap;
    }

    @Override // g1.a
    public final <T> T b(a.C0083a<T> key) {
        g.f(key, "key");
        return (T) this.f1706a.get(key);
    }

    public final void c(a.C0083a<?> key, Object obj) {
        g.f(key, "key");
        AtomicBoolean atomicBoolean = this.f1707b;
        if (atomicBoolean.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
        LinkedHashMap linkedHashMap = this.f1706a;
        if (obj == null) {
            if (atomicBoolean.get()) {
                throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
            }
            linkedHashMap.remove(key);
        } else {
            if (!(obj instanceof Set)) {
                linkedHashMap.put(key, obj);
                return;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(kotlin.collections.a.R0((Iterable) obj));
            g.e(setUnmodifiableSet, "unmodifiableSet(value.toSet())");
            linkedHashMap.put(key, setUnmodifiableSet);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MutablePreferences)) {
            return false;
        }
        return g.b(this.f1706a, ((MutablePreferences) obj).f1706a);
    }

    public final int hashCode() {
        return this.f1706a.hashCode();
    }

    public final String toString() {
        return kotlin.collections.a.z0(this.f1706a.entrySet(), ",\n", "{\n", "\n}", new l<Map.Entry<a.C0083a<?>, Object>, CharSequence>() { // from class: androidx.datastore.preferences.core.MutablePreferences.toString.1
            @Override // zb.l
            public final CharSequence invoke(Map.Entry<a.C0083a<?>, Object> entry) {
                Map.Entry<a.C0083a<?>, Object> entry2 = entry;
                g.f(entry2, "entry");
                return "  " + entry2.getKey().f8947a + " = " + entry2.getValue();
            }
        }, 24);
    }

    public /* synthetic */ MutablePreferences(boolean z, int i10) {
        this(new LinkedHashMap(), (i10 & 2) != 0 ? true : z);
    }

    public MutablePreferences(LinkedHashMap linkedHashMap, boolean z) {
        this.f1706a = linkedHashMap;
        this.f1707b = new AtomicBoolean(z);
    }
}
