package com.stepos.ailauncher.homegesture;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/homegesture/HomeGroupExitStartResult;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "ALREADY_ACTIVE", "NOT_ELIGIBLE", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeGroupExitStartResult {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ HomeGroupExitStartResult[] $VALUES;
    public static final HomeGroupExitStartResult STARTED = new HomeGroupExitStartResult("STARTED", 0);
    public static final HomeGroupExitStartResult ALREADY_ACTIVE = new HomeGroupExitStartResult("ALREADY_ACTIVE", 1);
    public static final HomeGroupExitStartResult NOT_ELIGIBLE = new HomeGroupExitStartResult("NOT_ELIGIBLE", 2);

    private static final /* synthetic */ HomeGroupExitStartResult[] $values() {
        return new HomeGroupExitStartResult[]{STARTED, ALREADY_ACTIVE, NOT_ELIGIBLE};
    }

    static {
        HomeGroupExitStartResult[] homeGroupExitStartResultArr$values = $values();
        $VALUES = homeGroupExitStartResultArr$values;
        $ENTRIES = kotlin.enums.a.a(homeGroupExitStartResultArr$values);
    }

    private HomeGroupExitStartResult(String str, int i10) {
    }

    public static InterfaceC4149a<HomeGroupExitStartResult> getEntries() {
        return $ENTRIES;
    }

    public static HomeGroupExitStartResult valueOf(String str) {
        return (HomeGroupExitStartResult) Enum.valueOf(HomeGroupExitStartResult.class, str);
    }

    public static HomeGroupExitStartResult[] values() {
        return (HomeGroupExitStartResult[]) $VALUES.clone();
    }
}
