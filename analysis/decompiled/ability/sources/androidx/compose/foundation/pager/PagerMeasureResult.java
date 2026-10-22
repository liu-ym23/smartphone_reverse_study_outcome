package androidx.compose.foundation.pager;

import D7.v;
import S7.k;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BÁ\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!H\u0096\u0001¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010\b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b-\u0010,R\u001a\u0010\t\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b.\u0010,R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b0\u00101R\u001a\u0010\f\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b2\u0010,R\u001a\u0010\r\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010*\u001a\u0004\b3\u0010,R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u00104\u001a\u0004\b5\u00106R\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b7\u0010,R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u00108\u001a\u0004\b;\u0010:R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010*\u001a\u0004\bA\u0010,\"\u0004\bB\u0010CR\"\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u00104\u001a\u0004\bD\u00106\"\u0004\bE\u0010FR\u001a\u0010\u0018\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010\u001a\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\bJ\u00106R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\bK\u0010)R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\bL\u0010)R\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010M\u001a\u0004\bN\u0010OR \u0010T\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020\u00060P8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020\u00068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010,R\"\u0010[\u001a\u0010\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020!\u0018\u00010W8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010]\u001a\u00020\u00068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010,R\u001a\u0010a\u001a\u00020^8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010,R\u0011\u0010e\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bd\u00106\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, d2 = {"Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "visiblePagesInfo", "", "pageSize", "pageSpacing", "afterContentPadding", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "viewportStartOffset", "viewportEndOffset", "", "reverseLayout", "beyondViewportPageCount", "firstVisiblePage", "currentPage", "", "currentPageOffsetFraction", "firstVisiblePageScrollOffset", "canScrollForward", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "snapPosition", "measureResult", "remeasureNeeded", "extraPagesBefore", "extraPagesAfter", "Lm9/z;", "coroutineScope", AppAgent.CONSTRUCT, "(Ljava/util/List;IIILandroidx/compose/foundation/gestures/Orientation;IIZILandroidx/compose/foundation/pager/MeasuredPage;Landroidx/compose/foundation/pager/MeasuredPage;FIZLandroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/ui/layout/MeasureResult;ZLjava/util/List;Ljava/util/List;Lm9/z;)V", "LC7/r;", "placeChildren", "()V", "delta", "tryToApplyScrollWithoutRemeasure", "(I)Z", "Ljava/util/List;", "getVisiblePagesInfo", "()Ljava/util/List;", "I", "getPageSize", "()I", "getPageSpacing", "getAfterContentPadding", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getViewportStartOffset", "getViewportEndOffset", "Z", "getReverseLayout", "()Z", "getBeyondViewportPageCount", "Landroidx/compose/foundation/pager/MeasuredPage;", "getFirstVisiblePage", "()Landroidx/compose/foundation/pager/MeasuredPage;", "getCurrentPage", "F", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "getFirstVisiblePageScrollOffset", "setFirstVisiblePageScrollOffset", "(I)V", "getCanScrollForward", "setCanScrollForward", "(Z)V", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getSnapPosition", "()Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getRemeasureNeeded", "getExtraPagesBefore", "getExtraPagesAfter", "Lm9/z;", "getCoroutineScope", "()Lm9/z;", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "alignmentLines", "getHeight", "height", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "getRulers", "()LS7/k;", "rulers", "getWidth", "width", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "viewportSize", "getBeforeContentPadding", "beforeContentPadding", "getCanScrollBackward", "canScrollBackward", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private final int beyondViewportPageCount;
    private boolean canScrollForward;
    private final InterfaceC1733z coroutineScope;
    private final MeasuredPage currentPage;
    private float currentPageOffsetFraction;
    private final List<MeasuredPage> extraPagesAfter;
    private final List<MeasuredPage> extraPagesBefore;
    private final MeasuredPage firstVisiblePage;
    private int firstVisiblePageScrollOffset;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final SnapPosition snapPosition;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<MeasuredPage> visiblePagesInfo;

    public PagerMeasureResult(List<MeasuredPage> list, int i, int i6, int i10, Orientation orientation, int i11, int i12, boolean z10, int i13, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f, int i14, boolean z11, SnapPosition snapPosition, MeasureResult measureResult, boolean z12, List<MeasuredPage> list2, List<MeasuredPage> list3, InterfaceC1733z interfaceC1733z) {
        this.visiblePagesInfo = list;
        this.pageSize = i;
        this.pageSpacing = i6;
        this.afterContentPadding = i10;
        this.orientation = orientation;
        this.viewportStartOffset = i11;
        this.viewportEndOffset = i12;
        this.reverseLayout = z10;
        this.beyondViewportPageCount = i13;
        this.firstVisiblePage = measuredPage;
        this.currentPage = measuredPage2;
        this.currentPageOffsetFraction = f;
        this.firstVisiblePageScrollOffset = i14;
        this.canScrollForward = z11;
        this.snapPosition = snapPosition;
        this.remeasureNeeded = z12;
        this.extraPagesBefore = list2;
        this.extraPagesAfter = list3;
        this.coroutineScope = interfaceC1733z;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    public final boolean getCanScrollBackward() {
        MeasuredPage measuredPage = this.firstVisiblePage;
        return ((measuredPage != null ? measuredPage.getIndex() : 0) == 0 && this.firstVisiblePageScrollOffset == 0) ? false : true;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final InterfaceC1733z getCoroutineScope() {
        return this.coroutineScope;
    }

    public final MeasuredPage getCurrentPage() {
        return this.currentPage;
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction;
    }

    public final List<MeasuredPage> getExtraPagesAfter() {
        return this.extraPagesAfter;
    }

    public final List<MeasuredPage> getExtraPagesBefore() {
        return this.extraPagesBefore;
    }

    public final MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageScrollOffset() {
        return this.firstVisiblePageScrollOffset;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    /* renamed from: getHeight */
    public int get$h() {
        return this.$$delegate_0.get$h();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSize() {
        return this.pageSize;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSpacing() {
        return this.pageSpacing;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    /* renamed from: getRulers */
    public k get$rulers() {
        return this.$$delegate_0.get$rulers();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public SnapPosition getSnapPosition() {
        return this.snapPosition;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    /* renamed from: getViewportSize-YbymL2g */
    public long mo941getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(get$w(), get$h());
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public List<MeasuredPage> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
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

    public final void setCurrentPageOffsetFraction(float f) {
        this.currentPageOffsetFraction = f;
    }

    public final void setFirstVisiblePageScrollOffset(int i) {
        this.firstVisiblePageScrollOffset = i;
    }

    public final boolean tryToApplyScrollWithoutRemeasure(int delta) {
        int i;
        int pageSpacing = getPageSpacing() + getPageSize();
        if (!this.remeasureNeeded && !getVisiblePagesInfo().isEmpty() && this.firstVisiblePage != null && (i = this.firstVisiblePageScrollOffset - delta) >= 0 && i < pageSpacing) {
            float f = pageSpacing != 0 ? delta / pageSpacing : 0.0f;
            float f7 = this.currentPageOffsetFraction - f;
            if (this.currentPage != null && f7 < 0.5f && f7 > -0.5f) {
                MeasuredPage measuredPage = (MeasuredPage) v.A0(getVisiblePagesInfo());
                MeasuredPage measuredPage2 = (MeasuredPage) v.K0(getVisiblePagesInfo());
                if (delta >= 0 ? Math.min(getViewportStartOffset() - measuredPage.getOffset(), getViewportEndOffset() - measuredPage2.getOffset()) > delta : Math.min((measuredPage.getOffset() + pageSpacing) - getViewportStartOffset(), (measuredPage2.getOffset() + pageSpacing) - getViewportEndOffset()) > (-delta)) {
                    this.currentPageOffsetFraction -= f;
                    this.firstVisiblePageScrollOffset -= delta;
                    List<MeasuredPage> visiblePagesInfo = getVisiblePagesInfo();
                    int size = visiblePagesInfo.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        visiblePagesInfo.get(i6).applyScrollDelta(delta);
                    }
                    List<MeasuredPage> list = this.extraPagesBefore;
                    int size2 = list.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        list.get(i10).applyScrollDelta(delta);
                    }
                    List<MeasuredPage> list2 = this.extraPagesAfter;
                    int size3 = list2.size();
                    for (int i11 = 0; i11 < size3; i11++) {
                        list2.get(i11).applyScrollDelta(delta);
                    }
                    if (!this.canScrollForward && delta > 0) {
                        this.canScrollForward = true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public PagerMeasureResult(List list, int i, int i6, int i10, Orientation orientation, int i11, int i12, boolean z10, int i13, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f, int i14, boolean z11, SnapPosition snapPosition, MeasureResult measureResult, boolean z12, List list2, List list3, InterfaceC1733z interfaceC1733z, int i15, e eVar) {
        this(list, i, i6, i10, orientation, i11, i12, z10, i13, measuredPage, measuredPage2, f, i14, z11, snapPosition, measureResult, z12, (i15 & 131072) != 0 ? EmptyList.f4893a : list2, (i15 & 262144) != 0 ? EmptyList.f4893a : list3, interfaceC1733z);
    }
}
