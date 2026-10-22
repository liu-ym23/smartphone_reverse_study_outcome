package androidx.compose.foundation.lazy.grid;

import S7.k;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0095\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\"\u001a\u00020\u0013*\u00020\u00132\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001eH\u0082\bø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J/\u0010-\u001a\u00020,2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010.J=\u0010-\u001a\u00020,2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003¢\u0006\u0004\b-\u00101J\u0015\u00103\u001a\u00020,2\u0006\u00102\u001a\u00020\u0003¢\u0006\u0004\b3\u00104J\u0015\u00106\u001a\u00020,2\u0006\u00105\u001a\u00020\u0003¢\u0006\u0004\b6\u00104J\u0015\u00109\u001a\u00020,2\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010A\u001a\u0004\b\b\u0010BR\u0017\u0010\t\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010;\u001a\u0004\bC\u0010=R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010AR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010DR\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010;R\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010;R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010ER\u001a\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0014\u0010FR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010>\u001a\u0004\bG\u0010@R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010HR \u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0019\u0010F\u001a\u0004\bI\u0010JR\u001a\u0010\u001a\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010;\u001a\u0004\bK\u0010=R\u001a\u0010\u001b\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010;\u001a\u0004\bL\u0010=R\u0017\u0010M\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bM\u0010;\u001a\u0004\bN\u0010=R\u001a\u0010O\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bO\u0010;\u001a\u0004\bP\u0010=R\u0016\u00102\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010;R\u0016\u0010Q\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010;R\u0016\u0010R\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010;R \u0010T\u001a\u00020S8\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bT\u0010F\u001a\u0004\bU\u0010JR*\u0010W\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u00138\u0016@RX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bW\u0010F\u001a\u0004\bX\u0010JR$\u0010/\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b/\u0010;\u001a\u0004\bY\u0010=R$\u00100\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b0\u0010;\u001a\u0004\bZ\u0010=R\"\u0010[\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b[\u0010A\u001a\u0004\b\\\u0010B\"\u0004\b]\u0010^R\u0018\u0010a\u001a\u00020\u0003*\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0018\u0010M\u001a\u00020\u0003*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010bR\u0014\u0010d\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010=\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "index", "", "key", "", "isVertical", "crossAxisSize", "mainAxisSpacing", "reverseLayout", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "beforeContentPadding", "afterContentPadding", "", "Landroidx/compose/ui/layout/Placeable;", "placeables", "Landroidx/compose/ui/unit/IntOffset;", "visualOffset", "contentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "animator", "Landroidx/compose/ui/unit/Constraints;", "constraints", "lane", "span", AppAgent.CONSTRUCT, "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JIILkotlin/jvm/internal/e;)V", "Lkotlin/Function1;", "mainAxisMap", "copy-4Tuh3kE", "(JLS7/k;)J", "copy", "getParentData", "(I)Ljava/lang/Object;", "getOffset-Bjo55l4", "(I)J", "getOffset", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "LC7/r;", "position", "(IIII)V", "row", "column", "(IIIIII)V", "mainAxisLayoutSize", "updateMainAxisLayoutSize", "(I)V", "delta", "applyScrollDelta", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "scope", "place", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)V", "I", "getIndex", "()I", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "Z", "()Z", "getCrossAxisSize", "Landroidx/compose/ui/unit/LayoutDirection;", "Ljava/util/List;", "J", "getContentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "getConstraints-msEJaDk", "()J", "getLane", "getSpan", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "minMainAxisOffset", "maxMainAxisOffset", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "<set-?>", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset-nOcc-ac", "getRow", "getColumn", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "getMainAxis--gyyYBs", "(J)I", "mainAxis", "(Landroidx/compose/ui/layout/Placeable;)I", "getPlaceablesCount", "placeablesCount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
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

    public /* synthetic */ LazyGridMeasuredItem(int i, Object obj, boolean z10, int i6, int i10, boolean z11, LayoutDirection layoutDirection, int i11, int i12, List list, long j5, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j6, int i13, int i14, e eVar) {
        this(i, obj, z10, i6, i10, z11, layoutDirection, i11, i12, list, j5, obj2, lazyLayoutItemAnimator, j6, i13, i14);
    }

    /* renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m842copy4Tuh3kE(long j5, k kVar) {
        return IntOffsetKt.IntOffset(getIsVertical() ? IntOffset.m6972getXimpl(j5) : ((Number) kVar.invoke(Integer.valueOf(IntOffset.m6972getXimpl(j5)))).intValue(), getIsVertical() ? ((Number) kVar.invoke(Integer.valueOf(IntOffset.m6973getYimpl(j5)))).intValue() : IntOffset.m6973getYimpl(j5));
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m843getMainAxisgyyYBs(long j5) {
        return getIsVertical() ? IntOffset.m6973getYimpl(j5) : IntOffset.m6972getXimpl(j5);
    }

    public final void applyScrollDelta(int delta) {
        if (getNonScrollableItem()) {
            return;
        }
        long offset = getOffset();
        int iM6972getXimpl = getIsVertical() ? IntOffset.m6972getXimpl(offset) : IntOffset.m6972getXimpl(offset) + delta;
        boolean isVertical = getIsVertical();
        int iM6973getYimpl = IntOffset.m6973getYimpl(offset);
        if (isVertical) {
            iM6973getYimpl += delta;
        }
        this.offset = IntOffsetKt.IntOffset(iM6972getXimpl, iM6973getYimpl);
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                long rawOffset = animation.getRawOffset();
                int iM6972getXimpl2 = getIsVertical() ? IntOffset.m6972getXimpl(rawOffset) : Integer.valueOf(IntOffset.m6972getXimpl(rawOffset) + delta).intValue();
                boolean isVertical2 = getIsVertical();
                int iM6973getYimpl2 = IntOffset.m6973getYimpl(rawOffset);
                if (isVertical2) {
                    iM6973getYimpl2 += delta;
                }
                animation.m863setRawOffsetgyyYBs(IntOffsetKt.IntOffset(iM6972getXimpl2, iM6973getYimpl2));
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getConstraints-msEJaDk, reason: from getter */
    public long getConstraints() {
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

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getOffset-Bjo55l4 */
    public long mo812getOffsetBjo55l4(int index) {
        return getOffset();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* renamed from: getOffset-nOcc-ac, reason: from getter */
    public long getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* renamed from: getSize-YbymL2g, reason: from getter */
    public long getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: isVertical, reason: from getter */
    public boolean getIsVertical() {
        return this.isVertical;
    }

    public final void place(Placeable.PlacementScope scope) {
        GraphicsLayer layer;
        Placeable.PlacementScope placementScope;
        int iM6972getXimpl;
        int iM6973getYimpl;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int placeablesCount = getPlaceablesCount();
        int i = 0;
        while (i < placeablesCount) {
            Placeable placeable = this.placeables.get(i);
            int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
            int i6 = this.maxMainAxisOffset;
            long offset = getOffset();
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                long jM6976plusqkQi6aY = IntOffset.m6976plusqkQi6aY(offset, animation.m859getPlacementDeltanOccac());
                if ((m843getMainAxisgyyYBs(offset) <= mainAxisSize && m843getMainAxisgyyYBs(jM6976plusqkQi6aY) <= mainAxisSize) || (m843getMainAxisgyyYBs(offset) >= i6 && m843getMainAxisgyyYBs(jM6976plusqkQi6aY) >= i6)) {
                    animation.cancelPlacementAnimation();
                }
                layer = animation.getLayer();
                offset = jM6976plusqkQi6aY;
            } else {
                layer = null;
            }
            if (this.reverseLayout) {
                if (getIsVertical()) {
                    iM6972getXimpl = IntOffset.m6972getXimpl(offset);
                } else {
                    iM6972getXimpl = (this.mainAxisLayoutSize - IntOffset.m6972getXimpl(offset)) - getMainAxisSize(placeable);
                }
                if (getIsVertical()) {
                    iM6973getYimpl = (this.mainAxisLayoutSize - IntOffset.m6973getYimpl(offset)) - getMainAxisSize(placeable);
                } else {
                    iM6973getYimpl = IntOffset.m6973getYimpl(offset);
                }
                offset = IntOffsetKt.IntOffset(iM6972getXimpl, iM6973getYimpl);
            }
            long jM6976plusqkQi6aY2 = IntOffset.m6976plusqkQi6aY(offset, this.visualOffset);
            if (animation != null) {
                animation.m861setFinalOffsetgyyYBs(jM6976plusqkQi6aY2);
            }
            if (!getIsVertical()) {
                placementScope = scope;
                GraphicsLayer graphicsLayer = layer;
                if (graphicsLayer != null) {
                    Placeable.PlacementScope.m5620placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM6976plusqkQi6aY2, graphicsLayer, 0.0f, 4, (Object) null);
                } else {
                    Placeable.PlacementScope.m5619placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM6976plusqkQi6aY2, 0.0f, (k) null, 6, (Object) null);
                }
            } else if (layer != null) {
                placementScope = scope;
                Placeable.PlacementScope.m5622placeWithLayeraW9wM$default(placementScope, placeable, jM6976plusqkQi6aY2, layer, 0.0f, 4, (Object) null);
            } else {
                placementScope = scope;
                Placeable.PlacementScope.m5621placeWithLayeraW9wM$default(placementScope, placeable, jM6976plusqkQi6aY2, 0.0f, (k) null, 6, (Object) null);
            }
            i++;
            scope = placementScope;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        position(mainAxisOffset, crossAxisOffset, layoutWidth, layoutHeight, -1, -1);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z10) {
        this.nonScrollableItem = z10;
    }

    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyGridMeasuredItem(int i, Object obj, boolean z10, int i6, int i10, boolean z11, LayoutDirection layoutDirection, int i11, int i12, List<? extends Placeable> list, long j5, Object obj2, LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, long j6, int i13, int i14) {
        this.index = i;
        this.key = obj;
        this.isVertical = z10;
        this.crossAxisSize = i6;
        this.reverseLayout = z11;
        this.layoutDirection = layoutDirection;
        this.beforeContentPadding = i11;
        this.afterContentPadding = i12;
        this.placeables = list;
        this.visualOffset = j5;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j6;
        this.lane = i13;
        this.span = i14;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = list.size();
        int iMax = 0;
        for (int i15 = 0; i15 < size; i15++) {
            Placeable placeable = (Placeable) list.get(i15);
            iMax = Math.max(iMax, getIsVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.mainAxisSize = iMax;
        int i16 = i10 + iMax;
        this.mainAxisSizeWithSpacings = i16 >= 0 ? i16 : 0;
        this.size = getIsVertical() ? IntSizeKt.IntSize(this.crossAxisSize, iMax) : IntSizeKt.IntSize(iMax, this.crossAxisSize);
        this.offset = IntOffset.INSTANCE.m6983getZeronOccac();
        this.row = -1;
        this.column = -1;
    }

    private final int getMainAxisSize(Placeable placeable) {
        return getIsVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    public final void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight, int row, int column) {
        this.mainAxisLayoutSize = getIsVertical() ? layoutHeight : layoutWidth;
        if (!getIsVertical()) {
            layoutWidth = layoutHeight;
        }
        if (getIsVertical() && this.layoutDirection == LayoutDirection.Rtl) {
            crossAxisOffset = (layoutWidth - crossAxisOffset) - this.crossAxisSize;
        }
        this.offset = getIsVertical() ? IntOffsetKt.IntOffset(crossAxisOffset, mainAxisOffset) : IntOffsetKt.IntOffset(mainAxisOffset, crossAxisOffset);
        this.row = row;
        this.column = column;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }
}
