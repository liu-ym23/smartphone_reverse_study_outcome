package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.platform.godzilla.common.CrashPortrait;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import com.bytedance.platform.godzilla.utils.ProcessHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SuperUncaughtExceptionPlugin extends UncaughtExceptionPlugin {
    private ConfigFetcher mConfigFetcher;
    private Context mContext;

    public interface ConfigFetcher {
        String getAppVersion();

        List<CrashPortrait> getCrashPortrait();

        int getUpdateVersion();

        void onCrashCatchSucceed(CrashPortrait r1);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CloudUncaughtExceptionCatcher";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    public SuperUncaughtExceptionPlugin(ConfigFetcher r1, Context r2) {
        this.mConfigFetcher = r1;
        this.mContext = r2;
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("mConfigFetcher and mContext can not be null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r17, Throwable r18) {
        ConfigFetcher r1 = this.mConfigFetcher;
        boolean r2 = false;
        if (r1 != null) goto L5;
        return false;
    L5:
        List<CrashPortrait> r3 = r1.getCrashPortrait();
        if (r3 != null) goto L8;
    L73:
        return r2;
    L8:
        if (r3.isEmpty() == true) goto L73;
        String r4 = this.mConfigFetcher.getAppVersion();
        int r5 = this.mConfigFetcher.getUpdateVersion();
        int r6 = Build.VERSION.SDK_INT;
        String r7 = r17.getName();
        String r8 = ProcessHelper.getCurrentProcessName(this.mContext);
        Iterator<CrashPortrait> r9 = r3.iterator();
    L12:
        if (r9.hasNext() == false) goto L73;
        CrashPortrait r10 = r9.next();
        if (TextUtils.isEmpty(r10.appVersion) == true) goto L19;
        if (r10.appVersion.equalsIgnoreCase(r4) == false) goto L12;
    L19:
        if (r10.updateVersion <= 0) goto L24;
        if (r10.updateVersion != r5) goto L12;
    L24:
        if (r10.osVersion <= 0) goto L29;
        if (r6 != r10.osVersion) goto L12;
    L29:
        if (TextUtils.isEmpty(r10.threadName) == true) goto L34;
        if (r10.threadName.equalsIgnoreCase(r7) == false) goto L12;
    L34:
        if (TextUtils.isEmpty(r10.processName) == true) goto L39;
        if (r10.processName.equalsIgnoreCase(r8) == false) goto L12;
    L39:
        if (TextUtils.isEmpty(r10.detailMessage) == true) goto L44;
        if (r10.detailMessage.equalsIgnoreCase(r18.getMessage()) == false) goto L12;
    L44:
        if (TextUtils.isEmpty(r10.throwableClassName) == true) goto L49;
        if (r10.throwableClassName.equalsIgnoreCase(r18.getClass().getName()) == false) goto L12;
    L49:
        if (TextUtils.isEmpty(r10.clazzName) == false) goto L55;
        if (TextUtils.isEmpty(r10.methodName) == false) goto L55;
        Logger.e("CloudUntExPlugin", "Hint crash," + r10);
        this.mConfigFetcher.onCrashCatchSucceed(r10);
        return true;
    L55:
        if (TextUtils.isEmpty(r10.clazzName) == false) goto L57;
    L58:
        Logger.e("CloudUntExPlugin", r10.clazzName + LibrarianImpl.Constants.DOT + r10.methodName + " does not match.");
    L59:
        StackTraceElement[] r11 = r18.getStackTrace();
        int r13 = r11.length;
        ?? r14 = r2;
    L60:
        if (r14 >= r13) goto L12;
        StackTraceElement r15 = r11[r14];
        if (TextUtils.isEmpty(r10.clazzName) == true) goto L67;
        if (r10.clazzName.equalsIgnoreCase(r15.getClassName()) == true) goto L67;
    L70:
        r2 = false;
        r14 = r14 + 1;
    L67:
        if (TextUtils.isEmpty(r10.methodName) == true) goto L71;
        if (r10.methodName.equalsIgnoreCase(r15.getMethodName()) == false) goto L70;
    L71:
        Logger.e("CloudUntExPlugin", "Hint crash," + r10);
        this.mConfigFetcher.onCrashCatchSucceed(r10);
        return true;
    L57:
        if (TextUtils.isEmpty(r10.methodName) == false) goto L59;
        goto L58
    }
}
