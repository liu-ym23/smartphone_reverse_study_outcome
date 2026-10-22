package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f139587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f139588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f139589c;

    public m(List<Integer> r100) {
        this.f139587a = a(r100, 0);
        this.f139588b = a(r100, 1);
        this.f139589c = a(r100, 2);
    }

    public final int b(PSMessagePriority r100) {
        Intrinsics.checkNotNullParameter(r100, "priority");
        int r101 = l.f139586a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return this.f139588b;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return this.f139589c;
    L13:
        return this.f139587a;
    }

    public static int a(List r100, int r101) {
        if (r100 == null) goto L9;
        if (r101 >= 0) goto L5;
        return 1;
    L5:
        if (r101 < r100.size()) goto L8;
        return 1;
    L8:
        return ((Number) ListProtector.get(r100, r101)).intValue();
    L9:
        return 1;
    }
}
