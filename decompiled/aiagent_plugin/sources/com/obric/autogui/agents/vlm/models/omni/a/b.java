package com.obric.autogui.agents.vlm.models.omni.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: DataFeedbackUploadCountStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f28141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Object> f28142b = null;

    private b() {
    }

    static {
        f28141a = new b();
        f28142b = new ConcurrentHashMap();
    }

    public final Object a(String r3) {
        o.e(r3, "repoName");
        ConcurrentMap r2 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(f28142b, ConcurrentMap.class, "com.obric.aiagent.plugin");
        Object r0 = r2.get(r3);
        if (r0 != null) goto L8;
        r0 = new Object();
        Object r4 = r2.putIfAbsent(r3, r0);
        if (r4 == null) goto L8;
        r0 = r4;
    L8:
        o.c(r0, "getOrPut(...)");
        return r0;
    }
}
