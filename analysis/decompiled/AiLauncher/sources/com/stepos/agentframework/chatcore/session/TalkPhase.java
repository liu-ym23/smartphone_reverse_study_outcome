package com.stepos.agentframework.chatcore.session;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/TalkPhase;", "", "<init>", "(Ljava/lang/String;I)V", "SENDING", "THINKING", "COT_THINKING", "REPLYING", "FINISHED", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TalkPhase {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TalkPhase[] $VALUES;
    public static final TalkPhase SENDING = new TalkPhase("SENDING", 0);
    public static final TalkPhase THINKING = new TalkPhase("THINKING", 1);
    public static final TalkPhase COT_THINKING = new TalkPhase("COT_THINKING", 2);
    public static final TalkPhase REPLYING = new TalkPhase("REPLYING", 3);
    public static final TalkPhase FINISHED = new TalkPhase("FINISHED", 4);

    private static final /* synthetic */ TalkPhase[] $values() {
        return new TalkPhase[]{SENDING, THINKING, COT_THINKING, REPLYING, FINISHED};
    }

    static {
        TalkPhase[] talkPhaseArr$values = $values();
        $VALUES = talkPhaseArr$values;
        $ENTRIES = kotlin.enums.a.a(talkPhaseArr$values);
    }

    private TalkPhase(String str, int i10) {
    }

    public static InterfaceC4149a<TalkPhase> getEntries() {
        return $ENTRIES;
    }

    public static TalkPhase valueOf(String str) {
        return (TalkPhase) Enum.valueOf(TalkPhase.class, str);
    }

    public static TalkPhase[] values() {
        return (TalkPhase[]) $VALUES.clone();
    }
}
