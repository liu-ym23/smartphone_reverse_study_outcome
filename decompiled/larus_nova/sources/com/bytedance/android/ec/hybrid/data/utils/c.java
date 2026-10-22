package com.bytedance.android.ec.hybrid.data.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f46835b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f46836c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f46837a;

    public static final class a {
        public a() {
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.f46837a.execute(r100);
    }

    static {
        f46836c = new a();
        f46835b = new AtomicInteger(1);
    }

    public c(Executor r100) {
        this.f46837a = r100;
    }
}
