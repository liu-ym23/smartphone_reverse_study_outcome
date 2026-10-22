package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14730c;

    /* renamed from: f, reason: collision with root package name */
    public int f14731f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f14732g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z f14733h;
    public final /* synthetic */ int i;

    /* renamed from: j, reason: collision with root package name */
    public Object f14734j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(z zVar, int i, nb.c cVar, int i3) {
        super(2, cVar);
        this.f14730c = i3;
        this.f14733h = zVar;
        this.i = i;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f14730c) {
            case 0:
                v vVar = new v(this.f14733h, this.i, cVar, 0);
                vVar.f14732g = ((Boolean) obj).booleanValue();
                return vVar;
            default:
                v vVar2 = new v(this.f14733h, this.i, cVar, 1);
                vVar2.f14732g = ((Boolean) obj).booleanValue();
                return vVar2;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f14730c;
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        nb.c cVar = (nb.c) obj2;
        switch (i) {
        }
        return ((v) create(bool, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.v.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
