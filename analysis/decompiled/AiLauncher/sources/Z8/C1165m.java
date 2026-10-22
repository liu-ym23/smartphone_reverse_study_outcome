package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\u0007\u0018\u0000 U*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001LB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0017\b\u0016\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0005\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0012J%\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010 \u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\u0007J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00028\u0000¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00028\u0000¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b(\u0010&J\u0015\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\f2\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0004\b,\u0010+J\r\u0010-\u001a\u00028\u0000¢\u0006\u0004\b-\u0010&J\u000f\u0010.\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b.\u0010&J\r\u0010/\u001a\u00028\u0000¢\u0006\u0004\b/\u0010&J\u000f\u00100\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b0\u0010&J\u0017\u00101\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00101\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00103J\u001d\u00104\u001a\u00020\"2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b4\u00105J%\u00104\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b4\u00106J\u0018\u00107\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b7\u00108J \u00109\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b;\u00102J\u0017\u0010<\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010?\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b?\u00102J\u0017\u0010@\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b@\u00108J\u001d\u0010A\u001a\u00020\"2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\bA\u00105J\u001d\u0010B\u001a\u00020\"2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\bB\u00105J\u000f\u0010C\u001a\u00020\fH\u0016¢\u0006\u0004\bC\u0010\u0007J)\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00010E\"\u0004\b\u0001\u0010D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010I0EH\u0016¢\u0006\u0004\bG\u0010JJ\u001f\u0010K\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0014¢\u0006\u0004\bK\u0010\u001cR\u0016\u0010N\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010I0E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR$\u0010T\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b@\u0010M\u001a\u0004\bO\u0010S¨\u0006V"}, d2 = {"LZ8/m;", ExifInterface.LONGITUDE_EAST, "LZ8/h;", "", "initialCapacity", "<init>", "(I)V", "()V", "", "elements", "(Ljava/util/Collection;)V", "minCapacity", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "newCapacity", "f", "index", "t", "(I)I", "m", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "internalIndex", "e", "(ILjava/util/Collection;)V", "fromIndex", "toIndex", "y", "(II)V", "z", "internalFromIndex", "internalToIndex", "n", "u", "", "isEmpty", "()Z", AMapLocationStaticsEntity.FIRST_LOCATE, "()Ljava/lang/Object;", "last", "l", "element", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "v", "removeLast", "x", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "get", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "c", "removeAll", "retainAll", "clear", ExifInterface.GPS_DIRECTION_TRUE, "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "removeRange", Const.INTENT_KEY_APIKEY, "I", "head", Const.INTENT_KEY_PKGNAME, "[Ljava/lang/Object;", "elementData", UxipConstants.f30680s, "()I", ContentDisposition.Parameters.Size, Const.INTENT_KEY_UMID, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Z8.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1165m<E> extends AbstractC1160h<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final Object[] f7696e = new Object[0];

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int head;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Object[] elementData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int size;

    public C1165m(int i10) {
        Object[] objArr;
        if (i10 == 0) {
            objArr = f7696e;
        } else {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i10);
            }
            objArr = new Object[i10];
        }
        this.elementData = objArr;
    }

    private final void j(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (minCapacity <= objArr.length) {
            return;
        }
        if (objArr == f7696e) {
            this.elementData = new Object[C5685n.f(minCapacity, 10)];
        } else {
            f(AbstractC1156d.INSTANCE.e(objArr.length, minCapacity));
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        u();
        j(size() + elements.size());
        e(t(this.head + size()), elements);
        return true;
    }

    public final void addFirst(E element) {
        u();
        j(size() + 1);
        int i10 = i(this.head);
        this.head = i10;
        this.elementData[i10] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        u();
        j(size() + 1);
        this.elementData[t(this.head + size())] = element;
        this.size = size() + 1;
    }

    @Override // Z8.AbstractC1160h
    /* renamed from: b, reason: from getter */
    public int getSize() {
        return this.size;
    }

    @Override // Z8.AbstractC1160h
    public E c(int index) {
        AbstractC1156d.INSTANCE.b(index, size());
        if (index == C1173v.o(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        u();
        int iT = t(this.head + index);
        E e10 = (E) this.elementData[iT];
        if (index < (size() >> 1)) {
            int i10 = this.head;
            if (iT >= i10) {
                Object[] objArr = this.elementData;
                C1168p.i(objArr, objArr, i10 + 1, i10, iT);
            } else {
                Object[] objArr2 = this.elementData;
                C1168p.i(objArr2, objArr2, 1, 0, iT);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i11 = this.head;
                C1168p.i(objArr3, objArr3, i11 + 1, i11, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i12 = this.head;
            objArr4[i12] = null;
            this.head = k(i12);
        } else {
            int iT2 = t(this.head + C1173v.o(this));
            if (iT <= iT2) {
                Object[] objArr5 = this.elementData;
                C1168p.i(objArr5, objArr5, iT, iT + 1, iT2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                C1168p.i(objArr6, objArr6, iT, iT + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                C1168p.i(objArr7, objArr7, 0, 1, iT2 + 1);
            }
            this.elementData[iT2] = null;
        }
        this.size = size() - 1;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            u();
            n(this.head, t(this.head + size()));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public final void e(int internalIndex, Collection<? extends E> elements) {
        Iterator<? extends E> it = elements.iterator();
        int length = this.elementData.length;
        while (internalIndex < length && it.hasNext()) {
            this.elementData[internalIndex] = it.next();
            internalIndex++;
        }
        int i10 = this.head;
        for (int i11 = 0; i11 < i10 && it.hasNext(); i11++) {
            this.elementData[i11] = it.next();
        }
        this.size = size() + elements.size();
    }

    public final void f(int newCapacity) {
        Object[] objArr = new Object[newCapacity];
        Object[] objArr2 = this.elementData;
        C1168p.i(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i10 = this.head;
        C1168p.i(objArr3, objArr, length - i10, 0, i10);
        this.head = 0;
        this.elementData = objArr;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractC1156d.INSTANCE.b(index, size());
        return (E) this.elementData[t(this.head + index)];
    }

    public final int i(int index) {
        return index == 0 ? r.f0(this.elementData) : index - 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        int i10;
        int iT = t(this.head + size());
        int length = this.head;
        if (length < iT) {
            while (length < iT) {
                if (kotlin.jvm.internal.p.d(element, this.elementData[length])) {
                    i10 = this.head;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iT) {
            return -1;
        }
        int length2 = this.elementData.length;
        while (true) {
            if (length >= length2) {
                for (int i11 = 0; i11 < iT; i11++) {
                    if (kotlin.jvm.internal.p.d(element, this.elementData[i11])) {
                        length = i11 + this.elementData.length;
                        i10 = this.head;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.p.d(element, this.elementData[length])) {
                i10 = this.head;
                break;
            }
            length++;
        }
        return length - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int k(int index) {
        if (index == r.f0(this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    public final E l() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[t(this.head + C1173v.o(this))];
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[t(this.head + C1173v.o(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        int iF0;
        int i10;
        int iT = t(this.head + size());
        int i11 = this.head;
        if (i11 < iT) {
            iF0 = iT - 1;
            if (i11 <= iF0) {
                while (!kotlin.jvm.internal.p.d(element, this.elementData[iF0])) {
                    if (iF0 != i11) {
                        iF0--;
                    }
                }
                i10 = this.head;
                return iF0 - i10;
            }
            return -1;
        }
        if (i11 > iT) {
            int i12 = iT - 1;
            while (true) {
                if (-1 >= i12) {
                    iF0 = r.f0(this.elementData);
                    int i13 = this.head;
                    if (i13 <= iF0) {
                        while (!kotlin.jvm.internal.p.d(element, this.elementData[iF0])) {
                            if (iF0 != i13) {
                                iF0--;
                            }
                        }
                        i10 = this.head;
                    }
                } else {
                    if (kotlin.jvm.internal.p.d(element, this.elementData[i12])) {
                        iF0 = i12 + this.elementData.length;
                        i10 = this.head;
                        break;
                    }
                    i12--;
                }
            }
        }
        return -1;
    }

    public final int m(int index) {
        return index < 0 ? index + this.elementData.length : index;
    }

    public final void n(int internalFromIndex, int internalToIndex) {
        if (internalFromIndex < internalToIndex) {
            C1168p.v(this.elementData, null, internalFromIndex, internalToIndex);
            return;
        }
        Object[] objArr = this.elementData;
        C1168p.v(objArr, null, internalFromIndex, objArr.length);
        C1168p.v(this.elementData, null, 0, internalToIndex);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf == -1) {
            return false;
        }
        c(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        int iT;
        kotlin.jvm.internal.p.i(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iT2 = t(this.head + size());
            int i10 = this.head;
            if (i10 < iT2) {
                iT = i10;
                while (i10 < iT2) {
                    Object obj = this.elementData[i10];
                    if (elements.contains(obj)) {
                        z10 = true;
                    } else {
                        this.elementData[iT] = obj;
                        iT++;
                    }
                    i10++;
                }
                C1168p.v(this.elementData, null, iT, iT2);
            } else {
                int length = this.elementData.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (elements.contains(obj2)) {
                        z11 = true;
                    } else {
                        this.elementData[i11] = obj2;
                        i11++;
                    }
                    i10++;
                }
                iT = t(i11);
                for (int i12 = 0; i12 < iT2; i12++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (elements.contains(obj3)) {
                        z11 = true;
                    } else {
                        this.elementData[iT] = obj3;
                        iT = k(iT);
                    }
                }
                z10 = z11;
            }
            if (z10) {
                u();
                this.size = m(iT - this.head);
            }
        }
        return z10;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        u();
        Object[] objArr = this.elementData;
        int i10 = this.head;
        E e10 = (E) objArr[i10];
        objArr[i10] = null;
        this.head = k(i10);
        this.size = size() - 1;
        return e10;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        u();
        int iT = t(this.head + C1173v.o(this));
        Object[] objArr = this.elementData;
        E e10 = (E) objArr[iT];
        objArr[iT] = null;
        this.size = size() - 1;
        return e10;
    }

    @Override // java.util.AbstractList
    public void removeRange(int fromIndex, int toIndex) {
        AbstractC1156d.INSTANCE.d(fromIndex, toIndex, size());
        int i10 = toIndex - fromIndex;
        if (i10 == 0) {
            return;
        }
        if (i10 == size()) {
            clear();
            return;
        }
        if (i10 == 1) {
            c(fromIndex);
            return;
        }
        u();
        if (fromIndex < size() - toIndex) {
            y(fromIndex, toIndex);
            int iT = t(this.head + i10);
            n(this.head, iT);
            this.head = iT;
        } else {
            z(fromIndex, toIndex);
            int iT2 = t(this.head + size());
            n(m(iT2 - i10), iT2);
        }
        this.size = size() - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        int iT;
        kotlin.jvm.internal.p.i(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iT2 = t(this.head + size());
            int i10 = this.head;
            if (i10 < iT2) {
                iT = i10;
                while (i10 < iT2) {
                    Object obj = this.elementData[i10];
                    if (elements.contains(obj)) {
                        this.elementData[iT] = obj;
                        iT++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                C1168p.v(this.elementData, null, iT, iT2);
            } else {
                int length = this.elementData.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i11] = obj2;
                        i11++;
                    } else {
                        z11 = true;
                    }
                    i10++;
                }
                iT = t(i11);
                for (int i12 = 0; i12 < iT2; i12++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[iT] = obj3;
                        iT = k(iT);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                u();
                this.size = m(iT - this.head);
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        AbstractC1156d.INSTANCE.b(index, size());
        int iT = t(this.head + index);
        Object[] objArr = this.elementData;
        E e10 = (E) objArr[iT];
        objArr[iT] = element;
        return e10;
    }

    public final int t(int index) {
        Object[] objArr = this.elementData;
        return index >= objArr.length ? index - objArr.length : index;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.p.i(array, "array");
        if (array.length < size()) {
            array = (T[]) C1166n.a(array, size());
        }
        T[] tArr = array;
        int iT = t(this.head + size());
        int i10 = this.head;
        if (i10 < iT) {
            C1168p.n(this.elementData, tArr, 0, i10, iT, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            C1168p.i(objArr, tArr, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            C1168p.i(objArr2, tArr, objArr2.length - this.head, 0, iT);
        }
        return (T[]) C1172u.g(size(), tArr);
    }

    public final void u() {
        ((AbstractList) this).modCount++;
    }

    public final E v() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E x() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public final void y(int fromIndex, int toIndex) {
        int iT = t(this.head + (fromIndex - 1));
        int iT2 = t(this.head + (toIndex - 1));
        while (fromIndex > 0) {
            int i10 = iT + 1;
            int iMin = Math.min(fromIndex, Math.min(i10, iT2 + 1));
            Object[] objArr = this.elementData;
            int i11 = iT2 - iMin;
            int i12 = iT - iMin;
            C1168p.i(objArr, objArr, i11 + 1, i12 + 1, i10);
            iT = m(i12);
            iT2 = m(i11);
            fromIndex -= iMin;
        }
    }

    public final void z(int fromIndex, int toIndex) {
        int iT = t(this.head + toIndex);
        int iT2 = t(this.head + fromIndex);
        int size = size();
        while (true) {
            size -= toIndex;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.elementData;
            toIndex = Math.min(size, Math.min(objArr.length - iT, objArr.length - iT2));
            Object[] objArr2 = this.elementData;
            int i10 = iT + toIndex;
            C1168p.i(objArr2, objArr2, iT2, iT, i10);
            iT = t(i10);
            iT2 = t(iT2 + toIndex);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        AbstractC1156d.INSTANCE.c(index, size());
        if (index == size()) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        u();
        j(size() + 1);
        int iT = t(this.head + index);
        if (index < ((size() + 1) >> 1)) {
            int i10 = i(iT);
            int i11 = i(this.head);
            int i12 = this.head;
            if (i10 >= i12) {
                Object[] objArr = this.elementData;
                objArr[i11] = objArr[i12];
                C1168p.i(objArr, objArr, i12, i12 + 1, i10 + 1);
            } else {
                Object[] objArr2 = this.elementData;
                C1168p.i(objArr2, objArr2, i12 - 1, i12, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                C1168p.i(objArr3, objArr3, 0, 1, i10 + 1);
            }
            this.elementData[i10] = element;
            this.head = i11;
        } else {
            int iT2 = t(this.head + size());
            if (iT < iT2) {
                Object[] objArr4 = this.elementData;
                C1168p.i(objArr4, objArr4, iT + 1, iT, iT2);
            } else {
                Object[] objArr5 = this.elementData;
                C1168p.i(objArr5, objArr5, 1, 0, iT2);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                C1168p.i(objArr6, objArr6, iT + 1, iT, objArr6.length - 1);
            }
            this.elementData[iT] = element;
        }
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        AbstractC1156d.INSTANCE.c(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        u();
        j(size() + elements.size());
        int iT = t(this.head + size());
        int iT2 = t(this.head + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i10 = this.head;
            int length = i10 - size;
            if (iT2 < i10) {
                Object[] objArr = this.elementData;
                C1168p.i(objArr, objArr, length, i10, objArr.length);
                if (size >= iT2) {
                    Object[] objArr2 = this.elementData;
                    C1168p.i(objArr2, objArr2, objArr2.length - size, 0, iT2);
                } else {
                    Object[] objArr3 = this.elementData;
                    C1168p.i(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    C1168p.i(objArr4, objArr4, 0, size, iT2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.elementData;
                C1168p.i(objArr5, objArr5, length, i10, iT2);
            } else {
                Object[] objArr6 = this.elementData;
                length += objArr6.length;
                int i11 = iT2 - i10;
                int length2 = objArr6.length - length;
                if (length2 >= i11) {
                    C1168p.i(objArr6, objArr6, length, i10, iT2);
                } else {
                    C1168p.i(objArr6, objArr6, length, i10, i10 + length2);
                    Object[] objArr7 = this.elementData;
                    C1168p.i(objArr7, objArr7, 0, this.head + length2, iT2);
                }
            }
            this.head = length;
            e(m(iT2 - size), elements);
        } else {
            int i12 = iT2 + size;
            if (iT2 < iT) {
                int i13 = size + iT;
                Object[] objArr8 = this.elementData;
                if (i13 <= objArr8.length) {
                    C1168p.i(objArr8, objArr8, i12, iT2, iT);
                } else if (i12 >= objArr8.length) {
                    C1168p.i(objArr8, objArr8, i12 - objArr8.length, iT2, iT);
                } else {
                    int length3 = iT - (i13 - objArr8.length);
                    C1168p.i(objArr8, objArr8, 0, length3, iT);
                    Object[] objArr9 = this.elementData;
                    C1168p.i(objArr9, objArr9, i12, iT2, length3);
                }
            } else {
                Object[] objArr10 = this.elementData;
                C1168p.i(objArr10, objArr10, size, 0, iT);
                Object[] objArr11 = this.elementData;
                if (i12 >= objArr11.length) {
                    C1168p.i(objArr11, objArr11, i12 - objArr11.length, iT2, objArr11.length);
                } else {
                    C1168p.i(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    C1168p.i(objArr12, objArr12, i12, iT2, objArr12.length - size);
                }
            }
            e(iT2, elements);
        }
        return true;
    }

    public C1165m() {
        this.elementData = f7696e;
    }

    public C1165m(Collection<? extends E> elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        this.elementData = array;
        this.size = array.length;
        if (array.length == 0) {
            this.elementData = f7696e;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
