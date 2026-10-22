package f0;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3328f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Collection f3329g;

    public /* synthetic */ b(int i2, Collection collection) {
        this.f3328f = i2;
        this.f3329g = collection;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        boolean zContains;
        int i2 = this.f3328f;
        Collection<?> collection = this.f3329g;
        switch (i2) {
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
