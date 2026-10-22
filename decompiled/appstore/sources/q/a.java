package q;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static Handler a() {
        if (Looper.myLooper() != null) goto L6;
        return new Handler(Looper.getMainLooper());
    L6:
        return new Handler();
    }
}
