package com.android.server.permission.access.immutable;

import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.ArrayList;

/* JADX INFO: compiled from: IndexedListSet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableIndexedListSet<T> extends IndexedListSet<T> {
    /* JADX WARN: Multi-variable type inference failed */
    public MutableIndexedListSet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MutableIndexedListSet(ArrayList<T> r2) {
        super(r2, null);
    }

    public /* synthetic */ MutableIndexedListSet(ArrayList r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ArrayList();
    L5:
        this(r1);
    }

    public MutableIndexedListSet(IndexedListSet<T> r3) {
        this(new ArrayList(r3.getList$frameworks__base__services__permission__android_common__services_permission_pre_jarjar()));
    }

    public final boolean add(T r2) {
        if (getList$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().contains(r2) == false) goto L5;
        return false;
    L5:
        getList$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().add(r2);
        return true;
    }

    public final boolean remove(T r2) {
        return getList$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().remove(r2);
    }
}
