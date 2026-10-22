package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0012\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/task/space/HomeInputPresentationState;", "", "<init>", "()V", "", "covered", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Z)V", Const.INTENT_KEY_APIKEY, "wakeDialogShowing", "artifactsActive", "Lcom/stepos/ailauncher/task/space/HomeInputPresentationState$a;", "c", "(ZZ)Lcom/stepos/ailauncher/task/space/HomeInputPresentationState$a;", "Lcom/stepos/ailauncher/task/space/HomeInputPresentationState$State;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/task/space/HomeInputPresentationState$State;", "State", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeInputPresentationState {
    private State state = State.READY;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/task/space/HomeInputPresentationState$State;", "", "<init>", "(Ljava/lang/String;I)V", "READY", "COVERED", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State READY = new State("READY", 0);
        public static final State COVERED = new State("COVERED", 1);

        private static final /* synthetic */ State[] $values() {
            return new State[]{READY, COVERED};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i10) {
        }

        public static InterfaceC4149a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/task/space/HomeInputPresentationState$a;", "", "", "visible", "glassSuspended", "<init>", "(ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.HomeInputPresentationState$a, reason: from toString */
    public static final /* data */ class Presentation {
        private final boolean glassSuspended;
        private final boolean visible;

        public Presentation(boolean z10, boolean z11) {
            this.visible = z10;
            this.glassSuspended = z11;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getGlassSuspended() {
            return this.glassSuspended;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Presentation)) {
                return false;
            }
            Presentation presentation = (Presentation) other;
            return this.visible == presentation.visible && this.glassSuspended == presentation.glassSuspended;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.visible) * 31) + Boolean.hashCode(this.glassSuspended);
        }

        public String toString() {
            return "Presentation(visible=" + this.visible + ", glassSuspended=" + this.glassSuspended + ")";
        }
    }

    public final void a() {
        this.state = State.READY;
    }

    public final void b(boolean covered) {
        this.state = covered ? State.COVERED : State.READY;
    }

    public final Presentation c(boolean wakeDialogShowing, boolean artifactsActive) {
        boolean z10 = false;
        boolean z11 = this.state == State.COVERED;
        if (!z11 && !wakeDialogShowing && !artifactsActive) {
            z10 = true;
        }
        return new Presentation(z10, z11);
    }
}
