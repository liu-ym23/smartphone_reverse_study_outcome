package com.obric.cloudsdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/cloudsdk/TaskExecutor;", "", "()V", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "execute", "", "task", "Lkotlin/Function0;", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TaskExecutor {
    public static final TaskExecutor INSTANCE = null;
    private static final ExecutorService executor = null;

    public static /* synthetic */ void $r8$lambda$h2wpXAaXU0ve4yffq7QXQqIoB94(Function0 r0) {
        execute$lambda$0(r0);
    }

    private TaskExecutor() {
    }

    static {
        INSTANCE = new TaskExecutor();
        executor = Executors.newSingleThreadExecutor();
    }

    public final void execute(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        executor.execute(new TaskExecutor$$ExternalSyntheticLambda0(r2));
    }

    private static final void execute$lambda$0(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$task");
        r1.invoke();
    }
}
