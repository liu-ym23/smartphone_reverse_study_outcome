package com.obric.performance.power.monitor.cpu.exception;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: CPUExceptionThreadFilter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "TCpuFilter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f36982a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Set<Integer> f36983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Set<String> f36984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Set<String> f36985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<String> f36986e = null;

    private c() {
    }

    static {
        f36982a = new c();
        f36983b = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        f36984c = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        f36985d = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        f36986e = ax.b(new String[]{"sleep", "Unsafe.park"});
    }

    public final synchronized void a(Collection<String> r3, Collection<String> r4) {
        monitor-enter(this);
        Collection<? extends String> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        Collection<? extends String> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        o.e(r5, "exactNames");     // Catch: Throwable -> L6
        o.e(r6, "namePrefixes");     // Catch: Throwable -> L6
        f36984c.clear();     // Catch: Throwable -> L6
        f36984c.addAll(r5);     // Catch: Throwable -> L6
        f36985d.clear();     // Catch: Throwable -> L6
        f36985d.addAll(r6);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(int r3, String r4) {
        o.e(r4, "name");
        if (r3 > 0) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (a(r4) == false) goto L15;
        ILogDepend.Companion.d(TAG, "system thread tid:" + r3 + " name:" + r4);
        f36983b.add(Integer.valueOf(r3));
        return;
    L15:
        return;
    L7:
        r0 = false;
        goto L8
    }

    private final boolean a(String r7) {
        if (f36984c.contains(r7) == true) goto L16;
        c r6 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(f36985d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        if (d.o.o.b(r7, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L7;
        return true;
    L12:
        return false;
    L16:
        return true;
    }

    public final void a(int r3) {
        if (r3 <= 0) goto L5;
        ILogDepend.Companion.d(TAG, "skip tid:" + r3);
        f36983b.add(Integer.valueOf(r3));
        return;
    }

    public final boolean b(int r1) {
        if (r1 > 0) goto L4;
    L7:
        return true;
    L4:
        if (f36983b.contains(Integer.valueOf(r1)) == true) goto L7;
        return false;
    }
}
