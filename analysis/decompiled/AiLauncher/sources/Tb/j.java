package Tb;

import Yb.AbstractC1128b;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;

/* loaded from: classes5.dex */
public class j extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final Yb.l f5968a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5969b;

    public static class a extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            CharSequence charSequenceA;
            if (interfaceC1287h.d() >= Xb.d.f6920a) {
                return AbstractC1285f.c();
            }
            CharSequence charSequenceB = interfaceC1287h.b();
            int iE = interfaceC1287h.e();
            j jVarK = j.k(charSequenceB, iE);
            if (jVarK != null) {
                return AbstractC1285f.d(jVarK).b(charSequenceB.length());
            }
            int iL = j.l(charSequenceB, iE);
            return (iL <= 0 || (charSequenceA = interfaceC1286g.a()) == null) ? AbstractC1285f.c() : AbstractC1285f.d(new j(iL, charSequenceA.toString())).b(charSequenceB.length()).e();
        }
    }

    public j(int i10, String str) {
        Yb.l lVar = new Yb.l();
        this.f5968a = lVar;
        lVar.o(i10);
        this.f5969b = str;
    }

    public static j k(CharSequence charSequence, int i10) {
        int iK = Xb.d.k('#', charSequence, i10, charSequence.length()) - i10;
        if (iK == 0 || iK > 6) {
            return null;
        }
        int i11 = i10 + iK;
        if (i11 >= charSequence.length()) {
            return new j(iK, "");
        }
        char cCharAt = charSequence.charAt(i11);
        if (cCharAt != ' ' && cCharAt != '\t') {
            return null;
        }
        int iN = Xb.d.n(charSequence, charSequence.length() - 1, i11);
        int iL = Xb.d.l('#', charSequence, iN, i11);
        int iN2 = Xb.d.n(charSequence, iL, i11);
        return iN2 != iL ? new j(iK, charSequence.subSequence(i11, iN2 + 1).toString()) : new j(iK, charSequence.subSequence(i11, iN + 1).toString());
    }

    public static int l(CharSequence charSequence, int i10) {
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt != '-') {
            if (cCharAt != '=') {
                return 0;
            }
            if (m(charSequence, i10 + 1, '=')) {
                return 1;
            }
        }
        return m(charSequence, i10 + 1, '-') ? 2 : 0;
    }

    public static boolean m(CharSequence charSequence, int i10, char c10) {
        return Xb.d.m(charSequence, Xb.d.k(c10, charSequence, i10, charSequence.length()), charSequence.length()) >= charSequence.length();
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void b(Zb.a aVar) {
        aVar.n(this.f5969b, this.f5968a);
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        return C1282c.d();
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f5968a;
    }
}
