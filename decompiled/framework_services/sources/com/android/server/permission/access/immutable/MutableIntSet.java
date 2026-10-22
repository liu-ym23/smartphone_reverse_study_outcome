package com.android.server.permission.access.immutable;

import android.util.SparseBooleanArray;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntSet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableIntSet extends IntSet {
    /* JADX WARN: Multi-variable type inference failed */
    public MutableIntSet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MutableIntSet(SparseBooleanArray array) {
        super(array, null);
    }

    public /* synthetic */ MutableIntSet(SparseBooleanArray r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new SparseBooleanArray();
    L5:
        this(r1);
    }

    public MutableIntSet(IntSet intSet) {
        this(intSet.getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().clone());
    }

    public final void clear() {
        getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().clear();
    }
}
