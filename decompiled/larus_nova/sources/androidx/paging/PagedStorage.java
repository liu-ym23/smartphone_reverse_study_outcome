package androidx.paging;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
final class PagedStorage<T> extends AbstractList<T> {
    private static final List PLACEHOLDER_LIST = null;
    private int mLeadingNullCount;
    private int mLoadedCount;
    private int mNumberAppended;
    private int mNumberPrepended;
    private int mPageSize;
    private final ArrayList<List<T>> mPages;
    private int mPositionOffset;
    private int mStorageCount;
    private int mTrailingNullCount;

    public interface Callback {
        void onEmptyAppend();

        void onEmptyPrepend();

        void onInitialized(int r100);

        void onPageAppended(int r100, int r101, int r102);

        void onPageInserted(int r100, int r101);

        void onPagePlaceholderInserted(int r100);

        void onPagePrepended(int r100, int r101, int r102);

        void onPagesRemoved(int r100, int r101);

        void onPagesSwappedToPlaceholder(int r100, int r101);
    }

    static {
        PLACEHOLDER_LIST = new ArrayList();
    }

    public int computeLeadingNulls() {
        int r100 = this.mLeadingNullCount;
        int r101 = this.mPages.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        List r103 = (List) ListProtector.get(this.mPages, r102);
        if (r103 == null) goto L9;
        if (r103 != PLACEHOLDER_LIST) goto L10;
    L9:
        r100 = r100 + this.mPageSize;
        r102 = r102 + 1;
    L10:
        return r100;
    }

    public int computeTrailingNulls() {
        int r100 = this.mTrailingNullCount;
        int r101 = this.mPages.size() - 1;
    L3:
        if (r101 < 0) goto L10;
        List r102 = (List) ListProtector.get(this.mPages, r101);
        if (r102 == null) goto L9;
        if (r102 != PLACEHOLDER_LIST) goto L10;
    L9:
        r100 = r100 + this.mPageSize;
        r101 = r101 - 1;
    L10:
        return r100;
    }

    public T getFirstLoadedItem() {
        return (T) ListProtector.get((List) ListProtector.get(this.mPages, 0), 0);
    }

    public T getLastLoadedItem() {
        ArrayList<List<T>> r100 = this.mPages;
        List r101 = (List) ListProtector.get(r100, r100.size() - 1);
        return (T) ListProtector.get(r101, r101.size() - 1);
    }

    public int getMiddleOfLoadedRange() {
        return (this.mLeadingNullCount + this.mPositionOffset) + (this.mStorageCount / 2);
    }

    public int getPageCount() {
        return this.mPages.size();
    }

    public boolean isTiled() {
        if (this.mPageSize <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return (this.mLeadingNullCount + this.mStorageCount) + this.mTrailingNullCount;
    }

    public PagedStorage<T> snapshot() {
        return new PagedStorage(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder r100 = new StringBuilder("leading " + this.mLeadingNullCount + ", storage " + this.mStorageCount + ", trailing " + getTrailingNullCount());
        int r101 = 0;
    L4:
        if (r101 >= this.mPages.size()) goto L7;
        r100.append(" ");
        r100.append(ListProtector.get(this.mPages, r101));
        r101 = r101 + 1;
        goto L4
    L7:
        return r100.toString();
    }

    public PagedStorage() {
        this.mLeadingNullCount = 0;
        this.mPages = new ArrayList();
        this.mTrailingNullCount = 0;
        this.mPositionOffset = 0;
        this.mLoadedCount = 0;
        this.mStorageCount = 0;
        this.mPageSize = 1;
        this.mNumberPrepended = 0;
        this.mNumberAppended = 0;
    }

    public int getLeadingNullCount() {
        return this.mLeadingNullCount;
    }

    public int getLoadedCount() {
        return this.mLoadedCount;
    }

    public int getNumberAppended() {
        return this.mNumberAppended;
    }

    public int getNumberPrepended() {
        return this.mNumberPrepended;
    }

    public int getPositionOffset() {
        return this.mPositionOffset;
    }

    public int getStorageCount() {
        return this.mStorageCount;
    }

    public int getTrailingNullCount() {
        return this.mTrailingNullCount;
    }

    private PagedStorage(PagedStorage<T> r100) {
        this.mLeadingNullCount = r100.mLeadingNullCount;
        this.mPages = new ArrayList(r100.mPages);
        this.mTrailingNullCount = r100.mTrailingNullCount;
        this.mPositionOffset = r100.mPositionOffset;
        this.mLoadedCount = r100.mLoadedCount;
        this.mStorageCount = r100.mStorageCount;
        this.mPageSize = r100.mPageSize;
        this.mNumberPrepended = r100.mNumberPrepended;
        this.mNumberAppended = r100.mNumberAppended;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r100) {
        if (r100 < 0) goto L28;
        if (r100 >= size()) goto L28;
        int r101 = r100 - this.mLeadingNullCount;
        if (r101 >= 0) goto L8;
    L26:
        return null;
    L8:
        if (r101 >= this.mStorageCount) goto L26;
        if (isTiled() == false) goto L13;
        int r102 = this.mPageSize;
        int r103 = r101 / r102;
        r101 = r101 % r102;
    L19:
        List r104 = (List) ListProtector.get(this.mPages, r103);
        if (r104 == null) goto L26;
        if (r104.size() == 0) goto L26;
        return (T) ListProtector.get(r104, r101);
    L13:
        int r105 = this.mPages.size();
        r103 = 0;
    L14:
        if (r103 >= r105) goto L19;
        int r106 = ((List) ListProtector.get(this.mPages, r103)).size();
        if (r106 > r101) goto L19;
        r101 = r101 - r106;
        r103 = r103 + 1;
    L28:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Size: " + size());
    }

    public void allocatePageRange(int r100, int r101) {
        int r102 = this.mLeadingNullCount / this.mPageSize;
        if (r100 >= r102) goto L9;
        int r103 = 0;
    L5:
        int r104 = r102 - r100;
        if (r103 >= r104) goto L8;
        ListProtector.add(this.mPages, 0, null);
        r103 = r103 + 1;
        goto L5
    L8:
        int r105 = r104 * this.mPageSize;
        this.mStorageCount += r105;
        this.mLeadingNullCount -= r105;
    L11:
        if (r101 < (this.mPages.size() + r100)) goto L20;
        int r106 = Math.min(this.mTrailingNullCount, ((r101 + 1) - (this.mPages.size() + r100)) * this.mPageSize);
        int r107 = this.mPages.size();
    L14:
        if (r107 > (r101 - r100)) goto L16;
        ArrayList<List<T>> r108 = this.mPages;
        ListProtector.add(r108, r108.size(), null);
        r107 = r107 + 1;
        goto L14
    L16:
        this.mStorageCount += r106;
        this.mTrailingNullCount -= r106;
        return;
    L20:
        return;
    L9:
        r100 = r102;
        goto L11
    }

    public void appendPage(List<T> r100, Callback r101) {
        int r102 = r100.size();
        if (r102 != 0) goto L7;
        r101.onEmptyAppend();
        return;
    L7:
        if (this.mPageSize <= 0) goto L12;
        ArrayList<List<T>> r103 = this.mPages;
        int r104 = ((List) ListProtector.get(r103, r103.size() - 1)).size();
        int r105 = this.mPageSize;
        if (r104 != r105) goto L11;
        if (r102 <= r105) goto L12;
    L11:
        this.mPageSize = -1;
    L12:
        this.mPages.add(r100);
        this.mLoadedCount += r102;
        this.mStorageCount += r102;
        int r106 = Math.min(this.mTrailingNullCount, r102);
        int r107 = r102 - r106;
        if (r106 == 0) goto L15;
        this.mTrailingNullCount -= r106;
    L15:
        this.mNumberAppended += r102;
        r101.onPageAppended((this.mLeadingNullCount + this.mStorageCount) - r102, r106, r107);
    }

    public boolean hasPage(int r100, int r101) {
        int r102 = this.mLeadingNullCount / r100;
        if (r101 >= r102) goto L5;
        return false;
    L5:
        if (r101 >= (this.mPages.size() + r102)) goto L16;
        List r103 = (List) ListProtector.get(this.mPages, r101 - r102);
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r103 == PLACEHOLDER_LIST) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public boolean needsTrimFromEnd(int r100, int r101) {
        return needsTrim(r100, r101, this.mPages.size() - 1);
    }

    public boolean needsTrimFromFront(int r100, int r101) {
        return needsTrim(r100, r101, 0);
    }

    public boolean pageWouldBeBoundary(int r100, boolean r101) {
        if (this.mPageSize < 1) goto L29;
        if (this.mPages.size() < 2) goto L29;
        int r102 = this.mLeadingNullCount;
        if (r100 >= r102) goto L10;
        return r101;
    L10:
        if (r100 >= (this.mStorageCount + r102)) goto L12;
        int r103 = (r100 - r102) / this.mPageSize;
        if (r101 == false) goto L21;
        int r104 = 0;
    L16:
        if (r104 >= r103) goto L27;
        if (ListProtector.get(this.mPages, r104) != null) goto L19;
        r104 = r104 + 1;
        goto L16
    L19:
        return false;
    L27:
        return true;
    L21:
        int r105 = this.mPages.size() - 1;
    L22:
        if (r105 <= r103) goto L27;
        if (ListProtector.get(this.mPages, r105) != null) goto L25;
        r105 = r105 - 1;
        goto L22
    L25:
        return false;
    L12:
        return !r101;
    L29:
        throw new IllegalStateException("Trimming attempt before sufficient load");
    }

    public void prependPage(List<T> r100, Callback r101) {
        int r102 = r100.size();
        if (r102 != 0) goto L6;
        r101.onEmptyPrepend();
        return;
    L6:
        int r103 = this.mPageSize;
        if (r103 <= 0) goto L15;
        if (r102 == r103) goto L15;
        if (this.mPages.size() == 1) goto L12;
    L14:
        this.mPageSize = -1;
        goto L15
    L12:
        if (r102 <= this.mPageSize) goto L14;
        this.mPageSize = r102;
    L15:
        ListProtector.add(this.mPages, 0, r100);
        this.mLoadedCount += r102;
        this.mStorageCount += r102;
        int r104 = Math.min(this.mLeadingNullCount, r102);
        int r105 = r102 - r104;
        if (r104 == 0) goto L18;
        this.mLeadingNullCount -= r104;
    L18:
        this.mPositionOffset -= r105;
        this.mNumberPrepended += r102;
        r101.onPagePrepended(this.mLeadingNullCount, r104, r105);
    }

    public PagedStorage(int r100, List<T> r101, int r102) {
        this();
        init(r100, r101, r102, 0);
    }

    private boolean needsTrim(int r100, int r101, int r102) {
        List r103 = (List) ListProtector.get(this.mPages, r102);
        if (r103 != null) goto L5;
    L14:
        return true;
    L5:
        if (this.mLoadedCount > r100) goto L7;
    L13:
        return false;
    L7:
        if (this.mPages.size() <= 2) goto L13;
        if (r103 == PLACEHOLDER_LIST) goto L13;
        if ((this.mLoadedCount - r103.size()) < r101) goto L13;
        goto L13
    }

    public void insertPage(int r100, List<T> r101, Callback r102) {
        int r103 = r101.size();
        if (r103 == this.mPageSize) goto L23;
        int r104 = size();
        int r105 = this.mPageSize;
        boolean r106 = false;
        if (r100 != (r104 - (r104 % r105))) goto L8;
        if (r103 >= r105) goto L8;
        boolean r107 = true;
    L10:
        if (this.mTrailingNullCount == 0) goto L12;
    L16:
        if (r106 == true) goto L21;
        if (r107 == true) goto L21;
        throw new IllegalArgumentException("page introduces incorrect tiling");
    L21:
        if (r106 == false) goto L23;
        this.mPageSize = r103;
        goto L23
    L12:
        if (this.mPages.size() != 1) goto L16;
        if (r103 <= this.mPageSize) goto L16;
        r106 = true;
    L8:
        r107 = false;
    L23:
        int r108 = r100 / this.mPageSize;
        allocatePageRange(r108, r108);
        int r109 = r108 - (this.mLeadingNullCount / this.mPageSize);
        List r110 = (List) ListProtector.get(this.mPages, r109);
        if (r110 != null) goto L26;
    L30:
        ListProtector.set(this.mPages, r109, r101);
        this.mLoadedCount += r103;
        if (r102 == null) goto L34;
        r102.onPageInserted(r100, r103);
        return;
    L34:
        return;
    L26:
        if (r110 == PLACEHOLDER_LIST) goto L30;
        throw new IllegalArgumentException("Invalid position " + r100 + ": data already loaded");
    }

    public boolean shouldPreTrimNewPage(int r100, int r101, int r102) {
        if ((this.mLoadedCount + r102) > r100) goto L5;
    L9:
        return false;
    L5:
        if (this.mPages.size() <= 1) goto L9;
        if (this.mLoadedCount < r101) goto L9;
        return true;
    }

    private void init(int r100, List<T> r101, int r102, int r103) {
        this.mLeadingNullCount = r100;
        this.mPages.clear();
        this.mPages.add(r101);
        this.mTrailingNullCount = r102;
        this.mPositionOffset = r103;
        int r104 = r101.size();
        this.mLoadedCount = r104;
        this.mStorageCount = r104;
        this.mPageSize = r101.size();
        this.mNumberPrepended = 0;
        this.mNumberAppended = 0;
    }

    public void allocatePlaceholders(int r100, int r101, int r102, Callback r103) {
        int r104 = this.mPageSize;
        if (r102 == r104) goto L14;
        if (r102 < r104) goto L13;
        if (this.mPages.size() != 1) goto L11;
        if (this.mTrailingNullCount != 0) goto L11;
        this.mPageSize = r102;
    L11:
        throw new IllegalArgumentException("Page size can change only if last page is only one present");
    L13:
        throw new IllegalArgumentException("Page size cannot be reduced");
    L14:
        int r105 = size();
        int r106 = this.mPageSize;
        int r107 = ((r105 + r106) - 1) / r106;
        int r108 = Math.max((r100 - r101) / r106, 0);
        int r109 = Math.min((r100 + r101) / this.mPageSize, r107 - 1);
        allocatePageRange(r108, r109);
        int r110 = this.mLeadingNullCount / this.mPageSize;
    L15:
        if (r108 > r109) goto L20;
        int r111 = r108 - r110;
        if (ListProtector.get(this.mPages, r111) != null) goto L19;
        ListProtector.set(this.mPages, r111, PLACEHOLDER_LIST);
        r103.onPagePlaceholderInserted(r108);
    L19:
        r108 = r108 + 1;
        goto L15
    }

    public boolean trimFromEnd(boolean r100, int r101, int r102, Callback r103) {
        int r104 = 0;
    L4:
        if (needsTrimFromEnd(r101, r102) == false) goto L14;
        ArrayList<List<T>> r105 = this.mPages;
        List r106 = (List) ListProtector.remove(r105, r105.size() - 1);
        if (r106 != null) goto L8;
        int r107 = this.mPageSize;
    L9:
        r104 = r104 + r107;
        this.mStorageCount -= r107;
        int r108 = this.mLoadedCount;
        if (r106 != null) goto L12;
        int r109 = 0;
    L13:
        this.mLoadedCount = r108 - r109;
        goto L4
    L12:
        r109 = r106.size();
        goto L13
    L8:
        r107 = r106.size();
        goto L9
    L14:
        if (r104 <= 0) goto L19;
        int r110 = this.mLeadingNullCount + this.mStorageCount;
        if (r100 == false) goto L18;
        this.mTrailingNullCount += r104;
        r103.onPagesSwappedToPlaceholder(r110, r104);
        goto L19
    L18:
        r103.onPagesRemoved(r110, r104);
    L19:
        if (r104 <= 0) goto L25;
        return true;
    L25:
        return false;
    }

    public boolean trimFromFront(boolean r100, int r101, int r102, Callback r103) {
        int r104 = 0;
    L4:
        if (needsTrimFromFront(r101, r102) == false) goto L14;
        List r105 = (List) ListProtector.remove(this.mPages, 0);
        if (r105 != null) goto L8;
        int r106 = this.mPageSize;
    L9:
        r104 = r104 + r106;
        this.mStorageCount -= r106;
        int r107 = this.mLoadedCount;
        if (r105 != null) goto L12;
        int r108 = 0;
    L13:
        this.mLoadedCount = r107 - r108;
        goto L4
    L12:
        r108 = r105.size();
        goto L13
    L8:
        r106 = r105.size();
        goto L9
    L14:
        if (r104 <= 0) goto L18;
        if (r100 == false) goto L17;
        int r109 = this.mLeadingNullCount;
        this.mLeadingNullCount = r109 + r104;
        r103.onPagesSwappedToPlaceholder(r109, r104);
        goto L18
    L17:
        this.mPositionOffset += r104;
        r103.onPagesRemoved(this.mLeadingNullCount, r104);
    L18:
        if (r104 <= 0) goto L24;
        return true;
    L24:
        return false;
    }

    public void init(int r100, List<T> r101, int r102, int r103, Callback r104) {
        init(r100, r101, r102, r103);
        r104.onInitialized(size());
    }

    public void initAndSplit(int r100, List<T> r101, int r102, int r110, int r111, Callback r112) {
        int r103 = (r101.size() + (r111 - 1)) / r111;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        int r105 = r104 * r111;
        int r106 = r104 + 1;
        List<T> r107 = r101.subList(r105, Math.min(r101.size(), r106 * r111));
        if (r104 != 0) goto L7;
        init(r100, r107, (r101.size() + r102) - r107.size(), r110);
    L8:
        r104 = r106;
        goto L3
    L7:
        insertPage(r105 + r100, r107, null);
        goto L8
    L9:
        r112.onInitialized(size());
    }

    public void tryInsertPageAndTrim(int r100, List<T> r101, int r102, int r103, int r110, Callback r111) {
        if (r103 == Integer.MAX_VALUE) goto L5;
        boolean r104 = true;
    L7:
        if (r102 <= getMiddleOfLoadedRange()) goto L9;
        boolean r105 = true;
    L10:
        if (r104 == true) goto L12;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        insertPage(r100, r101, r111);
    L24:
        if (r104 == false) goto L29;
        if (r105 == false) goto L27;
        trimFromFront(true, r103, r110, r111);
        return;
    L27:
        trimFromEnd(true, r103, r110, r111);
        return;
    L29:
        return;
    L20:
        ListProtector.set(this.mPages, (r100 - this.mLeadingNullCount) / this.mPageSize, null);
        this.mStorageCount -= r101.size();
        if (r105 == false) goto L23;
        ListProtector.remove(this.mPages, 0);
        this.mLeadingNullCount += r101.size();
        goto L24
    L23:
        ArrayList<List<T>> r107 = this.mPages;
        ListProtector.remove(r107, r107.size() - 1);
        this.mTrailingNullCount += r101.size();
        goto L24
    L12:
        if (shouldPreTrimNewPage(r103, r110, r101.size()) == false) goto L17;
        if (pageWouldBeBoundary(r100, r105) == false) goto L17;
        r106 = false;
        goto L18
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L7
    }
}
