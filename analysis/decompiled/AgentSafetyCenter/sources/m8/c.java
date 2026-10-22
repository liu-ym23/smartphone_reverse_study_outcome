package m8;

import android.content.res.Resources;
import s8.p3;
import s8.x0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8317c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Resources f8318f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ k0 f8319g;

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f8317c) {
            case 0:
                Resources resources = this.f8318f;
                k0 k0Var = this.f8319g;
                p3 p3Var = (p3) obj;
                p3Var.getClass();
                resources.getClass();
                return x0.q(p3Var, resources, k0Var.f8420d);
            default:
                return x0.q((p3) obj, this.f8318f, this.f8319g.f8420d);
        }
    }
}
