package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0016J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0002J\u0013\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Landroidx/collection/SetWrapper;", ExifInterface.LONGITUDE_EAST, "", "parent", "Landroidx/collection/ScatterSet;", "<init>", "(Landroidx/collection/ScatterSet;)V", "size", "", "getSize", "()I", "containsAll", "", SlcElement.KEY_ELEMENTS, "", "contains", "element", "(Ljava/lang/Object;)Z", "isEmpty", "iterator", "", "equals", "other", "", "hashCode", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
class SetWrapper<E> implements Set<E>, KMappedMarker {
    private final ScatterSet<E> parent;

    /* JADX INFO: renamed from: androidx.collection.SetWrapper$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.collection.SetWrapper$iterator$1", f = "ScatterSet.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {1153}, m = "invokeSuspend", n = {"$this$iterator", "elements$iv", "m$iv$iv", "lastIndex$iv$iv", "i$iv$iv", "slot$iv$iv", "bitCount$iv$iv", "j$iv$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "J$0", "I$2", "I$3"})
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ SetWrapper<E> this$0;

        public AnonymousClass1(SetWrapper<E> r100, Continuation<? super AnonymousClass1> r101) {
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

        public final Object invoke(SequenceScope<? super E> r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005c -> B:28:0x00b2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005e -> B:14:0x0070). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009e -> B:24:0x00a3). Please report as a decompilation issue!!! */
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
            Object[] r112 = (Object[]) this.L$1;
            SequenceScope r113 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r210);
            SequenceScope r114 = r113;
            Object[] r115 = r112;
            AnonymousClass1 r116 = this;
        L24:
            AnonymousClass1 r211 = r116;
            long[] r117 = r111;
            AnonymousClass1 r118 = r211;
        L25:
            r104 = r104 >> 8;
            r102 = r102 + 1;
        L14:
            if (r102 < r103) goto L16;
            if (r103 != 8) goto L31;
            int r106 = r110;
            AnonymousClass1 r119 = r118;
            long[] r107 = r117;
            Object[] r108 = r115;
            SequenceScope r109 = r114;
        L28:
            if (r105 == r106) goto L31;
            r105 = r105 + 1;
        L11:
            long r120 = r107[r105];
            if (((((~r120) << 7) & r120) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
            r114 = r109;
            r102 = 0;
            r117 = r107;
            r118 = r119;
            r103 = 8 - ((~(r105 - r106)) >>> 31);
            r115 = r108;
            r110 = r106;
            r104 = r120;
        L31:
            return Unit.INSTANCE;
        L16:
            if ((255 & r104) >= 128) goto L32;
            if (1 == 0) goto L25;
            Object r121 = r115[(r105 << 3) + r102];
            r118.L$0 = r114;
            r118.L$1 = r115;
            r118.L$2 = r117;
            r118.I$0 = r110;
            r118.I$1 = r105;
            r118.J$0 = r104;
            r118.I$2 = r103;
            r118.I$3 = r102;
            r118.label = 1;
            if (r114.yield(r121, r118) != r100) goto L23;
            return r100;
        L23:
            long[] r212 = r117;
            r116 = r118;
            r111 = r212;
            goto L24
        L32:
            if (0 == 0) goto L25;
            goto L25
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            r109 = (SequenceScope) this.L$0;
            ScatterSet r122 = SetWrapper.access$getParent$p(this.this$0);
            r108 = r122.elements;
            r107 = r122.metadata;
            r106 = r107.length - 2;
            if (r106 < 0) goto L31;
            r119 = this;
            r105 = 0;
            goto L11
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> r100) {
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
    public int hashCode() {
        return this.parent.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return SequencesKt.iterator(new AnonymousClass1(this, null));
    }

    public String toString() {
        return this.parent.toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public SetWrapper(ScatterSet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.parent = r100;
    }

    public static final /* synthetic */ ScatterSet access$getParent$p(SetWrapper r100) {
        return r100.parent;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r100) {
        return this.parent.contains(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Object r102 = r101.next();
        if (this.parent.contains((E) r102) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.parent, ((SetWrapper) r100).parent);
    }
}
