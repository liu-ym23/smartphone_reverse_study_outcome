package androidx.compose.foundation.lazy;

import S7.k;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0093\u0001\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010#\u001a\u00020\u0014*\u00020\u00142\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001fH\u0082\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010%J/\u0010+\u001a\u00020*2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010,J%\u0010+\u001a\u00020*2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003¢\u0006\u0004\b+\u0010-J\u0015\u0010/\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0003¢\u0006\u0004\b/\u00100J\u001d\u00103\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001d\u00106\u001a\u00020*2\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\b¢\u0006\u0004\b6\u00107J\u001d\u0010;\u001a\u00020*2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\b¢\u0006\u0004\b;\u0010<R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010@R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010A\u001a\u0004\b\t\u0010BR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010CR\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010DR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010ER\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010AR\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010=R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010=R\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010=R\u001a\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0015\u0010FR\u001a\u0010\u0017\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010G\u001a\u0004\bJ\u0010IR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010KR \u0010\u001c\u001a\u00020\u001b8\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u0010F\u001a\u0004\bL\u0010MR$\u0010O\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bO\u0010=\u001a\u0004\b3\u0010?R\u001a\u0010P\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bP\u0010=\u001a\u0004\bQ\u0010?R\u001a\u0010R\u001a\u00020\u00038\u0016X\u0096D¢\u0006\f\n\u0004\bR\u0010=\u001a\u0004\bS\u0010?R\u001a\u0010T\u001a\u00020\u00038\u0016X\u0096D¢\u0006\f\n\u0004\bT\u0010=\u001a\u0004\bU\u0010?R\u001a\u0010V\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bV\u0010=\u001a\u0004\bW\u0010?R\u0017\u0010X\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bX\u0010=\u001a\u0004\bY\u0010?R\"\u0010Z\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bZ\u0010A\u001a\u0004\b[\u0010B\"\u0004\b\\\u0010]R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010=R\u0016\u0010^\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010=R\u0016\u0010_\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010=R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010e\u001a\u00020\u0003*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0018\u0010h\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bi\u0010?\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006k"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "index", "", "Landroidx/compose/ui/layout/Placeable;", "placeables", "", "isVertical", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "Landroidx/compose/ui/unit/IntOffset;", "visualOffset", "", "key", "contentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "animator", "Landroidx/compose/ui/unit/Constraints;", "constraints", AppAgent.CONSTRUCT, "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/e;)V", "Lkotlin/Function1;", "mainAxisMap", "copy-4Tuh3kE", "(JLS7/k;)J", "copy", "getParentData", "(I)Ljava/lang/Object;", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "LC7/r;", "position", "(IIII)V", "(III)V", "mainAxisLayoutSize", "updateMainAxisLayoutSize", "(I)V", "getOffset-Bjo55l4", "(I)J", "getOffset", "delta", "updateAnimations", "applyScrollDelta", "(IZ)V", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "scope", "isLookingAhead", "place", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Z)V", "I", "getIndex", "()I", "Ljava/util/List;", "Z", "()Z", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "Landroidx/compose/ui/unit/LayoutDirection;", "J", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "getContentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "getConstraints-msEJaDk", "()J", "<set-?>", TypedValues.CycleType.S_WAVE_OFFSET, "size", "getSize", "lane", "getLane", "span", "getSpan", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "minMainAxisOffset", "maxMainAxisOffset", "", "placeableOffsets", "[I", "getMainAxis--gyyYBs", "(J)I", "mainAxis", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "mainAxisSize", "getPlaceablesCount", "placeablesCount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListMeasuredItem implements LazyListItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyListMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int spacing;
    private final int span;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    @ExperimentalFoundationApi
    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z10, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z11, int i6, int i10, int i11, long j5, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j6, e eVar) {
        this(i, list, z10, horizontal, vertical, layoutDirection, z11, i6, i10, i11, j5, obj, obj2, lazyLayoutItemAnimator, j6);
    }

    /* renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m809copy4Tuh3kE(long j5, k kVar) {
        return IntOffsetKt.IntOffset(getIsVertical() ? IntOffset.m6972getXimpl(j5) : ((Number) kVar.invoke(Integer.valueOf(IntOffset.m6972getXimpl(j5)))).intValue(), getIsVertical() ? ((Number) kVar.invoke(Integer.valueOf(IntOffset.m6973getYimpl(j5)))).intValue() : IntOffset.m6973getYimpl(j5));
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m810getMainAxisgyyYBs(long j5) {
        return getIsVertical() ? IntOffset.m6973getYimpl(j5) : IntOffset.m6972getXimpl(j5);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return getIsVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    public final void applyScrollDelta(int delta, boolean updateAnimations) {
        if (getNonScrollableItem()) {
            return;
        }
        this.offset = getOffset() + delta;
        int length = this.placeableOffsets.length;
        for (int i = 0; i < length; i++) {
            if ((getIsVertical() && i % 2 == 1) || (!getIsVertical() && i % 2 == 0)) {
                int[] iArr = this.placeableOffsets;
                iArr[i] = iArr[i] + delta;
            }
        }
        if (updateAnimations) {
            int placeablesCount = getPlaceablesCount();
            for (int i6 = 0; i6 < placeablesCount; i6++) {
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i6);
                if (animation != null) {
                    long rawOffset = animation.getRawOffset();
                    int iM6972getXimpl = getIsVertical() ? IntOffset.m6972getXimpl(rawOffset) : Integer.valueOf(IntOffset.m6972getXimpl(rawOffset) + delta).intValue();
                    boolean isVertical = getIsVertical();
                    int iM6973getYimpl = IntOffset.m6973getYimpl(rawOffset);
                    if (isVertical) {
                        iM6973getYimpl += delta;
                    }
                    animation.m863setRawOffsetgyyYBs(IntOffsetKt.IntOffset(iM6972getXimpl, iM6973getYimpl));
                }
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getConstraints-msEJaDk, reason: not valid java name and from getter */
    public long getConstraints() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public long mo812getOffsetBjo55l4(int index) {
        int[] iArr = this.placeableOffsets;
        int i = index * 2;
        return IntOffsetKt.IntOffset(iArr[i], iArr[i + 1]);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
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

    public final void place(Placeable.PlacementScope scope, boolean isLookingAhead) {
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
            long jMo812getOffsetBjo55l4 = mo812getOffsetBjo55l4(i);
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                if (isLookingAhead) {
                    animation.m862setLookaheadOffsetgyyYBs(jMo812getOffsetBjo55l4);
                } else {
                    if (!IntOffset.m6971equalsimpl0(animation.getLookaheadOffset(), LazyLayoutItemAnimation.INSTANCE.m865getNotInitializednOccac())) {
                        jMo812getOffsetBjo55l4 = animation.getLookaheadOffset();
                    }
                    long jM6976plusqkQi6aY = IntOffset.m6976plusqkQi6aY(jMo812getOffsetBjo55l4, animation.m859getPlacementDeltanOccac());
                    if ((m810getMainAxisgyyYBs(jMo812getOffsetBjo55l4) <= mainAxisSize && m810getMainAxisgyyYBs(jM6976plusqkQi6aY) <= mainAxisSize) || (m810getMainAxisgyyYBs(jMo812getOffsetBjo55l4) >= i6 && m810getMainAxisgyyYBs(jM6976plusqkQi6aY) >= i6)) {
                        animation.cancelPlacementAnimation();
                    }
                    jMo812getOffsetBjo55l4 = jM6976plusqkQi6aY;
                }
                layer = animation.getLayer();
            } else {
                layer = null;
            }
            if (this.reverseLayout) {
                if (getIsVertical()) {
                    iM6972getXimpl = IntOffset.m6972getXimpl(jMo812getOffsetBjo55l4);
                } else {
                    iM6972getXimpl = (this.mainAxisLayoutSize - IntOffset.m6972getXimpl(jMo812getOffsetBjo55l4)) - getMainAxisSize(placeable);
                }
                if (getIsVertical()) {
                    iM6973getYimpl = (this.mainAxisLayoutSize - IntOffset.m6973getYimpl(jMo812getOffsetBjo55l4)) - getMainAxisSize(placeable);
                } else {
                    iM6973getYimpl = IntOffset.m6973getYimpl(jMo812getOffsetBjo55l4);
                }
                jMo812getOffsetBjo55l4 = IntOffsetKt.IntOffset(iM6972getXimpl, iM6973getYimpl);
            }
            long jM6976plusqkQi6aY2 = IntOffset.m6976plusqkQi6aY(jMo812getOffsetBjo55l4, this.visualOffset);
            if (!isLookingAhead && animation != null) {
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
        position(mainAxisOffset, layoutWidth, layoutHeight);
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
    private LazyListMeasuredItem(int i, List<? extends Placeable> list, boolean z10, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z11, int i6, int i10, int i11, long j5, Object obj, Object obj2, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, long j6) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z10;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z11;
        this.beforeContentPadding = i6;
        this.afterContentPadding = i10;
        this.spacing = i11;
        this.visualOffset = j5;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j6;
        this.span = 1;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = list.size();
        int height = 0;
        int iMax = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Placeable placeable = (Placeable) list.get(i12);
            height += getIsVertical() ? placeable.getHeight() : placeable.getWidth();
            iMax = Math.max(iMax, !getIsVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = height;
        int size2 = getSize() + this.spacing;
        this.mainAxisSizeWithSpacings = size2 >= 0 ? size2 : 0;
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    public final void position(int mainAxisOffset, int layoutWidth, int layoutHeight) {
        int width;
        this.offset = mainAxisOffset;
        this.mainAxisLayoutSize = getIsVertical() ? layoutHeight : layoutWidth;
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            int i6 = i * 2;
            if (getIsVertical()) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == true");
                }
                iArr[i6] = horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection);
                this.placeableOffsets[i6 + 1] = mainAxisOffset;
                width = placeable.getHeight();
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i6] = mainAxisOffset;
                int i10 = i6 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalAlignment when isVertical == false");
                }
                iArr2[i10] = vertical.align(placeable.getHeight(), layoutHeight);
                width = placeable.getWidth();
            }
            mainAxisOffset = width + mainAxisOffset;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }
}
