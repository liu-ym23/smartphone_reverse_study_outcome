package com.stepos.agentframework.adapter.netcore;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "PLANNING", "PENDING", "RUNNING", "PAUSED", "WAITING", "IN_PROGRESS", "COMPLETED", "FAILED", "CANCELLED", "SKIPPED", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BusTaskStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ BusTaskStatus[] $VALUES;
    public static final BusTaskStatus CREATED = new BusTaskStatus("CREATED", 0);
    public static final BusTaskStatus PLANNING = new BusTaskStatus("PLANNING", 1);
    public static final BusTaskStatus PENDING = new BusTaskStatus("PENDING", 2);
    public static final BusTaskStatus RUNNING = new BusTaskStatus("RUNNING", 3);
    public static final BusTaskStatus PAUSED = new BusTaskStatus("PAUSED", 4);
    public static final BusTaskStatus WAITING = new BusTaskStatus("WAITING", 5);
    public static final BusTaskStatus IN_PROGRESS = new BusTaskStatus("IN_PROGRESS", 6);
    public static final BusTaskStatus COMPLETED = new BusTaskStatus("COMPLETED", 7);
    public static final BusTaskStatus FAILED = new BusTaskStatus("FAILED", 8);
    public static final BusTaskStatus CANCELLED = new BusTaskStatus("CANCELLED", 9);
    public static final BusTaskStatus SKIPPED = new BusTaskStatus("SKIPPED", 10);

    private static final /* synthetic */ BusTaskStatus[] $values() {
        return new BusTaskStatus[]{CREATED, PLANNING, PENDING, RUNNING, PAUSED, WAITING, IN_PROGRESS, COMPLETED, FAILED, CANCELLED, SKIPPED};
    }

    static {
        BusTaskStatus[] busTaskStatusArr$values = $values();
        $VALUES = busTaskStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(busTaskStatusArr$values);
    }

    private BusTaskStatus(String str, int i10) {
    }

    public static InterfaceC4149a<BusTaskStatus> getEntries() {
        return $ENTRIES;
    }

    public static BusTaskStatus valueOf(String str) {
        return (BusTaskStatus) Enum.valueOf(BusTaskStatus.class, str);
    }

    public static BusTaskStatus[] values() {
        return (BusTaskStatus[]) $VALUES.clone();
    }
}
