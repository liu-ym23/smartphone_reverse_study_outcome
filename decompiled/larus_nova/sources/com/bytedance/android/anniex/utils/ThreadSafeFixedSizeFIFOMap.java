package com.bytedance.android.anniex.utils;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010'\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\nJ\u001f\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0015\u001a\u00020\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0017H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/anniex/utils/ThreadSafeFixedSizeFIFOMap;", "K", "V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "maxSize", "", "loadFactor", "", "accessOrder", "", "(IFZ)V", MonitorConstants.CONNECT_TYPE_GET, "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "getMaxSize", "isFull", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "removeEldestEntry", "eldest", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ThreadSafeFixedSizeFIFOMap<K, V> extends LinkedHashMap<K, V> {
    private final boolean accessOrder;
    private final float loadFactor;
    private final int maxSize;

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return (Set<Map.Entry<K, V>>) getEntries();
    }

    public /* bridge */ Set<Map.Entry<Object, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<Object> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    public final boolean isFull() {
        if (size() != this.maxSize) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) getValues();
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public synchronized V get(Object r100) {
        monitor-enter(this);
        V r101 = (V) super.get(r100);
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public synchronized V remove(Object r100) {
        monitor-enter(this);
        V r101 = (V) super.remove(r100);
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedHashMap
    public synchronized boolean removeEldestEntry(Map.Entry<K, V> r100) {
        monitor-enter(this);
        if (size() <= this.maxSize) goto L6;
        boolean r101 = true;
    L7:
        monitor-exit(this);
        return r101;
    L6:
        r101 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public synchronized V put(K r100, V r101) {
        monitor-enter(this);
        V r102 = (V) super.put(r100, r101);
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public ThreadSafeFixedSizeFIFOMap(int r100, float r101, boolean r102) {
        super(r100, r101, r102);
        this.maxSize = r100;
        this.loadFactor = r101;
        this.accessOrder = r102;
    }

    public /* synthetic */ ThreadSafeFixedSizeFIFOMap(int r100, float r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = 0.75f;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        this(r100, r101, r102);
    }
}
