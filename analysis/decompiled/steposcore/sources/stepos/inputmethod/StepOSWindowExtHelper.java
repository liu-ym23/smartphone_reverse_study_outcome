package stepos.inputmethod;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import stepos.app.IStepOSWindowManager;

/* loaded from: classes.dex */
final class StepOSWindowExtHelper {
    private static final String TAG = "QsActionManager";
    private static IStepOSWindowManager sStepOSWm;

    private StepOSWindowExtHelper() {
    }

    static synchronized IStepOSWindowManager getStepOSWindowManager() {
        if (sStepOSWm != null) {
            return sStepOSWm;
        }
        IBinder b = ServiceManager.getService("window_ext");
        if (b == null) {
            return null;
        }
        sStepOSWm = IStepOSWindowManager.Stub.asInterface(b);
        return sStepOSWm;
    }

    static IBinder getSubService(String name) {
        IStepOSWindowManager wm = getStepOSWindowManager();
        if (wm == null) {
            return null;
        }
        try {
            return wm.getSubService(name);
        } catch (RemoteException e) {
            Slog.w("QsActionManager", "getSubService " + name, e);
            return null;
        }
    }

    static void setVirtualImeHeight(int displayId, int height) {
        IStepOSWindowManager wm = getStepOSWindowManager();
        if (wm == null) {
            return;
        }
        try {
            wm.setVirtualImeHeight(displayId, height);
        } catch (RemoteException e) {
            Slog.w("QsActionManager", "setVirtualImeHeight", e);
        }
    }
}
