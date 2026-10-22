package p5;

import java.util.HashMap;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9787c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ s f9788f;

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f9787c;
        s sVar = this.f9788f;
        HashMap map = (HashMap) obj;
        switch (i) {
            case 0:
                sVar.b(map);
                break;
            default:
                sVar.a(map);
                break;
        }
        return v.f6774a;
    }
}
