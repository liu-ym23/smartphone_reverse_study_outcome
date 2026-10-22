package com.android.server.am;

import android.content.ComponentName;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.IntArray;
import android.util.LongArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.internal.util.FrameworkStatsLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundServiceTypeLoggerModule {
    public static final int FGS_API_BEGIN_WITH_FGS = 1;
    public static final int FGS_API_END_WITHOUT_FGS = 3;
    public static final int FGS_API_END_WITH_FGS = 2;
    public static final int FGS_API_PAUSE = 4;
    public static final int FGS_API_RESUME = 5;
    public static final int FGS_STATE_CHANGED_API_CALL = 4;
    private static final String TAG = "ForegroundServiceTypeLoggerModule";
    private final SparseArray<UidState> mUids;

    private static class FgsApiRecord {
        ServiceRecord mAssociatedFgsRecord;
        boolean mIsAssociatedWithFgs;
        final String mPackageName;
        final int mPid;
        final long mTimeStart;
        int mType;
        final int mUid;

        FgsApiRecord(int uid, int pid, String packageName, int type, long timeStart) {
            this.mUid = uid;
            this.mPid = pid;
            this.mPackageName = packageName;
            this.mType = type;
            this.mTimeStart = timeStart;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FgsApiState {
    }

    private static class UidState {
        final SparseArray<FgsApiRecord> mApiClosedCalls;
        final SparseArray<FgsApiRecord> mApiOpenCalls;
        final SparseArray<Long> mFirstFgsTimeStamp;
        final SparseArray<Long> mLastFgsTimeStamp;
        final SparseIntArray mOpenWithFgsCount;
        final SparseIntArray mOpenedWithoutFgsCount;
        final SparseArray<ArrayMap<ComponentName, ServiceRecord>> mRunningFgs;

        /* synthetic */ UidState(ForegroundServiceTypeLoggerModuleIA r1) {
            this();
        }

        private UidState() {
            this.mApiOpenCalls = new SparseArray();
            this.mApiClosedCalls = new SparseArray();
            this.mOpenedWithoutFgsCount = new SparseIntArray();
            this.mOpenWithFgsCount = new SparseIntArray();
            this.mRunningFgs = new SparseArray();
            this.mLastFgsTimeStamp = new SparseArray();
            this.mFirstFgsTimeStamp = new SparseArray();
        }
    }

    public ForegroundServiceTypeLoggerModule() {
        this.mUids = new SparseArray();
    }

    public void logForegroundServiceStart(int uid, int pid, ServiceRecord record) {
        ServiceRecord r1 = record;
        if (r1.getComponentName() == null) goto L5;
        String traceTag = r1.getComponentName().flattenToString() + ":" + uid;
        Trace.asyncTraceForTrackBegin(64, traceTag, "foregroundService", r1.foregroundServiceType);
    L5:
        UidState uidState = this.mUids.get(uid);
        if (uidState != null) goto L8;
        UidState uidState2 = new UidState(null);
        this.mUids.put(uid, uidState2);
        UidState uidState3 = uidState2;
    L9:
        IntArray apiTypes = convertFgsTypeToApiTypes(r1.foregroundServiceType);
        if (apiTypes.size() != 0) goto L12;
        Slog.w(TAG, "Foreground service start for UID: " + uid + " does not have any types");
    L12:
        IntArray apiTypesFound = new IntArray();
        LongArray timestampsFound = new LongArray();
        int i = 0;
        int size = apiTypes.size();
    L13:
        if (i >= size) goto L21;
        int apiType = apiTypes.get(i);
        int fgsIndex = uidState3.mRunningFgs.indexOfKey(apiType);
        if (fgsIndex >= 0) goto L17;
        uidState3.mRunningFgs.put(apiType, new ArrayMap());
        fgsIndex = uidState3.mRunningFgs.indexOfKey(apiType);
        uidState3.mFirstFgsTimeStamp.put(apiType, Long.valueOf(System.currentTimeMillis()));
    L17:
        ArrayMap<ComponentName, ServiceRecord> fgsList = uidState3.mRunningFgs.valueAt(fgsIndex);
        fgsList.put(r1.getComponentName(), r1);
        if (uidState3.mApiOpenCalls.contains(apiType) == false) goto L20;
        uidState3.mOpenWithFgsCount.put(apiType, uidState3.mOpenedWithoutFgsCount.get(apiType));
        uidState3.mOpenedWithoutFgsCount.put(apiType, 0);
        apiTypesFound.add(apiType);
        FgsApiRecord call = uidState3.mApiOpenCalls.get(apiType);
        timestampsFound.add(call.mTimeStart);
        call.mIsAssociatedWithFgs = true;
        call.mAssociatedFgsRecord = r1;
        uidState3.mApiOpenCalls.remove(apiType);
    L20:
        i = i + 1;
        goto L13
    L21:
        int i2 = apiTypesFound.size();
        if (i2 == 0) goto L26;
        int size2 = apiTypesFound.size();
        int i3 = 0;
    L24:
        if (i3 >= size2) goto L31;
        logFgsApiEvent(r1, 4, 1, apiTypesFound.get(i3), timestampsFound.get(i3));
        i3 = i3 + 1;
        r1 = record;
        goto L24
    L31:
        return;
    L26:
        return;
    L8:
        uidState3 = uidState;
        goto L9
    }

    public void logForegroundServiceStop(int uid, ServiceRecord record) {
        ServiceRecord r1 = record;
        if (r1.getComponentName() == null) goto L5;
        String traceTag = r1.getComponentName().flattenToString() + ":" + uid;
        Trace.asyncTraceForTrackEnd(64, traceTag, r1.hashCode());
    L5:
        IntArray apiTypes = convertFgsTypeToApiTypes(r1.foregroundServiceType);
        UidState uidState = this.mUids.get(uid);
        if (apiTypes.size() != 0) goto L9;
        Slog.w(TAG, "FGS stop call for: " + uid + " has no types!");
    L9:
        if (uidState != null) goto L12;
        Slog.w(TAG, "FGS stop call being logged with no start call for UID for UID " + uid + " in package " + r1.packageName);
        return;
    L12:
        ArrayList<Integer> apisFound = new ArrayList();
        ArrayList<Long> timestampsFound = new ArrayList();
        int i = 0;
        int size = apiTypes.size();
    L13:
        if (i >= size) goto L30;
        int apiType = apiTypes.get(i);
        ArrayMap<ComponentName, ServiceRecord> runningFgsOfType = uidState.mRunningFgs.get(apiType);
        if (runningFgsOfType != null) goto L17;
        Slog.w(TAG, "Could not find appropriate running FGS for FGS stop for UID " + uid + " in package " + r1.packageName);
    L28:
        i = i + 1;
        r1 = record;
        goto L13
    L17:
        runningFgsOfType.remove(r1.getComponentName());
        if (runningFgsOfType.size() != 0) goto L20;
        uidState.mRunningFgs.remove(apiType);
        uidState.mLastFgsTimeStamp.put(apiType, Long.valueOf(System.currentTimeMillis()));
    L20:
        int apiTypeIndex = uidState.mOpenWithFgsCount.indexOfKey(apiType);
        if (apiTypeIndex >= 0) goto L23;
        Slog.w(TAG, "Logger should be tracking FGS types correctly for UID " + uid + " in package " + r1.packageName);
        goto L28
    L23:
        FgsApiRecord closedApi = uidState.mApiClosedCalls.get(apiType);
        if (closedApi == null) goto L28;
        if (uidState.mOpenWithFgsCount.valueAt(apiTypeIndex) != 0) goto L28;
        apisFound.add(Integer.valueOf(apiType));
        timestampsFound.add(Long.valueOf(closedApi.mTimeStart));
        uidState.mApiClosedCalls.remove(apiType);
        goto L28
    L30:
        if (apisFound.isEmpty() == true) goto L35;
        int i2 = 0;
    L33:
        if (i2 >= apisFound.size()) goto L43;
        logFgsApiEvent(record, 4, 2, apisFound.get(i2).intValue(), timestampsFound.get(i2).longValue());
        i2 = i2 + 1;
        goto L33
    L43:
        return;
    }

    public long logForegroundServiceApiEventBegin(int apiType, int uid, int pid, String packageName) {
        FgsApiRecord callStart = new FgsApiRecord(uid, pid, packageName, apiType, System.currentTimeMillis());
        UidState uidState = this.mUids.get(uid);
        if (uidState != null) goto L6;
        uidState = new UidState(null);
        this.mUids.put(uid, uidState);
    L6:
        if (hasValidActiveFgs(uid, apiType) == true) goto L17;
        int openWithoutFgsCountIndex = uidState.mOpenedWithoutFgsCount.indexOfKey(apiType);
        if (openWithoutFgsCountIndex >= 0) goto L11;
        uidState.mOpenedWithoutFgsCount.put(apiType, 0);
        openWithoutFgsCountIndex = uidState.mOpenedWithoutFgsCount.indexOfKey(apiType);
    L11:
        if (uidState.mApiOpenCalls.contains(apiType) == true) goto L13;
    L14:
        uidState.mApiOpenCalls.put(apiType, callStart);
    L15:
        uidState.mOpenedWithoutFgsCount.put(apiType, uidState.mOpenedWithoutFgsCount.get(apiType) + 1);
        return callStart.mTimeStart;
    L13:
        if (uidState.mOpenedWithoutFgsCount.valueAt(openWithoutFgsCountIndex) != 0) goto L15;
    L17:
        int openWithFgsIndex = uidState.mOpenWithFgsCount.indexOfKey(apiType);
        if (openWithFgsIndex >= 0) goto L20;
        uidState.mOpenWithFgsCount.put(apiType, 0);
        openWithFgsIndex = uidState.mOpenWithFgsCount.indexOfKey(apiType);
    L20:
        uidState.mOpenWithFgsCount.put(apiType, uidState.mOpenWithFgsCount.valueAt(openWithFgsIndex) + 1);
        ArrayMap<ComponentName, ServiceRecord> fgsListMap = uidState.mRunningFgs.get(apiType);
        long timestamps = callStart.mTimeStart;
        if (uidState.mOpenWithFgsCount.valueAt(openWithFgsIndex) != 1) goto L27;
        Iterator<ServiceRecord> r6 = fgsListMap.values().iterator();
    L24:
        if (r6.hasNext() == false) goto L27;
        ServiceRecord record = r6.next();
        logFgsApiEvent(record, 4, 1, apiType, timestamps);
    L27:
        return callStart.mTimeStart;
    }

    public long logForegroundServiceApiEventEnd(int apiType, int uid, int pid) {
        UidState uidState = this.mUids.get(uid);
        if (uidState != null) goto L6;
        Slog.w(TAG, "API event end called before start!");
        return -1;
    L6:
        int apiIndex = uidState.mOpenWithFgsCount.indexOfKey(apiType);
        if (apiIndex < 0) goto L21;
        if (uidState.mOpenWithFgsCount.get(apiType) == 0) goto L12;
        uidState.mOpenWithFgsCount.put(apiType, uidState.mOpenWithFgsCount.get(apiType) - 1);
    L12:
        if (hasValidActiveFgs(uid, apiType) == true) goto L21;
        if (uidState.mOpenWithFgsCount.get(apiType) != 0) goto L21;
        long timestamp = System.currentTimeMillis();
        logFgsApiEventWithNoFgs(uid, 3, apiType, timestamp);
        uidState.mOpenWithFgsCount.removeAt(apiIndex);
        return timestamp;
    L21:
        if (uidState.mOpenedWithoutFgsCount.indexOfKey(apiType) >= 0) goto L23;
        uidState.mOpenedWithoutFgsCount.put(apiType, 0);
    L23:
        int apiOpenWithoutFgsCount = uidState.mOpenedWithoutFgsCount.get(apiType);
        if (apiOpenWithoutFgsCount == 0) goto L30;
        int apiOpenWithoutFgsCount2 = apiOpenWithoutFgsCount - 1;
        if (apiOpenWithoutFgsCount2 != 0) goto L28;
        uidState.mApiOpenCalls.remove(apiType);
    L28:
        uidState.mOpenedWithoutFgsCount.put(apiType, apiOpenWithoutFgsCount2);
        return System.currentTimeMillis();
    L30:
        SparseArray<FgsApiRecord> r9 = uidState.mApiClosedCalls;
        FgsApiRecord closedCall = new FgsApiRecord(uid, pid, "", apiType, System.currentTimeMillis());
        uidState.mApiClosedCalls.put(apiType, closedCall);
        return closedCall.mTimeStart;
    }

    public void logForegroundServiceApiStateChanged(int apiType, int uid, int pid, int state) {
        UidState uidState = this.mUids.get(uid);
        if (uidState.mRunningFgs.contains(apiType) == true) goto L5;
        return;
    L5:
        ArrayMap<ComponentName, ServiceRecord> fgsRecords = uidState.mRunningFgs.get(apiType);
        long timestamp = System.currentTimeMillis();
        Iterator<ServiceRecord> r9 = fgsRecords.values().iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        ServiceRecord record = r9.next();
        logFgsApiEvent(record, 4, state, apiType, timestamp);
        goto L7
    }

    private IntArray convertFgsTypeToApiTypes(int fgsType) {
        IntArray types = new IntArray();
        if ((fgsType & 64) != 64) goto L6;
        types.add(1);
    L6:
        if ((fgsType & 16) != 16) goto L9;
        types.add(2);
        types.add(8);
        types.add(9);
    L9:
        if ((fgsType & 8) != 8) goto L12;
        types.add(3);
    L12:
        if ((fgsType & 2) != 2) goto L15;
        types.add(5);
        types.add(4);
    L15:
        if ((fgsType & 128) != 128) goto L18;
        types.add(6);
    L18:
        if ((fgsType & 4) != 4) goto L20;
        types.add(7);
    L20:
        return types;
    }

    private boolean hasValidActiveFgs(int uid, int apiType) {
        UidState uidState = this.mUids.get(uid);
        if (uidState != null) goto L5;
        return false;
    L5:
        return uidState.mRunningFgs.contains(apiType);
    }

    public void logFgsApiEvent(ServiceRecord r, int fgsState, int apiState, int apiType, long timestamp) {
        UidState uidState = this.mUids.get(r.appInfo.uid);
        if (uidState != null) goto L6;
        return;
    L6:
        if (uidState.mFirstFgsTimeStamp.contains(apiType) == false) goto L8;
        long apiDurationBeforeFgsStart = uidState.mFirstFgsTimeStamp.get(apiType).longValue() - timestamp;
        long apiDurationBeforeFgsStart2 = apiDurationBeforeFgsStart;
    L10:
        if (uidState.mLastFgsTimeStamp.contains(apiType) == false) goto L12;
        long apiDurationAfterFgsEnd = timestamp - uidState.mLastFgsTimeStamp.get(apiType).longValue();
        long apiDurationAfterFgsEnd2 = apiDurationAfterFgsEnd;
    L13:
        int[] apiTypes = {apiType};
        long[] timeStamps = {timestamp};
        int r9 = r.appInfo.uid;
        String r10 = r.shortInstanceName;
        boolean r12 = r.isFgsAllowedWiu_forCapabilities();
        int r13 = r.getFgsAllowStart();
        int r14 = r.appInfo.targetSdkVersion;
        int r15 = r.mRecentCallingUid;
        if (r.mInfoTempFgsAllowListReason == null) goto L16;
        int r17 = r.mInfoTempFgsAllowListReason.mCallingUid;
    L17:
        boolean r5 = r.mFgsNotificationWasDeferred;
        boolean r11 = r.mFgsNotificationShown;
        int r4 = r.mStartForegroundCount;
        boolean r8 = r.mFgsHasNotificationPermission;
        int r1 = r.foregroundServiceType;
        boolean r2 = r.mIsFgsDelegate;
        if (r.mFgsDelegation == null) goto L20;
        int r27 = r.mFgsDelegation.mOptions.mClientUid;
    L22:
        if (r.mFgsDelegation == null) goto L24;
        int r28 = r.mFgsDelegation.mOptions.mDelegationService;
    L25:
        FrameworkStatsLog.write(60, r9, r10, fgsState, r12, r13, r14, r15, 0, r17, r5, r11, 0, r4, 0, r8, r1, 0, r2, r27, r28, apiState, apiTypes, timeStamps, -1, 0, -1, 0, apiDurationBeforeFgsStart2, apiDurationAfterFgsEnd2, r.mAllowWiu_noBinding, r.mAllowWiu_inBindService, r.mAllowWiu_byBindings, r.mAllowStart_noBinding, r.mAllowStart_inBindService, r.mAllowStart_byBindings, 0, false);
        return;
    L24:
        r28 = 0;
        goto L25
    L20:
        r27 = -1;
        goto L22
    L16:
        r17 = -1;
        goto L17
    L12:
        apiDurationAfterFgsEnd2 = 0;
        goto L13
    L8:
        apiDurationBeforeFgsStart2 = 0;
        goto L10
    }

    public void logFgsApiEventWithNoFgs(int uid, int apiState, int apiType, long timestamp) {
        UidState uidState = this.mUids.get(uid);
        if (uidState != null) goto L6;
        return;
    L6:
        if (uidState.mLastFgsTimeStamp.contains(apiType) == false) goto L8;
        long apiDurationAfterFgsEnd = timestamp - uidState.mLastFgsTimeStamp.get(apiType).longValue();
        long apiDurationAfterFgsEnd2 = apiDurationAfterFgsEnd;
    L9:
        int[] apiTypes = {apiType};
        long[] timeStamps = {timestamp};
        FrameworkStatsLog.write(60, uid, null, 4, false, 0, 0, uid, 0, 0, false, false, 0, 0, 0, false, 0, 0, false, 0, 0, apiState, apiTypes, timeStamps, -1, 0, -1, 0, 0, apiDurationAfterFgsEnd2, 0, 0, 0, 0, 0, 0, 0, false);
        return;
    L8:
        apiDurationAfterFgsEnd2 = 0;
        goto L9
    }
}
