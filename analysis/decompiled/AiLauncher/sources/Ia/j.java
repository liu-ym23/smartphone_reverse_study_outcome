package Ia;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes5.dex */
public class j<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public int f3413a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3414b;

    public static class b<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3415a = new b();

        public static <T> b<T> a() {
            return f3415a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    public class c extends d<E> {

        /* renamed from: b, reason: collision with root package name */
        public final int f3416b;

        public c() {
            super();
            this.f3416b = ((AbstractList) j.this).modCount;
        }

        @Override // Ia.j.d
        public void a() {
            if (((AbstractList) j.this).modCount == this.f3416b) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) j.this).modCount + "; expected: " + this.f3416b);
        }

        @Override // Ia.j.d
        public E b() {
            return (E) j.this.f3414b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            j.this.clear();
        }
    }

    public static abstract class d<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3418a;

        public d() {
        }

        public abstract void a();

        public abstract T b();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f3418a;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f3418a) {
                throw new NoSuchElementException();
            }
            this.f3418a = true;
            a();
            return b();
        }
    }

    public static /* synthetic */ void b(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
        switch (i10) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = Const.INTENT_KEY_APIKEY;
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i10 == 2 || i10 == 3) {
            objArr[1] = "iterator";
        } else if (i10 == 5 || i10 == 6 || i10 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i10) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 5 && i10 != 6 && i10 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        int i10 = this.f3413a;
        if (i10 == 0) {
            this.f3414b = e10;
        } else if (i10 == 1) {
            this.f3414b = new Object[]{this.f3414b, e10};
        } else {
            Object[] objArr = (Object[]) this.f3414b;
            int length = objArr.length;
            if (i10 >= length) {
                int i11 = ((length * 3) / 2) + 1;
                int i12 = i10 + 1;
                if (i11 < i12) {
                    i11 = i12;
                }
                Object[] objArr2 = new Object[i11];
                this.f3414b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f3413a] = e10;
        }
        this.f3413a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f3414b = null;
        this.f3413a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        int i11;
        if (i10 >= 0 && i10 < (i11 = this.f3413a)) {
            return i11 == 1 ? (E) this.f3414b : (E) ((Object[]) this.f3414b)[i10];
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.f3413a);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int i10 = this.f3413a;
        if (i10 == 0) {
            b bVarA = b.a();
            if (bVarA == null) {
                b(2);
            }
            return bVarA;
        }
        if (i10 == 1) {
            return new c();
        }
        Iterator<E> it = super.iterator();
        if (it == null) {
            b(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i10) {
        int i11;
        E e10;
        if (i10 < 0 || i10 >= (i11 = this.f3413a)) {
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.f3413a);
        }
        if (i11 == 1) {
            e10 = (E) this.f3414b;
            this.f3414b = null;
        } else {
            Object[] objArr = (Object[]) this.f3414b;
            Object obj = objArr[i10];
            if (i11 == 2) {
                this.f3414b = objArr[1 - i10];
            } else {
                int i12 = (i11 - i10) - 1;
                if (i12 > 0) {
                    System.arraycopy(objArr, i10 + 1, objArr, i10, i12);
                }
                objArr[this.f3413a - 1] = null;
            }
            e10 = (E) obj;
        }
        this.f3413a--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f3413a)) {
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.f3413a);
        }
        if (i11 == 1) {
            E e11 = (E) this.f3414b;
            this.f3414b = e10;
            return e11;
        }
        Object[] objArr = (Object[]) this.f3414b;
        E e12 = (E) objArr[i10];
        objArr[i10] = e10;
        return e12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3413a;
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> comparator) {
        int i10 = this.f3413a;
        if (i10 >= 2) {
            Arrays.sort((Object[]) this.f3414b, 0, i10, comparator);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr == 0) {
            b(4);
        }
        int length = tArr.length;
        int i10 = this.f3413a;
        if (i10 == 1) {
            if (length == 0) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.f3414b;
                return tArr2;
            }
            tArr[0] = this.f3414b;
        } else {
            if (length < i10) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.f3414b, i10, tArr.getClass());
                if (tArr3 == null) {
                    b(6);
                }
                return tArr3;
            }
            if (i10 != 0) {
                System.arraycopy(this.f3414b, 0, tArr, 0, i10);
            }
        }
        int i11 = this.f3413a;
        if (length > i11) {
            tArr[i11] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        int i11;
        if (i10 >= 0 && i10 <= (i11 = this.f3413a)) {
            if (i11 == 0) {
                this.f3414b = e10;
            } else if (i11 == 1 && i10 == 0) {
                this.f3414b = new Object[]{e10, this.f3414b};
            } else {
                Object[] objArr = new Object[i11 + 1];
                if (i11 == 1) {
                    objArr[0] = this.f3414b;
                } else {
                    Object[] objArr2 = (Object[]) this.f3414b;
                    System.arraycopy(objArr2, 0, objArr, 0, i10);
                    System.arraycopy(objArr2, i10, objArr, i10 + 1, this.f3413a - i10);
                }
                objArr[i10] = e10;
                this.f3414b = objArr;
            }
            this.f3413a++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.f3413a);
    }
}
