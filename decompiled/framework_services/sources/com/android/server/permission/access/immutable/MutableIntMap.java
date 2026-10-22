package com.android.server.permission.access.immutable;

import android.util.SparseArray;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableIntMap<T> extends IntMap<T> {
    public MutableIntMap(SparseArray<T> r2) {
        super(r2, null);
    }

    public /* synthetic */ MutableIntMap(SparseArray r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new SparseArray();
    L5:
        this(r1);
    }

    public MutableIntMap(IntMap<T> r2) {
        this(r2.getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().clone());
    }

    public final T put(int r2, T r3) {
        return (T) IntMapKt.putReturnOld(getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(), r2, r3);
    }

    public final T remove(int r5) {
        T r0 = (T) getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().removeReturnOld(r5);
        IntMapKt.gc(getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar());
        return r0;
    }

    public final void clear() {
        getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().clear();
    }
}
