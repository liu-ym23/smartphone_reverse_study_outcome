package androidx.compose.runtime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class j extends y.j implements b {
    public static final int $stable = 0;
    private a next;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends y.k {

        /* renamed from: c, reason: collision with root package name */
        public float f986c;

        public a(long j10, float f8) {
            super(j10);
            this.f986c = f8;
        }

        @Override // y.k
        public final void a(y.k kVar) {
            kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
            this.f986c = ((a) kVar).f986c;
        }

        @Override // y.k
        public final y.k b(long j10) {
            return new a(j10, this.f986c);
        }
    }

    public j(float f8) {
        y.b bVarB = y.d.b();
        a aVar = new a(bVarB.d(), f8);
        if (!(bVarB instanceof y.a)) {
            aVar.f13949b = new a(1, f8);
        }
        this.next = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n component2$lambda$4(j jVar, float f8) {
        jVar.setFloatValue(f8);
        return lb.n.f10413a;
    }

    public zb.l<Float, lb.n> component2() {
        return new i(this, 0);
    }

    @Override // y.i
    public y.k getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.b
    public float getFloatValue() {
        return ((a) y.d.h(this.next, this)).f986c;
    }

    public n<Float> getPolicy() {
        return e.f979d;
    }

    public y.k mergeRecords(y.k kVar, y.k kVar2, y.k kVar3) {
        kotlin.jvm.internal.g.d(kVar2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        kotlin.jvm.internal.g.d(kVar3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        if (((a) kVar2).f986c == ((a) kVar3).f986c) {
            return kVar2;
        }
        return null;
    }

    @Override // y.i
    public void prependStateRecord(y.k kVar) {
        kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.next = (a) kVar;
    }

    @Override // androidx.compose.runtime.b
    public void setFloatValue(float f8) {
        y.b bVarB;
        a aVar = (a) y.d.a(this.next);
        if (aVar.f986c == f8) {
            return;
        }
        a aVar2 = this.next;
        synchronized (y.d.f13933b) {
            bVarB = y.d.b();
            ((a) y.d.e(aVar2, this, bVarB, aVar)).f986c = f8;
            lb.n nVar = lb.n.f10413a;
        }
        y.d.d(bVarB, this);
    }

    public String toString() {
        return "MutableFloatState(value=" + ((a) y.d.a(this.next)).f986c + ")@" + hashCode();
    }

    /* renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Float m5component1() {
        return Float.valueOf(getFloatValue());
    }
}
