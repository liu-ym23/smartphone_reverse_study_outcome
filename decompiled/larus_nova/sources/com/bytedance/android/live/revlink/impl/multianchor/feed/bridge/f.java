package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import com.bytedance.android.livesdk.link.model.f4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f94162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f4 f94163b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (this.f94162a == r101.f94162a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f94163b, r101.f94163b) == true) goto L16;
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
        boolean r100 = this.f94162a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        f4 r103 = this.f94163b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "IRealEffectInfo(isSelf=" + this.f94162a + ", effectInfo=" + this.f94163b + ")";
    }

    public f(boolean r100, f4 r101) {
        Intrinsics.checkNotNullParameter(r101, "effectInfo");
        this.f94162a = r100;
        this.f94163b = r101;
    }
}
