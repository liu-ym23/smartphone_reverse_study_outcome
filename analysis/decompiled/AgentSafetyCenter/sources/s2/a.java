package s2;

import java.lang.invoke.VarHandle;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11336c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m f11337f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(m mVar, int i) {
        super(1);
        this.f11336c = i;
        this.f11337f = mVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f11336c;
        m mVar = this.f11337f;
        switch (i) {
            case 0:
                b.c cVar = new b.c(3);
                cVar.f1687b = mVar;
                VarHandle.storeStoreFence();
                return cVar;
            default:
                if (mVar.i.f11354a) {
                    mVar.f11361h.invoke();
                }
                return v.f6774a;
        }
    }
}
