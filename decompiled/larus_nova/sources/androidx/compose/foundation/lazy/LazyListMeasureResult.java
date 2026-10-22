package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Density;
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
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u009f\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010B\u001a\u0004\u0018\u00010\u00002\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\bJ\t\u0010E\u001a\u00020FH\u0096\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\u000b\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0012\u001a\u00020\u0013¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u0010\u0016\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0014\u0010\u0017\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0014\u0010\u0018\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0014\u0010\u0019\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0014\u0010\u001c\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u0014\u0010\u001d\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0011\u0010;\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b<\u0010%R\u0014\u0010=\u001a\u00020>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010/R\u0014\u0010@\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010#R\u001e\u0010G\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00060HX\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0012\u0010L\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\bM\u0010#R'\u0010N\u001a\u0015\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020F\u0018\u00010O¢\u0006\u0002\bQ8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0012\u0010T\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010#¨\u0006V"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "firstVisibleItemScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "scrollBackAmount", "remeasureNeeded", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "visibleItemsInfo", "", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "<init>", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;IZFLandroidx/compose/ui/layout/MeasureResult;FZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;JLjava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstVisibleItem", "()Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getFirstVisibleItemScrollOffset", "()I", "getCanScrollForward", "()Z", "getConsumedScroll", "()F", "getScrollBackAmount", "getRemeasureNeeded", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getChildConstraints-msEJaDk", "()J", "J", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportStartOffset", "getViewportEndOffset", "getTotalItemsCount", "getReverseLayout", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getAfterContentPadding", "getMainAxisItemSpacing", "canScrollBackward", "getCanScrollBackward", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "beforeContentPadding", "getBeforeContentPadding", "copyWithScrollDeltaWithoutRemeasure", "delta", "updateAnimations", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyListMeasureResult implements LazyListLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final boolean canScrollForward;
    private final long childConstraints;
    private final float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final LazyListMeasuredItem firstVisibleItem;
    private final int firstVisibleItemScrollOffset;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final float scrollBackAmount;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<LazyListMeasuredItem> visibleItemsInfo;

    public /* synthetic */ LazyListMeasureResult(LazyListMeasuredItem r100, int r101, boolean r102, float r103, MeasureResult r104, float r105, boolean r106, CoroutineScope r107, Density r108, long r110, List r111, int r112, int r113, int r114, boolean r115, Orientation r116, int r117, int r118, DefaultConstructorMarker r210) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118);
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
        LazyListMeasuredItem r100 = this.firstVisibleItem;
        if (r100 == null) goto L5;
        int r101 = r100.getIndex();
    L6:
        if (r101 == 0) goto L8;
    L9:
        return true;
    L8:
        if (this.firstVisibleItemScrollOffset != 0) goto L9;
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo832getViewportSizeYbymL2g() {
        int r100 = getWidth();
        long r101 = ((long) r100) << 32;
        return IntSize.m7714constructorimpl((((long) getHeight()) & BodyPartID.bodyIdMax) | r101);
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    /* JADX INFO: renamed from: getChildConstraints-msEJaDk, reason: not valid java name */
    public final long m837getChildConstraintsmsEJaDk() {
        return this.childConstraints;
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

    public final LazyListMeasuredItem getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.firstVisibleItemScrollOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public List<LazyListMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    public final LazyListMeasureResult copyWithScrollDeltaWithoutRemeasure(int r210, boolean r310) {
        LazyListMeasureResult r100 = null;
        if (this.remeasureNeeded == false) goto L5;
    L39:
        return r100;
    L5:
        if (getVisibleItemsInfo().isEmpty() == true) goto L39;
        LazyListMeasuredItem r101 = this.firstVisibleItem;
        if (r101 == null) goto L39;
        int r102 = r101.getMainAxisSizeWithSpacings();
        int r103 = this.firstVisibleItemScrollOffset - r210;
        if (r103 < 0) goto L12;
        if (r103 >= r102) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L39;
        LazyListMeasuredItem r105 = (LazyListMeasuredItem) CollectionsKt.first(getVisibleItemsInfo());
        LazyListMeasuredItem r106 = (LazyListMeasuredItem) CollectionsKt.last(getVisibleItemsInfo());
        if (r105.getNonScrollableItem() == true) goto L39;
        if (r106.getNonScrollableItem() == true) goto L39;
        if (r210 >= 0) goto L25;
        if (Math.min((r105.getOffset() + r105.getMainAxisSizeWithSpacings()) - getViewportStartOffset(), (r106.getOffset() + r106.getMainAxisSizeWithSpacings()) - getViewportEndOffset()) > (-r210)) goto L26;
    L27:
        boolean r107 = false;
    L28:
        if (r107 == false) goto L39;
        List<LazyListMeasuredItem> r108 = getVisibleItemsInfo();
        int r109 = r108.size();
        int r110 = 0;
    L30:
        if (r110 >= r109) goto L32;
        ((LazyListMeasuredItem) ListProtector.get(r108, r110)).applyScrollDelta(r210, r310);
        r110 = r110 + 1;
        goto L30
    L32:
        LazyListMeasuredItem r111 = this.firstVisibleItem;
        int r112 = this.firstVisibleItemScrollOffset - r210;
        if (this.canScrollForward == true) goto L37;
        if (r210 > 0) goto L37;
        boolean r113 = false;
    L38:
        r100 = new LazyListMeasureResult(r111, r112, r113, r210, this.measureResult, this.scrollBackAmount, this.remeasureNeeded, this.coroutineScope, this.density, this.childConstraints, getVisibleItemsInfo(), getViewportStartOffset(), getViewportEndOffset(), getTotalItemsCount(), getReverseLayout(), getOrientation(), getAfterContentPadding(), getMainAxisItemSpacing(), null);
    L37:
        r113 = true;
    L26:
        r107 = true;
        goto L28
    L25:
        if (Math.min(getViewportStartOffset() - r105.getOffset(), getViewportEndOffset() - r106.getOffset()) <= r210) goto L27;
    L12:
        r104 = false;
        goto L13
    }

    private LazyListMeasureResult(LazyListMeasuredItem r100, int r101, boolean r102, float r103, MeasureResult r104, float r105, boolean r110, CoroutineScope r111, Density r112, long r113, List<LazyListMeasuredItem> r114, int r115, int r116, int r117, boolean r118, Orientation r210, int r211, int r212) {
        this.firstVisibleItem = r100;
        this.firstVisibleItemScrollOffset = r101;
        this.canScrollForward = r102;
        this.consumedScroll = r103;
        this.measureResult = r104;
        this.scrollBackAmount = r105;
        this.remeasureNeeded = r110;
        this.coroutineScope = r111;
        this.density = r112;
        this.childConstraints = r113;
        this.visibleItemsInfo = r114;
        this.viewportStartOffset = r115;
        this.viewportEndOffset = r116;
        this.totalItemsCount = r117;
        this.reverseLayout = r118;
        this.orientation = r210;
        this.afterContentPadding = r211;
        this.mainAxisItemSpacing = r212;
    }
}
