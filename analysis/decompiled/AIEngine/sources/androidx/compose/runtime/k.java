package androidx.compose.runtime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class k extends y.j implements c {
    public static final int $stable = 0;
    private a next;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends y.k {

        /* renamed from: c, reason: collision with root package name */
        public int f987c;

        public a(long j10, int i10) {
            super(j10);
            this.f987c = i10;
        }

        @Override // y.k
        public final void a(y.k kVar) {
            kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
            this.f987c = ((a) kVar).f987c;
        }

        @Override // y.k
        public final y.k b(long j10) {
            return new a(j10, this.f987c);
        }
    }

    public k(int i10) {
        y.b bVarB = y.d.b();
        a aVar = new a(bVarB.d(), i10);
        if (!(bVarB instanceof y.a)) {
            aVar.f13949b = new a(1, i10);
        }
        this.next = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n component2$lambda$4(k kVar, int i10) {
        kVar.setIntValue(i10);
        return lb.n.f10413a;
    }

    public zb.l<Integer, lb.n> component2() {
        return new g(this, 1);
    }

    public final int getDebuggerDisplayValue() {
        return ((a) y.d.a(this.next)).f987c;
    }

    @Override // y.i
    public y.k getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.c
    public int getIntValue() {
        return ((a) y.d.h(this.next, this)).f987c;
    }

    public n<Integer> getPolicy() {
        return e.f979d;
    }

    public y.k mergeRecords(y.k kVar, y.k kVar2, y.k kVar3) {
        kotlin.jvm.internal.g.d(kVar2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        kotlin.jvm.internal.g.d(kVar3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        if (((a) kVar2).f987c == ((a) kVar3).f987c) {
            return kVar2;
        }
        return null;
    }

    @Override // y.i
    public void prependStateRecord(y.k kVar) {
        kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        this.next = (a) kVar;
    }

    @Override // androidx.compose.runtime.c
    public void setIntValue(int i10) {
        y.b bVarB;
        a aVar = (a) y.d.a(this.next);
        if (aVar.f987c != i10) {
            a aVar2 = this.next;
            synchronized (y.d.f13933b) {
                bVarB = y.d.b();
                ((a) y.d.e(aVar2, this, bVarB, aVar)).f987c = i10;
                lb.n nVar = lb.n.f10413a;
            }
            y.d.d(bVarB, this);
        }
    }

    public String toString() {
        return "MutableIntState(value=" + ((a) y.d.a(this.next)).f987c + ")@" + hashCode();
    }

    /* renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Integer m6component1() {
        return Integer.valueOf(getIntValue());
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }
}
