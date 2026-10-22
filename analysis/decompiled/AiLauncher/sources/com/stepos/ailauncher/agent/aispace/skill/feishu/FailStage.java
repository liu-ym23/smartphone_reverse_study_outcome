package com.stepos.ailauncher.agent.aispace.skill.feishu;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;", "", "<init>", "(Ljava/lang/String;I)V", "Install", "CreateBot", "Authorize", "Review", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FailStage {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FailStage[] $VALUES;
    public static final FailStage Install = new FailStage("Install", 0);
    public static final FailStage CreateBot = new FailStage("CreateBot", 1);
    public static final FailStage Authorize = new FailStage("Authorize", 2);
    public static final FailStage Review = new FailStage("Review", 3);

    private static final /* synthetic */ FailStage[] $values() {
        return new FailStage[]{Install, CreateBot, Authorize, Review};
    }

    static {
        FailStage[] failStageArr$values = $values();
        $VALUES = failStageArr$values;
        $ENTRIES = kotlin.enums.a.a(failStageArr$values);
    }

    private FailStage(String str, int i10) {
    }

    public static InterfaceC4149a<FailStage> getEntries() {
        return $ENTRIES;
    }

    public static FailStage valueOf(String str) {
        return (FailStage) Enum.valueOf(FailStage.class, str);
    }

    public static FailStage[] values() {
        return (FailStage[]) $VALUES.clone();
    }
}
