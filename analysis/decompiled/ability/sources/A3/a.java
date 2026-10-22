package A3;

import com.networknt.schema.path.PathType;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class a implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final PathType f92a;
    public final a b;
    public final String c;
    public final int d;
    public volatile String e;
    public int f;

    public a(PathType pathType) {
        this.e = null;
        this.f = 0;
        this.f92a = pathType;
        this.b = null;
        this.c = null;
        this.d = -1;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(a aVar) {
        a aVar2;
        int iCompareTo;
        a aVar3 = this.b;
        if (aVar3 != null && aVar.b == null) {
            return 1;
        }
        if (aVar3 != null || aVar.b == null) {
            if (aVar3 != null && (aVar2 = aVar.b) != null && (iCompareTo = aVar3.compareTo(aVar2)) != 0) {
                return iCompareTo;
            }
            Object objB = b(-1);
            String string = objB != null ? objB.toString() : null;
            Object objB2 = aVar.b(-1);
            String string2 = objB2 != null ? objB2.toString() : null;
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

    public final Object b(int i) {
        if (i == -1) {
            int i6 = this.d;
            return i6 != -1 ? Integer.valueOf(i6) : this.c;
        }
        int nameCount = getNameCount();
        if (nameCount - 1 == i) {
            return b(-1);
        }
        int i10 = (nameCount - i) - 1;
        if (i10 < 0) {
            throw new IllegalArgumentException("");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            this = this.b;
        }
        return this.b(-1);
    }

    public final boolean c(a aVar) {
        int nameCount = getNameCount();
        int nameCount2 = aVar.getNameCount();
        if (nameCount2 > nameCount) {
            return false;
        }
        if (nameCount2 == nameCount) {
            return equals(aVar);
        }
        for (int i = nameCount - nameCount2; i > 0; i--) {
            this = this.b;
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
        return Objects.equals(this.c, aVar.c) && this.d == aVar.d && this.f92a == aVar.f92a && Objects.equals(this.b, aVar.b);
    }

    public final int getNameCount() {
        int i = (this.d == -1 && this.c == null) ? 0 : 1;
        a aVar = this.b;
        return i + (aVar != null ? aVar.getNameCount() : 0);
    }

    public final int hashCode() {
        int i = this.f;
        if (i != 0) {
            return i;
        }
        int iHash = Objects.hash(this.b, this.c, Integer.valueOf(this.d), this.f92a);
        this.f = iHash;
        return iHash;
    }

    public final String toString() {
        if (this.e == null) {
            if (this.d == -1 && this.c == null) {
                this.e = this.f92a.f3055a;
                return this.e;
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            int i = this.d;
            if (i != -1) {
                arrayDeque.push(Integer.valueOf(i));
            } else {
                String str = this.c;
                if (str != null) {
                    arrayDeque.push(str);
                }
            }
            for (a aVar = this.b; aVar != null; aVar = aVar.b) {
                int i6 = aVar.d;
                if (i6 != -1) {
                    arrayDeque.push(Integer.valueOf(i6));
                } else {
                    String str2 = aVar.c;
                    if (str2 != null) {
                        arrayDeque.push(str2);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            String str3 = this.f92a.f3055a;
            if (str3 != null) {
                sb.append(str3);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof Number) {
                    this.f92a.c.accept(sb, Integer.valueOf(((Number) next).intValue()));
                } else {
                    PathType pathType = this.f92a;
                    pathType.b.accept(sb, next.toString());
                }
            }
            this.e = sb.toString();
        }
        return this.e;
    }

    public a(a aVar, String str) {
        this.e = null;
        this.f = 0;
        this.b = aVar;
        this.f92a = aVar.f92a;
        this.c = str;
        this.d = -1;
    }

    public a(a aVar, int i) {
        this.e = null;
        this.f = 0;
        this.b = aVar;
        this.f92a = aVar.f92a;
        this.c = null;
        this.d = i;
    }
}
