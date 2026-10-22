package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class WorkInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UUID f5366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public State f5367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f5368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set f5369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f5370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5372g;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State BLOCKED = null;
        public static final State CANCELLED = null;
        public static final State ENQUEUED = null;
        public static final State FAILED = null;
        public static final State RUNNING = null;
        public static final State SUCCEEDED = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{ENQUEUED, RUNNING, SUCCEEDED, FAILED, BLOCKED, CANCELLED};
        }

        static {
            ENQUEUED = new State("ENQUEUED", 0);
            RUNNING = new State("RUNNING", 1);
            SUCCEEDED = new State("SUCCEEDED", 2);
            FAILED = new State("FAILED", 3);
            BLOCKED = new State("BLOCKED", 4);
            CANCELLED = new State("CANCELLED", 5);
            $VALUES = $values();
        }

        private State(String r10, int r11) {
            super(r10, r11);
        }

        public static State valueOf(String r10) {
            return (State) Enum.valueOf(State.class, r10);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public boolean isFinished() {
            if (this != SUCCEEDED) goto L5;
        L10:
            return true;
        L5:
            if (this == FAILED) goto L10;
            if (this == CANCELLED) goto L10;
            return false;
        }
    }

    public WorkInfo(UUID r10, State r11, c r12, List r13, c r14, int r15, int r16) {
        this.f5366a = r10;
        this.f5367b = r11;
        this.f5368c = r12;
        this.f5369d = new HashSet(r13);
        this.f5370e = r14;
        this.f5371f = r15;
        this.f5372g = r16;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L30:
        return false;
    L8:
        if (WorkInfo.class != r10.getClass()) goto L30;
        WorkInfo r11 = (WorkInfo) r10;
        if (this.f5371f == r11.f5371f) goto L14;
        return false;
    L14:
        if (this.f5372g == r11.f5372g) goto L17;
        return false;
    L17:
        if (this.f5366a.equals(r11.f5366a) == true) goto L20;
        return false;
    L20:
        if (this.f5367b == r11.f5367b) goto L23;
        return false;
    L23:
        if (this.f5368c.equals(r11.f5368c) == true) goto L26;
        return false;
    L26:
        if (this.f5369d.equals(r11.f5369d) == true) goto L29;
        return false;
    L29:
        return this.f5370e.equals(r11.f5370e);
    }

    public int hashCode() {
        return (((((((((((this.f5366a.hashCode() * 31) + this.f5367b.hashCode()) * 31) + this.f5368c.hashCode()) * 31) + this.f5369d.hashCode()) * 31) + this.f5370e.hashCode()) * 31) + this.f5371f) * 31) + this.f5372g;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f5366a + "', mState=" + this.f5367b + ", mOutputData=" + this.f5368c + ", mTags=" + this.f5369d + ", mProgress=" + this.f5370e + '}';
    }
}
