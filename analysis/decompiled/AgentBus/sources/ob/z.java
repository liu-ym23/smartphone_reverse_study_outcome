package ob;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class z implements Comparable {

    /* renamed from: g, reason: collision with root package name */
    public static final String f8042g;

    /* renamed from: f, reason: collision with root package name */
    public final k f8043f;

    static {
        String str = File.separator;
        q7.k.d(str, "separator");
        f8042g = str;
    }

    public z(k kVar) {
        q7.k.e(kVar, "bytes");
        this.f8043f = kVar;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iA = pb.c.a(this);
        k kVar = this.f8043f;
        if (iA == -1) {
            iA = 0;
        } else if (iA < kVar.d() && kVar.i(iA) == 92) {
            iA++;
        }
        int iD = kVar.d();
        int i2 = iA;
        while (iA < iD) {
            if (kVar.i(iA) == 47 || kVar.i(iA) == 92) {
                arrayList.add(kVar.n(i2, iA));
                i2 = iA + 1;
            }
            iA++;
        }
        if (i2 < kVar.d()) {
            arrayList.add(kVar.n(i2, kVar.d()));
        }
        return arrayList;
    }

    public final String b() {
        k kVar = pb.c.f8578a;
        k kVarO = this.f8043f;
        int iK = k.k(kVarO, kVar);
        if (iK == -1) {
            iK = k.k(kVarO, pb.c.f8579b);
        }
        if (iK != -1) {
            kVarO = k.o(kVarO, iK + 1, 0, 2);
        } else if (g() != null && kVarO.d() == 2) {
            kVarO = k.f7997i;
        }
        return kVarO.r();
    }

    public final z c() {
        k kVar = pb.c.f8581d;
        k kVar2 = this.f8043f;
        if (q7.k.a(kVar2, kVar)) {
            return null;
        }
        k kVar3 = pb.c.f8578a;
        if (q7.k.a(kVar2, kVar3)) {
            return null;
        }
        k kVar4 = pb.c.f8579b;
        if (q7.k.a(kVar2, kVar4)) {
            return null;
        }
        k kVar5 = pb.c.f8582e;
        kVar2.getClass();
        q7.k.e(kVar5, "suffix");
        int iD = kVar2.d();
        byte[] bArr = kVar5.f7998f;
        if (kVar2.m(iD - bArr.length, kVar5, bArr.length) && (kVar2.d() == 2 || kVar2.m(kVar2.d() - 3, kVar3, 1) || kVar2.m(kVar2.d() - 3, kVar4, 1))) {
            return null;
        }
        int iK = k.k(kVar2, kVar3);
        if (iK == -1) {
            iK = k.k(kVar2, kVar4);
        }
        if (iK == 2 && g() != null) {
            if (kVar2.d() == 3) {
                return null;
            }
            return new z(k.o(kVar2, 0, 3, 1));
        }
        if (iK == 1) {
            q7.k.e(kVar4, "prefix");
            if (kVar2.m(0, kVar4, kVar4.d())) {
                return null;
            }
        }
        if (iK != -1 || g() == null) {
            return iK == -1 ? new z(kVar) : iK == 0 ? new z(k.o(kVar2, 0, 1, 1)) : new z(k.o(kVar2, 0, iK, 1));
        }
        if (kVar2.d() == 2) {
            return null;
        }
        return new z(k.o(kVar2, 0, 2, 1));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        z zVar = (z) obj;
        q7.k.e(zVar, "other");
        return this.f8043f.compareTo(zVar.f8043f);
    }

    public final z d(z zVar) {
        q7.k.e(zVar, "other");
        k kVar = zVar.f8043f;
        int iA = pb.c.a(this);
        k kVar2 = this.f8043f;
        z zVar2 = iA == -1 ? null : new z(kVar2.n(0, iA));
        int iA2 = pb.c.a(zVar);
        if (!q7.k.a(zVar2, iA2 != -1 ? new z(kVar.n(0, iA2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + zVar).toString());
        }
        ArrayList arrayListA = a();
        ArrayList arrayListA2 = zVar.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i2 = 0;
        while (i2 < iMin && q7.k.a(arrayListA.get(i2), arrayListA2.get(i2))) {
            i2++;
        }
        if (i2 == iMin && kVar2.d() == kVar.d()) {
            return h4.n.l(".", false);
        }
        if (arrayListA2.subList(i2, arrayListA2.size()).indexOf(pb.c.f8582e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + zVar).toString());
        }
        h hVar = new h();
        k kVarC = pb.c.c(zVar);
        if (kVarC == null && (kVarC = pb.c.c(this)) == null) {
            kVarC = pb.c.f(f8042g);
        }
        int size = arrayListA2.size();
        for (int i10 = i2; i10 < size; i10++) {
            hVar.H(pb.c.f8582e);
            hVar.H(kVarC);
        }
        int size2 = arrayListA.size();
        while (i2 < size2) {
            hVar.H((k) arrayListA.get(i2));
            hVar.H(kVarC);
            i2++;
        }
        return pb.c.d(hVar, false);
    }

    public final z e(String str) {
        q7.k.e(str, "child");
        h hVar = new h();
        hVar.U(str);
        return pb.c.b(this, pb.c.d(hVar, false), false);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof z) && q7.k.a(((z) obj).f8043f, this.f8043f);
    }

    public final Path f() {
        Path path = Paths.get(this.f8043f.r(), new String[0]);
        q7.k.d(path, "get(...)");
        return path;
    }

    public final Character g() {
        k kVar = pb.c.f8578a;
        k kVar2 = this.f8043f;
        if (k.g(kVar2, kVar) != -1 || kVar2.d() < 2 || kVar2.i(1) != 58) {
            return null;
        }
        char cI = (char) kVar2.i(0);
        if (('a' > cI || cI >= '{') && ('A' > cI || cI >= '[')) {
            return null;
        }
        return Character.valueOf(cI);
    }

    public final int hashCode() {
        return this.f8043f.hashCode();
    }

    public final File toFile() {
        return new File(this.f8043f.r());
    }

    public final String toString() {
        return this.f8043f.r();
    }
}
