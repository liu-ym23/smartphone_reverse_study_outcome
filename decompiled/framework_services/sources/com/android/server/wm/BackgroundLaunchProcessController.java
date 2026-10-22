package com.android.server.wm;

import android.app.BackgroundStartPrivileges;
import android.app.compat.CompatChanges;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.IntArray;
import com.android.internal.util.Preconditions;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import com.android.server.job.controllers.JobStatus;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

/* JADX INFO: loaded from: classes3.dex */
class BackgroundLaunchProcessController {
    static final BalCheckConfiguration CHECK_FOR_FGS_START = null;
    private static final long DEFAULT_RESCIND_BAL_FG_PRIVILEGES_BOUND_SERVICE = 261072174;
    private static final String TAG = "ActivityTaskManager";
    private final BackgroundActivityStartCallback mBackgroundActivityStartCallback;
    private ArrayMap<Binder, BackgroundStartPrivileges> mBackgroundStartPrivileges;
    private IntArray mBalOptInBoundClientUids;
    private final IntPredicate mUidHasActiveVisibleWindowPredicate;

    static final class BalCheckConfiguration extends Record {
        private final boolean checkOtherExemptions;
        private final boolean checkVisibility;
        private final long gracePeriod;
        private final boolean isCheckingForFgsStart;

        private /* synthetic */ boolean $record$equals(Object r5) {
            if ((r5 instanceof BalCheckConfiguration) == false) goto L14;
            BalCheckConfiguration r6 = (BalCheckConfiguration) r5;
            if (this.isCheckingForFgsStart == r6.isCheckingForFgsStart) goto L7;
            return false;
        L7:
            if (this.checkVisibility == r6.checkVisibility) goto L9;
            return false;
        L9:
            if (this.checkOtherExemptions == r6.checkOtherExemptions) goto L11;
            return false;
        L11:
            if (this.gracePeriod != r6.gracePeriod) goto L19;
            return true;
        L19:
            return false;
        L14:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{Boolean.valueOf(this.isCheckingForFgsStart), Boolean.valueOf(this.checkVisibility), Boolean.valueOf(this.checkOtherExemptions), Long.valueOf(this.gracePeriod)};
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcheckOtherExemptions, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9840$$Nest$fgetcheckOtherExemptions(BalCheckConfiguration r0) {
            return r0.checkOtherExemptions;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcheckVisibility, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9841$$Nest$fgetcheckVisibility(BalCheckConfiguration r0) {
            return r0.checkVisibility;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetgracePeriod, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m9842$$Nest$fgetgracePeriod(BalCheckConfiguration r2) {
            return r2.gracePeriod;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetisCheckingForFgsStart, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9843$$Nest$fgetisCheckingForFgsStart(BalCheckConfiguration r0) {
            return r0.isCheckingForFgsStart;
        }

        BalCheckConfiguration(boolean isCheckingForFgsStart, boolean checkVisibility, boolean checkOtherExemptions, long gracePeriod) {
            this.isCheckingForFgsStart = isCheckingForFgsStart;
            this.checkVisibility = checkVisibility;
            this.checkOtherExemptions = checkOtherExemptions;
            this.gracePeriod = gracePeriod;
        }

        public boolean checkOtherExemptions() {
            return this.checkOtherExemptions;
        }

        public boolean checkVisibility() {
            return this.checkVisibility;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        public long gracePeriod() {
            return this.gracePeriod;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return BackgroundLaunchProcessController$BalCheckConfiguration$$ExternalSyntheticRecord0.m(this.isCheckingForFgsStart, this.checkVisibility, this.checkOtherExemptions, this.gracePeriod);
        }

        public boolean isCheckingForFgsStart() {
            return this.isCheckingForFgsStart;
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), BalCheckConfiguration.class, "isCheckingForFgsStart;checkVisibility;checkOtherExemptions;gracePeriod");
        }
    }

    BackgroundLaunchProcessController(IntPredicate uidHasActiveVisibleWindowPredicate, BackgroundActivityStartCallback callback) {
        this.mUidHasActiveVisibleWindowPredicate = uidHasActiveVisibleWindowPredicate;
        this.mBackgroundActivityStartCallback = callback;
    }

    static {
        CHECK_FOR_FGS_START = new BalCheckConfiguration(true, true, true, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    BackgroundActivityStartController.BalVerdict areBackgroundActivityStartsAllowed(int pid, int uid, String packageName, int appSwitchState, BalCheckConfiguration checkConfiguration, boolean hasActivityInVisibleTask, boolean inPinnedWindow, boolean hasBackgroundActivityStartPrivileges, long lastStopAppSwitchesTime, long lastActivityLaunchTime, long lastActivityFinishTime) {
        if (BalCheckConfiguration.m9840$$Nest$fgetcheckOtherExemptions(checkConfiguration) == false) goto L8;
        if (hasBackgroundActivityStartPrivileges == false) goto L8;
        return new BackgroundActivityStartController.BalVerdict(6, "process instrumenting with background activity starts privileges");
    L8:
        if (BalCheckConfiguration.m9840$$Nest$fgetcheckOtherExemptions(checkConfiguration) == false) goto L13;
        BackgroundActivityStartController.BalVerdict tokenVerdict = isBackgroundStartAllowedByToken(uid, packageName, BalCheckConfiguration.m9843$$Nest$fgetisCheckingForFgsStart(checkConfiguration));
        if (tokenVerdict.allows() == false) goto L13;
        return tokenVerdict;
    L13:
        if (BalCheckConfiguration.m9841$$Nest$fgetcheckVisibility(checkConfiguration) == false) goto L20;
        if (appSwitchState == 0) goto L20;
        if (isBoundByForegroundUid() == false) goto L20;
        return new BackgroundActivityStartController.BalVerdict(13, "process bound by foreground uid");
    L20:
        if (BalCheckConfiguration.m9843$$Nest$fgetisCheckingForFgsStart(checkConfiguration) == true) goto L23;
        if (inPinnedWindow == false) goto L23;
    L29:
        if (BalCheckConfiguration.m9840$$Nest$fgetcheckOtherExemptions(checkConfiguration) == false) goto L41;
        if (appSwitchState != 2) goto L41;
        if (lastActivityLaunchTime <= lastStopAppSwitchesTime) goto L35;
    L36:
        long now = SystemClock.uptimeMillis();
        long timeSinceLastStartOrFinish = now - Math.max(lastActivityLaunchTime, lastActivityFinishTime);
        if (timeSinceLastStartOrFinish >= BalCheckConfiguration.m9842$$Nest$fgetgracePeriod(checkConfiguration)) goto L41;
        return new BackgroundActivityStartController.BalVerdict(8, "within " + BalCheckConfiguration.m9842$$Nest$fgetgracePeriod(checkConfiguration) + "ms grace period (" + timeSinceLastStartOrFinish + "ms)");
    L35:
        if (lastActivityFinishTime > lastStopAppSwitchesTime) goto L36;
    L41:
        return BackgroundActivityStartController.BalVerdict.BLOCK;
    L23:
        if (BalCheckConfiguration.m9840$$Nest$fgetcheckOtherExemptions(checkConfiguration) == false) goto L29;
        if (hasActivityInVisibleTask == false) goto L29;
        if (appSwitchState == 0) goto L29;
        return new BackgroundActivityStartController.BalVerdict(9, "process has activity in foreground task");
    }

    private BackgroundActivityStartController.BalVerdict isBackgroundStartAllowedByToken(int uid, String packageName, boolean isCheckingForFgsStart) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.mBackgroundStartPrivileges != null) goto L6;
    L56:
        BackgroundActivityStartController.BalVerdict r0 = BackgroundActivityStartController.BalVerdict.BLOCK;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r0;
    L6:
        if (this.mBackgroundStartPrivileges.isEmpty() == true) goto L56;
        if (isCheckingForFgsStart == false) goto L25;
        int i = this.mBackgroundStartPrivileges.size();     // Catch: Throwable -> L18
    L11:
        int i2 = i - 1;     // Catch: Throwable -> L18
        if (i <= 0) goto L21;
        if (this.mBackgroundStartPrivileges.valueAt(i2).allowsBackgroundFgsStarts() == true) goto L15;
        i = i2;
        goto L11
    L15:
        BackgroundActivityStartController.BalVerdict r1 = new BackgroundActivityStartController.BalVerdict(12, "process allowed by token");     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r1;
    L21:
        BackgroundActivityStartController.BalVerdict r2 = BackgroundActivityStartController.BalVerdict.BLOCK;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r2;
    L25:
        if (this.mBackgroundActivityStartCallback != null) goto L38;
        int i3 = this.mBackgroundStartPrivileges.size();     // Catch: Throwable -> L18
    L27:
        int i4 = i3 - 1;     // Catch: Throwable -> L18
        if (i3 <= 0) goto L35;
        if (this.mBackgroundStartPrivileges.valueAt(i4).allowsBackgroundActivityStarts() == true) goto L31;
        i3 = i4;
        goto L27
    L31:
        BackgroundActivityStartController.BalVerdict r3 = new BackgroundActivityStartController.BalVerdict(12, "process allowed by token");     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r3;
    L35:
        BackgroundActivityStartController.BalVerdict r4 = BackgroundActivityStartController.BalVerdict.BLOCK;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r4;
    L38:
        List<IBinder> binderTokens = getOriginatingTokensThatAllowBal();     // Catch: Throwable -> L18
        if (binderTokens.isEmpty() == false) goto L43;
        BackgroundActivityStartController.BalVerdict r5 = BackgroundActivityStartController.BalVerdict.BLOCK;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r5;
    L43:
        BackgroundActivityStartCallback.BackgroundActivityStartCallbackResult activityStartAllowed = this.mBackgroundActivityStartCallback.isActivityStartAllowed(binderTokens, uid, packageName);     // Catch: Throwable -> L18
        if (activityStartAllowed.allowed() == true) goto L49;
        BackgroundActivityStartController.BalVerdict r6 = BackgroundActivityStartController.BalVerdict.BLOCK;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r6;
    L49:
        if (activityStartAllowed.token() != null) goto L53;
        BackgroundActivityStartController.BalVerdict r7 = new BackgroundActivityStartController.BalVerdict(12, "process allowed by callback (token ignored) tokens: " + binderTokens);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r7;
    L53:
        BackgroundActivityStartController.BalVerdict r8 = new BackgroundActivityStartController.BalVerdict(12, "process allowed by callback (token: " + activityStartAllowed.token() + ") tokens: " + binderTokens);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r8;
    }

    private List<IBinder> getOriginatingTokensThatAllowBal() {
        List<IBinder> originatingTokens = new ArrayList();
        int i = this.mBackgroundStartPrivileges.size();
    L3:
        int i2 = i - 1;
        if (i <= 0) goto L10;
        BackgroundStartPrivileges privilege = this.mBackgroundStartPrivileges.valueAt(i2);
        if (privilege.allowsBackgroundActivityStarts() == false) goto L8;
        originatingTokens.add(privilege.getOriginatingToken());
    L8:
        i = i2;
        goto L3
    L10:
        return originatingTokens;
    }

    private boolean isBoundByForegroundUid() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mBalOptInBoundClientUids == null) goto L14;
        int i = this.mBalOptInBoundClientUids.size() - 1;     // Catch: Throwable -> L11
    L6:
        if (i < 0) goto L14;
        if (this.mUidHasActiveVisibleWindowPredicate.test(this.mBalOptInBoundClientUids.get(i)) == true) goto L9;
        i = i - 1;     // Catch: Throwable -> L11
        goto L6
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return true;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L11
        return false;
    }

    void clearBalOptInBoundClientUids() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mBalOptInBoundClientUids != null) goto L8;
        this.mBalOptInBoundClientUids = new IntArray();     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L8:
        this.mBalOptInBoundClientUids.clear();     // Catch: Throwable -> L6
        goto L9
    }

    void addBoundClientUid(int clientUid, String clientPackageName, long bindFlags) {
        if (CompatChanges.isChangeEnabled(DEFAULT_RESCIND_BAL_FG_PRIVILEGES_BOUND_SERVICE, clientPackageName, UserHandle.getUserHandleForUid(clientUid)) == false) goto L7;
        if ((512 & bindFlags) != 0) goto L7;
        return;
    L7:
        if (this.mBalOptInBoundClientUids != null) goto L10;
        this.mBalOptInBoundClientUids = new IntArray();
    L10:
        if (this.mBalOptInBoundClientUids.indexOf(clientUid) != (-1)) goto L14;
        this.mBalOptInBoundClientUids.add(clientUid);
        return;
    }

    void addOrUpdateAllowBackgroundStartPrivileges(Binder entity, BackgroundStartPrivileges backgroundStartPrivileges) {
        entity.getClass();
        backgroundStartPrivileges.getClass();
        Preconditions.checkArgument(backgroundStartPrivileges.allowsAny(), "backgroundStartPrivileges does not allow anything");
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mBackgroundStartPrivileges != null) goto L9;
        this.mBackgroundStartPrivileges = new ArrayMap();     // Catch: Throwable -> L7
    L9:
        this.mBackgroundStartPrivileges.put(entity, backgroundStartPrivileges);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    void removeAllowBackgroundStartPrivileges(Binder entity) {
        entity.getClass();
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mBackgroundStartPrivileges == null) goto L9;
        this.mBackgroundStartPrivileges.remove(entity);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    boolean canCloseSystemDialogsByToken(int uid) {
        if (this.mBackgroundActivityStartCallback != null) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.mBackgroundStartPrivileges != null) goto L9;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L14
        return false;
    L9:
        if (this.mBackgroundStartPrivileges.isEmpty() == true) goto L16;
        boolean r0 = this.mBackgroundActivityStartCallback.canCloseSystemDialogs(getOriginatingTokensThatAllowBal(), uid);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return r0;
    }

    void dump(PrintWriter pw, String prefix) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mBackgroundStartPrivileges == null) goto L13;
        if (this.mBackgroundStartPrivileges.isEmpty() == true) goto L13;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.println("Background activity start tokens (token: originating token):");     // Catch: Throwable -> L10
        int i = this.mBackgroundStartPrivileges.size() - 1;     // Catch: Throwable -> L10
    L8:
        if (i < 0) goto L13;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.print("  - ");     // Catch: Throwable -> L10
        pw.print(this.mBackgroundStartPrivileges.keyAt(i));     // Catch: Throwable -> L10
        pw.print(": ");     // Catch: Throwable -> L10
        pw.println(this.mBackgroundStartPrivileges.valueAt(i));     // Catch: Throwable -> L10
        i = i - 1;     // Catch: Throwable -> L10
    L13:
        if (this.mBalOptInBoundClientUids != null) goto L15;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L15:
        if (this.mBalOptInBoundClientUids.size() <= 0) goto L17;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.print("BoundClientUids:");     // Catch: Throwable -> L10
        pw.println(Arrays.toString(this.mBalOptInBoundClientUids.toArray()));     // Catch: Throwable -> L10
        goto L17
    }
}
