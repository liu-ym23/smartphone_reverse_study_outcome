package com.stepos.core.common.telemetry;

import android.content.Context;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EngineVersionProvider {
    public static final EngineVersionProvider INSTANCE = new EngineVersionProvider();
    private static volatile String cached;

    private EngineVersionProvider() {
    }

    private final String resolveFromPackageInfo() {
        Object objA;
        Context context;
        try {
            context = l7.a.f10344a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (context == null) {
            throw new IllegalStateException("ContextHolder must be initialized before use!");
        }
        objA = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        if (objA == null) {
            objA = "";
        }
        return (String) (objA instanceof Result.Failure ? "" : objA);
    }

    public final String get() {
        String str = cached;
        if (str != null) {
            return str;
        }
        String strResolveFromPackageInfo = resolveFromPackageInfo();
        cached = strResolveFromPackageInfo;
        return strResolveFromPackageInfo;
    }

    public final void init(String version) {
        kotlin.jvm.internal.g.f(version, "version");
        cached = version;
    }
}
