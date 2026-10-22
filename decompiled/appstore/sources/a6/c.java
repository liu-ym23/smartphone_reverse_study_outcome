package a6;

import android.view.WindowManager;
import com.bytedance.platform.godzilla.common.Logger;

/* JADX INFO: loaded from: classes.dex */
public class c extends c6.b {
    public c() {
    }

    @Override // c6.a
    public String a() {
        return "ToastBadTokenPlugin";
    }

    @Override // com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r10, Throwable r11) {
        return f(r10, r11);
    }

    @Override // c6.b
    public boolean e() {
        return false;
    }

    public final boolean f(Thread r10, Throwable r11) {
        if ((r11 instanceof WindowManager.BadTokenException) == false) goto L15;
        StackTraceElement[] r12 = r11.getStackTrace();
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L15;
        StackTraceElement r15 = r12[r14];
        if (r15 == null) goto L14;
        if ("android.widget.Toast$TN".equals(r15.getClassName()) == false) goto L14;
        if ("handleShow".equals(r15.getMethodName()) == false) goto L14;
        Logger.c(a(), "Hint ToastBadToken case ,fix it.");
        return true;
    L14:
        r14 = r14 + 1;
    L15:
        return false;
    }
}
