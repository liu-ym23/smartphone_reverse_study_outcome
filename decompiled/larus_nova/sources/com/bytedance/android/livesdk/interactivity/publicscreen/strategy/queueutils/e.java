package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f139564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f139565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f139566c;

    public final m a(PSMessageHeatState r100) {
        Intrinsics.checkNotNullParameter(r100, "heatState");
        int r101 = d.f139563a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return this.f139566c;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return this.f139565b;
    L13:
        return this.f139564a;
    }

    public e(m r100, m r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "hotPollConfig");
        Intrinsics.checkNotNullParameter(r101, "normalPollConfig");
        Intrinsics.checkNotNullParameter(r102, "coldPollConfig");
        this.f139564a = r100;
        this.f139565b = r101;
        this.f139566c = r102;
    }
}
