package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatui/HeldCardFlushPolicy;", "", "<init>", "()V", "", "appUIName", "", "c", "(Ljava/lang/String;)Z", "LKa/j;", "Lcom/stepos/agentframework/chatui/P1;", "tools", Const.INTENT_KEY_APIKEY, "(LKa/j;)Z", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "status", "toolFinished", "allVisibleToolsFinished", "forceRelease", "Lcom/stepos/agentframework/chatui/HeldCardFlushPolicy$Decision;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/session/EReplyStatus;Ljava/lang/String;ZZZ)Lcom/stepos/agentframework/chatui/HeldCardFlushPolicy$Decision;", "Decision", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HeldCardFlushPolicy {
    public static final HeldCardFlushPolicy INSTANCE = new HeldCardFlushPolicy();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatui/HeldCardFlushPolicy$Decision;", "", "<init>", "(Ljava/lang/String;I)V", "FLUSH", "DROP", "HOLD", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Decision {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Decision[] $VALUES;
        public static final Decision FLUSH = new Decision("FLUSH", 0);
        public static final Decision DROP = new Decision("DROP", 1);
        public static final Decision HOLD = new Decision("HOLD", 2);

        private static final /* synthetic */ Decision[] $values() {
            return new Decision[]{FLUSH, DROP, HOLD};
        }

        static {
            Decision[] decisionArr$values = $values();
            $VALUES = decisionArr$values;
            $ENTRIES = kotlin.enums.a.a(decisionArr$values);
        }

        private Decision(String str, int i10) {
        }

        public static InterfaceC4149a<Decision> getEntries() {
            return $ENTRIES;
        }

        public static Decision valueOf(String str) {
            return (Decision) Enum.valueOf(Decision.class, str);
        }

        public static Decision[] values() {
            return (Decision[]) $VALUES.clone();
        }
    }

    public final boolean a(Ka.j<DisplayTool> tools) {
        kotlin.jvm.internal.p.i(tools, "tools");
        for (DisplayTool displayTool : tools) {
            if (!displayTool.getIsFinished() && !displayTool.k()) {
                return false;
            }
        }
        return true;
    }

    public final Decision b(EReplyStatus status, String appUIName, boolean toolFinished, boolean allVisibleToolsFinished, boolean forceRelease) {
        kotlin.jvm.internal.p.i(status, "status");
        return (status == EReplyStatus.CANCELED || status == EReplyStatus.ERROR) ? Decision.DROP : status == EReplyStatus.COMPLETED ? Decision.FLUSH : (c(appUIName) && toolFinished && (forceRelease || status == EReplyStatus.REPLYING || allVisibleToolsFinished)) ? Decision.FLUSH : Decision.HOLD;
    }

    public final boolean c(String appUIName) {
        return kotlin.jvm.internal.p.d(appUIName, "app_ui_name_task_result_file");
    }
}
