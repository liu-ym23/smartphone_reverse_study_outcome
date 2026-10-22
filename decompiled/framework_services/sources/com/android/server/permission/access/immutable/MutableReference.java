package com.android.server.permission.access.immutable;

import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MutableReference.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableReference<I extends Immutable<M>, M extends I> {
    private I immutable;

    /* JADX INFO: Incorrect field signature: TM; */
    private Immutable mutable;

    /* JADX WARN: Incorrect types in method signature: (TI;TM;)V */
    /* JADX WARN: Multi-variable type inference failed */
    private MutableReference(Immutable r1, Immutable mutable) {
        this.immutable = r1;
        this.mutable = mutable;
    }

    /* JADX WARN: Incorrect types in method signature: (TM;)V */
    public MutableReference(Immutable mutable) {
        this(mutable, mutable);
    }

    public final I get() {
        return this.immutable;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TM; */
    public final Immutable mutate() {
        Immutable it = this.mutable;
        if (it != null) goto L5;
        Object r0 = this.immutable.toMutable();
        I r1 = (I) r0;
        this.immutable = r1;
        this.mutable = r1;
        return (Immutable) r0;
    L5:
        return it;
    }

    public final MutableReference<I, M> toImmutable() {
        return new MutableReference(this.immutable, null);
    }

    public boolean equals(Object other) {
        if (this != other) goto L5;
        return true;
    L5:
        Class<?> r0 = getClass();
        if (other == null) goto L8;
        Class<?> r1 = other.getClass();
    L10:
        if (Intrinsics.areEqual(r0, r1) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.android.server.permission.access.immutable.MutableReference<*, *>");
        MutableReference r2 = (MutableReference) other;
        return Intrinsics.areEqual(this.immutable, ((MutableReference) other).immutable);
    L8:
        r1 = null;
        goto L10
    }

    public int hashCode() {
        return this.immutable.hashCode();
    }
}
