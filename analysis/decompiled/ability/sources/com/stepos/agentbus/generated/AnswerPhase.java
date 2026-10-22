package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentbus/generated/AnswerPhase;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "ACCEPTED", "APPLIED", "REJECTED", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AnswerPhase {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ AnswerPhase[] $VALUES;
    public static final AnswerPhase ACCEPTED = new AnswerPhase("ACCEPTED", 0);
    public static final AnswerPhase APPLIED = new AnswerPhase("APPLIED", 1);
    public static final AnswerPhase REJECTED = new AnswerPhase("REJECTED", 2);

    private static final /* synthetic */ AnswerPhase[] $values() {
        return new AnswerPhase[]{ACCEPTED, APPLIED, REJECTED};
    }

    static {
        AnswerPhase[] answerPhaseArr$values = $values();
        $VALUES = answerPhaseArr$values;
        $ENTRIES = kotlin.enums.a.a(answerPhaseArr$values);
    }

    private AnswerPhase(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static AnswerPhase valueOf(String str) {
        return (AnswerPhase) Enum.valueOf(AnswerPhase.class, str);
    }

    public static AnswerPhase[] values() {
        return (AnswerPhase[]) $VALUES.clone();
    }
}
