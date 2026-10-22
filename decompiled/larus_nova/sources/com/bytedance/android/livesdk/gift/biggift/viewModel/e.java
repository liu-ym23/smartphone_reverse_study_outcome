package com.bytedance.android.livesdk.gift.biggift.viewModel;

import com.bytedance.android.livesdk.gift.model.q3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q3 f126002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f126003b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f126002a, r101.f126002a) == true) goto L8;
        return false;
    L8:
        if (this.f126003b == r101.f126003b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        q3 r100 = this.f126002a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f126003b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "SubscribeGiftSendInfo(info=" + this.f126002a + ", leftCount=" + this.f126003b + ")";
    }

    public e(q3 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.f126002a = r100;
        this.f126003b = r101;
    }
}
