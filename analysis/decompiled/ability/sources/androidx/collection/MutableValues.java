package androidx.collection;

import D7.v;
import T7.a;
import T7.b;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u0014J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u0017R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/collection/MutableValues;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Landroidx/collection/MutableScatterMap;", "parent", AppAgent.CONSTRUCT, "(Landroidx/collection/MutableScatterMap;)V", "", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "LC7/r;", "clear", "()V", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "element", "add", "(Ljava/lang/Object;)Z", "retainAll", "removeAll", "remove", "containsAll", "contains", "Landroidx/collection/MutableScatterMap;", "", "getSize", "()I", "size", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class MutableValues<K, V> implements Collection<V>, b {
    private final MutableScatterMap<K, V> parent;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010\b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"androidx/collection/MutableValues$iterator$1", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "LC7/r;", "remove", "()V", "", "", "iterator", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "current", "I", "getCurrent", "()I", "setCurrent", "(I)V", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: androidx.collection.MutableValues$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<V>, a {
        private int current = -1;
        private final Iterator<Integer> iterator;
        final /* synthetic */ MutableValues<K, V> this$0;

        public AnonymousClass1(MutableValues<K, V> mutableValues) {
            this.this$0 = mutableValues;
            this.iterator = U7.a.K(new MutableValues$iterator$1$iterator$1(mutableValues, null));
        }

        public final int getCurrent() {
            return this.current;
        }

        public final Iterator<Integer> getIterator() {
            return this.iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            this.current = this.iterator.next().intValue();
            return (V) ((MutableValues) this.this$0).parent.values[this.current];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current >= 0) {
                ((MutableValues) this.this$0).parent.removeValueAt(this.current);
                this.current = -1;
            }
        }

        public final void setCurrent(int i) {
            this.current = i;
        }
    }

    public MutableValues(MutableScatterMap<K, V> parent) {
        k.f(parent, "parent");
        this.parent = parent;
    }

    @Override // java.util.Collection
    public boolean add(V element) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends V> elements) {
        k.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        this.parent.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object element) {
        return this.parent.containsValue(element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        k.f(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!this.parent.containsValue(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.parent._size;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new AnonymousClass1(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    @Override // java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean remove(java.lang.Object r14) {
        /*
            r13 = this;
            androidx.collection.MutableScatterMap<K, V> r0 = r13.parent
            long[] r0 = r0.metadata
            int r1 = r0.length
            int r1 = r1 + (-2)
            r2 = 0
            if (r1 < 0) goto L51
            r3 = r2
        Lb:
            r4 = r0[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L4c
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L25:
            if (r8 >= r6) goto L4a
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L46
            int r9 = r3 << 3
            int r9 = r9 + r8
            androidx.collection.MutableScatterMap<K, V> r10 = r13.parent
            java.lang.Object[] r10 = r10.values
            r10 = r10[r9]
            boolean r10 = kotlin.jvm.internal.k.b(r10, r14)
            if (r10 == 0) goto L46
            androidx.collection.MutableScatterMap<K, V> r13 = r13.parent
            r13.removeValueAt(r9)
            r13 = 1
            return r13
        L46:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L25
        L4a:
            if (r6 != r7) goto L51
        L4c:
            if (r3 == r1) goto L51
            int r3 = r3 + 1
            goto Lb
        L51:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableValues.remove(java.lang.Object):boolean");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        k.f(elements, "elements");
        long[] jArr = this.parent.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i = 0;
        boolean z10 = false;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        if (v.u0(elements, this.parent.values[i11])) {
                            this.parent.removeValueAt(i11);
                            z10 = true;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return z10;
                }
            }
            if (i == length) {
                return z10;
            }
            i++;
        }
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        k.f(elements, "elements");
        long[] jArr = this.parent.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i = 0;
        boolean z10 = false;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        if (!v.u0(elements, this.parent.values[i11])) {
                            this.parent.removeValueAt(i11);
                            z10 = true;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return z10;
                }
            }
            if (i == length) {
                return z10;
            }
            i++;
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return j.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        k.f(array, "array");
        return (T[]) j.b(this, array);
    }
}
