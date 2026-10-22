package Tb;

import Yb.AbstractC1128b;
import Yb.t;
import Yb.v;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1283d;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;

/* loaded from: classes5.dex */
public class o extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final Yb.s f6002a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6003b;

    /* renamed from: c, reason: collision with root package name */
    public int f6004c;

    public static class a extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            InterfaceC1283d interfaceC1283dB = interfaceC1286g.b();
            if (interfaceC1287h.d() >= Xb.d.f6920a) {
                return AbstractC1285f.c();
            }
            b bVarN = o.n(interfaceC1287h.b(), interfaceC1287h.e(), interfaceC1287h.c() + interfaceC1287h.d(), interfaceC1286g.a() != null);
            if (bVarN == null) {
                return AbstractC1285f.c();
            }
            int i10 = bVarN.f6006b;
            p pVar = new p(i10 - interfaceC1287h.c());
            if ((interfaceC1283dB instanceof o) && o.m((Yb.s) interfaceC1283dB.e(), bVarN.f6005a)) {
                return AbstractC1285f.d(pVar).a(i10);
            }
            o oVar = new o(bVarN.f6005a);
            bVarN.f6005a.o(true);
            return AbstractC1285f.d(oVar, pVar).a(i10);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Yb.s f6005a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6006b;

        public b(Yb.s sVar, int i10) {
            this.f6005a = sVar;
            this.f6006b = i10;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Yb.s f6007a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6008b;

        public c(Yb.s sVar, int i10) {
            this.f6007a = sVar;
            this.f6008b = i10;
        }
    }

    public o(Yb.s sVar) {
        this.f6002a = sVar;
    }

    public static boolean k(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean l(CharSequence charSequence, int i10) {
        char cCharAt;
        return i10 >= charSequence.length() || (cCharAt = charSequence.charAt(i10)) == '\t' || cCharAt == ' ';
    }

    public static boolean m(Yb.s sVar, Yb.s sVar2) {
        if ((sVar instanceof Yb.d) && (sVar2 instanceof Yb.d)) {
            return k(Character.valueOf(((Yb.d) sVar).p()), Character.valueOf(((Yb.d) sVar2).p()));
        }
        if ((sVar instanceof v) && (sVar2 instanceof v)) {
            return k(Character.valueOf(((v) sVar).p()), Character.valueOf(((v) sVar2).p()));
        }
        return false;
    }

    public static b n(CharSequence charSequence, int i10, int i11, boolean z10) {
        boolean z11;
        c cVarO = o(charSequence, i10);
        if (cVarO == null) {
            return null;
        }
        Yb.s sVar = cVarO.f6007a;
        int i12 = cVarO.f6008b;
        int i13 = i11 + (i12 - i10);
        int length = charSequence.length();
        int iA = i13;
        while (true) {
            if (i12 >= length) {
                z11 = false;
                break;
            }
            char cCharAt = charSequence.charAt(i12);
            if (cCharAt != '\t') {
                if (cCharAt != ' ') {
                    z11 = true;
                    break;
                }
                iA++;
            } else {
                iA += Xb.d.a(iA);
            }
            i12++;
        }
        if (z10 && (((sVar instanceof v) && ((v) sVar).q() != 1) || !z11)) {
            return null;
        }
        if (!z11 || iA - i13 > Xb.d.f6920a) {
            iA = i13 + 1;
        }
        return new b(sVar, iA);
    }

    public static c o(CharSequence charSequence, int i10) {
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt != '*' && cCharAt != '+' && cCharAt != '-') {
            return p(charSequence, i10);
        }
        int i11 = i10 + 1;
        if (!l(charSequence, i11)) {
            return null;
        }
        Yb.d dVar = new Yb.d();
        dVar.q(cCharAt);
        return new c(dVar, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0009  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static Tb.o.c p(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = 0
            r2 = r7
        L6:
            r3 = 0
            if (r2 >= r0) goto L4b
            char r4 = r6.charAt(r2)
            r5 = 41
            if (r4 == r5) goto L23
            r5 = 46
            if (r4 == r5) goto L23
            switch(r4) {
                case 48: goto L19;
                case 49: goto L19;
                case 50: goto L19;
                case 51: goto L19;
                case 52: goto L19;
                case 53: goto L19;
                case 54: goto L19;
                case 55: goto L19;
                case 56: goto L19;
                case 57: goto L19;
                default: goto L18;
            }
        L18:
            return r3
        L19:
            int r1 = r1 + 1
            r4 = 9
            if (r1 <= r4) goto L20
            return r3
        L20:
            int r2 = r2 + 1
            goto L6
        L23:
            r0 = 1
            if (r1 < r0) goto L4b
            int r0 = r2 + 1
            boolean r1 = l(r6, r0)
            if (r1 == 0) goto L4b
            java.lang.CharSequence r6 = r6.subSequence(r7, r2)
            java.lang.String r6 = r6.toString()
            Yb.v r7 = new Yb.v
            r7.<init>()
            int r6 = java.lang.Integer.parseInt(r6)
            r7.s(r6)
            r7.r(r4)
            Tb.o$c r6 = new Tb.o$c
            r6.<init>(r7, r0)
            return r6
        L4b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: Tb.o.p(java.lang.CharSequence, int):Tb.o$c");
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean a() {
        return true;
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        if (interfaceC1287h.a()) {
            this.f6003b = true;
            this.f6004c = 0;
        } else if (this.f6003b) {
            this.f6004c++;
        }
        return C1282c.b(interfaceC1287h.getIndex());
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f6002a;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean h(AbstractC1128b abstractC1128b) {
        if (!(abstractC1128b instanceof t)) {
            return false;
        }
        if (this.f6003b && this.f6004c == 1) {
            this.f6002a.o(false);
            this.f6003b = false;
        }
        return true;
    }
}
