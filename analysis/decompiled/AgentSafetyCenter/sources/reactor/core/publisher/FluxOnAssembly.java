package reactor.core.publisher;

import java.io.Serializable;
import java.lang.invoke.VarHandle;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxOnAssembly<T> extends InternalFluxOperator<T, T> implements Fuseable, AssemblyOp {
    final AssemblySnapshot snapshotStack;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CheckpointHeavySnapshot extends AssemblySnapshot {
        public CheckpointHeavySnapshot(@Nullable String str, Supplier<String> supplier) {
            super(true, str, supplier);
        }

        @Override // reactor.core.publisher.FluxOnAssembly.AssemblySnapshot
        public String lightPrefix() {
            StringBuilder sb2 = new StringBuilder("checkpoint(");
            String str = this.description;
            if (str == null) {
                str = "";
            }
            return androidx.activity.b.n(sb2, str, ")");
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CheckpointLightSnapshot extends AssemblySnapshot {
        /* JADX WARN: Multi-variable type inference failed */
        public CheckpointLightSnapshot(@Nullable String str) {
            super(true, str, null);
            this.cached = androidx.activity.b.n(new StringBuilder("checkpoint(\""), str == null ? "" : str, "\")");
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ObservedAtInformationNode implements Serializable {
        private static final long serialVersionUID = 1;

        /* renamed from: id, reason: collision with root package name */
        final int f10644id;
        final String message;
        final String operator;

        @Nullable
        ObservedAtInformationNode parent;
        int occurrenceCounter = 0;
        Set<ObservedAtInformationNode> children = new LinkedHashSet();

        public ObservedAtInformationNode(int i, String str, String str2) {
            this.f10644id = i;
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
                if (this.f10644id == observedAtInformationNode.f10644id && this.operator.equals(observedAtInformationNode.operator) && this.message.equals(observedAtInformationNode.message)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f10644id), this.operator, this.message);
        }

        public void incrementCount() {
            this.occurrenceCounter++;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.operator);
            sb2.append("{@");
            sb2.append(this.f10644id);
            if (this.children.isEmpty()) {
                str = "";
            } else {
                str = ", " + this.children.size() + " children";
            }
            return k0.a.s(sb2, str, '}');
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class OnAssemblyConditionalSubscriber<T> extends OnAssemblySubscriber<T> implements Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super T> actualCS;

        public OnAssemblyConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, AssemblySnapshot assemblySnapshot, qd.c cVar, qd.c cVar2) {
            super(conditionalSubscriber, assemblySnapshot, cVar, cVar2);
            this.actualCS = conditionalSubscriber;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            return this.actualCS.tryOnNext(t10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class OnAssemblySubscriber<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final qd.c current;
        int fusionMode;
        final qd.c parent;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10645s;
        final AssemblySnapshot snapshotStack;

        public OnAssemblySubscriber(CoreSubscriber<? super T> coreSubscriber, AssemblySnapshot assemblySnapshot, qd.c cVar, qd.c cVar2) {
            this.actual = coreSubscriber;
            this.snapshotStack = assemblySnapshot;
            this.parent = cVar;
            this.current = cVar2;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public final void cancel() {
            this.f10645s.cancel();
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
                    StringBuilder sb2 = new StringBuilder();
                    FluxOnAssembly.fillStacktraceHeader(sb2, this.parent.getClass(), this.snapshotStack.getDescription());
                    sb2.append(this.snapshotStack.toAssemblyInformation().replaceFirst("\\n$", ""));
                    onAssemblyException = new OnAssemblyException(sb2.toString());
                }
                th = Exceptions.addSuppressed(th, onAssemblyException);
                StackTraceElement[] stackTrace = th.getStackTrace();
                if (stackTrace.length > 0) {
                    StackTraceElement[] stackTraceElementArr = new StackTraceElement[stackTrace.length];
                    int i3 = 0;
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String className = stackTraceElement.getClassName();
                        if (!className.startsWith("reactor.core.publisher.") || !className.contains("OnAssembly")) {
                            stackTraceElementArr[i3] = stackTraceElement;
                            i3++;
                        }
                    }
                    onAssemblyException.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTraceElementArr, i3));
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public final void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public final void onError(Throwable th) {
            this.actual.onError(fail(th));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public final void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public final void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10645s, eVar)) {
                this.f10645s = eVar;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public final void request(long j10) {
            this.f10645s.request(j10);
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
            return attr == Scannable.Attr.PARENT ? this.f10645s : attr == Scannable.Attr.ACTUAL_METADATA ? Boolean.valueOf(!this.snapshotStack.isCheckpoint) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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

    public static <T> CoreSubscriber<? super T> wrapSubscriber(CoreSubscriber<? super T> coreSubscriber, Flux<? extends T> flux, qd.c cVar, @Nullable AssemblySnapshot assemblySnapshot) {
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class AssemblySnapshot {

        @Nullable
        final Supplier<String> assemblyInformationSupplier;
        String cached;

        @Nullable
        final String description;
        final boolean isCheckpoint;

        public AssemblySnapshot(String str) {
            this.isCheckpoint = false;
            this.description = null;
            this.assemblyInformationSupplier = null;
            this.cached = str;
        }

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
                    od.f.e("assemblyInformation must either be supplied or resolvable");
                    return null;
                }
                this.cached = supplier.get();
            }
            return this.cached;
        }

        public AssemblySnapshot(@Nullable String str, Supplier<String> supplier) {
            this(str != null, str, supplier);
        }

        private AssemblySnapshot(boolean z10, @Nullable String str, @Nullable Supplier<String> supplier) {
            this.isCheckpoint = z10;
            this.description = str;
            this.assemblyInformationSupplier = supplier;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        private void add(qd.c cVar, qd.c cVar2, String str, String str2) {
            ObservedAtInformationNode observedAtInformationNode;
            Scannable scannableOrElse = Scannable.from(cVar2).parents().filter(new m0(1)).findFirst().orElse(null);
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
                    if (scannableOrElse == null || (observedAtInformationNode = this.nodesPerId.get(Integer.valueOf(iIdentityHashCode2))) == null) {
                        this.root.addNode(observedAtInformationNode2);
                    } else {
                        observedAtInformationNode.addNode(observedAtInformationNode2);
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

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$add$0(Scannable scannable) {
            return scannable instanceof AssemblyOp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getMessage$4(StringBuilder sb2, List list) {
            r0 r0Var = new r0(1);
            r0Var.f10851f = this;
            r0Var.f10852g = sb2;
            VarHandle.storeStoreFence();
            list.forEach(r0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$null$3(StringBuilder sb2, ObservedAtInformationNode observedAtInformationNode) {
            ObservedAtInformationNode observedAtInformationNode2 = observedAtInformationNode.parent;
            boolean z10 = observedAtInformationNode2 == null || observedAtInformationNode2 == this.root;
            sb2.append("\t");
            sb2.append(z10 ? "*_" : "|_");
            char c9 = z10 ? '_' : ' ';
            for (int length = observedAtInformationNode.operator.length(); length < this.maxOperatorSize; length++) {
                sb2.append(c9);
            }
            sb2.append(c9);
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

        /* renamed from: findPathToLeaves, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public void lambda$getMessage$2(ObservedAtInformationNode observedAtInformationNode, List<List<ObservedAtInformationNode>> list) {
            if (observedAtInformationNode.children.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                while (observedAtInformationNode != null && observedAtInformationNode != this.root) {
                    linkedList.add(0, observedAtInformationNode);
                    observedAtInformationNode = observedAtInformationNode.parent;
                }
                list.add(linkedList);
                return;
            }
            Set<ObservedAtInformationNode> set = observedAtInformationNode.children;
            q0 q0Var = new q0(1);
            q0Var.f10844f = this;
            q0Var.f10845g = list;
            VarHandle.storeStoreFence();
            set.forEach(q0Var);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            synchronized (this.nodesPerId) {
                try {
                    if (this.root.children.isEmpty()) {
                        return super.getMessage();
                    }
                    StringBuilder sb2 = new StringBuilder(super.getMessage());
                    sb2.append(System.lineSeparator());
                    sb2.append("Error has been observed at the following site(s):");
                    sb2.append(System.lineSeparator());
                    ArrayList arrayList = new ArrayList();
                    Set<ObservedAtInformationNode> set = this.root.children;
                    int i = 0;
                    q0 q0Var = new q0(i);
                    q0Var.f10844f = this;
                    q0Var.f10845g = arrayList;
                    VarHandle.storeStoreFence();
                    set.forEach(q0Var);
                    r0 r0Var = new r0(i);
                    r0Var.f10851f = this;
                    r0Var.f10852g = sb2;
                    VarHandle.storeStoreFence();
                    arrayList.forEach(r0Var);
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
            return localizedMessage == null ? "The stacktrace should have been enhanced by Reactor, but there was no message in OnAssemblyException" : "The stacktrace has been enhanced by Reactor, refer to additional information below: ".concat(localizedMessage);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        public void add(qd.c cVar, qd.c cVar2, AssemblySnapshot assemblySnapshot) {
            if (assemblySnapshot.isCheckpoint()) {
                if (assemblySnapshot.isLight()) {
                    String strLightPrefix = assemblySnapshot.lightPrefix();
                    String description = assemblySnapshot.getDescription();
                    Objects.requireNonNull(description);
                    add(cVar, cVar2, strLightPrefix, description);
                    return;
                }
                String[] strArrExtractOperatorAssemblyInformationParts = Traces.extractOperatorAssemblyInformationParts(assemblySnapshot.toAssemblyInformation());
                if (strArrExtractOperatorAssemblyInformationParts.length > 0) {
                    add(cVar, cVar2, assemblySnapshot.lightPrefix(), strArrExtractOperatorAssemblyInformationParts[strArrExtractOperatorAssemblyInformationParts.length - 1]);
                    return;
                }
                String strLightPrefix2 = assemblySnapshot.lightPrefix();
                String description2 = assemblySnapshot.getDescription();
                Objects.requireNonNull(description2);
                add(cVar, cVar2, strLightPrefix2, description2);
                return;
            }
            String[] strArrExtractOperatorAssemblyInformationParts2 = Traces.extractOperatorAssemblyInformationParts(assemblySnapshot.toAssemblyInformation());
            if (strArrExtractOperatorAssemblyInformationParts2.length > 0) {
                add(cVar, cVar2, strArrExtractOperatorAssemblyInformationParts2.length > 1 ? strArrExtractOperatorAssemblyInformationParts2[0] : "", strArrExtractOperatorAssemblyInformationParts2[strArrExtractOperatorAssemblyInformationParts2.length - 1]);
            }
        }
    }
}
