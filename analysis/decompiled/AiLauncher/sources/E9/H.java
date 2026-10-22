package E9;

import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public class H implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final ga.c f2430a;

    public H(ga.c cVar) {
        this.f2430a = cVar;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return Boolean.valueOf(I.g(this.f2430a, (ga.c) obj));
    }
}
