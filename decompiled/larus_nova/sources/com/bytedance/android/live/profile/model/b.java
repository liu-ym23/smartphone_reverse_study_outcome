package com.bytedance.android.live.profile.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleStateType f86064a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f86064a, ((b) r100).f86064a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        LifecycleStateType r100 = this.f86064a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LifecycleState(stateType=" + this.f86064a + ")";
    }

    public b(LifecycleStateType r100) {
        Intrinsics.checkNotNullParameter(r100, "stateType");
        this.f86064a = r100;
    }
}
