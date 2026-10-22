package od;

import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public static final String f9497f;

    /* renamed from: c, reason: collision with root package name */
    public l f9498c;

    static {
        String str = File.separator;
        str.getClass();
        f9497f = str;
    }

    public final ArrayList a() {
        l lVar = this.f9498c;
        ArrayList arrayList = new ArrayList();
        int iA = pd.c.a(this);
        if (iA == -1) {
            iA = 0;
        } else if (iA < lVar.c() && lVar.h(iA) == 92) {
            iA++;
        }
        int iC = lVar.c();
        int i = iA;
        while (iA < iC) {
            if (lVar.h(iA) == 47 || lVar.h(iA) == 92) {
                arrayList.add(lVar.m(i, iA));
                i = iA + 1;
            }
            iA++;
        }
        if (i < lVar.c()) {
            arrayList.add(lVar.m(i, lVar.c()));
        }
        return arrayList;
    }

    public final z b() {
        l lVar = this.f9498c;
        l lVar2 = pd.c.f10002d;
        if (yb.k.a(lVar, lVar2)) {
            return null;
        }
        l lVar3 = pd.c.f9999a;
        if (yb.k.a(lVar, lVar3)) {
            return null;
        }
        l lVar4 = pd.c.f10000b;
        if (yb.k.a(lVar, lVar4)) {
            return null;
        }
        l lVar5 = pd.c.f10003e;
        lVar.getClass();
        lVar5.getClass();
        int iC = lVar.c();
        byte[] bArr = lVar5.f9460c;
        if (lVar.k(iC - bArr.length, lVar5, bArr.length) && (lVar.c() == 2 || lVar.k(lVar.c() - 3, lVar3, 1) || lVar.k(lVar.c() - 3, lVar4, 1))) {
            return null;
        }
        int iJ = l.j(lVar, lVar3);
        if (iJ == -1) {
            iJ = l.j(lVar, lVar4);
        }
        if (iJ == 2 && e() != null) {
            if (lVar.c() == 3) {
                return null;
            }
            l lVarN = l.n(lVar, 0, 3, 1);
            z zVar = new z();
            zVar.f9498c = lVarN;
            return zVar;
        }
        if (iJ == 1) {
            lVar4.getClass();
            if (lVar.k(0, lVar4, lVar4.c())) {
                return null;
            }
        }
        if (iJ == -1 && e() != null) {
            if (lVar.c() == 2) {
                return null;
            }
            l lVarN2 = l.n(lVar, 0, 2, 1);
            z zVar2 = new z();
            zVar2.f9498c = lVarN2;
            return zVar2;
        }
        if (iJ == -1) {
            lVar2.getClass();
            z zVar3 = new z();
            zVar3.f9498c = lVar2;
            return zVar3;
        }
        if (iJ == 0) {
            l lVarN3 = l.n(lVar, 0, 1, 1);
            z zVar4 = new z();
            zVar4.f9498c = lVarN3;
            return zVar4;
        }
        l lVarN4 = l.n(lVar, 0, iJ, 1);
        z zVar5 = new z();
        zVar5.f9498c = lVarN4;
        return zVar5;
    }

    public final z c(z zVar) {
        z zVar2;
        l lVar = this.f9498c;
        zVar.getClass();
        l lVar2 = zVar.f9498c;
        int iA = pd.c.a(this);
        z zVar3 = null;
        if (iA == -1) {
            zVar2 = null;
        } else {
            l lVarM = lVar.m(0, iA);
            zVar2 = new z();
            zVar2.f9498c = lVarM;
        }
        int iA2 = pd.c.a(zVar);
        if (iA2 != -1) {
            l lVarM2 = lVar2.m(0, iA2);
            zVar3 = new z();
            zVar3.f9498c = lVarM2;
        }
        if (!yb.k.a(zVar2, zVar3)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + zVar).toString());
        }
        ArrayList arrayListA = a();
        ArrayList arrayListA2 = zVar.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i = 0;
        while (i < iMin && yb.k.a(arrayListA.get(i), arrayListA2.get(i))) {
            i++;
        }
        if (i == iMin && lVar.c() == lVar2.c()) {
            return f8.b.n(".");
        }
        if (arrayListA2.subList(i, arrayListA2.size()).indexOf(pd.c.f10003e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + zVar).toString());
        }
        i iVar = new i();
        l lVarC = pd.c.c(zVar);
        if (lVarC == null && (lVarC = pd.c.c(this)) == null) {
            lVarC = pd.c.f(f9497f);
        }
        int size = arrayListA2.size();
        for (int i3 = i; i3 < size; i3++) {
            iVar.Z(pd.c.f10003e);
            iVar.Z(lVarC);
        }
        int size2 = arrayListA.size();
        while (i < size2) {
            iVar.Z((l) arrayListA.get(i));
            iVar.Z(lVarC);
            i++;
        }
        return pd.c.d(iVar, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        z zVar = (z) obj;
        zVar.getClass();
        return this.f9498c.compareTo(zVar.f9498c);
    }

    public final z d(String str) {
        str.getClass();
        i iVar = new i();
        iVar.g0(str);
        return pd.c.b(this, pd.c.d(iVar, false), false);
    }

    public final Character e() {
        l lVar = this.f9498c;
        if (l.f(lVar, pd.c.f9999a) != -1 || lVar.c() < 2 || lVar.h(1) != 58) {
            return null;
        }
        char cH = (char) lVar.h(0);
        if (('a' > cH || cH >= '{') && ('A' > cH || cH >= '[')) {
            return null;
        }
        return Character.valueOf(cH);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof z) && yb.k.a(((z) obj).f9498c, this.f9498c);
    }

    public final int hashCode() {
        return this.f9498c.hashCode();
    }

    public final File toFile() {
        return new File(this.f9498c.p());
    }

    public final String toString() {
        return this.f9498c.p();
    }
}
