package com.stepos.ailauncher.taskstore.livenotification;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;", "", "<init>", "(Ljava/lang/String;I)V", "SMALL", "MEDIUM", "LARGE", "PERMISSION", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LiveCardLevel {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LiveCardLevel[] $VALUES;
    public static final LiveCardLevel SMALL = new LiveCardLevel("SMALL", 0);
    public static final LiveCardLevel MEDIUM = new LiveCardLevel("MEDIUM", 1);
    public static final LiveCardLevel LARGE = new LiveCardLevel("LARGE", 2);
    public static final LiveCardLevel PERMISSION = new LiveCardLevel("PERMISSION", 3);

    private static final /* synthetic */ LiveCardLevel[] $values() {
        return new LiveCardLevel[]{SMALL, MEDIUM, LARGE, PERMISSION};
    }

    static {
        LiveCardLevel[] liveCardLevelArr$values = $values();
        $VALUES = liveCardLevelArr$values;
        $ENTRIES = kotlin.enums.a.a(liveCardLevelArr$values);
    }

    private LiveCardLevel(String str, int i10) {
    }

    public static InterfaceC4149a<LiveCardLevel> getEntries() {
        return $ENTRIES;
    }

    public static LiveCardLevel valueOf(String str) {
        return (LiveCardLevel) Enum.valueOf(LiveCardLevel.class, str);
    }

    public static LiveCardLevel[] values() {
        return (LiveCardLevel[]) $VALUES.clone();
    }
}
