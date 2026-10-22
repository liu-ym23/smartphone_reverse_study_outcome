package com.bytedance.android.live.core.tetris.layer.core.element;

import j70.e;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import k70.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002>\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00040\u0001j\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0004`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/ElementBuilderMap;", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lj70/e;", "Lk70/b;", "Lkotlin/collections/HashMap;", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ElementBuilderMap extends HashMap<Class<? extends e>, b<? extends e>> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<Class<? extends e>, b<? extends e>>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Class<? extends e>> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<b<? extends e>> values() {
        return getValues();
    }

    public ElementBuilderMap() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof Class) == true) goto L7;
        return false;
    L7:
        return containsKey((Class) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof b) == true) goto L7;
        return false;
    L7:
        return containsValue((b) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ b<? extends e> get(Object r100) {
        if ((r100 instanceof Class) == true) goto L7;
        return null;
    L7:
        return get((Class) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ b<? extends e> remove(Object r100) {
        if ((r100 instanceof Class) == true) goto L7;
        return null;
    L7:
        return remove((Class) r100);
    }

    public /* bridge */ boolean containsKey(Class r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(b r100) {
        return super.containsValue(r100);
    }

    public /* bridge */ b get(Class r100) {
        return (b) super.get(r100);
    }

    public /* bridge */ b remove(Class r100) {
        return (b) super.remove(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof Class) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((Class) r100, (b) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof Class) == true) goto L5;
        return false;
    L5:
        if ((r101 instanceof b) == true) goto L8;
        return false;
    L8:
        return remove((Class) r100, (b) r101);
    }

    public /* bridge */ b getOrDefault(Class r100, b r101) {
        return (b) super.getOrDefault(r100, r101);
    }

    public /* bridge */ boolean remove(Class r100, b r101) {
        return super.remove(r100, r101);
    }
}
