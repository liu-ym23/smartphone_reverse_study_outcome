package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10114c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ long f10115f;

    @Override // xb.l
    public final Object invoke(Object obj) throws Exception {
        x4.c cVarK;
        switch (this.f10114c) {
            case 0:
                long j10 = this.f10115f;
                x4.a aVar = (x4.a) obj;
                aVar.getClass();
                cVarK = aVar.K("SELECT result_json FROM dashboard_days WHERE day_start_millis = ? LIMIT 1");
                try {
                    cVarK.c(1, j10);
                    String strZ = null;
                    if (cVarK.G() && !cVarK.isNull(0)) {
                        strZ = cVarK.z(0);
                    }
                    return strZ;
                } finally {
                }
            default:
                long j11 = this.f10115f;
                x4.a aVar2 = (x4.a) obj;
                aVar2.getClass();
                cVarK = aVar2.K("DELETE FROM dashboard_days WHERE day_start_millis = ?");
                try {
                    cVarK.c(1, j11);
                    cVarK.G();
                    cVarK.close();
                    return jb.v.f6774a;
                } finally {
                }
        }
    }
}
