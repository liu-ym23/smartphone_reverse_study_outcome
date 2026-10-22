package com.bytedance.android.shopping.api.video;

import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f170640a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f170640a, ((c) r100).f170640a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        FrameLayout r100 = this.f170640a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ECPlayerHost(container=" + this.f170640a + ")";
    }

    public c(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f170640a = r100;
    }
}
