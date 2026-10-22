package c5;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(Runnable r100, Throwable r101) {
        if (r101 == null) goto L4;
    L13:
        Throwable r102 = null;
    L14:
        if (r102 == null) goto L20;
        Logger.throwException(r102);
        return;
    L20:
        return;
    L4:
        if ((r100 instanceof Future) == false) goto L13;
        Future r103 = (Future) r100;
        if (r103.isDone() == false) goto L13;
        if (r103.isCancelled() == true) goto L13;
        r103.get();     // Catch: ExecutionException -> L11 Throwable -> L17
    L11:
        e = move-exception;
        r102 = e.getCause();
        goto L14
    }
}
