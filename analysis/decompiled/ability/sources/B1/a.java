package B1;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f178a;
    public final e b;
    public final Object c;

    public a(int i, e eVar, Object obj) {
        this.f178a = i;
        this.b = eVar;
        this.c = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        int i = aVar.f178a;
        Object obj2 = aVar.c;
        if (this.f178a != i || !this.b.equals(aVar.b)) {
            return false;
        }
        Object obj3 = this.c;
        return (obj3 == null || obj3.equals(obj2)) && (obj2 == null || obj2.equals(obj3));
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.b.f181a) << 31) + this.f178a;
    }
}
