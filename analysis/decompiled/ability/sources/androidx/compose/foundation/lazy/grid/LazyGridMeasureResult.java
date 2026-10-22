package androidx.compose.foundation.lazy.grid;

import S7.k;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B½\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012$\u0010\u0016\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u0012\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#H\u0096\u0001¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010+R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b;\u00103R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010\u0011\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\bB\u0010.R5\u0010\u0016\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0016\u0010C\u001a\u0004\bD\u0010ER \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010\u0019\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\bI\u0010.R\u001a\u0010\u001a\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\bJ\u0010.R\u001a\u0010\u001b\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\bK\u0010.R\u001a\u0010\u001c\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\bL\u00103R\u001a\u0010\u001e\u001a\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010M\u001a\u0004\bN\u0010OR\u001a\u0010\u001f\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\bP\u0010.R\u001a\u0010 \u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\bQ\u0010.R \u0010V\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00050R8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\u00058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bW\u0010.R\"\u0010[\u001a\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020#\u0018\u00010\u00128VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010ER\u0014\u0010]\u001a\u00020\u00058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010.R\u0011\u0010_\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b^\u00103R\u001a\u0010c\u001a\u00020`8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010.\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "firstVisibleLine", "", "firstVisibleLineScrollOffset", "", "canScrollForward", "", "consumedScroll", "measureResult", "remeasureNeeded", "Lm9/z;", "coroutineScope", "Landroidx/compose/ui/unit/Density;", "density", "slotsPerLine", "Lkotlin/Function1;", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "prefetchInfoRetriever", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "visibleItemsInfo", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "afterContentPadding", "mainAxisItemSpacing", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;IZFLandroidx/compose/ui/layout/MeasureResult;ZLm9/z;Landroidx/compose/ui/unit/Density;ILS7/k;Ljava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;II)V", "LC7/r;", "placeChildren", "()V", "delta", "tryToApplyScrollWithoutRemeasure", "(I)Z", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getFirstVisibleLine", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "I", "getFirstVisibleLineScrollOffset", "()I", "setFirstVisibleLineScrollOffset", "(I)V", "Z", "getCanScrollForward", "()Z", "setCanScrollForward", "(Z)V", "F", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getRemeasureNeeded", "Lm9/z;", "getCoroutineScope", "()Lm9/z;", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getSlotsPerLine", "LS7/k;", "getPrefetchInfoRetriever", "()LS7/k;", "Ljava/util/List;", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportStartOffset", "getViewportEndOffset", "getTotalItemsCount", "getReverseLayout", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getAfterContentPadding", "getMainAxisItemSpacing", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "alignmentLines", "getHeight", "height", "Landroidx/compose/ui/layout/RulerScope;", "getRulers", "rulers", "getWidth", "width", "getCanScrollBackward", "canScrollBackward", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "viewportSize", "getBeforeContentPadding", "beforeContentPadding", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasureResult implements LazyGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final InterfaceC1733z coroutineScope;
    private final Density density;
    private final LazyGridMeasuredLine firstVisibleLine;
    private int firstVisibleLineScrollOffset;
    private final int mainAxisItemSpacing;
    private final Orientation orientation;
    private final k prefetchInfoRetriever;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final int slotsPerLine;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<LazyGridMeasuredItem> visibleItemsInfo;

    public LazyGridMeasureResult(LazyGridMeasuredLine lazyGridMeasuredLine, int i, boolean z10, float f, MeasureResult measureResult, boolean z11, InterfaceC1733z interfaceC1733z, Density density, int i6, k kVar, List<LazyGridMeasuredItem> list, int i10, int i11, int i12, boolean z12, Orientation orientation, int i13, int i14) {
        this.firstVisibleLine = lazyGridMeasuredLine;
        this.firstVisibleLineScrollOffset = i;
        this.canScrollForward = z10;
        this.consumedScroll = f;
        this.remeasureNeeded = z11;
        this.coroutineScope = interfaceC1733z;
        this.density = density;
        this.slotsPerLine = i6;
        this.prefetchInfoRetriever = kVar;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i10;
        this.viewportEndOffset = i11;
        this.totalItemsCount = i12;
        this.reverseLayout = z12;
        this.orientation = orientation;
        this.afterContentPadding = i13;
        this.mainAxisItemSpacing = i14;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean getCanScrollBackward() {
        LazyGridMeasuredLine lazyGridMeasuredLine = this.firstVisibleLine;
        return ((lazyGridMeasuredLine != null ? lazyGridMeasuredLine.getIndex() : 0) == 0 && this.firstVisibleLineScrollOffset == 0) ? false : true;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final InterfaceC1733z getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final LazyGridMeasuredLine getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    public final int getFirstVisibleLineScrollOffset() {
        return this.firstVisibleLineScrollOffset;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    /* renamed from: getHeight */
    public int get$h() {
        return this.$$delegate_0.get$h();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    public final k getPrefetchInfoRetriever() {
        return this.prefetchInfoRetriever;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    /* renamed from: getRulers */
    public k get$rulers() {
        return this.$$delegate_0.get$rulers();
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    /* renamed from: getViewportSize-YbymL2g */
    public long mo840getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(get$w(), get$h());
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public List<LazyGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    /* renamed from: getWidth */
    public int get$w() {
        return this.$$delegate_0.get$w();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    public final void setCanScrollForward(boolean z10) {
        this.canScrollForward = z10;
    }

    public final void setConsumedScroll(float f) {
        this.consumedScroll = f;
    }

    public final void setFirstVisibleLineScrollOffset(int i) {
        this.firstVisibleLineScrollOffset = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean tryToApplyScrollWithoutRemeasure(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.remeasureNeeded
            r1 = 0
            if (r0 != 0) goto Lb5
            java.util.List r0 = r5.getVisibleItemsInfo()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb5
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r0 = r5.firstVisibleLine
            if (r0 == 0) goto Lb5
            int r0 = r0.getMainAxisSizeWithSpacings()
            int r2 = r5.firstVisibleLineScrollOffset
            int r2 = r2 - r6
            if (r2 < 0) goto Lb5
            if (r2 >= r0) goto Lb5
            java.util.List r0 = r5.getVisibleItemsInfo()
            java.lang.Object r0 = D7.v.A0(r0)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r0 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r0
            java.util.List r2 = r5.getVisibleItemsInfo()
            java.lang.Object r2 = D7.v.K0(r2)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r2 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r2
            boolean r3 = r0.getNonScrollableItem()
            if (r3 != 0) goto Lb5
            boolean r3 = r2.getNonScrollableItem()
            if (r3 == 0) goto L40
            goto Lb5
        L40:
            if (r6 >= 0) goto L6e
            androidx.compose.foundation.gestures.Orientation r3 = r5.getOrientation()
            int r3 = androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r0, r3)
            int r0 = r0.getMainAxisSizeWithSpacings()
            int r0 = r0 + r3
            int r3 = r5.getViewportStartOffset()
            int r0 = r0 - r3
            androidx.compose.foundation.gestures.Orientation r3 = r5.getOrientation()
            int r3 = androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r2, r3)
            int r2 = r2.getMainAxisSizeWithSpacings()
            int r2 = r2 + r3
            int r3 = r5.getViewportEndOffset()
            int r2 = r2 - r3
            int r0 = java.lang.Math.min(r0, r2)
            int r2 = -r6
            if (r0 <= r2) goto Lb5
            goto L8e
        L6e:
            int r3 = r5.getViewportStartOffset()
            androidx.compose.foundation.gestures.Orientation r4 = r5.getOrientation()
            int r0 = androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r0, r4)
            int r3 = r3 - r0
            int r0 = r5.getViewportEndOffset()
            androidx.compose.foundation.gestures.Orientation r4 = r5.getOrientation()
            int r2 = androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r2, r4)
            int r0 = r0 - r2
            int r0 = java.lang.Math.min(r3, r0)
            if (r0 <= r6) goto Lb5
        L8e:
            int r0 = r5.firstVisibleLineScrollOffset
            int r0 = r0 - r6
            r5.firstVisibleLineScrollOffset = r0
            java.util.List r0 = r5.getVisibleItemsInfo()
            int r2 = r0.size()
        L9b:
            if (r1 >= r2) goto La9
            java.lang.Object r3 = r0.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r3 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r3
            r3.applyScrollDelta(r6)
            int r1 = r1 + 1
            goto L9b
        La9:
            float r0 = (float) r6
            r5.consumedScroll = r0
            boolean r0 = r5.canScrollForward
            r1 = 1
            if (r0 != 0) goto Lb5
            if (r6 <= 0) goto Lb5
            r5.canScrollForward = r1
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureResult.tryToApplyScrollWithoutRemeasure(int):boolean");
    }
}
