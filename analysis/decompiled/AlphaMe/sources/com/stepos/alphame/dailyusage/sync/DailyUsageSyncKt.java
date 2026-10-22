package com.stepos.alphame.dailyusage.sync;

import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import s0.C0847e;
import s0.u;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0001\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"", "DAILY_USAGE_SYNC", "Ljava/lang/String;", "Ls0/e;", "getSyncConstraints", "()Ls0/e;", "SyncConstraints", "dailyusage_release"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class DailyUsageSyncKt {

    @NotNull
    public static final String DAILY_USAGE_SYNC = "DailyUsageSync";

    @NotNull
    public static final C0847e getSyncConstraints() {
        C0847e c0847e = new C0847e(u.f14214a, false, false, true, false, -1L, -1L, CollectionsKt.toSet(new LinkedHashSet()));
        Intrinsics.checkNotNullExpressionValue(c0847e, "build(...)");
        return c0847e;
    }
}
