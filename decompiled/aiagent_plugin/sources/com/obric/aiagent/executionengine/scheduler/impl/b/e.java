package com.obric.aiagent.executionengine.scheduler.impl.b;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ExecutorRegistry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f18360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<com.obric.aiagent.executionengine.capabilitymanager.api.a.a, f> f18361b = null;

    private e() {
    }

    static {
        e r0 = new e();
        f18360a = r0;
        f18361b = new ConcurrentHashMap();
        r0.a((f) ZeusTransformUtils.preCheckCast(d.f18358a, f.class, "com.obric.aiagent.plugin"));
        if (Build.VERSION.SDK_INT < 36) goto L6;
        r0.a((f) ZeusTransformUtils.preCheckCast(c.f18351a, f.class, "com.obric.aiagent.plugin"));
        r0.a((f) ZeusTransformUtils.preCheckCast(a.f18344a, f.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void a(f r3) {
        f r2 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        o.e(r2, "executor");
        ((Map) ZeusTransformUtils.preCheckCast(f18361b, Map.class, "com.obric.aiagent.plugin")).put(r2.getType(), r2);
    }

    public final f a(com.obric.aiagent.executionengine.capabilitymanager.api.a.a r3) {
        o.e(r3, "type");
        f r2 = (f) ZeusTransformUtils.preCheckCast(f18361b.get(r3), f.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException(("No ICapabilityExecutor registered for type=" + r3).toString());
    }
}
