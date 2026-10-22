package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.g;
import mb.c;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class EnumEntriesList<T extends Enum<T>> extends c<T> implements sb.a<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final T[] f10067a;

    public EnumEntriesList(T[] entries) {
        g.f(entries, "entries");
        this.f10067a = entries;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.f10067a);
    }

    @Override // mb.a
    public final int a() {
        return this.f10067a.length;
    }

    @Override // mb.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r32 = (Enum) obj;
        return ((Enum) l.g0(this.f10067a, r32.ordinal())) == r32;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        T[] tArr = this.f10067a;
        int length = tArr.length;
        if (i10 < 0 || i10 >= length) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, length, ", size: "));
        }
        return tArr[i10];
    }

    @Override // mb.c, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r32 = (Enum) obj;
        int iOrdinal = r32.ordinal();
        if (((Enum) l.g0(this.f10067a, iOrdinal)) == r32) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // mb.c, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((Enum) obj);
        }
        return -1;
    }
}
