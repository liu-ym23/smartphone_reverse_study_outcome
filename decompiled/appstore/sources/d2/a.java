package d2;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashSet f19024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Handler f19025b;

    static {
        f19024a = new HashSet();
        f19025b = new Handler(Looper.getMainLooper());
    }

    public static Handler a() {
        return f19025b;
    }
}
