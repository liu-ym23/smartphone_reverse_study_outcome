package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthorizationState;", "", "<init>", "(Ljava/lang/String;I)V", "AUTHORIZED", "NOT_AUTHORIZED", "INDETERMINATE", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DidiAuthorizationState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ DidiAuthorizationState[] $VALUES;
    public static final DidiAuthorizationState AUTHORIZED = new DidiAuthorizationState("AUTHORIZED", 0);
    public static final DidiAuthorizationState NOT_AUTHORIZED = new DidiAuthorizationState("NOT_AUTHORIZED", 1);
    public static final DidiAuthorizationState INDETERMINATE = new DidiAuthorizationState("INDETERMINATE", 2);

    private static final /* synthetic */ DidiAuthorizationState[] $values() {
        return new DidiAuthorizationState[]{AUTHORIZED, NOT_AUTHORIZED, INDETERMINATE};
    }

    static {
        DidiAuthorizationState[] didiAuthorizationStateArr$values = $values();
        $VALUES = didiAuthorizationStateArr$values;
        $ENTRIES = a.a(didiAuthorizationStateArr$values);
    }

    private DidiAuthorizationState(String str, int i10) {
    }

    public static InterfaceC4149a<DidiAuthorizationState> getEntries() {
        return $ENTRIES;
    }

    public static DidiAuthorizationState valueOf(String str) {
        return (DidiAuthorizationState) Enum.valueOf(DidiAuthorizationState.class, str);
    }

    public static DidiAuthorizationState[] values() {
        return (DidiAuthorizationState[]) $VALUES.clone();
    }
}
