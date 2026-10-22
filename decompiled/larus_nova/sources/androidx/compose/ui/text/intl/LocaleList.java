package androidx.compose.ui.text.intl;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u001d\b\u0016\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b\"\u00020\u0002¢\u0006\u0004\b\u0005\u0010\fJ\u0011\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0096\u0002J\u0013\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\bH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Landroidx/compose/ui/text/intl/LocaleList;", "", "Landroidx/compose/ui/text/intl/Locale;", "localeList", "", "<init>", "(Ljava/util/List;)V", "languageTags", "", "(Ljava/lang/String;)V", "locales", "", "([Landroidx/compose/ui/text/intl/Locale;)V", "getLocaleList", "()Ljava/util/List;", MonitorConstants.CONNECT_TYPE_GET, RXScreenCaptureService.KEY_INDEX, "", "size", "getSize", "()I", "contains", "", "element", "containsAll", SlcElement.KEY_ELEMENTS, "isEmpty", "iterator", "", "equals", "other", "", "hashCode", "toString", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocaleList implements Collection<Locale>, KMappedMarker {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final LocaleList Empty = null;
    private final List<Locale> localeList;
    private final int size;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/intl/LocaleList$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/ui/text/intl/LocaleList;", "getEmpty", "()Landroidx/compose/ui/text/intl/LocaleList;", "current", "getCurrent", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LocaleList getCurrent() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent();
        }

        public final LocaleList getEmpty() {
            return LocaleList.access$getEmpty$cp();
        }
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public boolean add2(Locale r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Locale r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends Locale> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super Locale> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    static {
        Companion = new Companion(null);
        Empty = new LocaleList(CollectionsKt.emptyList());
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.localeList.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.localeList.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<Locale> iterator() {
        return this.localeList.iterator();
    }

    public String toString() {
        return "LocaleList(localeList=" + this.localeList + ')';
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public static final /* synthetic */ LocaleList access$getEmpty$cp() {
        return Empty;
    }

    public final List<Locale> getLocaleList() {
        return this.localeList;
    }

    public int getSize() {
        return this.size;
    }

    public LocaleList(String r100) {
        List r101 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);
        ArrayList r102 = new ArrayList(r101.size());
        int r103 = r101.size();
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        r102.add(StringsKt.trim((String) ListProtector.get(r101, r105)).toString());
        r105 = r105 + 1;
        goto L3
    L5:
        ArrayList r106 = new ArrayList(r102.size());
        int r107 = r102.size();
    L6:
        if (r104 >= r107) goto L8;
        r106.add(new Locale((String) ListProtector.get(r102, r104)));
        r104 = r104 + 1;
        goto L6
    L8:
        this(r106);
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof Locale) == true) goto L7;
        return false;
    L7:
        return contains((Locale) r100);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        return this.localeList.containsAll(r100);
    }

    @Override // java.util.Collection
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocaleList) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.localeList, ((LocaleList) r100).localeList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final Locale get(int r100) {
        return (Locale) ListProtector.get(this.localeList, r100);
    }

    public LocaleList(List<Locale> r100) {
        this.localeList = r100;
        this.size = r100.size();
    }

    public boolean contains(Locale r100) {
        return this.localeList.contains(r100);
    }

    public LocaleList(Locale... r100) {
        this(ArraysKt.toList(r100));
    }
}
