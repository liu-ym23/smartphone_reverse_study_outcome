package com.obric.performance.power.monitor.cpu;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.performance.power.monitor.utils.EnsureLoad;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CPUNative.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CPUNative {
    private static final String TAG = "CPUNative";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CPUNative f36957a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Integer, Integer> f36958b;

    private static final native HashMap<String, String> dumpCpuPolicy();

    public static final native CPUInfo dumpNativeCpuTime(boolean r0, boolean r1, boolean r2, int[] r3, boolean r4, boolean r5);

    public static final native long getDeviceCpuTime();

    public static final native long getDeviceIdleTime();

    public static final native long getProcessCpuTime();

    public static final native long[] getThreadArrayCpuTime(int[] r0);

    public static final native long getThreadCpuTime(int r0);

    private CPUNative() {
    }

    static {
        f36957a = new CPUNative();
        EnsureLoad.f37016a.init();
    }

    public final Map<Integer, Integer> a() {
        if (f36958b != null) goto L24;
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (f36958b != null) goto L17;
        HashMap<String, String> r0 = dumpCpuPolicy();     // Catch: Throwable -> L20
        if (r0 == null) goto L15;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r1.size()), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Iterator r3 = r1.entrySet().iterator();     // Catch: Throwable -> L20
    L11:
        if (r3.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        r2.add(s.a(Integer.valueOf(Integer.parseInt(r5)), Integer.valueOf(Integer.parseInt(r6))));     // Catch: Throwable -> L20
        goto L11
    L13:
        Map<Integer, Integer> r7 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L20
        if (r7 == null) goto L15;
    L16:
        f36958b = r7;     // Catch: Throwable -> L20
    L15:
        r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
    L17:
        x r8 = x.f38692a;     // Catch: Throwable -> L20
        monitor-exit(this);
    L24:
        return f36958b;
    }

    public static final CPUInfo a(boolean r2, boolean r3, boolean r4, int[] r5, boolean r6, boolean r7) {
        long r0 = System.currentTimeMillis();
        CPUInfo r8 = dumpNativeCpuTime(r2, r3, r4, r5, r6, r7);
        r8.setRefreshTime(r0);
        a(TAG, r8.toString());
        return r8;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
