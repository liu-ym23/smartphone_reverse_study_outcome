package com.bytedance.android.livesdk.viewmodel;

import com.bytedance.android.live.base.model.feed.FeedItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<FeedItem> f159330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f159331b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f159330a, r101.f159330a) == true) goto L8;
        return false;
    L8:
        if (this.f159331b == r101.f159331b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        List<FeedItem> r100 = this.f159330a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f159331b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateData(items=" + this.f159330a + ", isChangeAll=" + this.f159331b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends FeedItem> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f159330a = r100;
        this.f159331b = r101;
    }
}
