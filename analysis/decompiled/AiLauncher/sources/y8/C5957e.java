package y8;

import Yb.AbstractC1128b;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;

/* renamed from: y8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5957e extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final C5956d f43949a = new C5956d();

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f43950b = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public final int f43951c;

    /* renamed from: y8.e$a */
    public static class a extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            if (interfaceC1287h.d() >= Xb.d.f6920a) {
                return AbstractC1285f.c();
            }
            int iE = interfaceC1287h.e();
            CharSequence charSequenceB = interfaceC1287h.b();
            int length = charSequenceB.length();
            int iJ = C5957e.j('$', charSequenceB, iE, length);
            if (iJ >= 2 && Xb.d.k(' ', charSequenceB, iE + iJ, length) == length) {
                return AbstractC1285f.d(new C5957e(iJ)).b(length + 1);
            }
            return AbstractC1285f.c();
        }
    }

    public C5957e(int i10) {
        this.f43951c = i10;
    }

    public static int j(char c10, CharSequence charSequence, int i10, int i11) {
        for (int i12 = i10; i12 < i11; i12++) {
            if (c10 != charSequence.charAt(i12)) {
                return i12 - i10;
            }
        }
        return i11 - i10;
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        int iE = interfaceC1287h.e();
        CharSequence charSequenceB = interfaceC1287h.b();
        int length = charSequenceB.length();
        if (interfaceC1287h.d() < Xb.d.f6920a) {
            int iJ = j('$', charSequenceB, iE, length);
            int i10 = this.f43951c;
            if (iJ == i10 && Xb.d.k(' ', charSequenceB, iE + i10, length) == length) {
                return C1282c.c();
            }
        }
        return C1282c.b(interfaceC1287h.getIndex());
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f43949a;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void f(CharSequence charSequence) {
        this.f43950b.append(charSequence);
        this.f43950b.append('\n');
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void g() {
        this.f43949a.o(this.f43950b.toString());
    }
}
