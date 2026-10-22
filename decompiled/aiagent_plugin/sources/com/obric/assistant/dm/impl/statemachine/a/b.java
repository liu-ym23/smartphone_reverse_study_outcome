package com.obric.assistant.dm.impl.statemachine.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.g;
import d.h.b.o;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;

/* JADX INFO: compiled from: DMScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f22508b = null;

    /* JADX INFO: renamed from: lambda$MlpUAN0f5-rRLP6jicI0qf6AwQM, reason: not valid java name */
    public static /* synthetic */ Thread m424lambda$MlpUAN0f5rRLP6jicI0qf6AwQM(Runnable r0) {
        return a(r0);
    }

    private b() {
    }

    static {
        f22507a = new b();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$b$MlpUAN0f5rRLP6jicI0qf6AwQM.INSTANCE);
        o.c(r0, "newSingleThreadExecutor(...)");
        f22508b = an.a((g) ZeusTransformUtils.preCheckCast(br.a(r0), g.class, "com.obric.aiagent.plugin"));
    }

    public final am a() {
        return f22508b;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "dm-dispatcher");
    }
}
