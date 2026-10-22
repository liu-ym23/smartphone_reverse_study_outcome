package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist;

import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f54424a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f54424a, ((b) r100).f54424a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        k r100 = this.f54424a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ColListSelfProps(pageInfo=" + this.f54424a + ")";
    }

    public b(k r100) {
        this.f54424a = r100;
    }
}
