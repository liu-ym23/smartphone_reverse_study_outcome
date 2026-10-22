package androidx.compose.material3.carousel;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0006\b\u0001\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u0017\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020#J\u000e\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020#J\u000e\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020#J\u0013\u0010*\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020\u0007H\u0016J\u0011\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0002H\u0096\u0003J\u0017\u00100\u001a\u00020 2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000202H\u0096\u0001J\u0011\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0007H\u0096\u0003J\u0011\u00105\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0002H\u0096\u0001J\t\u00106\u001a\u00020 H\u0096\u0001J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000208H\u0096\u0003J\u0011\u00109\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0002H\u0096\u0001J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020;H\u0096\u0001J\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020;2\u0006\u00104\u001a\u00020\u0007H\u0096\u0001J\u001f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0096\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0011\u0010\u000f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0011\u0010\u0013\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0011\u0010\u0017\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0011\u0010\u001b\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\tR\u0012\u0010%\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010\t¨\u0006A"}, d2 = {"Landroidx/compose/material3/carousel/KeylineList;", "", "Landroidx/compose/material3/carousel/Keyline;", "keylines", "<init>", "(Ljava/util/List;)V", "pivotIndex", "", "getPivotIndex", "()I", "pivot", "getPivot", "()Landroidx/compose/material3/carousel/Keyline;", "firstNonAnchorIndex", "getFirstNonAnchorIndex", "firstNonAnchor", "getFirstNonAnchor", "lastNonAnchorIndex", "getLastNonAnchorIndex", "lastNonAnchor", "getLastNonAnchor", "firstFocalIndex", "getFirstFocalIndex", "firstFocal", "getFirstFocal", "lastFocalIndex", "getLastFocalIndex", "lastFocal", "getLastFocal", "focalCount", "getFocalCount", "isFirstFocalItemAtStartOfContainer", "", "isLastFocalItemAtEndOfContainer", "carouselMainAxisSize", "", "firstIndexAfterFocalRangeWithSize", "size", "lastIndexBeforeFocalRangeWithSize", "getKeylineBefore", "unadjustedOffset", "getKeylineAfter", "equals", "other", "", "hashCode", "contains", "element", "containsAll", SlcElement.KEY_ELEMENTS, "", MonitorConstants.CONNECT_TYPE_GET, "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "getSize", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeylineList implements List<Keyline>, KMappedMarker {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final KeylineList Empty = null;
    private final /* synthetic */ List<Keyline> $$delegate_0;
    private final int firstFocalIndex;
    private final int firstNonAnchorIndex;
    private final int focalCount;
    private final int lastFocalIndex;
    private final int lastNonAnchorIndex;
    private final int pivotIndex;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/carousel/KeylineList$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/material3/carousel/KeylineList;", "getEmpty", "()Landroidx/compose/material3/carousel/KeylineList;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final KeylineList getEmpty() {
            return KeylineList.access$getEmpty$cp();
        }
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public void add2(int r100, Keyline r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int r100, Keyline r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Keyline r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r100, Collection<? extends Keyline> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Keyline> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(Keyline r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addFirst(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(Keyline r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addLast(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Keyline r100) {
        return this.$$delegate_0.contains(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        return this.$$delegate_0.containsAll(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public Keyline get(int r100) {
        return (Keyline) ListProtector.get(this.$$delegate_0, r100);
    }

    public int getSize() {
        return this.$$delegate_0.size();
    }

    public int indexOf(Keyline r100) {
        return this.$$delegate_0.indexOf(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Keyline> iterator() {
        return this.$$delegate_0.iterator();
    }

    public int lastIndexOf(Keyline r100) {
        return this.$$delegate_0.lastIndexOf(r100);
    }

    @Override // java.util.List
    public ListIterator<Keyline> listIterator() {
        return this.$$delegate_0.listIterator();
    }

    @Override // java.util.List
    public ListIterator<Keyline> listIterator(int r100) {
        return this.$$delegate_0.listIterator(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public Keyline remove(int r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Keyline remove(int r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Keyline removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: removeFirst, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3117removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Keyline removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: removeLast, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3118removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<Keyline> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public Keyline set2(int r100, Keyline r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Keyline set(int r100, Keyline r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator<? super Keyline> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Keyline> subList(int r100, int r101) {
        return this.$$delegate_0.subList(r100, r101);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        Empty = new KeylineList(CollectionsKt.emptyList());
    }

    public final Keyline getFirstFocal() {
        Keyline r100 = (Keyline) CollectionsKt.getOrNull(this, this.firstFocalIndex);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
    }

    public final Keyline getFirstNonAnchor() {
        return get(this.firstNonAnchorIndex);
    }

    public final Keyline getLastFocal() {
        Keyline r100 = (Keyline) CollectionsKt.getOrNull(this, this.lastFocalIndex);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
    }

    public final Keyline getLastNonAnchor() {
        return get(this.lastNonAnchorIndex);
    }

    public final Keyline getPivot() {
        return get(this.pivotIndex);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int r100 = size();
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L5;
        r102 = r102 + (((Keyline) ListProtector.get(this, r101)).hashCode() * 31);
        r101 = r101 + 1;
        goto L3
    L5:
        return r102;
    }

    public final boolean isFirstFocalItemAtStartOfContainer() {
        if ((getFirstFocal().getOffset() - (getFirstFocal().getSize() / 2)) >= 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getFirstFocal(), getFirstNonAnchor()) == false) goto L7;
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public static final /* synthetic */ KeylineList access$getEmpty$cp() {
        return Empty;
    }

    public final int getFirstFocalIndex() {
        return this.firstFocalIndex;
    }

    public final int getFirstNonAnchorIndex() {
        return this.firstNonAnchorIndex;
    }

    public final int getFocalCount() {
        return this.focalCount;
    }

    public final int getLastFocalIndex() {
        return this.lastFocalIndex;
    }

    public final int getLastNonAnchorIndex() {
        return this.lastNonAnchorIndex;
    }

    public final int getPivotIndex() {
        return this.pivotIndex;
    }

    public KeylineList(List<Keyline> r100) {
        this.$$delegate_0 = r100;
        Iterator<Keyline> r101 = iterator();
        int r102 = 0;
        int r103 = 0;
    L3:
        int r104 = -1;
        if (r101.hasNext() == false) goto L9;
        if (r101.next().isPivot() == true) goto L10;
        r103 = r103 + 1;
    L10:
        this.pivotIndex = r103;
        Iterator<Keyline> r105 = iterator();
        int r106 = 0;
    L12:
        if (r105.hasNext() == false) goto L17;
        if ((!r105.next().isAnchor()) == true) goto L18;
        r106 = r106 + 1;
    L18:
        this.firstNonAnchorIndex = r106;
        ListIterator<Keyline> r107 = listIterator(size());
    L20:
        if (r107.hasPrevious() == false) goto L24;
        if ((!r107.previous().isAnchor()) == false) goto L20;
        int r108 = r107.nextIndex();
    L25:
        this.lastNonAnchorIndex = r108;
        Iterator<Keyline> r109 = iterator();
    L27:
        if (r109.hasNext() == false) goto L32;
        if (r109.next().isFocal() == true) goto L33;
        r102 = r102 + 1;
    L33:
        this.firstFocalIndex = r102;
        ListIterator<Keyline> r110 = listIterator(size());
    L35:
        if (r110.hasPrevious() == false) goto L39;
        if (r110.previous().isFocal() == false) goto L35;
        r104 = r110.nextIndex();
    L39:
        this.lastFocalIndex = r104;
        this.focalCount = (r104 - this.firstFocalIndex) + 1;
        return;
    L32:
        r102 = -1;
        goto L33
    L24:
        r108 = -1;
        goto L25
    L17:
        r106 = -1;
        goto L18
    L9:
        r103 = -1;
        goto L10
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof Keyline) == true) goto L7;
        return false;
    L7:
        return contains((Keyline) r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KeylineList) == true) goto L8;
        return false;
    L8:
        KeylineList r101 = (KeylineList) r100;
        if (size() == r101.size()) goto L11;
        return false;
    L11:
        int r102 = size();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L17;
        if (Intrinsics.areEqual((Keyline) ListProtector.get(this, r103), r101.get(r103)) == false) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public final int firstIndexAfterFocalRangeWithSize(float r100) {
        Iterator<Integer> r101 = new IntRange(this.lastFocalIndex, CollectionsKt.getLastIndex(this)).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Integer r102 = r101.next();
        if (get(r102.intValue()).getSize() != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L12:
        Integer r104 = r102;
        if (r104 == null) goto L16;
        return r104.intValue();
    L16:
        return CollectionsKt.getLastIndex(this);
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Keyline get(int r100) {
        return get(r100);
    }

    public final Keyline getKeylineAfter(float r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        Object r103 = ListProtector.get(this, r102);
        if (((Keyline) r103).getUnadjustedOffset() < r100) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L12;
        r102 = r102 + 1;
    L12:
        Keyline r105 = (Keyline) r103;
        if (r105 == null) goto L15;
        return r105;
    L15:
        return (Keyline) CollectionsKt.last(this);
    L7:
        r104 = false;
        goto L8
    L11:
        r103 = null;
        goto L12
    }

    public final Keyline getKeylineBefore(float r100) {
        int r101 = size() - 1;
        if (r101 < 0) goto L11;
    L4:
        int r102 = r101 - 1;
        Keyline r103 = get(r101);
        if (r103.getUnadjustedOffset() < r100) goto L6;
        if (r102 < 0) goto L11;
        r101 = r102;
        goto L4
    L6:
        return r103;
    L11:
        return (Keyline) CollectionsKt.first(this);
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof Keyline) == true) goto L7;
        return -1;
    L7:
        return indexOf((Keyline) r100);
    }

    public final boolean isLastFocalItemAtEndOfContainer(float r100) {
        if ((getLastFocal().getOffset() + (getLastFocal().getSize() / 2)) <= r100) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getLastFocal(), getLastNonAnchor()) == false) goto L7;
        return true;
    }

    public final int lastIndexBeforeFocalRangeWithSize(float r100) {
        Iterator<Integer> r101 = RangesKt.downTo(this.firstFocalIndex - 1, 0).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Integer r102 = r101.next();
        if (get(r102.intValue()).getSize() != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L12:
        Integer r104 = r102;
        if (r104 != null) goto L15;
        return 0;
    L15:
        return r104.intValue();
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof Keyline) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((Keyline) r100);
    }
}
