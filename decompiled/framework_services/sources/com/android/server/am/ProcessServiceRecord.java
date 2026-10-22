package com.android.server.am;

import android.os.IBinder;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.android.server.wm.WindowProcessController;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class ProcessServiceRecord {
    boolean mAllowlistManager;
    final ProcessRecord mApp;
    private ArraySet<Integer> mBoundClientUids;
    private int mConnectionGroup;
    private int mConnectionImportance;
    private ServiceRecord mConnectionService;
    private final ArraySet<ConnectionRecord> mConnections;
    private boolean mExecServicesFg;
    private final ArraySet<ServiceRecord> mExecutingServices;
    private int mFgServiceTypes;
    private boolean mHasAboveClient;
    private boolean mHasClientActivities;
    private boolean mHasForegroundServices;
    private boolean mHasTopStartedAlmostPerceptibleServices;
    private boolean mHasTypeNoneFgs;
    private long mLastTopStartedAlmostPerceptibleBindRequestUptimeMs;
    private int mRepFgServiceTypes;
    private boolean mRepHasForegroundServices;
    private boolean mScheduleServiceTimeoutPending;
    private ArraySet<ConnectionRecord> mSdkSandboxConnections;
    private final ActivityManagerService mService;
    final ArraySet<ServiceRecord> mServices;
    private boolean mTreatLikeActivity;

    ProcessServiceRecord(ProcessRecord app) {
        this.mServices = new ArraySet();
        this.mExecutingServices = new ArraySet();
        this.mConnections = new ArraySet();
        this.mBoundClientUids = new ArraySet();
        this.mApp = app;
        this.mService = app.mService;
    }

    void setHasClientActivities(boolean hasClientActivities) {
        this.mHasClientActivities = hasClientActivities;
        this.mApp.getWindowProcessController().setHasClientActivities(hasClientActivities);
    }

    boolean hasClientActivities() {
        return this.mHasClientActivities;
    }

    void setHasForegroundServices(boolean hasForegroundServices, int fgServiceTypes, boolean hasTypeNoneFgs) {
        setHasForegroundServices(hasForegroundServices, fgServiceTypes, hasTypeNoneFgs, false);
    }

    void setHasForegroundServices(boolean hasForegroundServices, int fgServiceTypes, boolean hasTypeNoneFgs, boolean fromFrozen) {
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L14;
        if (fgServiceTypes != 0) goto L8;
        if (hasTypeNoneFgs == true) goto L8;
        boolean r0 = false;
    L9:
        if (hasForegroundServices == r0) goto L14;
        if (fromFrozen == true) goto L14;
        throw new IllegalStateException("hasForegroundServices mismatch");
    L8:
        r0 = true;
    L14:
        this.mHasForegroundServices = hasForegroundServices;
        this.mFgServiceTypes = fgServiceTypes;
        this.mHasTypeNoneFgs = hasTypeNoneFgs;
        this.mApp.getWindowProcessController().setHasForegroundServices(hasForegroundServices);
        if (hasForegroundServices == false) goto L17;
        this.mApp.mProfile.addHostingComponentType(256);
        return;
    L17:
        this.mApp.mProfile.clearHostingComponentType(256);
    }

    boolean hasForegroundServices() {
        return this.mHasForegroundServices;
    }

    void setHasReportedForegroundServices(boolean hasForegroundServices) {
        this.mRepHasForegroundServices = hasForegroundServices;
    }

    boolean hasReportedForegroundServices() {
        return this.mRepHasForegroundServices;
    }

    int getForegroundServiceTypes() {
        if (this.mHasForegroundServices == true) goto L7;
        return 0;
    L7:
        return this.mFgServiceTypes;
    }

    boolean areForegroundServiceTypesSame(int types, boolean hasTypeNoneFgs) {
        if ((getForegroundServiceTypes() & types) == types) goto L5;
    L7:
        return false;
    L5:
        if (this.mHasTypeNoneFgs != hasTypeNoneFgs) goto L7;
        return true;
    }

    boolean containsAnyForegroundServiceTypes(int types) {
        if ((getForegroundServiceTypes() & types) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasNonShortForegroundServices() {
        if (this.mHasForegroundServices == true) goto L6;
        return false;
    L6:
        if (this.mHasTypeNoneFgs == false) goto L9;
        return true;
    L9:
        if (this.mFgServiceTypes != 2048) goto L11;
        return false;
    L11:
        return true;
    }

    boolean areAllShortForegroundServicesProcstateTimedOut(long nowUptime) {
        if (this.mHasForegroundServices == true) goto L6;
        return false;
    L6:
        if (hasNonShortForegroundServices() == false) goto L9;
        return false;
    L9:
        return !hasUndemotedShortForegroundService(nowUptime);
    }

    boolean hasUndemotedShortForegroundService(long nowUptime) {
        int i = this.mServices.size() - 1;
    L3:
        if (i < 0) goto L13;
        ServiceRecord sr = this.mServices.valueAt(i);
        if (sr.isShortFgs() == false) goto L12;
        if (sr.hasShortFgsInfo() == false) goto L12;
        if (sr.getShortFgsInfo().getProcStateDemoteTime() < nowUptime) goto L12;
        return true;
    L12:
        i = i - 1;
        goto L3
    L13:
        return false;
    }

    int getReportedForegroundServiceTypes() {
        return this.mRepFgServiceTypes;
    }

    void setReportedForegroundServiceTypes(int foregroundServiceTypes) {
        this.mRepFgServiceTypes = foregroundServiceTypes;
    }

    int getNumForegroundServices() {
        int count = 0;
        int i = 0;
        int serviceCount = this.mServices.size();
    L3:
        if (i >= serviceCount) goto L9;
        if (this.mServices.valueAt(i).isForeground == false) goto L7;
        count = count + 1;
    L7:
        i = i + 1;
        goto L3
    L9:
        return count;
    }

    void updateHasTopStartedAlmostPerceptibleServices() {
        this.mHasTopStartedAlmostPerceptibleServices = false;
        this.mLastTopStartedAlmostPerceptibleBindRequestUptimeMs = 0;
        int s = this.mServices.size() - 1;
    L3:
        if (s < 0) goto L11;
        ServiceRecord sr = this.mServices.valueAt(s);
        this.mLastTopStartedAlmostPerceptibleBindRequestUptimeMs = Math.max(this.mLastTopStartedAlmostPerceptibleBindRequestUptimeMs, sr.lastTopAlmostPerceptibleBindRequestUptimeMs);
        if (this.mHasTopStartedAlmostPerceptibleServices == true) goto L9;
        if (isAlmostPerceptible(sr) == false) goto L9;
        this.mHasTopStartedAlmostPerceptibleServices = true;
    L9:
        s = s - 1;
        goto L3
    }

    private boolean isAlmostPerceptible(ServiceRecord record) {
        if (record.lastTopAlmostPerceptibleBindRequestUptimeMs > 0) goto L5;
        return false;
    L5:
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> serviceConnections = record.getConnections();
        int m = serviceConnections.size() - 1;
    L6:
        if (m < 0) goto L15;
        ArrayList<ConnectionRecord> clist = serviceConnections.valueAt(m);
        int c = clist.size() - 1;
    L8:
        if (c < 0) goto L13;
        ConnectionRecord cr = clist.get(c);
        if (cr.hasFlag(65536) == true) goto L11;
        c = c - 1;
        goto L8
    L11:
        return true;
    L13:
        m = m - 1;
        goto L6
    L15:
        return false;
    }

    boolean hasTopStartedAlmostPerceptibleServices() {
        if (this.mHasTopStartedAlmostPerceptibleServices == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mLastTopStartedAlmostPerceptibleBindRequestUptimeMs > 0) goto L7;
    L9:
        return false;
    L7:
        if ((SystemClock.uptimeMillis() - this.mLastTopStartedAlmostPerceptibleBindRequestUptimeMs) >= this.mService.mConstants.mServiceBindAlmostPerceptibleTimeoutMs) goto L9;
        goto L9
    }

    ServiceRecord getConnectionService() {
        return this.mConnectionService;
    }

    void setConnectionService(ServiceRecord connectionService) {
        this.mConnectionService = connectionService;
    }

    int getConnectionGroup() {
        return this.mConnectionGroup;
    }

    void setConnectionGroup(int connectionGroup) {
        this.mConnectionGroup = connectionGroup;
    }

    int getConnectionImportance() {
        return this.mConnectionImportance;
    }

    void setConnectionImportance(int connectionImportance) {
        this.mConnectionImportance = connectionImportance;
    }

    void updateHasAboveClientLocked() {
        this.mHasAboveClient = false;
        int i = this.mConnections.size() - 1;
    L3:
        if (i < 0) goto L20;
        ConnectionRecord cr = this.mConnections.valueAt(i);
        if (cr.binding.service.app != null) goto L7;
    L9:
        boolean isSameProcess = false;
    L10:
        if (isSameProcess == true) goto L14;
        if (cr.hasFlag(8) == false) goto L14;
        this.mHasAboveClient = true;
        return;
    L14:
        i = i - 1;
        goto L3
    L7:
        if (cr.binding.service.app.mServices != this) goto L9;
        isSameProcess = true;
        goto L10
    }

    void setHasAboveClient(boolean hasAboveClient) {
        this.mHasAboveClient = hasAboveClient;
    }

    boolean hasAboveClient() {
        return this.mHasAboveClient;
    }

    int modifyRawOomAdj(int adj) {
        if (this.mHasAboveClient == false) goto L25;
        if (adj >= 0) goto L7;
        return adj;
    L7:
        if (adj >= 100) goto L10;
        return 100;
    L10:
        if (adj >= 200) goto L13;
        return 200;
    L13:
        if (adj >= 250) goto L16;
        return 250;
    L16:
        if (adj >= 500) goto L19;
        return 500;
    L19:
        if (adj >= 900) goto L22;
        return 900;
    L22:
        if (adj < 999) goto L24;
        return adj;
    L24:
        return adj + 1;
    L25:
        return adj;
    }

    boolean isTreatedLikeActivity() {
        return this.mTreatLikeActivity;
    }

    void setTreatLikeActivity(boolean treatLikeActivity) {
        this.mTreatLikeActivity = treatLikeActivity;
    }

    boolean shouldExecServicesFg() {
        return this.mExecServicesFg;
    }

    void setExecServicesFg(boolean execServicesFg) {
        this.mExecServicesFg = execServicesFg;
    }

    boolean startService(ServiceRecord record) {
        if (record != null) goto L5;
        return false;
    L5:
        boolean added = this.mServices.add(record);
        if (added == false) goto L11;
        if (record.serviceInfo == null) goto L11;
        this.mApp.getWindowProcessController().onServiceStarted(record.serviceInfo);
        updateHostingComonentTypeForBindingsLocked();
    L11:
        if (record.lastTopAlmostPerceptibleBindRequestUptimeMs <= 0) goto L15;
        this.mLastTopStartedAlmostPerceptibleBindRequestUptimeMs = Math.max(this.mLastTopStartedAlmostPerceptibleBindRequestUptimeMs, record.lastTopAlmostPerceptibleBindRequestUptimeMs);
        if (this.mHasTopStartedAlmostPerceptibleServices == true) goto L15;
        this.mHasTopStartedAlmostPerceptibleServices = isAlmostPerceptible(record);
    L15:
        return added;
    }

    boolean stopService(ServiceRecord record) {
        boolean removed = this.mServices.remove(record);
        if (record.lastTopAlmostPerceptibleBindRequestUptimeMs <= 0) goto L5;
        updateHasTopStartedAlmostPerceptibleServices();
    L5:
        if (removed == false) goto L7;
        updateHostingComonentTypeForBindingsLocked();
    L7:
        return removed;
    }

    void stopAllServices() {
        this.mServices.clear();
        updateHasTopStartedAlmostPerceptibleServices();
    }

    int numberOfRunningServices() {
        return this.mServices.size();
    }

    ServiceRecord getRunningServiceAt(int index) {
        return this.mServices.valueAt(index);
    }

    void startExecutingService(ServiceRecord service) {
        this.mExecutingServices.add(service);
    }

    void stopExecutingService(ServiceRecord service) {
        this.mExecutingServices.remove(service);
    }

    void stopAllExecutingServices() {
        this.mExecutingServices.clear();
    }

    ServiceRecord getExecutingServiceAt(int index) {
        return this.mExecutingServices.valueAt(index);
    }

    int numberOfExecutingServices() {
        return this.mExecutingServices.size();
    }

    void addConnection(ConnectionRecord connection) {
        this.mConnections.add(connection);
        addSdkSandboxConnectionIfNecessary(connection);
    }

    void removeConnection(ConnectionRecord connection) {
        this.mConnections.remove(connection);
        removeSdkSandboxConnectionIfNecessary(connection);
    }

    void removeAllConnections() {
        int i = 0;
        int size = this.mConnections.size();
    L3:
        if (i >= size) goto L5;
        removeSdkSandboxConnectionIfNecessary(this.mConnections.valueAt(i));
        i = i + 1;
        goto L3
    L5:
        this.mConnections.clear();
    }

    ConnectionRecord getConnectionAt(int index) {
        return this.mConnections.valueAt(index);
    }

    int numberOfConnections() {
        return this.mConnections.size();
    }

    private void addSdkSandboxConnectionIfNecessary(ConnectionRecord connection) {
        ProcessRecord attributedClient = connection.binding.attributedClient;
        if (attributedClient != null) goto L5;
        return;
    L5:
        if (connection.binding.service.isSdkSandbox == true) goto L7;
        return;
    L7:
        if (attributedClient.mServices.mSdkSandboxConnections != null) goto L9;
        ProcessServiceRecord r1 = attributedClient.mServices;
        r1.mSdkSandboxConnections = new ArraySet();
    L9:
        attributedClient.mServices.mSdkSandboxConnections.add(connection);
    }

    private void removeSdkSandboxConnectionIfNecessary(ConnectionRecord connection) {
        ProcessRecord attributedClient = connection.binding.attributedClient;
        if (attributedClient != null) goto L5;
        return;
    L5:
        if (connection.binding.service.isSdkSandbox == true) goto L7;
        return;
    L7:
        if (attributedClient.mServices.mSdkSandboxConnections == null) goto L12;
        attributedClient.mServices.mSdkSandboxConnections.remove(connection);
        return;
    }

    void removeAllSdkSandboxConnections() {
        if (this.mSdkSandboxConnections == null) goto L6;
        this.mSdkSandboxConnections.clear();
        return;
    }

    ConnectionRecord getSdkSandboxConnectionAt(int index) {
        if (this.mSdkSandboxConnections != null) goto L7;
        return null;
    L7:
        return this.mSdkSandboxConnections.valueAt(index);
    }

    int numberOfSdkSandboxConnections() {
        if (this.mSdkSandboxConnections != null) goto L7;
        return 0;
    L7:
        return this.mSdkSandboxConnections.size();
    }

    void addBoundClientUid(int clientUid, String clientPackageName, long bindFlags) {
        this.mBoundClientUids.add(Integer.valueOf(clientUid));
        this.mApp.getWindowProcessController().addBoundClientUid(clientUid, clientPackageName, bindFlags);
    }

    void updateBoundClientUids() {
        clearBoundClientUids();
        if (this.mServices.isEmpty() == false) goto L5;
        return;
    L5:
        ArraySet<Integer> boundClientUids = new ArraySet();
        int serviceCount = this.mServices.size();
        WindowProcessController controller = this.mApp.getWindowProcessController();
        int j = 0;
    L6:
        if (j >= serviceCount) goto L15;
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> conns = this.mServices.valueAt(j).getConnections();
        int size = conns.size();
        int conni = 0;
    L8:
        if (conni >= size) goto L14;
        ArrayList<ConnectionRecord> c = conns.valueAt(conni);
        int i = 0;
    L11:
        if (i >= c.size()) goto L13;
        ConnectionRecord cr = c.get(i);
        boundClientUids.add(Integer.valueOf(cr.clientUid));
        controller.addBoundClientUid(cr.clientUid, cr.clientPackageName, cr.getFlags());
        i = i + 1;
        goto L11
    L13:
        conni = conni + 1;
        goto L8
    L14:
        j = j + 1;
        goto L6
    L15:
        this.mBoundClientUids = boundClientUids;
    }

    void addBoundClientUidsOfNewService(ServiceRecord sr) {
        if (sr != null) goto L4;
        return;
    L4:
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> conns = sr.getConnections();
        int conni = conns.size() - 1;
    L5:
        if (conni < 0) goto L12;
        ArrayList<ConnectionRecord> c = conns.valueAt(conni);
        int i = 0;
    L8:
        if (i >= c.size()) goto L10;
        ConnectionRecord cr = c.get(i);
        this.mBoundClientUids.add(Integer.valueOf(cr.clientUid));
        this.mApp.getWindowProcessController().addBoundClientUid(cr.clientUid, cr.clientPackageName, cr.getFlags());
        i = i + 1;
        goto L8
    L10:
        conni = conni - 1;
        goto L5
    }

    void clearBoundClientUids() {
        this.mBoundClientUids.clear();
        this.mApp.getWindowProcessController().clearBoundClientUids();
    }

    void updateHostingComonentTypeForBindingsLocked() {
        boolean hasBoundClient = false;
        int i = numberOfRunningServices() - 1;
    L3:
        if (i < 0) goto L11;
        ServiceRecord sr = getRunningServiceAt(i);
        if (sr == null) goto L9;
        if (sr.getConnections().isEmpty() == true) goto L9;
        hasBoundClient = true;
    L9:
        i = i - 1;
    L11:
        if (hasBoundClient == false) goto L13;
        this.mApp.mProfile.addHostingComponentType(512);
        return;
    L13:
        this.mApp.mProfile.clearHostingComponentType(512);
    }

    boolean incServiceCrashCountLocked(long now) {
        if (this.mApp.mState.getCurProcState() != 5) goto L5;
        boolean procIsBoundForeground = true;
    L6:
        boolean tryAgain = false;
        int i = numberOfRunningServices() - 1;
    L7:
        if (i < 0) goto L20;
        ServiceRecord sr = getRunningServiceAt(i);
        if (now <= (sr.restartTime + ((long) ActivityManagerConstants.MIN_CRASH_INTERVAL))) goto L11;
        sr.crashCount = 1;
    L13:
        if (sr.crashCount >= this.mService.mConstants.BOUND_SERVICE_MAX_CRASH_RETRY) goto L18;
        if (sr.isForeground == true) goto L17;
        if (procIsBoundForeground == false) goto L18;
    L17:
        tryAgain = true;
    L18:
        i = i - 1;
        goto L7
    L11:
        sr.crashCount++;
        goto L13
    L20:
        return tryAgain;
    L5:
        procIsBoundForeground = false;
        goto L6
    }

    void onCleanupApplicationRecordLocked() {
        this.mTreatLikeActivity = false;
        this.mHasAboveClient = false;
        setHasClientActivities(false);
    }

    void noteScheduleServiceTimeoutPending(boolean pending) {
        this.mScheduleServiceTimeoutPending = pending;
    }

    boolean isScheduleServiceTimeoutPending() {
        return this.mScheduleServiceTimeoutPending;
    }

    void onProcessUnfrozen() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        scheduleServiceTimeoutIfNeededLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void onProcessFrozenCancelled() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        scheduleServiceTimeoutIfNeededLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void scheduleServiceTimeoutIfNeededLocked() {
        if (this.mScheduleServiceTimeoutPending == true) goto L5;
        return;
    L5:
        if (this.mExecutingServices.size() <= 0) goto L11;
        this.mService.mServices.scheduleServiceTimeoutLocked(this.mApp);
        long now = SystemClock.uptimeMillis();
        int i = 0;
        int size = this.mExecutingServices.size();
    L7:
        if (i >= size) goto L12;
        this.mExecutingServices.valueAt(i).executingStart = now;
        i = i + 1;
        goto L7
    L12:
        return;
    }

    void dump(PrintWriter pw, String prefix, long nowUptime) {
        if (this.mHasForegroundServices == false) goto L5;
    L6:
        pw.print(prefix);
        pw.print("mHasForegroundServices=");
        pw.print(this.mHasForegroundServices);
        pw.print(" forcingToImportant=");
        pw.println(this.mApp.mState.getForcingToImportant());
        pw.print(" mFgServiceTypes=");
        pw.println(this.mFgServiceTypes);
    L8:
        if (this.mHasTopStartedAlmostPerceptibleServices == false) goto L10;
    L11:
        pw.print(prefix);
        pw.print("mHasTopStartedAlmostPerceptibleServices=");
        pw.print(this.mHasTopStartedAlmostPerceptibleServices);
        pw.print(" mLastTopStartedAlmostPerceptibleBindRequestUptimeMs=");
        pw.println(this.mLastTopStartedAlmostPerceptibleBindRequestUptimeMs);
    L13:
        if (this.mHasClientActivities == false) goto L15;
    L18:
        pw.print(prefix);
        pw.print("hasClientActivities=");
        pw.print(this.mHasClientActivities);
        pw.print(" hasAboveClient=");
        pw.print(this.mHasAboveClient);
        pw.print(" treatLikeActivity=");
        pw.println(this.mTreatLikeActivity);
    L20:
        if (this.mConnectionService == null) goto L22;
    L23:
        pw.print(prefix);
        pw.print("connectionGroup=");
        pw.print(this.mConnectionGroup);
        pw.print(" Importance=");
        pw.print(this.mConnectionImportance);
        pw.print(" Service=");
        pw.println(this.mConnectionService);
    L25:
        if (this.mAllowlistManager == false) goto L28;
        pw.print(prefix);
        pw.print("allowlistManager=");
        pw.println(this.mAllowlistManager);
    L28:
        if (this.mServices.size() <= 0) goto L33;
        pw.print(prefix);
        pw.println("Services:");
        int i = 0;
        int size = this.mServices.size();
    L30:
        if (i >= size) goto L33;
        pw.print(prefix);
        pw.print("  - ");
        pw.println(this.mServices.valueAt(i));
        i = i + 1;
    L33:
        if (this.mExecutingServices.size() <= 0) goto L38;
        pw.print(prefix);
        pw.print("Executing Services (fg=");
        pw.print(this.mExecServicesFg);
        pw.println(")");
        int i2 = 0;
        int size2 = this.mExecutingServices.size();
    L35:
        if (i2 >= size2) goto L38;
        pw.print(prefix);
        pw.print("  - ");
        pw.println(this.mExecutingServices.valueAt(i2));
        i2 = i2 + 1;
    L38:
        if (this.mConnections.size() <= 0) goto L42;
        pw.print(prefix);
        pw.println("mConnections:");
        int i3 = 0;
        int size3 = this.mConnections.size();
    L40:
        if (i3 >= size3) goto L42;
        pw.print(prefix);
        pw.print("  - ");
        pw.println(this.mConnections.valueAt(i3));
        i3 = i3 + 1;
    L42:
        pw.print(prefix);
        pw.print("scheduleServiceTimeoutPending=");
        pw.println(this.mScheduleServiceTimeoutPending);
        return;
    L22:
        if (this.mConnectionGroup == 0) goto L25;
    L15:
        if (this.mHasAboveClient == true) goto L18;
        if (this.mTreatLikeActivity == false) goto L20;
    L10:
        if (this.mLastTopStartedAlmostPerceptibleBindRequestUptimeMs <= 0) goto L13;
    L5:
        if (this.mApp.mState.getForcingToImportant() == null) goto L8;
        goto L6
    }

    public ArraySet<ConnectionRecord> getConnections() {
        return this.mConnections;
    }
}
