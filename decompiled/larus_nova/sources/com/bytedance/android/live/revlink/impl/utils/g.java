package com.bytedance.android.live.revlink.impl.utils;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f97658a = 0;

    static {
    }

    public static String a(Context r100) {
        if (r100 != null) goto L98;
        r100 = jc1.a.b();
    L98:
        Object r101 = r100.getSystemService("activity");     // Catch: Throwable -> L95
        if (r101 == null) goto L94;
        Iterator<T> r102 = ((ActivityManager) r101).getHistoricalProcessExitReasons(r100.getPackageName(), 0, 5).iterator();     // Catch: Throwable -> L95
    L8:
        Integer r103 = null;
        if (r102.hasNext() == false) goto L13;
        Object r104 = r102.next();     // Catch: Throwable -> L95
        if (Intrinsics.areEqual(((ApplicationExitInfo) r104).getProcessName(), r100.getPackageName()) == false) goto L8;
    L14:
        ApplicationExitInfo r105 = (ApplicationExitInfo) r104;     // Catch: Throwable -> L95
        if (r105 == null) goto L17;
        r103 = Integer.valueOf(r105.getReason());     // Catch: Throwable -> L95
    L17:
        if (r103 != null) goto L20;
    L22:
        if (r103 != null) goto L25;
    L27:
        if (r103 != null) goto L30;
    L32:
        if (r103 != null) goto L35;
    L37:
        if (r103 != null) goto L40;
    L42:
        if (r103 != null) goto L45;
    L47:
        if (r103 != null) goto L50;
    L52:
        if (r103 != null) goto L55;
    L57:
        if (r103 != null) goto L60;
    L62:
        if (r103 != null) goto L65;
    L67:
        if (r103 != null) goto L70;
    L72:
        if (r103 != null) goto L75;
    L77:
        if (r103 != null) goto L80;
    L82:
        if (r103 != null) goto L85;
    L87:
        if (r105 == null) goto L116;
        String r106 = String.valueOf(r105.getReason());     // Catch: Throwable -> L95
        if (r106 != null) goto L92;
        return "unknown";
    L92:
        return r106;
    L116:
        return "unknown";
    L85:
        if (r103.intValue() != 7) goto L87;
        return "initial failure";
    L80:
        if (r103.intValue() != 2) goto L82;
        return IAllianceService.LAUNCH_FROM_SIGNAL;
    L75:
        if (r103.intValue() != 1) goto L77;
        return "exit self";
    L70:
        if (r103.intValue() != 13) goto L72;
        return "other";
    L65:
        if (r103.intValue() != 12) goto L67;
        return "dependency died";
    L60:
        if (r103.intValue() != 11) goto L62;
        return "user stopped";
    L55:
        if (r103.intValue() != 9) goto L57;
        return "excessive resource usage";
    L50:
        if (r103.intValue() != 8) goto L52;
        return "permission change";
    L45:
        if (r103.intValue() != 10) goto L47;
        return "user request";
    L40:
        if (r103.intValue() != 6) goto L42;
        return "anr";
    L35:
        if (r103.intValue() != 5) goto L37;
        return "native crash";
    L30:
        if (r103.intValue() != 4) goto L32;
        return "crash";
    L25:
        if (r103.intValue() != 3) goto L27;
        return "low memory";
    L20:
        if (r103.intValue() != 0) goto L22;
        return "unknown";
    L13:
        r104 = null;
        goto L14
    L94:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        ALogger.e("LinkCrashUtils", th);
        return "unknown";
    }
}
