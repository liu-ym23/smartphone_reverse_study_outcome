package d7;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class q implements fa.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2975a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2976b;

    public /* synthetic */ q(int i2, Object obj) {
        this.f2975a = i2;
        this.f2976b = obj;
    }

    @Override // fa.j
    public final Iterator iterator() {
        switch (this.f2975a) {
            case 0:
                return q7.k.h((Object[]) this.f2976b);
            case 1:
                return ((Iterable) this.f2976b).iterator();
            case 2:
                return (Iterator) this.f2976b;
            case 3:
                return new fa.h(this);
            default:
                return new n7.n(this);
        }
    }
}
