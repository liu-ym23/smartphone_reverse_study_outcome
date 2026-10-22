package kotlin.collections.builders;

import D7.AbstractC0214f;
import D7.AbstractC0218j;
import D7.C0211c;
import D7.q;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsrpk.d;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0002\u000b\fJ\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "LD7/j;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "E7/a", "BuilderSubList", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListBuilder<E> extends AbstractC0218j implements List<E>, RandomAccess, Serializable {
    public static final ListBuilder d;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f4898a;
    public int b;
    public boolean c;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001\u0010J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "LD7/j;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "kotlin/collections/builders/a", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BuilderSubList<E> extends AbstractC0218j implements List<E>, RandomAccess, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f4899a;
        public final int b;
        public int c;
        public final BuilderSubList d;
        public final ListBuilder e;

        public BuilderSubList(Object[] backing, int i, int i6, BuilderSubList builderSubList, ListBuilder root) {
            k.f(backing, "backing");
            k.f(root, "root");
            this.f4899a = backing;
            this.b = i;
            this.c = i6;
            this.d = builderSubList;
            this.e = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        private final void readObject(ObjectInputStream input) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final Object writeReplace() throws NotSerializableException {
            if (this.e.c) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean add(Object obj) {
            h();
            g();
            f(this.b + this.c, obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean addAll(Collection elements) {
            k.f(elements, "elements");
            h();
            g();
            int size = elements.size();
            e(elements, this.b + this.c, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final void clear() {
            h();
            g();
            j(this.b, this.c);
        }

        public final void e(Collection collection, int i, int i6) {
            ((AbstractList) this).modCount++;
            ListBuilder listBuilder = this.e;
            BuilderSubList builderSubList = this.d;
            if (builderSubList != null) {
                builderSubList.e(collection, i, i6);
            } else {
                ListBuilder listBuilder2 = ListBuilder.d;
                listBuilder.e(collection, i, i6);
            }
            this.f4899a = listBuilder.f4898a;
            this.c += i6;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            g();
            if (obj == this) {
                return true;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                Object[] objArr = this.f4899a;
                int i = this.c;
                if (i == list.size()) {
                    for (int i6 = 0; i6 < i; i6++) {
                        if (k.b(objArr[this.b + i6], list.get(i6))) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public final void f(int i, Object obj) {
            ((AbstractList) this).modCount++;
            ListBuilder listBuilder = this.e;
            BuilderSubList builderSubList = this.d;
            if (builderSubList != null) {
                builderSubList.f(i, obj);
            } else {
                ListBuilder listBuilder2 = ListBuilder.d;
                listBuilder.f(i, obj);
            }
            this.f4899a = listBuilder.f4898a;
            this.c++;
        }

        public final void g() {
            if (((AbstractList) this.e).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i) {
            g();
            C0211c c0211c = AbstractC0214f.Companion;
            int i6 = this.c;
            c0211c.getClass();
            C0211c.b(i, i6);
            return this.f4899a[this.b + i];
        }

        @Override // D7.AbstractC0218j
        /* renamed from: getSize */
        public final int getB() {
            g();
            return this.c;
        }

        public final void h() {
            if (this.e.c) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            g();
            Object[] objArr = this.f4899a;
            int i = this.c;
            int iHashCode = 1;
            for (int i6 = 0; i6 < i; i6++) {
                Object obj = objArr[this.b + i6];
                iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
            }
            return iHashCode;
        }

        public final Object i(int i) {
            Object objI;
            ((AbstractList) this).modCount++;
            BuilderSubList builderSubList = this.d;
            if (builderSubList != null) {
                objI = builderSubList.i(i);
            } else {
                ListBuilder listBuilder = ListBuilder.d;
                objI = this.e.i(i);
            }
            this.c--;
            return objI;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(Object obj) {
            g();
            for (int i = 0; i < this.c; i++) {
                if (k.b(this.f4899a[this.b + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean isEmpty() {
            g();
            return this.c == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public final Iterator iterator() {
            return listIterator(0);
        }

        public final void j(int i, int i6) {
            if (i6 > 0) {
                ((AbstractList) this).modCount++;
            }
            BuilderSubList builderSubList = this.d;
            if (builderSubList != null) {
                builderSubList.j(i, i6);
            } else {
                ListBuilder listBuilder = ListBuilder.d;
                this.e.j(i, i6);
            }
            this.c -= i6;
        }

        public final int l(int i, int i6, Collection collection, boolean z10) {
            int iL;
            BuilderSubList builderSubList = this.d;
            if (builderSubList != null) {
                iL = builderSubList.l(i, i6, collection, z10);
            } else {
                ListBuilder listBuilder = ListBuilder.d;
                iL = this.e.l(i, i6, collection, z10);
            }
            if (iL > 0) {
                ((AbstractList) this).modCount++;
            }
            this.c -= iL;
            return iL;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(Object obj) {
            g();
            for (int i = this.c - 1; i >= 0; i--) {
                if (k.b(this.f4899a[this.b + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean remove(Object obj) {
            h();
            g();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                removeAt(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean removeAll(Collection elements) {
            k.f(elements, "elements");
            h();
            g();
            return l(this.b, this.c, elements, false) > 0;
        }

        @Override // D7.AbstractC0218j
        public final Object removeAt(int i) {
            h();
            g();
            C0211c c0211c = AbstractC0214f.Companion;
            int i6 = this.c;
            c0211c.getClass();
            C0211c.b(i, i6);
            return i(this.b + i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean retainAll(Collection elements) {
            k.f(elements, "elements");
            h();
            g();
            return l(this.b, this.c, elements, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i, Object obj) {
            h();
            g();
            C0211c c0211c = AbstractC0214f.Companion;
            int i6 = this.c;
            c0211c.getClass();
            C0211c.b(i, i6);
            Object[] objArr = this.f4899a;
            int i10 = this.b + i;
            Object obj2 = objArr[i10];
            objArr[i10] = obj;
            return obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public final List subList(int i, int i6) {
            C0211c c0211c = AbstractC0214f.Companion;
            int i10 = this.c;
            c0211c.getClass();
            C0211c.d(i, i6, i10);
            return new BuilderSubList(this.f4899a, this.b + i, i6 - i, this, this.e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final Object[] toArray(Object[] array) {
            k.f(array, "array");
            g();
            int length = array.length;
            int i = this.c;
            int i6 = this.b;
            if (length < i) {
                Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f4899a, i6, i + i6, array.getClass());
                k.e(objArrCopyOfRange, "copyOfRange(...)");
                return objArrCopyOfRange;
            }
            q.X(this.f4899a, array, 0, i6, i + i6);
            int i10 = this.c;
            if (i10 < array.length) {
                array[i10] = null;
            }
            return array;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            g();
            return d.g(this.f4899a, this.b, this.c, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator(int i) {
            g();
            C0211c c0211c = AbstractC0214f.Companion;
            int i6 = this.c;
            c0211c.getClass();
            C0211c.c(i, i6);
            return new a(this, i);
        }

        @Override // java.util.AbstractList, java.util.List
        public final void add(int i, Object obj) {
            h();
            g();
            C0211c c0211c = AbstractC0214f.Companion;
            int i6 = this.c;
            c0211c.getClass();
            C0211c.c(i, i6);
            f(this.b + i, obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public final boolean addAll(int i, Collection elements) {
            k.f(elements, "elements");
            h();
            g();
            C0211c c0211c = AbstractC0214f.Companion;
            int i6 = this.c;
            c0211c.getClass();
            C0211c.c(i, i6);
            int size = elements.size();
            e(elements, this.b + i, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final Object[] toArray() {
            g();
            Object[] objArr = this.f4899a;
            int i = this.c;
            int i6 = this.b;
            return q.d0(objArr, i6, i + i6);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.c = true;
        d = listBuilder;
    }

    public ListBuilder(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f4898a = new Object[i];
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.c) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        int i = this.b;
        ((AbstractList) this).modCount++;
        h(i, 1);
        this.f4898a[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        k.f(elements, "elements");
        g();
        int size = elements.size();
        e(elements, this.b, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        j(0, this.b);
    }

    public final void e(Collection collection, int i, int i6) {
        ((AbstractList) this).modCount++;
        h(i, i6);
        Iterator<E> it = collection.iterator();
        for (int i10 = 0; i10 < i6; i10++) {
            this.f4898a[i + i10] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f4898a;
            int i = this.b;
            if (i == list.size()) {
                for (int i6 = 0; i6 < i; i6++) {
                    if (k.b(objArr[i6], list.get(i6))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i, Object obj) {
        ((AbstractList) this).modCount++;
        h(i, 1);
        this.f4898a[i] = obj;
    }

    public final void g() {
        if (this.c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        C0211c c0211c = AbstractC0214f.Companion;
        int i6 = this.b;
        c0211c.getClass();
        C0211c.b(i, i6);
        return this.f4898a[i];
    }

    @Override // D7.AbstractC0218j
    /* renamed from: getSize, reason: from getter */
    public final int getB() {
        return this.b;
    }

    public final void h(int i, int i6) {
        int i10 = this.b + i6;
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f4898a;
        if (i10 > objArr.length) {
            C0211c c0211c = AbstractC0214f.Companion;
            int length = objArr.length;
            c0211c.getClass();
            int iE = C0211c.e(length, i10);
            Object[] objArr2 = this.f4898a;
            k.f(objArr2, "<this>");
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, iE);
            k.e(objArrCopyOf, "copyOf(...)");
            this.f4898a = objArrCopyOf;
        }
        Object[] objArr3 = this.f4898a;
        q.X(objArr3, objArr3, i + i6, i, this.b);
        this.b += i6;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f4898a;
        int i = this.b;
        int iHashCode = 1;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj = objArr[i6];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final Object i(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f4898a;
        Object obj = objArr[i];
        q.X(objArr, objArr, i, i + 1, this.b);
        Object[] objArr2 = this.f4898a;
        int i6 = this.b - 1;
        k.f(objArr2, "<this>");
        objArr2[i6] = null;
        this.b--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.b; i++) {
            if (k.b(this.f4898a[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i, int i6) {
        if (i6 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f4898a;
        q.X(objArr, objArr, i, i + i6, this.b);
        Object[] objArr2 = this.f4898a;
        int i10 = this.b;
        d.H(objArr2, i10 - i6, i10);
        this.b -= i6;
    }

    public final int l(int i, int i6, Collection collection, boolean z10) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < i6) {
            int i12 = i + i10;
            if (collection.contains(this.f4898a[i12]) == z10) {
                Object[] objArr = this.f4898a;
                i10++;
                objArr[i11 + i] = objArr[i12];
                i11++;
            } else {
                i10++;
            }
        }
        int i13 = i6 - i11;
        Object[] objArr2 = this.f4898a;
        q.X(objArr2, objArr2, i + i11, i6 + i, this.b);
        Object[] objArr3 = this.f4898a;
        int i14 = this.b;
        d.H(objArr3, i14 - i13, i14);
        if (i13 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.b -= i13;
        return i13;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.b - 1; i >= 0; i--) {
            if (k.b(this.f4898a[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            removeAt(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        k.f(elements, "elements");
        g();
        return l(0, this.b, elements, false) > 0;
    }

    @Override // D7.AbstractC0218j
    public final Object removeAt(int i) {
        g();
        C0211c c0211c = AbstractC0214f.Companion;
        int i6 = this.b;
        c0211c.getClass();
        C0211c.b(i, i6);
        return i(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        k.f(elements, "elements");
        g();
        return l(0, this.b, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        g();
        C0211c c0211c = AbstractC0214f.Companion;
        int i6 = this.b;
        c0211c.getClass();
        C0211c.b(i, i6);
        Object[] objArr = this.f4898a;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i6) {
        C0211c c0211c = AbstractC0214f.Companion;
        int i10 = this.b;
        c0211c.getClass();
        C0211c.d(i, i6, i10);
        return new BuilderSubList(this.f4898a, i, i6 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        k.f(array, "array");
        int length = array.length;
        int i = this.b;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f4898a, 0, i, array.getClass());
            k.e(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        q.X(this.f4898a, array, 0, 0, i);
        int i6 = this.b;
        if (i6 < array.length) {
            array[i6] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return d.g(this.f4898a, 0, this.b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        C0211c c0211c = AbstractC0214f.Companion;
        int i6 = this.b;
        c0211c.getClass();
        C0211c.c(i, i6);
        return new E7.a(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        k.f(elements, "elements");
        g();
        C0211c c0211c = AbstractC0214f.Companion;
        int i6 = this.b;
        c0211c.getClass();
        C0211c.c(i, i6);
        int size = elements.size();
        e(elements, i, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        g();
        C0211c c0211c = AbstractC0214f.Companion;
        int i6 = this.b;
        c0211c.getClass();
        C0211c.c(i, i6);
        ((AbstractList) this).modCount++;
        h(i, 1);
        this.f4898a[i] = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return q.d0(this.f4898a, 0, this.b);
    }
}
