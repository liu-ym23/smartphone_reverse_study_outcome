package W9;

import W9.F;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public class E implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final F f6680a;

    /* renamed from: b, reason: collision with root package name */
    public final V9.k f6681b;

    public E(F f10, V9.k kVar) {
        this.f6680a = f10;
        this.f6681b = kVar;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return F.h0(this.f6680a, this.f6681b, (F.a) obj);
    }
}
