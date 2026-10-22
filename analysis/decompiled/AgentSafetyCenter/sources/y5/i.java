package y5;

import android.net.Uri;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements f {

    /* renamed from: a, reason: collision with root package name */
    public jb.k f15909a;

    /* renamed from: b, reason: collision with root package name */
    public jb.k f15910b;

    @Override // y5.f
    public final g a(Object obj, e6.m mVar) {
        Uri uri = (Uri) obj;
        if (!yb.k.a(uri.getScheme(), "http") && !yb.k.a(uri.getScheme(), "https")) {
            return null;
        }
        String string = uri.toString();
        jb.k kVar = this.f15909a;
        jb.k kVar2 = this.f15910b;
        l lVar = new l();
        lVar.f15921a = string;
        lVar.f15922b = mVar;
        lVar.f15923c = kVar;
        lVar.f15924d = kVar2;
        VarHandle.storeStoreFence();
        return lVar;
    }
}
