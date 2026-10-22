package com.bytedance.platform.godzilla.crash.boostcrash.impl;

import android.app.Instrumentation;
import android.os.Looper;
import com.bytedance.platform.godzilla.common.b;
import com.bytedance.platform.godzilla.common.g;
import com.bytedance.platform.godzilla.crash.boostcrash.a.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentationWrapper extends Instrumentation {
    private static final String TAG = "InstrumentationWrapper";
    private static List<a> sExceptionCatchers;
    private static boolean sIsFixed;

    public InstrumentationWrapper() {
    }

    static {
        sExceptionCatchers = new ArrayList();
    }

    public static void startFix() {
        if (sIsFixed == false) goto L13;
        return;
    L13:
        Object r1 = b.a();     // Catch: Exception -> L10
        Field r2 = r1.getClass().getDeclaredField("mInstrumentation");     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        if (ZeusTransformUtils.instanceOf(r2.get(r1), InstrumentationWrapper.class) == false) goto L8;
        return;
    L8:
        r2.set(r1, new InstrumentationWrapper());     // Catch: Exception -> L10
        g.b(TAG, "Fix success.");     // Catch: Exception -> L10
        sIsFixed = true;     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        g.b(TAG, e.getMessage());
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object r5, Throwable r6) {
        Iterator<a> r0 = sExceptionCatchers.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin")).a(r5, r6) == false) goto L4;
        return true;
    L10:
        return super.onException(r5, r6);
    }

    public static void registerExceptionCatcher(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        if (g.a() == true) goto L5;
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.a() == true) goto L14;
        return;
    L14:
        if (sExceptionCatchers.contains(r3) == true) goto L18;
        sExceptionCatchers.add(r3);
        return;
    L18:
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L9;
        throw new RuntimeException("register only in UI thread.");
    }

    public static void unRegisterExceptionCatcher(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        if (g.a() == true) goto L5;
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        sExceptionCatchers.remove(r3);
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L9;
        throw new RuntimeException("unRegister only in UI thread.");
    }
}
