package a6;

import com.bytedance.platform.godzilla.common.Logger;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class a extends c6.b {
    public a() {
    }

    @Override // c6.a
    public String a() {
        return "FinalizeTimeoutPlugin";
    }

    @Override // c6.b, c6.a
    public void c() {
        super.c();
    }

    @Override // com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r10, Throwable r11) {
        boolean r12 = f(r10, r11);
        if (r12 == false) goto L5;
        Logger.c(a(), "Hint FinalizeTimeout case ,fix it.");
    L5:
        return r12;
    }

    @Override // c6.b
    public boolean e() {
        return true;
    }

    public final boolean f(Thread r10, Throwable r11) {
        if (r10 == null) goto L9;
        if (r11 == null) goto L9;
        if (r10.getName().equals("FinalizerWatchdogDaemon") == false) goto L9;
        if ((r11 instanceof TimeoutException) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
