package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.bytedance.apm.constant.PerfConsts;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ConcurrentWeakMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0003()*B\u000f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J\u001f\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010$J!\u0010%\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u00002\b\u0010#\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0002\u0010$J\u0017\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u0006\u0010'\u001a\u00020\u001aR\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u001f\u0010\n\u001a\u0018\u0012\u0014\u0012\u00120\fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u000bX\u0082\u0004R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/AbstractMutableMap;", "weakRefQueue", "", "(Z)V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "core", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", PerfConsts.PERF_DISK_FILE_SIZE, "", "getSize", "()I", "Ljava/lang/ref/ReferenceQueue;", "cleanWeakRef", "", "w", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "clear", "decrementSize", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putSynchronized", "remove", "runWeakRefQueueCleaningLoopUntilInterrupted", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    private static final AtomicIntegerFieldUpdater _size$FU = null;
    private static final AtomicReferenceFieldUpdater core$FU = null;

    @Volatile
    private volatile int _size;

    @Volatile
    private volatile Object core;
    private final ReferenceQueue<K> weakRefQueue;

    /* JADX INFO: compiled from: ConcurrentWeakMap.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0015\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0002\u0010\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00170\u0019J1\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u00002\b\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fJ\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006X\u0082\u0004R\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¨\u0006\""}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "allocated", "", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "keys", "Lkotlinx/atomicfu/AtomicArray;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "load", "Lkotlinx/atomicfu/AtomicInt;", "shift", "threshold", "values", "cleanWeakRef", "", "weakRef", "getImpl", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "index", "hash", "keyValueIterator", "", ExifInterface.LONGITUDE_EAST, "factory", "Lkotlin/Function2;", "putImpl", "value", "weakKey0", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "rehash", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "removeCleanedAt", "KeyValueIterator", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class Core {
        private static final AtomicIntegerFieldUpdater load$FU = null;
        private final int allocated;
        private final AtomicReferenceArray keys;

        @Volatile
        private volatile int load;
        private final int shift;
        final /* synthetic */ ConcurrentWeakMap<K, V> this$0;
        private final int threshold;
        private final AtomicReferenceArray values;

        /* JADX INFO: compiled from: ConcurrentWeakMap.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00028\u0001X\u0082.¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", ExifInterface.LONGITUDE_EAST, "", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "index", "", "key", "Ljava/lang/Object;", "value", "findNext", "", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {
            private final Function2<K, V, E> factory;
            private int index;
            private K key;
            final /* synthetic */ ConcurrentWeakMap<K, V>.Core this$0;
            private V value;

            /* JADX WARN: Multi-variable type inference failed */
            public KeyValueIterator(Core r1, Function2<? super K, ? super V, ? extends E> r2) {
                this.this$0 = r1;
                this.factory = r2;
                this.index = -1;
                findNext();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ void remove() {
                remove();
            }

            private final void findNext() {
            L2:
                int r0 = this.index + 1;
                this.index = r0;
                if (r0 >= Core.access$getAllocated$p(this.this$0)) goto L23;
                HashedWeakRef r1 = (HashedWeakRef) Core.access$getKeys$p(this.this$0).get(this.index);
                if (r1 == null) goto L2;
                K r2 = (K) r1.get();
                if (r2 == null) goto L2;
                this.key = r2;
                Object r3 = (V) Core.access$getValues$p(this.this$0).get(this.index);
                if ((r3 instanceof Marked) == false) goto L12;
                r3 = (V) ((Marked) r3).ref;
            L12:
                if (r3 == null) goto L2;
                this.value = (V) r3;
                return;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index >= Core.access$getAllocated$p(this.this$0)) goto L5;
                return true;
            L5:
                return false;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.Iterator
            public E next() {
                if (this.index >= Core.access$getAllocated$p(this.this$0)) goto L13;
                Function2<K, V, E> r0 = this.factory;
                K r1 = this.key;
                if (r1 == true) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("key");
                r1 = (K) Unit.INSTANCE;
            L7:
                V r2 = this.value;
                if (r2 == true) goto L10;
                Intrinsics.throwUninitializedPropertyAccessException("value");
                r2 = (V) Unit.INSTANCE;
            L10:
                E r3 = (E) r0.invoke(r1, r2);
                findNext();
                return r3;
            L13:
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public Void remove() {
                ConcurrentWeakMapKt.access$noImpl();
                throw new KotlinNothingValueException();
            }
        }

        static {
            load$FU = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");
        }

        private final void update$atomicfu(AtomicIntegerFieldUpdater r2, Function1<? super Integer, Integer> r3, Object r4) {
        L2:
            int r1 = r2.get(r4);
            if (r2.compareAndSet(r4, r1, r3.invoke(Integer.valueOf(r1)).intValue()) == false) goto L2;
        }

        public static final /* synthetic */ int access$getAllocated$p(Core r0) {
            return r0.allocated;
        }

        public static final /* synthetic */ AtomicReferenceArray access$getKeys$p(Core r0) {
            return r0.keys;
        }

        public static final /* synthetic */ AtomicReferenceArray access$getValues$p(Core r0) {
            return r0.values;
        }

        public Core(ConcurrentWeakMap r1, int r2) {
            this.this$0 = r1;
            this.allocated = r2;
            this.shift = Integer.numberOfLeadingZeros(r2) + 1;
            this.threshold = (r2 * 2) / 3;
            this.keys = new AtomicReferenceArray(r2);
            this.values = new AtomicReferenceArray(r2);
        }

        private final int index(int r2) {
            return (r2 * (-1640531527)) >>> this.shift;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final V getImpl(K r4) {
            int r0 = index(r4.hashCode());
        L3:
            HashedWeakRef r1 = (HashedWeakRef) this.keys.get(r0);
            if (r1 == null) goto L5;
            Object r2 = r1.get();
            if (Intrinsics.areEqual(r4, r2) == true) goto L9;
            if (r2 != null) goto L15;
            removeCleanedAt(r0);
        L15:
            if (r0 != 0) goto L17;
            r0 = this.allocated;
        L17:
            r0 = r0 - 1;
            goto L3
        L9:
            V r3 = (V) this.values.get(r0);
            if ((r3 instanceof Marked) == true) goto L12;
            return r3;
        L12:
            return (V) ((Marked) r3).ref;
        L5:
            return null;
        }

        private final void removeCleanedAt(int r4) {
        L2:
            Object r0 = this.values.get(r4);
            if (r0 == null) goto L4;
            if ((r0 instanceof Marked) == true) goto L7;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.values, r4, r0, null) == false) goto L2;
            ConcurrentWeakMap.access$decrementSize(this.this$0);
            return;
        L7:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object putImpl$default(Core r0, Object r1, Object r2, HashedWeakRef r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            return r0.putImpl(r1, r2, r3);
        }

        public final Object putImpl(K r6, V r7, HashedWeakRef<K> r8) {
            int r0 = index(r6.hashCode());
            boolean r1 = false;
        L3:
            HashedWeakRef r2 = (HashedWeakRef) this.keys.get(r0);
            if (r2 == null) goto L6;
            Object r3 = r2.get();
            if (Intrinsics.areEqual(r6, r3) == true) goto L24;
            if (r3 != null) goto L35;
            removeCleanedAt(r0);
        L35:
            if (r0 != 0) goto L37;
            r0 = this.allocated;
        L37:
            r0 = r0 - 1;
            goto L3
        L24:
            if (r1 == false) goto L26;
            load$FU.decrementAndGet(this);
        L26:
            Object r9 = this.values.get(r0);
            if ((r9 instanceof Marked) == true) goto L29;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.values, r0, r9, r7) == false) goto L26;
            return r9;
        L29:
            return ConcurrentWeakMapKt.access$getREHASH$p();
        L6:
            if (r7 == null) goto L7;
            if (r1 == true) goto L17;
            AtomicIntegerFieldUpdater r4 = load$FU;
        L10:
            int r5 = r4.get(this);
            if (r5 >= this.threshold) goto L13;
            if (r4.compareAndSet(this, r5, r5 + 1) == false) goto L10;
            r1 = true;
            goto L17
        L13:
            return ConcurrentWeakMapKt.access$getREHASH$p();
        L17:
            if (r8 != null) goto L20;
            r8 = new HashedWeakRef(r6, ConcurrentWeakMap.access$getWeakRefQueue$p(this.this$0));
        L20:
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.keys, r0, null, r8) == true) goto L26;
        L7:
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.Core rehash() {
        L2:
            int r0 = Integer.highestOneBit(RangesKt.coerceAtLeast(this.this$0.size(), 4)) * 4;
            ConcurrentWeakMap<K, V>.Core r1 = (ConcurrentWeakMap<K, V>.Core) new Core(this.this$0, r0);
            int r2 = this.allocated;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L21;
            HashedWeakRef r4 = (HashedWeakRef) this.keys.get(r3);
            if (r4 == null) goto L7;
            Object r5 = r4.get();
        L8:
            if (r4 == null) goto L11;
            if (r5 != null) goto L11;
            removeCleanedAt(r3);
        L11:
            Object r6 = this.values.get(r3);
            if ((r6 instanceof Marked) == true) goto L13;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.values, r3, r6, ConcurrentWeakMapKt.access$mark(r6)) == false) goto L11;
        L16:
            if (r5 == null) goto L20;
            if (r6 == null) goto L20;
            if (r1.putImpl(r5, r6, r4) == ConcurrentWeakMapKt.access$getREHASH$p()) goto L2;
        L20:
            r3 = r3 + 1;
            goto L3
        L13:
            r6 = ((Marked) r6).ref;
            goto L16
        L7:
            r5 = null;
            goto L8
        L21:
            return r1;
        }

        public final void cleanWeakRef(HashedWeakRef<?> r3) {
            int r0 = index(r3.hash);
        L3:
            HashedWeakRef<?> r1 = (HashedWeakRef) this.keys.get(r0);
            if (r1 == null) goto L5;
            if (r1 == r3) goto L7;
            if (r0 != 0) goto L11;
            r0 = this.allocated;
        L11:
            r0 = r0 - 1;
            goto L3
        L7:
            removeCleanedAt(r0);
            return;
        }

        public final <E> Iterator<E> keyValueIterator(Function2<? super K, ? super V, ? extends E> r2) {
            return new KeyValueIterator(this, r2);
        }
    }

    /* JADX INFO: compiled from: ConcurrentWeakMap.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final K key;
        private final V value;

        public Entry(K r1, V r2) {
            this.key = r1;
            this.value = r2;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r1) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: compiled from: ConcurrentWeakMap.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000fH\u0096\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", PerfConsts.PERF_DISK_FILE_SIZE, "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class KeyValueSet<E> extends AbstractMutableSet<E> {
        private final Function2<K, V, E> factory;
        final /* synthetic */ ConcurrentWeakMap<K, V> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public KeyValueSet(ConcurrentWeakMap r1, Function2<? super K, ? super V, ? extends E> r2) {
            this.this$0 = r1;
            this.factory = r2;
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return this.this$0.size();
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E r1) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((Core) ConcurrentWeakMap.access$getCore$FU$p().get(this.this$0)).keyValueIterator(this.factory);
        }
    }

    static {
        _size$FU = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
        core$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core");
    }

    public ConcurrentWeakMap() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static final /* synthetic */ void access$decrementSize(ConcurrentWeakMap r0) {
        r0.decrementSize();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getCore$FU$p() {
        return core$FU;
    }

    public static final /* synthetic */ ReferenceQueue access$getWeakRefQueue$p(ConcurrentWeakMap r0) {
        return r0.weakRefQueue;
    }

    public /* synthetic */ ConcurrentWeakMap(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    public ConcurrentWeakMap(boolean r3) {
        this.core = new Core(this, 16);
        if (r3 == false) goto L5;
        ReferenceQueue<K> r4 = new ReferenceQueue();
    L6:
        this.weakRefQueue = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return _size$FU.get(this);
    }

    private final void decrementSize() {
        _size$FU.decrementAndGet(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (V) ((Core) core$FU.get(this)).getImpl(r2);
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public V put(K r8, V r9) {
        V r0 = (V) Core.putImpl$default((Core) core$FU.get(this), r8, r9, null, 4, null);
        if (r0 != ConcurrentWeakMapKt.access$getREHASH$p()) goto L5;
        r0 = putSynchronized(r8, r9);
    L5:
        if (r0 != null) goto L7;
        _size$FU.incrementAndGet(this);
    L7:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r9) {
        if (r9 != 0) goto L5;
        return null;
    L5:
        V r1 = (V) Core.putImpl$default((Core) core$FU.get(this), r9, null, null, 4, null);
        if (r1 != ConcurrentWeakMapKt.access$getREHASH$p()) goto L8;
        r1 = putSynchronized(r9, null);
    L8:
        if (r1 == null) goto L10;
        _size$FU.decrementAndGet(this);
    L10:
        return r1;
    }

    private final synchronized V putSynchronized(K r8, V r9) {
        monitor-enter(this);
        Core r0 = (Core) core$FU.get(this);     // Catch: Throwable -> L10
    L4:
        V r1 = (V) Core.putImpl$default(r0, r8, r9, null, 4, null);
        if (r1 != ConcurrentWeakMapKt.access$getREHASH$p()) goto L6;
        r0 = r0.rehash();     // Catch: Throwable -> L10
        core$FU.set(this, r0);     // Catch: Throwable -> L10
        goto L4
    L6:
        monitor-exit(this);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return new KeyValueSet(this, ConcurrentWeakMap$keys$1.INSTANCE);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return new KeyValueSet(this, ConcurrentWeakMap$entries$1.INSTANCE);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> r0 = keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        remove(r0.next());
        goto L4
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        if (this.weakRefQueue == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
    L13:
        Reference<? extends K> r1 = this.weakRefQueue.remove();     // Catch: InterruptedException -> L9
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");     // Catch: InterruptedException -> L9
        cleanWeakRef((HashedWeakRef) r1);     // Catch: InterruptedException -> L9
    L9:
        Thread.currentThread().interrupt();
        return;
    L12:
        throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
    L5:
        r0 = false;
        goto L6
    }

    private final void cleanWeakRef(HashedWeakRef<?> r2) {
        ((Core) core$FU.get(this)).cleanWeakRef(r2);
    }
}
