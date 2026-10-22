package a9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f281c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f282f;

    public /* synthetic */ k(int i) {
        this.f281c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f281c;
        String str = this.f282f;
        switch (i) {
            case 0:
                m mVar = (m) obj;
                mVar.getClass();
                return (l) kb.l.x0(o.h(mVar.f291b, str, true));
            default:
                String str2 = (String) obj;
                str2.getClass();
                return hc.h.g0(str2) ? str2.length() < str.length() ? str : str2 : str.concat(str2);
        }
    }
}
