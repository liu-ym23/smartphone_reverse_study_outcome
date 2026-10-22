package com.stepos.ailauncher.chat.lockscreen;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/LockScreenGuard;", "", "<init>", "(Ljava/lang/String;I)V", "USER_PRESENT", "SCREEN_OFF", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LockScreenGuard {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LockScreenGuard[] $VALUES;
    public static final LockScreenGuard USER_PRESENT = new LockScreenGuard("USER_PRESENT", 0);
    public static final LockScreenGuard SCREEN_OFF = new LockScreenGuard("SCREEN_OFF", 1);

    private static final /* synthetic */ LockScreenGuard[] $values() {
        return new LockScreenGuard[]{USER_PRESENT, SCREEN_OFF};
    }

    static {
        LockScreenGuard[] lockScreenGuardArr$values = $values();
        $VALUES = lockScreenGuardArr$values;
        $ENTRIES = kotlin.enums.a.a(lockScreenGuardArr$values);
    }

    private LockScreenGuard(String str, int i10) {
    }

    public static InterfaceC4149a<LockScreenGuard> getEntries() {
        return $ENTRIES;
    }

    public static LockScreenGuard valueOf(String str) {
        return (LockScreenGuard) Enum.valueOf(LockScreenGuard.class, str);
    }

    public static LockScreenGuard[] values() {
        return (LockScreenGuard[]) $VALUES.clone();
    }
}
