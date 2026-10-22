package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.livesdk.link.model.g6;
import com.bytedance.android.livesdk.link.model.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f95040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g6 f95041b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f95040a, r101.f95040a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f95041b, r101.f95041b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        p r100 = this.f95040a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        g6 r104 = this.f95041b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorLeaveEvent(leaveAnchor=" + this.f95040a + ", content=" + this.f95041b + ")";
    }

    public a(p r100, g6 r101) {
        Intrinsics.checkNotNullParameter(r100, "leaveAnchor");
        this.f95040a = r100;
        this.f95041b = r101;
    }
}
