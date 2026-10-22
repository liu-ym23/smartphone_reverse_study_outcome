package com.bytedance.ai.applet.domain;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f34614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f34615b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f34614a == r101.f34614a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34615b, r101.f34615b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f34614a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f34615b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "WebviewDomainPolicy(domainVerifySwitch=" + this.f34614a + ", domains=" + this.f34615b + ')';
    }

    public f(boolean r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "domains");
        this.f34614a = r100;
        this.f34615b = r101;
    }
}
