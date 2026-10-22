package androidx.compose.runtime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class l extends y.j implements d {
    public static final int $stable = 0;
    private a next;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends y.k {

        /* renamed from: c, reason: collision with root package name */
        public long f988c;

        public a(long j10, long j11) {
            super(j10);
            this.f988c = j11;
        }

        @Override // y.k
        public final void a(y.k kVar) {
            kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
            this.f988c = ((a) kVar).f988c;
        }

        @Override // y.k
        public final y.k b(long j10) {
            return new a(j10, this.f988c);
        }
    }

    public l(long j10) {
        y.b bVarB = y.d.b();
        a aVar = new a(bVarB.d(), j10);
        if (!(bVarB instanceof y.a)) {
            aVar.f13949b = new a(1, j10);
        }
        this.next = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n component2$lambda$4(l lVar, long j10) {
        lVar.setLongValue(j10);
        return lb.n.f10413a;
    }

    public zb.l<Long, lb.n> component2() {
        return new i(this, 1);
    }

    @Override // y.i
    public y.k getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.d
    public long getLongValue() {
        return ((a) y.d.h(this.next, this)).f988c;
    }

    public n<Long> getPolicy() {
        return e.f979d;
    }

    public y.k mergeRecords(y.k kVar, y.k kVar2, y.k kVar3) {
        kotlin.jvm.internal.g.d(kVar2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        kotlin.jvm.internal.g.d(kVar3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        if (((a) kVar2).f988c == ((a) kVar3).f988c) {
            return kVar2;
        }
        return null;
    }

    @Override // y.i
    public void prependStateRecord(y.k kVar) {
        kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        this.next = (a) kVar;
    }

    @Override // androidx.compose.runtime.d
    public void setLongValue(long j10) {
        y.b bVarB;
        a aVar = (a) y.d.a(this.next);
        if (aVar.f988c != j10) {
            a aVar2 = this.next;
            synchronized (y.d.f13933b) {
                bVarB = y.d.b();
                ((a) y.d.e(aVar2, this, bVarB, aVar)).f988c = j10;
                lb.n nVar = lb.n.f10413a;
            }
            y.d.d(bVarB, this);
        }
    }

    public String toString() {
        return "MutableLongState(value=" + ((a) y.d.a(this.next)).f988c + ")@" + hashCode();
    }

    /* renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Long m7component1() {
        return Long.valueOf(getLongValue());
    }
}
