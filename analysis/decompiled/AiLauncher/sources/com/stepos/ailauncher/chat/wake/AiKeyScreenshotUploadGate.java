package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0003\u0010\u0019\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate;", "", "<init>", "()V", "", "nowMs", "LY8/t;", "c", "(J)V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "f", "round", "", "e", "(J)Z", Const.INTENT_KEY_APIKEY, "(JLe9/c;)Ljava/lang/Object;", "LXa/k;", "Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$b;", VoiceWakeupReceiver.EXTRA_STATE, "LXa/k;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()J", "Companion", "Decision", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AiKeyScreenshotUploadGate {
    public static final long LONG_PRESS_THRESHOLD_MS = 1500;
    private final Xa.k<State> state = Xa.u.a(new State(0, null, null, 7, null));

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$Decision;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW", "PENDING", "BLOCK", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Decision {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Decision[] $VALUES;
        public static final Decision ALLOW = new Decision("ALLOW", 0);
        public static final Decision PENDING = new Decision("PENDING", 1);
        public static final Decision BLOCK = new Decision("BLOCK", 2);

        private static final /* synthetic */ Decision[] $values() {
            return new Decision[]{ALLOW, PENDING, BLOCK};
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

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$b;", "", "", "round", "Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$Decision;", "decision", "pressedAtMs", "<init>", "(JLcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$Decision;Ljava/lang/Long;)V", Const.INTENT_KEY_APIKEY, "(JLcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$Decision;Ljava/lang/Long;)Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$b;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "e", "()J", "Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$Decision;", "c", "()Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$Decision;", "Ljava/lang/Long;", Const.INTENT_KEY_UMID, "()Ljava/lang/Long;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$b, reason: from toString */
    public static final /* data */ class State {
        private final Decision decision;
        private final Long pressedAtMs;
        private final long round;

        public State() {
            this(0L, null, null, 7, null);
        }

        public static /* synthetic */ State b(State state, long j10, Decision decision, Long l10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = state.round;
            }
            if ((i10 & 2) != 0) {
                decision = state.decision;
            }
            if ((i10 & 4) != 0) {
                l10 = state.pressedAtMs;
            }
            return state.a(j10, decision, l10);
        }

        public final State a(long round, Decision decision, Long pressedAtMs) {
            kotlin.jvm.internal.p.i(decision, "decision");
            return new State(round, decision, pressedAtMs);
        }

        /* renamed from: c, reason: from getter */
        public final Decision getDecision() {
            return this.decision;
        }

        /* renamed from: d, reason: from getter */
        public final Long getPressedAtMs() {
            return this.pressedAtMs;
        }

        /* renamed from: e, reason: from getter */
        public final long getRound() {
            return this.round;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.round == state.round && this.decision == state.decision && kotlin.jvm.internal.p.d(this.pressedAtMs, state.pressedAtMs);
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.round) * 31) + this.decision.hashCode()) * 31;
            Long l10 = this.pressedAtMs;
            return iHashCode + (l10 == null ? 0 : l10.hashCode());
        }

        public String toString() {
            return "State(round=" + this.round + ", decision=" + this.decision + ", pressedAtMs=" + this.pressedAtMs + ")";
        }

        public State(long j10, Decision decision, Long l10) {
            kotlin.jvm.internal.p.i(decision, "decision");
            this.round = j10;
            this.decision = decision;
            this.pressedAtMs = l10;
        }

        public /* synthetic */ State(long j10, Decision decision, Long l10, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? 0L : j10, (i10 & 2) != 0 ? Decision.ALLOW : decision, (i10 & 4) != 0 ? null : l10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r6, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$awaitPermission$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$awaitPermission$1 r0 = (com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$awaitPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$awaitPermission$1 r0 = new com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$awaitPermission$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            long r6 = r0.J$0
            kotlin.C4849c.b(r8)
            goto L49
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.C4849c.b(r8)
            Xa.k<com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$b> r8 = r5.state
            com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$awaitPermission$2 r2 = new com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$awaitPermission$2
            r4 = 0
            r2.<init>(r6, r4)
            r0.J$0 = r6
            r0.label = r3
            java.lang.Object r8 = Xa.d.z(r8, r2, r0)
            if (r8 != r1) goto L49
            return r1
        L49:
            boolean r5 = r5.e(r6)
            java.lang.Boolean r5 = g9.C4109a.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate.a(long, e9.c):java.lang.Object");
    }

    public final void b() {
        if (this.state.getValue().getPressedAtMs() == null && this.state.getValue().getDecision() != Decision.ALLOW) {
            this.state.setValue(new State(g() + 1, null, null, 6, null));
        }
    }

    public final void c(long nowMs) {
        this.state.setValue(new State(g() + 1, Decision.PENDING, Long.valueOf(nowMs)));
    }

    public final void d() {
        Xa.k<State> kVar = this.state;
        kVar.setValue(State.b(kVar.getValue(), 0L, Decision.BLOCK, null, 5, null));
    }

    public final boolean e(long round) {
        State value = this.state.getValue();
        return value.getRound() == round && value.getDecision() == Decision.ALLOW;
    }

    public final void f(long nowMs) {
        State value = this.state.getValue();
        Long pressedAtMs = value.getPressedAtMs();
        if (pressedAtMs != null) {
            long jLongValue = pressedAtMs.longValue();
            Decision decision = value.getDecision();
            Decision decision2 = Decision.BLOCK;
            boolean z10 = decision == decision2 || nowMs - jLongValue >= 1500;
            Xa.k<State> kVar = this.state;
            if (!z10) {
                decision2 = Decision.ALLOW;
            }
            kVar.setValue(State.b(value, 0L, decision2, null, 1, null));
        }
    }

    public final long g() {
        return this.state.getValue().getRound();
    }
}
