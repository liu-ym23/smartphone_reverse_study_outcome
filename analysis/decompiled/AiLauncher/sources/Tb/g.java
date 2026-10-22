package Tb;

import Yb.AbstractC1128b;
import ac.AbstractC1280a;
import ac.C1282c;
import ac.InterfaceC1287h;

/* loaded from: classes5.dex */
public class g extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final Yb.h f5946a = new Yb.h();

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean a() {
        return true;
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        return C1282c.b(interfaceC1287h.getIndex());
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void f(CharSequence charSequence) {
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean h(AbstractC1128b abstractC1128b) {
        return true;
    }

    @Override // ac.InterfaceC1283d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Yb.h e() {
        return this.f5946a;
    }
}
