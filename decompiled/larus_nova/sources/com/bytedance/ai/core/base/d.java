package com.bytedance.ai.core.base;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes43.dex */
public abstract class d extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f36143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f36144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f36145e;

    public d() {
        this(0);
    }

    public abstract void k();

    public abstract long l();

    public d(int r100) {
        CoroutineScope r101 = CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a);
        Intrinsics.checkNotNullParameter(r101, "coroutineScope");
        this.f36143c = r101;
        this.f36144d = new AtomicBoolean(false);
        this.f36148b = new c(this);
    }
}
