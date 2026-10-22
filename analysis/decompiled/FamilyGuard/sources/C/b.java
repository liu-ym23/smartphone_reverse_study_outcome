package C;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
class b {
    static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
