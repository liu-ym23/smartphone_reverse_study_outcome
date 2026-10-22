package androidx.appsearch.util;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class ExceptionUtil {
    private static final String TAG = "AppSearchExceptionUtil";

    private ExceptionUtil() {
    }

    public static void handleException(Exception exc) {
        if (isItOkayToRethrowException() && (exc instanceof RuntimeException)) {
            rethrowRuntimeException((RuntimeException) exc);
        }
    }

    public static void handleRemoteException(RemoteException remoteException) {
        Log.w(TAG, "Unable to make a call to AppSearchManagerService!", remoteException);
    }

    private static boolean isItOkayToRethrowException() {
        return true;
    }

    private static void rethrowRuntimeException(RuntimeException runtimeException) {
        throw runtimeException;
    }
}
