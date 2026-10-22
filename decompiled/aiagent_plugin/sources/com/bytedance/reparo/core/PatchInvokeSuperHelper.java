package com.bytedance.reparo.core;

import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class PatchInvokeSuperHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Class> f9134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Class, ReentrantLock> f9135b;

    public PatchInvokeSuperHelper() {
    }

    static {
        f9134a = new HashMap();
        f9135b = new HashMap();
    }

    static void a(List<Class> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        f9134a.clear();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Class r0 = (Class) ZeusTransformUtils.preCheckCast(r6.next(), Class.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        f9134a.put(r0.getName(), r0);
        goto L4
    }

    public static boolean replaceSuperClassForReflectionInvoke(String r3, Class r4) {
        if (l.a() == true) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return false;
    L11:
        Map<String, Class> r0 = f9134a;
        if (r0.containsKey(r3) == true) goto L15;
        return false;
    L15:
        return b((Class) ZeusTransformUtils.preCheckCast(r0.get(r3), Class.class, "com.obric.aiagent.plugin"), r4);
    }

    static boolean a(Class r6, Class r7) {
        if (r6 != null) goto L5;
        return false;
    L5:
        Field r2 = null;
        r2 = r6.getClass().getDeclaredField("superClass");     // Catch: NoSuchFieldException -> L8
    L10:
        if (r2 != null) goto L12;
        return false;
    L12:
        r2.setAccessible(true);
        r2.set(r6, r7);     // Catch: Exception -> L15
        return true;
    L15:
        e = move-exception;
        com.bytedance.reparo.core.f.a.b("replaceSuperClassForReflectionInvoke: " + r6.getName(), e);
        return false;
    L8:
        e = move-exception;
        com.bytedance.reparo.core.f.a.b("replaceSuperClassForReflectionInvoke: " + r6.getName(), e);
        goto L10
    }

    static boolean b(Class r0, Class r1) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return a(r0, r1);
    }
}
