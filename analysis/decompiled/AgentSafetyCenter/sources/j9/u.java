package j9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Float f6720c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ float f6721f;

    @Override // xb.l
    public final Object invoke(Object obj) {
        Float f5 = this.f6720c;
        float f10 = this.f6721f;
        ((o2.c) obj).getClass();
        int iQ = ac.a.Q(f5.floatValue() - f10);
        if (iQ < 0) {
            iQ = 0;
        }
        return o2.i.a((iQ & 4294967295L) | (0 << 32));
    }
}
