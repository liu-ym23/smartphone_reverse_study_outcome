package Y8;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0001\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\f\n\u0004\b'\u0010(\u0012\u0004\b)\u0010*R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0088\u0001\b\u0092\u0001\u00020\u0007¨\u0006-"}, d2 = {"LY8/n;", "", "LY8/m;", "", ContentDisposition.Parameters.Size, "c", "(I)[I", "", "storage", "e", "([I)[I", "index", "l", "([II)I", UxipConstants.f30680s, "LY8/t;", "t", "([III)V", "", "r", "([I)Ljava/util/Iterator;", "element", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "([II)Z", "elements", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "([ILjava/util/Collection;)Z", "p", "([I)Z", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "[I", "getStorage$annotations", "()V", "n", "([I)I", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class n implements Collection<m>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int[] storage;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"LY8/n$a;", "", "LY8/m;", "", "array", "<init>", "([I)V", "", "hasNext", "()Z", Const.INTENT_KEY_APIKEY, "()I", "[I", "", Const.INTENT_KEY_PKGNAME, "I", "index", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Iterator<m>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int[] array;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int index;

        public a(int[] array) {
            kotlin.jvm.internal.p.i(array, "array");
            this.array = array;
        }

        public int a() {
            int i10 = this.index;
            int[] iArr = this.array;
            if (i10 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i10 + 1;
            return m.b(iArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ m next() {
            return m.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ n(int[] iArr) {
        this.storage = iArr;
    }

    public static final /* synthetic */ n b(int[] iArr) {
        return new n(iArr);
    }

    public static int[] c(int i10) {
        return e(new int[i10]);
    }

    public static int[] e(int[] storage) {
        kotlin.jvm.internal.p.i(storage, "storage");
        return storage;
    }

    public static boolean i(int[] iArr, int i10) {
        return Z8.r.P(iArr, i10);
    }

    public static boolean j(int[] iArr, Collection<m> elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        Collection<m> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof m) || !Z8.r.P(iArr, ((m) obj).getData())) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(int[] iArr, Object obj) {
        return (obj instanceof n) && kotlin.jvm.internal.p.d(iArr, ((n) obj).getStorage());
    }

    public static final int l(int[] iArr, int i10) {
        return m.b(iArr[i10]);
    }

    public static int n(int[] iArr) {
        return iArr.length;
    }

    public static int o(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean p(int[] iArr) {
        return iArr.length == 0;
    }

    public static Iterator<m> r(int[] iArr) {
        return new a(iArr);
    }

    public static final void t(int[] iArr, int i10, int i11) {
        iArr[i10] = i11;
    }

    public static String u(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(m mVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends m> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof m) {
            return f(((m) obj).getData());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return j(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object other) {
        return k(this.storage, other);
    }

    public boolean f(int i10) {
        return i(this.storage, i10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return o(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return p(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<m> iterator() {
        return r(this.storage);
    }

    @Override // java.util.Collection
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public int size() {
        return n(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.h.a(this);
    }

    public String toString() {
        return u(this.storage);
    }

    /* renamed from: v, reason: from getter */
    public final /* synthetic */ int[] getStorage() {
        return this.storage;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.p.i(array, "array");
        return (T[]) kotlin.jvm.internal.h.b(this, array);
    }
}
