package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntIntMapKt;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b \b!\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\u000fJ\b\u0010\"\u001a\u00020\u001fH\u0002J\n\u0010#\u001a\u00020\u001f*\u00020 J\u0006\u0010$\u001a\u00020\u0013J\u0014\u0010%\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0014\u0010&\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0014\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0006\u0010)\u001a\u00020\u001fJD\u0010*\u001a\u00020\u001f*\u00020 2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0013H\u0002J@\u00102\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J\u001c\u00104\u001a\u00020\u0011*\u00020 2\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0013H\u0002J\u0018\u00107\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0002J\u0018\u00109\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0002J\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0011H\u0002J\u001c\u0010=\u001a\u00020\u001f*\u00020 2\u0006\u00105\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u0011H\u0002J\f\u0010?\u001a\u00020\u001f*\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;)V", "prefetchWindowHandles", "Landroidx/collection/MutableIntObjectMap;", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "indicesToRemove", "Landroidx/collection/MutableIntSet;", "windowCache", "Landroidx/collection/MutableIntIntMap;", "previousPassDelta", "", "previousPassItemCount", "", "hasUpdatedVisibleItemsOnce", "", "value", "prefetchWindowStartLine", "getPrefetchWindowStartLine$foundation_release", "()I", "prefetchWindowEndLine", "getPrefetchWindowEndLine$foundation_release", "prefetchWindowStartExtraSpace", "prefetchWindowEndExtraSpace", "shouldRefillWindow", "itemsCount", "onScroll", "", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "delta", "traceWindowInfo", "onVisibleItemsUpdated", "hasValidBounds", "fillCacheWindowBackward", "fillCacheWindowForward", "refillWindow", "refillForward", "resetStrategy", "onPrefetchForward", "visibleWindowStart", "visibleWindowEnd", "prefetchForwardWindow", "mainAxisExtraSpaceEnd", "mainAxisExtraSpaceStart", "scrollDelta", "applyForwardPrefetch", "onKeepAround", "keepAroundWindow", "getItemSizeOrPrefetch", "index", "isUrgent", "cachePrefetchedItem", "size", "cacheVisibleItemsInfo", "removeOutOfBoundsItems", "startLine", "endLine", "onItemPrefetched", "itemSize", "scheduleNextItemIfNeeded", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CacheWindowLogic {
    public static final int $stable = 8;
    private final LazyLayoutCacheWindow cacheWindow;
    private boolean hasUpdatedVisibleItemsOnce;
    private final MutableIntSet indicesToRemove;
    private int itemsCount;
    private int prefetchWindowEndExtraSpace;
    private int prefetchWindowEndLine;
    private final MutableIntObjectMap<List<LazyLayoutPrefetchState.PrefetchHandle>> prefetchWindowHandles;
    private int prefetchWindowStartExtraSpace;
    private int prefetchWindowStartLine;
    private float previousPassDelta;
    private int previousPassItemCount;
    private boolean shouldRefillWindow;
    private final MutableIntIntMap windowCache;

    public static /* synthetic */ Unit a(CacheWindowLogic r100, CacheWindowScope r101, int r102, int r103) {
        return scheduleNextItemIfNeeded$lambda$15(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit b(CacheWindowLogic r100, CacheWindowScope r101, int r102, int r103) {
        return getItemSizeOrPrefetch$lambda$8(r100, r101, r102, r103);
    }

    private final void traceWindowInfo() {
        AndroidTrace_androidKt.traceValue("prefetchWindowStartExtraSpace", this.prefetchWindowStartExtraSpace);
        AndroidTrace_androidKt.traceValue("prefetchWindowEndExtraSpace", this.prefetchWindowEndExtraSpace);
        AndroidTrace_androidKt.traceValue("prefetchWindowStartIndex", this.prefetchWindowStartLine);
        AndroidTrace_androidKt.traceValue("prefetchWindowEndIndex", this.prefetchWindowEndLine);
    }

    public final boolean hasValidBounds() {
        if (this.prefetchWindowStartLine != Integer.MAX_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (this.prefetchWindowEndLine == Integer.MIN_VALUE) goto L7;
        return true;
    }

    public final void resetStrategy() {
        this.prefetchWindowStartLine = Integer.MAX_VALUE;
        this.prefetchWindowEndLine = Integer.MIN_VALUE;
        this.prefetchWindowStartExtraSpace = 0;
        this.prefetchWindowEndExtraSpace = 0;
        this.shouldRefillWindow = false;
        this.windowCache.clear();
        MutableIntObjectMap<List<LazyLayoutPrefetchState.PrefetchHandle>> r100 = this.prefetchWindowHandles;
        long[] r101 = r100.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L22;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L20;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L19;
        if ((255 & r104) >= 128) goto L12;
        boolean r110 = true;
    L13:
        if (r110 == false) goto L18;
        int r111 = (r103 << 3) + r106;
        int r112 = r100.keys[r111];
        List r113 = (List) r100.values[r111];
        int r114 = r113.size();
        int r115 = 0;
    L15:
        if (r115 >= r114) goto L17;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r113, r115)).cancel();
        r115 = r115 + 1;
        goto L15
    L17:
        r100.removeValueAt(r111);
    L18:
        r104 = r104 >> 8;
        r106 = r106 + 1;
        goto L8
    L12:
        r110 = false;
        goto L13
    L19:
        if (r105 == 8) goto L20;
        return;
    L20:
        if (r103 == r102) goto L30;
        r103 = r103 + 1;
        goto L5
    L30:
        return;
    }

    public final int getPrefetchWindowEndLine$foundation_release() {
        return this.prefetchWindowEndLine;
    }

    public final int getPrefetchWindowStartLine$foundation_release() {
        return this.prefetchWindowStartLine;
    }

    public CacheWindowLogic(LazyLayoutCacheWindow r100) {
        this.cacheWindow = r100;
        this.prefetchWindowHandles = IntObjectMapKt.mutableIntObjectMapOf();
        this.indicesToRemove = IntSetKt.mutableIntSetOf();
        this.windowCache = IntIntMapKt.mutableIntIntMapOf();
        this.previousPassItemCount = -1;
        this.prefetchWindowStartLine = Integer.MAX_VALUE;
        this.prefetchWindowEndLine = Integer.MIN_VALUE;
    }

    private final void scheduleNextItemIfNeeded(final CacheWindowScope r100) {
        if (Math.signum(this.previousPassDelta) > 0.0f) goto L8;
        if (this.prefetchWindowEndExtraSpace <= 0) goto L12;
        int r101 = this.prefetchWindowEndLine + 1;
    L13:
        if (r101 > 0) goto L15;
        return;
    L15:
        if (r100.getLastIndexInLine(r101) != (-1)) goto L17;
        return;
    L17:
        if (r100.getLastIndexInLine(r101) >= this.itemsCount) goto L22;
        this.prefetchWindowHandles.set(r101, r100.schedulePrefetch(r101, new c(this, r100)));
        return;
    L22:
        return;
    L12:
        r101 = -1;
        goto L13
    L8:
        if (Math.signum(this.previousPassDelta) <= 0.0f) goto L12;
        if (this.prefetchWindowStartExtraSpace <= 0) goto L12;
        r101 = this.prefetchWindowStartLine - 1;
        goto L13
    }

    public final void onVisibleItemsUpdated(CacheWindowScope r100) {
        boolean r101 = true;
        if (this.hasUpdatedVisibleItemsOnce == true) goto L11;
        LazyLayoutCacheWindow r102 = this.cacheWindow;
        Density r103 = r100.getDensity();
        if (r103 == null) goto L7;
        int r104 = r102.calculateAheadWindow(r103, r100.getMainAxisViewportSize());
    L8:
        if (r104 == 0) goto L10;
        this.shouldRefillWindow = true;
    L10:
        this.hasUpdatedVisibleItemsOnce = true;
        goto L11
    L7:
        r104 = 0;
    L11:
        int r105 = this.previousPassItemCount;
        if (r105 != (-1)) goto L14;
    L18:
        this.itemsCount = r100.getTotalItemsCount();
        if (r100.getHasVisibleItems() == false) goto L30;
        int r106 = r100.getVisibleLineCount();
        int r107 = 0;
    L21:
        if (r107 >= r106) goto L24;
        cacheVisibleItemsInfo(r100.getVisibleItemLine(r107), r100.getVisibleItemSize(r107));
        r107 = r107 + 1;
        goto L21
    L24:
        if (this.shouldRefillWindow == true) goto L26;
    L31:
        this.previousPassItemCount = r100.getTotalItemsCount();
        return;
    L26:
        if (this.previousPassDelta <= 0.0f) goto L29;
        r101 = false;
    L29:
        refillWindow(r100, r101);
        this.shouldRefillWindow = false;
        goto L31
    L30:
        resetStrategy();
        goto L31
    L14:
        if (r105 == r100.getTotalItemsCount()) goto L18;
        this.shouldRefillWindow = true;
        this.prefetchWindowStartLine = RangesKt.coerceAtLeast(this.prefetchWindowStartLine, 0);
        int r108 = r100.getLastLineIndex();
        if (r108 == (-1)) goto L18;
        this.prefetchWindowEndLine = RangesKt.coerceAtMost(this.prefetchWindowEndLine, r108);
        goto L18
    }

    private final void cachePrefetchedItem(int r100, int r101) {
        this.windowCache.set(r100, r101);
        if (r100 <= this.prefetchWindowEndLine) goto L6;
        this.prefetchWindowEndLine = r100;
        this.prefetchWindowEndExtraSpace -= r101;
        return;
    L6:
        if (r100 >= this.prefetchWindowStartLine) goto L10;
        this.prefetchWindowStartLine = r100;
        this.prefetchWindowStartExtraSpace -= r101;
        return;
    }

    private final void cacheVisibleItemsInfo(int r100, int r101) {
        if (this.windowCache.containsKey(r100) == true) goto L5;
    L7:
        this.windowCache.set(r100, r101);
        this.prefetchWindowStartLine = Math.min(this.prefetchWindowStartLine, r100);
        this.prefetchWindowEndLine = Math.max(this.prefetchWindowEndLine, r100);
        List<LazyLayoutPrefetchState.PrefetchHandle> r102 = this.prefetchWindowHandles.remove(r100);
        if (r102 == null) goto L12;
        int r103 = r102.size();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L14;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r102, r104)).cancel();
        r104 = r104 + 1;
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        if (this.windowCache.get(r100) == r101) goto L7;
        this.shouldRefillWindow = true;
        goto L7
    }

    private final void fillCacheWindowBackward(CacheWindowScope r110, float r111) {
        if (r110.getHasVisibleItems() == false) goto L10;
        int r100 = r110.getMainAxisViewportSize();
        LazyLayoutCacheWindow r101 = this.cacheWindow;
        Density r102 = r110.getDensity();
        if (r102 == null) goto L7;
        int r103 = r101.calculateBehindWindow(r102, r100);
    L8:
        this.itemsCount = r110.getTotalItemsCount();
        int r104 = r110.getFirstVisibleLineIndex();
        int r105 = r110.getLastVisibleLineIndex();
        int r106 = r110.getTotalItemsCount();
        int r107 = r110.getMainAxisExtraSpaceStart();
        onKeepAround(r104, r105, r110.getMainAxisExtraSpaceEnd(), r107, r103, r111, r106);
        return;
    L7:
        r103 = 0;
        goto L8
    }

    private final void fillCacheWindowForward(CacheWindowScope r110, float r111) {
        if (r110.getHasVisibleItems() == false) goto L14;
        int r100 = r110.getMainAxisViewportSize();
        LazyLayoutCacheWindow r101 = this.cacheWindow;
        Density r102 = r110.getDensity();
        if (r102 == null) goto L7;
        int r103 = r101.calculateAheadWindow(r102, r100);
    L8:
        int r104 = r110.getFirstVisibleLineIndex();
        int r105 = r110.getLastVisibleLineIndex();
        int r112 = r110.getMainAxisExtraSpaceStart();
        int r106 = r110.getMainAxisExtraSpaceEnd();
        if (r111 > 0.0f) goto L11;
        boolean r113 = true;
    L12:
        onPrefetchForward(r110, r104, r105, r103, r106, r112, r111, r113);
        return;
    L11:
        r113 = false;
        goto L12
    L7:
        r103 = 0;
        goto L8
    }

    private final void refillWindow(CacheWindowScope r110, boolean r111) {
        if (r110.getHasVisibleItems() == false) goto L10;
        int r100 = r110.getMainAxisViewportSize();
        LazyLayoutCacheWindow r101 = this.cacheWindow;
        Density r102 = r110.getDensity();
        if (r102 == null) goto L7;
        int r103 = r101.calculateAheadWindow(r102, r100);
    L8:
        int r104 = r110.getFirstVisibleLineIndex();
        int r105 = r110.getLastVisibleLineIndex();
        int r106 = r110.getMainAxisExtraSpaceStart();
        onPrefetchForward(r110, r104, r105, r103, r110.getMainAxisExtraSpaceEnd(), r106, 0.0f, r111);
        return;
    L7:
        r103 = 0;
        goto L8
    }

    private final void removeOutOfBoundsItems(int r210, int r211) {
        this.indicesToRemove.clear();
        MutableIntObjectMap<List<LazyLayoutPrefetchState.PrefetchHandle>> r100 = this.prefetchWindowHandles;
        int[] r101 = r100.keys;
        long[] r102 = r100.metadata;
        int r103 = r102.length - 2;
        char r110 = 7;
        long r111 = -9187201950435737472L;
        if (r103 < 0) goto L25;
        int r112 = 0;
    L5:
        long r104 = r102[r112];
        if (((((~r104) << 7) & r104) & r111) == r111) goto L23;
        int r105 = 8 - ((~(r112 - r103)) >>> 31);
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L22;
        if ((r104 & 255) >= 128) goto L12;
        boolean r212 = true;
    L13:
        if (r212 == false) goto L21;
        int r113 = r101[(r112 << 3) + r106];
        if (r210 > r113) goto L18;
        if (r113 > r211) goto L18;
        boolean r213 = true;
    L19:
        if (r213 == false) goto L21;
        this.indicesToRemove.add(r113);
    L18:
        r213 = false;
    L21:
        r104 = r104 >> 8;
        r106 = r106 + 1;
        goto L8
    L12:
        r212 = false;
        goto L13
    L22:
        if (r105 != 8) goto L25;
    L23:
        if (r112 == r103) goto L25;
        r112 = r112 + 1;
        r111 = -9187201950435737472L;
    L25:
        MutableIntIntMap r107 = this.windowCache;
        int[] r108 = r107.keys;
        long[] r109 = r107.metadata;
        int r114 = r109.length - 2;
        if (r114 < 0) goto L48;
        int r115 = 0;
    L28:
        long r116 = r109[r115];
        if (((((~r116) << 7) & r116) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L46;
        int r117 = 8 - ((~(r115 - r114)) >>> 31);
        int r118 = 0;
    L31:
        if (r118 >= r117) goto L45;
        if ((r116 & 255) >= 128) goto L35;
        boolean r119 = true;
    L36:
        if (r119 == false) goto L44;
        int r120 = r108[(r115 << 3) + r118];
        if (r210 > r120) goto L41;
        if (r120 > r211) goto L41;
        boolean r121 = true;
    L42:
        if (r121 == false) goto L44;
        this.indicesToRemove.add(r120);
    L41:
        r121 = false;
    L44:
        r116 = r116 >> 8;
        r118 = r118 + 1;
        goto L31
    L35:
        r119 = false;
        goto L36
    L45:
        if (r117 != 8) goto L48;
    L46:
        if (r115 == r114) goto L48;
        r115 = r115 + 1;
    L48:
        MutableIntSet r122 = this.indicesToRemove;
        int[] r123 = r122.elements;
        long[] r124 = r122.metadata;
        int r125 = r124.length - 2;
        if (r125 < 0) goto L73;
        int r126 = 0;
    L51:
        long r127 = r124[r126];
        if (((((~r127) << r110) & r127) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L71;
        int r128 = 8 - ((~(r126 - r125)) >>> 31);
        int r129 = 0;
    L54:
        if (r129 >= r128) goto L68;
        if ((r127 & 255) >= 128) goto L58;
        boolean r130 = true;
    L59:
        if (r130 == false) goto L66;
        int r131 = r123[(r126 << 3) + r129];
        List<LazyLayoutPrefetchState.PrefetchHandle> r132 = this.prefetchWindowHandles.remove(r131);
        if (r132 == null) goto L65;
        int r133 = r132.size();
        int r134 = 0;
    L63:
        if (r134 >= r133) goto L65;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r132, r134)).cancel();
        r134 = r134 + 1;
    L65:
        this.windowCache.remove(r131);
    L66:
        r127 = r127 >> 8;
        r129 = r129 + 1;
        goto L54
    L58:
        r130 = false;
        goto L59
    L68:
        if (r128 == 8) goto L71;
        return;
    L71:
        if (r126 == r125) goto L93;
        r126 = r126 + 1;
        r110 = 7;
        goto L51
    L93:
        return;
    }

    public final void onScroll(CacheWindowScope r100, float r101) {
        traceWindowInfo();
        fillCacheWindowBackward(r100, r101);
        fillCacheWindowForward(r100, r101);
        this.previousPassDelta = r101;
        traceWindowInfo();
    }

    private final int getItemSizeOrPrefetch(final CacheWindowScope r100, int r101, boolean r102) {
        if (this.windowCache.containsKey(r101) == true) goto L24;
        int r103 = 0;
        if (this.prefetchWindowHandles.containsKey(r101) == false) goto L13;
        if (r102 == false) goto L20;
        List<LazyLayoutPrefetchState.PrefetchHandle> r104 = this.prefetchWindowHandles.get(r101);
        if (r104 == null) goto L20;
        int r105 = r104.size();
    L11:
        if (r103 >= r105) goto L20;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r104, r103)).markAsUrgent();
        r103 = r103 + 1;
    L20:
        return -1;
    L13:
        this.prefetchWindowHandles.set(r101, r100.schedulePrefetch(r101, new b(this, r100)));
        if (r102 == false) goto L20;
        List<LazyLayoutPrefetchState.PrefetchHandle> r106 = this.prefetchWindowHandles.get(r101);
        if (r106 == null) goto L20;
        int r107 = r106.size();
    L18:
        if (r103 >= r107) goto L20;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r106, r103)).markAsUrgent();
        r103 = r103 + 1;
        goto L18
    L24:
        return this.windowCache.get(r101);
    }

    private final void onItemPrefetched(CacheWindowScope r100, int r101, int r102) {
        cachePrefetchedItem(r101, r102);
        scheduleNextItemIfNeeded(r100);
        traceWindowInfo();
    }

    private static final Unit getItemSizeOrPrefetch$lambda$8(CacheWindowLogic r100, CacheWindowScope r101, int r102, int r103) {
        r100.onItemPrefetched(r101, r102, r103);
        return Unit.INSTANCE;
    }

    private static final Unit scheduleNextItemIfNeeded$lambda$15(CacheWindowLogic r100, CacheWindowScope r101, int r102, int r103) {
        r100.onItemPrefetched(r101, r102, r103);
        return Unit.INSTANCE;
    }

    private final void onKeepAround(int r100, int r101, int r102, int r103, int r104, float r105, int r106) {
        if (r105 > 0.0f) goto L13;
        this.prefetchWindowStartExtraSpace = r104 - r103;
        this.prefetchWindowStartLine = r100;
    L6:
        if (this.prefetchWindowStartExtraSpace <= 0) goto L12;
        int r107 = this.prefetchWindowStartLine;
        if (r107 <= 0) goto L12;
        if (this.windowCache.containsKey(r107 - 1) == false) goto L12;
        int r108 = this.windowCache.get(this.prefetchWindowStartLine - 1);
        this.prefetchWindowStartLine--;
        this.prefetchWindowStartExtraSpace -= r108;
    L12:
        removeOutOfBoundsItems(0, this.prefetchWindowStartLine - 1);
        return;
    L13:
        this.prefetchWindowEndExtraSpace = r104 - r102;
        this.prefetchWindowEndLine = r101;
    L15:
        if (this.prefetchWindowEndExtraSpace <= 0) goto L21;
        int r109 = this.prefetchWindowEndLine;
        if (r109 >= (r106 - 1)) goto L21;
        if (this.windowCache.containsKey(r109 + 1) == false) goto L21;
        int r110 = this.windowCache.get(this.prefetchWindowEndLine + 1);
        this.prefetchWindowEndLine++;
        this.prefetchWindowEndExtraSpace -= r110;
    L21:
        removeOutOfBoundsItems(this.prefetchWindowEndLine + 1, r106 - 1);
    }

    private final void onPrefetchForward(CacheWindowScope r100, int r101, int r102, int r103, int r104, int r110, float r111, boolean r112) {
        if (Math.signum(r111) != Math.signum(this.previousPassDelta)) goto L5;
        boolean r105 = true;
    L6:
        boolean r106 = !r105;
        if (r112 == false) goto L29;
        if (r106 == false) goto L10;
    L13:
        this.prefetchWindowEndExtraSpace = r103 - r104;
        this.prefetchWindowEndLine = r102;
    L15:
        if (this.prefetchWindowEndExtraSpace <= 0) goto L48;
        if (r100.getLastIndexInLine(this.prefetchWindowEndLine) == (-1)) goto L58;
        if (r100.getLastIndexInLine(this.prefetchWindowEndLine) >= (this.itemsCount - 1)) goto L59;
        if ((this.prefetchWindowEndLine + 1) == (r102 + 1)) goto L23;
    L25:
        boolean r107 = false;
    L26:
        int r108 = getItemSizeOrPrefetch(r100, this.prefetchWindowEndLine + 1, r107);
        if (r108 == (-1)) goto L60;
        this.prefetchWindowEndLine++;
        this.prefetchWindowEndExtraSpace -= r108;
        goto L15
    L60:
        return;
    L23:
        if (Math.abs(r111) < r104) goto L25;
        r107 = true;
        goto L26
    L59:
        return;
    L58:
        return;
    L48:
        return;
    L10:
        if (this.shouldRefillWindow == true) goto L13;
        this.prefetchWindowEndExtraSpace += MathKt.roundToInt(Math.abs(r111));
        goto L15
    L29:
        if (r106 == false) goto L31;
    L34:
        this.prefetchWindowStartExtraSpace = r103 - r110;
        this.prefetchWindowStartLine = r101;
    L36:
        if (this.prefetchWindowStartExtraSpace <= 0) goto L61;
        int r109 = this.prefetchWindowStartLine;
        if (r109 <= 0) goto L62;
        if ((r109 - 1) == (r101 - 1)) goto L42;
    L44:
        boolean r113 = false;
    L45:
        int r114 = getItemSizeOrPrefetch(r100, this.prefetchWindowStartLine - 1, r113);
        if (r114 == (-1)) goto L63;
        this.prefetchWindowStartLine--;
        this.prefetchWindowStartExtraSpace -= r114;
        goto L36
    L63:
        return;
    L42:
        if (Math.abs(r111) < r110) goto L44;
        r113 = true;
        goto L45
    L62:
        return;
    L61:
        return;
    L31:
        if (this.shouldRefillWindow == true) goto L34;
        this.prefetchWindowStartExtraSpace += MathKt.roundToInt(Math.abs(r111));
        goto L36
    L5:
        r105 = false;
        goto L6
    }
}
