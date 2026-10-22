package com.obric.aiagent.executionengine.scheduler.impl.execution.b;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: UriSharingRecords.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String TAG = "UriSharingRecords";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f18404b = null;

    private c() {
    }

    static {
        f18403a = new c();
        f18404b = new ConcurrentHashMap();
    }

    public final void a(a r4) {
        o.e(r4, "record");
        String r3 = r4.a();
        ((Map) ZeusTransformUtils.preCheckCast(f18404b, Map.class, "com.obric.aiagent.plugin")).put(r3, r4);
        ILogDepend.Companion.d(TAG, "add sharing record: " + r3);
    }

    public final void b(a r3) {
        o.e(r3, "record");
        String r2 = r3.a();
        f18404b.remove(r2);
        ILogDepend.Companion.d(TAG, "remove sharing record: " + r2);
    }

    public final boolean c(a r1) {
        o.e(r1, "record");
        return f18404b.containsKey(r1.a());
    }
}
