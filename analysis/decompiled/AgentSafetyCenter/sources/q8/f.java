package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f10116c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ long f10117f;

    @Override // xb.l
    public final Object invoke(Object obj) throws Exception {
        String str = this.f10116c;
        long j10 = this.f10117f;
        x4.a aVar = (x4.a) obj;
        aVar.getClass();
        x4.c cVarK = aVar.K(str);
        try {
            cVarK.c(1, j10);
            Integer numValueOf = null;
            if (cVarK.G() && !cVarK.isNull(0)) {
                numValueOf = Integer.valueOf((int) cVarK.getLong(0));
            }
            return numValueOf;
        } finally {
            cVarK.close();
        }
    }
}
