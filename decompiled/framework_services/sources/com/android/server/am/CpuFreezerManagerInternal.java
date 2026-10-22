package com.android.server.am;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class CpuFreezerManagerInternal {
    public abstract boolean addFlags(int r1, int r2);

    public abstract boolean checkIsWidgetApp(int r1);

    public abstract void doOptimizeForGMS(int r1);

    public abstract ArrayList<CpuFreezerAppInfo> getCFAppInfos();

    public abstract int[] getCpuFreezerUids();

    public abstract long getFreezeStartTime(int r1);

    public abstract boolean getScreenState();

    public abstract boolean isAppFreezed(int r1);

    public abstract boolean isForceFreezedApp(int r1);

    public abstract boolean isNeedSkipForFrozen(int r1, String r2, boolean r3);

    public abstract void noteCpuFreezerUidStartBg(int r1);

    public abstract void noteCpuFreezerUidStartIdle(int r1);

    public abstract void noteCpuFreezerUidWorking(int r1, boolean r2, String r3);

    public abstract void notifyScreenOffOfPolicy();

    public abstract void notifyUidFreezeResult(int r1, boolean r2);

    public abstract void notifyWakeup();

    public abstract boolean removeFlags(int r1, int r2);

    public abstract boolean setCpuFreezerForPkgName(String r1, int r2, String r3);

    public abstract boolean setCpuFreezerForPkgUid(int r1, int r2, String r3);

    public abstract boolean setForceFreeze(int r1);

    public abstract void setFreezeTypeForDualAPP(boolean r1);

    public CpuFreezerManagerInternal() {
    }
}
