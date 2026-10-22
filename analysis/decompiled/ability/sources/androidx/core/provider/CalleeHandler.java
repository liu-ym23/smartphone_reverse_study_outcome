package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
class CalleeHandler {
    private CalleeHandler() {
    }

    public static Handler create() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
