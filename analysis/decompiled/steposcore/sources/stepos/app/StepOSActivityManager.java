package stepos.app;

import android.annotation.SystemApi;
import android.app.usage.IStepOSUsageEventListener;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import stepos.app.IStepOSActivityManager;

@SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
/* loaded from: classes.dex */
public class StepOSActivityManager extends StepOSCommonManager {
    private static final String TAG = "StepOSActivityManager";
    protected IStepOSActivityManager mStepOSAm;

    private static final class InstanceHolder {
        private static final StepOSActivityManager INSTANCE = new StepOSActivityManager();

        private InstanceHolder() {
        }
    }

    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    public static StepOSActivityManager get() {
        return InstanceHolder.INSTANCE;
    }

    private StepOSActivityManager() {
        super("activity");
        try {
            if (this.mRemote == null) {
                Log.w(TAG, "mRemote is null, ACTIVITY_SERVICE not available");
            } else {
                IBinder extension = this.mRemote.getExtension();
                this.mStepOSAm = IStepOSActivityManager.Stub.asInterface(extension);
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to init stepos activity manager", e);
        }
    }

    public void test() {
        if (this.mStepOSAm == null) {
            return;
        }
        try {
            this.mStepOSAm.test();
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
        }
    }

    public void registerEventListener(IStepOSUsageEventListener listener) {
        if (this.mStepOSAm == null) {
            return;
        }
        try {
            this.mStepOSAm.registerEventListener(listener);
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
        }
    }

    public void removeEventListener(IStepOSUsageEventListener listener) {
        if (this.mStepOSAm == null) {
            return;
        }
        try {
            this.mStepOSAm.removeEventListener(listener);
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
        }
    }

    public void setApexService(Intent intent) {
        if (this.mStepOSAm == null) {
            return;
        }
        try {
            this.mStepOSAm.setApexService(intent);
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
        }
    }

    public void apexRequest(Intent intent) {
        if (this.mStepOSAm == null) {
            return;
        }
        try {
            this.mStepOSAm.apexRequest(intent);
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
        }
    }

    public boolean setVirtualDisplayCgroupTier(int tier, int displayId) {
        if (this.mStepOSAm == null) {
            return false;
        }
        try {
            return this.mStepOSAm.setVirtualDisplayCgroupTier(tier, displayId);
        } catch (RemoteException e) {
            Log.e(TAG, "setVirtualDisplayCgroupTier", e);
            return false;
        }
    }

    public boolean resetVirtualDisplayCgroupTier(int displayId) {
        if (this.mStepOSAm == null) {
            return false;
        }
        try {
            return this.mStepOSAm.resetVirtualDisplayCgroupTier(displayId);
        } catch (RemoteException e) {
            Log.e(TAG, "resetVirtualDisplayCgroupTier", e);
            return false;
        }
    }

    public boolean isVirtualDisplayCgroupEnabled() {
        if (this.mStepOSAm == null) {
            return false;
        }
        try {
            return this.mStepOSAm.isVirtualDisplayCgroupEnabled();
        } catch (RemoteException e) {
            Log.e(TAG, "isVirtualDisplayCgroupEnabled", e);
            return false;
        }
    }

    public int getVirtualDisplayCgroupTier(int displayId) {
        if (this.mStepOSAm == null) {
            return 0;
        }
        try {
            return this.mStepOSAm.getVirtualDisplayCgroupTier(displayId);
        } catch (RemoteException e) {
            Log.e(TAG, "getVirtualDisplayCgroupTier", e);
            return 0;
        }
    }

    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    public String getProcessNameByUidAndTid(int uid, int tid) {
        if (this.mStepOSAm == null) {
            return null;
        }
        try {
            return this.mStepOSAm.getProcessNameByUidAndTid(uid, tid);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean watchDeathForProcess(int pid, boolean needRemove, String packageName) {
        if (this.mStepOSAm == null) {
            return false;
        }
        try {
            return this.mStepOSAm.watchDeathForProcess(pid, needRemove, packageName);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public long[] getProcessCpuTimes(int[] pids, int[] uids) {
        if (this.mStepOSAm == null) {
            return null;
        }
        try {
            return this.mStepOSAm.getProcessCpuTimes(pids, uids);
        } catch (RemoteException e) {
            Log.e(TAG, "getProcessCpuTimes", e);
            return null;
        }
    }
}
