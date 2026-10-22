package a2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f82c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f83f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(String str, int i) {
        super(1);
        this.f82c = i;
        this.f83f = str;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f82c;
        jb.v vVar = jb.v.f6774a;
        String str = this.f83f;
        switch (i) {
            case 0:
                fc.c[] cVarArr = w.f144a;
                ((k) obj).d(u.f117a, ac.a.E(str));
                break;
            case 1:
                fc.c[] cVarArr2 = w.f144a;
                x xVar = u.f120d;
                fc.c cVar = w.f144a[2];
                ((k) obj).d(xVar, str);
                break;
            default:
                k kVar = (k) obj;
                fc.c[] cVarArr3 = w.f144a;
                kVar.d(u.f117a, ac.a.E(str));
                w.a(kVar, 5);
                break;
        }
        return vVar;
    }
}
