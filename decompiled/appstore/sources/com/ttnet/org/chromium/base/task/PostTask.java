package com.ttnet.org.chromium.base.task;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace(TraceStatsConsts.STATS_BASE_MODULE)
public class PostTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f18341a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List f18342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f18343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f18344d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static AtomicReferenceArray f18345e;

    public interface Natives {
        void postDelayedTask(int r10, boolean r11, boolean r12, byte r13, byte[] r14, Runnable r15, long r16);
    }

    static {
        f18341a = new Object();
        f18342b = new ArrayList();
        f18344d = new c();
        f18345e = a();
    }

    public static AtomicReferenceArray a() {
        AtomicReferenceArray r10 = new AtomicReferenceArray(5);
        r10.set(0, new d());
        return r10;
    }

    @CalledByNative
    private static void onNativeSchedulerReady() {
        f18343c = true;
        Object r10 = f18341a;
        monitor-enter(r10);
        List r11 = f18342b;     // Catch: Throwable -> L11
        f18342b = null;     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((TaskRunnerImpl) r12.next()).a();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private static void onNativeSchedulerShutdownForTesting() {
    }
}
