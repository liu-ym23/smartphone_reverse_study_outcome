package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* JADX INFO: loaded from: classes2.dex */
public class TopResumedActivityPlugin extends UncaughtExceptionPlugin {
    private static final String ERR_MSG = "Activity top position already set to onTop=false";
    private static final String STACK_CLASS = "android.app.ActivityThread";
    private static final String STACK_METHOD = "handleTopResumedActivityChanged";

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "TopResumedActivityPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return false;
    }

    public TopResumedActivityPlugin() {
    }

    private boolean isTopResumedActivityException(Thread r6, Throwable r7) {
        if ((r7 instanceof IllegalStateException) == false) goto L17;
        StackTraceElement[] r5 = r7.getStackTrace();
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L17;
        StackTraceElement r2 = r5[r1];
        if (r2 == null) goto L16;
        if (STACK_CLASS.equals(r2.getClassName()) == false) goto L16;
        if (STACK_METHOD.equals(r2.getMethodName()) == false) goto L16;
        if (ERR_MSG.equals(r7.getMessage()) == false) goto L16;
        return true;
    L16:
        r1 = r1 + 1;
    L17:
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r1, Throwable r2) throws Throwable {
        return isTopResumedActivityException(r1, r2);
    }
}
