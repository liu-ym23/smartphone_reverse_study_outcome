package com.bumptech.glide.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ManifestParser.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class e {
    private static final String TAG = "ManifestParser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3271a;

    public e(Context r3) {
        this.f3271a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public List<c> a() {
        if (a(TAG, 3) == false) goto L5;
        a(TAG, "Loading Glide modules");
    L5:
        ArrayList r2 = new ArrayList();
        ApplicationInfo r7 = this.f3271a.getPackageManager().getApplicationInfo(this.f3271a.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L28
        if (r7.metaData != null) goto L13;
        if (a(TAG, 3) == false) goto L11;
        a(TAG, "Got null app info metadata");     // Catch: PackageManager.NameNotFoundException -> L28
    L11:
        return r2;
    L13:
        if (a(TAG, 2) == false) goto L15;
        b(TAG, "Got app info metadata: " + r7.metaData);     // Catch: PackageManager.NameNotFoundException -> L28
    L15:
        Iterator<String> r3 = r7.metaData.keySet().iterator();     // Catch: PackageManager.NameNotFoundException -> L28
    L17:
        if (r3.hasNext() == false) goto L25;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: PackageManager.NameNotFoundException -> L28
        if ("GlideModule".equals(r7.metaData.get(r4)) == false) goto L17;
        r2.add(a(r4));     // Catch: PackageManager.NameNotFoundException -> L28
        if (a(TAG, 3) == false) goto L17;
        a(TAG, "Loaded Glide module: " + r4);     // Catch: PackageManager.NameNotFoundException -> L28
        goto L17
    L25:
        if (a(TAG, 3) == false) goto L27;
        a(TAG, "Finished loading Glide modules");
    L27:
        return r2;
    L28:
        e = move-exception;
        throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
    }

    private static c a(String r4) {
        Class r5 = ZeusTransformUtils.forName(r4, "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L21
        Object r1 = null;
        r1 = r5.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 InstantiationException -> L13
    L16:
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L20;
        return (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
    L20:
        throw new RuntimeException("Expected instanceof GlideModule, but found: " + r1);
    L11:
        e = move-exception;
        a(r5, e);
    L13:
        e = move-exception;
        a(r5, e);
    L9:
        e = move-exception;
        a(r5, e);
    L7:
        e = move-exception;
        a(r5, e);
    L21:
        e = move-exception;
        throw new IllegalArgumentException("Unable to find GlideModule implementation", e);
    }

    private static void a(Class<?> r3, Exception r4) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + r3, r4);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
