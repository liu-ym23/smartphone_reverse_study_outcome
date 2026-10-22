package android.view;

import android.app.Application;
import android.app.StepOSActivityThreadExtImpl;
import android.app.asyncinflate.AsyncInflateStub;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.perfmain.client.PerfMainClient;

/* loaded from: classes.dex */
public class StepOSChoreographerExtImpl implements IStepOSChoreographerExt {
    private static final String LAUNCHER3_PROCESS = "com.android.launcher3";
    private static final int SVIP_VALUE = 132;
    private static final String TAG = "StepOSChoreographerExtImpl";
    private static volatile boolean sNotifiedDoFrame = false;
    private Choreographer mHost;
    private boolean mSvipSet = false;

    public void onAttach(Choreographer host) {
        this.mHost = host;
    }

    public void onDoFrame() {
        if (!this.mSvipSet) {
            this.mSvipSet = true;
            setDoFrameThreadSvip();
        }
        if (!sNotifiedDoFrame && Looper.myLooper() == Looper.getMainLooper()) {
            sNotifiedDoFrame = true;
            AsyncInflateStub.get().notifyDoFrame();
        }
    }

    private void setDoFrameThreadSvip() {
        final int pid = Process.myPid();
        final int tid = Process.myTid();
        new Thread(new Runnable() { // from class: android.view.StepOSChoreographerExtImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StepOSChoreographerExtImpl.lambda$setDoFrameThreadSvip$0(pid, tid);
            }
        }, "svip-set").start();
    }

    static /* synthetic */ void lambda$setDoFrameThreadSvip$0(int pid, int tid) {
        try {
            String processName = getProcessNameSafely();
            if (processName != null && processName.toLowerCase().contains(LAUNCHER3_PROCESS)) {
                PerfMainClient client = new PerfMainClient();
                if (!client.connect(0)) {
                    Log.w(TAG, "PerfMain connect failed for doFrame SVIP (pid=" + pid + " tid=" + tid + ")");
                } else {
                    int result = client.request("speedsched", "setSvip", new int[]{pid, tid, SVIP_VALUE});
                    Log.i(TAG, "doFrame thread SVIP set: process=" + processName + " pid=" + pid + " tid=" + tid + " result=" + result);
                    client.disconnect();
                }
                return;
            }
            Log.i(TAG, "skip doFrame SVIP, not launcher3 process: " + processName);
        } catch (Throwable t) {
            Log.w(TAG, "set doFrame SVIP failed: " + t.getMessage());
        }
    }

    private static String getProcessNameSafely() {
        try {
            return Application.getProcessName();
        } catch (Throwable t) {
            Log.w(TAG, "getProcessName failed: " + t.getMessage());
            return null;
        }
    }

    public void onDetach() {
        this.mHost = null;
    }

    public void postCallbackImmediately(int callbackType, Runnable action, Object token, long delayMillis) throws Throwable {
        Throwable th;
        if (action == null) {
            throw new IllegalArgumentException("action must not be null");
        }
        synchronized (this.mHost.getChoreographerInner().getLock()) {
            try {
                try {
                    long now = SystemClock.uptimeMillis();
                    long dueTime = now + delayMillis;
                    this.mHost.getChoreographerInner().postCallback(callbackType, action, token, dueTime);
                    this.mHost.getChoreographerInner().setFrameScheduled(true);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    public void setAppDoFrameOptEnable(boolean r) {
        StepOSActivityThreadExtImpl.mAppDoFrameOptEnable = r;
    }
}
