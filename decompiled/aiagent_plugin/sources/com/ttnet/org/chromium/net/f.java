package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CronetProvider.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    private static final String TAG = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f37898a;

    static {
    }

    public abstract d.a a(boolean r1);

    public abstract String a();

    public abstract String b();

    public abstract boolean c();

    public f(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        this.f37898a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        return;
    L7:
        throw new IllegalArgumentException("Context must not be null");
    }

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + a() + ", version=" + b() + ", enabled=" + c() + "]";
    }

    public static List<f> a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        LinkedHashSet r0 = new LinkedHashSet();
        a(r4, "com.ttnet.org.chromium.net.impl.NativeCronetProvider", r0, false);
        return Collections.unmodifiableList(new ArrayList(r0));
    }

    private static boolean a(Context r7, String r8, Set<f> r9, boolean r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        r12.add((f) ZeusTransformUtils.preCheckCast(r11.getClassLoader().loadClass(r8).asSubclass(f.class).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r11}), f.class, "com.obric.aiagent.plugin"));     // Catch: ClassNotFoundException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 InvocationTargetException -> L11 InstantiationException -> L13
        return true;
    L5:
        e = move-exception;
        a(r8, r10, e);
    L15:
        return false;
    L7:
        e = move-exception;
        a(r8, r10, e);
    L13:
        e = move-exception;
        a(r8, r10, e);
    L9:
        e = move-exception;
        a(r8, r10, e);
    L11:
        e = move-exception;
        a(r8, r10, e);
        goto L15
    }

    private static void a(String r2, boolean r3, Exception r4) {
        if (r3 == false) goto L4;
        a(TAG, "Unable to load provider class: " + r2, r4);
        return;
    L4:
        String r5 = TAG;
        if (a(r5, 3) == false) goto L9;
        a(r5, "Tried to load " + r2 + " provider class but it wasn't included in the app classpath");
        return;
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
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
