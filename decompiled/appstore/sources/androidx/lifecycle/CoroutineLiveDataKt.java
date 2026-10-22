package androidx.lifecycle;

import com.bytedance.apm.constant.PerfConsts;
import kotlin.Function;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineLiveDataKt {

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f3421a;

        public a(Function1 r10) {
            kotlin.jvm.internal.q.g(r10, "function");
            this.f3421a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return kotlin.jvm.internal.q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f3421a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f3421a.invoke(r10);
        }
    }

    public static final Object a(u r10, LiveData r11, Continuation r12) {
        return kotlinx.coroutines.h.g(kotlinx.coroutines.l0.c().e(), new CoroutineLiveDataKt$addDisposableSource$2(r10, r11, null), r12);
    }

    public static final LiveData b(CoroutineContext r10, long r11, Function2 r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r12, "block");
        return new CoroutineLiveData(r10, r11, r12);
    }

    public static /* synthetic */ LiveData c(CoroutineContext r10, long r11, Function2 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
    L9:
        return b(r10, r11, r12);
    }
}
