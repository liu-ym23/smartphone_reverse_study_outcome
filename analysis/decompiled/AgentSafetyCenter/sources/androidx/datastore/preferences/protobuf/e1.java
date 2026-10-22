package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e1 {
    public static d1 a(Object obj) {
        v vVar = (v) obj;
        d1 d1Var = vVar.unknownFields;
        if (d1Var != d1.f1097f) {
            return d1Var;
        }
        d1 d1Var2 = new d1(0, new int[8], new Object[8], true);
        vVar.unknownFields = d1Var2;
        return d1Var2;
    }

    public static boolean b(int i, j jVar, Object obj) throws z {
        int i3 = jVar.f1134a;
        i iVar = (i) jVar.f1137d;
        int i10 = i3 >>> 3;
        int i11 = i3 & 7;
        if (i11 == 0) {
            jVar.A(0);
            ((d1) obj).c(i10 << 3, Long.valueOf(iVar.n()));
            return true;
        }
        if (i11 == 1) {
            jVar.A(1);
            ((d1) obj).c((i10 << 3) | 1, Long.valueOf(iVar.k()));
            return true;
        }
        if (i11 == 2) {
            ((d1) obj).c((i10 << 3) | 2, jVar.i());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw z.b();
            }
            jVar.A(5);
            ((d1) obj).c(5 | (i10 << 3), Integer.valueOf(iVar.j()));
            return true;
        }
        d1 d1Var = new d1(0, new int[8], new Object[8], true);
        int i12 = i10 << 3;
        int i13 = i12 | 4;
        int i14 = i + 1;
        if (i14 >= 100) {
            throw new z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (jVar.c() != Integer.MAX_VALUE && b(i14, jVar, d1Var)) {
        }
        if (i13 != jVar.f1134a) {
            throw new z("Protocol message end-group tag did not match expected tag.");
        }
        if (d1Var.f1102e) {
            d1Var.f1102e = false;
        }
        ((d1) obj).c(i12 | 3, d1Var);
        return true;
    }
}
