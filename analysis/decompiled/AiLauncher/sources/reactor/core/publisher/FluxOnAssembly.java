package reactor.core.publisher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxOnAssembly;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxOnAssembly<T> extends InternalFluxOperator<T, T> implements Fuseable, AssemblyOp {
    final AssemblySnapshot snapshotStack;

    public static class AssemblySnapshot {

        @Nullable
        final Supplier<String> assemblyInformationSupplier;
        String cached;

        @Nullable
        final String description;
        final boolean isCheckpoint;

        @Nullable
        public String getDescription() {
            return this.description;
        }

        public boolean hasDescription() {
            return this.description != null;
        }

        public boolean isCheckpoint() {
            return this.isCheckpoint;
        }

        public boolean isLight() {
            return false;
        }

        public String lightPrefix() {
            return "";
        }

        public String operatorAssemblyInformation() {
            return Traces.extractOperatorAssemblyInformation(toAssemblyInformation());
        }

        public String toAssemblyInformation() {
            if (this.cached == null) {
                Supplier<String> supplier = this.assemblyInformationSupplier;
                if (supplier == null) {
                    throw new IllegalStateException("assemblyInformation must either be supplied or resolvable");
                }
                this.cached = supplier.get();
            }
            return this.cached;
        }

        public AssemblySnapshot(@Nullable String str, Supplier<String> supplier) {
            this(str != null, str, supplier);
        }

        public AssemblySnapshot(String str) {
            this.isCheckpoint = false;
            this.description = null;
            this.assemblyInformationSupplier = null;
            this.cached = str;
        }

        private AssemblySnapshot(boolean z10, @Nullable String str, @Nullable Supplier<String> supplier) {
            this.isCheckpoint = z10;
            this.description = str;
            this.assemblyInformationSupplier = supplier;
        }
    }

    public static final class CheckpointHeavySnapshot extends AssemblySnapshot {
        public CheckpointHeavySnapshot(@Nullable String str, Supplier<String> supplier) {
            super(true, str, supplier);
        }

        @Override // reactor.core.publisher.FluxOnAssembly.AssemblySnapshot
        public String lightPrefix() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkpoint(");
            String str = this.description;
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class CheckpointLightSnapshot extends AssemblySnapshot {
        /* JADX WARN: Multi-variable type inference failed */
        public CheckpointLightSnapshot(@Nullable String str) {
            super(true, str, null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkpoint(\"");
            sb2.append(str == null ? "" : str);
            sb2.append("\")");
            this.cached = sb2.toString();
        }

        @Override // reactor.core.publisher.FluxOnAssembly.AssemblySnapshot
        public boolean isLight() {
            return true;
        }

        @Override // reactor.core.publisher.FluxOnAssembly.AssemblySnapshot
        public String lightPrefix() {
            return "checkpoint";
        }

        @Override // reactor.core.publisher.FluxOnAssembly.AssemblySnapshot
        public String operatorAssemblyInformation() {
            return this.cached;
        }
    }

    public static final class MethodReturnSnapshot extends AssemblySnapshot {
        /* JADX WARN: Multi-variable type inference failed */
        public MethodReturnSnapshot(String str) {
            super(false, str, null);
            this.cached = str;
        }

        @Override // reactor.core.publisher.FluxOnAssembly.AssemblySnapshot
        public boolean isLight() {
            return true;
        }

        @Override // reactor.core.publisher.FluxOnAssembly.AssemblySnapshot
        public String operatorAssemblyInformation() {
            return this.cached;
        }
    }

    public static final class ObservedAtInformationNode implements Serializable {
        private static final long serialVersionUID = 1;
        final int id;
        final String message;
        final String operator;

        @Nullable
        ObservedAtInformationNode parent;
        int occurrenceCounter = 0;
        Set<ObservedAtInformationNode> children = new LinkedHashSet();

        public ObservedAtInformationNode(int i10, String str, String str2) {
            this.id = i10;
            this.operator = str;
            this.message = str2;
        }

        public void addNode(ObservedAtInformationNode observedAtInformationNode) {
            if (this != observedAtInformationNode && this.children.add(observedAtInformationNode)) {
                observedAtInformationNode.parent = this;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ObservedAtInformationNode.class == obj.getClass()) {
                ObservedAtInformationNode observedAtInformationNode = (ObservedAtInformationNode) obj;
                if (this.id == observedAtInformationNode.id && this.operator.equals(observedAtInformationNode.operator) && this.message.equals(observedAtInformationNode.message)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.id), this.operator, this.message);
        }

        public void incrementCount() {
            this.occurrenceCounter++;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.operator);
            sb2.append("{@");
            sb2.append(this.id);
            if (this.children.isEmpty()) {
                str = "";
            } else {
                str = ", " + this.children.size() + " children";
            }
            sb2.append(str);
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static final class OnAssemblyConditionalSubscriber<T> extends OnAssemblySubscriber<T> implements Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super T> actualCS;

        public OnAssemblyConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, AssemblySnapshot assemblySnapshot, qc.b<?> bVar, qc.b<?> bVar2) {
            super(conditionalSubscriber, assemblySnapshot, bVar, bVar2);
            this.actualCS = conditionalSubscriber;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            return this.actualCS.tryOnNext(t10);
        }
    }

    public static class OnAssemblySubscriber<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final qc.b<?> current;
        int fusionMode;
        final qc.b<?> parent;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39535s;
        final AssemblySnapshot snapshotStack;

        public OnAssemblySubscriber(CoreSubscriber<? super T> coreSubscriber, AssemblySnapshot assemblySnapshot, qc.b<?> bVar, qc.b<?> bVar2) {
            this.actual = coreSubscriber;
            this.snapshotStack = assemblySnapshot;
            this.parent = bVar;
            this.current = bVar2;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public final void cancel() {
            this.f39535s.cancel();
        }

        @Override // java.util.Collection
        public final void clear() {
            this.qs.clear();
        }

        public final Throwable fail(Throwable th) {
            OnAssemblyException onAssemblyException;
            boolean zIsLight = this.snapshotStack.isLight();
            Throwable[] suppressed = th.getSuppressed();
            int length = suppressed.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    onAssemblyException = null;
                    break;
                }
                Throwable th2 = suppressed[i10];
                if (th2 instanceof OnAssemblyException) {
                    onAssemblyException = (OnAssemblyException) th2;
                    break;
                }
                i10++;
            }
            if (onAssemblyException == null) {
                if (zIsLight) {
                    onAssemblyException = new OnAssemblyException("");
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    FluxOnAssembly.fillStacktraceHeader(sb2, this.parent.getClass(), this.snapshotStack.getDescription());
                    sb2.append(this.snapshotStack.toAssemblyInformation().replaceFirst("\\n$", ""));
                    onAssemblyException = new OnAssemblyException(sb2.toString());
                }
                th = Exceptions.addSuppressed(th, onAssemblyException);
                StackTraceElement[] stackTrace = th.getStackTrace();
                if (stackTrace.length > 0) {
                    StackTraceElement[] stackTraceElementArr = new StackTraceElement[stackTrace.length];
                    int i11 = 0;
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String className = stackTraceElement.getClassName();
                        if (!className.startsWith("reactor.core.publisher.") || !className.contains("OnAssembly")) {
                            stackTraceElementArr[i11] = stackTraceElement;
                            i11++;
                        }
                    }
                    onAssemblyException.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTraceElementArr, i11));
                    th.setStackTrace(new StackTraceElement[]{stackTrace[0]});
                }
            }
            onAssemblyException.add(this.parent, this.current, this.snapshotStack);
            return th;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            try {
                return this.qs.isEmpty();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw Exceptions.propagate(this.fail(th));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public final void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public final void onError(Throwable th) {
            this.actual.onError(fail(th));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public final void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public final void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39535s, dVar)) {
                this.f39535s = dVar;
                this.qs = Operators.as(dVar);
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public final T poll() {
            try {
                return this.qs.poll();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw Exceptions.propagate(this.fail(th));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public final void request(long j10) {
            this.f39535s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public final int requestFusion(int i10) {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return 0;
            }
            int iRequestFusion = queueSubscription.requestFusion(i10);
            if (iRequestFusion != 0) {
                this.fusionMode = iRequestFusion;
            }
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39535s : attr == Scannable.Attr.ACTUAL_METADATA ? Boolean.valueOf(!this.snapshotStack.isCheckpoint) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public final int size() {
            return this.qs.size();
        }

        @Override // reactor.core.Scannable
        public String stepName() {
            return toString();
        }

        public String toString() {
            return this.snapshotStack.operatorAssemblyInformation();
        }
    }

    public FluxOnAssembly(Flux<? extends T> flux, AssemblySnapshot assemblySnapshot) {
        super(flux);
        this.snapshotStack = assemblySnapshot;
    }

    public static void fillStacktraceHeader(StringBuilder sb2, Class<?> cls, @Nullable String str) {
        sb2.append("\nAssembly trace from producer [");
        sb2.append(cls.getName());
        sb2.append("]");
        if (str != null) {
            sb2.append(", described as [");
            sb2.append(str);
            sb2.append("]");
        }
        sb2.append(" :\n");
    }

    public static <T> CoreSubscriber<? super T> wrapSubscriber(CoreSubscriber<? super T> coreSubscriber, Flux<? extends T> flux, qc.b<?> bVar, @Nullable AssemblySnapshot assemblySnapshot) {
        return assemblySnapshot != null ? coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new OnAssemblyConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, assemblySnapshot, flux, bVar) : new OnAssemblySubscriber(coreSubscriber, assemblySnapshot, flux, bVar) : coreSubscriber;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.ACTUAL_METADATA ? Boolean.valueOf(!this.snapshotStack.isCheckpoint) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        return this.snapshotStack.operatorAssemblyInformation();
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return wrapSubscriber(coreSubscriber, this.source, this, this.snapshotStack);
    }

    @Override // reactor.core.publisher.Flux
    public String toString() {
        return this.snapshotStack.operatorAssemblyInformation();
    }

    public static final class OnAssemblyException extends RuntimeException {
        private static final long serialVersionUID = -6342981676020433721L;
        int maxOperatorSize;
        final Map<Integer, ObservedAtInformationNode> nodesPerId;
        final ObservedAtInformationNode root;

        public OnAssemblyException(String str) {
            super(str);
            this.nodesPerId = new HashMap();
            this.root = new ObservedAtInformationNode(-1, "ROOT", "ROOT");
            this.maxOperatorSize = 0;
        }

        public static /* synthetic */ void b(final OnAssemblyException onAssemblyException, final StringBuilder sb2, List list) {
            onAssemblyException.getClass();
            list.forEach(new Consumer() { // from class: reactor.core.publisher.O0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    FluxOnAssembly.OnAssemblyException.c(this.f39682a, sb2, (FluxOnAssembly.ObservedAtInformationNode) obj);
                }
            });
        }

        public static /* synthetic */ void c(OnAssemblyException onAssemblyException, StringBuilder sb2, ObservedAtInformationNode observedAtInformationNode) {
            onAssemblyException.getClass();
            ObservedAtInformationNode observedAtInformationNode2 = observedAtInformationNode.parent;
            boolean z10 = observedAtInformationNode2 == null || observedAtInformationNode2 == onAssemblyException.root;
            sb2.append("\t");
            sb2.append(z10 ? "*_" : "|_");
            char c10 = z10 ? '_' : ' ';
            for (int length = observedAtInformationNode.operator.length(); length < onAssemblyException.maxOperatorSize; length++) {
                sb2.append(c10);
            }
            sb2.append(c10);
            sb2.append(observedAtInformationNode.operator);
            sb2.append(" ⇢ ");
            sb2.append(observedAtInformationNode.message);
            if (observedAtInformationNode.occurrenceCounter > 0) {
                sb2.append(" (observed ");
                sb2.append(observedAtInformationNode.occurrenceCounter + 1);
                sb2.append(" times)");
            }
            sb2.append(System.lineSeparator());
        }

        public static /* synthetic */ boolean e(Scannable scannable) {
            return scannable instanceof AssemblyOp;
        }

        public void add(qc.b<?> bVar, qc.b<?> bVar2, AssemblySnapshot assemblySnapshot) {
            if (!assemblySnapshot.isCheckpoint()) {
                String[] strArrExtractOperatorAssemblyInformationParts = Traces.extractOperatorAssemblyInformationParts(assemblySnapshot.toAssemblyInformation());
                if (strArrExtractOperatorAssemblyInformationParts.length > 0) {
                    add(bVar, bVar2, strArrExtractOperatorAssemblyInformationParts.length > 1 ? strArrExtractOperatorAssemblyInformationParts[0] : "", strArrExtractOperatorAssemblyInformationParts[strArrExtractOperatorAssemblyInformationParts.length - 1]);
                    return;
                }
                return;
            }
            if (assemblySnapshot.isLight()) {
                String strLightPrefix = assemblySnapshot.lightPrefix();
                String description = assemblySnapshot.getDescription();
                Objects.requireNonNull(description);
                add(bVar, bVar2, strLightPrefix, description);
                return;
            }
            String[] strArrExtractOperatorAssemblyInformationParts2 = Traces.extractOperatorAssemblyInformationParts(assemblySnapshot.toAssemblyInformation());
            if (strArrExtractOperatorAssemblyInformationParts2.length > 0) {
                add(bVar, bVar2, assemblySnapshot.lightPrefix(), strArrExtractOperatorAssemblyInformationParts2[strArrExtractOperatorAssemblyInformationParts2.length - 1]);
                return;
            }
            String strLightPrefix2 = assemblySnapshot.lightPrefix();
            String description2 = assemblySnapshot.getDescription();
            Objects.requireNonNull(description2);
            add(bVar, bVar2, strLightPrefix2, description2);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        public void findPathToLeaves(ObservedAtInformationNode observedAtInformationNode, final List<List<ObservedAtInformationNode>> list) {
            if (!observedAtInformationNode.children.isEmpty()) {
                observedAtInformationNode.children.forEach(new Consumer() { // from class: reactor.core.publisher.P0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f39690a.findPathToLeaves((FluxOnAssembly.ObservedAtInformationNode) obj, list);
                    }
                });
                return;
            }
            LinkedList linkedList = new LinkedList();
            while (observedAtInformationNode != null && observedAtInformationNode != this.root) {
                linkedList.add(0, observedAtInformationNode);
                observedAtInformationNode = observedAtInformationNode.parent;
            }
            list.add(linkedList);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            synchronized (this.nodesPerId) {
                try {
                    if (this.root.children.isEmpty()) {
                        return super.getMessage();
                    }
                    final StringBuilder sb2 = new StringBuilder(super.getMessage());
                    sb2.append(System.lineSeparator());
                    sb2.append("Error has been observed at the following site(s):");
                    sb2.append(System.lineSeparator());
                    final ArrayList arrayList = new ArrayList();
                    this.root.children.forEach(new Consumer() { // from class: reactor.core.publisher.M0
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            this.f39642a.findPathToLeaves((FluxOnAssembly.ObservedAtInformationNode) obj, arrayList);
                        }
                    });
                    arrayList.forEach(new Consumer() { // from class: reactor.core.publisher.N0
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            FluxOnAssembly.OnAssemblyException.b(this.f39678a, sb2, (List) obj);
                        }
                    });
                    sb2.append("Original Stack Trace:");
                    return sb2.toString();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Throwable
        public String toString() {
            String localizedMessage = getLocalizedMessage();
            if (localizedMessage == null) {
                return "The stacktrace should have been enhanced by Reactor, but there was no message in OnAssemblyException";
            }
            return "The stacktrace has been enhanced by Reactor, refer to additional information below: " + localizedMessage;
        }

        private void add(qc.b<?> bVar, qc.b<?> bVar2, String str, String str2) {
            ObservedAtInformationNode observedAtInformationNode;
            Scannable scannableOrElse = Scannable.from(bVar2).parents().filter(new Predicate() { // from class: reactor.core.publisher.L0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return FluxOnAssembly.OnAssemblyException.e((Scannable) obj);
                }
            }).findFirst().orElse(null);
            int iIdentityHashCode = System.identityHashCode(bVar2);
            int iIdentityHashCode2 = System.identityHashCode(scannableOrElse);
            synchronized (this.nodesPerId) {
                try {
                    ObservedAtInformationNode observedAtInformationNode2 = this.nodesPerId.get(Integer.valueOf(iIdentityHashCode));
                    if (observedAtInformationNode2 != null) {
                        observedAtInformationNode2.incrementCount();
                    } else {
                        observedAtInformationNode2 = new ObservedAtInformationNode(iIdentityHashCode, str, str2);
                        this.nodesPerId.put(Integer.valueOf(iIdentityHashCode), observedAtInformationNode2);
                    }
                    if (scannableOrElse != null && (observedAtInformationNode = this.nodesPerId.get(Integer.valueOf(iIdentityHashCode2))) != null) {
                        observedAtInformationNode.addNode(observedAtInformationNode2);
                    } else {
                        this.root.addNode(observedAtInformationNode2);
                    }
                    int length = observedAtInformationNode2.operator.length();
                    if (length > this.maxOperatorSize) {
                        this.maxOperatorSize = length;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
