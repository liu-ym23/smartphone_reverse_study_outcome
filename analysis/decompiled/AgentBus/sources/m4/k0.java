package m4;

/* loaded from: classes.dex */
public final class k0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6239f;

    /* renamed from: g, reason: collision with root package name */
    public q0 f6240g;

    /* renamed from: h, reason: collision with root package name */
    public String f6241h;

    /* renamed from: i, reason: collision with root package name */
    public q0 f6242i;

    /* renamed from: j, reason: collision with root package name */
    public String f6243j;

    /* renamed from: k, reason: collision with root package name */
    public int f6244k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ q0 f6245l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f6246m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ a6.w f6247n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k0(int i2, a6.w wVar, g7.d dVar, String str, q0 q0Var) {
        super(2, dVar);
        this.f6239f = i2;
        this.f6245l = q0Var;
        this.f6246m = str;
        this.f6247n = wVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6239f) {
            case 0:
                return new k0(0, this.f6247n, dVar, this.f6246m, this.f6245l);
            case 1:
                return new k0(1, this.f6247n, dVar, this.f6246m, this.f6245l);
            default:
                return new k0(2, this.f6247n, dVar, this.f6246m, this.f6245l);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f6239f) {
        }
        return ((k0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x038d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0584 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0209  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r43) {
        /*
            Method dump skipped, instructions count: 1534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.k0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
