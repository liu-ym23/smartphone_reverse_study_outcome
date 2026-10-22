package com.obric.aiagent.executionengine.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Binder;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PackageUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18566a = null;

    static {
        f18566a = new b();
    }

    private b() {
    }

    public final String a(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        if (r4.checkSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") != 0) goto L21;
        int r6 = Binder.getCallingPid();
        Object r7 = r4.getSystemService("activity");
        o.a(r7, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> r8 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r7, ActivityManager.class, "com.obric.aiagent.plugin")).getRunningAppProcesses();
        o.c(r8, "getRunningAppProcesses(...)");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r9.hasNext() == false) goto L13;
        Object r2 = r9.next();
        if (((ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r2, ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin")).pid != r6) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L6;
    L14:
        ActivityManager.RunningAppProcessInfo r10 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r2, ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L17;
        String r11 = r10.processName;
    L18:
        if (r11 != null) goto L20;
        return null;
    L20:
        return d.o.o.b(r11, ":", r11);
    L17:
        r11 = null;
        goto L18
    L10:
        r3 = false;
        goto L11
    L13:
        r2 = null;
        goto L14
    L21:
        Binder.getCallingWorkSourceUid();
        int r12 = Binder.getCallingUid();
        if (r12 >= 10000) goto L26;
        ILogDepend.Companion.e("PackageUtils", "Failed to get package for system uid: " + r12);
        return null;
    L26:
        return r4.getPackageManager().getNameForUid(r12);
    }
}
