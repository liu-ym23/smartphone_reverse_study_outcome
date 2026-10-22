package qb;

import g5.f;
import java.io.Serializable;
import kb.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends e implements a, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public Enum[] f10215f;

    @Override // jb.n
    public final int a() {
        return this.f10215f.length;
    }

    @Override // jb.n, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r32 = (Enum) obj;
        Enum[] enumArr = this.f10215f;
        int iOrdinal = r32.ordinal();
        return ((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r32;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.f10215f;
        int length = enumArr.length;
        if (i >= 0 && i < length) {
            return enumArr[i];
        }
        f.q(androidx.activity.b.i("index: ", i, ", size: ", length));
        return null;
    }

    @Override // kb.e, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r42 = (Enum) obj;
        int iOrdinal = r42.ordinal();
        Enum[] enumArr = this.f10215f;
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r42) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // kb.e, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r42 = (Enum) obj;
        int iOrdinal = r42.ordinal();
        Enum[] enumArr = this.f10215f;
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r42) {
            return iOrdinal;
        }
        return -1;
    }
}
