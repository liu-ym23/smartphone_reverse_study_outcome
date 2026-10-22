package pd;

import od.l;
import od.z;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final l f9999a;

    /* renamed from: b, reason: collision with root package name */
    public static final l f10000b;

    /* renamed from: c, reason: collision with root package name */
    public static final l f10001c;

    /* renamed from: d, reason: collision with root package name */
    public static final l f10002d;

    /* renamed from: e, reason: collision with root package name */
    public static final l f10003e;

    static {
        l lVar = l.f9459h;
        f9999a = f8.b.l("/");
        f10000b = f8.b.l("\\");
        f10001c = f8.b.l("/\\");
        f10002d = f8.b.l(".");
        f10003e = f8.b.l("..");
    }

    public static final int a(z zVar) {
        l lVar = zVar.f9498c;
        if (lVar.c() != 0) {
            if (lVar.h(0) != 47) {
                if (lVar.h(0) == 92) {
                    if (lVar.c() > 2 && lVar.h(1) == 92) {
                        l lVar2 = f10000b;
                        lVar2.getClass();
                        int iE = lVar.e(2, lVar2.g());
                        return iE == -1 ? lVar.c() : iE;
                    }
                } else if (lVar.c() > 2 && lVar.h(1) == 58 && lVar.h(2) == 92) {
                    char cH = (char) lVar.h(0);
                    if ('a' <= cH && cH < '{') {
                        return 3;
                    }
                    if ('A' <= cH && cH < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final z b(z zVar, z zVar2, boolean z10) {
        zVar2.getClass();
        if (a(zVar2) != -1 || zVar2.e() != null) {
            return zVar2;
        }
        l lVarC = c(zVar);
        if (lVarC == null && (lVarC = c(zVar2)) == null) {
            lVarC = f(z.f9497f);
        }
        od.i iVar = new od.i();
        iVar.Z(zVar.f9498c);
        if (iVar.f9454f > 0) {
            iVar.Z(lVarC);
        }
        iVar.Z(zVar2.f9498c);
        return d(iVar, z10);
    }

    public static final l c(z zVar) {
        l lVar = zVar.f9498c;
        l lVar2 = f9999a;
        if (l.f(lVar, lVar2) != -1) {
            return lVar2;
        }
        l lVar3 = zVar.f9498c;
        l lVar4 = f10000b;
        if (l.f(lVar3, lVar4) != -1) {
            return lVar4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011c A[EDGE_INSN: B:101:0x011c->B:84:0x011c BREAK  A[LOOP:1: B:53:0x00ab->B:116:0x00ab], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final od.z d(od.i r17, boolean r18) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pd.c.d(od.i, boolean):od.z");
    }

    public static final l e(byte b10) {
        if (b10 == 47) {
            return f9999a;
        }
        if (b10 == 92) {
            return f10000b;
        }
        g5.f.s(k0.a.j(b10, "not a directory separator: "));
        return null;
    }

    public static final l f(String str) {
        if (k.a(str, "/")) {
            return f9999a;
        }
        if (k.a(str, "\\")) {
            return f10000b;
        }
        g5.f.s(w2.c.b("not a directory separator: ", str));
        return null;
    }
}
