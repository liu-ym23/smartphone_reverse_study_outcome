package com.stepos.ailauncher.container;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000  2\u00020\u0001:\u0003!\u001a\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\bJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\nJ\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0003R$\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/container/OverlayRecentsInputGate;", "", "<init>", "()V", "", "overlayMidDrag", "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a;", "f", "(Z)Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a;", "enter", "c", "suspended", "e", Const.INTENT_KEY_UMID, "", "postedGeneration", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)Z", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$Phase;", UxipConstants.f30680s, "phase", "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$Phase;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$Phase;", HomeGestureEligibilityContract.EXTRA_GENERATION, "I", "getGeneration", "()I", "Companion", "Phase", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlayRecentsInputGate {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final float MID_DRAG_PROGRESS_HIGH = 0.95f;
    public static final float MID_DRAG_PROGRESS_LOW = 0.05f;
    private int generation;
    private Phase phase = Phase.IDLE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PEEK", "OVERVIEW", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Phase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        public static final Phase IDLE = new Phase("IDLE", 0);
        public static final Phase PEEK = new Phase("PEEK", 1);
        public static final Phase OVERVIEW = new Phase("OVERVIEW", 2);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{IDLE, PEEK, OVERVIEW};
        }

        static {
            Phase[] phaseArr$values = $values();
            $VALUES = phaseArr$values;
            $ENTRIES = kotlin.enums.a.a(phaseArr$values);
        }

        private Phase(String str, int i10) {
        }

        public static InterfaceC4149a<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String str) {
            return (Phase) Enum.valueOf(Phase.class, str);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a;", "", "<init>", "()V", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a$a;", "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a$b;", "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a$c;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class a {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a$a;", "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.container.OverlayRecentsInputGate$a$a, reason: collision with other inner class name */
        public static final /* data */ class C0305a extends a {
            public static final C0305a INSTANCE = new C0305a();

            public C0305a() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof C0305a);
            }

            public int hashCode() {
                return 1082930631;
            }

            public String toString() {
                return "Ignore";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a$b;", "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a;", "", "reason", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.container.OverlayRecentsInputGate$a$b, reason: from toString */
        public static final /* data */ class Restore extends a {
            private final String reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Restore(String reason) {
                super(null);
                kotlin.jvm.internal.p.i(reason, "reason");
                this.reason = reason;
            }

            /* renamed from: a, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Restore) && kotlin.jvm.internal.p.d(this.reason, ((Restore) other).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Restore(reason=" + this.reason + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a$c;", "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$a;", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "", "reason", "<init>", "(ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.container.OverlayRecentsInputGate$a$c, reason: from toString */
        public static final /* data */ class Suppress extends a {
            private final int generation;
            private final String reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Suppress(int i10, String reason) {
                super(null);
                kotlin.jvm.internal.p.i(reason, "reason");
                this.generation = i10;
                this.reason = reason;
            }

            /* renamed from: a, reason: from getter */
            public final int getGeneration() {
                return this.generation;
            }

            /* renamed from: b, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Suppress)) {
                    return false;
                }
                Suppress suppress = (Suppress) other;
                return this.generation == suppress.generation && kotlin.jvm.internal.p.d(this.reason, suppress.reason);
            }

            public int hashCode() {
                return (Integer.hashCode(this.generation) * 31) + this.reason.hashCode();
            }

            public String toString() {
                return "Suppress(generation=" + this.generation + ", reason=" + this.reason + ")";
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/container/OverlayRecentsInputGate$b;", "", "<init>", "()V", "", "progress", "", "alreadyInOpen", "isPanelOpen", Const.INTENT_KEY_APIKEY, "(FZZ)Z", "MID_DRAG_PROGRESS_LOW", "F", "MID_DRAG_PROGRESS_HIGH", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.container.OverlayRecentsInputGate$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(float progress, boolean alreadyInOpen, boolean isPanelOpen) {
            return (progress > 0.05f && progress < 0.95f) || alreadyInOpen != isPanelOpen;
        }

        public Companion() {
        }
    }

    /* renamed from: a, reason: from getter */
    public final Phase getPhase() {
        return this.phase;
    }

    public final a b() {
        this.generation++;
        this.phase = Phase.IDLE;
        return new a.Restore("CANCEL_GESTURE_VIEW");
    }

    public final a c(boolean enter) {
        int i10 = this.generation + 1;
        this.generation = i10;
        if (enter) {
            this.phase = Phase.OVERVIEW;
            return new a.Suppress(i10, "ENTER_RECENTS");
        }
        this.phase = Phase.IDLE;
        return new a.Restore("ENTER_RECENTS_EXIT");
    }

    public final a d() {
        this.generation++;
        this.phase = Phase.IDLE;
        return new a.Restore("overlay-resume");
    }

    public final a e(boolean suspended) {
        int i10 = this.generation + 1;
        this.generation = i10;
        if (suspended) {
            this.phase = Phase.OVERVIEW;
            return new a.Suppress(i10, "RECENTS_SUSPEND");
        }
        this.phase = Phase.IDLE;
        return new a.Restore("RECENTS_SUSPEND_CLEARED");
    }

    public final a f(boolean overlayMidDrag) {
        if (!overlayMidDrag && this.phase == Phase.OVERVIEW) {
            return a.C0305a.INSTANCE;
        }
        return a.C0305a.INSTANCE;
    }

    public final void g() {
        this.phase = Phase.IDLE;
        this.generation++;
    }

    public final boolean h(int postedGeneration) {
        return postedGeneration == this.generation && this.phase != Phase.IDLE;
    }
}
