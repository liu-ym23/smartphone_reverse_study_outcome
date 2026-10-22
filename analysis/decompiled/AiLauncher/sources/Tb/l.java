package Tb;

import Yb.AbstractC1128b;
import Yb.w;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class l extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final Yb.p f5975a = new Yb.p();

    /* renamed from: b, reason: collision with root package name */
    public final List<CharSequence> f5976b = new ArrayList();

    public static class a extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            return (interfaceC1287h.d() < Xb.d.f6920a || interfaceC1287h.a() || (interfaceC1287h.f().e() instanceof w)) ? AbstractC1285f.c() : AbstractC1285f.d(new l()).a(interfaceC1287h.c() + Xb.d.f6920a);
        }
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        return interfaceC1287h.d() >= Xb.d.f6920a ? C1282c.a(interfaceC1287h.c() + Xb.d.f6920a) : interfaceC1287h.a() ? C1282c.b(interfaceC1287h.e()) : C1282c.d();
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f5975a;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void f(CharSequence charSequence) {
        this.f5976b.add(charSequence);
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void g() {
        int size = this.f5976b.size() - 1;
        while (size >= 0 && Xb.d.f(this.f5976b.get(size))) {
            size--;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < size + 1; i10++) {
            sb2.append(this.f5976b.get(i10));
            sb2.append('\n');
        }
        this.f5975a.o(sb2.toString());
    }
}
