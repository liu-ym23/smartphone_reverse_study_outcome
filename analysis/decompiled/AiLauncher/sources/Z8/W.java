package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\n\u0010\rJ\u0018\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u001aJ\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b\"\u0010\rR\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R$\u0010,\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b%\u0010+¨\u0006-"}, d2 = {"LZ8/W;", ExifInterface.GPS_DIRECTION_TRUE, "LZ8/d;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "", "buffer", "", "filledSize", "<init>", "([Ljava/lang/Object;I)V", "capacity", "(I)V", "index", "get", "(I)Ljava/lang/Object;", "", "m", "()Z", "", "iterator", "()Ljava/util/Iterator;", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "maxCapacity", "l", "(I)LZ8/W;", "element", "LY8/t;", "k", "(Ljava/lang/Object;)V", "n", Const.INTENT_KEY_PKGNAME, "[Ljava/lang/Object;", "c", "I", Const.INTENT_KEY_UMID, "startIndex", UxipConstants.f30680s, "e", "()I", ContentDisposition.Parameters.Size, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class W<T> extends AbstractC1156d<T> implements RandomAccess {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object[] buffer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int startIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int size;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Z8/W$a", "LZ8/c;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "", "c", "I", "count", Const.INTENT_KEY_UMID, "index", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1155c<T> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int count;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public int index;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ W<T> f7679e;

        public a(W<T> w10) {
            this.f7679e = w10;
            this.count = w10.size();
            this.index = w10.startIndex;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // Z8.AbstractC1155c
        public void a() {
            if (this.count == 0) {
                b();
                return;
            }
            c(this.f7679e.buffer[this.index]);
            this.index = (this.index + 1) % this.f7679e.capacity;
            this.count--;
        }
    }

    public W(Object[] buffer, int i10) {
        kotlin.jvm.internal.p.i(buffer, "buffer");
        this.buffer = buffer;
        if (i10 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i10).toString());
        }
        if (i10 <= buffer.length) {
            this.capacity = buffer.length;
            this.size = i10;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i10 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    @Override // Z8.AbstractC1154b
    /* renamed from: c, reason: from getter */
    public int getSize() {
        return this.size;
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public T get(int index) {
        AbstractC1156d.INSTANCE.b(index, size());
        return (T) this.buffer[(this.startIndex + index) % this.capacity];
    }

    @Override // Z8.AbstractC1156d, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a(this);
    }

    public final void k(T element) {
        if (m()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = element;
        this.size = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final W<T> l(int maxCapacity) {
        Object[] array;
        int i10 = this.capacity;
        int iJ = C5685n.j(i10 + (i10 >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, iJ);
            kotlin.jvm.internal.p.h(array, "copyOf(...)");
        } else {
            array = toArray(new Object[iJ]);
        }
        return new W<>(array, size());
    }

    public final boolean m() {
        return size() == this.capacity;
    }

    public final void n(int n10) {
        if (n10 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + n10).toString());
        }
        if (n10 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + n10 + ", size = " + size()).toString());
        }
        if (n10 > 0) {
            int i10 = this.startIndex;
            int i11 = (i10 + n10) % this.capacity;
            if (i10 > i11) {
                C1168p.v(this.buffer, null, i10, this.capacity);
                C1168p.v(this.buffer, null, 0, i11);
            } else {
                C1168p.v(this.buffer, null, i10, i11);
            }
            this.startIndex = i11;
            this.size = size() - n10;
        }
    }

    @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.p.i(array, "array");
        int length = array.length;
        Object[] objArr = array;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.p.h(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = this.startIndex; i11 < size && i12 < this.capacity; i12++) {
            objArr[i11] = this.buffer[i12];
            i11++;
        }
        while (i11 < size) {
            objArr[i11] = this.buffer[i10];
            i11++;
            i10++;
        }
        return (T[]) C1172u.g(size, objArr);
    }

    public W(int i10) {
        this(new Object[i10], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
