package androidx.compose.runtime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class h extends y.j implements androidx.compose.runtime.a {
    public static final int $stable = 0;
    private a next;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends y.k {

        /* renamed from: c, reason: collision with root package name */
        public double f983c;

        public a(long j10, double d8) {
            super(j10);
            this.f983c = d8;
        }

        @Override // y.k
        public final void a(y.k kVar) {
            kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
            this.f983c = ((a) kVar).f983c;
        }

        @Override // y.k
        public final y.k b(long j10) {
            return new a(j10, this.f983c);
        }
    }

    public h(double d8) {
        y.b bVarB = y.d.b();
        a aVar = new a(bVarB.d(), d8);
        if (!(bVarB instanceof y.a)) {
            aVar.f13949b = new a(1, d8);
        }
        this.next = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n component2$lambda$4(h hVar, double d8) {
        hVar.setDoubleValue(d8);
        return lb.n.f10413a;
    }

    public zb.l<Double, lb.n> component2() {
        return new g(this, 0);
    }

    @Override // androidx.compose.runtime.a
    public double getDoubleValue() {
        return ((a) y.d.h(this.next, this)).f983c;
    }

    @Override // y.i
    public y.k getFirstStateRecord() {
        return this.next;
    }

    public n<Double> getPolicy() {
        return e.f979d;
    }

    public y.k mergeRecords(y.k kVar, y.k kVar2, y.k kVar3) {
        kotlin.jvm.internal.g.d(kVar2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        kotlin.jvm.internal.g.d(kVar3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        if (((a) kVar2).f983c == ((a) kVar3).f983c) {
            return kVar2;
        }
        return null;
    }

    @Override // y.i
    public void prependStateRecord(y.k kVar) {
        kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        this.next = (a) kVar;
    }

    @Override // androidx.compose.runtime.a
    public void setDoubleValue(double d8) {
        y.b bVarB;
        a aVar = (a) y.d.a(this.next);
        if (aVar.f983c == d8) {
            return;
        }
        a aVar2 = this.next;
        synchronized (y.d.f13933b) {
            bVarB = y.d.b();
            ((a) y.d.e(aVar2, this, bVarB, aVar)).f983c = d8;
            lb.n nVar = lb.n.f10413a;
        }
        y.d.d(bVarB, this);
    }

    public String toString() {
        return "MutableDoubleState(value=" + ((a) y.d.a(this.next)).f983c + ")@" + hashCode();
    }

    /* renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Double m4component1() {
        return Double.valueOf(getDoubleValue());
    }
}
