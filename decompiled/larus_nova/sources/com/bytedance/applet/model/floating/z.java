package com.bytedance.applet.model.floating;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f192152b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f192151a, r101.f192151a) == true) goto L12;
        return false;
    L12:
        if (this.f192152b == r101.f192152b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f192151a.hashCode() * 31;
        if (this.f192152b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "FloatingSpeakerKeepScreenOnState(owner=" + this.f192151a + ", usesGuard=" + this.f192152b + ')';
    }

    public z(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f192151a = r100;
        this.f192152b = r101;
    }
}
