package com.obric.performance.power.monitor.a;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AudioMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f36938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f36939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<m<Integer, Long>> f36940d;

    private a() {
    }

    static {
        f36937a = new a();
        f36940d = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
    }

    public static final void a(int r7) {
        List<m<Integer, Long>> r0 = f36940d;
        o.a(r0);
        monitor-enter(r0);
        List<m<Integer, Long>> r1 = f36940d;     // Catch: Throwable -> L26
        o.c(r1, "audioList");     // Catch: Throwable -> L26
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L7;
    L9:
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L26
    L11:
        if (r4.hasNext() == false) goto L18;
        if (((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r4.next(), m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue() != r7) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L11;
    L19:
        if (r3 == false) goto L22;
        monitor-exit(r0);
        return;
    L22:
        f36940d.add(new m(Integer.valueOf(r7), Long.valueOf(SystemClock.uptimeMillis())));     // Catch: Throwable -> L26
        monitor-exit(r0);
        ILogDepend.Companion.d("PowerMonitor", "AudioMonitor onStart: " + r7);
        return;
    L15:
        r5 = false;
    L18:
        r3 = false;
        goto L19
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
    L26:
        th = move-exception;
        throw th;
    }

    public static final void b(int r11) {
        List<m<Integer, Long>> r0 = f36940d;
        o.a(r0);
        monitor-enter(r0);
        List<m<Integer, Long>> r1 = f36940d;     // Catch: Throwable -> L22
        o.c(r1, "audioList");     // Catch: Throwable -> L22
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L22
    L6:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();     // Catch: Throwable -> L22
        if (((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue() != r11) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
    L14:
        m r5 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r5 != null) goto L18;
        monitor-exit(r0);
        return;
    L18:
        f36938b += SystemClock.uptimeMillis() - Math.max(f36939c, ((Number) ZeusTransformUtils.preCheckCast(r5.b(), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L22
        f36940d.remove(r5);     // Catch: Throwable -> L22
        monitor-exit(r0);
        ILogDepend.Companion.d("PowerMonitor", "AudioMonitor onPauseOrStop: " + r11 + ", audioStartTime: " + f36938b);
        return;
    L10:
        r4 = false;
        goto L11
    L13:
        r3 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final int a() {
        return f36940d.size();
    }

    public final void b() {
        f36939c = SystemClock.uptimeMillis();
    }

    public final long c() {
        List<m<Integer, Long>> r12 = f36940d;
        o.c(r12, "audioList");
        monitor-enter(r12);
        List<m<Integer, Long>> r0 = f36940d;     // Catch: Throwable -> L11
        o.c(r0, "audioList");     // Catch: Throwable -> L11
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
        long r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L8;
        r3 = r3 + (SystemClock.uptimeMillis() - Math.max(f36939c, ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r1.next(), m.class, "com.obric.aiagent.plugin")).b(), Number.class, "com.obric.aiagent.plugin")).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r4 = r3 + f36938b;     // Catch: Throwable -> L11
        f36938b = 0;     // Catch: Throwable -> L11
        f36939c = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r12);
        return r4;
    L11:
        th = move-exception;
        throw th;
    }
}
