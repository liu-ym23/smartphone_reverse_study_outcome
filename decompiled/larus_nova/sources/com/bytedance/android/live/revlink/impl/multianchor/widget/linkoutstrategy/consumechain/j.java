package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import com.bytedance.android.livesdk.link.model.i6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i6 f95218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.g f95219b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f95218a, r101.f95218a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f95219b, r101.f95219b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        i6 r100 = this.f95218a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.live.revlink.impl.multianchor.utils.g r104 = this.f95219b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplyEvent(linkerMessage=" + this.f95218a + ", connectProcess=" + this.f95219b + ")";
    }

    public j(i6 r100, com.bytedance.android.live.revlink.impl.multianchor.utils.g r101) {
        Intrinsics.checkNotNullParameter(r100, "linkerMessage");
        this.f95218a = r100;
        this.f95219b = r101;
    }
}
