package com.android.server.job.controllers;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.SysOptBridge;
import com.android.server.job.JobSchedulerService;
import com.android.server.pm.PackageManagerService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricJobResourceController extends StateController {
    public static final int CONSTRAINT_ABOVE_BATTERY_LEVEL = 2;
    public static final int CONSTRAINT_BELOW_BATTERY_LEVEL = 4;
    public static final int CONSTRAINT_BELOW_THERMAL = 16;
    public static final int CONSTRAINT_BT_STATE = 32;
    public static final int CONSTRAINT_CHARGING_DURATION_TIME = 8;
    public static final int CONSTRAINT_CHARGING_PLUGGED_TYPE = 64;
    public static final int CONSTRAINT_POWERMODE = 256;
    public static final int CONSTRAINT_SCREEN_STATE = 128;
    public static final int CONSTRAINT_SLEEP_MODE = 1;
    private static final boolean DEBUG = false;
    public static final int OPERATOR_BIT = 8;
    public static final int OPERATOR_BOOL = 7;
    public static final int OPERATOR_EQ = 0;
    public static final int OPERATOR_GREATER = 2;
    public static final int OPERATOR_GREATER_EQ = 1;
    public static final int OPERATOR_LESS = 5;
    public static final int OPERATOR_LESS_EQ = 3;
    public static final int OPERATOR_STR = 6;
    private static final String TAG = "JobScheduler.ObricJobResourceController";
    private final ArraySet<JobStatus> mChangedJobs;
    private boolean mObricJobResourceEnable;
    private PackageManager mPackageManager;
    private final ArrayList<String> mPermissonAllowed;
    private final HashMap<Integer, String> mResourceBitKeyMap;
    private final HashMap<String, ResourceCtrl> mResourceCtrlMap;
    private final ArraySet<JobStatus> mTrackedTasks;
    private final ArrayMap<String, TrackingInstance> mTrackers;

    final class ResourceCtrl {
        int keyBit;
        String keyName;
        int operatorCode;
        Object resourceValue;

        /* synthetic */ ResourceCtrl(ObricJobResourceController r1, String r2, int r3, int r4, ObricJobResourceControllerIA r5) {
            this(r1, r2, r3, r4);
        }

        private ResourceCtrl(ObricJobResourceController this$0, String keyName, int keyBit, int operatorCode) {
            this.keyName = keyName;
            this.keyBit = keyBit;
            this.operatorCode = operatorCode;
        }

        public String getKeyName() {
            return this.keyName;
        }

        public int getKeyBit() {
            return this.keyBit;
        }

        public int getOperatorCode() {
            return this.operatorCode;
        }

        public Object getResourceValue() {
            return this.resourceValue;
        }

        public void setResourceValue(Object obj) {
            this.resourceValue = obj;
        }

        public String toString() {
            return "ResourceCtrl{keyName='" + this.keyName + "', keyBit=" + this.keyBit + ", operatorCode=" + this.operatorCode + ", resourceValue=" + this.resourceValue + '}';
        }
    }

    final class TrackingInstance {
        final ArraySet<ObricJobCondition> mJobs;
        int mKeyBit;
        String mKeyName;
        int mOperatorCode;
        final /* synthetic */ ObricJobResourceController this$0;

        /* synthetic */ TrackingInstance(ObricJobResourceController r1, ResourceCtrl r2, ObricJobResourceControllerIA r3) {
            this(r1, r2);
        }

        private TrackingInstance(ObricJobResourceController this$0, ResourceCtrl resourceCtrl) {
            this.this$0 = this$0;
            this.mJobs = new ArraySet();
            this.mKeyName = resourceCtrl.getKeyName();
            this.mKeyBit = resourceCtrl.getKeyBit();
            this.mOperatorCode = resourceCtrl.getOperatorCode();
            SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().updateRequiredConstraint(this.mKeyBit, true);
        }

        public void addJobStatus(ObricJobCondition obricJobCondition) {
            this.mJobs.add(obricJobCondition);
        }

        public void handleStateChangeLocked(Object objValue) {
            int size = this.mJobs.size();
            int i = 0;
        L3:
            if (i >= size) goto L10;
            ObricJobCondition ojc = this.mJobs.valueAt(i);
            boolean innerConstraintSatisfied = this.this$0.operating(objValue, ojc.mRequiredValueMap.get(this.mKeyName), this.mOperatorCode);
            boolean innerConstraintChanged = ojc.setInnerConstraintSatisfied(this.mKeyBit, innerConstraintSatisfied);
            boolean businessConstraintChanged = ojc.setBusinessConstraintSatisfied(ojc.isObricJobReady());
            if (innerConstraintChanged == false) goto L8;
            if (businessConstraintChanged == false) goto L8;
            ObricJobResourceController.m4992$$Nest$fgetmChangedJobs(this.this$0).add(ojc.mJobStatus);
        L8:
            i = i + 1;
            goto L3
        L10:
            if (ObricJobResourceController.m4992$$Nest$fgetmChangedJobs(this.this$0).isEmpty() == true) goto L12;
            this.this$0.mStateChangedListener.onControllerStateChanged(ObricJobResourceController.m4992$$Nest$fgetmChangedJobs(this.this$0));
        L12:
            ObricJobResourceController.m4992$$Nest$fgetmChangedJobs(this.this$0).clear();
        }

        public void detachLocked() {
            ObricJobResourceController.m4994$$Nest$fgetmTrackers(this.this$0).remove(this.mKeyName);
            ResourceCtrl resourceCtrl = (ResourceCtrl) ObricJobResourceController.m4993$$Nest$fgetmResourceCtrlMap(this.this$0).get(this.mKeyName);
            if (resourceCtrl == null) goto L5;
            resourceCtrl.setResourceValue(null);
        L5:
            Slog.i(ObricJobResourceController.TAG, "detachLocked, KeyName:" + this.mKeyName + ", key: " + this.mKeyBit);
            SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().updateRequiredConstraint(this.mKeyBit, false);
        }

        public String toString() {
            return "{mKeyName='" + this.mKeyName + "', mKeyBit=" + this.mKeyBit + ", mOperatorCode=" + this.mOperatorCode + '}';
        }
    }

    public static /* synthetic */ void $r8$lambda$Phm3GxI08uQS6QfTHlMHCafIsAY(ObricJobResourceController r0, String r1, Object r2) {
        r0.lambda$updateResourceState$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmChangedJobs, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m4992$$Nest$fgetmChangedJobs(ObricJobResourceController r0) {
        return r0.mChangedJobs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmResourceCtrlMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m4993$$Nest$fgetmResourceCtrlMap(ObricJobResourceController r0) {
        return r0.mResourceCtrlMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrackers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m4994$$Nest$fgetmTrackers(ObricJobResourceController r0) {
        return r0.mTrackers;
    }

    static {
        if (JobSchedulerService.DEBUG == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        DEBUG = r0;
        return;
    L5:
        if (Log.isLoggable(TAG, 3) == true) goto L8;
        r0 = false;
        goto L9
    }

    public ObricJobResourceController(JobSchedulerService jobSchedulerService) {
        super(jobSchedulerService);
        this.mObricJobResourceEnable = false;
        this.mPermissonAllowed = new ArrayList();
        this.mTrackedTasks = new ArraySet();
        this.mChangedJobs = new ArraySet();
        this.mTrackers = new ArrayMap();
        this.mResourceCtrlMap = new HashMap();
        this.mResourceBitKeyMap = new HashMap();
        this.mPackageManager = this.mContext.getPackageManager();
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus jobStatus, JobStatus lastJob) {
        if (jobStatus.hasObricBusinessConstraint() == true) goto L5;
    L11:
        if (lastJob != null) goto L13;
        return;
    L13:
        if (lastJob.obricJobCondition == null) goto L17;
        lastJob.obricJobCondition.detachLocked(false);
        lastJob.obricJobCondition = null;
        return;
    L17:
        return;
    L5:
        if (this.mObricJobResourceEnable == true) goto L7;
    L10:
        Slog.i(TAG, "set business satisfied, enable: " + this.mObricJobResourceEnable);
        jobStatus.setObricBusinessConstraintSatisfied(JobSchedulerService.sElapsedRealtimeClock.millis(), true);
        goto L11
    L7:
        if (isPermissionAllow(jobStatus.sourceUid, jobStatus.sourcePackageName) == false) goto L10;
        this.mTrackedTasks.add(jobStatus);
        initBusinessTrackingLocked(jobStatus);
        goto L11
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus jobStatus, JobStatus incomingJob) {
        if (jobStatus.hasObricBusinessConstraint() == false) goto L11;
        this.mTrackedTasks.remove(jobStatus);
        ObricJobCondition obricJobCondition = jobStatus.obricJobCondition;
        if (obricJobCondition == null) goto L12;
        if (incomingJob == null) goto L8;
        boolean r1 = true;
    L9:
        obricJobCondition.detachLocked(r1);
        jobStatus.obricJobCondition = null;
        return;
    L8:
        r1 = false;
        goto L9
    L12:
        return;
    }

    private void initBusinessTrackingLocked(JobStatus jobStatus) {
        if (jobStatus.obricJobCondition != null) goto L5;
        jobStatus.obricJobCondition = new ObricJobCondition(jobStatus, this.mResourceCtrlMap);
    L5:
        ObricJobCondition obricJobCondition = jobStatus.obricJobCondition;
        Iterator<String> r1 = obricJobCondition.mRequiredValueMap.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        String str = r1.next();
        ResourceCtrl resourceCtrl = this.mResourceCtrlMap.get(str);
        TrackingInstance trackingInstance = this.mTrackers.get(str);
        if (trackingInstance != null) goto L11;
        trackingInstance = new TrackingInstance(this, resourceCtrl, null);
        this.mTrackers.put(str, trackingInstance);
    L11:
        trackingInstance.addJobStatus(obricJobCondition);
        obricJobCondition.addTracker(trackingInstance);
        boolean isSatisfied = operating(resourceCtrl.getResourceValue(), obricJobCondition.mRequiredValueMap.get(str), resourceCtrl.getOperatorCode());
        obricJobCondition.setInnerConstraintSatisfied(resourceCtrl.getKeyBit(), isSatisfied);
        goto L7
    L13:
        if (obricJobCondition.mMyTrackings.isEmpty() == false) goto L16;
        obricJobCondition.ignoreBusinessConstraint();
        Slog.i(TAG, "init Business ignore " + obricJobCondition.mSatisfiedConstraints);
    L16:
        if (obricJobCondition.isObricJobReady() == false) goto L22;
        obricJobCondition.setBusinessConstraintSatisfied(true);
        Slog.i(TAG, "set Business constraint satisfied ");
        return;
    }

    public boolean operating(Object curValue, Object requiredValue, int i) {
        if (curValue == null) goto L77;
        if (requiredValue == null) goto L77;
        if ((curValue instanceof Integer) == false) goto L39;
        if ((requiredValue instanceof Integer) == false) goto L39;
        int intCurValue = ((Integer) curValue).intValue();
        int intRequiredValue = ((Integer) requiredValue).intValue();
        if (i != 0) goto L15;
        if (intCurValue == intRequiredValue) goto L14;
        return false;
    L14:
        return true;
    L15:
        if (i != 1) goto L19;
        if (intCurValue >= intRequiredValue) goto L18;
        return false;
    L18:
        return true;
    L19:
        if (i != 2) goto L23;
        if (intCurValue > intRequiredValue) goto L22;
        return false;
    L22:
        return true;
    L23:
        if (i != 3) goto L27;
        if (intCurValue <= intRequiredValue) goto L26;
        return false;
    L26:
        return true;
    L27:
        if (i != 5) goto L31;
        if (intCurValue < intRequiredValue) goto L30;
        return false;
    L30:
        return true;
    L31:
        if (i == 8) goto L33;
        Slog.w(TAG, "error for invalid operator: " + i);
        return false;
    L33:
        if ((intCurValue & intRequiredValue) == intRequiredValue) goto L35;
        return false;
    L35:
        return true;
    L39:
        if ((curValue instanceof Long) == false) goto L76;
        if ((requiredValue instanceof Long) == false) goto L76;
        long intCurValue2 = ((Long) curValue).longValue();
        long intRequiredValue2 = ((Long) requiredValue).longValue();
        if (i == 0) goto L45;
        if (i == 1) goto L50;
        if (i == 2) goto L55;
        if (i == 3) goto L60;
        if (i == 5) goto L65;
        if (i == 8) goto L70;
        Slog.w(TAG, "error for invalid operator: " + i);
        return false;
    L70:
        if ((intCurValue2 & intRequiredValue2) == intRequiredValue2) goto L72;
        return false;
    L72:
        return true;
    L65:
        if (intCurValue2 < intRequiredValue2) goto L67;
        return false;
    L67:
        return true;
    L60:
        if (intCurValue2 <= intRequiredValue2) goto L62;
        return false;
    L62:
        return true;
    L55:
        if (intCurValue2 > intRequiredValue2) goto L57;
        return false;
    L57:
        return true;
    L50:
        if (intCurValue2 >= intRequiredValue2) goto L52;
        return false;
    L52:
        return true;
    L45:
        if (intCurValue2 == intRequiredValue2) goto L47;
        return false;
    L47:
        return true;
    L76:
        return curValue.equals(requiredValue);
    L77:
        return false;
    }

    public void initResourceCtrl(Map<String, Pair<Integer, Integer>> map, List<String> list) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (list != null) goto L24;
    L8:
        if (map != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L6
        return;
    L11:
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r0 = map.entrySet().iterator();     // Catch: Throwable -> L6
    L13:
        if (r0.hasNext() == false) goto L19;
        Map.Entry<String, Pair<Integer, Integer>> entry = r0.next();     // Catch: Throwable -> L6
        String keyName = entry.getKey();     // Catch: Throwable -> L6
        int keyBit = ((Integer) entry.getValue().first).intValue();     // Catch: Throwable -> L6
        int operatorCode = ((Integer) entry.getValue().second).intValue();     // Catch: Throwable -> L6
        HashMap<String, ResourceCtrl> r3 = this.mResourceCtrlMap;     // Catch: Throwable -> L6
        r3.put(keyName, new ResourceCtrl(this, keyName, keyBit, operatorCode, null));     // Catch: Throwable -> L17
        this.mResourceBitKeyMap.put(Integer.valueOf(keyBit), keyName);     // Catch: Throwable -> L17
        goto L13
    L19:
        this.mObricJobResourceEnable = true;     // Catch: Throwable -> L17
        Slog.i(TAG, "initResourceCtrl done");     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L24:
        this.mPermissonAllowed.clear();     // Catch: Throwable -> L6
        this.mPermissonAllowed.addAll(list);     // Catch: Throwable -> L6
    L6:
        th = th;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L17
        throw th;
    L17:
        th = th;
        goto L22
    }

    public void handleBitState(int keyBit, String value) {
        String keyName = this.mResourceBitKeyMap.get(Integer.valueOf(keyBit));
        if (keyName != null) goto L5;
        return;
    L5:
        int operatorCode = this.mResourceCtrlMap.get(keyName).getOperatorCode();
        if (keyBit != 8) goto L9;
        Object objValue = Long.valueOf(value);
    L15:
        updateResourceState(keyName, objValue);
        return;
    L9:
        if (operatorCode != 6) goto L12;
        objValue = value;
        goto L15
    L12:
        if (operatorCode != 7) goto L14;
        objValue = Boolean.valueOf(value);
        goto L15
    L14:
        objValue = Integer.valueOf(value);
        goto L15
    }

    private void updateResourceState(final String keyName, final Object objValue) {
        AppSchedulingModuleThread.getHandler().post(new ObricJobResourceController$$ExternalSyntheticLambda0(this, keyName, objValue));
    }

    private /* synthetic */ void lambda$updateResourceState$0(String keyName, Object objValue) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ResourceCtrl resourceCtrl = this.mResourceCtrlMap.get(keyName);     // Catch: Throwable -> L8
        if (resourceCtrl != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (resourceCtrl.getResourceValue() != null) goto L13;
    L16:
        resourceCtrl.setResourceValue(objValue);     // Catch: Throwable -> L8
        TrackingInstance trackingInstance = this.mTrackers.get(keyName);     // Catch: Throwable -> L8
        if (trackingInstance == null) goto L19;
        trackingInstance.handleStateChangeLocked(objValue);     // Catch: Throwable -> L8
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (resourceCtrl.getResourceValue().equals(objValue) == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isPermissionAllow(int uid, String pkg) {
        if (uid > 10000) goto L5;
    L31:
        return true;
    L5:
        if (this.mPermissonAllowed.contains(pkg) == true) goto L31;
        if (this.mPackageManager != null) goto L32;
        this.mPackageManager = this.mContext.getPackageManager();
    L32:
        ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfo(pkg, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        if (applicationInfo != null) goto L14;
    L18:
        if (applicationInfo == null) goto L26;
        if ((applicationInfo.flags & 128) == 0) goto L26;
        return true;
    L26:
        if (this.mPackageManager.checkSignatures(PackageManagerService.PLATFORM_PACKAGE_NAME, pkg) < 0) goto L29;
        Slog.i(TAG, pkg + " signatures is same as android");
        return true;
    L29:
        Slog.i(TAG, pkg + " has not permission");
        return false;
    L14:
        if ((applicationInfo.flags & 1) == 0) goto L18;
        return true;
    L24:
        Slog.i(TAG, pkg + " get app info error!");
        goto L26
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(IndentingPrintWriter indentingPrintWriter, Predicate<JobStatus> predicate) {
        indentingPrintWriter.println("mWorkResourceState: " + this.mObricJobResourceEnable);
        int i = 0;
    L4:
        if (i >= this.mTrackedTasks.size()) goto L9;
        JobStatus jobStatusValueAt = this.mTrackedTasks.valueAt(i);
        if (predicate.test(jobStatusValueAt) == false) goto L8;
        indentingPrintWriter.print("#");
        jobStatusValueAt.printUniqueId(indentingPrintWriter);
        indentingPrintWriter.print(" from ");
        UserHandle.formatUid(indentingPrintWriter, jobStatusValueAt.getSourceUid());
        indentingPrintWriter.print(": ");
        indentingPrintWriter.print(jobStatusValueAt.getSourcePackageName());
        indentingPrintWriter.println();
        indentingPrintWriter.println("   required: " + jobStatusValueAt.obricJobCondition.mRequiredConstraints + " satisfied: " + jobStatusValueAt.obricJobCondition.mSatisfiedConstraints);
        StringBuilder sb = new StringBuilder();
        sb.append("   requiredValue: ");
        sb.append(jobStatusValueAt.obricJobCondition.mRequiredValueMap);
        indentingPrintWriter.println(sb.toString());
        indentingPrintWriter.println();
    L8:
        i = i + 1;
        goto L4
    L9:
        indentingPrintWriter.println("mTrackers");
        Iterator<Map.Entry<String, TrackingInstance>> r0 = this.mTrackers.entrySet().iterator();
    L11:
        if (r0.hasNext() == false) goto L17;
        Map.Entry<String, TrackingInstance> entry = r0.next();
        indentingPrintWriter.print(" #");
        indentingPrintWriter.println(entry.getValue().toString());
        Iterator<ObricJobCondition> it = entry.getValue().mJobs.iterator();
    L14:
        if (it.hasNext() == false) goto L11;
        ObricJobCondition next = it.next();
        indentingPrintWriter.print("   ");
        indentingPrintWriter.println(next.toString());
        goto L14
    L17:
        indentingPrintWriter.println();
        indentingPrintWriter.println("ResourceValue: ");
        Iterator<Map.Entry<Integer, String>> r1 = this.mResourceBitKeyMap.entrySet().iterator();
    L19:
        if (r1.hasNext() == false) goto L21;
        Map.Entry<Integer, String> entry2 = r1.next();
        indentingPrintWriter.println("  " + entry2.getValue() + " -> " + entry2.getKey());
        goto L19
    L21:
        indentingPrintWriter.println();
        indentingPrintWriter.println("ResourceCtrlMap: ");
        Iterator<Map.Entry<String, ResourceCtrl>> r2 = this.mResourceCtrlMap.entrySet().iterator();
    L23:
        if (r2.hasNext() == false) goto L25;
        Map.Entry<String, ResourceCtrl> entry3 = r2.next();
        indentingPrintWriter.println("   " + entry3.getKey() + " -> " + entry3.getValue());
        goto L23
    L25:
        indentingPrintWriter.println();
    }
}
