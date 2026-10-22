package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxOnAssembly;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoOnAssembly<T> extends InternalMonoOperator<T, T> implements Fuseable, AssemblyOp {
    final FluxOnAssembly.AssemblySnapshot stacktrace;

    public MonoOnAssembly(Mono<? extends T> mono, FluxOnAssembly.AssemblySnapshot assemblySnapshot) {
        super(mono);
        this.stacktrace = assemblySnapshot;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.ACTUAL_METADATA ? Boolean.valueOf(!this.stacktrace.isCheckpoint) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        return this.stacktrace.operatorAssemblyInformation();
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        boolean z10 = coreSubscriber instanceof Fuseable.ConditionalSubscriber;
        FluxOnAssembly.AssemblySnapshot assemblySnapshot = this.stacktrace;
        return z10 ? new FluxOnAssembly.OnAssemblyConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, assemblySnapshot, this.source, this) : new FluxOnAssembly.OnAssemblySubscriber(coreSubscriber, assemblySnapshot, this.source, this);
    }

    @Override // reactor.core.publisher.Mono
    public String toString() {
        return this.stacktrace.operatorAssemblyInformation();
    }
}
