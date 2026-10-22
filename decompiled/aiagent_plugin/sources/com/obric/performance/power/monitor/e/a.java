package com.obric.performance.power.monitor.e;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CameraMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36995a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f36996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f36997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<m<String, Long>> f36998d;

    private a() {
    }

    static {
        f36995a = new a();
        f36998d = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
    }

    public final int a() {
        return f36998d.size();
    }

    public final void b() {
        f36997c = SystemClock.uptimeMillis();
    }

    public final long c() {
        List<m<String, Long>> r12 = f36998d;
        o.c(r12, "cameraList");
        monitor-enter(r12);
        List<m<String, Long>> r0 = f36998d;     // Catch: Throwable -> L11
        o.c(r0, "cameraList");     // Catch: Throwable -> L11
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
        long r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L8;
        r3 = r3 + (SystemClock.uptimeMillis() - Math.max(f36997c, ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r1.next(), m.class, "com.obric.aiagent.plugin")).b(), Number.class, "com.obric.aiagent.plugin")).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r4 = r3 + f36996b;     // Catch: Throwable -> L11
        f36996b = 0;     // Catch: Throwable -> L11
        f36997c = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r12);
        return r4;
    L11:
        th = move-exception;
        throw th;
    }
}
