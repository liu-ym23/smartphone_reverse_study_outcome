package cib;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {
    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(r100.concat(", can't operate on non-main thread, ").toString());
    }
}
