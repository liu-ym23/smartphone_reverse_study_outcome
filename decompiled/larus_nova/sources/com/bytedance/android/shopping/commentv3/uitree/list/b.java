package com.bytedance.android.shopping.commentv3.uitree.list;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements com.bytedance.android.shopping.commentv3.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lc3.b f172830a;

    public final int hashCode() {
        lc3.b r100 = this.f172830a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CommentListState(componentModel=" + this.f172830a + ")";
    }

    public b(lc3.b r100) {
        Intrinsics.checkNotNullParameter(r100, "componentModel");
        this.f172830a = r100;
    }

    public final boolean equals(Object r100) {
        return super.equals(r100);
    }
}
