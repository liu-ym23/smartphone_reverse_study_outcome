package j7;

import d7.f;
import d7.n;
import java.io.Serializable;
import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class b extends f implements a, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Enum[] f5400f;

    public b(Enum[] enumArr) {
        k.e(enumArr, "entries");
        this.f5400f = enumArr;
    }

    @Override // d7.a
    public final int a() {
        return this.f5400f.length;
    }

    @Override // d7.a, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r32 = (Enum) obj;
        return ((Enum) n.k0(r32.ordinal(), this.f5400f)) == r32;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        Enum[] enumArr = this.f5400f;
        int length = enumArr.length;
        if (i2 < 0 || i2 >= length) {
            throw new IndexOutOfBoundsException(x.k("index: ", i2, length, ", size: "));
        }
        return enumArr[i2];
    }

    @Override // d7.f, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r32 = (Enum) obj;
        int iOrdinal = r32.ordinal();
        if (((Enum) n.k0(iOrdinal, this.f5400f)) == r32) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // d7.f, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((Enum) obj);
        }
        return -1;
    }
}
