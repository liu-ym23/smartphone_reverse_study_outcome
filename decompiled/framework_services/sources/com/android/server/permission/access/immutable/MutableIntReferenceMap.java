package com.android.server.permission.access.immutable;

import android.util.SparseArray;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntReferenceMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableIntReferenceMap<I extends Immutable<M>, M extends I> extends IntReferenceMap<I, M> {
    /* JADX WARN: Multi-variable type inference failed */
    public MutableIntReferenceMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ MutableIntReferenceMap(SparseArray r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new SparseArray();
    L5:
        this(r1);
    }

    public MutableIntReferenceMap(SparseArray<MutableReference<I, M>> r2) {
        super(r2, null);
    }

    public MutableIntReferenceMap(IntReferenceMap<I, M> r7) {
        SparseArray<MutableReference<I, M>> r0 = r7.getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().clone();
        int i = 0;
        int r4 = r0.size();
    L3:
        if (i >= r4) goto L5;
        r0.setValueAt(i, r0.valueAt(i).toImmutable());
        i = i + 1;
        goto L3
    L5:
        this(r0);
    }

    /* JADX WARN: Incorrect return type in method signature: (I)TM; */
    public final Immutable mutate(int key) {
        MutableReference<I, M> r0 = getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().get(key);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mutate();
    }

    /* JADX WARN: Incorrect types in method signature: (ITM;)TI; */
    public final Immutable put(int key, Immutable value) {
        MutableReference r0 = (MutableReference) IntMapKt.putReturnOld(getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(), key, new MutableReference(value));
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    /* JADX WARN: Incorrect return type in method signature: (I)TM; */
    public final Immutable mutateAt(int index) {
        return getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().valueAt(index).mutate();
    }

    public final I removeAt(int r5) {
        Object r0 = IntMapKt.removeAtReturnOld(getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(), r5);
        MutableReference r1 = (MutableReference) r0;
        IntMapKt.gc(getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar());
        return (I) ((MutableReference) r0).get();
    }
}
