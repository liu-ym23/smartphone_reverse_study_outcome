package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f34262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34263b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f34262a, r101.f34262a) == true) goto L12;
        return false;
    L12:
        if (this.f34263b == r101.f34263b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f34262a.hashCode() * 31;
        long r101 = this.f34263b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "AppLaunchCompletion(entry=" + this.f34262a + ", duration=" + this.f34263b + ')';
    }

    public a(f.a r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        this.f34262a = r100;
        this.f34263b = r101;
    }
}
