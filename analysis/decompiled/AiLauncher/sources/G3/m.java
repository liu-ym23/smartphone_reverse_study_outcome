package G3;

/* loaded from: classes2.dex */
public final class m extends c {
    @Override // G3.c, G3.g
    public void a(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char c10 = hVar.c();
            hVar.f2788f++;
            c(c10, sb2);
            if (sb2.length() % 3 == 0) {
                c.h(hVar, sb2);
                if (j.n(hVar.d(), hVar.f2788f, f()) != f()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        g(hVar, sb2);
    }

    @Override // G3.c
    public int c(char c10, StringBuilder sb2) {
        if (c10 == '\r') {
            sb2.append((char) 0);
        } else if (c10 == ' ') {
            sb2.append((char) 3);
        } else if (c10 == '*') {
            sb2.append((char) 1);
        } else if (c10 == '>') {
            sb2.append((char) 2);
        } else if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) (c10 - ','));
        } else if (c10 < 'A' || c10 > 'Z') {
            j.e(c10);
        } else {
            sb2.append((char) (c10 - '3'));
        }
        return 1;
    }

    @Override // G3.c
    public int f() {
        return 3;
    }

    @Override // G3.c
    public void g(h hVar, StringBuilder sb2) {
        hVar.p();
        int iA = hVar.g().a() - hVar.a();
        hVar.f2788f -= sb2.length();
        if (hVar.f() > 1 || iA > 1 || hVar.f() != iA) {
            hVar.r((char) 254);
        }
        if (hVar.e() < 0) {
            hVar.o(0);
        }
    }
}
