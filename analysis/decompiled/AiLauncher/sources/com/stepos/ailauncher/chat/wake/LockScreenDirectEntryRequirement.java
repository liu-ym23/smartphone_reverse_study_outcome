package com.stepos.ailauncher.chat.wake;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/LockScreenDirectEntryRequirement;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW", "LOGIN", "AGENT_SWITCH", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LockScreenDirectEntryRequirement {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LockScreenDirectEntryRequirement[] $VALUES;
    public static final LockScreenDirectEntryRequirement ALLOW = new LockScreenDirectEntryRequirement("ALLOW", 0);
    public static final LockScreenDirectEntryRequirement LOGIN = new LockScreenDirectEntryRequirement("LOGIN", 1);
    public static final LockScreenDirectEntryRequirement AGENT_SWITCH = new LockScreenDirectEntryRequirement("AGENT_SWITCH", 2);

    private static final /* synthetic */ LockScreenDirectEntryRequirement[] $values() {
        return new LockScreenDirectEntryRequirement[]{ALLOW, LOGIN, AGENT_SWITCH};
    }

    static {
        LockScreenDirectEntryRequirement[] lockScreenDirectEntryRequirementArr$values = $values();
        $VALUES = lockScreenDirectEntryRequirementArr$values;
        $ENTRIES = kotlin.enums.a.a(lockScreenDirectEntryRequirementArr$values);
    }

    private LockScreenDirectEntryRequirement(String str, int i10) {
    }

    public static InterfaceC4149a<LockScreenDirectEntryRequirement> getEntries() {
        return $ENTRIES;
    }

    public static LockScreenDirectEntryRequirement valueOf(String str) {
        return (LockScreenDirectEntryRequirement) Enum.valueOf(LockScreenDirectEntryRequirement.class, str);
    }

    public static LockScreenDirectEntryRequirement[] values() {
        return (LockScreenDirectEntryRequirement[]) $VALUES.clone();
    }
}
