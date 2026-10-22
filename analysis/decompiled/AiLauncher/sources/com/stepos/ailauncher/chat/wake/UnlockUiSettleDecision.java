package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/UnlockUiSettleDecision;", "", "<init>", "(Ljava/lang/String;I)V", "CONTINUE", "WAIT", AMapLocationStaticsEntity.FAIL_STATUS, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnlockUiSettleDecision {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ UnlockUiSettleDecision[] $VALUES;
    public static final UnlockUiSettleDecision CONTINUE = new UnlockUiSettleDecision("CONTINUE", 0);
    public static final UnlockUiSettleDecision WAIT = new UnlockUiSettleDecision("WAIT", 1);
    public static final UnlockUiSettleDecision FAIL = new UnlockUiSettleDecision(AMapLocationStaticsEntity.FAIL_STATUS, 2);

    private static final /* synthetic */ UnlockUiSettleDecision[] $values() {
        return new UnlockUiSettleDecision[]{CONTINUE, WAIT, FAIL};
    }

    static {
        UnlockUiSettleDecision[] unlockUiSettleDecisionArr$values = $values();
        $VALUES = unlockUiSettleDecisionArr$values;
        $ENTRIES = kotlin.enums.a.a(unlockUiSettleDecisionArr$values);
    }

    private UnlockUiSettleDecision(String str, int i10) {
    }

    public static InterfaceC4149a<UnlockUiSettleDecision> getEntries() {
        return $ENTRIES;
    }

    public static UnlockUiSettleDecision valueOf(String str) {
        return (UnlockUiSettleDecision) Enum.valueOf(UnlockUiSettleDecision.class, str);
    }

    public static UnlockUiSettleDecision[] values() {
        return (UnlockUiSettleDecision[]) $VALUES.clone();
    }
}
