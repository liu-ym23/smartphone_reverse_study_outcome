package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: CalleeHandler.java */
/* JADX INFO: loaded from: classes.dex */
class b {
    static Handler a() {
        if (Looper.myLooper() != null) goto L6;
        return new Handler(Looper.getMainLooper());
    L6:
        return new Handler();
    }
}
