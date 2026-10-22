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
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
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
            StringBuilder sb = new StringBuilder("checkpoint(");
            String str = this.description;
            if (str == null) {
                str = "";
            }
            return B7.a.q(sb, str, ")");
        }
    }

    public static final class CheckpointLightSnapshot extends AssemblySnapshot {
        /* JADX WARN: Multi-variable type inference failed */
        public CheckpointLightSnapshot(@Nullable String str) {
            super(true, str, null);
            this.cached = B7.a.q(new StringBuilder("checkpoint(\""), str == null ? "" : str, "\")");
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

        public ObservedAtInformationNode(int i, String str, String str2) {
            this.id = i;
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
            StringBuilder sb = new StringBuilder();
            sb.append(this.operator);
            sb.append("{@");
            sb.append(this.id);
            if (this.children.isEmpty()) {
                str = "";
            } else {
                str = ", " + this.children.size() + " children";
            }
            return B7.a.g('}', str, sb);
        }
    }

    public static final class OnAssemblyConditionalSubscriber<T> extends OnAssemblySubscriber<T> implements Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super T> actualCS;

        public OnAssemblyConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, AssemblySnapshot assemblySnapshot, Z9.c cVar, Z9.c cVar2) {
            super(conditionalSubscriber, assemblySnapshot, cVar, cVar2);
            this.actualCS = conditionalSubscriber;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            return this.actualCS.tryOnNext(t9);
        }
    }

    public static class OnAssemblySubscriber<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final Z9.c current;
        int fusionMode;
        final Z9.c parent;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5765s;
        final AssemblySnapshot snapshotStack;

        public OnAssemblySubscriber(CoreSubscriber<? super T> coreSubscriber, AssemblySnapshot assemblySnapshot, Z9.c cVar, Z9.c cVar2) {
            this.actual = coreSubscriber;
            this.snapshotStack = assemblySnapshot;
            this.parent = cVar;
            this.current = cVar2;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public final void cancel() {
            this.f5765s.cancel();
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
            int i = 0;
            while (true) {
                if (i >= length) {
                    onAssemblyException = null;
                    break;
                }
                Throwable th2 = suppressed[i];
                if (th2 instanceof OnAssemblyException) {
                    onAssemblyException = (OnAssemblyException) th2;
                    break;
                }
                i++;
            }
            if (onAssemblyException == null) {
                if (zIsLight) {
                    onAssemblyException = new OnAssemblyException("");
                } else {
                    StringBuilder sb = new StringBuilder();
                    FluxOnAssembly.fillStacktraceHeader(sb, this.parent.getClass(), this.snapshotStack.getDescription());
                    sb.append(this.snapshotStack.toAssemblyInformation().replaceFirst("\\n$", ""));
                    onAssemblyException = new OnAssemblyException(sb.toString());
                }
                th = Exceptions.addSuppressed(th, onAssemblyException);
                StackTraceElement[] stackTrace = th.getStackTrace();
                if (stackTrace.length > 0) {
                    StackTraceElement[] stackTraceElementArr = new StackTraceElement[stackTrace.length];
                    int i6 = 0;
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String className = stackTraceElement.getClassName();
                        if (!className.startsWith("reactor.core.publisher.") || !className.contains("OnAssembly")) {
                            stackTraceElementArr[i6] = stackTraceElement;
                            i6++;
                        }
                    }
                    onAssemblyException.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTraceElementArr, i6));
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public final void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public final void onError(Throwable th) {
            this.actual.onError(fail(th));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public final void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public final void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5765s, eVar)) {
                this.f5765s = eVar;
                this.qs = Operators.as(eVar);
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public final void request(long j5) {
            this.f5765s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public final int requestFusion(int i) {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return 0;
            }
            int iRequestFusion = queueSubscription.requestFusion(i);
            if (iRequestFusion != 0) {
                this.fusionMode = iRequestFusion;
            }
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5765s : attr == Scannable.Attr.ACTUAL_METADATA ? Boolean.valueOf(!this.snapshotStack.isCheckpoint) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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

    public static void fillStacktraceHeader(StringBuilder sb, Class<?> cls, @Nullable String str) {
        sb.append("\nAssembly trace from producer [");
        sb.append(cls.getName());
        sb.append("]");
        if (str != null) {
            androidx.compose.foundation.b.C(sb, ", described as [", str, "]");
        }
        sb.append(" :\n");
    }

    public static <T> CoreSubscriber<? super T> wrapSubscriber(CoreSubscriber<? super T> coreSubscriber, Flux<? extends T> flux, Z9.c cVar, @Nullable AssemblySnapshot assemblySnapshot) {
        return assemblySnapshot != null ? coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new OnAssemblyConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, assemblySnapshot, flux, cVar) : new OnAssemblySubscriber(coreSubscriber, assemblySnapshot, flux, cVar) : coreSubscriber;
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

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$add$0(Scannable scannable) {
            return scannable instanceof AssemblyOp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getMessage$4(StringBuilder sb, List list) {
            list.forEach(new Q(this, sb, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$null$3(StringBuilder sb, ObservedAtInformationNode observedAtInformationNode) {
            ObservedAtInformationNode observedAtInformationNode2 = observedAtInformationNode.parent;
            boolean z10 = observedAtInformationNode2 == null || observedAtInformationNode2 == this.root;
            sb.append("\t");
            sb.append(z10 ? "*_" : "|_");
            char c = z10 ? '_' : ' ';
            for (int length = observedAtInformationNode.operator.length(); length < this.maxOperatorSize; length++) {
                sb.append(c);
            }
            sb.append(c);
            sb.append(observedAtInformationNode.operator);
            sb.append(" ⇢ ");
            sb.append(observedAtInformationNode.message);
            if (observedAtInformationNode.occurrenceCounter > 0) {
                sb.append(" (observed ");
                sb.append(observedAtInformationNode.occurrenceCounter + 1);
                sb.append(" times)");
            }
            sb.append(System.lineSeparator());
        }

        public void add(Z9.c cVar, Z9.c cVar2, AssemblySnapshot assemblySnapshot) {
            if (!assemblySnapshot.isCheckpoint()) {
                String[] strArrExtractOperatorAssemblyInformationParts = Traces.extractOperatorAssemblyInformationParts(assemblySnapshot.toAssemblyInformation());
                if (strArrExtractOperatorAssemblyInformationParts.length > 0) {
                    add(cVar, cVar2, strArrExtractOperatorAssemblyInformationParts.length > 1 ? strArrExtractOperatorAssemblyInformationParts[0] : "", strArrExtractOperatorAssemblyInformationParts[strArrExtractOperatorAssemblyInformationParts.length - 1]);
                    return;
                }
                return;
            }
            if (assemblySnapshot.isLight()) {
                String strLightPrefix = assemblySnapshot.lightPrefix();
                String description = assemblySnapshot.getDescription();
                Objects.requireNonNull(description);
                add(cVar, cVar2, strLightPrefix, description);
                return;
            }
            String[] strArrExtractOperatorAssemblyInformationParts2 = Traces.extractOperatorAssemblyInformationParts(assemblySnapshot.toAssemblyInformation());
            if (strArrExtractOperatorAssemblyInformationParts2.length > 0) {
                add(cVar, cVar2, assemblySnapshot.lightPrefix(), strArrExtractOperatorAssemblyInformationParts2[strArrExtractOperatorAssemblyInformationParts2.length - 1]);
                return;
            }
            String strLightPrefix2 = assemblySnapshot.lightPrefix();
            String description2 = assemblySnapshot.getDescription();
            Objects.requireNonNull(description2);
            add(cVar, cVar2, strLightPrefix2, description2);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        /* renamed from: findPathToLeaves, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public void lambda$getMessage$2(ObservedAtInformationNode observedAtInformationNode, List<List<ObservedAtInformationNode>> list) {
            if (!observedAtInformationNode.children.isEmpty()) {
                observedAtInformationNode.children.forEach(new P(this, list, 1));
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
                    StringBuilder sb = new StringBuilder(super.getMessage());
                    sb.append(System.lineSeparator());
                    sb.append("Error has been observed at the following site(s):");
                    sb.append(System.lineSeparator());
                    ArrayList arrayList = new ArrayList();
                    this.root.children.forEach(new P(this, arrayList, 0));
                    arrayList.forEach(new Q(this, sb, 0));
                    sb.append("Original Stack Trace:");
                    return sb.toString();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Throwable
        public String toString() {
            String localizedMessage = getLocalizedMessage();
            return localizedMessage == null ? "The stacktrace should have been enhanced by Reactor, but there was no message in OnAssemblyException" : "The stacktrace has been enhanced by Reactor, refer to additional information below: ".concat(localizedMessage);
        }

        private void add(Z9.c cVar, Z9.c cVar2, String str, String str2) {
            ObservedAtInformationNode observedAtInformationNode;
            Scannable scannableOrElse = Scannable.from(cVar2).parents().filter(new L(1)).findFirst().orElse(null);
            int iIdentityHashCode = System.identityHashCode(cVar2);
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
