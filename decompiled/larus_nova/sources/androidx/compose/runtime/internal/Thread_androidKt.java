package androidx.compose.runtime.internal;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"MainThreadId", "", "getMainThreadId", "()J", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Thread_androidKt {
    private static final long MainThreadId = 0;

    static {
        long r100 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId();     // Catch: Exception -> L4
    L5:
        MainThreadId = r100;
        return;
    L4:
        r100 = -1;
        goto L5
    }

    public static final long getMainThreadId() {
        return MainThreadId;
    }
}
