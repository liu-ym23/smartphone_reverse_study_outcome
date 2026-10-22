package com.obric.aiagent.executionengine.eventstaskmanager.timertask;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;

/* JADX INFO: compiled from: TimerTaskRepoDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17908a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final bp f17909b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final bp f17910c = null;

    public static /* synthetic */ Thread lambda$4iREitlivo2Vs9gDT2LpTiAa34E(Runnable r0) {
        return b(r0);
    }

    public static /* synthetic */ Thread lambda$_dAkz0D0CKgcDYybFoietSwz0i8(Runnable r0) {
        return a(r0);
    }

    private c() {
    }

    static {
        f17908a = new c();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$c$_dAkz0D0CKgcDYybFoietSwz0i8.INSTANCE);
        o.c(r0, "newSingleThreadExecutor(...)");
        f17909b = br.a(r0);
        ExecutorService r1 = Executors.newSingleThreadExecutor($$Lambda$c$4iREitlivo2Vs9gDT2LpTiAa34E.INSTANCE);
        o.c(r1, "newSingleThreadExecutor(...)");
        f17910c = br.a(r1);
    }

    public final bp a() {
        return f17909b;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "Timer-task-db-dispatcher");
    }

    public final bp b() {
        return f17910c;
    }

    private static final Thread b(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "plugin-operation-thread");
    }
}
