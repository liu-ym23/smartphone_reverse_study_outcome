package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0091\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010@\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J(\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0016J\u001e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004J\u000e\u0010G\u001a\u00020B2\u0006\u00109\u001a\u00020\u0004J\u0017\u0010*\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\bH\u0010IJ\u0016\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\tJ\u0016\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\tJ(\u0010W\u001a\u00020\u0015*\u00020\u00152\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040YH\u0082\b¢\u0006\u0004\bZ\u0010[R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010!R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010'R\u001e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0014\u0010+\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0014\u0010-\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0014\u0010/\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0014\u00101\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0011\u00103\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u001a\u00105\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010!\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010 R\u0018\u0010Q\u001a\u00020\u0004*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0018\u0010T\u001a\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010V¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "()Z", "J", "getKey", "()Ljava/lang/Object;", "getContentType", "getConstraints-msEJaDk", "()J", "value", "offset", "getOffset", "size", "getSize", "lane", "getLane", "span", "getSpan", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "getParentData", "position", "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "updateMainAxisLayoutSize", "getOffset-Bjo55l4", "(I)J", "applyScrollDelta", "delta", "updateAnimations", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public /* synthetic */ LazyListMeasuredItem(int r100, List r101, boolean r102, Alignment.Horizontal r103, Alignment.Vertical r104, LayoutDirection r105, boolean r106, int r107, int r108, int r110, long r111, Object r112, Object r113, LazyLayoutItemAnimator r114, long r115, DefaultConstructorMarker r116) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public long mo840getConstraintsmsEJaDk() {
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

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean isVertical() {
        return this.isVertical;
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m839getMainAxisgyyYBs(long r100) {
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
    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public long mo841getOffsetBjo55l4(int r100) {
        if (r100 == 0) goto L5;
    L11:
        int[] r101 = this.placeableOffsets;
        int r102 = r100 * 2;
        int r103 = r101[r102];
        int r104 = r101[r102 + 1];
        long r105 = ((long) r103) << 32;
        return IntOffset.m7670constructorimpl((BodyPartID.bodyIdMax & ((long) r104)) | r105);
    L5:
        if (getPlaceablesCount() != 0) goto L11;
        if (isVertical() == false) goto L9;
        long r106 = BodyPartID.bodyIdMax & ((long) getOffset());
        long r107 = r106 | (((long) 0) << 32);
    L13:
        return IntOffset.m7670constructorimpl(r107);
    L9:
        long r108 = ((long) getOffset()) << 32;
        r107 = (BodyPartID.bodyIdMax & ((long) 0)) | r108;
        goto L13
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
    private final long m838copy4Tuh3kE(long r100, Function1<? super Integer, Integer> r101) {
        if (isVertical() == false) goto L5;
        int r102 = IntOffset.m7676getXimpl(r100);
        int r103 = r101.invoke(Integer.valueOf(IntOffset.m7677getYimpl(r100))).intValue();
        long r104 = r102;
    L7:
        return IntOffset.m7670constructorimpl((r104 << 32) | (((long) r103) & BodyPartID.bodyIdMax));
    L5:
        int r105 = r101.invoke(Integer.valueOf(IntOffset.m7676getXimpl(r100))).intValue();
        r103 = IntOffset.m7677getYimpl(r100);
        r104 = r105;
        goto L7
    }

    public final void applyScrollDelta(int r110, boolean r111) {
        if (getNonScrollableItem() == false) goto L5;
        return;
    L5:
        this.offset = getOffset() + r110;
        int r100 = this.placeableOffsets.length;
        int r101 = 0;
        int r102 = 0;
    L6:
        if (r102 >= r100) goto L15;
        int r103 = r102 & 1;
        if (isVertical() == false) goto L11;
        if (r103 == 0) goto L11;
    L13:
        int[] r104 = this.placeableOffsets;
        r104[r102] = r104[r102] + r110;
    L14:
        r102 = r102 + 1;
    L11:
        if (isVertical() == true) goto L14;
        if (r103 != 0) goto L14;
    L15:
        if (r111 == false) goto L26;
        int r112 = getPlaceablesCount();
    L17:
        if (r101 >= r112) goto L34;
        LazyLayoutItemAnimation r105 = this.animator.getAnimation(getKey(), r101);
        if (r105 == null) goto L25;
        long r106 = r105.m888getRawOffsetnOccac();
        if (isVertical() == false) goto L23;
        int r107 = IntOffset.m7676getXimpl(r106);
        int r108 = Integer.valueOf(IntOffset.m7677getYimpl(r106) + r110).intValue();
    L24:
        r105.m891setRawOffsetgyyYBs(IntOffset.m7670constructorimpl((((long) r107) << 32) | (BodyPartID.bodyIdMax & ((long) r108))));
        goto L25
    L23:
        r107 = Integer.valueOf(IntOffset.m7676getXimpl(r106) + r110).intValue();
        r108 = IntOffset.m7677getYimpl(r106);
    L25:
        r101 = r101 + 1;
        goto L17
    L34:
        return;
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
        if (r100 >= r102) goto L49;
        Placeable r103 = (Placeable) ListProtector.get(this.placeables, r100);
        int r104 = this.minMainAxisOffset - getMainAxisSize(r103);
        int r105 = this.maxMainAxisOffset;
        long r106 = mo841getOffsetBjo55l4(r100);
        LazyLayoutItemAnimation r107 = this.animator.getAnimation(getKey(), r100);
        if (r107 == null) goto L28;
        if (r111 == false) goto L15;
        r107.m890setLookaheadOffsetgyyYBs(r106);
    L27:
        GraphicsLayer r108 = r107.getLayer();
    L30:
        if (this.reverseLayout == true) goto L32;
    L36:
        long r109 = IntOffset.m7680plusqkQi6aY(r106, this.visualOffset);
        if (r111 == true) goto L41;
        if (r107 == null) goto L41;
        r107.m889setFinalOffsetgyyYBs(r109);
    L41:
        if (isVertical() == false) goto L45;
        if (r108 == null) goto L44;
        Placeable.PlacementScope.m6332placeWithLayeraW9wM$default(r110, r103, r109, r108, 0.0f, 4, null);
    L48:
        r100 = r100 + 1;
        goto L9
    L44:
        Placeable.PlacementScope.m6331placeWithLayeraW9wM$default(r110, r103, r109, 0.0f, null, 6, null);
        goto L48
    L45:
        if (r108 == null) goto L47;
        Placeable.PlacementScope.m6330placeRelativeWithLayeraW9wM$default(r110, r103, r109, r108, 0.0f, 4, null);
        goto L48
    L47:
        Placeable.PlacementScope.m6329placeRelativeWithLayeraW9wM$default(r110, r103, r109, 0.0f, null, 6, null);
        goto L48
    L32:
        if (isVertical() == false) goto L34;
        int r112 = IntOffset.m7676getXimpl(r106);
        int r113 = IntOffset.m7677getYimpl(r106);
        long r114 = ((long) ((this.mainAxisLayoutSize - r113) - getMainAxisSize(r103))) & BodyPartID.bodyIdMax;
        long r115 = r114 | (((long) r112) << 32);
    L35:
        r106 = IntOffset.m7670constructorimpl(r115);
        goto L36
    L34:
        int r116 = IntOffset.m7676getXimpl(r106);
        int r117 = (this.mainAxisLayoutSize - r116) - getMainAxisSize(r103);
        int r118 = IntOffset.m7677getYimpl(r106);
        r115 = (((long) r117) << 32) | (BodyPartID.bodyIdMax & ((long) r118));
        goto L35
    L15:
        if (IntOffset.m7675equalsimpl0(r107.m886getLookaheadOffsetnOccac(), LazyLayoutItemAnimation.Companion.m892getNotInitializednOccac()) == true) goto L17;
        r106 = r107.m886getLookaheadOffsetnOccac();
    L17:
        long r119 = IntOffset.m7680plusqkQi6aY(r106, r107.m887getPlacementDeltanOccac());
        if (m839getMainAxisgyyYBs(r106) > r104) goto L22;
        if (m839getMainAxisgyyYBs(r119) > r104) goto L22;
    L25:
        r107.cancelPlacementAnimation();
    L26:
        r106 = r119;
    L22:
        if (m839getMainAxisgyyYBs(r106) < r105) goto L26;
        if (m839getMainAxisgyyYBs(r119) < r105) goto L26;
    L28:
        r108 = null;
        goto L30
    L49:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void position(int r110, int r111, int r112) {
        this.offset = r110;
        if (isVertical() == false) goto L5;
        int r100 = r112;
    L6:
        this.mainAxisLayoutSize = r100;
        List<Placeable> r101 = this.placeables;
        int r102 = r101.size();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L21;
        Placeable r104 = (Placeable) ListProtector.get(r101, r103);
        int r105 = r103 * 2;
        if (isVertical() == false) goto L15;
        int[] r106 = this.placeableOffsets;
        Alignment.Horizontal r107 = this.horizontalAlignment;
        if (r107 == null) goto L13;
        r106[r105] = r107.align(r104.getWidth(), r111, this.layoutDirection);
        this.placeableOffsets[r105 + 1] = r110;
        int r108 = r104.getHeight();
    L18:
        r110 = r110 + r108;
        r103 = r103 + 1;
        goto L7
    L13:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == true");
        throw new KotlinNothingValueException();
    L15:
        int[] r109 = this.placeableOffsets;
        r109[r105] = r110;
        int r113 = r105 + 1;
        Alignment.Vertical r114 = this.verticalAlignment;
        if (r114 == null) goto L19;
        r109[r113] = r114.align(r104.getHeight(), r112);
        r108 = r104.getWidth();
        goto L18
    L19:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalAlignment when isVertical == false");
        throw new KotlinNothingValueException();
    L21:
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
        return;
    L5:
        r100 = r111;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int r100, int r101, int r102, int r103) {
        position(r100, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyListMeasuredItem(int r110, List<? extends Placeable> r111, boolean r112, Alignment.Horizontal r113, Alignment.Vertical r114, LayoutDirection r115, boolean r116, int r117, int r118, int r119, long r210, Object r211, Object r212, LazyLayoutItemAnimator<LazyListMeasuredItem> r213, long r214) {
        this.index = r110;
        this.placeables = r111;
        this.isVertical = r112;
        this.horizontalAlignment = r113;
        this.verticalAlignment = r114;
        this.layoutDirection = r115;
        this.reverseLayout = r116;
        this.beforeContentPadding = r117;
        this.afterContentPadding = r118;
        this.spacing = r119;
        this.visualOffset = r210;
        this.key = r211;
        this.contentType = r212;
        this.animator = r213;
        this.constraints = r214;
        this.span = 1;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int r100 = r111.size();
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r101 >= r100) goto L13;
        Placeable r104 = (Placeable) ListProtector.get(r111, r101);
        if (isVertical() == false) goto L7;
        int r105 = r104.getHeight();
    L8:
        r102 = r102 + r105;
        if (isVertical() == true) goto L11;
        int r106 = r104.getHeight();
    L12:
        r103 = Math.max(r103, r106);
        r101 = r101 + 1;
        goto L3
    L11:
        r106 = r104.getWidth();
        goto L12
    L7:
        r105 = r104.getWidth();
        goto L8
    L13:
        this.size = r102;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = r103;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }
}
