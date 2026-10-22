package a6;

import android.view.WindowManager;
import com.bytedance.platform.godzilla.common.Logger;

/* JADX INFO: loaded from: classes.dex */
public class b extends c6.b {
    public b() {
    }

    @Override // c6.a
    public String a() {
        return "JsDialogBadTokenPlugin";
    }

    @Override // com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r10, Throwable r11) {
        return f(r11);
    }

    @Override // c6.b
    public boolean e() {
        return false;
    }

    public final boolean f(Throwable r10) {
        if ((r10 instanceof WindowManager.BadTokenException) == false) goto L13;
        StackTraceElement[] r11 = r10.getStackTrace();
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        StackTraceElement r14 = r11[r13];
        if ("android.webkit.JsDialogHelper".equals(r14.getClassName()) == false) goto L12;
        if ("showDialog".equals(r14.getMethodName()) == false) goto L12;
        Logger.c(a(), "Hint JsDialogBadToken case ,fix it.");
        return true;
    L12:
        r13 = r13 + 1;
    L13:
        return false;
    }
}
