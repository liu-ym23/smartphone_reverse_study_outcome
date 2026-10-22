package G3;

/* loaded from: classes2.dex */
public class c implements g {
    public static String e(CharSequence charSequence) {
        int iCharAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * '(') + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    public static void h(h hVar, StringBuilder sb2) {
        hVar.s(e(sb2));
        sb2.delete(0, 3);
    }

    @Override // G3.g
    public void a(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char c10 = hVar.c();
            hVar.f2788f++;
            int iC = c(c10, sb2);
            int iA = hVar.a() + ((sb2.length() / 3) * 2);
            hVar.q(iA);
            int iA2 = hVar.g().a() - iA;
            if (!hVar.i()) {
                StringBuilder sb3 = new StringBuilder();
                if (sb2.length() % 3 == 2 && iA2 != 2) {
                    iC = b(hVar, sb2, sb3, iC);
                }
                while (sb2.length() % 3 == 1 && (iC > 3 || iA2 != 1)) {
                    iC = b(hVar, sb2, sb3, iC);
                }
            } else if (sb2.length() % 3 == 0 && j.n(hVar.d(), hVar.f2788f, f()) != f()) {
                hVar.o(0);
                break;
            }
        }
        g(hVar, sb2);
    }

    public final int b(h hVar, StringBuilder sb2, StringBuilder sb3, int i10) {
        int length = sb2.length();
        sb2.delete(length - i10, length);
        hVar.f2788f--;
        int iC = c(hVar.c(), sb3);
        hVar.k();
        return iC;
    }

    public int c(char c10, StringBuilder sb2) {
        if (c10 == ' ') {
            sb2.append((char) 3);
            return 1;
        }
        if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) (c10 - ','));
            return 1;
        }
        if (c10 >= 'A' && c10 <= 'Z') {
            sb2.append((char) (c10 - '3'));
            return 1;
        }
        if (c10 < ' ') {
            sb2.append((char) 0);
            sb2.append(c10);
            return 2;
        }
        if (c10 <= '/') {
            sb2.append((char) 1);
            sb2.append((char) (c10 - '!'));
            return 2;
        }
        if (c10 <= '@') {
            sb2.append((char) 1);
            sb2.append((char) (c10 - '+'));
            return 2;
        }
        if (c10 <= '_') {
            sb2.append((char) 1);
            sb2.append((char) (c10 - 'E'));
            return 2;
        }
        if (c10 > 127) {
            sb2.append("\u0001\u001e");
            return c((char) (c10 - 128), sb2) + 2;
        }
        sb2.append((char) 2);
        sb2.append((char) (c10 - '`'));
        return 2;
    }

    public void d(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = hVar.f2788f;
        int length = 0;
        int iC = 0;
        while (hVar.i()) {
            char c10 = hVar.c();
            hVar.f2788f++;
            iC = c(c10, sb2);
            if (sb2.length() % 3 == 0) {
                i10 = hVar.f2788f;
                length = sb2.length();
            }
        }
        if (length != sb2.length()) {
            int iA = hVar.a() + ((sb2.length() / 3) * 2) + 1;
            hVar.q(iA);
            int iA2 = hVar.g().a() - iA;
            int length2 = sb2.length() % 3;
            if ((length2 == 2 && iA2 != 2) || (length2 == 1 && (iC > 3 || iA2 != 1))) {
                sb2.setLength(length);
                hVar.f2788f = i10;
            }
        }
        if (sb2.length() > 0) {
            hVar.r((char) 230);
        }
        g(hVar, sb2);
    }

    public int f() {
        return 1;
    }

    public void g(h hVar, StringBuilder sb2) {
        int length = (sb2.length() / 3) * 2;
        int length2 = sb2.length() % 3;
        int iA = hVar.a() + length;
        hVar.q(iA);
        int iA2 = hVar.g().a() - iA;
        if (length2 == 2) {
            sb2.append((char) 0);
            while (sb2.length() >= 3) {
                h(hVar, sb2);
            }
            if (hVar.i()) {
                hVar.r((char) 254);
            }
        } else if (iA2 == 1 && length2 == 1) {
            while (sb2.length() >= 3) {
                h(hVar, sb2);
            }
            if (hVar.i()) {
                hVar.r((char) 254);
            }
            hVar.f2788f--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb2.length() >= 3) {
                h(hVar, sb2);
            }
            if (iA2 > 0 || hVar.i()) {
                hVar.r((char) 254);
            }
        }
        hVar.o(0);
    }
}
