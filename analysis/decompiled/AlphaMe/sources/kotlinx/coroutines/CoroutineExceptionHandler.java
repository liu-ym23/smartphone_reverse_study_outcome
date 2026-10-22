package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "Z2/B", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    void handleException(CoroutineContext coroutineContext, Throwable th);
}
