package l9;

import jb.v;
import k0.h1;
import s1.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7799c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ h1 f7800f;

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f7799c;
        h1 h1Var = this.f7800f;
        switch (i) {
            case 0:
                h1Var.h(((Integer) obj).intValue());
                break;
            default:
                q qVar = (q) obj;
                qVar.getClass();
                h1Var.h((int) (qVar.l() & 4294967295L));
                break;
        }
        return v.f6774a;
    }
}
