package Tb;

import Yb.AbstractC1128b;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;

/* loaded from: classes5.dex */
public class c extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final Yb.c f5926a = new Yb.c();

    public static class a extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            int iE = interfaceC1287h.e();
            if (!c.k(interfaceC1287h, iE)) {
                return AbstractC1285f.c();
            }
            int iC = interfaceC1287h.c() + interfaceC1287h.d();
            int i10 = iC + 1;
            if (Xb.d.i(interfaceC1287h.b(), iE + 1)) {
                i10 = iC + 2;
            }
            return AbstractC1285f.d(new c()).a(i10);
        }
    }

    public static boolean k(InterfaceC1287h interfaceC1287h, int i10) {
        CharSequence charSequenceB = interfaceC1287h.b();
        return interfaceC1287h.d() < Xb.d.f6920a && i10 < charSequenceB.length() && charSequenceB.charAt(i10) == '>';
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean a() {
        return true;
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        int iE = interfaceC1287h.e();
        if (!k(interfaceC1287h, iE)) {
            return C1282c.d();
        }
        int iC = interfaceC1287h.c() + interfaceC1287h.d();
        int i10 = iC + 1;
        if (Xb.d.i(interfaceC1287h.b(), iE + 1)) {
            i10 = iC + 2;
        }
        return C1282c.a(i10);
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean h(AbstractC1128b abstractC1128b) {
        return true;
    }

    @Override // ac.InterfaceC1283d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Yb.c e() {
        return this.f5926a;
    }
}
