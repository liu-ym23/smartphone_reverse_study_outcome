package com.bytedance.android.gamecp.base.core.service.depend;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f51409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f51410b;

    public v() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L10;
        v r101 = (v) r100;
        if (this.f51409a == r101.f51409a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f51410b, r101.f51410b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f51409a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Map<String, String> r103 = this.f51410b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "InstalledFinishData(isOtherChannelInstalled=" + this.f51409a + ", eventMap=" + this.f51410b + ")";
    }

    public /* synthetic */ v(int r100) {
        this(false, null);
    }

    public v(boolean r100, Map<String, String> r101) {
        this.f51409a = r100;
        this.f51410b = r101;
    }
}
