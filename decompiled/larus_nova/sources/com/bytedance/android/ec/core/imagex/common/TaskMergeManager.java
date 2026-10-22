package com.bytedance.android.ec.core.imagex.common;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class TaskMergeManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f44626e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Runnable> f44627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f44628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f44629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f44630d;

    public static final class a {
    }

    public final class b extends v {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f44631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TaskMergeManager f44632e;

        @Override // com.bytedance.android.ec.core.imagex.common.v
        public final void b() {
        L2:
            Runnable r100 = this.f44632e.f44627a.poll();
            if (r100 == null) goto L13;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            if ((r100 instanceof v) == false) goto L7;
            ((v) r100).f44659a = false;     // Catch: Throwable -> L9
        L7:
            r100.run();     // Catch: Throwable -> L9
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            int r102 = this.f44631d;
            this.f44631d = r102 + 1;
            if (r102 <= this.f44632e.f44629c) goto L2;
        L9:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L13:
            this.f44632e.f44628b.set(false);
            if ((!this.f44632e.f44627a.isEmpty()) == true) goto L16;
            return;
        L16:
            if (this.f44632e.f44628b.compareAndSet(false, true) == false) goto L25;
            TaskMergeManager r104 = this.f44632e;
            r104.f44630d.execute(new b(r104));
            return;
        }

        public b(TaskMergeManager r100) {
            this.f44632e = r100;
            super(null);
        }
    }

    static {
        f44626e = LazyKt.lazy(TaskMergeManager$Companion$enable$2.INSTANCE);
    }

    public final void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        this.f44627a.offer(r100);
        if (this.f44628b.compareAndSet(false, true) == false) goto L6;
        this.f44630d.execute(new b(this));
        return;
    }

    public TaskMergeManager(int r100, Executor r101) {
        Intrinsics.checkNotNullParameter(r101, "executor");
        this.f44629c = r100;
        this.f44630d = r101;
        this.f44627a = new ConcurrentLinkedQueue();
        this.f44628b = new AtomicBoolean(false);
    }
}
