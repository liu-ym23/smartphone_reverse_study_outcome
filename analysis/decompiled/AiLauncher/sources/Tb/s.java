package Tb;

import Yb.A;
import Yb.AbstractC1128b;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;

/* loaded from: classes5.dex */
public class s extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final A f6017a = new A();

    public static class a extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            if (interfaceC1287h.d() >= 4) {
                return AbstractC1285f.c();
            }
            int iE = interfaceC1287h.e();
            CharSequence charSequenceB = interfaceC1287h.b();
            return s.j(charSequenceB, iE) ? AbstractC1285f.d(new s()).b(charSequenceB.length()) : AbstractC1285f.c();
        }
    }

    public static boolean j(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i10 < length) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt != '\t' && cCharAt != ' ') {
                if (cCharAt == '*') {
                    i13++;
                } else if (cCharAt == '-') {
                    i11++;
                } else {
                    if (cCharAt != '_') {
                        return false;
                    }
                    i12++;
                }
            }
            i10++;
        }
        if (i11 >= 3 && i12 == 0 && i13 == 0) {
            return true;
        }
        if (i12 >= 3 && i11 == 0 && i13 == 0) {
            return true;
        }
        return i13 >= 3 && i11 == 0 && i12 == 0;
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        return C1282c.d();
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f6017a;
    }
}
