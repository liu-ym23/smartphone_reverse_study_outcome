package c8;

import g5.f;
import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public e f2223c;
    public volatile String i = null;

    /* renamed from: j, reason: collision with root package name */
    public int f2227j = 0;

    /* renamed from: f, reason: collision with root package name */
    public a f2224f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f2225g = null;

    /* renamed from: h, reason: collision with root package name */
    public int f2226h = -1;

    public a(e eVar) {
        this.f2223c = eVar;
    }

    public final a a(int i) {
        a aVar = new a();
        aVar.i = null;
        aVar.f2227j = 0;
        aVar.f2224f = this;
        aVar.f2223c = this.f2223c;
        aVar.f2225g = null;
        aVar.f2226h = i;
        VarHandle.storeStoreFence();
        return aVar;
    }

    public final a b(String str) {
        a aVar = new a();
        aVar.i = null;
        aVar.f2227j = 0;
        aVar.f2224f = this;
        aVar.f2223c = this.f2223c;
        aVar.f2225g = str;
        aVar.f2226h = -1;
        VarHandle.storeStoreFence();
        return aVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(a aVar) {
        a aVar2;
        int iCompareTo;
        a aVar3 = this.f2224f;
        if (aVar3 != null && aVar.f2224f == null) {
            return 1;
        }
        if (aVar3 != null || aVar.f2224f == null) {
            if (aVar3 != null && (aVar2 = aVar.f2224f) != null && (iCompareTo = aVar3.compareTo(aVar2)) != 0) {
                return iCompareTo;
            }
            Object objD = d(-1);
            String string = objD != null ? objD.toString() : null;
            Object objD2 = aVar.d(-1);
            String string2 = objD2 != null ? objD2.toString() : null;
            if (string == null && string2 == null) {
                return 0;
            }
            if (string != null && string2 == null) {
                return 1;
            }
            if (string != null || string2 == null) {
                return string.compareTo(string2);
            }
        }
        return -1;
    }

    public final Object d(int i) {
        if (i == -1) {
            int i3 = this.f2226h;
            return i3 != -1 ? Integer.valueOf(i3) : this.f2225g;
        }
        int nameCount = getNameCount();
        if (nameCount - 1 == i) {
            return d(-1);
        }
        int i10 = (nameCount - i) - 1;
        if (i10 < 0) {
            f.s("");
            return null;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            this = this.f2224f;
        }
        return this.d(-1);
    }

    public final boolean e(a aVar) {
        int nameCount = getNameCount();
        int nameCount2 = aVar.getNameCount();
        if (nameCount2 > nameCount) {
            return false;
        }
        if (nameCount2 == nameCount) {
            return equals(aVar);
        }
        for (int i = nameCount - nameCount2; i > 0; i--) {
            this = this.f2224f;
        }
        return aVar.equals(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.f2225g, aVar.f2225g) && this.f2226h == aVar.f2226h && this.f2223c == aVar.f2223c && Objects.equals(this.f2224f, aVar.f2224f);
    }

    public final int getNameCount() {
        int i = (this.f2226h == -1 && this.f2225g == null) ? 0 : 1;
        a aVar = this.f2224f;
        return i + (aVar != null ? aVar.getNameCount() : 0);
    }

    public final int hashCode() {
        int i = this.f2227j;
        if (i != 0) {
            return i;
        }
        int iHash = Objects.hash(this.f2224f, this.f2225g, Integer.valueOf(this.f2226h), this.f2223c);
        this.f2227j = iHash;
        return iHash;
    }

    public final String toString() {
        if (this.i == null) {
            if (this.f2226h == -1 && this.f2225g == null) {
                this.i = this.f2223c.f2236c;
                return this.i;
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            int i = this.f2226h;
            if (i != -1) {
                arrayDeque.push(Integer.valueOf(i));
            } else {
                String str = this.f2225g;
                if (str != null) {
                    arrayDeque.push(str);
                }
            }
            for (a aVar = this.f2224f; aVar != null; aVar = aVar.f2224f) {
                int i3 = aVar.f2226h;
                if (i3 != -1) {
                    arrayDeque.push(Integer.valueOf(i3));
                } else {
                    String str2 = aVar.f2225g;
                    if (str2 != null) {
                        arrayDeque.push(str2);
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f2223c.f2236c);
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                boolean z10 = next instanceof Number;
                e eVar = this.f2223c;
                if (z10) {
                    eVar.f2238g.accept(sb2, Integer.valueOf(((Number) next).intValue()));
                } else {
                    eVar.f2237f.accept(sb2, next.toString());
                }
            }
            this.i = sb2.toString();
        }
        return this.i;
    }
}
