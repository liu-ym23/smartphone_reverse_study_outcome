package o0;

import java.util.Collection;
import java.util.List;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8976c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Collection f8977f;

    @Override // xb.l
    public final Object invoke(Object obj) {
        boolean zContains;
        int i = this.f8976c;
        Collection<?> collection = this.f8977f;
        switch (i) {
            case 0:
                zContains = collection.contains(obj);
                break;
            case 1:
                zContains = collection.contains(obj);
                break;
            default:
                zContains = ((List) obj).retainAll(collection);
                break;
        }
        return Boolean.valueOf(zContains);
    }
}
