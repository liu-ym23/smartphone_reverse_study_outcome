package com.android.contacts.dialpad;

import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.DialpadMatchEvent;
import com.obric.utils.GlobalUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialpadMatchTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/contacts/dialpad/DialpadMatchTracker;", "", "()V", "pendingStartMs", "", "state", "Lcom/android/contacts/dialpad/DialpadMatchTracker$MatchState;", "onMatchCancelled", "", "onMatchDone", "digitsLength", "", "resultSize", "onMatchStart", "reportAndClear", "endReason", "", "MatchState", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialpadMatchTracker {
    public static final DialpadMatchTracker INSTANCE = null;
    private static volatile long pendingStartMs;
    private static volatile MatchState state;

    /* JADX INFO: compiled from: DialpadMatchTracker.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/android/contacts/dialpad/DialpadMatchTracker$MatchState;", "", "matchDurationMs", "", "digitsLength", "", "resultSize", "hasReported", "", "(JIIZ)V", "getDigitsLength", "()I", "getHasReported", "()Z", "setHasReported", "(Z)V", "getMatchDurationMs", "()J", "getResultSize", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MatchState {
        private final int digitsLength;
        private boolean hasReported;
        private final long matchDurationMs;
        private final int resultSize;

        public static /* synthetic */ MatchState copy$default(MatchState r6, long r7, int r9, int r10, boolean r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.matchDurationMs;
        L5:
            long r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r9 = r6.digitsLength;
        L8:
            int r3 = r9;
            if ((r12 & 4) == 0) goto L11;
            r10 = r6.resultSize;
        L11:
            int r4 = r10;
            if ((r12 & 8) == 0) goto L15;
            r11 = r6.hasReported;
        L15:
            return r6.copy(r1, r3, r4, r11);
        }

        public final long component1() {
            return this.matchDurationMs;
        }

        public final int component2() {
            return this.digitsLength;
        }

        public final int component3() {
            return this.resultSize;
        }

        public final boolean component4() {
            return this.hasReported;
        }

        public final MatchState copy(long r7, int r9, int r10, boolean r11) {
            return new MatchState(r7, r9, r10, r11);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof MatchState) == true) goto L8;
            return false;
        L8:
            MatchState r9 = (MatchState) r8;
            if (this.matchDurationMs == r9.matchDurationMs) goto L12;
            return false;
        L12:
            if (this.digitsLength == r9.digitsLength) goto L15;
            return false;
        L15:
            if (this.resultSize == r9.resultSize) goto L18;
            return false;
        L18:
            if (this.hasReported == r9.hasReported) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r0 = ((((Long.hashCode(this.matchDurationMs) * 31) + Integer.hashCode(this.digitsLength)) * 31) + Integer.hashCode(this.resultSize)) * 31;
            boolean r2 = this.hasReported;
            ?? r3 = r2;
            if (r2 == false) goto L6;
            r3 = 1;
        L6:
            return r0 + r3;
        }

        public String toString() {
            return "MatchState(matchDurationMs=" + this.matchDurationMs + ", digitsLength=" + this.digitsLength + ", resultSize=" + this.resultSize + ", hasReported=" + this.hasReported + ')';
        }

        public MatchState(long r1, int r3, int r4, boolean r5) {
            this.matchDurationMs = r1;
            this.digitsLength = r3;
            this.resultSize = r4;
            this.hasReported = r5;
        }

        public /* synthetic */ MatchState(long r7, int r9, int r10, boolean r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 8) == 0) goto L5;
            r11 = false;
        L5:
            this(r7, r9, r10, r11);
        }

        public final long getMatchDurationMs() {
            return this.matchDurationMs;
        }

        public final int getDigitsLength() {
            return this.digitsLength;
        }

        public final int getResultSize() {
            return this.resultSize;
        }

        public final boolean getHasReported() {
            return this.hasReported;
        }

        public final void setHasReported(boolean r1) {
            this.hasReported = r1;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$DsyhO59IZuiT6Ohqa1ja_l-NEbE, reason: not valid java name */
    public static /* synthetic */ void m177$r8$lambda$DsyhO59IZuiT6Ohqa1ja_lNEbE(MatchState r0, String r1) {
        reportAndClear$lambda$1$lambda$0(r0, r1);
    }

    static {
        INSTANCE = new DialpadMatchTracker();
    }

    private DialpadMatchTracker() {
    }

    @JvmStatic
    public static final void onMatchStart() {
        pendingStartMs = System.currentTimeMillis();
    }

    @JvmStatic
    public static final void onMatchCancelled() {
        pendingStartMs = 0;
    }

    @JvmStatic
    public static final void onMatchDone(int r13, int r14) {
        long r0 = pendingStartMs;
        if (r0 != 0) goto L5;
        return;
    L5:
        state = new MatchState(System.currentTimeMillis() - r0, r13, r14, false, 8, null);
        pendingStartMs = 0;
    }

    @JvmStatic
    public static final void reportAndClear(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "endReason");
        final MatchState r0 = state;
        if (r0 != null) goto L5;
    L7:
        state = null;
        pendingStartMs = 0;
        return;
    L5:
        if (r0.getHasReported() == true) goto L7;
        GlobalUtils.INSTANCE.execute(new DialpadMatchTracker$$ExternalSyntheticLambda0(r0, r3));
        r0.setHasReported(true);
        goto L7
    }

    private static final void reportAndClear$lambda$1$lambda$0(MatchState r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "$it");
        Intrinsics.checkNotNullParameter(r12, "$endReason");
        EventTrackerManager.INSTANCE.track(new DialpadMatchEvent(r11.getMatchDurationMs(), r11.getDigitsLength(), r11.getResultSize(), r12, null, 16, null));
    }
}
