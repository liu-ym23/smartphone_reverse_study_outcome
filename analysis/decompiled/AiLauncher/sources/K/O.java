package K;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class O {
    public static O a(Executor executor, Handler handler) {
        return new C0879e(executor, handler);
    }

    public abstract Executor b();

    public abstract Handler c();
}
