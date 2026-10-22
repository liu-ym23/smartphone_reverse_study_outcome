package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrayActionType f130068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f130069b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f130068a, r101.f130068a) == true) goto L8;
        return false;
    L8:
        if (this.f130069b == r101.f130069b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        TrayActionType r100 = this.f130068a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f130069b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "TrayAction(actionType=" + this.f130068a + ", duration=" + this.f130069b + ")";
    }

    public o(TrayActionType r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        this.f130068a = r100;
        this.f130069b = r101;
    }
}
