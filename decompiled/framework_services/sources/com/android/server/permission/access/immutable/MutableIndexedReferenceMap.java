package com.android.server.permission.access.immutable;

import android.util.ArrayMap;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IndexedReferenceMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableIndexedReferenceMap<K, I extends Immutable<M>, M extends I> extends IndexedReferenceMap<K, I, M> {
    /* JADX WARN: Multi-variable type inference failed */
    public MutableIndexedReferenceMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ MutableIndexedReferenceMap(ArrayMap r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ArrayMap();
    L5:
        this(r1);
    }

    public MutableIndexedReferenceMap(ArrayMap<K, MutableReference<I, M>> r2) {
        super(r2, null);
    }

    public MutableIndexedReferenceMap(IndexedReferenceMap<K, I, M> r7) {
        ArrayMap $this$_init__u24lambda_u240 = new ArrayMap(r7.getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar());
        int i = 0;
        int r4 = $this$_init__u24lambda_u240.size();
    L3:
        if (i >= r4) goto L5;
        $this$_init__u24lambda_u240.setValueAt(i, ((MutableReference) $this$_init__u24lambda_u240.valueAt(i)).toImmutable());
        i = i + 1;
        goto L3
    L5:
        this($this$_init__u24lambda_u240);
    }

    /* JADX WARN: Incorrect return type in method signature: (TK;)TM; */
    public final Immutable mutate(Object key) {
        MutableReference<I, M> r0 = getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().get(key);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mutate();
    }

    /* JADX WARN: Incorrect types in method signature: (TK;TM;)TI; */
    /* JADX WARN: Multi-variable type inference failed */
    public final Immutable put(Object r3, Immutable value) {
        MutableReference<I, M> r0 = getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().put(r3, new MutableReference(value));
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public final I remove(K r2) {
        MutableReference<I, M> r0 = getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().remove(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (I) r0.get();
    }

    public final I removeAt(int r2) {
        return (I) getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().removeAt(r2).get();
    }
}
