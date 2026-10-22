package com.bytedance.android.shopping.commentv3.uitree.root;

import com.bytedance.android.shopping.commentv3.data.interfaces.ToastData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.android.shopping.commentv3.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ToastData f172880a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f172880a, ((a) r100).f172880a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        ToastData r100 = this.f172880a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CommentRootState(toastData=" + this.f172880a + ")";
    }

    public a(ToastData r100) {
        this.f172880a = r100;
    }
}
