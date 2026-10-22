package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B÷\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u00123\u0010\u0013\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a0\u00190\u00180\u0014\u0012!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0014\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020$\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\u0006\u0010&\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J\u0018\u0010O\u001a\u0004\u0018\u00010\u00002\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\bJ\t\u0010R\u001a\u00020SH\u0096\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u0010\u000b\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010,R>\u0010\u0013\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a0\u00190\u00180\u0014¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R,\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010\u001f\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010,R\u0014\u0010 \u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010,R\u0014\u0010!\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u0014\u0010\"\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0014\u0010#\u001a\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010%\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010,R\u0014\u0010&\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010,R\u0011\u0010E\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bF\u0010.R\u0014\u0010G\u001a\u00020H8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010,R\u0014\u0010M\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010,R\u001e\u0010T\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020\u00060UX\u0096\u0005¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0012\u0010Y\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010,R'\u0010[\u001a\u0015\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020S\u0018\u00010\u0014¢\u0006\u0002\b]8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b^\u00109R\u0012\u0010_\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\b`\u0010,¨\u0006a"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "firstVisibleLineScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "scrollBackAmount", "remeasureNeeded", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "slotsPerLine", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "lineIndexProvider", "itemIndex", "visibleItemsInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;IZFLandroidx/compose/ui/layout/MeasureResult;FZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;II)V", "getFirstVisibleLine", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getFirstVisibleLineScrollOffset", "()I", "getCanScrollForward", "()Z", "getConsumedScroll", "()F", "getScrollBackAmount", "getRemeasureNeeded", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getSlotsPerLine", "getPrefetchInfoRetriever", "()Lkotlin/jvm/functions/Function1;", "getLineIndexProvider", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportStartOffset", "getViewportEndOffset", "getTotalItemsCount", "getReverseLayout", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getAfterContentPadding", "getMainAxisItemSpacing", "canScrollBackward", "getCanScrollBackward", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "beforeContentPadding", "getBeforeContentPadding", "maxSpan", "getMaxSpan", "copyWithScrollDeltaWithoutRemeasure", "delta", "updateAnimations", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "width", "getWidth", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridMeasureResult implements LazyGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final boolean canScrollForward;
    private final float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final LazyGridMeasuredLine firstVisibleLine;
    private final int firstVisibleLineScrollOffset;
    private final Function1<Integer, Integer> lineIndexProvider;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final Function1<Integer, List<Pair<Integer, Constraints>>> prefetchInfoRetriever;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final float scrollBackAmount;
    private final int slotsPerLine;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<LazyGridMeasuredItem> visibleItemsInfo;

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
        LazyGridMeasuredLine r100 = this.firstVisibleLine;
        if (r100 == null) goto L5;
        int r101 = r100.getIndex();
    L6:
        if (r101 == 0) goto L8;
    L9:
        return true;
    L8:
        if (this.firstVisibleLineScrollOffset != 0) goto L9;
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo864getViewportSizeYbymL2g() {
        int r100 = getWidth();
        long r101 = ((long) r100) << 32;
        return IntSize.m7714constructorimpl((((long) getHeight()) & BodyPartID.bodyIdMax) | r101);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
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

    public final LazyGridMeasuredLine getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    public final int getFirstVisibleLineScrollOffset() {
        return this.firstVisibleLineScrollOffset;
    }

    public final Function1<Integer, Integer> getLineIndexProvider() {
        return this.lineIndexProvider;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getMaxSpan() {
        return this.slotsPerLine;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    public final Function1<Integer, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever() {
        return this.prefetchInfoRetriever;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
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
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public List<LazyGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    public final LazyGridMeasureResult copyWithScrollDeltaWithoutRemeasure(int r210, boolean r310) {
        if (this.remeasureNeeded == false) goto L5;
        return null;
    L5:
        if (getVisibleItemsInfo().isEmpty() == true) goto L42;
        LazyGridMeasuredLine r100 = this.firstVisibleLine;
        if (r100 == null) goto L43;
        int r101 = r100.getMainAxisSizeWithSpacings();
        int r102 = this.firstVisibleLineScrollOffset - r210;
        if (r102 < 0) goto L12;
        if (r102 >= r101) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L46;
        LazyGridMeasuredItem r104 = (LazyGridMeasuredItem) CollectionsKt.first(getVisibleItemsInfo());
        LazyGridMeasuredItem r105 = (LazyGridMeasuredItem) CollectionsKt.last(getVisibleItemsInfo());
        if (r104.getNonScrollableItem() == false) goto L18;
        return null;
    L18:
        if (r105.getNonScrollableItem() == true) goto L47;
        if (r210 >= 0) goto L25;
        if (Math.min((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r104, getOrientation()) + r104.getMainAxisSizeWithSpacings()) - getViewportStartOffset(), (LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r105, getOrientation()) + r105.getMainAxisSizeWithSpacings()) - getViewportEndOffset()) > (-r210)) goto L26;
    L27:
        boolean r106 = false;
    L28:
        if (r106 == false) goto L45;
        List<LazyGridMeasuredItem> r107 = getVisibleItemsInfo();
        int r108 = r107.size();
        int r109 = 0;
    L30:
        if (r109 >= r108) goto L32;
        ((LazyGridMeasuredItem) ListProtector.get(r107, r109)).applyScrollDelta(r210, r310);
        r109 = r109 + 1;
        goto L30
    L32:
        LazyGridMeasuredLine r110 = this.firstVisibleLine;
        int r111 = this.firstVisibleLineScrollOffset - r210;
        if (this.canScrollForward == true) goto L37;
        if (r210 > 0) goto L37;
        boolean r112 = false;
    L39:
        return new LazyGridMeasureResult(r110, r111, r112, r210, this.measureResult, this.scrollBackAmount, this.remeasureNeeded, this.coroutineScope, this.density, this.slotsPerLine, this.prefetchInfoRetriever, this.lineIndexProvider, getVisibleItemsInfo(), getViewportStartOffset(), getViewportEndOffset(), getTotalItemsCount(), getReverseLayout(), getOrientation(), getAfterContentPadding(), getMainAxisItemSpacing());
    L37:
        r112 = true;
        goto L39
    L45:
        return null;
    L26:
        r106 = true;
        goto L28
    L25:
        if (Math.min(getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r104, getOrientation()), getViewportEndOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r105, getOrientation())) <= r210) goto L27;
    L47:
        return null;
    L46:
        return null;
    L12:
        r103 = false;
        goto L13
    L43:
        return null;
    L42:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyGridMeasureResult(LazyGridMeasuredLine r100, int r101, boolean r102, float r103, MeasureResult r104, float r105, boolean r106, CoroutineScope r110, Density r111, int r112, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> r113, Function1<? super Integer, Integer> r114, List<LazyGridMeasuredItem> r115, int r116, int r117, int r118, boolean r119, Orientation r210, int r211, int r212) {
        this.firstVisibleLine = r100;
        this.firstVisibleLineScrollOffset = r101;
        this.canScrollForward = r102;
        this.consumedScroll = r103;
        this.measureResult = r104;
        this.scrollBackAmount = r105;
        this.remeasureNeeded = r106;
        this.coroutineScope = r110;
        this.density = r111;
        this.slotsPerLine = r112;
        this.prefetchInfoRetriever = r113;
        this.lineIndexProvider = r114;
        this.visibleItemsInfo = r115;
        this.viewportStartOffset = r116;
        this.viewportEndOffset = r117;
        this.totalItemsCount = r118;
        this.reverseLayout = r119;
        this.orientation = r210;
        this.afterContentPadding = r211;
        this.mainAxisItemSpacing = r212;
    }
}
