package G3;

/* loaded from: classes2.dex */
public final class a implements g {
    public static char b(char c10, char c11) {
        if (j.f(c10) && j.f(c11)) {
            return (char) (((c10 - '0') * 10) + (c11 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c10 + c11);
    }

    @Override // G3.g
    public void a(h hVar) {
        if (j.a(hVar.d(), hVar.f2788f) >= 2) {
            hVar.r(b(hVar.d().charAt(hVar.f2788f), hVar.d().charAt(hVar.f2788f + 1)));
            hVar.f2788f += 2;
            return;
        }
        char c10 = hVar.c();
        int iN = j.n(hVar.d(), hVar.f2788f, c());
        if (iN == c()) {
            if (!j.g(c10)) {
                hVar.r((char) (c10 + 1));
                hVar.f2788f++;
                return;
            } else {
                hVar.r((char) 235);
                hVar.r((char) (c10 - 127));
                hVar.f2788f++;
                return;
            }
        }
        if (iN == 1) {
            hVar.r((char) 230);
            hVar.o(1);
            return;
        }
        if (iN == 2) {
            hVar.r((char) 239);
            hVar.o(2);
            return;
        }
        if (iN == 3) {
            hVar.r((char) 238);
            hVar.o(3);
            return;
        }
        if (iN == 4) {
            hVar.r((char) 240);
            hVar.o(4);
        } else if (iN == 5) {
            hVar.r((char) 231);
            hVar.o(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + iN);
        }
    }

    public int c() {
        return 0;
    }
}
