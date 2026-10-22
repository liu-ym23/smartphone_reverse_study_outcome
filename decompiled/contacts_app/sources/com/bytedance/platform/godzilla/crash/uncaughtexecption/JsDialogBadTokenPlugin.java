package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.view.WindowManager;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* JADX INFO: loaded from: classes2.dex */
public class JsDialogBadTokenPlugin extends UncaughtExceptionPlugin {
    private static final String STACK_CLASS = "android.webkit.JsDialogHelper";
    private static final String STACK_METHOD = "showDialog";

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "JsDialogBadTokenPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return false;
    }

    public JsDialogBadTokenPlugin() {
    }

    private boolean matchBadToken(Throwable r7) {
        if ((r7 instanceof WindowManager.BadTokenException) == false) goto L13;
        StackTraceElement[] r8 = r7.getStackTrace();
        int r0 = r8.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L13;
        StackTraceElement r3 = r8[r2];
        if (STACK_CLASS.equals(r3.getClassName()) == false) goto L12;
        if ("showDialog".equals(r3.getMethodName()) == false) goto L12;
        Logger.e(getName(), "Hint JsDialogBadToken case ,fix it.");
        return true;
    L12:
        r2 = r2 + 1;
    L13:
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r1, Throwable r2) throws Throwable {
        return matchBadToken(r2);
    }
}
