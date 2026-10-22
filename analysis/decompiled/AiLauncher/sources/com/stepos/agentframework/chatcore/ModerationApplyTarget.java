package com.stepos.agentframework.chatcore;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/ModerationApplyTarget;", "", "<init>", "(Ljava/lang/String;I)V", "FOREGROUND", "BACKGROUND", "MISSING_SESSION", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ModerationApplyTarget {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ModerationApplyTarget[] $VALUES;
    public static final ModerationApplyTarget FOREGROUND = new ModerationApplyTarget("FOREGROUND", 0);
    public static final ModerationApplyTarget BACKGROUND = new ModerationApplyTarget("BACKGROUND", 1);
    public static final ModerationApplyTarget MISSING_SESSION = new ModerationApplyTarget("MISSING_SESSION", 2);

    private static final /* synthetic */ ModerationApplyTarget[] $values() {
        return new ModerationApplyTarget[]{FOREGROUND, BACKGROUND, MISSING_SESSION};
    }

    static {
        ModerationApplyTarget[] moderationApplyTargetArr$values = $values();
        $VALUES = moderationApplyTargetArr$values;
        $ENTRIES = kotlin.enums.a.a(moderationApplyTargetArr$values);
    }

    private ModerationApplyTarget(String str, int i10) {
    }

    public static InterfaceC4149a<ModerationApplyTarget> getEntries() {
        return $ENTRIES;
    }

    public static ModerationApplyTarget valueOf(String str) {
        return (ModerationApplyTarget) Enum.valueOf(ModerationApplyTarget.class, str);
    }

    public static ModerationApplyTarget[] values() {
        return (ModerationApplyTarget[]) $VALUES.clone();
    }
}
