package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public final class WorkInfo {
    private UUID mId;
    private Data mOutputData;
    private Data mProgress;
    private int mRunAttemptCount;
    private State mState;
    private Set<String> mTags;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State BLOCKED = null;
        public static final State CANCELLED = null;
        public static final State ENQUEUED = null;
        public static final State FAILED = null;
        public static final State RUNNING = null;
        public static final State SUCCEEDED = null;

        static {
            State r100 = new State("ENQUEUED", 0);
            ENQUEUED = r100;
            State r101 = new State("RUNNING", 1);
            RUNNING = r101;
            State r102 = new State("SUCCEEDED", 2);
            SUCCEEDED = r102;
            State r103 = new State("FAILED", 3);
            FAILED = r103;
            State r104 = new State("BLOCKED", 4);
            BLOCKED = r104;
            State r105 = new State("CANCELLED", 5);
            CANCELLED = r105;
            $VALUES = new State[]{r100, r101, r102, r103, r104, r105};
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

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int hashCode() {
        return (((((((((this.mId.hashCode() * 31) + this.mState.hashCode()) * 31) + this.mOutputData.hashCode()) * 31) + this.mTags.hashCode()) * 31) + this.mProgress.hashCode()) * 31) + this.mRunAttemptCount;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.mId + "', mState=" + this.mState + ", mOutputData=" + this.mOutputData + ", mTags=" + this.mTags + ", mProgress=" + this.mProgress + '}';
    }

    public UUID getId() {
        return this.mId;
    }

    public Data getOutputData() {
        return this.mOutputData;
    }

    public Data getProgress() {
        return this.mProgress;
    }

    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    public State getState() {
        return this.mState;
    }

    public Set<String> getTags() {
        return this.mTags;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L27:
        return false;
    L8:
        if (WorkInfo.class != r100.getClass()) goto L27;
        WorkInfo r101 = (WorkInfo) r100;
        if (this.mRunAttemptCount == r101.mRunAttemptCount) goto L14;
        return false;
    L14:
        if (this.mId.equals(r101.mId) == true) goto L17;
        return false;
    L17:
        if (this.mState == r101.mState) goto L20;
        return false;
    L20:
        if (this.mOutputData.equals(r101.mOutputData) == true) goto L23;
        return false;
    L23:
        if (this.mTags.equals(r101.mTags) == true) goto L26;
        return false;
    L26:
        return this.mProgress.equals(r101.mProgress);
    }

    public WorkInfo(UUID r100, State r101, Data r102, List<String> r103, Data r104, int r105) {
        this.mId = r100;
        this.mState = r101;
        this.mOutputData = r102;
        this.mTags = new HashSet(r103);
        this.mProgress = r104;
        this.mRunAttemptCount = r105;
    }
}
