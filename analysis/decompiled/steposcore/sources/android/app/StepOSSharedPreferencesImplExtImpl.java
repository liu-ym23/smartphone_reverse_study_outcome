package android.app;

import android.os.Process;
import android.util.Log;
import com.stepos.perfmain.client.PerfMainClient;

/* loaded from: classes.dex */
public class StepOSSharedPreferencesImplExtImpl implements IStepOSSharedPreferencesImplExt {
    private static final long SVIP_WAIT_THRESHOLD_MS = 5;
    private static final String TAG = "StepOSSharedPreferencesImplExtImpl";
    private SharedPreferencesImpl mHost;
    private volatile int mLoadThreadTid = -1;
    private volatile int mPid = -1;
    private int mSvipPid = -1;
    private int mSvipTid = -1;
    private PerfMainClient mClient = new PerfMainClient();

    public void onAttach(SharedPreferencesImpl host) {
        this.mHost = host;
    }

    public void onDetach() {
        this.mHost = null;
    }

    public void notifyStartLoad() {
        this.mLoadThreadTid = Process.myTid();
        this.mPid = Process.myPid();
    }

    boolean setOrClearSvip(boolean isSet, int pid, int tid) {
        int result;
        try {
        } catch (Exception e) {
            Log.e(TAG, "Failed to set svip flag", e);
        }
        if (!this.mClient.connect(0)) {
            Log.e(TAG, "Failed to connect to perf main service");
            return false;
        }
        if (isSet) {
            result = this.mClient.request("speedsched", "setSvip", new int[]{pid, tid, 1});
        } else {
            result = this.mClient.request("speedsched", "clearSvip", new int[]{pid, tid});
        }
        if (result == 0) {
            return true;
        }
        Log.e(TAG, isSet ? "Failed to set staticSvipFlag" : "Failed to clear staticSvipFlag");
        return false;
    }

    private boolean isBoostableCaller() {
        int tid = Process.myTid();
        return tid == Process.myPid() && tid != this.mLoadThreadTid;
    }

    public long getSvipWaitThresholdMs() {
        if (isBoostableCaller()) {
            return SVIP_WAIT_THRESHOLD_MS;
        }
        return 0L;
    }

    public boolean notifyStartWait() {
        if (this.mLoadThreadTid < 0 || this.mPid < 0 || !isBoostableCaller()) {
            return false;
        }
        int pid = this.mPid;
        int tid = this.mLoadThreadTid;
        if (!setOrClearSvip(true, pid, tid)) {
            return false;
        }
        this.mSvipPid = pid;
        this.mSvipTid = tid;
        return true;
    }

    public void notifyLoadFinished() {
        if (this.mSvipPid < 0 || this.mSvipTid < 0) {
            return;
        }
        setOrClearSvip(false, this.mSvipPid, this.mSvipTid);
        this.mSvipPid = -1;
        this.mSvipTid = -1;
    }
}
