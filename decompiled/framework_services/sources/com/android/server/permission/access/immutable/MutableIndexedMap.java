package com.android.server.permission.access.immutable;

import android.util.ArrayMap;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IndexedMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableIndexedMap<K, V> extends IndexedMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public MutableIndexedMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MutableIndexedMap(ArrayMap<K, V> r2) {
        super(r2, null);
    }

    public /* synthetic */ MutableIndexedMap(ArrayMap r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ArrayMap();
    L5:
        this(r1);
    }

    public MutableIndexedMap(IndexedMap<K, V> r3) {
        this(new ArrayMap(r3.getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar()));
    }

    public final V put(K r2, V r3) {
        return getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().put(r2, r3);
    }

    public final V remove(K r2) {
        return getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().remove(r2);
    }

    public final V putAt(int index, V r3) {
        return getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().setValueAt(index, r3);
    }

    public final V removeAt(int index) {
        return getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().removeAt(index);
    }
}
