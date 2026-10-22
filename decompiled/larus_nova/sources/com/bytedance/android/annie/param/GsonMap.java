package com.bytedance.android.annie.param;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes43.dex */
public class GsonMap implements Map<String, Object>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonObject f39682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f39683b;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(String r100, BiFunction<? super String, ? super Object, ? extends Object> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(String r100, Function<? super String, ? extends Object> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(String r100, BiFunction<? super String, ? super Object, ? extends Object> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(String r100, Object r101, BiFunction<? super Object, ? super Object, ? extends Object> r102) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(String r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(String r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean remove(Object r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(String r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String r100, Object r101, Object r102) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Set<Map.Entry<String, Object>> b() {
        return (Set) this.f39683b.getValue();
    }

    public Collection<Object> c() {
        Set<Map.Entry<String, JsonElement>> r100 = this.f39682a.entrySet();
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(UtilsKt.c((JsonElement) ((Map.Entry) r102.next()).getValue()));
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (this.f39682a.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f39682a.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f39682a.size();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return b();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Object> values() {
        return c();
    }

    public GsonMap(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f39682a = r100;
        this.f39683b = LazyKt.lazy(new GsonMap$entries$2(this));
    }

    public Object a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        JsonElement r101 = this.f39682a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return UtilsKt.c(r101);
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f39682a.keySet().contains(r101);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        Set<Map.Entry<String, JsonElement>> r101 = this.f39682a.entrySet();
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((Map.Entry) r102.next()).getValue(), r100) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return a((String) r100);
    }
}
