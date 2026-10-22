package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task;

import com.bytedance.android.livesdk.config.qe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t¨\u0006\n"}, d2 = {"executeTask", "", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasAsyncExecutor;", "name", "", "runnable", "Ljava/lang/Runnable;", "degradeCallback", "Lkotlin/Function0;", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasAsyncDegradeCallback;", "infrastructure_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class AtlasAsyncExtKt {
    public static final void executeTask(AtlasAsyncExecutor r100, String r101, Runnable r102, AtlasAsyncDegradeCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$executeTask");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "runnable");
        Intrinsics.checkNotNullParameter(r103, "degradeCallback");
        if (qe.f121048a.getValue().a() == false) goto L5;
        r100.executeLiveAsyncTask(r101, r102);
        return;
    L5:
        r103.call();
    }

    public static final void executeTask(AtlasAsyncExecutor r100, String r101, Runnable r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$executeTask");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "runnable");
        Intrinsics.checkNotNullParameter(r103, "degradeCallback");
        if (qe.f121048a.getValue().a() == false) goto L5;
        r100.executeLiveAsyncTask(r101, r102);
        return;
    L5:
        r103.invoke();
    }
}
