package com.android.contacts.calllog.v2;

import kotlin.Metadata;

/* JADX INFO: compiled from: CallLogUiState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogTab;", "", "(Ljava/lang/String;I)V", "ALL", "MISSED", "SIM1", "SIM2", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum CallLogTab extends Enum<CallLogTab> {
    private static final /* synthetic */ CallLogTab[] $VALUES = null;
    public static final CallLogTab ALL = null;
    public static final CallLogTab MISSED = null;
    public static final CallLogTab SIM1 = null;
    public static final CallLogTab SIM2 = null;

    private static final /* synthetic */ CallLogTab[] $values() {
        return new CallLogTab[]{ALL, MISSED, SIM1, SIM2};
    }

    public static CallLogTab valueOf(String r1) {
        return (CallLogTab) Enum.valueOf(CallLogTab.class, r1);
    }

    public static CallLogTab[] values() {
        return (CallLogTab[]) $VALUES.clone();
    }

    private CallLogTab(String r1, int r2) {
        super(r1, r2);
    }

    static {
        ALL = new CallLogTab("ALL", 0);
        MISSED = new CallLogTab("MISSED", 1);
        SIM1 = new CallLogTab("SIM1", 2);
        SIM2 = new CallLogTab("SIM2", 3);
        $VALUES = $values();
    }
}
