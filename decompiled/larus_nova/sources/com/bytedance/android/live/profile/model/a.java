package com.bytedance.android.live.profile.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnterExitStateType f86063a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f86063a, ((a) r100).f86063a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        EnterExitStateType r100 = this.f86063a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "EnterExitState(stateType=" + this.f86063a + ")";
    }

    public a(EnterExitStateType r100) {
        Intrinsics.checkNotNullParameter(r100, "stateType");
        this.f86063a = r100;
    }
}
