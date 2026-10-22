package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BÁ\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010D\u001a\u0004\u0018\u00010\u00002\u0006\u0010E\u001a\u00020\u0007J\t\u0010F\u001a\u00020GH\u0096\u0001R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0014\u0010\t\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0014\u0010\r\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\u0010\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u000e\u0010\u0019\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010,R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010$R\u0011\u0010B\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bC\u0010,R\u001e\u0010H\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u00070IX\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0012\u0010M\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010$R'\u0010O\u001a\u0015\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020G\u0018\u00010P¢\u0006\u0002\bR8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0012\u0010U\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\bV\u0010$¨\u0006W"}, d2 = {"Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "pageSize", "", "pageSpacing", "afterContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "viewportStartOffset", "viewportEndOffset", "reverseLayout", "", "beyondViewportPageCount", "firstVisiblePage", "currentPage", "currentPageOffsetFraction", "", "firstVisiblePageScrollOffset", "canScrollForward", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "measureResult", "remeasureNeeded", "extraPagesBefore", "extraPagesAfter", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljava/util/List;IIILandroidx/compose/foundation/gestures/Orientation;IIZILandroidx/compose/foundation/pager/MeasuredPage;Landroidx/compose/foundation/pager/MeasuredPage;FIZLandroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/ui/layout/MeasureResult;ZLjava/util/List;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;)V", "getVisiblePagesInfo", "()Ljava/util/List;", "getPageSize", "()I", "getPageSpacing", "getAfterContentPadding", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getViewportStartOffset", "getViewportEndOffset", "getReverseLayout", "()Z", "getBeyondViewportPageCount", "getFirstVisiblePage", "()Landroidx/compose/foundation/pager/MeasuredPage;", "getCurrentPage", "getCurrentPageOffsetFraction", "()F", "getFirstVisiblePageScrollOffset", "getCanScrollForward", "getSnapPosition", "()Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getRemeasureNeeded", "getExtraPagesBefore", "getExtraPagesAfter", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "beforeContentPadding", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "copyWithScrollDeltaWithoutRemeasure", "delta", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beyondViewportPageCount;
    private final boolean canScrollForward;
    private final CoroutineScope coroutineScope;
    private final MeasuredPage currentPage;
    private final float currentPageOffsetFraction;
    private final List<MeasuredPage> extraPagesAfter;
    private final List<MeasuredPage> extraPagesBefore;
    private final MeasuredPage firstVisiblePage;
    private final int firstVisiblePageScrollOffset;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final SnapPosition snapPosition;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<MeasuredPage> visiblePagesInfo;

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
        MeasuredPage r100 = this.firstVisiblePage;
        if (r100 == null) goto L5;
        int r101 = r100.getIndex();
    L6:
        if (r101 == 0) goto L8;
    L9:
        return true;
    L8:
        if (this.firstVisiblePageScrollOffset != 0) goto L9;
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo977getViewportSizeYbymL2g() {
        int r100 = getWidth();
        long r101 = ((long) r100) << 32;
        return IntSize.m7714constructorimpl((((long) getHeight()) & BodyPartID.bodyIdMax) | r101);
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final CoroutineScope getCoroutineScope() {
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

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public SnapPosition getSnapPosition() {
        return this.snapPosition;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public List<MeasuredPage> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    public final PagerMeasureResult copyWithScrollDeltaWithoutRemeasure(int r310) {
        int r100 = getPageSize() + getPageSpacing();
        PagerMeasureResult r101 = null;
        if (this.remeasureNeeded == false) goto L5;
    L51:
        return r101;
    L5:
        if (getVisiblePagesInfo().isEmpty() == true) goto L51;
        if (this.firstVisiblePage == null) goto L51;
        int r102 = this.firstVisiblePageScrollOffset - r310;
        if (r102 < 0) goto L12;
        if (r102 >= r100) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L51;
        if (r100 == 0) goto L17;
        float r104 = r310 / r100;
    L18:
        float r105 = this.currentPageOffsetFraction - r104;
        if (this.currentPage == null) goto L51;
        if (r105 >= 0.5f) goto L51;
        if (r105 <= (-0.5f)) goto L51;
        MeasuredPage r106 = (MeasuredPage) CollectionsKt.first(getVisiblePagesInfo());
        MeasuredPage r107 = (MeasuredPage) CollectionsKt.last(getVisiblePagesInfo());
        if (r310 >= 0) goto L31;
        if (Math.min((r106.getOffset() + r100) - getViewportStartOffset(), (r107.getOffset() + r100) - getViewportEndOffset()) > (-r310)) goto L32;
    L33:
        boolean r108 = false;
    L34:
        if (r108 == false) goto L51;
        List<MeasuredPage> r109 = getVisiblePagesInfo();
        int r110 = r109.size();
        int r111 = 0;
    L36:
        if (r111 >= r110) goto L38;
        ((MeasuredPage) ListProtector.get(r109, r111)).applyScrollDelta(r310);
        r111 = r111 + 1;
        goto L36
    L38:
        List<MeasuredPage> r112 = this.extraPagesBefore;
        int r113 = r112.size();
        int r114 = 0;
    L39:
        if (r114 >= r113) goto L41;
        ((MeasuredPage) ListProtector.get(r112, r114)).applyScrollDelta(r310);
        r114 = r114 + 1;
        goto L39
    L41:
        List<MeasuredPage> r115 = this.extraPagesAfter;
        int r116 = r115.size();
        int r117 = 0;
    L42:
        if (r117 >= r116) goto L44;
        ((MeasuredPage) ListProtector.get(r115, r117)).applyScrollDelta(r310);
        r117 = r117 + 1;
        goto L42
    L44:
        List<MeasuredPage> r118 = getVisiblePagesInfo();
        int r119 = getPageSize();
        int r120 = getPageSpacing();
        int r121 = getAfterContentPadding();
        Orientation r122 = getOrientation();
        int r123 = getViewportStartOffset();
        int r124 = getViewportEndOffset();
        boolean r125 = getReverseLayout();
        int r126 = getBeyondViewportPageCount();
        MeasuredPage r127 = this.firstVisiblePage;
        MeasuredPage r128 = this.currentPage;
        float r210 = this.currentPageOffsetFraction - r104;
        int r211 = this.firstVisiblePageScrollOffset - r310;
        if (this.canScrollForward == true) goto L49;
        if (r310 > 0) goto L49;
        boolean r212 = false;
    L50:
        r101 = new PagerMeasureResult(r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r210, r211, r212, getSnapPosition(), this.measureResult, this.remeasureNeeded, this.extraPagesBefore, this.extraPagesAfter, this.coroutineScope);
    L49:
        r212 = true;
    L32:
        r108 = true;
        goto L34
    L31:
        if (Math.min(getViewportStartOffset() - r106.getOffset(), getViewportEndOffset() - r107.getOffset()) <= r310) goto L33;
    L17:
        r104 = 0.0f;
    L12:
        r103 = false;
        goto L13
    }

    public PagerMeasureResult(List<MeasuredPage> r100, int r101, int r102, int r103, Orientation r104, int r105, int r106, boolean r110, int r111, MeasuredPage r112, MeasuredPage r113, float r114, int r115, boolean r116, SnapPosition r117, MeasureResult r118, boolean r119, List<MeasuredPage> r210, List<MeasuredPage> r211, CoroutineScope r212) {
        this.visiblePagesInfo = r100;
        this.pageSize = r101;
        this.pageSpacing = r102;
        this.afterContentPadding = r103;
        this.orientation = r104;
        this.viewportStartOffset = r105;
        this.viewportEndOffset = r106;
        this.reverseLayout = r110;
        this.beyondViewportPageCount = r111;
        this.firstVisiblePage = r112;
        this.currentPage = r113;
        this.currentPageOffsetFraction = r114;
        this.firstVisiblePageScrollOffset = r115;
        this.canScrollForward = r116;
        this.snapPosition = r117;
        this.measureResult = r118;
        this.remeasureNeeded = r119;
        this.extraPagesBefore = r210;
        this.extraPagesAfter = r211;
        this.coroutineScope = r212;
    }

    public /* synthetic */ PagerMeasureResult(List r210, int r211, int r212, int r213, Orientation r214, int r215, int r216, boolean r310, int r311, MeasuredPage r312, MeasuredPage r313, float r314, int r315, boolean r316, SnapPosition r317, MeasureResult r318, boolean r319, List r410, List r411, CoroutineScope r412, int r413, DefaultConstructorMarker r414) {
        if ((r413 & 131072) == 0) goto L5;
        List r110 = CollectionsKt.emptyList();
    L7:
        if ((r413 & 262144) == 0) goto L9;
        List r217 = CollectionsKt.emptyList();
    L10:
        this(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r110, r217, r412);
        return;
    L9:
        r217 = r411;
        goto L10
    L5:
        r110 = r410;
        goto L7
    }
}
