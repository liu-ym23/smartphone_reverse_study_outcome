package com.obric.aiagent.assistant.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ObricAppStatusConst.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NoInstalled", "AppDisabled", "Enabled", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AppEnableStatus extends Enum<AppEnableStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AppEnableStatus[] $VALUES = null;
    public static final AppEnableStatus AppDisabled = null;
    public static final AppEnableStatus Enabled = null;
    public static final AppEnableStatus NoInstalled = null;

    private static final /* synthetic */ AppEnableStatus[] $values() {
        return new AppEnableStatus[]{NoInstalled, AppDisabled, Enabled};
    }

    public static EnumEntries<AppEnableStatus> getEntries() {
        return $ENTRIES;
    }

    private AppEnableStatus(String r1, int r2) {
        super(r1, r2);
    }

    static {
        NoInstalled = new AppEnableStatus("NoInstalled", 0);
        AppDisabled = new AppEnableStatus("AppDisabled", 1);
        Enabled = new AppEnableStatus("Enabled", 2);
        AppEnableStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static AppEnableStatus valueOf(String r1) {
        return (AppEnableStatus) Enum.valueOf(AppEnableStatus.class, r1);
    }

    public static AppEnableStatus[] values() {
        return (AppEnableStatus[]) $VALUES.clone();
    }
}
