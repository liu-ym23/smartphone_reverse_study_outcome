package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\nJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/task/space/MinusOneIncomingVoiceHold;", "", "<init>", "()V", "", "panelStillOpen", "voiceActive", "incomingCover", "Lcom/stepos/ailauncher/task/space/MinusOneIncomingVoiceHold$PauseAction;", Const.INTENT_KEY_APIKEY, "(ZZZ)Lcom/stepos/ailauncher/task/space/MinusOneIncomingVoiceHold$PauseAction;", "pageStillPaused", "c", Const.INTENT_KEY_PKGNAME, "()Z", "held", "Z", Z5.b.FALLBACK_STATE_WAITING, "PauseAction", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MinusOneIncomingVoiceHold {
    private boolean held;
    private boolean waiting;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/task/space/MinusOneIncomingVoiceHold$PauseAction;", "", "<init>", "(Ljava/lang/String;I)V", "STOP_NOW", "KEEP", "WAIT", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PauseAction {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PauseAction[] $VALUES;
        public static final PauseAction STOP_NOW = new PauseAction("STOP_NOW", 0);
        public static final PauseAction KEEP = new PauseAction("KEEP", 1);
        public static final PauseAction WAIT = new PauseAction("WAIT", 2);

        private static final /* synthetic */ PauseAction[] $values() {
            return new PauseAction[]{STOP_NOW, KEEP, WAIT};
        }

        static {
            PauseAction[] pauseActionArr$values = $values();
            $VALUES = pauseActionArr$values;
            $ENTRIES = kotlin.enums.a.a(pauseActionArr$values);
        }

        private PauseAction(String str, int i10) {
        }

        public static InterfaceC4149a<PauseAction> getEntries() {
            return $ENTRIES;
        }

        public static PauseAction valueOf(String str) {
            return (PauseAction) Enum.valueOf(PauseAction.class, str);
        }

        public static PauseAction[] values() {
            return (PauseAction[]) $VALUES.clone();
        }
    }

    public final PauseAction a(boolean panelStillOpen, boolean voiceActive, boolean incomingCover) {
        if (!panelStillOpen || !voiceActive) {
            this.held = false;
            this.waiting = false;
            return PauseAction.STOP_NOW;
        }
        if (!incomingCover) {
            this.waiting = true;
            return PauseAction.WAIT;
        }
        this.waiting = false;
        this.held = true;
        return PauseAction.KEEP;
    }

    public final boolean b() {
        this.waiting = false;
        boolean z10 = this.held;
        this.held = false;
        return z10;
    }

    public final PauseAction c(boolean pageStillPaused, boolean voiceActive, boolean incomingCover) {
        if (!this.waiting) {
            return PauseAction.KEEP;
        }
        this.waiting = false;
        if (!pageStillPaused) {
            return PauseAction.KEEP;
        }
        if (!incomingCover || !voiceActive) {
            return PauseAction.STOP_NOW;
        }
        this.held = true;
        return PauseAction.KEEP;
    }
}
