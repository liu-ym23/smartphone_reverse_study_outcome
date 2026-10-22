package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhase;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "RUNNING", "PASSIVE_PROMPT", "TAKEOVER_ACK", "MINI", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlayPhase {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ OverlayPhase[] $VALUES;
    public static final OverlayPhase RUNNING = new OverlayPhase("RUNNING", 0);
    public static final OverlayPhase PASSIVE_PROMPT = new OverlayPhase("PASSIVE_PROMPT", 1);
    public static final OverlayPhase TAKEOVER_ACK = new OverlayPhase("TAKEOVER_ACK", 2);
    public static final OverlayPhase MINI = new OverlayPhase("MINI", 3);

    private static final /* synthetic */ OverlayPhase[] $values() {
        return new OverlayPhase[]{RUNNING, PASSIVE_PROMPT, TAKEOVER_ACK, MINI};
    }

    static {
        OverlayPhase[] overlayPhaseArr$values = $values();
        $VALUES = overlayPhaseArr$values;
        $ENTRIES = kotlin.enums.a.a(overlayPhaseArr$values);
    }

    private OverlayPhase(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static OverlayPhase valueOf(String str) {
        return (OverlayPhase) Enum.valueOf(OverlayPhase.class, str);
    }

    public static OverlayPhase[] values() {
        return (OverlayPhase[]) $VALUES.clone();
    }
}
