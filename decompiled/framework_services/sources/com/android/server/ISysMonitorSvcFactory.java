package com.android.server;

import com.android.server.am.ActivityManagerService;
import com.android.server.am.IARTLockMonitorRecordUtils;
import com.android.server.am.IAnrMonitor;
import com.android.server.am.IBatteryStatsServiceOptEx;
import com.android.server.am.IBinderMonitor;
import com.android.server.am.IDumpUtils;
import com.android.server.am.IHandleMemoryLeak;
import com.android.server.am.IMemoryStrategy;
import com.android.server.am.IProcessStatsServiceOptEx;
import com.android.server.am.IUploadUtils;
import com.android.server.compilemonitor.ICompileMonitorService;
import com.android.server.pm.profile.ISystemAppProfileCollectionManagerService;
import com.android.server.power.IPowerManagerMonitorEx;
import com.android.server.power.ISmartPowerData;
import com.android.server.power.stats.IBatteryStatsImplOptEx;
import com.android.server.wm.ActivityRecord;
import com.android.server.wm.IActivityLaunchTimeStatistics;
import com.android.server.wm.IInputManagerCallbackEx;

/* JADX INFO: loaded from: classes.dex */
public interface ISysMonitorSvcFactory {
    default IAnrMonitor getAnrMonitor() {
        return new AnonymousClass1(this);
    }

    default IMemoryStrategy getMemoryStrategy() {
        return new AnonymousClass2(this);
    }

    default ISysMonitorService getSysMonitorService() {
        return new AnonymousClass3(this);
    }

    default ISystemAppProfileCollectionManagerService getSystemAppProfileCollectionManagerService() {
        return new AnonymousClass4(this);
    }

    default ICompileMonitorService getCompileMonitorService() {
        return new AnonymousClass5(this);
    }

    default ISmartMonitorController getSmartMonitorController() {
        return new AnonymousClass6(this);
    }

    default ISmartService getSmartService() {
        return new AnonymousClass7(this);
    }

    default IAtraceStatusMonitor getAtraceStatusMonitor() {
        return new AnonymousClass8(this);
    }

    default ITransferController getTransferController() {
        return new AnonymousClass9(this);
    }

    default ISmartAnaly getSmtAnalysis() {
        return new AnonymousClass10(this);
    }

    default ISysPerfMonitorService getSysPerfMonitorService() {
        return new AnonymousClass11(this);
    }

    default IInputManagerCallbackEx getInputManagerEx() {
        return new AnonymousClass12(this);
    }

    default IActivityLaunchTimeStatistics getActivityLaunchTimeStatistics(ActivityRecord record) {
        return new AnonymousClass13(this);
    }

    default IProcessStatsServiceOptEx getProcessStatsServiceOptEx() {
        return new AnonymousClass14(this);
    }

    default ISmartPowerData getSmartPowerDataInstance() {
        return new AnonymousClass15(this);
    }

    default IPowerManagerMonitorEx getPowerManagerMonitor() {
        return new AnonymousClass16(this);
    }

    default IBatteryStatsServiceOptEx getBatteryStatsServiceOptEx() {
        return new AnonymousClass17(this);
    }

    default IBatteryServiceOptEx getBatteryServiceOptEx() {
        return new AnonymousClass18(this);
    }

    default IActivityManagerOptEx getActivityManager(ActivityManagerService service) {
        return new AnonymousClass19(this);
    }

    default IHandleMemoryLeak getHandleMemoryLeak() {
        return new AnonymousClass20(this);
    }

    default IDumpUtils getDumpUtils() {
        return new AnonymousClass21(this);
    }

    default IBinderMonitor getBinderMonitor() {
        return new AnonymousClass22(this);
    }

    default IBatteryStatsImplOptEx getBatteryStatsImpl() {
        return new AnonymousClass23(this);
    }

    default IBootReceiverSmtEx getBootReceiver() {
        return new AnonymousClass24(this);
    }

    default IARTLockMonitorRecordUtils getARTLockMonitorRecordUtils() {
        return new AnonymousClass25(this);
    }

    default IFallocateManager getFallocateManager() {
        return new AnonymousClass26(this);
    }

    default IUploadUtils getUploadUtils() {
        return new AnonymousClass27(this);
    }

    default ISceneMetricsAnalyzer getSceneMetricsAnalyzer() {
        return new AnonymousClass28(this);
    }
}
