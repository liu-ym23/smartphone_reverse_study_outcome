package com.android.server.permission.access.immutable;

import android.util.ArraySet;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IndexedSet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableIndexedSet<T> extends IndexedSet<T> {
    /* JADX WARN: Multi-variable type inference failed */
    public MutableIndexedSet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MutableIndexedSet(ArraySet<T> r2) {
        super(r2, null);
    }

    public /* synthetic */ MutableIndexedSet(ArraySet r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ArraySet();
    L5:
        this(r1);
    }

    public MutableIndexedSet(IndexedSet<T> r3) {
        this(new ArraySet(r3.getSet$frameworks__base__services__permission__android_common__services_permission_pre_jarjar()));
    }

    public final boolean add(T r2) {
        return getSet$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().add(r2);
    }
}
