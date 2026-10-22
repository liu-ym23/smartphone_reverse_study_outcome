package com.bytedance.dataplatform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Worker.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static ScheduledExecutorService f7952a;

    static {
        f7952a = Executors.newSingleThreadScheduledExecutor();
    }

    public static Future a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        return f7952a.submit(r3);
    }

    public static Future a(Runnable r7, long r8, long r10) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");
        return f7952a.scheduleWithFixedDelay(r1, r8, r10, TimeUnit.MILLISECONDS);
    }
}
