package com.bytedance.android.sdk.bdticketguard;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<u> f164093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164094b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L10;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f164093a, r101.f164093a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f164094b, r101.f164094b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<u> r100 = this.f164093a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f164094b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KeyCreateLogs(entries=" + this.f164093a + ", createLogString=" + this.f164094b + ")";
    }

    public v(List<u> r100, String r101) {
        this.f164093a = r100;
        this.f164094b = r101;
    }
}
