package com.bytedance.android.livesdk.ktvimpl.base;

import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KtvConflictScene f142488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f142489b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f142488a, r101.f142488a) == true) goto L8;
        return false;
    L8:
        if (this.f142489b == r101.f142489b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        KtvConflictScene r100 = this.f142488a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f142489b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "KtvConflictTip(conflictScene=" + this.f142488a + ", conflictTipRes=" + this.f142489b + ")";
    }

    public f(KtvConflictScene r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "conflictScene");
        this.f142488a = r100;
        this.f142489b = r101;
    }
}
