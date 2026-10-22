package com.bytedance.applet.debugger;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f191755b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f191754a, r101.f191754a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f191755b, r101.f191755b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f191754a.hashCode() * 31) + this.f191755b.hashCode();
    }

    public final String toString() {
        return "AppletDebuggerSaveTokenItem(logId=" + this.f191754a + ", token=" + this.f191755b + ')';
    }

    public q(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "logId");
        Intrinsics.checkNotNullParameter(r101, "token");
        this.f191754a = r100;
        this.f191755b = r101;
    }
}
