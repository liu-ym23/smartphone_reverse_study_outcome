package androidx.compose.runtime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class m<T> extends y.j {
    public static final int $stable = 0;
    private a<T> next;
    private final n<T> policy;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> extends y.k {

        /* renamed from: c, reason: collision with root package name */
        public T f989c;

        public a(long j10, T t8) {
            super(j10);
            this.f989c = t8;
        }

        @Override // y.k
        public final void a(y.k kVar) {
            kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord>");
            this.f989c = ((a) kVar).f989c;
        }

        @Override // y.k
        public final y.k b(long j10) {
            return new a(y.d.b().d(), this.f989c);
        }
    }

    public m(T t8, n<T> nVar) {
        this.policy = nVar;
        y.b bVarB = y.d.b();
        a<T> aVar = new a<>(bVarB.d(), t8);
        if (!(bVarB instanceof y.a)) {
            aVar.f13949b = new a(1, t8);
        }
        this.next = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n component2$lambda$6(m mVar, Object obj) {
        mVar.setValue(obj);
        return lb.n.f10413a;
    }

    public T component1() {
        return getValue();
    }

    public zb.l<T, lb.n> component2() {
        return new g(this, 2);
    }

    public final T getDebuggerDisplayValue() {
        return ((a) y.d.a(this.next)).f989c;
    }

    @Override // y.i
    public y.k getFirstStateRecord() {
        return this.next;
    }

    public n<T> getPolicy() {
        return this.policy;
    }

    public T getValue() {
        return ((a) y.d.h(this.next, this)).f989c;
    }

    public y.k mergeRecords(y.k kVar, y.k kVar2, y.k kVar3) {
        kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        kotlin.jvm.internal.g.d(kVar2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        kotlin.jvm.internal.g.d(kVar3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        if (getPolicy().a(((a) kVar2).f989c, ((a) kVar3).f989c)) {
            return kVar2;
        }
        getPolicy().getClass();
        return null;
    }

    @Override // y.i
    public void prependStateRecord(y.k kVar) {
        kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        this.next = (a) kVar;
    }

    public void setValue(T t8) {
        y.b bVarB;
        a aVar = (a) y.d.a(this.next);
        if (getPolicy().a(aVar.f989c, t8)) {
            return;
        }
        a<T> aVar2 = this.next;
        synchronized (y.d.f13933b) {
            bVarB = y.d.b();
            ((a) y.d.e(aVar2, this, bVarB, aVar)).f989c = t8;
            lb.n nVar = lb.n.f10413a;
        }
        y.d.d(bVarB, this);
    }

    public String toString() {
        return "MutableState(value=" + ((a) y.d.a(this.next)).f989c + ")@" + hashCode();
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }
}
