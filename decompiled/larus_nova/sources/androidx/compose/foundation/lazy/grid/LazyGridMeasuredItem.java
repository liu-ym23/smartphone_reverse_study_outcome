package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u00103\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0017\u0010>\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010@J(\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0004H\u0016J6\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020F2\u0006\u00100\u001a\u00020\u0004J\u0016\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\bJ\u0016\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\bJ(\u0010W\u001a\u00020\u0014*\u00020\u00142\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040YH\u0082\b¢\u0006\u0004\bZ\u0010[R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\"R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010'R\u0014\u0010\u001a\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0014\u0010\u001b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010*\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0014\u0010,\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0014\u0010.\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001fR\u000e\u00100\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\u000205X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b6\u0010'R \u00108\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0014@RX\u0096\u000e¢\u0006\n\n\u0002\u0010$\u001a\u0004\b9\u0010'R\u001e\u0010:\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001fR\u001e\u0010<\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u001fR\u001a\u0010A\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\"\"\u0004\bC\u0010DR\u0018\u0010S\u001a\u00020\u0004*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0018\u0010*\u001a\u00020\u0004*\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010V¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "isVertical", "", "crossAxisSize", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lane", "span", "<init>", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "()Z", "getCrossAxisSize", "J", "getContentType", "getConstraints-msEJaDk", "()J", "getLane", "getSpan", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "placeablesCount", "getPlaceablesCount", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "getParentData", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "value", "offset", "getOffset-nOcc-ac", SlcFlexDirection.FLEX_ROW, "getRow", "column", "getColumn", "getOffset", "getOffset-Bjo55l4", "(I)J", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "position", "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "updateMainAxisLayoutSize", "applyScrollDelta", "delta", "updateAnimations", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridMeasuredItem implements LazyGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private int column;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final int span;
    private final long visualOffset;

    public /* synthetic */ LazyGridMeasuredItem(int r100, Object r101, boolean r102, int r103, int r104, boolean r105, LayoutDirection r106, int r107, int r108, List r110, long r111, Object r112, LazyLayoutItemAnimator r113, long r114, int r115, int r116, DefaultConstructorMarker r117) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public long mo840getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac */
    public long mo861getOffsetnOccac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo862getSizeYbymL2g() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean isVertical() {
        return this.isVertical;
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m867getMainAxisgyyYBs(long r100) {
        if (isVertical() == false) goto L6;
        return IntOffset.m7677getYimpl(r100);
    L6:
        return IntOffset.m7676getXimpl(r100);
    }

    private final int getMainAxisSize(Placeable r100) {
        if (isVertical() == false) goto L6;
        return r100.getHeight();
    L6:
        return r100.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4 */
    public long mo841getOffsetBjo55l4(int r100) {
        return mo861getOffsetnOccac();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int r100) {
        return ((Placeable) ListProtector.get(this.placeables, r100)).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean r100) {
        this.nonScrollableItem = r100;
    }

    public final void updateMainAxisLayoutSize(int r100) {
        this.mainAxisLayoutSize = r100;
        this.maxMainAxisOffset = r100 + this.afterContentPadding;
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m866copy4Tuh3kE(long r100, Function1<? super Integer, Integer> r101) {
        if (isVertical() == false) goto L5;
        int r102 = IntOffset.m7676getXimpl(r100);
    L6:
        boolean r103 = isVertical();
        int r104 = IntOffset.m7677getYimpl(r100);
        if (r103 == false) goto L10;
        r104 = r101.invoke(Integer.valueOf(r104)).intValue();
    L10:
        return IntOffset.m7670constructorimpl((((long) r102) << 32) | (((long) r104) & BodyPartID.bodyIdMax));
    L5:
        r102 = r101.invoke(Integer.valueOf(IntOffset.m7676getXimpl(r100))).intValue();
        goto L6
    }

    public final void applyScrollDelta(int r110, boolean r111) {
        if (getNonScrollableItem() == false) goto L5;
        return;
    L5:
        long r100 = mo861getOffsetnOccac();
        if (isVertical() == false) goto L8;
        int r101 = IntOffset.m7676getXimpl(r100);
    L9:
        boolean r102 = isVertical();
        int r103 = IntOffset.m7677getYimpl(r100);
        if (r102 == false) goto L12;
        r103 = r103 + r110;
    L12:
        this.offset = IntOffset.m7670constructorimpl((((long) r101) << 32) | (((long) r103) & BodyPartID.bodyIdMax));
        if (r111 == false) goto L27;
        int r112 = getPlaceablesCount();
        int r104 = 0;
    L15:
        if (r104 >= r112) goto L31;
        LazyLayoutItemAnimation r105 = this.animator.getAnimation(getKey(), r104);
        if (r105 == null) goto L26;
        long r106 = r105.m888getRawOffsetnOccac();
        if (isVertical() == false) goto L21;
        int r107 = IntOffset.m7676getXimpl(r106);
    L22:
        boolean r108 = isVertical();
        int r109 = IntOffset.m7677getYimpl(r106);
        if (r108 == false) goto L25;
        r109 = Integer.valueOf(r109 + r110).intValue();
    L25:
        long r113 = ((long) r109) & BodyPartID.bodyIdMax;
        r105.m891setRawOffsetgyyYBs(IntOffset.m7670constructorimpl(r113 | (((long) r107) << 32)));
        goto L26
    L21:
        r107 = Integer.valueOf(IntOffset.m7676getXimpl(r106) + r110).intValue();
    L26:
        r104 = r104 + 1;
        goto L15
    L31:
        return;
    L27:
        return;
    L8:
        r101 = IntOffset.m7676getXimpl(r100) + r110;
        goto L9
    }

    public final void place(Placeable.PlacementScope r110, boolean r111) {
        int r100 = 0;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
    L8:
        int r102 = getPlaceablesCount();
    L9:
        if (r100 >= r102) goto L54;
        Placeable r103 = (Placeable) ListProtector.get(this.placeables, r100);
        int r104 = this.minMainAxisOffset - getMainAxisSize(r103);
        int r105 = this.maxMainAxisOffset;
        long r106 = mo861getOffsetnOccac();
        LazyLayoutItemAnimation r107 = this.animator.getAnimation(getKey(), r100);
        if (r107 == null) goto L29;
        if (r111 == false) goto L15;
        r107.m890setLookaheadOffsetgyyYBs(r106);
    L28:
        GraphicsLayer r108 = r107.getLayer();
    L31:
        if (this.reverseLayout == true) goto L33;
    L41:
        long r109 = IntOffset.m7680plusqkQi6aY(r106, this.visualOffset);
        if (r111 == true) goto L46;
        if (r107 == null) goto L46;
        r107.m889setFinalOffsetgyyYBs(r109);
    L46:
        if (isVertical() == false) goto L50;
        if (r108 == null) goto L49;
        Placeable.PlacementScope.m6332placeWithLayeraW9wM$default(r110, r103, r109, r108, 0.0f, 4, null);
    L53:
        r100 = r100 + 1;
        goto L9
    L49:
        Placeable.PlacementScope.m6331placeWithLayeraW9wM$default(r110, r103, r109, 0.0f, null, 6, null);
        goto L53
    L50:
        if (r108 == null) goto L52;
        Placeable.PlacementScope.m6330placeRelativeWithLayeraW9wM$default(r110, r103, r109, r108, 0.0f, 4, null);
        goto L53
    L52:
        Placeable.PlacementScope.m6329placeRelativeWithLayeraW9wM$default(r110, r103, r109, 0.0f, null, 6, null);
        goto L53
    L33:
        if (isVertical() == false) goto L35;
        int r112 = IntOffset.m7676getXimpl(r106);
    L37:
        if (isVertical() == false) goto L39;
        int r113 = IntOffset.m7677getYimpl(r106);
        int r114 = (this.mainAxisLayoutSize - r113) - getMainAxisSize(r103);
    L40:
        long r115 = ((long) r114) & BodyPartID.bodyIdMax;
        r106 = IntOffset.m7670constructorimpl(r115 | (((long) r112) << 32));
        goto L41
    L39:
        r114 = IntOffset.m7677getYimpl(r106);
        goto L40
    L35:
        int r116 = IntOffset.m7676getXimpl(r106);
        r112 = (this.mainAxisLayoutSize - r116) - getMainAxisSize(r103);
        goto L37
    L15:
        if (IntOffset.m7675equalsimpl0(r107.m886getLookaheadOffsetnOccac(), LazyLayoutItemAnimation.Companion.m892getNotInitializednOccac()) == true) goto L17;
        long r117 = r107.m886getLookaheadOffsetnOccac();
    L18:
        long r118 = IntOffset.m7680plusqkQi6aY(r117, r107.m887getPlacementDeltanOccac());
        if (m867getMainAxisgyyYBs(r106) > r104) goto L23;
        if (m867getMainAxisgyyYBs(r118) > r104) goto L23;
    L26:
        r107.cancelPlacementAnimation();
    L27:
        r106 = r118;
    L23:
        if (m867getMainAxisgyyYBs(r106) < r105) goto L27;
        if (m867getMainAxisgyyYBs(r118) < r105) goto L27;
    L17:
        r117 = r106;
        goto L18
    L29:
        r108 = null;
        goto L31
    L54:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int r100, int r101, int r110, int r111) {
        position(r100, r101, r110, r111, -1, -1);
    }

    public final void position(int r100, int r101, int r102, int r103, int r104, int r110) {
        if (isVertical() == false) goto L5;
        int r105 = r103;
    L6:
        this.mainAxisLayoutSize = r105;
        if (isVertical() == true) goto L11;
        r102 = r103;
    L11:
        if (isVertical() == false) goto L16;
        if (this.layoutDirection != LayoutDirection.Rtl) goto L16;
        r101 = (r102 - r101) - this.crossAxisSize;
    L16:
        if (isVertical() == false) goto L18;
        long r106 = IntOffset.m7670constructorimpl((((long) r101) << 32) | (BodyPartID.bodyIdMax & ((long) r100)));
    L19:
        this.offset = r106;
        this.row = r104;
        this.column = r110;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
        return;
    L18:
        long r107 = ((long) r100) << 32;
        r106 = IntOffset.m7670constructorimpl((((long) r101) & BodyPartID.bodyIdMax) | r107);
        goto L19
    L5:
        r105 = r102;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyGridMeasuredItem(int r100, Object r110, boolean r111, int r112, int r113, boolean r114, LayoutDirection r115, int r116, int r117, List<? extends Placeable> r118, long r119, Object r210, LazyLayoutItemAnimator<LazyGridMeasuredItem> r211, long r212, int r213, int r214) {
        this.index = r100;
        this.key = r110;
        this.isVertical = r111;
        this.crossAxisSize = r112;
        this.reverseLayout = r114;
        this.layoutDirection = r115;
        this.beforeContentPadding = r116;
        this.afterContentPadding = r117;
        this.placeables = r118;
        this.visualOffset = r119;
        this.contentType = r210;
        this.animator = r211;
        this.constraints = r212;
        this.lane = r213;
        this.span = r214;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int r101 = r118.size();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L9;
        Placeable r104 = (Placeable) ListProtector.get(r118, r102);
        if (isVertical() == false) goto L7;
        int r105 = r104.getHeight();
    L8:
        r103 = Math.max(r103, r105);
        r102 = r102 + 1;
        goto L3
    L7:
        r105 = r104.getWidth();
        goto L8
    L9:
        this.mainAxisSize = r103;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(r103 + r113, 0);
        if (isVertical() == false) goto L12;
        long r106 = ((long) this.crossAxisSize) << 32;
        long r107 = IntSize.m7714constructorimpl((((long) r103) & BodyPartID.bodyIdMax) | r106);
    L13:
        this.size = r107;
        this.offset = IntOffset.Companion.m7687getZeronOccac();
        this.row = -1;
        this.column = -1;
        return;
    L12:
        long r108 = ((long) this.crossAxisSize) & BodyPartID.bodyIdMax;
        r107 = IntSize.m7714constructorimpl(r108 | (((long) r103) << 32));
        goto L13
    }
}
