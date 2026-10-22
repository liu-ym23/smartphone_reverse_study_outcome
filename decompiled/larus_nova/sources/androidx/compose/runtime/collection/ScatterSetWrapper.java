package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
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
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0002J\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/collection/ScatterSetWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "", "set", "Landroidx/collection/ScatterSet;", "<init>", "(Landroidx/collection/ScatterSet;)V", "getSet$runtime", "()Landroidx/collection/ScatterSet;", "size", "", "getSize", "()I", "isEmpty", "", "iterator", "", "containsAll", SlcElement.KEY_ELEMENTS, "", "contains", "element", "(Ljava/lang/Object;)Z", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScatterSetWrapper<T> implements Set<T>, KMappedMarker {
    public static final int $stable = 8;
    private final ScatterSet<T> set;

    /* JADX INFO: renamed from: androidx.compose.runtime.collection.ScatterSetWrapper$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.collection.ScatterSetWrapper$iterator$1", f = "ScatterSetWrapper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {31}, m = "invokeSuspend", n = {"$this$iterator", "elements$iv", "m$iv$iv", "lastIndex$iv$iv", "i$iv$iv", "slot$iv$iv", "bitCount$iv$iv", "j$iv$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "J$0", "I$2", "I$3"})
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ScatterSetWrapper<T> this$0;

        public AnonymousClass1(ScatterSetWrapper<T> r100, Continuation<? super AnonymousClass1> r101) {
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

        public final Object invoke(SequenceScope<? super T> r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object, kotlin.sequences.SequenceScope] */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r14v3 */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v6 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v7 */
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
            ?? r114 = r113;
            Object[] r115 = r112;
            AnonymousClass1 r116 = this;
        L24:
            AnonymousClass1 r211 = r116;
            long[] r117 = r111;
            AnonymousClass1 r118 = r211;
        L25:
            r104 = r104 >> 8;
            r102 = r102 + 1;
            r114 = r114;
        L14:
            if (r102 < r103) goto L16;
            if (r103 != 8) goto L31;
            int r106 = r110;
            AnonymousClass1 r119 = r118;
            long[] r107 = r117;
            Object[] r108 = r115;
            ?? r109 = r114;
        L28:
            if (r105 == r106) goto L31;
            r105 = r105 + 1;
            ?? r120 = r109;
        L11:
            long r121 = r107[r105];
            r109 = r120;
            if (((((~r121) << 7) & r121) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
            r114 = r120;
            r102 = 0;
            r117 = r107;
            r118 = r119;
            r103 = 8 - ((~(r105 - r106)) >>> 31);
            r115 = r108;
            r110 = r106;
            r104 = r121;
        L31:
            return Unit.INSTANCE;
        L16:
            if ((255 & r104) >= 128) goto L32;
            if (1 == 0) goto L25;
            Object r122 = r115[(r105 << 3) + r102];
            r118.L$0 = r114;
            r118.L$1 = r115;
            r118.L$2 = r117;
            r118.I$0 = r110;
            r118.I$1 = r105;
            r118.J$0 = r104;
            r118.I$2 = r103;
            r118.I$3 = r102;
            r118.label = 1;
            if (r114.yield(r122, r118) != r100) goto L23;
            return r100;
        L23:
            long[] r212 = r117;
            r116 = r118;
            r111 = r212;
            r114 = r114;
            goto L24
        L32:
            if (0 == 0) goto L25;
            goto L25
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            SequenceScope r123 = (SequenceScope) this.L$0;
            ScatterSet<T> r124 = this.this$0.getSet$runtime();
            r108 = r124.elements;
            r107 = r124.metadata;
            r106 = r107.length - 2;
            if (r106 < 0) goto L31;
            r119 = this;
            r105 = 0;
            r120 = r123;
            goto L11
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(T r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> r100) {
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
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    public int getSize() {
        return this.set.getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return SequencesKt.iterator(new AnonymousClass1(this, null));
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final ScatterSet<T> getSet$runtime() {
        return this.set;
    }

    public ScatterSetWrapper(ScatterSet<T> r100) {
        this.set = r100;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r100) {
        return this.set.contains(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        Collection<?> r101 = r100;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        T r103 = r102.next();
        if (this.set.contains(r103) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return true;
    }
}
