package com.obric.agent.trace;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: CountdownManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f15437a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, d> f15438b = null;

    private c() {
    }

    static {
        f15437a = new c();
        f15438b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r4, long r5) {
        d.h.b.o.e(r4, DbHelper.COL_ID);
        Map<String, d> r3 = f15438b;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r3.remove(r4), d.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.b();
    L5:
        d r1 = new d(r4, r5);
        r3.put(r4, r1);
        r1.a();
    }

    public final void a(String r4) {
        d.h.b.o.e(r4, DbHelper.COL_ID);
        Map<String, d> r3 = f15438b;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r3.get(r4), d.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.b();
    L5:
        r3.remove(r4);
    }
}
