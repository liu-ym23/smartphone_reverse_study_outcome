package com.bytedance.android.ec.hybrid.card.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f46493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f46494d;

    public final int hashCode() {
        return this.f46492b.hashCode();
    }

    public final String toString() {
        return "sceneId = " + this.f46491a + ", containerId = " + this.f46492b + ", timestamp = " + this.f46493c;
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f46491a, r101.f46491a) == true) goto L11;
    L18:
        return false;
    L11:
        if (Intrinsics.areEqual(this.f46492b, r101.f46492b) == false) goto L18;
        if (this.f46492b.length() <= 0) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L18;
        return true;
    L15:
        r102 = false;
        goto L16
    }

    public f(String r100, String r101, long r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, "sceneID");
        Intrinsics.checkNotNullParameter(r101, "containerID");
        this.f46491a = r100;
        this.f46492b = r101;
        this.f46493c = r102;
        this.f46494d = r103;
    }
}
