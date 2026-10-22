package androidx.lifecycle;

import androidx.lifecycle.AbstractC0533m;

/* renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0523c implements InterfaceC0537q {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0530j[] f10862a;

    public C0523c(InterfaceC0530j[] interfaceC0530jArr) {
        j4.k.g(interfaceC0530jArr, "generatedAdapters");
        this.f10862a = interfaceC0530jArr;
    }

    @Override // androidx.lifecycle.InterfaceC0537q
    public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
        j4.k.g(interfaceC0539t, "source");
        j4.k.g(aVar, "event");
        A a6 = new A();
        for (InterfaceC0530j interfaceC0530j : this.f10862a) {
            interfaceC0530j.a(interfaceC0539t, aVar, false, a6);
        }
        for (InterfaceC0530j interfaceC0530j2 : this.f10862a) {
            interfaceC0530j2.a(interfaceC0539t, aVar, true, a6);
        }
    }
}
