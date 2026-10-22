package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import c6.b;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.platform.godzilla.common.Logger;
import d6.g;
import java.util.Iterator;
import java.util.List;
import u5.c;

/* JADX INFO: loaded from: classes.dex */
public class SuperUncaughtExceptionPlugin extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConfigFetcher f7868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f7869c;

    public interface ConfigFetcher {
        String getAppVersion();

        List<c> getCrashPortrait();

        int getUpdateVersion();

        void onCrashCatchSucceed(c r10);
    }

    public SuperUncaughtExceptionPlugin(ConfigFetcher r10, Context r11) {
        this.f7868b = r10;
        this.f7869c = r11;
        if (r10 == null) goto L7;
        if (r11 == null) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("mConfigFetcher and mContext can not be null.");
    }

    @Override // c6.a
    public String a() {
        return "CloudUncaughtExceptionCatcher";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    @Override // com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r17, Throwable r18) {
        ConfigFetcher r10 = this.f7868b;
        boolean r11 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        List<c> r12 = r10.getCrashPortrait();
        if (r12 != null) goto L8;
    L71:
        return r11;
    L8:
        if (r12.isEmpty() == true) goto L71;
        String r13 = this.f7868b.getAppVersion();
        int r14 = this.f7868b.getUpdateVersion();
        int r15 = Build.VERSION.SDK_INT;
        String r16 = r17.getName();
        String r19 = g.b(this.f7869c);
        Iterator<c> r20 = r12.iterator();
    L12:
        if (r20.hasNext() == false) goto L71;
        c r21 = r20.next();
        if (TextUtils.isEmpty(r21.f24874e) == true) goto L18;
        if (r21.f24874e.equalsIgnoreCase(r13) == false) goto L12;
    L18:
        int r22 = r21.f24875f;
        if (r22 <= 0) goto L22;
        if (r22 != r14) goto L12;
    L22:
        int r23 = r21.f24878i;
        if (r23 <= 0) goto L27;
        if (r15 != r23) goto L12;
    L27:
        if (TextUtils.isEmpty(r21.f24873d) == true) goto L32;
        if (r21.f24873d.equalsIgnoreCase(r16) == false) goto L12;
    L32:
        if (TextUtils.isEmpty(r21.f24870a) == true) goto L37;
        if (r21.f24870a.equalsIgnoreCase(r19) == false) goto L12;
    L37:
        if (TextUtils.isEmpty(r21.f24876g) == true) goto L42;
        if (r21.f24876g.equalsIgnoreCase(r18.getMessage()) == false) goto L12;
    L42:
        if (TextUtils.isEmpty(r21.f24877h) == true) goto L47;
        if (r21.f24877h.equalsIgnoreCase(r18.getClass().getName()) == false) goto L12;
    L47:
        if (TextUtils.isEmpty(r21.f24871b) == false) goto L53;
        if (TextUtils.isEmpty(r21.f24872c) == false) goto L53;
        Logger.c("CloudUntExPlugin", "Hint crash," + r21);
        this.f7868b.onCrashCatchSucceed(r21);
        return true;
    L53:
        if (TextUtils.isEmpty(r21.f24871b) == false) goto L55;
    L56:
        Logger.c("CloudUntExPlugin", r21.f24871b + LibrarianImpl.Constants.DOT + r21.f24872c + " does not match.");
    L57:
        StackTraceElement[] r24 = r18.getStackTrace();
        int r110 = r24.length;
        ?? r111 = r11;
    L58:
        if (r111 >= r110) goto L12;
        StackTraceElement r112 = r24[r111];
        if (TextUtils.isEmpty(r21.f24871b) == true) goto L65;
        if (r21.f24871b.equalsIgnoreCase(r112.getClassName()) == true) goto L65;
    L68:
        r11 = false;
        r111 = r111 + 1;
    L65:
        if (TextUtils.isEmpty(r21.f24872c) == true) goto L69;
        if (r21.f24872c.equalsIgnoreCase(r112.getMethodName()) == false) goto L68;
    L69:
        Logger.c("CloudUntExPlugin", "Hint crash," + r21);
        this.f7868b.onCrashCatchSucceed(r21);
        return true;
    L55:
        if (TextUtils.isEmpty(r21.f24872c) == false) goto L57;
        goto L56
    }

    @Override // c6.b
    public boolean e() {
        return true;
    }
}
