package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.IntervalList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0003)*+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bJ\u0016\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bJ\b\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u001f¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "", "gridContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;)V", "buckets", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "Lkotlin/collections/ArrayList;", "bucketSize", "", "getBucketSize", "()I", "lastLineIndex", "lastLineStartItemIndex", "lastLineStartKnownSpan", "cachedBucketIndex", "cachedBucket", "", "previousDefaultSpans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "getDefaultSpans", "currentSlotsPerLine", "totalSize", "getTotalSize", "value", "slotsPerLine", "getSlotsPerLine", "setSlotsPerLine", "(I)V", "getLineConfiguration", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "lineIndex", "getLineIndexOfItem", "itemIndex", "spanOf", "maxSpan", "invalidateCache", "", "LineConfiguration", "Bucket", "LazyGridItemSpanScopeImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridSpanLayoutProvider {
    public static final int $stable = 8;
    private final ArrayList<Bucket> buckets;
    private final List<Integer> cachedBucket;
    private int cachedBucketIndex;
    private final LazyGridIntervalContent gridContent;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    private List<GridItemSpan> previousDefaultSpans;
    private int slotsPerLine;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "", "firstItemIndex", "", "firstItemKnownSpan", "<init>", "(II)V", "getFirstItemIndex", "()I", "getFirstItemKnownSpan", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }

        public Bucket(int r100, int r101) {
            this.firstItemIndex = r100;
            this.firstItemKnownSpan = r101;
        }

        public /* synthetic */ Bucket(int r100, int r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = 0;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "<init>", "()V", "maxCurrentLineSpan", "", "getMaxCurrentLineSpan", "()I", "setMaxCurrentLineSpan", "(I)V", "maxLineSpan", "getMaxLineSpan", "setMaxLineSpan", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        public static final LazyGridItemSpanScopeImpl INSTANCE = null;
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        static {
            INSTANCE = new LazyGridItemSpanScopeImpl();
        }

        private LazyGridItemSpanScopeImpl() {
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxCurrentLineSpan() {
            return maxCurrentLineSpan;
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxLineSpan() {
            return maxLineSpan;
        }

        public void setMaxCurrentLineSpan(int r100) {
            maxCurrentLineSpan = r100;
        }

        public void setMaxLineSpan(int r100) {
            maxLineSpan = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "", "firstItemIndex", "", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "<init>", "(ILjava/util/List;)V", "getFirstItemIndex", "()I", "getSpans", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LineConfiguration {
        public static final int $stable = 8;
        private final int firstItemIndex;
        private final List<GridItemSpan> spans;

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final List<GridItemSpan> getSpans() {
            return this.spans;
        }

        public LineConfiguration(int r100, List<GridItemSpan> r101) {
            this.firstItemIndex = r100;
            this.spans = r101;
        }
    }

    public static /* synthetic */ int a(int r100, Bucket r101) {
        return getLineIndexOfItem$lambda$8(r100, r101);
    }

    private final void invalidateCache() {
        this.buckets.clear();
        int r100 = 0;
        this.buckets.add(new Bucket(r100, r100, 2, null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.lastLineStartKnownSpan = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    public final int getTotalSize() {
        return this.gridContent.getIntervals().getSize();
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((((double) getTotalSize()) * 1.0d) / ((double) this.slotsPerLine))) + 1;
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public LazyGridSpanLayoutProvider(LazyGridIntervalContent r100) {
        this.gridContent = r100;
        ArrayList<Bucket> r101 = new ArrayList();
        int r102 = 0;
        r101.add(new Bucket(r102, r102, 2, null));
        this.buckets = r101;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.previousDefaultSpans = CollectionsKt.emptyList();
    }

    private final List<GridItemSpan> getDefaultSpans(int r100) {
        if (r100 == this.previousDefaultSpans.size()) goto L11;
        ArrayList r101 = new ArrayList(r100);
        int r102 = 0;
    L6:
        if (r102 >= r100) goto L8;
        r101.add(GridItemSpan.m848boximpl(LazyGridSpanKt.GridItemSpan(1)));
        r102 = r102 + 1;
        goto L6
    L8:
        this.previousDefaultSpans = r101;
        return r101;
    L11:
        return this.previousDefaultSpans;
    }

    public final LineConfiguration getLineConfiguration(int r110) {
        if (this.gridContent.getHasCustomSpans$foundation_release() == true) goto L6;
        int r100 = this.slotsPerLine;
        int r111 = r110 * r100;
        return new LineConfiguration(r111, getDefaultSpans(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r100, getTotalSize() - r111), 0)));
    L6:
        int r101 = Math.min(r110 / getBucketSize(), this.buckets.size() - 1);
        int r102 = getBucketSize() * r101;
        int r103 = ((Bucket) ListProtector.get(this.buckets, r101)).getFirstItemIndex();
        int r104 = ((Bucket) ListProtector.get(this.buckets, r101)).getFirstItemKnownSpan();
        int r105 = this.lastLineIndex;
        if (r102 > r105) goto L10;
        if (r105 > r110) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L14;
        r103 = this.lastLineStartItemIndex;
        r104 = this.lastLineStartKnownSpan;
        r102 = r105;
    L19:
        if ((r102 % getBucketSize()) != 0) goto L27;
        int r107 = getBucketSize();
        int r108 = r110 - r102;
        if (2 > r108) goto L24;
        if (r108 >= r107) goto L24;
        boolean r109 = true;
    L25:
        if (r109 == false) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == false) goto L30;
        this.cachedBucketIndex = r101;
        this.cachedBucket.clear();
    L30:
        if (r102 > r110) goto L32;
        boolean r113 = true;
    L33:
        if (r113 == true) goto L35;
        InlineClassHelperKt.throwIllegalStateException("currentLine (" + r102 + ") > lineIndex (" + r110 + ')');
    L35:
        if (r102 >= r110) goto L63;
        if (r103 >= getTotalSize()) goto L63;
        if (r112 == false) goto L40;
        this.cachedBucket.add(Integer.valueOf(r103));
    L40:
        int r114 = 0;
    L42:
        if (r114 >= this.slotsPerLine) goto L52;
        if (r103 >= getTotalSize()) goto L52;
        if (r104 != 0) goto L47;
        int r115 = r104;
        r104 = spanOf(r103, this.slotsPerLine - r114);
    L48:
        r114 = r114 + r104;
        if (r114 > this.slotsPerLine) goto L52;
        r103 = r103 + 1;
        r104 = r115;
        goto L42
    L47:
        r115 = 0;
    L52:
        r102 = r102 + 1;
        if ((r102 % getBucketSize()) != 0) goto L35;
        if (r103 >= getTotalSize()) goto L35;
        if (this.buckets.size() != (r102 / getBucketSize())) goto L59;
        boolean r116 = true;
    L60:
        if (r116 == true) goto L62;
        InlineClassHelperKt.throwIllegalStateException("invalid starting point");
    L62:
        this.buckets.add(new Bucket(r103, r104));
        goto L35
    L59:
        r116 = false;
    L63:
        this.lastLineIndex = r110;
        this.lastLineStartItemIndex = r103;
        this.lastLineStartKnownSpan = r104;
        ArrayList r117 = new ArrayList();
        int r118 = r103;
        int r119 = 0;
    L65:
        if (r119 >= this.slotsPerLine) goto L75;
        if (r118 >= getTotalSize()) goto L75;
        if (r104 != 0) goto L70;
        int r120 = r104;
        r104 = spanOf(r118, this.slotsPerLine - r119);
        int r121 = r120;
    L71:
        r119 = r119 + r104;
        if (r119 > this.slotsPerLine) goto L75;
        r118 = r118 + 1;
        r117.add(GridItemSpan.m848boximpl(LazyGridSpanKt.GridItemSpan(r104)));
        r104 = r121;
        goto L65
    L70:
        r121 = 0;
    L75:
        return new LineConfiguration(r103, r117);
    L32:
        r113 = false;
    L24:
        r109 = false;
    L27:
        r112 = false;
        goto L28
    L14:
        if (r101 != this.cachedBucketIndex) goto L19;
        int r122 = r110 - r102;
        if (r122 >= this.cachedBucket.size()) goto L19;
        r103 = ((Number) ListProtector.get(this.cachedBucket, r122)).intValue();
        r102 = r110;
        r104 = 0;
    L10:
        r106 = false;
        goto L11
    }

    public final int getLineIndexOfItem(final int r110) {
        int r100 = 0;
        if (getTotalSize() > 0) goto L6;
        return 0;
    L6:
        if (r110 >= getTotalSize()) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == true) goto L12;
        InlineClassHelperKt.throwIllegalArgumentException("ItemIndex > total count");
    L12:
        if (this.gridContent.getHasCustomSpans$foundation_release() == false) goto L14;
        int r102 = CollectionsKt.binarySearch$default(this.buckets, 0, 0, new x(r110), 3, null);
        int r103 = 2;
        if (r102 >= 0) goto L19;
        r102 = (-r102) - 2;
    L19:
        int r104 = getBucketSize() * r102;
        int r105 = ((Bucket) ListProtector.get(this.buckets, r102)).getFirstItemIndex();
        if (r105 > r110) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == true) goto L25;
        InlineClassHelperKt.throwIllegalArgumentException("currentItemIndex > itemIndex");
    L25:
        int r107 = 0;
    L26:
        if (r105 >= r110) goto L44;
        int r108 = r105 + 1;
        int r109 = spanOf(r105, this.slotsPerLine - r107);
        r107 = r107 + r109;
        int r111 = this.slotsPerLine;
        if (r107 < r111) goto L34;
        if (r107 != r111) goto L32;
        r104 = r104 + 1;
        r107 = 0;
        goto L34
    L32:
        r104 = r104 + 1;
        r107 = r109;
    L34:
        if ((r104 % getBucketSize()) != 0) goto L42;
        if ((r104 / getBucketSize()) < this.buckets.size()) goto L42;
        ArrayList<Bucket> r112 = this.buckets;
        if (r107 <= 0) goto L40;
        int r113 = 1;
    L41:
        r112.add(new Bucket(r108 - r113, r100, r103, null));
        goto L42
    L40:
        r113 = 0;
    L42:
        r105 = r108;
        goto L26
    L44:
        if ((r107 + spanOf(r110, this.slotsPerLine - r107)) > this.slotsPerLine) goto L46;
        return r104;
    L46:
        return r104 + 1;
    L22:
        r106 = false;
        goto L23
    L14:
        return r110 / this.slotsPerLine;
    L8:
        r101 = false;
        goto L9
    }

    public final void setSlotsPerLine(int r100) {
        if (r100 == this.slotsPerLine) goto L6;
        this.slotsPerLine = r100;
        invalidateCache();
        return;
    }

    private static final int getLineIndexOfItem$lambda$8(int r100, Bucket r101) {
        return r101.getFirstItemIndex() - r100;
    }

    public final int spanOf(int r100, int r101) {
        LazyGridItemSpanScopeImpl r102 = LazyGridItemSpanScopeImpl.INSTANCE;
        r102.setMaxCurrentLineSpan(r101);
        r102.setMaxLineSpan(this.slotsPerLine);
        IntervalList.Interval<LazyGridInterval> r103 = this.gridContent.getIntervals().get(r100);
        int r104 = r100 - r103.getStartIndex();
        return GridItemSpan.m852getCurrentLineSpanimpl(r103.getValue().getSpan().invoke(r102, Integer.valueOf(r104)).m855unboximpl());
    }
}
