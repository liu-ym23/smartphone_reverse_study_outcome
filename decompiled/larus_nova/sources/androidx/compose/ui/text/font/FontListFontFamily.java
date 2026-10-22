package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0003J\u0017\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eH\u0096\u0003J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0019\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0096\u0003J\u0011\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0001J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0096\u0001J\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0096\u0001J\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000eH\u0096\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\"\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamily;", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "", "Landroidx/compose/ui/text/font/Font;", "fonts", "<init>", "(Ljava/util/List;)V", "getFonts", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "toString", "", "contains", "element", "containsAll", SlcElement.KEY_ELEMENTS, "", MonitorConstants.CONNECT_TYPE_GET, "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "size", "getSize", "()I", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FontListFontFamily extends FileBasedFontFamily implements List<Font>, KMappedMarker {
    public static final int $stable = 0;
    private final List<Font> fonts;

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public void add2(int r100, Font r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int r100, Font r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Font r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r100, Collection<? extends Font> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Font> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(Font r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addFirst(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(Font r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addLast(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Font r100) {
        return this.fonts.contains(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        return this.fonts.containsAll(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public Font get(int r100) {
        return (Font) ListProtector.get(this.fonts, r100);
    }

    public int getSize() {
        return this.fonts.size();
    }

    public int indexOf(Font r100) {
        return this.fonts.indexOf(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.fonts.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Font> iterator() {
        return this.fonts.iterator();
    }

    public int lastIndexOf(Font r100) {
        return this.fonts.lastIndexOf(r100);
    }

    @Override // java.util.List
    public ListIterator<Font> listIterator() {
        return this.fonts.listIterator();
    }

    @Override // java.util.List
    public ListIterator<Font> listIterator(int r100) {
        return this.fonts.listIterator(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public Font remove(int r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Font remove(int r100) {
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

    public Font removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: removeFirst, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m7094removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Font removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: removeLast, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m7095removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<Font> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public Font set2(int r100, Font r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Font set(int r100, Font r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator<? super Font> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Font> subList(int r100, int r101) {
        return this.fonts.subList(r100, r101);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.fonts.hashCode();
    }

    public String toString() {
        return "FontListFontFamily(fonts=" + this.fonts + ')';
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final List<Font> getFonts() {
        return this.fonts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FontListFontFamily(List<? extends Font> r100) {
        super(null);
        this.fonts = r100;
        if ((!r100.isEmpty()) == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("At least one font should be passed to FontFamily");
        return;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof Font) == true) goto L7;
        return false;
    L7:
        return contains((Font) r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FontListFontFamily) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fonts, ((FontListFontFamily) r100).fonts) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Font get(int r100) {
        return get(r100);
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof Font) == true) goto L7;
        return -1;
    L7:
        return indexOf((Font) r100);
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof Font) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((Font) r100);
    }
}
