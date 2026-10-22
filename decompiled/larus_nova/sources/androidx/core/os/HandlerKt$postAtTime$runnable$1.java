package androidx.core.os;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 8, 0}, xi = 176)
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ Function0<Unit> $action;

    public HandlerKt$postAtTime$runnable$1(Function0<Unit> r100) {
        this.$action = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        androidx_core_os_HandlerKt$postAtTime$runnable$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void androidx_core_os_HandlerKt$postAtTime$runnable$1__run$___twin___() {
        this.$action.invoke();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_core_os_HandlerKt$postAtTime$runnable$1_com_larus_apm_impl_protector_RunnableLancet_run(HandlerKt$postAtTime$runnable$1 r100) {
        r100.androidx_core_os_HandlerKt$postAtTime$runnable$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
