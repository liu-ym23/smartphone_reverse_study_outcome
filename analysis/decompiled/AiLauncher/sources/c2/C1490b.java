package c2;

import c2.C1492d;
import i2.InterfaceC4163a;

/* renamed from: c2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1490b implements InterfaceC4163a {

    /* renamed from: a, reason: collision with root package name */
    public final C1492d f15426a;

    public C1490b(C1492d c1492d) {
        this.f15426a = c1492d;
    }

    public static InterfaceC4163a a(C1492d c1492d) {
        return new C1490b(c1492d);
    }

    @Override // i2.InterfaceC4163a
    public Object apply(Object obj) {
        return this.f15426a.d((C1492d.a) obj);
    }
}
