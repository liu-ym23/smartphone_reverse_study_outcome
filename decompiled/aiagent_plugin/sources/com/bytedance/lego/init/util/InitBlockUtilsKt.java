package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: InitBlockUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitBlockUtilsKt {
    public static final String LOG_TAG = "InitTaskDispatcher";

    public static final <T> T runWithTrace(String r2, a<? extends T> r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.d(r2, "traceTag");
        o.d(r4, "block");
        InitTraceUtil.INSTANCE.beginSection(r2);
        T r5 = (T) r4.invoke();
        InitTraceUtil.INSTANCE.endSection();
        return r5;
    }

    public static /* synthetic */ Object runWithMonitor$default(String r4, boolean r5, a r6, int r7, Object r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        if ((r7 & 2) == 0) goto L5;
        r5 = true;
    L5:
        o.d(r4, "monitorTag");
        o.d(r9, "block");
        long r10 = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug() == false) goto L8;
        InitLogger.INSTANCE.v(LOG_TAG, r4 + " start");
    L8:
        InitMonitor.INSTANCE.monitorStart(r4, r5);
        Object r11 = r9.invoke();
        InitMonitor.INSTANCE.monitorEnd(r4, r5);
        InitMonitor.INSTANCE.monitorCosTime(r4, System.currentTimeMillis() - r10, r5);
        if (InitLogger.INSTANCE.isDebug() == false) goto L11;
        InitLogger.INSTANCE.d(LOG_TAG, r4 + " done. cos: " + (System.currentTimeMillis() - r10) + "ms.");
    L11:
        return r11;
    }

    public static final <T> T runWithMonitor(String r6, boolean r7, a<? extends T> r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.aiagent.plugin");
        o.d(r6, "monitorTag");
        o.d(r9, "block");
        long r0 = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug() == false) goto L5;
        InitLogger.INSTANCE.v(LOG_TAG, r6 + " start");
    L5:
        InitMonitor.INSTANCE.monitorStart(r6, r7);
        T r10 = (T) r9.invoke();
        InitMonitor.INSTANCE.monitorEnd(r6, r7);
        InitMonitor.INSTANCE.monitorCosTime(r6, System.currentTimeMillis() - r0, r7);
        if (InitLogger.INSTANCE.isDebug() == false) goto L8;
        InitLogger.INSTANCE.d(LOG_TAG, r6 + " done. cos: " + (System.currentTimeMillis() - r0) + "ms.");
    L8:
        return r10;
    }

    public static /* synthetic */ Object runWithTraceAndMonitor$default(String r4, boolean r5, String r6, a r7, int r8, Object r9) {
        a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
        if ((r8 & 2) == 0) goto L5;
        r5 = true;
    L5:
        o.d(r4, "monitorTag");
        o.d(r6, "traceTag");
        o.d(r10, "block");
        long r11 = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug() == false) goto L8;
        InitLogger.INSTANCE.v(LOG_TAG, r4 + " start");
    L8:
        InitMonitor.INSTANCE.monitorStart(r4, r5);
        InitTraceUtil.INSTANCE.beginSection(r6);
        Object r12 = r10.invoke();
        InitTraceUtil.INSTANCE.endSection();
        InitMonitor.INSTANCE.monitorEnd(r4, r5);
        InitMonitor.INSTANCE.monitorCosTime(r4, System.currentTimeMillis() - r11, r5);
        if (InitLogger.INSTANCE.isDebug() == false) goto L11;
        InitLogger.INSTANCE.d(LOG_TAG, r4 + " done. cos: " + (System.currentTimeMillis() - r11) + "ms.");
    L11:
        return r12;
    }

    public static final void ifLogEnable(a<x> r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        o.d(r3, "block");
        if (InitLogger.INSTANCE.isDebug() == false) goto L6;
        r3.invoke();
        return;
    }

    public static /* synthetic */ Object runOrThrow$default(String r1, a r2, int r3, Object r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        o.d(r1, "exceptionTag");
        o.d(r5, "block");
        return r5.invoke();
    L8:
        e = move-exception;
        e.printStackTrace();
        if (InitScheduler.INSTANCE.enableCatchException() == false) goto L14;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), r1);
        return null;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> T runOrThrow(String r3, a<? extends T> r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        o.d(r3, "exceptionTag");
        o.d(r5, "block");
        return (T) r5.invoke();
    L5:
        e = move-exception;
        e.printStackTrace();
        if (InitScheduler.INSTANCE.enableCatchException() == false) goto L11;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), r3);
        return null;
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> T runWithTraceAndMonitor(String r6, boolean r7, String r8, a<? extends T> r9) {
        a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.aiagent.plugin");
        o.d(r6, "monitorTag");
        o.d(r8, "traceTag");
        o.d(r10, "block");
        long r0 = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug() == false) goto L5;
        InitLogger.INSTANCE.v(LOG_TAG, r6 + " start");
    L5:
        InitMonitor.INSTANCE.monitorStart(r6, r7);
        InitTraceUtil.INSTANCE.beginSection(r8);
        T r11 = (T) r10.invoke();
        InitTraceUtil.INSTANCE.endSection();
        InitMonitor.INSTANCE.monitorEnd(r6, r7);
        InitMonitor.INSTANCE.monitorCosTime(r6, System.currentTimeMillis() - r0, r7);
        if (InitLogger.INSTANCE.isDebug() == false) goto L8;
        InitLogger.INSTANCE.d(LOG_TAG, r6 + " done. cos: " + (System.currentTimeMillis() - r0) + "ms.");
    L8:
        return r11;
    }
}
