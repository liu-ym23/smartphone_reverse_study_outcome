package t;

import java.util.Collection;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12873a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Collection f12874b;

    public /* synthetic */ b(int i10, Collection collection) {
        this.f12873a = i10;
        this.f12874b = collection;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        boolean zContains;
        int i10 = this.f12873a;
        Collection collection = this.f12874b;
        switch (i10) {
            case 0:
                zContains = collection.contains(obj);
                break;
            default:
                zContains = collection.contains(obj);
                break;
        }
        return Boolean.valueOf(zContains);
    }
}
