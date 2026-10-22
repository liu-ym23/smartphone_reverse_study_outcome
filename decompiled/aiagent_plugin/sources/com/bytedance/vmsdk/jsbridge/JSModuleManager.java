package com.bytedance.vmsdk.jsbridge;

import android.content.Context;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class JSModuleManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, JSModuleWrapper> f11742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f11743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, d> f11744c;

    public JSModuleManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f11744c = new ConcurrentHashMap();
        this.f11743b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    public void a(String r5, Class<? extends JSModule> r6, Object r7) {
        d r0 = new d();
        r0.a(r5);
        r0.a(r6);
        r0.a(r7);
        d r8 = (d) ZeusTransformUtils.preCheckCast(this.f11744c.get(r5), d.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L5;
        a("VmsdkModuleManager", "Duplicated VmsdkModule For Name: " + r5 + ", " + r8 + " will be override");
    L5:
        this.f11744c.put(r5, r0);
        b("VmsdkModuleManager", "registered module with name: " + r5 + " class" + r6);
    }

    private void a(Exception r2) {
        a("VmsdkModuleManager", "get Module failed" + r2);
    }

    public JSModuleWrapper a(String r14) {
        if (r14 != null) goto L7;
        a("VmsdkModuleManager", "getModule failed, name is null");
        return null;
    L7:
        if (this.f11742a != null) goto L10;
        this.f11742a = new ConcurrentHashMap();
    L10:
        if (this.f11742a.get(r14) != null) goto L12;
        d r2 = (d) ZeusTransformUtils.preCheckCast(this.f11744c.get(r14), d.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L16;
        return null;
    L16:
        Class<? extends JSModule> r4 = r2.a();
    L43:
        e = move-exception;
        a(e);
    L47:
        JSModule r3 = null;
    L48:
        if (r3 != null) goto L51;
        b("VmsdkModuleManager", "getModule" + r14 + "failed");
        return null;
    L51:
        JSModuleWrapper r0 = new JSModuleWrapper(r14, r3);
        this.f11742a.put(r14, r0);
        return r0;
    L45:
        e = move-exception;
        a(e);
    L41:
        e = move-exception;
        a(e);
    L39:
        e = move-exception;
        a(e);
    L37:
        e = move-exception;
        a(e);
        goto L47
    L18:
        if (r2.b() != null) goto L34;
        Constructor<?>[] r5 = r4.getConstructors();     // Catch: Exception -> L37 InvocationTargetException -> L39 NoSuchMethodException -> L41 IllegalAccessException -> L43 InstantiationException -> L45
        int r6 = r5.length;     // Catch: Exception -> L37 InvocationTargetException -> L39 NoSuchMethodException -> L41 IllegalAccessException -> L43 InstantiationException -> L45
        int r7 = 0;
    L20:
        if (r7 >= r6) goto L47;
        Constructor<?> r9 = r5[r7];     // Catch: Exception -> L37 InvocationTargetException -> L39 NoSuchMethodException -> L41 IllegalAccessException -> L43 InstantiationException -> L45
        Class<?>[] r10 = r9.getParameterTypes();     // Catch: Exception -> L37 InvocationTargetException -> L39 NoSuchMethodException -> L41 IllegalAccessException -> L43 InstantiationException -> L45
        if (r10.length != 1) goto L27;
        if (Context.class.equals(r10[0]) == false) goto L27;
        r3 = (JSModule) ZeusTransformUtils.preCheckCast(r9.newInstance(new Object[]{this.f11743b}), JSModule.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L37 InvocationTargetException -> L39 NoSuchMethodException -> L41 IllegalAccessException -> L43 InstantiationException -> L45
    L27:
        if (r10.length != 2) goto L33;
        if (Context.class.equals(r10[0]) == false) goto L33;
        if (Object.class.equals(r10[1]) == false) goto L33;
        r3 = (JSModule) ZeusTransformUtils.preCheckCast(r9.newInstance(new Object[]{this.f11743b, null}), JSModule.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L37 InvocationTargetException -> L39 NoSuchMethodException -> L41 IllegalAccessException -> L43 InstantiationException -> L45
    L33:
        r7 = r7 + 1;     // Catch: Exception -> L37 InvocationTargetException -> L39 NoSuchMethodException -> L41 IllegalAccessException -> L43 InstantiationException -> L45
        goto L20
    L34:
        if (r4 == null) goto L47;
        r3 = (JSModule) ZeusTransformUtils.preCheckCast(r4.getConstructor(new Class[]{Context.class, Object.class}).newInstance(new Object[]{this.f11743b, r2.b()}), JSModule.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L37 InvocationTargetException -> L39 NoSuchMethodException -> L41 IllegalAccessException -> L43 InstantiationException -> L45
        goto L48
    L12:
        return (JSModuleWrapper) ZeusTransformUtils.preCheckCast(this.f11742a.get(r14), JSModuleWrapper.class, "com.obric.aiagent.plugin");
    }

    private JSModuleWrapper moduleWrapperForName(String r1) {
        return a(r1);
    }

    public void destroy() {
        this.f11743b = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
        ConcurrentHashMap<String, JSModuleWrapper> r1 = this.f11742a;
        if (r1 == null) goto L5;
        r1.clear();
        this.f11742a = null;
    L5:
        this.f11744c.clear();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
