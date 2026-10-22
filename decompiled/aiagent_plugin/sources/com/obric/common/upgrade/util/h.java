package com.obric.common.upgrade.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: ThreadPoolUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f32659a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f32660b = null;

    private h() {
    }

    static {
        f32659a = new h();
        ExecutorService r0 = Executors.newFixedThreadPool(3);
        o.c(r0, "newFixedThreadPool(3)");
        f32660b = r0;
    }

    public final void a(Runnable r2) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        o.e(r1, "task");
        f32660b.execute(r1);
    }
}
