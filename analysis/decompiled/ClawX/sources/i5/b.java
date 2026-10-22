package i5;

import c5.f;
import c5.l;
import java.io.Serializable;
import java.util.RandomAccess;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends f implements a, RandomAccess, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Enum[] f3151a;

    public b(Enum[] entries) {
        p.e(entries, "entries");
        this.f3151a = entries;
    }

    @Override // c5.b, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r3 = (Enum) obj;
        return ((Enum) l.f0(this.f3151a, r3.ordinal())) == r3;
    }

    @Override // c5.b
    public final int f() {
        return this.f3151a.length;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        Enum[] enumArr = this.f3151a;
        int length = enumArr.length;
        if (i8 < 0 || i8 >= length) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, length, "index: ", ", size: "));
        }
        return enumArr[i8];
    }

    @Override // c5.f, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r3 = (Enum) obj;
        int iOrdinal = r3.ordinal();
        if (((Enum) l.f0(this.f3151a, iOrdinal)) == r3) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // c5.f, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r3 = (Enum) obj;
        int iOrdinal = r3.ordinal();
        if (((Enum) l.f0(this.f3151a, iOrdinal)) == r3) {
            return iOrdinal;
        }
        return -1;
    }
}
