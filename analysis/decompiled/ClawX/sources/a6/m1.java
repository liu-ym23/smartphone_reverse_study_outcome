package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m1 extends m {

    /* renamed from: j, reason: collision with root package name */
    public final p1 f193j;

    public m1(f5.c cVar, p1 p1Var) {
        super(1, cVar);
        this.f193j = p1Var;
    }

    @Override // a6.m
    public final Throwable r(p1 p1Var) {
        Throwable thC;
        p1 p1Var2 = this.f193j;
        p1Var2.getClass();
        Object obj = p1.f206a.get(p1Var2);
        return (!(obj instanceof o1) || (thC = ((o1) obj).c()) == null) ? obj instanceof v ? ((v) obj).f222a : p1Var.v() : thC;
    }

    @Override // a6.m
    public final String z() {
        return "AwaitContinuation";
    }
}
