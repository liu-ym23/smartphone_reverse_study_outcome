package androidx.collection;

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
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001b\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0010H\u0096\u0002J\"\u0010\u0011\u001a\u00020\u000e2\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0013H\u0016J\u001d\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/collection/Entries;", "K", "V", "", "", "parent", "Landroidx/collection/ScatterMap;", "<init>", "(Landroidx/collection/ScatterMap;)V", "size", "", "getSize", "()I", "isEmpty", "", "iterator", "", "containsAll", SlcElement.KEY_ELEMENTS, "", "contains", "element", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Entries<K, V> implements Set<Map.Entry<? extends K, ? extends V>>, KMappedMarker {
    private final ScatterMap<K, V> parent;

    /* JADX INFO: renamed from: androidx.collection.Entries$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\n"}, d2 = {"<anonymous>", "", "K", "V", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.collection.Entries$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1418}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$2", "I$0", "I$1", "J$0", "I$2", "I$3"})
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<? extends K, ? extends V>>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Entries<K, V> this$0;

        public AnonymousClass1(Entries<K, V> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
            return invoke((SequenceScope) r100, r101);
        }

        public final Object invoke(SequenceScope<? super Map.Entry<? extends K, ? extends V>> r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005c -> B:14:0x006e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b0 -> B:24:0x00b4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00bb -> B:25:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ce -> B:32:0x00d1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            int r102 = this.I$3;
            int r103 = this.I$2;
            long r104 = this.J$0;
            int r105 = this.I$1;
            int r110 = this.I$0;
            long[] r111 = (long[]) this.L$2;
            Entries<K, V> r112 = (Entries) this.L$1;
            SequenceScope r113 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r210);
            AnonymousClass1 r106 = this;
            int r107 = 1;
        L24:
            SequenceScope r114 = r113;
            Entries<K, V> r115 = r112;
            long[] r116 = r111;
            AnonymousClass1 r117 = r106;
        L27:
            r104 = r104 >> 8;
            r102 = r102 + r107;
        L14:
            if (r102 >= r103) goto L29;
            if ((255 & r104) >= 128) goto L18;
            boolean r118 = true;
        L19:
            if (r118 == false) goto L26;
            int r119 = (r105 << 3) + r102;
            MapEntry r108 = new MapEntry(Entries.access$getParent$p(r115).keys[r119], Entries.access$getParent$p(r115).values[r119]);
            r117.L$0 = r114;
            r117.L$1 = r115;
            r117.L$2 = r116;
            r117.I$0 = r110;
            r117.I$1 = r105;
            r117.J$0 = r104;
            r117.I$2 = r103;
            r117.I$3 = r102;
            r107 = 1;
            r117.label = 1;
            if (r114.yield(r108, r117) != r100) goto L23;
            return r100;
        L23:
            r106 = r117;
            r111 = r116;
            r112 = r115;
            r113 = r114;
            goto L24
        L26:
            r107 = 1;
            goto L27
        L18:
            r118 = false;
            goto L19
        L29:
            if (r103 != 8) goto L35;
            int r109 = r110;
            AnonymousClass1 r120 = r117;
            long[] r121 = r116;
            Entries<K, V> r122 = r115;
            SequenceScope r123 = r114;
        L32:
            if (r105 == r109) goto L35;
            r105 = r105 + 1;
        L11:
            long r124 = r121[r105];
            if (((((~r124) << 7) & r124) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L32;
            r114 = r123;
            r102 = 0;
            r116 = r121;
            r117 = r120;
            r103 = 8 - ((~(r105 - r109)) >>> 31);
            r115 = r122;
            r110 = r109;
            r104 = r124;
        L35:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            r123 = (SequenceScope) this.L$0;
            ScatterMap r125 = Entries.access$getParent$p(this.this$0);
            r122 = this.this$0;
            r121 = r125.metadata;
            r109 = r121.length - 2;
            if (r109 < 0) goto L35;
            r120 = this;
            r105 = 0;
            goto L11
        }
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Map.Entry<? extends K, ? extends V> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Map.Entry<? extends K, ? extends V>> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    public int getSize() {
        return this.parent._size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return SequencesKt.iterator(new AnonymousClass1(this, null));
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public Entries(ScatterMap<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.parent = r100;
    }

    public static final /* synthetic */ ScatterMap access$getParent$p(Entries r100) {
        return r100.parent;
    }

    public boolean contains(Map.Entry<? extends K, ? extends V> r100) {
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

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return contains((Map.Entry) r100);
    }
}
