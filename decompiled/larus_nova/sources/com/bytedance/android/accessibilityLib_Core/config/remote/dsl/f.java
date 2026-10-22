package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g> f38190b;

    public f() {
        this("", null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f38189a, r101.f38189a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f38190b, r101.f38190b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f38189a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<g> r104 = this.f38190b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RemoteActivityConfigDsl(activityId=" + this.f38189a + ", data=" + this.f38190b + ')';
    }

    public f(String r100, List<g> r101) {
        this.f38189a = r100;
        this.f38190b = r101;
    }
}
