package androidx.work.impl;

import androidx.work.ExistingWorkPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $name;
    final /* synthetic */ n $operation;
    final /* synthetic */ c0 $this_enqueueUniquelyNamedPeriodic;
    final /* synthetic */ androidx.work.l $workRequest;

    public WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1(androidx.work.l r10, c0 r11, String r12, n r13) {
        this.$workRequest = r10;
        this.$this_enqueueUniquelyNamedPeriodic = r11;
        this.$name = r12;
        this.$operation = r13;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List r10 = kotlin.collections.s.e(this.$workRequest);
        new androidx.work.impl.utils.c(new v(this.$this_enqueueUniquelyNamedPeriodic, this.$name, ExistingWorkPolicy.KEEP, r10), this.$operation).run();
    }
}
