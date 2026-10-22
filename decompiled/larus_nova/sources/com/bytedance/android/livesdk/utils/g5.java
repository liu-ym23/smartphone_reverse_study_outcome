package com.bytedance.android.livesdk.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f158962a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g5) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f158962a, ((g5) r100).f158962a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f158962a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PageOptContainer(pageOpt=" + this.f158962a + ")";
    }

    public g5(String r100) {
        this.f158962a = r100;
    }
}
