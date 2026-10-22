package Tb;

import Yb.AbstractC1128b;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;
import com.fasterxml.jackson.core.JsonPointer;

/* loaded from: classes5.dex */
public class i extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final Yb.j f5965a;

    /* renamed from: b, reason: collision with root package name */
    public String f5966b;

    /* renamed from: c, reason: collision with root package name */
    public StringBuilder f5967c;

    public static class a extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            int iD = interfaceC1287h.d();
            if (iD >= Xb.d.f6920a) {
                return AbstractC1285f.c();
            }
            int iE = interfaceC1287h.e();
            i iVarK = i.k(interfaceC1287h.b(), iE, iD);
            return iVarK != null ? AbstractC1285f.d(iVarK).b(iE + iVarK.f5965a.p()) : AbstractC1285f.c();
        }
    }

    public i(char c10, int i10, int i11) {
        Yb.j jVar = new Yb.j();
        this.f5965a = jVar;
        this.f5967c = new StringBuilder();
        jVar.s(c10);
        jVar.u(i10);
        jVar.t(i11);
    }

    public static i k(CharSequence charSequence, int i10, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = i10; i14 < length; i14++) {
            char cCharAt = charSequence.charAt(i14);
            if (cCharAt == '`') {
                i12++;
            } else {
                if (cCharAt != '~') {
                    break;
                }
                i13++;
            }
        }
        if (i12 >= 3 && i13 == 0) {
            if (Xb.d.b('`', charSequence, i10 + i12) != -1) {
                return null;
            }
            return new i('`', i12, i11);
        }
        if (i13 < 3 || i12 != 0) {
            return null;
        }
        return new i(JsonPointer.ESC, i13, i11);
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        int iE = interfaceC1287h.e();
        int index = interfaceC1287h.getIndex();
        CharSequence charSequenceB = interfaceC1287h.b();
        if (interfaceC1287h.d() < Xb.d.f6920a && l(charSequenceB, iE)) {
            return C1282c.c();
        }
        int length = charSequenceB.length();
        for (int iO = this.f5965a.o(); iO > 0 && index < length && charSequenceB.charAt(index) == ' '; iO--) {
            index++;
        }
        return C1282c.b(index);
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f5965a;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void f(CharSequence charSequence) {
        if (this.f5966b == null) {
            this.f5966b = charSequence.toString();
        } else {
            this.f5967c.append(charSequence);
            this.f5967c.append('\n');
        }
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void g() {
        this.f5965a.v(Xb.a.e(this.f5966b.trim()));
        this.f5965a.w(this.f5967c.toString());
    }

    public final boolean l(CharSequence charSequence, int i10) {
        char cN = this.f5965a.n();
        int iP = this.f5965a.p();
        int iK = Xb.d.k(cN, charSequence, i10, charSequence.length()) - i10;
        return iK >= iP && Xb.d.m(charSequence, i10 + iK, charSequence.length()) == charSequence.length();
    }
}
