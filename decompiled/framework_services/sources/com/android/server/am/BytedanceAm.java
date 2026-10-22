package com.android.server.am;

import android.app.IApplicationThread;
import android.os.IBinder;
import android.os.Parcel;
import android.provider.Settings;
import com.android.server.usb.descriptors.UsbTerminalTypes;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class BytedanceAm {

    public static class BytedanceAmUtils {
        public static int FEAT_SCENE_ADJUST_FREQ_SWITCH_OFFSET;
        private static BytedanceAmUtils mInstance;
        private ActivityManagerService mActivityService;

        static {
            mInstance = new BytedanceAmUtils();
            FEAT_SCENE_ADJUST_FREQ_SWITCH_OFFSET = 0;
        }

        private BytedanceAmUtils() {
        }

        public static BytedanceAmUtils getInstance() {
            return mInstance;
        }

        public void initService(ActivityManagerService service) {
            this.mActivityService = service;
        }

        public void notifyClientsMonitorStatsChanged(boolean open) {
            ActivityManagerService r0 = this.mActivityService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Iterator<ProcessRecord> r1 = this.mActivityService.mProcessList.getLruProcessesLOSP().iterator();     // Catch: Throwable -> L15
        L6:
            if (r1.hasNext() == false) goto L19;
            ProcessRecord proc = r1.next();     // Catch: Throwable -> L15
            IApplicationThread thread = proc.getThread();     // Catch: Throwable -> L15
            if (thread == null) goto L6;
            IBinder binder = thread.asBinder();     // Catch: Throwable -> L15 Exception -> L17
            Parcel data = Parcel.obtain();     // Catch: Throwable -> L15 Exception -> L17
            if (open == false) goto L12;
            int r7 = 1;
        L13:
            data.writeInt(r7);     // Catch: Throwable -> L15 Exception -> L17
            binder.transact(1021, data, null, 1);     // Catch: Throwable -> L15 Exception -> L17
            goto L6
        L12:
            r7 = 0;
            goto L13
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L15
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L15:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        public void notifyClientsEnableMonitorBinderTrans(boolean enable, int mode) {
            ActivityManagerService r0 = this.mActivityService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Iterator<ProcessRecord> r1 = this.mActivityService.mProcessList.getLruProcessesLOSP().iterator();     // Catch: Throwable -> L15
        L6:
            if (r1.hasNext() == false) goto L19;
            ProcessRecord proc = r1.next();     // Catch: Throwable -> L15
            IApplicationThread thread = proc.getThread();     // Catch: Throwable -> L15
            if (thread == null) goto L6;
            IBinder binder = thread.asBinder();     // Catch: Throwable -> L15 Exception -> L17
            Parcel data = Parcel.obtain();     // Catch: Throwable -> L15 Exception -> L17
            if (enable == false) goto L12;
            int r7 = 1;
        L13:
            data.writeInt(r7);     // Catch: Throwable -> L15 Exception -> L17
            data.writeInt(mode);     // Catch: Throwable -> L15 Exception -> L17
            binder.transact(1023, data, null, 1);     // Catch: Throwable -> L15 Exception -> L17
            goto L6
        L12:
            r7 = 0;
            goto L13
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L15
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L15:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        public void logClientsBinderTrans(int maxUid, int mode) {
            ActivityManagerService r0 = this.mActivityService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Iterator<ProcessRecord> r1 = this.mActivityService.mProcessList.getLruProcessesLOSP().iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L15;
            ProcessRecord proc = r1.next();     // Catch: Throwable -> L11
            IApplicationThread thread = proc.getThread();     // Catch: Throwable -> L11
            if (thread == null) goto L6;
            IBinder binder = thread.asBinder();     // Catch: Throwable -> L11 Exception -> L13
            Parcel data = Parcel.obtain();     // Catch: Throwable -> L11 Exception -> L13
            data.writeInt(maxUid);     // Catch: Throwable -> L11 Exception -> L13
            data.writeInt(mode);     // Catch: Throwable -> L11 Exception -> L13
            binder.transact(1024, data, null, 1);     // Catch: Throwable -> L11 Exception -> L13
            goto L6
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        public void openAppMainThreadLooperTrace(String packageName) {
            ActivityManagerService r0 = this.mActivityService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Iterator<ProcessRecord> r1 = this.mActivityService.mProcessList.getLruProcessesLOSP().iterator();     // Catch: Throwable -> L15
        L6:
            if (r1.hasNext() == false) goto L19;
            ProcessRecord proc = r1.next();     // Catch: Throwable -> L15
            if (packageName == null) goto L6;
            if (packageName.equals(proc.info.packageName) == false) goto L6;
            IApplicationThread thread = proc.getThread();     // Catch: Throwable -> L15
            if (thread == null) goto L6;
            IBinder binder = thread.asBinder();     // Catch: Throwable -> L15 Exception -> L17
            Parcel data = Parcel.obtain();     // Catch: Throwable -> L15 Exception -> L17
            binder.transact(UsbTerminalTypes.TERMINAL_BIDIR_HANDSET, data, null, 1);     // Catch: Throwable -> L15 Exception -> L17
            goto L6
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L15
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L15:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        public void openAppMainThreadLooperMonitor(int pid) {
            ActivityManagerService r0 = this.mActivityService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Iterator<ProcessRecord> r1 = this.mActivityService.mProcessList.getLruProcessesLOSP().iterator();     // Catch: Throwable -> L13
        L6:
            if (r1.hasNext() == false) goto L17;
            ProcessRecord proc = r1.next();     // Catch: Throwable -> L13
            if (pid != proc.getPid()) goto L6;
            IApplicationThread thread = proc.getThread();     // Catch: Throwable -> L13
            if (thread == null) goto L6;
            IBinder binder = thread.asBinder();     // Catch: Throwable -> L13 Exception -> L15
            Parcel data = Parcel.obtain();     // Catch: Throwable -> L13 Exception -> L15
            binder.transact(UsbTerminalTypes.TERMINAL_BIDIR_HEADSET, data, null, 1);     // Catch: Throwable -> L13 Exception -> L15
            goto L6
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L13
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        public void getAppMainSlowOperations(int pid, int index) {
            ActivityManagerService r0 = this.mActivityService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Iterator<ProcessRecord> r1 = this.mActivityService.mProcessList.getLruProcessesLOSP().iterator();     // Catch: Throwable -> L13
        L6:
            if (r1.hasNext() == false) goto L17;
            ProcessRecord proc = r1.next();     // Catch: Throwable -> L13
            if (pid != proc.getPid()) goto L6;
            IApplicationThread thread = proc.getThread();     // Catch: Throwable -> L13
            if (thread == null) goto L6;
            IBinder binder = thread.asBinder();     // Catch: Throwable -> L13 Exception -> L15
            Parcel data = Parcel.obtain();     // Catch: Throwable -> L13 Exception -> L15
            data.writeInt(index);     // Catch: Throwable -> L13 Exception -> L15
            binder.transact(UsbTerminalTypes.TERMINAL_BIDIR_SKRPHONE, data, null, 1);     // Catch: Throwable -> L13 Exception -> L15
            goto L6
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L13
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        public void notifySwitchState(int offset, boolean enable) {
            ActivityManagerService r0 = this.mActivityService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Iterator<ProcessRecord> r1 = this.mActivityService.mProcessList.getLruProcessesLOSP().iterator();     // Catch: Throwable -> L15
        L6:
            if (r1.hasNext() == false) goto L19;
            ProcessRecord proc = r1.next();     // Catch: Throwable -> L15
            IApplicationThread thread = proc.getThread();     // Catch: Throwable -> L15
            if (thread == null) goto L6;
            IBinder binder = thread.asBinder();     // Catch: Throwable -> L15 Exception -> L17
            Parcel data = Parcel.obtain();     // Catch: Throwable -> L15 Exception -> L17
            data.writeInt(offset);     // Catch: Throwable -> L15 Exception -> L17
            if (enable == false) goto L12;
            int r7 = 1;
        L13:
            data.writeInt(r7);     // Catch: Throwable -> L15 Exception -> L17
            binder.transact(1032, data, null, 1);     // Catch: Throwable -> L15 Exception -> L17
            goto L6
        L12:
            r7 = 0;
            goto L13
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L15
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L15:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        public void putIntToSettings(String key, int value) {
            if (this.mActivityService != null) goto L5;
            return;
        L5:
            Settings.System.putInt(this.mActivityService.mContext.getContentResolver(), key, value);
        }

        public int getIntFromSettings(String key, int defaultValue) {
            if (this.mActivityService != null) goto L6;
            return defaultValue;
        L6:
            return Settings.System.getInt(this.mActivityService.mContext.getContentResolver(), key, defaultValue);
        }

        public void putLongToSettings(String key, long value) {
            if (this.mActivityService != null) goto L5;
            return;
        L5:
            Settings.System.putLong(this.mActivityService.mContext.getContentResolver(), key, value);
        }

        public long getLongFromSettings(String key, long defaultValue) {
            if (this.mActivityService != null) goto L6;
            return defaultValue;
        L6:
            return Settings.System.getLong(this.mActivityService.mContext.getContentResolver(), key, defaultValue);
        }

        public void putStringToSettings(String key, String value) {
            if (this.mActivityService != null) goto L5;
            return;
        L5:
            Settings.System.putString(this.mActivityService.mContext.getContentResolver(), key, value);
        }

        public String getStringFromSettings(String key) {
            if (this.mActivityService != null) goto L7;
            return null;
        L7:
            return Settings.System.getString(this.mActivityService.mContext.getContentResolver(), key);
        }
    }

    public BytedanceAm() {
    }
}
