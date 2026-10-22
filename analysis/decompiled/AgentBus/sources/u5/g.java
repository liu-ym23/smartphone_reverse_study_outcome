package u5;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.keepalive.StepOSKeepAliveManager;
import m.x;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static volatile long f10126a;

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f10127b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public static final j1.p f10128c = new j1.p(1);

    public static void a() {
        try {
            if (StepOSKeepAliveManager.get().setProcessTempKeepAlive(Application.getProcessName(), 1, 1800000)) {
                return;
            }
            Log.w("KeepAliveHelper", "setProcessTempKeepAlive returned false");
        } catch (Throwable th) {
            f10126a = 0L;
            x.v("refreshKeepAlive failed: ", th.getMessage(), "KeepAliveHelper");
        }
    }
}
