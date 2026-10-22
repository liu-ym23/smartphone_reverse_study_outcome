package androidx.activity.contextaware;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "onContextAvailable", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ i<R> $co;
    final /* synthetic */ Function1<Context, R> $onContextAvailable;

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Continuation r101 = this.$co;
        Function1<Context, R> r102 = this.$onContextAvailable;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(r102.invoke(r100));     // Catch: Throwable -> L5
    L7:
        r101.resumeWith(r104);
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public ContextAwareKt$withContextAvailable$2$listener$1(i<R> r100, Function1<Context, R> r101) {
        this.$co = r100;
        this.$onContextAvailable = r101;
    }
}
