package com.bytedance.android.gamecp.common.utils;

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

/* JADX INFO: loaded from: classes44.dex */
public final class GsonMap implements Map<String, Object>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f57168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f57169b;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object compute(String r100, BiFunction<? super String, ? super Object, ? extends Object> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object computeIfAbsent(String r100, Function<? super String, ? extends Object> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object computeIfPresent(String r100, BiFunction<? super String, ? super Object, ? extends Object> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object merge(String r100, Object r101, BiFunction<? super Object, ? super Object, ? extends Object> r102) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object put(String r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object putIfAbsent(String r100, Object r101) {
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
    public final /* synthetic */ Object replace(String r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean replace(String r100, Object r101, Object r102) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, Object>> entrySet() {
        return (Set) this.f57168a.getValue();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (this.f57169b.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f57169b.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f57169b.size();
    }

    @Override // java.util.Map
    public final Collection<Object> values() {
        Set<Map.Entry<String, JsonElement>> r100 = this.f57169b.entrySet();
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(UtilsKt.b((JsonElement) ((Map.Entry) r102.next()).getValue()));
        goto L4
    L6:
        return r101;
    }

    public GsonMap(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f57169b = r100;
        this.f57168a = LazyKt.lazy(new GsonMap$entries$2(this));
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f57169b.keySet().contains(r101);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        Set<Map.Entry<String, JsonElement>> r101 = this.f57169b.entrySet();
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (Intrinsics.areEqual((JsonElement) ((Map.Entry) r102.next()).getValue(), r100) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return false;
    }

    @Override // java.util.Map
    public final Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        return null;
    L5:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        JsonElement r102 = this.f57169b.get(r101);
        if (r102 != null) goto L8;
        return null;
    L8:
        return UtilsKt.b(r102);
    }
}
