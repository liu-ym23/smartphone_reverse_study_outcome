package androidx.compose.ui.layout;

import S7.k;
import T7.a;
import androidx.collection.MutableOrderedScatterSet;
import androidx.collection.OrderedScatterSetKt;
import androidx.collection.SieveCacheKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "slotIds", "LC7/r;", "getSlotsToRetain", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;)V", "slotId", "reusableSlotId", "", "areCompatible", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "SlotIdsSet", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SubcomposeSlotReusePolicy {

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010)\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\b\u0000\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ\u001d\u0010\u0018\u001a\u00020\u00072\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\u0004\b\u0018\u0010\fJ#\u0010\u0018\u001a\u00020\u00072\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0004\b\u0018\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u00072\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\u0004\b\u001c\u0010\fJ#\u0010\u001c\u001a\u00020\u00072\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J#\u0010%\u001a\u00020\u001d2\u0014\u0010$\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u001d0\u0019¢\u0006\u0004\b%\u0010&J&\u0010'\u001a\u00020\u001d2\u0014\u0010$\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u001d0\u0019H\u0086\b¢\u0006\u0004\b'\u0010&R(\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010(\u0012\u0004\b+\u0010\u001f\u001a\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "", "", "Landroidx/collection/MutableOrderedScatterSet;", "set", AppAgent.CONSTRUCT, "(Landroidx/collection/MutableOrderedScatterSet;)V", "", "isEmpty", "()Z", "elements", "containsAll", "(Ljava/util/Collection;)Z", "element", "contains", "(Ljava/lang/Object;)Z", "slotId", "add$ui_release", "add", "", "iterator", "()Ljava/util/Iterator;", "remove", "slotIds", "removeAll", "Lkotlin/Function1;", "predicate", "(LS7/k;)Z", "retainAll", "LC7/r;", "clear", "()V", "", "maxSlotsToRetainForReuse", "trimToSize", "(I)V", "block", "forEach", "(LS7/k;)V", "fastForEach", "Landroidx/collection/MutableOrderedScatterSet;", "getSet", "()Landroidx/collection/MutableOrderedScatterSet;", "getSet$annotations", "getSize", "()I", "size", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SlotIdsSet implements Collection<Object>, a {
        public static final int $stable = 8;
        private final MutableOrderedScatterSet<Object> set;

        /* JADX WARN: Multi-variable type inference failed */
        public SlotIdsSet() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ void getSet$annotations() {
        }

        @Override // java.util.Collection
        /* renamed from: add$ui_release, reason: merged with bridge method [inline-methods] */
        public final boolean add(Object slotId) {
            return this.set.add(slotId);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final void clear() {
            this.set.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object element) {
            return this.set.contains(element);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> elements) {
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!this.set.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final void fastForEach(k block) {
            MutableOrderedScatterSet<Object> set = getSet();
            Object[] objArr = set.elements;
            long[] jArr = set.nodes;
            int i = set.tail;
            while (i != Integer.MAX_VALUE) {
                int i6 = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask);
                block.invoke(objArr[i]);
                i = i6;
            }
        }

        public final void forEach(k block) {
            MutableOrderedScatterSet<Object> mutableOrderedScatterSet = this.set;
            Object[] objArr = mutableOrderedScatterSet.elements;
            long[] jArr = mutableOrderedScatterSet.nodes;
            int i = mutableOrderedScatterSet.tail;
            while (i != Integer.MAX_VALUE) {
                int i6 = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask);
                block.invoke(objArr[i]);
                i = i6;
            }
        }

        public final MutableOrderedScatterSet<Object> getSet() {
            return this.set;
        }

        public int getSize() {
            return this.set.get_size();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.set.asMutableSet().iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object slotId) {
            return this.set.remove(slotId);
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> slotIds) {
            return this.set.remove(slotIds);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super Object> predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> slotIds) {
            return this.set.retainAll((Collection<? extends Object>) slotIds);
        }

        @Override // java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return j.a(this);
        }

        public final void trimToSize(int maxSlotsToRetainForReuse) {
            this.set.trimToSize(maxSlotsToRetainForReuse);
        }

        public SlotIdsSet(MutableOrderedScatterSet<Object> mutableOrderedScatterSet) {
            this.set = mutableOrderedScatterSet;
        }

        public final boolean removeAll(k predicate) {
            int size = this.set.get_size();
            MutableOrderedScatterSet<Object> mutableOrderedScatterSet = this.set;
            Object[] objArr = mutableOrderedScatterSet.elements;
            long[] jArr = mutableOrderedScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j5 = jArr[i];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i - length)) >>> 31);
                        for (int i10 = 0; i10 < i6; i10++) {
                            if ((255 & j5) < 128) {
                                int i11 = (i << 3) + i10;
                                if (((Boolean) predicate.invoke(objArr[i11])).booleanValue()) {
                                    mutableOrderedScatterSet.removeElementAt(i11);
                                }
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            return size != this.set.get_size();
        }

        public final boolean retainAll(k predicate) {
            MutableOrderedScatterSet<Object> mutableOrderedScatterSet = this.set;
            Object[] objArr = mutableOrderedScatterSet.elements;
            int size = mutableOrderedScatterSet.get_size();
            long[] jArr = mutableOrderedScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j5 = jArr[i];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i - length)) >>> 31);
                        for (int i10 = 0; i10 < i6; i10++) {
                            if ((255 & j5) < 128) {
                                int i11 = (i << 3) + i10;
                                if (!((Boolean) predicate.invoke(objArr[i11])).booleanValue()) {
                                    mutableOrderedScatterSet.removeElementAt(i11);
                                }
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            return size != mutableOrderedScatterSet.get_size();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j.b(this, tArr);
        }

        public /* synthetic */ SlotIdsSet(MutableOrderedScatterSet mutableOrderedScatterSet, int i, e eVar) {
            this((i & 1) != 0 ? OrderedScatterSetKt.mutableOrderedScatterSetOf() : mutableOrderedScatterSet);
        }
    }

    boolean areCompatible(Object slotId, Object reusableSlotId);

    void getSlotsToRetain(SlotIdsSet slotIds);
}
