package com.obric.agent.utils;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16020a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<c> f16021b = null;

    private d() {
    }

    static {
        f16020a = new d();
        f16021b = d.a.p.b(new c[]{p.f16059a, w.f16078a, x.f16079a, v.f16077a});
    }

    public final JSONObject a() {
        long r0 = SystemClock.elapsedRealtime();
        JSONObject r10 = new JSONObject();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(f16021b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.aiagent.plugin");
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L8
        r3.a(r10);     // Catch: Throwable -> L8
        Object r7 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L4;
        ILogDepend.Companion.w("ClientPhoneEnvInfo", "collect " + r3.a() + " env failed", r8);
    L8:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L10
    L13:
        ILogDepend.Companion.i("ClientPhoneEnvInfo", "client env collect total cost=" + (SystemClock.elapsedRealtime() - r0) + "ms");
        return r10;
    }
}
