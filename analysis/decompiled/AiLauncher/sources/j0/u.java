package j0;

import Z8.M;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import q9.InterfaceC5162a;
import q9.InterfaceC5165d;
import v9.C5685n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0010)\n\u0002\b\b\n\u0002\u0010+\n\u0002\b\u0018\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001f\u0010\u0019J\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b \u0010\u0010J\u001f\u0010 \u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b \u0010!J%\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010\"\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\"\u0010\u0014J\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\fJ\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010(J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010\u0010J\u001d\u0010*\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b*\u0010\u0014J\u0017\u0010+\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0017J\u001d\u0010,\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b,\u0010\u0014J \u0010-\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b-\u0010.J%\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u00100R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u00106R$\u0010<\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00058\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b5\u0010;¨\u0006="}, d2 = {"Lj0/u;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "parentList", "", "fromIndex", "toIndex", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", "LY8/t;", "e", "()V", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "index", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "add", "(ILjava/lang/Object;)V", "addAll", "(ILjava/util/Collection;)Z", "clear", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "remove", "removeAll", "c", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "(II)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", Const.INTENT_KEY_PKGNAME, "I", "offset", "structure", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "()I", ContentDisposition.Parameters.Size, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class u<T> implements List<T>, InterfaceC5165d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SnapshotStateList<T> parentList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int offset;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int structure;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int size;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u000e¨\u0006\u0014"}, d2 = {"j0/u$a", "", "", "hasPrevious", "()Z", "", "nextIndex", "()I", "previous", "()Ljava/lang/Object;", "previousIndex", "element", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)Ljava/lang/Void;", "hasNext", "next", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Void;", "c", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ListIterator<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f34462a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u<T> f34463b;

        public a(Ref$IntRef ref$IntRef, u<T> uVar) {
            this.f34462a = ref$IntRef;
            this.f34463b = uVar;
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void add(T element) {
            C4753k.j();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            C4753k.j();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void set(T element) {
            C4753k.j();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f34462a.f34818a < this.f34463b.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f34462a.f34818a >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            int i10 = this.f34462a.f34818a + 1;
            C4753k.m(i10, this.f34463b.size());
            this.f34462a.f34818a = i10;
            return this.f34463b.get(i10);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f34462a.f34818a + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int i10 = this.f34462a.f34818a;
            C4753k.m(i10, this.f34463b.size());
            this.f34462a.f34818a = i10 - 1;
            return this.f34463b.get(i10);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f34462a.f34818a;
        }
    }

    public u(SnapshotStateList<T> snapshotStateList, int i10, int i11) {
        this.parentList = snapshotStateList;
        this.offset = i10;
        this.structure = C4753k.h(snapshotStateList);
        this.size = i11 - i10;
    }

    private final void e() {
        if (C4753k.h(this.parentList) != this.structure) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        e();
        this.parentList.add(this.offset + size(), element);
        this.size = size() + 1;
        this.structure = C4753k.h(this.parentList);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends T> elements) {
        e();
        boolean zAddAll = this.parentList.addAll(index + this.offset, elements);
        if (zAddAll) {
            this.size = size() + elements.size();
            this.structure = C4753k.h(this.parentList);
        }
        return zAddAll;
    }

    /* renamed from: b, reason: from getter */
    public int getSize() {
        return this.size;
    }

    public T c(int index) {
        e();
        T tRemove = this.parentList.remove(this.offset + index);
        this.size = size() - 1;
        this.structure = C4753k.h(this.parentList);
        return tRemove;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() > 0) {
            e();
            SnapshotStateList<T> snapshotStateList = this.parentList;
            int i10 = this.offset;
            snapshotStateList.removeRange(i10, size() + i10);
            this.size = 0;
            this.structure = C4753k.h(this.parentList);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Collection<?> collection = elements;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public T get(int index) {
        e();
        C4753k.m(index, size());
        return this.parentList.get(this.offset + index);
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        e();
        int i10 = this.offset;
        Iterator<Integer> it = C5685n.s(i10, size() + i10).iterator();
        while (it.hasNext()) {
            int iNextInt = ((M) it).nextInt();
            if (kotlin.jvm.internal.p.d(element, this.parentList.get(iNextInt))) {
                return iNextInt - this.offset;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        e();
        int size = this.offset + size();
        do {
            size--;
            if (size < this.offset) {
                return -1;
            }
        } while (!kotlin.jvm.internal.p.d(element, this.parentList.get(size)));
        return size - this.offset;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i10) {
        return c(i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> elements) {
        Iterator<?> it = elements.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> elements) {
        e();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int i10 = this.offset;
        int iRetainAllInRange$runtime = snapshotStateList.retainAllInRange$runtime(elements, i10, size() + i10);
        if (iRetainAllInRange$runtime > 0) {
            this.structure = C4753k.h(this.parentList);
            this.size = size() - iRetainAllInRange$runtime;
        }
        return iRetainAllInRange$runtime > 0;
    }

    @Override // java.util.List
    public T set(int index, T element) {
        C4753k.m(index, size());
        e();
        T t10 = this.parentList.set(index + this.offset, element);
        this.structure = C4753k.h(this.parentList);
        return t10;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        if (!(fromIndex >= 0 && fromIndex <= toIndex && toIndex <= size())) {
            androidx.compose.runtime.f.a("fromIndex or toIndex are out of bounds");
        }
        e();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int i10 = this.offset;
        return new u(snapshotStateList, fromIndex + i10, toIndex + i10);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.h.a(this);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        e();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = index - 1;
        return new a(ref$IntRef, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) kotlin.jvm.internal.h.b(this, tArr);
    }

    @Override // java.util.List
    public void add(int index, T element) {
        e();
        this.parentList.add(this.offset + index, element);
        this.size = size() + 1;
        this.structure = C4753k.h(this.parentList);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        return addAll(size(), elements);
    }
}
