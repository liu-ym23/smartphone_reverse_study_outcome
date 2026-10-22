package com.obric.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;

/* JADX INFO: compiled from: ActionDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f14213b = null;

    public static /* synthetic */ Thread lambda$xIBfConbYVJ25CR0_ntb8qxBr0c(Runnable r0) {
        return a(r0);
    }

    private a() {
    }

    static {
        f14212a = new a();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$a$xIBfConbYVJ25CR0_ntb8qxBr0c.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        f14213b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r0), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public final am a() {
        return f14213b;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "action-dispatcher");
    }
}
