package com.android.server.permission.access.immutable;

import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.ArrayList;

/* JADX INFO: compiled from: IndexedList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableIndexedList<T> extends IndexedList<T> {
    public MutableIndexedList(ArrayList<T> r2) {
        super(r2, null);
    }

    public /* synthetic */ MutableIndexedList(ArrayList r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ArrayList();
    L5:
        this(r1);
    }

    public MutableIndexedList(IndexedList<T> r3) {
        this(new ArrayList(r3.getList$frameworks__base__services__permission__android_common__services_permission_pre_jarjar()));
    }

    public final void add(T r2) {
        getList$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().add(r2);
    }
}
