package com.android.server.permission.access.immutable;

import com.android.server.permission.jarjar.kotlin.Unit;

/* JADX INFO: compiled from: IntReferenceMapExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntReferenceMapExtensionsKt {
    public static final <I extends Immutable<M>, M extends I> void minusAssign(MutableIntReferenceMap<I, M> r3, int key) {
        r3.getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().remove(key);
        Unit r0 = Unit.INSTANCE;
        IntMapKt.gc(r3.getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar());
    }

    /* JADX WARN: Incorrect types in method signature: <I::Lcom/android/server/permission/access/immutable/Immutable<TM;>;M::TI;>(Lcom/android/server/permission/access/immutable/MutableIntReferenceMap<TI;TM;>;ITM;)V */
    public static final void set(MutableIntReferenceMap $this$set, int key, Immutable value) {
        $this$set.getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().put(key, new MutableReference(value));
    }
}
