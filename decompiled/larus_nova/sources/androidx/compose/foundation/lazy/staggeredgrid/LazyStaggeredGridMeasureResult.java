package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Density;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u00ad\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0018\u0010I\u001a\u0004\u0018\u00010\u00002\u0006\u0010J\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u000bJ\t\u0010L\u001a\u00020MH\u0096\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010-R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0016\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0014\u0010\u001b\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00106R\u0014\u0010\u001c\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00106R\u0014\u0010\u001d\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00106R\u0014\u0010\u001e\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00106R\u0014\u0010\u001f\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00106R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bD\u0010-R\u0014\u0010E\u001a\u00020FX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001e\u0010N\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00150OX\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0012\u0010S\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u00106R'\u0010U\u001a\u0015\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020M\u0018\u00010V¢\u0006\u0002\bX8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0012\u0010[\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u00106¨\u0006]"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItemIndices", "", "firstVisibleItemScrollOffsets", "consumedScroll", "", "measureResult", "scrollBackAmount", "canScrollForward", "", "isVertical", "remeasureNeeded", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "density", "Landroidx/compose/ui/unit/Density;", "totalItemsCount", "", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "viewportStartOffset", "viewportEndOffset", "beforeContentPadding", "afterContentPadding", "mainAxisItemSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "([I[IFLandroidx/compose/ui/layout/MeasureResult;FZZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;Landroidx/compose/ui/unit/Density;ILjava/util/List;JIIIIILkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstVisibleItemIndices", "()[I", "getFirstVisibleItemScrollOffsets", "getConsumedScroll", "()F", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "getScrollBackAmount", "getCanScrollForward", "()Z", "getRemeasureNeeded", "getSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getSpanProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getTotalItemsCount", "()I", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportSize-YbymL2g", "()J", "J", "getViewportStartOffset", "getViewportEndOffset", "getBeforeContentPadding", "getAfterContentPadding", "getMainAxisItemSpacing", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "canScrollBackward", "getCanScrollBackward", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "copyWithScrollDeltaWithoutRemeasure", "delta", "updateAnimations", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridMeasureResult implements LazyStaggeredGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final boolean canScrollForward;
    private final float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final int[] firstVisibleItemIndices;
    private final int[] firstVisibleItemScrollOffsets;
    private final boolean isVertical;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final float scrollBackAmount;
    private final LazyStaggeredGridSlots slots;
    private final LazyStaggeredGridSpanProvider spanProvider;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final long viewportSize;
    private final int viewportStartOffset;
    private final List<LazyStaggeredGridMeasuredItem> visibleItemsInfo;

    public /* synthetic */ LazyStaggeredGridMeasureResult(int[] r100, int[] r101, float r102, MeasureResult r103, float r104, boolean r105, boolean r106, boolean r107, LazyStaggeredGridSlots r108, LazyStaggeredGridSpanProvider r110, Density r111, int r112, List r113, long r114, int r115, int r116, int r117, int r118, int r210, CoroutineScope r211, DefaultConstructorMarker r212) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211);
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.measureResult.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1<RulerScope, Unit> getRulers() {
        return this.measureResult.getRulers();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.measureResult.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void placeChildren() {
        this.measureResult.placeChildren();
    }

    public final boolean getCanScrollBackward() {
        if (this.firstVisibleItemIndices[0] == 0) goto L5;
    L6:
        return true;
    L5:
        if (this.firstVisibleItemScrollOffsets[0] > 0) goto L6;
        return false;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final int[] getFirstVisibleItemIndices() {
        return this.firstVisibleItemIndices;
    }

    public final int[] getFirstVisibleItemScrollOffsets() {
        return this.firstVisibleItemScrollOffsets;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final MeasureResult getMeasureResult() {
        return this.measureResult;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
    }

    public final LazyStaggeredGridSlots getSlots() {
        return this.slots;
    }

    public final LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.spanProvider;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo938getViewportSizeYbymL2g() {
        return this.viewportSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public List<LazyStaggeredGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final LazyStaggeredGridMeasureResult copyWithScrollDeltaWithoutRemeasure(int r310, boolean r311) {
        if (this.remeasureNeeded == false) goto L5;
    L71:
        return null;
    L5:
        if (getVisibleItemsInfo().isEmpty() == true) goto L71;
        if (this.firstVisibleItemIndices.length != 0) goto L9;
        boolean r100 = true;
    L10:
        if (r100 == true) goto L71;
        if (this.firstVisibleItemScrollOffsets.length != 0) goto L14;
        boolean r101 = true;
    L15:
        if (r101 == true) goto L71;
        int r102 = getViewportEndOffset() - getAfterContentPadding();
        List<LazyStaggeredGridMeasuredItem> r103 = getVisibleItemsInfo();
        int r104 = r103.size();
        int r105 = 0;
    L18:
        if (r105 >= r104) goto L57;
        LazyStaggeredGridMeasuredItem r106 = (LazyStaggeredGridMeasuredItem) ListProtector.get(r103, r105);
        if (r106.getNonScrollableItem() == true) goto L56;
        if (r106.getMainAxisOffset() > 0) goto L24;
        boolean r110 = true;
    L26:
        if ((r106.getMainAxisOffset() + r310) > 0) goto L28;
        boolean r111 = true;
    L29:
        if (r110 != r111) goto L56;
        if (r106.getMainAxisOffset() > getViewportStartOffset()) goto L44;
        if (r310 >= 0) goto L38;
        if (((r106.getMainAxisOffset() + r106.getMainAxisSizeWithSpacings()) - getViewportStartOffset()) > (-r310)) goto L39;
    L40:
        boolean r112 = false;
    L41:
        if (r112 == true) goto L44;
        return null;
    L39:
        r112 = true;
        goto L41
    L38:
        if ((getViewportStartOffset() - r106.getMainAxisOffset()) <= r310) goto L40;
    L44:
        if ((r106.getMainAxisOffset() + r106.getMainAxisSizeWithSpacings()) < r102) goto L55;
        if (r310 >= 0) goto L50;
        if (((r106.getMainAxisOffset() + r106.getMainAxisSizeWithSpacings()) - getViewportEndOffset()) > (-r310)) goto L51;
    L52:
        boolean r107 = false;
    L53:
        if (r107 == true) goto L55;
        return null;
    L51:
        r107 = true;
        goto L53
    L50:
        if ((getViewportEndOffset() - r106.getMainAxisOffset()) <= r310) goto L52;
    L55:
        r105 = r105 + 1;
        goto L18
    L28:
        r111 = false;
        goto L29
    L24:
        r110 = false;
    L56:
        return null;
    L57:
        List<LazyStaggeredGridMeasuredItem> r108 = getVisibleItemsInfo();
        int r109 = r108.size();
        int r113 = 0;
    L58:
        if (r113 >= r109) goto L60;
        ((LazyStaggeredGridMeasuredItem) ListProtector.get(r108, r113)).applyScrollDelta(r310, r311);
        r113 = r113 + 1;
        goto L58
    L60:
        int[] r114 = this.firstVisibleItemIndices;
        int r115 = this.firstVisibleItemScrollOffsets.length;
        int[] r116 = new int[r115];
        int r117 = 0;
    L61:
        if (r117 >= r115) goto L63;
        r116[r117] = this.firstVisibleItemScrollOffsets[r117] - r310;
        r117 = r117 + 1;
        goto L61
    L63:
        float r118 = r310;
        float r119 = this.scrollBackAmount;
        MeasureResult r120 = this.measureResult;
        if (this.canScrollForward == true) goto L68;
        if (r310 > 0) goto L68;
        boolean r121 = false;
    L70:
        return new LazyStaggeredGridMeasureResult(r114, r116, r118, r120, r119, r121, this.isVertical, this.remeasureNeeded, this.slots, this.spanProvider, this.density, getTotalItemsCount(), getVisibleItemsInfo(), mo938getViewportSizeYbymL2g(), getViewportStartOffset(), getViewportEndOffset(), getBeforeContentPadding(), getAfterContentPadding(), getMainAxisItemSpacing(), this.coroutineScope, null);
    L68:
        r121 = true;
        goto L70
    L14:
        r101 = false;
        goto L15
    L9:
        r100 = false;
        goto L10
    }

    private LazyStaggeredGridMeasureResult(int[] r100, int[] r101, float r102, MeasureResult r103, float r104, boolean r110, boolean r111, boolean r112, LazyStaggeredGridSlots r113, LazyStaggeredGridSpanProvider r114, Density r115, int r116, List<LazyStaggeredGridMeasuredItem> r117, long r118, int r210, int r211, int r212, int r213, int r214, CoroutineScope r215) {
        this.firstVisibleItemIndices = r100;
        this.firstVisibleItemScrollOffsets = r101;
        this.consumedScroll = r102;
        this.measureResult = r103;
        this.scrollBackAmount = r104;
        this.canScrollForward = r110;
        this.isVertical = r111;
        this.remeasureNeeded = r112;
        this.slots = r113;
        this.spanProvider = r114;
        this.density = r115;
        this.totalItemsCount = r116;
        this.visibleItemsInfo = r117;
        this.viewportSize = r118;
        this.viewportStartOffset = r210;
        this.viewportEndOffset = r211;
        this.beforeContentPadding = r212;
        this.afterContentPadding = r213;
        this.mainAxisItemSpacing = r214;
        this.coroutineScope = r215;
        if (r111 == false) goto L5;
        Orientation r105 = Orientation.Vertical;
    L6:
        this.orientation = r105;
        return;
    L5:
        r105 = Orientation.Horizontal;
        goto L6
    }
}
