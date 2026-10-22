package androidx.collection;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001b\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0015H\u0016J\u001d\u0010\u0016\u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\"\u0010\u0018\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0015H\u0016J\u001c\u0010\u0019\u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u001a\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0015H\u0016J\"\u0010\u001b\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0015H\u0016J\u001c\u0010\u001c\u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/collection/MutableEntries;", "K", "V", "", "", "parent", "Landroidx/collection/MutableScatterMap;", "<init>", "(Landroidx/collection/MutableScatterMap;)V", "size", "", "getSize", "()I", "isEmpty", "", "iterator", "", "clear", "", "containsAll", SlcElement.KEY_ELEMENTS, "", "contains", "element", "addAll", "add", "retainAll", "removeAll", "remove", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MutableEntries<K, V> implements Set<Map.Entry<K, V>>, KMutableSet {
    private final MutableScatterMap<K, V> parent;

    /* JADX INFO: renamed from: androidx.collection.MutableEntries$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R,\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"androidx/collection/MutableEntries$iterator$1", "", "", "iterator", "", "getIterator", "()Ljava/util/Iterator;", "setIterator", "(Ljava/util/Iterator;)V", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "remove", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        private int current;
        private Iterator<? extends Map.Entry<K, V>> iterator;
        final /* synthetic */ MutableEntries<K, V> this$0;

        /* JADX INFO: renamed from: androidx.collection.MutableEntries$iterator$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\n"}, d2 = {"<anonymous>", "", "K", "V", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.collection.MutableEntries$iterator$1$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1542}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
        public static final class C00981 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<K, V>>, Continuation<? super Unit>, Object> {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            long J$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ MutableEntries<K, V> this$0;
            final /* synthetic */ AnonymousClass1 this$1;

            public C00981(MutableEntries<K, V> r100, AnonymousClass1 r101, Continuation<? super C00981> r102) {
                this.this$0 = r100;
                this.this$1 = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                C00981 r102 = new C00981(this.this$0, this.this$1, r101);
                r102.L$0 = r100;
                return r102;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
                return invoke((SequenceScope) r100, r101);
            }

            public final Object invoke(SequenceScope<? super Map.Entry<K, V>> r100, Continuation<? super Unit> r101) {
                return ((C00981) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0065 -> B:14:0x007f). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ca -> B:24:0x00ce). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00d5 -> B:26:0x00d6). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00ea -> B:31:0x00eb). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r210) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                int r102 = 8;
                if (r101 == 0) goto L8;
                if (r101 != 1) goto L7;
                int r103 = this.I$3;
                int r104 = this.I$2;
                long r105 = this.J$0;
                int r106 = this.I$1;
                int r110 = this.I$0;
                long[] r111 = (long[]) this.L$3;
                MutableEntries<K, V> r112 = (MutableEntries) this.L$2;
                AnonymousClass1 r113 = (AnonymousClass1) this.L$1;
                SequenceScope r114 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(r210);
                C00981 r107 = this;
                int r108 = 1;
            L24:
                SequenceScope r115 = r114;
                AnonymousClass1 r116 = r113;
                MutableEntries<K, V> r117 = r112;
                C00981 r118 = r107;
                r102 = 8;
            L26:
                r105 = r105 >> r102;
                r103 = r103 + r108;
            L14:
                if (r103 >= r104) goto L28;
                if ((r105 & 255) >= 128) goto L18;
                boolean r119 = true;
            L19:
                if (r119 == false) goto L25;
                r116.setCurrent((r106 << 3) + r103);
                MutableMapEntry r109 = new MutableMapEntry(MutableEntries.access$getParent$p(r117).keys, MutableEntries.access$getParent$p(r117).values, r116.getCurrent());
                r118.L$0 = r115;
                r118.L$1 = r116;
                r118.L$2 = r117;
                r118.L$3 = r111;
                r118.I$0 = r110;
                r118.I$1 = r106;
                r118.J$0 = r105;
                r118.I$2 = r104;
                r118.I$3 = r103;
                r108 = 1;
                r118.label = 1;
                if (r115.yield(r109, r118) != r100) goto L23;
                return r100;
            L23:
                r107 = r118;
                r112 = r117;
                r113 = r116;
                r114 = r115;
                goto L24
            L25:
                r108 = 1;
                goto L26
            L18:
                r119 = false;
                goto L19
            L28:
                if (r104 != r102) goto L34;
                long[] r120 = r111;
                C00981 r121 = r118;
                MutableEntries<K, V> r122 = r117;
                AnonymousClass1 r123 = r116;
                SequenceScope r124 = r115;
                int r211 = r110;
                int r125 = r106;
                int r126 = r211;
            L31:
                if (r125 == r126) goto L34;
                r125 = r125 + 1;
            L11:
                long r127 = r120[r125];
                if (((((~r127) << 7) & r127) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L31;
                r115 = r124;
                r103 = 0;
                C00981 r212 = r121;
                r111 = r120;
                r104 = 8 - ((~(r125 - r126)) >>> 31);
                r116 = r123;
                r117 = r122;
                r118 = r212;
                r105 = r127;
                int r213 = r125;
                r110 = r126;
                r106 = r213;
            L34:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r210);
                r124 = (SequenceScope) this.L$0;
                MutableScatterMap r128 = MutableEntries.access$getParent$p(this.this$0);
                r123 = this.this$1;
                r122 = this.this$0;
                r120 = r128.metadata;
                r126 = r120.length - 2;
                if (r126 < 0) goto L34;
                r121 = this;
                r125 = 0;
                goto L11
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current == (-1)) goto L6;
            MutableEntries.access$getParent$p(this.this$0).removeValueAt(this.current);
            this.current = -1;
            return;
        }

        public final int getCurrent() {
            return this.current;
        }

        public final Iterator<Map.Entry<K, V>> getIterator() {
            return this.iterator;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public AnonymousClass1(MutableEntries<K, V> r100) {
            this.this$0 = r100;
            this.current = -1;
            this.iterator = SequencesKt.iterator(new C00981(r100, this, null));
        }

        public final void setCurrent(int r100) {
            this.current = r100;
        }

        public final void setIterator(Iterator<? extends Map.Entry<K, V>> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.iterator = r100;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.parent.clear();
    }

    public int getSize() {
        return this.parent._size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public MutableEntries(MutableScatterMap<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.parent = r100;
    }

    public static final /* synthetic */ MutableScatterMap access$getParent$p(MutableEntries r100) {
        return r100.parent;
    }

    public boolean add(Map.Entry<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Map.Entry<K, V>> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        throw new UnsupportedOperationException();
    }

    public boolean contains(Map.Entry<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        return Intrinsics.areEqual(this.parent.get(r100.getKey()), r100.getValue());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Collection<?> r101 = r100;
        if (r101.isEmpty() == true) goto L15;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (Intrinsics.areEqual(this.parent.get((K) r103.getKey()), r103.getValue()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    public boolean remove(Map.Entry<K, V> r210) {
        Intrinsics.checkNotNullParameter(r210, "element");
        MutableScatterMap<K, V> r100 = this.parent;
        K r101 = r210.getKey();
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = r102 * ScatterMapKt.MurmurHashC1;
        int r104 = r103 ^ (r103 << 16);
        int r105 = r104 & 127;
        int r106 = r100._capacity;
        int r107 = (r104 >>> 7) & r106;
        int r108 = 0;
    L7:
        long[] r109 = r100.metadata;
        int r110 = r107 >> 3;
        int r111 = (r107 & 7) << 3;
        long r112 = ((r109[r110 + 1] << (64 - r111)) & ((-r111) >> 63)) | (r109[r110] >>> r111);
        long r113 = (((long) r105) * ScatterMapKt.BitmaskLsb) ^ r112;
        long r114 = ((~r113) & (r113 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r114 == 0) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L18;
        int r116 = ((Long.numberOfTrailingZeros(r114) >> 3) + r107) & r106;
        if (Intrinsics.areEqual(r100.keys[r116], r101) == true) goto L20;
        r114 = r114 & (r114 - 1);
    L20:
        if (r116 >= 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.parent.values[r116], r210.getValue()) == false) goto L31;
        this.parent.removeValueAt(r116);
        return true;
    L31:
        return false;
    L18:
        if (((r112 & ((~r112) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r108 = r108 + 8;
        r107 = (r107 + r108) & r106;
        goto L7
    L19:
        r116 = -1;
        goto L20
    L11:
        r115 = false;
        goto L12
    L5:
        r102 = 0;
        goto L6
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        long[] r100 = this.parent.metadata;
        int r101 = r100.length - 2;
        if (r101 < 0) goto L27;
        int r102 = 0;
        boolean r103 = false;
    L5:
        long r104 = r100[r102];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L24;
        int r105 = 8 - ((~(r102 - r101)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L23;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L22;
        int r113 = (r102 << 3) + r111;
        Iterator<?> r114 = r110.iterator();
    L16:
        if (r114.hasNext() == false) goto L22;
        Map.Entry r115 = (Map.Entry) r114.next();
        if (Intrinsics.areEqual(r115.getKey(), this.parent.keys[r113]) == false) goto L16;
        if (Intrinsics.areEqual(r115.getValue(), this.parent.values[r113]) == false) goto L16;
        this.parent.removeValueAt(r113);
        r103 = true;
    L22:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L23:
        if (r105 == 8) goto L24;
        return r103;
    L24:
        if (r102 == r101) goto L26;
        r102 = r102 + 1;
        goto L5
    L26:
        boolean r106 = r103;
    L29:
        return r106;
    L27:
        r106 = false;
        goto L29
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        long[] r100 = this.parent.metadata;
        int r101 = r100.length - 2;
        if (r101 < 0) goto L30;
        int r102 = 0;
        boolean r103 = false;
    L5:
        long r104 = r100[r102];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L27;
        int r105 = 8 - ((~(r102 - r101)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L26;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L25;
        int r113 = (r102 << 3) + r111;
        Iterator<?> r114 = r110.iterator();
    L16:
        if (r114.hasNext() == false) goto L22;
        Map.Entry r115 = (Map.Entry) r114.next();
        if (Intrinsics.areEqual(r115.getKey(), this.parent.keys[r113]) == false) goto L16;
        if (Intrinsics.areEqual(r115.getValue(), this.parent.values[r113]) == false) goto L16;
        boolean r106 = true;
    L23:
        if (r106 == true) goto L25;
        this.parent.removeValueAt(r113);
        r103 = true;
        goto L25
    L22:
        r106 = false;
    L25:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L26:
        if (r105 == 8) goto L27;
        return r103;
    L27:
        if (r102 == r101) goto L29;
        r102 = r102 + 1;
        goto L5
    L29:
        boolean r107 = r103;
    L32:
        return r107;
    L30:
        r107 = false;
        goto L32
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r100) {
        return add((Map.Entry) r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object r100) {
        if (TypeIntrinsics.isMutableMapEntry(r100) == true) goto L7;
        return false;
    L7:
        return contains((Map.Entry) r100);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object r100) {
        if (TypeIntrinsics.isMutableMapEntry(r100) == true) goto L7;
        return false;
    L7:
        return remove((Map.Entry) r100);
    }
}
