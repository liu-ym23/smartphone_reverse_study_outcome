package com.android.server.wm;

import android.util.ArraySet;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class WindowProcessControllerMap {
    private final SparseArray<WindowProcessController> mPidMap;
    private final Map<Integer, ArraySet<WindowProcessController>> mUidMap;

    WindowProcessControllerMap() {
        this.mPidMap = new SparseArray();
        this.mUidMap = new HashMap();
    }

    WindowProcessController getProcess(int pid) {
        return this.mPidMap.get(pid);
    }

    ArraySet<WindowProcessController> getProcesses(int uid) {
        return this.mUidMap.get(Integer.valueOf(uid));
    }

    SparseArray<WindowProcessController> getPidMap() {
        return this.mPidMap;
    }

    void put(int pid, WindowProcessController proc) {
        WindowProcessController prevProc = this.mPidMap.get(pid);
        if (prevProc == null) goto L5;
        removeProcessFromUidMap(prevProc);
    L5:
        this.mPidMap.put(pid, proc);
        int uid = proc.mUid;
        ArraySet<WindowProcessController> procSet = this.mUidMap.getOrDefault(Integer.valueOf(uid), new ArraySet());
        procSet.add(proc);
        this.mUidMap.put(Integer.valueOf(uid), procSet);
        proc.updateActivityConfigurationListenerIfNeeded();
    }

    void remove(int pid) {
        WindowProcessController proc = this.mPidMap.get(pid);
        if (proc == null) goto L6;
        this.mPidMap.remove(pid);
        removeProcessFromUidMap(proc);
        proc.destroy();
        return;
    }

    private void removeProcessFromUidMap(WindowProcessController proc) {
        int uid = proc.mUid;
        ArraySet<WindowProcessController> procSet = this.mUidMap.get(Integer.valueOf(uid));
        if (procSet == null) goto L8;
        procSet.remove(proc);
        if (procSet.isEmpty() == false) goto L9;
        this.mUidMap.remove(Integer.valueOf(uid));
        return;
    L9:
        return;
    }
}
