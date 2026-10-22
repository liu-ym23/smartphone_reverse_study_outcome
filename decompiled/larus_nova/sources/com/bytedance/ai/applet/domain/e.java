package com.bytedance.ai.applet.domain;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f34611c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f34612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34613b;

    public static final class a {
        public static e a() {
            return new e(true, "");
        }

        public static e b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            return new e(false, r100);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f34612a == r101.f34612a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34613b, r101.f34613b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f34612a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f34613b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "DomainPolicyCheckResult(allowed=" + this.f34612a + ", reason=" + this.f34613b + ')';
    }

    public e(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f34612a = r100;
        this.f34613b = r101;
    }
}
