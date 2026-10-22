package com.bytedance.services.apm.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: EnsureManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static IEnsure f11167a;

    public static void a(IEnsure r2) {
        f11167a = (IEnsure) ZeusTransformUtils.wrapperContextForParams(r2, IEnsure.class, "com.obric.aiagent.plugin");
    }

    public static void a(String r1) {
        IEnsure r0 = f11167a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1);
    }

    public static void a(Throwable r1) {
        IEnsure r0 = f11167a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1);
    }

    public static void a(int r0, Throwable r1, String r2, boolean r3) {
        IEnsure r4 = f11167a;
        if (r4 != null) goto L5;
        return;
    L5:
        r4.reportLogException(r0, r1, r2);
    }

    public static void a(Throwable r1, String r2) {
        IEnsure r0 = f11167a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1, r2);
    }

    public static void a(String r2, Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        IEnsure r0 = f11167a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r2, r4);
    }
}
