package android.internal.os;

import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public class StepOSRuntimeInitImpl implements StepOSRuntimeInitStub {
    private static final String TAG = "StepOSRuntimeInitImpl";

    public void handleApplicationCrash(Thread t, Throwable e, IBinder applicationObject) {
        try {
            Log.d(TAG, "handle application crash: " + t.getName() + ", " + e.getMessage());
        } catch (Throwable th) {
            Log.e(TAG, "handle application crash error.");
        }
    }
}
