package com.bytedance.android.shopping.anchorv4.vm;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f167729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f167730b;

    public a() {
        this(false, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f167729a == r101.f167729a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167730b, r101.f167730b) == true) goto L16;
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
        boolean r100 = this.f167729a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.f167730b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "CollapseInfo(collapseDetail=" + this.f167729a + ", collapseIgnoreList=" + this.f167730b + ")";
    }

    public a(boolean r100, List<String> r101) {
        this.f167729a = r100;
        this.f167730b = r101;
    }
}
