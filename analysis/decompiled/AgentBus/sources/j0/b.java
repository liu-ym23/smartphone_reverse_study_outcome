package j0;

import androidx.lifecycle.v;
import b0.p;
import c7.r;
import p7.n;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5066f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5067g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5068h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f5069i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5070j;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i2, int i10) {
        this.f5066f = i10;
        this.f5068h = obj;
        this.f5069i = obj2;
        this.f5070j = obj3;
        this.f5067g = i2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5066f) {
            case 0:
                ((Integer) obj2).intValue();
                int iS = b0.b.s(this.f5067g) | 1;
                ((d) this.f5068h).f(this.f5069i, this.f5070j, (p) obj, iS);
                break;
            default:
                ((Integer) obj2).intValue();
                nb.i.d((v) this.f5068h, (z2.e) this.f5069i, (p7.k) this.f5070j, (p) obj, b0.b.s(this.f5067g | 1));
                break;
        }
        return r.f1986a;
    }
}
