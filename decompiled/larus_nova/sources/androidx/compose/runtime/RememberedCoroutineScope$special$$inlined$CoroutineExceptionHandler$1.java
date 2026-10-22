package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ CompositionErrorContextImpl $traceContext$inlined;
    final /* synthetic */ RememberedCoroutineScope this$0;

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext r100, Throwable r101) {
        this.$traceContext$inlined.attachComposeStackTrace(r101, this.this$0);
        CoroutineContext r102 = RememberedCoroutineScope.access$getOverlayContext$p(this.this$0);
        CoroutineExceptionHandler.Key r103 = CoroutineExceptionHandler.Key;
        CoroutineExceptionHandler r104 = (CoroutineExceptionHandler) r102.get(r103);
        if (r104 == null) goto L5;
        r104.handleException(r100, r101);
        return;
    L5:
        CoroutineExceptionHandler r105 = (CoroutineExceptionHandler) RememberedCoroutineScope.access$getParentContext$p(this.this$0).get(r103);
        if (r105 == null) goto L9;
        r105.handleException(r100, r101);
        return;
    L9:
        throw r101;
    }

    public RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key r100, CompositionErrorContextImpl r101, RememberedCoroutineScope r102) {
        this.$traceContext$inlined = r101;
        this.this$0 = r102;
        super(r100);
    }
}
