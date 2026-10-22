package com.stepos.ailauncher.taskstore.livenotification;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/SessionLiveCategory;", "", "<init>", "(Ljava/lang/String;I)V", "TASK", "CHAT", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionLiveCategory {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SessionLiveCategory[] $VALUES;
    public static final SessionLiveCategory TASK = new SessionLiveCategory("TASK", 0);
    public static final SessionLiveCategory CHAT = new SessionLiveCategory("CHAT", 1);

    private static final /* synthetic */ SessionLiveCategory[] $values() {
        return new SessionLiveCategory[]{TASK, CHAT};
    }

    static {
        SessionLiveCategory[] sessionLiveCategoryArr$values = $values();
        $VALUES = sessionLiveCategoryArr$values;
        $ENTRIES = kotlin.enums.a.a(sessionLiveCategoryArr$values);
    }

    private SessionLiveCategory(String str, int i10) {
    }

    public static InterfaceC4149a<SessionLiveCategory> getEntries() {
        return $ENTRIES;
    }

    public static SessionLiveCategory valueOf(String str) {
        return (SessionLiveCategory) Enum.valueOf(SessionLiveCategory.class, str);
    }

    public static SessionLiveCategory[] values() {
        return (SessionLiveCategory[]) $VALUES.clone();
    }
}
