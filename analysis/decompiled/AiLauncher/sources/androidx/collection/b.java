package androidx.collection;

import Z8.C1168p;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import c0.C1481a;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import q9.InterfaceC5163b;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u00015B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u0010J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u0010J\u0015\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u0017J\u0015\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d\"\u0004\b\u0001\u0010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d¢\u0006\u0004\b\u001e\u0010\"J\u001a\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b$\u0010\u0010J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0096\u0002¢\u0006\u0004\b+\u0010,J\u001d\u0010/\u001a\u00020\u000e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016¢\u0006\u0004\b/\u00100J\u001d\u00101\u001a\u00020\u000e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016¢\u0006\u0004\b1\u00100J\u001d\u00102\u001a\u00020\u000e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016¢\u0006\u0004\b2\u00100J\u001d\u00103\u001a\u00020\u000e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016¢\u0006\u0004\b3\u00100R\"\u0010;\u001a\u0002048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R*\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010<\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010?R\"\u0010C\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010@\u001a\u0004\bA\u0010&\"\u0004\bB\u0010\u0007R\u0014\u0010E\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010&¨\u0006F"}, d2 = {"Landroidx/collection/b;", ExifInterface.LONGITUDE_EAST, "", "", "", "capacity", "<init>", "(I)V", "LY8/t;", "clear", "()V", "minimumCapacity", Const.INTENT_KEY_PKGNAME, "element", "", "contains", "(Ljava/lang/Object;)Z", "", "key", "indexOf", "(Ljava/lang/Object;)I", "index", "n", "(I)Ljava/lang/Object;", "isEmpty", "()Z", "add", "remove", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "iterator", "()Ljava/util/Iterator;", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "addAll", "removeAll", "retainAll", "", Const.INTENT_KEY_APIKEY, "[I", "e", "()[I", "l", "([I)V", "hashes", "[Ljava/lang/Object;", "c", "k", "([Ljava/lang/Object;)V", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "m", "_size", "f", ContentDisposition.Parameters.Size, "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E>, InterfaceC5163b, q9.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int[] hashes;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Object[] array;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int _size;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/collection/b$a;", "Landroidx/collection/f;", "<init>", "(Landroidx/collection/b;)V", "", "index", Const.INTENT_KEY_APIKEY, "(I)Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(I)V", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class a extends f<E> {
        public a() {
            super(b.this.i());
        }

        @Override // androidx.collection.f
        public E a(int index) {
            return b.this.n(index);
        }

        @Override // androidx.collection.f
        public void b(int index) {
            b.this.j(index);
        }
    }

    public b() {
        this(0, 1, null);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E element) {
        int i10;
        int iC;
        int i11 = i();
        if (element == null) {
            iC = d.d(this);
            i10 = 0;
        } else {
            int iHashCode = element.hashCode();
            i10 = iHashCode;
            iC = d.c(this, element, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i12 = ~iC;
        if (i11 >= getHashes().length) {
            int i13 = 8;
            if (i11 >= 8) {
                i13 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i13 = 4;
            }
            int[] hashes = getHashes();
            Object[] array = getArray();
            d.a(this, i13);
            if (i11 != i()) {
                throw new ConcurrentModificationException();
            }
            if (!(getHashes().length == 0)) {
                C1168p.l(hashes, getHashes(), 0, 0, hashes.length, 6, null);
                C1168p.n(array, getArray(), 0, 0, array.length, 6, null);
            }
        }
        if (i12 < i11) {
            int i14 = i12 + 1;
            C1168p.g(getHashes(), getHashes(), i14, i12, i11);
            C1168p.i(getArray(), getArray(), i14, i12, i11);
        }
        if (i11 != i() || i12 >= getHashes().length) {
            throw new ConcurrentModificationException();
        }
        getHashes()[i12] = i10;
        getArray()[i12] = element;
        m(i() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        b(i() + elements.size());
        Iterator<? extends E> it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final void b(int minimumCapacity) {
        int i10 = i();
        if (getHashes().length < minimumCapacity) {
            int[] hashes = getHashes();
            Object[] array = getArray();
            d.a(this, minimumCapacity);
            if (i() > 0) {
                C1168p.l(hashes, getHashes(), 0, 0, i(), 6, null);
                C1168p.n(array, getArray(), 0, 0, i(), 6, null);
            }
        }
        if (i() != i10) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: c, reason: from getter */
    public final Object[] getArray() {
        return this.array;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (i() != 0) {
            l(C1481a.f15396a);
            k(C1481a.f15398c);
            m(0);
        }
        if (i() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e, reason: from getter */
    public final int[] getHashes() {
        return this.hashes;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Set) || size() != ((Set) other).size()) {
            return false;
        }
        try {
            int i10 = i();
            for (int i11 = 0; i11 < i10; i11++) {
                if (!((Set) other).contains(n(i11))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* renamed from: f, reason: from getter */
    public int get_size() {
        return this._size;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes = getHashes();
        int i10 = i();
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += hashes[i12];
        }
        return i11;
    }

    public final int i() {
        return this._size;
    }

    public final int indexOf(Object key) {
        return key == null ? d.d(this) : d.c(this, key, key.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return i() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    public final E j(int index) {
        int i10;
        Object[] objArr;
        int i11 = i();
        E e10 = (E) getArray()[index];
        if (i11 <= 1) {
            clear();
            return e10;
        }
        int i12 = i11 - 1;
        if (getHashes().length <= 8 || i() >= getHashes().length / 3) {
            if (index < i12) {
                int i13 = index + 1;
                C1168p.g(getHashes(), getHashes(), index, i13, i11);
                C1168p.i(getArray(), getArray(), index, i13, i11);
            }
            getArray()[i12] = null;
        } else {
            int i14 = i() > 8 ? i() + (i() >> 1) : 8;
            int[] hashes = getHashes();
            Object[] array = getArray();
            d.a(this, i14);
            if (index > 0) {
                C1168p.l(hashes, getHashes(), 0, 0, index, 6, null);
                objArr = array;
                C1168p.n(objArr, getArray(), 0, 0, index, 6, null);
                i10 = index;
            } else {
                i10 = index;
                objArr = array;
            }
            if (i10 < i12) {
                int i15 = i10 + 1;
                C1168p.g(hashes, getHashes(), i10, i15, i11);
                C1168p.i(objArr, getArray(), i10, i15, i11);
            }
        }
        if (i11 != i()) {
            throw new ConcurrentModificationException();
        }
        m(i12);
        return e10;
    }

    public final void k(Object[] objArr) {
        kotlin.jvm.internal.p.i(objArr, "<set-?>");
        this.array = objArr;
    }

    public final void l(int[] iArr) {
        kotlin.jvm.internal.p.i(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final void m(int i10) {
        this._size = i10;
    }

    public final E n(int index) {
        return (E) getArray()[index];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf < 0) {
            return false;
        }
        j(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        boolean z10 = false;
        for (int i10 = i() - 1; -1 < i10; i10--) {
            if (!F.f0(elements, getArray()[i10])) {
                j(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return get_size();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return C1168p.q(this.array, 0, this._size);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(i() * 14);
        sb2.append('{');
        int i10 = i();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            E eN = n(i11);
            if (eN != this) {
                sb2.append(eN);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public b(int i10) {
        this.hashes = C1481a.f15396a;
        this.array = C1481a.f15398c;
        if (i10 > 0) {
            d.a(this, i10);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.p.i(array, "array");
        T[] tArr = (T[]) c.a(array, this._size);
        C1168p.i(this.array, tArr, 0, 0, this._size);
        kotlin.jvm.internal.p.f(tArr);
        return tArr;
    }

    public /* synthetic */ b(int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
