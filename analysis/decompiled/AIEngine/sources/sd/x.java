package sd;

import java.io.File;
import java.util.ArrayList;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x implements Comparable<x> {

    /* renamed from: b, reason: collision with root package name */
    public static final String f11981b;

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f11982a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static x a(String str) {
            kotlin.jvm.internal.g.f(str, "<this>");
            ByteString byteString = td.c.f13075a;
            e eVar = new e();
            eVar.U0(str);
            return td.c.d(eVar, false);
        }
    }

    static {
        String separator = File.separator;
        kotlin.jvm.internal.g.e(separator, "separator");
        f11981b = separator;
    }

    public x(ByteString bytes) {
        kotlin.jvm.internal.g.f(bytes, "bytes");
        this.f11982a = bytes;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iA = td.c.a(this);
        ByteString byteString = this.f11982a;
        if (iA == -1) {
            iA = 0;
        } else if (iA < byteString.d() && byteString.j(iA) == 92) {
            iA++;
        }
        int iD = byteString.d();
        int i10 = iA;
        while (iA < iD) {
            if (byteString.j(iA) == 47 || byteString.j(iA) == 92) {
                arrayList.add(byteString.o(i10, iA));
                i10 = iA + 1;
            }
            iA++;
        }
        if (i10 < byteString.d()) {
            arrayList.add(byteString.o(i10, byteString.d()));
        }
        return arrayList;
    }

    public final x b(x other) {
        kotlin.jvm.internal.g.f(other, "other");
        ByteString byteString = other.f11982a;
        int iA = td.c.a(this);
        ByteString byteString2 = this.f11982a;
        x xVar = iA == -1 ? null : new x(byteString2.o(0, iA));
        int iA2 = td.c.a(other);
        if (!kotlin.jvm.internal.g.b(xVar, iA2 != -1 ? new x(byteString.o(0, iA2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        ArrayList arrayListA = a();
        ArrayList arrayListA2 = other.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i10 = 0;
        while (i10 < iMin && kotlin.jvm.internal.g.b(arrayListA.get(i10), arrayListA2.get(i10))) {
            i10++;
        }
        if (i10 == iMin && byteString2.d() == byteString.d()) {
            return a.a(".");
        }
        if (arrayListA2.subList(i10, arrayListA2.size()).indexOf(td.c.f13079e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        e eVar = new e();
        ByteString byteStringC = td.c.c(other);
        if (byteStringC == null && (byteStringC = td.c.c(this)) == null) {
            byteStringC = td.c.f(f11981b);
        }
        int size = arrayListA2.size();
        for (int i11 = i10; i11 < size; i11++) {
            eVar.N0(td.c.f13079e);
            eVar.N0(byteStringC);
        }
        int size2 = arrayListA.size();
        while (i10 < size2) {
            eVar.N0((ByteString) arrayListA.get(i10));
            eVar.N0(byteStringC);
            i10++;
        }
        return td.c.d(eVar, false);
    }

    public final x c(String child) {
        kotlin.jvm.internal.g.f(child, "child");
        e eVar = new e();
        eVar.U0(child);
        return td.c.b(this, td.c.d(eVar, false), false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(x xVar) {
        x other = xVar;
        kotlin.jvm.internal.g.f(other, "other");
        return this.f11982a.compareTo(other.f11982a);
    }

    public final Character d() {
        ByteString byteString = td.c.f13075a;
        ByteString byteString2 = this.f11982a;
        if (ByteString.h(byteString2, byteString) != -1 || byteString2.d() < 2 || byteString2.j(1) != 58) {
            return null;
        }
        char cJ = (char) byteString2.j(0);
        if (('a' > cJ || cJ >= '{') && ('A' > cJ || cJ >= '[')) {
            return null;
        }
        return Character.valueOf(cJ);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof x) && kotlin.jvm.internal.g.b(((x) obj).f11982a, this.f11982a);
    }

    public final int hashCode() {
        return this.f11982a.hashCode();
    }

    public final String toString() {
        return this.f11982a.r();
    }
}
