package kotlinx.coroutines.internal;

import Z2.y0;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;

@InternalCoroutinesApi
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public interface MainDispatcherFactory {
    y0 createDispatcher(List list);

    int getLoadPriority();

    String hintOnError();
}
