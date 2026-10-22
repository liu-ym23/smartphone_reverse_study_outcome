package h5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends pb.i implements xb.r {

    /* renamed from: c, reason: collision with root package name */
    public int f5349c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Throwable f5350f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ long f5351g;

    @Override // xb.r
    public final Object c(Object obj, Object obj2, Object obj3, Object obj4) {
        long jLongValue = ((Number) obj3).longValue();
        l lVar = new l(4, (nb.c) obj4);
        lVar.f5350f = (Throwable) obj2;
        lVar.f5351g = jLongValue;
        return lVar.invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        int i = this.f5349c;
        if (i == 0) {
            id.c.I(obj);
            Throwable th = this.f5350f;
            long j10 = this.f5351g;
            g5.u.d().c(m.f5352a, "Cannot check for unfinished work", th);
            long jMin = Math.min(j10 * 30000, m.f5353b);
            this.f5349c = 1;
            if (kc.w.g(jMin, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
        }
        return Boolean.TRUE;
    }
}
