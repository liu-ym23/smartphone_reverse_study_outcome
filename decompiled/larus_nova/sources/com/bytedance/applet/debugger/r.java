package com.bytedance.applet.debugger;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q> f191756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f191757b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f191756a, r101.f191756a) == true) goto L12;
        return false;
    L12:
        if (this.f191757b == r101.f191757b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f191756a.hashCode() * 31) + this.f191757b;
    }

    public final String toString() {
        return "AppletDebuggerSaveTokenRequest(batchData=" + this.f191756a + ", feedbackSource=" + this.f191757b + ')';
    }

    public r(List r100) {
        Intrinsics.checkNotNullParameter(r100, "batchData");
        this.f191756a = r100;
        this.f191757b = 2;
    }
}
