package d8;

import java.security.SecureRandom;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u0 implements Cloneable {
    public static final SecureRandom d = new SecureRandom();

    /* renamed from: a, reason: collision with root package name */
    public int f2175a;

    /* renamed from: b, reason: collision with root package name */
    public int f2176b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f2177c;

    public u0(int i8) {
        if (i8 < 0 || i8 > 65535) {
            throw new IllegalArgumentException(a8.b.k(i8, "DNS message ID ", " is out of range"));
        }
        this.f2177c = new int[4];
        this.f2176b = 0;
        this.f2175a = i8;
    }

    public static void a(int i8) {
        if (i8 >= 0 && i8 <= 15) {
            n0.f2092a.c(i8);
            if ((i8 < 1 || i8 > 4) && i8 < 12) {
                return;
            }
        }
        throw new IllegalArgumentException(a8.b.j(i8, "invalid flag bit "));
    }

    public static boolean c(int i8, int i9) {
        a(i9);
        return (i8 & (1 << (15 - i9))) != 0;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final u0 clone() {
        u0 u0Var = (u0) super.clone();
        u0Var.f2175a = this.f2175a;
        u0Var.f2176b = this.f2176b;
        int[] iArr = new int[u0Var.f2177c.length];
        u0Var.f2177c = iArr;
        int[] iArr2 = this.f2177c;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        return u0Var;
    }

    public final int d() {
        return (this.f2176b >> 11) & 15;
    }

    public final void e() {
        this.f2176b &= 34815;
    }

    public final String f(int i8) {
        StringBuilder sb = new StringBuilder(";; ->>HEADER<<- opcode: ");
        sb.append(o2.f2101a.d(d()));
        sb.append(", status: ");
        sb.append(v2.f2185a.d(i8));
        sb.append(", id: ");
        sb.append(this.f2175a);
        sb.append("\n;; flags: ");
        for (int i9 = 0; i9 < 16; i9++) {
            if (i9 >= 0 && i9 <= 15) {
                l1 l1Var = n0.f2092a;
                l1Var.c(i9);
                if ((i9 < 1 || i9 > 4) && i9 < 12 && c(this.f2176b, i9)) {
                    sb.append(l1Var.d(i9));
                    sb.append(" ");
                }
            }
        }
        sb.append("; ");
        for (int i10 = 0; i10 < 4; i10++) {
            sb.append(q3.f2122a.d(i10));
            sb.append(": ");
            sb.append(this.f2177c[i10]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public final void g(b0.j jVar) {
        jVar.j(this.f2175a);
        jVar.j(this.f2176b);
        for (int i8 : this.f2177c) {
            jVar.j(i8);
        }
    }

    public final String toString() {
        return f(this.f2176b & 15);
    }
}
