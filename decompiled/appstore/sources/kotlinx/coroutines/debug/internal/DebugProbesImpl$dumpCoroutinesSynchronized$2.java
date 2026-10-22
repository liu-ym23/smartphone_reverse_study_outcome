package kotlinx.coroutines.debug.internal;

import androidx.appcompat.widget.p;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/debug/internal/c$a;", "it", "", "invoke", "(Lkotlinx/coroutines/debug/internal/c$a;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class DebugProbesImpl$dumpCoroutinesSynchronized$2 extends Lambda implements Function1<c.a, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$2 INSTANCE = null;

    static {
        INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$2();
    }

    public DebugProbesImpl$dumpCoroutinesSynchronized$2() {
        super(1);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(@NotNull c.a r10) {
        return Boolean.valueOf(!c.b(c.f21396a, r10));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(c.a r10) {
        p.a(r10);
        return invoke2(null);
    }
}
