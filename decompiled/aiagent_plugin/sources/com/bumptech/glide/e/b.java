package com.bumptech.glide.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.bumptech.glide.load.g;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ApplicationVersionSignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String TAG = "AppVersionSignature";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<String, g> f3301a = null;

    static {
        f3301a = new ConcurrentHashMap();
    }

    public static g a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        String r0 = r6.getPackageName();
        ConcurrentMap<String, g> r2 = f3301a;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r2.get(r0), g.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
        g r4 = b(r6);
        g r7 = (g) ZeusTransformUtils.preCheckCast(r2.putIfAbsent(r0, r4), g.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L8;
        return r4;
    L8:
        return r7;
    L9:
        return r3;
    }

    private static g b(Context r2) {
        return new d(a(c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"))));
    }

    private static String a(PackageInfo r0) {
        if (r0 == null) goto L5;
        return String.valueOf(r0.versionCode);
    L5:
        return UUID.randomUUID().toString();
    }

    private static PackageInfo c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        return r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0);
    L5:
        e = move-exception;
        a(TAG, "Cannot resolve info for" + r4.getPackageName(), e);
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
