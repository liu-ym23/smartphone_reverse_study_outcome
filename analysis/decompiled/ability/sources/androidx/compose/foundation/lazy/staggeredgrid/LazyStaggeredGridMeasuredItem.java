package androidx.compose.foundation.lazy.staggeredgrid;

import H4.o;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bu\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J/\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010(J\u001d\u0010-\u001a\u00020!2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020!2\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020!2\u0006\u00101\u001a\u00020\u0003¢\u0006\u0004\b2\u00100J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J+\u0010:\u001a\u00020\u001a*\u00020\u001a2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000306H\u0082\bø\u0001\u0001¢\u0006\u0004\b8\u00109R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010AR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010B\u001a\u0004\b\u000b\u0010CR\u001a\u0010\r\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010;\u001a\u0004\bD\u0010=R\u001a\u0010\u000e\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010;\u001a\u0004\bE\u0010=R\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010;R\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010;R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010>\u001a\u0004\bF\u0010@R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010GR \u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0015\u0010H\u001a\u0004\bI\u0010JR\"\u0010K\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010B\u001a\u0004\bK\u0010C\"\u0004\bL\u0010MR\u0017\u0010N\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bN\u0010;\u001a\u0004\bO\u0010=R\u001a\u0010P\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bP\u0010;\u001a\u0004\bQ\u0010=R\u0017\u0010R\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bR\u0010;\u001a\u0004\bS\u0010=R\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010;R\u0016\u0010T\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010;R\u0016\u0010U\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010;R\"\u0010V\u001a\u00020\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bV\u0010B\u001a\u0004\bW\u0010C\"\u0004\bX\u0010MR \u0010Z\u001a\u00020Y8\u0016X\u0096\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\bZ\u0010H\u001a\u0004\b[\u0010JR*\u0010]\u001a\u00020\u001a2\u0006\u0010\\\u001a\u00020\u001a8\u0016@RX\u0096\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b]\u0010H\u001a\u0004\b^\u0010JR\u0014\u0010`\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010=R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\ba\u0010=R\u0018\u0010\u001e\u001a\u00020\u0003*\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0019\u0010N\u001a\u00020\u0003*\u00020\b8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010d\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006e"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "index", "", "key", "", "Landroidx/compose/ui/layout/Placeable;", "placeables", "", "isVertical", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "animator", "Landroidx/compose/ui/unit/Constraints;", "constraints", AppAgent.CONSTRUCT, "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/e;)V", "getParentData", "(I)Ljava/lang/Object;", "Landroidx/compose/ui/unit/IntOffset;", "getOffset-Bjo55l4", "(I)J", "getOffset", "mainAxis", "crossAxis", "mainAxisLayoutSize", "LC7/r;", "position", "(III)V", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "(IIII)V", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "scope", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "context", "place", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;)V", "updateMainAxisLayoutSize", "(I)V", "delta", "applyScrollDelta", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function1;", "mainAxisMap", "copy-4Tuh3kE", "(JLS7/k;)J", "copy", "I", "getIndex", "()I", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "Ljava/util/List;", "Z", "()Z", "getLane", "getSpan", "getContentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "J", "getConstraints-msEJaDk", "()J", "isVisible", "setVisible", "(Z)V", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "minMainAxisOffset", "maxMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "<set-?>", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset-nOcc-ac", "getPlaceablesCount", "placeablesCount", "getMainAxisOffset", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int span;

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int i, Object obj, List list, boolean z10, int i6, int i10, int i11, int i12, int i13, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j5, e eVar) {
        this(i, obj, list, z10, i6, i10, i11, i12, i13, obj2, lazyLayoutItemAnimator, j5);
    }

    /* renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m918copy4Tuh3kE(long j5, k kVar) {
        return IntOffsetKt.IntOffset(getIsVertical() ? IntOffset.m6972getXimpl(j5) : ((Number) kVar.invoke(Integer.valueOf(IntOffset.m6972getXimpl(j5)))).intValue(), getIsVertical() ? ((Number) kVar.invoke(Integer.valueOf(IntOffset.m6973getYimpl(j5)))).intValue() : IntOffset.m6973getYimpl(j5));
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m919getMainAxisgyyYBs(long j5) {
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

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getConstraints-msEJaDk, reason: from getter */
    public long getConstraints() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    public final int getMainAxisOffset() {
        return !getIsVertical() ? IntOffset.m6972getXimpl(getOffset()) : IntOffset.m6973getYimpl(getOffset());
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

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
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

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
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

    /* renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final void place(Placeable.PlacementScope scope, LazyStaggeredGridMeasureContext context) {
        GraphicsLayer layer;
        Placeable.PlacementScope placementScope;
        int iM6972getXimpl;
        int iM6973getYimpl;
        if (this.mainAxisLayoutSize == -1) {
            throw new IllegalArgumentException("position() should be called first");
        }
        List<Placeable> list = this.placeables;
        int size = list.size();
        int i = 0;
        while (i < size) {
            Placeable placeable = list.get(i);
            int height = this.minMainAxisOffset - (getIsVertical() ? placeable.getHeight() : placeable.getWidth());
            int i6 = this.maxMainAxisOffset;
            long offset = getOffset();
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                long jM6976plusqkQi6aY = IntOffset.m6976plusqkQi6aY(offset, animation.m859getPlacementDeltanOccac());
                if ((m919getMainAxisgyyYBs(offset) <= height && m919getMainAxisgyyYBs(jM6976plusqkQi6aY) <= height) || (m919getMainAxisgyyYBs(offset) >= i6 && m919getMainAxisgyyYBs(jM6976plusqkQi6aY) >= i6)) {
                    animation.cancelPlacementAnimation();
                }
                layer = animation.getLayer();
                offset = jM6976plusqkQi6aY;
            } else {
                layer = null;
            }
            if (context.getReverseLayout()) {
                if (getIsVertical()) {
                    iM6972getXimpl = IntOffset.m6972getXimpl(offset);
                } else {
                    iM6972getXimpl = (this.mainAxisLayoutSize - IntOffset.m6972getXimpl(offset)) - (getIsVertical() ? placeable.getHeight() : placeable.getWidth());
                }
                if (getIsVertical()) {
                    iM6973getYimpl = (this.mainAxisLayoutSize - IntOffset.m6973getYimpl(offset)) - (getIsVertical() ? placeable.getHeight() : placeable.getWidth());
                } else {
                    iM6973getYimpl = IntOffset.m6973getYimpl(offset);
                }
                offset = IntOffsetKt.IntOffset(iM6972getXimpl, iM6973getYimpl);
            }
            long jM6976plusqkQi6aY2 = IntOffset.m6976plusqkQi6aY(offset, context.getContentOffset());
            if (animation != null) {
                animation.m861setFinalOffsetgyyYBs(jM6976plusqkQi6aY2);
            }
            if (layer != null) {
                placementScope = scope;
                Placeable.PlacementScope.m5620placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM6976plusqkQi6aY2, layer, 0.0f, 4, (Object) null);
            } else {
                placementScope = scope;
                Placeable.PlacementScope.m5619placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM6976plusqkQi6aY2, 0.0f, (k) null, 6, (Object) null);
            }
            i++;
            scope = placementScope;
        }
    }

    public final void position(int mainAxis, int crossAxis, int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
        this.offset = getIsVertical() ? IntOffsetKt.IntOffset(crossAxis, mainAxis) : IntOffsetKt.IntOffset(mainAxis, crossAxis);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z10) {
        this.nonScrollableItem = z10;
    }

    public final void setVisible(boolean z10) {
        this.isVisible = z10;
    }

    public String toString() {
        return super.toString();
    }

    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyStaggeredGridMeasuredItem(int i, Object obj, List<? extends Placeable> list, boolean z10, int i6, int i10, int i11, int i12, int i13, Object obj2, LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> lazyLayoutItemAnimator, long j5) {
        Integer numValueOf;
        this.index = i;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z10;
        this.lane = i10;
        this.span = i11;
        this.beforeContentPadding = i12;
        this.afterContentPadding = i13;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j5;
        int i14 = 1;
        this.isVisible = true;
        Integer num = null;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            Placeable placeable = (Placeable) list.get(0);
            numValueOf = Integer.valueOf(getIsVertical() ? placeable.getHeight() : placeable.getWidth());
            int iH = o.H(list);
            if (1 <= iH) {
                int i15 = 1;
                while (true) {
                    Placeable placeable2 = (Placeable) list.get(i15);
                    Integer numValueOf2 = Integer.valueOf(getIsVertical() ? placeable2.getHeight() : placeable2.getWidth());
                    numValueOf = numValueOf2.compareTo(numValueOf) > 0 ? numValueOf2 : numValueOf;
                    if (i15 == iH) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
        this.mainAxisSize = iIntValue;
        int i16 = iIntValue + i6;
        this.mainAxisSizeWithSpacings = i16 < 0 ? 0 : i16;
        List<Placeable> list2 = this.placeables;
        if (!list2.isEmpty()) {
            Placeable placeable3 = list2.get(0);
            Integer numValueOf3 = Integer.valueOf(getIsVertical() ? placeable3.getWidth() : placeable3.getHeight());
            int iH2 = o.H(list2);
            if (1 <= iH2) {
                while (true) {
                    Placeable placeable4 = list2.get(i14);
                    Integer numValueOf4 = Integer.valueOf(getIsVertical() ? placeable4.getWidth() : placeable4.getHeight());
                    numValueOf3 = numValueOf4.compareTo(numValueOf3) > 0 ? numValueOf4 : numValueOf3;
                    if (i14 == iH2) {
                        break;
                    } else {
                        i14++;
                    }
                }
            }
            num = numValueOf3;
        }
        int iIntValue2 = num != null ? num.intValue() : 0;
        this.crossAxisSize = iIntValue2;
        this.mainAxisLayoutSize = -1;
        this.size = getIsVertical() ? IntSizeKt.IntSize(iIntValue2, this.mainAxisSize) : IntSizeKt.IntSize(this.mainAxisSize, iIntValue2);
        this.offset = IntOffset.INSTANCE.m6983getZeronOccac();
    }

    private final int getMainAxisSize(Placeable placeable) {
        return getIsVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        if (getIsVertical()) {
            layoutWidth = layoutHeight;
        }
        position(mainAxisOffset, crossAxisOffset, layoutWidth);
    }
}
