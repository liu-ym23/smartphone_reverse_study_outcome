package pb;

import h4.n;
import ob.k;
import ob.z;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final k f8578a;

    /* renamed from: b, reason: collision with root package name */
    public static final k f8579b;

    /* renamed from: c, reason: collision with root package name */
    public static final k f8580c;

    /* renamed from: d, reason: collision with root package name */
    public static final k f8581d;

    /* renamed from: e, reason: collision with root package name */
    public static final k f8582e;

    static {
        k kVar = k.f7997i;
        f8578a = n.j("/");
        f8579b = n.j("\\");
        f8580c = n.j("/\\");
        f8581d = n.j(".");
        f8582e = n.j("..");
    }

    public static final int a(z zVar) {
        k kVar = zVar.f8043f;
        if (kVar.d() != 0) {
            if (kVar.i(0) != 47) {
                if (kVar.i(0) == 92) {
                    if (kVar.d() > 2 && kVar.i(1) == 92) {
                        k kVar2 = f8579b;
                        q7.k.e(kVar2, "other");
                        int iF = kVar.f(2, kVar2.h());
                        return iF == -1 ? kVar.d() : iF;
                    }
                } else if (kVar.d() > 2 && kVar.i(1) == 58 && kVar.i(2) == 92) {
                    char cI = (char) kVar.i(0);
                    if ('a' <= cI && cI < '{') {
                        return 3;
                    }
                    if ('A' <= cI && cI < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final z b(z zVar, z zVar2, boolean z4) {
        q7.k.e(zVar2, "child");
        if (a(zVar2) != -1 || zVar2.g() != null) {
            return zVar2;
        }
        k kVarC = c(zVar);
        if (kVarC == null && (kVarC = c(zVar2)) == null) {
            kVarC = f(z.f8042g);
        }
        ob.h hVar = new ob.h();
        hVar.H(zVar.f8043f);
        if (hVar.f7993g > 0) {
            hVar.H(kVarC);
        }
        hVar.H(zVar2.f8043f);
        return d(hVar, z4);
    }

    public static final k c(z zVar) {
        k kVar = zVar.f8043f;
        k kVar2 = f8578a;
        if (k.g(kVar, kVar2) != -1) {
            return kVar2;
        }
        k kVar3 = zVar.f8043f;
        k kVar4 = f8579b;
        if (k.g(kVar3, kVar4) != -1) {
            return kVar4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011b A[EDGE_INSN: B:101:0x011b->B:84:0x011b BREAK  A[LOOP:1: B:53:0x00ab->B:116:0x00ab], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ob.z d(ob.h r17, boolean r18) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.c.d(ob.h, boolean):ob.z");
    }

    public static final k e(byte b10) {
        if (b10 == 47) {
            return f8578a;
        }
        if (b10 == 92) {
            return f8579b;
        }
        throw new IllegalArgumentException(n.f.c(b10, "not a directory separator: "));
    }

    public static final k f(String str) {
        if (q7.k.a(str, "/")) {
            return f8578a;
        }
        if (q7.k.a(str, "\\")) {
            return f8579b;
        }
        throw new IllegalArgumentException(a1.a.w("not a directory separator: ", str));
    }
}
