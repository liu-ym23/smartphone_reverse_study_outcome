package d8;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j1 implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final w2[] f2030f;

    /* renamed from: a, reason: collision with root package name */
    public u0 f2031a;

    /* renamed from: b, reason: collision with root package name */
    public List[] f2032b;

    /* renamed from: c, reason: collision with root package name */
    public int f2033c;
    public y3 d;

    /* renamed from: e, reason: collision with root package name */
    public y3 f2034e;

    static {
        z7.d.b(j1.class);
        f2030f = new w2[0];
    }

    public j1(u0 u0Var) {
        this.f2032b = new List[4];
        this.f2031a = u0Var;
    }

    public final void a(w2 w2Var, int i8) {
        List[] listArr = this.f2032b;
        if (listArr[i8] == null) {
            listArr[i8] = new LinkedList();
        }
        int[] iArr = this.f2031a.f2177c;
        int i9 = iArr[i8];
        if (i9 == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i8] = i9 + 1;
        this.f2032b[i8].add(w2Var);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final j1 clone() {
        j1 j1Var = (j1) super.clone();
        j1Var.f2032b = new List[this.f2032b.length];
        int i8 = 0;
        while (true) {
            List[] listArr = this.f2032b;
            if (i8 >= listArr.length) {
                break;
            }
            if (listArr[i8] != null) {
                j1Var.f2032b[i8] = new LinkedList(this.f2032b[i8]);
            }
            i8++;
        }
        j1Var.f2031a = this.f2031a.clone();
        y3 y3Var = this.f2034e;
        if (y3Var != null) {
            j1Var.f2034e = (y3) y3Var.d();
        }
        y3 y3Var2 = this.d;
        if (y3Var2 != null) {
            j1Var.d = (y3) y3Var2.d();
        }
        return j1Var;
    }

    public final n2 c() {
        q3.f2122a.c(3);
        List list = this.f2032b[3];
        for (w2 w2Var : list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list)) {
            if (w2Var instanceof n2) {
                return (n2) w2Var;
            }
        }
        return null;
    }

    public final w2 d() {
        List list = this.f2032b[0];
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (w2) list.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
    
        if (r13 == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a2, code lost:
    
        if (r10 == 3) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a4, code lost:
    
        d8.u0.a(r18);
        r8 = r8 | 512;
        r4 = r6 + 4;
        r21.k(r20.f2031a.f2177c[r10] - r13, (r10 * 2) + r4);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bb, code lost:
    
        if (r10 >= 3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bd, code lost:
    
        r21.k(0, (r10 * 2) + r4);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c7, code lost:
    
        r5 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c9, code lost:
    
        r5 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ca, code lost:
    
        if (r10 != r5) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cc, code lost:
    
        r11 = r20.f2031a.f2177c[r10] - r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(b0.j r21) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.j1.e(b0.j):boolean");
    }

    public final byte[] f() {
        b0.j jVar = new b0.j(2);
        this.f2031a.g(jVar);
        n nVar = new n();
        int i8 = 0;
        while (true) {
            List[] listArr = this.f2032b;
            if (i8 >= listArr.length) {
                this.f2033c = jVar.f832a;
                return jVar.f();
            }
            List list = listArr[i8];
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((w2) it.next()).m(jVar, i8, nVar);
                }
            }
            i8++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        n2 n2VarC = c();
        if (n2VarC != null) {
            u0 u0Var = this.f2031a;
            int i8 = u0Var.f2176b & 15;
            n2 n2VarC2 = c();
            if (n2VarC2 != null) {
                i8 += ((int) (n2VarC2.d >>> 24)) << 4;
            }
            sb.append(u0Var.f(i8));
            sb.append("\n\n;; OPT PSEUDOSECTION: \n; EDNS: version: ");
            sb.append((int) ((n2VarC.d >>> 16) & 255));
            sb.append("; flags: ");
            for (int i9 = 0; i9 < 16; i9++) {
                int i10 = 1 << (15 - i9);
                if ((((int) (n2VarC.d & 65535)) & i10) != 0) {
                    sb.append(g0.f1999a.d(i10));
                    sb.append(" ");
                }
            }
            sb.append("; udp: ");
            sb.append(n2VarC.f2197c);
            ArrayList arrayList = n2VarC.f2094f;
            if (arrayList != null) {
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList.get(i11);
                    i11++;
                    d0 d0Var = (d0) obj;
                    sb.append("\n; ");
                    sb.append(c0.f1963a.d(d0Var.f1976a));
                    sb.append(": ");
                    sb.append(d0Var.b());
                }
            }
            sb.append('\n');
        } else {
            sb.append(this.f2031a);
            sb.append('\n');
        }
        for (int i12 = 0; i12 < 4; i12++) {
            if (this.f2031a.d() != 5) {
                sb.append(";; ");
                q3.f2122a.c(i12);
                sb.append(q3.f2123b[i12]);
                sb.append(":\n");
            } else {
                sb.append(";; ");
                q3.f2122a.c(i12);
                sb.append(q3.f2124c[i12]);
                sb.append(":\n");
            }
            if (i12 <= 3) {
                q3.f2122a.c(i12);
                List list = this.f2032b[i12];
                for (w2 w2Var : list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list)) {
                    if (i12 == 0) {
                        sb.append(";;\t");
                        sb.append(w2Var.f2195a);
                        sb.append(", type = ");
                        sb.append(f4.f1995a.d(w2Var.f2196b));
                        sb.append(", class = ");
                        sb.append(q.f2118a.d(w2Var.f2197c));
                    } else if (!(w2Var instanceof n2)) {
                        sb.append(w2Var);
                    }
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        sb.append(";; Message size: ");
        return m0.f.e(sb, this.f2033c, " bytes");
    }

    public j1() {
        this(new u0(u0.d.nextInt(Blake2xsDigest.UNKNOWN_DIGEST_LENGTH)));
    }

    public j1(byte[] bArr) throws l4 {
        u uVar = new u(bArr);
        u0 u0Var = new u0(uVar.d());
        u0Var.f2176b = uVar.d();
        int i8 = 0;
        while (true) {
            int[] iArr = u0Var.f2177c;
            if (i8 >= iArr.length) {
                break;
            }
            iArr[i8] = uVar.d();
            i8++;
        }
        this(u0Var);
        boolean z = u0Var.d() == 5;
        boolean zC = u0.c(this.f2031a.f2176b, 6);
        int i9 = 0;
        while (true) {
            ByteBuffer byteBuffer = uVar.f2171a;
            if (i9 >= 4) {
                break;
            }
            try {
                int i10 = this.f2031a.f2177c[i9];
                if (i10 > 0) {
                    this.f2032b[i9] = new ArrayList(i10);
                }
                for (int i11 = 0; i11 < i10; i11++) {
                    byteBuffer.position();
                    w2 w2VarE = w2.e(uVar, i9, z);
                    this.f2032b[i9].add(w2VarE);
                    if (i9 == 3) {
                        int i12 = w2VarE.f2196b;
                        if (i12 == 250 && i11 != i10 - 1) {
                            throw new l4("TSIG is not the last record in the message");
                        }
                        if (i12 == 24) {
                        }
                    }
                }
                i9++;
            } catch (l4 e9) {
                if (!zC) {
                    throw e9;
                }
                this.f2033c = byteBuffer.position() - uVar.f2172b;
                return;
            }
        }
    }
}
