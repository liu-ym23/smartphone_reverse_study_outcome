package kotlinx.coroutines.flow.internal;

import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J,\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/FusibleFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "fuse", "context", "Lkotlin/coroutines/CoroutineContext;", PerfConsts.KEY_CURRENT_CAPACITY, "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FusibleFlow<T> extends Flow<T> {

    public static final class a {
        public static /* synthetic */ Flow a(FusibleFlow r10, CoroutineContext r11, int r12, BufferOverflow r13, int r14, Object r15) {
            if (r15 != null) goto L15;
            if ((r14 & 1) == 0) goto L7;
            r11 = EmptyCoroutineContext.INSTANCE;
        L7:
            if ((r14 & 2) == 0) goto L10;
            r12 = -3;
        L10:
            if ((r14 & 4) == 0) goto L13;
            r13 = BufferOverflow.SUSPEND;
        L13:
            return r10.fuse(r11, r12, r13);
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    @NotNull
    Flow<T> fuse(@NotNull CoroutineContext r10, int r11, @NotNull BufferOverflow r12);
}
