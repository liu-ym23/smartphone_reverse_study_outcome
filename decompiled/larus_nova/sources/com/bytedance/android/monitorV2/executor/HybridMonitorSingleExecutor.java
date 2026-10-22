package com.bytedance.android.monitorV2.executor;

import com.bytedance.android.monitorV2.util.f;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class HybridMonitorSingleExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f163031a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f163032a;

        public a(Function0<Unit> r100) {
            this.f163032a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function0<Unit> r100 = this.f163032a;     // Catch: Throwable -> L11
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            r100.invoke();     // Catch: Throwable -> L5
            Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);     // Catch: Throwable -> L11
            if (r103 == null) goto L14;
            f.b(r103);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L5:
            th = move-exception;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    static {
        f163031a = LazyKt.lazy(HybridMonitorSingleExecutor$singleExecutorService$2.INSTANCE);
    }

    public static void a(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        ((ExecutorService) f163031a.getValue()).execute(new a(r100));
    }
}
