package kotlinx.coroutines.selects;

import androidx.datastore.preferences.protobuf.b1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.a;
import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import lb.n;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SelectImplementation<R> implements CancelHandler, SelectInstance, Waiter {
    private static final /* synthetic */ AtomicReferenceFieldUpdater state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");
    private List<SelectImplementation<R>.ClauseData> clauses;
    private final d context;
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    private Object internalResult;
    private volatile /* synthetic */ Object state$volatile;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class ClauseData {
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment;
        public final q<SelectInstance<?>, Object, Object, q<Throwable, Object, d, n>> onCancellationConstructor;
        private final Object param;
        final /* synthetic */ SelectImplementation<R> this$0;

        public final q<Throwable, Object, d, n> createOnCancellationAction(SelectInstance<?> selectInstance, Object obj) {
            q<SelectInstance<?>, Object, Object, q<Throwable, Object, d, n>> qVar = this.onCancellationConstructor;
            if (qVar != null) {
                return qVar.invoke(selectInstance, this.param, obj);
            }
            return null;
        }

        public final void dispose() {
            Object obj = this.disposableHandleOrSegment;
            SelectImplementation<R> selectImplementation = this.this$0;
            if (obj instanceof Segment) {
                ((Segment) obj).onCancellation(this.indexInSegment, null, selectImplementation.getContext());
                return;
            }
            DisposableHandle disposableHandle = obj instanceof DisposableHandle ? (DisposableHandle) obj : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }
    }

    private final SelectImplementation<R>.ClauseData findClause(Object obj) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ClauseData) next).clauseObject == obj) {
                obj2 = next;
                break;
            }
        }
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj2;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    private final int trySelectInternal(Object obj, Object obj2) {
        while (true) {
            Object obj3 = state$volatile$FU.get(this);
            if (!(obj3 instanceof CancellableContinuation)) {
                if (g.b(obj3, SelectKt.STATE_COMPLETED) || (obj3 instanceof ClauseData)) {
                    return 3;
                }
                if (g.b(obj3, SelectKt.STATE_CANCELLED)) {
                    return 2;
                }
                if (g.b(obj3, SelectKt.STATE_REG)) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
                    List listP = b1.P(obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, listP)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                            break;
                        }
                    }
                    return 1;
                }
                if (!(obj3 instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = state$volatile$FU;
                ArrayList arrayListE0 = a.E0((Collection) obj3, obj);
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj3, arrayListE0)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj3) {
                        break;
                    }
                }
                return 1;
            }
            SelectImplementation<R>.ClauseData clauseDataFindClause = findClause(obj);
            if (clauseDataFindClause != null) {
                q<Throwable, Object, d, n> qVarCreateOnCancellationAction = clauseDataFindClause.createOnCancellationAction(this, obj2);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = state$volatile$FU;
                while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj3, clauseDataFindClause)) {
                    if (atomicReferenceFieldUpdater3.get(this) != obj3) {
                        break;
                    }
                }
                this.internalResult = obj2;
                if (SelectKt.tryResume((CancellableContinuation) obj3, qVarCreateOnCancellationAction)) {
                    return 0;
                }
                this.internalResult = SelectKt.NO_RESULT;
                return 2;
            }
            continue;
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public d getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public void invoke(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.STATE_COMPLETED) {
                return;
            }
            Symbol symbol = SelectKt.STATE_CANCELLED;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            List<SelectImplementation<R>.ClauseData> list = this.clauses;
            if (list == null) {
                return;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((ClauseData) it.next()).dispose();
            }
            this.internalResult = SelectKt.NO_RESULT;
            this.clauses = null;
            return;
        }
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> segment, int i10) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = i10;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(Object obj) {
        this.internalResult = obj;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(Object obj, Object obj2) {
        return trySelectInternal(obj, obj2) == 0;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object obj, Object obj2) {
        return SelectKt.TrySelectDetailedResult(trySelectInternal(obj, obj2));
    }
}
